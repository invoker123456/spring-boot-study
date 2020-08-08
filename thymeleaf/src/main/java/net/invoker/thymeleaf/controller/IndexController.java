package net.invoker.thymeleaf.controller;

import net.invoker.thymeleaf.dto.UserDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: invoker
 * @Date: 2020/8/7 下午10:32
 * @Description：
 */
@RestController
public class IndexController {
    @RequestMapping("/sample")
    public String sample(Model model) {
        model.addAttribute("user", getUserDTOData());
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO("zhangsan", "男", new Date()));
        users.add(new UserDTO("wangjingjing", "女", new Date()));
        users.add(new UserDTO("limeimei", "女", new Date()));
        users.add(new UserDTO("lisi", "男", new Date()));
        model.addAttribute("users", users);
        return "/index/sample";
    }

    /**
     * 构造一个user对象
     */
    private UserDTO getUserDTOData() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("fishpro");
        userDTO.setSex("男");
        userDTO.setBirthday(new Date());
        return userDTO;
    }
}
