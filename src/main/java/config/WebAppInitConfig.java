package config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
		  AnnotationConfigWebApplicationContext servletApplicationContext = new AnnotationConfigWebApplicationContext();
		  servletApplicationContext.register(ServletAppContext.class);
		  
		  DispatcherServlet dispatcherServlet = new DispatcherServlet(servletApplicationContext);
		  ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		  
		  servlet.setLoadOnStartup(1);
		  servlet.addMapping("/");
		  
		  AnnotationConfigWebApplicationContext rootApplicationContext = new AnnotationConfigWebApplicationContext();
		  rootApplicationContext.register(rootApplicationContext.class);
		  
		  ContextLoaderListener listener = new ContextLoaderListener(rootApplicationContext);
		  servletContext.addListener(listener);
	
		  FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
	        filter.setInitParameter("encoding", "UTF-8");
	        filter.addMappingForServletNames(null, false, "dispatcher");
	
	}

}
