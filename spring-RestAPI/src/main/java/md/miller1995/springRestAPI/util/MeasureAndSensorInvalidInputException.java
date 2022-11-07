package md.miller1995.springRestAPI.util;

// our custom exception, we throw this exception in program
public class MeasureAndSensorInvalidInputException extends RuntimeException {
    public MeasureAndSensorInvalidInputException(String message) {
        super(message);
    }
}
