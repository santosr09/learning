defmodule ApplicationTweetTest do
  use ExUnit.Case
  doctest ApplicationTweet

  test "greets the world" do
    assert ApplicationTweet.hello() == :world
  end
end
