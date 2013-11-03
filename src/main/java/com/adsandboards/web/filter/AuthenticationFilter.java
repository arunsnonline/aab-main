package com.adsandboards.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adsandboards.web.model.User;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpresponse = (HttpServletResponse) servletResponse;

		// do this only when request is NOT for login.jsp

		if (httprequest.getRequestURI().indexOf("adminpanel") == -1) {

			HttpSession session = httprequest.getSession();
			User userInSession = (User) session.getAttribute("userInSession");

			if (userInSession == null) {
				httpresponse.sendRedirect(httprequest.getContextPath() + "/adminpanel");
				return;
			}
		}

		// proceed if user is authenticated
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
