package net.invoker.restful.domain;

/**
 * @Author: invoker
 * @Date: 2020/8/8 下午1:20
 * @Description：实体类代码
 */
public class UserDO {
    private Integer userId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
