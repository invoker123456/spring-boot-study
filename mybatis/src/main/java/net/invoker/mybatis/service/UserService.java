package net.invoker.mybatis.service;

import net.invoker.mybatis.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * @Author: invoker
 * @Date: 2020/8/9 上午11:51
 * @Description：服务层包括了接口+接口实现
 */
public interface UserService {
    UserDO get(Integer id);

    List<UserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserDO user);

    int update(UserDO user);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
