package labat.paul.fr.openfoodfacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String productUrl = "http://fr.openfoodfacts.org/api/v0/produit/";

    private RequestQueue mRequestQueue;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scanButton = (Button) findViewById(R.id.scan_button);
        Button scanButton2 = (Button) findViewById(R.id.scan2);
        if(scanButton != null)
            scanButton.setOnClickListener(this);

        if(scanButton2 != null)
            scanButton2.setOnClickListener(this);


        number = (EditText)findViewById(R.id.number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scan_button:
                new IntentIntegrator(this).initiateScan();
                break;
            case R.id.scan2:
                if(Utils.isNetworkAvailable(this)){
                    getProduct(number.getText().toString());
                }else{
                    Toast.makeText(this, "Pas de connexion réseau", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            if(Utils.isNetworkAvailable(this)){
                getProduct(scanContent);
            }else{
                Toast.makeText(this, "Pas de connexion réseau", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "Aucune donnée reçu!", Toast.LENGTH_SHORT).show();

        }

    }



    public RequestQueue getReqQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    private void getProduct(String productBareCode){
        String url = productUrl+productBareCode+".json";
        Log.d("getproduct", url);
        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject res = UtilsJSON.checkIfProductFound(response);
                if(res != null){
                    Intent intent = new Intent(getApplicationContext(), ViewProduct.class);
                    intent.putExtra("data", res.toString());
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("resquest", error.getMessage());
            }
        });
        getReqQueue().add(request);
    }
}