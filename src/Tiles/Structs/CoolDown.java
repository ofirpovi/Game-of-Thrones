package Tiles.Structs;

public class CoolDown {
    private Integer abilityCoolDown;
    private Integer remainingCoolDown;

    public CoolDown (Integer abilityCoolDown, Integer remainingCoolDown){
        this.abilityCoolDown = abilityCoolDown;
        this.remainingCoolDown = remainingCoolDown;
    }

    public Integer getAbilityCoolDown() {
        return abilityCoolDown;
    }

    public Integer getRemainingCoolDown() {
        return remainingCoolDown;
    }

    public void setAbilityCoolDown(Integer abilityCoolDown) {
        this.abilityCoolDown = abilityCoolDown;
    }

    public void setRemainingCoolDown(Integer remainingCoolDown) {
        this.remainingCoolDown = remainingCoolDown;
    }
}
