package Lesson1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MultyplyTable extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        String number = request.getParameter("number");

        if (number.length() >= 3) {
            response.getWriter().println("<h2> The number is big</h2>");

        } else
        {
            boolean isDigit = true;
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                    isDigit = false;
                    break;
                }}
            int num;
            PrintWriter writer = response.getWriter();
            if (isDigit) {
                num = Integer.parseInt(number);
                for (int i = 1; i <= 10; i++) {
                    writer.print("<div><b>" + i + " *" + num + " = " + i * num + "</b></div>");
                }
                writer.println();
            } else {
                writer.println("<h2> The number is a not Digit</h2>");
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {


    }

}
