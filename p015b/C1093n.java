package p015b;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p015b.C1117y.C1116a;
import p015b.p016a.C1022c;

/* renamed from: b.n */
public final class C1093n {
    private int f2471a;
    private int f2472b;
    private Runnable f2473c;
    private ExecutorService f2474d;
    private final Deque<C1116a> f2475e;
    private final Deque<C1116a> f2476f;
    private final Deque<C1117y> f2477g;

    public C1093n() {
        this.f2471a = 64;
        this.f2472b = 5;
        this.f2475e = new ArrayDeque();
        this.f2476f = new ArrayDeque();
        this.f2477g = new ArrayDeque();
    }

    public synchronized ExecutorService m4541a() {
        if (this.f2474d == null) {
            this.f2474d = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1022c.m4231a("OkHttp Dispatcher", false));
        }
        return this.f2474d;
    }

    synchronized void m4542a(C1116a c1116a) {
        if (this.f2476f.size() >= this.f2471a || m4539c(c1116a) >= this.f2472b) {
            this.f2475e.add(c1116a);
        } else {
            this.f2476f.add(c1116a);
            m4541a().execute(c1116a);
        }
    }

    public synchronized void m4544b() {
        for (C1116a b : this.f2475e) {
            b.m4687b().m4698c();
        }
        for (C1116a b2 : this.f2476f) {
            b2.m4687b().m4698c();
        }
        for (C1117y c : this.f2477g) {
            c.m4698c();
        }
    }

    private void m4540d() {
        if (this.f2476f.size() < this.f2471a && !this.f2475e.isEmpty()) {
            Iterator it = this.f2475e.iterator();
            while (it.hasNext()) {
                C1116a c1116a = (C1116a) it.next();
                if (m4539c(c1116a) < this.f2472b) {
                    it.remove();
                    this.f2476f.add(c1116a);
                    m4541a().execute(c1116a);
                }
                if (this.f2476f.size() >= this.f2471a) {
                    return;
                }
            }
        }
    }

    private int m4539c(C1116a c1116a) {
        int i = 0;
        for (C1116a a : this.f2476f) {
            int i2;
            if (a.m4686a().equals(c1116a.m4686a())) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    synchronized void m4543a(C1117y c1117y) {
        this.f2477g.add(c1117y);
    }

    void m4545b(C1116a c1116a) {
        m4538a(this.f2476f, c1116a, true);
    }

    void m4546b(C1117y c1117y) {
        m4538a(this.f2477g, c1117y, false);
    }

    private <T> void m4538a(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m4540d();
                }
                int c = m4547c();
                Runnable runnable = this.f2473c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (c == 0 && runnable != null) {
            runnable.run();
        }
    }

    public synchronized int m4547c() {
        return this.f2476f.size() + this.f2477g.size();
    }
}
