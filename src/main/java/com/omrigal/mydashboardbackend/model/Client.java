package com.omrigal.mydashboardbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "email", length = 20, nullable = false, unique = true)
    private String email;

    @Column(name = "is_online")
    private Boolean isOnline = false;

    @Column(name = "login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(name = "ip", length = 20)
    private String ip;

    @Column(name = "register_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;

    @Column(name = "login_count", nullable = false)
    private Long loginCount;

    public Client(ClientRegisterRequest request) {
        this.username = request.getUsername();
        this.password = request.getPassword();
        this.email = request.getEmail();
        Date currentTime = new Date(System.currentTimeMillis());
        this.lastUpdated = currentTime;
        this.registerTime = currentTime;
        this.loginCount = 0L;
        this.isOnline = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
