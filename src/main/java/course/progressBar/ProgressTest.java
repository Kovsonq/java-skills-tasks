package course.progressBar;

import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;

public class ProgressTest {
    public static void main(String[] args) throws InterruptedException {
//        try (ProgressBar pb = new ProgressBarBuilder()
//                .setInitialMax(10)
//                .setTaskName("Test")
//                .setConsumer(new DelegatingProgressBarConsumer(logger::error, 90))
//                .build()) {
//            for (int i = 0; i < 10; i++) {
//                pb.stepTo(i);
//                Thread.sleep(300);
//            }
//            pb.stepTo(10);
//            Thread.sleep(100);
//        }

        try (ProgressBar progressBar = new ProgressBarBuilder()
                .setStyle(ProgressBarStyle.ASCII)
                .setInitialMax(5)
                .setTaskName("nfs-val")
                .build()) {
            for (int i = 0; i < 10; i++) {
                progressBar.stepTo(i);
                progressBar.setExtraMessage("Step number: " + i);
                Thread.sleep(300);
            }
            progressBar.stepTo(10);
        }
        Thread.sleep(100);
    }
}
