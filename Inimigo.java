import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class Inimigo{
  int x, y;
  Image img;
  Paint paint;
  Rectangle2D.Float hitbox;
  Inimigo(int a, int b, Image imagem, Paint p){
    img=imagem;
    x=a;
    y=b;
    hitbox = new Rectangle2D.Float(x, y, img.getWidth(null), img.getHeight(null));
    paint=p;
  }
}
