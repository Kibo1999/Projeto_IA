package mummymaze;

import agent.Action;

public class ActionUp extends Action<MummyMazeState> {

    public ActionUp() {
        super(1);
    }

    @Override
    public void execute(MummyMazeState state, Cell character) {
        state.moveUp(character);
        state.setAction(this);
    }

    @Override
    public boolean isValid(MummyMazeState state, Cell character) {
        return state.canMoveUp(character);
    }
}
