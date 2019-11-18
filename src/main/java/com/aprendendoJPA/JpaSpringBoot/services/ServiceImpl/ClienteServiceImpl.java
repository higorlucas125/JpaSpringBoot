package com.aprendendoJPA.JpaSpringBoot.services.ServiceImpl;


import com.aprendendoJPA.JpaSpringBoot.domain.Cliente;
import com.aprendendoJPA.JpaSpringBoot.repositories.ClienteRepository;
import com.aprendendoJPA.JpaSpringBoot.services.ClienteService;
import exception.ObjectNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;


@Service
public class ClienteServiceImpl implements ClienteService {

    private static final Logger logg = Logger.getLogger( ClienteServiceImpl.class );

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente findId( Integer id ) {

        Optional< Cliente > ops = clienteRepository.findById( id );
        Supplier<ObjectNotFoundException> objectNotFoundExceptionSupplier = () -> new ObjectNotFoundException("Objeto não encontrado ! " + id + " , Tipo " + Cliente.class.getName());
        try {
            return ops.orElseThrow(objectNotFoundExceptionSupplier);
        } catch ( Exception e ) {
            logg.error( "Cliente não foi cadastrado ainda ", e );
        }
        return ops.orElseThrow(objectNotFoundExceptionSupplier);
    }
}
