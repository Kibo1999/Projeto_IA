package mummymaze;

import agent.Action;
import agent.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MummyMazeProblem extends Problem<MummyMazeState> {

    public MummyMazeProblem(MummyMazeState state) {
        super(new ArrayList<>(5), state);
        createAvailableActionsList(actions);
    }

    private void createAvailableActionsList(List<Action> actions) {
        actions.add(new ActionLeft());
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionStay());
    }


    @Override
    public LinkedList<MummyMazeState> executeAction(MummyMazeState state) {
        LinkedList<MummyMazeState> successors = new LinkedList<>();
        for (Action a: actions){
            if (a.isValid(state)){
                MummyMazeState newState = (MummyMazeState) state.clone();
                a.execute(newState);
                successors.add(newState);
            }
        }
        return successors;
    }

    @Override
    public boolean isGoal(MummyMazeState state) {

        return false;
    }

    public void setAction(mummymaze.ActionDown actionDown) {
    }
}
