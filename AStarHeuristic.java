/* An interface for the A* Heuristic. 
 * @author Bob (Robert) Wagner
 */
public interface AStarHeuristic {
	
	/* This method must be implemented to retrieve the cost 
	 * of reaching the goal board state from the current
	 * board state.
	 */
	public int getCost(Board state, Board goalState);
}
