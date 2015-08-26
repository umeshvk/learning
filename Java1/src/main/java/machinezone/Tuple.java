package machinezone;

/**
 * Created by umesh on 8/25/15.
 */
public class Tuple<T1, T2> {
    T1 v1;
    T2 v2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;

        Tuple tuple = (Tuple) o;

        if (!v1.equals(tuple.v1)) return false;
        if (!v2.equals(tuple.v2)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = v1.hashCode();
        result = 31 * result + v2.hashCode();
        return result;
    }

    public String toString() {
        return v1.toString() + "," + v2.toString();
    }
}

