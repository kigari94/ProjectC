package de.haw_hamburg.features.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<HomeModel> homeModels = new ArrayList<>();

    int[] homeModuleImages = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            androidx.constraintlayout.widget.R.drawable.abc_ic_star_black_16dp,
            com.google.android.material.R.drawable.abc_ic_star_half_black_16dp,
            androidx.constraintlayout.widget.R.drawable.abc_ic_star_half_black_48dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.homeRecyclerView);
        setupHomeModels();
        HomeAdapter adapter = new HomeAdapter(this, homeModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupHomeModels(){
        String[] homeModules = getResources().getStringArray(R.array.moduleNames);
        for (int i = 0; i < homeModules.length; i++) {
            homeModels.add(new HomeModel(homeModules[i], homeModuleImages[i]));
        }
    }
}