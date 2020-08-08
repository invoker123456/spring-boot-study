package net.invoker.thymeleaf.dto;

import java.util.Date;

/**
 * @Author: invoker
 * @Date: 2020/8/7 下午10:31
 * @Description：
 */
public class UserDTO {
    private String username;
    private String sex;
    private Date birthday;

    public UserDTO() {
    }

    public UserDTO(String username, String sex, Date birthday) {
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
