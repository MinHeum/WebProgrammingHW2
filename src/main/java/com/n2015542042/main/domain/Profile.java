package com.n2015542042.main.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Table
@Entity
public class Profile implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String username;

    @Column
    private String url;

    @Column
    private LocalDateTime createdat;

    @Builder
    public Profile(String network, String username, String url, LocalDateTime createdat) {
        this.network = network;
        this.username = username;
        this.url = url;
        this.createdat = createdat;
    }

    public void setCreateDateNow() {
        this.createdat = LocalDateTime.now();
    }

    public void update(Profile profile) {
        this.network = profile.getNetwork();
        this.username = profile.getUsername();
        this.url = profile.getUrl();
        this.createdat = profile.getCreatedat();
    }
}
