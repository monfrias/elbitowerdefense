package window;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LevelFile {

	FileInputStream file;
	InputStreamReader reader;
	Scanner scanner;
	Level level = new Level();
	private static final int BOARD_LENGTH = 29;
	private static final int BOARD_WIDTH = 13;
	
	public Level getLevel() {
		
		try {
			
			file = new FileInputStream("map/map.txt");
			reader = new InputStreamReader(file);
			scanner = new Scanner(reader);
			
			level.map = new int[BOARD_LENGTH][BOARD_WIDTH];
			
			for(int i = 0; i < BOARD_LENGTH; i++) {
				for(int j = 0; j < BOARD_WIDTH; j++) {
					
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}