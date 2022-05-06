package mummymaze;

import agent.Agent;
import eightpuzzle.EightPuzzleState;

import java.io.File;
import java.io.FileNotFoundException;
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

    public static MummyMazeState readInitialStateFromFile(File file) throws FileNotFoundException {
        java.util.Scanner scanner = new java.util.Scanner(file);

        char[][] matrix = new char [13][13];

        for (int i = 0; i < 13; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        initialEnvironment = new MummyMazeState(matrix);
        resetEnvironment();
        return environment;
    }

    public List<String> getTurns() {
        return null;
    }

    public double getSolutionCost() {
        return 0;
    }
}
