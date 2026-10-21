package mx.edu.utez.proyecto1E.model.cursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private int noUnidades;
}
