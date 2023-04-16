package model;

public class Country implements Comparable<Country> {

    private String name;
    private int gold;
    private int silver;
    private int bronze;

    public Country(String name) {
        this.name = name;
        this.gold = 0;
        this.silver = 0;
        this.bronze = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getTotalMedals() {
        return gold + silver + bronze;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nGolden medals: " + gold +
                "\nSilver medals: " + silver +
                "\nBronze medals: " + bronze;
    }

    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.getName());
    }
}
