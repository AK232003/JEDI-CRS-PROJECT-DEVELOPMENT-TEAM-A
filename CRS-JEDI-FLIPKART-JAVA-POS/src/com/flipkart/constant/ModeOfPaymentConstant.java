package com.flipkart.constant;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Enumeration class for modes of payment
 *
 */
public enum ModeOfPaymentConstant {

    CARD,CHEQUE,UPI,NET_BANKING,CASH;

    /**
     * selects the mode of payment
     * @param value
     * @return mode of payment
     */
    public static ModeOfPaymentConstant getModeofPayment(int value)
    {
        switch(value)
        {
            case 1:
                return ModeOfPaymentConstant.CARD;
            case 4:
                return ModeOfPaymentConstant.NET_BANKING;
            case 3:
                return ModeOfPaymentConstant.UPI;
            case 5:
                return ModeOfPaymentConstant.CASH;
            case 2:
                return ModeOfPaymentConstant.CHEQUE;
            default:
                return null;

        }

    }

}
