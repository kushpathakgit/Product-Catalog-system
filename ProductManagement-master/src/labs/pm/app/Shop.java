    /*
     * Copyright (c) 2025- 7/18/25, 1:02 AM. year.
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

    package labs.pm.app;
    import labs.pm.data.Product;
    import labs.pm.data.ProductManager;
    import labs.pm.data.Rating;

    import java.math.BigDecimal;
    import java.time.LocalDate;
    import java.util.Locale;
    import java.util.Comparator;

    public class Shop {

        /**
         * The main method creates a {@link Product} instance, sets its properties,
         * and prints its ID, name, price, and discount to the console.
         *
         * @param args command-line arguments (not used)
         */
        public static void main(String[] args) {

            ProductManager pm = new ProductManager(new Locale("ml", "IN"));


            pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED, LocalDate.now());
            pm.printProductReport(42);

            pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
            pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak good");
            pm.reviewProduct(101, Rating.FOUR_STAR, "Fine tea");
            pm.reviewProduct(101, Rating.FOUR_STAR, "Good tea");
            pm.reviewProduct(101, Rating.FIVE_STAR, "Amazing hot cup of tea");
            pm.reviewProduct(101, Rating.THREE_STAR, "Okeish tea");

            pm.printProductReport(101);

            pm.createProduct(102, "Coffee",
                    BigDecimal.valueOf(1.99), Rating.NOT_RATED);
            pm.reviewProduct(102, Rating.THREE_STAR, "Coffee was ok");
            pm.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?!");
            pm.reviewProduct(102, Rating.FIVE_STAR,
                    "It's perfect with ten spoons of sugar!");
            pm.printProductReport(102);

            pm.createProduct(103, "Cake",
                    BigDecimal.valueOf(3.99), Rating.NOT_RATED,
                    LocalDate.now().plusDays(2));
            pm.reviewProduct(103, Rating.FIVE_STAR, "Very nice cake");
            pm.reviewProduct(103, Rating.FOUR_STAR,
                    "Good, but I've expected more chocolate");
            pm.reviewProduct(103, Rating.FIVE_STAR, "This cake is perfect!");
            pm.printProductReport(103);

            pm.createProduct(104, "Cookie",
                    BigDecimal.valueOf(2.99), Rating.NOT_RATED,
                    LocalDate.now());
            pm.reviewProduct(104, Rating.THREE_STAR, "Just another cookie");
            pm.reviewProduct(104, Rating.THREE_STAR, "Ok");
            pm.printProductReport(104);

            Product p5 = pm.createProduct(105, "Hot Chocolate",
                    BigDecimal.valueOf(2.50), Rating.NOT_RATED);
            p5 = pm.reviewProduct(p5, Rating.FOUR_STAR, "Tasty!");
            p5 = pm.reviewProduct(p5, Rating.FOUR_STAR, "No bad at all");
            pm.printProductReport(p5);

            Product p6 = pm.createProduct(106, "Chocolate",
                    BigDecimal.valueOf(2.50), Rating.NOT_RATED,
                    LocalDate.now().plusDays(3));
            p6 = pm.reviewProduct(106, Rating.TWO_STAR, "Too sweet");
            p6 = pm.reviewProduct(106, Rating.THREE_STAR, "Better then cookie");
            p6 = pm.reviewProduct(106, Rating.TWO_STAR, "Too bitter");
            p6 = pm.reviewProduct(106, Rating.ONE_STAR, "I don't get it!");
            pm.printProductReport(106);

            pm.getDiscount().forEach((rating, discount) -> System.out.println(rating + "\t" + discount));

            pm.printProduct(p -> p.getPrice().floatValue() < 2, (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());

    //        pm.printProduct((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));

    //        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
    //        Comparator<Product> priceSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
    //
    //        pm.printProduct(ratingSorter.thenComparing(priceSorter));
    //        pm.printProduct(ratingSorter.thenComparing(priceSorter).reversed());


            // if (p3 instanceof Food f) {
            //     System.out.println(f.getBestBefore());
            // }

            // System.out.println(
            //     p1.getId() + " " +
            //     p1.getName() + " " +
            //     p1.getPrice() + " " +
            //     p1.getDiscount() + " " +
            //     p1.getRating().getStar()
            // );

            // System.out.println(
            //     p2.getId() + " " +
            //     p2.getName() + " " +
            //     p2.getPrice() + " " +
            //     p2.getDiscount() + " " +
            //     p2.getRating().getStar()
            // );

            // System.out.println(
            //     p3.getId() + " " +
            //     p3.getName() + " " +
            //     p3.getPrice() + " " +
            //     p3.getDiscount() + " " +
            //     p3.getRating().getStar()
            // );

            // System.out.println(
            //     p4.getId() + " " +
            //     p4.getName() + " " +
            //     p4.getPrice() + " " +
            //     p4.getDiscount() + " " +
            //     p4.getRating().getStar()
            // );

            // System.out.println(
            //     p5.getId() + " " +
            //     p5.getName() + " " +
            //     p5.getPrice() + " " +
            //     p5.getDiscount() + " " +
            //     p5.getRating().getStar()
            // );
        }
    }