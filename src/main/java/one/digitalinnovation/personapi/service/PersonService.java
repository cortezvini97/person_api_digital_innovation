package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonalNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService
{
    private final PersonRepository repository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    public MessageResponseDTO create(@RequestBody PersonDTO personDTO)
    {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = repository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Person successfully created with ID ");
    }

    public List<PersonDTO> listAll()
    {
        List<Person> allPeople = repository.findAll();

        return allPeople
                .stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonalNotFoundException {
       Person person = verefyIfExists(id);

        return personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonalNotFoundException {
       verefyIfExists(id);
        repository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonalNotFoundException {
        verefyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person personUpdate = repository.save(personToUpdate);
        return createMessageResponse(personUpdate.getId(), "Person successfully updated with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String message)
    {
        return MessageResponseDTO.builder().message(message + id).build();
    }

    private Person verefyIfExists (Long id) throws PersonalNotFoundException
    {
        return repository.findById(id).orElseThrow(() -> new PersonalNotFoundException(id));
    }
}
