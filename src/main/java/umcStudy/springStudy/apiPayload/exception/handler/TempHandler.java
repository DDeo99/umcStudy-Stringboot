package umcStudy.springStudy.apiPayload.exception.handler;

import umcStudy.springStudy.apiPayload.code.BaseErrorCode;
import umcStudy.springStudy.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}