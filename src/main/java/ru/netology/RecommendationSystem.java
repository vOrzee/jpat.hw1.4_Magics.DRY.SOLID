package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class RecommendationSystem {
    public List<String> getRecommendedProducts(User user) {
        List<String> recommendedProducts = new ArrayList<>();

        if (!user.getPurchaseHistory().isEmpty()) {
            recommendedProducts.addAll(user.getPurchaseHistory());
        }

        return recommendedProducts;
    }
}