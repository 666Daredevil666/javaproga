package Objects;

import java.util.Objects;

public abstract class Obj {
    protected String name;

    public Obj(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Переопределяем equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obj)) return false;
        Obj obj = (Obj) o;
        return Objects.equals(name, obj.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "name='" + name + "'}";
    }
}
