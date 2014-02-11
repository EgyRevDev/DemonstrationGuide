package com.showair.Demonstratorguide;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void advices_handler(View view){
        //Toast.makeText(this,"Advices button is pressed", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, AdvicesActivity.class);
        startActivity(intent);


    }

    public void rights_handler(View view){
        /*Toast.makeText(this,"Rights button is pressed", Toast.LENGTH_LONG).show();*/
        Intent intent = new Intent(this, RightsActivity.class);
        startActivity(intent);
    }

    public void faqs_handler(View view){
        /*Toast.makeText(this,"FAQs button is pressed", Toast.LENGTH_LONG).show();*/
        Intent intent = new Intent(this, FaqsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }

        if (id == R.id.action_about) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
