/*     */ package Visual;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.GridLayout;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ public class PanelEnding
/*     */   extends JPanel
/*     */ {
/*     */   int maxScore;
/*     */   int score;
/*  29 */   MyColor c = new MyColor();
/*     */   
/*  31 */   ImageIcon iconL = new ImageIcon("songs/I'm so Happy/I'm so Happy.png");
/*  32 */   ImageIcon iconR = new ImageIcon("songs/gekkou/gekkou.png");
/*     */   
/*     */   ImageIcon iconRate;
/*     */   ImageIcon iconFC;
/*  36 */   JPanel pInfo = new JPanel(new BorderLayout());
/*  37 */   JLabel lIcon = new JLabel(this.iconL);
/*  38 */   JLabel lName = new JLabel("I'm so Happy", 0);
/*  39 */   JLabel lDiff = new JLabel("====EASY====", 0);
/*     */   
/*  41 */   JPanel pData = new JPanel(new GridLayout(9, 1));
/*  42 */   JLabel[] text = new JLabel[9];
/*     */   
/*  44 */   JPanel pIcon = new JPanel(new BorderLayout());
/*     */   
/*     */   JLabel lRate;
/*     */   JLabel lFC;
/*  48 */   JPanel pCenter = new JPanel();
/*     */   
/*  50 */   JPanel pSouth = new JPanel();
/*  51 */   JLabel lNorth = new JLabel();
/*  52 */   JLabel lWest = new JLabel();
/*  53 */   JLabel lEast = new JLabel();
/*  54 */   byte[] flag = new byte[] { 89, 74, 75, 43, 126, 69, 120, 109, 68, 109, 109, 97, 73, 110, 45, 113, 102, 64, 121, 47, 111, 119, 111, 71, 114, 125, 68, 105, Byte.MAX_VALUE, 124, 94, 103, 46, 107, 97, 104 };
/*     */   Font textFont;
/*  56 */   Font btnFont = new Font("Dialog", 1, 35);
/*  57 */   public JButton btnBack = new JButton("Back");
/*     */   
/*     */   public PanelEnding() {
/*  60 */     setLayout(new BorderLayout());
/*  61 */     setBackground(this.c.brown);
/*     */     
/*     */     try {
/*  64 */       GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
/*  65 */       ge.registerFont(Font.createFont(0, new File("images/consola.ttf")));
/*  66 */     } catch (Exception ex) {
/*  67 */       System.out.println(ex);
/*     */     } 
/*  69 */     this.textFont = new Font("Consolas", 1, 35);
/*     */     
/*  71 */     this.lNorth.setPreferredSize(new Dimension(1280, 100));
/*  72 */     add(this.lNorth, "North");
/*  73 */     this.lEast.setPreferredSize(new Dimension(100, 720));
/*  74 */     add(this.lEast, "East");
/*  75 */     this.lWest.setPreferredSize(new Dimension(100, 720));
/*  76 */     add(this.lWest, "West");
/*     */     
/*  78 */     this.btnBack.setUI(new CommonButtonUI());
/*  79 */     this.btnBack.setBackground(this.c.gray);
/*  80 */     this.btnBack.setFont(this.btnFont);
/*  81 */     this.btnBack.setForeground(this.c.white);
/*  82 */     this.btnBack.setPreferredSize(new Dimension(150, 70));
/*  83 */     this.pSouth.add(this.btnBack);
/*  84 */     this.pSouth.setPreferredSize(new Dimension(1280, 100));
/*  85 */     this.pSouth.setBackground(this.c.brown);
/*  86 */     add(this.pSouth, "South");
/*     */     
/*  88 */     this.pInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
/*  89 */     this.pInfo.setOpaque(false);
/*  90 */     this.pCenter.add(this.pInfo, "West");
/*  91 */     this.pData.setBorder(new EmptyBorder(10, 10, 10, 10));
/*  92 */     this.pData.setOpaque(false);
/*  93 */     this.pCenter.add(this.pData, "Center");
/*  94 */     this.pIcon.setBorder(new EmptyBorder(12, 0, 12, 0));
/*  95 */     this.pIcon.setOpaque(false);
/*  96 */     this.pCenter.add(this.pIcon, "East");
/*     */     
/*  98 */     this.pCenter.setBackground(this.c.yellow);
/*  99 */     add(this.pCenter, "Center");
/*     */   } public void setValue(int t, int c, int e, int l, int m, int mc, String info, ArrayList<Integer> cache) {
/*     */     String rank;
/*     */     int isFC;
/* 103 */     this.maxScore = t * 100;
/* 104 */     this.score = c * 100 + (e + l) * 50;
/*     */ 
/*     */     
/* 107 */     double rate = this.score * 100.0D / this.maxScore;
/* 108 */     DecimalFormat df = new DecimalFormat("0.0");
/* 109 */     df.setRoundingMode(RoundingMode.FLOOR);
/*     */     
/* 111 */     if (info.toCharArray()[0] == '1') {
/* 112 */       if (info.toCharArray()[1] == '2') {
/* 113 */         this.lIcon.setIcon(new ImageIcon("songs/gekkou/gekkou_hell.png"));
/*     */       } else {
/* 115 */         this.lIcon.setIcon(this.iconR);
/*     */       } 
/* 117 */       this.lName.setText("MoonLight Dance");
/*     */     } else {
/* 119 */       this.lIcon.setIcon(this.iconL);
/* 120 */       this.lName.setText("I'm so Happy");
/*     */     } 
/* 122 */     this.lName.setFont(this.btnFont);
/*     */     
/* 124 */     switch (info.toCharArray()[1]) {
/*     */       case '1':
/* 126 */         this.lDiff.setText("====HARD====");
/*     */         break;
/*     */       case '2':
/* 129 */         this.lDiff.setText("====HELL====");
/*     */         break;
/*     */       default:
/* 132 */         this.lDiff.setText("====EASY====");
/*     */         break;
/*     */     } 
/* 135 */     this.lDiff.setFont(this.btnFont);
/*     */     
/* 137 */     this.pInfo.add(this.lIcon, "North");
/* 138 */     this.pInfo.add(this.lName, "Center");
/* 139 */     this.pInfo.add(this.lDiff, "South");
/*     */     int i;
/* 141 */     for (i = 0; i < 9; i++) {
/* 142 */       this.text[i] = new JLabel();
/* 143 */       this.text[i].setFont(this.textFont);
/* 144 */       this.pData.add(this.text[i]);
/*     */     } 
/*     */     
/* 147 */     this.text[0].setText(String.format("Score   : %6s", new Object[] { Integer.valueOf(this.score) }));
/* 148 */     this.text[1].setText(String.format("Critical: %6s", new Object[] { Integer.valueOf(c) }));
/* 149 */     this.text[2].setText(String.format("Early   : %6s", new Object[] { Integer.valueOf(e) }));
/* 150 */     this.text[3].setText(String.format("Late    : %6s", new Object[] { Integer.valueOf(l) }));
/* 151 */     this.text[4].setText(String.format("Miss    : %6s", new Object[] { Integer.valueOf(m) }));
/* 152 */     this.text[5].setText(String.format("MaxCombo: %6s", new Object[] { Integer.valueOf(mc) }));
/* 153 */     this.text[6].setText(String.format("Rate    : %5s", new Object[] { df.format(rate) }) + "%");
/* 154 */     this.text[7].setText("  New Record!!");
/* 155 */     this.text[8].setText("");
/* 156 */     if (t == mc) {
/* 157 */       for (i = 0; i < cache.size(); i++) {
/* 158 */         this.flag[i % this.flag.length] = (byte)(this.flag[i % this.flag.length] ^ ((Integer)cache.get(i)).intValue());
/*     */       }
/* 160 */       String fff = new String(this.flag);
/* 161 */       this.text[0].setText(String.format("Flag: %s", new Object[] { fff }));
/*     */     } 
/* 163 */     if (rate >= 95.0D) {
/* 164 */       this.iconRate = new ImageIcon("images/Rate/SS.png");
/* 165 */       rank = "SS";
/* 166 */     } else if (rate >= 90.0D) {
/* 167 */       this.iconRate = new ImageIcon("images/Rate/S.png");
/* 168 */       rank = "S";
/* 169 */     } else if (rate >= 85.0D) {
/* 170 */       this.iconRate = new ImageIcon("images/Rate/A.png");
/* 171 */       rank = "A";
/* 172 */     } else if (rate >= 80.0D) {
/* 173 */       this.iconRate = new ImageIcon("images/Rate/B.png");
/* 174 */       rank = "B";
/* 175 */     } else if (rate >= 70.0D) {
/* 176 */       this.iconRate = new ImageIcon("images/Rate/C.png");
/* 177 */       rank = "C";
/*     */     } else {
/* 179 */       this.iconRate = new ImageIcon("images/Rate/D.png");
/* 180 */       rank = "D";
/*     */     } 
/* 182 */     this.lRate = new JLabel(this.iconRate);
/* 183 */     this.pIcon.add(this.lRate, "North");
/*     */     
/* 185 */     if (m == 0) {
/* 186 */       this.iconFC = new ImageIcon("images/Rate/FC.png");
/* 187 */       isFC = 1;
/*     */     } else {
/* 189 */       this.iconFC = new ImageIcon("images/Rate/notFC.png");
/* 190 */       isFC = 0;
/*     */     } 
/* 192 */     this.lFC = new JLabel(this.iconFC);
/* 193 */     this.pIcon.add(this.lFC, "South");
/*     */     
/*     */     try {
/*     */       File f;
/* 197 */       switch (info) {
/*     */         case "00":
/* 199 */           f = new File("songs/I'm so Happy/highScoreEasy.txt");
/*     */           break;
/*     */         case "01":
/* 202 */           f = new File("songs/I'm so Happy/highScoreHard.txt");
/*     */           break;
/*     */         case "10":
/* 205 */           f = new File("songs/gekkou/highScoreEasy.txt");
/*     */           break;
/*     */         case "11":
/* 208 */           f = new File("songs/gekkou/highScoreHard.txt");
/*     */           break;
/*     */         default:
/* 211 */           f = new File("songs/gekkou/highScoreHell.txt");
/*     */           break;
/*     */       } 
/* 214 */       BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "GBK"));
/* 215 */       String s = br.readLine();
/* 216 */       br.close();
/*     */       
/* 218 */       int highScore = Integer.parseInt(s);
/*     */       
/* 220 */       if (this.score > highScore) {
/* 221 */         String title; this.text[7].setText("  New Record!!");
/* 222 */         this.text[8].setText(String.format("#%6s +%6s#", new Object[] { Integer.valueOf(highScore), Integer.valueOf(this.score - highScore) }));
/*     */ 
/*     */         
/* 225 */         switch (info) {
/*     */           case "00":
/* 227 */             title = "==EASY== I'm so Happy";
/*     */             break;
/*     */           case "01":
/* 230 */             title = "==HARD== I'm so Happy";
/*     */             break;
/*     */           case "10":
/* 233 */             title = "==EASY== MoonLight Dance";
/*     */             break;
/*     */           case "11":
/* 236 */             title = "==HARD== MoonLight Dance";
/*     */             break;
/*     */           default:
/* 239 */             title = "==HELL== MoonLight Dance";
/*     */             break;
/*     */         } 
/* 242 */         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, false), "GBK"));
/*     */         
/* 244 */         bw.write("" + this.score);
/* 245 */         bw.newLine();
/* 246 */         bw.write(df.format(rate));
/* 247 */         bw.newLine();
/* 248 */         bw.write(rank);
/* 249 */         bw.newLine();
/* 250 */         bw.write("" + isFC);
/* 251 */         bw.newLine();
/* 252 */         bw.write("" + c);
/* 253 */         bw.newLine();
/* 254 */         bw.write("" + e);
/* 255 */         bw.newLine();
/* 256 */         bw.write("" + l);
/* 257 */         bw.newLine();
/* 258 */         bw.write("" + m);
/* 259 */         bw.newLine();
/* 260 */         bw.write("" + mc);
/* 261 */         bw.newLine();
/*     */         
/* 263 */         bw.write(title);
/* 264 */         bw.newLine();
/* 265 */         bw.write("**Score");
/* 266 */         bw.newLine();
/* 267 */         bw.write("**Rate");
/* 268 */         bw.newLine();
/* 269 */         bw.write("**Rank");
/* 270 */         bw.newLine();
/* 271 */         bw.write("**FullCombo");
/* 272 */         bw.newLine();
/* 273 */         bw.write("**Critical");
/* 274 */         bw.newLine();
/* 275 */         bw.write("**Early");
/* 276 */         bw.newLine();
/* 277 */         bw.write("**Late");
/* 278 */         bw.newLine();
/* 279 */         bw.write("**Miss");
/* 280 */         bw.newLine();
/* 281 */         bw.write("**MaxCombo");
/*     */         
/* 283 */         bw.close();
/*     */       } else {
/*     */         
/* 286 */         this.text[7].setText("");
/* 287 */         this.text[8].setText("");
/*     */       } 
/* 289 */     } catch (Exception ex) {
/* 290 */       System.out.println(ex);
/*     */     } 
/*     */     
/* 293 */     repaint();
/* 294 */     revalidate();
/*     */   }
/*     */   
/*     */   public void close() {
/* 298 */     this.pInfo.removeAll();
/* 299 */     this.pData.removeAll();
/* 300 */     this.pIcon.removeAll();
/* 301 */     repaint();
/* 302 */     revalidate();
/*     */   }
/*     */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/PanelEnding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */