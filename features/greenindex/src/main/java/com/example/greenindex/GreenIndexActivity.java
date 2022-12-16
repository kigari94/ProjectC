package com.example.greenindex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import de.haw_hamburg.core.data.ApiRequests;

public class GreenIndexActivity extends AppCompatActivity {

    ApiRequests apiRequests = new ApiRequests();
    String url = "https://api.npoint.io/3c14109850c7a61d5540";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiRequests.getDataFromApi(url, this);
    }
}