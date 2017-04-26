package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p015b.aa;
import p015b.ac;
import retrofit2.Converter.Factory;
import retrofit2.http.Streaming;

final class BuiltInConverters extends Factory {

    static final class BufferingResponseBodyConverter implements Converter<ac, ac> {
        static final BufferingResponseBodyConverter INSTANCE;

        BufferingResponseBodyConverter() {
        }

        static {
            INSTANCE = new BufferingResponseBodyConverter();
        }

        public ac convert(ac acVar) {
            try {
                ac buffer = Utils.buffer(acVar);
                return buffer;
            } finally {
                acVar.close();
            }
        }
    }

    static final class RequestBodyConverter implements Converter<aa, aa> {
        static final RequestBodyConverter INSTANCE;

        RequestBodyConverter() {
        }

        static {
            INSTANCE = new RequestBodyConverter();
        }

        public aa convert(aa aaVar) {
            return aaVar;
        }
    }

    static final class StreamingResponseBodyConverter implements Converter<ac, ac> {
        static final StreamingResponseBodyConverter INSTANCE;

        StreamingResponseBodyConverter() {
        }

        static {
            INSTANCE = new StreamingResponseBodyConverter();
        }

        public ac convert(ac acVar) {
            return acVar;
        }
    }

    static final class StringConverter implements Converter<String, String> {
        static final StringConverter INSTANCE;

        StringConverter() {
        }

        static {
            INSTANCE = new StringConverter();
        }

        public String convert(String str) {
            return str;
        }
    }

    static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE;

        ToStringConverter() {
        }

        static {
            INSTANCE = new ToStringConverter();
        }

        public String convert(Object obj) {
            return obj.toString();
        }
    }

    static final class VoidResponseBodyConverter implements Converter<ac, Void> {
        static final VoidResponseBodyConverter INSTANCE;

        VoidResponseBodyConverter() {
        }

        static {
            INSTANCE = new VoidResponseBodyConverter();
        }

        public Void convert(ac acVar) {
            acVar.close();
            return null;
        }
    }

    BuiltInConverters() {
    }

    public Converter<ac, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ac.class) {
            if (Utils.isAnnotationPresent(annotationArr, Streaming.class)) {
                return StreamingResponseBodyConverter.INSTANCE;
            }
            return BufferingResponseBodyConverter.INSTANCE;
        } else if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        } else {
            return null;
        }
    }

    public Converter<?, aa> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (aa.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == String.class) {
            return StringConverter.INSTANCE;
        }
        return null;
    }
}
