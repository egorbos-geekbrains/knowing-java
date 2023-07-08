package codes.egorbos.geekbrains.java;

public enum OsType {
    NONE,
    LINUX,
    WINDOWS10,
    WINDOWS11;

    @Override
    public String toString() {
        switch (this.ordinal()) {
            case 0:
                return "отсутствует";
            case 1:
                return "Linux";
            case 2:
                return "Windows 10";
            case 3:
                return "Windows 11";
            default:
                return "";
        }
    }
}