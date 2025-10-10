package ru.amfeller.lessonshop.delivery;

public class Address {
    private String houseNumber;
    private String street;
    private String city;
    private String country;

    public Address(String country, String city,String street,String houseNumber) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + ", " + city + ", ул. " + street + ", д. " + houseNumber;
    }
}
