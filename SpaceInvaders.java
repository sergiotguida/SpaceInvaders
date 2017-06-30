import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.util.*;

class SpaceInvaders{
  JFrame janela = new JFrame("Space Invaders");
  public static void main(String[] args){
    SpaceInvaders var = new SpaceInvaders();
    Paint paint = new Paint();
    var.janela.setSize(new Dimension(500, 700));
    var.janela.setResizable(false);
    var.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    var.janela.add(paint);
    var.janela.addKeyListener(new Teclado(paint, var.janela));
    var.janela.setVisible(true);
  }
}
