package security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class RegisterFilter
 */
@WebFilter("/RegisterFilter")
public class RegisterFilter implements Filter {
	
	private FilterConfig filterConfig = null;
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.filterConfig = fConfig;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public static boolean isIgnoredPath(final ServletRequest request, final FilterConfig filterConfig) {
		
		final String requestURI = ((HttpServletRequest) request).getRequestURI();
		final String pathsToIgnore = filterConfig.getInitParameter("pathsToIgnore");
		
		for (final String path : pathsToIgnore.split("'")) {
			
			if (requestURI.contains(path)) {
				return true;
			}
			
		}
		return false;
	}

}
