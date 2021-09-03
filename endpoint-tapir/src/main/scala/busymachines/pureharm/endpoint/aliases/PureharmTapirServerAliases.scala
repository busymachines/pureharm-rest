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

import sttp.tapir.server

/** @author
  *   Lorand Szakacs, https://github.com/lorandszakacs
  * @since 16
  *   Jul 2020
  */
trait PureharmTapirServerAliases {
  type DecodeFailureHandling = server.DecodeFailureHandling
  val DecodeFailureHandling: server.DecodeFailureHandling.type = server.DecodeFailureHandling

  type DecodeFailureContext = server.DecodeFailureContext
  val DecodeFailureContext: server.DecodeFailureContext.type = server.DecodeFailureContext

  type DecodeFailureHandler = DecodeFailureContext => DecodeFailureHandling

  val ServerDefaults: server.ServerDefaults.type = server.ServerDefaults

  type ServerEndpoint[I, E, O, -R, F[_]]               = server.ServerEndpoint[I, E, O, R, F]
  type PartialServerEndpoint[U, I, E, O, -R, F[_]]     = server.PartialServerEndpoint[U, I, E, O, R, F]
  type ServerEndpointInParts[U, IR, I, E, O, -R, F[_]] = server.ServerEndpointInParts[U, IR, I, E, O, R, F]

  type SimpleServerEndpoint[I, O, F[_]] = server.ServerEndpoint[I, Throwable, O, Nothing, F]
}
