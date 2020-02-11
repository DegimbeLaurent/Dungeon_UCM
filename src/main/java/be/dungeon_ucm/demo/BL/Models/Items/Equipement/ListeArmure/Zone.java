package be.dungeon_ucm.demo.BL.Models.Items.Equipement.ListeArmure;

public enum Zone {

    TORSE("torse"),
    MAIN("bras"),
    JAMBES("jambes"),
    TETE("tete"),
    PIEDS("pieds");

    private String zoneApplicable;

    Zone(String zoneApplicable) {
        this.zoneApplicable = zoneApplicable;
    }

    public String getZoneApplicable() {
        return zoneApplicable;
    }

    public void setZoneApplicable(String zoneApplicable) {
        this.zoneApplicable = zoneApplicable;
    }

}
