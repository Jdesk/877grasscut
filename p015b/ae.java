package p015b;

import net.cachapa.expandablelayout.C5541a.C5538a;

/* renamed from: b.ae */
public enum ae {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    final String f2351e;

    private ae(String str) {
        this.f2351e = str;
    }

    public static ae m4464a(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    obj = 1;
                    break;
                }
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    obj = null;
                    break;
                }
                break;
            case 79201641:
                if (str.equals("SSLv3")) {
                    obj = 3;
                    break;
                }
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case C5538a.ExpandableLayout_android_orientation /*0*/:
                return TLS_1_2;
            case C5538a.ExpandableLayout_el_duration /*1*/:
                return TLS_1_1;
            case C5538a.ExpandableLayout_el_expanded /*2*/:
                return TLS_1_0;
            case C5538a.ExpandableLayout_layout_expandable /*3*/:
                return SSL_3_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }
}
