package com.example.configureddialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout lL;
    AlertDialog.Builder adb;
    final String [] COLORS = {"RED","GREEN","BLUE"};
    int [] color ;
    Intent si;
    AlertDialog.Builder adb2;
    AlertDialog.Builder adb3;
    AlertDialog.Builder adb4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lL =findViewById(R.id.lL);
        adb = new AlertDialog.Builder(this);
        adb2 = new AlertDialog.Builder(this);
        adb3 = new AlertDialog.Builder(this);
        adb4 = new AlertDialog.Builder(this);
    }

    public void primers(View view) {
        color = new int[] {0,0,0};
        adb.setTitle("primers - one choice");
        adb.setItems(COLORS, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 255;
                lL.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));

            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void CombinedColors(View view) {
        color = new int[] {0,0,0};
        adb2.setTitle("primers - one choice");
        adb2.setMultiChoiceItems(COLORS,null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                if(b)color[i]=255;
                else if(color[i]==255)color[i]=0 ;

            }

        });
        adb2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                lL.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        AlertDialog ad = adb2.create();
        ad.show();
    }

    public void WhiteColor(View view) {
        adb3.setTitle("RESET");
        adb3.setPositiveButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                lL.setBackgroundColor(Color.WHITE);
            }
        });
        AlertDialog ad = adb3.create();
        ad.show();
    }

    public void text(View view) {
        adb4.setTitle("TEXT");
        EditText eT = new EditText(this);
        eT.setHint("Type text");
        adb4.setView(eT);
        adb4.setPositiveButton("copy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String st  = eT.getText().toString();
                Toast.makeText(MainActivity.this,st,Toast.LENGTH_SHORT).show();
            }
        });
        adb4.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad = adb4.create();
        ad.show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(0, 0, 100, "Credits");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str = menuItem.getTitle().toString();

        if (str.equals("Credits")) {
            Intent si = new Intent(this, MainActivity2.class);
            startActivity(si);
        }
        return true;
    }
}