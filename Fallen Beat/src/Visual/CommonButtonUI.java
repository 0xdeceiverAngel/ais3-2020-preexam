/*    */ package Visual;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Cursor;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.RenderingHints;
/*    */ import javax.swing.AbstractButton;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ import javax.swing.plaf.basic.BasicButtonUI;
/*    */ 
/*    */ public class CommonButtonUI
/*    */   extends BasicButtonUI
/*    */ {
/*    */   public void installUI(JComponent c) {
/* 18 */     super.installUI(c);
/* 19 */     AbstractButton button = (AbstractButton)c;
/* 20 */     button.setOpaque(false);
/* 21 */     button.setBorder(new EmptyBorder(5, 15, 5, 15));
/* 22 */     button.setCursor(new Cursor(12));
/*    */   }
/*    */   
/*    */   public void paint(Graphics g, JComponent c) {
/*    */     int buttonEventStyleNum;
/* 27 */     AbstractButton b = (AbstractButton)c;
/*    */     
/* 29 */     if (b.getModel().isPressed()) {
/* 30 */       buttonEventStyleNum = 1;
/* 31 */     } else if (b.getModel().isRollover()) {
/* 32 */       buttonEventStyleNum = 2;
/*    */     } else {
/* 34 */       buttonEventStyleNum = 0;
/*    */     } 
/* 36 */     paintBackground(g, b, buttonEventStyleNum);
/* 37 */     super.paint(g, c);
/*    */   }
/*    */   
/*    */   private void paintBackground(Graphics g, JComponent c, int styleNumber) {
/* 41 */     Dimension size = c.getSize();
/* 42 */     Graphics2D g2 = (Graphics2D)g;
/* 43 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*    */     
/* 45 */     switch (styleNumber) {
/*    */       case 1:
/* 47 */         g.setColor(c.getBackground().brighter());
/* 48 */         g.fillRect(0, 0, size.width, size.height);
/* 49 */         g.setColor(c.getBackground().darker());
/* 50 */         g.fillRect(5, 5, size.width - 10, size.height - 10);
/*    */         return;
/*    */       case 2:
/* 53 */         g.setColor(Color.WHITE);
/* 54 */         g.fillRect(0, 0, size.width, size.height);
/* 55 */         g.setColor(c.getBackground());
/* 56 */         g.fillRect(5, 5, size.width - 10, size.height - 10);
/*    */         return;
/*    */     } 
/* 59 */     g.setColor(c.getBackground().brighter().brighter());
/* 60 */     g.fillRect(0, 0, size.width, size.height);
/* 61 */     g.setColor(c.getBackground());
/* 62 */     g.fillRect(5, 5, size.width - 10, size.height - 10);
/*    */   }
/*    */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/CommonButtonUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */