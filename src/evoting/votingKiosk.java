package evoting;

// Importamos únicamente las excepciones y las clases de paquete data que vayamos a utilizar
import data.BiometricData;
import data.Nif;
import data.Password;
import data.VotingOption;
import exceptions.*;
import services.ElectoralOrganism;
import services.LocalService;
import services.Scrutiny;

/**
 * Internal classes involved in the exercise of the vote
 */
public class votingKiosk {

    LocalService serviceLocal;
    ElectoralOrganism organismElectoral;
    Scrutiny scrutiny;
    //Opción de identificación: 'D' para el DNI y 'P' para el pasaporte.
    private char idOption;

    private boolean voteConf;

     //Último partido consultado.
     private VotingOption consultedParty;

     public votingKiosk(LocalService ls, ElectoralOrganism eo, Scrutiny scr) {
         this.serviceLocal = ls;
         this.organismElectoral = eo;
         this.scrutiny = scr;
         this.voteConf = false;
     }

     Nif voterNIF;


    // ??? The class members
    // ??? The constructor/s
    // Input events
    public void initVoting () {
        System.out.println("Bienvenido.\n Seleccione la funcionalidad deseada");
    }
    public void setDocument (char opt) {
       idOption = opt;
    }
    public void enterAccount (String login, Password pssw) throws InvalidAccountException {
         try {
             serviceLocal.verifyAccount(login, pssw);
         }catch (InvalidAccountException e) {
             System.out.println("La cuenta de acceso proporcionada es inválida");
         }
    }
    public void confirmIdentif (char conf) throws InvalidDNIDocumException {
        if(conf == 'N') {
            throw new InvalidDNIDocumException("El documento está caducado, no es válido o no corresponde a la persona.");
        }

    }
    public void enterNif (Nif nif) throws NotEnabledException, ConnectException{
         this.voterNIF = nif;
         this.organismElectoral.canVote(this.voterNIF);
         System.out.println("El usuario puede votar.");

    }
    public void initOptionsNavigation () {
        System.out.println("Opciones de voto: ");
    }
    public void consultVotingOption (VotingOption vopt) {
        consultedParty = vopt;
        System.out.println("Información sobre el partido" + consultedParty.getParty() + ": ");
    }
    public void vote () {
        System.out.println("Usted ha escogido votar a: " + this.consultedParty.getParty());
        System.out.println(("Confirme si desea votar al partido seleccionado: "));
    }

    public void confirmVotingOption (char conf) throws ConnectException {
        if(conf == 'S') {
            voteConf = true;
            System.out.println("Procesando voto...");
            this.scrutiny.scrutinize(this.consultedParty);
            this.organismElectoral.disableVoter(this.voterNIF);
            System.out.println("Voto escrutado correctamente.");
        }

    }

    private void finalizeSession () {
        // Hay que hacer
    }

    // Setter methods for injecting dependences and additional methods

    private void verifiyBiometricData (BiometricData humanBioD, BiometricData passpBioD) throws BiometricVerificationFailedException {
        // Hay que hacer
    }
    private void removeBiometricData () {
        // Hay que hacer
    }
    public void grantExplicitConsent (char cons) {
        // Hay que hacer
    }
    public void readPassport () throws NotValidPassportException, PassportBiometricReadingException{
        // Hay que hacer
    }
    public void readFaceBiometrics () throws HumanBiometricScanningException{
        // Hay que hacer
    }
    public void readFingerPrintBiometrics () throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException{
        // Hay que hacer
    }

}

