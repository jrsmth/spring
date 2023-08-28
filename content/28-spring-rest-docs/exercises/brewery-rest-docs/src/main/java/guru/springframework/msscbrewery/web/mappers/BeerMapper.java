package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by jt on 2019-05-25.
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
// Error:
// Note :: java.lang.NullPointerException: Cannot invoke "java.net.URL.toExternalForm()" because "resource" is null at org.mapstruct
// Soln:
// Note :: https://stackoverflow.com/questions/66591176/java-lang-nullpointerexception-cannot-invoke-java-net-url-toexternalform-be
// Note :: File | Settings | Build, Execution, Deployment | Compiler | user-local build process vm options
// Note :: -Djps.track.ap.dependencies=false