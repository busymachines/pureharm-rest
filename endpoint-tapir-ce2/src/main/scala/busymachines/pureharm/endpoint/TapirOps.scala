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

package busymachines.pureharm.endpoint

import busymachines.pureharm.sprout._
import sttp.tapir

/** @author
  *   Lorand Szakacs, https://github.com/lorandszakacs
  * @since 16
  *   Jul 2020
  */
object TapirOps {
  import sttp.tapir._

  final class AuthOps(val o: TapirAuth.type) extends AnyVal {

    def xCustomAuthHeader[T](
      headerName:         String
    )(implicit authCodec: Codec[String, T, CodecFormat.TextPlain]): EndpointInput.Auth.Http[T] = {
      implicit val listCodec: Codec[List[String], T, CodecFormat.TextPlain] =
        Codec.listHead[String, T, CodecFormat.TextPlain]
      EndpointInput.Auth.Http(
        scheme             = "Custom",
        input              = header[T](headerName)(listCodec).description(
          s"Authentication done with token required in header: $headerName"
        ),
        challenge          = EndpointInput.WWWAuthenticate.bearer(headerName),
        securitySchemeName = Option("Custom Auth Header"),
      )
    }

  }

  final class CodecOps[Old](val c: tapir.Codec.PlainCodec[Old]) {
    def sprout[New](implicit p: NewType[Old, New]): tapir.Codec.PlainCodec[New] = c.map[New](p.newType _)(p.oldType)

    def sproutRefined[New](implicit p: RefinedTypeThrow[Old, New]): tapir.Codec.PlainCodec[New] =
      TapirCodecs.refinedTypePlainCodec[Old, New](p, c)
  }
}
