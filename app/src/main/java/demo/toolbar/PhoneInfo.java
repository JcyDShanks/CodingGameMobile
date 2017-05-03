package demo.toolbar;
/**
 * Created by JcyDShanks on 2017/4/12.
 */

public class PhoneInfo {
    private String name;
    private String number;
    public PhoneInfo(String name,String number){
        setName(name);
        setNumber(number);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() { return number; }

    public String getName() {
        return name;
    }
}
