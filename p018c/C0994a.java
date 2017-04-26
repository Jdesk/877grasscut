package p018c;

import java.io.IOException;
import java.io.InterruptedIOException;

/* renamed from: c.a */
public class C0994a extends C0993t {
    private static C0994a f2093a;
    private boolean f2094c;
    private C0994a f2095d;
    private long f2096e;

    /* renamed from: c.a.1 */
    class C11211 implements C0954r {
        final /* synthetic */ C0954r f2614a;
        final /* synthetic */ C0994a f2615b;

        C11211(C0994a c0994a, C0954r c0954r) {
            this.f2615b = c0994a;
            this.f2614a = c0954r;
        }

        public void m4731a(C1129c c1129c, long j) {
            C1147u.m4929a(c1129c.f2624b, 0, j);
            long j2 = j;
            while (j2 > 0) {
                C1143o c1143o = c1129c.f2623a;
                long j3 = 0;
                while (j3 < 65536) {
                    long j4 = ((long) (c1129c.f2623a.f2659c - c1129c.f2623a.f2658b)) + j3;
                    if (j4 >= j2) {
                        j3 = j2;
                        break;
                    } else {
                        c1143o = c1143o.f2662f;
                        j3 = j4;
                    }
                }
                this.f2615b.m4043c();
                try {
                    this.f2614a.m3815a(c1129c, j3);
                    j2 -= j3;
                    this.f2615b.m4041a(true);
                } catch (IOException e) {
                    throw this.f2615b.m4042b(e);
                } catch (Throwable th) {
                    this.f2615b.m4041a(false);
                }
            }
        }

        public void flush() {
            this.f2615b.m4043c();
            try {
                this.f2614a.flush();
                this.f2615b.m4041a(true);
            } catch (IOException e) {
                throw this.f2615b.m4042b(e);
            } catch (Throwable th) {
                this.f2615b.m4041a(false);
            }
        }

        public void close() {
            this.f2615b.m4043c();
            try {
                this.f2614a.close();
                this.f2615b.m4041a(true);
            } catch (IOException e) {
                throw this.f2615b.m4042b(e);
            } catch (Throwable th) {
                this.f2615b.m4041a(false);
            }
        }

        public C0993t timeout() {
            return this.f2615b;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f2614a + ")";
        }
    }

    /* renamed from: c.a.2 */
    class C11222 implements C0946s {
        final /* synthetic */ C0946s f2616a;
        final /* synthetic */ C0994a f2617b;

        C11222(C0994a c0994a, C0946s c0946s) {
            this.f2617b = c0994a;
            this.f2616a = c0946s;
        }

        public long read(C1129c c1129c, long j) {
            this.f2617b.m4043c();
            try {
                long read = this.f2616a.read(c1129c, j);
                this.f2617b.m4041a(true);
                return read;
            } catch (IOException e) {
                throw this.f2617b.m4042b(e);
            } catch (Throwable th) {
                this.f2617b.m4041a(false);
            }
        }

        public void close() {
            try {
                this.f2616a.close();
                this.f2617b.m4041a(true);
            } catch (IOException e) {
                throw this.f2617b.m4042b(e);
            } catch (Throwable th) {
                this.f2617b.m4041a(false);
            }
        }

        public C0993t timeout() {
            return this.f2617b;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f2616a + ")";
        }
    }

    /* renamed from: c.a.a */
    private static final class C1123a extends Thread {
        public C1123a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            while (true) {
                try {
                    C0994a e = C0994a.m4036e();
                    if (e != null) {
                        e.m4040a();
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    public final void m4043c() {
        if (this.f2094c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long o_ = o_();
        boolean p_ = p_();
        if (o_ != 0 || p_) {
            this.f2094c = true;
            C0994a.m4033a(this, o_, p_);
        }
    }

    private static synchronized void m4033a(C0994a c0994a, long j, boolean z) {
        synchronized (C0994a.class) {
            if (f2093a == null) {
                f2093a = new C0994a();
                new C1123a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                c0994a.f2096e = Math.min(j, c0994a.m4030d() - nanoTime) + nanoTime;
            } else if (j != 0) {
                c0994a.f2096e = nanoTime + j;
            } else if (z) {
                c0994a.f2096e = c0994a.m4030d();
            } else {
                throw new AssertionError();
            }
            long b = c0994a.m4035b(nanoTime);
            C0994a c0994a2 = f2093a;
            while (c0994a2.f2095d != null && b >= c0994a2.f2095d.m4035b(nanoTime)) {
                c0994a2 = c0994a2.f2095d;
            }
            c0994a.f2095d = c0994a2.f2095d;
            c0994a2.f2095d = c0994a;
            if (c0994a2 == f2093a) {
                C0994a.class.notify();
            }
        }
    }

    public final boolean n_() {
        if (!this.f2094c) {
            return false;
        }
        this.f2094c = false;
        return C0994a.m4034a(this);
    }

    private static synchronized boolean m4034a(C0994a c0994a) {
        boolean z;
        synchronized (C0994a.class) {
            for (C0994a c0994a2 = f2093a; c0994a2 != null; c0994a2 = c0994a2.f2095d) {
                if (c0994a2.f2095d == c0994a) {
                    c0994a2.f2095d = c0994a.f2095d;
                    c0994a.f2095d = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    private long m4035b(long j) {
        return this.f2096e - j;
    }

    protected void m4040a() {
    }

    public final C0954r m4037a(C0954r c0954r) {
        return new C11211(this, c0954r);
    }

    public final C0946s m4038a(C0946s c0946s) {
        return new C11222(this, c0946s);
    }

    final void m4041a(boolean z) {
        if (n_() && z) {
            throw m4039a(null);
        }
    }

    final IOException m4042b(IOException iOException) {
        return !n_() ? iOException : m4039a(iOException);
    }

    protected IOException m4039a(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    static synchronized C0994a m4036e() {
        C0994a c0994a = null;
        synchronized (C0994a.class) {
            C0994a c0994a2 = f2093a.f2095d;
            if (c0994a2 == null) {
                C0994a.class.wait();
            } else {
                long b = c0994a2.m4035b(System.nanoTime());
                if (b > 0) {
                    long j = b / 1000000;
                    C0994a.class.wait(j, (int) (b - (1000000 * j)));
                } else {
                    f2093a.f2095d = c0994a2.f2095d;
                    c0994a2.f2095d = null;
                    c0994a = c0994a2;
                }
            }
        }
        return c0994a;
    }
}
