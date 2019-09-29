package com.zxl;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zxl16
 * @Date 2019/9/29.
 */
public class SocketPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
