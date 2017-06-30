import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor{
  public static void main(String[] args) {
    ServerSocket server = null;
    try{
      server = new ServerSocket(31416);
    }
    catch(IOException e){
      System.out.println("Não foi possivel abrir a porta 31416");
      System.exit(1);
    }
    try{
      System.out.println("Porta 31416 aberta!");
      Socket player1=server.accept();
      Socket player2=server.accept();
      new Servindo(player1, 0).start();
      new Servindo(player2, 1).start();
    }
    catch(Exception e){
      System.out.println(e);
      System.exit(1);
    }
  }
}
