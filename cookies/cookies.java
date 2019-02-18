//Servlet Cookies Methods
//Following is the list of useful methods which you can use while manipulating 
//cookies in servlet.

	
//public void setDomain(String pattern)
//This method sets the domain to which cookie applies, for example tutorialspoint.com.

//public String getDomain()
//This method gets the domain to which cookie applies, for example tutorialspoint.com.

	
//public void setMaxAge(int expiry)
//This method sets how much time (in seconds) should elapse before the cookie expires. If you don't set this, the cookie will last only for the current session.

	
//public int getMaxAge()
//This method returns the maximum age of the cookie, specified in seconds, By default, -1 indicating the cookie will persist until browser shutdown.

	
//public String getName()
//This method returns the name of the cookie. The name cannot be changed after creation.

	
//public void setValue(String newValue)
//This method sets the value associated with the cookie

	
//public String getValue()
//This method gets the value associated with the cookie.


//public void setPath(String uri)
//This method sets the path to which this cookie applies. If you don't specify a path, the cookie is returned for all URLs in the same directory as the current page as well as all subdirectories.

	
//public String getPath()
//This method gets the path to which this cookie applies.


//public void setSecure(boolean flag)
//This method sets the boolean value indicating whether the cookie should only be sent over encrypted (i.e. SSL) connections.

	
//public void setComment(String purpose)
//This method specifies a comment that describes a cookie's purpose. The comment is useful if the browser presents the cookie to the user.

	
//public String getComment()
//This method returns the comment describing the purpose of this cookie, or null if the cookie has no comment.


// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
// Extend HttpServlet class
public class HelloForm extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Create cookies for first and last names.      
      Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
      Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

      // Set expiry date after 24 Hrs for both the cookies.
      firstName.setMaxAge(60*60*24);
      lastName.setMaxAge(60*60*24);

      // Add both the cookies in the response header.
      response.addCookie( firstName );
      response.addCookie( lastName );

      // Set response content type
      response.setContentType("text/html");
 
      PrintWriter out = response.getWriter();
      String title = "Setting Cookies Example";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
            "<head>
               <title>" + title + "</title>
            </head>\n" +
            
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<ul>\n" +
                  "  <li><b>First Name</b>: "
                  + request.getParameter("first_name") + "\n" +
                  "  <li><b>Last Name</b>: "
                  + request.getParameter("last_name") + "\n" +
               "</ul>\n" +
            "</body>
         </html>"
      );
   }
}