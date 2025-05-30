package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static List<User> users = null;

    public void createUsersTable() {
        if (users == null) {
            users = new ArrayList<>();
        }

    }

    public void dropUsersTable() {
        if (users != null) {
            users = null;
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        if (users != null) {
            users.add(new User(name, lastName, age));
        }
    }

    public void removeUserById(long id) {
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

    public List<User> getAllUsers() {
        if (users == null) {
            users = new ArrayList<>(users);
        } else {
            users = new ArrayList<>();
        }
        return users;
    }

    public void cleanUsersTable() {
        if (users != null) {
            users.clear();
        }
    }

}
