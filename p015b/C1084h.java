package p015b;

import com.zopim.android.sdk.api.C5264R;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: b.h */
public final class C1084h {
    public static final C1084h f2384A;
    public static final C1084h f2385B;
    public static final C1084h f2386C;
    public static final C1084h f2387D;
    public static final C1084h f2388E;
    public static final C1084h f2389F;
    public static final C1084h f2390G;
    public static final C1084h f2391H;
    public static final C1084h f2392I;
    public static final C1084h f2393J;
    public static final C1084h f2394K;
    public static final C1084h f2395L;
    public static final C1084h f2396M;
    public static final C1084h f2397N;
    public static final C1084h f2398O;
    public static final C1084h f2399P;
    public static final C1084h f2400Q;
    public static final C1084h f2401R;
    public static final C1084h f2402S;
    public static final C1084h f2403T;
    public static final C1084h f2404U;
    public static final C1084h f2405V;
    public static final C1084h f2406W;
    public static final C1084h f2407X;
    public static final C1084h f2408Y;
    public static final C1084h f2409Z;
    public static final C1084h f2410a;
    public static final C1084h aA;
    public static final C1084h aB;
    public static final C1084h aC;
    public static final C1084h aD;
    public static final C1084h aE;
    public static final C1084h aF;
    public static final C1084h aG;
    public static final C1084h aH;
    public static final C1084h aI;
    public static final C1084h aJ;
    public static final C1084h aK;
    public static final C1084h aL;
    public static final C1084h aM;
    public static final C1084h aN;
    public static final C1084h aO;
    public static final C1084h aP;
    public static final C1084h aQ;
    public static final C1084h aR;
    private static final ConcurrentMap<String, C1084h> aT;
    public static final C1084h aa;
    public static final C1084h ab;
    public static final C1084h ac;
    public static final C1084h ad;
    public static final C1084h ae;
    public static final C1084h af;
    public static final C1084h ag;
    public static final C1084h ah;
    public static final C1084h ai;
    public static final C1084h aj;
    public static final C1084h ak;
    public static final C1084h al;
    public static final C1084h am;
    public static final C1084h an;
    public static final C1084h ao;
    public static final C1084h ap;
    public static final C1084h aq;
    public static final C1084h ar;
    public static final C1084h as;
    public static final C1084h at;
    public static final C1084h au;
    public static final C1084h av;
    public static final C1084h aw;
    public static final C1084h ax;
    public static final C1084h ay;
    public static final C1084h az;
    public static final C1084h f2411b;
    public static final C1084h f2412c;
    public static final C1084h f2413d;
    public static final C1084h f2414e;
    public static final C1084h f2415f;
    public static final C1084h f2416g;
    public static final C1084h f2417h;
    public static final C1084h f2418i;
    public static final C1084h f2419j;
    public static final C1084h f2420k;
    public static final C1084h f2421l;
    public static final C1084h f2422m;
    public static final C1084h f2423n;
    public static final C1084h f2424o;
    public static final C1084h f2425p;
    public static final C1084h f2426q;
    public static final C1084h f2427r;
    public static final C1084h f2428s;
    public static final C1084h f2429t;
    public static final C1084h f2430u;
    public static final C1084h f2431v;
    public static final C1084h f2432w;
    public static final C1084h f2433x;
    public static final C1084h f2434y;
    public static final C1084h f2435z;
    final String aS;

    static {
        aT = new ConcurrentHashMap();
        f2410a = C1084h.m4496a("SSL_RSA_WITH_NULL_MD5", 1, 5246, 6, 10);
        f2411b = C1084h.m4496a("SSL_RSA_WITH_NULL_SHA", 2, 5246, 6, 10);
        f2412c = C1084h.m4496a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3, 4346, 6, 10);
        f2413d = C1084h.m4496a("SSL_RSA_WITH_RC4_128_MD5", 4, 5246, 6, 10);
        f2414e = C1084h.m4496a("SSL_RSA_WITH_RC4_128_SHA", 5, 5246, 6, 10);
        f2415f = C1084h.m4496a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8, 4346, 6, 10);
        f2416g = C1084h.m4496a("SSL_RSA_WITH_DES_CBC_SHA", 9, 5469, 6, 10);
        f2417h = C1084h.m4496a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10, 5246, 6, 10);
        f2418i = C1084h.m4496a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17, 4346, 6, 10);
        f2419j = C1084h.m4496a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18, 5469, 6, 10);
        f2420k = C1084h.m4496a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19, 5246, 6, 10);
        f2421l = C1084h.m4496a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20, 4346, 6, 10);
        f2422m = C1084h.m4496a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21, 5469, 6, 10);
        f2423n = C1084h.m4496a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22, 5246, 6, 10);
        f2424o = C1084h.m4496a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23, 4346, 6, 10);
        f2425p = C1084h.m4496a("SSL_DH_anon_WITH_RC4_128_MD5", 24, 5246, 6, 10);
        f2426q = C1084h.m4496a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25, 4346, 6, 10);
        f2427r = C1084h.m4496a("SSL_DH_anon_WITH_DES_CBC_SHA", 26, 5469, 6, 10);
        f2428s = C1084h.m4496a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27, 5246, 6, 10);
        f2429t = C1084h.m4496a("TLS_KRB5_WITH_DES_CBC_SHA", 30, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2430u = C1084h.m4496a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2431v = C1084h.m4496a("TLS_KRB5_WITH_RC4_128_SHA", 32, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2432w = C1084h.m4496a("TLS_KRB5_WITH_DES_CBC_MD5", 34, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2433x = C1084h.m4496a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2434y = C1084h.m4496a("TLS_KRB5_WITH_RC4_128_MD5", 36, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2435z = C1084h.m4496a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2384A = C1084h.m4496a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2385B = C1084h.m4496a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2386C = C1084h.m4496a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43, 2712, 6, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        f2387D = C1084h.m4496a("TLS_RSA_WITH_AES_128_CBC_SHA", 47, 5246, 6, 10);
        f2388E = C1084h.m4496a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50, 5246, 6, 10);
        f2389F = C1084h.m4496a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51, 5246, 6, 10);
        f2390G = C1084h.m4496a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52, 5246, 6, 10);
        f2391H = C1084h.m4496a("TLS_RSA_WITH_AES_256_CBC_SHA", 53, 5246, 6, 10);
        f2392I = C1084h.m4496a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56, 5246, 6, 10);
        f2393J = C1084h.m4496a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57, 5246, 6, 10);
        f2394K = C1084h.m4496a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58, 5246, 6, 10);
        f2395L = C1084h.m4496a("TLS_RSA_WITH_NULL_SHA256", 59, 5246, 7, 21);
        f2396M = C1084h.m4496a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60, 5246, 7, 21);
        f2397N = C1084h.m4496a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61, 5246, 7, 21);
        f2398O = C1084h.m4496a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64, 5246, 7, 21);
        f2399P = C1084h.m4496a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", C5264R.styleable.AppCompatTheme_buttonStyleSmall, 5246, 7, 21);
        f2400Q = C1084h.m4496a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", C5264R.styleable.AppCompatTheme_editTextStyle, 5246, 7, 21);
        f2401R = C1084h.m4496a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", C5264R.styleable.AppCompatTheme_radioButtonStyle, 5246, 7, 21);
        f2402S = C1084h.m4496a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", C5264R.styleable.AppCompatTheme_ratingBarStyle, 5246, 7, 21);
        f2403T = C1084h.m4496a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", C5264R.styleable.AppCompatTheme_ratingBarStyleIndicator, 5246, 7, 21);
        f2404U = C1084h.m4496a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156, 5288, 8, 21);
        f2405V = C1084h.m4496a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157, 5288, 8, 21);
        f2406W = C1084h.m4496a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158, 5288, 8, 21);
        f2407X = C1084h.m4496a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159, 5288, 8, 21);
        f2408Y = C1084h.m4496a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162, 5288, 8, 21);
        f2409Z = C1084h.m4496a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163, 5288, 8, 21);
        aa = C1084h.m4496a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166, 5288, 8, 21);
        ab = C1084h.m4496a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167, 5288, 8, 21);
        ac = C1084h.m4496a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255, 5746, 6, 14);
        ad = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153, 4492, 7, 14);
        ae = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154, 4492, 7, 14);
        af = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155, 4492, 7, 14);
        ag = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156, 4492, 7, 14);
        ah = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157, 4492, 7, 14);
        ai = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158, 4492, 7, 14);
        aj = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159, 4492, 7, 14);
        ak = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160, 4492, 7, 14);
        al = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161, 4492, 7, 14);
        am = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162, 4492, 7, 14);
        an = C1084h.m4496a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163, 4492, 7, 14);
        ao = C1084h.m4496a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164, 4492, 7, 14);
        ap = C1084h.m4496a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165, 4492, 7, 14);
        aq = C1084h.m4496a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166, 4492, 7, 14);
        ar = C1084h.m4496a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167, 4492, 7, 14);
        as = C1084h.m4496a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168, 4492, 7, 14);
        at = C1084h.m4496a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169, 4492, 7, 14);
        au = C1084h.m4496a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170, 4492, 7, 14);
        av = C1084h.m4496a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171, 4492, 7, 14);
        aw = C1084h.m4496a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172, 4492, 7, 14);
        ax = C1084h.m4496a("TLS_ECDH_anon_WITH_NULL_SHA", 49173, 4492, 7, 14);
        ay = C1084h.m4496a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174, 4492, 7, 14);
        az = C1084h.m4496a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175, 4492, 7, 14);
        aA = C1084h.m4496a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176, 4492, 7, 14);
        aB = C1084h.m4496a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177, 4492, 7, 14);
        aC = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187, 5289, 7, 21);
        aD = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188, 5289, 7, 21);
        aE = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189, 5289, 7, 21);
        aF = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190, 5289, 7, 21);
        aG = C1084h.m4496a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191, 5289, 7, 21);
        aH = C1084h.m4496a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192, 5289, 7, 21);
        aI = C1084h.m4496a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193, 5289, 7, 21);
        aJ = C1084h.m4496a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194, 5289, 7, 21);
        aK = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195, 5289, 8, 21);
        aL = C1084h.m4496a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196, 5289, 8, 21);
        aM = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197, 5289, 8, 21);
        aN = C1084h.m4496a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198, 5289, 8, 21);
        aO = C1084h.m4496a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199, 5289, 8, 21);
        aP = C1084h.m4496a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200, 5289, 8, 21);
        aQ = C1084h.m4496a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201, 5289, 8, 21);
        aR = C1084h.m4496a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202, 5289, 8, 21);
    }

    public static C1084h m4495a(String str) {
        C1084h c1084h = (C1084h) aT.get(str);
        if (c1084h != null) {
            return c1084h;
        }
        C1084h c1084h2 = new C1084h(str);
        c1084h = (C1084h) aT.putIfAbsent(str, c1084h2);
        if (c1084h == null) {
            return c1084h2;
        }
        return c1084h;
    }

    private C1084h(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.aS = str;
    }

    private static C1084h m4496a(String str, int i, int i2, int i3, int i4) {
        return C1084h.m4495a(str);
    }

    public String toString() {
        return this.aS;
    }
}
