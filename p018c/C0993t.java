package p018c;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: c.t */
public class C0993t {
    public static final C0993t f2089b;
    private boolean f2090a;
    private long f2091c;
    private long f2092d;

    /* renamed from: c.t.1 */
    static class C11461 extends C0993t {
        C11461() {
        }

        public C0993t m4925a(long j, TimeUnit timeUnit) {
            return this;
        }

        public C0993t m4924a(long j) {
            return this;
        }

        public void m4926g() {
        }
    }

    static {
        f2089b = new C11461();
    }

    public C0993t m4029a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.f2092d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long o_() {
        return this.f2092d;
    }

    public boolean p_() {
        return this.f2090a;
    }

    public long m4030d() {
        if (this.f2090a) {
            return this.f2091c;
        }
        throw new IllegalStateException("No deadline");
    }

    public C0993t m4028a(long j) {
        this.f2090a = true;
        this.f2091c = j;
        return this;
    }

    public C0993t q_() {
        this.f2092d = 0;
        return this;
    }

    public C0993t m4031f() {
        this.f2090a = false;
        return this;
    }

    public void m4032g() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f2090a && this.f2091c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
