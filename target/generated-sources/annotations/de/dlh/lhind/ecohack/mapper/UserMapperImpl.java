package de.dlh.lhind.ecohack.mapper;

import de.dlh.lhind.ecohack.exception.custom.UnAuthorizedException;
import de.dlh.lhind.ecohack.model.dto.UserDto;
import de.dlh.lhind.ecohack.model.entity.User;
import de.dlh.lhind.ecohack.util.mapper.MappingUtil;
import javax.annotation.processing.Generated;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-23T14:27:36+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userDetailsToUserDto(UserDetails userDetails) throws UnAuthorizedException {
        if ( userDetails == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setRole( MappingUtil.mapAuthoritiesToRole( userDetails.getAuthorities() ) );
        userDto.setUsername( userDetails.getUsername() );
        userDto.setPassword( userDetails.getPassword() );

        return userDto;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUsername( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setRole( MappingUtil.mapRoleToString( user.getRole() ) );

        return userDto;
    }

    @Override
    public User userDtoToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setRole( MappingUtil.mapStringToRole( userDto.getRole() ) );

        return user;
    }
}
