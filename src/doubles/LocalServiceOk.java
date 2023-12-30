package doubles;

import data.Password;
import exceptions.InvalidAccountException;
import services.LocalService;

import java.util.HashMap;
import java.util.Map;

public class LocalServiceOk implements LocalService {

    private Map<Password, String> userCredentials;

    public LocalServiceOk(Map<Password, String> userCredentials) {
        this.userCredentials = new HashMap<>(userCredentials);
    }
    @Override
    public void verifyAccount(String login, Password pssw) throws InvalidAccountException {
        if(pssw.isValid(pssw.getPassword())) {
            String user = userCredentials.get(pssw);
            if (user.equals(login)) {
                System.out.println("Acceso verificado corectamente");
            }
        } else {
            throw new InvalidAccountException("Acceso denegado");
        }
    }

}
