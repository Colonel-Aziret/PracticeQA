package model;

public class Airport {
    private String code;
    private String city;
    private String country_code;

    public Airport(String code, String city, String country_code) {
        this.code = code;
        this.city = city;
        this.country_code = country_code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
