package de.haw_hamburg.core.data;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ApiRequests {

    private static final String TAG = "ApiActivity";
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    public void getDataFromApi(String url, Context context) {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(context);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, response -> {

            Toast.makeText(context.getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

        }, error -> Log.i(TAG,"Error :" + error.toString()));

        mRequestQueue.add(mStringRequest);
    }
}
