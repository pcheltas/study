package common.help;
import java.io.Serializable;

public class Response implements Serializable{
    private String responseBody;
    private ServerResponse responseCode;
    private String responseCodeInString;

    public Response(ServerResponse responseCode, String responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public Response(String responseCodeInString, String responseBody) {
        this.responseCodeInString = responseCodeInString;
        this.responseBody = responseBody;
    }


    public String getResponseBody() {
        return responseBody;
    }

    @Override
    public String toString() {
        return "Response[" + responseBody + "]";
    }

    public ServerResponse getResponseCode() {
        return responseCode;
    }
}
