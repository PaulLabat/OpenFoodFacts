package labat.paul.fr.openfoodfacts;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UtilsJSON {


    @Nullable
    public static JSONObject checkIfProductFound(JSONObject product){
        try {
            if(product.getInt("status") == 1){
                return product.getJSONObject("product");
            }else{
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }



    @NonNull
    public static Product createProductFromJson(JSONObject response){
        Product product = new Product();

        try {
            product.setBrand(response.getString("brands"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            product.setQuantity(response.getString("quantity"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            product.setNutritionGrade(response.getString("nutrition_grade_fr"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setPackaging(response.getString("packaging"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setTraces(response.getString("traces"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setAllergens(response.getString("allergens"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setProductName(response.getString("product_name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setIngredient(response.getString("ingredients_text"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setCategories(response.getString("categories"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setLabels(response.getString("labels"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setNutritionPerPortion(response.getString("nutrition_data_per"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setServingSize(response.getString("serving_size"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setOrigins(response.getString("origins"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            product.setImageFrontUrl(response.getString("image_front_small_url"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            JSONArray tmp = response.getJSONArray("additives_tags");
            List<String> l = new ArrayList<>();
            for(int i = 0; i < tmp.length(); i++){
                l.add(tmp.getString(i).replace("en:", ""));
            }
            product.setAdditives(l);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            JSONObject tmp = response.getJSONObject("nutriments");
            HashMap<String, String> h = new HashMap<>();
            h.put("sodium", tmp.getString("sodium_100g"));
            h.put("sodium portion", tmp.getString("sodium_serving"));

            h.put("sucres", tmp.getString("sugars_100g"));
            h.put("Sucres portion", tmp.getString("sugars_serving"));

            h.put("glucides", tmp.getString("carbohydrates_100g"));
            h.put("glucides portion", tmp.getString("carbohydrates_serving"));

            h.put("graisses", tmp.getString("fat_100g"));
            h.put("graisses portion", tmp.getString("fat_serving"));

            h.put("protéines", tmp.getString("proteins_100g"));
            h.put("protéines portion", tmp.getString("proteins_serving"));

            h.put("graisses", tmp.getString("fat_100g"));
            h.put("graisses portion", tmp.getString("fat_serving"));

            h.put("sel", tmp.getString("salt_100g"));
            h.put("sel portion", tmp.getString("salt_serving"));


            h.put("acides gras saturés", tmp.getString("saturated-fat_100g"));
            h.put("acides gras saturés portion", tmp.getString("saturated-fat_serving"));

            h.put("fibres", tmp.getString("fiber_100g"));
            h.put("fibres portion", tmp.getString("fiber_serving"));

            h.put("énergie", tmp.getString("energy_100g"));
            h.put("énergie portion", tmp.getString("energy_serving"));
            h.put("énergie unité", tmp.getString("energy_unit"));


            product.setNutriments(h);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            JSONObject tmp = response.getJSONObject("nutrient_levels");
            HashMap<String, String>  h= new HashMap<>();
            h.put("Sel", tmp.getString("salt"));
            h.put("Graisses", tmp.getString("fat"));
            h.put("Sucres", tmp.getString("sugars"));
            h.put("Graisses saturées", tmp.getString("salt"));

            product.setNutrientLevels(h);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return product;
    }


}
