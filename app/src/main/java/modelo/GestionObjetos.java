package modelo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import Javabean.Objeto;

/**
 * Created by USUARIO on 10/04/2017.
 */

public class GestionObjetos {
    String host="192.168.1.33";
    int puerto=9000;
    public ArrayList<Objeto> recuperarObjetos(){
        ArrayList<Objeto> objetos=new ArrayList<>();
        try{
            String cad=""; //contendra la cadena JSON
            String s;
            Socket sc = new Socket(host, puerto);
            BufferedReader bf=new BufferedReader(new InputStreamReader((sc.getInputStream())));
            while((s=bf.readLine())!=null){
                cad+=s;
            }
            //creamos el objeto JSONArray a traves de la cadena JSON recibida
            JSONArray jarray= new JSONArray(cad);
            //recorremos el array y por cada objeto json de ese array
            //creamos un objeto
            for(int i=0;i<jarray.length();i++){
                JSONObject job=jarray.getJSONObject(i);
                Objeto obj=new Objeto(job.getString("nombre"),job.getDouble("longitud"),job.getDouble("latitud"));
                objetos.add(obj);
            }
            sc.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return objetos;
    }
}
