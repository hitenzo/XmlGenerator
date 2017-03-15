package XmlGenerator;

import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;


public class ConfigFile {

    private String filePath;
    private String show_sgl;
    private String format_sgl;
    private String dialect;
    private String driver_class;
    private String url;
    private int emailsCount;
    private String context_class;
    private String username;
    private String password;
    private String actionOnDB;

    public ConfigFile(String filePath){
        this.filePath = filePath;
    }

    public Configuration getConfiguration(){
        Configuration conf = new Configuration();
        conf.addResource("EmailInfo.hbm.xml");
        conf.setProperty("connection.url", url);
        if(show_sgl!=""){
            conf.setProperty("show_sql", show_sgl);
        }
        if(format_sgl!=""){
            conf.setProperty("format_sql", format_sgl);
        }
        if(dialect!=""){
            conf.setProperty("dialect", dialect);
        }
        if(driver_class!=""){
            conf.setProperty("connection.driver_class", driver_class);
        }
        if(context_class!=""){
            conf.setProperty("current_session_context_class", context_class);
        }
        if(username!=""){
            conf.setProperty("connection.username", username);
        }
        if(password!=""){
            conf.setProperty("connection.password", password);
        }
        if(actionOnDB!=""){
            conf.setProperty("hibernate.hbm2ddl.auto", actionOnDB);
        }
        return conf;
    }

    public void loadFileConfig() throws FileNotFoundException {

        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        Document configDocument = null;
        try {
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            configDocument = docBuilder.parse(file);

            if(isElementExist(configDocument, "show_sql")){
                Node show_sglNode = configDocument.getElementsByTagName("show_sql").item(0);
                show_sgl = show_sglNode.getTextContent();
            }

            if(isElementExist(configDocument, "format_sql")){
                Node format_sqlNode = configDocument.getElementsByTagName("format_sql").item(0);
                format_sgl = format_sqlNode.getTextContent();
            }

            if(isElementExist(configDocument, "dialect")){
                Node dialectNode = configDocument.getElementsByTagName("dialect").item(0);
                dialect = dialectNode.getTextContent();
            }

            if(isElementExist(configDocument, "connection.driver_class")){
                Node driver_classNode = configDocument.getElementsByTagName("connection.driver_class").item(0);
                driver_class = driver_classNode.getTextContent();
            }

            Node urlNode = configDocument.getElementsByTagName("db_path").item(0);
            url = urlNode.getTextContent();

            Node emailsNode = configDocument.getElementsByTagName("mail_count").item(0);
            emailsCount = Integer.parseInt(emailsNode.getTextContent());

            if(isElementExist(configDocument, "current_session_context_class")){
                Node context_classNode = configDocument.getElementsByTagName("current_session_context_class").item(0);
                context_class = context_classNode.getTextContent();
            }

            if(isElementExist(configDocument, "connection.username")){
                Node usernameNode = configDocument.getElementsByTagName("connection.username").item(0);
                username = usernameNode.getTextContent();
            }

            if(isElementExist(configDocument, "connection.password")){
                Node passwordNode = configDocument.getElementsByTagName("connection.password").item(0);
                password = passwordNode.getTextContent();
            }

            if(isElementExist(configDocument, "hibernate.hbm2ddl.auto")){
                Node actionOnDBNode = configDocument.getElementsByTagName("hibernate.hbm2ddl.auto").item(0);
                actionOnDB = actionOnDBNode.getTextContent();
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public int getEmailsCount(){
        return emailsCount;
    }

    public boolean isElementExist(Document document, String tagName){
        boolean elementExist = false;
        NodeList foundtags = document.getElementsByTagName(tagName);

        if(foundtags.getLength() > 0){
            elementExist = true;
        }

        return elementExist;
    }

}
