package p018c;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;

/* renamed from: c.f */
public class C1130f implements Serializable, Comparable<C1130f> {
    static final char[] f2625a;
    public static final C1130f f2626b;
    final byte[] f2627c;
    transient int f2628d;
    transient String f2629e;

    public /* synthetic */ int compareTo(Object obj) {
        return m4830a((C1130f) obj);
    }

    static {
        f2625a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f2626b = C1130f.m4828a(new byte[0]);
    }

    C1130f(byte[] bArr) {
        this.f2627c = bArr;
    }

    public static C1130f m4828a(byte... bArr) {
        if (bArr != null) {
            return new C1130f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static C1130f m4827a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        C1130f c1130f = new C1130f(str.getBytes(C1147u.f2668a));
        c1130f.f2629e = str;
        return c1130f;
    }

    public String m4832a() {
        String str = this.f2629e;
        if (str != null) {
            return str;
        }
        str = new String(this.f2627c, C1147u.f2668a);
        this.f2629e = str;
        return str;
    }

    public String m4836b() {
        return C1124b.m4732a(this.f2627c);
    }

    public String m4837c() {
        int i = 0;
        char[] cArr = new char[(this.f2627c.length * 2)];
        byte[] bArr = this.f2627c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = f2625a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = f2625a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public static C1130f m4826a(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new C1130f(bArr);
        }
    }

    public C1130f m4838d() {
        int i = 0;
        while (i < this.f2627c.length) {
            byte b = this.f2627c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f2627c.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b + 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i] = (byte) (b2 + 32);
                    }
                }
                return new C1130f(bArr);
            }
        }
        return this;
    }

    public C1130f m4831a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.f2627c.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f2627c.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f2627c.length) {
                return this;
            } else {
                Object obj = new byte[i3];
                System.arraycopy(this.f2627c, i, obj, 0, i3);
                this(obj);
                return this;
            }
        }
    }

    public byte m4829a(int i) {
        return this.f2627c[i];
    }

    public int m4839e() {
        return this.f2627c.length;
    }

    public byte[] m4840f() {
        return (byte[]) this.f2627c.clone();
    }

    void m4833a(C1129c c1129c) {
        c1129c.m4785b(this.f2627c, 0, this.f2627c.length);
    }

    public boolean m4834a(int i, C1130f c1130f, int i2, int i3) {
        return c1130f.m4835a(i2, this.f2627c, i, i3);
    }

    public boolean m4835a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f2627c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C1147u.m4931a(this.f2627c, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z;
        if ((obj instanceof C1130f) && ((C1130f) obj).m4839e() == this.f2627c.length && ((C1130f) obj).m4835a(0, this.f2627c, 0, this.f2627c.length)) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.f2628d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.f2627c);
        this.f2628d = i;
        return i;
    }

    public int m4830a(C1130f c1130f) {
        int e = m4839e();
        int e2 = c1130f.m4839e();
        int min = Math.min(e, e2);
        int i = 0;
        while (i < min) {
            int a = m4829a(i) & 255;
            int a2 = c1130f.m4829a(i) & 255;
            if (a == a2) {
                i++;
            } else if (a < a2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (e == e2) {
            return 0;
        }
        if (e >= e2) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        if (this.f2627c.length == 0) {
            return "[size=0]";
        }
        String a = m4832a();
        int a2 = C1130f.m4825a(a, 64);
        if (a2 != -1) {
            String replace = a.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            return a2 < a.length() ? "[size=" + this.f2627c.length + " text=" + replace + "\u2026]" : "[text=" + replace + "]";
        } else if (this.f2627c.length <= 64) {
            return "[hex=" + m4837c() + "]";
        } else {
            return "[size=" + this.f2627c.length + " hex=" + m4831a(0, 64).m4837c() + "\u2026]";
        }
    }

    static int m4825a(String str, int i) {
        int i2 = 0;
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        C1130f a = C1130f.m4826a((InputStream) objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = C1130f.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a.f2627c);
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f2627c.length);
        objectOutputStream.write(this.f2627c);
    }
}
