
package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/ious")
public class IOUController {

    private final IOUService iouService;

    @Autowired
    public IOUController(IOUService iouService) {
        this.iouService = iouService;
    }

    @GetMapping
    public List<IOU> getAllIOUs() {
        return iouService.getAllIOUs();
    }

    @GetMapping("/{id}")
    public IOU getIOU(@PathVariable UUID id) {
        return iouService.getIOU(id);
    }

    @PostMapping
    public IOU createIOU(@RequestBody IOU iou) {
        return iouService.createIOU(iou);
    }

    @PutMapping("/{id}")
    public IOU updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) {
        return iouService.updateIOU(id, updatedIOU);
    }

    @DeleteMapping("/{id}")
    public void deleteIOU(@PathVariable UUID id) {
        iouService.deleteIOU(id);
    }
}