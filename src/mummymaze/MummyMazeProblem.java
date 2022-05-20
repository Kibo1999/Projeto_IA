package mummymaze;

import agent.Action;
import agent.Problem;
import eightpuzzle.ActionDown;
import eightpuzzle.ActionLeft;
import eightpuzzle.ActionRight;
import eightpuzzle.ActionUp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MummyMazeProblem extends Problem<MummyMazeState> {


    public MummyMazeProblem(List<Action> actions, MummyMazeState initialState) {
        super(actions, initialState);
    }

    public MummyMazeProblem(MummyMazeState state) {
        super(new ArrayList<>(5), state);
        createAvailableActionsList(actions);
    }

    private void createAvailableActionsList(List<Action> actions) {
        actions.add(new ActionLeft());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionUp());
        actions.add(new ActionStay());
    }


    @Override
    public LinkedList<MummyMazeState> executeAction(MummyMazeState state) {
        return null;
    }

    @Override
    public boolean isGoal(MummyMazeState state) {
        return false;
    }

    public void setAction(mummymaze.ActionDown actionDown) {
    }
}
