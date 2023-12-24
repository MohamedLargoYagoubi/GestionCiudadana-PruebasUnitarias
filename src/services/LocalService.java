package services;

// Importamos únicamente las excepciones que vayamos a utilizar
import data.Password;
import exceptions.InvalidAccountException;

public interface LocalService { // Solves the login step for the support staff
    void verifyAccount (String login, Password pssw) throws InvalidAccountException;
}

