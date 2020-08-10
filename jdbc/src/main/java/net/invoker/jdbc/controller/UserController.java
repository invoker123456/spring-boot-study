package net.invoker.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: invoker
 * @Date: 2020/8/9 上午12:15
 * @Description：
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/users")
    public Object getUsers() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_user ");
        return list;
    }
}
