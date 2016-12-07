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
	
	public Level getLevel() {
		
		try {
			
			file = new FileInputStream("res/map/map.txt");
			reader = new InputStreamReader(file);
			scanner = new Scanner(reader);
			
			level.map = new int[level.getLevelWidth()][level.getLevelLength()];
			
			for(int i = 0; i < level.getLevelWidth(); i++) {
				for(int j = 0; j < level.getLevelLength(); j++) {
					level.map[i][j] = scanner.nextInt();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}