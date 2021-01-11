package domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User {
        private String userName;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        @Transient
        private List<Shelf> shelves;
        private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Long id;

    @OneToMany
    private Collection<Story> stories;

    public User(String userName, String firstName, String lastName, String password, String email, Role role) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String userName, String firstName, String lastName, String password, String email, Role role, List<Shelf> shelves, Collection<Story> stories) {
        this(userName, firstName, lastName, password, email,role);
        this.shelves = shelves;
        this.stories = stories;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<Story> getStories() {
        return stories;
    }

    public void setStories(Collection<Story> stories) {
        this.stories = stories;
    }

    @Override
    public String toString() {
        return " Username: " + this.userName +
                ", First Name: " + this.firstName  +
                ", Last Name: " + this.lastName +
                ", Password: " + this.password +
                ", Email: " + this.email +
                ", Role: '" + this.role +
                ", Collection of Shelfs: " + this.shelves ;
    }

    public String getShortInfo() {
        return "First name: " + this.firstName + '\''
                + ", Last Name:" + this.lastName;
    }
}

