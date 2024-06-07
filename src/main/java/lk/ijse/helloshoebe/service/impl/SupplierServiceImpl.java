package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.SupplierDTO;
import lk.ijse.helloshoebe.entity.Supplier;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.InvalidDataException;
import lk.ijse.helloshoebe.exception.NotFoundException;
import lk.ijse.helloshoebe.repo.SupplierRepo;
import lk.ijse.helloshoebe.service.SupplierService;
import lk.ijse.helloshoebe.util.IdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        try {
            supplierDTO.setSupplierCode(IdGenerator.generateId());
            supplierRepo.save(modelMapper.map(supplierDTO,Supplier.class));
            return supplierDTO;
        }catch(Exception e){
            throw new DuplicateException("Supplier is already there");
        }
    }

    @Override
    public void deleteSupplier(String supplierId) {
        try {
            if (supplierRepo.existsById(supplierId)){
                supplierRepo.deleteById(supplierId);
            }
        }catch (Exception e){
            throw new NotFoundException("Supplier does not Exist");
        }
    }

    @Override
    public SupplierDTO getSelectedSupplier(String supplierId) {
        try {
            if (supplierRepo.existsById(supplierId)){
                return modelMapper.map(supplierRepo.getReferenceById(supplierId),SupplierDTO.class);
            }
            throw new NotFoundException("Supplier does not Exist");
        }catch (Exception e){
            throw new NotFoundException("Supplier does not Exist");
        }
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        try {
            return modelMapper.map(supplierRepo.findAll(), List.class);
        }catch (Exception e){
            throw new InvalidDataException("Relevant Data Can't be Found");
        }
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        if (supplierRepo.existsById(supplierDTO.getSupplierCode())){
            try {
                Supplier supplier = modelMapper.map(supplierDTO,Supplier.class);
                return modelMapper.map(supplierRepo.save(supplier), SupplierDTO.class);
            }catch (Exception e){
                throw new DuplicateException("Supplier Duplicate Data Entered");
            }
        }
        throw new NotFoundException("Supplier Not Found");
    }
}
