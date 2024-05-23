package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ListIOUService implements IOUService {
    
    private final IOURepository repository;
    public ListIOUService (IOURepository iouRepository) {
        this.repository = iouRepository;
    }


    @Override
    public List<IOU> getAllIOUs() {
        return repository.findAll();
    
    }

    @Override
    public IOU getIOU(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIOU'");
    }

    @Override
    public IOU createIOU(IOU iou) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createIOU'");
    }

    @Override
    public IOU updateIOU(UUID id, IOU updatedIOU) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateIOU'");
    }

    @Override
    public void deleteIOU(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteIOU'");
    }


}
