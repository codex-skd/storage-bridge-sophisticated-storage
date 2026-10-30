# Changelog

Todos los cambios notables de este proyecto se documentan en este archivo.

## [0.0.0-beta.5] - 2026-10-30

### Changed

- **Variables de CurseForge**: `docs/curseforge/project_vars.md` pasa a `docs/curseforge/project.env` (formato env: `PROJECT_ID`, `GAME_VERSIONS`, `RELEASE_TYPE`, `RELATIONS`). La documentación genérica se centraliza en `codex-docs/reference/CURSEFORGE.md` y los scripts de subida y consulta leen el nuevo fichero.
- **Sin cambios en el mod**: solo documentación y tooling. Versión **exenta de subida a CurseForge** (no hay JAR nuevo que publicar); se versiona por ser un cambio de proceso importante.

## [0.0.0-beta.4] - 2026-10-29

### Changed

- **Tokens de CurseForge**: el token de subida y la clave Core ya no se guardan en `docs/curseforge/project_vars.md`; se leen de las variables de entorno de usuario `API_MOD_UPLOAD_CURSEFORGE` y `API_MOD_GET_CURSEFORGE`. Los scripts de subida y consulta se han adaptado y la documentación se ha actualizado.
- **Sin cambios en el mod**: solo documentación y tooling. Versión **exenta de subida a CurseForge** (no hay JAR nuevo que publicar); se versiona por ser un cambio de proceso importante.

## [0.0.0-beta.3]

### Changed

- NeoForge bumped 21.1.249 -> 21.1.259. New branch `minecraft/1.21.1/neoforge-21.1.259/production`.
  No gameplay changes.

## [Unreleased]

### Added

- **`LICENSE`**: el mod declara `mod_license=All Rights Reserved` en `gradle.properties`, pero no
  habia fichero de licencia, asi que el snapshot publico no declaraba sus terminos. `LICENSE` ya estaba
  en el allowlist apuntando a un fichero que no existia.

---

## [0.0.0-beta.2]

### Fixed

- Dependencias obligatorias (Sophisticated Core, Sophisticated Storage, Placebo, Apotheosis and Apothic Enchanting) declaradas como `relations` en `docs/curseforge/project_vars.md`,
  para que el launcher de CurseForge las instale automáticamente. Sin cambios de juego.

## [0.0.0-beta.1] - 2026-09-30

### Añadido
- Estructura inicial del repositorio (docs, workflow, CI/CD) y esqueleto Gradle/NeoForge del mod (`StorageBridgeSophisticatedStorage`, dependencias reales de Sophisticated Storage/Core, Apothic-Enchanting, Apotheosis y Placebo en `libs/`).
- Gesto: clic derecho con la mano principal, sin agacharse, en cualquier cara de un Controller de Sophisticated Storage (el mismo clic con el que Sophisticated Storage deposita el inventario, que se sigue ejecutando).
- Alcance: el bloque destino debe tocar el Controller, cualquier almacenamiento conectado a él (`getStoragePositions()`) o un bloque enlazado como un Storage Link (`getLinkedBlocks()`), dentro del `controllerRange` de Sophisticated Storage (`ControllerNetworkSearch`).
- Integración con Apothic-Enchanting Library (`apothic_enchanting:library` / `apothic_enchanting:ender_library`): deposita todos los libros encantados del inventario del jugador.
- Integración con Apotheosis Gem Case / Ender Gem Case: deposita las gemas sin engarzar; la propia capability del Gem Case filtra qué es una gema válida.
