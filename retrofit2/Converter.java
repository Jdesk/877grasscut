package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p015b.aa;
import p015b.ac;

public interface Converter<F, T> {

    public static abstract class Factory {
        public Converter<ac, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        public Converter<?, aa> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    T convert(F f);
}
