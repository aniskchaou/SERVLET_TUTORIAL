//Methods to Set HTTP Status Code
//The following methods can be used to set HTTP Status Code in your servlet program. 
//These methods are available with HttpServletResponse object.


//public void setStatus ( int statusCode )
//This method sets an arbitrary status code. The setStatus method takes 
//an int (the status code) as an argument. 
//If your response includes a special status code and a document, 
//be sure to call setStatus before actually returning any of the content with the 
//PrintWriter.

	
//public void sendRedirect(String url)
//This method generates a 302 response along with a Location header giving the URL of
// the new document

	
//public void sendError(int code, String message)
//This method sends a status code (usually 404) along with a short message that is
// automatically formatted inside an HTML document and sent to the client.

//HTTP Status Code Example
//Following is the example which would send a 407 error code to the client browser
// and browser would show you "Need authentication!!!" message.

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class showError extends HttpServlet {
 
   // Method to handle GET method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set error code and reason.
      response.sendError(407, "Need authentication!!!" );
   }
   
   // Method to handle POST method request.
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      doGet(request, response);
   }
}