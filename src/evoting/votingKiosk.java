package evoting;

// Importamos únicamente las excepciones y las clases de paquete data que vayamos a utilizar
import data.*;
import evoting.biometricdataperipheral.HumanBiometricScanner;
import evoting.biometricdataperipheral.PassportBiometricReader;
import exceptions.*;
import services.*;

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
    private String login;
    private Password pssw;

    private char selectedDocument;
    private String supportLogin;
    private String supportPassword;
    private char supportConfirmation;
    private Nif manualNif;
    private VotingOption selectedVotingOption;

    private BiometricData passpBioD;
    private BiometricData humanBioD;
    private char consent;
    PassportBiometricReader passportValidationService;
    HumanBiometricScanner humanBiometricScanner;
    SingleBiometricData faceBiometricData;
    SingleBiometricData fingerprintBiometricData;
    ElectoralOrganism electoralOrganism;
    boolean vote = false;

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

        if (humanBioD == null || passpBioD == null) throw new BiometricVerificationFailedException("Los datos proporcionados son nulos");

        if(!checkData(humanBioD,passpBioD)) throw new BiometricVerificationFailedException("Los datos no coinciden con la persona");

        System.out.println("Verificacion biometricca correcta");
        return;
    }

    public boolean checkData(BiometricData data1, BiometricData data2) {
        if(data1.getFaceBiometricData().getKeyData().length != data2.getFaceBiometricData().getKeyData().length &&
                data1.getFingerprintBiometricData().getKeyData().length != data2.getFingerprintBiometricData().getKeyData().length) {
            return false;
        }
        return true;
    }
    private void removeBiometricData () {
        // Hay que hacer
        humanBioD = null;
        passpBioD = null;
        System.out.println("Datos biometricos eliminados");
    }
    public void grantExplicitConsent (char cons) throws InvalidConsentException{
        if (cons != 's' || cons != 'S') throw new InvalidConsentException("Consentimiento explicito denegado");
        System.out.println("Consentimineto explicito otorgado");
        consent = cons;

    }
    public void readPassport () throws NotValidPassportException, PassportBiometricReadingException{
        passportValidationService.validatePassport();
        manualNif = passportValidationService.getNifWithOCR();
        passpBioD = passportValidationService.getPassportBiometricData();
        System.out.println("Lectura de pasaporte correcta");
    }
    public void readFaceBiometrics () throws HumanBiometricScanningException{
        faceBiometricData = humanBiometricScanner.scanFaceBiometrics();
        System.out.println("Lectura biometrica facial ");


    }
    public void readFingerPrintBiometrics () throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException{
        fingerprintBiometricData = humanBiometricScanner.scanFingerprintBiometrics();
        humanBioD = new BiometricData(faceBiometricData, fingerprintBiometricData);
        verifiyBiometricData(humanBioD,passpBioD);
        System.out.println("Lectura de datos biométricos correcta.");
        // Eliminación de datos biometricos
        removeBiometricData();
        electoralOrganism.canVote(manualNif);
        vote = true;
        electoralOrganism.disableVoter(manualNif);

    }


}
