package md.miller1995.springRestAPI.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorForClient {
    public static void returnErrorsToClient(BindingResult bindingResult) {
        StringBuilder errorMessage = new StringBuilder();

        List<FieldError> errorList = bindingResult.getFieldErrors();  // get all errors from bindingResult, and put them in FieldError object -> errorList

        for(FieldError error:errorList){                            // with for each get all errors from errorList
                                                                    // and concat errors in StringBuilder object -> errorMessage
            errorMessage.append(error.getField())                   // get name of field where is error message
                        .append(" - ")
                        .append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage())     //
                        .append(";");
        }
        throw new MeasureAndSensorInvalidInputException(errorMessage.toString());   //
    }
}
