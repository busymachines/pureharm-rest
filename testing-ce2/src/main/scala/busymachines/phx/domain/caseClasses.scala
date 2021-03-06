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

package busymachines.phx.domain

import busymachines.phx.util.json._
import busymachines.phx.util.endpoint._

/** @author
  *   Lorand Szakacs, https://github.com/lorandszakacs
  * @since 10
  *   Jul 2020
  */
final case class MyInputType(
  f1:  PHString,
  f2:  PHInt,
  f3:  PHLong,
  fl:  List[PHLong],
  f4:  List[PHUUID],
  f5:  Option[PHString],
  sf6: SafePHUUIDThr,
)

object MyInputType {

  implicit val codec:  Codec[MyInputType]  = derive.codec[MyInputType]
  implicit val schema: Schema[MyInputType] = Schema.derived
}

final case class MyOutputType(
  id:  PHUUID,
  f1:  PHString,
  f2:  PHInt,
  f3:  PHLong,
  fl:  List[PHLong],
  f4:  List[PHUUID],
  f5:  Option[PHString],
  sf6: SafePHUUIDThr,
)

object MyOutputType {
  implicit val codec:  Codec[MyOutputType]  = derive.codec[MyOutputType]
  implicit val schema: Schema[MyOutputType] = Schema.derived
}
