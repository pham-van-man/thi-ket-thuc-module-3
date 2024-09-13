package org.example.thi_ket_thuc_module_3.service;

import org.example.thi_ket_thuc_module_3.model.HocSinh;
import org.example.thi_ket_thuc_module_3.repository.RepositoryHocSinh;
import org.example.thi_ket_thuc_module_3.repository.RepositoryHocSinhImpl;

import java.util.List;

public class ServiceHocSinhImpl implements ServiceHocSinh {
    private static final RepositoryHocSinh REPOSITORY_HOC_SINH = new RepositoryHocSinhImpl();

    @Override
    public List<HocSinh> getAllHocSinh() throws Exception {
        return REPOSITORY_HOC_SINH.getAllHocSinh();
    }
}
