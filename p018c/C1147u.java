package p018c;

import java.nio.charset.Charset;

/* renamed from: c.u */
final class C1147u {
    public static final Charset f2668a;

    static {
        f2668a = Charset.forName(HttpRequest.CHARSET);
    }

    public static void m4929a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    public static short m4928a(short s) {
        int i = 65535 & s;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    public static int m4927a(int i) {
        return ((((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8)) | ((65280 & i) << 8)) | ((i & 255) << 24);
    }

    public static void m4930a(Throwable th) {
        C1147u.m4932b(th);
    }

    private static <T extends Throwable> void m4932b(Throwable th) {
        throw th;
    }

    public static boolean m4931a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
