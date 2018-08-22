package models;

public class GTCDriver {
    private int id;
    private String email;
    private String mobileId;
    private String fullName;
    private String address;
    private boolean useDepotAddress;

    private boolean isLoggedIn = false;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getUseDepotAddress() {
        return useDepotAddress;
    }

    public void setUseDepotAddress(boolean useDepotAddress) {
        this.useDepotAddress = useDepotAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUseDepotAddress() {
        return useDepotAddress;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
