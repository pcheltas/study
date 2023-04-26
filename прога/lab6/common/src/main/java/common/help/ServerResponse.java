package common.help;

public enum ServerResponse {
    OK("успешно"),
    ERROR ("ошибка");

    private String title;

    ServerResponse(String title) {
        this.title = title;
    }
    public String getServerResponse() {
        return title;
    }
}
