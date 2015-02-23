package com.example.eric.fragmentexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    int swap = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Button
        Button switchButton = (Button) findViewById(R.id.button);

        //Get reference to activity fragment manager.
        FragmentManager manager = getFragmentManager();

        //Reference fragment transaction
        final FragmentTransaction transaction = manager.beginTransaction();

        //Create two new frag objects by instantiating the two classes

        FragmentOne fragOne = new FragmentOne();
        FragmentTwo fragTwo = new FragmentTwo();

        //add two fragments to the transaction
        transaction.add(R.id.fragView, fragOne, "Fragment One");
        transaction.add(R.id.fragView, fragTwo, "Fragment Two");

        //commit transactions
        transaction.commit();

        switchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (swap == 1){
                    transaction.replace(R.id.fragView, fragTwo, "Fragment Two");
                    transaction.add(R.id.fragView, fragOne, "Fragment One");
                    swap = 0;
                }
                else if (swap == 0){
                    transaction.replace(R.id.fragView,fragOne,"Fragment One");
                    transaction.add(R.id.fragView, fragTwo, "Fragment Two");
                    swap = 1;
                }
                transaction.commit();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
