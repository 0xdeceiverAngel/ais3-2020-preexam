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
/*    */ public class PanelHelp
/*    */   extends JPanel {
/* 14 */   MyColor c = new MyColor();
/*    */   
/* 16 */   JPanel pCenter = new JPanel(new GridLayout(1, 2));
/* 17 */   JPanel pSouth = new JPanel();
/* 18 */   JPanel pNorth = new JPanel();
/* 19 */   JLabel lWest = new JLabel();
/* 20 */   JLabel lEast = new JLabel();
/*    */   
/* 22 */   ImageIcon help1 = new ImageIcon("images/Help/help_1.png");
/* 23 */   ImageIcon help2 = new ImageIcon("images/Help/help_2.png");
/*    */   
/* 25 */   Font btnFont = new Font("Dialog", 1, 35);
/* 26 */   public JButton btnBack = new JButton("Back");
/* 27 */   public JButton btnHell = new JButton();
/*    */   
/*    */   public PanelHelp() {
/* 30 */     setLayout(new BorderLayout());
/* 31 */     setBackground(this.c.brown);
/*    */     
/* 33 */     this.lEast.setPreferredSize(new Dimension(100, 720));
/* 34 */     add(this.lEast, "East");
/* 35 */     this.lWest.setPreferredSize(new Dimension(100, 720));
/* 36 */     add(this.lWest, "West");
/*    */     
/* 38 */     this.btnHell.setUI(new TransparentButtonUI());
/* 39 */     this.btnHell.setBackground(this.c.gray);
/* 40 */     this.btnHell.setFont(this.btnFont);
/* 41 */     this.btnHell.setForeground(this.c.white);
/* 42 */     this.btnHell.setPreferredSize(new Dimension(150, 70));
/* 43 */     this.pNorth.add(this.btnHell);
/* 44 */     this.pNorth.setPreferredSize(new Dimension(1280, 100));
/* 45 */     this.pNorth.setBackground(this.c.brown);
/* 46 */     add(this.pNorth, "North");
/*    */     
/* 48 */     this.btnBack.setUI(new CommonButtonUI());
/* 49 */     this.btnBack.setBackground(this.c.gray);
/* 50 */     this.btnBack.setFont(this.btnFont);
/* 51 */     this.btnBack.setForeground(this.c.white);
/* 52 */     this.btnBack.setPreferredSize(new Dimension(150, 70));
/* 53 */     this.pSouth.add(this.btnBack);
/* 54 */     this.pSouth.setPreferredSize(new Dimension(1280, 100));
/* 55 */     this.pSouth.setBackground(this.c.brown);
/* 56 */     add(this.pSouth, "South");
/*    */     
/* 58 */     this.pCenter.add(new JLabel(this.help1));
/* 59 */     this.pCenter.add(new JLabel(this.help2));
/* 60 */     this.pCenter.setBackground(this.c.yellow);
/* 61 */     add(this.pCenter, "Center");
/*    */   }
/*    */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/PanelHelp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */