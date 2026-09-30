<h1 align="center">&#128230; Storage Bridge (Sophisticated Storage)</h1>

<p align="center"><strong>Send enchanted books and gems from a Sophisticated Storage Controller to the right place &mdash; no hoppers, no pipes.</strong></p>

<p align="center">
<img src="https://img.shields.io/badge/loader-NeoForge-orange?style=plastic&logo=curseforge" alt="NeoForge">
<img src="https://img.shields.io/badge/minecraft-1.21.1-blue?style=plastic" alt="Minecraft 1.21.1">
<img src="https://img.shields.io/badge/type-compatibility-brightgreen?style=plastic" alt="Compatibility">
</p>

<br>

---

<br>

<h2>&#10024; Overview</h2>

<p>Storage Bridge (Sophisticated Storage) is a lightweight compatibility mod that lets a <strong>Sophisticated Storage Controller</strong> hand items to storage blocks from other mods that Sophisticated Storage can't reach on its own, using each mod's own public item-handling capability &mdash; no mixins, no extra blocks to place, no hoppers or pipes required.</p>

<p>No configuration needed: it hooks into the click Sophisticated Storage already uses to deposit your inventory into the Controller's storages. Sophisticated Storage's own deposit still happens; books and gems are simply routed to their proper home first.</p>

<br>

<h2>&#127919; Features</h2>

<h3>&#128218; Apothic-Enchanting Library Integration</h3>
<p>Right-click a Sophisticated Storage Controller with your main hand (not sneaking, any face) and every <code>minecraft:enchanted_book</code> in your inventory is moved into a reachable <strong>Apothic-Enchanting Library</strong> (<code>apothic_enchanting:library</code> "Enchantment Library" or <code>apothic_enchanting:ender_library</code> "Library of Alexandria"). One direction only: the Library consumes every book it receives and cannot return them, matching its own behavior.</p>

<br>

<h3>&#128142; Apotheosis Gem Case Integration</h3>
<p>The same click also moves unsocketed gem stacks into a reachable <strong>Apotheosis Gem Case</strong> or Ender Gem Case. The Gem Case's own capability rejects anything that isn't a valid gem, so no extra matching logic is needed.</p>

<br>

<h3>&#128279; Network Reach</h3>
<p>The Library or Gem Case doesn't have to touch the Controller: it can sit next to <strong>any storage connected to the Controller</strong>, or next to a linked block such as a <strong>Storage Link</strong>, within Sophisticated Storage's own <code>controllerRange</code>.</p>

<br>

<h2>&#128203; Requirements</h2>

<table>
<tr><td><strong>Minecraft</strong></td><td>1.21.1</td></tr>
<tr><td><strong>NeoForge</strong></td><td>21.1.249+</td></tr>
<tr><td><strong>Java</strong></td><td>21</td></tr>
<tr><td><strong>Depends on</strong></td><td><a href="https://www.curseforge.com/minecraft/mc-mods/sophisticated-storage">Sophisticated Storage</a> + <a href="https://www.curseforge.com/minecraft/mc-mods/sophisticated-core">Sophisticated Core</a></td></tr>
<tr><td><strong>Also required</strong></td><td><a href="https://www.curseforge.com/minecraft/mc-mods/apothic-enchanting">Apothic-Enchanting</a>, <a href="https://www.curseforge.com/minecraft/mc-mods/apotheosis">Apotheosis</a> + <a href="https://www.curseforge.com/minecraft/mc-mods/placebo">Placebo</a></td></tr>
</table>

<br>

<h2>&#127918; How to Use</h2>

<ol>
<li>Install <strong>Storage Bridge (Sophisticated Storage)</strong> alongside <strong>Sophisticated Storage</strong>, Apothic-Enchanting and Apotheosis.</li>
<li>Place a Library or Gem Case next to the Controller, next to any storage connected to it, or next to a Storage Link.</li>
<li>Right-click the Controller with your main hand &mdash; enchanted books go to the Library, gems to the Gem Case, and Sophisticated Storage deposits the rest as usual.</li>
</ol>

<br>

<blockquote><strong>Beta.</strong> <code>0.0.0-beta.1</code> is the first public build. Please report any issue you find.</blockquote>

<br>

---

<br>

<h2>&#128591; Credits</h2>

<p>Developed by <strong>Stalking Dragons</strong>.</p>

<br>
<br>

<p align="center">
  <a href="https://codex.skdragons.com/" target="_blank">
    <img src="https://node-files.skdragons.com/uploads/MINECRAFT/Codex/logo_codex_stalking_dragons.png" alt="Codex Stalking Dragons" width="200">
  </a>
  <br>
  <a href="https://codex.skdragons.com/">https://codex.skdragons.com/</a>
  <br>
  <em>Codex Stalking Dragons &mdash; Minecraft Modding</em>
</p>
