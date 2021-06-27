package com.gvendas.gestaovendas.controlador;


import com.gvendas.gestaovendas.dto.cliente.ClienteResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.servico.ClienteServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    private ClienteServico clienteServico;

    @ApiOperation(value = "Listar", nickname = "listarTodosClientes")
    @GetMapping
    public List<ClienteResponseDTO> listarTodos(){

        return clienteServico.listarTodos().stream()
                .map(cliente -> ClienteResponseDTO.converterParaClienteDTO(cliente))
                .collect(Collectors.toList());
    }


    @ApiOperation(value = "Listar", nickname = "buscarClientePorId")
    @GetMapping("/{codigo}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long codigo) {
        Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigo);
        return cliente.isPresent() ? ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(cliente.get()))
                : ResponseEntity.notFound().build();
    }

}
