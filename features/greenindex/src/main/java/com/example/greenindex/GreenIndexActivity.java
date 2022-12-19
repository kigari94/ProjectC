package com.example.greenindex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import de.haw_hamburg.core.data.ApiRequests;

public class GreenIndexActivity extends AppCompatActivity {

    ApiRequests apiRequests = new ApiRequests();
    String url = "https://api.corrently.io/v2.0/gsi/prediction?zip=69256";

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greenindex);

        apiRequests.getDataFromApi(url, this);

        // ToDo: Using Listener to get the values from the network (api) thread
        // String jsonArray = apiRequests.getApiResponse();

        // Toast.makeText(this.getApplicationContext(),"Response :" + jsonArray.toString(), Toast.LENGTH_LONG).show();

    }

    protected void setData() {
        pieChart.addPieSlice(
                new PieModel(
                        "Andere",
                        47,
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "GSI",
                        53,
                        Color.parseColor("#66BB6A")));
        pieChart.startAnimation();
    }
}