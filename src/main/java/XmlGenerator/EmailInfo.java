package XmlGenerator;


public class EmailInfo implements java.io.Serializable {

    private int id;
    private String login;
    private String password;
    private String repeat_password;
    private String name;
    private String surname;
    private String fullname;
    private String city_postalcode;
    private String alternative_contact;
    private String birthDate_day;
    private String birthDate_month;
    private String birthDate_year;


    public int getId() { return id; }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeat_password() {
        return repeat_password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCity_postalcode() {
        return city_postalcode;
    }

    public String getAlternative_contact() {
        return alternative_contact;
    }

    public String getBirthDate_day() {
        return birthDate_day;
    }

    public String getBirthDate_month() {
        return birthDate_month;
    }

    public String getBirthDate_year() {
        return birthDate_year;
    }

    public void setId(int id) { this.id = id; }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeat_password(String repeat_password) {
        this.repeat_password = repeat_password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCity_postalcode(String city_postalcode) {
        this.city_postalcode = city_postalcode;
    }

    public void setAlternative_contact(String alternative_contact) {
        this.alternative_contact = alternative_contact;
    }

    public void setBirthDate_day(String birthDate_day) {
        this.birthDate_day = birthDate_day;
    }

    public void setBirthDate_month(String birthDate_month) {
        this.birthDate_month = birthDate_month;
    }

    public void setBirthDate_year(String birthDate_year) {
        this.birthDate_year = birthDate_year;
    }
}

