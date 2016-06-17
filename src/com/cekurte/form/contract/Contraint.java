package com.cekurte.form.contract;

import java.util.List;

public interface Contraint {
    public List<String> validate(Object data);
}
