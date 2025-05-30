package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static List<User> users = null;
    private final UserDao userDao = new UserDaoHibernateImpl(Util.getSessionFactory());

    @Override
    public void createUsersTable() {
        //Hibernate
        userDao.createUsersTable();

        //JDBC
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    @Override
    public void dropUsersTable() {
        //Hibernate
        userDao.dropUsersTable();

        //JDBC
        if (users != null) {
            users = null;
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        //Hibernate
        userDao.saveUser(name, lastName, age);

        //JDBC
         if (users != null) {
             users.add(new User(name, lastName, age));
         }
    }

    @Override
    public void removeUserById(long id) {
        //Hibernate
        userDao.removeUserById(id);

        //JDBC
        if (users != null) {
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getId() == id) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        //Hibernate
        //return userDao.getAllUsers();

        //JDBC
        if (users == null) {
            users = new ArrayList<>();
        } else {
            users = new ArrayList<>(users);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        //Hibernate
        userDao.cleanUsersTable();

        //JDBC
        if (users != null) {
            users.clear();
        }
    }
}
