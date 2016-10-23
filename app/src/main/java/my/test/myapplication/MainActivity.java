package my.test.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static my.test.myapplication.R.layout.frag1;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    static CustomAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Agregamos el Toolbar
        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

    }

    private class CustomAdapter extends FragmentPagerAdapter {

        private String fragments[] = {"Cartelera", "Mis Reservas"};

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }

    }

    public void actualizar(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("MainActivity", "Mirame**************************************************");
        adapter2.onActivityResult(requestCode, resultCode, data);
    }

}