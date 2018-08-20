package com.kulina.preliminarytest.kulinapreliminarytest;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalculateFees extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    TextView tv_counter;
    TextView tv_dyn_rincian1;
    TextView tv_dyn_rincian2;
    TextView tv_dyn_rincian3;
    TextView tv_dyn_rincian4;
    TextView tv_price1;
    TextView tv_price2;
    TextView tv_price3;
    RelativeLayout rl_paket1;
    RelativeLayout rl_paket2;
    RelativeLayout rl_paket3;
    RelativeLayout rl_paket4;
    ImageButton ibtn_minus;
    ImageButton ibtn_plus;
    ImageView imageV;
    CalendarView cldr_schedule;
    Date currentTime;
    Calendar calendar;
    long initPrice;
    int counter = 1;
    String formatFloat;
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_fees);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collaps_toolbar);
        collapsingToolbarLayout.setTitle("Mulai Langganan");
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        tv_counter = (TextView) findViewById(R.id.tv_counter);
        tv_dyn_rincian1 = (TextView) findViewById(R.id.tv_dyn_rincian1);
        tv_dyn_rincian2 = (TextView) findViewById(R.id.tv_dyn_rincian2);
        tv_dyn_rincian3 = (TextView) findViewById(R.id.tv_dyn_rincian3);
        tv_dyn_rincian4 = (TextView) findViewById(R.id.tv_dyn_rincian4);
        tv_price1 = (TextView) findViewById(R.id.tv_price1);
        tv_price2 = (TextView) findViewById(R.id.tv_price2);
        tv_price3 = (TextView) findViewById(R.id.tv_price3);
        initPrice = Integer.parseInt(getIntent().getExtras().getString("PackagePrice"));
        formatFloat = numberFormat.format(initPrice);
        tv_dyn_rincian1.setText("Rp " + formatFloat);
        tv_price1.setText(numberFormat.format(initPrice * 0.9) + "/hari");
        tv_price2.setText(numberFormat.format(initPrice * 0.97) + "/hari");
        tv_price3.setText(formatFloat + "/hari");

        rl_paket4 = (RelativeLayout) findViewById(R.id.rl_paket4);
    }

    public void countInc(View view) {
        counter++;
        tv_counter.setText(Integer.toString(counter));
    }

    public void countDec(View view) {
        if (counter > 1)
            counter--;
        tv_counter.setText(Integer.toString(counter));
    }

    public void onClick_rl_paket1 (View view) {
        int paket = 20;
        double calc;
        tv_dyn_rincian2.setText(paket * counter + " Box");
        tv_dyn_rincian3.setText(paket + " Hari");
        calc = (initPrice * 0.9) * (paket * counter);
        tv_dyn_rincian4.setText(numberFormat.format(calc));
        tv_dyn_rincian4.requestFocus();
    }

    public void onClick_rl_paket2 (View view) {
        int paket = 10;
        double calc;
        tv_dyn_rincian2.setText(paket * counter + " Box");
        tv_dyn_rincian3.setText(paket + " Hari");
        calc = (initPrice * 0.97) * (paket * counter);
        tv_dyn_rincian4.setText(numberFormat.format(calc));
        tv_dyn_rincian4.requestFocus();
    }

    public void onClick_rl_paket3 (View view) {
        int paket = 5;
        double calc;
        tv_dyn_rincian2.setText(paket * counter + " Box");
        tv_dyn_rincian3.setText(paket + " Hari");
        calc = initPrice * (paket * counter);
        tv_dyn_rincian4.setText(numberFormat.format(calc));
        tv_dyn_rincian4.requestFocus();
    }

    public void onClick_rl_paket4 (View view) {
        int paket = 2;
        double calc;
        tv_dyn_rincian2.setText(paket * counter + " Box");
        tv_dyn_rincian3.setText(paket + " Hari");
        calc = initPrice * (paket * counter);
        tv_dyn_rincian4.setText(numberFormat.format(calc));
        tv_dyn_rincian4.requestFocus();
    }
}
