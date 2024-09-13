package org.example.thi_ket_thuc_module_3.repository;

import org.example.thi_ket_thuc_module_3.model.Sach;

import java.sql.SQLException;
import java.util.List;

public interface RepositorySach {
    List<Sach> getAllSach() throws SQLException;

    Sach getSach(String maSach) throws SQLException;

    void updateSach(Sach sach) throws SQLException;
}
