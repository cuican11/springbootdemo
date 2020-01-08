package com.hwgif.configure.security;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter extends AbstractAuthenticationProcessingFilter {

    @Value("${token.header}")
    private String tokenHeader;

    @Value("${token.name}")
    private String tokenName;

    public AuthTokenFilter(RequestMatcher matcher)
    {
        super(matcher);
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException
    {
        String authToken = request.getHeader(this.tokenHeader);
        if(StringUtils.isEmpty(authToken))
        {
            authToken = request.getParameter(this.tokenName);
        }
        logger.debug("start to check token:{} *************");
        if (authToken == null)
        {
            throw new AuthenticationCredentialsNotFoundException("Access Token is not provided");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authToken, null);
        return getAuthenticationManager().authenticate(authentication);

    }
}
