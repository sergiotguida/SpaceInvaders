import java.net.*;
import java.io.*;

class Servindo extends Thread{
  Socket cliente;
  static DataOutputStream envia[] = new DataOutputStream[2];
  static DataInputStream recebe[] = new DataInputStream[2];
  int idjogador;
  static int ready=0;
  boolean start=false;
  private int Posxn, Posyn;
  private int Posxt1, Posyt1;
  private int Posxt2, Posyt2;
  static boolean ini1[] = new boolean[3];
  static boolean ini2[] = new boolean[3];
  static boolean ini3[] = new boolean[3];
  Servindo(Socket cliente, int idjogador){
    this.cliente = cliente;
    this.idjogador = idjogador;
  }
  public void run(){
    try{
      recebe[idjogador] = new DataInputStream(cliente.getInputStream());
      envia[idjogador] = new DataOutputStream(cliente.getOutputStream());
    }
    catch(IOException e){
      System.out.println(e);
      System.exit(1);
    }
    try{
      envia[idjogador].writeInt(idjogador);
      do{
        Posxn=recebe[idjogador].readInt();
        Posxt1=recebe[idjogador].readInt();
        Posyt1=recebe[idjogador].readInt();
        Posxt2=recebe[idjogador].readInt();
        Posyt2=recebe[idjogador].readInt();
        for(int i = 0; i < 6; i++){
          ini1[i] = recebe[idjogador].readBoolean();
          ini2[i] = recebe[idjogador].readBoolean();
          ini3[i] = recebe[idjogador].readBoolean();
          sleep(5);
        }
        if(idjogador==0){
          envia[1].writeInt(Posxn);
          envia[1].writeInt(Posxt1);
          envia[1].writeInt(Posyt1);
          envia[1].writeInt(Posxt2);
          envia[1].writeInt(Posyt2);
          for(int i = 0; i < 6; i++){
            envia[1].writeBoolean(ini1[i]);
            envia[1].writeBoolean(ini2[i]);
            envia[1].writeBoolean(ini3[i]);
            sleep(5);
          }
        }
        else{
          envia[0].writeInt(Posxn);
          envia[0].writeInt(Posxt1);
          envia[0].writeInt(Posyt1);
          envia[0].writeInt(Posxt2);
          envia[0].writeInt(Posyt2);
          for(int i = 0; i < 6; i++){
            envia[0].writeBoolean(ini1[i]);
            envia[0].writeBoolean(ini2[i]);
            envia[0].writeBoolean(ini3[i]);
            sleep(5);
          }
        }
      }
      while(true);
    }
    catch(IOException e){
      System.out.println(e);
    }
    catch(InterruptedException ex){
      System.out.println(ex);
    }
  }
}
