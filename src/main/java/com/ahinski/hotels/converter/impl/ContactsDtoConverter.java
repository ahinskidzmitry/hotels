package com.ahinski.hotels.converter.impl;

import com.ahinski.hotels.converter.DtoConverter;
import com.ahinski.hotels.dto.ContactsDto;
import com.ahinski.hotels.model.Contacts;

class ContactsDtoConverter implements DtoConverter<Contacts, ContactsDto> {

    @Override
    public ContactsDto convertToDto(Contacts entity) {
        ContactsDto contactsDto = new ContactsDto();

        contactsDto.setEmail(entity.getEmail());
        contactsDto.setPhone(entity.getPhone());

        return contactsDto;
    }

    @Override
    public Contacts convertToEntity(ContactsDto dto) {
        Contacts contacts = new Contacts();

        contacts.setEmail(dto.getEmail());
        contacts.setPhone(dto.getPhone());

        return contacts;
    }
}