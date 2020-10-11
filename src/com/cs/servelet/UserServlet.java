package com.cs.servelet;

import com.cs.entity.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.PageSupport;

import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "UserServlet",urlPatterns = {"/userServlet"})
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm=request.getParameter("comm");
        String id=request.getParameter("id");
//        int ids=Integer.parseInt(id);

        UserServiceImpl usi = new UserServiceImpl();
        if(comm.equals("list")) {
            String pageNO = request.getParameter("indexno");
            if (pageNO == null || pageNO == "") {
                pageNO = "1";
            }
            int pno = Integer.parseInt(pageNO);
//            UserServiceImpl usi = new UserServiceImpl();
            PageSupport ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.findByCountUser());
                List<User> list = usi.findByPageUserInfo(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("lists", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 查看
        if(comm.equals("query")){
            int ids=Integer.parseInt(id);
            try {
                User lists= usi.findbycrrunt(ids);
                request.setAttribute("lists",lists);
                request.getRequestDispatcher("query.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(comm.equals("del")){
            int ids=Integer.parseInt(id);
            try {
                boolean i=usi.deletinfoid(ids);
                if (i=true){
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(comm.equals("update")){
            int ids=Integer.parseInt(id);
            try {
                User lists= (User) usi.findbycrrunt(ids);
                request.setAttribute("lists",lists);
                request.getRequestDispatcher("update.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (comm.equals(("add"))){

        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
