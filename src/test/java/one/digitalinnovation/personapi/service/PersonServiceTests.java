package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTests
{
    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage()
    {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();



        Mockito.when(repository.save(ArgumentMatchers.any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());

        MessageResponseDTO successMessage = service.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);

    }

    private MessageResponseDTO createExpectedSuccessMessage(Long id)
    {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + id)
                .build();
    }
}
