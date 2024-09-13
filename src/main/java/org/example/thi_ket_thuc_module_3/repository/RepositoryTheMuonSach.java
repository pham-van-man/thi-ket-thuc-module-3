package org.example.thi_ket_thuc_module_3.repository;

import org.example.thi_ket_thuc_module_3.model.TheMuonSach;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryTheMuonSach {
    void insertTheMuonSach(TheMuonSach theMuonSach) throws SQLException;

    List<TheMuonSach> getAllTheMuonSach() throws SQLException;

    TheMuonSach getTheMuonSach(String maMuonSach) throws SQLException;
}
