package codes.egorbos.geekbrains.java;

public enum Color {
    RED,
    GREY,
    WHITE,
    BLACK;

    @Override
    public String toString() {
        switch (this.ordinal()) {
            case 0:
                return "красный";
            case 1:
                return "серый";
            case 2:
                return "белый";
            case 3:
                return "черный";
            default:
                return "";
        }
    }
}
