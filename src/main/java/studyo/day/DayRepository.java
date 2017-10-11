package studyo.day;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "day", path = "day")
public interface DayRepository extends MongoRepository<Day, String>{
	
}
