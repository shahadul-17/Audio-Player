package audio.player;

public class Main {
	
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		
		try {
			audioPlayer.play("beep.wav");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
}