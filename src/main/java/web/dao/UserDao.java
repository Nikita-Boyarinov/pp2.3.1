package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User getUser(long id);

    List<User> getAll();

    void delete(long id);

    void update(User user);
}
