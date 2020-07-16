/*     */ package Visual;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class PanelStrat
/*     */   extends JPanel {
/*  14 */   MyColor c = new MyColor();
/*  15 */   ImageIcon iconImSoHappy = new ImageIcon("songs/I'm so Happy/I'm so Happy.png");
/*  16 */   ImageIcon iconGekkou = new ImageIcon("songs/gekkou/gekkou.png");
/*     */   
/*  18 */   JPanel pCenter = new JPanel(new GridLayout(1, 2));
/*  19 */   JPanel pSouth = new JPanel();
/*  20 */   JLabel lNorth = new JLabel("Please turn off your Chinese Input Method.", 0);
/*  21 */   JLabel lWest = new JLabel();
/*  22 */   JLabel lEast = new JLabel();
/*     */   
/*  24 */   JPanel pL = new JPanel(new BorderLayout());
/*  25 */   JPanel gapL = new JPanel();
/*  26 */   JLabel lIconL = new JLabel(this.iconImSoHappy);
/*  27 */   JPanel pLCenter = new JPanel(new BorderLayout());
/*  28 */   JLabel lNameL = new JLabel("I'm so Happy", 0);
/*  29 */   JPanel pLSouth = new JPanel(new GridLayout(1, 3));
/*  30 */   JPanel[] pBtnL = new JPanel[3];
/*  31 */   public JButton[] btnL = new JButton[3];
/*     */   
/*  33 */   JPanel pR = new JPanel(new BorderLayout());
/*  34 */   JPanel gapR = new JPanel();
/*  35 */   JLabel lIconR = new JLabel(this.iconGekkou);
/*  36 */   JPanel pRCenter = new JPanel(new BorderLayout());
/*  37 */   JLabel lNameR = new JLabel("MoonLight Dance", 0);
/*  38 */   JPanel pRSouth = new JPanel(new GridLayout(1, 3));
/*  39 */   JPanel[] pBtnR = new JPanel[3];
/*  40 */   public JButton[] btnR = new JButton[3];
/*     */   
/*  42 */   Font btnFont = new Font("Dialog", 1, 35);
/*  43 */   public JButton btnBack = new JButton("Back");
/*     */   
/*     */   public PanelStrat() {
/*  46 */     setLayout(new BorderLayout());
/*  47 */     setBackground(this.c.brown);
/*     */     
/*  49 */     this.lNorth.setPreferredSize(new Dimension(1280, 100));
/*  50 */     this.lNorth.setFont(this.btnFont);
/*  51 */     add(this.lNorth, "North");
/*  52 */     this.lEast.setPreferredSize(new Dimension(100, 720));
/*  53 */     add(this.lEast, "East");
/*  54 */     this.lWest.setPreferredSize(new Dimension(100, 720));
/*  55 */     add(this.lWest, "West");
/*     */     
/*  57 */     this.btnBack.setUI(new CommonButtonUI());
/*  58 */     this.btnBack.setBackground(this.c.gray);
/*  59 */     this.btnBack.setFont(this.btnFont);
/*  60 */     this.btnBack.setForeground(this.c.white);
/*  61 */     this.btnBack.setPreferredSize(new Dimension(150, 70));
/*  62 */     this.pSouth.add(this.btnBack);
/*  63 */     this.pSouth.setPreferredSize(new Dimension(1280, 100));
/*  64 */     this.pSouth.setBackground(this.c.brown);
/*  65 */     add(this.pSouth, "South");
/*     */     
/*  67 */     this.gapL.setBackground(this.c.brown);
/*  68 */     this.pL.add(this.gapL, "East");
/*  69 */     this.pLCenter.setBackground(this.c.blue);
/*  70 */     this.pLCenter.add(this.lIconL, "North");
/*  71 */     this.lNameL.setFont(this.btnFont);
/*  72 */     this.pLCenter.add(this.lNameL, "Center");
/*  73 */     this.pLSouth.setOpaque(false);
/*  74 */     this.pLCenter.add(this.pLSouth, "South");
/*  75 */     this.pL.add(this.pLCenter, "Center");
/*  76 */     this.pL.setBackground(this.c.blue);
/*  77 */     this.pCenter.add(this.pL);
/*     */     
/*  79 */     this.gapR.setBackground(this.c.brown);
/*  80 */     this.pR.add(this.gapR, "West");
/*  81 */     this.pRCenter.setBackground(this.c.blue);
/*  82 */     this.pRCenter.add(this.lIconR, "North");
/*  83 */     this.lNameR.setFont(this.btnFont);
/*  84 */     this.pRCenter.add(this.lNameR, "Center");
/*  85 */     this.pRSouth.setOpaque(false);
/*  86 */     this.pRCenter.add(this.pRSouth, "South");
/*  87 */     this.pR.add(this.pRCenter, "Center");
/*  88 */     this.pR.setBackground(this.c.blue);
/*  89 */     this.pCenter.setOpaque(false);
/*  90 */     this.pCenter.add(this.pR);
/*     */     
/*  92 */     for (int i = 0; i < 3; i++) {
/*  93 */       switch (i) {
/*     */         case 0:
/*  95 */           this.btnL[i] = new JButton("Trial");
/*  96 */           this.btnR[i] = new JButton("Trial");
/*     */           break;
/*     */         case 1:
/*  99 */           this.btnL[i] = new JButton("Easy");
/* 100 */           this.btnR[i] = new JButton("Easy");
/*     */           break;
/*     */         default:
/* 103 */           this.btnL[i] = new JButton("Hard");
/* 104 */           this.btnR[i] = new JButton("Hard");
/*     */           break;
/*     */       } 
/* 107 */       this.btnL[i].setUI(new CommonButtonUI());
/* 108 */       this.btnL[i].setBackground(this.c.gray);
/* 109 */       this.btnL[i].setFont(this.btnFont);
/* 110 */       this.btnL[i].setForeground(this.c.white);
/* 111 */       this.btnL[i].setPreferredSize(new Dimension(0, 70));
/* 112 */       this.pLSouth.add(this.btnL[i]);
/* 113 */       this.btnR[i].setUI(new CommonButtonUI());
/* 114 */       this.btnR[i].setBackground(this.c.gray);
/* 115 */       this.btnR[i].setFont(this.btnFont);
/* 116 */       this.btnR[i].setForeground(this.c.white);
/* 117 */       this.btnR[i].setPreferredSize(new Dimension(0, 70));
/* 118 */       this.pRSouth.add(this.btnR[i]);
/*     */     } 
/*     */     
/* 121 */     this.pCenter.setBackground(this.c.brown);
/* 122 */     add(this.pCenter, "Center");
/*     */   }
/*     */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Visual/PanelStrat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */