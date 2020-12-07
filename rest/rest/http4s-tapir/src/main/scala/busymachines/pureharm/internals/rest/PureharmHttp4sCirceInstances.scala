/** Copyright (c) 2017-2019 BusyMachines
  *
  * See company homepage at: https://www.busymachines.com/
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
package busymachines.pureharm.internals.rest

import busymachines.pureharm.effects._
import busymachines.pureharm.json._
import fs2.Chunk
import io.circe.Printer
import org.http4s._
import org.http4s.circe.CirceInstances
import org.http4s.headers.`Content-Type`

/** You need to have this in scope if you want "seamless" serializing/deserializing
  * to/from JSON in your HttpRoutes endpoints.
  *
  * @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 26 Jun 2018
  */
trait PureharmHttp4sCirceInstances {

  import PureharmHttp4sCirceInstances._

  /** This code was copied from [[org.http4s.circe.CirceInstances#jsonEncoderWithPrinter]]
    * Ideally, we would have done directly:
    * {{{
    *   circeInstance.jsonEncoderOf[F, T]
    * }}}
    * But that throws us into an infinite loop because the implicit picks itself up.
    *
    * @return
    */
  implicit def applicativeEntityJsonEncoder[F[_]: Applicative, T: Encoder]: EntityEncoder[F, T] =
    EntityEncoder[F, Chunk[Byte]]
      .contramap[Json] { json =>
        val bytes = printer.printToByteBuffer(json)
        Chunk.byteBuffer(bytes)
      }
      .withContentType(`Content-Type`(org.http4s.MediaType.application.json))
      .contramap(t => Encoder[T].apply(t))

  implicit def syncEntityJsonDecoder[F[_]: Sync, T: Decoder]: EntityDecoder[F, T] =
    circeInstances.jsonOf[F, T] //TODO: adaptErrorMessage

}

object PureharmHttp4sCirceInstances {
  private val printer:        Printer        = Printer.noSpaces.copy(dropNullValues = true)
  private val circeInstances: CirceInstances = CirceInstances.withPrinter(printer).build
}
