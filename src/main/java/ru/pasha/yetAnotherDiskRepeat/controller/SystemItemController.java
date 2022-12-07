package ru.pasha.yetAnotherDiskRepeat.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pasha.yetAnotherDiskRepeat.domain.*;
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
    public ResponseEntity<List<SystemItem>> saveSystemItem(@RequestBody SystemItemRequest systemItemRequest) {
        List<SystemItem> systemItems = systemItemRequestService.parseSystemItems(systemItemRequest);

        return new ResponseEntity<>(systemItemService.saveAllSystemItems(systemItems), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SystemItem> deleteSystemItemById(@PathVariable String id, @RequestParam String date) {
        SystemItem systemItem = systemItemService.deleteSystemItemById(id, date);

        return new ResponseEntity<>(systemItem, HttpStatus.OK);
    }

    @GetMapping("/nodes/{id}")
    public ResponseEntity<SystemItem> findSystemItemById(@PathVariable String id) {
        SystemItem systemItem = systemItemService.findSystemItemById(id);

        return new ResponseEntity<>(systemItem, HttpStatus.OK);
    }

    @GetMapping("/updates")
    public ResponseEntity<SystemItemResponse> findSystemItemByDate(@RequestParam String date) {
        List<SystemItem> systemItems = systemItemService.findSystemItemByDate(date);
        SystemItemResponse response = new SystemItemResponse(systemItems);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/node/{id}/history")
    public ResponseEntity<SystemItemHistoryResponse> getHistoryById(
            @PathVariable String id,
            @RequestParam String dateStart,
            @RequestParam String dateEnd
    ) {
        List<SystemItemHistory> systemItemsHistory = systemItemService.findHistoryById(id, dateStart, dateEnd);
        SystemItemHistoryResponse response = new SystemItemHistoryResponse(systemItemsHistory);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
