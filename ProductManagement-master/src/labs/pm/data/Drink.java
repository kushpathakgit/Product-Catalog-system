package labs.pm.data;


import java.math.BigDecimal;
import java.time.LocalTime;

public final class Drink extends Product {
    
    public BigDecimal getDiscount() {
        LocalTime timeNow = LocalTime.now();
        return (timeNow.isAfter(LocalTime.of(17, 30)) && timeNow.isBefore(LocalTime.of(18, 30)) ? super.getDiscount() : BigDecimal.ZERO);
    }

    Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }

    public Product applyRating(Rating newRating){
        return new Drink(getId(), getName(), getPrice(), newRating);
    }
}
