package Tiles.Structs;

public class Health {
    private Integer healthPool;
    private Integer healthAmount;

    public Health (Integer healthPool,Integer healthAmount){
        this.healthPool = healthPool;
        this.healthAmount = healthAmount;
    }

    public void setHealthPool (Integer newHealthPool) { healthPool = newHealthPool;}
    public void setHealthAmount (Integer newHealthAmount) {
        healthAmount = Math.min(newHealthAmount, healthPool);
    }

    public Integer getHealthPool() {return healthPool;}
    public Integer getHealthAmount() { return healthAmount;}
}
