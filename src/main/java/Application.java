
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {

        // ЗАДАНИЕ 1
        System.out.println("Задание 1");

        final String user = "postgres";
        final String password = "Rere!090215Cz";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, 8);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = "Имя: " + resultSet.getString("first_name");
                String lastName = "Фамилия: " + resultSet.getString("last_name");
                String gender = "Пол: " + resultSet.getString("gender");
                int age = resultSet.getInt(5);
                long cityId = resultSet.getLong(6);

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println("Возраст: " + age);
                System.out.println("ID города: " + cityId);

            }
        }

        System.out.println();
        // ЗАДАНИЕ 2
        System.out.println("Задание 2");
        System.out.println();

        EmployeeDao employeeDao=new EmployeeDaoImpl();
        employeeDao.findAll().forEach(System.out::println);

        System.out.println();
        // Создание (добавление) объекта Employee в таблицу.
        employeeDao.add(new Employee(9,"Anton","Peston","man",55,new City((2),
                "Санкт-Петербург")));

        System.out.println();
        // Получение списка всех объектов Employee.
        employeeDao.findAll().forEach(System.out::println);

        System.out.println();
        // Получение конкретного объекта по id.
        System.out.println(employeeDao.readById(8));

        System.out.println();
        // Изменение конкретного объекта по id.
        employeeDao.updateEmployeeById(2,"Anna");
        employeeDao.findAll().forEach(System.out::println);

        System.out.println();
        // Удаление конкретного объекта по id.
        employeeDao.deleteById(0);
        employeeDao.findAll().forEach(System.out::println);



    }
}

