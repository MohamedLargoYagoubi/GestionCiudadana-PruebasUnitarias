package data;

import exceptions.InvalidNifException;

public class Nif {

    private final String nif;
    public Nif (String code) throws InvalidNifException {
        if(!isValidNIF(code)) throw new InvalidNifException("El NIF no es válido");
        this.nif = code;
    }



    public Boolean isValidNIF(String code){
        String codes = "TRWAGMYFPDXBNJZSQVHLCKE"; // Códigos de control

        // Comprueba que la entrada no sea un null
        if (code == null) return false;

        String numero = code.substring(0, code.length() -1); // Nos quedamos con toda la cadena original sin la última letra

        // Verificamos que la última posición sea una letra y nos quedamos con su valor
        if(!Character.isLetter(code.charAt(code.length()-1))) return false;
        char letra = Character.toUpperCase(code.charAt(code.length()-1));

        // Comprueba que la longitud no sea diferente de 9
        if (code.length() != 9) return false;

        // Comprobamos que de la posición 1 a las 7 sean dígitos (en la posición 0 podría contener letras como sucede con los NIEs)
        for (int i = 1; i < 8; i++) {
            if (!Character.isDigit(code.charAt(i))) return false;
        }
        // En el caso de disponer de un NIE, la primera cifra ha de ser una letra
        if(Character.isLetter(numero.charAt(0))){
            // La letra inicial solamente puede ser X, Y o Z y reemplazamos por su valor númerico correspondiente
            if(Character.toUpperCase(numero.charAt(0)) == 'X'){
                numero = numero.replace("X", "0");
            } else if (Character.toUpperCase(numero.charAt(0)) == 'Y') {
                numero = numero.replace("Y", "1");
            } else if (Character.toUpperCase(numero.charAt(0)) == 'Z'){
                numero = numero.replace("Z", "2");
            }else{
                return false;
            }
        }
        // Calculamos la letra de control
        int res = Integer.parseInt(numero) % 23;
        // Verificamos que la última letra corresponda con el resultado
        return letra == codes.charAt(res);
    }
    public String getNif () { return nif; }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif niff = (Nif) o;
        return nif.equals(niff.nif);
    }
    @Override
    public int hashCode () { return nif.hashCode(); }
    @Override
    public String toString () {
        return "Nif{" + "nif ciudadano= " + nif + '\'' + '}';
    }
}