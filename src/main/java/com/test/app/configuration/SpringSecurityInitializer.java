package com.test.app.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/* register the springSecurityFilter */

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer{

	
	
}


/*
    The equivalent of Spring Security in web.xml file :
    
	<filter>
		<filter-name>springSecurityFilterChain</filter-name>
		<filter-class>
				org.springframework.web.filter.DelegatingFilterProxy
        </filter-class>
	</filter>

	<filter-mapping>
		<filter-name>springSecurityFilterChain</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
*/