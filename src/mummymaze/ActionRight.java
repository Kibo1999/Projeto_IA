package mummymaze;

import agent.Action;

public class ActionRight extends Action<MummyMazeState> {

    public ActionRight() {
        super(1);
    }

    @Override
    public void execute(MummyMazeState state, Cell character) {
        state.moveRight(character);
        state.setAction(this);
    }

    @Override
    public boolean isValid(MummyMazeState state,Cell character) {
        return state.canMoveRight(character);
    }
}
