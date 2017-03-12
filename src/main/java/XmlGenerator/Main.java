package XmlGenerator;


public class Main {

    public static void main(String[] args){
        int emailsCount = Integer.parseInt(args[0]);
        String filePath = args[1];
        String emailsToDelete = args[2];

        EmailsManager emailManager = new EmailsManager(filePath);
        emailManager.createEmails(emailsCount);
        emailManager.saveEmailsToDB();
        if(emailsToDelete != "0"){
            emailManager.deleteEmailsFromDB(emailsToDelete);
        }
        emailManager.closeDBConnection();
    }
}
