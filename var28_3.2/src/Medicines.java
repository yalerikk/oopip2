abstract class Medicines {
    private double cost;

    private String type;

    public Medicines(double cost, String type){
        this.cost = cost;
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }
}
