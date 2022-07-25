package com.weekend.w303;

import java.util.*;

public class FoodRatings {
    public TreeMap<String, List<String>> cuisiMap;
    public TreeMap<String,Integer> rateMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisiMap = new TreeMap<>();
        rateMap  = new TreeMap<>();
        for (int i = 0; i < foods.length; i++) {
            String name = foods[i];
            String cui = cuisines[i];
            int rat = ratings[i];
            List<String> orDefault = cuisiMap.getOrDefault(cui, new ArrayList<>());
            orDefault.add(name);
            cuisiMap.put(cui,orDefault);
            rateMap.put(name,rat);
        }
    }

    public void changeRating(String food, int newRating) {
        rateMap.put(food,newRating);
    }

    public String highestRated(String cuisine) {
        List<String> foodNames = cuisiMap.get(cuisine);
        String maxFoodNam="";
        int maxRate = 0;
        for (int i = 0; i < foodNames.size(); i++) {
            int rate = rateMap.get(foodNames.get(i));
            if (rate > maxRate){
                maxRate = rate;
                maxFoodNam = foodNames.get(i);
            }else if (rate == maxRate && maxFoodNam.compareTo(foodNames.get(i))>0){
                maxFoodNam = foodNames.get(i);
            }
        }
        return maxFoodNam;
    }
}
