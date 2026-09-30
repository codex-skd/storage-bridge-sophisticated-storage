# Storage Bridge (Sophisticated Storage)

Right-click a Sophisticated Storage Controller to send enchanted books to an Apothic-Enchanting Library and gems to an Apotheosis Gem Case connected to its storage network — no hoppers, no pipes.

Storage Bridge (Sophisticated Storage) hooks into the click Sophisticated Storage already uses to deposit your inventory into a Controller's storages, and adds targets that Sophisticated Storage can't reach on its own. It uses each mod's public `IItemHandler` capability; no mixins, no extra blocks.

## Features

- **Apothic-Enchanting Library integration** — right-clicking a Sophisticated Storage Controller (main hand, not sneaking, any face) moves every `minecraft:enchanted_book` stack in the player's inventory into an Apothic-Enchanting Library (`apothic_enchanting:library` "Enchantment Library" or `apothic_enchanting:ender_library` "Library of Alexandria") reachable through the Controller's network. One-directional: the Library consumes every book it accepts and cannot return them.
- **Apotheosis Gem Case integration** — the same click also moves unsocketed gem stacks into a reachable Apotheosis Gem Case or Ender Gem Case; the Gem Case's own capability rejects anything that isn't a valid gem.
- **Reach** — the target block must touch the Controller, any storage connected to it, or a block linked to it (such as a Storage Link), within Sophisticated Storage's own `controllerRange`.
- Sophisticated Storage's own deposit still happens on the same click; books and gems are routed first.

## Requirements

| | |
|---|---|
| Minecraft | 1.21.1 |
| NeoForge | 21.1.249+ |
| Sophisticated Storage (+ Sophisticated Core) | Required |
| Apothic-Enchanting | Required (Library integration) |
| Apotheosis + Placebo | Required (Gem Case integration) |

All of them are declared as `required` dependencies in the mod metadata (`neoforge.mods.toml`).

## Building from source

```
./gradlew build
```

The built jar is placed in `build/libs/`.
