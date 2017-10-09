package studyo.materia;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
 *  esta annotation do jeito que está é desnecessária, pois está com o mesmo nome da classe
 *  e esta nomeação para o path ocorre automaticamente. Coloquei apenas para utilizar de 
 *  exemplo para futuras implementações
 */
@RepositoryRestResource(collectionResourceRel = "materia", path = "materia")
public interface MateriaRepository extends MongoRepository<Materia, String>{

	List<Materia> findByNome(@Param("nome") String nome);
	
}
