package ru.netology;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Product tablet = new Product("Tablet", "High-performance tablet with enhanced features", 829.99, "ManufacturerC", 0.0);
        Product smartWatch = new Product("SmartWatch", "Latest generation smartwatch with advanced tracking", 299.99, "ManufacturerD", 0.0);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(tablet);
        cart.addProduct(smartWatch);

        Random randomNumber = new Random();
        String orderNumber = Integer.toString(randomNumber.nextInt(9999));
        Order order = new Order(orderNumber);
        order.setProducts(cart.getProducts());

        DeliveryService deliveryService = new DeliveryService();
        String trackingNumber = deliveryService.shipOrder(order);

        deliveryService.trackOrder(trackingNumber);

        RatingSystem ratingSystem = new RatingSystem();
        ratingSystem.rateProduct(tablet, 4.8);

        RecommendationSystem recommendationSystem = new RecommendationSystem();
        User user = new User("AliceBlue", "alice.blue@example.com");
        user.addToPurchaseHistory(tablet.getName());
        user.addToPurchaseHistory(smartWatch.getName());

        List<String> userPurchaseHistory = user.getPurchaseHistory();
        System.out.println("Purchase history for user " + user.getUsername() + ": " + userPurchaseHistory);

        List<String> recommendedProducts = recommendationSystem.getRecommendedProducts(user);

        System.out.println("Recommended products for user " + user.getUsername() + ":");
        for (String recommendedProduct : recommendedProducts) {
            System.out.println(recommendedProduct);
        }
    }

}