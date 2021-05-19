package nhat.com.vicinema.model;

//import java.beans.Transient;
import java.sql.Date;
import java.util.ArrayList;
//import java.time.LocalDate;
//import java.time.Period;
//import java.time.ZoneId;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "customer")
@Table(name = "customer")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String mobile;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "sex")
    private Boolean sex;

    // @Transient
    // private int age;

    // public int getAge() {
    // Date safeDate = new Date(birthday.getTime());
    // LocalDate birthDayInLocalDate =
    // safeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    // return Period.between(birthDayInLocalDate, LocalDate.now()).getYears();
    // }

    public Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    @OneToMany(mappedBy = "customer")
    private List<Order> order = new ArrayList<>();

}
