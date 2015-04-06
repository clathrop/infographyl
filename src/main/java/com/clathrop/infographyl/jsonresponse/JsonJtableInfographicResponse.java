package com.clathrop.infographyl.jsonresponse;

import com.clathrop.infographyl.model.JsonJTableInfographicBean;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by clathrop on 4/5/15.
 */
public class JsonJtableInfographicResponse {

    private String Result;

    private JsonJTableInfographicBean Records;

    private String Message;

    public JsonJtableInfographicResponse(){}

    public JsonJtableInfographicResponse(String Result) {
        this.Result = Result;
    }

    public JsonJtableInfographicResponse(String Result, JsonJTableInfographicBean Records) {
        this.Result = Result;
        this.Records = Records;
    }

    public JsonJtableInfographicResponse(String Result, String Message) {
        this.Result = Result;
        this.Message = Message;
    }

    @JsonProperty("Result")
    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    @JsonProperty("Record")
    public JsonJTableInfographicBean getRecords() {
        return Records;
    }

    public void setRecords(JsonJTableInfographicBean Records) {
        this.Records = Records;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
}
