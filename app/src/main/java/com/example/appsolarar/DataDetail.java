package com.example.appsolarar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsolarar.model.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DataDetail extends AppCompatActivity {
    private String pId="",downloadImageUrl;
    private TextView pName,pDesc,pPrice;
    private ImageView PImage;
    private Uri imageUri;
    private String datarefs;
    private FloatingActionButton floatingActionButton;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_detail);
        pId=getIntent().getStringExtra("pid");
        datarefs=getIntent().getStringExtra("datarefs");
        floatingActionButton=findViewById(R.id.speech_btn);
        pName=(TextView)findViewById(R.id.product_title_detail);
        pDesc=(TextView)findViewById(R.id.product_desc_detail);
        PImage=(ImageView)findViewById(R.id.product_img_detail);
        getProductsDetails(pId);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = pDesc.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    private void getProductsDetails(String pId) {
        DatabaseReference productref= FirebaseDatabase.getInstance().getReference().child(datarefs);
        productref.child(pId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    Data products=dataSnapshot.getValue(Data.class);
                    // ddsds//
                    Picasso.get().load(products.getImage()).into(PImage);
                    pName.setText(products.getPName());
                    pDesc.setText(products.getDescription());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}