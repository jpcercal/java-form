package com.cekurte.form;

import java.util.ArrayList;
import java.util.List;

import com.cekurte.form.contract.Field;
import com.cekurte.form.contract.Form;

public class GenericForm implements Form {

    List<Field> fields;
    
    public GenericForm()
    {
        this.fields = new ArrayList<Field>();
    }

    @Override
    public boolean isValid() {
        for (Field field : fields) {
            if (!field.isValid()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Field getFieldById(String id) {
        for (Field field : fields) {
            if (!field.hasIdEquals(id)) {
                return field;
            }
        }
        
        return null;
    }

    @Override
    public List<Field> getFields() {
        return fields;
    }

    @Override
    public boolean addField(Field field) {
        return fields.add(field);
    }

    @Override
    public boolean removeField(Field field) {
        return fields.remove(field);
    }

    @Override
    public boolean isSubmitted() {
        for (Field field : fields) {
            if (!field.isSubmitted()) {
                return false;
            }
        }
        
        return true;
    }
}
