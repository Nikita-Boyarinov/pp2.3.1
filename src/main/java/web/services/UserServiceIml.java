package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.entity.User;

import java.util.List;

@Service
public class UserServiceIml implements UserService {


    private final UserDao userDao;


    @Autowired
    public UserServiceIml(UserDao userDao) {

        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }


}
