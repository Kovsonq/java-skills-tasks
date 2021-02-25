package course.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TaskImplementation {
    private static final int NUMBER_OF_THREADS = 8;

    public static void main(String[] args) {

//        createTable();

//        increaseWithEightThreads();
//        increaseWithEightThreadsPessimistic();
//        countSumOfVal();
    }

    private static void createTable() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
//        create 40 insertions
            Session session = factory.getCurrentSession();
            for (int i = 0; i < 40; i++) {
                session = factory.getCurrentSession();
                session.beginTransaction();
                session.save(new Item());
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void increaseWithEightThreads() {
        CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_THREADS);
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        AtomicInteger count = new AtomicInteger();

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                final int u = i;
                threads[i] = new Thread(() -> {
                    log.info("Thread-{} started", u);
                    for (int j = 0; j < 200; j++) {
                        boolean updated = false;
                        Long randomRow = (long) (new Random().nextInt(40) + 1);
                        while (!updated) {
                            Session session = factory.getCurrentSession();
                            session.beginTransaction();
                            Item item = session.get(Item.class, randomRow);
//                            session.lock(item, LockModeType.OPTIMISTIC);
                            item.setVal(item.getVal() + 1);
                            uncheckableSleep(5);
                            try {
//                                if element doesn't exist, in this situation it is
//                                    session.save(item);
                                    session.getTransaction().commit();
                                    updated = true;
                                    count.getAndIncrement();
                            } catch (OptimisticLockException e) {
                                session.getTransaction().rollback();
                            }
                            if (session != null) {
                                session.close();
                            }
                        }
                    }
                    countDownLatch.countDown();
                });
                threads[i].start();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("END");
            log.info("{}", count);
        }
    }

    public static void increaseWithEightThreadsPessimistic() {
        CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_THREADS);
        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                final int u = i;
                threads[i] = new Thread(() -> {
                    log.info("Thread-{} started", u);
                    for (int j = 0; j < 200; j++) {
                        Session session = factory.getCurrentSession();
                        session.beginTransaction();
                        Long randomRow = (long) (new Random().nextInt(40) + 1);

                        Item item = session
                                .createQuery("FROM Item i WHERE i.id = :id", Item.class)
                                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                                .setParameter("id",randomRow)
                                .getSingleResult();

                        item.setVal(item.getVal() + 1);
                        uncheckableSleep(5);

                        try {
//                            if element doesn't exist, in this situation it is
//                            session.save(item);
                            session.getTransaction().commit();
                        } catch (OptimisticLockException e) {
                            session.getTransaction().rollback();
                        }
                        if (session != null) {
                            session.close();
                        }
                    }
                    countDownLatch.countDown();
                });
                threads[i].start();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("END");
        }
    }

    public static void uncheckableSleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void countSumOfVal() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Object o = session.createNativeQuery("SELECT SUM(val) FROM item;").getSingleResult();
            log.info("Sum of DB: {} ", o);
            if (session != null) {
                session.close();
            }
        }
    }
}
