package com.msansar.account.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customer")
public class Customer extends BaseEntity{
    private String name;
    private String surname;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();

    public Customer(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Customer(String id, LocalDateTime createdAt, String name, String surname, Set<Account> accounts){
        super(id, createdAt);
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        if (!name.equals(customer.name)) return false;
        if (!surname.equals(customer.surname)) return false;
        return Objects.equals(accounts, customer.accounts);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }
}
