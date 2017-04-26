package p015b;

import java.util.ArrayList;
import java.util.List;
import p015b.p016a.C1022c;
import p018c.C1127d;
import p018c.C1129c;

/* renamed from: b.p */
public final class C1098p extends aa {
    private static final C1107u f2481a;
    private final List<String> f2482b;
    private final List<String> f2483c;

    /* renamed from: b.p.a */
    public static final class C1097a {
        private final List<String> f2479a;
        private final List<String> f2480b;

        public C1097a() {
            this.f2479a = new ArrayList();
            this.f2480b = new ArrayList();
        }

        public C1097a m4550a(String str, String str2) {
            this.f2479a.add(C1106s.m4604a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f2480b.add(C1106s.m4604a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public C1097a m4552b(String str, String str2) {
            this.f2479a.add(C1106s.m4604a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f2480b.add(C1106s.m4604a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        public C1098p m4551a() {
            return new C1098p(this.f2480b, null);
        }
    }

    static {
        f2481a = C1107u.m4632a("application/x-www-form-urlencoded");
    }

    private C1098p(List<String> list, List<String> list2) {
        this.f2482b = C1022c.m4228a((List) list);
        this.f2483c = C1022c.m4228a((List) list2);
    }

    public C1107u contentType() {
        return f2481a;
    }

    public long contentLength() {
        return m4553a(null, true);
    }

    public void writeTo(C1127d c1127d) {
        m4553a(c1127d, false);
    }

    private long m4553a(C1127d c1127d, boolean z) {
        C1129c c1129c;
        long j = 0;
        if (z) {
            c1129c = new C1129c();
        } else {
            c1129c = c1127d.m4735b();
        }
        int size = this.f2482b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                c1129c.m4783b(38);
            }
            c1129c.m4773a((String) this.f2482b.get(i));
            c1129c.m4783b(61);
            c1129c.m4773a((String) this.f2483c.get(i));
        }
        if (z) {
            j = c1129c.m4765a();
            c1129c.m4821r();
        }
        return j;
    }
}
