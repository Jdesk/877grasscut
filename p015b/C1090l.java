package p015b;

import io.card.payment.BuildConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p015b.p016a.C1022c;
import p015b.p016a.p021d.C1037e;

/* renamed from: b.l */
public final class C1090l {
    private static final Pattern f2457a;
    private static final Pattern f2458b;
    private static final Pattern f2459c;
    private static final Pattern f2460d;
    private final String f2461e;
    private final String f2462f;
    private final long f2463g;
    private final String f2464h;
    private final String f2465i;
    private final boolean f2466j;
    private final boolean f2467k;
    private final boolean f2468l;
    private final boolean f2469m;

    static {
        f2457a = Pattern.compile("(\\d{2,4})[^\\d]*");
        f2458b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f2459c = Pattern.compile("(\\d{1,2})[^\\d]*");
        f2460d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private C1090l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f2461e = str;
        this.f2462f = str2;
        this.f2463g = j;
        this.f2464h = str3;
        this.f2465i = str4;
        this.f2466j = z;
        this.f2467k = z2;
        this.f2469m = z3;
        this.f2468l = z4;
    }

    public String m4532a() {
        return this.f2461e;
    }

    public String m4533b() {
        return this.f2462f;
    }

    private static boolean m4531b(C1106s c1106s, String str) {
        String f = c1106s.m4623f();
        if (f.equals(str)) {
            return true;
        }
        if (f.endsWith(str) && f.charAt((f.length() - str.length()) - 1) == '.' && !C1022c.m4244b(f)) {
            return true;
        }
        return false;
    }

    public static C1090l m4528a(C1106s c1106s, String str) {
        return C1090l.m4527a(System.currentTimeMillis(), c1106s, str);
    }

    static C1090l m4527a(long j, C1106s c1106s, String str) {
        int length = str.length();
        int a = C1022c.m4221a(str, 0, length, ';');
        int a2 = C1022c.m4221a(str, 0, a, '=');
        if (a2 == a) {
            return null;
        }
        String c = C1022c.m4245c(str, 0, a2);
        if (c.isEmpty()) {
            return null;
        }
        String substring;
        String c2 = C1022c.m4245c(str, a2 + 1, a);
        long j2 = 253402300799999L;
        long j3 = -1;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        a++;
        while (a < length) {
            long j4;
            int a3 = C1022c.m4221a(str, a, length, ';');
            int a4 = C1022c.m4221a(str, a, a3, '=');
            String c3 = C1022c.m4245c(str, a, a4);
            String c4 = a4 < a3 ? C1022c.m4245c(str, a4 + 1, a3) : BuildConfig.FLAVOR;
            if (c3.equalsIgnoreCase("expires")) {
                try {
                    j2 = C1090l.m4526a(c4, 0, c4.length());
                    z4 = true;
                    c4 = str2;
                    j4 = j2;
                } catch (IllegalArgumentException e) {
                    c4 = str2;
                    j4 = j2;
                }
            } else {
                if (c3.equalsIgnoreCase("max-age")) {
                    try {
                        j3 = C1090l.m4525a(c4);
                        z4 = true;
                        c4 = str2;
                        j4 = j2;
                    } catch (NumberFormatException e2) {
                        c4 = str2;
                        j4 = j2;
                    }
                } else {
                    if (c3.equalsIgnoreCase("domain")) {
                        try {
                            c4 = C1090l.m4530b(c4);
                            z3 = false;
                            j4 = j2;
                        } catch (IllegalArgumentException e3) {
                            c4 = str2;
                            j4 = j2;
                        }
                    } else {
                        if (c3.equalsIgnoreCase("path")) {
                            str3 = c4;
                            c4 = str2;
                            j4 = j2;
                        } else {
                            if (c3.equalsIgnoreCase("secure")) {
                                z = true;
                                c4 = str2;
                                j4 = j2;
                            } else {
                                if (c3.equalsIgnoreCase("httponly")) {
                                    z2 = true;
                                    c4 = str2;
                                    j4 = j2;
                                } else {
                                    c4 = str2;
                                    j4 = j2;
                                }
                            }
                        }
                    }
                }
            }
            String str4 = c4;
            a = a3 + 1;
            j2 = j4;
            str2 = str4;
        }
        if (j3 == Long.MIN_VALUE) {
            j3 = Long.MIN_VALUE;
        } else if (j3 != -1) {
            j3 = (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE) + j;
            if (j3 < j || j3 > 253402300799999L) {
                j3 = 253402300799999L;
            }
        } else {
            j3 = j2;
        }
        if (str2 == null) {
            str2 = c1106s.m4623f();
        } else if (!C1090l.m4531b(c1106s, str2)) {
            return null;
        }
        if (str3 == null || !str3.startsWith("/")) {
            str3 = c1106s.m4625h();
            a = str3.lastIndexOf(47);
            substring = a != 0 ? str3.substring(0, a) : "/";
        } else {
            substring = str3;
        }
        return new C1090l(c, c2, j3, str2, substring, z, z2, z3, z4);
    }

    private static long m4526a(String str, int i, int i2) {
        int a = C1090l.m4524a(str, i, i2, false);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        Matcher matcher = f2460d.matcher(str);
        while (a < i2) {
            int a2 = C1090l.m4524a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i3 == -1 && matcher.usePattern(f2460d).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i4 = Integer.parseInt(matcher.group(2));
                i5 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(f2459c).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(f2458b).matches()) {
                i7 = f2458b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i8 == -1 && matcher.usePattern(f2457a).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            }
            a = C1090l.m4524a(str, a2 + 1, i2, false);
        }
        if (i8 >= 70 && i8 <= 99) {
            i8 += 1900;
        }
        if (i8 >= 0 && i8 <= 69) {
            i8 += 2000;
        }
        if (i8 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 59) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException();
        } else {
            Calendar gregorianCalendar = new GregorianCalendar(C1022c.f2198d);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i8);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i4);
            gregorianCalendar.set(13, i5);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static int m4524a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            Object obj;
            char charAt = str.charAt(i3);
            Object obj2 = ((charAt >= ' ' || charAt == '\t') && charAt < '\u007f' && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) ? null : 1;
            if (z) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj2 == obj) {
                return i3;
            }
        }
        return i2;
    }

    private static long m4525a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    private static String m4530b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String a = C1022c.m4226a(str);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException();
    }

    public static List<C1090l> m4529a(C1106s c1106s, C1102r c1102r) {
        List c = c1102r.m4574c("Set-Cookie");
        List list = null;
        int size = c.size();
        for (int i = 0; i < size; i++) {
            C1090l a = C1090l.m4528a(c1106s, (String) c.get(i));
            if (a != null) {
                List arrayList;
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = list;
                }
                arrayList.add(a);
                list = arrayList;
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f2461e);
        stringBuilder.append('=');
        stringBuilder.append(this.f2462f);
        if (this.f2468l) {
            if (this.f2463g == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(C1037e.m4294a(new Date(this.f2463g)));
            }
        }
        if (!this.f2469m) {
            stringBuilder.append("; domain=").append(this.f2464h);
        }
        stringBuilder.append("; path=").append(this.f2465i);
        if (this.f2466j) {
            stringBuilder.append("; secure");
        }
        if (this.f2467k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1090l)) {
            return false;
        }
        C1090l c1090l = (C1090l) obj;
        if (c1090l.f2461e.equals(this.f2461e) && c1090l.f2462f.equals(this.f2462f) && c1090l.f2464h.equals(this.f2464h) && c1090l.f2465i.equals(this.f2465i) && c1090l.f2463g == this.f2463g && c1090l.f2466j == this.f2466j && c1090l.f2467k == this.f2467k && c1090l.f2468l == this.f2468l && c1090l.f2469m == this.f2469m) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = (((((((((this.f2461e.hashCode() + 527) * 31) + this.f2462f.hashCode()) * 31) + this.f2464h.hashCode()) * 31) + this.f2465i.hashCode()) * 31) + ((int) (this.f2463g ^ (this.f2463g >>> 32)))) * 31;
        if (this.f2466j) {
            i = 0;
        } else {
            i = 1;
        }
        hashCode = (i + hashCode) * 31;
        if (this.f2467k) {
            i = 0;
        } else {
            i = 1;
        }
        hashCode = (i + hashCode) * 31;
        if (this.f2468l) {
            i = 0;
        } else {
            i = 1;
        }
        i = (i + hashCode) * 31;
        if (!this.f2469m) {
            i2 = 1;
        }
        return i + i2;
    }
}
