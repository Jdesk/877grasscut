package p015b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import p015b.p016a.C1022c;
import p018c.C1128e;
import p018c.C1129c;

/* renamed from: b.ac */
public abstract class ac implements Closeable {
    private Reader reader;

    /* renamed from: b.ac.1 */
    static class C10701 extends ac {
        final /* synthetic */ C1107u f2340a;
        final /* synthetic */ long f2341b;
        final /* synthetic */ C1128e f2342c;

        C10701(C1107u c1107u, long j, C1128e c1128e) {
            this.f2340a = c1107u;
            this.f2341b = j;
            this.f2342c = c1128e;
        }

        public C1107u contentType() {
            return this.f2340a;
        }

        public long contentLength() {
            return this.f2341b;
        }

        public C1128e source() {
            return this.f2342c;
        }
    }

    public abstract long contentLength();

    public abstract C1107u contentType();

    public abstract C1128e source();

    public final InputStream byteStream() {
        return source().m4753f();
    }

    public final byte[] bytes() {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        Closeable source = source();
        try {
            byte[] q = source.m4763q();
            if (contentLength == -1 || contentLength == ((long) q.length)) {
                return q;
            }
            throw new IOException("Content-Length and stream length disagree");
        } finally {
            C1022c.m4233a(source);
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        reader = new InputStreamReader(byteStream(), charset());
        this.reader = reader;
        return reader;
    }

    public final String string() {
        return new String(bytes(), charset().name());
    }

    private Charset charset() {
        C1107u contentType = contentType();
        return contentType != null ? contentType.m4634a(C1022c.f2197c) : C1022c.f2197c;
    }

    public void close() {
        C1022c.m4233a(source());
    }

    public static ac create(C1107u c1107u, String str) {
        Charset charset = C1022c.f2197c;
        if (c1107u != null) {
            charset = c1107u.m4635b();
            if (charset == null) {
                charset = C1022c.f2197c;
                c1107u = C1107u.m4632a(c1107u + "; charset=utf-8");
            }
        }
        C1128e a = new C1129c().m4776a(str, charset);
        return ac.create(c1107u, a.m4765a(), a);
    }

    public static ac create(C1107u c1107u, byte[] bArr) {
        return ac.create(c1107u, (long) bArr.length, new C1129c().m4784b(bArr));
    }

    public static ac create(C1107u c1107u, long j, C1128e c1128e) {
        if (c1128e != null) {
            return new C10701(c1107u, j, c1128e);
        }
        throw new NullPointerException("source == null");
    }
}
