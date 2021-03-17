use Mix.Config

config :spotify_ex, user_id: "12155624579",
                    scopes: "user-read-private user-read-email",
                    callback_url: "http://localhost:8888/callback"