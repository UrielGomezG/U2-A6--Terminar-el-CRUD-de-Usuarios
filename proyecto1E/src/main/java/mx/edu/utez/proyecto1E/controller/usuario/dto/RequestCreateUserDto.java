package mx.edu.utez.proyecto1E.controller.usuario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateUserDto {

    @NotBlank(message = "Nombre de usuario obligatorio")
    @Size(min = 4, max = 15, message = "debe tener entre 4 y 15 caracteres")
    private String username;

    @NotBlank(message = "Contraseña obligatoria")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, incluir al menos una letra y un número"
    )
    private String password;

    private String descripcion;

    @NotBlank(message = "rol obligatorio")
    @Pattern(
            regexp = "^(ADMIN|PROFESOR|ESTUDIANTE)$",
            message = "El rol debe ser ADMIN, PROFESOR o ESTUDIANTE"
    )
    private String rol;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El primer apellido es obligatorio")
    private String primerApellido;

    private String segundoApellido;

    @NotBlank(message = "El CURP es obligatorio")
    private String curp;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Formato de correo inválido")
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;
}