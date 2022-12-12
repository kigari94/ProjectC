package de.haw_hamburg.features.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<HomeModel> homeModels = new ArrayList<>();

    int[] homeModuleImages = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};

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