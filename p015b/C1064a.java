package p015b;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p015b.C1106s.C1105a;
import p015b.p016a.C1022c;

/* renamed from: b.a */
public final class C1064a {
    final C1106s f2296a;
    final C1094o f2297b;
    final SocketFactory f2298c;
    final C1071b f2299d;
    final List<C1114x> f2300e;
    final List<C1089k> f2301f;
    final ProxySelector f2302g;
    final Proxy f2303h;
    final SSLSocketFactory f2304i;
    final HostnameVerifier f2305j;
    final C1083g f2306k;

    public C1064a(String str, int i, C1094o c1094o, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C1083g c1083g, C1071b c1071b, Proxy proxy, List<C1114x> list, List<C1089k> list2, ProxySelector proxySelector) {
        this.f2296a = new C1105a().m4592a(sSLSocketFactory != null ? "https" : "http").m4595b(str).m4591a(i).m4598c();
        if (c1094o == null) {
            throw new NullPointerException("dns == null");
        }
        this.f2297b = c1094o;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f2298c = socketFactory;
        if (c1071b == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f2299d = c1071b;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f2300e = C1022c.m4228a((List) list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f2301f = C1022c.m4228a((List) list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f2302g = proxySelector;
        this.f2303h = proxy;
        this.f2304i = sSLSocketFactory;
        this.f2305j = hostnameVerifier;
        this.f2306k = c1083g;
    }

    public C1106s m4395a() {
        return this.f2296a;
    }

    public C1094o m4396b() {
        return this.f2297b;
    }

    public SocketFactory m4397c() {
        return this.f2298c;
    }

    public C1071b m4398d() {
        return this.f2299d;
    }

    public List<C1114x> m4399e() {
        return this.f2300e;
    }

    public List<C1089k> m4400f() {
        return this.f2301f;
    }

    public ProxySelector m4401g() {
        return this.f2302g;
    }

    public Proxy m4402h() {
        return this.f2303h;
    }

    public SSLSocketFactory m4403i() {
        return this.f2304i;
    }

    public HostnameVerifier m4404j() {
        return this.f2305j;
    }

    public C1083g m4405k() {
        return this.f2306k;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1064a)) {
            return false;
        }
        C1064a c1064a = (C1064a) obj;
        if (this.f2296a.equals(c1064a.f2296a) && this.f2297b.equals(c1064a.f2297b) && this.f2299d.equals(c1064a.f2299d) && this.f2300e.equals(c1064a.f2300e) && this.f2301f.equals(c1064a.f2301f) && this.f2302g.equals(c1064a.f2302g) && C1022c.m4238a(this.f2303h, c1064a.f2303h) && C1022c.m4238a(this.f2304i, c1064a.f2304i) && C1022c.m4238a(this.f2305j, c1064a.f2305j) && C1022c.m4238a(this.f2306k, c1064a.f2306k)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (((((((((((this.f2296a.hashCode() + 527) * 31) + this.f2297b.hashCode()) * 31) + this.f2299d.hashCode()) * 31) + this.f2300e.hashCode()) * 31) + this.f2301f.hashCode()) * 31) + this.f2302g.hashCode()) * 31;
        if (this.f2303h != null) {
            hashCode = this.f2303h.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f2304i != null) {
            hashCode = this.f2304i.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f2305j != null) {
            hashCode = this.f2305j.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.f2306k != null) {
            i = this.f2306k.hashCode();
        }
        return hashCode + i;
    }
}
