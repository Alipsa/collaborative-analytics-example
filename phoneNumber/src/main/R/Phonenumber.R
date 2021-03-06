# remember to add export(function name) to NAMESPACE to make them available


validatePhoneNumber <- function(phoneNumber, defaultRegion = "SE") {
  import(se.alipsa.phonenumber.PhoneNumberWrapper)
  wrapper <- PhoneNumberWrapper$new()
  return(wrapper$isValid(phoneNumber, defaultRegion))
}

validatePhoneNumbers <- function(phoneNumbers) {
  vecVal <- Vectorize(validatePhoneNumber, vectorize.args = "phoneNumber")
  vecVal(phoneNumbers)
}