package p015b;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: b.u */
public final class C1107u {
    private static final Pattern f2515a;
    private static final Pattern f2516b;
    private final String f2517c;
    private final String f2518d;
    private final String f2519e;
    private final String f2520f;

    static {
        f2515a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f2516b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private C1107u(String str, String str2, String str3, String str4) {
        this.f2517c = str;
        this.f2518d = str2;
        this.f2519e = str3;
        this.f2520f = str4;
    }

    public static C1107u m4632a(String str) {
        Matcher matcher = f2515a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f2516b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                if (matcher2.group(2) != null) {
                    group = matcher2.group(2);
                } else {
                    group = matcher2.group(3);
                }
                if (str2 == null || group.equalsIgnoreCase(str2)) {
                    str2 = group;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new C1107u(str, toLowerCase, toLowerCase2, str2);
    }

    public String m4633a() {
        return this.f2518d;
    }

    public Charset m4635b() {
        return this.f2520f != null ? Charset.forName(this.f2520f) : null;
    }

    public Charset m4634a(Charset charset) {
        return this.f2520f != null ? Charset.forName(this.f2520f) : charset;
    }

    public String toString() {
        return this.f2517c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1107u) && ((C1107u) obj).f2517c.equals(this.f2517c);
    }

    public int hashCode() {
        return this.f2517c.hashCode();
    }
}
