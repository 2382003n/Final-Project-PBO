package cleaningServiceApp.entities;

public class Customer {
    private String name;
    private String addreas;
    private String phone;

    public Customer(String name, String addreas, String phone){
        this.name = name;
        this.addreas = addreas;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddreas() {
        return addreas;
    }

    public void setAddreas(String addreas) {
        this.addreas = addreas;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
