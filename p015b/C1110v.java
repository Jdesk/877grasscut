package p015b;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import p015b.p016a.C1022c;
import p018c.C1127d;
import p018c.C1129c;
import p018c.C1130f;

/* renamed from: b.v */
public final class C1110v extends aa {
    public static final C1107u f2526a;
    public static final C1107u f2527b;
    public static final C1107u f2528c;
    public static final C1107u f2529d;
    public static final C1107u f2530e;
    private static final byte[] f2531f;
    private static final byte[] f2532g;
    private static final byte[] f2533h;
    private final C1130f f2534i;
    private final C1107u f2535j;
    private final C1107u f2536k;
    private final List<C1109b> f2537l;
    private long f2538m;

    /* renamed from: b.v.a */
    public static final class C1108a {
        private final C1130f f2521a;
        private C1107u f2522b;
        private final List<C1109b> f2523c;

        public C1108a() {
            this(UUID.randomUUID().toString());
        }

        public C1108a(String str) {
            this.f2522b = C1110v.f2526a;
            this.f2523c = new ArrayList();
            this.f2521a = C1130f.m4827a(str);
        }

        public C1108a m4637a(C1107u c1107u) {
            if (c1107u == null) {
                throw new NullPointerException("type == null");
            } else if (c1107u.m4633a().equals("multipart")) {
                this.f2522b = c1107u;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != " + c1107u);
            }
        }

        public C1108a m4636a(C1102r c1102r, aa aaVar) {
            return m4638a(C1109b.m4641a(c1102r, aaVar));
        }

        public C1108a m4638a(C1109b c1109b) {
            if (c1109b == null) {
                throw new NullPointerException("part == null");
            }
            this.f2523c.add(c1109b);
            return this;
        }

        public C1110v m4639a() {
            if (!this.f2523c.isEmpty()) {
                return new C1110v(this.f2521a, this.f2522b, this.f2523c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* renamed from: b.v.b */
    public static final class C1109b {
        private final C1102r f2524a;
        private final aa f2525b;

        public static C1109b m4641a(C1102r c1102r, aa aaVar) {
            if (aaVar == null) {
                throw new NullPointerException("body == null");
            } else if (c1102r != null && c1102r.m4569a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (c1102r == null || c1102r.m4569a("Content-Length") == null) {
                return new C1109b(c1102r, aaVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        private C1109b(C1102r c1102r, aa aaVar) {
            this.f2524a = c1102r;
            this.f2525b = aaVar;
        }
    }

    static {
        f2526a = C1107u.m4632a("multipart/mixed");
        f2527b = C1107u.m4632a("multipart/alternative");
        f2528c = C1107u.m4632a("multipart/digest");
        f2529d = C1107u.m4632a("multipart/parallel");
        f2530e = C1107u.m4632a("multipart/form-data");
        f2531f = new byte[]{(byte) 58, (byte) 32};
        f2532g = new byte[]{(byte) 13, (byte) 10};
        f2533h = new byte[]{(byte) 45, (byte) 45};
    }

    C1110v(C1130f c1130f, C1107u c1107u, List<C1109b> list) {
        this.f2538m = -1;
        this.f2534i = c1130f;
        this.f2535j = c1107u;
        this.f2536k = C1107u.m4632a(c1107u + "; boundary=" + c1130f.m4832a());
        this.f2537l = C1022c.m4228a((List) list);
    }

    public C1107u contentType() {
        return this.f2536k;
    }

    public long contentLength() {
        long j = this.f2538m;
        if (j != -1) {
            return j;
        }
        j = m4643a(null, true);
        this.f2538m = j;
        return j;
    }

    public void writeTo(C1127d c1127d) {
        m4643a(c1127d, false);
    }

    private long m4643a(C1127d c1127d, boolean z) {
        C1129c c1129c;
        long j = 0;
        if (z) {
            C1129c c1129c2 = new C1129c();
            c1129c = c1129c2;
            c1127d = c1129c2;
        } else {
            c1129c = null;
        }
        int size = this.f2537l.size();
        for (int i = 0; i < size; i++) {
            C1109b c1109b = (C1109b) this.f2537l.get(i);
            C1102r a = c1109b.f2524a;
            aa b = c1109b.f2525b;
            c1127d.m4738c(f2533h);
            c1127d.m4736b(this.f2534i);
            c1127d.m4738c(f2532g);
            if (a != null) {
                int a2 = a.m4567a();
                for (int i2 = 0; i2 < a2; i2++) {
                    c1127d.m4737b(a.m4568a(i2)).m4738c(f2531f).m4737b(a.m4570b(i2)).m4738c(f2532g);
                }
            }
            C1107u contentType = b.contentType();
            if (contentType != null) {
                c1127d.m4737b("Content-Type: ").m4737b(contentType.toString()).m4738c(f2532g);
            }
            long contentLength = b.contentLength();
            if (contentLength != -1) {
                c1127d.m4737b("Content-Length: ").m4745k(contentLength).m4738c(f2532g);
            } else if (z) {
                c1129c.m4821r();
                return -1;
            }
            c1127d.m4738c(f2532g);
            if (z) {
                j += contentLength;
            } else {
                b.writeTo(c1127d);
            }
            c1127d.m4738c(f2532g);
        }
        c1127d.m4738c(f2533h);
        c1127d.m4736b(this.f2534i);
        c1127d.m4738c(f2533h);
        c1127d.m4738c(f2532g);
        if (!z) {
            return j;
        }
        j += c1129c.m4765a();
        c1129c.m4821r();
        return j;
    }
}
