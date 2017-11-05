package com.myhexaville.androidanimatedcolor;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AnimatedColor oneToTwo = new AnimatedColor(ContextCompat.getColor(this, R.color.intro_page_one), ContextCompat.getColor(this, R.color.intro_page_two));
        final AnimatedColor twoToThree = new AnimatedColor(ContextCompat.getColor(this, R.color.intro_page_two), ContextCompat.getColor(this, R.color.intro_page_three));
        final AnimatedColor threeToFour = new AnimatedColor(ContextCompat.getColor(this, R.color.intro_page_three), ContextCompat.getColor(this, R.color.intro_page_four));

        pager = findViewById(R.id.pager);
        pager.setAdapter(new Adapter(getSupportFragmentManager()));

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        pager.setBackgroundColor(oneToTwo.with(positionOffset));
                        break;
                    case 1:
                        pager.setBackgroundColor(twoToThree.with(positionOffset));
                        break;
                    case 2:
                        pager.setBackgroundColor(threeToFour.with(positionOffset));
                        break;
                    case 3:
                        pager.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.intro_page_four));
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }
}
