package com.studentinfo.servlet;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ReportServlet extends HttpServlet {

    private Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        Map<String, Object> data = new HashMap<>();
        data.put("message", "Report working");

        out.print(gson.toJson(data));
    }
}
