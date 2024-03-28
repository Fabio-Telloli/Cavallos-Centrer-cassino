public class Utente {
    private String email;
    private String password;
    private Integer crediti;
    
    Utente(String email, String password, Integer crediti) {
        this.email = email;
        this.password = password;
        this.crediti = crediti;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getCrediti() {
        return crediti;
    }

    public void setCrediti(Integer crediti) {
        this.crediti = crediti;
    }

    @Override
    public String toString() {
        return email + " " + password + " " + crediti;
    }
}
