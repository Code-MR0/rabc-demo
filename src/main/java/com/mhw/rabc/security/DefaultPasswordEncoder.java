package com.mhw.rabc.security;

import com.mhw.rabc.util.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @className: DefaultPasswordEncoder
 * @description: DefaultPasswordEncoder
 * @author: mhw
 * @date: 2022-03-01
 * @version 1.0
 **/
@Component
public class DefaultPasswordEncoder implements PasswordEncoder {

    public DefaultPasswordEncoder() {
        this(-1);
    }

    public DefaultPasswordEncoder(int strength) {
    }

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
//        return MD5.encrypt(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        return encodedPassword.equals(charSequence.toString());
//        return encodedPassword.equals(MD5.encrypt(charSequence.toString()));
    }
}
