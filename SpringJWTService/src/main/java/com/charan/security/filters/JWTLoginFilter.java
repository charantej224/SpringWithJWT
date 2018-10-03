package com.charan.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import com.charan.security.services.TokenAuthenticationService;

public class JWTLoginFilter extends GenericFilterBean {

	@Autowired
	TokenAuthenticationService tokenService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("JWTAuthenticationFilter.doFilter");
		String token = tokenService.resolveToken((HttpServletRequest) request);
		boolean flag = tokenService.validateToken(token);
		if(!flag) {
			HttpServletResponse httpResponse = (HttpServletResponse) request;
			httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "you are done!!!");
		}
		chain.doFilter(request, response);

}

}