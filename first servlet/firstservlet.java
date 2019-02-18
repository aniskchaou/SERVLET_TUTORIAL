
//Servlets are Java classes which service HTTP requests and implement the 
//javax.servlet.Servlet interface. Web application developers typically write 
//servlets that extend javax.servlet.http.HttpServlet, an abstract class that 
//implements the Servlet interface and is specially designed to handle HTTP requests.



// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloWorld extends HttpServlet {
 
   private String message;

   public void init() throws ServletException {
      // Do required initialization
      message = "Hello World";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
   }

   public void destroy() {
      // do nothing.
   }
}


//Compiling a Servlet
//Let us create a file with name HelloWorld.java with the code shown above. 
//Place this file at C:\ServletDevel (in Windows) or at /usr/ServletDevel (in Unix).
//This path location must be added to CLASSPATH before proceeding further.

//Assuming your environment is setup properly, go in ServletDevel directory and compile
//HelloWorld.java as follows −

//$ javac HelloWorld.java


//Servlet Deployment
//By default, a servlet application is located at 
//the path <Tomcat-installationdirectory>/webapps/ROOT and the class file would 
//reside in <Tomcat-installationdirectory>/webapps/ROOT/WEB-INF/classes.

//If you have a fully qualified class name of com.myorg.MyServlet, then this servlet
//class must be located in WEB-INF/classes/com/myorg/MyServlet.class.

//For now, let us copy HelloWorld.class into 
//<Tomcat-installationdirectory>/webapps/ROOT/WEB-INF/classes and create following
//entries in web.xml file located in 
//<Tomcat-installation-directory>/webapps/ROOT/WEB-INF/

//<servlet>
//   <servlet-name>HelloWorld</servlet-name>
//   <servlet-class>HelloWorld</servlet-class>
//</servlet>

//<servlet-mapping>
//   <servlet-name>HelloWorld</servlet-name>
//   <url-pattern>/HelloWorld</url-pattern>
//</servlet-mapping>
//Above entries to be created inside <web-app>...</web-app> tags available in web.xml 
//file. 


