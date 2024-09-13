package org.example.thi_ket_thuc_module_3.controller;

import org.example.thi_ket_thuc_module_3.model.TheMuonSach;
import org.example.thi_ket_thuc_module_3.service.ServiceTheMuonSach;
import org.example.thi_ket_thuc_module_3.service.ServiceTheMuonSachImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/sach-dang-muon")
public class ControllerTheMuonSach extends HttpServlet {
    private static final ServiceTheMuonSach SERVICE_THE_MUON_SACH = new ServiceTheMuonSachImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "traSach":
                    traSach(req, resp);
                    break;
                default:

                    List<TheMuonSach> danhSachTheMuonSach = SERVICE_THE_MUON_SACH.getAllTheMuonSach();
                    req.setAttribute("danhSachTheMuonSach", danhSachTheMuonSach);
                    req.getRequestDispatcher("/theMuonSach.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void traSach(HttpServletRequest req, HttpServletResponse resp) {
        String maMuonSach = req.getParameter("maMuonSach");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
