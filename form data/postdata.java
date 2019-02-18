//POST Method Example Using Form
//Let us do little modification in the above servlet, so that it can handle GET as well 
//as POST methods. Below is HelloForm.java servlet program to handle input given by web
//browser using GET or POST methods.

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloForm extends HttpServlet {

   // Method to handle GET method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Using GET Method to Read Form Data";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<ul>\n" +
                  "  <li><b>First Name</b>: "
                  + request.getParameter("first_name") + "\n" +
                  "  <li><b>Last Name</b>: "
                  + request.getParameter("last_name") + "\n" +
               "</ul>\n" +
            "</body>"
         "</html>"
      );
   }

   // Method to handle POST method request.
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      doGet(request, response);
   }
}
//<html>
//   <body>
//      <form action = "HelloForm" method = "POST">
//         First Name: <input type = "text" name = "first_name">
//         <br />
//         Last Name: <input type = "text" name = "last_name" />
//         <input type = "submit" value = "Submit" />
//      </form>
//   </body>
//</html>

//Here is the actual output of the above form, Try to enter First and Last Name and
//then click submit button to see the result on your local machine where tomcat is 
//running.