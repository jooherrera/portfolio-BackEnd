
package com.joseherrera.Backend.interfaces;

import com.joseherrera.Backend.model.ContactModel;

public interface IContactService {
    public ContactModel getContact(int dni);
    public void updateContact(ContactModel contact);
}
