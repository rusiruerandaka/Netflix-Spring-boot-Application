package com.projectnetflix.netflix.Service;


import com.projectnetflix.netflix.Model.Admin;
import com.projectnetflix.netflix.Model.DatabaseSequence;
import com.projectnetflix.netflix.Repository.Adminrepo;
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
public class AdminService {

    @Autowired
    private Adminrepo adminrepo;

    public Admin getadminById(long id){
        return adminrepo.findById(id).orElse(null);

    }

    public Admin addAdmin(Admin admin){
        admin.setAdmin_id(generateSequence(Admin.SEQUENCE_NAME));
        return adminrepo.save(admin);

    }

    public List<Admin> getAdmin(){

        return adminrepo.findAll();
    }

    public Admin updateAdmin(Long id, Admin admin) {
        Optional<Admin> optionalGuser = adminrepo.findById(id);
        Admin existingGuser = null;
        if (optionalGuser.isPresent()) {
            existingGuser = optionalGuser.get();
            existingGuser.setName(admin.getName());
            existingGuser.setEmail(admin.getEmail());
            existingGuser.setPassword(admin.getPassword());


        }
        return adminrepo.save(existingGuser);
    }

    public String deleteAdmin(long id){
        adminrepo.deleteById(id);
        return "Admin Deleted - id=" +id;
    }


    @Autowired
    private MongoOperations mongoOperations;

    private long generateSequence(String seqName){
        DatabaseSequence counter =mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter)? counter.getSeq():1;
    }

}
