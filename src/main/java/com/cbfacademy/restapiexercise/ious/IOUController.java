package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/ious")
public class IOUController {

    private final IOUService iouService;

    @Autowired
    public IOUController(IOUService iouService) {
        this.iouService = iouService;
    }

    @Operation(summary="operation to retrive all ious")
    @GetMapping
    public List<IOU> getAllIOUs() {
        return iouService.getAllIOUs();
    }

    @Operation(summary="operation to retrive a specific ious")
    @GetMapping("/{id}")
    public IOU getIOU(@PathVariable UUID id) {
        return iouService.getIOU(id);
    }

    @Operation(summary="operation to create ious")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IOU createIOU(@RequestBody IOU iou) {
        return iouService.createIOU(iou);
    }

    @Operation(summary="operation to update a specific ious")
    @PutMapping("/{id}")
    public IOU updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) {
        return iouService.updateIOU(id, updatedIOU);
    }

    @Operation(summary="operation to delete an ious")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIOU(@PathVariable UUID id) {
        iouService.deleteIOU(id);
    }
}