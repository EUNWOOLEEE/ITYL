package org.scoula.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sports")
public class SportsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] sports = req.getParameterValues("sports");
        String sex = req.getParameter("sex");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");
        for (String str : sports)
            out.println("좋아하는 운동: " + str + "<br>");
        out.println("성별: " + sex + "<br>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String[] sports = req.getParameterValues("sports");
        String sex = req.getParameter("sex");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");
        for (String str : sports)
            out.println("좋아하는 운동: " + str + "<br>");
        out.println("성별: " + sex + "<br>");
        out.println("</body>");
        out.println("</html>");
    }
}
