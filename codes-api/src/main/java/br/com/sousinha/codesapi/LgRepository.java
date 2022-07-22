package br.com.sousinha.codesapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LgRepository extends MongoRepository<Linguagem, String> {
    
}
