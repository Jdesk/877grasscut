package p015b;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p015b.p016a.C1022c;
import p015b.p016a.p019b.C0965c;
import p015b.p016a.p019b.C0966d;
import p015b.p016a.p019b.C0969g;
import p015b.p016a.p024f.C1052e;

/* renamed from: b.j */
public final class C1086j {
    static final /* synthetic */ boolean f2437c;
    private static final Executor f2438d;
    final C0966d f2439a;
    boolean f2440b;
    private final int f2441e;
    private final long f2442f;
    private final Runnable f2443g;
    private final Deque<C0965c> f2444h;

    /* renamed from: b.j.1 */
    class C10851 implements Runnable {
        final /* synthetic */ C1086j f2436a;

        C10851(C1086j c1086j) {
            this.f2436a = c1086j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r8 = this;
            r6 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        L_0x0003:
            r0 = r8.f2436a;
            r2 = java.lang.System.nanoTime();
            r0 = r0.m4498a(r2);
            r2 = -1;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 != 0) goto L_0x0014;
        L_0x0013:
            return;
        L_0x0014:
            r2 = 0;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 <= 0) goto L_0x0003;
        L_0x001a:
            r2 = r0 / r6;
            r4 = r2 * r6;
            r0 = r0 - r4;
            r4 = r8.f2436a;
            monitor-enter(r4);
            r5 = r8.f2436a;	 Catch:{ InterruptedException -> 0x002d }
            r0 = (int) r0;	 Catch:{ InterruptedException -> 0x002d }
            r5.wait(r2, r0);	 Catch:{ InterruptedException -> 0x002d }
        L_0x0028:
            monitor-exit(r4);	 Catch:{ all -> 0x002a }
            goto L_0x0003;
        L_0x002a:
            r0 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x002a }
            throw r0;
        L_0x002d:
            r0 = move-exception;
            goto L_0x0028;
            */
            throw new UnsupportedOperationException("Method not decompiled: b.j.1.run():void");
        }
    }

    static {
        f2437c = !C1086j.class.desiredAssertionStatus();
        f2438d = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1022c.m4231a("OkHttp ConnectionPool", true));
    }

    public C1086j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public C1086j(int i, long j, TimeUnit timeUnit) {
        this.f2443g = new C10851(this);
        this.f2444h = new ArrayDeque();
        this.f2439a = new C0966d();
        this.f2441e = i;
        this.f2442f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    C0965c m4499a(C1064a c1064a, C0969g c0969g) {
        if (f2437c || Thread.holdsLock(this)) {
            for (C0965c c0965c : this.f2444h) {
                if (c0965c.f1959g.size() < c0965c.f1958f && c1064a.equals(c0965c.m3866a().f2343a) && !c0965c.f1960h) {
                    c0969g.m3900a(c0965c);
                    return c0965c;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    void m4500a(C0965c c0965c) {
        if (f2437c || Thread.holdsLock(this)) {
            if (!this.f2440b) {
                this.f2440b = true;
                f2438d.execute(this.f2443g);
            }
            this.f2444h.add(c0965c);
            return;
        }
        throw new AssertionError();
    }

    boolean m4501b(C0965c c0965c) {
        if (!f2437c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (c0965c.f1960h || this.f2441e == 0) {
            this.f2444h.remove(c0965c);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }

    long m4498a(long j) {
        C0965c c0965c = null;
        long j2 = Long.MIN_VALUE;
        synchronized (this) {
            int i = 0;
            int i2 = 0;
            for (C0965c c0965c2 : this.f2444h) {
                long j3;
                if (m4497a(c0965c2, j) > 0) {
                    i2++;
                } else {
                    C0965c c0965c3;
                    int i3 = i + 1;
                    long j4 = j - c0965c2.f1961i;
                    if (j4 > j2) {
                        long j5 = j4;
                        c0965c3 = c0965c2;
                        j3 = j5;
                    } else {
                        c0965c3 = c0965c;
                        j3 = j2;
                    }
                    j2 = j3;
                    c0965c = c0965c3;
                    i = i3;
                }
            }
            if (j2 >= this.f2442f || i > this.f2441e) {
                this.f2444h.remove(c0965c);
                C1022c.m4235a(c0965c.m3872c());
                return 0;
            }
            if (i > 0) {
                j3 = this.f2442f - j2;
                return j3;
            } else if (i2 > 0) {
                j3 = this.f2442f;
                return j3;
            } else {
                this.f2440b = false;
                return -1;
            }
        }
    }

    private int m4497a(C0965c c0965c, long j) {
        List list = c0965c.f1959g;
        int i = 0;
        while (i < list.size()) {
            if (((Reference) list.get(i)).get() != null) {
                i++;
            } else {
                C1052e.m4342b().m4346a(5, "A connection to " + c0965c.m3866a().m4460a().m4395a() + " was leaked. Did you forget to close a response body?", null);
                list.remove(i);
                c0965c.f1960h = true;
                if (list.isEmpty()) {
                    c0965c.f1961i = j - this.f2442f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
