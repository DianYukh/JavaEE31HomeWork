package HomeWork1.Task04;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Завдання 4:
//Створіть сервлет “Анкета”. Користувач вводить свої дані:
// ПІБ, телефон, email, вік. Сервлет відображає
//отриману інформацію.
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, NumberFormatException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String age = request.getParameter("age");

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Form Result </title></head>");
        writer.println("<body style='background-color: #76b852; color: #FFFFFFFF; font-family: Roboto'>");
        writer.println("<body>");
        try {
            Person person = new Person(name, phone, email, age);
            writer.println("<h2>Your profile:</h2>");
            writer.println("<p><b>Name, Lastname:</b> " + person.getName() + "</p>");
            writer.println("<p><b>Phone Number:</b> " + person.getPhone() + "</p>");
            writer.println("<p><b>Email:</b> " + person.getEmail() + "</p>");
            writer.println("<p><b>Age:</b> " + person.getAge() + "</p>");

        } catch (NumberFormatException e) {
            writer.println("<p style='color:red;'>Wrong age. Use digital.</p>");
        }

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}