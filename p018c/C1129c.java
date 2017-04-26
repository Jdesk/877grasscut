package p018c;

import android.support.v4.app.ad;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import io.card.payment.BuildConfig;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* renamed from: c.c */
public final class C1129c implements C1127d, C1128e, Cloneable {
    private static final byte[] f2622c;
    C1143o f2623a;
    long f2624b;

    /* renamed from: c.c.1 */
    class C11251 extends OutputStream {
        final /* synthetic */ C1129c f2620a;

        C11251(C1129c c1129c) {
            this.f2620a = c1129c;
        }

        public void write(int i) {
            this.f2620a.m4783b((byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f2620a.m4785b(bArr, i, i2);
        }

        public void flush() {
        }

        public void close() {
        }

        public String toString() {
            return this.f2620a + ".outputStream()";
        }
    }

    /* renamed from: c.c.2 */
    class C11262 extends InputStream {
        final /* synthetic */ C1129c f2621a;

        C11262(C1129c c1129c) {
            this.f2621a = c1129c;
        }

        public int read() {
            if (this.f2621a.f2624b > 0) {
                return this.f2621a.m4805h() & 255;
            }
            return -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return this.f2621a.m4764a(bArr, i, i2);
        }

        public int available() {
            return (int) Math.min(this.f2621a.f2624b, 2147483647L);
        }

        public void close() {
        }

        public String toString() {
            return this.f2621a + ".inputStream()";
        }
    }

    public /* synthetic */ C1127d m4786b(C1130f c1130f) {
        return m4772a(c1130f);
    }

    public /* synthetic */ C1127d m4787b(String str) {
        return m4773a(str);
    }

    public /* synthetic */ C1127d m4789c(byte[] bArr) {
        return m4784b(bArr);
    }

    public /* synthetic */ C1127d m4790c(byte[] bArr, int i, int i2) {
        return m4785b(bArr, i, i2);
    }

    public /* synthetic */ Object clone() {
        return m4822s();
    }

    public /* synthetic */ C1127d m4803g(int i) {
        return m4794d(i);
    }

    public /* synthetic */ C1127d m4807h(int i) {
        return m4788c(i);
    }

    public /* synthetic */ C1127d m4809i(int i) {
        return m4783b(i);
    }

    public /* synthetic */ C1127d m4812j(long j) {
        return m4808i(j);
    }

    public /* synthetic */ C1127d m4813k(long j) {
        return m4806h(j);
    }

    public /* synthetic */ C1127d m4824u() {
        return m4793d();
    }

    static {
        f2622c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    }

    public long m4765a() {
        return this.f2624b;
    }

    public C1129c m4782b() {
        return this;
    }

    public OutputStream m4792c() {
        return new C11251(this);
    }

    public C1129c m4793d() {
        return this;
    }

    public boolean m4798e() {
        return this.f2624b == 0;
    }

    public void m4778a(long j) {
        if (this.f2624b < j) {
            throw new EOFException();
        }
    }

    public InputStream m4800f() {
        return new C11262(this);
    }

    public C1129c m4771a(C1129c c1129c, long j, long j2) {
        if (c1129c == null) {
            throw new IllegalArgumentException("out == null");
        }
        C1147u.m4929a(this.f2624b, j, j2);
        if (j2 != 0) {
            c1129c.f2624b += j2;
            C1143o c1143o = this.f2623a;
            while (j >= ((long) (c1143o.f2659c - c1143o.f2658b))) {
                j -= (long) (c1143o.f2659c - c1143o.f2658b);
                c1143o = c1143o.f2662f;
            }
            while (j2 > 0) {
                C1143o c1143o2 = new C1143o(c1143o);
                c1143o2.f2658b = (int) (((long) c1143o2.f2658b) + j);
                c1143o2.f2659c = Math.min(c1143o2.f2658b + ((int) j2), c1143o2.f2659c);
                if (c1129c.f2623a == null) {
                    c1143o2.f2663g = c1143o2;
                    c1143o2.f2662f = c1143o2;
                    c1129c.f2623a = c1143o2;
                } else {
                    c1129c.f2623a.f2663g.m4906a(c1143o2);
                }
                j2 -= (long) (c1143o2.f2659c - c1143o2.f2658b);
                c1143o = c1143o.f2662f;
                j = 0;
            }
        }
        return this;
    }

    public long m4802g() {
        long j = this.f2624b;
        if (j == 0) {
            return 0;
        }
        C1143o c1143o = this.f2623a.f2663g;
        if (c1143o.f2659c >= 8192 || !c1143o.f2661e) {
            return j;
        }
        return j - ((long) (c1143o.f2659c - c1143o.f2658b));
    }

    public byte m4805h() {
        if (this.f2624b == 0) {
            throw new IllegalStateException("size == 0");
        }
        C1143o c1143o = this.f2623a;
        int i = c1143o.f2658b;
        int i2 = c1143o.f2659c;
        int i3 = i + 1;
        byte b = c1143o.f2657a[i];
        this.f2624b--;
        if (i3 == i2) {
            this.f2623a = c1143o.m4904a();
            C1144p.m4910a(c1143o);
        } else {
            c1143o.f2658b = i3;
        }
        return b;
    }

    public byte m4781b(long j) {
        C1147u.m4929a(this.f2624b, j, 1);
        C1143o c1143o = this.f2623a;
        while (true) {
            int i = c1143o.f2659c - c1143o.f2658b;
            if (j < ((long) i)) {
                return c1143o.f2657a[c1143o.f2658b + ((int) j)];
            }
            j -= (long) i;
            c1143o = c1143o.f2662f;
        }
    }

    public short m4810i() {
        if (this.f2624b < 2) {
            throw new IllegalStateException("size < 2: " + this.f2624b);
        }
        C1143o c1143o = this.f2623a;
        int i = c1143o.f2658b;
        int i2 = c1143o.f2659c;
        if (i2 - i < 2) {
            return (short) (((m4805h() & 255) << 8) | (m4805h() & 255));
        }
        byte[] bArr = c1143o.f2657a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f2624b -= 2;
        if (i4 == i2) {
            this.f2623a = c1143o.m4904a();
            C1144p.m4910a(c1143o);
        } else {
            c1143o.f2658b = i4;
        }
        return (short) i;
    }

    public int m4811j() {
        if (this.f2624b < 4) {
            throw new IllegalStateException("size < 4: " + this.f2624b);
        }
        C1143o c1143o = this.f2623a;
        int i = c1143o.f2658b;
        int i2 = c1143o.f2659c;
        if (i2 - i < 4) {
            return ((((m4805h() & 255) << 24) | ((m4805h() & 255) << 16)) | ((m4805h() & 255) << 8)) | (m4805h() & 255);
        }
        byte[] bArr = c1143o.f2657a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.f2624b -= 4;
        if (i4 == i2) {
            this.f2623a = c1143o.m4904a();
            C1144p.m4910a(c1143o);
            return i;
        }
        c1143o.f2658b = i4;
        return i;
    }

    public short m4814k() {
        return C1147u.m4928a(m4810i());
    }

    public int m4815l() {
        return C1147u.m4927a(m4811j());
    }

    public long m4816m() {
        if (this.f2624b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        do {
            C1143o c1143o = this.f2623a;
            byte[] bArr = c1143o.f2657a;
            int i2 = c1143o.f2658b;
            int i3 = c1143o.f2659c;
            int i4 = i2;
            while (i4 < i3) {
                int i5 = bArr[i4];
                if (i5 >= 48 && i5 <= 57) {
                    i2 = i5 - 48;
                } else if (i5 >= 97 && i5 <= 102) {
                    i2 = (i5 - 97) + 10;
                } else if (i5 < 65 || i5 > 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.f2623a = c1143o.m4904a();
                            C1144p.m4910a(c1143o);
                        } else {
                            c1143o.f2658b = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i5));
                    }
                } else {
                    i2 = (i5 - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new C1129c().m4808i(j).m4783b(i5).m4818o());
                }
                i++;
                i4++;
                j = ((long) i2) | (j << 4);
            }
            if (i4 != i3) {
                c1143o.f2658b = i4;
            } else {
                this.f2623a = c1143o.m4904a();
                C1144p.m4910a(c1143o);
            }
            if (obj == null) {
                break;
            }
        } while (this.f2623a != null);
        this.f2624b -= (long) i;
        return j;
    }

    public C1130f m4817n() {
        return new C1130f(m4820q());
    }

    public C1130f m4791c(long j) {
        return new C1130f(m4801f(j));
    }

    public long m4768a(C0954r c0954r) {
        long j = this.f2624b;
        if (j > 0) {
            c0954r.m3815a(this, j);
        }
        return j;
    }

    public String m4818o() {
        try {
            return m4777a(this.f2624b, C1147u.f2668a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String m4795d(long j) {
        return m4777a(j, C1147u.f2668a);
    }

    public String m4777a(long j, Charset charset) {
        C1147u.m4929a(this.f2624b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return BuildConfig.FLAVOR;
        } else {
            C1143o c1143o = this.f2623a;
            if (((long) c1143o.f2658b) + j > ((long) c1143o.f2659c)) {
                return new String(m4801f(j), charset);
            }
            String str = new String(c1143o.f2657a, c1143o.f2658b, (int) j, charset);
            c1143o.f2658b = (int) (((long) c1143o.f2658b) + j);
            this.f2624b -= j;
            if (c1143o.f2658b != c1143o.f2659c) {
                return str;
            }
            this.f2623a = c1143o.m4904a();
            C1144p.m4910a(c1143o);
            return str;
        }
    }

    public String m4819p() {
        long a = m4766a((byte) 10);
        if (a != -1) {
            return m4797e(a);
        }
        C1129c c1129c = new C1129c();
        m4771a(c1129c, 0, Math.min(32, this.f2624b));
        throw new EOFException("\\n not found: size=" + m4765a() + " content=" + c1129c.m4817n().m4837c() + "\u2026");
    }

    String m4797e(long j) {
        if (j <= 0 || m4781b(j - 1) != 13) {
            String d = m4795d(j);
            m4804g(1);
            return d;
        }
        d = m4795d(j - 1);
        m4804g(2);
        return d;
    }

    public byte[] m4820q() {
        try {
            return m4801f(this.f2624b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] m4801f(long j) {
        C1147u.m4929a(this.f2624b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        m4780a(bArr);
        return bArr;
    }

    public void m4780a(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int a = m4764a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public int m4764a(byte[] bArr, int i, int i2) {
        C1147u.m4929a((long) bArr.length, (long) i, (long) i2);
        C1143o c1143o = this.f2623a;
        if (c1143o == null) {
            return -1;
        }
        int min = Math.min(i2, c1143o.f2659c - c1143o.f2658b);
        System.arraycopy(c1143o.f2657a, c1143o.f2658b, bArr, i, min);
        c1143o.f2658b += min;
        this.f2624b -= (long) min;
        if (c1143o.f2658b != c1143o.f2659c) {
            return min;
        }
        this.f2623a = c1143o.m4904a();
        C1144p.m4910a(c1143o);
        return min;
    }

    public void m4821r() {
        try {
            m4804g(this.f2624b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void m4804g(long j) {
        while (j > 0) {
            if (this.f2623a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f2623a.f2659c - this.f2623a.f2658b));
            this.f2624b -= (long) min;
            j -= (long) min;
            C1143o c1143o = this.f2623a;
            c1143o.f2658b = min + c1143o.f2658b;
            if (this.f2623a.f2658b == this.f2623a.f2659c) {
                C1143o c1143o2 = this.f2623a;
                this.f2623a = c1143o2.m4904a();
                C1144p.m4910a(c1143o2);
            }
        }
    }

    public C1129c m4772a(C1130f c1130f) {
        if (c1130f == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        c1130f.m4833a(this);
        return this;
    }

    public C1129c m4773a(String str) {
        return m4774a(str, 0, str.length());
    }

    public C1129c m4774a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt < '\u0080') {
                    int i4;
                    C1143o e = m4796e(1);
                    byte[] bArr = e.f2657a;
                    int i5 = e.f2659c - i;
                    int min = Math.min(i2, 8192 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '\u0080') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - e.f2659c;
                    e.f2659c += i4;
                    this.f2624b += (long) i4;
                } else if (charAt < '\u0800') {
                    m4783b((charAt >> 6) | 192);
                    m4783b((charAt & 63) | ad.FLAG_HIGH_PRIORITY);
                    i3 = i + 1;
                } else if (charAt < '\ud800' || charAt > '\udfff') {
                    m4783b((charAt >> 12) | 224);
                    m4783b(((charAt >> 6) & 63) | ad.FLAG_HIGH_PRIORITY);
                    m4783b((charAt & 63) | ad.FLAG_HIGH_PRIORITY);
                    i3 = i + 1;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '\udbff' || i3 < 56320 || i3 > 57343) {
                        m4783b(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        m4783b((i3 >> 18) | 240);
                        m4783b(((i3 >> 12) & 63) | ad.FLAG_HIGH_PRIORITY);
                        m4783b(((i3 >> 6) & 63) | ad.FLAG_HIGH_PRIORITY);
                        m4783b((i3 & 63) | ad.FLAG_HIGH_PRIORITY);
                        i3 = i + 2;
                    }
                }
                i = i3;
            }
            return this;
        }
    }

    public C1129c m4770a(int i) {
        if (i < ad.FLAG_HIGH_PRIORITY) {
            m4783b(i);
        } else if (i < ItemAnimator.FLAG_MOVED) {
            m4783b((i >> 6) | 192);
            m4783b((i & 63) | ad.FLAG_HIGH_PRIORITY);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                m4783b((i >> 12) | 224);
                m4783b(((i >> 6) & 63) | ad.FLAG_HIGH_PRIORITY);
                m4783b((i & 63) | ad.FLAG_HIGH_PRIORITY);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            m4783b((i >> 18) | 240);
            m4783b(((i >> 12) & 63) | ad.FLAG_HIGH_PRIORITY);
            m4783b(((i >> 6) & 63) | ad.FLAG_HIGH_PRIORITY);
            m4783b((i & 63) | ad.FLAG_HIGH_PRIORITY);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public C1129c m4776a(String str, Charset charset) {
        return m4775a(str, 0, str.length(), charset);
    }

    public C1129c m4775a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C1147u.f2668a)) {
            return m4773a(str);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return m4785b(bytes, 0, bytes.length);
        }
    }

    public C1129c m4784b(byte[] bArr) {
        if (bArr != null) {
            return m4785b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public C1129c m4785b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        C1147u.m4929a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            C1143o e = m4796e(1);
            int min = Math.min(i3 - i, 8192 - e.f2659c);
            System.arraycopy(bArr, i, e.f2657a, e.f2659c, min);
            i += min;
            e.f2659c = min + e.f2659c;
        }
        this.f2624b += (long) i2;
        return this;
    }

    public long m4769a(C0946s c0946s) {
        if (c0946s == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = c0946s.read(this, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public C1129c m4783b(int i) {
        C1143o e = m4796e(1);
        byte[] bArr = e.f2657a;
        int i2 = e.f2659c;
        e.f2659c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f2624b++;
        return this;
    }

    public C1129c m4788c(int i) {
        C1143o e = m4796e(2);
        byte[] bArr = e.f2657a;
        int i2 = e.f2659c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f2659c = i2;
        this.f2624b += 2;
        return this;
    }

    public C1129c m4794d(int i) {
        C1143o e = m4796e(4);
        byte[] bArr = e.f2657a;
        int i2 = e.f2659c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.f2659c = i2;
        this.f2624b += 4;
        return this;
    }

    public C1129c m4806h(long j) {
        if (j == 0) {
            return m4783b(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return m4773a("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        C1143o e = m4796e(i);
        byte[] bArr = e.f2657a;
        int i2 = e.f2659c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f2622c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        e.f2659c += i;
        this.f2624b = ((long) i) + this.f2624b;
        return this;
    }

    public C1129c m4808i(long j) {
        if (j == 0) {
            return m4783b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        C1143o e = m4796e(numberOfTrailingZeros);
        byte[] bArr = e.f2657a;
        int i = e.f2659c;
        for (int i2 = (e.f2659c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f2622c[(int) (15 & j)];
            j >>>= 4;
        }
        e.f2659c += numberOfTrailingZeros;
        this.f2624b = ((long) numberOfTrailingZeros) + this.f2624b;
        return this;
    }

    C1143o m4796e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.f2623a == null) {
            this.f2623a = C1144p.m4909a();
            C1143o c1143o = this.f2623a;
            C1143o c1143o2 = this.f2623a;
            r0 = this.f2623a;
            c1143o2.f2663g = r0;
            c1143o.f2662f = r0;
            return r0;
        } else {
            r0 = this.f2623a.f2663g;
            if (r0.f2659c + i > 8192 || !r0.f2661e) {
                return r0.m4906a(C1144p.m4909a());
            }
            return r0;
        }
    }

    public void m4779a(C1129c c1129c, long j) {
        if (c1129c == null) {
            throw new IllegalArgumentException("source == null");
        } else if (c1129c == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            C1147u.m4929a(c1129c.f2624b, 0, j);
            while (j > 0) {
                C1143o c1143o;
                if (j < ((long) (c1129c.f2623a.f2659c - c1129c.f2623a.f2658b))) {
                    c1143o = this.f2623a != null ? this.f2623a.f2663g : null;
                    if (c1143o != null && c1143o.f2661e) {
                        if ((((long) c1143o.f2659c) + j) - ((long) (c1143o.f2660d ? 0 : c1143o.f2658b)) <= 8192) {
                            c1129c.f2623a.m4907a(c1143o, (int) j);
                            c1129c.f2624b -= j;
                            this.f2624b += j;
                            return;
                        }
                    }
                    c1129c.f2623a = c1129c.f2623a.m4905a((int) j);
                }
                C1143o c1143o2 = c1129c.f2623a;
                long j2 = (long) (c1143o2.f2659c - c1143o2.f2658b);
                c1129c.f2623a = c1143o2.m4904a();
                if (this.f2623a == null) {
                    this.f2623a = c1143o2;
                    c1143o2 = this.f2623a;
                    c1143o = this.f2623a;
                    C1143o c1143o3 = this.f2623a;
                    c1143o.f2663g = c1143o3;
                    c1143o2.f2662f = c1143o3;
                } else {
                    this.f2623a.f2663g.m4906a(c1143o2).m4908b();
                }
                c1129c.f2624b -= j2;
                this.f2624b += j2;
                j -= j2;
            }
        }
    }

    public long read(C1129c c1129c, long j) {
        if (c1129c == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f2624b == 0) {
            return -1;
        } else {
            if (j > this.f2624b) {
                j = this.f2624b;
            }
            c1129c.m4779a(this, j);
            return j;
        }
    }

    public long m4766a(byte b) {
        return m4767a(b, 0);
    }

    public long m4767a(byte b, long j) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        C1143o c1143o = this.f2623a;
        if (c1143o == null) {
            return -1;
        }
        C1143o c1143o2;
        if (this.f2624b - j >= j) {
            c1143o2 = c1143o;
            while (true) {
                long j3 = ((long) (c1143o2.f2659c - c1143o2.f2658b)) + j2;
                if (j3 >= j) {
                    break;
                }
                c1143o2 = c1143o2.f2662f;
                j2 = j3;
            }
        } else {
            j2 = this.f2624b;
            c1143o2 = c1143o;
            while (j2 > j) {
                c1143o2 = c1143o2.f2663g;
                j2 -= (long) (c1143o2.f2659c - c1143o2.f2658b);
            }
        }
        while (j2 < this.f2624b) {
            byte[] bArr = c1143o2.f2657a;
            int i = c1143o2.f2659c;
            for (int i2 = (int) ((((long) c1143o2.f2658b) + j) - j2); i2 < i; i2++) {
                if (bArr[i2] == b) {
                    return j2 + ((long) (i2 - c1143o2.f2658b));
                }
            }
            j2 += (long) (c1143o2.f2659c - c1143o2.f2658b);
            c1143o2 = c1143o2.f2662f;
            j = j2;
        }
        return -1;
    }

    public void flush() {
    }

    public void close() {
    }

    public C0993t timeout() {
        return C0993t.f2089b;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1129c)) {
            return false;
        }
        C1129c c1129c = (C1129c) obj;
        if (this.f2624b != c1129c.f2624b) {
            return false;
        }
        if (this.f2624b == 0) {
            return true;
        }
        C1143o c1143o = this.f2623a;
        C1143o c1143o2 = c1129c.f2623a;
        int i = c1143o.f2658b;
        int i2 = c1143o2.f2658b;
        while (j < this.f2624b) {
            long min = (long) Math.min(c1143o.f2659c - i, c1143o2.f2659c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = c1143o.f2657a[i];
                i = i2 + 1;
                if (b != c1143o2.f2657a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == c1143o.f2659c) {
                c1143o = c1143o.f2662f;
                i = c1143o.f2658b;
            }
            if (i2 == c1143o2.f2659c) {
                c1143o2 = c1143o2.f2662f;
                i2 = c1143o2.f2658b;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        C1143o c1143o = this.f2623a;
        if (c1143o == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c1143o.f2658b;
            while (i2 < c1143o.f2659c) {
                int i3 = c1143o.f2657a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            c1143o = c1143o.f2662f;
        } while (c1143o != this.f2623a);
        return i;
    }

    public String toString() {
        return m4823t().toString();
    }

    public C1129c m4822s() {
        C1129c c1129c = new C1129c();
        if (this.f2624b == 0) {
            return c1129c;
        }
        c1129c.f2623a = new C1143o(this.f2623a);
        C1143o c1143o = c1129c.f2623a;
        C1143o c1143o2 = c1129c.f2623a;
        C1143o c1143o3 = c1129c.f2623a;
        c1143o2.f2663g = c1143o3;
        c1143o.f2662f = c1143o3;
        for (c1143o = this.f2623a.f2662f; c1143o != this.f2623a; c1143o = c1143o.f2662f) {
            c1129c.f2623a.f2663g.m4906a(new C1143o(c1143o));
        }
        c1129c.f2624b = this.f2624b;
        return c1129c;
    }

    public C1130f m4823t() {
        if (this.f2624b <= 2147483647L) {
            return m4799f((int) this.f2624b);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f2624b);
    }

    public C1130f m4799f(int i) {
        if (i == 0) {
            return C1130f.f2626b;
        }
        return new C1145q(this, i);
    }
}
