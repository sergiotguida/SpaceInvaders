import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import javax.swing.Timer;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import java.util.*;
import java.awt.event.*;

public class Paint extends JPanel{
  int xp=90, yp=610, x2p=330;
  int i;
  int x, y;
  int cont=18;
  Graphics2D g2d;
  Image fundo1;
  Image fundo2;
  Image nave;
  Image nave2;
  Image inimigo1;
  Image inimigo2;
  Image inimigo3;
  Image tiro1;
  Image tiro2;
  boolean termina=false;
  boolean inicio=false;
  int posX=0, posY=0, posY2=-700;
  Tiro[] tiro = new Tiro[3];
  Player player1;
  Player player2;
  Inimigo[] ini1 = new Inimigo[6];
  Inimigo[] ini2 = new Inimigo[6];
  Inimigo[] ini3 = new Inimigo[6];
  ArrayList <Base> base = new ArrayList<>();
  Cliente cliente = new Cliente();
  Timer time = new Timer(40, new ActionListener(){
    @Override
    public void actionPerformed (ActionEvent e) {

      repaint();

    }
  });
  Paint(){
    super(true);
    time.start();
    cliente.start();
    if(cliente.RecebePlayerID()==0){
      player1 = new Player(xp, yp, nave, this);
      player2 = new Player(x2p, yp, nave2, this);
    }
    else{
      player1 = new Player(x2p, yp, nave2, this);
      player2 = new Player(xp, yp, nave, this);
    }
    try{
      fundo1=ImageIO.read(new File("Imagens/stars-carousel.jpg"));
      fundo2=ImageIO.read(new File("Imagens/stars-carousel.jpg"));
      nave=ImageIO.read(new File("Imagens/SpaceInvadersNave.png"));
      nave2=ImageIO.read(new File("Imagens/SpaceInvadersNave2.png"));
      inimigo1=ImageIO.read(new File("Imagens/SpaceInvadersEnemy1.png"));
      inimigo2=ImageIO.read(new File("Imagens/SpaceInvadersEnemy2.png"));
      inimigo3=ImageIO.read(new File("Imagens/SpaceInvadersEnemy3.png"));
      tiro1=ImageIO.read(new File("Imagens/Tiro1.png"));
      tiro2=ImageIO.read(new File("Imagens/Tiro2.png"));
    }
    catch(IOException e){
      System.out.println("Erro ao carregar imagem!");
      System.exit(1);
    }
    base.add(new Base(0, 0, this, fundo1));
    for(i=0; i<6; i++){
      ini1[i] = new Inimigo(80*i, 0, inimigo1, this);
      ini2[i] = new Inimigo(3+80*i, 50, inimigo2, this);
      ini3[i] = new Inimigo(10+80*i, 100, inimigo3, this);

    }
  }
  @Override
  public void paintComponent(Graphics g){
    update(g);
  }
  @Override
  public void update(Graphics g){
    g2d = (Graphics2D) g;
    if(!inicio)
      Wait(g2d);
    fundo(g);
    Nave(g);
    Inimigos(g);
    Tiro(g);
    if(cont==0){
      Final(g2d);
    }
  }
  public void Wait(Graphics g2d){
    g2d.setColor(new Color(0, 0, 0));
    g2d.fillRect(0, 0, 500, 700);
    g2d.setColor(new Color(0, 0, 0));
    g2d.setColor (new Color(0,255,0));
	  g2d.setFont(new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 25));
    g2d.drawString("Aperte enter para conectar!", 100, 350);
  }
  public void fundo(Graphics g){
    g.drawImage(fundo1, posX, posY, 500, 700, null);
    g.drawImage(fundo2, posX, posY2, 500, 700, null);
    if(posY==700){
      posY=-700;
    }
    if(posY2==700){
      posY2=-700;
    }
    posY++;
    posY2++;
    repaint();
    try{
      Thread.sleep(7);
    }
    catch(InterruptedException ex){
      System.out.println("Erro ao usar sleep!");
      System.exit(1);
    }
  }
  public void Nave(Graphics g){
    g.drawImage(nave, player1.x, player1.y, 55, 55, this);
    g.drawImage(nave2, player2.x2, player2.y, 55, 55, this);
  }
  public void Inimigos(Graphics g){
    g2d = (Graphics2D) g;
    int i;
    for(i=0; i<6; i++){
      if(Cliente.ini1[i]){
        g.drawImage(inimigo1, ini1[i].x, ini1[i].y, 45, 25, this);
      }
    }
    for(i=0; i<6; i++){
      if(Cliente.ini2[i]){
        g.drawImage(inimigo2, ini2[i].x, ini2[i].y, 38, 30, this);
      }
    }
    for(i=0; i<6; i++){
      if(Cliente.ini3[i]){
        g.drawImage(inimigo3, ini3[i].x, ini3[i].y, 23, 23, this);
      }
    }
  }
  public void Tiro(Graphics g){
    g2d = (Graphics2D) g;
    if(tiro[0]!=null){
      g.drawImage(tiro1, tiro[0].x, tiro[0].y, 5, 20, this);
    }
    if(tiro[1]!=null){
      g.drawImage(tiro1, tiro[1].x, tiro[1].y, 5, 20, this);
    }
    if(tiro[2]!=null){
      g.drawImage(tiro1, tiro[2].x, tiro[2].y, 5, 20, this);
    }
  }
  public void Final(Graphics2D g2d){
    g2d.setColor(new Color(0, 0, 0));
    g2d.fillRect(0, 0, 500, 700);
    g2d.setColor(new Color(250,250,250));
    g2d.setColor (new Color(0,255,0));
	  g2d.setFont(new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 30));
    g2d.drawString("Fim de Jogo!", 150, 350);
  }
}
