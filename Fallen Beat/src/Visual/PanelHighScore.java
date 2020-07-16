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
/*     */ public class PanelHighScore
/*     */   extends JPanel {
/*  20 */   MyColor c = new MyColor();
/*     */   
/*  22 */   ImageIcon iconImSoHappyHS = new ImageIcon("songs/I'm so Happy/I'm so Happy_HS.png");
/*  23 */   ImageIcon iconGekkouHS = new ImageIcon("songs/gekkou/gekkou_HS.png");
/*  24 */   JLabel[] lIconHS = new JLabel[2];
/*     */   
/*  26 */   JPanel[] pRecord = new JPanel[2];
/*  27 */   JPanel[] pGap = new JPanel[2];
/*  28 */   JPanel[] pTextPlate = new JPanel[2];
/*  29 */   JPanel[] pText = new JPanel[4];
/*  30 */   JLabel[][] text = new JLabel[4][10];
/*  31 */   JPanel pCenter = new JPanel(new GridLayout(2, 1));
/*     */   
/*  33 */   JPanel pSouth = new JPanel();
/*  34 */   JLabel lNorth = new JLabel();
/*  35 */   JLabel lWest = new JLabel();
/*  36 */   JLabel lEast = new JLabel();
/*     */   
/*     */   Font textFont;
/*  39 */   Font btnFont = new Font("Dialog", 1, 35);
/*  40 */   public JButton btnBack = new JButton("Back");
/*     */   
/*     */   public PanelHighScore() {
/*  43 */     setLayout(new BorderLayout());
/*  44 */     setBackground(this.c.brown);
/*     */     
/*     */     try {
/*  47 */       GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
/*  48 */       ge.registerFont(Font.createFont(0, new File("images/consola.ttf")));
/*  49 */     } catch (Exception ex) {
/*  50 */       System.out.println(ex);
/*     */     } 
/*  52 */     this.textFont = new Font("Consolas", 1, 25);
/*     */     
/*  54 */     this.lNorth.setPreferredSize(new Dimension(1280, 100));
/*  55 */     add(this.lNorth, "North");
/*  56 */     this.lEast.setPreferredSize(new Dimension(100, 720));
/*  57 */     add(this.lEast, "East");
/*  58 */     this.lWest.setPreferredSize(new Dimension(100, 720));
/*  59 */     add(this.lWest, "West");
/*     */     
/*  61 */     this.btnBack.setUI(new CommonButtonUI());
/*  62 */     this.btnBack.setBackground(this.c.gray);
/*  63 */     this.btnBack.setFont(this.btnFont);
/*  64 */     this.btnBack.setForeground(this.c.white);
/*  65 */     this.btnBack.setPreferredSize(new Dimension(150, 70));
/*  66 */     this.pSouth.add(this.btnBack);
/*  67 */     this.pSouth.setPreferredSize(new Dimension(1280, 100));
/*  68 */     this.pSouth.setBackground(this.c.brown);
/*  69 */     add(this.pSouth, "South");
/*     */     
/*  71 */     this.pRecord[0] = new JPanel(new BorderLayout());
/*  72 */     this.pRecord[0].setBackground(this.c.blue);
/*  73 */     this.pGap[0] = new JPanel();
/*  74 */     this.pGap[0].setBackground(this.c.brown);
/*  75 */     this.pRecord[0].add(this.pGap[0], "South");
/*  76 */     this.lIconHS[0] = new JLabel(this.iconImSoHappyHS);
/*  77 */     this.lIconHS[0].setBorder(new EmptyBorder(0, 10, 0, 10));
/*  78 */     this.pRecord[0].add(this.lIconHS[0], "West");
/*  79 */     this.pCenter.add(this.pRecord[0]);
/*     */     
/*  81 */     this.pRecord[1] = new JPanel(new BorderLayout());
/*  82 */     this.pRecord[1].setBackground(this.c.blue);
/*  83 */     this.pGap[1] = new JPanel();
/*  84 */     this.pGap[1].setBackground(this.c.brown);
/*  85 */     this.pRecord[1].add(this.pGap[1], "North");
/*  86 */     this.lIconHS[1] = new JLabel(this.iconGekkouHS);
/*  87 */     this.lIconHS[1].setBorder(new EmptyBorder(0, 10, 0, 10));
/*  88 */     this.pRecord[1].add(this.lIconHS[1], "West");
/*  89 */     this.pCenter.add(this.pRecord[1]);
/*     */     int i;
/*  91 */     for (i = 0; i < 2; i++) {
/*  92 */       this.pTextPlate[i] = new JPanel(new GridLayout(1, 2));
/*  93 */       this.pTextPlate[i].setBorder(new EmptyBorder(10, 10, 10, 10));
/*  94 */       this.pTextPlate[i].setOpaque(false);
/*  95 */       this.pRecord[i].add(this.pTextPlate[i], "Center");
/*     */     } 
/*     */     
/*  98 */     for (i = 0; i < 4; i++) {
/*  99 */       this.pText[i] = new JPanel(new GridLayout(5, 2));
/* 100 */       this.pText[i].setBackground((i % 2 == 0) ? this.c.white : this.c.yellow);
/* 101 */       this.pText[i].setBorder(new EmptyBorder(10, 10, 10, 10));
/* 102 */       if (i < 2) {
/* 103 */         this.pTextPlate[0].add(this.pText[i]);
/*     */       } else {
/* 105 */         this.pTextPlate[1].add(this.pText[i]);
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     for (i = 0; i < 4; i++) {
/* 110 */       int j; for (j = 0; j < 10; j++) {
/* 111 */         this.text[i][j] = new JLabel();
/* 112 */         this.text[i][j].setFont(this.textFont);
/*     */       } 
/* 114 */       for (j = 0; j < 5; j++) {
/* 115 */         this.pText[i].add(this.text[i][j]);
/* 116 */         this.pText[i].add(this.text[i][j + 5]);
/*     */       } 
/* 118 */       this.text[i][0].setText((i % 2 == 0) ? "====EASY====" : "====HARD====");
/* 119 */       this.text[i][1].setText("Score:");
/* 120 */       this.text[i][2].setText("Rate :");
/* 121 */       this.text[i][3].setText("Rank :");
/* 122 */       this.text[i][4].setText("");
/* 123 */       this.text[i][5].setText("Critical:");
/* 124 */       this.text[i][6].setText("Early   :");
/* 125 */       this.text[i][7].setText("Late    :");
/* 126 */       this.text[i][8].setText("Miss    :");
/* 127 */       this.text[i][9].setText("MaxCombo:");
/*     */     } 
/*     */     
/* 130 */     this.pCenter.setOpaque(false);
/* 131 */     add(this.pCenter, "Center");
/*     */   }
/*     */   
/*     */   public void readRecord() throws Exception {
/* 135 */     for (int i = 0; i < 4; i++) {
/*     */       File f;
/* 137 */       switch (i) {
/*     */         case 0:
/* 139 */           f = new File("songs/I'm so Happy/highScoreEasy.txt");
/*     */           break;
/*     */         case 1:
/* 142 */           f = new File("songs/I'm so Happy/highScoreHard.txt");
/*     */           break;
/*     */         case 2:
/* 145 */           f = new File("songs/gekkou/highScoreEasy.txt");
/*     */           break;
/*     */         default:
/* 148 */           f = new File("songs/gekkou/highScoreHard.txt");
/*     */           break;
/*     */       } 
/* 151 */       BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "GBK"));
/*     */       
/* 153 */       String[] data = new String[9];
/*     */       
/* 155 */       for (int j = 0; j < 9 && br.ready(); j++) {
/* 156 */         String s = br.readLine();
/* 157 */         if (s.toCharArray()[0] == '*' || s.toCharArray()[0] == '=') {
/* 158 */           j--;
/*     */         } else {
/*     */           
/* 161 */           data[j] = s;
/*     */         } 
/* 163 */       }  br.close();
/*     */       
/* 165 */       this.text[i][0].setText((i % 2 == 0) ? "====EASY====" : "====HARD====");
/* 166 */       this.text[i][1].setText("Score:" + String.format("%6s", new Object[] { data[0] }));
/* 167 */       this.text[i][2].setText("Rate :" + String.format("%5s", new Object[] { data[1] }) + "%");
/* 168 */       this.text[i][3].setText("Rank :" + String.format("%6s", new Object[] { data[2] }));
/* 169 */       this.text[i][4].setText("0".equals(data[3]) ? "" : "[Full Combo]");
/* 170 */       this.text[i][5].setText("Critical:" + String.format("%4s", new Object[] { data[4] }));
/* 171 */       this.text[i][6].setText("Early   :" + String.format("%4s", new Object[] { data[5] }));
/* 172 */       this.text[i][7].setText("Late    :" + String.format("%4s", new Object[] { data[6] }));
/* 173 */       this.text[i][8].setText("Miss    :" + String.format("%4s", new Object[] { data[7] }));
/* 174 */       this.text[i][9].setText("MaxCombo:" + String.format("%4s", new Object[] { data[8] }));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/PanelHighScore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */