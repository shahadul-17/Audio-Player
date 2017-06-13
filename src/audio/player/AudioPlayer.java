package audio.player;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioPlayer {
	
	private byte[] buffer = new byte[8192];
	private int bytesRead;
	
	private File file;
	private AudioInputStream audioInputStream;
	private AudioFormat audioFormat;
	private SourceDataLine sourceDataLine;
	
	public void play(String fileName) throws Exception {
		file = new File(fileName);
		audioInputStream = AudioSystem.getAudioInputStream(file);
		audioFormat = audioInputStream.getFormat();
		
		sourceDataLine = (SourceDataLine) AudioSystem.getLine(new DataLine.Info(SourceDataLine.class, audioFormat));
		sourceDataLine.open(audioFormat);
		sourceDataLine.start();
		
		while ((bytesRead = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
			sourceDataLine.write(buffer, 0, bytesRead);
		}
		
		sourceDataLine.drain();
		sourceDataLine.close();
	}
	
}