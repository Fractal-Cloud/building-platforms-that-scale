# Building Platforms that Scale — Companion Code

[![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)](https://openjdk.org/projects/jdk/25/)
[![Gradle](https://img.shields.io/badge/Gradle-9.5-02303A?logo=gradle)](https://gradle.org/)
[![License: AGPL v3](https://img.shields.io/badge/License-AGPL_v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)

Companion source code for the book **[Building Platforms that Scale: A Practical Guide to Platform Engineering with Fractal Architecture](https://www.informit.com/store/building-platforms-that-scale-a-practical-guide-to-9780138340186)** (Addison-Wesley / Pearson).

This repository contains a simplified Java SDK that mirrors the [Fractal Cloud](https://fractal.cloud) platform's core abstractions. It is purposely minimal — every type exists to make the book's examples runnable and explorable, not to ship to production.

---

## What's in here

The codebase is split into the SDK (`src/main`) and the chapter examples (`src/test`).

### `src/main/java/cloud/fractal/book` — the SDK

The skeleton of the Fractal Architecture model:

| Package | Purpose |
|---|---|
| `book` | Top-level domain types: `Component`, `ComponentBase`, `BoundedContext`, `Environment` |
| `book.fractal` | Reusable patterns: `Fractal`, `Blueprint`, `BlueprintComponent`, `Interface`, `Offer`, `Provider` |
| `book.livesystem` | Customer instantiations: `LiveSystem`, `LiveSystemComponent` |
| `book.values` | Value objects: `InfrastructureDomain`, `ServiceDeliveryModel`, `KebabCaseString`, `PascalCaseString`, `OwnerId`, `OwnerType`, `Version` |
| `book.fractal.components.*` | Abstract component contracts: `ObjectStorage`, `CertificateAuthorityComponent`, `CustomPaaSWorkload`, `CustomFunctionWorkload` |
| `book.livesystem.components.*` | Vendor-specific offers: `S3` (AWS), `LambdaFunction` (AWS), `CloudFunction` (GCP), `AppEngineApplication` (GCP), `ElasticBeanstalkApplication` (AWS), `AwsAcmPrivateCertificateAuthority`, `GcpCasCertificateAuthority` |

### `src/test/java/cloud/fractal/book` — chapter examples

Each role from the book has its own package:

- **`ccoe/`** — examples produced by a **Cloud Center of Excellence** team authoring Fractals: `AwsSimpleLandingZone`, `GcpSimpleLandingZone`, `AwsThreeTierApplication`, plus shared `BoundedContexts`, `Environments`, `Constants`.
- **`devteam/`** — examples produced by a **Dev team** consuming Fractals: `SalesApp` and its `BoundedContexts` / `Constants`.

They live in `src/test` for two reasons. First, they double as **unit tests for the SDK** — one of the book's recurring points is that infrastructure-as-code becomes testable when expressed as a typed model rather than templates, and these examples exercise the SDK in exactly that way. Second, they reference the SDK without ending up on the published artifact.

---

## Core concepts in 60 seconds

The book builds on five concepts that map 1:1 to types in this repo:

1. **Bounded Context** — a governance scope grouping Fractals, LiveSystems, and Environments (personal or organizational).
2. **Fractal** — a reusable infrastructure pattern composed of a **Blueprint** (what is fixed) and an **Interface** (what consumers can specialize).
3. **LiveSystem** — a customer's running instantiation of a Fractal.
4. **Component → Service → Offer** — the three-level catalogue hierarchy. Components are abstract contracts, Services are delivery models, Offers are concrete vendor-specific implementations.
5. **Parameters / Dependencies / Links** — the three distinct ways components describe themselves and relate to each other.

The book unpacks each of these step by step, with worked examples that map directly to the code in this repo.

---

## Build & run

Requires **JDK 25**. The Gradle wrapper handles everything else.

```bash
./gradlew build       # compile main + test, build sources + javadoc jars
./gradlew compileJava # main only
./gradlew test        # run JUnit 5 tests
./gradlew clean
```

The build uses Java 25 with `--enable-preview`, Lombok for boilerplate, and the standard JUnit 5 / AssertJ / jFixture stack ready to go if you want to add your own tests.

---

## Versioning

This repository tracks the published book. It is intentionally **not** a moving target — when the book is updated, this repo will be tagged to match.

---

## License

Licensed under the [GNU Affero General Public License v3.0](LICENSE).

---

## About Fractal Cloud

The Fractal Architecture model in this book is the same model that powers the [Fractal Cloud](https://fractal.cloud) platform. If you want to use Fractal Architecture in production rather than learn the concepts, that's where to start.

---

## Get the book

📘 **[Building Platforms that Scale — InformIT](https://www.informit.com/store/building-platforms-that-scale-a-practical-guide-to-9780138340186)**