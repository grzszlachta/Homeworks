package model;

public interface Discountable {

    int MAGIC_NUMBER = 28;

    default int getDiscount() {
        return 25;
    }
}
