public class Utente {
    private String email;
    private String password;
    
    Utente(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Email: " + email + ", Password: " + password;
    }
}
