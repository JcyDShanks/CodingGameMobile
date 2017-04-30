package demo.toolbar;
/**
 * Created by JcyDShanks on 2017/4/12.
 */

public class PhoneInfo {
    private String name;
    private String number;
    //private String Id;
    //private String email;
    public PhoneInfo(String name,String number){
        setName(name);
        setNumber(number);
        //setId(Id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //public void setId(String Id){ this.Id=Id; }

    public String getNumber() { return number; }

    public String getName() {
        return name;
    }

    //public String getId(){ return Id; }

}
