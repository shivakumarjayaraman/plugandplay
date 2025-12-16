package com.netgear.simplews;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrontController extends HttpServlet  {
    String dataUrl;

    public FrontController() throws Exception {
        dataUrl = "file:///";
        if (!App.dataDirectory.startsWith("/")) {
            dataUrl += System.getProperty("user.dir");
        }
        dataUrl += "/" + App.dataDirectory + "/";
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        String actionClass = request.getRequestURI();
        Pattern pattern = Pattern.compile("/([^/=?]*).*");
        Matcher matcher = pattern.matcher(actionClass);
        int code = 400;
        String status = "error";
        String message = "Invalid action";

        if (matcher.find()) {
            actionClass = matcher.group(1);
            response.setStatus(200);
            try {
                message = process(actionClass, request.getParameter("data"));
                status = "success";
                code = 200;
            } catch (Exception e) {
            }
        }
        sendResponse(response, 200, status, message);
    }

    private String process(String actionClass, String data) throws IOException {
        return "Please Implement Me";
    }

    private void sendResponse(HttpServletResponse response, int code, String status, String message) throws IOException {
        response.setStatus(code);
        response.getWriter().println(
          "{ \"status\": \"" + status + "\", \"message\": \"" + message + "\"}");
    }
}
