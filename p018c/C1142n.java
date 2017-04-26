package p018c;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: c.n */
final class C1142n implements C1128e {
    public final C1129c f2654a;
    public final C0946s f2655b;
    boolean f2656c;

    /* renamed from: c.n.1 */
    class C11411 extends InputStream {
        final /* synthetic */ C1142n f2653a;

        C11411(C1142n c1142n) {
            this.f2653a = c1142n;
        }

        public int read() {
            if (this.f2653a.f2656c) {
                throw new IOException("closed");
            } else if (this.f2653a.f2654a.f2624b == 0 && this.f2653a.f2655b.read(this.f2653a.f2654a, 8192) == -1) {
                return -1;
            } else {
                return this.f2653a.f2654a.m4805h() & 255;
            }
        }

        public int read(byte[] bArr, int i, int i2) {
            if (this.f2653a.f2656c) {
                throw new IOException("closed");
            }
            C1147u.m4929a((long) bArr.length, (long) i, (long) i2);
            if (this.f2653a.f2654a.f2624b == 0 && this.f2653a.f2655b.read(this.f2653a.f2654a, 8192) == -1) {
                return -1;
            }
            return this.f2653a.f2654a.m4764a(bArr, i, i2);
        }

        public int available() {
            if (!this.f2653a.f2656c) {
                return (int) Math.min(this.f2653a.f2654a.f2624b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() {
            this.f2653a.close();
        }

        public String toString() {
            return this.f2653a + ".inputStream()";
        }
    }

    C1142n(C0946s c0946s) {
        this.f2654a = new C1129c();
        if (c0946s == null) {
            throw new NullPointerException("source == null");
        }
        this.f2655b = c0946s;
    }

    public C1129c m4889b() {
        return this.f2654a;
    }

    public long read(C1129c c1129c, long j) {
        if (c1129c == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f2656c) {
            throw new IllegalStateException("closed");
        } else if (this.f2654a.f2624b == 0 && this.f2655b.read(this.f2654a, 8192) == -1) {
            return -1;
        } else {
            return this.f2654a.read(c1129c, Math.min(j, this.f2654a.f2624b));
        }
    }

    public boolean m4892e() {
        if (!this.f2656c) {
            return this.f2654a.m4798e() && this.f2655b.read(this.f2654a, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void m4888a(long j) {
        if (!m4890b(j)) {
            throw new EOFException();
        }
    }

    public boolean m4890b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f2656c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f2654a.f2624b < j) {
                if (this.f2655b.read(this.f2654a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte m4896h() {
        m4888a(1);
        return this.f2654a.m4805h();
    }

    public C1130f m4891c(long j) {
        m4888a(j);
        return this.f2654a.m4791c(j);
    }

    public byte[] m4903q() {
        this.f2654a.m4769a(this.f2655b);
        return this.f2654a.m4820q();
    }

    public byte[] m4894f(long j) {
        m4888a(j);
        return this.f2654a.m4801f(j);
    }

    public long m4887a(C0954r c0954r) {
        if (c0954r == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f2655b.read(this.f2654a, 8192) != -1) {
            long g = this.f2654a.m4802g();
            if (g > 0) {
                j += g;
                c0954r.m3815a(this.f2654a, g);
            }
        }
        if (this.f2654a.m4765a() <= 0) {
            return j;
        }
        j += this.f2654a.m4765a();
        c0954r.m3815a(this.f2654a, this.f2654a.m4765a());
        return j;
    }

    public String m4902p() {
        long a = m4885a((byte) 10);
        if (a != -1) {
            return this.f2654a.m4797e(a);
        }
        C1129c c1129c = new C1129c();
        this.f2654a.m4771a(c1129c, 0, Math.min(32, this.f2654a.m4765a()));
        throw new EOFException("\\n not found: size=" + this.f2654a.m4765a() + " content=" + c1129c.m4817n().m4837c() + "\u2026");
    }

    public short m4897i() {
        m4888a(2);
        return this.f2654a.m4810i();
    }

    public short m4899k() {
        m4888a(2);
        return this.f2654a.m4814k();
    }

    public int m4898j() {
        m4888a(4);
        return this.f2654a.m4811j();
    }

    public int m4900l() {
        m4888a(4);
        return this.f2654a.m4815l();
    }

    public long m4901m() {
        m4888a(1);
        for (int i = 0; m4890b((long) (i + 1)); i++) {
            byte b = this.f2654a.m4781b((long) i);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
                }
                return this.f2654a.m4816m();
            }
        }
        return this.f2654a.m4816m();
    }

    public void m4895g(long j) {
        if (this.f2656c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f2654a.f2624b == 0 && this.f2655b.read(this.f2654a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f2654a.m4765a());
            this.f2654a.m4804g(min);
            j -= min;
        }
    }

    public long m4885a(byte b) {
        return m4886a(b, 0);
    }

    public long m4886a(byte b, long j) {
        if (this.f2656c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long a = this.f2654a.m4767a(b, j);
            if (a != -1) {
                return a;
            }
            a = this.f2654a.f2624b;
            if (this.f2655b.read(this.f2654a, 8192) == -1) {
                return -1;
            }
            j = Math.max(j, a);
        }
    }

    public InputStream m4893f() {
        return new C11411(this);
    }

    public void close() {
        if (!this.f2656c) {
            this.f2656c = true;
            this.f2655b.close();
            this.f2654a.m4821r();
        }
    }

    public C0993t timeout() {
        return this.f2655b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f2655b + ")";
    }
}
