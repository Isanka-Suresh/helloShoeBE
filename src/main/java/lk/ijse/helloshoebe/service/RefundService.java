package lk.ijse.helloshoebe.service;


import lk.ijse.helloshoebe.dto.RefundDTO;

import java.util.List;

public interface RefundService {
    RefundDTO saveRefund(RefundDTO refundDTO);
    void deleteRefund(String refundId);
    RefundDTO getSelectedRefund(String refundId);
    List<RefundDTO> getAllRefunds();
    void updateRefund(String refundId,RefundDTO refundDTO);
}
