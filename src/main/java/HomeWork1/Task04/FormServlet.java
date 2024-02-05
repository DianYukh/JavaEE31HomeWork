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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));

        Person person = new Person(name, phone, email, age);
        PrintWriter writer=response.getWriter();
        writer.println();
        writer.println("<html>");
        writer.println("<head><title>Результат анкети</title></head>");
        writer.println("<body>");
        writer.println("<h2>Ваші дані:</h2>");
        writer.println("<p><b>ПІБ:</b> " + name + "</p>");
        writer.println("<p><b>Телефон:</b> " + phone + "</p>");
        writer.println("<p><b>Email:</b> " + email + "</p>");
        writer.println("<p><b>Вік:</b> " + age + "</p>");
        writer.println("</body>");
        writer.println("</html>");


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Home</h1>");

    }
}