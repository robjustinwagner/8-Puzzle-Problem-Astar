/* This class represents the Frontier of
 * the A* Search algorithm implemented in
 * AStar.java; it holds the current
 * board state we are evaluating as 
 * possible next state.
 *
 * @author Bob (Robert) Wagner
 */
public class Frontier {
	
	private Board wrapperBoard;	//board under evaluation
	private int wrapperCost = 0;	//current cost of reaching the board
	private int wrapperSortVal;	//the sorting value of the board
	
	//constructor
	public Frontier(Board board, int sortVal, int cost) {
		wrapperBoard = board;
		wrapperSortVal = sortVal;
		wrapperCost = cost;
	}
	
	public Board getBoard() {
		return wrapperBoard;
	}
	
	public void setBoard(Board board) {
		wrapperBoard = board;
	}
	
	public int getCost() {
		return wrapperCost;
	}
	
	public void setCost(int cost) {
		wrapperCost = cost;
	}
	
	public void setSortVal(int val) {
		wrapperSortVal = val;
	}
	
	public int getSortVal() {
		return wrapperSortVal;
	}

}
