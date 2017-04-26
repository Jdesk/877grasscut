package p018c;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: c.m */
final class C1140m implements C1127d {
    public final C1129c f2650a;
    public final C0954r f2651b;
    boolean f2652c;

    /* renamed from: c.m.1 */
    class C11391 extends OutputStream {
        final /* synthetic */ C1140m f2649a;

        C11391(C1140m c1140m) {
            this.f2649a = c1140m;
        }

        public void write(int i) {
            if (this.f2649a.f2652c) {
                throw new IOException("closed");
            }
            this.f2649a.f2650a.m4783b((byte) i);
            this.f2649a.m4884u();
        }

        public void write(byte[] bArr, int i, int i2) {
            if (this.f2649a.f2652c) {
                throw new IOException("closed");
            }
            this.f2649a.f2650a.m4785b(bArr, i, i2);
            this.f2649a.m4884u();
        }

        public void flush() {
            if (!this.f2649a.f2652c) {
                this.f2649a.flush();
            }
        }

        public void close() {
            this.f2649a.close();
        }

        public String toString() {
            return this.f2649a + ".outputStream()";
        }
    }

    C1140m(C0954r c0954r) {
        this.f2650a = new C1129c();
        if (c0954r == null) {
            throw new NullPointerException("sink == null");
        }
        this.f2651b = c0954r;
    }

    public C1129c m4873b() {
        return this.f2650a;
    }

    public void m4872a(C1129c c1129c, long j) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4779a(c1129c, j);
        m4884u();
    }

    public C1127d m4874b(C1130f c1130f) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4772a(c1130f);
        return m4884u();
    }

    public C1127d m4875b(String str) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4773a(str);
        return m4884u();
    }

    public C1127d m4876c(byte[] bArr) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4784b(bArr);
        return m4884u();
    }

    public C1127d m4877c(byte[] bArr, int i, int i2) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4785b(bArr, i, i2);
        return m4884u();
    }

    public long m4871a(C0946s c0946s) {
        if (c0946s == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = c0946s.read(this.f2650a, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            m4884u();
        }
    }

    public C1127d m4881i(int i) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4783b(i);
        return m4884u();
    }

    public C1127d m4880h(int i) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4788c(i);
        return m4884u();
    }

    public C1127d m4879g(int i) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4794d(i);
        return m4884u();
    }

    public C1127d m4883k(long j) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4806h(j);
        return m4884u();
    }

    public C1127d m4882j(long j) {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        this.f2650a.m4808i(j);
        return m4884u();
    }

    public C1127d m4884u() {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        long g = this.f2650a.m4802g();
        if (g > 0) {
            this.f2651b.m3815a(this.f2650a, g);
        }
        return this;
    }

    public OutputStream m4878c() {
        return new C11391(this);
    }

    public void flush() {
        if (this.f2652c) {
            throw new IllegalStateException("closed");
        }
        if (this.f2650a.f2624b > 0) {
            this.f2651b.m3815a(this.f2650a, this.f2650a.f2624b);
        }
        this.f2651b.flush();
    }

    public void close() {
        if (!this.f2652c) {
            Throwable th = null;
            try {
                if (this.f2650a.f2624b > 0) {
                    this.f2651b.m3815a(this.f2650a, this.f2650a.f2624b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f2651b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f2652c = true;
            if (th != null) {
                C1147u.m4930a(th);
            }
        }
    }

    public C0993t timeout() {
        return this.f2651b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f2651b + ")";
    }
}
