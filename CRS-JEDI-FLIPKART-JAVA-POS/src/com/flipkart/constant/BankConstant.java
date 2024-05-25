package com.flipkart.constant;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Enumeration class for BankConstant names
 *
 */
public enum BankConstant {

    HDFC("HDFC BankConstant"),
    SBI("SBI"),
    ICICI("ICICI BankConstant"),
    Axis("Axis BankConstant");
    
    final private String value;
    private BankConstant(String value)
    {
        this.value=value;
    }
    public String hasValue()
    {
        return this.value;
    }
}
