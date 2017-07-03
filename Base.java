import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;

class Base{
  int x, y;
  Image img;
  Shape hitbox=null;
  Paint paint;
  Base(int posX, int posY, Paint pinta, Image imagem){
    x=posX;
    y=posY;
    img=imagem;
    paint=pinta;
  }
}
