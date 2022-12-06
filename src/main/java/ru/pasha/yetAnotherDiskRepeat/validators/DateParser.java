package ru.pasha.yetAnotherDiskRepeat.validators;

import org.springframework.stereotype.Component;
import ru.pasha.yetAnotherDiskRepeat.exception.ValidationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateParser {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    public Date parse(String date) {
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new ValidationException("Validation Failed");
        }
    }
}
