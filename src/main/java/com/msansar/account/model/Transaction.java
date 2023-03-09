package com.msansar.account.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transaction")
public class Transaction extends BaseEntity{

    private TransactionType transactionType = TransactionType.INITIAL;
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction(BigDecimal amount, LocalDateTime creationDate, Account account){
        super(creationDate);
        this.amount = amount;
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Transaction that = (Transaction) o;

        if (transactionType != that.transactionType) return false;
        if (!amount.equals(that.amount)) return false;
        return account.equals(that.account);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + transactionType.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + account.hashCode();
        return result;
    }
}
