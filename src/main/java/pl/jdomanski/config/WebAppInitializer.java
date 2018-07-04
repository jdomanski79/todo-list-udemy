package pl.jdomanski.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {
    
    private final static String DISPATCHER_SERVLET_NAME = "dispatcher";
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        log.info("onStartup");        
        
        //create the spring application context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        
        context.register(WebConfig.class);
        
        // create the dispatcher servlet
        DispatcherServlet dispatcherSerlet = new DispatcherServlet(context);
        
        // register and configure the dispatcher servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherSerlet);
        
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
