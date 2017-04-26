package p015b;

import io.card.payment.BuildConfig;
import java.util.concurrent.TimeUnit;
import p015b.p016a.p021d.C1038f;

/* renamed from: b.d */
public final class C1076d {
    public static final C1076d f2362a;
    public static final C1076d f2363b;
    String f2364c;
    private final boolean f2365d;
    private final boolean f2366e;
    private final int f2367f;
    private final int f2368g;
    private final boolean f2369h;
    private final boolean f2370i;
    private final boolean f2371j;
    private final int f2372k;
    private final int f2373l;
    private final boolean f2374m;
    private final boolean f2375n;

    /* renamed from: b.d.a */
    public static final class C1075a {
        boolean f2355a;
        boolean f2356b;
        int f2357c;
        int f2358d;
        int f2359e;
        boolean f2360f;
        boolean f2361g;

        public C1075a() {
            this.f2357c = -1;
            this.f2358d = -1;
            this.f2359e = -1;
        }

        public C1075a m4467a() {
            this.f2355a = true;
            return this;
        }

        public C1075a m4468a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long toSeconds = timeUnit.toSeconds((long) i);
            this.f2358d = toSeconds > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) toSeconds;
            return this;
        }

        public C1075a m4469b() {
            this.f2360f = true;
            return this;
        }

        public C1076d m4470c() {
            return new C1076d();
        }
    }

    static {
        f2362a = new C1075a().m4467a().m4470c();
        f2363b = new C1075a().m4469b().m4468a(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS).m4470c();
    }

    private C1076d(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f2365d = z;
        this.f2366e = z2;
        this.f2367f = i;
        this.f2368g = i2;
        this.f2369h = z3;
        this.f2370i = z4;
        this.f2371j = z5;
        this.f2372k = i3;
        this.f2373l = i4;
        this.f2374m = z6;
        this.f2375n = z7;
        this.f2364c = str;
    }

    private C1076d(C1075a c1075a) {
        this.f2365d = c1075a.f2355a;
        this.f2366e = c1075a.f2356b;
        this.f2367f = c1075a.f2357c;
        this.f2368g = -1;
        this.f2369h = false;
        this.f2370i = false;
        this.f2371j = false;
        this.f2372k = c1075a.f2358d;
        this.f2373l = c1075a.f2359e;
        this.f2374m = c1075a.f2360f;
        this.f2375n = c1075a.f2361g;
    }

    public boolean m4473a() {
        return this.f2365d;
    }

    public boolean m4474b() {
        return this.f2366e;
    }

    public int m4475c() {
        return this.f2367f;
    }

    public boolean m4476d() {
        return this.f2369h;
    }

    public boolean m4477e() {
        return this.f2370i;
    }

    public boolean m4478f() {
        return this.f2371j;
    }

    public int m4479g() {
        return this.f2372k;
    }

    public int m4480h() {
        return this.f2373l;
    }

    public boolean m4481i() {
        return this.f2374m;
    }

    public static C1076d m4471a(C1102r c1102r) {
        String b;
        boolean z = false;
        int i = -1;
        int i2 = -1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z5 = false;
        boolean z6 = false;
        Object obj = 1;
        int a = c1102r.m4567a();
        int i5 = 0;
        String str = null;
        boolean z7 = false;
        while (i5 < a) {
            boolean z8;
            String a2 = c1102r.m4568a(i5);
            b = c1102r.m4570b(i5);
            if (a2.equalsIgnoreCase("Cache-Control")) {
                if (str != null) {
                    obj = null;
                } else {
                    str = b;
                }
            } else if (a2.equalsIgnoreCase("Pragma")) {
                obj = null;
            } else {
                z8 = z7;
                i5++;
                z7 = z8;
            }
            z8 = z7;
            int i6 = 0;
            while (i6 < b.length()) {
                String str2;
                int a3 = C1038f.m4297a(b, i6, "=,;");
                String trim = b.substring(i6, a3).trim();
                if (a3 == b.length() || b.charAt(a3) == ',' || b.charAt(a3) == ';') {
                    i6 = a3 + 1;
                    str2 = null;
                } else {
                    i6 = C1038f.m4296a(b, a3 + 1);
                    String trim2;
                    if (i6 >= b.length() || b.charAt(i6) != '\"') {
                        a3 = C1038f.m4297a(b, i6, ",;");
                        trim2 = b.substring(i6, a3).trim();
                        i6 = a3;
                        str2 = trim2;
                    } else {
                        i6++;
                        a3 = C1038f.m4297a(b, i6, "\"");
                        trim2 = b.substring(i6, a3);
                        i6 = a3 + 1;
                        str2 = trim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else {
                    if ("no-store".equalsIgnoreCase(trim)) {
                        z = true;
                    } else {
                        if ("max-age".equalsIgnoreCase(trim)) {
                            i = C1038f.m4302b(str2, -1);
                        } else {
                            if ("s-maxage".equalsIgnoreCase(trim)) {
                                i2 = C1038f.m4302b(str2, -1);
                            } else {
                                if ("private".equalsIgnoreCase(trim)) {
                                    z2 = true;
                                } else {
                                    if ("public".equalsIgnoreCase(trim)) {
                                        z3 = true;
                                    } else {
                                        if ("must-revalidate".equalsIgnoreCase(trim)) {
                                            z4 = true;
                                        } else {
                                            if ("max-stale".equalsIgnoreCase(trim)) {
                                                i3 = C1038f.m4302b(str2, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                                            } else {
                                                if ("min-fresh".equalsIgnoreCase(trim)) {
                                                    i4 = C1038f.m4302b(str2, -1);
                                                } else {
                                                    if ("only-if-cached".equalsIgnoreCase(trim)) {
                                                        z5 = true;
                                                    } else {
                                                        if ("no-transform".equalsIgnoreCase(trim)) {
                                                            z6 = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i5++;
            z7 = z8;
        }
        if (obj == null) {
            b = null;
        } else {
            b = str;
        }
        return new C1076d(z7, z, i, i2, z2, z3, z4, i3, i4, z5, z6, b);
    }

    public String toString() {
        String str = this.f2364c;
        if (str != null) {
            return str;
        }
        str = m4472j();
        this.f2364c = str;
        return str;
    }

    private String m4472j() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f2365d) {
            stringBuilder.append("no-cache, ");
        }
        if (this.f2366e) {
            stringBuilder.append("no-store, ");
        }
        if (this.f2367f != -1) {
            stringBuilder.append("max-age=").append(this.f2367f).append(", ");
        }
        if (this.f2368g != -1) {
            stringBuilder.append("s-maxage=").append(this.f2368g).append(", ");
        }
        if (this.f2369h) {
            stringBuilder.append("private, ");
        }
        if (this.f2370i) {
            stringBuilder.append("public, ");
        }
        if (this.f2371j) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.f2372k != -1) {
            stringBuilder.append("max-stale=").append(this.f2372k).append(", ");
        }
        if (this.f2373l != -1) {
            stringBuilder.append("min-fresh=").append(this.f2373l).append(", ");
        }
        if (this.f2374m) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.f2375n) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
