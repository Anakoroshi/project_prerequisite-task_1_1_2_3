package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.*;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // implement algorithm here
        UserServiceImpl userDao = new UserServiceImpl();
        try  {
            userDao.createUsersTable();

            userDao.saveUser("Konstantin", "Ten", (byte) 26);
            System.out.println("Пользователь с именем - Konstantin добавлен в базу данных");

            userDao.saveUser("Michael", "Alexandrine", (byte) 30);
            System.out.println("Пользователь с именем - Michael добавлен в базу данных");

            userDao.saveUser("Islam", "Badiev", (byte) 24);
            System.out.println("Пользователь с именем - Islam добавлен в базу данных");

            userDao.saveUser("Jay", "Bay", (byte) 23);
            System.out.println("Пользователь с именем - Jay добавлен в базу данных");

            for (User user : userDao.getAllUsers()) {
                System.out.println(user);
            }

            userDao.cleanUsersTable();
            userDao.dropUsersTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
