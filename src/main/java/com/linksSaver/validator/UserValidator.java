package com.linksSaver.validator;


import com.linksSaver.dao.entity.securityEntities.UserInfo;
import com.linksSaver.service.securityService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserInfo.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserInfo userInfo = (UserInfo) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "This field is required.");
        if (userInfo.getUsername().length() < 3 || userInfo.getUsername().length() > 32) {
            errors.rejectValue("username", "Please use between 4 and 32 characters.");
        }
        if (userService.findByUsername(userInfo.getUsername()) != null) {
            errors.rejectValue("username", "Someone already has that username.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "This field is required.");
        if (userInfo.getPassword().length() < 4 || userInfo.getPassword().length() > 32) {
            errors.rejectValue("password", "Try one with at least 4 characters.");
        }

        if (!userInfo.getPasswordConfirm().equals(userInfo.getPassword())) {
            errors.rejectValue("passwordConfirm", "These passwords don't match.");
        }
    }
}
