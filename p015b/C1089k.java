package p015b;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p015b.p016a.C1022c;

/* renamed from: b.k */
public final class C1089k {
    public static final C1089k f2449a;
    public static final C1089k f2450b;
    public static final C1089k f2451c;
    private static final C1084h[] f2452d;
    private final boolean f2453e;
    private final boolean f2454f;
    private final String[] f2455g;
    private final String[] f2456h;

    /* renamed from: b.k.a */
    public static final class C1088a {
        private boolean f2445a;
        private String[] f2446b;
        private String[] f2447c;
        private boolean f2448d;

        C1088a(boolean z) {
            this.f2445a = z;
        }

        public C1088a(C1089k c1089k) {
            this.f2445a = c1089k.f2453e;
            this.f2446b = c1089k.f2455g;
            this.f2447c = c1089k.f2456h;
            this.f2448d = c1089k.f2454f;
        }

        public C1088a m4508a(C1084h... c1084hArr) {
            if (this.f2445a) {
                String[] strArr = new String[c1084hArr.length];
                for (int i = 0; i < c1084hArr.length; i++) {
                    strArr[i] = c1084hArr[i].aS;
                }
                return m4509a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C1088a m4509a(String... strArr) {
            if (!this.f2445a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            } else {
                this.f2446b = (String[]) strArr.clone();
                return this;
            }
        }

        public C1088a m4507a(ae... aeVarArr) {
            if (this.f2445a) {
                String[] strArr = new String[aeVarArr.length];
                for (int i = 0; i < aeVarArr.length; i++) {
                    strArr[i] = aeVarArr[i].f2351e;
                }
                return m4511b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C1088a m4511b(String... strArr) {
            if (!this.f2445a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            } else {
                this.f2447c = (String[]) strArr.clone();
                return this;
            }
        }

        public C1088a m4506a(boolean z) {
            if (this.f2445a) {
                this.f2448d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C1089k m4510a() {
            return new C1089k();
        }
    }

    static {
        f2452d = new C1084h[]{C1084h.aK, C1084h.aO, C1084h.f2406W, C1084h.am, C1084h.al, C1084h.av, C1084h.aw, C1084h.f2389F, C1084h.f2393J, C1084h.f2404U, C1084h.f2387D, C1084h.f2391H, C1084h.f2417h};
        f2449a = new C1088a(true).m4508a(f2452d).m4507a(ae.TLS_1_2, ae.TLS_1_1, ae.TLS_1_0).m4506a(true).m4510a();
        f2450b = new C1088a(f2449a).m4507a(ae.TLS_1_0).m4506a(true).m4510a();
        f2451c = new C1088a(false).m4510a();
    }

    private C1089k(C1088a c1088a) {
        this.f2453e = c1088a.f2445a;
        this.f2455g = c1088a.f2446b;
        this.f2456h = c1088a.f2447c;
        this.f2454f = c1088a.f2448d;
    }

    public boolean m4519a() {
        return this.f2453e;
    }

    public List<C1084h> m4521b() {
        if (this.f2455g == null) {
            return null;
        }
        Object[] objArr = new C1084h[this.f2455g.length];
        for (int i = 0; i < this.f2455g.length; i++) {
            objArr[i] = C1084h.m4495a(this.f2455g[i]);
        }
        return C1022c.m4229a(objArr);
    }

    public List<ae> m4522c() {
        if (this.f2456h == null) {
            return null;
        }
        Object[] objArr = new ae[this.f2456h.length];
        for (int i = 0; i < this.f2456h.length; i++) {
            objArr[i] = ae.m4464a(this.f2456h[i]);
        }
        return C1022c.m4229a(objArr);
    }

    public boolean m4523d() {
        return this.f2454f;
    }

    void m4518a(SSLSocket sSLSocket, boolean z) {
        C1089k b = m4514b(sSLSocket, z);
        if (b.f2456h != null) {
            sSLSocket.setEnabledProtocols(b.f2456h);
        }
        if (b.f2455g != null) {
            sSLSocket.setEnabledCipherSuites(b.f2455g);
        }
    }

    private C1089k m4514b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f2455g != null) {
            strArr = (String[]) C1022c.m4239a(String.class, this.f2455g, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f2456h != null) {
            strArr2 = (String[]) C1022c.m4239a(String.class, this.f2456h, sSLSocket.getEnabledProtocols());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        if (z && C1022c.m4223a(sSLSocket.getSupportedCipherSuites(), (Object) "TLS_FALLBACK_SCSV") != -1) {
            strArr = C1022c.m4240a(strArr, "TLS_FALLBACK_SCSV");
        }
        return new C1088a(this).m4509a(strArr).m4511b(strArr2).m4510a();
    }

    public boolean m4520a(SSLSocket sSLSocket) {
        if (!this.f2453e) {
            return false;
        }
        if (this.f2456h != null && !C1089k.m4513a(this.f2456h, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f2455g == null || C1089k.m4513a(this.f2455g, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    private static boolean m4513a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (Object a : strArr) {
            if (C1022c.m4223a((Object[]) strArr2, a) != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1089k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C1089k c1089k = (C1089k) obj;
        if (this.f2453e != c1089k.f2453e) {
            return false;
        }
        if (!this.f2453e || (Arrays.equals(this.f2455g, c1089k.f2455g) && Arrays.equals(this.f2456h, c1089k.f2456h) && this.f2454f == c1089k.f2454f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.f2453e) {
            return 17;
        }
        return (this.f2454f ? 0 : 1) + ((((Arrays.hashCode(this.f2455g) + 527) * 31) + Arrays.hashCode(this.f2456h)) * 31);
    }

    public String toString() {
        if (!this.f2453e) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f2455g != null ? m4521b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f2456h != null ? m4522c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f2454f + ")";
    }
}
