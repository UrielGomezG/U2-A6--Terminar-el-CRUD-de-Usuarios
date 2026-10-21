package mx.edu.utez.proyecto1E.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResponseCalculadoraDTO {

    private int respuesta;
    private String operacionRealizada;

}
