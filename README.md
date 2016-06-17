# Form

[![license](https://img.shields.io/github/license/jpcercal/java-form.svg?style=square)](https://github.com/jpcercal/java-form)

- A simple form library to use in your console application (I create this library to learn the concepts of a Java Console Application).

Note that I'm not a Java developer, so keep a calm if something looks like wrong for you and contact me opening an issue. Hey, give a star **=)**.

## Documentation

But, how to use this library? Well, you must add the binaries to your project. Next,
you must create an instance of `com.cekurte.form.GenericForm`, so you must
add your fields (initially this library have two fields, the `com.cekurte.form.field.TextField` and the `com.cekurte.form.field.EmailField`. Let's see an example of it.

```java
import com.cekurte.form.GenericForm;
import com.cekurte.form.constraint.RequiredContraint;
import com.cekurte.form.contract.Field;
import com.cekurte.form.contract.Form;
import com.cekurte.form.field.EmailField;
import com.cekurte.form.field.TextField;
import com.cekurte.form.render.TerminalRender;

public class Test {

    public static void main(String[] args) {
        Form form = new GenericForm();

        Field name = new TextField();
        name.setLabel("Name");
        name.addContraint(new RequiredContraint());
        form.addField(name);

        Field email = new EmailField();
        email.setLabel("E-mail");
        email.addContraint(new RequiredContraint());
        form.addField(email);

        Thread thred = new Thread(new TerminalRender(form));
        thred.start();

        try {
            thred.join();

            System.out.println("Form data:");

            for (Field field : form.getFields()) {
                System.out.println(field.getLabel() + ": " + field.getData());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
```

Contributing
------------

1. Give me a star =)
2. Fork it
3. Create your feature branch (`git checkout -b my-new-feature`)
4. Make your changes
5. Commit your changes (`git commit -am 'Added some feature'`)
6. Push to the branch (`git push origin my-new-feature`)
7. Create new Pull Request
