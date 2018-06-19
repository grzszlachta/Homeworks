package model;

public class Address {

    private String city;
    private String street;
    private String house;
    private int room;
    private String zipCode;

    public Address() {

    }

    public Address(String _city, String _street, String _house, int _room, String _zipCode) {
        city = _city;
        street = _street;
        house = _house;
        room = _room;
        zipCode = _zipCode;
    }

    public String getCity() {
        return new String(city);
    }

    public String getStreet() {
        return new String(street);
    }

    public String getHouse() {
        return new String(house);
    }

    public int getRoom() {
        return room;
    }

    public String getZipCode() {
        return new String(zipCode);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", room=" + room +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }



}
