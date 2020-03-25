package store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.model.Name;
import store.repository.NameRepository;

import java.util.List;

@Component
class Store {

    @Autowired
    NameRepository nameRepository;

    public void out() {
        List<Name> names = (List<Name>) nameRepository.findAll();
        for (Name name: names) {
            System.out.println(name);
        }
    }

    public void add(Name name) {
        nameRepository.save(name);
    }

    //    @Autowired
//    private List<Name> names = new ArrayList<>();
//
//    void out(){
//        for (Name name: names) {
//            System.out.println(name);
//        }
//    }
//
//    void add(Name name){
//        names.add(name);
//    }
}
