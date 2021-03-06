[discord-invite]: https://discord.gg/invite/eXioStorm#6069
[FAQ]: https://img.shields.io/badge/Wiki-FAQ-blue.svg
[![Discord](https://cdn.discordapp.com/attachments/509290751478464525/574644069607800843/myDiscord.png)][discord-invite]
[![Discord](https://discordapp.com/api/guilds/431382619595210752/widget.png)][discord-invite]

[ ![FAQ] ](https://github.com/eXioStorm/demimorph)
# demimorph
an attempt to create a platformer with extensive modding capabilities.

## workflow progress
* ~~[Audio]() - Positional audio that's easy to use.~~
  * ~~add categories~~
  * ~~add a sound type that can overlap itself~~
* [Rendering]() - what you will see on the screen. (or wont see)
  * ~~render window~~
* [Physics]() - things like collisions...
* [Inputs]() - Handles all user inputs, gaming controller controls, keyboard buttons, mouse buttons, mouse position, basically any device which you would plug in to your computer to interact with the game.
* [TileMap Manager]() - handles retrieving information about the tilemap (game map) note: maps should have their own method which extends this method to add unique information to the map which is specific to the game. such as enemy spawns or BGM.
* [Entity Handler]() - ???
  * Player
  * NPC
  * Objects
* [Game Loop]() - The code that runs x times per second (main loop)
* [Artificial Intelligence]() - self explanatory?
* [Event Handler]() - handles things such as your keyboard layout / what should happen if x happens?
  * Add a textfield for sending text to the client(can be used later to also send it to multiplayer chat)
* [Event Scheduler]() - Schedules when the game should do something, in events where it is required that this runs with the main game loop. (such as timed delays?) for example, something happens and needs to do something else in 30 seconds, this will run every so often to check if 30 seconds has elapsed since then, and once it finally has, it will do something. (adjust how frequently this method will run)
* [RPG System?]() - Handle things such as abilities, items, inventories, worn equipment / items, etc?
* []() -

* [Networking]() - anything which interacts with somebody or something else over the internet.
  * Add multiplayer, either from peer to peer, or from setting up a server.
## Other ToDos
* make & release a simple audio player demo and standalone jar / source.

## Dependencies
* I'm using [LWJGL](https://www.lwjgl.org/) to run this project, so far I'm utilizing the following libraries:
  * [OpenAL](https://github.com/LWJGL/lwjgl3-wiki/wiki/2.1.-OpenAL)
  * [stb](http://www.java-gaming.org/index.php?topic=36153.0)
  * [minimal-json](https://github.com/ralfstx/minimal-json)

## special thanks:
[Mike S.](https://github.com/foreignguymike) Thanks for making the original game code which I eviscerated in order to start learning how to make my own. Also check out his [youtube channel](https://www.youtube.com/channel/UC_IV37n-uBpRp64hQIwywWQ).
