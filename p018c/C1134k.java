package p018c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

/* renamed from: c.k */
public final class C1134k implements C0946s {
    private final C1128e f2639a;
    private final Inflater f2640b;
    private int f2641c;
    private boolean f2642d;

    public C1134k(C0946s c0946s, Inflater inflater) {
        this(C1138l.m4861a(c0946s), inflater);
    }

    C1134k(C1128e c1128e, Inflater inflater) {
        if (c1128e == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f2639a = c1128e;
            this.f2640b = inflater;
        }
    }

    public long read(C1129c c1129c, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f2642d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean a;
            do {
                a = m4856a();
                try {
                    C1143o e = c1129c.m4796e(1);
                    int inflate = this.f2640b.inflate(e.f2657a, e.f2659c, 8192 - e.f2659c);
                    if (inflate > 0) {
                        e.f2659c += inflate;
                        c1129c.f2624b += (long) inflate;
                        return (long) inflate;
                    } else if (this.f2640b.finished() || this.f2640b.needsDictionary()) {
                        m4855b();
                        if (e.f2658b == e.f2659c) {
                            c1129c.f2623a = e.m4904a();
                            C1144p.m4910a(e);
                        }
                        return -1;
                    }
                } catch (Throwable e2) {
                    throw new IOException(e2);
                }
            } while (!a);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public boolean m4856a() {
        if (!this.f2640b.needsInput()) {
            return false;
        }
        m4855b();
        if (this.f2640b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f2639a.m4752e()) {
            return true;
        } else {
            C1143o c1143o = this.f2639a.m4750b().f2623a;
            this.f2641c = c1143o.f2659c - c1143o.f2658b;
            this.f2640b.setInput(c1143o.f2657a, c1143o.f2658b, this.f2641c);
            return false;
        }
    }

    private void m4855b() {
        if (this.f2641c != 0) {
            int remaining = this.f2641c - this.f2640b.getRemaining();
            this.f2641c -= remaining;
            this.f2639a.m4755g((long) remaining);
        }
    }

    public C0993t timeout() {
        return this.f2639a.timeout();
    }

    public void close() {
        if (!this.f2642d) {
            this.f2640b.end();
            this.f2642d = true;
            this.f2639a.close();
        }
    }
}
