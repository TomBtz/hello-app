package rg.wcs.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SimpleHelloServlet", urlPatterns = {"/hello-form", "/custom-hello"})
public class SimpleHelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        String timeUser = request.getParameter("time");
        String customMsg = "";
        PrintWriter writer = response.getWriter();

        //gestion du temps
        DateFormat sdf = new SimpleDateFormat("hh:mm");
        Date date=null;
        try {
            date = sdf.parse(timeUser);
            customMsg = getCustomMsgByHour(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // build HTML code
//        String htmlRespone = "<html>";
//        htmlRespone += "<h2>"+customMsg+" "+userName+ " " + userSurname + ". How are you ?</h2>";
//        htmlRespone += "</html>";
//        writer.println(htmlRespone);


        request.setAttribute("name", userName);
        request.setAttribute("familyName", userSurname);
        request.setAttribute("customMsg", customMsg);
        request.getRequestDispatcher("custom-hello.jsp").forward(request, response);
    }

    protected String getCustomMsgByHour (Date timeUser) {

        DateFormat sdf = new SimpleDateFormat("hh:mm");
        Date morningHours=null;
        Date afternoonHours=null;
        Date eveningHours=null;
        String msg ="Good Evening";
        try {
            morningHours = sdf.parse("06:00");
            afternoonHours = sdf.parse("11:59");
            eveningHours = sdf.parse("18:00");

            if(timeUser.before(eveningHours)){
                msg =  "Good afternoon";
            }

            if (timeUser.before(afternoonHours) && (morningHours.before(timeUser))) {
                msg =  "Good Morning";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    return msg;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);

        //PrintWriter out = response.getWriter(); out.print("Simple hello coucou!");



    }

}
