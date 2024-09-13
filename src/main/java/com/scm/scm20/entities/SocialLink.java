package com.scm.scm20.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "social_link")
public class SocialLink {

    @Id
    private Long id;
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;
}
