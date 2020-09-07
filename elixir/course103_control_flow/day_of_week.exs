defmodule Sample.Calendar do
    def day_abrevation(day) do
        cond do
            day == :Monday -> "M"
            day == :Tuesday -> "Tu"
            day == :Wednesday -> "W"
            day == :Thursday -> "Th"
            day == :Friday -> "F"
            #To avoid error: 'no cond clause evaluated to a true'
            true -> "Invalid day"
        end
    end

    def day_abbreviation_case(day) do
        case day do
            :Monday -> "M"
            :Tuesday -> "Tu"
            :Wednesday -> "W"
            :Thursday -> "Th"
            :Friday -> "Fr"
            _ -> "Invalid Day"
        end
    end

    def describe_date(date) do
    #case using pattern matching: 
        case date do
            {1, _, _} -> "Brand new month!"
            {25, 12, _} -> "Merry Christmas"
            {25, month, _} -> "Only #{12 - month} more"
            {31, 10, 1517} -> "The refomration is starting"
            {31, 10, _} -> "Happy Halloween"
            #Using 'Guard clause' to let the last case be reached
            {_, month, _} when month <= 12 -> "Just an average day"
            {_, _, _} -> "Invalid month"
        end
    end

    def send_tweet(path) do
        case File.read(path) do
            {:ok, data} -> Twwet.send(data)
            {:error, error} -> IO.puts "Could not be loaded"
        end
    end
end