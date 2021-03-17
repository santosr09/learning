defmodule ApplicationTweet.Scheduler do
    use QuantumScheduler,
    otp_app: :application_tweet
end