package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

public class RoleVo implements Serializable {
    private List<Role> role;
    private Integer total;

    public List<Role> getRole(){
        return this.role;
    }
    public Integer getTotal() {
        return this.total;
    }
    public RoleVo(List<Role> role_obj, Integer Total){
        this.role = role_obj;
        this.total = Total;
    }
}
