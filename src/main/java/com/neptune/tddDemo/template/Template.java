package com.neptune.tddDemo.template;

public class Template {
    private String templateText;

    public Template() {
        this.templateText="";
    }
    public Template(String templateText) throws NullTemplateException {
        if(templateText!=null) {
            this.templateText = templateText;
        }else{
            throw new NullTemplateException();
        }
    }

    public String render() {
        return templateText;
    }

    public String render(String s) {
        return templateText+s;
    }
}
