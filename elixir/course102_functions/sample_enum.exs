defmodule Sample.Enum do
    #Matching when list is empty
    #def first([]) do
    #    nil
    #end
    
    #1
    #Matching when list has elements
    #def first(list) do
    #    hd(list)
    #end

    #2
    #WARNING: variable tail unused
    #def first([head | tail]) do
    #3
    #def first([head | _]) do
    #    head
    #end

    #Shortcut when a function is simple:
    def first([]), do: nil
    def first([head | _]), do: head

    #4
    #Example of pattern matching
   def some_func(quantity, {_, _, price}) do
      quantity * price
   end

   #Less legible
   def some_func(quantity, book) do
      quantity * elem(book, 2)
   end

end