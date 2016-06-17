package com.cekurte.form.contract;

import java.util.List;

import com.cekurte.form.contract.input.Disabled;
import com.cekurte.form.contract.input.Hidden;
import com.cekurte.form.contract.input.Id;
import com.cekurte.form.contract.input.Mask;
import com.cekurte.form.contract.input.Required;
import com.cekurte.form.contract.input.Submitted;
import com.cekurte.form.contract.input.Validation;

public interface Field extends 
    Disabled, 
    Hidden, 
    Id, 
    Mask,
    Required,
    Submitted,
    Validation
{
    public void addContraint(Contraint constraint);
    
    public void setConstraints(List<Contraint> contraints);
    
    public void setLabel(String label);
    
    public String getLabel();
    
    public boolean hasLabel();
    
    public void setData(String string);
    
    public String getData();
    
    public boolean isFilled();
    
    public boolean validate(Object data);
    
    public void addValidationError(String error);

    public void clearValidationErrors();
    
    public void setValidationErrors(List<String> errors);
    
    public List<String> getValidationErrors();
}
