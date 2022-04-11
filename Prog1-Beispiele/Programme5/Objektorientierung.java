// Objektorientierung.java
/**
 * Zusammenfassung Objektorientierung.
 * Beispielprogramm zur Programmiertechnik 1, Teil 5.
 * @author H.Drachenfels
 * @version 9.1.2017
 */
public final class Objektorientierung {
    private Objektorientierung() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet
     */
    public static void main(final String[] args) {
        A.f();  // ok, kein Parameter this bei static-Methoden
      //A.g();  // Fehler, Parameter this kann nicht initialisiert werden
      //A.h();  // Fehler, Parameter this kann nicht initialisiert werden
      //A.i();  // Fehler wegen private und this
        System.out.println();

        A a = new A();  // statische Bindung: A.A(a)
        a.f();  // statische Bindung: A.f(), kein Parameter this
        a.g();  // dynamische Bindung: A.g(a)
        a.h();  // dynamische Bindung: A.h(a)
      //a.i();  // Fehler wegen private
        System.out.println();

        a = new B(); // statische Bindung: A.A(a) B.B(a), a polymorph
        a.f();  // statische Bindung: A.f(), kein Parameter this
        a.g();  // dynamische Bindung: A.g(a)
        a.h();  // dynamische Bindung: B.h(a)
      //a.i();  // Fehler wegen private
        System.out.println();

        B b = new B();  // statische Bindung: A.A(b) B.B(b)
        b.f();  // statische Bindung: B.f(), kein Parameter this
        b.g();  // dynamische Bindung: A.g(b)
        b.h();  // dynamische Bindung: B.h(b)
        b.i();  // dynamische Bindung: B.i(b)
        System.out.println();
    }
}

// Oberklasse A
class A {
    public A() {
        System.out.printf("A.A(%s)%n", this);
    }

    public static void f() {
        System.out.printf("A.f()%n");
    }

    public final void g() {
        System.out.printf("A.g(%s)%n", this);
    }

    public void h() {
        System.out.printf("A.h(%s)%n", this);
        this.i(); // statische Bindung: A.i(this)
    }

    private void i() {
        System.out.printf("A.i(%s)%n", this);
    }
}

// Unterklasse B von A
class B extends A {
    public B() {
        System.out.printf("B.B(%s)%n", this);
    }

    public static void f() {
        System.out.printf("B.f()%n");
    }

  //public void g() { } // Fehler wegen final in Oberklasse

    public void h() {
        System.out.printf("B.h(%s)%n", this);
        this.i();  // dynamische Bindung: B.i(this)
        super.h(); // statische Bindung: A.h(this)
    }

    public void i() {
        System.out.printf("B.i(%s)%n", this);
    }
}

