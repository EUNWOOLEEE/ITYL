package part09.ch13.sec02.exam01;

public class Product<T1, T2> {
    public T1 kind;
    public T2 model;

    public void setKind(T1 kind) {
        this.kind = kind;
    }

    public void setModel(T2 model) {
        this.model = model;
    }

    public T1 getKind() {
        return kind;
    }

    public T2 getModel() {
        return model;
    }
}
