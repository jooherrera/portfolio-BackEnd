
package com.joseherrera.Backend.interfaces;

import com.joseherrera.Backend.model.PersonModel;

public interface IPersonService {
    public PersonModel getPerson(int authId);
}
