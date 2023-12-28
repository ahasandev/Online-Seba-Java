package com.company.districtseba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Service_5 extends AppCompatActivity {


  public String num="";
  ImageView back;
  LottieAnimationView  Fire1,Fire2,Fire3,Fire4,Fire5,Fire6;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service5);


        Fire1=findViewById(R.id.Fire1);
        Fire2=findViewById(R.id.Fire2);
        Fire3=findViewById(R.id.Fire3);
        Fire4=findViewById(R.id.Fire4);
        Fire5=findViewById(R.id.Fire5);
        Fire6=findViewById(R.id.Fire6);

        back=findViewById(R.id.back5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Service_5.super.onBackPressed();

            }
        });



        //=======================================================================//




        //==============================Fire service=============================================//
        Fire1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01901-023251";
                callPhoneNumber();
            }
        });
        Fire2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01901-023275";
                callPhoneNumber();
            }
        });
        Fire3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01901-023263";
                callPhoneNumber();
            }
        });
        Fire4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01901-023283";
                callPhoneNumber();
            }
        });
        Fire5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01901-023259";
                callPhoneNumber();
            }
        });
        Fire6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01730-009122";
                callPhoneNumber();
            }
        });

        //================================end====================================================//


    }



    //......................call method.....................//

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if(requestCode == 101)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhoneNumber();
            }
        }
    }

    public void callPhoneNumber()
    {
        try
        {
            if(Build.VERSION.SDK_INT > 22)
            {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Service_5.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);

            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //==================================================================================//



}