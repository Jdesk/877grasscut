package p018c;

import java.util.Arrays;

/* renamed from: c.q */
final class C1145q extends C1130f {
    final transient byte[][] f2666f;
    final transient int[] f2667g;

    C1145q(C1129c c1129c, int i) {
        int i2 = 0;
        super(null);
        C1147u.m4929a(c1129c.f2624b, 0, (long) i);
        C1143o c1143o = c1129c.f2623a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (c1143o.f2659c == c1143o.f2658b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += c1143o.f2659c - c1143o.f2658b;
            i3++;
            c1143o = c1143o.f2662f;
        }
        this.f2666f = new byte[i3][];
        this.f2667g = new int[(i3 * 2)];
        C1143o c1143o2 = c1129c.f2623a;
        i4 = 0;
        while (i2 < i) {
            this.f2666f[i4] = c1143o2.f2657a;
            int i5 = (c1143o2.f2659c - c1143o2.f2658b) + i2;
            if (i5 > i) {
                i5 = i;
            }
            this.f2667g[i4] = i5;
            this.f2667g[this.f2666f.length + i4] = c1143o2.f2658b;
            c1143o2.f2660d = true;
            i4++;
            c1143o2 = c1143o2.f2662f;
            i2 = i5;
        }
    }

    public String m4915a() {
        return m4912g().m4832a();
    }

    public String m4919b() {
        return m4912g().m4836b();
    }

    public String m4920c() {
        return m4912g().m4837c();
    }

    public C1130f m4921d() {
        return m4912g().m4838d();
    }

    public C1130f m4914a(int i, int i2) {
        return m4912g().m4831a(i, i2);
    }

    public byte m4913a(int i) {
        C1147u.m4929a((long) this.f2667g[this.f2666f.length - 1], (long) i, 1);
        int b = m4911b(i);
        return this.f2666f[b][(i - (b == 0 ? 0 : this.f2667g[b - 1])) + this.f2667g[this.f2666f.length + b]];
    }

    private int m4911b(int i) {
        int binarySearch = Arrays.binarySearch(this.f2667g, 0, this.f2666f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public int m4922e() {
        return this.f2667g[this.f2666f.length - 1];
    }

    public byte[] m4923f() {
        int i = 0;
        Object obj = new byte[this.f2667g[this.f2666f.length - 1]];
        int length = this.f2666f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f2667g[length + i];
            int i4 = this.f2667g[i];
            System.arraycopy(this.f2666f[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    void m4916a(C1129c c1129c) {
        int i = 0;
        int length = this.f2666f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f2667g[length + i];
            int i4 = this.f2667g[i];
            C1143o c1143o = new C1143o(this.f2666f[i], i3, (i3 + i4) - i2);
            if (c1129c.f2623a == null) {
                c1143o.f2663g = c1143o;
                c1143o.f2662f = c1143o;
                c1129c.f2623a = c1143o;
            } else {
                c1129c.f2623a.f2663g.m4906a(c1143o);
            }
            i++;
            i2 = i4;
        }
        c1129c.f2624b = ((long) i2) + c1129c.f2624b;
    }

    public boolean m4917a(int i, C1130f c1130f, int i2, int i3) {
        if (i < 0 || i > m4922e() - i3) {
            return false;
        }
        int b = m4911b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.f2667g[b - 1];
            int min = Math.min(i3, ((this.f2667g[b] - i4) + i4) - i);
            if (!c1130f.m4835a(i2, this.f2666f[b], (i - i4) + this.f2667g[this.f2666f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    public boolean m4918a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > m4922e() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = m4911b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.f2667g[b - 1];
            int min = Math.min(i3, ((this.f2667g[b] - i4) + i4) - i);
            if (!C1147u.m4931a(this.f2666f[b], (i - i4) + this.f2667g[this.f2666f.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private C1130f m4912g() {
        return new C1130f(m4923f());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z;
        if ((obj instanceof C1130f) && ((C1130f) obj).m4839e() == m4922e() && m4917a(0, (C1130f) obj, 0, m4922e())) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.d;
        if (i == 0) {
            i = 1;
            int length = this.f2666f.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.f2666f[i2];
                int i4 = this.f2667g[length + i2];
                int i5 = this.f2667g[i2];
                i3 = (i5 - i3) + i4;
                int i6 = i4;
                i4 = i;
                for (i = i6; i < i3; i++) {
                    i4 = (i4 * 31) + bArr[i];
                }
                i2++;
                i3 = i5;
                i = i4;
            }
            this.d = i;
        }
        return i;
    }

    public String toString() {
        return m4912g().toString();
    }

    private Object writeReplace() {
        return m4912g();
    }
}
