/* This heuristic is to be applied to the A* search
 * algorithm implemented in AStar.java.
 * It effectively mimics an uninformed search algorithm
 * (as opposed to A* search, which is informed by
 * heuristics) by always returning a cost of 0.
 * @author Bob (Robert) Wagner
 */
public class EmptyHeuristic implements AStarHeuristic {
	
	/* We return a cost of 0 for any beginning and goal 
	 * board states such that we eliminate the effect 
	 * heuristics have in an informed search algorithm.
	 */
	public int getCost(Board state, Board goalState) {
		return 0;
	}
}
