package agent;


import mummymaze.Cell;

public abstract class Action <S extends State>{

    private final double cost;

    public Action(double cost){
        this.cost = cost;
    }

    public abstract void execute(S State, Cell character);

    public abstract boolean isValid(S State, Cell character);

    public double getCost(){
        return cost;
    }
}
