package p018c;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: c.g */
public final class C1131g implements C0954r {
    private final C1127d f2630a;
    private final Deflater f2631b;
    private boolean f2632c;

    public C1131g(C0954r c0954r, Deflater deflater) {
        this(C1138l.m4860a(c0954r), deflater);
    }

    C1131g(C1127d c1127d, Deflater deflater) {
        if (c1127d == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f2630a = c1127d;
            this.f2631b = deflater;
        }
    }

    public void m4843a(C1129c c1129c, long j) {
        C1147u.m4929a(c1129c.f2624b, 0, j);
        while (j > 0) {
            C1143o c1143o = c1129c.f2623a;
            int min = (int) Math.min(j, (long) (c1143o.f2659c - c1143o.f2658b));
            this.f2631b.setInput(c1143o.f2657a, c1143o.f2658b, min);
            m4841a(false);
            c1129c.f2624b -= (long) min;
            c1143o.f2658b += min;
            if (c1143o.f2658b == c1143o.f2659c) {
                c1129c.f2623a = c1143o.m4904a();
                C1144p.m4910a(c1143o);
            }
            j -= (long) min;
        }
    }

    @IgnoreJRERequirement
    private void m4841a(boolean z) {
        C1129c b = this.f2630a.m4735b();
        while (true) {
            int deflate;
            C1143o e = b.m4796e(1);
            if (z) {
                deflate = this.f2631b.deflate(e.f2657a, e.f2659c, 8192 - e.f2659c, 2);
            } else {
                deflate = this.f2631b.deflate(e.f2657a, e.f2659c, 8192 - e.f2659c);
            }
            if (deflate > 0) {
                e.f2659c += deflate;
                b.f2624b += (long) deflate;
                this.f2630a.m4746u();
            } else if (this.f2631b.needsInput()) {
                break;
            }
        }
        if (e.f2658b == e.f2659c) {
            b.f2623a = e.m4904a();
            C1144p.m4910a(e);
        }
    }

    public void flush() {
        m4841a(true);
        this.f2630a.flush();
    }

    void m4842a() {
        this.f2631b.finish();
        m4841a(false);
    }

    public void close() {
        if (!this.f2632c) {
            Throwable th;
            Throwable th2 = null;
            try {
                m4842a();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f2631b.end();
                th = th2;
            } catch (Throwable th4) {
                th = th4;
                if (th2 != null) {
                    th = th2;
                }
            }
            try {
                this.f2630a.close();
            } catch (Throwable th22) {
                if (th == null) {
                    th = th22;
                }
            }
            this.f2632c = true;
            if (th != null) {
                C1147u.m4930a(th);
            }
        }
    }

    public C0993t timeout() {
        return this.f2630a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f2630a + ")";
    }
}
