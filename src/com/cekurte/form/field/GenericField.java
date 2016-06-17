package com.cekurte.form.field;

import java.util.ArrayList;
import java.util.List;

import com.cekurte.form.constraint.RequiredContraint;
import com.cekurte.form.contract.Contraint;
import com.cekurte.form.contract.Field;

public class GenericField implements Field {
    
    protected boolean hidden;
    
    protected boolean disabled;
    
    protected String id;
    
    protected String mask;
    
    protected List<String> errors;
    
    protected List<Contraint> contraints;
    
    protected String label;
    
    protected String data;

    protected boolean submitted;
    
    public GenericField() {
        this.setHidden(false);
        this.setDisabled(false);
        this.setId(new String());
        this.setMask(new String());
        this.clearValidationErrors();
        this.contraints = new ArrayList<>();
        this.setLabel(new String());
        this.setData(new String());
        this.submitted = false;
    }

    @Override
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public boolean isHidden() {
        return this.hidden;
    }

    @Override
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public boolean isDisabled() {
        return this.disabled;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean hasId() {
        return !this.id.isEmpty();
    }

    @Override
    public boolean hasIdEquals(String id) {
        return this.id.equals(id);
    }

    @Override
    public void setMask(String mask) {
        this.mask = mask;
    }

    @Override
    public String getMask() {
        return this.mask;
    }
    
    @Override
    public boolean hasMask() {
        return !this.mask.isEmpty();
    }

    @Override
    public boolean hasMaskEquals(String mask) {
        return this.mask.equals(mask);
    }

    @Override
    public void addValidationError(String error) {
        this.errors.add(error);
    }

    @Override
    public void clearValidationErrors() {
        this.errors = new ArrayList<>();
    }
    
    @Override
    public void setValidationErrors(List<String> errors) {
        this.errors.addAll(errors);
    }

    @Override
    public List<String> getValidationErrors() {
        return this.errors;
    }

    @Override
    public boolean isValid() {
        return this.errors.isEmpty() && this.isSubmitted();
    }

    @Override
    public boolean isRequired() {
        for (Contraint contraint : contraints) {
            if (contraint instanceof RequiredContraint) {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public void addContraint(Contraint constraint) {
        this.contraints.add(constraint);
    }
    
    @Override
    public void setConstraints(List<Contraint> contraints) {
        this.contraints.addAll(contraints);
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
    
    @Override
    public boolean hasLabel() {
        return !this.label.isEmpty();
    }
    
    @Override
    public void setData(String data) {
        if (data.isEmpty() && this.isFilled()) {
            this.validate(this.data);
        } else {
            this.validate(data);
            this.data = data;
        }
        
        this.submitted = true;
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public boolean isFilled() {
        if (this.data == null) {
            return false;
        }
        
        return !this.data.isEmpty();
    }
    
    @Override
    public boolean isSubmitted() {
        return this.submitted;
    }

    @Override
    public boolean validate(Object data) {
        this.clearValidationErrors();
        
        for (Contraint contraint : this.contraints) {
            List<String> constraintErrors = contraint.validate(data);
            
            for (String error : constraintErrors) {
                this.addValidationError(error);
            }
        }
        
        return this.isValid();
    }
}
