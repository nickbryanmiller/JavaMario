import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
 
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
 
public class Music {
  
	public void Music() {
		
	}

    public void playTheme() throws Exception {

        InputStream in = new FileInputStream(new File("theme.wav"));
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public void playJump() throws Exception {

        InputStream in = new FileInputStream(new File("jumpSound.wav"));
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public void playBrick() throws Exception {

        InputStream in = new FileInputStream(new File("bump.wav"));
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

}