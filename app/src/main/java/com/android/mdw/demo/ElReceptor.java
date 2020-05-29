package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ElReceptor extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, ElServicio.class);

        if (intent.getAction() == null) {

            Bundle data = intent.getExtras();
            String so = data.getString(context.getString(R.string.mess));

            if (so.equals(context.getString(R.string.selectSonido))) {
                Toast.makeText(context, R.string.BcasMessSon, Toast.LENGTH_LONG).show();
                context.startService(intent);
            } else if (so.equals(context.getString(R.string.selectCancion))) {
                Toast.makeText(context, R.string.BcasMessCan, Toast.LENGTH_LONG).show();
                context.startService(intent);
            } else if (so.equals(context.getString(R.string.selectDetencion))) {
                Toast.makeText(context, R.string.BcasMessDet, Toast.LENGTH_LONG).show();
                context.stopService(intent);
            }
        }
    }
}