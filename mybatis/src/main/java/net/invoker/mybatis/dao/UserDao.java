package net.invoker.mybatis.dao;

import net.invoker.mybatis.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: invoker
 * @Date: 2020/8/9 上午11:54
 * @Description：数据库访问层
 */
@Mapper
public interface UserDao {
    /**
     * 对应节点 select id="get" resultType="net.invoker.mybatis.domain.UserDO"
     */
    UserDO get(Integer id);

    /**
     * 对应节点 select id="list" resultType="net.invoker.mybatis.domain.UserDO"
     */
    List<UserDO> list(Map<String, Object> map);

    /**
     * 对应节点 select id="count" resultType="int"
     */
    int count(Map<String, Object> map);

    /**
     * 对应节点 insert id="save" parameterType="net.invoker.mybatis.domain.UserDO" useGeneratedKeys="true" keyProperty="id"
     */
    int save(UserDO user);

    /**
     * 对应节点 update id="update" parameterType="net.invoker.mybatis.domain.UserDO"
     */
    int update(UserDO user);

    /**
     * 对应节点 delete id="remove"
     */
    int remove(Integer id);

    /**
     * 对应节点 delete id="batchRemove"
     */
    int batchRemove(Integer[] ids);
}
