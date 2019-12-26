package com.hwgif.configure.security;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

    /**
     * 描述：自定义AuthenticationDetailsSource，将HttpServletRequest注入到HwgifWebAuthenticationDetails，使其能获取到请求中的验证码等其他信息
     *
     * @Author
     * @Date 2019/4/21 17:03
     * @Version V1.0
     **/
    @Component
    public class HwgifWebAuthenticationDetailsSource  implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
        @Override
        public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
            return new HwgifWebAuthenticationDetails(request);
        }
    }
