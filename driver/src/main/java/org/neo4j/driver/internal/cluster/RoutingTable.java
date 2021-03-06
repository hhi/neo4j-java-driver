/*
 * Copyright (c) 2002-2017 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
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
package org.neo4j.driver.internal.cluster;

import java.util.Set;

import org.neo4j.driver.internal.async.BoltServerAddress;
import org.neo4j.driver.v1.AccessMode;

public interface RoutingTable
{
    boolean isStaleFor( AccessMode mode );

    Set<BoltServerAddress> update( ClusterComposition cluster );

    void forget( BoltServerAddress address );

    AddressSet readers();

    AddressSet writers();

    AddressSet routers();

    void removeWriter( BoltServerAddress toRemove );
}
