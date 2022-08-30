package model;

public class Clients {
    private String inn;
    private int id;
    private String fio;
    private String gender;
    private String country;

    public Clients(String inn, int id, String fio, String gender, String country) {
        this.inn = inn;
        this.fio = fio;
        this.gender = gender;
        this.country = country;
        this.id = id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
