/*    */ package Visual;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.LayoutManager;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ public class PanelGaming
/*    */   extends JPanel
/*    */ {
/* 14 */   private Image img = (new ImageIcon("images/Rail.png")).getImage(); public PanelGaming() {
/* 15 */     Dimension size = new Dimension(this.img.getWidth(null), this.img.getHeight(null));
/* 16 */     setPreferredSize(size);
/* 17 */     setMinimumSize(size);
/* 18 */     setMaximumSize(size);
/* 19 */     setSize(size);
/* 20 */     setLayout((LayoutManager)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void paintComponent(Graphics g) {
/* 25 */     g.drawImage(this.img, 0, 0, null);
/*    */   }
/*    */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/PanelGaming.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */