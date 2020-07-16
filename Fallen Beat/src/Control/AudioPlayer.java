/*    */ package Control;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.sound.sampled.AudioSystem;
/*    */ import javax.sound.sampled.Clip;
/*    */ 
/*    */ 
/*    */ public class AudioPlayer
/*    */ {
/*    */   File music;
/*    */   Clip clip;
/*    */   
/*    */   public AudioPlayer(String filePath) {
/* 14 */     this.music = new File(filePath);
/*    */   }
/*    */   
/*    */   public void musicPlay() {
/*    */     try {
/* 19 */       this.clip = AudioSystem.getClip();
/* 20 */       this.clip.open(AudioSystem.getAudioInputStream(this.music));
/* 21 */       this.clip.start();
/* 22 */     } catch (Exception ex) {
/* 23 */       System.out.println(ex);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void musicStop() {
/* 28 */     this.clip.stop();
/*    */   }
/*    */   
/*    */   public void musicLoop() {
/*    */     try {
/* 33 */       this.clip = AudioSystem.getClip();
/* 34 */       this.clip.open(AudioSystem.getAudioInputStream(this.music));
/* 35 */       this.clip.loop(-1);
/* 36 */     } catch (Exception ex) {
/* 37 */       System.out.println(ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/user/ais3/Fallen Beat/Fallen_Beat/Fallen_Beat.jar!/Control/AudioPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */