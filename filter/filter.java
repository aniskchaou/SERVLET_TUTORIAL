//Servlet Filters are Java classes that can be used in Servlet Programming for the 
//following purposes −

//To intercept requests from a client before they access a resource at back end.
//To manipulate responses from server before they are sent back to the client.


//Filters are deployed in the deployment descriptor file web.xml and then map to either
//servlet names or URL patterns in your application's deployment descriptor.

//When the web container starts up your web application, it creates an instance of each
//filter that you have declared in the deployment descriptor. The filters execute in the
//order that they are declared in the deployment descriptor.

//Servlet Filter Methods
//A filter is simply a Java class that implements the javax.servlet.Filter interface. 
//The javax.servlet.Filter interface defines three methods −

	
//public void doFilter (ServletRequest, ServletResponse, FilterChain)
//This method is called by the container each time a request/response pair is passed through the chain due to a client request for a resource at the end of the chain.
	
//public void init(FilterConfig filterConfig)
//This method is called by the web container to indicate to a filter that it is being placed into service.

//public void destroy()
//This method is called by the web container to indicate to a filter that it is being taken out of service.

//Servlet Filter − Example

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Implements Filter class
public class LogFilter implements Filter  {
   public void  init(FilterConfig config) throws ServletException {
      
      // Get init parameter 
      String testParam = config.getInitParameter("test-param"); 

      //Print the init parameter 
      System.out.println("Test Param: " + testParam); 
   }
   
   public void  doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws java.io.IOException, ServletException {

      // Get the IP address of client machine.
      String ipAddress = request.getRemoteAddr();

      // Log the IP address and current timestamp.
      System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());

      // Pass request back down the filter chain
      chain.doFilter(request,response);
   }

   public void destroy( ) {
      /* Called before the Filter instance is removed from service by the web container*/
   }
}


//Servlet Filter Mapping in Web.xml
//Filters are defined and then mapped to a URL or Servlet, in much the same way as 
//Servlet is defined and then mapped to a URL pattern. Create the following entry for
//filter tag in the deployment descriptor file web.xml

//<filter>
//   <filter-name>LogFilter</filter-name>
//   <filter-class>LogFilter</filter-class>
//   <init-param>
//      <param-name>test-param</param-name>
//      <param-value>Initialization Paramter</param-value>
//   </init-param>
//</filter>

//<filter-mapping>
//   <filter-name>LogFilter</filter-name>
//   <url-pattern>/*</url-pattern>
//</filter-mapping>

//The above filter would apply to all the servlets because we specified /* in our 
//configuration. You can specicy a particular servlet path if you want to apply filter
//on few servlets only.
