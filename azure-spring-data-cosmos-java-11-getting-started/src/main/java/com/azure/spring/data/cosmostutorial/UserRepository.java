// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.data.cosmostutorial;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import com.azure.spring.data.cosmos.repository.Query;

import java.util.List;

@Repository
public interface UserRepository extends CosmosRepository<User, String> {

    Iterable<User> findByFirstName(String firstName);

    @Query(value = "select * from c where c.firstName = @firstName AND ST_WITHIN(c.location, " +
        "{ 'type': 'Polygon', 'coordinates':[[" +
        "[@long1, @lat1]," +
        "[@long2, @lat2]," +
        "[@long3, @lat3]," +
        "[@long4, @lat4]," +
        "[@long5, @lat5]]]}) AND " +
        "ARRAY_CONTAINS(@mmsis, c.mmsi)")
    List<User> findByFirstNameAndMMSI(
        @Param("firstName")String firstName,
        @Param("long1") double long1,
        @Param("lat1") double lat1,
        @Param("long2") double long2,
        @Param("lat2") double lat2,
        @Param("long3") double long3,
        @Param("lat3") double lat3,
        @Param("long4") double long4,
        @Param("lat4") double lat4,
        @Param("long5") double long5,
        @Param("lat5") double lat5,
        @Param("mmsis") List<Integer> mmsis);

    User findByIdAndLastName(String id, String lastName);
}
