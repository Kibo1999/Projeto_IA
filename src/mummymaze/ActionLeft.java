package mummymaze;

import agent.Action;

public class ActionLeft extends Action<MummyMazeState> {

    public ActionLeft() {
        super(1);
    }

    @Override
    public void execute(MummyMazeState state, Cell character) {
        state.moveLeft(character);
        state.setAction(this);
    }

    @Override
    public boolean isValid(MummyMazeState state, Cell character) {
        return state.canMoveLeft(character);
    }
}
