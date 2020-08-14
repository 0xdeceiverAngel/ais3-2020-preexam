/*     */ package Control;
/*     */ 
/*     */ import Visual.MyColor;
/*     */ import Visual.PanelEnding;
/*     */ import Visual.PanelGaming;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class GameControl extends Thread implements KeyListener {
/*     */   Frame f;
/*  23 */   MyColor c = new MyColor();
/*     */   PanelGaming pg;
/*     */   PanelEnding pe;
/*     */   AudioPlayer music;
/*     */   JLabel note;
/*  28 */   JPanel pFumen = new JPanel((LayoutManager)null);
/*  29 */   JPanel pCL = new JPanel((LayoutManager)null);
/*     */   JLabel lCL;
/*  31 */   ImageIcon bt = new ImageIcon("images/BT.png");
/*  32 */   ImageIcon fx = new ImageIcon("images/FX.png");
/*  33 */   ImageIcon cl = new ImageIcon("images/CL.png");
/*  34 */   ImageIcon aeY = new ImageIcon("images/ActionEffect/yellow.png");
/*  35 */   ImageIcon aeG = new ImageIcon("images/ActionEffect/green.png");
/*  36 */   ImageIcon aeB = new ImageIcon("images/ActionEffect/blue.png");
/*  37 */   ImageIcon aeR = new ImageIcon("images/ActionEffect/red.png");
/*  38 */   ImageIcon aeW = new ImageIcon("images/ActionEffect/white.png");
/*  39 */   JLabel[] lAE = new JLabel[4];
/*     */   
/*     */   ArrayList<Integer> cache;
/*     */   JLabel lbanner;
/*  43 */   JLabel wordCombo = new JLabel("Combo", 2);
/*  44 */   JLabel showCombo = new JLabel(String.format("%4s", new Object[] { "0" }), 2);
/*     */   int bpm;
/*     */   int y;
/*  47 */   int distance = 80;
/*  48 */   int deltaY = 10;
/*     */   
/*     */   int delay;
/*     */   int initY;
/*     */   long spf;Fallen Beat
/*  53 */   int[] key = new int[] { 68, 70, 74, 75, 32 };
/*     */   
/*     */   ArrayList<ArrayList<Integer>> check;
/*  56 */   int[] checkSize = new int[5];
/*     */   
/*  58 */   int criticalTime = 80;
/*  59 */   int nearTime = 200;
/*     */   
/*     */   int total;
/*     */   
/*     */   int critical;
/*     */   
/*     */   int early;
/*     */   int late;
/*     */   int miss;
/*     */   int combo;
/*     */   int idx;
/*     */   int comboMax;
/*     */   String info;
/*     */   
/*     */   public GameControl(Frame fTemp, PanelEnding peTemp, PanelGaming pgTemp, String fumenPath) {
/*     */     try {
/*  75 */       this.f = fTemp;
/*  76 */       this.pe = peTemp;
/*  77 */       this.pg = pgTemp;
/*     */       
/*  79 */       this.check = new ArrayList<>();
/*  80 */       for (int i = 0; i < 5; i++) {
/*  81 */         this.check.add(new ArrayList<>());
/*     */       }
/*     */       
/*  84 */       this.total = 0;
/*  85 */       this.critical = 0;
/*  86 */       this.early = 0;
/*  87 */       this.late = 0;
/*  88 */       this.miss = 0;
/*  89 */       this.combo = 0;
/*  90 */       this.comboMax = 0;
/*  91 */       this.idx = 0;
/*  92 */       this.y = 0;
/*     */       
/*  94 */       FileReader fr = new FileReader(fumenPath);
/*  95 */       BufferedReader br = new BufferedReader(fr);
/*  96 */       this.bpm = Integer.parseInt(br.readLine());
/*  97 */       this.spf = (long)(1.5E7D / this.bpm / (this.distance / this.deltaY) * 1000.0D);
/*     */       
/*  99 */       for (int j = 0; j < 4; j++) {
/* 100 */         this.lAE[j] = new JLabel();
/* 101 */         this.lAE[j].setOpaque(false);
/* 102 */         this.lAE[j].setBounds(111 * j + 14, 15, 100, 80);
/* 103 */         this.lAE[j].addKeyListener(this);
/* 104 */         this.lAE[j].setFocusable(true);
/* 105 */         this.pCL.add(this.lAE[j]);
/*     */       } 
/*     */       
/* 108 */       this.lCL = new JLabel(this.cl);
/* 109 */       this.lCL.setBounds(0, 0, 460, 100);
/* 110 */       this.pCL.add(this.lCL);
/* 111 */       this.pCL.setBounds(410, 600, 460, 100);
/* 112 */       this.pg.add(this.pCL);
/*     */       
/*     */       try {
/* 115 */         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
/* 116 */         ge.registerFont(Font.createFont(0, new File("images/consola.ttf")));
/* 117 */       } catch (Exception ex) {
/* 118 */         System.out.println(ex);
/*     */       } 
/* 120 */       Font textFont = new Font("Consolas", 1, 100);
/*     */       
/* 122 */       this.wordCombo.setBounds(900, 100, 400, 120);
/* 123 */       this.wordCombo.setForeground(this.c.white);
/* 124 */       this.wordCombo.setFont(textFont);
/* 125 */       this.pg.add(this.wordCombo);
/*     */       
/* 127 */       this.showCombo.setBounds(900, 220, 400, 120);
/* 128 */       this.showCombo.setForeground(this.c.white);
/* 129 */       this.showCombo.setFont(textFont);
/* 130 */       pgTemp.add(this.showCombo);
/* 131 */       this.cache = new ArrayList<>();
/* 132 */       int[] bounds = { 1, 111, 223, 334, 36 };
/* 133 */       while (br.ready()) {
/* 134 */         String s = br.readLine();
/* 135 */         if (s.charAt(0) != '*') {
/* 136 */           int a = Integer.parseInt(s);
/* 137 */           this.cache.add(Integer.valueOf(a));
/* 138 */           for (int m = 0; m < 5; m++) {
/* 139 */             if ((a >> m & 0x1) == 1) {
/* 140 */               if (m != 4) {
/* 141 */                 this.note = new JLabel(this.bt);
/* 142 */                 this.note.setBounds(bounds[m], this.y, 100, 40);
/*     */               } else {
/* 144 */                 this.note = new JLabel(this.fx);
/* 145 */                 this.note.setBounds(bounds[m], this.y, 350, 40);
/*     */               } 
/* 147 */               this.pFumen.add(this.note);
/* 148 */               ((ArrayList<Integer>)this.check.get(m)).add(Integer.valueOf(this.y));
/* 149 */               this.total++;
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 201 */           this.y += this.distance;
/*     */         } 
/*     */       } 
/*     */       
/* 205 */       this.pFumen.setBounds(422, -this.y, 438, this.y - 125);
/* 206 */       this.pg.add(this.pFumen);
/* 207 */       this.pFumen.setOpaque(false);
/* 208 */       this.pg.repaint();
/* 209 */       this.pg.revalidate();
/*     */       
/* 211 */       this.pg.addKeyListener(this);
/* 212 */       this.pg.setFocusable(true);
/* 213 */       this.pg.requestFocusInWindow();
/*     */       
/* 215 */       for (int k = 0; k < 5; k++) {
/* 216 */         this.checkSize[k] = ((ArrayList)this.check.get(k)).size();
/*     */       }
/*     */       
/* 219 */       br.close();
/* 220 */       fr.close();
/* 221 */     } catch (Exception ex) {
/* 222 */       System.out.println(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setInfo(int song, int difficulty) {
/* 227 */     this.info = "" + song + "" + difficulty + "";
/*     */   }
/*     */   
/*     */   public void setMusic(String filePath) {
/* 231 */     this.music = new AudioPlayer(filePath);
/*     */   }
/*     */   
/*     */   public void setBanner(String filePath) {
/* 235 */     this.lbanner = new JLabel(new ImageIcon(filePath));
/* 236 */     this.lbanner.setBounds(0, 0, 410, 720);
/* 237 */     this.pg.add(this.lbanner);
/*     */   }
/*     */   
/*     */   public void setDelay(int delay, int initY) {
/* 241 */     this.delay = delay;
/* 242 */     this.initY = initY;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/* 247 */     long startConstruct = System.currentTimeMillis();
/* 248 */     System.out.println("Ready");
/* 249 */     int sizeY = this.y - this.distance;
/* 250 */     int[] counter = { -1, -1, -1, -1, -1 };
/*     */     
/* 252 */     while (System.currentTimeMillis() - startConstruct < 2000L);
/*     */     
/* 254 */     System.out.println("Go");
/*     */     
/* 256 */     long startTime = System.nanoTime();
/* 257 */     this.music.musicPlay();
/* 258 */     while (this.y > -720 - this.deltaY * 200) {
/* 259 */       while (System.nanoTime() - startTime < this.spf);
/*     */       
/* 261 */       startTime += this.spf;
/* 262 */       this.pFumen.setBounds(422, -this.y - this.deltaY * this.initY, 438, sizeY);
/* 263 */       this.y -= this.deltaY;
/*     */       
/* 265 */       for (int i = 0; i < 4; i++) {
/* 266 */         if (this.checkSize[i] >= 1) {
/* 267 */           if (((Integer)((ArrayList)this.check.get(i)).get(this.checkSize[i] - 1)).intValue() - this.y + this.delay > this.nearTime) {
/* 268 */             synchronized (this) {
/* 269 */               this.lAE[i].setIcon(this.aeR);
/* 270 */               this.checkSize[i] = this.checkSize[i] - 1;
/* 271 */               ((ArrayList)this.check.get(i)).remove(this.checkSize[i]);
/* 272 */               counter[i] = 5;
/* 273 */               this.miss++;
/* 274 */               if (this.combo > this.comboMax) {
/* 275 */                 this.comboMax = this.combo;
/*     */               }
/* 277 */               this.combo = 0;
/* 278 */               this.showCombo.setText(String.format("%4s", new Object[] { "0" }));
/*     */             } 
/* 280 */           } else if (counter[i] == 0 || this.checkSize[i] == 0) {
/* 281 */             synchronized (this) {
/* 282 */               this.lAE[i].setIcon((Icon)null);
/* 283 */               counter[i] = counter[i] - 1;
/*     */             } 
/* 285 */           } else if (counter[i] > 0) {
/* 286 */             counter[i] = counter[i] - 1;
/*     */           } 
/*     */         }
/*     */       } 
/* 290 */       if (this.checkSize[4] >= 1) {
/* 291 */         if (((Integer)((ArrayList)this.check.get(4)).get(this.checkSize[4] - 1)).intValue() - this.y + this.delay > this.nearTime) {
/* 292 */           synchronized (this) {
/* 293 */             this.lAE[1].setIcon(this.aeR);
/* 294 */             this.lAE[2].setIcon(this.aeR);
/* 295 */             this.checkSize[4] = this.checkSize[4] - 1;
/* 296 */             ((ArrayList)this.check.get(4)).remove(this.checkSize[4]);
/* 297 */             counter[4] = 5;
/* 298 */             this.miss++;
/* 299 */             if (this.combo > this.comboMax) {
/* 300 */               this.comboMax = this.combo;
/*     */             }
/* 302 */             this.combo = 0;
/* 303 */             this.showCombo.setText(String.format("%4s", new Object[] { "0" }));
/*     */           }  continue;
/* 305 */         }  if (counter[4] == 0 || this.checkSize[4] == 0) {
/* 306 */           synchronized (this) {
/* 307 */             this.lAE[1].setIcon((Icon)null);
/* 308 */             this.lAE[2].setIcon((Icon)null);
/* 309 */             counter[4] = counter[4] - 1;
/*     */           }  continue;
/* 311 */         }  if (counter[4] > 0) {
/* 312 */           counter[4] = counter[4] - 1;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 317 */     if (this.combo > this.comboMax) {
/* 318 */       this.comboMax = this.combo;
/*     */     }
/*     */     
/* 321 */     this.f.remove((Component)this.pg);
/* 322 */     this.f.add((Component)this.pe);
/* 323 */     this.pe.setValue(this.total, this.critical, this.early, this.late, this.miss, this.comboMax, this.info, this.cache);
/* 324 */     this.f.repaint();
/* 325 */     this.f.revalidate();
/*     */     
/* 327 */     this.pg.removeKeyListener(this);
/* 328 */     this.pg.setFocusable(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyTyped(KeyEvent ke) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyPressed(KeyEvent ke) {
/* 338 */     for (int i = 0; i < 4; i++) {
/* 339 */       if (ke.getKeyCode() == this.key[i]) {
/* 340 */         if (this.checkSize[i] >= 1) {
/* 341 */           int deltaT = ((Integer)((ArrayList<Integer>)this.check.get(i)).get(this.checkSize[i] - 1)).intValue() - this.y + this.delay;
/* 342 */           if (Math.abs(deltaT) <= this.criticalTime) {
/* 343 */             synchronized (this) {
/* 344 */               this.lAE[i].setIcon(this.aeY);
/* 345 */               this.checkSize[i] = this.checkSize[i] - 1;
/* 346 */               ((ArrayList)this.check.get(i)).remove(this.checkSize[i]);
/* 347 */               this.critical++;
/* 348 */               this.combo++;
/* 349 */               this.showCombo.setText(String.format("%4s", new Object[] { Integer.valueOf(this.combo) }));
/*     */             } 
/* 351 */           } else if (deltaT > this.criticalTime && deltaT <= this.nearTime) {
/* 352 */             synchronized (this) {
/* 353 */               this.lAE[i].setIcon(this.aeG);
/* 354 */               this.checkSize[i] = this.checkSize[i] - 1;
/* 355 */               ((ArrayList)this.check.get(i)).remove(this.checkSize[i]);
/* 356 */               this.late++;
/*     */             } 
/* 358 */           } else if (deltaT < -this.criticalTime && deltaT >= -this.nearTime) {
/* 359 */             synchronized (this) {
/* 360 */               this.lAE[i].setIcon(this.aeB);
/* 361 */               this.checkSize[i] = this.checkSize[i] - 1;
/* 362 */               ((ArrayList)this.check.get(i)).remove(this.checkSize[i]);
/* 363 */               this.early++;
/*     */             } 
/*     */           } else {
/* 366 */             this.lAE[i].setIcon(this.aeW);
/*     */           } 
/*     */         } else {
/* 369 */           this.lAE[i].setIcon(this.aeW);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 374 */     if (ke.getKeyCode() == this.key[4]) {
/* 375 */       if (this.checkSize[4] >= 1) {
/* 376 */         int deltaT = ((Integer)((ArrayList<Integer>)this.check.get(4)).get(this.checkSize[4] - 1)).intValue() - this.y + this.delay;
/* 377 */         if (Math.abs(deltaT) <= this.criticalTime) {
/* 378 */           synchronized (this) {
/* 379 */             this.lAE[1].setIcon(this.aeY);
/* 380 */             this.lAE[2].setIcon(this.aeY);
/* 381 */             this.checkSize[4] = this.checkSize[4] - 1;
/* 382 */             ((ArrayList)this.check.get(4)).remove(this.checkSize[4]);
/* 383 */             this.critical++;
/* 384 */             this.combo++;
/* 385 */             this.showCombo.setText(String.format("%4s", new Object[] { Integer.valueOf(this.combo) }));
/*     */           } 
/* 387 */         } else if (deltaT > this.criticalTime && deltaT <= this.nearTime) {
/* 388 */           synchronized (this) {
/* 389 */             this.lAE[1].setIcon(this.aeG);
/* 390 */             this.lAE[2].setIcon(this.aeG);
/* 391 */             this.checkSize[4] = this.checkSize[4] - 1;
/* 392 */             ((ArrayList)this.check.get(4)).remove(this.checkSize[4]);
/* 393 */             this.late++;
/*     */           } 
/* 395 */         } else if (deltaT < -this.criticalTime && deltaT >= -this.nearTime) {
/* 396 */           synchronized (this) {
/* 397 */             this.lAE[1].setIcon(this.aeB);
/* 398 */             this.lAE[2].setIcon(this.aeB);
/* 399 */             this.checkSize[4] = this.checkSize[4] - 1;
/* 400 */             ((ArrayList)this.check.get(4)).remove(this.checkSize[4]);
/* 401 */             this.early++;
/*     */           } 
/*     */         } else {
/* 404 */           this.lAE[1].setIcon(this.aeW);
/* 405 */           this.lAE[2].setIcon(this.aeW);
/*     */         } 
/*     */       } else {
/* 408 */         this.lAE[1].setIcon(this.aeW);
/* 409 */         this.lAE[2].setIcon(this.aeW);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyReleased(KeyEvent ke) {
/* 416 */     for (int i = 0; i < 4; i++) {
/* 417 */       if (ke.getKeyCode() == this.key[i]) {
/* 418 */         this.lAE[i].setIcon((Icon)null);
/*     */       }
/*     */     } 
/*     */     
/* 422 */     if (ke.getKeyCode() == this.key[4]) {
/* 423 */       this.lAE[1].setIcon((Icon)null);
/* 424 */       this.lAE[2].setIcon((Icon)null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Control/GameControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */