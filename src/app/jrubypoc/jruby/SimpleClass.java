package app.jrubypoc.jruby;

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.runtime.Helpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;


public class SimpleClass extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("#!/usr/bin/env jruby\n" +
            "require 'java'\n" +
            "java_package 'app.jrubypoc.jruby'\n" +
            "\n" +
            "class SimpleClass\n" +
            "  def do_stuff(name)\n" +
            "    \"#{name} does good stuff\"\n" +
            "  end\n" +
            "end\n" +
            "\n" +
            "").toString();
        __ruby__.executeScript(source, "simple_class.rb");
        RubyClass metaclass = __ruby__.getClass("SimpleClass");
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: SimpleClass");
        metaclass.setRubyStaticAllocator(SimpleClass.class);
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private SimpleClass(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaClass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new SimpleClass(ruby, metaClass);
    }

    /**
     * Default constructor. Invokes this(Ruby, RubyClass) with the classloader-static
     * Ruby and RubyClass instances assocated with this class, and then invokes the
     * no-argument 'initialize' method in Ruby.
     */
    public SimpleClass() {
        this(__ruby__, __metaclass__);
        Helpers.invoke(__ruby__.getCurrentContext(), this, "initialize");
    }


    
    public Object do_stuff(Object name) {
        IRubyObject ruby_arg_name = JavaUtil.convertJavaToRuby(__ruby__, name);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "do_stuff", ruby_arg_name);
        return (Object)ruby_result.toJava(Object.class);

    }

}
