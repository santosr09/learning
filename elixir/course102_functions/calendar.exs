defmodule Sample.Calendar do

#GUARD CLASS
#It's a kind of pre-condition's validation
   def is_leap_year(year) when rem(year, 400) == 0, do: true
   def is_leap_year(year) when rem(year, 100) == 0, do: true
   def is_leap_year(year) when rem(year, 4) == 0, do: true
   def is_leap_year(year), do: false

end