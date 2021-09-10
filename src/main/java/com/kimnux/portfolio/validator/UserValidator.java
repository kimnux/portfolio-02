package com.kimnux.portfolio.validator;

import com.kimnux.portfolio.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String regex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

        if(!Pattern.matches(regex, user.getUser_id())) {
            errors.rejectValue("user_id", "key", "이메일 형식이 아닙니다!!");
        }
        
        if(StringUtils.isEmpty(user.getUser_pwd()) || user.getUser_pwd().length() < 8 || user.getUser_pwd().length() > 20) {
            errors.rejectValue("user_pwd", "key", "비밀번호는 8~20자리 여야 합니다!!");
        }
    }
}
