package net.invoker.mybatis.service.impl;

import net.invoker.mybatis.dao.UserDao;
import net.invoker.mybatis.domain.UserDO;
import net.invoker.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: invoker
 * @Date: 2020/8/9 上午11:52
 * @Description：服务层包括了接口+接口实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDO get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public List<UserDO> list(Map<String, Object> map) {
        return userDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userDao.count(map);
    }

    @Override
    public int save(UserDO user) {
        return userDao.save(user);
    }

    @Override
    public int update(UserDO user) {
        return userDao.update(user);
    }

    @Override
    public int remove(Integer id) {
        return userDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return userDao.batchRemove(ids);
    }
}
