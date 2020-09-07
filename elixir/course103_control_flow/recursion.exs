defmodule Sample.Enum do

    #Function that receives an empty list, this will end up the recursion
    def map([], _), do: []
    
    #This method receives a list and a function
    #Example to invoke this function: Sample.Enum.map([2,6,4,7,9], &(&1 * 2))
    def map([hd | tl], f) do

        #A new list is created using the three parameters received
        #The first element of the list is the result of pasing the first element to the function
        #The remain part of the list is created making a recursive call to this function.
        #When the remain list is empty, it will reach the function that receives an empty list, and the recursion will over
        [f.(hd) | map(tl, f)]
    end
    
    #BODY RECURSION: The last operation is the '+'
    def length([]), do: 0

    #In this function elixir perform 2 operations, find the length and '+'
    def length([_ | tail]),
        do: 1 + length(tail)
    
    #TAIL RECURSION: the last operation a function performs is recursion.
    def other_length([_ | tail]),
        do: other_length(tail, 1)
    
    def other_length([], len),
        do: len

    def other_length([_ | tail], len),
        do: other_length(tail, len + 1)

end