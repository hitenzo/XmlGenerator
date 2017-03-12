package XmlGenerator;

import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by hitenz on 09.03.2017.
 */
public class ConfigFile {

    private String filePath;
    private String show_sgl;
    private String format_sgl;
    private String dialect;
    private String driver_class;
    private String url;
    private String context_class;
    private String username;
    private String password;
    private String actionOnDB;

    public ConfigFile(String filePath){
        filePath = filePath;
        loadFileConfig();
    }

    public Configuration getConfiguration(){
        Configuration conf = new Configuration();
        conf.addResource("EmailInfo.hbm.xml");
        conf.setProperty("show_sql", show_sgl);
        conf.setProperty("format_sql", format_sgl);
        conf.setProperty("dialect", dialect);
        conf.setProperty("connection.driver_class", driver_class);
        conf.setProperty("connection.url", url);
        conf.setProperty("current_session_context_class", context_class);
        conf.setProperty("connection.username", username);
        conf.setProperty("connection.password", password);
        conf.setProperty("hibernate.hbm2ddl.auto", actionOnDB);
        return conf;
    }

    public void loadFileConfig(){

        File file = new File(filePath);
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        Document configDocument = null;
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        try {
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            configDocument = docBuilder.parse(file);
            XPathExpression show_sqlExpr = xpath.compile("//property[@name='show_sql']");
            XPathExpression format_sglExpr = xpath.compile("//property[@name='format_sql']");
            XPathExpression dialectExpr = xpath.compile("//property[@name='dialect']");
            XPathExpression driver_classExpr = xpath.compile("//property[@name='connection.driver_class']");
            XPathExpression urlExpr = xpath.compile("//property[@name='connection.url']");
            XPathExpression context_classExpr = xpath.compile("//property[@name='current_session_context_class']");
            XPathExpression usernameExpr = xpath.compile("//property[@name='connection.username']");
            XPathExpression passwordExpr = xpath.compile("//property[@name='connection.password']");
            XPathExpression actionOnDBExpr = xpath.compile("//property[@name='hibernate.hbm2ddl.auto']");

            Node show_sglNode = (Node) show_sqlExpr.evaluate(configDocument, XPathConstants.NODESET);
            show_sgl = show_sglNode.getTextContent();

            Node format_sglNode = (Node) format_sglExpr.evaluate(configDocument, XPathConstants.NODESET);
            format_sgl = format_sglNode.getTextContent();

            Node dialectNode = (Node) dialectExpr.evaluate(configDocument, XPathConstants.NODESET);
            dialect = dialectNode.getTextContent();

            Node driver_classNode = (Node) driver_classExpr.evaluate(configDocument, XPathConstants.NODESET);
            driver_class = driver_classNode.getTextContent();

            Node urlNode = (Node) urlExpr.evaluate(configDocument, XPathConstants.NODESET);
            url = urlNode.getTextContent();

            Node context_classNode = (Node) context_classExpr.evaluate(configDocument, XPathConstants.NODESET);
            context_class = context_classNode.getTextContent();

            Node usernameNode = (Node) usernameExpr.evaluate(configDocument, XPathConstants.NODESET);
            username = usernameNode.getTextContent();

            Node passwordNode = (Node) passwordExpr.evaluate(configDocument, XPathConstants.NODESET);
            password = passwordNode.getTextContent();

            Node actionOnDBNode = (Node) actionOnDBExpr.evaluate(configDocument, XPathConstants.NODESET);
            actionOnDB = actionOnDBNode.getTextContent();

            //NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}
