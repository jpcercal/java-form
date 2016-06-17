package com.cekurte.form.contract.input;

public interface Mask {
    
    public void setMask(String mask);
    
    public String getMask();
    
    public boolean hasMask();
    
    public boolean hasMaskEquals(String mask);
}
