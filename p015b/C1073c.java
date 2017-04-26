package p015b;

import java.io.Closeable;
import java.io.Flushable;
import p015b.p016a.p017a.C0958d;
import p015b.p016a.p017a.C0959e;

/* renamed from: b.c */
public final class C1073c implements Closeable, Flushable {
    final C0959e f2353a;
    private final C0958d f2354b;

    public void flush() {
        this.f2354b.flush();
    }

    public void close() {
        this.f2354b.close();
    }
}
