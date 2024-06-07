package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.SalesDTO;
import lk.ijse.helloshoebe.repo.SalesRepo;
import lk.ijse.helloshoebe.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepo salesRepo;

    @Override
    public SalesDTO saveSales(SalesDTO salesDTO) {
        return null;
    }

    @Override
    public void deleteSales(String salesId) {

    }

    @Override
    public SalesDTO getSelectedSales(String salesId) {
        return null;
    }

    @Override
    public List<SalesDTO> getAllSales() {
        return null;
    }

    @Override
    public void updateSales(String salesId, SalesDTO salesDTO) {

    }
}
