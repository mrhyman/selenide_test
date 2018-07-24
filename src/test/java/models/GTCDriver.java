package models;

public class GTCDriver {
    private String email;
    private String mobileId;
    private String fullName;
    private String address;
    private boolean useDepotAddress;

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
}
