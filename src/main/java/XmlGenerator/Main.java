package XmlGenerator;

/**
 * Created by hitenz on 07.03.2017.
 */
public class Main {

    public static void main(String[] args){
        //int emailsCount = Integer.parseInt(args[0]);
        int emailsCount = 3;
        EmailsManager emailManager = new EmailsManager();
        emailManager.createEmails(emailsCount);
        emailManager.saveEmailsToDB();
        emailManager.deleteEmailsFromDB(3);
        emailManager.deleteEmailsFromDB(4);
        emailManager.deleteEmailsFromDB(5);
        emailManager.closeDBConnection();
    }
}
