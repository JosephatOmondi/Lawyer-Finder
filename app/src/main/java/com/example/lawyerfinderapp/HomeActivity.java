package com.example.lawyerfinderapp;

import com.example.lawyerfinderapp.models.Lawyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private LawyerAdapter adapter;
    private ArrayList<Lawyer> lawyers, filteredLawyers;
    private SearchView searchLocation, searchType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Drawer Layout
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Navigation View
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            return true;
        });

        // Search Views
        searchLocation = findViewById(R.id.search_location);
        searchType = findViewById(R.id.search_type);

        // ListView Initialization
        listView = findViewById(R.id.AllList);
        lawyers = new ArrayList<>();
        populateLawyers();
        filteredLawyers = new ArrayList<>(lawyers);

        // Initialize LawyerAdapter (Removed admin-related parameters)
        adapter = new LawyerAdapter(this, filteredLawyers);
        listView.setAdapter(adapter);

        // Location Search
        searchLocation.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterLawyers();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterLawyers();
                return true;
            }
        });

        // Type Search
        searchType.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterLawyers();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterLawyers();
                return true;
            }
        });

        // Lawyer Click Event
        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Lawyer selectedLawyer = filteredLawyers.get(position);
            Intent intent = new Intent(HomeActivity.this, BookAppointmentActivity.class);
            intent.putExtra("lawyer_name", selectedLawyer.getName());
            intent.putExtra("lawyer_type", selectedLawyer.getSpecialty());

            int imageRes = selectedLawyer.getImageResId();
            if (imageRes == 0) {
                imageRes = R.drawable.ic_baseline_person_24; // Default Image
            }
            intent.putExtra("lawyer_image", imageRes);

            startActivity(intent);
        });
    }

    private void populateLawyers() {
        lawyers.add(new Lawyer(1, "John Mwangi", "Criminal Defense Lawyer", R.drawable.ic_baseline_person_24, 4.8f, "Nairobi"));
        lawyers.add(new Lawyer(2, "Aisha Hassan", "Family Lawyer", R.drawable.ic_baseline_person_24, 4.7f, "Mombasa"));
        lawyers.add(new Lawyer(3, "David Otieno", "Immigration Lawyer", R.drawable.ic_baseline_person_24, 4.6f, "Kisumu"));
        lawyers.add(new Lawyer(4, "Grace Wanjiru", "Real Estate Lawyer", R.drawable.ic_baseline_person_24, 4.9f, "Nakuru"));
        lawyers.add(new Lawyer(5, "Kelvin Kiptoo", "Employment Lawyer", R.drawable.ic_baseline_person_24, 4.5f, "Eldoret"));
        lawyers.add(new Lawyer(6, "Lucy Ndung’u", "Tax Lawyer", R.drawable.ic_baseline_person_24, 4.7f, "Thika"));
        lawyers.add(new Lawyer(7, "Peter Ochieng", "Intellectual Property Lawyer", R.drawable.ic_baseline_person_24, 4.8f, "Kisii"));
        lawyers.add(new Lawyer(8, "Brenda Akinyi", "Personal Injury Lawyer", R.drawable.ic_baseline_person_24, 4.6f, "Machakos"));
        lawyers.add(new Lawyer(9, "Samuel Kariuki", "Bankruptcy Lawyer", R.drawable.ic_baseline_person_24, 4.9f, "Nyeri"));
        lawyers.add(new Lawyer(10, "Christine Naliaka", "Human Rights Lawyer", R.drawable.ic_baseline_person_24, 4.8f, "Bungoma"));

        lawyers.add(new Lawyer(11, "James Karanja", "Criminal Defense Lawyer", R.drawable.ic_baseline_person_24, 4.7f, "Nairobi"));
        lawyers.add(new Lawyer(12, "Fatuma Juma", "Family Lawyer", R.drawable.ic_baseline_person_24, 4.5f, "Mombasa"));
        lawyers.add(new Lawyer(13, "Brian Onyango", "Immigration Lawyer", R.drawable.ic_baseline_person_24, 4.6f, "Kisumu"));
        lawyers.add(new Lawyer(14, "Janet Chepkirui", "Real Estate Lawyer", R.drawable.ic_baseline_person_24, 4.9f, "Nakuru"));
        lawyers.add(new Lawyer(15, "Steve Kibet", "Employment Lawyer", R.drawable.ic_baseline_person_24, 4.4f, "Eldoret"));
        lawyers.add(new Lawyer(16, "Nancy Wairimu", "Tax Lawyer", R.drawable.ic_baseline_person_24, 4.8f, "Thika"));
        lawyers.add(new Lawyer(17, "George Ouma", "Intellectual Property Lawyer", R.drawable.ic_baseline_person_24, 4.7f, "Kisii"));
        lawyers.add(new Lawyer(18, "Susan Atieno", "Personal Injury Lawyer", R.drawable.ic_baseline_person_24, 4.5f, "Machakos"));
        lawyers.add(new Lawyer(19, "Patrick Njoroge", "Bankruptcy Lawyer", R.drawable.ic_baseline_person_24, 4.9f, "Nyeri"));
        lawyers.add(new Lawyer(20, "Eunice Wanjala", "Human Rights Lawyer", R.drawable.ic_baseline_person_24, 4.8f, "Bungoma"));

        lawyers.add(new Lawyer(21, "Alex Kipruto", "Criminal Defense Lawyer", R.drawable.ic_baseline_person_24, 4.6f, "Eldoret"));
        lawyers.add(new Lawyer(22, "Dorothy Wambui", "Family Lawyer", R.drawable.ic_baseline_person_24, 4.7f, "Nakuru"));
        lawyers.add(new Lawyer(23, "Ben Omondi", "Immigration Lawyer", R.drawable.ic_baseline_person_24, 4.8f, "Nairobi"));
        lawyers.add(new Lawyer(24, "Stella Muthoni", "Real Estate Lawyer", R.drawable.ic_baseline_person_24, 4.5f, "Kisumu"));
        lawyers.add(new Lawyer(25, "Joseph Mwakio", "Employment Lawyer", R.drawable.ic_baseline_person_24, 4.9f, "Mombasa"));
        lawyers.add(new Lawyer(26, "Rose Ngugi", "Tax Lawyer", R.drawable.ic_baseline_person_24, 4.6f, "Thika"));
        lawyers.add(new Lawyer(27, "Tom Adera", "Intellectual Property Lawyer", R.drawable.ic_baseline_person_24, 4.7f, "Kisii"));
        lawyers.add(new Lawyer(28, "Caroline Mutua", "Personal Injury Lawyer", R.drawable.ic_baseline_person_24, 4.8f, "Machakos"));
        lawyers.add(new Lawyer(29, "Hassan Ali", "Bankruptcy Lawyer", R.drawable.ic_baseline_person_24, 4.9f, "Nyeri"));
        lawyers.add(new Lawyer(30, "Winnie Atieno", "Human Rights Lawyer", R.drawable.ic_baseline_person_24, 4.7f, "Bungoma"));

// Repeat similar entries up to 100 lawyers

    }

    private void filterLawyers() {
        String locationQuery = searchLocation.getQuery().toString().toLowerCase();
        String typeQuery = searchType.getQuery().toString().toLowerCase();

        if (!filteredLawyers.isEmpty()) {
            filteredLawyers.clear();
        }

        for (Lawyer lawyer : lawyers) {
            boolean matchesLocation = lawyer.getLocation().toLowerCase().contains(locationQuery);
            boolean matchesType = lawyer.getSpecialty().toLowerCase().contains(typeQuery);

            if (matchesLocation && matchesType) {
                filteredLawyers.add(lawyer);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
