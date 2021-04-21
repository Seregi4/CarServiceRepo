public class Taburetka {
    private int nozkiCount;
    private String name;

    public Taburetka(int nozkiCount, String name) {
        this.nozkiCount = nozkiCount;
        this.name = name;
    }

    public Taburetka(int nozkiCount) {
        this.nozkiCount = nozkiCount;
    }

    public Taburetka(String name) {
        this.name = name;
    }

    public int getNozkiCount() {
        return nozkiCount;
    }

    public void setNozkiCount(int nozkiCount) {
        this.nozkiCount = nozkiCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
