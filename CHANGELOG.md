# Changelog

Todos los cambios notables de este proyecto se documentan en este archivo.

## [Unreleased]

### Added

- **`LICENSE`**: el mod declara `mod_license=All Rights Reserved` en `gradle.properties`, pero no
  habia fichero de licencia, asi que el snapshot publico no declaraba sus terminos. `LICENSE` ya estaba
  en el allowlist apuntando a un fichero que no existia.

---

## [0.0.0-beta.1] - 2026-09-30

### Añadido
- Estructura inicial del repositorio (docs, workflow, CI/CD) y esqueleto Gradle/NeoForge del mod (`StorageBridgeSophisticatedStorage`, dependencias reales de Sophisticated Storage/Core, Apothic-Enchanting, Apotheosis y Placebo en `libs/`).
- Gesto: clic derecho con la mano principal, sin agacharse, en cualquier cara de un Controller de Sophisticated Storage (el mismo clic con el que Sophisticated Storage deposita el inventario, que se sigue ejecutando).
- Alcance: el bloque destino debe tocar el Controller, cualquier almacenamiento conectado a él (`getStoragePositions()`) o un bloque enlazado como un Storage Link (`getLinkedBlocks()`), dentro del `controllerRange` de Sophisticated Storage (`ControllerNetworkSearch`).
- Integración con Apothic-Enchanting Library (`apothic_enchanting:library` / `apothic_enchanting:ender_library`): deposita todos los libros encantados del inventario del jugador.
- Integración con Apotheosis Gem Case / Ender Gem Case: deposita las gemas sin engarzar; la propia capability del Gem Case filtra qué es una gema válida.
