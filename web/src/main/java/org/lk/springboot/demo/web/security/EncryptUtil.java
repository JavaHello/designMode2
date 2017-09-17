package org.lk.springboot.demo.web.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EncryptUtil {
   //从配置文件中获得  
   private static final String SITE_WIDE_SECRET = "STR";
   private static final PasswordEncoder encoder = new StandardPasswordEncoder(SITE_WIDE_SECRET);
  
   public static String encrypt(CharSequence rawPassword) {
        return encoder.encode(rawPassword);  
   }  
  
   public static boolean match(CharSequence rawPassword, String password) {
        return encoder.matches(rawPassword, password);  
   }

    public static void main(String[] args) {
        String encrypt = encrypt("121121");
        System.out.println(encrypt);
        System.out.println(match("121121", encrypt));
    }
}  