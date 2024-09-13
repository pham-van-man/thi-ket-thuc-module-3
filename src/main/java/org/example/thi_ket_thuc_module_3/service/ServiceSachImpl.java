package org.example.thi_ket_thuc_module_3.service;

import org.example.thi_ket_thuc_module_3.model.Sach;
import org.example.thi_ket_thuc_module_3.repository.RepositorySach;
import org.example.thi_ket_thuc_module_3.repository.RepositorySachImpl;

import java.sql.SQLException;
import java.util.List;

public class ServiceSachImpl implements ServiceSach {
    private static final RepositorySach REPOSITORY_SACH = new RepositorySachImpl();

    @Override
    public List<Sach> getAllSach() throws SQLException {
        return REPOSITORY_SACH.getAllSach();
    }

    @Override
    public Sach getSach(String maSach) throws SQLException {
        return REPOSITORY_SACH.getSach(maSach);
    }

    @Override
    public void updateSach(Sach sach) throws SQLException {
        REPOSITORY_SACH.updateSach(sach);
    }
}
