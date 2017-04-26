package p018c;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: c.l */
public final class C1138l {
    static final Logger f2648a;

    /* renamed from: c.l.1 */
    static class C11351 implements C0954r {
        final /* synthetic */ C0993t f2643a;
        final /* synthetic */ OutputStream f2644b;

        C11351(C0993t c0993t, OutputStream outputStream) {
            this.f2643a = c0993t;
            this.f2644b = outputStream;
        }

        public void m4857a(C1129c c1129c, long j) {
            C1147u.m4929a(c1129c.f2624b, 0, j);
            while (j > 0) {
                this.f2643a.m4032g();
                C1143o c1143o = c1129c.f2623a;
                int min = (int) Math.min(j, (long) (c1143o.f2659c - c1143o.f2658b));
                this.f2644b.write(c1143o.f2657a, c1143o.f2658b, min);
                c1143o.f2658b += min;
                j -= (long) min;
                c1129c.f2624b -= (long) min;
                if (c1143o.f2658b == c1143o.f2659c) {
                    c1129c.f2623a = c1143o.m4904a();
                    C1144p.m4910a(c1143o);
                }
            }
        }

        public void flush() {
            this.f2644b.flush();
        }

        public void close() {
            this.f2644b.close();
        }

        public C0993t timeout() {
            return this.f2643a;
        }

        public String toString() {
            return "sink(" + this.f2644b + ")";
        }
    }

    /* renamed from: c.l.2 */
    static class C11362 implements C0946s {
        final /* synthetic */ C0993t f2645a;
        final /* synthetic */ InputStream f2646b;

        C11362(C0993t c0993t, InputStream inputStream) {
            this.f2645a = c0993t;
            this.f2646b = inputStream;
        }

        public long read(C1129c c1129c, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (j == 0) {
                return 0;
            } else {
                try {
                    this.f2645a.m4032g();
                    C1143o e = c1129c.m4796e(1);
                    int read = this.f2646b.read(e.f2657a, e.f2659c, (int) Math.min(j, (long) (8192 - e.f2659c)));
                    if (read == -1) {
                        return -1;
                    }
                    e.f2659c += read;
                    c1129c.f2624b += (long) read;
                    return (long) read;
                } catch (AssertionError e2) {
                    if (C1138l.m4868a(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public void close() {
            this.f2646b.close();
        }

        public C0993t timeout() {
            return this.f2645a;
        }

        public String toString() {
            return "source(" + this.f2646b + ")";
        }
    }

    /* renamed from: c.l.3 */
    static class C11373 extends C0994a {
        final /* synthetic */ Socket f2647a;

        C11373(Socket socket) {
            this.f2647a = socket;
        }

        protected IOException m4858a(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        protected void m4859a() {
            try {
                this.f2647a.close();
            } catch (Throwable e) {
                C1138l.f2648a.log(Level.WARNING, "Failed to close timed out socket " + this.f2647a, e);
            } catch (AssertionError e2) {
                if (C1138l.m4868a(e2)) {
                    C1138l.f2648a.log(Level.WARNING, "Failed to close timed out socket " + this.f2647a, e2);
                    return;
                }
                throw e2;
            }
        }
    }

    static {
        f2648a = Logger.getLogger(C1138l.class.getName());
    }

    private C1138l() {
    }

    public static C1128e m4861a(C0946s c0946s) {
        return new C1142n(c0946s);
    }

    public static C1127d m4860a(C0954r c0954r) {
        return new C1140m(c0954r);
    }

    public static C0954r m4862a(OutputStream outputStream) {
        return C1138l.m4863a(outputStream, new C0993t());
    }

    private static C0954r m4863a(OutputStream outputStream, C0993t c0993t) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (c0993t != null) {
            return new C11351(c0993t, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static C0954r m4864a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        C0993t c = C1138l.m4870c(socket);
        return c.m4037a(C1138l.m4863a(socket.getOutputStream(), c));
    }

    public static C0946s m4866a(InputStream inputStream) {
        return C1138l.m4867a(inputStream, new C0993t());
    }

    private static C0946s m4867a(InputStream inputStream, C0993t c0993t) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (c0993t != null) {
            return new C11362(c0993t, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static C0946s m4865a(File file) {
        if (file != null) {
            return C1138l.m4866a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static C0946s m4869b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        C0993t c = C1138l.m4870c(socket);
        return c.m4038a(C1138l.m4867a(socket.getInputStream(), c));
    }

    private static C0994a m4870c(Socket socket) {
        return new C11373(socket);
    }

    static boolean m4868a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
