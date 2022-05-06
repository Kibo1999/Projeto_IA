package mummymaze;

import agent.Agent;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class MummyMazeAgent extends Agent<MummyMazeState> {


    public MummyMazeAgent(MummyMazeState environment) {
        super(environment);
        // ola mundo
        // ola jose

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // teste 3
    }

    public static MummyMazeState readInitialStateFromFile(File file) {
        return null;
    }

    public List<String> getTurns() {
        return null;
    }

    public double getSolutionCost() {
        return 0;
    }
}
