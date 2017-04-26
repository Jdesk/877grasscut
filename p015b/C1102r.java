package p015b;

import io.card.payment.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import p015b.p016a.C1022c;
import p015b.p016a.p021d.C1037e;

/* renamed from: b.r */
public final class C1102r {
    private final String[] f2489a;

    /* renamed from: b.r.a */
    public static final class C1101a {
        private final List<String> f2488a;

        public C1101a() {
            this.f2488a = new ArrayList(20);
        }

        C1101a m4559a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return m4563b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return m4563b(BuildConfig.FLAVOR, str.substring(1));
            }
            return m4563b(BuildConfig.FLAVOR, str);
        }

        public C1101a m4560a(String str, String str2) {
            m4558d(str, str2);
            return m4563b(str, str2);
        }

        C1101a m4563b(String str, String str2) {
            this.f2488a.add(str);
            this.f2488a.add(str2.trim());
            return this;
        }

        public C1101a m4562b(String str) {
            int i = 0;
            while (i < this.f2488a.size()) {
                if (str.equalsIgnoreCase((String) this.f2488a.get(i))) {
                    this.f2488a.remove(i);
                    this.f2488a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public C1101a m4564c(String str, String str2) {
            m4558d(str, str2);
            m4562b(str);
            m4563b(str, str2);
            return this;
        }

        private void m4558d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int i;
                char charAt;
                int length = str.length();
                for (i = 0; i < length; i++) {
                    charAt = str.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '\u007f') {
                        throw new IllegalArgumentException(C1022c.m4227a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                length = str2.length();
                for (i = 0; i < length; i++) {
                    charAt = str2.charAt(i);
                    if (charAt <= '\u001f' || charAt >= '\u007f') {
                        throw new IllegalArgumentException(C1022c.m4227a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str, str2));
                    }
                }
            }
        }

        public C1102r m4561a() {
            return new C1102r();
        }
    }

    private C1102r(C1101a c1101a) {
        this.f2489a = (String[]) c1101a.f2488a.toArray(new String[c1101a.f2488a.size()]);
    }

    private C1102r(String[] strArr) {
        this.f2489a = strArr;
    }

    public String m4569a(String str) {
        return C1102r.m4566a(this.f2489a, str);
    }

    public Date m4571b(String str) {
        String a = m4569a(str);
        return a != null ? C1037e.m4295a(a) : null;
    }

    public int m4567a() {
        return this.f2489a.length / 2;
    }

    public String m4568a(int i) {
        return this.f2489a[i * 2];
    }

    public String m4570b(int i) {
        return this.f2489a[(i * 2) + 1];
    }

    public Set<String> m4572b() {
        Set treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int a = m4567a();
        for (int i = 0; i < a; i++) {
            treeSet.add(m4568a(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public List<String> m4574c(String str) {
        int a = m4567a();
        List list = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(m4568a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(m4570b(i));
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public C1101a m4573c() {
        C1101a c1101a = new C1101a();
        Collections.addAll(c1101a.f2488a, this.f2489a);
        return c1101a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1102r) && Arrays.equals(((C1102r) obj).f2489a, this.f2489a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f2489a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int a = m4567a();
        for (int i = 0; i < a; i++) {
            stringBuilder.append(m4568a(i)).append(": ").append(m4570b(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    public Map<String, List<String>> m4575d() {
        Map<String, List<String>> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int a = m4567a();
        for (int i = 0; i < a; i++) {
            String toLowerCase = m4568a(i).toLowerCase(Locale.US);
            List list = (List) treeMap.get(toLowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(toLowerCase, list);
            }
            list.add(m4570b(i));
        }
        return treeMap;
    }

    private static String m4566a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static C1102r m4565a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        } else {
            int i;
            String[] strArr2 = (String[]) strArr.clone();
            for (i = 0; i < strArr2.length; i++) {
                if (strArr2[i] == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i] = strArr2[i].trim();
            }
            i = 0;
            while (i < strArr2.length) {
                String str = strArr2[i];
                String str2 = strArr2[i + 1];
                if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                    i += 2;
                } else {
                    throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
                }
            }
            return new C1102r(strArr2);
        }
    }
}
