package retrofit2;

import p015b.C1098p.C1097a;
import p015b.C1102r;
import p015b.C1106s;
import p015b.C1106s.C1105a;
import p015b.C1107u;
import p015b.C1110v;
import p015b.C1110v.C1108a;
import p015b.C1110v.C1109b;
import p015b.C1120z;
import p015b.C1120z.C1119a;
import p015b.aa;
import p018c.C1127d;
import p018c.C1129c;

final class RequestBuilder {
    private static final char[] HEX_DIGITS;
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final C1106s baseUrl;
    private aa body;
    private C1107u contentType;
    private C1097a formBuilder;
    private final boolean hasBody;
    private final String method;
    private C1108a multipartBuilder;
    private String relativeUrl;
    private final C1119a requestBuilder;
    private C1105a urlBuilder;

    private static class ContentTypeOverridingRequestBody extends aa {
        private final C1107u contentType;
        private final aa delegate;

        ContentTypeOverridingRequestBody(aa aaVar, C1107u c1107u) {
            this.delegate = aaVar;
            this.contentType = c1107u;
        }

        public C1107u contentType() {
            return this.contentType;
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public void writeTo(C1127d c1127d) {
            this.delegate.writeTo(c1127d);
        }
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    RequestBuilder(String str, C1106s c1106s, String str2, C1102r c1102r, C1107u c1107u, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = c1106s;
        this.relativeUrl = str2;
        this.requestBuilder = new C1119a();
        this.contentType = c1107u;
        this.hasBody = z;
        if (c1102r != null) {
            this.requestBuilder.m4707a(c1102r);
        }
        if (z2) {
            this.formBuilder = new C1097a();
        } else if (z3) {
            this.multipartBuilder = new C1108a();
            this.multipartBuilder.m4637a(C1110v.f2530e);
        }
    }

    void setRelativeUrl(Object obj) {
        if (obj == null) {
            throw new NullPointerException("@Url parameter is null.");
        }
        this.relativeUrl = obj.toString();
    }

    void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            C1107u a = C1107u.m4632a(str2);
            if (a == null) {
                throw new IllegalArgumentException("Malformed content type: " + str2);
            }
            this.contentType = a;
            return;
        }
        this.requestBuilder.m4715b(str, str2);
    }

    void addPathParam(String str, String str2, boolean z) {
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        this.relativeUrl = this.relativeUrl.replace("{" + str + "}", canonicalizeForPath(str2, z));
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                C1129c c1129c = new C1129c();
                c1129c.m4774a(str, 0, i);
                canonicalizeForPath(c1129c, str, i, length, z);
                return c1129c.m4818o();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void canonicalizeForPath(C1129c c1129c, String str, int i, int i2, boolean z) {
        C1129c c1129c2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!(z && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13))) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (c1129c2 == null) {
                        c1129c2 = new C1129c();
                    }
                    c1129c2.m4770a(codePointAt);
                    while (!c1129c2.m4798e()) {
                        int h = c1129c2.m4805h() & 255;
                        c1129c.m4783b(37);
                        c1129c.m4783b(HEX_DIGITS[(h >> 4) & 15]);
                        c1129c.m4783b(HEX_DIGITS[h & 15]);
                    }
                } else {
                    c1129c.m4770a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    void addQueryParam(String str, String str2, boolean z) {
        if (this.relativeUrl != null) {
            this.urlBuilder = this.baseUrl.m4620d(this.relativeUrl);
            if (this.urlBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z) {
            this.urlBuilder.m4596b(str, str2);
        } else {
            this.urlBuilder.m4593a(str, str2);
        }
    }

    void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.m4552b(str, str2);
        } else {
            this.formBuilder.m4550a(str, str2);
        }
    }

    void addPart(C1102r c1102r, aa aaVar) {
        this.multipartBuilder.m4636a(c1102r, aaVar);
    }

    void addPart(C1109b c1109b) {
        this.multipartBuilder.m4638a(c1109b);
    }

    void setBody(aa aaVar) {
        this.body = aaVar;
    }

    C1120z build() {
        C1106s c;
        C1105a c1105a = this.urlBuilder;
        if (c1105a != null) {
            c = c1105a.m4598c();
        } else {
            c = this.baseUrl.m4618c(this.relativeUrl);
            if (c == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        aa aaVar = this.body;
        if (aaVar == null) {
            if (this.formBuilder != null) {
                aaVar = this.formBuilder.m4551a();
            } else if (this.multipartBuilder != null) {
                aaVar = this.multipartBuilder.m4639a();
            } else if (this.hasBody) {
                aaVar = aa.create(null, new byte[0]);
            }
        }
        C1107u c1107u = this.contentType;
        if (c1107u != null) {
            if (aaVar != null) {
                aaVar = new ContentTypeOverridingRequestBody(aaVar, c1107u);
            } else {
                this.requestBuilder.m4715b("Content-Type", c1107u.toString());
            }
        }
        return this.requestBuilder.m4708a(c).m4710a(this.method, aaVar).m4717c();
    }
}
