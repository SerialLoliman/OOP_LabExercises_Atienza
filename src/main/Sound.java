package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound{

Clip clip;
URL soundURL[] = new URL[30];

public Sound(){
    
    soundURL[0] = getClass().getResource("/res/sound/PetGameAdventure.wav");
    soundURL[1] = getClass().getResource("/res/sound/jingle.wav");
    soundURL[2] = getClass().getResource("/res/sound/magic.wav");
    soundURL[3] = getClass().getResource("/res/sound/unlock.wav");
    soundURL[4] = getClass().getResource("/res/sound/applause.wav");
    soundURL[5] = getClass().getResource("/res/sound/MemeVictory.wav");
    soundURL[6] = getClass().getResource("/res/sound/woodchop.wav");
    
    
    soundURL[9] = getClass().getResource("/res/sound/choose.wav");
}

public void setFile(int i){

try{

AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
clip = AudioSystem.getClip();
clip.open(ais);

}catch(Exception e){}
}

public void play(){
clip.start();
}
public void loop(){
clip.loop(Clip.LOOP_CONTINUOUSLY);
}
public void stop(){
clip.stop();
}
}