package ru.kirilltrezubov.springMVC.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kirilltrezubov.springMVC.dao.UserDao;
import ru.kirilltrezubov.springMVC.entity.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    public UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl(){}

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) throws Exception{
        if (user.getName().length() < 2) throw new Exception();
        userDao.save(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
