package retrofit2;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import p015b.C1102r;
import p015b.C1114x;
import p015b.C1120z.C1119a;
import p015b.ab;
import p015b.ab.C1069a;
import p015b.ac;

public final class Response<T> {
    private final T body;
    private final ac errorBody;
    private final ab rawResponse;

    public static <T> Response<T> success(T t) {
        return success((Object) t, new C1069a().m4420a((int) Callback.DEFAULT_DRAG_ANIMATION_DURATION).m4428a("OK").m4426a(C1114x.HTTP_1_1).m4427a(new C1119a().m4709a("http://localhost/").m4717c()).m4430a());
    }

    public static <T> Response<T> success(T t, C1102r c1102r) {
        if (c1102r != null) {
            return success((Object) t, new C1069a().m4420a((int) Callback.DEFAULT_DRAG_ANIMATION_DURATION).m4428a("OK").m4426a(C1114x.HTTP_1_1).m4425a(c1102r).m4427a(new C1119a().m4709a("http://localhost/").m4717c()).m4430a());
        }
        throw new NullPointerException("headers == null");
    }

    public static <T> Response<T> success(T t, ab abVar) {
        if (abVar == null) {
            throw new NullPointerException("rawResponse == null");
        } else if (abVar.m4451c()) {
            return new Response(abVar, t, null);
        } else {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
    }

    public static <T> Response<T> error(int i, ac acVar) {
        if (i >= 400) {
            return error(acVar, new C1069a().m4420a(i).m4426a(C1114x.HTTP_1_1).m4427a(new C1119a().m4709a("http://localhost/").m4717c()).m4430a());
        }
        throw new IllegalArgumentException("code < 400: " + i);
    }

    public static <T> Response<T> error(ac acVar, ab abVar) {
        if (acVar == null) {
            throw new NullPointerException("body == null");
        } else if (abVar == null) {
            throw new NullPointerException("rawResponse == null");
        } else if (!abVar.m4451c()) {
            return new Response(abVar, null, acVar);
        } else {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
    }

    private Response(ab abVar, T t, ac acVar) {
        this.rawResponse = abVar;
        this.body = t;
        this.errorBody = acVar;
    }

    public ab raw() {
        return this.rawResponse;
    }

    public int code() {
        return this.rawResponse.m4450b();
    }

    public String message() {
        return this.rawResponse.m4452d();
    }

    public C1102r headers() {
        return this.rawResponse.m4454f();
    }

    public boolean isSuccessful() {
        return this.rawResponse.m4451c();
    }

    public T body() {
        return this.body;
    }

    public ac errorBody() {
        return this.errorBody;
    }
}
