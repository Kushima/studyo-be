package studyo.subjectday;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "subjectDay", path = "subjectDay")
public interface SubjectDayRepository extends MongoRepository<SubjectDay, String>{
	
}
