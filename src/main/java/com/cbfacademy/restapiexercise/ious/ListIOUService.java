package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.restapiexercise.core.IOUNotFoundException;
import com.cbfacademy.restapiexercise.core.PersistenceException;

@Service
public class ListIOUService implements IOUService {
    
    private final IOURepository iouRepository;

    @Autowired
    public ListIOUService (IOURepository iouRepository) {
        this.iouRepository = iouRepository;
    }


    @Override
    public List<IOU> getAllIOUs() {
        return iouRepository.findAll();
    
    }

    @Override
    public IOU getIOU(UUID id) {
        if (!iouRepository.findById(id).isPresent()) {
            throw new IOUNotFoundException("Resource not exist");
        }
        return iouRepository.findById(id).get();
    }

    @Override
    public IOU createIOU(IOU iou) {
        return iouRepository.save(iou);
    }

    @Override
    public IOU updateIOU(UUID id, IOU updatedIOU) {
        IOU iou = getIOU(id);
        iou.setLender(updatedIOU.getLender());
        iou.setAmount(updatedIOU.getAmount());
        iou.setBorrower(updatedIOU.getBorrower());
        iou.setDateTime(updatedIOU.getDateTime());
        return iouRepository.save(iou);
    }

    @Override
    public void deleteIOU(UUID id) {
        IOU iou = getIOU(id);
        iouRepository.delete(iou);
    }


}
