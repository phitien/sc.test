package com.app.models;

import com.app.calculators.CalculatorFactory;
import com.app.calculators.ICalculator;
import com.app.exceptions.CalculatorNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phitien on 8/12/16.
 */
@Entity
public class Product<T extends ICalculator> {

    Class<T> calculatorClass;
    T calculator;

    Long id;
    Product parent = null;
    List<Product> children = new ArrayList<Product>();
    Float price = Float.valueOf(0);
    Boolean free = false;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    public Product getParent() {
        return parent;
    }

    public void setParent(Product parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    public List<Product> getChildren() {
        return children;
    }

    public void setChildren(List<Product> children) {
        this.children = children;
    }

    @Column
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column
    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Class<T> getCalculatorClass() {
        return calculatorClass;
    }

    public void setCalculatorClass(Class<T> calculatorClass) throws CalculatorNull {
        this.calculatorClass = calculatorClass;
        try {
            this.calculator = calculatorClass.newInstance();
        } catch (Exception e) {
            throw new CalculatorNull();
        }
    }

    public Float calculatePrice() {
        if (children.size() > 0) {
            Float price = Float.valueOf(0);
            for (Product child : children) {
                price += child.calculatePrice();
            }
            return price;
        }

        return calculator != null ? calculator.calculate(this) : getPrice();
    }
}
