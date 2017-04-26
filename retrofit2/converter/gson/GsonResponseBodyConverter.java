package retrofit2.converter.gson;

import com.google.gson.C3676t;
import com.google.gson.Gson;
import p015b.ac;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<ac, T> {
    private final C3676t<T> adapter;
    private final Gson gson;

    GsonResponseBodyConverter(Gson gson, C3676t<T> c3676t) {
        this.gson = gson;
        this.adapter = c3676t;
    }

    public T convert(ac acVar) {
        try {
            T b = this.adapter.m18136b(this.gson.m18167a(acVar.charStream()));
            return b;
        } finally {
            acVar.close();
        }
    }
}
