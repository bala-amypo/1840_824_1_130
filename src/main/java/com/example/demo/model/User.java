package com.example.demo.model;
    public class User{
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

    }