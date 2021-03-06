package org.andrew.malapura.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;


public class SetCharacterEncodingFilter implements Filter {
	
	protected Logger logger = Logger.getLogger(SetCharacterEncodingFilter.class);

	 protected String encoding = null;

	 protected FilterConfig filterConfig = null;

	 protected boolean ignore = true;


	public void destroy() {
		this.encoding = null;
        this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

        // Conditionally select and set the character encoding to be used
        if (ignore || (request.getCharacterEncoding() == null)) {
            String encoding = selectEncoding(request);
            if (encoding != null) request.setCharacterEncoding(encoding);
        }
 
        // Pass control on to the next filter
        chain.doFilter(request, response);


	}

	public void init(FilterConfig filterConfig) throws ServletException {
		 this.filterConfig = filterConfig;
         this.encoding = filterConfig.getInitParameter("encoding");
         String value = filterConfig.getInitParameter("ignore");
         if (value == null)
             this.ignore = true;
         else if (value.equalsIgnoreCase("true"))
             this.ignore = true;
         else if (value.equalsIgnoreCase("yes"))
             this.ignore = true;
         else
             this.ignore = false;
         logger.info("Charset filter initialized encoding [" + this.encoding
                 + "]; ignoring client encoding [" + this.ignore + ":980214]");

	}
	
	 protected String selectEncoding(ServletRequest request) {
         return (this.encoding);
     }

}
