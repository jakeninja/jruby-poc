#!/usr/bin/env jruby
require 'java'
java_package 'app.jrubypoc.jruby'

class SimpleClass
  def do_stuff(name)
    "#{name} does good stuff"
  end
end

