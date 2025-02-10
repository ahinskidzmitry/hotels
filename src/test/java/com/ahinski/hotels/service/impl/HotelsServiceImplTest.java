package com.ahinski.hotels.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ahinski.hotels.converter.DtoConverter;
import com.ahinski.hotels.converter.EntityToDtoConverter;
import com.ahinski.hotels.converter.impl.BriefHotelToDtoConverter;
import com.ahinski.hotels.converter.impl.HotelDtoConverter;
import com.ahinski.hotels.dto.AddressDto;
import com.ahinski.hotels.dto.ArrivalTimeDto;
import com.ahinski.hotels.dto.BriefHotelDto;
import com.ahinski.hotels.dto.ContactsDto;
import com.ahinski.hotels.dto.HotelDto;
import com.ahinski.hotels.exception.HotelDoesNotExistException;
import com.ahinski.hotels.model.Hotel;
import com.ahinski.hotels.repository.AmenitiesRepository;
import com.ahinski.hotels.repository.HotelsRepository;
import com.ahinski.hotels.validator.DtoValidationChain;

public class HotelsServiceImplTest {

    @Mock
    private HotelsRepository hotelsRepository;

    @Mock
    private AmenitiesRepository amenitiesRepository;

    @Mock
    private DtoConverter<Hotel, HotelDto> hotelDtoConverter;

    @Mock
    private EntityToDtoConverter<Hotel, BriefHotelDto> briefHotelDtoConverter;

    @Mock
    private DtoValidationChain dtoValidationChain;

    @InjectMocks
    private HotelsServiceImpl hotelsService;

    private List<HotelDto> hotelDtos;

    private List<BriefHotelDto> briefHotelDtos;

    private List<Hotel> hotelEntities;

    @BeforeEach
    public void setUp() {
        
        MockitoAnnotations.openMocks(this);

        hotelDtos = new ArrayList<>();
        briefHotelDtos = new ArrayList<>();
        hotelEntities = new ArrayList<>();

        HotelDto hotelDto = new HotelDto();

        hotelDto.setId(1L);
        hotelDto.setName("HotelName");
        hotelDto.setDescription("Hotel description");
        hotelDto.setBrand("Hotel brand");
        
        AddressDto addressDto = new AddressDto();
        addressDto.setHouseNumber(1);
        addressDto.setStreet("Street");
        addressDto.setCity("City");
        addressDto.setCountry("Country");
        addressDto.setPostCode("222222");
        hotelDto.setAddress(addressDto);

        ContactsDto contactsDto = new ContactsDto();
        contactsDto.setEmail("someemail@gmail.com");
        contactsDto.setPhone("+375 25 999 55 44");
        hotelDto.setContacts(contactsDto);

        ArrivalTimeDto arrivalTimeDto = new ArrivalTimeDto();
        arrivalTimeDto.setCheckIn(LocalTime.of(12, 0, 0));
        arrivalTimeDto.setCheckOut(LocalTime.of(18, 0, 0));
        hotelDto.setArrivalTime(arrivalTimeDto);

        List<String> amenities = new ArrayList<>();
        amenities.add("Fitness center");
        amenities.add("Free parking");
        amenities.add("Free WiFi");
        hotelDto.setAmenities(amenities);

        hotelDtos.add(hotelDto);

        HotelDto hotelDto2 = new HotelDto();

        hotelDto2.setId(2L);
        hotelDto2.setName("HotelName2");
        hotelDto2.setBrand("Hotel brand2");
        
        AddressDto addressDto2 = new AddressDto();
        addressDto.setHouseNumber(2);
        addressDto.setStreet("Street2");
        addressDto.setCity("City2");
        addressDto.setCountry("Country2");
        addressDto.setPostCode("555555");
        hotelDto2.setAddress(addressDto2);

        ContactsDto contactsDto2 = new ContactsDto();
        contactsDto.setEmail("someemail2@gmail.com");
        contactsDto.setPhone("+375 25 555 55 55");
        hotelDto2.setContacts(contactsDto2);

        ArrivalTimeDto arrivalTimeDto2 = new ArrivalTimeDto();
        arrivalTimeDto.setCheckIn(LocalTime.of(9, 0, 0));
        hotelDto2.setArrivalTime(arrivalTimeDto2);

        List<String> amenities2 = new ArrayList<>();
        amenities.add("Room service");
        amenities.add("Free parking");
        amenities.add("Meeting rooms");
        hotelDto2.setAmenities(amenities2);

        hotelDtos.add(hotelDto2);

        HotelDtoConverter hotelConverter = new HotelDtoConverter();
        Hotel hotel = hotelConverter.convertToEntity(hotelDto);
        Hotel hotel2 = hotelConverter.convertToEntity(hotelDto2);
        hotelEntities.add(hotel);
        hotelEntities.add(hotel2);
        BriefHotelToDtoConverter briefHotelConverter = new BriefHotelToDtoConverter();
        briefHotelDtos.add(briefHotelConverter.convertToDto(hotel));
        briefHotelDtos.add(briefHotelConverter.convertToDto(hotel2));
    }

    @Test
    void testFindAllMustReturnBriefHotelDtosList() {
        when(hotelsRepository.findAll()).thenReturn(hotelEntities);
        when(briefHotelDtoConverter.convertToDto(hotelEntities.get(0))).thenReturn(briefHotelDtos.get(0));
        when(briefHotelDtoConverter.convertToDto(hotelEntities.get(1))).thenReturn(briefHotelDtos.get(1));


        List<BriefHotelDto> briefHotelDtosList = hotelsService.findAll();

        assertNotNull(briefHotelDtosList);
        assertEquals(briefHotelDtosList.size(), hotelEntities.size());
        assertEquals(briefHotelDtosList.get(0), briefHotelDtos.get(0));
        assertEquals(briefHotelDtosList.get(1), briefHotelDtos.get(1));

        verify(hotelsRepository, times(1)).findAll();
        verify(briefHotelDtoConverter, times(2)).convertToDto(any());
    }

    @Test
    void testFindByIdMustReturnHotelForExistingHotelId() {
        when(hotelsRepository.findById(1L)).thenReturn(Optional.of(hotelEntities.get(1)));
        when(hotelDtoConverter.convertToDto(any())).thenReturn(hotelDtos.get(0));

        HotelDto hotelDto = hotelsService.findById(1L);

        assertNotNull(hotelDto);
        assertEquals(hotelDto, hotelDtos.get(0));

        verify(hotelsRepository, times(1)).findById(1L);
        verify(hotelDtoConverter, times(1)).convertToDto(any());
    }

    @Test
    void testFindByIdMustThrowExceptionForNonExistingHotelId() {
        when(hotelsRepository.findById(555L)).thenReturn(Optional.empty());
        when(hotelDtoConverter.convertToDto(any())).thenReturn(hotelDtos.get(0));

        try {
            hotelsService.findById(555L);
            fail("HotelDoesNotExistException was not thrown");
        } catch (HotelDoesNotExistException hotelDoesNotExistException) {
            assertEquals("Hotel with ID 555 does not exist", hotelDoesNotExistException.getMessage());
            verify(hotelsRepository, times(1)).findById(555L);
            verify(hotelDtoConverter, times(0)).convertToDto(any());
        }
    }

    @Test
    void testFindAllByCriteriaMustReturnBriefHotelDtosList() {
        when(hotelsRepository.findAllByCriteria("Name", "Brand", "City", "Country", Collections.emptyList())).thenReturn(hotelEntities);
        when(briefHotelDtoConverter.convertToDto(hotelEntities.get(0))).thenReturn(briefHotelDtos.get(0));
        when(briefHotelDtoConverter.convertToDto(hotelEntities.get(1))).thenReturn(briefHotelDtos.get(1));


        List<BriefHotelDto> briefHotelDtosList = hotelsService.findAllByCriteria("Name", "Brand", "City", "Country", Collections.emptyList());

        assertNotNull(briefHotelDtosList);
        assertEquals(briefHotelDtosList.size(), hotelEntities.size());
        assertEquals(briefHotelDtosList.get(0), briefHotelDtos.get(0));
        assertEquals(briefHotelDtosList.get(1), briefHotelDtos.get(1));

        verify(hotelsRepository, times(1)).findAllByCriteria("Name", "Brand", "City", "Country", Collections.emptyList());
        verify(briefHotelDtoConverter, times(2)).convertToDto(any());
    }

    @Test
    void testSaveHotelMustReturnSavedBriefHotelDto() {
        when(hotelsRepository.save(hotelEntities.get(0))).thenReturn(hotelEntities.get(0));
        when(hotelDtoConverter.convertToEntity(hotelDtos.get(0))).thenReturn(hotelEntities.get(0));
        when(briefHotelDtoConverter.convertToDto(hotelEntities.get(0))).thenReturn(briefHotelDtos.get(0));


        BriefHotelDto briefHotelDto = hotelsService.save(hotelDtos.get(0));

        assertNotNull(briefHotelDto);
        assertEquals(briefHotelDto, briefHotelDtos.get(0));

        verify(hotelsRepository, times(1)).save(hotelEntities.get(0));
        verify(briefHotelDtoConverter, times(1)).convertToDto(any());
        verify(hotelDtoConverter, times(1)).convertToEntity(any());
    }

    @Test
    void testCountByParameterMustReturnMapWithCorrectParamAndNumber() {
        List<Object[]> data = new ArrayList<>();
        Object[] objects = new Object[] { "brand", 5 };
        data.add(objects);
        when(hotelsRepository.countByBrand()).thenReturn(data);

        Map<String, Long> countedParamMap = hotelsService.countByParameter("brand");

        assertNotNull(countedParamMap);
        assertEquals(countedParamMap.get("brand"), 5L);

        verify(hotelsRepository, times(1)).countByBrand();
    }
}
