package mummymaze;

import agent.Action;

public class ActionDown extends Action<MummyMazeState> {

    public ActionDown() {
        super(1);
    }

    @Override
    public void execute(MummyMazeState state,Cell character) {
        state.moveDown(character);
        state.setAction(this);
    }

    @Override
    public boolean isValid(MummyMazeState state,Cell character) {
        return state.canMoveDown(character);
    }
}
