package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button btnInicio = findViewById(R.id.btnInicio);
    Button btnCancion = findViewById(R.id.btnCancion);
    Button btnFin = findViewById(R.id.btnFin);

    btnInicio.setOnClickListener(this);
    btnCancion.setOnClickListener(this);
    btnFin.setOnClickListener(this);


  }

  @Override
  public void onClick(View src) {
    Intent in;

    //APARTADO A
    switch (src.getId()) {
    case R.id.btnInicio:
      Toast.makeText(this, R.string.select, Toast.LENGTH_LONG).show();
      in = new Intent(this, ElServicio.class);
      in.putExtra(getString(R.string.mess), getString(R.string.selectSonido));
      startService(in);
      break;

     case R.id.btnCancion:
       Toast.makeText(this, R.string.select2, Toast.LENGTH_LONG).show();
       in = new Intent(this, ElServicio.class);
       in.putExtra(getString(R.string.mess), getString(R.string.selectCancion));
       startService(in);
       break;

      case R.id.btnFin:
       Toast.makeText(this, R.string.select3, Toast.LENGTH_LONG).show();
       stopService(new Intent(this, ElServicio.class));
       break;
    }
  }
}