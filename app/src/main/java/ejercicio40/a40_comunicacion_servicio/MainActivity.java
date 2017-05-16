package ejercicio40.a40_comunicacion_servicio;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Javabean.Objeto;

public class MainActivity extends AppCompatActivity {
    private static ListView lstObjetos;
    private static Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstObjetos=(ListView) this.findViewById(R.id.lstObjetos);
        ctx=this;
        Intent intent=new Intent(this,ServicioComunicacion.class);
        this.startService(intent);
    }


    public static Handler manejador=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //recogemos el dato enviado desde el hilo
            ArrayList<Objeto> dat=(ArrayList<Objeto>)msg.obj;
            ArrayAdapter adp=new ArrayAdapter(ctx, android.R.layout.simple_list_item_1,dat);
            lstObjetos.setAdapter(adp);

        }
    };
}
