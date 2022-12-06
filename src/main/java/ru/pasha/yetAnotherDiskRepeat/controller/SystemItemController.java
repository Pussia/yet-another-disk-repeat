package ru.pasha.yetAnotherDiskRepeat.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItem;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItemRequest;
import ru.pasha.yetAnotherDiskRepeat.service.SystemItemRequestService;
import ru.pasha.yetAnotherDiskRepeat.service.SystemItemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class SystemItemController {

    private final SystemItemRequestService systemItemRequestService;
    private final SystemItemService systemItemService;

    @PostMapping("/imports")
    public ResponseEntity<List<SystemItem>> save(@RequestBody SystemItemRequest systemItemRequest) {
        List<SystemItem> systemItems = systemItemRequestService.parseSystemItems(systemItemRequest);

        return new ResponseEntity<>(systemItemService.saveAll(systemItems), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SystemItem> delete(@PathVariable String id, @RequestParam String date) {
        SystemItem systemItem = systemItemService.deleteById(id, date);

        return new ResponseEntity<>(systemItem, HttpStatus.OK);
    }

    @GetMapping("/nodes/{id}")
    public ResponseEntity<SystemItem> findById(@PathVariable String id) {
        SystemItem systemItem = systemItemService.findById(id);

        return new ResponseEntity<>(systemItem, HttpStatus.OK);
    }
}
