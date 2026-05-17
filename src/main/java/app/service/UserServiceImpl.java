package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao<User, Long> userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user){
        userDao.save(user);
    }

    public void update(User user){
        userDao.update(user);
    }

    public void delete(Long id){
        userDao.delete(id);
    }

    public User findById(Long id){
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
