package window;

public class Level {
	
	public int[][] map;
	SpawnPoint spawnPoint;
	private static final int BOARD_LENGTH = 29;
	private static final int BOARD_WIDTH = 13;
	
	public int getLevelWidth() {
		return this.BOARD_WIDTH;
	}
	
	public int getLevelLength() {
		return this.BOARD_LENGTH;
	}
	
	public void findSpawnPoint() {
		for(int i = 0; i < BOARD_WIDTH; i++) {
			for(int j = 0; j < BOARD_LENGTH; j++) {
				
				if(map[i][j] == 2) {
					spawnPoint = new SpawnPoint(i, j);
				}
			}
		}
	}
}