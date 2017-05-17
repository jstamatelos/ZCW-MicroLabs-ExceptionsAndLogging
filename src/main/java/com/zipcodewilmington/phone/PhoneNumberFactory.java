package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberFactory.class);

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] phoneNumbers = new PhoneNumber[phoneNumberCount];
        for (PhoneNumber pn : phoneNumbers){
            pn = createRandomPhoneNumber();
        }





        return null;

    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic

    private static PhoneNumber createRandomPhoneNumber() {
            return createPhoneNumberSafely(RandomNumberFactory.createInteger(111, 999), RandomNumberFactory.createInteger(100, 999), RandomNumberFactory.createInteger(1000, 9999));
        }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null

    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        try {
            String phoneNumberString = String.format("(%s)-%s-%s", areaCode, centralOfficeCode, phoneLineCode);
            return new PhoneNumber(phoneNumberString);
        } catch (InvalidPhoneNumberFormatException e){
            logger.warn("(%s)-%s-%s is not a valid phone number");
            logger.info("(%s)-%s-%s is not a valid phone number");
            return null;
        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        LoggerFactory.getLogger("Attempting to create a new PhoneNumber object with a value of (%s)-%s-%s");
        return new PhoneNumber(phoneNumberString);

    }
}