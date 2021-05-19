package nhat.com.vicinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "cinema")
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Cinema(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        address.setCinema(this);
        addresses.add(address);
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        room.setCinema(this);
        rooms.add(room);
    }

}
