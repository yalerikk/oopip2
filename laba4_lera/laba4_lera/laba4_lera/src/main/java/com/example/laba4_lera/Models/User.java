package com.example.laba4_lera.Models;

public class User {
        private static String passwordU;
        private static String loginU ;

        public User(String loginU, String passwordU){
            this.passwordU = passwordU;
            this.loginU = loginU;
        }

        public String getPasswordU() {
            return passwordU;
        }

        public String getLoginU() {
            return loginU;
        }

}
