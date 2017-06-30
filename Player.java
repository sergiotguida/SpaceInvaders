import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.awt.geom.Rectangle2D;

public class Player{
  int x, x2, y;
  Image img;
  Paint paint;
  Player(int a, int b, Image imagem, Paint pinta){
    x=a;
    x2=a;
    y=b;
    img=imagem;
    paint=pinta;
  }
}
