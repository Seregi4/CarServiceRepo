import java.util.Objects;

public class ClassTest {
    private  int id;
    private int volume;

    public ClassTest(int id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "ClassTest{" +
                "id=" + id +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTest classTest = (ClassTest) o;
        return id == classTest.id && volume == classTest.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, volume);
    }
}
