package p015b;

import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;
import p015b.p016a.C1022c;
import p018c.C1127d;
import p018c.C1130f;
import p018c.C1138l;

/* renamed from: b.aa */
public abstract class aa {

    /* renamed from: b.aa.1 */
    static class C10651 extends aa {
        final /* synthetic */ C1107u f2307a;
        final /* synthetic */ C1130f f2308b;

        C10651(C1107u c1107u, C1130f c1130f) {
            this.f2307a = c1107u;
            this.f2308b = c1130f;
        }

        public C1107u contentType() {
            return this.f2307a;
        }

        public long contentLength() {
            return (long) this.f2308b.m4839e();
        }

        public void writeTo(C1127d c1127d) {
            c1127d.m4736b(this.f2308b);
        }
    }

    /* renamed from: b.aa.2 */
    static class C10662 extends aa {
        final /* synthetic */ C1107u f2309a;
        final /* synthetic */ int f2310b;
        final /* synthetic */ byte[] f2311c;
        final /* synthetic */ int f2312d;

        C10662(C1107u c1107u, int i, byte[] bArr, int i2) {
            this.f2309a = c1107u;
            this.f2310b = i;
            this.f2311c = bArr;
            this.f2312d = i2;
        }

        public C1107u contentType() {
            return this.f2309a;
        }

        public long contentLength() {
            return (long) this.f2310b;
        }

        public void writeTo(C1127d c1127d) {
            c1127d.m4739c(this.f2311c, this.f2312d, this.f2310b);
        }
    }

    /* renamed from: b.aa.3 */
    static class C10673 extends aa {
        final /* synthetic */ C1107u f2313a;
        final /* synthetic */ File f2314b;

        C10673(C1107u c1107u, File file) {
            this.f2313a = c1107u;
            this.f2314b = file;
        }

        public C1107u contentType() {
            return this.f2313a;
        }

        public long contentLength() {
            return this.f2314b.length();
        }

        public void writeTo(C1127d c1127d) {
            Closeable closeable = null;
            try {
                closeable = C1138l.m4865a(this.f2314b);
                c1127d.m4734a(closeable);
            } finally {
                C1022c.m4233a(closeable);
            }
        }
    }

    public abstract C1107u contentType();

    public abstract void writeTo(C1127d c1127d);

    public long contentLength() {
        return -1;
    }

    public static aa create(C1107u c1107u, String str) {
        Charset charset = C1022c.f2197c;
        if (c1107u != null) {
            charset = c1107u.m4635b();
            if (charset == null) {
                charset = C1022c.f2197c;
                c1107u = C1107u.m4632a(c1107u + "; charset=utf-8");
            }
        }
        return aa.create(c1107u, str.getBytes(charset));
    }

    public static aa create(C1107u c1107u, C1130f c1130f) {
        return new C10651(c1107u, c1130f);
    }

    public static aa create(C1107u c1107u, byte[] bArr) {
        return aa.create(c1107u, bArr, 0, bArr.length);
    }

    public static aa create(C1107u c1107u, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        C1022c.m4232a((long) bArr.length, (long) i, (long) i2);
        return new C10662(c1107u, i2, bArr, i);
    }

    public static aa create(C1107u c1107u, File file) {
        if (file != null) {
            return new C10673(c1107u, file);
        }
        throw new NullPointerException("content == null");
    }
}
