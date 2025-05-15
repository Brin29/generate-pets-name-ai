package brien.pets_name.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "user_first_name")
    private String firstName;

    @Column(nullable = false, name = "user_last_name")
    private String lastName;

    @Column(nullable = false, name = "email", unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

}