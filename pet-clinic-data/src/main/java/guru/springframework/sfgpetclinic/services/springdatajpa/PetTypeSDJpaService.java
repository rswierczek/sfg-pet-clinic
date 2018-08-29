package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepositry;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepositry petTypeRepositry;

    public PetTypeSDJpaService(PetTypeRepositry petTypeRepositry) {
        this.petTypeRepositry = petTypeRepositry;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepositry.findById(id).orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepositry.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepositry.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepositry.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepositry.deleteById(id);
    }
}
