package mh;

public class GenericPair<T> {

    private final T v1;
    private final T v2;

    public GenericPair(T v1, T v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public T getV1() {
        return v1;
    }

    public T getV2() {
        return v2;
    }
}
