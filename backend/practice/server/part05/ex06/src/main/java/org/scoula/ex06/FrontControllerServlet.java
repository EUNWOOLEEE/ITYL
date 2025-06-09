package org.scoula.ex06;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {
    public Map<String, Command> getMap;
    public Map<String, Command> postMap;

    @Override
    public void init() throws ServletException {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private String getCommandName(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest req) {
        String commandName = getCommandName(req);

        Command command;
        if (req.getMethod().equalsIgnoreCase("get"))
            command = getMap.get(commandName);
        else
            command = postMap.get(commandName);

        return command;
    }

    private void execute(Command cmd, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewName = cmd.execute(req, resp);
    }
}
