package p018c;

import java.util.concurrent.TimeUnit;

/* renamed from: c.i */
public class C1132i extends C0993t {
    private C0993t f2633a;

    public C1132i(C0993t c0993t) {
        if (c0993t == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f2633a = c0993t;
    }

    public final C0993t m4845a() {
        return this.f2633a;
    }

    public final C1132i m4844a(C0993t c0993t) {
        if (c0993t == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f2633a = c0993t;
        return this;
    }

    public C0993t m4847a(long j, TimeUnit timeUnit) {
        return this.f2633a.m4029a(j, timeUnit);
    }

    public long o_() {
        return this.f2633a.o_();
    }

    public boolean p_() {
        return this.f2633a.p_();
    }

    public long m4848d() {
        return this.f2633a.m4030d();
    }

    public C0993t m4846a(long j) {
        return this.f2633a.m4028a(j);
    }

    public C0993t q_() {
        return this.f2633a.q_();
    }

    public C0993t m4849f() {
        return this.f2633a.m4031f();
    }

    public void m4850g() {
        this.f2633a.m4032g();
    }
}
