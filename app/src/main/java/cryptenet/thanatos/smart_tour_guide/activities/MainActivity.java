package cryptenet.thanatos.smart_tour_guide.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cryptenet.thanatos.smart_tour_guide.MainApplication;
import cryptenet.thanatos.smart_tour_guide.R;
import cryptenet.thanatos.smart_tour_guide.fragments.HomeFragment;
import cryptenet.thanatos.smart_tour_guide.fragments.ResultFragment;
import cryptenet.thanatos.util.AppInfo;
import cryptenet.thanatos.util.DialogUtil;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.onSearchButtonPressedListener,ResultFragment.onListItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        viewBinder();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setNavigationView();
        navigationView.getMenu().getItem(0).setChecked(true);
        getFragment(new HomeFragment());

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void viewBinder() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    private void setNavigationView() {
        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void getFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_container, fragment);
            ft.commit();
        }
    }

    @Override
    public void onSearchButtonPressed(Bundle bundle) {
        ResultFragment fragment = new ResultFragment();
        fragment.setArguments(bundle);
        getFragment(fragment);
    }

    @Override
    public void onListItemSelected() {

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogUtil.showMessageAbout(MainActivity.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                getFragment(new HomeFragment());
                break;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
