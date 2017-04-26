package p018c;

/* renamed from: c.p */
final class C1144p {
    static C1143o f2664a;
    static long f2665b;

    private C1144p() {
    }

    static C1143o m4909a() {
        synchronized (C1144p.class) {
            if (f2664a != null) {
                C1143o c1143o = f2664a;
                f2664a = c1143o.f2662f;
                c1143o.f2662f = null;
                f2665b -= 8192;
                return c1143o;
            }
            return new C1143o();
        }
    }

    static void m4910a(C1143o c1143o) {
        if (c1143o.f2662f != null || c1143o.f2663g != null) {
            throw new IllegalArgumentException();
        } else if (!c1143o.f2660d) {
            synchronized (C1144p.class) {
                if (f2665b + 8192 > 65536) {
                    return;
                }
                f2665b += 8192;
                c1143o.f2662f = f2664a;
                c1143o.f2659c = 0;
                c1143o.f2658b = 0;
                f2664a = c1143o;
            }
        }
    }
}
