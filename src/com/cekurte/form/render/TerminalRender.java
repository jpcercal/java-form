package com.cekurte.form.render;

import java.io.PrintStream;
import java.util.Scanner;

import com.cekurte.form.contract.Field;
import com.cekurte.form.contract.Form;

public class TerminalRender implements Runnable {
    
    private Scanner input;
    
    private PrintStream output;
    
    private Form form;
    
    public TerminalRender(Form form) {
        this.form   = form;
        this.input  = new Scanner(System.in);
        this.output = System.out;
    }

    @Override
    public void run() {
        for (Field field : form.getFields()) {
            if (field.isHidden() || field.isDisabled()) {
                continue;
            }
            
            String data = null;
            
            while (!field.isValid()) {
                
                field.clearValidationErrors();
                
                output.print(field.getLabel());
                
                if (field.isFilled()) {
                    output.print(" [" + field.getData() + "]: ");
                } else {
                    output.print(": ");
                }
                
                data = input.nextLine();
                field.setData(data);
                
                for (String error : field.getValidationErrors()) {
                    output.println(error);
                }
            };
        }
    }
    
}
