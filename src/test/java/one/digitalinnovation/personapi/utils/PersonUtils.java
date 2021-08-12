package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils
{
    private static final String FIRST_NAME = "Vinicius";
    private static final String LAST_NAME = "Cortez";
    private static final String CPF_NUMBER = "079.997.350-51";
    private static final String EMAIL = "teste@gmail.com";
    private static final String STATE = "MG";
    private static final String CITY = "cidade";
    private static final String ZIPCODE = "37950-000";
    private static final String DISTRICT = "bairro";
    private static final String ROAD = "rua";
    private static final int NUMBER = 1;
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1997, 03, 9);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .email(EMAIL)
                .state(STATE)
                .city(CITY)
                .zipcode(ZIPCODE)
                .district(DISTRICT)
                .road(ROAD)
                .number(NUMBER)
                .birthDate("09-03-1997")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

}
