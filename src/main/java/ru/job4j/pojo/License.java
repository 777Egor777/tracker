package ru.job4j.pojo;

import java.util.Date;

public class License {
    private String owner;
    private String model;
    private String code;
    private Date created;

    public License(String owner, String model, String code, Date created) {
        this.owner = owner;
        this.model = model;
        this.code = code;
        this.created = created;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    private boolean eq(Object a, Object b) {
        boolean result = true;
        if (a != b) {
            if (a == null || !a.equals(b)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = true;
        if (this != obj) {
            if (obj == null || obj.getClass() != this.getClass()) {
                result = false;
            } else {
                License license = (License) obj;
                result = eq(this.model, license.getModel()) &&
                        eq(this.owner, license.getOwner()) &&
                        eq(this.code, license.getCode()) &&
                        eq(this.created, license.getCreated());
            }
        }
        return result;
    }
}
