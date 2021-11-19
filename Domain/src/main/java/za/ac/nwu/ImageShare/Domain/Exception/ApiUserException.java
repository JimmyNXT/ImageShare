package za.ac.nwu.ImageShare.Domain.Exception;

public class ApiUserException extends RuntimeException{
    public ApiUserException(String message) {
        super(message);
    }
}
