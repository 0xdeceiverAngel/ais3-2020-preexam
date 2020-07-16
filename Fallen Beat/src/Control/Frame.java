/*     */ package Control;
/*     */ import Visual.PanelEnding;
/*     */ import Visual.PanelGaming;
/*     */ import Visual.PanelHell;
/*     */ import Visual.PanelHighScore;
/*     */ import java.awt.Component;
/*     */ import java.awt.event.ActionEvent;
/*     */ 
/*     */ public class Frame extends JFrame implements ActionListener {
/*  10 */   PanelMenu pMenu = new PanelMenu();
/*  11 */   PanelHelp pHelp = new PanelHelp();
/*  12 */   PanelHell pHell = new PanelHell();
/*  13 */   PanelHighScore pHighScore = new PanelHighScore();
/*     */   PanelGaming pGaming;
/*  15 */   PanelEnding pEnding = new PanelEnding();
/*     */   
/*     */   GameControl gc;
/*  18 */   AudioPlayer apImSoHappy = new AudioPlayer("songs/I'm so Happy/I'm so Happy.wav");
/*  19 */   AudioPlayer apGekkou = new AudioPlayer("songs/gekkou/gekkou.wav");
/*  20 */   AudioPlayer titleBGM = new AudioPlayer("songs/titleBGM.wav");
/*     */   
/*     */   boolean trialL = false;
/*     */   boolean trialR = false;
/*     */   
/*     */   public Frame(String s) {
/*  26 */     super(s);
/*     */     
/*  28 */     this.pMenu.btnStart.addActionListener(this);
/*  29 */     this.pMenu.btnHighScore.addActionListener(this);
/*  30 */     this.pMenu.btnHelp.addActionListener(this);
/*  31 */     this.pMenu.btnExit.addActionListener(this);
/*  32 */     add((Component)this.pMenu);
/*     */     
/*  34 */     this.pHelp.btnBack.addActionListener(this);
/*  35 */     this.pHelp.btnHell.addActionListener(this);
/*     */     
/*  37 */     this.pHighScore.btnBack.addActionListener(this);
/*     */     
/*  39 */     this.pHell.btnBack.addActionListener(this);
/*  40 */     this.pHell.btnHell.addActionListener(this);
/*     */     
/*  42 */     this.pEnding.btnBack.addActionListener(this);
/*  43 */     this.titleBGM.musicPlay();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent ae) {
/*  49 */     if (ae.getSource() == this.pMenu.btnStart) {
/*  50 */       if (this.titleBGM.clip != null && this.titleBGM.clip.isRunning()) {
/*  51 */         this.titleBGM.musicStop();
/*     */       }
/*  53 */       remove((Component)this.pMenu);
/*  54 */       add((Component)this.pHell);
/*  55 */       repaint();
/*  56 */       revalidate();
/*  57 */     } else if (ae.getSource() == this.pMenu.btnHighScore) {
/*  58 */       remove((Component)this.pMenu);
/*  59 */       add((Component)this.pHighScore);
/*     */       try {
/*  61 */         this.pHighScore.readRecord();
/*  62 */       } catch (Exception ex) {
/*  63 */         System.out.println(ex);
/*     */       } 
/*  65 */       repaint();
/*  66 */       revalidate();
/*  67 */     } else if (ae.getSource() == this.pMenu.btnHelp) {
/*  68 */       remove((Component)this.pMenu);
/*  69 */       add((Component)this.pHelp);
/*  70 */       repaint();
/*  71 */       revalidate();
/*  72 */     } else if (ae.getSource() == this.pMenu.btnExit) {
/*  73 */       if (this.titleBGM.clip != null && this.titleBGM.clip.isRunning()) {
/*  74 */         this.titleBGM.musicStop();
/*     */       }
/*  76 */       dispose();
/*     */     } 
/*     */ 
/*     */     
/*  80 */     if (ae.getSource() == this.pHelp.btnBack) {
/*  81 */       remove((Component)this.pHelp);
/*  82 */       add((Component)this.pMenu);
/*  83 */       repaint();
/*  84 */       revalidate();
/*  85 */     } else if (ae.getSource() == this.pHelp.btnHell) {
/*  86 */       if (this.titleBGM.clip != null && this.titleBGM.clip.isRunning()) {
/*  87 */         this.titleBGM.musicStop();
/*     */       }
/*  89 */       remove((Component)this.pHelp);
/*  90 */       add((Component)this.pHell);
/*     */       try {
/*  92 */         this.pHell.readRecord();
/*  93 */       } catch (Exception ex) {
/*  94 */         System.out.println(ex);
/*     */       } 
/*  96 */       repaint();
/*  97 */       revalidate();
/*     */     } 
/*     */ 
/*     */     
/* 101 */     if (ae.getSource() == this.pHell.btnBack) {
/* 102 */       remove((Component)this.pHell);
/* 103 */       add((Component)this.pMenu);
/* 104 */       this.titleBGM.musicPlay();
/* 105 */       repaint();
/* 106 */       revalidate();
/* 107 */     } else if (ae.getSource() == this.pHell.btnHell) {
/* 108 */       this.pGaming = new PanelGaming();
/* 109 */       remove((Component)this.pHell);
/* 110 */       add((Component)this.pGaming);
/* 111 */       repaint();
/* 112 */       revalidate();
/*     */       
/* 114 */       this.gc = new GameControl(this, this.pEnding, this.pGaming, "songs/gekkou/hell.txt");
/* 115 */       this.gc.setInfo(1, 2);
/* 116 */       this.gc.setMusic("songs/gekkou/gekkou_hell.wav");
/* 117 */       this.gc.setBanner("songs/gekkou/banner.png");
/* 118 */       this.gc.setDelay(560, -5);
/* 119 */       this.gc.start();
/*     */     } 
/*     */ 
/*     */     
/* 123 */     if (ae.getSource() == this.pHighScore.btnBack) {
/* 124 */       remove((Component)this.pHighScore);
/* 125 */       add((Component)this.pMenu);
/* 126 */       repaint();
/* 127 */       revalidate();
/*     */     } 
/*     */ 
/*     */     
/* 131 */     if (ae.getSource() == this.pEnding.btnBack) {
/* 132 */       remove((Component)this.pEnding);
/* 133 */       this.pEnding.close();
/* 134 */       add((Component)this.pHell);
/* 135 */       repaint();
/* 136 */       revalidate();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Control/Frame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */