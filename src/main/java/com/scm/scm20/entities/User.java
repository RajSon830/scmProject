package com.scm.scm20.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
 @Builder
public class User {

       @Id
        private String userId;

       @Column(name = "user_name",nullable = false)
       private String name;

       @Column(unique = true,nullable = false)
        private String email;


        private String password;

       @Column(length = 10000)
        private String about;

        private String profilePic;

        private boolean enable=false;
        private boolean emailVerified =  false;
        private boolean phoneVerified = false;

        private Providers provider=Providers.SELF;
        private String providerUserId;

         @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
        private List<Contact> contactList=new ArrayList<>();



}
