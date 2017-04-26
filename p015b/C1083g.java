package p015b;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import p015b.p016a.C1022c;
import p015b.p016a.p023g.C1050b;
import p018c.C1130f;

/* renamed from: b.g */
public final class C1083g {
    public static final C1083g f2381a;
    private final List<C1082b> f2382b;
    private final C1050b f2383c;

    /* renamed from: b.g.a */
    public static final class C1081a {
        private final List<C1082b> f2376a;

        public C1081a() {
            this.f2376a = new ArrayList();
        }

        public C1083g m4487a() {
            return new C1083g(null, null);
        }
    }

    /* renamed from: b.g.b */
    static final class C1082b {
        final String f2377a;
        final String f2378b;
        final String f2379c;
        final C1130f f2380d;

        boolean m4488a(String str) {
            if (!this.f2377a.startsWith("*.")) {
                return str.equals(this.f2378b);
            }
            return str.regionMatches(false, str.indexOf(46) + 1, this.f2378b, 0, this.f2378b.length());
        }

        public boolean equals(Object obj) {
            return (obj instanceof C1082b) && this.f2377a.equals(((C1082b) obj).f2377a) && this.f2379c.equals(((C1082b) obj).f2379c) && this.f2380d.equals(((C1082b) obj).f2380d);
        }

        public int hashCode() {
            return ((((this.f2377a.hashCode() + 527) * 31) + this.f2379c.hashCode()) * 31) + this.f2380d.hashCode();
        }

        public String toString() {
            return this.f2379c + this.f2380d.m4836b();
        }
    }

    static {
        f2381a = new C1081a().m4487a();
    }

    private C1083g(List<C1082b> list, C1050b c1050b) {
        this.f2382b = list;
        this.f2383c = c1050b;
    }

    public void m4494a(String str, List<Certificate> list) {
        List a = m4493a(str);
        if (!a.isEmpty()) {
            int i;
            if (this.f2383c != null) {
                list = this.f2383c.m4338a(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = a.size();
                int i3 = 0;
                Object obj = null;
                Object obj2 = null;
                while (i3 < size2) {
                    C1082b c1082b = (C1082b) a.get(i3);
                    if (c1082b.f2379c.equals("sha256/")) {
                        if (obj == null) {
                            obj = C1083g.m4491b(x509Certificate);
                        }
                        if (c1082b.f2380d.equals(obj)) {
                            return;
                        }
                    } else if (c1082b.f2379c.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = C1083g.m4489a(x509Certificate);
                        }
                        if (c1082b.f2380d.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                    Object obj3 = obj;
                    i3++;
                    obj2 = obj2;
                    obj = obj3;
                }
            }
            StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (i = 0; i < size3; i++) {
                Certificate certificate = (X509Certificate) list.get(i);
                append.append("\n    ").append(C1083g.m4490a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            size3 = a.size();
            for (i = 0; i < size3; i++) {
                append.append("\n    ").append((C1082b) a.get(i));
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }

    List<C1082b> m4493a(String str) {
        List<C1082b> emptyList = Collections.emptyList();
        for (C1082b c1082b : this.f2382b) {
            if (c1082b.m4488a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(c1082b);
            }
        }
        return emptyList;
    }

    C1083g m4492a(C1050b c1050b) {
        return this.f2383c != c1050b ? new C1083g(this.f2382b, c1050b) : this;
    }

    public static String m4490a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + C1083g.m4491b((X509Certificate) certificate).m4836b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static C1130f m4489a(X509Certificate x509Certificate) {
        return C1022c.m4224a(C1130f.m4828a(x509Certificate.getPublicKey().getEncoded()));
    }

    static C1130f m4491b(X509Certificate x509Certificate) {
        return C1022c.m4242b(C1130f.m4828a(x509Certificate.getPublicKey().getEncoded()));
    }
}
