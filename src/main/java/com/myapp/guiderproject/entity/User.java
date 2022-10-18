package com.myapp.guiderproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    // GenerationType is very important
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "user_rating", nullable = false)
    private double rating;

    @Column(name = "user_publications", nullable = false)
    private int publications;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UserCredentials userCredentials;

    // empty constructor for JPA specification
    public User() {

    }

    public User(String username, double rating, int publications) {
        this.username = username;
        this.rating = rating;
        this.publications = publications;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                ", publications=" + publications +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.rating, rating) == 0 && publications == user.publications && id.equals(user.id) && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, rating, publications);
    }
}