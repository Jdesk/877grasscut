package p015b;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* renamed from: b.ad */
public final class ad {
    final C1064a f2343a;
    final Proxy f2344b;
    final InetSocketAddress f2345c;

    public ad(C1064a c1064a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c1064a == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f2343a = c1064a;
            this.f2344b = proxy;
            this.f2345c = inetSocketAddress;
        }
    }

    public C1064a m4460a() {
        return this.f2343a;
    }

    public Proxy m4461b() {
        return this.f2344b;
    }

    public InetSocketAddress m4462c() {
        return this.f2345c;
    }

    public boolean m4463d() {
        return this.f2343a.f2304i != null && this.f2344b.type() == Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        if (this.f2343a.equals(adVar.f2343a) && this.f2344b.equals(adVar.f2344b) && this.f2345c.equals(adVar.f2345c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f2343a.hashCode() + 527) * 31) + this.f2344b.hashCode()) * 31) + this.f2345c.hashCode();
    }
}
