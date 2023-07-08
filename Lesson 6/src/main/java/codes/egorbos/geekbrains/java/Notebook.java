package codes.egorbos.geekbrains.java;

public class Notebook {
    private OsType os;
    private Color color;
    private int ramAmount;
    private int hddCapacity;

    public Notebook(OsType os, Color color, int ramAmount, int hddCapacity) {
        this.os = os;
        this.color = color;
        this.ramAmount = ramAmount;
        this.hddCapacity = hddCapacity;
    }

    public OsType getOs() {
        return os;
    }

    public Color getColor() {
        return color;
    }

    public int getRamAmount() {
        return ramAmount;
    }

    public int getHddCapacity() {
        return hddCapacity;
    }

    @Override
    public String toString() {
        return String.format("Ноутбук: цвет - %s, ОС - %s, RAM - %d Гб, HDD - %d Гб.", color, os, ramAmount, hddCapacity);
    }
}