package mummymaze;

import agent.Action;

public class ActionStay extends Action<MummyMazeState> {

    public ActionStay() {
        super(1);
    }

    @Override
    public void execute(MummyMazeState state, Cell character) {
        state.stay(character);
        state.setAction(this);
    }

    @Override
    public boolean isValid(MummyMazeState state, Cell character) {
        return state.canStay(character);
    }
}
