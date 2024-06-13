package ru.mtsbank.depositservice.exception;

public class NoMoneyException extends Exception{
    public NoMoneyException(String message){
        super(message);
    }
}
