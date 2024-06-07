package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.RefundDTO;
import lk.ijse.helloshoebe.repo.RefundRepo;
import lk.ijse.helloshoebe.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RefundServiceImpl implements RefundService {
    @Autowired
    private RefundRepo refundRepo;

    @Override
    public RefundDTO saveRefund(RefundDTO refundDTO) {
        return null;
    }

    @Override
    public void deleteRefund(String refundId) {

    }

    @Override
    public RefundDTO getSelectedRefund(String refundId) {
        return null;
    }

    @Override
    public List<RefundDTO> getAllRefunds() {
        return null;
    }

    @Override
    public void updateRefund(String refundId, RefundDTO refundDTO) {

    }
}
