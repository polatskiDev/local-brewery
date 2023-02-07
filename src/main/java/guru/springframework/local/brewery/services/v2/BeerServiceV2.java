package guru.springframework.local.brewery.services.v2;

import guru.springframework.local.brewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * @author Orhan Polat
 */
public interface BeerServiceV2 {
    BeerDtoV2 getBeerId(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteBeer(UUID beerId);
}
