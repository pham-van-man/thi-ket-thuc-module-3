package org.example.thi_ket_thuc_module_3.controller;

import org.example.thi_ket_thuc_module_3.model.HocSinh;
import org.example.thi_ket_thuc_module_3.service.ServiceHocSinh;
import org.example.thi_ket_thuc_module_3.service.ServiceHocSinhImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/hoc-sinh")
public class ControllerHocSinh extends HttpServlet {
    private static final ServiceHocSinh SERVICE_HOC_SINH = new ServiceHocSinhImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                default:
                    danhSachHocSinh(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void danhSachHocSinh(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<HocSinh> danhSachHocSinh = SERVICE_HOC_SINH.getAllHocSinh();
        req.setAttribute("danhSachHocSinh", danhSachHocSinh);
        req.getRequestDispatcher("/sach/muon_sach.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
