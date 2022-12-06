package ru.pasha.yetAnotherDiskRepeat.validators;

public interface Validator<T> {

    boolean validate(T arg);
}
