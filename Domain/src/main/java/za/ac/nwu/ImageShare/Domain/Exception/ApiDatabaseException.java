package za.ac.nwu.ImageShare.Domain.Exception;

public class ApiDatabaseException extends RuntimeException{
    public ApiDatabaseException(String message) {
        super(message);
    }
}
