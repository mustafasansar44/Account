package com.msansar.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account")
public class Account extends BaseEntity{
        private BigDecimal balance = BigDecimal.ZERO;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "customer_id", nullable = false)
        private Customer customer;

        @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private Set<Transaction> transaction = new HashSet<>();

        public Account(Customer customer, BigDecimal balance, LocalDateTime creationDate){
                super(creationDate);
                this.customer = customer;
                this.balance = balance;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;

                Account account = (Account) o;

                if (!balance.equals(account.balance)) return false;
                if (!customer.equals(account.customer)) return false;
                return Objects.equals(transaction, account.transaction);
        }

        @Override
        public int hashCode() {
                int result = super.hashCode();
                result = 31 * result + balance.hashCode();
                result = 31 * result + customer.hashCode();
                return result;
        }
}
