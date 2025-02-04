package com.projectnetflix.netflix.Service;


import com.projectnetflix.netflix.Dto.Guserdto;
import com.projectnetflix.netflix.Model.DatabaseSequence;
import com.projectnetflix.netflix.Model.Guser;
import com.projectnetflix.netflix.Repository.GuserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class GuserService {

    @Autowired
    private GuserRepo guserRepo;



    public Guser getUserById(long id){
        ;return guserRepo.findById(id).orElse(null);
    }

    public Guser addGuser(Guser guser){
        guser.setGuser_id(generateSequence(Guser.SEQUENCE_NAME));
        return guserRepo.save(guser);
    }

    public List<Guser> getGuser() {

        return guserRepo.findAll();
    }

    public Guser updateGuser(Long id, Guser guser) {
        Optional<Guser> optionalGuser = guserRepo.findById(id);
        Guser existingGuser = null;
        if (optionalGuser.isPresent()) {
            existingGuser = optionalGuser.get();
            existingGuser.setName(guser.getName());
            existingGuser.setEmail(guser.getEmail());
            existingGuser.setPassword(guser.getPassword());


        }
        return guserRepo.save(existingGuser);
    }

    public String deleteGuser(long id){
        guserRepo.deleteById(id);
        return "User Deleted - id=" +id;
    }

    

    @Autowired
    private MongoOperations mongoOperations;

    private long generateSequence(String seqName) {
        DatabaseSequence counter= mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                DatabaseSequence.class);

        return !Objects.isNull(counter)? counter.getSeq():1;
    }



}
