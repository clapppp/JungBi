package starthere.review.dto;

public class LoginDto {
    private final String id;
    private String password;

    public LoginDto(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        return;
    }
}
