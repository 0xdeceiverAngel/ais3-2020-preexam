/*    */ package Visual;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class PanelMenu
/*    */   extends JPanel {
/* 14 */   MyColor c = new MyColor();
/* 15 */   ImageIcon logo = new ImageIcon("images/fallenBeatLogo.png");
/*    */   
/* 17 */   JPanel pBtnList = new JPanel(new GridLayout(4, 1));
/* 18 */   JLabel lLogo = new JLabel(this.logo);
/* 19 */   JLabel lNorth = new JLabel();
/* 20 */   JLabel lSouth = new JLabel();
/* 21 */   JLabel lEast = new JLabel();
/*    */   
/* 23 */   Font btnFont = new Font("Dialog", 1, 35);
/* 24 */   public JButton btnStart = new JButton("Start");
/* 25 */   public JButton btnHighScore = new JButton("High Score");
/* 26 */   public JButton btnHelp = new JButton("Help");
/* 27 */   public JButton btnExit = new JButton("Exit");
/*    */   
/*    */   public PanelMenu() {
/* 30 */     setLayout(new BorderLayout());
/* 31 */     setBackground(this.c.brown);
/*    */     
/* 33 */     this.lLogo.setPreferredSize(new Dimension(this.logo.getIconWidth() + 150, this.logo.getIconHeight()));
/* 34 */     add(this.lLogo, "West");
/*    */     
/* 36 */     this.lNorth.setPreferredSize(new Dimension(1280, 130));
/* 37 */     add(this.lNorth, "North");
/* 38 */     this.lSouth.setPreferredSize(new Dimension(1280, 130));
/* 39 */     add(this.lSouth, "South");
/* 40 */     this.lEast.setPreferredSize(new Dimension(100, 720));
/* 41 */     add(this.lEast, "East");
/*    */     
/* 43 */     this.btnStart.setUI(new MenuButtonUI());
/* 44 */     this.btnStart.setBackground(this.c.gray);
/* 45 */     this.btnStart.setFont(this.btnFont);
/* 46 */     this.btnStart.setForeground(this.c.white);
/* 47 */     this.pBtnList.add(this.btnStart);
/*    */     
/* 49 */     this.btnHighScore.setUI(new MenuButtonUI());
/* 50 */     this.btnHighScore.setBackground(this.c.gray);
/* 51 */     this.btnHighScore.setFont(this.btnFont);
/* 52 */     this.btnHighScore.setForeground(this.c.white);
/* 53 */     this.pBtnList.add(this.btnHighScore);
/*    */     
/* 55 */     this.btnHelp.setUI(new MenuButtonUI());
/* 56 */     this.btnHelp.setBackground(this.c.gray);
/* 57 */     this.btnHelp.setFont(this.btnFont);
/* 58 */     this.btnHelp.setForeground(this.c.white);
/* 59 */     this.pBtnList.add(this.btnHelp);
/*    */     
/* 61 */     this.btnExit.setUI(new MenuButtonUI());
/* 62 */     this.btnExit.setBackground(this.c.gray);
/* 63 */     this.btnExit.setFont(this.btnFont);
/* 64 */     this.btnExit.setForeground(this.c.white);
/* 65 */     this.pBtnList.add(this.btnExit);
/*    */     
/* 67 */     this.pBtnList.setBackground(this.c.brown);
/* 68 */     add(this.pBtnList, "Center");
/*    */   }
/*    */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/PanelMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */