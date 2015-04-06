package com.clathrop.infographyl.jsonresponse;

import com.clathrop.infographyl.model.JsonJTableInfographicBean;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by clathrop on 4/4/15.
 */
public class JsonJtableInfographicListResponse {
    private String Result;
    private List<JsonJTableInfographicBean> Records;
    private Integer TotalRecordCount;
    private String Message;

    public JsonJtableInfographicListResponse(String Result, List<JsonJTableInfographicBean> Records, Integer TotalRecordCount){
        this.Result = Result;
        this.Records = Records;
        this.TotalRecordCount = TotalRecordCount;
    }

    public JsonJtableInfographicListResponse(String Result, String Message){
        this.Result = Result;
        this.Message = Message;
    }

    @JsonProperty("Result")
    public String getResult(){
        return this.Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    @JsonProperty("Records")
    public List<JsonJTableInfographicBean> getRecords() {
        return Records;
    }

    public void setRecords(List<JsonJTableInfographicBean> Records) {
        this.Records = Records;
    }

    @JsonProperty("TotalRecordCount")
    public int getTotalRecordCount() {
        return TotalRecordCount;
    }

    public void setTotalRecordCount(int TotalRecordCount) {
        this.TotalRecordCount = TotalRecordCount;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }


}
