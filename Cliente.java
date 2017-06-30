import java.net.*;
import java.io.*;

public class Cliente extends Thread{
  Socket cliente = null;
  static DataInputStream recebe = null;
  static DataOutputStream envia = null;
  int idjogador;
  int Posxn;
  int Posxt1, Posyt1;
  int Posxt2, Posyt2;
  int Posxna;
  int Posxt1a, Posyt1a;
  int Posxt2a, Posyt2a;
  static boolean ini1[] = new boolean[6];
  static boolean ini2[] = new boolean[6];
  static boolean ini3[] = new boolean[6];

  public Cliente(){
    for(int i=0; i < 6; i++){
      ini1[i] = true;
      ini2[i] = true;
      ini3[i] = true;
    }
  }
  public int RecebePlayerID(){
    return idjogador;
  }
  public void EnviaNave(int x){
    Posxn=x;
  }
  public void EnviaTiro1(int x, int y){
    Posxt1=x;
    Posyt1=y;
  }
  public void EnviaTiro2(int x, int y){
    Posxt2=x;
    Posyt2=y;
  }
  public int RecebeNave(){
    return Posxna;
  }
  public int RecebeTiro1x(){
    return Posxt1a;
  }
  public int RecebeTiro1y(){
    return Posyt1a;
  }
  public int RecebeTiro2x(){
    return Posxt2a;
  }
  public int RecebeTiro2y(){
    return Posyt2a;
  }
  public void run(){
    try{
      cliente = new Socket("127.0.0.1", 31416);
      recebe = new DataInputStream(cliente.getInputStream());
      envia = new DataOutputStream(cliente.getOutputStream());
      idjogador = recebe.readInt();
      do{
        envia.writeInt(Posxn);
        envia.writeInt(Posxt1);
        envia.writeInt(Posyt1);
        envia.writeInt(Posxt2);
        envia.writeInt(Posyt2);
        for(int i = 0; i < 6; i++){
          envia.writeBoolean(ini1[i]);
          envia.writeBoolean(ini2[i]);
          envia.writeBoolean(ini3[i]);
          sleep(5);
        }
        Posxna=recebe.readInt();
        Posxt1a=recebe.readInt();
        Posyt1a=recebe.readInt();
        Posxt2a=recebe.readInt();
        Posyt2a=recebe.readInt();
        for(int i = 0; i < 6; i++){
          ini1[i] = recebe.readBoolean();
          ini2[i] = recebe.readBoolean();
          ini3[i] = recebe.readBoolean();
          sleep(5);
        }
      }
      while(true);
    }
    catch(Exception e){}
  }
}
