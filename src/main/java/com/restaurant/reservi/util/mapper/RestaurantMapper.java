package com.restaurant.reservi.util.mapper;

import com.restaurant.reservi.application.dto.RestaurantRequest;
import com.restaurant.reservi.application.dto.RestaurantResponse;
import com.restaurant.reservi.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant restaurantRequestToRestaurant(RestaurantRequest restaurantRequest);
    RestaurantResponse restaurantToRestaurantResponse(Restaurant restaurant);
}
