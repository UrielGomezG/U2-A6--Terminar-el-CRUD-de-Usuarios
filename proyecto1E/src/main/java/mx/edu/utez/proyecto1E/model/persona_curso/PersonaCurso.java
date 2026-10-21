package mx.edu.utez.proyecto1E.model.persona_curso;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1E.model.cursos.Curso;
import mx.edu.utez.proyecto1E.model.persona.Persona;

import java.time.LocalDate;

@Entity
@Table(name = "personas_curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PersonaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double calificacion;
    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

     @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
