//The HttpSession Object
//Apart from the above mentioned three ways, servlet provides HttpSession Interface 
//which provides a way to identify a user across more than one page request or visit
//to a Web site and to store information about that user.

//The servlet container uses this interface to create a session between an HTTP client 
//and an HTTP server. The session persists for a specified time period, across more than
//one connection or page request from the user.


	
//public Object getAttribute(String name)
//This method returns the object bound with the specified name in this session, or null if no object is bound under the name.

	
//public Enumeration getAttributeNames()
//This method returns an Enumeration of String objects containing the names of all the objects bound to this session.

	
//public long getCreationTime()
//This method returns the time when this session was created, measured in milliseconds since midnight January 1, 1970 GMT.

	
//public String getId()
//This method returns a string containing the unique identifier assigned to this session.

	
//public long getLastAccessedTime()
//This method returns the last accessed time of the session, in the format of milliseconds since midnight January 1, 1970 GMT

	
//public int getMaxInactiveInterval()
//This method returns the maximum time interval (seconds), that the servlet container will keep the session open between client accesses.

	
//public void invalidate()
//This method invalidates this session and unbinds any objects bound to it.

	
//public boolean isNew()
//This method returns true if the client does not yet know about the session or if the client chooses not to join the session.

	
//public void removeAttribute(String name)
//This method removes the object bound with the specified name from this session.

	
//public void setAttribute(String name, Object value)
//This method binds an object to this session, using the name specified.


//public void setMaxInactiveInterval(int interval)
//This method specifies the time, in seconds, between client requests before the 
//servlet container will invalidate this session.

//Session Tracking Example
//This example describes how to use the HttpSession object to find out the creation 
//time and the last-accessed time for a session. We would associate a new session with
//the request if one does not already exist.

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
// Extend HttpServlet class
public class SessionTrack extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      // Create a session object if it is already not  created.
      HttpSession session = request.getSession(true);
         
      // Get session creation time.
      Date createTime = new Date(session.getCreationTime());
         
      // Get last access time of this web page.
      Date lastAccessTime = new Date(session.getLastAccessedTime());

      String title = "Welcome Back to my website";
      Integer visitCount = new Integer(0);
      String visitCountKey = new String("visitCount");
      String userIDKey = new String("userID");
      String userID = new String("ABCD");

      // Check if this is new comer on your web page.
      if (session.isNew()) {
         title = "Welcome to my website";
         session.setAttribute(userIDKey, userID);
      } else {
         visitCount = (Integer)session.getAttribute(visitCountKey);
         visitCount = visitCount + 1;
         userID = (String)session.getAttribute(userIDKey);
      }
      session.setAttribute(visitCountKey,  visitCount);

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";

      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<h2 align = \"center\">Session Infomation</h2>\n" +
               "<table border = \"1\" align = \"center\">\n" +
                  
                  "<tr bgcolor = \"#949494\">\n" +
                     "  <th>Session info</th><th>value</th>
                  </tr>\n" +
                     
                  "<tr>\n" +
                     "  <td>id</td>\n" +
                     "  <td>" + session.getId() + "</td>
                  </tr>\n" +
                  
                  "<tr>\n" +
                     "  <td>Creation Time</td>\n" +
                     "  <td>" + createTime + "  </td>
                  </tr>\n" +
                  
                  "<tr>\n" +
                     "  <td>Time of Last Access</td>\n" +
                     "  <td>" + lastAccessTime + "  </td>
                  </tr>\n" +
                  
                  "<tr>\n" +
                     "  <td>User ID</td>\n" +
                     "  <td>" + userID + "  </td>
                  </tr>\n" +
                  
                  "<tr>\n" +
                     "  <td>Number of visits</td>\n" +
                     "  <td>" + visitCount + "</td>
                  </tr>\n" +
               "</table>\n" +
            "</body>
         </html>"
      );
   }
}