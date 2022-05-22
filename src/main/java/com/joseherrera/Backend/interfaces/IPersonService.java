
package com.joseherrera.Backend.interfaces;

import com.joseherrera.Backend.model.PersonModel;
import java.util.Map;

public interface IPersonService {
    public PersonModel getPerson(int authId);
    public void updatePerson(PersonModel person);
}
