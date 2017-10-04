package com.tt.projectshowcase.data;

import com.tt.projectshowcase.data.local.models.User;
import com.tt.projectshowcase.data.remote.models.UserDTO;

/**
 * Created by TT on 4.10.2017..
 * ProjectShowcase
 *
 * Maps objects between various layers.
 */

public class ObjectMapper {

    public static User fromUserDTO(UserDTO userDTO){
       return new User(userDTO.getId(), userDTO.getUsername(), userDTO.getEmail());
    }
}
