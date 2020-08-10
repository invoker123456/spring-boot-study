package net.invoker.securityjwt.dto;

import java.io.Serializable;

/**
 * @Author: invoker
 * @Date: 2020/8/9 下午2:54
 * @Description：
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}