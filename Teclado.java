import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.awt.event.*;

class Teclado extends KeyAdapter{
  Paint paint;
  JFrame janela;
  boolean boo=false;
  Teclado(Paint p, JFrame j){
    paint=p;
    janela=j;
  }
  @Override
  public void keyPressed(KeyEvent e){
    int x = e.getKeyCode();
    if(x==KeyEvent.VK_LEFT){
      if(paint.player1.x<=0){
        paint.player1.x=0;
      }
      paint.player1.x-=10;
      paint.cliente.EnviaNave(paint.player1.x);
    }
    else if(x==KeyEvent.VK_RIGHT){
      if(paint.player1.x>=435){
        paint.player1.x=445;
      }
      paint.player1.x+=10;
      paint.cliente.EnviaNave(paint.player1.x);
    }
    else if(x==KeyEvent.VK_SPACE){
      if(paint.tiro[0]==null){
        paint.tiro[0] = new Tiro(paint.player1.x+paint.nave.getWidth(null)/2-7, paint.player1.y-paint.tiro1.getHeight(null), paint.tiro1, paint);
      }
      else if(paint.tiro[1]==null){
        paint.tiro[1] = new Tiro(paint.player1.x+paint.nave.getWidth(null)/2-7, paint.player1.y-paint.tiro1.getHeight(null), paint.tiro1, paint);
      }
      else if(paint.tiro[2]==null){
        paint.tiro[2] = new Tiro(paint.player1.x+paint.nave.getWidth(null)/2-7, paint.player1.y-paint.tiro1.getHeight(null), paint.tiro1, paint);
      }
    }
    else if(x==KeyEvent.VK_ENTER){
      paint.inicio=true;
    }
  }
}
