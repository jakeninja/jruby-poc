package app.jrubypoc;
import app.jrubypoc.jruby.SimpleClass;

public class Main {

    public static void main(String[] args) {
        SimpleClass p = new SimpleClass();
        System.out.println(p.do_stuff("Jake"));
    }
}
