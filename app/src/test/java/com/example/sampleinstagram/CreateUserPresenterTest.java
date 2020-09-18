package com.example.sampleinstagram;

import com.example.sampleinstagram.presenters.CreateUserPresenter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateUserPresenterTest {

    private CreateUserPresenter createUserPresenter = new CreateUserPresenter();

    @Test
    public void passwordIsCorrectLength() {
        String pass = "fjwjejfj";
        assertTrue(createUserPresenter.isLength(pass));
    }

    @Test
    public void passwordHasCorrectCapitalLetters() {
        String pass = "aaTaaaa";
        assertTrue(createUserPresenter.hasCapitalLetter(pass));
    }

    @Test
    public void loginFailsWhenUsernameIsNull() {
        String pass = "aTasdf3ad";
        String pass2 = "aTasdf3ad";
        String user = "";
        assertFalse(createUserPresenter.isValidCredentials(user, pass, pass2));
    }

    @Test
    public void passwordFitsAllRequirements() {
        String pass = "aTasdf3ad";
        String user = "john";
        String pass2 = "aTasdf3ad";
        assertTrue(createUserPresenter.isValidCredentials(user, pass, pass2));
    }

}
