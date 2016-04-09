package labat.paul.fr.openfoodfacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class ViewProduct extends AppCompatActivity {

    TextView productName, quantity, additives, ingredientsList, allergens, lables, categories, brands, packaging, traces;
    TextView bareCode;

    @Nullable
    private Product currentProduct;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_product);

        bareCode = (TextView)findViewById(R.id.bare_code);
        productName = (TextView) findViewById(R.id.product_name);
        quantity = (TextView)findViewById(R.id.quantity);
        additives = (TextView)findViewById(R.id.additives);
        ingredientsList = (TextView)findViewById(R.id.ingredients_list);
        allergens = (TextView)findViewById(R.id.allergenes);
        lables = (TextView)findViewById(R.id.labels);
        categories = (TextView)findViewById(R.id.categories);
        brands = (TextView)findViewById(R.id.brand);
        packaging = (TextView)findViewById(R.id.packaging);
        traces = (TextView)findViewById(R.id.traces);

        Intent intent = getIntent();
        if(intent.getStringExtra("data") != null){
            try {
                currentProduct = UtilsJSON.createProductFromJson(new JSONObject(intent.getStringExtra("data")));
            } catch (JSONException e) {
                e.printStackTrace();
                currentProduct = null;
            }
        }

        if(currentProduct != null)
            updateUI();

    }


    private void updateUI(){
        packaging.setText(currentProduct.getPackaging());
        allergens.setText(currentProduct.getAllergens());
        brands.setText(currentProduct.getBrand());
        categories.setText(currentProduct.getCategories());
        quantity.setText(currentProduct.getQuantity());
        productName.setText(currentProduct.getProductName());
        lables.setText(currentProduct.getLabels());
        traces.setText(currentProduct.getTraces());
        additives.setText(currentProduct.getAdditives() == null ? "" : currentProduct.getAdditives().toString());
        ingredientsList.setText(currentProduct.getIngredient());
        bareCode.setText(currentProduct.getBareCode());



    }



}
