package p015b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: b.o */
public interface C1094o {
    public static final C1094o f2478a;

    /* renamed from: b.o.1 */
    static class C10951 implements C1094o {
        C10951() {
        }

        public List<InetAddress> m4549a(String str) {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    List<InetAddress> m4548a(String str);

    static {
        f2478a = new C10951();
    }
}
