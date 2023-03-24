

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {



   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       String n=request.getParameter("name");
       String e=request.getParameter("email");
       String p=request.getParameter("pass");
       if(Login.validate(n,e,p)){
           RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
           rd.forward(request, response);
       }
       else{
           out.print("sorry username or password error");
           RequestDispatcher rd=request.getRequestDispatcher("index.html");
           rd.include(request,response);
       }
       out.close();
    }
}

   
   
