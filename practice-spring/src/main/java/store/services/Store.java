package store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.model.Name;
import store.repository.NameRepository;

import java.util.Set;

@Component
class Store {

    @Autowired
    NameRepository nameRepository;

    public Set<Name> out() {
        return (Set<Name>)nameRepository.findAll();
    }

    public void add(Name name) {
        nameRepository.save(name);
    }
}
