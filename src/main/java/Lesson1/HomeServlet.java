package Lesson1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{
        String name = request.getParameter("name");
        String email= request.getParameter("email");
        String comments= request.getParameter("comments");

        Teacher teacher = new Teacher(1,"Jack","Lucas");
        Student student = new Student(name, email, comments, teacher);

        PrintWriter writer=response.getWriter();
        writer.println("<table>");

        writer.println("<tr><td>Student name</td>");
        writer.println("<td>"+ student.getName() +"</td></tr>");

        writer.println("<tr><td>Student email: </td>");
        writer.println("<td>"+student.getEmail() +"</td></tr>");

        writer.println("<tr><td>Comments:</td>");
        writer.println("<td>"+ student.getComments() +"</td></tr>");

        writer.println("<tr><td>Teacher name:</td>");
        writer.println("<td>"+ student.getTeacher().getFirstName() +"</td></tr>");

        writer.println("<tr><td>Teacher lastname:</td>");
        writer.println("<td>"+ student.getTeacher().getLastName() +"</td></tr>");

        writer.println("</table>");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{
        PrintWriter out = response.getWriter();
        out.println("<h1>Home</h1>");
        out.println("<p>Paragraph</p>");
        out.println("<ul>");
        out.println("<li><a>Item1</a></li>");
        out.println("<li><a>Item2</a></li>");
        out.println("<li><a>Item3</a></li>");
        out.println("<ul>");
    }
}
