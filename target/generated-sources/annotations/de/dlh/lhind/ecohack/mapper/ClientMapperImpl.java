package de.dlh.lhind.ecohack.mapper;

import de.dlh.lhind.ecohack.model.dto.ClientDto;
import de.dlh.lhind.ecohack.model.entity.Client;
import de.dlh.lhind.ecohack.model.entity.User;
import de.dlh.lhind.ecohack.util.mapper.MappingUtil;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-23T10:36:36+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto clientToDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setUsername( clientUserEmail( client ) );
        clientDto.setPassword( clientUserPassword( client ) );
        clientDto.setId( client.getId() );
        clientDto.setName( client.getName() );
        clientDto.setSurname( client.getSurname() );
        clientDto.setLatitude( client.getLatitude() );
        clientDto.setLongtitude( client.getLongtitude() );
        clientDto.setPaymentMethod( MappingUtil.paymentMethodToString( client.getPaymentMethod() ) );
        clientDto.setRankingPoints( client.getRankingPoints() );

        return clientDto;
    }

    @Override
    public Client dtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setUser( clientDtoToUser( clientDto ) );
        client.setId( clientDto.getId() );
        client.setName( clientDto.getName() );
        client.setSurname( clientDto.getSurname() );
        client.setLatitude( clientDto.getLatitude() );
        client.setLongtitude( clientDto.getLongtitude() );
        client.setRankingPoints( clientDto.getRankingPoints() );
        client.setPaymentMethod( MappingUtil.mapStringToPaymentMethod( clientDto.getPaymentMethod() ) );

        return client;
    }

    private String clientUserEmail(Client client) {
        if ( client == null ) {
            return null;
        }
        User user = client.getUser();
        if ( user == null ) {
            return null;
        }
        String email = user.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private String clientUserPassword(Client client) {
        if ( client == null ) {
            return null;
        }
        User user = client.getUser();
        if ( user == null ) {
            return null;
        }
        String password = user.getPassword();
        if ( password == null ) {
            return null;
        }
        return password;
    }

    protected User clientDtoToUser(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( clientDto.getUsername() );
        user.setPassword( clientDto.getPassword() );

        return user;
    }
}
