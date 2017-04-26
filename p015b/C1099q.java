package p015b;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import p015b.p016a.C1022c;

/* renamed from: b.q */
public final class C1099q {
    private final ae f2484a;
    private final C1084h f2485b;
    private final List<Certificate> f2486c;
    private final List<Certificate> f2487d;

    private C1099q(ae aeVar, C1084h c1084h, List<Certificate> list, List<Certificate> list2) {
        this.f2484a = aeVar;
        this.f2485b = c1084h;
        this.f2486c = list;
        this.f2487d = list2;
    }

    public static C1099q m4554a(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        C1084h a = C1084h.m4495a(cipherSuite);
        cipherSuite = sSLSession.getProtocol();
        if (cipherSuite == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        Object[] peerCertificates;
        List a2;
        List a3;
        ae a4 = ae.m4464a(cipherSuite);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            a2 = C1022c.m4229a(peerCertificates);
        } else {
            a2 = Collections.emptyList();
        }
        Object[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            a3 = C1022c.m4229a(localCertificates);
        } else {
            a3 = Collections.emptyList();
        }
        return new C1099q(a4, a, a2, a3);
    }

    public C1084h m4555a() {
        return this.f2485b;
    }

    public List<Certificate> m4556b() {
        return this.f2486c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1099q)) {
            return false;
        }
        C1099q c1099q = (C1099q) obj;
        if (C1022c.m4238a(this.f2485b, c1099q.f2485b) && this.f2485b.equals(c1099q.f2485b) && this.f2486c.equals(c1099q.f2486c) && this.f2487d.equals(c1099q.f2487d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f2484a != null ? this.f2484a.hashCode() : 0) + 527) * 31) + this.f2485b.hashCode()) * 31) + this.f2486c.hashCode()) * 31) + this.f2487d.hashCode();
    }
}
