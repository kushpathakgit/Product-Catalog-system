/*
 * Copyright (c) 2025- 7/18/25, 1:09 AM. year.
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

/**
 * The {@code Product} class represents a product in an inventory or catalog system.
 * It includes fields for ID, name, and price, and provides methods to access and
 * modify these values. It also includes logic to calculate a standard discount.
 *
 * <p>This class uses {@link BigDecimal} for price and discount calculations to ensure
 * precision in financial operations.</p>
 *
 * @author Sanjay
 * @version 1.0
 * @since 2025-07-05
 */
package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;
import static labs.pm.data.Rating.*;
import static labs.pm.data.Rating.NOT_RATED;

public sealed abstract class Product implements Rateable<Product> permits Food, Drink  {

   
    private Rating rating;
    private final int id;
    private final  String name;
    private final BigDecimal price;

    Product(int id, String name, BigDecimal price, Rating rating){
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price){
        this(id, name ,price, NOT_RATED);
    }



    
    @Override
    public String toString() {  //overriding toString() method of the object class to our need
        return "Product(" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", price= " + price +
           ", rating= " + rating.getStar() +
           ", bestBefore= " + getBestBefore() +
           ')';
        }

    @Override
    public boolean equals(Object o) { //overriding equals method of object class to our need the 
        if (this == o) return true;          //traditonal one will only check if both are pointing to the same    location in heap or not 
        if ( o instanceof Product product) {
            return id == product.id;
        }
        return false;
    }
//     - this == o: Fast path — if both references point to the same object, they’re obviously equal.
// - getClass() != o.getClass(): Ensures both are exactly the same type, avoiding false positives across class hierarchies.
// - (Product) o: Safely cast so you can access fields.
// - Objects.equals(...): Null-safe way to compare name, avoids manual null checks

    // @Override
    // public boolean equals(Object o) { 
    //     if (this == o) return true;          
    //     if ( o instanceof Product product) {
    //     return id == product.id && Objects.equals(name, product.name);
    //     }
    //     return false;
    // }

//     - This line is strict: it requires both objects to be of the exact same class.
// - If Product is later subclassed (e.g. DiscountedProduct), this check fails, even if the fields match!
// - That’s why it could return false, even when id and name were equal.



    @Override
    public int hashCode() {
        return Objects.hash(id);

    }

    /**
     * The standard discount rate applied to all products (10%).
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    public Rating getRating(){
        return rating;
    }
    /**
     * Returns the product's unique identifier.
      *
     * @return the product ID
     */
    public int getId() {
        return id;
    }



    /**
     * Returns the name of the product.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }



    /**
     * Returns the price of the product.
     *
     * @return the product price
     */
    public BigDecimal getPrice() {
        return price;
    }


    /**
     * Calculates and returns the discount amount based on the current price
     * and the standard {@link #DISCOUNT_RATE}.
     *
     * @return the discount amount, rounded to two decimal places
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public abstract Product applyRating(Rating newRating);

    /**
     * Assumes that the best before date is today 
     * @return the current date
     */
    public LocalDate getBestBefore(){
        return LocalDate.now();
    }
}