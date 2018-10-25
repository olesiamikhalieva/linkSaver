package com.linksSaver.service.securityService;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
