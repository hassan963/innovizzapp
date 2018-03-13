package innovizz.ecommerce.medicalremind;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import innovizz.ecommerce.medicalremind.fragment.AddMedicineFragment;
import innovizz.ecommerce.medicalremind.fragment.HomeFragment;
import innovizz.ecommerce.medicalremind.fragment.AlarmFragment;
import innovizz.ecommerce.medicalremind.fragment.ProfileFragment;
import innovizz.ecommerce.medicalremind.fragment.TipsFragment;

/*
*
* Hassan M Ashraful ID: 102015
* */


public class MainActivity extends AppCompatActivity {

/*
* Changing  fragment by calling changeFragment() with position parameter
*
* */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(0);
                    return true;
                case R.id.navigation_profile:
                    changeFragment(1);
                    return true;
                case R.id.navigation_alarm:
                    changeFragment(2);
                    return true;
                case R.id.navigation_tips:
                    changeFragment(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFragment(0); //for first time setup fragment

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    /**
     * Loadig Fragment
     *
     */
    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == 0) {
            newFragment = new HomeFragment();
        } else if (position == 1) {
            newFragment = new ProfileFragment();
        } else if (position == 2){
            newFragment = new AlarmFragment();
        }
        else {
            newFragment = new TipsFragment();
        }

        //inflating fragment, fragment support version
        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragmentContainer, newFragment)
                .commit();
    }

}
