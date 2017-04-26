package p018c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: c.j */
public final class C1133j implements C0946s {
    private int f2634a;
    private final C1128e f2635b;
    private final Inflater f2636c;
    private final C1134k f2637d;
    private final CRC32 f2638e;

    public C1133j(C0946s c0946s) {
        this.f2634a = 0;
        this.f2638e = new CRC32();
        if (c0946s == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f2636c = new Inflater(true);
        this.f2635b = C1138l.m4861a(c0946s);
        this.f2637d = new C1134k(this.f2635b, this.f2636c);
    }

    public long read(C1129c c1129c, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f2634a == 0) {
                m4851a();
                this.f2634a = 1;
            }
            if (this.f2634a == 1) {
                long j2 = c1129c.f2624b;
                long read = this.f2637d.read(c1129c, j);
                if (read != -1) {
                    m4852a(c1129c, j2, read);
                    return read;
                }
                this.f2634a = 2;
            }
            if (this.f2634a == 2) {
                m4854b();
                this.f2634a = 3;
                if (!this.f2635b.m4752e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    private void m4851a() {
        Object obj;
        long a;
        this.f2635b.m4749a(10);
        byte b = this.f2635b.m4750b().m4781b(3);
        if (((b >> 1) & 1) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m4852a(this.f2635b.m4750b(), 0, 10);
        }
        m4853a("ID1ID2", 8075, this.f2635b.m4757i());
        this.f2635b.m4755g(8);
        if (((b >> 2) & 1) == 1) {
            this.f2635b.m4749a(2);
            if (obj != null) {
                m4852a(this.f2635b.m4750b(), 0, 2);
            }
            short k = this.f2635b.m4750b().m4814k();
            this.f2635b.m4749a((long) k);
            if (obj != null) {
                m4852a(this.f2635b.m4750b(), 0, (long) k);
            }
            this.f2635b.m4755g((long) k);
        }
        if (((b >> 3) & 1) == 1) {
            a = this.f2635b.m4747a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                m4852a(this.f2635b.m4750b(), 0, 1 + a);
            }
            this.f2635b.m4755g(1 + a);
        }
        if (((b >> 4) & 1) == 1) {
            a = this.f2635b.m4747a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                m4852a(this.f2635b.m4750b(), 0, 1 + a);
            }
            this.f2635b.m4755g(1 + a);
        }
        if (obj != null) {
            m4853a("FHCRC", this.f2635b.m4759k(), (short) ((int) this.f2638e.getValue()));
            this.f2638e.reset();
        }
    }

    private void m4854b() {
        m4853a("CRC", this.f2635b.m4760l(), (int) this.f2638e.getValue());
        m4853a("ISIZE", this.f2635b.m4760l(), this.f2636c.getTotalOut());
    }

    public C0993t timeout() {
        return this.f2635b.timeout();
    }

    public void close() {
        this.f2637d.close();
    }

    private void m4852a(C1129c c1129c, long j, long j2) {
        C1143o c1143o = c1129c.f2623a;
        while (j >= ((long) (c1143o.f2659c - c1143o.f2658b))) {
            j -= (long) (c1143o.f2659c - c1143o.f2658b);
            c1143o = c1143o.f2662f;
        }
        while (j2 > 0) {
            int i = (int) (((long) c1143o.f2658b) + j);
            int min = (int) Math.min((long) (c1143o.f2659c - i), j2);
            this.f2638e.update(c1143o.f2657a, i, min);
            j2 -= (long) min;
            c1143o = c1143o.f2662f;
            j = 0;
        }
    }

    private void m4853a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
