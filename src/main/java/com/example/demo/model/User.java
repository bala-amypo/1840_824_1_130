package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalDate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Set;
    @Entity
    public class User{
         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         private Long id;
         private String name;
         private String email;
         private String password;
         private Set<String> roles;
         private LocalDateTime createdAt;

         public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }
         public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public String getPassword(){
            return password;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public Set<String> getRoles(){
            return roles;
        }
        public void setRoles(Set<String> roles){

            this.roles = roles;
        }
         public LocalDateTime getCreatedAt(){
             return createdAt;
        }
        public void  setCreatedAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
        }
        public User(Long id,String name,String email,String password,Set<String> roles,LocalDateTime createdAt){
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.roles = roles;
            this.createdAt = createdAt;
        }
        public User(){
            
        }
 
    }