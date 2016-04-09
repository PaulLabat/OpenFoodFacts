package labat.paul.fr.openfoodfacts;

import android.support.annotation.Nullable;
import android.support.v4.util.Pair;

import java.util.HashMap;
import java.util.List;


public class Product {
    @Nullable
    public String getBrand() {
        return brand;
    }

    public void setBrand(@Nullable String brand) {
        this.brand = brand;
    }

    @Nullable
    public String getNutritionGrade() {
        return nutritionGrade;
    }

    public void setNutritionGrade(@Nullable String nutritionGrade) {
        this.nutritionGrade = nutritionGrade;
    }

    @Nullable
    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(@Nullable String packaging) {
        this.packaging = packaging;
    }

    @Nullable
    public String getTraces() {
        return traces;
    }

    public void setTraces(@Nullable String traces) {
        this.traces = traces;
    }

    @Nullable
    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(@Nullable String allergens) {
        this.allergens = allergens;
    }

    @Nullable
    public String getProductName() {
        return productName;
    }

    public void setProductName(@Nullable String productName) {
        this.productName = productName;
    }

    @Nullable
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(@Nullable String ingredient) {
        this.ingredient = ingredient;
    }

    @Nullable
    public String getCategories() {
        return categories;
    }

    public void setCategories(@Nullable String categories) {
        this.categories = categories;
    }

    @Nullable
    public String getLabels() {
        return labels;
    }

    public void setLabels(@Nullable String labels) {
        this.labels = labels;
    }

    @Nullable
    public HashMap<String, String> getNutriments() {
        return nutriments;
    }

    public void setNutriments(@Nullable HashMap<String, String> nutriments) {
        this.nutriments = nutriments;
    }

    @Nullable
    public String getNutritionPerPortion() {
        return nutritionPerPortion;
    }

    public void setNutritionPerPortion(@Nullable String nutritionPerPortion) {
        this.nutritionPerPortion = nutritionPerPortion;
    }

    @Nullable
    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(@Nullable String servingSize) {
        this.servingSize = servingSize;
    }

    @Nullable
    public HashMap<String, String> getNutrientLevels() {
        return nutrientLevels;
    }

    public void setNutrientLevels(@Nullable HashMap<String, String> nutrientLevels) {
        this.nutrientLevels = nutrientLevels;
    }

    @Nullable
    public String getOrigins() {
        return origins;
    }

    public void setOrigins(@Nullable String origins) {
        this.origins = origins;
    }

    @Nullable
    public List<String> getAdditives() {
        return additives;
    }

    public void setAdditives(@Nullable List<String> additives) {
        this.additives = additives;
    }

    @Nullable
    public String getImageFrontUrl() {
        return imageFrontUrl;
    }

    public void setImageFrontUrl(@Nullable String imageFrontUrl) {
        this.imageFrontUrl = imageFrontUrl;
    }

    @Nullable
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(@Nullable String quantity) {
        this.quantity = quantity;
    }

    @Nullable
    private String quantity;

    @Nullable//brands
    private String brand;

    @Nullable//nutrition_grade_fr
    private String nutritionGrade;

    @Nullable//packaging
    private String packaging;

    @Nullable//traces
    private String traces;

    @Nullable//allergens
    private String allergens;

    @Nullable//product_name
    private String productName;

    @Nullable//ingredients_text
    private String ingredient;

    @Nullable//categories
    private String categories;

    @Nullable//labels
    private String labels;

    @Nullable//nutriments
    private HashMap<String, String> nutriments;

    @Nullable//nutrition_data_per
    private String nutritionPerPortion;

    @Nullable//serving_size
    private String servingSize;

    @Nullable//nutrient_levels
    private HashMap<String, String> nutrientLevels;

    @Nullable//origins
    private String origins;

    @Nullable//additives_tags
    private List<String> additives;

    @Nullable//image_front_small_url
    private String imageFrontUrl;

    @Nullable
    private String bareCode;

    @Nullable
    public String getBareCode() {
        return bareCode;
    }

    public void setBareCode(@Nullable String bareCode) {
        this.bareCode = bareCode;
    }
}
