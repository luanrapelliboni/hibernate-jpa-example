package br.com.playground.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@ToString(includeFieldNames = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "users")
public class User extends BaseEntity {
    private String name;
    private Double salary;
}
