package ejercicio40.a40_comunicacion_servicio;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import modelo.GestionObjetos;

public class ServicioComunicacion extends Service {
    Timer timer;
    public ServicioComunicacion() {
    }

    @Override
    public IBinder onBind(Intent intent) {
    return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer=new Timer();
        timer.schedule(new ActualizarDatos(),0,400);
        return Service.START_STICKY;

    }

    @Override
    public void onDestroy() {
        timer.cancel();
    }

    class ActualizarDatos extends TimerTask {
        @Override
        public void run() {
            GestionObjetos gobj=new GestionObjetos();
            MainActivity.manejador.obtainMessage(0,gobj.recuperarObjetos()).sendToTarget();
        }
    }


}
