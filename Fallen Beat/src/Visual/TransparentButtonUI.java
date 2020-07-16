/*    */ package Visual;
/*    */ 
/*    */ import java.awt.Cursor;
/*    */ import javax.swing.AbstractButton;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ import javax.swing.plaf.basic.BasicButtonUI;
/*    */ 
/*    */ public class TransparentButtonUI
/*    */   extends BasicButtonUI
/*    */ {
/*    */   public void installUI(JComponent c) {
/* 13 */     super.installUI(c);
/* 14 */     AbstractButton button = (AbstractButton)c;
/* 15 */     button.setOpaque(false);
/* 16 */     button.setBorder(new EmptyBorder(5, 15, 5, 15));
/* 17 */     button.setCursor(new Cursor(12));
/*    */   }
/*    */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/TransparentButtonUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */