package p015b;

import android.support.v4.app.ad;
import com.zopim.android.sdk.C5240R;
import com.zopim.android.sdk.api.C5264R;
import io.card.payment.BuildConfig;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p015b.p016a.C1022c;
import p018c.C1129c;

/* renamed from: b.s */
public final class C1106s {
    private static final char[] f2505a;
    private final String f2506b;
    private final String f2507c;
    private final String f2508d;
    private final String f2509e;
    private final int f2510f;
    private final List<String> f2511g;
    private final List<String> f2512h;
    private final String f2513i;
    private final String f2514j;

    /* renamed from: b.s.1 */
    static /* synthetic */ class C11031 {
        static final /* synthetic */ int[] f2490a;

        static {
            f2490a = new int[C1104a.values().length];
            try {
                f2490a[C1104a.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2490a[C1104a.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2490a[C1104a.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2490a[C1104a.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2490a[C1104a.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: b.s.a */
    public static final class C1105a {
        String f2497a;
        String f2498b;
        String f2499c;
        String f2500d;
        int f2501e;
        final List<String> f2502f;
        List<String> f2503g;
        String f2504h;

        /* renamed from: b.s.a.a */
        enum C1104a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public C1105a() {
            this.f2498b = BuildConfig.FLAVOR;
            this.f2499c = BuildConfig.FLAVOR;
            this.f2501e = -1;
            this.f2502f = new ArrayList();
            this.f2502f.add(BuildConfig.FLAVOR);
        }

        public C1105a m4592a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f2497a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f2497a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public C1105a m4595b(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String e = C1105a.m4585e(str, 0, str.length());
            if (e == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f2500d = e;
            return this;
        }

        public C1105a m4591a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f2501e = i;
            return this;
        }

        int m4589a() {
            return this.f2501e != -1 ? this.f2501e : C1106s.m4600a(this.f2497a);
        }

        public C1105a m4597c(String str) {
            List b;
            if (str != null) {
                b = C1106s.m4612b(C1106s.m4604a(str, " \"'<>#", true, false, true, true));
            } else {
                b = null;
            }
            this.f2503g = b;
            return this;
        }

        public C1105a m4593a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            Object a;
            if (this.f2503g == null) {
                this.f2503g = new ArrayList();
            }
            this.f2503g.add(C1106s.m4604a(str, " \"'<>#&=", false, false, true, true));
            List list = this.f2503g;
            if (str2 != null) {
                a = C1106s.m4604a(str2, " \"'<>#&=", false, false, true, true);
            } else {
                a = null;
            }
            list.add(a);
            return this;
        }

        public C1105a m4596b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            Object a;
            if (this.f2503g == null) {
                this.f2503g = new ArrayList();
            }
            this.f2503g.add(C1106s.m4604a(str, " \"'<>#&=", true, false, true, true));
            List list = this.f2503g;
            if (str2 != null) {
                a = C1106s.m4604a(str2, " \"'<>#&=", true, false, true, true);
            } else {
                a = null;
            }
            list.add(a);
            return this;
        }

        C1105a m4594b() {
            int size = this.f2502f.size();
            for (int i = 0; i < size; i++) {
                this.f2502f.set(i, C1106s.m4604a((String) this.f2502f.get(i), "[]", true, true, false, true));
            }
            if (this.f2503g != null) {
                int size2 = this.f2503g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) this.f2503g.get(i2);
                    if (str != null) {
                        this.f2503g.set(i2, C1106s.m4604a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.f2504h != null) {
                this.f2504h = C1106s.m4604a(this.f2504h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public C1106s m4598c() {
            if (this.f2497a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f2500d != null) {
                return new C1106s();
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f2497a);
            stringBuilder.append("://");
            if (!(this.f2498b.isEmpty() && this.f2499c.isEmpty())) {
                stringBuilder.append(this.f2498b);
                if (!this.f2499c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.f2499c);
                }
                stringBuilder.append('@');
            }
            if (this.f2500d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.f2500d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.f2500d);
            }
            int a = m4589a();
            if (a != C1106s.m4600a(this.f2497a)) {
                stringBuilder.append(':');
                stringBuilder.append(a);
            }
            C1106s.m4609a(stringBuilder, this.f2502f);
            if (this.f2503g != null) {
                stringBuilder.append('?');
                C1106s.m4613b(stringBuilder, this.f2503g);
            }
            if (this.f2504h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.f2504h);
            }
            return stringBuilder.toString();
        }

        C1104a m4590a(C1106s c1106s, String str) {
            int d;
            int a = C1022c.m4220a(str, 0, str.length());
            int b = C1022c.m4241b(str, a, str.length());
            if (C1105a.m4580b(str, a, b) != -1) {
                if (str.regionMatches(true, a, "https:", 0, 6)) {
                    this.f2497a = "https";
                    a += "https:".length();
                } else {
                    if (!str.regionMatches(true, a, "http:", 0, 5)) {
                        return C1104a.UNSUPPORTED_SCHEME;
                    }
                    this.f2497a = "http";
                    a += "http:".length();
                }
            } else if (c1106s == null) {
                return C1104a.MISSING_SCHEME;
            } else {
                this.f2497a = c1106s.f2506b;
            }
            int c = C1105a.m4581c(str, a, b);
            if (c >= 2 || c1106s == null || !c1106s.f2506b.equals(this.f2497a)) {
                Object obj = null;
                Object obj2 = null;
                int i = a + c;
                while (true) {
                    Object obj3;
                    Object obj4;
                    int a2 = C1022c.m4222a(str, i, b, "@/\\?#");
                    switch (a2 != b ? str.charAt(a2) : '\uffff') {
                        case ErrorResponse.NON_HTTP_ERROR /*-1*/:
                        case C5264R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                        case C5264R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                        case C5264R.styleable.AppCompatTheme_editTextColor /*63*/:
                        case C5240R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                            d = C1105a.m4582d(str, i, a2);
                            if (d + 1 < a2) {
                                this.f2500d = C1105a.m4585e(str, i, d);
                                this.f2501e = C1105a.m4588g(str, d + 1, a2);
                                if (this.f2501e == -1) {
                                    return C1104a.INVALID_PORT;
                                }
                            }
                            this.f2500d = C1105a.m4585e(str, i, d);
                            this.f2501e = C1106s.m4600a(this.f2497a);
                            if (this.f2500d != null) {
                                a = a2;
                                break;
                            }
                            return C1104a.INVALID_HOST;
                        case C5264R.styleable.AppCompatTheme_editTextBackground /*64*/:
                            if (obj == null) {
                                a = C1022c.m4221a(str, i, a2, ':');
                                String a3 = C1106s.m4602a(str, i, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (obj2 != null) {
                                    a3 = this.f2498b + "%40" + a3;
                                }
                                this.f2498b = a3;
                                if (a != a2) {
                                    obj = 1;
                                    this.f2499c = C1106s.m4602a(str, a + 1, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                }
                                obj2 = 1;
                            } else {
                                this.f2499c += "%40" + C1106s.m4602a(str, i, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            a = a2 + 1;
                            obj3 = obj;
                            obj4 = obj2;
                            continue;
                        default:
                            obj3 = obj;
                            a = i;
                            obj4 = obj2;
                            continue;
                    }
                    obj = obj3;
                    obj2 = obj4;
                    i = a;
                }
            } else {
                this.f2498b = c1106s.m4621d();
                this.f2499c = c1106s.m4622e();
                this.f2500d = c1106s.f2509e;
                this.f2501e = c1106s.f2510f;
                this.f2502f.clear();
                this.f2502f.addAll(c1106s.m4626i());
                if (a == b || str.charAt(a) == '#') {
                    m4597c(c1106s.m4628k());
                }
            }
            d = C1022c.m4222a(str, a, b, "?#");
            m4577a(str, a, d);
            if (d >= b || str.charAt(d) != '?') {
                a = d;
            } else {
                a = C1022c.m4221a(str, d, b, '#');
                this.f2503g = C1106s.m4612b(C1106s.m4602a(str, d + 1, a, " \"'<>#", true, false, true, true));
            }
            if (a < b && str.charAt(a) == '#') {
                this.f2504h = C1106s.m4602a(str, a + 1, b, BuildConfig.FLAVOR, true, false, false, false);
            }
            return C1104a.SUCCESS;
        }

        private void m4577a(String str, int i, int i2) {
            if (i != i2) {
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.f2502f.clear();
                    this.f2502f.add(BuildConfig.FLAVOR);
                    i++;
                } else {
                    this.f2502f.set(this.f2502f.size() - 1, BuildConfig.FLAVOR);
                }
                int i3 = i;
                while (i3 < i2) {
                    int a = C1022c.m4222a(str, i3, i2, "/\\");
                    boolean z = a < i2;
                    m4578a(str, i3, a, z, true);
                    if (z) {
                        a++;
                    }
                    i3 = a;
                }
            }
        }

        private void m4578a(String str, int i, int i2, boolean z, boolean z2) {
            String a = C1106s.m4602a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (!m4584d(a)) {
                if (m4586e(a)) {
                    m4583d();
                    return;
                }
                if (((String) this.f2502f.get(this.f2502f.size() - 1)).isEmpty()) {
                    this.f2502f.set(this.f2502f.size() - 1, a);
                } else {
                    this.f2502f.add(a);
                }
                if (z) {
                    this.f2502f.add(BuildConfig.FLAVOR);
                }
            }
        }

        private boolean m4584d(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean m4586e(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void m4583d() {
            if (!((String) this.f2502f.remove(this.f2502f.size() - 1)).isEmpty() || this.f2502f.isEmpty()) {
                this.f2502f.add(BuildConfig.FLAVOR);
            } else {
                this.f2502f.set(this.f2502f.size() - 1, BuildConfig.FLAVOR);
            }
        }

        private static int m4580b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            int i3 = i + 1;
            while (i3 < i2) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 >= 'a' && charAt2 <= 'z') || ((charAt2 >= 'A' && charAt2 <= 'Z') || ((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                    i3++;
                } else if (charAt2 == ':') {
                    return i3;
                } else {
                    return -1;
                }
            }
            return -1;
        }

        private static int m4581c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int m4582d(java.lang.String r3, int r4, int r5) {
            /*
            r0 = r4;
        L_0x0001:
            if (r0 >= r5) goto L_0x001a;
        L_0x0003:
            r1 = r3.charAt(r0);
            switch(r1) {
                case 58: goto L_0x001b;
                case 91: goto L_0x000d;
                default: goto L_0x000a;
            };
        L_0x000a:
            r0 = r0 + 1;
            goto L_0x0001;
        L_0x000d:
            r0 = r0 + 1;
            if (r0 >= r5) goto L_0x000a;
        L_0x0011:
            r1 = r3.charAt(r0);
            r2 = 93;
            if (r1 != r2) goto L_0x000d;
        L_0x0019:
            goto L_0x000a;
        L_0x001a:
            r0 = r5;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: b.s.a.d(java.lang.String, int, int):int");
        }

        private static String m4585e(String str, int i, int i2) {
            String a = C1106s.m4603a(str, i, i2, false);
            if (!a.contains(":")) {
                return C1022c.m4226a(a);
            }
            InetAddress f;
            if (a.startsWith("[") && a.endsWith("]")) {
                f = C1105a.m4587f(a, 1, a.length() - 1);
            } else {
                f = C1105a.m4587f(a, 0, a.length());
            }
            if (f == null) {
                return null;
            }
            byte[] address = f.getAddress();
            if (address.length == 16) {
                return C1105a.m4576a(address);
            }
            throw new AssertionError();
        }

        private static InetAddress m4587f(String str, int i, int i2) {
            byte[] bArr = new byte[16];
            int i3 = i;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            while (i3 < i2) {
                if (i6 == bArr.length) {
                    return null;
                }
                int a;
                if (i3 + 2 > i2 || !str.regionMatches(i3, "::", 0, 2)) {
                    if (i6 != 0) {
                        if (str.regionMatches(i3, ":", 0, 1)) {
                            i3++;
                        } else if (!str.regionMatches(i3, ".", 0, 1)) {
                            return null;
                        } else {
                            if (!C1105a.m4579a(str, i4, i2, bArr, i6 - 2)) {
                                return null;
                            }
                            i6 += 2;
                        }
                    }
                } else if (i5 != -1) {
                    return null;
                } else {
                    i3 += 2;
                    i5 = i6 + 2;
                    if (i3 == i2) {
                        i6 = i5;
                        break;
                    }
                    i6 = i5;
                }
                i4 = 0;
                int i7 = i3;
                while (i7 < i2) {
                    a = C1106s.m4599a(str.charAt(i7));
                    if (a == -1) {
                        break;
                    }
                    i4 = (i4 << 4) + a;
                    i7++;
                }
                a = i7 - i3;
                if (a == 0 || a > 4) {
                    return null;
                }
                a = i6 + 1;
                bArr[i6] = (byte) ((i4 >>> 8) & 255);
                i6 = a + 1;
                bArr[a] = (byte) (i4 & 255);
                i4 = i3;
                i3 = i7;
            }
            if (i6 != bArr.length) {
                if (i5 == -1) {
                    return null;
                }
                System.arraycopy(bArr, i5, bArr, bArr.length - (i6 - i5), i6 - i5);
                Arrays.fill(bArr, i5, (bArr.length - i6) + i5, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean m4579a(java.lang.String r7, int r8, int r9, byte[] r10, int r11) {
            /*
            r1 = 0;
            r0 = r8;
            r4 = r11;
        L_0x0003:
            if (r0 >= r9) goto L_0x004a;
        L_0x0005:
            r2 = r10.length;
            if (r4 != r2) goto L_0x000a;
        L_0x0008:
            r0 = r1;
        L_0x0009:
            return r0;
        L_0x000a:
            if (r4 == r11) goto L_0x0018;
        L_0x000c:
            r2 = r7.charAt(r0);
            r3 = 46;
            if (r2 == r3) goto L_0x0016;
        L_0x0014:
            r0 = r1;
            goto L_0x0009;
        L_0x0016:
            r0 = r0 + 1;
        L_0x0018:
            r2 = r1;
            r3 = r0;
        L_0x001a:
            if (r3 >= r9) goto L_0x0028;
        L_0x001c:
            r5 = r7.charAt(r3);
            r6 = 48;
            if (r5 < r6) goto L_0x0028;
        L_0x0024:
            r6 = 57;
            if (r5 <= r6) goto L_0x002e;
        L_0x0028:
            r0 = r3 - r0;
            if (r0 != 0) goto L_0x0042;
        L_0x002c:
            r0 = r1;
            goto L_0x0009;
        L_0x002e:
            if (r2 != 0) goto L_0x0034;
        L_0x0030:
            if (r0 == r3) goto L_0x0034;
        L_0x0032:
            r0 = r1;
            goto L_0x0009;
        L_0x0034:
            r2 = r2 * 10;
            r2 = r2 + r5;
            r2 = r2 + -48;
            r5 = 255; // 0xff float:3.57E-43 double:1.26E-321;
            if (r2 <= r5) goto L_0x003f;
        L_0x003d:
            r0 = r1;
            goto L_0x0009;
        L_0x003f:
            r3 = r3 + 1;
            goto L_0x001a;
        L_0x0042:
            r0 = r4 + 1;
            r2 = (byte) r2;
            r10[r4] = r2;
            r4 = r0;
            r0 = r3;
            goto L_0x0003;
        L_0x004a:
            r0 = r11 + 4;
            if (r4 == r0) goto L_0x0050;
        L_0x004e:
            r0 = r1;
            goto L_0x0009;
        L_0x0050:
            r0 = 1;
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: b.s.a.a(java.lang.String, int, int, byte[], int):boolean");
        }

        private static String m4576a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == null && bArr[i5 + 1] == null) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2) {
                    i2 = i6;
                    i3 = i4;
                }
                i4 = i5 + 2;
            }
            C1129c c1129c = new C1129c();
            while (i < bArr.length) {
                if (i == i3) {
                    c1129c.m4783b(58);
                    i += i2;
                    if (i == 16) {
                        c1129c.m4783b(58);
                    }
                } else {
                    if (i > 0) {
                        c1129c.m4783b(58);
                    }
                    c1129c.m4808i((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return c1129c.m4818o();
        }

        private static int m4588g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(C1106s.m4602a(str, i, i2, BuildConfig.FLAVOR, false, false, false, true));
                return (parseInt <= 0 || parseInt > 65535) ? -1 : parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    static {
        f2505a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private C1106s(C1105a c1105a) {
        String str = null;
        this.f2506b = c1105a.f2497a;
        this.f2507c = C1106s.m4605a(c1105a.f2498b, false);
        this.f2508d = C1106s.m4605a(c1105a.f2499c, false);
        this.f2509e = c1105a.f2500d;
        this.f2510f = c1105a.m4589a();
        this.f2511g = m4606a(c1105a.f2502f, false);
        this.f2512h = c1105a.f2503g != null ? m4606a(c1105a.f2503g, true) : null;
        if (c1105a.f2504h != null) {
            str = C1106s.m4605a(c1105a.f2504h, false);
        }
        this.f2513i = str;
        this.f2514j = c1105a.toString();
    }

    public URI m4616a() {
        String c1105a = m4631n().m4594b().toString();
        try {
            return new URI(c1105a);
        } catch (Throwable e) {
            try {
                return URI.create(c1105a.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", BuildConfig.FLAVOR));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public String m4617b() {
        return this.f2506b;
    }

    public boolean m4619c() {
        return this.f2506b.equals("https");
    }

    public String m4621d() {
        if (this.f2507c.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int length = this.f2506b.length() + 3;
        return this.f2514j.substring(length, C1022c.m4222a(this.f2514j, length, this.f2514j.length(), ":@"));
    }

    public String m4622e() {
        if (this.f2508d.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        return this.f2514j.substring(this.f2514j.indexOf(58, this.f2506b.length() + 3) + 1, this.f2514j.indexOf(64));
    }

    public String m4623f() {
        return this.f2509e;
    }

    public int m4624g() {
        return this.f2510f;
    }

    public static int m4600a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    public String m4625h() {
        int indexOf = this.f2514j.indexOf(47, this.f2506b.length() + 3);
        return this.f2514j.substring(indexOf, C1022c.m4222a(this.f2514j, indexOf, this.f2514j.length(), "?#"));
    }

    static void m4609a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    public List<String> m4626i() {
        int indexOf = this.f2514j.indexOf(47, this.f2506b.length() + 3);
        int a = C1022c.m4222a(this.f2514j, indexOf, this.f2514j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            indexOf = C1022c.m4221a(this.f2514j, i, a, '/');
            arrayList.add(this.f2514j.substring(i, indexOf));
        }
        return arrayList;
    }

    public List<String> m4627j() {
        return this.f2511g;
    }

    public String m4628k() {
        if (this.f2512h == null) {
            return null;
        }
        int indexOf = this.f2514j.indexOf(63) + 1;
        return this.f2514j.substring(indexOf, C1022c.m4221a(this.f2514j, indexOf + 1, this.f2514j.length(), '#'));
    }

    static void m4613b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    static List<String> m4612b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String m4629l() {
        if (this.f2512h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C1106s.m4613b(stringBuilder, this.f2512h);
        return stringBuilder.toString();
    }

    public String m4630m() {
        if (this.f2513i == null) {
            return null;
        }
        return this.f2514j.substring(this.f2514j.indexOf(35) + 1);
    }

    public C1106s m4618c(String str) {
        C1105a d = m4620d(str);
        return d != null ? d.m4598c() : null;
    }

    public C1105a m4631n() {
        C1105a c1105a = new C1105a();
        c1105a.f2497a = this.f2506b;
        c1105a.f2498b = m4621d();
        c1105a.f2499c = m4622e();
        c1105a.f2500d = this.f2509e;
        c1105a.f2501e = this.f2510f != C1106s.m4600a(this.f2506b) ? this.f2510f : -1;
        c1105a.f2502f.clear();
        c1105a.f2502f.addAll(m4626i());
        c1105a.m4597c(m4628k());
        c1105a.f2504h = m4630m();
        return c1105a;
    }

    public C1105a m4620d(String str) {
        C1105a c1105a = new C1105a();
        return c1105a.m4590a(this, str) == C1104a.SUCCESS ? c1105a : null;
    }

    public static C1106s m4615e(String str) {
        C1105a c1105a = new C1105a();
        if (c1105a.m4590a(null, str) == C1104a.SUCCESS) {
            return c1105a.m4598c();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1106s) && ((C1106s) obj).f2514j.equals(this.f2514j);
    }

    public int hashCode() {
        return this.f2514j.hashCode();
    }

    public String toString() {
        return this.f2514j;
    }

    static String m4605a(String str, boolean z) {
        return C1106s.m4603a(str, 0, str.length(), z);
    }

    private List<String> m4606a(List<String> list, boolean z) {
        List arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(str != null ? C1106s.m4605a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String m4603a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                C1129c c1129c = new C1129c();
                c1129c.m4774a(str, i, i3);
                C1106s.m4608a(c1129c, str, i3, i2, z);
                return c1129c.m4818o();
            }
        }
        return str.substring(i, i2);
    }

    static void m4608a(C1129c c1129c, String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt != 37 || i3 + 2 >= i2) {
                if (codePointAt == 43 && z) {
                    c1129c.m4783b(32);
                }
                c1129c.m4770a(codePointAt);
            } else {
                int a = C1106s.m4599a(str.charAt(i3 + 1));
                int a2 = C1106s.m4599a(str.charAt(i3 + 2));
                if (!(a == -1 || a2 == -1)) {
                    c1129c.m4783b((a << 4) + a2);
                    i3 += 2;
                }
                c1129c.m4770a(codePointAt);
            }
            i3 += Character.charCount(codePointAt);
        }
    }

    static boolean m4610a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && C1106s.m4599a(str.charAt(i + 1)) != -1 && C1106s.m4599a(str.charAt(i + 2)) != -1;
    }

    static int m4599a(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 65) + 10;
    }

    static String m4602a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= ad.FLAG_HIGH_PRIORITY && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !C1106s.m4610a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                C1129c c1129c = new C1129c();
                c1129c.m4774a(str, i, i3);
                C1106s.m4607a(c1129c, str, i3, i2, str2, z, z2, z3, z4);
                return c1129c.m4818o();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    static void m4607a(C1129c c1129c, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        C1129c c1129c2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!(z && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13))) {
                if (codePointAt == 43 && z3) {
                    c1129c.m4773a(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= ad.FLAG_HIGH_PRIORITY && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !C1106s.m4610a(str, i, i2)))))) {
                    if (c1129c2 == null) {
                        c1129c2 = new C1129c();
                    }
                    c1129c2.m4770a(codePointAt);
                    while (!c1129c2.m4798e()) {
                        int h = c1129c2.m4805h() & 255;
                        c1129c.m4783b(37);
                        c1129c.m4783b(f2505a[(h >> 4) & 15]);
                        c1129c.m4783b(f2505a[h & 15]);
                    }
                } else {
                    c1129c.m4770a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static String m4604a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return C1106s.m4602a(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
