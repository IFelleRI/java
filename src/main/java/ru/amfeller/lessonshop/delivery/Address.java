package ru.amfeller.lessonshop.delivery;

public class Address {
    private final String houseNumber;
    private final String street;
    private final String city;
    private final String country;

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
