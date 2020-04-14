package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class ElServicio extends Service {

	private MediaPlayer player;
	private MediaPlayer player1;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show();
		player = MediaPlayer.create(this, R.raw.train);
		player.setLooping(true);
		player1 = MediaPlayer.create(this, R.raw.bob_marley_cybl);
		player1.setLooping(true);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show();
		player.stop();
		player1.stop();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		Toast.makeText(this, R.string.iniserv, Toast.LENGTH_LONG).show();
		
		Bundle data = intent.getExtras();
		String so = data.getString(getString(R.string.mess));

		if(so.equals(getString(R.string.selectSonido))) {
			player.start();
		}else if (so.equals(getString(R.string.selectCancion))){
			player1.start();
		}
		return startid;		
	}	

}
