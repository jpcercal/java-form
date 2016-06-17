package com.cekurte.form.constraint;

import java.util.ArrayList;
import java.util.List;

import com.cekurte.form.contract.Contraint;

public class RequiredContraint implements Contraint {

    @Override
    public List<String> validate(Object data) {
        List<String> errors = new ArrayList<>();
        
        if (data instanceof String) {
            if (((String) data).isEmpty()) {
                errors.add(
                    "The field is required and can not be empty."
                );
            }
        }
        
        return errors;
    }
    
}
