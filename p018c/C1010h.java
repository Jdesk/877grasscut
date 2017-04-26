package p018c;

/* renamed from: c.h */
public abstract class C1010h implements C0946s {
    private final C0946s delegate;

    public C1010h(C0946s c0946s) {
        if (c0946s == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = c0946s;
    }

    public final C0946s delegate() {
        return this.delegate;
    }

    public long read(C1129c c1129c, long j) {
        return this.delegate.read(c1129c, j);
    }

    public C0993t timeout() {
        return this.delegate.timeout();
    }

    public void close() {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
