defmodule Sample.Enum do
    def first(list) do
        if(length(list) == 0) do
            nil
        else
            hd[list]
        end
    end
end