package domashka.module1_2;

class Admin extends User {
    @Override
    public String getRole() {
        return "domashka.module1_2.Admin";
    }
}