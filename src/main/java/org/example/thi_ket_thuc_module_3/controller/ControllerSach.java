package org.example.thi_ket_thuc_module_3.controller;

import org.example.thi_ket_thuc_module_3.model.HocSinh;
import org.example.thi_ket_thuc_module_3.model.Sach;
import org.example.thi_ket_thuc_module_3.model.TheMuonSach;
import org.example.thi_ket_thuc_module_3.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/sach")
public class ControllerSach extends HttpServlet {
    private static final ServiceSach SERVICE_SACH = new ServiceSachImpl();
    private static final ServiceHocSinh SERVICE_HOC_SINH = new ServiceHocSinhImpl();
    private static final ServiceTheMuonSach SERVICE_THE_MUON_SACH = new ServiceTheMuonSachImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "muonSach":
                    showFormMuonSach(req, resp);
                    break;
                default:
                    danhSachSach(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormMuonSach(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String maSach = req.getParameter("maSach");
        Sach sach = SERVICE_SACH.getSach(maSach);
        List<HocSinh> danhSachHocSinh = SERVICE_HOC_SINH.getAllHocSinh();
        req.setAttribute("danhSachHocSinh", danhSachHocSinh);
        req.setAttribute("sach", sach);
        req.getRequestDispatcher("/sach/muon_sach.jsp").forward(req, resp);
    }

    private void danhSachSach(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Sach> danhSachSach = SERVICE_SACH.getAllSach();
        req.setAttribute("danhSachSach", danhSachSach);
        req.getRequestDispatcher("/sach/danh_sach.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "muonSach":
                    muonSach(req, resp);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void muonSach(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String maMuonSach = req.getParameter("ma-muon-sach");
        String maSach = req.getParameter("ma-sach");
        Sach sach = SERVICE_SACH.getSach(maSach);
        sach.setSoLuong(sach.getSoLuong() - 1);
        String maHocSinh = req.getParameter("ma-hoc-sinh");
        LocalDate ngayMuon = LocalDate.parse(req.getParameter("ngay-muon"));
        LocalDate ngayTra = LocalDate.parse(req.getParameter("ngay-tra"));
        TheMuonSach theMuonSach = new TheMuonSach(maMuonSach, maSach, maHocSinh, 0, ngayMuon, ngayTra);
        SERVICE_THE_MUON_SACH.insertTheMuonSach(theMuonSach);
        SERVICE_SACH.updateSach(sach);
        resp.sendRedirect("/sach");
    }
}
