defmodule ApplicationTweet.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  use Application

  def start(_type, _args) do
    children = [
      # Starts a worker by calling: ApplicationTweet.Worker.start_link(arg)
      # {ApplicationTweet.Worker, arg}
      ApplicationTweet.Scheduler
    ]

    # See https://hexdocs.pm/elixir/Supervisor.html
    # for other strategies and supported options
    opts = [strategy: :one_for_one, name: ApplicationTweet.Supervisor]
    Supervisor.start_link(children, opts)
  end
end
