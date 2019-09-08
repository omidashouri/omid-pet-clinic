package ir.omidashouri.omidpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;
}
