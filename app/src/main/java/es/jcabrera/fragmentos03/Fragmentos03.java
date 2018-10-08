package es.jcabrera.fragmentos03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class Fragmentos03 extends AppCompatActivity {

    private boolean bol = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragmentos03);

        final Fragmento1 fragmentUNO = new Fragmento1();
        final Fragmento2 fragmentDOS = new Fragmento2();
        FragmentTransaction FT1 = getSupportFragmentManager().beginTransaction();
        FT1.add(R.id.contenedor, fragmentUNO);
        FT1.commit();

        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                FragmentTransaction FT2 = getSupportFragmentManager().beginTransaction();
                if (bol) {
                    FT2.replace(R.id.contenedor, fragmentUNO);
                } else {
                    FT2.replace(R.id.contenedor, fragmentDOS);
                }
                FT2.addToBackStack(null);
                FT2.commit();

                bol = (bol) ? false : true;
            }
        });
    }
}
