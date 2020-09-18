package com.example.sampleinstagram.presenters;

public class CreateUserPresenter {
    private String TAG = CreateUserPresenter.class.getSimpleName();

    int passwordLength = 5;

    public CreateUserPresenter(){}

    public boolean isValidCredentials(String user, String pass, String pass2) {
        return isMatchingAndNonEmpty(user, pass, pass2) && isLength(pass) && hasCapitalLetter(pass);
    }

    public boolean isMatchingAndNonEmpty(String user, String pass, String pass2) {
        return pass.equals(pass2) && !pass.isEmpty() && !pass2.isEmpty() && !user.isEmpty();
    }

    public boolean isLength(String password) {
        return password.length() >= passwordLength;
    }

    public boolean hasCapitalLetter(String password) {
        for (int i=0; i<password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
