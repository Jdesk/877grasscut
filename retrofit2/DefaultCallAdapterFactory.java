package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.CallAdapter.Factory;

final class DefaultCallAdapterFactory extends Factory {
    static final Factory INSTANCE;

    /* renamed from: retrofit2.DefaultCallAdapterFactory.1 */
    class C57221 implements CallAdapter<Call<?>> {
        final /* synthetic */ Type val$responseType;

        C57221(Type type) {
            this.val$responseType = type;
        }

        public Type responseType() {
            return this.val$responseType;
        }

        public <R> Call<R> adapt(Call<R> call) {
            return call;
        }
    }

    DefaultCallAdapterFactory() {
    }

    static {
        INSTANCE = new DefaultCallAdapterFactory();
    }

    public CallAdapter<?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Factory.getRawType(type) != Call.class) {
            return null;
        }
        return new C57221(Utils.getCallResponseType(type));
    }
}
