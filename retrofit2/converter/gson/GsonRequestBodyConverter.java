package retrofit2.converter.gson;

import com.google.gson.C3676t;
import com.google.gson.Gson;
import com.google.gson.p110c.C3704c;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import p015b.C1107u;
import p015b.aa;
import p018c.C1129c;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, aa> {
    private static final C1107u MEDIA_TYPE;
    private static final Charset UTF_8;
    private final C3676t<T> adapter;
    private final Gson gson;

    static {
        MEDIA_TYPE = C1107u.m4632a("application/json; charset=UTF-8");
        UTF_8 = Charset.forName(HttpRequest.CHARSET);
    }

    GsonRequestBodyConverter(Gson gson, C3676t<T> c3676t) {
        this.gson = gson;
        this.adapter = c3676t;
    }

    public aa convert(T t) {
        C1129c c1129c = new C1129c();
        C3704c a = this.gson.m18168a(new OutputStreamWriter(c1129c.m4792c(), UTF_8));
        this.adapter.m18135a(a, t);
        a.close();
        return aa.create(MEDIA_TYPE, c1129c.m4817n());
    }
}
