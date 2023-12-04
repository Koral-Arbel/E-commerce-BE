    package com.ecommerce.ecommerce.model;

    public class CustomUser {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String fullAddress;
        private String username;
        private String password;
        private int active;
        private String roles = "";
        private String permissions = "";

        public CustomUser(Long id, String firstName, String lastName, String email, String phone, String fullAddress, String username, String password, String roles, String permissions) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.fullAddress = fullAddress;
            this.username = username;
            this.password = password;
            this.roles = roles;
            this.permissions = permissions;
            this.active = 1;
        }

        public Long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getFullAddress() {
            return fullAddress;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public int getActive() {
            return active;
        }

        public String getRoles() {
            return roles;
        }

        public String getPermissions() {
            return permissions;
        }
    }