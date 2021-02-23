package course.reflection;

import course.reflection.annatations.Column;
import course.reflection.annatations.Table;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MainApp {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            connect();
//            insertExample();
//            resultSetExample();
//            updateExample();
//            deleteExample();
//            dropTableExample();
//            transactionalExample();

            createTableByAnnotatedClass(TableExample.class);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void createTableByAnnotatedClass(Class tableExample) throws SQLException {
        if (!tableExample.isAnnotationPresent(Table.class)){
            throw new RuntimeException("@Table missed");
        }

        Map<Class,String> columnType = new HashMap<>();
        columnType.put(int.class,"INTEGER");
        columnType.put(String.class, "TEXT");

        StringBuilder tableSql = new StringBuilder();
        tableSql.append("CREATE TABLE ");
        tableSql.append(((Table) tableExample.getAnnotation(Table.class)).name());

        tableSql.append(" (");
        Field[] fields = tableExample.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                tableSql.append(field.getName())
                        .append(" ")
                        .append(columnType.get(field.getType()))
                        .append(", ");
            }
        }
        tableSql.setLength(tableSql.length()-2);
        tableSql.append(");");

        log.info("String: {}", tableSql);

        statement.executeUpdate(tableSql.toString());

    }

    private static void transactionalExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setString(1,"Bob" + (i+1));
            preparedStatement.setObject(2,50);
            preparedStatement.executeUpdate();
        }
        connection.commit();
    }

    private static void dropTableExample() throws SQLException {
        statement.executeUpdate("Drop table students;");
    }

    private static void deleteExample() throws SQLException {
        statement.executeUpdate("DELETE from students;");
    }

    private static void updateExample() throws SQLException {
        statement.executeUpdate("INSERT INTO students (name, score) VALUES ('bob',2);");
    }

    private static void resultSetExample() throws SQLException {
        try (ResultSet resultSet = statement.executeQuery("SELECT * from students;");){
            while (resultSet.next()){
                log.info(resultSet.getInt("id") +
                        " " +resultSet.getString("name") +
                        " " + resultSet.getInt("score"));
            }
        }
    }

    public static void connect() throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) values (?,?);");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
