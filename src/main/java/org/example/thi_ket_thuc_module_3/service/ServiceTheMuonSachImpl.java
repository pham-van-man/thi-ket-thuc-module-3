package org.example.thi_ket_thuc_module_3.service;

import org.example.thi_ket_thuc_module_3.model.TheMuonSach;
import org.example.thi_ket_thuc_module_3.repository.RepositoryTheMuonSach;
import org.example.thi_ket_thuc_module_3.repository.RepositpryTheMuonSachImpl;

import java.sql.SQLException;
import java.util.List;

public class ServiceTheMuonSachImpl implements ServiceTheMuonSach {
    private static final RepositoryTheMuonSach REPOSITORY_THE_MUON_SACH = new RepositpryTheMuonSachImpl();

    @Override
    public void insertTheMuonSach(TheMuonSach theMuonSach) throws SQLException {
        REPOSITORY_THE_MUON_SACH.insertTheMuonSach(theMuonSach);
    }

    @Override
    public List<TheMuonSach> getAllTheMuonSach() throws SQLException {
        return REPOSITORY_THE_MUON_SACH.getAllTheMuonSach();
    }

}
