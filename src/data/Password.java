package data;

import exceptions.InvalidPasswordException;

public class Password {

    private final String password;

    public Password(String pswrd) throws InvalidPasswordException {
        if(!isValid(pswrd)) {
            throw new InvalidPasswordException("La contrseña no es válida");
        }
        this.password = pswrd;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid(String pswrd) {
        if (pswrd == null) {
            return false;
            //es comprova la longitud mínima i màxima de la contrasenya
        } else if(pswrd.length() < 8 || pswrd.length() > 20) {
            return false;
        }
            //comprova que els caràcters siguin lletres o números
        for(int i = 0; i < pswrd.length(); i++) {
            if(!Character.isLetter(pswrd.charAt(i)) && !Character.isDigit(pswrd.charAt(i))) {
                return false;
            }
        }

        //return pswrd.matches("[a-z],[A-Z],[0-9],[-][_]");
        return true;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password p0 = (Password) o; 
        return password.equals(p0.password);
    }

    @Override
    public int hashCode () { return password.hashCode(); }

    @Override
    public String toString () {
        return "Contraseña= {" + password + '\'' + '}';
    }

}
