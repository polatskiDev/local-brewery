package guru.springframework.local.brewery.web.controller.v2;


import guru.springframework.local.brewery.services.v2.BeerServiceV2;
import guru.springframework.local.brewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Orhan Polat
 */
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerId(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto){

        beerServiceV2.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeer(beerId);
    }
}
