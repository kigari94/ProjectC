package de.haw_hamburg.core.data;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiRequests {

    private static final String TAG = "ApiActivity";
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String jsonArray = null;

    public void getDataFromApi(String url, Context context) {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(context);

        //JObject Request initialized
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // ToDo: Give values to Listener in Main Activity
                        try {
                            JSONArray jsonArray = response.getJSONArray("forecast");
                            // JSONObject test = jsonArray.getJSONObject(2);
                            // String secondTest = test.getString("gsi");
                            // setApiResponse(secondTest);
                            // Toast.makeText(context.getApplicationContext(),"Response :" + jsonArray.getString(2), Toast.LENGTH_LONG).show();
                            String gsi = null;
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                gsi = jsonObject.getString("gsi");

                                Log.i(TAG, "Test: " + gsi);
                                // Toast.makeText(context.getApplicationContext(),"Response :" + jsonArray.getString(9), Toast.LENGTH_LONG).show();
                                // Toast.makeText(context.getApplicationContext(),"Response :" + jsonArray.getString(10), Toast.LENGTH_LONG).show();
                            }
                            Toast.makeText(context.getApplicationContext(), "Response :" + gsi, Toast.LENGTH_LONG).show();
                            // Toast.makeText(context.getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();
                            // Toast.makeText(context.getApplicationContext(),"Response :" + response.getString("gsi"), Toast.LENGTH_LONG).show();
                            // Toast.makeText(context.getApplicationContext(),"Response :" + response.getString("ewind"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG,"Error : APIRequests went wrong");
                    }
                });

        mRequestQueue.add(jsonObjectRequest);

    }

    private void setApiResponse(String response) {
        jsonArray = response;
    }

    public String getApiResponse() {
        return jsonArray;
    }
}
