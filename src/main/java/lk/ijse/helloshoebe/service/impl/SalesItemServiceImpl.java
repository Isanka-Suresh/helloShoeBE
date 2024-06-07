package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.SalesItemDTO;
import lk.ijse.helloshoebe.repo.SalesItemsRepo;
import lk.ijse.helloshoebe.service.SalesItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SalesItemServiceImpl implements SalesItemService {
    @Autowired
    private SalesItemsRepo salesItemsRepo;

    @Override
    public SalesItemDTO saveSalesItem(SalesItemDTO salesItemDTO) {
        return null;
    }

    @Override
    public void deleteSalesItem(String salesItemId) {

    }

    @Override
    public SalesItemDTO getSelectedSalesItem(String salesItemId) {
        return null;
    }

    @Override
    public List<SalesItemDTO> getAllSalesItems() {
        return null;
    }

    @Override
    public void updateSalesItem(String salesItemId, SalesItemDTO salesItemDTO) {

    }
}
