package com.cekurte.form.contract;

import java.util.List;

import com.cekurte.form.contract.input.Submitted;
import com.cekurte.form.contract.input.Validation;

public interface Form extends Submitted, Validation {
    
    public Field getFieldById(String id);
    
    public List<Field> getFields();
    
    public boolean addField(Field field);
    
    public boolean removeField(Field field);
}
