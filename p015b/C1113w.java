package p015b;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p015b.C1078e.C1077a;
import p015b.C1102r.C1101a;
import p015b.p016a.C0960a;
import p015b.p016a.C1022c;
import p015b.p016a.p017a.C0959e;
import p015b.p016a.p019b.C0965c;
import p015b.p016a.p019b.C0966d;
import p015b.p016a.p019b.C0969g;
import p015b.p016a.p023g.C1050b;
import p015b.p016a.p023g.C1060d;

/* renamed from: b.w */
public class C1113w implements C1077a, Cloneable {
    private static final List<C1089k> f2564A;
    private static final List<C1114x> f2565z;
    final C1093n f2566a;
    final Proxy f2567b;
    final List<C1114x> f2568c;
    final List<C1089k> f2569d;
    final List<C0948t> f2570e;
    final List<C0948t> f2571f;
    final ProxySelector f2572g;
    final C1091m f2573h;
    final C1073c f2574i;
    final C0959e f2575j;
    final SocketFactory f2576k;
    final SSLSocketFactory f2577l;
    final C1050b f2578m;
    final HostnameVerifier f2579n;
    final C1083g f2580o;
    final C1071b f2581p;
    final C1071b f2582q;
    final C1086j f2583r;
    final C1094o f2584s;
    final boolean f2585t;
    final boolean f2586u;
    final boolean f2587v;
    final int f2588w;
    final int f2589x;
    final int f2590y;

    /* renamed from: b.w.1 */
    static class C11111 extends C0960a {
        C11111() {
        }

        public void m4647a(C1101a c1101a, String str) {
            c1101a.m4559a(str);
        }

        public void m4648a(C1101a c1101a, String str, String str2) {
            c1101a.m4563b(str, str2);
        }

        public boolean m4649a(C1086j c1086j, C0965c c0965c) {
            return c1086j.m4501b(c0965c);
        }

        public C0965c m4644a(C1086j c1086j, C1064a c1064a, C0969g c0969g) {
            return c1086j.m4499a(c1064a, c0969g);
        }

        public void m4650b(C1086j c1086j, C0965c c0965c) {
            c1086j.m4500a(c0965c);
        }

        public C0966d m4645a(C1086j c1086j) {
            return c1086j.f2439a;
        }

        public void m4646a(C1089k c1089k, SSLSocket sSLSocket, boolean z) {
            c1089k.m4518a(sSLSocket, z);
        }
    }

    /* renamed from: b.w.a */
    public static final class C1112a {
        C1093n f2539a;
        Proxy f2540b;
        List<C1114x> f2541c;
        List<C1089k> f2542d;
        final List<C0948t> f2543e;
        final List<C0948t> f2544f;
        ProxySelector f2545g;
        C1091m f2546h;
        C1073c f2547i;
        C0959e f2548j;
        SocketFactory f2549k;
        SSLSocketFactory f2550l;
        C1050b f2551m;
        HostnameVerifier f2552n;
        C1083g f2553o;
        C1071b f2554p;
        C1071b f2555q;
        C1086j f2556r;
        C1094o f2557s;
        boolean f2558t;
        boolean f2559u;
        boolean f2560v;
        int f2561w;
        int f2562x;
        int f2563y;

        public C1112a() {
            this.f2543e = new ArrayList();
            this.f2544f = new ArrayList();
            this.f2539a = new C1093n();
            this.f2541c = C1113w.f2565z;
            this.f2542d = C1113w.f2564A;
            this.f2545g = ProxySelector.getDefault();
            this.f2546h = C1091m.f2470a;
            this.f2549k = SocketFactory.getDefault();
            this.f2552n = C1060d.f2292a;
            this.f2553o = C1083g.f2381a;
            this.f2554p = C1071b.f2352a;
            this.f2555q = C1071b.f2352a;
            this.f2556r = new C1086j();
            this.f2557s = C1094o.f2478a;
            this.f2558t = true;
            this.f2559u = true;
            this.f2560v = true;
            this.f2561w = 10000;
            this.f2562x = 10000;
            this.f2563y = 10000;
        }

        C1112a(C1113w c1113w) {
            this.f2543e = new ArrayList();
            this.f2544f = new ArrayList();
            this.f2539a = c1113w.f2566a;
            this.f2540b = c1113w.f2567b;
            this.f2541c = c1113w.f2568c;
            this.f2542d = c1113w.f2569d;
            this.f2543e.addAll(c1113w.f2570e);
            this.f2544f.addAll(c1113w.f2571f);
            this.f2545g = c1113w.f2572g;
            this.f2546h = c1113w.f2573h;
            this.f2548j = c1113w.f2575j;
            this.f2547i = c1113w.f2574i;
            this.f2549k = c1113w.f2576k;
            this.f2550l = c1113w.f2577l;
            this.f2551m = c1113w.f2578m;
            this.f2552n = c1113w.f2579n;
            this.f2553o = c1113w.f2580o;
            this.f2554p = c1113w.f2581p;
            this.f2555q = c1113w.f2582q;
            this.f2556r = c1113w.f2583r;
            this.f2557s = c1113w.f2584s;
            this.f2558t = c1113w.f2585t;
            this.f2559u = c1113w.f2586u;
            this.f2560v = c1113w.f2587v;
            this.f2561w = c1113w.f2588w;
            this.f2562x = c1113w.f2589x;
            this.f2563y = c1113w.f2590y;
        }

        public C1112a m4651a(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(j);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || j <= 0) {
                    this.f2561w = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        public C1112a m4654b(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(j);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || j <= 0) {
                    this.f2562x = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        public C1112a m4652a(boolean z) {
            this.f2559u = z;
            return this;
        }

        public List<C0948t> m4653a() {
            return this.f2544f;
        }

        public C1113w m4655b() {
            return new C1113w();
        }
    }

    static {
        f2565z = C1022c.m4229a(C1114x.HTTP_2, C1114x.SPDY_3, C1114x.HTTP_1_1);
        f2564A = C1022c.m4229a(C1089k.f2449a, C1089k.f2450b, C1089k.f2451c);
        C0960a.f1946a = new C11111();
    }

    public C1113w() {
        this(new C1112a());
    }

    private C1113w(C1112a c1112a) {
        this.f2566a = c1112a.f2539a;
        this.f2567b = c1112a.f2540b;
        this.f2568c = c1112a.f2541c;
        this.f2569d = c1112a.f2542d;
        this.f2570e = C1022c.m4228a(c1112a.f2543e);
        this.f2571f = C1022c.m4228a(c1112a.f2544f);
        this.f2572g = c1112a.f2545g;
        this.f2573h = c1112a.f2546h;
        this.f2574i = c1112a.f2547i;
        this.f2575j = c1112a.f2548j;
        this.f2576k = c1112a.f2549k;
        Object obj = null;
        for (C1089k c1089k : this.f2569d) {
            Object obj2;
            if (obj != null || c1089k.m4519a()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            obj = obj2;
        }
        if (c1112a.f2550l != null || obj == null) {
            this.f2577l = c1112a.f2550l;
            this.f2578m = c1112a.f2551m;
        } else {
            X509TrustManager A = m4656A();
            this.f2577l = m4657a(A);
            this.f2578m = C1050b.m4337a(A);
        }
        this.f2579n = c1112a.f2552n;
        this.f2580o = c1112a.f2553o.m4492a(this.f2578m);
        this.f2581p = c1112a.f2554p;
        this.f2582q = c1112a.f2555q;
        this.f2583r = c1112a.f2556r;
        this.f2584s = c1112a.f2557s;
        this.f2585t = c1112a.f2558t;
        this.f2586u = c1112a.f2559u;
        this.f2587v = c1112a.f2560v;
        this.f2588w = c1112a.f2561w;
        this.f2589x = c1112a.f2562x;
        this.f2590y = c1112a.f2563y;
    }

    private X509TrustManager m4656A() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    private SSLSocketFactory m4657a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{x509TrustManager}, null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    public int m4660a() {
        return this.f2588w;
    }

    public int m4662b() {
        return this.f2589x;
    }

    public int m4663c() {
        return this.f2590y;
    }

    public Proxy m4664d() {
        return this.f2567b;
    }

    public ProxySelector m4665e() {
        return this.f2572g;
    }

    public C1091m m4666f() {
        return this.f2573h;
    }

    C0959e m4667g() {
        return this.f2574i != null ? this.f2574i.f2353a : this.f2575j;
    }

    public C1094o m4668h() {
        return this.f2584s;
    }

    public SocketFactory m4669i() {
        return this.f2576k;
    }

    public SSLSocketFactory m4670j() {
        return this.f2577l;
    }

    public HostnameVerifier m4671k() {
        return this.f2579n;
    }

    public C1083g m4672l() {
        return this.f2580o;
    }

    public C1071b m4673m() {
        return this.f2582q;
    }

    public C1071b m4674n() {
        return this.f2581p;
    }

    public C1086j m4675o() {
        return this.f2583r;
    }

    public boolean m4676p() {
        return this.f2585t;
    }

    public boolean m4677q() {
        return this.f2586u;
    }

    public boolean m4678r() {
        return this.f2587v;
    }

    public C1093n m4679s() {
        return this.f2566a;
    }

    public List<C1114x> m4680t() {
        return this.f2568c;
    }

    public List<C1089k> m4681u() {
        return this.f2569d;
    }

    public List<C0948t> m4682v() {
        return this.f2570e;
    }

    public List<C0948t> m4683w() {
        return this.f2571f;
    }

    public C1078e m4661a(C1120z c1120z) {
        return new C1117y(this, c1120z);
    }

    public C1112a m4684x() {
        return new C1112a(this);
    }
}
