package com.example.demo;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;

@Controller
public class CookSearch {
    @GetMapping("/search")
    public String search(){
        return "cookSearch";
    }

    @PostMapping("/search")
    public String result(@RequestParam String cookName, Model model){
        try {
            String encoded = URLEncoder.encode(cookName, StandardCharsets.UTF_8);
            String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + encoded;

            RestTemplate restTemplate = new RestTemplate();
            Map response = restTemplate.getForObject(url, Map.class);
            List<Object> mealObj = (List<Object>) response.get("meals");
            System.out.println(((Map<String, Object>)mealObj.get(0)).keySet());

            List<Map<String, Object>> meals = new ArrayList<>();
            for (Object meal: mealObj){
                Map<String, Object> mealMap = new HashMap<>();
                mealMap.put("name", ((Map<String, Object>) meal).get("strMeal"));                mealMap.put("name", ((Map<String, Object>) meal).get("strMeal"));
                mealMap.put("category", ((Map<String, Object>) meal).get("strCategory"));
                mealMap.put("area", ((Map<String, Object>) meal).get("strArea"));
                mealMap.put("thumb", ((Map<String, Object>) meal).get("strMealThumb"));
                mealMap.put("instructions",((Map<String, Object>) meal).get("strInstructions"));
                meals.add(mealMap);
            }


            model.addAttribute("meals", meals);
            model.addAttribute("keyword", cookName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cookSearch";
    }
}
