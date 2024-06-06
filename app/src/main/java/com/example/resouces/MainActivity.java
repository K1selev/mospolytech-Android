package com.example.resouces;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.resouces.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RelativeLayout relativeLayout = new RelativeLayout(this);
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final LinearLayout mylayout = (LinearLayout)findViewById(R.id.root);
        final TextView mytext = (TextView) findViewById(R.id.my_text);
        int itId = item.getItemId();
        if (itId == R.id.red){
            mylayout.setBackgroundColor(getResources().getColor(R.color.red));
            return true;}
        else if (itId == R.id.green){
            mylayout.setBackgroundColor(getResources().getColor(R.color.green));
            return true;}
        else if (itId == R.id.blue){
            mylayout.setBackgroundColor(getResources().getColor(R.color.blue));
            return true;}
        else if (itId == R.id.firstImg){
            mylayout.setBackgroundResource(R.drawable.firstimg);
            return true;}
        else if (itId == R.id.secondImg){
            mylayout.setBackgroundResource(R.drawable.second_img);
            return true;}
        else if (itId == R.id.thirdImg){
            mylayout.setBackgroundResource(R.drawable.third_img);
            return true;}

        else if (itId == R.id.sans_serif){
            mytext.setTypeface(Typeface.SANS_SERIF,
                    Typeface.NORMAL);
            return true;}
        else if (itId == R.id.serif){
            mytext.setTypeface(Typeface.SERIF,
                    Typeface.NORMAL);
            return true;}
        else if (itId == R.id.monospace){
            mytext.setTypeface(Typeface.MONOSPACE,
                    Typeface.NORMAL);
            return true;}
        else if (itId == R.id.add) {
            TextView tv = new TextView(this);
            tv.setText(R.string.text);
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                    ((int) LinearLayout.LayoutParams.WRAP_CONTENT,(int) LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 50;
            params.topMargin  = 50;
            tv.setTextSize((float) 20);
            tv.setLayoutParams(params);
            mylayout.addView(tv);
            return true;
        }
        else if (itId == R.id.exit){
            finish();
            return true;}
        else return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}