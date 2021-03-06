package se.alipsa.phonenumber;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber;

/** 
 * This wrapper is temporary workaround until the Renjin StringConverter is fixed 
 * to also treat CharSequences as Strings
 */
public final class PhoneNumberWrapper {

  private final com.google.i18n.phonenumbers.PhoneNumberUtil numberUtil =
        com.google.i18n.phonenumbers.PhoneNumberUtil.getInstance();       
  
  public boolean isValid(String phoneNumber, String region) {
    //System.out.println("Evaluating phoneNumber " + phoneNumber);
    try {
      Phonenumber.PhoneNumber number = numberUtil.parseAndKeepRawInput(phoneNumber, region);
      return numberUtil.isValidNumber(number);
    } catch(Throwable e) {
      return false;
    }
  }
}