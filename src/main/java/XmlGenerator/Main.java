package XmlGenerator;


import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        String filePath;

        if(args.length != 0){
            filePath = args[0];
        }else{
            filePath = "0";
        }


        EmailsManager emailManager = null;
        try {
            emailManager = new EmailsManager(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        emailManager.saveEmailsToDB();
        emailManager.closeDBConnection();
    }
}
