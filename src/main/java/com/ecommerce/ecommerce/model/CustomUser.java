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
            this.active = 1;
            this.roles = roles;
            this.permissions = permissions;
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

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setFullAddress(String fullAddress) {
            this.fullAddress = fullAddress;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setActive(int active) {
            this.active = active;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public void setPermissions(String permissions) {
            this.permissions = permissions;
        }
    }