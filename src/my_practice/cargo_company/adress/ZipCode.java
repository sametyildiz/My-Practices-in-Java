package my_practice.cargo_company.adress;

import java.util.Objects;

public record ZipCode(int zipCode, String city, String state, String neighborhood) {
    @Override
    public String toString() {
        return  "Zip Code     : " + zipCode + '\n' +
                "City         : " + city + '\n' +
                "State        : " + state + '\n' +
                "Neighborhood : " + neighborhood ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZipCode)) return false;
        ZipCode zipCode1 = (ZipCode) o;
        return zipCode == zipCode1.zipCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode);
    }
}
