package p015b;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.io.Closeable;
import p015b.C1102r.C1101a;

/* renamed from: b.ab */
public final class ab implements Closeable {
    private final C1120z f2327a;
    private final C1114x f2328b;
    private final int f2329c;
    private final String f2330d;
    private final C1099q f2331e;
    private final C1102r f2332f;
    private final ac f2333g;
    private final ab f2334h;
    private final ab f2335i;
    private final ab f2336j;
    private final long f2337k;
    private final long f2338l;
    private volatile C1076d f2339m;

    /* renamed from: b.ab.a */
    public static class C1069a {
        private C1120z f2315a;
        private C1114x f2316b;
        private int f2317c;
        private String f2318d;
        private C1099q f2319e;
        private C1101a f2320f;
        private ac f2321g;
        private ab f2322h;
        private ab f2323i;
        private ab f2324j;
        private long f2325k;
        private long f2326l;

        public C1069a() {
            this.f2317c = -1;
            this.f2320f = new C1101a();
        }

        private C1069a(ab abVar) {
            this.f2317c = -1;
            this.f2315a = abVar.f2327a;
            this.f2316b = abVar.f2328b;
            this.f2317c = abVar.f2329c;
            this.f2318d = abVar.f2330d;
            this.f2319e = abVar.f2331e;
            this.f2320f = abVar.f2332f.m4573c();
            this.f2321g = abVar.f2333g;
            this.f2322h = abVar.f2334h;
            this.f2323i = abVar.f2335i;
            this.f2324j = abVar.f2336j;
            this.f2325k = abVar.f2337k;
            this.f2326l = abVar.f2338l;
        }

        public C1069a m4427a(C1120z c1120z) {
            this.f2315a = c1120z;
            return this;
        }

        public C1069a m4426a(C1114x c1114x) {
            this.f2316b = c1114x;
            return this;
        }

        public C1069a m4420a(int i) {
            this.f2317c = i;
            return this;
        }

        public C1069a m4428a(String str) {
            this.f2318d = str;
            return this;
        }

        public C1069a m4424a(C1099q c1099q) {
            this.f2319e = c1099q;
            return this;
        }

        public C1069a m4429a(String str, String str2) {
            this.f2320f.m4564c(str, str2);
            return this;
        }

        public C1069a m4433b(String str, String str2) {
            this.f2320f.m4560a(str, str2);
            return this;
        }

        public C1069a m4425a(C1102r c1102r) {
            this.f2320f = c1102r.m4573c();
            return this;
        }

        public C1069a m4423a(ac acVar) {
            this.f2321g = acVar;
            return this;
        }

        public C1069a m4422a(ab abVar) {
            if (abVar != null) {
                m4407a("networkResponse", abVar);
            }
            this.f2322h = abVar;
            return this;
        }

        public C1069a m4432b(ab abVar) {
            if (abVar != null) {
                m4407a("cacheResponse", abVar);
            }
            this.f2323i = abVar;
            return this;
        }

        private void m4407a(String str, ab abVar) {
            if (abVar.f2333g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (abVar.f2334h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (abVar.f2335i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (abVar.f2336j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public C1069a m4434c(ab abVar) {
            if (abVar != null) {
                m4411d(abVar);
            }
            this.f2324j = abVar;
            return this;
        }

        private void m4411d(ab abVar) {
            if (abVar.f2333g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public C1069a m4421a(long j) {
            this.f2325k = j;
            return this;
        }

        public C1069a m4431b(long j) {
            this.f2326l = j;
            return this;
        }

        public ab m4430a() {
            if (this.f2315a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f2316b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f2317c >= 0) {
                return new ab();
            } else {
                throw new IllegalStateException("code < 0: " + this.f2317c);
            }
        }
    }

    private ab(C1069a c1069a) {
        this.f2327a = c1069a.f2315a;
        this.f2328b = c1069a.f2316b;
        this.f2329c = c1069a.f2317c;
        this.f2330d = c1069a.f2318d;
        this.f2331e = c1069a.f2319e;
        this.f2332f = c1069a.f2320f.m4561a();
        this.f2333g = c1069a.f2321g;
        this.f2334h = c1069a.f2322h;
        this.f2335i = c1069a.f2323i;
        this.f2336j = c1069a.f2324j;
        this.f2337k = c1069a.f2325k;
        this.f2338l = c1069a.f2326l;
    }

    public C1120z m4447a() {
        return this.f2327a;
    }

    public int m4450b() {
        return this.f2329c;
    }

    public boolean m4451c() {
        return this.f2329c >= Callback.DEFAULT_DRAG_ANIMATION_DURATION && this.f2329c < 300;
    }

    public String m4452d() {
        return this.f2330d;
    }

    public C1099q m4453e() {
        return this.f2331e;
    }

    public String m4448a(String str) {
        return m4449a(str, null);
    }

    public String m4449a(String str, String str2) {
        String a = this.f2332f.m4569a(str);
        return a != null ? a : str2;
    }

    public C1102r m4454f() {
        return this.f2332f;
    }

    public ac m4455g() {
        return this.f2333g;
    }

    public C1069a m4456h() {
        return new C1069a();
    }

    public C1076d m4457i() {
        C1076d c1076d = this.f2339m;
        if (c1076d != null) {
            return c1076d;
        }
        c1076d = C1076d.m4471a(this.f2332f);
        this.f2339m = c1076d;
        return c1076d;
    }

    public long m4458j() {
        return this.f2337k;
    }

    public long m4459k() {
        return this.f2338l;
    }

    public void close() {
        this.f2333g.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f2328b + ", code=" + this.f2329c + ", message=" + this.f2330d + ", url=" + this.f2327a.m4723a() + '}';
    }
}
