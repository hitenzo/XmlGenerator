package XmlGenerator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.ArrayList;
import java.util.Random;

public class EmailsManager {

    private ArrayList<EmailInfo> emailsList = new ArrayList<EmailInfo>();
    private SessionFactory sessionFactory;
    private Session session;

    public EmailsManager(){
        Configuration conf = new Configuration();
        conf.addResource("EmailInfo.hbm.xml");
        conf.configure();
        ServiceRegistry sessionRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        sessionFactory = conf.buildSessionFactory(sessionRegistry);
        session = sessionFactory.openSession();
    }

    public void createEmails(int counter){

        for(int i=0; i<counter; i++){
            EmailInfo email = new EmailInfo();
            email.setLogin(getLogin());
            email.setPassword("dupa123DUPA987");
            email.setRepeat_password("dupa123DUPA987");
            email.setName("Jan");
            email.setSurname("Kowalski");
            email.setFullname("Jan Kowalski");
            email.setCity_postalcode("Warszawa 02-153");
            email.setAlternative_contact("bourn2@wp.pl");
            email.setBirthDate_day("13");
            email.setBirthDate_month("marca");
            email.setBirthDate_year("1983");
            emailsList.add(email);
        }
    }

    public void saveEmailsToDB(){

        session.beginTransaction();
        for(EmailInfo email : emailsList){
            session.save(email);
        }
        session.getTransaction().commit();
    }

    public void deleteEmailsFromDB(int id){
        session.beginTransaction();
        EmailInfo email = (EmailInfo)session.load(EmailInfo.class, id);
        session.delete(email);
        session.getTransaction().commit();
    }

    public void closeDBConnection(){
        session.close();
        sessionFactory.close();
    }

    private static String getLogin(){
        String login = "";
        Random rand = new Random();

        for(int i=0; i<8; i++){
            char randomCharacter = (char)(rand.nextInt(26) + 'a');
            login = login.concat(Character.toString(randomCharacter));
        }
        for(int j=0; j<5; j++){
            int randomNumber = rand.nextInt(10);
            login = login.concat(Integer.toString(randomNumber));
        }

        return login;
    }
}

