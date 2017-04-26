package retrofit2;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.io.IOException;
import p015b.C1078e;
import p015b.C1079f;
import p015b.C1107u;
import p015b.C1120z;
import p015b.ab;
import p015b.ac;
import p018c.C0946s;
import p018c.C1010h;
import p018c.C1128e;
import p018c.C1129c;
import p018c.C1138l;

final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private C1078e rawCall;
    private final ServiceMethod<T> serviceMethod;

    /* renamed from: retrofit2.OkHttpCall.1 */
    class C57271 implements C1079f {
        final /* synthetic */ Callback val$callback;

        C57271(Callback callback) {
            this.val$callback = callback;
        }

        public void onResponse(C1078e c1078e, ab abVar) {
            try {
                callSuccess(OkHttpCall.this.parseResponse(abVar));
            } catch (Throwable th) {
                callFailure(th);
            }
        }

        public void onFailure(C1078e c1078e, IOException iOException) {
            try {
                this.val$callback.onFailure(OkHttpCall.this, iOException);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private void callFailure(Throwable th) {
            try {
                this.val$callback.onFailure(OkHttpCall.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        private void callSuccess(Response<T> response) {
            try {
                this.val$callback.onResponse(OkHttpCall.this, response);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static final class ExceptionCatchingRequestBody extends ac {
        private final ac delegate;
        IOException thrownException;

        /* renamed from: retrofit2.OkHttpCall.ExceptionCatchingRequestBody.1 */
        class C57281 extends C1010h {
            C57281(C0946s c0946s) {
                super(c0946s);
            }

            public long read(C1129c c1129c, long j) {
                try {
                    return super.read(c1129c, j);
                } catch (IOException e) {
                    ExceptionCatchingRequestBody.this.thrownException = e;
                    throw e;
                }
            }
        }

        ExceptionCatchingRequestBody(ac acVar) {
            this.delegate = acVar;
        }

        public C1107u contentType() {
            return this.delegate.contentType();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public C1128e source() {
            return C1138l.m4861a(new C57281(this.delegate.source()));
        }

        public void close() {
            this.delegate.close();
        }

        void throwIfCaught() {
            if (this.thrownException != null) {
                throw this.thrownException;
            }
        }
    }

    static final class NoContentResponseBody extends ac {
        private final long contentLength;
        private final C1107u contentType;

        NoContentResponseBody(C1107u c1107u, long j) {
            this.contentType = c1107u;
            this.contentLength = j;
        }

        public C1107u contentType() {
            return this.contentType;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public C1128e source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(ServiceMethod<T> serviceMethod, Object[] objArr) {
        this.serviceMethod = serviceMethod;
        this.args = objArr;
    }

    public OkHttpCall<T> clone() {
        return new OkHttpCall(this.serviceMethod, this.args);
    }

    public synchronized C1120z request() {
        C1120z a;
        C1078e c1078e = this.rawCall;
        if (c1078e != null) {
            a = c1078e.m4483a();
        } else {
            if (this.creationFailure == null) {
                try {
                    c1078e = createRawCall();
                    this.rawCall = c1078e;
                    a = c1078e.m4483a();
                } catch (Throwable e) {
                    this.creationFailure = e;
                    throw e;
                } catch (Throwable e2) {
                    this.creationFailure = e2;
                    throw new RuntimeException("Unable to create request.", e2);
                }
            } else if (this.creationFailure instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.creationFailure);
            } else {
                throw ((RuntimeException) this.creationFailure);
            }
        }
        return a;
    }

    public void enqueue(Callback<T> callback) {
        if (callback == null) {
            throw new NullPointerException("callback == null");
        }
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            C1078e createRawCall;
            this.executed = true;
            C1078e c1078e = this.rawCall;
            Throwable th = this.creationFailure;
            if (c1078e == null && th == null) {
                try {
                    createRawCall = createRawCall();
                    this.rawCall = createRawCall;
                } catch (Throwable th2) {
                    th = th2;
                    this.creationFailure = th;
                    createRawCall = c1078e;
                }
            } else {
                createRawCall = c1078e;
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            createRawCall.m4486c();
        }
        createRawCall.m4484a(new C57271(callback));
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> execute() {
        C1078e c1078e;
        Throwable e;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            if (this.creationFailure == null) {
                c1078e = this.rawCall;
                if (c1078e == null) {
                    try {
                        c1078e = createRawCall();
                        this.rawCall = c1078e;
                    } catch (IOException e2) {
                        e = e2;
                        this.creationFailure = e;
                        throw e;
                    } catch (RuntimeException e3) {
                        e = e3;
                        this.creationFailure = e;
                        throw e;
                    }
                }
            } else if (this.creationFailure instanceof IOException) {
                throw ((IOException) this.creationFailure);
            } else {
                throw ((RuntimeException) this.creationFailure);
            }
        }
        if (this.canceled) {
            c1078e.m4486c();
        }
        return parseResponse(c1078e.m4485b());
    }

    private C1078e createRawCall() {
        C1078e a = this.serviceMethod.callFactory.m4482a(this.serviceMethod.toRequest(this.args));
        if (a != null) {
            return a;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    Response<T> parseResponse(ab abVar) {
        ac g = abVar.m4455g();
        ab a = abVar.m4456h().m4423a(new NoContentResponseBody(g.contentType(), g.contentLength())).m4430a();
        int b = a.m4450b();
        if (b < Callback.DEFAULT_DRAG_ANIMATION_DURATION || b >= 300) {
            try {
                Response<T> error = Response.error(Utils.buffer(g), a);
                return error;
            } finally {
                g.close();
            }
        } else if (b == 204 || b == 205) {
            return Response.success(null, a);
        } else {
            ac exceptionCatchingRequestBody = new ExceptionCatchingRequestBody(g);
            try {
                return Response.success(this.serviceMethod.toResponse(exceptionCatchingRequestBody), a);
            } catch (RuntimeException e) {
                exceptionCatchingRequestBody.throwIfCaught();
                throw e;
            }
        }
    }

    public void cancel() {
        this.canceled = true;
        synchronized (this) {
            C1078e c1078e = this.rawCall;
        }
        if (c1078e != null) {
            c1078e.m4486c();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }
}
