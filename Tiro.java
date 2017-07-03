import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class Tiro implements ActionListener{
  int x, y=0;
  Paint paint;
  Image img;
  int v=12;
  int indice;
  int vetor;
  boolean existe=false;
  boolean eliminado=false;
  Rectangle2D.Float hitbox =  new Rectangle2D.Float(x, y+5, 5,15);
  Timer timer = new Timer(75, this);
  Tiro(int a, int b, Image imagem, Paint p){
    x=a;
    y=b;
    img=imagem;
    paint=p;
    timer.start();
  }
  public void actionPerformed(ActionEvent e){
    int i;
    y-=v;
    paint.repaint();
    hitbox.y=y+5;
    hitbox.x=x;
    if(y<-img.getHeight(null))
      existe=true;
    for(i=0; i<6; i++){
      if(paint.ini1[i]!=null && paint.ini1[i].hitbox.intersects(hitbox)){
        eliminado=true;
        indice=i;
        vetor=1;
      }
      else if(paint.ini2[i]!=null && paint.ini2[i].hitbox.intersects(hitbox)){
        eliminado=true;
        indice=i;
        vetor=2;
      }
      else if(paint.ini3[i]!=null && paint.ini3[i].hitbox.intersects(hitbox)){
        eliminado=true;
        indice=i;
        vetor=3;
      }
    }
    if(existe || eliminado){
      if(paint.tiro[0]!=null && paint.tiro[0].equals(this)){
        timer.stop();
        paint.tiro[0]=null;
      }
      else if(paint.tiro[1]!=null && paint.tiro[1].equals(this)){
        timer.stop();
        paint.tiro[1]=null;
      }
      else if(paint.tiro[2]!=null && paint.tiro[2].equals(this)){
        timer.stop();
        paint.tiro[2]=null;
      }
      if(eliminado){
        if(vetor==1){
          Cliente.ini1[indice]=false;
          paint.ini1[indice]=null;
        }
        else if(vetor==2){
          Cliente.ini2[indice]=false;
          paint.ini2[indice]=null;

        }
        else if(vetor==3){
          Cliente.ini3[indice]=false;
          paint.ini3[indice]=null;

        }
        paint.cont--;
      }
      existe=false;
      eliminado=false;
    }
  }
}
