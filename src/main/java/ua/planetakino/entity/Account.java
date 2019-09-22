package ua.planetakino.entity;

public class Account {
    private String firstName;
    private String lastName;
    private String secretWord;

    public Account(String firstName, String lastName, String secretWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secretWord = secretWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
