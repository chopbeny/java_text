package testWab;
import java.util.Scanner;
import java.io.*;
import javax.sound.midi.*;
class Music {
	File file;
	Sequence sequence;
	Sequencer sequencer;
	public Music(){
		try{
			sequencer=MidiSystem.getSequencer();
			sequencer.open();
		}
		catch(MidiUnavailableException ex){
			
		}
	}
	void loadMusic(String fileName){
		file=new File(fileName);
			try{
				sequence=MidiSystem.getSequence(file);
			}
			catch(InvalidMidiDataException ex){
				
			}
			catch (IOException ex){
				
			}
	}
	public void playMusic(){
		try{
			sequencer.setSequence(sequence);
		}catch(InvalidMidiDataException ex){
			
		}
		sequencer.start();
		sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
	}
	public void stopPlaying(){
		sequencer.stop();
	}
	public boolean isStopped(){
		return !sequencer.isRunning();
	}
	public static void main(String[] agrs){
		Scanner input = new Scanner(System.in);
		int chos=input.nextInt();
		Music music=new Music();
		switch(chos){
		case 1:
			music.loadMusic("D:/Users/workspace/BoxGame/images/sola.mid");
			break;
		case 2:
			music.loadMusic("D:/Users/workspace/BoxGame/images/fsn.mid");
			break;
		case 3:
			music.loadMusic("D:/Users/workspace/BoxGame/images/ffn.mid");
			break;
		case 4:
			music.loadMusic("D:/Users/workspace/BoxGame/images/nor.mid");
			break;
		case 5:
			music.loadMusic("D:/Users/workspace/BoxGame/images/qin.mid");
			break;
			
		}
		music.loadMusic("D:/Users/workspace/BoxGame/images/sola.mid");
		music.playMusic();
	}

}