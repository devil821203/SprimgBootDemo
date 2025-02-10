package org.example.trouble.demo.Entities.db1;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "db1",name = "table2")
@Data
@NoArgsConstructor
public class table2Entity {

    @Id
    @Column(name = "id")
    @NotNull
    Integer id;
    @Column(name = "name")
    String name;


}
