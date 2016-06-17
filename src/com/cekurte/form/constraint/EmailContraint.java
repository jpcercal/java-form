package com.cekurte.form.constraint;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.cekurte.form.contract.Contraint;

public class EmailContraint implements Contraint {

    @Override
    public List<String> validate(Object data) {
        List<String> errors = new ArrayList<>();
        
        if (data instanceof String) {
            try {
                InternetAddress emailAddr = new InternetAddress((String) data);
                emailAddr.validate();
             } catch (AddressException e) {
                 errors.add(
                     e.getMessage()
                 );
             }
        }
        
        return errors;
    }
    
}
