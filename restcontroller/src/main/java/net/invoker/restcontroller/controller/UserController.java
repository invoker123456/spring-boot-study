package net.invoker.restcontroller.controller;

import net.invoker.restcontroller.domain.UserDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: invoker
 * @Date: 2020/8/8 下午1:20
 * @Description：RESTful API 风格示例 对资源 user 进行操作
 * 本示例没有使用数据库，也没有使用 service 类来辅助完成，所有操作在本类中完成
 */
@Controller
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
     * GET  返回用户列表信息
     */
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String index(Model model) {
        List<UserDO> list = getData();
        model.addAttribute("list", list);//返回 用户 list
        return "user/index1.html";
    }
}
