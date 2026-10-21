package mx.edu.utez.proyecto1E.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1E.controller.dtos.RequestBodyDTO;
import mx.edu.utez.proyecto1E.controller.dtos.RequestCalculadoraDTO;
import mx.edu.utez.proyecto1E.controller.dtos.ResponseCalculadoraDTO;
import mx.edu.utez.proyecto1E.service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"}) // permitir cualquier origen
@RequestMapping("/my-services")
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping
    public String miPrimerServicio(){

        return "Hello World!";

    }

    @GetMapping("/segundo")
    public String segundoServicio(){
        return "Esto es el servicio 2";
    }

    @PostMapping
    public String tercerServicio(){
        return "tercero";
    }

    @GetMapping("/path/{id}")
    public String pathVariable(@PathVariable String id){
        return "path variable: " + id;
    }

    @PostMapping("/body")
    public ResponseEntity<RequestBodyDTO> body(@RequestBody @Valid RequestBodyDTO payload){

        System.out.println(payload.getNombre());
        System.out.println(payload.getEdad());
        System.out.println(payload.getCurp());
        System.out.println(payload.getCorreo());

        return ResponseEntity.status(201).body(payload);
    }

    @PostMapping("/calculadora")
    public ResponseEntity<ResponseCalculadoraDTO> calculadora(@RequestBody @Valid RequestCalculadoraDTO payload){

        return ResponseEntity
                .status(200)
                .body(
                        myService.calculadora(payload)
                );

    }

}
