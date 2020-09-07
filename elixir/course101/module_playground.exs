defmodule ModulePlayground do
   #2
   #import IO
   import IO, only: [puts: 1]
   import Kernel, except: [inspect: 1]

   #Alias
   #alias ModulePlayground.Misc.Util.Math

   #Alias with custom alias
   alias ModulePlayground.Misc.Util.Math, as: MyMath

   require Integer

   def say_here do
      #1
      #IO.puts "I'm Here"
      
      #2
      #puts "I'm Here with import"

      #3
      inspect "I'm Here, inspect function"
   end

   def inspect(param1) do
       puts "Starting Output"
       puts param1
       puts "Ending output"
   end

   def print_sum do
       #ModulePlayground.Misc.Util.Math.add(2,6)
       
       #Alias
       #Math.add(8,6)

       #Custom Alias
       MyMath.add(3,7)
   end

   def print_is_even(num) do
      puts "Is #{num} even? #{Integer.is_even(num)}"
   end

end