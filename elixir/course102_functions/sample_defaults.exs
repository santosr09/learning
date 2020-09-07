defmodule Sample.DefaultParams do

#DEFAULT_PARAMETERS
#We can specify default values for parameters, if user don't provide a value for that parameter, default value will be used

    def add(list, val \\ 0) do
        trace(list)
        [val | list]
    end

#PRIVATE FUNCTION
defp trace(value) do
    IO.puts("The value passed in was #{value}")
end

#Multiple clauses with deafult values should define a function head with the deafult values:

    #This is the head function defining the default value for first/2 function
    def first(list, val \\ nil)  

    def first([head | _], _), do: head
    def first([], val), do: val
end