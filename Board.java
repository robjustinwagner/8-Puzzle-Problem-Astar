import java.util.ArrayList;

/* This class represents an object associated with a board state.
 */
public class Board {
	
	public static int rows = 5;	//number of rows the board contains
	public static int columns = 3;  //number of columns the board contains
	private Board parent = null; 	//only initial board's parent is null
	public int[][] tiles;		//2-D mapping of board

	//constrcutor, populate (deep copy) states
	public Board(int[][] cells) {
		tiles = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				tiles[i][j] = cells[i][j];
			}
		}
	}
	
	/* override to check for board state equality
	 * @param x 	board state to check against
	 * @return 	true if equal, else false
	 */
	public boolean equals(Object x) {
		
		Board boardState = (Board)x;
		//dimension checking
		if (columns != boardState.columns || rows != boardState.rows) {
			return false;
		}
		//value checking
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (tiles[i][j] != boardState.tiles[i][j]) {
					return false;
				}
			}
		}
		//must be equal at this point, return true
		return true;
	}
	
	/* returns the successor board states of the current
	 * board state. Uses cyclic ordering for expanding nodes: 
	 * 	Right, Down, Left, Up
	 * @returns ArrayList<Board>	the list of successors
	 */
	public ArrayList<Board> getSuccessors()	{
		
		ArrayList<Board> successors = new ArrayList<Board>();
		Board tempBoard = new Board(tiles);
		int[] coords;
		
		//if 0 has three switch options... {[2,0],[2,2]}
		//else, only has two switch options...
		coords = findZeroCoordinates(tiles);
		
		if(coords[1] != 2) {
			if(tiles[coords[0]][coords[1]+1] != -1) { //east
				tempBoard.tiles[coords[0]][coords[1]] = tiles[coords[0]][coords[1]+1];
				tempBoard.tiles[coords[0]][coords[1]+1] = 0;
				successors.add(tempBoard);
				tempBoard = new Board(tiles);
			}
		}
		if(coords[0] != 4) {
			if(tiles[coords[0]+1][coords[1]] != -1) { //south
				tempBoard.tiles[coords[0]][coords[1]] = tiles[coords[0]+1][coords[1]]; //swap
				tempBoard.tiles[coords[0]+1][coords[1]] = 0; //values
				successors.add(tempBoard); //add to successors list
				tempBoard = new Board(tiles);
			}
		}
		if(coords[1] != 0) {
			if(tiles[coords[0]][coords[1]-1] != -1) { //west
				tempBoard.tiles[coords[0]][coords[1]] = tiles[coords[0]][coords[1]-1]; //swap
				tempBoard.tiles[coords[0]][coords[1]-1] = 0; //values
				successors.add(tempBoard); //add to successors list
				tempBoard = new Board(tiles);
			}
		}
		if(coords[0] != 0) {
			if(tiles[coords[0]-1][coords[1]] != -1) { //north
				tempBoard.tiles[coords[0]][coords[1]] = tiles[coords[0]-1][coords[1]]; //swap
				tempBoard.tiles[coords[0]-1][coords[1]] = 0; //values
				successors.add(tempBoard); //add to successors list
			}
		}
		return successors;
	}
	
	public void print()
	{
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (j > 0) {
					System.out.print("\t");
				}
				System.out.print(tiles[i][j]);
			}
			System.out.println();
		}
	}
	
	public void setParent(Board parentBoard)
	{
		parent = parentBoard;
	}
	
	public Board getParent()
	{
		return parent;
	}
	
	/* 
	private int[] findZeroCoordinates(int[][] board) {
	
		int[] coordinates = new int[2]; //coordinates[0] = row, coordinates[1] = column
		boolean done = false;
		
		for (int i = 0; i < rows & !done; i++) {
			for (int j = 0; j < columns & !done; j++) {
				if(tiles[i][j] == 0) {
					coordinates[0] = i;
					coordinates[1] = j;
					done = true;
				}
			}
		}
		return coordinates;
	}
	
}
