# CurseForge — Variables del proyecto

## Proyecto

| Variable | Valor |
|----------|-------|
| `project_id` | `1719578` |
| `mod_id` | `storage_bridge_sophisticated_storage` |
| `display_name` | `Storage Bridge (Sophisticated Storage)` |
| `slug` | `storage-bridge-sophisticated-storage` |

## Tokens

| API | Token | Uso |
|-----|-------|-----|
| Upload | `ee776b0a-ee95-4850-b554-06be02a8657f` | Subir archivos JAR |
| Core (GET) | `$2a$10$yGwryAfmRkS9ZJsJUDf5YOKZpOIsmHB8Fji2D8JVCKBSZEKYlwmaO` | Consultar datos del mod |

Autenticación Upload: cabecera `X-Api-Token`
Autenticación Core: cabecera `x-api-key`

## Versión actual (rama 1.21.1)

| Variable | Valor |
|----------|-------|
| `minecraft_version` | `1.21.1` |
| `neo_version` (loader) | `21.1.249` |
| `framework` | `neoforge` |
| `java_version` | `21` |
| `mod_version` | `0.0.0-beta.1` |
| `environment` | `Client`, `Server` |

## Rama

```
minecraft/1.21.1/neoforge-21.1.249/production
```

## IDs de `gameVersions` para 1.21.1 (reutilizados de player_activity_view, verificados 2026-09-02)

| Nombre | ID |
|--------|-----|
| `Client` | `9638` |
| `Server` | `9639` |
| `1.21.1` | `11779` |
| `NeoForge` | `10150` |

## Claves parseables por el script genérico

```
project_id = 1719578
api_token = ee776b0a-ee95-4850-b554-06be02a8657f
game_versions = 9638, 9639, 11779, 10150
release_type = beta
```

## Subir archivo (JAR)

Usar el script genérico `codex-docs/scripts/curseforge-upload.ps1` (desde este repo):

```powershell
powershell -File ../../codex-docs/scripts/curseforge-upload.ps1
```

## Descripcion del proyecto

No hay endpoint API para actualizar la descripcion. Se edita manualmente desde la web de CurseForge pegando el HTML de `docs/curseforge/project_description.md`.
