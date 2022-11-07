package md.miller1995.springRestAPI.util;

// object of this class, will be sent, if we have an error
public class ErrorResponse {
    private String message;                     // message of errors
    private long timestamp;                     // time when error is taking place

    public ErrorResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
