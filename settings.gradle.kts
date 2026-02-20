rootProject.name = "CareoBackend"

include(
    "app",
    "shared:domain",
    "shared:infrastructure",
    "shared:api",
    "modules:user",
    "modules:records",
    "modules:subscription",
    "modules:ai",
    "modules:sync"
)