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

package busymachines.phx.util.route

import busymachines.pureharm.route
import busymachines.pureharm.effects._

object Routes {

  def apply[F[_]](implicit eff: Async[F]): Routes[F] = new route.Routes[F] {
    override protected def F:                   Async[F]                  = eff
    override protected def http4sServerOptions: Http4sServerOptions[F, F] = _opts
    private lazy val _opts = customServerOpsHelper()
  }
}
