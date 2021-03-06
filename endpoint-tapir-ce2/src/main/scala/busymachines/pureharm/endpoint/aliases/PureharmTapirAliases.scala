/*
 * Copyright 2021 BusyMachines
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package busymachines.pureharm.endpoint.aliases

import busymachines.pureharm.anomaly.AnomalyLike
import sttp.tapir.{LowPrioritySchema, SchemaExtensions}
import sttp.tapir.macros.SchemaCompanionMacros

/** Mirrors: sttp.tapir.TapirAliases but it realiases Codec to TapirCodec because that conflicts with Circe's Codec, and
  * that's way too annoying.
  */
trait PureharmTapirAliases {

  type SimpleEndpoint[I, O] = sttp.tapir.Endpoint[I, AnomalyLike, O, Any]

  //mirroring starts here:
  type CodecFormat = sttp.tapir.CodecFormat
  val CodecFormat: sttp.tapir.CodecFormat.type = sttp.tapir.CodecFormat

  /** Codec.scala */
  type TapirCodec[L, H, CF <: CodecFormat] = sttp.tapir.Codec[L, H, CF]
  val TapirCodec: sttp.tapir.Codec.type = sttp.tapir.Codec
  type TapirPlainCodec[T] = sttp.tapir.Codec.PlainCodec[T]

  val TapirCodecs: busymachines.pureharm.endpoint.TapirCodecs.type =
    busymachines.pureharm.endpoint.TapirCodecs

  /** DecodeResult.scala */
  type DecodeResult[+T] = sttp.tapir.DecodeResult[T]
  val DecodeResult: sttp.tapir.DecodeResult.type = sttp.tapir.DecodeResult

  /** Defaults.scala */
  val Defaults: sttp.tapir.Defaults.type = sttp.tapir.Defaults

  /** Endpoint.scala */
  type Endpoint[I, E, O, -R] = sttp.tapir.Endpoint[I, E, O, R]
  val Endpoint: sttp.tapir.Endpoint.type = sttp.tapir.Endpoint

  type EndpointInfo = sttp.tapir.EndpointInfo
  val EndpointInfo: sttp.tapir.EndpointInfo.type = sttp.tapir.EndpointInfo

  /** EndpointIO.scala */
  type EndpointInput[I] = sttp.tapir.EndpointInput[I]
  val EndpointInput: sttp.tapir.EndpointInput.type = sttp.tapir.EndpointInput

  type EndpointOutput[O] = sttp.tapir.EndpointOutput[O]
  val EndpointOutput: sttp.tapir.EndpointOutput.type = sttp.tapir.EndpointOutput

  type EndpointIO[I] = sttp.tapir.EndpointIO[I]
  val EndpointIO: sttp.tapir.EndpointIO.type = sttp.tapir.EndpointIO

  /** package.scala */
  type RawPart           = sttp.tapir.RawPart
  type AnyPart           = sttp.tapir.AnyPart
  type AnyListCodec      = sttp.tapir.AnyListCodec
  type MultipartCodec[T] = sttp.tapir.MultipartCodec[T]

  /** RenderPathTemplate.scala */
  val RenderPathTemplate: sttp.tapir.RenderPathTemplate.type = sttp.tapir.RenderPathTemplate

  /** SchemaType.scala */
  type SchemaType[T] = sttp.tapir.SchemaType[T]
  val SchemaType: sttp.tapir.SchemaType.type = sttp.tapir.SchemaType

  /** Schema.scala */
  type Schema[T] = sttp.tapir.Schema[T]

  val Schema: sttp.tapir.Schema.type with SchemaExtensions with LowPrioritySchema with SchemaCompanionMacros =
    sttp.tapir.Schema

  /** Tapir.scala */
  type Tapir              = sttp.tapir.Tapir
  type TapirDerivedInputs = sttp.tapir.TapirDerivedInputs

  /** TapirAuth.scala */
  val TapirAuth: sttp.tapir.TapirAuth.type = sttp.tapir.TapirAuth

  type Fs2Streams[F[_]] = sttp.capabilities.fs2.Fs2Streams[F]
  val Fs2Streams = sttp.capabilities.fs2.Fs2Streams

}
