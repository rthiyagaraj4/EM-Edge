package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import eXH.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __updatedownloadabhacard extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/exh/jsp/UpdateDownloadABHACard.jsp", 1709122395022L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<title>Update / Download ABHA Card</title>\n<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" type=\"text/css\" />\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eCA/js/jquery-1.7.2.min.js\"></script>\n<style type=\"text/css\">\n.okBtn{\n\twidth: 60px;\n}\n.content {\n\tpadding: 10px;\n\tpadding-bottom: 35px;\n}\n#footer {  \n\tbottom: 0;\n\tposition: fixed;\n\twidth: 99%; \n\ttext-align: right;\n\tpadding: 10px;\n}\n</style>\n<script type=\"text/javascript\">\n\nfunction formRequestData(request_type,request_option){\n\t\n\tvar patient_id = document.getElementById(\"patient_id\").value;\n\tvar facility_id = document.getElementById(\"facility_id\").value;\n\tvar logged_in_user = document.getElementById(\"logged_in_user\").value;\n\tvar logged_in_ws_no = document.getElementById(\"logged_in_ws_no\").value;\n\tvar session_id = document.getElementById(\"session_id\").value;\n\t\n\treturn \"<REQUEST_TYPE>\"+request_type+\"$!^<REQUEST_OPTION>\"+request_option+\"$!^<PATIENT_ID>\"+patient_id+\"$!^<FACILITY_ID>\"+facility_id+\"$!^<LOGGED_IN_USER_ID>\"+logged_in_user+\"$!^<LOGGED_IN_WSNO>\"+logged_in_ws_no+\"$!^<SESSION>\"+session_id+\"$!^\";\n}\n\nfunction otpValidation(evt) {\n\tvar val = document.getElementById(\"Otp\").value;\n\tif (val.length == 6) {\n\t\tdocument.getElementById(\"verifyOTP\").disabled = false;\n\t} else {\n\t\tdocument.getElementById(\"verifyOTP\").disabled = true;\n\t}\n\t\n\tvar retVal = numberValidation(evt);\n\t\n\treturn retVal;\n}\n\nfunction mobileOtpValidation(evt) {\n\tvar val = document.getElementById(\"MobileOtp\").value;\n\tif (val.length == 6) {\n\t\tdocument.getElementById(\"VerMobOtpBtn\").disabled = false;\n\t} else {\n\t\tdocument.getElementById(\"VerMobOtpBtn\").disabled = true;\n\t}\n\t\n\tvar retVal = numberValidation(evt);\n\t\n\treturn retVal;\n}\n\nfunction emailOtpValidation(evt) {\n\tvar val = document.getElementById(\"EmailOtp\").value;\n\tif (val.length == 6) {\n\t\tdocument.getElementById(\"VerEmlOtpBtn\").disabled = false;\n\t} else {\n\t\tdocument.getElementById(\"VerEmlOtpBtn\").disabled = true;\n\t}\n\t\n\tvar retVal = numberValidation(evt);\n\t\n\treturn retVal;\n}\n\nfunction numberValidation(evt) {\n\t// Only ASCII character in that range allowed\n\tvar ASCIICode = (evt.which) ? evt.which : evt.keyCode;\n\tif (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))\n\t\treturn false;\n\t\n\treturn true;\n}\n\nfunction reset(){\n\tdocument.forms[0].reset();\n}\n\nfunction ResponseMsg(color,resMsg){\n\t$(\"#footerResId\").html(\"\");\n\t$(\"#footerResId\").append(\'<p id=\"resMsg\" style=\"color: \'+color+\';\">\'+resMsg+\'</p>\');\n}\n\nfunction generateOTP(){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\tvar mobileEle = document.getElementById(\"MobileNo\");\n\t\n\tvar otpEle = document.getElementById(\"Otp\");\n\tvar mobile_no = mobileEle.value;\n\t\n\tif(isDebugYN==\"true\") \n\t\talert(\'Generate OTP... mobile_no:\'+mobile_no);\n\t\n\tif(mobile_no!=null && mobile_no!=\"\"){\n\t\tmobileEle.disabled=true;\n\t\tdocument.getElementById(\"genOTPBtn\").disabled=true;\n\t\t\n\t\tvar request_type=\"\";\n\t\tvar strMode = getMode();\n\t\tif(strMode==\"UPDATEABHA\"){\n\t\t\trequest_type=\"UPDATEABHAID\";\n\t\t}else{\n\t\t\trequest_type=\"DOWNLOADABHAID\";\n\t\t}\n\t\tvar option = \"SENDLOGINOTP\";\t\t\n\t\tvar request_option=option;\n\t\t\n\t\tvar request_data = formRequestData(request_type,request_option);\n\t\trequest_data = request_data+\"<MOBILE_NO>\"+mobile_no;\n\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\"requestData: \"+request_data);\n\t\t\n\t\t//var responseMsg = \'{\"txnId\":\"0a67db9b-af9c-4c63-9774-3947f475053c\"}$!^S$!^SUCCESS\';//\n\t\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\'responseMsg: \'+responseMsg);\n\t\t\n\t\tvar resArray = responseMsg.split(\"$!^\");\n\t\tvar response = resArray[0];\n\t\tvar errorCode = resArray[1];\n\t\tvar errorMsg = resArray[2];\n\t\t\n\t\t if(errorCode==\"S\" && response!=\"null\"){ \n\t\t\tvar jsonResponse = jQuery.parseJSON(response);\n\t\t\tdocument.getElementById(\"txnId\").value = jsonResponse.txnId;\n\t\t\totpEle.disabled = false;\n\t\t\n\t\t\tResponseMsg(\'green\',\'OTP successfully sent to the mobile number!\');\n\t\t} else if(errorCode==\"F\" && response!=\"null\"){\n\t\t\tmobileEle.disabled=false;\n\t\t\tdocument.getElementById(\"genOTPBtn\").disabled=false;\n\t\t\totpEle.disabled = true;\n\t\t\t\n\t\t\tif(jQuery.parseJSON(response)){\n\t\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\t\n\t\t\t\tif(jObj.details[0].code!=null){\n\t\t\t\t\tvar resmsg = jObj.details[0].code+\":\"+jObj.details[0].message;\n\t\t\t\t\tResponseMsg(\'red\',resmsg);\n\t\t\t\t\t\n\t\t\t\t\tif(jObj.details[0].code==\"HIS-1023\"){\n\t\t\t\t\t\tmobileEle.disabled=true;\n\t\t\t\t\t\tdocument.getElementById(\"genOTPBtn\").disabled=true;\n\t\t\t\t\t\tvar timerOn = document.getElementById(\'timerOn\').value;\n\t\t\t\t\t\tvar waitTime = document.getElementById(\'waitTime\').value;\n\t\t\t\t\t\ttimer(waitTime,timerOn,option);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tResponseMsg(\'red\',response);\n\t\t\t}\n\t\t}else{\n\t\t\tmobileEle.disabled=false;\n\t\t\tdocument.getElementById(\"genOTPBtn\").disabled=false;\n\t\t\totpEle.disabled = true;\n\t\t\t\n\t\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t\t}\n\t}else {\n\t\tResponseMsg(\'red\',\'Enter mobile number.\');\n\t}\n}\n\nfunction verifyMobileOTP(){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\t\n\tvar otpEle = document.getElementById(\"Otp\");\n\tvar otp = otpEle.value;\n\tvar txnId = document.getElementById(\"txnId\").value;\n\t\n\tdocument.getElementById(\"verifyOTP\").disabled = true;\n\totpEle.disabled=true;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'Update ABHA... otp:\'+otp+\' txnId:\'+txnId);\n\t\n\tvar request_type=\"\";\n\tvar strMode = getMode();\n\tif(strMode==\"UPDATEABHA\"){\n\t\trequest_type=\"UPDATEABHAID\";\n\t}else{\n\t\trequest_type=\"DOWNLOADABHAID\";\n\t}\n\tvar request_option=\"VERIFYLOGINOTP\";\n\t\n\tvar request_data = formRequestData(request_type,request_option);\n\trequest_data = request_data+\"<OTP>\"+otp+\"$!^<TXN_ID>\"+txnId;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\"requestData: \"+request_data);\n\t\n\t//var responseMsg = \'{\"txnId\":\"0a67db9b-af9c-4c63-9774-3947f475053c\",\"token\":\"eyJhbGciOiJSUzUxMiJ9.eyJzdWIiOiI5Njc3MTEyMDAxIiwiY2xpZW50SWQiOiJTQlhfMDAwMTU0Iiwic3lzdGVtIjoiQUJIQS1OIiwiZXhwIjoxNjkzMjI2MDY1LCJpYXQiOjE2OTMyMjQyNjUsInR4bklkIjoiMGE2N2RiOWItYWY5Yy00YzYzLTk3NzQtMzk0N2Y0NzUwNTNjIn0.KHQO5TzJOeR1oeHdalwLlfYz514XhZQKeGYoiFTtVt2pW371PHfQZ_1HAbCkEgp9QmcaJGITPJCscnk0vJVO6pJBJ4nrp0NwQ76B8kjBvi6JngS2vD5u5WwkakMkxeshUdq3u2vo9ugSeLGt0OUVfx3C6ze88O-10uiFwS3kCgBgYGNsgqqAkuIccd0O_Q0GxYgkX9v3Ji3zpg9rkS_v2fu5KQEfEpZmv0kp-IupJctghF1KUL3TpmJtX82znJvnLAdjRbRleQUu7Kriuz0v9bGX5oTNyu6atLtYjGevNLE505epam-FnsalqLYQeU5lmhqJg1vSMewywPavIDezsVE4tp5EP8WpYwi3tOJus8kkE4QPWNq2e_3Od4vIA9-DXqW14k2z8gsqnbgFWVX8-ma2FqxgcXWlpDZVWZT267QDkB7wm7gj1yiYYiV2cAop1qPbuap-MnBDHdT5sDv9gSyyDHz6NAzMNYedLLq08rjNmHdAZX-RO1ohfe2S2t5T_AQL8SAH70D9HKxZloAG4ysHkcK7glT2BQcrCAhQcu8CugfTWV_gxevERVnJccWgjjWcaEe-6TCSu6xjmsdPDyqPYE5qat3hGC-D_KV8Zb6jWnollOQJiSWOy0NwfCCJ-0mfC286HMP2RG8JMdDXpoVhj7sdjdqiwHzTMBX9-dg\",\"mobileLinkedHid\":[{\"healthIdNumber\":\"91-3670-8272-5162\",\"healthId\":\"guruhealth1806@sbx\",\"name\":\"Padidam Thirupathi Rao\",\"profilePhoto\":null,\"phrAddress\":null},{\"healthIdNumber\":\"91-2757-5352-6811\",\"healthId\":\"91275753526811@sbx\",\"name\":\"K Vignesh\",\"profilePhoto\":null,\"phrAddress\":null}]}$!^S$!^SUCCESS\';//callABDM(request_type,request_option,request_data);\n\t//var responseMsg = \'{\"token\": \"trdqwytq-qwewqe-qweqwe-eqwwaedwq\"}$!^S$!^SUCCESS\';\n\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'responseMsg: \'+responseMsg);\n\t\n\tvar resArray = responseMsg.split(\"$!^\");\n\tvar response = resArray[0];\n\tvar errorCode = resArray[1];\n\tvar errorMsg = resArray[2];\n\t\n\t$(\"#SearchAbhaDtlTbl\").html(\"\");\n\t if(errorCode==\"S\" && response!=\"null\"){ \n\t\t\n\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\n\t\tif(jObj.mobileLinkedHid!=null){\n\t\t\tdocument.getElementById(\"txnId\").value = jObj.txnId;\n\t\t\tdocument.getElementById(\"T_token\").value = jObj.token;\n\t\t\t\n\t\t\tvar mobileLinkedHid = jObj.mobileLinkedHid;\n\t\t\tvar tableData =mobileLinkedHid;//\n\t\t\t\n\t\t\tdocument.getElementById(\"SearchAbhaDtlTbl\").style.display = \'block\';\n\t\t\t$(\"#SearchAbhaDtlTbl\").append(\'<tr id=\"headerRow\"></tr>\');\n\t\t\t\n\t\t\tif(request_type==\"UPDATEABHAID\")\n\t\t\t\t$(\"#headerRow\").append(\'<th></th>\');\n\t\t\t\n\t\t\t$(\"#headerRow\").append(\'<th>HealthId Number</th>\');\n\t\t\t$(\"#headerRow\").append(\'<th>HealthId</th>\');\n\t\t\t$(\"#headerRow\").append(\'<th>Name</th>\');\n\t\t\t\n\t\t\tif(request_type==\"DOWNLOADABHAID\")\n\t\t\t\t$(\"#headerRow\").append(\'<th>Download</th>\');\n\n\t\t\t$.each(tableData, function(a, b) {\n\t\t\t\t$(\"#SearchAbhaDtlTbl\").append(\'<tr id=\"\' + a + \'\"></tr>\');\n\t\t\t\tvar dataRowId = \'#\' + a;\n\t\t\t\t\n\t\t\t\tif(request_type==\"UPDATEABHAID\")\n\t\t\t\t\t$(dataRowId).append(\'<td><input id=\"abha\'+a+\'Id\" name=\"selectAbha\" id=\"selectAbha\" type=\"radio\" onclick=\"selectAbhaDtl(this)\" value=\"\'+b.healthIdNumber+\'\"></td>\');\n\t\t\t\t\n\t\t\t\t$(dataRowId).append(\'<td>\' + b.healthIdNumber + \'</td>\');\n\t\t\t\t\n\t\t\t\tif(b.healthId==\"\"){\n\t\t\t\t\t$(dataRowId).append(\'<td>Not Available</td>\');\n\t\t\t\t}else{\n\t\t\t\t\t$(dataRowId).append(\'<td>\' + b.healthId + \'</td>\');\n\t\t\t\t}\n\t\t\t\t$(dataRowId).append(\'<td>\' + b.name + \'</td>\');\n\t\t\t\t\n\t\t\t\tif(request_type==\"DOWNLOADABHAID\")\n\t\t\t\t\t$(dataRowId).append(\'<td><a href=\"#\" onclick=\"onclickDownload(\\\'\'+b.healthIdNumber+\'\\\')\">Download</a></td>\');\n\t\t\t\t\n\t\t\t});\n\t\t\t\n\t\t\tdocument.getElementById(\"eOtpLbl\").style.display = \'none\';\n\t\t\tdocument.getElementById(\"verifyOTP\").style.display = \'none\';\n\t\t\totpEle.style.display = \'none\';\n\t\t\tResponseMsg(\'green\',\'OTP verified successfully!\');\n\t\t}\n\t\telse if(jObj.token!=null){\t\t\t\n\t\t\tdocument.getElementById(\"X_token\").value = jObj.token;\n\t\t\t\n\t\t\tdocument.getElementById(\"eOtpLbl\").style.display = \'none\';\n\t\t\tdocument.getElementById(\"verifyOTP\").style.display = \'none\';\n\t\t\totpEle.style.display = \'none\';\n\t\t\t\n\t\t\tResponseMsg(\'green\',\'OTP verified successfully!\');\n\t\t\t\n\t\t\tif(request_type==\"UPDATEABHAID\"){\n\t\t\t\tdocument.getElementById(\"VerifyTbl\").style.display = \'block\';\n\t\t\t}else{\n\t\t\t\tdownloadAbha();\n\t\t\t}\n\t\t\t\n\t\t}else{\n\t\t\tdocument.getElementById(\"verifyOTP\").disable=false;\n\t\t\totpEle.disabled=false;\n\t\t\t\n\t\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t\t}\t\n\t\t\n\t}else if(errorCode==\"F\" && response!=\"null\") {\n\t\tdocument.getElementById(\"verifyOTP\").disable=false;\n\t\totpEle.disabled=false;\n\t\t\n\t\tif(jQuery.parseJSON(response)){\n\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\n\t\t\tif(jObj.details[0].code!=null)\n\t\t\t\tResponseMsg(\'red\',jObj.details[0].code+\":\"+jObj.details[0].message);\n\t\t}else{\n\t\t\tResponseMsg(\'red\',response);\n\t\t}\n\t}else{\t\n\t\tdocument.getElementById(\"verifyOTP\").disable=false;\n\t\totpEle.disabled=false;\n\t\t\n\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t}\n}\n\nfunction selectAbhaDtl(data){\n\tdocument.getElementById(\"healthIdNumber\").value = data.value;\n\tgenProfileToken();\n}\n\nfunction onclickDownload(healthIdNumber){\n\tdocument.getElementById(\"healthIdNumber\").value = healthIdNumber;\n\tgenProfileToken();\n}\n\nfunction genProfileToken(){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\t\n\tvar txnId = document.getElementById(\"txnId\").value;\n\tvar token = document.getElementById(\"T_token\").value;\n\tvar healthIdNumber = document.getElementById(\"healthIdNumber\").value;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'Generate Profile Token... txnId:\'+txnId+\' token:\'+token+\' healthIdNumber:\'+healthIdNumber);\n\t\n\tvar mobileEle = document.getElementById(\"NewMobileNo\");\n\tmobileEle.value=\"\";\n\tmobileEle.disabled=false;\n\tvar emailEle = document.getElementById(\"NewEmailId\");\n\temailEle.value=\"\";\n\temailEle.disabled=false;\n\tvar MobOtpEle = document.getElementById(\"MobileOtp\");\n\tMobOtpEle.value=\"\";\n\tMobOtpEle.disabled=true;\n\tvar EmlOtpEle = document.getElementById(\"EmailOtp\");\n\tEmlOtpEle.value=\"\";\n\tEmlOtpEle.disabled=true;\n\tdocument.getElementById(\"GenMobOtpBtn\").disabled=false;\n\tdocument.getElementById(\"GenEmlOtpBtn\").disabled=false;\n\tdocument.getElementById(\"VerifyTbl\").style.display = \'none\';\n\tdocument.getElementById(\"resMsg\").innerHTML = \"\";\n\t\n\tvar request_type=\"\";\n\tvar strMode = getMode();\n\tif(strMode==\"UPDATEABHA\"){\n\t\trequest_type=\"UPDATEABHAID\";\n\t}else{\n\t\trequest_type=\"DOWNLOADABHAID\";\n\t}\n\tvar request_option=\"GENERATEPROFILETOKEN\";\n\tvar request_data = formRequestData(request_type,request_option);\n\trequest_data = request_data+\"<TXN_ID>\"+txnId+\"$!^<TOKEN>\"+token+\"$!^<HEALTHIDNUMBER>\"+healthIdNumber;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\"requestData: \"+request_data);\n\t\n\t//var responseMsg = \'{\"token\":\"asfdag-asdadhja-asdasd\"}$!^S$!^SUCCESS\';//callABDM(request_type,request_option,request_data);\n\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'responseMsg: \'+responseMsg);\n\t\n\tvar resArray = responseMsg.split(\"$!^\");\n\tvar response = resArray[0];\n\tvar errorCode = resArray[1];\n\tvar errorMsg = resArray[2];\n\t\n\t if(errorCode==\"S\" && response!=\"null\"){ \n\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\n\t\tdocument.getElementById(\"X_token\").value = jObj.token;\t\t\n\t\tResponseMsg(\'green\',\'Profile token generated successfully for healthId number (\'+healthIdNumber+\')\');\n\t\t\n\t\tif(request_type==\"DOWNLOADABHAID\"){\n\t\t\tdownloadAbha();\n\t\t}else{\n\t\t\tdocument.getElementById(\"VerifyTbl\").style.display = \'block\';\n\t\t}\n\t\t\n\t}else if(errorCode==\"F\" && response!=\"null\") {\n\t\tif(jQuery.parseJSON(response)){\n\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\n\t\t\tif(jObj.details[0].code!=null)\n\t\t\t\tResponseMsg(\'red\',jObj.details[0].code+\":\"+jObj.details[0].message);\n\t\t}else{\n\t\t\tResponseMsg(\'red\',response);\n\t\t}\n\t}else{\n\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t}\n}\n\nfunction generateUpdateOTP(option){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\tvar mobileEle = document.getElementById(\"NewMobileNo\");\n\tvar emailEle = document.getElementById(\"NewEmailId\");\n\t\n\tvar MobOtpEle = document.getElementById(\"MobileOtp\");\n\tvar EmlOtpEle = document.getElementById(\"EmailOtp\");\n\tvar mobile_no = mobileEle.value;\n\tvar email_id = emailEle.value;\n\t\n\tvar token = document.getElementById(\"X_token\").value;\n\t\n\t\n\t\n\t//if(mobile_no!=null && mobile_no!==\"\"){\n\t\tvar request_type=\"UPDATEABHAID\";\n\t\tvar request_option=option;\n\t\tvar request_data = formRequestData(request_type,request_option);\n\t\t\n\t\tif(option==\"UPDATEMOBILEINIT\"){\t\n\t\t\tif(isDebugYN==\"true\")\n\t\t\t\talert(\'Generate OTP... mobile_no:\'+mobile_no);\n\t\t\t\n\t\t\trequest_data = request_data+\"<TOKEN>\"+token+\"$!^<MOBILE_NO>\"+mobile_no;\n\t\t}else{\n\t\t\tif(isDebugYN==\"true\")\n\t\t\t\talert(\'Generate OTP... email_id:\'+email_id);\n\t\t\t\n\t\t\trequest_data = request_data+\"<TOKEN>\"+token+\"$!^<EMAIL>\"+email_id;\n\t\t}\n\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\"requestData: \"+request_data);\n\t\t\n\t\t//var responseMsg = \'{\"txnId\":\"0a67db9b-af9c-4c63-9774-3947f475053c\"}$!^S$!^SUCCESS\';//callABDM(request_type,request_option,request_data);\n\t\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\'responseMsg: \'+responseMsg);\n\t\t\n\t\tvar resArray = responseMsg.split(\"$!^\");\n\t\tvar response = resArray[0];\n\t\tvar errorCode = resArray[1];\n\t\tvar errorMsg = resArray[2];\n\t\t\n\t\t if(errorCode==\"S\" && response!=\"null\"){ \n\t\t\tvar jsonResponse = jQuery.parseJSON(response);\n\t\t\tdocument.getElementById(\"U_txnId\").value = jsonResponse.txnId;\n\t\t\t\n\t\t\tif(option==\"UPDATEMOBILEINIT\"){\t\n\t\t\t\tMobOtpEle.disabled = false;\n\t\t\t\tmobileEle.disabled = true;\n\t\t\t\tdocument.getElementById(\"GenMobOtpBtn\").disabled=true;\n\t\t\t\tResponseMsg(\'green\',\'OTP successfully sent to the mobile number!\');\n\t\t\t}else{\n\t\t\t\tEmlOtpEle.disabled = false;\n\t\t\t\temailEle.disabled = true;\n\t\t\t\tdocument.getElementById(\"GenEmlOtpBtn\").disabled=true;\n\t\t\t\tResponseMsg(\'green\',\'OTP successfully sent to the emailId!\');\n\t\t\t}\n\t\t\t\n\t\t} else if(errorCode==\"F\" && response!=\"null\"){\n\t\t\tif(jQuery.parseJSON(response)){\n\t\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\t\n\t\t\t\tif(jObj.details[0].code!=null){\n\t\t\t\t\tvar resmsg = jObj.details[0].code+\":\"+jObj.details[0].message;\n\t\t\t\t\tResponseMsg(\'red\',resmsg);\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tResponseMsg(\'red\',response);\n\t\t\t}\n\t\t}else{\n\t\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t\t}\n\t/*}else {\n\t\tResponseMsg(\'red\',\'Enter mobile number.\');\n\t}*/\n}\n\nfunction verifyUpdate(option){\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\t\n\tvar txnId = document.getElementById(\"U_txnId\").value;\n\tvar token = document.getElementById(\"X_token\").value;\n\tvar MobOtpEle = document.getElementById(\"MobileOtp\");\n\tvar EmlOtpEle = document.getElementById(\"EmailOtp\");\n\t\n\tvar otp=\"\";\n\tif(option==\"CHANGEMOBILENUMBER\"){\n\t\totp = MobOtpEle.value;\n\t}else{\n\t\totp = EmlOtpEle.value;\n\t}\n\n\tif(isDebugYN==\"true\")\n\t\talert(\'verifyUpdateMobile... txnId:\'+txnId+\' token:\'+token+\' otp:\'+otp);\n\t\n\tvar request_type=\"UPDATEABHAID\";\n\tvar request_option=option;\n\tvar request_data = formRequestData(request_type,request_option);\n\trequest_data = request_data+\"<TXN_ID>\"+txnId+\"$!^<TOKEN>\"+token+\"$!^<OTP>\"+otp;\n\t\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\"requestData: \"+request_data);\n\t\n\t//var responseMsg = \'{\"txnId\":\"0a67db9b-af9c-4c63-9774-3947f475053c\"}$!^S$!^SUCCESS\';//callABDM(request_type,request_option,request_data);\n\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'responseMsg: \'+responseMsg);\n\t\n\tvar resArray = responseMsg.split(\"$!^\");\n\tvar response = resArray[0];\n\tvar errorCode = resArray[1];\n\tvar errorMsg = resArray[2];\n\t\n\t if(errorCode==\"S\" && response!=\"null\"){ \n\t\t//var jsonResponse = jQuery.parseJSON(response);\n\t\t//document.getElementById(\"txnId\").value = jsonResponse.txnId;\n\t\tvar mobileEle = document.getElementById(\"NewMobileNo\");\n\t\tvar emailEle = document.getElementById(\"NewEmailId\");\n\t\tif(option==\"CHANGEMOBILENUMBER\"){\n\t\t\tMobOtpEle.disabled = true;\n\t\t\tdocument.getElementById(\"VerMobOtpBtn\").disabled=true;\n\t\t\tdocument.getElementById(\"UpdatedMobile\").value = mobileEle.value;\n\t\t\tResponseMsg(\'green\',\'Mobile number updated successfully!\');\n\t\t}else{\n\t\t\tEmlOtpEle.disabled = true;\n\t\t\tdocument.getElementById(\"VerEmlOtpBtn\").disabled=true;\n\t\t\tdocument.getElementById(\"UpdatedEmail\").value = emailEle.value;\n\t\t\tResponseMsg(\'green\',\'Email updated successfully!\');\n\t\t}\n\t\tdocument.getElementById(\"okBtn\").disabled=false;\n\t\t\n\t} else if(errorCode==\"F\" && response!=\"null\"){\n\t\tif(jQuery.parseJSON(response)){\n\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\n\t\t\tif(jObj.details[0].code!=null){\n\t\t\t\tvar resmsg = jObj.details[0].code+\":\"+jObj.details[0].message;\n\t\t\t\tResponseMsg(\'red\',resmsg);\n\t\t\t}\n\t\t}else{\n\t\t\tResponseMsg(\'red\',response);\n\t\t}\n\t}else{\n\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t}\n}\n\nfunction downloadAbha(){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\tvar token = document.getElementById(\"X_token\").value;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'Download.... token:\'+token);\n\t\n\tvar request_type=\"DOWNLOADABHAID\";\n\tvar request_option=\"DOWNLOADABHACARD\";\n\tvar request_data = formRequestData(request_type,request_option);\n\trequest_data = request_data+\"<TOKEN>\"+token;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\"requestData: \"+request_data);\n\t\n\t//var responseMsg = \'{\"image\":\"asfdag-asdadhja-asdasd\",\"patient_id\":\"123412653\"}$!^S$!^SUCCESS\';\n\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'responseMsg: \'+responseMsg);\n\t\n\tvar resArray = responseMsg.split(\"$!^\");\n\tvar response = resArray[0];\n\tvar errorCode = resArray[1];\n\tvar errorMsg = resArray[2];\n\t\n\tif(errorCode==\"S\"){\n\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\n\t\tdocument.getElementById(\"X_token\").value = jObj.token;\n\t\tResponseMsg(\'green\',\'Downloaded successfully!\');\n\t\tdocument.getElementById(\"okBtn\").disabled=false;\n\t\t\n\t}else if(errorCode==\"F\") {\n\t\tif(jQuery.parseJSON(response)){\n\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\n\t\t\tif(jObj.details[0].code!=null)\n\t\t\t\tResponseMsg(\'red\',jObj.details[0].code+\":\"+jObj.details[0].message);\n\t\t}else{\n\t\t\tResponseMsg(\'red\',response);\n\t\t}\n\t}else{\n\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t}\n\t\n}\n\t\nfunction timer(remaining,timerOn,reqOption) {\n\t  var m = Math.floor(remaining / 60);\n\t  var s = remaining;\n\t  \n\t  m = m < 10 ? \'0\' + m : m;\n\t  s = s < 10 ? \'0\' + s : s;\n\t  document.getElementById(\'timer\').innerHTML = m + \':\' + s;\n\t  remaining -= 1;\n\t  \n\t  if(remaining >= 0 && timerOn) {\n\t    setTimeout(function() {\n\t        timer(remaining,timerOn,reqOption);\n\t    }, 1000);\n\t    return;\n\t  }\n\n\t  if(!timerOn) {\n\t    // Do validate stuff here\n\t    //alert(\'validate stuff\');\n\t    return;\n\t  }\n\t  \n\t  // Do timeout stuff here\n\t  document.getElementById(\'timer\').innerHTML = \"\";\n\t  if(reqOption==\"GENERATEOTP\"){\n\t\t  document.getElementById(\"genOTPBtn\").disabled = false;  \n\t  }else if(reqOption==\"GENERATEMOBILEOTP\"){\t\t  \n\t  \t  document.getElementById(\"genMobOTPBtn\").disabled = false;\n\t  }else if(reqOption==\"SENDLOGINOTP\"){\n\t\t  document.getElementById(\"MobileNo\").disabled=false;\n\t\t  document.getElementById(\"genOTPBtn\").disabled=false;\n\t  }\n}\n\nfunction getMode(){\n\tvar strMode = \"\";\n\tvar serEle = document.getElementsByName(\"updwRad\");\n    for (i=0; i < serEle.length; i++) {\n        if (serEle[i].checked)\n        \tstrMode =  serEle[i].value;\n    }\n    return strMode;\n}\n\nfunction filedReset(){\n\t\n\tvar strMode = getMode();\n\t\n\tdocument.forms[0].reset();\n\t\n\tif(strMode==\"UPDATEABHA\"){\t\n\t\tdocument.getElementById(\"updateRad\").checked=true;\n\t}else{\n\t\tdocument.getElementById(\"downloadRad\").checked=true;\n\t}\n\tdocument.getElementById(\"MobileNo\").disabled=false;\n\tdocument.getElementById(\"genOTPBtn\").disabled=false;\n\tdocument.getElementById(\"eOtpLbl\").style.display = \'block\';\n\tdocument.getElementById(\"verifyOTP\").style.display = \'block\';\n\tvar otpEle=document.getElementById(\"Otp\");\n\totpEle.style.display = \'block\';\n\totpEle.disabled=true;\n\t$(\"#SearchAbhaDtlTbl\").html(\"\");\n\tdocument.getElementById(\"SearchAbhaDtlTbl\").style.display = \'none\';\n\tdocument.getElementById(\"NewMobileNo\").disabled=false;\n\tdocument.getElementById(\"NewEmailId\").disabled=false;\n\tdocument.getElementById(\"GenMobOtpBtn\").disabled=false;\n\tdocument.getElementById(\"GenEmlOtpBtn\").disabled=false;\n\tdocument.getElementById(\"VerifyTbl\").style.display = \'none\';\n\tdocument.getElementById(\"okBtn\").disabled=true;\n\tdocument.getElementById(\"resMsg\").innerHTML = \"\";\n}\n\nfunction cancel(){\n\twindow.close();\n}\n\nfunction finish() {\n\t\n\tvar strMode = getMode();\n\tvar strRes = strMode;\n\tif(strMode==\"UPDATEABHA\"){\t\n\t\tvar mobile = document.getElementById(\"UpdatedMobile\").value;\n\t\tvar email = document.getElementById(\"UpdatedEmail\").value;\n\t\tstrRes = strRes+\"$!^\"+mobile+\"$!^\"+email\n\t}\n\twindow.returnValue = strRes;\n\twindow.close();\n}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n<body>\n<form name=\"UpdateABHADetailsForm\" id=\"UpdateABHADetailsForm\" method=\"post\" >\n\t<div class=\"content\">\n\t\t<table cellspacing=0 cellpadding=3>\n\t\t\t<tr>\n\t\t\t\t<td align=\"left\">\n\t\t\t\t\t<input type=\"radio\" id=\"updateRad\" name=\"updwRad\" id=\"updwRad\" value=\"UPDATEABHA\" onclick=\"filedReset()\" checked /><label for=\"updateRad\">Update ABHA</label>\n\t\t\t\t\t<input type=\"radio\" id=\"downloadRad\" name=\"updwRad\" id=\"updwRad\" value=\"DOWNLOADABHA\" onclick=\"filedReset()\" /><label for=\"dowloadRad\">Download ABHA</label>\n\t\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\n\t\t</table>\n\t\t<table cellspacing=0 cellpadding=3 >\n\t\t\t<tr>\n\t\t\t\t<td align=\"left\">\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t<td align=\"left\"><input type=\"number\" title=\"10 Digit mobile number Ex. 9840012345\" id=\"MobileNo\" name=\"MobileNo\" id=\"MobileNo\" size=20 maxlength=10  \n\t\t\t\t\t\tonkeyup=\"return numberValidation(event)\" onkeydown=\"return numberValidation(event)\" onkeypress=\"return numberValidation(event)\"></td>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"left\"><input id=\"genOTPBtn\" type=\"button\" class=\"button\" value=\"Generate OTP\" onclick=\"generateOTP()\"></td>\n\t\t\t\t\n\t\t\t\t<td class=\'label\' id=\"eOtpLbl\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t<td align=\"left\"><input type=\"number\" id=\"Otp\" name=\"Otp\" id=\"Otp\" size=10 maxlength=6 value=\'\' disabled \n\t\t\t\tonkeyup=\"return otpValidation(event)\" onkeydown=\"return otpValidation(event)\" onkeypress=\"return otpValidation(event)\"></td>\n\t\t\t\t<td align=\"left\"><input type=\"button\" class=\"button\" id=\"verifyOTP\" value=\"Verify OTP\" onclick=\"verifyMobileOTP()\" disabled></td>\n\t\t\t\t<td align=\"left\"><input type=\"button\" class=\"button\" id=\"resetBtn\" value=\"Reset\" onclick=\"filedReset()\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</br>\n\t\t<hr style=\"border-top: 1px solid #bbb\">\n\t\t</br>\n\t\t<div style=\"width: 100%;text-align: center;\">\n\t\t\t<p id=\"timer\" style=\"color:blue;\"></p>\n\t\t</div>\n\t\t<table id=\"SearchAbhaDtlTbl\" border=1 cellspacing=0 cellpadding=3 width=\'98%\' align=\"center\" style=\"display: none;\"></table>\n\t\t</br>\n\t\t<div style=\"padding: 10px;\">\n\t\t\t<table id=\"VerifyTbl\" cellspacing=0 cellpadding=0 width=\"100%\" style=\"display: none;\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<table id=\"GenMobileOtpTbl\" width=\"100%\" cellspacing=0 cellpadding=3>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"55%\"><input type=\"number\" title=\"10 Digit mobile number Ex. 9840012345\" id=\"NewMobileNo\" name=\"NewMobileNo\" id=\"NewMobileNo\" style=\"width:98%\" maxlength=10  \n\t\t\t\t\t\t\t\t\tonkeyup=\"return numberValidation(event)\" onkeydown=\"return numberValidation(event)\" onkeypress=\"return numberValidation(event)\"></td>\t\n\t\t\t\t\t\t\t\t<td align=\"right\" width=\"20%\"><input type=\"button\" id=\"GenMobOtpBtn\" class=\"button\" value=\"Generate OTP\" onclick=\"generateUpdateOTP(\'UPDATEMOBILEINIT\')\" </td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<table id=\"GenEmailOtpTbl\" width=\"100%\" cellspacing=0 cellpadding=3>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t\t\t<td align=\"right\" width=\"55%\"><input type=\"text\" id=\"NewEmailId\" name=\"NewEmailId\" id=\"NewEmailId\" style=\"width:98%\" value=\'\' ></td>\n\t\t\t\t\t\t\t\t<td align=\"right\" width=\"20%\"><input type=\"button\" id=\"GenEmlOtpBtn\" class=\"button\" value=\"Generate OTP\" onclick=\"generateUpdateOTP(\'UPDATEEMAILINIT\')\" ></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<table id=\"VerMobileOtpTbl\" width=\"100%\" cellspacing=0 cellpadding=3>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t\t\t<td align=\"right\" width=\"20%\"><input type=\"number\" id=\"MobileOtp\" name=\"MobileOtp\" id=\"MobileOtp\" maxlength=6 value=\'\' disabled \n\t\t\t\t\t\t\t\tonkeyup=\"return mobileOtpValidation(event)\" onkeydown=\"return mobileOtpValidation(event)\" onkeypress=\"return mobileOtpValidation(event)\"></td>\n\t\t\t\t\t\t\t\t<td align=\"right\" width=\"55%\"><input type=\"button\" id=\"VerMobOtpBtn\" class=\"button\" value=\"Verify OTP / Update Mobile\" onclick=\"verifyUpdate(\'CHANGEMOBILENUMBER\')\" disabled></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<table id=\"VerEmailOtpTbl\" width=\"100%\" cellspacing=0 cellpadding=3>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t\t<td align=\"right\" width=\"20%\"><input type=\"number\" id=\"EmailOtp\" name=\"EmailOtp\" id=\"EmailOtp\" maxlength=6 value=\'\' disabled \n\t\t\t\t\t\t\t\tonkeyup=\"return emailOtpValidation(event)\" onkeydown=\"return emailOtpValidation(event)\" onkeypress=\"return emailOtpValidation(event)\"></td>\n\t\t\t\t\t\t\t\t<td align=\"right\" width=\"55%\"><input type=\"button\" id=\"VerEmlOtpBtn\" class=\"button\" value=\"Verify OTP / Update Email\" onclick=\"verifyUpdate(\'CHANGEEMAIL\')\" disabled></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t</div>\n\t<div id=\"footer\">\n\t\t<div id=\"footerResId\" style=\"padding-left: 10px;float: left;text-align: left;\"><p id=\"resMsg\"></p></div>\n\t\t<div style=\"padding-right: 10px;\">\n\t\t\t<!-- <input type=\"button\" class=\"button\" value=\"Cancel\" onclick=\"cancel()\"> -->\n\t\t\t<input id=\"OkBtn\" type=\"button\" class=\"button okBtn\" value=\"OK\" onclick=\"finish()\" disabled >\n\t\t</div>\n\t</div>\n\t\n\t<input type=\"hidden\" id=\"isDebugYN\" name=\"isDebugYN\" id=\"isDebugYN\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"> \n\t<input type=\"hidden\" id=\"patient_id\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"> \n\t<input type=\"hidden\" id=\"facility_id\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\" id=\"logged_in_user\" name=\"logged_in_user\" id=\"logged_in_user\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"> \n\t<input type=\"hidden\" id=\"logged_in_ws_no\" name=\"logged_in_ws_no\" id=\"logged_in_ws_no\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> \n\t<input type=\"hidden\" id=\"session_id\" name=\"session_id\" id=\"session_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" id=\"txnId\" name=\"txnId\" id=\"txnId\" value=\"\">\n\t<input type=\"hidden\" id=\"U_txnId\" name=\"U_txnId\" id=\"U_txnId\" value=\"\"> \n\t<input type=\"hidden\" id=\"X_token\" name=\"X_token\" id=\"X_token\" value=\"\"> \n\t<input type=\"hidden\" id=\"T_token\" name=\"T_token\" id=\"T_token\" value=\"\"> \n\t<input type=\"hidden\" id=\"timerOn\" name=\"timerOn\" id=\"timerOn\" value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\t<input type=\"hidden\" id=\"waitTime\" name=\"waitTime\" id=\"waitTime\" value=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t<input type=\"hidden\" id=\"healthIdNumber\" name=\"healthIdNumber\" id=\"healthIdNumber\" value=\"\"> \n\t<input type=\"hidden\" id=\"UpdatedMobile\" name=\"UpdatedMobile\" id=\"UpdatedMobile\" value=\"\"> \n\t<input type=\"hidden\" id=\"UpdatedEmail\" name=\"UpdatedEmail\" id=\"UpdatedEmail\" value=\"\"> \n</form>\n</body>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	Connection conn = null;
	boolean isDebugYN = false; 
	boolean timerOn = true;
	String waitTime = "30";
	
	try{
		isDebugYN = (XHUtil.singleParamExeQry("SELECT NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PROTOCOL_LINK WHERE PROTOCOL_LINK_ID = 'ABDMPL1'").equals("Y")) ? true : false;
		System.out.println("***Inside Update ABHA ID - isDebugYN..."+isDebugYN);
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("***Inside Update ABHA ID - Exception while checking isDebugYN Flag... "+e);
	}finally{
		ConnectionManager.returnConnection(conn);
		if(isDebugYN)
			System.out.println("***Inside Update ABHA ID - Conection closed");
	}
	
	String mobile_no = checkForNull(request.getParameter("mobile_no"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String logged_in_user = checkForNull(request.getParameter("logged_in_user"));
	String logged_in_ws_no = checkForNull(request.getParameter("logged_in_ws_no"));
	String session_id = checkForNull(request.getParameter("session_id"));

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(logged_in_user));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(logged_in_ws_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( timerOn ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( waitTime ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.MobileNumber.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.EnterOTP.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.MobileNumber.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.EmailId.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.EnterOTP.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.EnterOTP.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
