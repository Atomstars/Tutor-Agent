package com.tutoragent.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static String email() { return SecurityContextHolder.getContext().getAuthentication().getName(); }
}
