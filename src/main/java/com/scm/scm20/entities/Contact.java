package com.scm.scm20.entities;


import jakarta.persistence.*;

import java.util.*;

@Entity
public class Contact {

        @Id
        private String id;
        private String name;
        private  String email;
        private String phoneNumber;
        private String address;
        private String pictures;

        @Column(length = 10000)
        private String description;
        private boolean favorite = false;
        private  String webSiteLinks;
        private String linkedInLink;
       // private List<String> socialLinkList=new ArrayList<>();

        @ManyToOne
       private User user;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SocialLink> links=new ArrayList<>();
}
