package com.uhbooba.userservice.constant;

public final class SECURITY_SET {

    public static final String[] PERMITALL_URL_PATTERNS = {

        // swagger
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/swagger-ui/index.html",

        // test db
        "/h2-console/**",

        // users
        "/users/**"

    };

    public static final String[] NEED_LOGIN_URL_PATTERNS = {

    };

    public static final String[] NEED_ADMIN_ROLE_URL_PATTERNS = {

    };

    private SECURITY_SET() {
    }
}
