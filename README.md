![logo](https://raw.githubusercontent.com/Urkaz/MoreCobblemonStats/refs/heads/main/external_resources/more_cobblemon_stats.png)

# More Cobblemon Stats

Adds more Stats to Cobblemon and some of its most common addons.
Also applies some fixes to some of those addons.

## New Stats

* [Cobblemon (1.7.3+1.21.1)](https://modrinth.com/mod/cobblemon)
    * Poké Balls Thrown
    * Poké Balls Thrown Hit
    * Pokémon Defeated
    * Pokémon Terastalized
    * Pokémon Mega Evolved
    * Pokémon Forme Changes
    * Pokémon Z-Moves Used
* [Cobbledollars (2.0.0+Beta-5.1)](https://modrinth.com/mod/cobbledollars)
    * Cobbledollars Earned
    * Cobbledollars Lost
* [CobbleSafari (0.2.0)](https://modrinth.com/mod/cobblesafari)
    * Hoopa Rings Traversed
    * Safari Expeditions
    * Underground Treasures Found
    * (Visits to dimensions through Hoopa Rings):
        * Underground Adventures
        * Distortion World Visits
    * Secret Base Flags Stolen
    * Reward Balloons Looted
* [Cobblemon Quick Battle (1.3.8)](https://modrinth.com/mod/cobblemon-quick-battle)
    * Pokémon Quick Battles
    * Pokémon Quick Battles Won
    * Pokémon Quick Battles Started
* [Cobblemon Rustling Spots (2.0.1)](https://modrinth.com/mod/cobblemon-rustling-spots)
    * Rustling Spots Examined
* [Cobblemon Marks Quests (1.0.2)](https://www.curseforge.com/minecraft/mc-mods/cobblemon-marks-quests/)
    * Pokémon Marks Obtained
* [Cobblemon: Research Tasks (2.0)](https://modrinth.com/mod/cobblemon-research-tasks) (Fabric Only)
    * Taks Completed
    * Entries Completed: _(by claiming the completed reward)_
* [Cobblemon Ultra-Beasts (3.1)](https://www.curseforge.com/minecraft/mc-mods/cobblemon-ultra-beasts) (Fabric Only)
    * Ultra Wormholes Entered
* [Cobblemon Snap (1.1.2)](https://modrinth.com/mod/cobblemon-snap)
    * Photos Taken: _(by just taking photos)_
    * Photos Registered: _(photos taken that contained a Pokémon)_
    * Snapdex Entries: _(entries considered "captured" in the Snapdex)_
    * Total Pokémon Captured: _(total count of Pokémon that appeared in photos)_
* [PokeBike (1.8)](https://modrinth.com/mod/pokebike)
    * Distance by Bike
* [Cobblemon Expeditions (1.1.2/3)](https://modrinth.com/mod/cobblemon_expeditions)
    * Expeditions Started
    * Expeditions Canceled
    * Expeditions Finished
    * Expeditions With Failed Result
    * Expeditions With Partial Result
    * Expeditions With Great Result
    * Expeditions With Successful Result
* [Cobblemon: Shadowed Hearts (1.0.6)](https://modrinth.com/mod/cobblemon-shadowedhearts)
    * Shadow Pokémon Defeated
    * Shadow Pokémon Caught
    * Shadow Pokémon Purified
    * Shadow Pokémon Snagged
* [Cobblemon Battle Tower (1.10.19)](https://modrinth.com/mod/cobblemon-battle-tower)
    * Battles Won
    * Battles Lost
    * Runs Forfeited
    * Total Floors Completed
    * Total BP Earned
    * Best Win Streak
    * Highest Floor Reached
* [Cobblemon Wonder Trade (1.2.2)](https://modrinth.com/mod/cobblemon-wonder-trade)
    * Wonder Trades

## Compatibility Enhancements

* [CobbleSafari (0.2.0)](https://modrinth.com/mod/cobblesafari)
    * Incubators now count for "Pokémon Eggs Hatched".
    * Wild Eggs now count for "Pokémon Eggs Collected"
* [Cobblemon Quick Battle (1.3.8)](https://modrinth.com/mod/cobblemon-quick-battle)
    * Now triggers BATTLE_FAINTED events so other mods could handle the defeat.
* [Cobblemon: Research Tasks (2.0)](https://modrinth.com/mod/cobblemon-research-tasks) (Fabric Only)
    * Now correctly handles evolution through UI with the Pokémon inside the PokéBall.
* [Cobblemon Wonder Trade (1.2.2)](https://modrinth.com/mod/cobblemon-wonder-trade)
    * Now awards Cobblemon:Traded stat.

## New features

* New command (/mcs shiny_check &lt;player>) to check a player's shiny chance.

# TODO List

- Stat: Add Num of Entries in SnapDex
- Fix ShadowedHearts snag achievement
- FTB Quests integration?
    - All implemented stats
    - Cobblemon Raid Dens
