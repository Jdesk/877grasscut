package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import p015b.C1120z;
import retrofit2.CallAdapter.Factory;

final class ExecutorCallAdapterFactory extends Factory {
    final Executor callbackExecutor;

    /* renamed from: retrofit2.ExecutorCallAdapterFactory.1 */
    class C57231 implements CallAdapter<Call<?>> {
        final /* synthetic */ Type val$responseType;

        C57231(Type type) {
            this.val$responseType = type;
        }

        public Type responseType() {
            return this.val$responseType;
        }

        public <R> Call<R> adapt(Call<R> call) {
            return new ExecutorCallbackCall(ExecutorCallAdapterFactory.this.callbackExecutor, call);
        }
    }

    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        /* renamed from: retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1 */
        class C57261 implements Callback<T> {
            final /* synthetic */ Callback val$callback;

            /* renamed from: retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1.1 */
            class C57241 implements Runnable {
                final /* synthetic */ Response val$response;

                C57241(Response response) {
                    this.val$response = response;
                }

                public void run() {
                    if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                        C57261.this.val$callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                    } else {
                        C57261.this.val$callback.onResponse(ExecutorCallbackCall.this, this.val$response);
                    }
                }
            }

            /* renamed from: retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.1.2 */
            class C57252 implements Runnable {
                final /* synthetic */ Throwable val$t;

                C57252(Throwable th) {
                    this.val$t = th;
                }

                public void run() {
                    C57261.this.val$callback.onFailure(ExecutorCallbackCall.this, this.val$t);
                }
            }

            C57261(Callback callback) {
                this.val$callback = callback;
            }

            public void onResponse(Call<T> call, Response<T> response) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new C57241(response));
            }

            public void onFailure(Call<T> call, Throwable th) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new C57252(th));
            }
        }

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        public void enqueue(Callback<T> callback) {
            if (callback == null) {
                throw new NullPointerException("callback == null");
            }
            this.delegate.enqueue(new C57261(callback));
        }

        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        public Response<T> execute() {
            return this.delegate.execute();
        }

        public void cancel() {
            this.delegate.cancel();
        }

        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        public C1120z request() {
            return this.delegate.request();
        }
    }

    ExecutorCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    public CallAdapter<Call<?>> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Factory.getRawType(type) != Call.class) {
            return null;
        }
        return new C57231(Utils.getCallResponseType(type));
    }
}
