package com.example.groveapp.depart.service.imp;

import com.example.groveapp.depart.dao.DepartRepository;
import com.example.groveapp.depart.entiry.GoveDepart;
import com.example.groveapp.depart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
class DepartServiceImp implements DepartService {
    @Autowired
    DepartRepository departDao;

    @Override
//    @Cacheable(value = "depart", key="")
    public List<GoveDepart> getAll() {

        List<GoveDepart> all = departDao.findAll();
        return all;
    }

    @Override
    public List<GoveDepart> saveAll(List<GoveDepart> departs) {
        List<GoveDepart> goveDeparts = departDao.saveAll(departs);
        return goveDeparts;
    }

    @Override
    public GoveDepart save(GoveDepart depart) {
        return departDao.save(depart);
    }

    @Override
    public GoveDepart findDepartByCode(String code) {
        GoveDepart departByCode = departDao.findGoveDepartByPart_code(code);
        return departByCode;
    }

}
