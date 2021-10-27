package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rostertwo.springcorebooking.SimpleUser;

/**
 * Created by maksym_govorischev on 14/03/14.
 */
@JsonDeserialize(as = SimpleUser.class)
public interface User {
    /**
     * User Id. UNIQUE.
     * @return User Id.
     */
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);

    /**
     * User email. UNIQUE.
     * @return User email.
     */
    String getEmail();
    void setEmail(String email);
}
