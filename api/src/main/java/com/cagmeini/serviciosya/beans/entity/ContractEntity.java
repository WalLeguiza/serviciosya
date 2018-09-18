package com.cagmeini.serviciosya.beans.entity;

import org.hibernate.type.CalendarType;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity (name = "Contract")
@Table (name = "contract")
public class ContractEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn (name = "provider_id")
    private ProviderEntity provider;

    @ManyToOne
    @JoinColumn (name = "consumer_id")
    private ConsumerEntity consumer;

    @Column (name = "date", nullable = false)
    private GregorianCalendar date;

    @Column (name = "amount", nullable = false)
    private double amount;

    @Column (name = "status", nullable = false)
    private int status;

    /**
     *
     *
     * <p>Constructor without arguments</p>
     */
    public ContractEntity() {

        super ();
    }

    /**
     *
     *
     * <p>Constructor with arguments</p>
     */
    public ContractEntity(int id, ProviderEntity provider, ConsumerEntity consumer,
                          GregorianCalendar date, double amount, int status) {
        this.id = id;
        this.provider = provider;
        this.consumer = consumer;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProviderEntity getProvider() {
        return provider;
    }

    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
    }

    public ConsumerEntity getConsumer() {
        return consumer;
    }

    public void setConsumer(ConsumerEntity consumer) {
        this.consumer = consumer;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Contract: " +
                "provider= " + provider +
                ", consumer= " + consumer;
    }
}
