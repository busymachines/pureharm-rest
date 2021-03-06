# pureharm-rest

See [changelog](./CHANGELOG.md).

## modules

- `"com.busymachines" %% "pureharm-endpoint-tapir" % "0.5.0-M3`

  - [sttp-shared-fs2](https://github.com/softwaremill/sttp-shared/releases) `1.1.1`
  - [tapir-core](https://github.com/softwaremill/tapir/releases) `0.19.0-M9`
  - [tapir-json-circe](https://github.com/softwaremill/tapir/releases) `0.19.0-M9`
  - [pureharm-core-anomaly](https://github.com/busymachines/pureharm-core/releases) `0.3.0`
  - [pureharm-core-sprout](https://github.com/busymachines/pureharm-core/releases) `0.3.0`
  - [pureharm-json-circe](https://github.com/busymachines/pureharm-json-circe/releases) `0.3.0-M1`
  - [pureharm-effects-cats](https://github.com/busymachines/pureharm-effects-cats/releases) `0.5.0`

- `"com.busymachines" %% "pureharm-endpoint-docs-tapir" % "0.5.0-M3`

  - [tapir-openapi-docs](https://github.com/softwaremill/tapir/releases) `0.19.0-M9`
  - [tapir-openapi-circe-yaml](https://github.com/softwaremill/tapir/releases) `0.19.0-M9`

- `"com.busymachines" %% "pureharm-route-http4s-tapir" % "0.5.0-M3`

  - `pureharm-endpoint-tapir`
  - [http4s-dsl](https://github.com/http4s/http4s/releases) `0.23.3`
  - [tapir-http4s-server](https://github.com/softwaremill/tapir/releases) `0.19.0-M9`

- `"com.busymachines" %% "pureharm-server-http4s" % "0.5.0-M3`
  - [pureharm-effects-cats](https://github.com/busymachines/pureharm-effects-cats/releases) `0.5.0`
  - [http4s-blaze-server](https://github.com/http4s/http4s/releases) `0.23.3`

## usage

See [`testing`](./testing) for a pretty much full-fledged example on how to use the modules.

Still under construction. See [release notes](https://github.com/busymachines/pureharm-rest/releases) and tests for examples.

## Copyright and License

All code is available to you under the Apache 2.0 license, available
at [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0) and also in
the [LICENSE](./LICENSE) file.
