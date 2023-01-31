package web.services;

import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User getUser(long id);

    List<User> getAll();


    void delete(long id);

    void update(User user);

}
