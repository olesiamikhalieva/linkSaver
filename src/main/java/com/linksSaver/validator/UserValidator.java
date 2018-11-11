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

    private static final String USERNAME_PATTERN =
            "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*";

    @Override
    public boolean supports(Class<?> aClass) {
        return UserInfo.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserInfo userInfo = (UserInfo) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (userInfo.getUsername().length() < 3 || userInfo.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(userInfo.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        if (userInfo.getUsername().matches(USERNAME_PATTERN)==false) {
            errors.rejectValue("username", "UserName.pattern");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (userInfo.getPassword().length() < 4 || userInfo.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!userInfo.getPasswordConfirm().equals(userInfo.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
