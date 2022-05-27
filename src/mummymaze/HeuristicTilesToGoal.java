package mummymaze;

import agent.Heuristic;

public class HeuristicTilesToGoal extends Heuristic<MummyMazeProblem,MummyMazeState> {
    @Override
    public double compute(MummyMazeState state){
        return state.computeDistanceToGoal();
    }

    @Override
    public String toString(){
        return "Tiles distance to final position";
    }
}
