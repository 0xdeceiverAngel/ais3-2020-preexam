/*     */ package Visual;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.GridLayout;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ public class PanelHell
/*     */   extends JPanel {
/*  20 */   MyColor c = new MyColor();
/*     */   
/*  22 */   JPanel pText = new JPanel(new GridLayout(10, 1));
/*  23 */   JLabel[] text = new JLabel[10];
/*     */   
/*  25 */   JPanel pHell = new JPanel(new BorderLayout());
/*     */   
/*  27 */   JPanel pCenter = new JPanel(new GridLayout(1, 2));
/*     */   
/*  29 */   JPanel pSouth = new JPanel();
/*  30 */   JLabel lNorth = new JLabel("Please turn off your Chinese Input Method.", 0);
/*  31 */   JLabel lWest = new JLabel();
/*  32 */   JLabel lEast = new JLabel();
/*     */   
/*  34 */   ImageIcon iconHell = new ImageIcon("songs/gekkou/gekkou_hell.png");
/*  35 */   JLabel lIcon = new JLabel(this.iconHell);
/*  36 */   JLabel lName = new JLabel("MoonLight Dance", 0);
/*  37 */   JPanel pBtn = new JPanel();
/*     */   
/*  39 */   Font btnFont = new Font("Dialog", 1, 35);
/*     */   Font textFont;
/*  41 */   public JButton btnBack = new JButton("Back");
/*  42 */   public JButton btnHell = new JButton("Hell");
/*     */   
/*     */   public PanelHell() {
/*  45 */     setLayout(new BorderLayout());
/*  46 */     setBackground(this.c.brown);
/*     */     
/*     */     try {
/*  49 */       GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
/*  50 */       ge.registerFont(Font.createFont(0, new File("images/consola.ttf")));
/*  51 */     } catch (Exception ex) {
/*  52 */       System.out.println(ex);
/*     */     } 
/*  54 */     this.textFont = new Font("Consolas", 1, 35);
/*     */     
/*  56 */     this.lNorth.setPreferredSize(new Dimension(1280, 100));
/*  57 */     this.lNorth.setFont(this.btnFont);
/*  58 */     add(this.lNorth, "North");
/*  59 */     this.lEast.setPreferredSize(new Dimension(100, 720));
/*  60 */     add(this.lEast, "East");
/*  61 */     this.lWest.setPreferredSize(new Dimension(100, 720));
/*  62 */     add(this.lWest, "West");
/*     */     
/*  64 */     this.btnBack.setUI(new CommonButtonUI());
/*  65 */     this.btnBack.setBackground(this.c.gray);
/*  66 */     this.btnBack.setFont(this.btnFont);
/*  67 */     this.btnBack.setForeground(this.c.white);
/*  68 */     this.btnBack.setPreferredSize(new Dimension(150, 70));
/*  69 */     this.pSouth.add(this.btnBack);
/*  70 */     this.pSouth.setPreferredSize(new Dimension(1280, 100));
/*  71 */     this.pSouth.setBackground(this.c.brown);
/*  72 */     add(this.pSouth, "South");
/*     */     
/*  74 */     for (int i = 0; i < 10; i++) {
/*  75 */       this.text[i] = new JLabel();
/*  76 */       this.text[i].setFont(this.textFont);
/*  77 */       this.text[i].setHorizontalAlignment(0);
/*  78 */       this.pText.add(this.text[i]);
/*     */     } 
/*  80 */     this.text[0].setText("=====RECORD=====");
/*  81 */     this.text[1].setText("Score   :");
/*  82 */     this.text[2].setText("Rate    :");
/*  83 */     this.text[3].setText("Rank    :");
/*  84 */     this.text[4].setText("");
/*  85 */     this.text[5].setText("Critical:");
/*  86 */     this.text[6].setText("Early   :");
/*  87 */     this.text[7].setText("Late    :");
/*  88 */     this.text[8].setText("Miss    :");
/*  89 */     this.text[9].setText("MaxCombo:");
/*  90 */     this.pText.setOpaque(false);
/*  91 */     this.pText.setBorder(new EmptyBorder(10, 30, 10, 10));
/*  92 */     this.pCenter.add(this.pText);
/*     */     
/*  94 */     this.pHell.add(this.lIcon, "North");
/*  95 */     this.lName.setFont(this.btnFont);
/*  96 */     this.pHell.add(this.lName, "Center");
/*  97 */     this.btnHell.setUI(new CommonButtonUI());
/*  98 */     this.btnHell.setBackground(this.c.gray);
/*  99 */     this.btnHell.setFont(this.btnFont);
/* 100 */     this.btnHell.setForeground(this.c.white);
/* 101 */     this.btnHell.setPreferredSize(new Dimension(150, 70));
/* 102 */     this.pBtn.add(this.btnHell);
/* 103 */     this.pBtn.setOpaque(false);
/* 104 */     this.pHell.add(this.pBtn, "South");
/* 105 */     this.pHell.setOpaque(false);
/* 106 */     this.pCenter.add(this.pHell);
/*     */     
/* 108 */     this.pCenter.setBackground(this.c.blue);
/* 109 */     add(this.pCenter, "Center");
/*     */   }
/*     */ 
/*     */   
/*     */   public void readRecord() throws Exception {
/* 114 */     File f = new File("songs/gekkou/highScoreHell.txt");
/* 115 */     BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "GBK"));
/*     */     
/* 117 */     String[] data = new String[9];
/*     */     
/* 119 */     for (int i = 0; i < 9 && br.ready(); i++) {
/* 120 */       String s = br.readLine();
/* 121 */       if (s.toCharArray()[0] == '*' || s.toCharArray()[0] == '=') {
/* 122 */         i--;
/*     */       } else {
/*     */         
/* 125 */         data[i] = s;
/*     */       } 
/* 127 */     }  br.close();
/*     */     
/* 129 */     this.text[1].setText("Score   :" + String.format("%6s", new Object[] { data[0] }));
/* 130 */     this.text[2].setText("Rate    :" + String.format("%5s", new Object[] { data[1] }) + "%");
/* 131 */     this.text[3].setText("Rank    :" + String.format("%6s", new Object[] { data[2] }));
/* 132 */     this.text[4].setText("0".equals(data[3]) ? "" : "[Full Combo]");
/* 133 */     this.text[5].setText("Critical:" + String.format("%6s", new Object[] { data[4] }));
/* 134 */     this.text[6].setText("Early   :" + String.format("%6s", new Object[] { data[5] }));
/* 135 */     this.text[7].setText("Late    :" + String.format("%6s", new Object[] { data[6] }));
/* 136 */     this.text[8].setText("Miss    :" + String.format("%6s", new Object[] { data[7] }));
/* 137 */     this.text[9].setText("MaxCombo:" + String.format("%6s", new Object[] { data[8] }));
/*     */   }
/*     */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/PanelHell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */