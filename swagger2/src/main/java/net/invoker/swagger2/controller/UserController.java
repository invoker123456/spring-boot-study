package net.invoker.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.invoker.swagger2.domain.UserDO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: invoker
 * @Date: 2020/8/8 下午1:20
 * @Description：RESTful API 风格示例 对资源 user 进行操作
 * 本示例没有使用数据库，也没有使用 service 类来辅助完成，所有操作在本类中完成
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "用户接口")
public class UserController {
    /**
     * 模拟一组数据
     */
    private List<UserDO> getData() {
        List<UserDO> list = new ArrayList<>();

        UserDO userDO = new UserDO();
        userDO.setUserId(1);
        userDO.setUserName("admin");
        list.add(userDO);

        userDO = new UserDO();
        userDO.setUserId(2);
        userDO.setUserName("heike");
        list.add(userDO);

        userDO = new UserDO();
        userDO.setUserId(3);
        userDO.setUserName("tom");
        list.add(userDO);

        userDO = new UserDO();
        userDO.setUserId(4);
        userDO.setUserName("mac");
        list.add(userDO);

        return list;
    }

    /**
     * SELECT 查询操作，返回一个JSON数组
     * 具有幂等性
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "获取用户全部信息", tags = "查询用户", notes = "注意这里没有分页")
    public Object getUsers() {
        List<UserDO> list = new ArrayList<>();
        list = getData();
        return list;
    }

    /**
     * SELECT 查询操作，返回一个新建的JSON对象
     * 具有幂等性
     */
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "获取指定ID用户信息", tags = "查询用户", notes = "注意这里的参数id")
    public Object getUser(@PathVariable("id") String id) {
        if (null == id) {
            return null;
        }
        List<UserDO> list = getData();
        UserDO userDO = null;
        for (UserDO user : list) {
            if (id.equals(user.getUserId().toString())) {
                userDO = user;
                break;
            }
        }
        return userDO;
    }

    /**
     * 新增一个用户对象
     * 非幂等
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "新增一个用户", tags = "操作用户", notes = "客户端提供用户实体Json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "UserDO")
    })
    public Object addUser(@RequestBody UserDO user) {
        List<UserDO> list = getData();
        list.add(user);//模拟向列表中增加数据
        return user;
    }

    /**
     * 编辑一个用户对象
     * 幂等性
     */
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value ="更新一个用户",tags = "操作用户",notes = "客户端提供用户实体Json")
    public Object editUser(@PathVariable("id") String id, @RequestBody UserDO user) {
        List<UserDO> list = getData();
        for (UserDO userDO1 : list) {
            if (id.equals(userDO1.getUserId().toString())) {
                userDO1 = user;
                break;
            }
        }
        return user;
    }

    /**
     * 删除一个用户对象
     * 幂等性
     */
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value ="删除用户",tags = "操作用户",notes = "客户端提供用户实体Json")
    public Object deleteUser(@PathVariable("id") String id) {
        List<UserDO> list = getData();
        UserDO userDO = null;
        for (UserDO user : list) {
            if (id.equals(user.getUserId().toString())) {
                //删除用户
                userDO = user;
                break;
            }
        }
        return userDO;//返回被删除的对象
    }
}
