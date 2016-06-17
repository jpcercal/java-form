package com.cekurte.form.field;

import com.cekurte.form.constraint.EmailContraint;
import com.cekurte.form.contract.Field;

public class EmailField extends GenericField implements Field {
    
    public EmailField()
    {
        super();
        this.addContraint(new EmailContraint());
    }
    
}
