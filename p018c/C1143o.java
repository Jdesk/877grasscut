package p018c;

/* renamed from: c.o */
final class C1143o {
    final byte[] f2657a;
    int f2658b;
    int f2659c;
    boolean f2660d;
    boolean f2661e;
    C1143o f2662f;
    C1143o f2663g;

    C1143o() {
        this.f2657a = new byte[8192];
        this.f2661e = true;
        this.f2660d = false;
    }

    C1143o(C1143o c1143o) {
        this(c1143o.f2657a, c1143o.f2658b, c1143o.f2659c);
        c1143o.f2660d = true;
    }

    C1143o(byte[] bArr, int i, int i2) {
        this.f2657a = bArr;
        this.f2658b = i;
        this.f2659c = i2;
        this.f2661e = false;
        this.f2660d = true;
    }

    public C1143o m4904a() {
        C1143o c1143o = this.f2662f != this ? this.f2662f : null;
        this.f2663g.f2662f = this.f2662f;
        this.f2662f.f2663g = this.f2663g;
        this.f2662f = null;
        this.f2663g = null;
        return c1143o;
    }

    public C1143o m4906a(C1143o c1143o) {
        c1143o.f2663g = this;
        c1143o.f2662f = this.f2662f;
        this.f2662f.f2663g = c1143o;
        this.f2662f = c1143o;
        return c1143o;
    }

    public C1143o m4905a(int i) {
        if (i <= 0 || i > this.f2659c - this.f2658b) {
            throw new IllegalArgumentException();
        }
        C1143o c1143o;
        if (i >= 1024) {
            c1143o = new C1143o(this);
        } else {
            c1143o = C1144p.m4909a();
            System.arraycopy(this.f2657a, this.f2658b, c1143o.f2657a, 0, i);
        }
        c1143o.f2659c = c1143o.f2658b + i;
        this.f2658b += i;
        this.f2663g.m4906a(c1143o);
        return c1143o;
    }

    public void m4908b() {
        if (this.f2663g == this) {
            throw new IllegalStateException();
        } else if (this.f2663g.f2661e) {
            int i = this.f2659c - this.f2658b;
            if (i <= (this.f2663g.f2660d ? 0 : this.f2663g.f2658b) + (8192 - this.f2663g.f2659c)) {
                m4907a(this.f2663g, i);
                m4904a();
                C1144p.m4910a(this);
            }
        }
    }

    public void m4907a(C1143o c1143o, int i) {
        if (c1143o.f2661e) {
            if (c1143o.f2659c + i > 8192) {
                if (c1143o.f2660d) {
                    throw new IllegalArgumentException();
                } else if ((c1143o.f2659c + i) - c1143o.f2658b > 8192) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(c1143o.f2657a, c1143o.f2658b, c1143o.f2657a, 0, c1143o.f2659c - c1143o.f2658b);
                    c1143o.f2659c -= c1143o.f2658b;
                    c1143o.f2658b = 0;
                }
            }
            System.arraycopy(this.f2657a, this.f2658b, c1143o.f2657a, c1143o.f2659c, i);
            c1143o.f2659c += i;
            this.f2658b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
