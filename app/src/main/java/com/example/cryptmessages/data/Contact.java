package com.example.cryptmessages.data;

import java.util.Set;

public class Contact  extends BaseEntity{
    private String name;
    private Set<Massage> massages;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Massage> getMassages() {
        return massages;
    }

    public void setMassages(Set<Massage> massages) {
        this.massages = massages;
    }

}
