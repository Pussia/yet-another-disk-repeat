package ru.pasha.yetAnotherDiskRepeat.service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItem;
import ru.pasha.yetAnotherDiskRepeat.domain.SystemItemRequest;
import ru.pasha.yetAnotherDiskRepeat.exception.ValidationException;
import ru.pasha.yetAnotherDiskRepeat.validators.SystemItemRequestValidator;

import java.util.List;

@Service
@AllArgsConstructor
public class SystemItemRequestServiceImpl implements SystemItemRequestService {

    private final SystemItemRequestValidator systemItemRequestValidator;

    @Override
    public List<SystemItem> parseSystemItems(SystemItemRequest systemItemRequest) {
        if (systemItemRequestValidator.validate(systemItemRequest)) {
            return systemItemRequest.getItems();
        } else {
            throw new ValidationException("Validation Failed");
        }
    }
}
