# Flujo de trabajo — Storage Bridge (Sophisticated Storage) (NeoForge)

> **Versión del workflow**: 1.18.0 (codex-docs)
> Este archivo pertenece al proyecto **Storage Bridge (Sophisticated Storage)**. Cambios aquí solo afectan a este proyecto.
> **Trabaja directamente con este archivo**: es el workflow operativo del mod, autocontenido. No leas `codex-docs/WORKFLOW_AGENT.md` ni `WORKFLOW_GENERIC.md` de forma rutinaria.
> On-demand (solo si la tarea lo necesita): `codex-docs/reference/CURSEFORGE.md` (formato HTML al publicar), `codex-docs/reference/GRAPHIFY.md` (backend LLM de Graphify), `codex-docs/reference/REPO_SETUP.md` (setup único de repo).

## Específico del mod

| Dato | Valor |
|---|---|
| Mod ID (`gradle.properties`) | `storage_bridge_sophisticated_storage` |
| Clase principal | `StorageBridgeSophisticatedStorage` |
| Paquete base | `com.skd.storagebridge.sophisticatedstorage` |
| Display name (Title Case) | `Storage Bridge (Sophisticated Storage)` |
| Slug (GitLab / GitHub / CurseForge) | `storage-bridge-sophisticated-storage` |
| Proyecto CurseForge | `1719578` |
| Versiones de Minecraft | `1.21.1` |
| Rama | `minecraft/1.21.1/neoforge-21.1.249/production` |

### Notas específicas de este mod

- **Naturaleza**: mod de compatibilidad nuevo (no es fork). El origen es siempre un **Controller de Sophisticated Storage**; los destinos son bloques de otros mods pegados al Controller, a cualquier almacenamiento que el Controller tenga conectado (`getStoragePositions()`, rango `controllerRange` de Sophisticated Storage) o a un bloque enlazado como un Storage Link (`getLinkedBlocks()`). Lógica en `compat/ControllerNetworkSearch`.
- **Proyecto independiente**: se parece a *Storage Bridge (Storage Drawers)* pero es otro mod, con su propio proyecto CurseForge y sin código ni convención común. No sincronizar cambios entre ambos de forma automática.
- **Gesto**: clic derecho con la mano principal, sin agacharse, en cualquier cara del Controller (no tiene cara frontal). Es el mismo clic con el que Sophisticated Storage deposita el inventario; nuestro listener (`PlayerInteractEvent.RightClickBlock`) corre antes y no cancela el evento, así que el depósito propio de Sophisticated Storage sigue ocurriendo después.
- **Integraciones**: Apothic-Enchanting Library (libros encantados, unidireccional) y Apotheosis Gem Case / Ender Gem Case (gemas). No hay integración "hacia Sophisticated Storage" porque es el mod de origen. No añadir integraciones nuevas sin confirmación explícita del usuario.
- **Dependencias en tiempo de ejecución**: `sophisticatedstorage`, `sophisticatedcore`, `apothic_enchanting`, `apotheosis` y `placebo`, todas `required` con `ordering=AFTER` en `neoforge.mods.toml`.
- **Entorno de desarrollo**: `libs/` no incluye `apothic_attributes` (dependencia de Apotheosis y Apothic-Enchanting); para `runClient`/`runServer` hay que ponerla en `lib_ext/` y añadirla como `localRuntime` solo en local.
- **Sin mixins** y **sin estado persistente** (no registra bloques, items, config ni datos de mundo).

## Convenciones de nomenclatura

| Convención | Uso | Ejemplo |
|---|---|---|
| **snake_case** | `mod_id`, assets/, packages Java | `storage_bridge_sophisticated_storage` |
| **PascalCase** | Clases Java principales | `StorageBridgeSophisticatedStorage` |
| **camelCase** | Variables, métodos, config keys | `storageBridgeSophisticatedStorageConfig` |
| **Title Case** | Display name (README, CHANGELOG, docs, CurseForge) | `Storage Bridge (Sophisticated Storage)` |

## Organización y ramas

- Un repo GitLab por mod, una rama `minecraft/<mc>/neoforge-<neo>/production` por versión. Este clon local trabaja en la rama `production` de esta versión.
- Carpetas: `<mod_id>/<framework>/<mc-version>/` — este clon vive en `storage_bridge_sophisticated_storage/neoforge/1.21.1/`.
- `*/main` y CI/CD: setup único al crear el repo (`codex-docs/reference/REPO_SETUP.md`) — no releer ni modificar.

## Estructura del proyecto

`build.gradle` · `gradle.properties` (mod_id, mod_version, mod_group_id, mod_framework) · `settings.gradle` · `src/main/java/<package>/` · `src/main/resources/assets/<mod_id>/` · `META-INF/neoforge.mods.toml` · `libs/` (versionado) · `lib_ext/` y `temp/` (no versionados) · `docs/` (WORKFLOW + curseforge/) · `CHANGELOG.md` · `README.md` · `graphify-out/` (versionado).

## Versionado

- Beta `0.0.0-beta.X` · Release `X.Y.Z` (SemVer: MAJOR breaking / MINOR feature / PATCH fix)
- `mod_version` y `mod_framework` en `gradle.properties`. JAR: `<mod_id>-<mc>-<framework>-<loader>-<version>.jar`

## Commits (Conventional Commits)

`<tipo>[<ámbito>]: <descripción>` · tipos `feat fix refactor docs chore style perf test` · el mensaje incluye la versión (`v<version>`).

## Sin tags

**No se crean tags git** (ni en GitLab ni en ningún remoto): apuntan a commits de `production` y el mirror los publicaría con el contenido privado. El commit exacto de cada JAR es su `chore: bump version to <version>`.

## Flujo por tarea

**0. Alcance** — si el mod tiene varias versiones, preguntar con la herramienta `question`: **"Todas"** o una versión. No asumir.

**1. Desarrollo**

```bash
git checkout minecraft/1.21.1/neoforge-21.1.249/production
./gradlew.bat build
git add -A
git commit -m "feat: <descripción>

v<version>"
git push
```

**2. CurseForge** — solo si el usuario confirma:
- Bump `mod_version` en gradle.properties → `./gradlew.bat clean build`
- Release notes `docs/curseforge/versions/<version>.md` (HTML) + actualizar `CHANGELOG.md`
- Commit `chore: bump version to <version>` → push (sin tag)
- Subir JAR: `powershell -File ../../codex-docs/scripts/curseforge-upload.ps1` (desde este repo)
- Formato HTML de descripciones/changelog: `codex-docs/reference/CURSEFORGE.md`

**3. Release estable** — bump `X.Y.Z` + commit (sin tag).

**4. Graphify** — tras cada push a remoto. Versión 0.9.12: **`build` no existe**, usar `extract` (1ª vez) o `update . --force` (tras cambios):

```bash
GRAPHIFY="C:\Users\llagu\AppData\Local\Packages\PythonSoftwareFoundation.Python.3.13_qbz5n2kfra8p0\LocalCache\local-packages\Python313\Scripts\graphify.exe"
"$GRAPHIFY" update . --force
git add graphify-out/ && git commit -m "chore: update knowledge graph" && git push
```

Leer siempre `GRAPH_REPORT.md`, nunca `graph.json`/`graph.html` (pesan >1MB). Sin copias fechadas de `graphify-out/`. Backend LLM: `codex-docs/reference/GRAPHIFY.md`.

## Buenas prácticas

- Un commit por cambio lógico · commit+push tras cada cambio funcional y de docs
- `clean build` antes del JAR final · versionar antes de CurseForge · CHANGELOG al día
- Graphify actualizado tras cada release · nomenclatura consistente · sin basura en repo (`nul`, `*_errors.txt`, `TEMPLATE_LICENSE.txt`) · `.gitignore` excluye `temp/` y `lib_ext/`
- README en inglés siempre actualizado · sin residuos de mod original (no aplica: no es fork) · si en el futuro se integra código de terceros como referencia, atribución explícita (README, project_description, credits)

## Idioma

| Ámbito | Idioma |
|---|---|
| código, logs, commits | en-US |
| README.md | en-US |
| docs internas (docs/, CHANGELOG, este archivo) | es-ES |
| CurseForge | en-US |
