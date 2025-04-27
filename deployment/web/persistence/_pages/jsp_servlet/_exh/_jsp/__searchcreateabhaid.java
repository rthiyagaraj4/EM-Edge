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

public final class __searchcreateabhaid extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/SearchCreateABHAID.jsp", 1709122391147L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<title>Link Health ID</title>\n<link rel=\"StyleSheet\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" type=\"text/css\" />\n<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eCA/js/jquery-1.7.2.min.js\"></script>\n<style type=\"text/css\">\n.okBtn{\n\twidth: 60px;\n}\n.content {\n\tpadding: 10px;\n\tpadding-bottom: 35px;\n}\n#footer {  \n\tbottom: 0;\n\tposition: fixed;\n\twidth: 99%;\n\ttext-align: right;\n\tpadding: 10px;\n\tbackground-color: white;\n}\n</style>\n<script type=\"text/javascript\">\nfunction SearchCreateEvent(object){\n\n\tvar strMode = \"\";\n\tvar serEle = document.getElementsByName(\"searchRad\");\n    for (i=0; i < serEle.length; i++) {\n        if (serEle[i].checked)\n        \tstrMode =  serEle[i].value;\n    }\n    fieldsReset(strMode);\n}\n\nfunction fieldsReset(strMode){\n\t\n\tdocument.forms[0].reset();\n\n\t$(\"#abhaIdInfoTable\").html(\"\");\n\tdocument.getElementById(\"resMsg\").innerHTML = \"\";\n\t\n\tvar searchDiv = document.getElementById(\"searchDiv\");\n\tvar createDiv = document.getElementById(\"createDiv\");\n\tvar otpDiv = document.getElementById(\"otpDiv\");\n\tvar searchFooter = document.getElementById(\"searchFooter\");\n\tvar createFooter = document.getElementById(\"createFooter\");\n\n\tif(strMode==\"SEARCHABHA\"){\n\t\tdocument.getElementById(\"searchRad\").checked=true;\n\t\tsearchDiv.style.display = \'block\';\n\t\tcreateDiv.style.display = \'none\';\n\n\t\tdocument.getElementById(\"SearchMobileNo\").disabled = false;\n\t\tdocument.getElementById(\"Name\").disabled = false;\n\t\tdocument.getElementById(\"BirthYear\").disabled = false;\n\t\tdocument.getElementById(\"genSltId\").disabled = false;\n\t\t\n\t\totpDiv.style.display = \'none\';\n\t\t\n\t\tdocument.getElementById(\"searchBtn\").disabled = false;\n\t\tdocument.getElementById(\"searchOkBtn\").disabled = true;\n\t\t\n\t\tsearchFooter.style.display = \'block\';\n\t\tcreateFooter.style.display = \'none\';\n\t\t\n\t}else if(strMode==\"CREATEABHA\"){\t\n\t\tdocument.getElementById(\"createRad\").checked=true;\n\t\tsearchDiv.style.display = \'none\';\n\t\tcreateDiv.style.display = \'block\';\n\n\t\tdocument.getElementById(\"CreateMobileNo\").disabled = false;\n\t\tdocument.getElementById(\"AadhaarNo\").disabled = false;\n\t\tvar genOtpEle = document.getElementById(\"genOTPBtn\");\n\t\tgenOtpEle.disabled = false;\n\t\tgenOtpEle.style.display = \'block\';\n\t\tvar genMobOtpEle = document.getElementById(\"genMobOTPBtn\");\n\t\tgenMobOtpEle.disabled = false;\n\t\tgenMobOtpEle.style.display = \'none\';\t\t\n\t\t\n\t\totpDiv.style.display = \'block\';\n\t\tdocument.getElementById(\"etrAotpLabel\").style.display = \'block\';\n\t\tdocument.getElementById(\"etrMotpLabel\").style.display = \'none\';\t\n\t\tdocument.getElementById(\"Otp\").disabled=true;\n\t\t\n\t\tdocument.getElementById(\"verCreateBtn\").disabled = true;\n\t\tdocument.getElementById(\"createOkBtn\").disabled = true;\n\t\t\n\t\tsearchFooter.style.display = \'none\';\n\t\tcreateFooter.style.display = \'block\';\n\t}\t\n}\n\nfunction formRequestData(request_type,request_option){\n\t\n\tvar patient_id = document.getElementById(\"patient_id\").value;\n\tvar facility_id = document.getElementById(\"facility_id\").value;\n\tvar logged_in_user = document.getElementById(\"logged_in_user\").value;\n\tvar logged_in_ws_no = document.getElementById(\"logged_in_ws_no\").value;\n\tvar session_id = document.getElementById(\"session_id\").value;\n\t\n\treturn \"<REQUEST_TYPE>\"+request_type+\"$!^<REQUEST_OPTION>\"+request_option+\"$!^<PATIENT_ID>\"+patient_id+\"$!^<FACILITY_ID>\"+facility_id+\"$!^<LOGGED_IN_USER_ID>\"+logged_in_user+\"$!^<LOGGED_IN_WSNO>\"+logged_in_ws_no+\"$!^<SESSION>\"+session_id+\"$!^\";\n}\n\nfunction search(){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\n\tvar mobileEle = document.getElementById(\"SearchMobileNo\");\n\tvar nameEle = document.getElementById(\"Name\");\n\tvar byEle = document.getElementById(\"BirthYear\");\n\t\n\tvar MobileNumber = mobileEle.value;\n\tvar Name = nameEle.value;\n\tvar BirthYear = byEle.value;\n\tvar Gender=\"\";\n    var genEle = document.getElementById(\"genSltId\");\n    Gender = genEle.value;\n\t\n    if(isDebugYN==\"true\")\n\t\talert(\'Search ABHA... mobile_no:\'+MobileNumber+\' Name:\'+Name+\' BirthYear:\'+BirthYear+\' Gender:\'+Gender);\n\t\n\tif(MobileNumber != null && MobileNumber !=\"\" && Name != null && Name !=\"\" \n\t\t\t&& BirthYear != null && BirthYear !=\"\" && Gender != null && Gender !=\"\"){\n\t\t\n\t\tmobileEle.disabled = true;\n\t\tnameEle.disabled = true;\n\t\tbyEle.disabled = true;\n\t\tgenEle.disabled = true;\n\t\tdocument.getElementById(\"searchBtn\").disabled = true;\n\t\t\n\t\tvar request_type=\"SEARCHABHAID\";\n\t\tvar request_option=\"BYDEMOAUTH\";\n\t\tvar request_data = formRequestData(request_type,request_option);\n\n\t\trequest_data = request_data+\"<MOBILE_NO>\"+MobileNumber+\"$!^<NAME>\"+Name+\"$!^<BIRTHOFYEAR>\"+BirthYear+\"$!^<GENDER>\"+Gender;\n\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\"requestData: \"+request_data);\n\t\t\n\t\t//var responseMsg = \'{\"authMethods\":[\"AADHAAR_OTP\",\"DEMOGRAPHICS\",\"AADHAAR_BIO\",\"MOBILE_OTP\"],\"healthIdNumber\":\"91-3171-3025-3881\",\"status\":\"ACTIVE\"}$!^S$!^ Success\';\n\t\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\'responseMsg: \'+responseMsg);\n\t\t\n\t\tvar resArray = responseMsg.split(\"$!^\");\n\t\tvar response = resArray[0];\n\t\tvar errorCode = resArray[1];\n\t\tvar errorMsg = resArray[2];\n\t\t\n\t\t$(\"#abhaIdInfoTable\").html(\"\");\n\t\tif(errorCode==\"S\" && response!=\"null\"){\n\t\t\tvar jsonResponse = jQuery.parseJSON(response);\n\t\t\tdocument.getElementById(\"abhaInfo\").value=response;\n\t\t\t\n\t\t\tvar tableData = \'[{\"ABHA Address\":\"\'+jsonResponse.healthId+\'\",\"Health ID\":\"\'+jsonResponse.healthIdNumber+\'\"}]\';\n\t\t\ttableData = jQuery.parseJSON(tableData);\n\t\t\t\n\t\t\tdocument.getElementById(\"abhaIdInfoTable\").style.display = \'block\';\t\t\n\t\t\t$(\"#abhaIdInfoTable\").append(\'<tr id=\"headerRow\"></tr>\');\n\t\t\t$.each(tableData[0], function(a, b) {\n\t\t\t\t$(\"#headerRow\").append(\'<th>\' + a + \'</th>\');\n\t\t\t});\n\t\n\t\t\t$.each(tableData, function(a, b) {\n\t\t\t\t$(\"#abhaIdInfoTable\").append(\'<tr id=\"\' + a + \'\"></tr>\');\n\t\t\t\tvar dataRowId = \'#\' + a;\n\t\t\t\t$.each(tableData[a], function(c, d) {\n\t\t\t\t\tif(d==\'undefined\'){\n\t\t\t\t\t\t$(dataRowId).append(\'<td>Not Available</td>\');\n\t\t\t\t\t}else{\n\t\t\t\t\t\t$(dataRowId).append(\'<td>\' + d + \'</td>\');\n\t\t\t\t\t}\n\t\t\t\t});\n\t\t\t});\n\t\t\t\n\t\t\tdocument.getElementById(\"searchOkBtn\").disabled = false;\n\t\t\tResponseMsg(\'green\',\'ABHA ID retrieved successfully!\');\n\t\t\t\n\t\t} else if(errorCode==\"F\" && response!=\"null\") {\n\t\t\t\n\t\t\tmobileEle.disabled = false;\n\t\t\tnameEle.disabled = false;\n\t\t\tbyEle.disabled = false;\n\t\t\tgenEle.disabled = false;\n\t\t\tdocument.getElementById(\"searchBtn\").disabled = false;\n\t\t\t\n\t\t\tif(response==\"\" || response==\"Failure\"){\n\t\t\t\tResponseMsg(\'red\',\'ABHA ID not found for the given criteria.\');\n\t\t\t}else{\n\t\t\t\tif(jQuery.parseJSON(response)){\n\t\t\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\t\t\n\t\t\t\t\tif(jObj.details[0].code!=null)\n\t\t\t\t\t\tResponseMsg(\'red\',jObj.details[0].code+\":\"+jObj.details[0].message);\n\t\t\t\t}else{\n\t\t\t\t\tResponseMsg(\'red\',response);\n\t\t\t\t}\n\t\t\t}\n\t\t\t\t\t\t\t\n\t\t}else{\n\t\t\tmobileEle.disabled = false;\n\t\t\tnameEle.disabled = false;\n\t\t\tbyEle.disabled = false;\n\t\t\tgenEle.disabled = false;\n\t\t\tdocument.getElementById(\"searchBtn\").disabled = false;\n\t\t\t\n\t\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t\t}\n\t}else {\n\t\tResponseMsg(\'red\',\'Enter all the mandatory details.\');\n\t}\n}\n\nfunction generateOTP(option){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\t\n\tvar mobileEle = document.getElementById(\"CreateMobileNo\");\n\tvar aadharEle = document.getElementById(\"AadhaarNo\");\n\tvar otpEle = document.getElementById(\"Otp\");\n\t\n\tvar mobile_no = mobileEle.value;\n\tvar aadhaar_no = aadharEle.value;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'Generate OPT... mobile_no:\'+mobile_no+\' aadhaar_no:\'+aadhaar_no+\' option: \'+option);\n\t\n\tif(option==\"GENERATEOTP\"){\n\t\n\t\tif(mobile_no!=null && mobile_no!==\"\" && aadhaar_no!=null && aadhaar_no!=\"\"){\n\t\t\tmobileEle.disabled=true;\n\t\t\taadharEle.disabled=true;\n\t\t\tdocument.getElementById(\"genOTPBtn\").disabled = true;\n\t\t\n\t\t\tvar request_type=\"CREATEABHAID\";\n\t\t\tvar request_option=option;\n\t\t\tvar request_data = formRequestData(request_type,request_option);\n\t\t\trequest_data = request_data+\"<AADHAAR_ID>\"+aadhaar_no+\"$!^<MOBILE_NO>\"+mobile_no;\n\t\t\t\n\t\t\tif(isDebugYN==\"true\")\n\t\t\t\talert(\"requestData: \"+request_data);\n\t\t\t\n\t\t\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\t\t\n\t\t\tif(isDebugYN==\"true\")\n\t\t\t\talert(\'responseMsg: \'+responseMsg);\n\t\t\t\n\t\t\tvar resArray = responseMsg.split(\"$!^\");\n\t\t\tvar response = resArray[0];\n\t\t\tvar errorCode = resArray[1];\n\t\t\tvar errorMsg = resArray[2];\n\t\t\t\n\t\t\tif(errorCode==\"S\" && response!=\"null\"){\n\t\t\t\tvar jsonResponse = jQuery.parseJSON(response);\n\t\t\t\t//alert(\'ParsedJson: \'+jsonResponse);\n\t\t\t\tdocument.getElementById(\"VerifyReqOption\").value = \"VERIFYOTP\";\n\t\t\t\tdocument.getElementById(\"txnId\").value = jsonResponse.txnId;\t\t\t\t\n\t\t\t\totpDiv.style.display = \'block\';\n\t\t\t\totpEle.disabled=false;\n\t\t\t\tResponseMsg(\'green\',\'OTP successfully sent to linked Aadhaar mobile number!\');\n\t\t\t\t\n\t\t\t} else if(errorCode==\"F\" && response!=\"null\") {\n\t\t\t\tmobileEle.disabled=false;\n\t\t\t\taadharEle.disabled=false;\n\t\t\t\tdocument.getElementById(\"genOTPBtn\").disabled = false;\n\t\t\t\t\n\t\t\t\tif(jQuery.parseJSON(response)){\n\t\t\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\t\t\n\t\t\t\t\tif(jObj.details[0].code!=null){\n\t\t\t\t\t\tvar resmsg = jObj.details[0].code+\":\"+jObj.details[0].message;\n\t\t\t\t\t\tResponseMsg(\'red\',resmsg);\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(jObj.details[0].code==\"HIS-1023\"){\n\t\t\t\t\t\t\tdocument.getElementById(\"genMobOTPBtn\").disabled = true;\n\t\t\t\t\t\t\totpEle.disabled=true;\n\t\t\t\t\t\t\tvar timerOn = document.getElementById(\'timerOn\').value;\n\t\t\t\t\t\t\tvar waitTime = document.getElementById(\'waitTime\').value;\n\t\t\t\t\t\t\ttimer(waitTime,timerOn,option);\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\tResponseMsg(\'red\',response);\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tmobileEle.disabled=false;\n\t\t\t\taadharEle.disabled=false;\n\t\t\t\tdocument.getElementById(\"genOTPBtn\").disabled = false;\n\t\t\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t\t\t}\n\t\t}else {\n\t\t\tResponseMsg(\'red\',\'Enter all the mandatory details.\');\n\t\t}\n\t}else if(option==\"GENERATEMOBILEOTP\"){\n\t\tdocument.getElementById(\"genMobOTPBtn\").disabled = true;\n\t\t\n\t\tvar txnId = document.getElementById(\"txnId\").value;\n\t\t\n\t\tvar request_type=\"CREATEABHAID\";\n\t\tvar request_option=option;\n\t\tvar request_data = formRequestData(request_type,request_option);\n\t\trequest_data = request_data+\"<TXN_ID>\"+txnId+\"$!^<MOBILE_NO>\"+mobile_no;\n\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\"requestData: \"+request_data);\n\t\t\n\t\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\'responseMsg: \'+responseMsg);\n\t\t\n\t\tvar resArray = responseMsg.split(\"$!^\");\n\t\tvar response = resArray[0];\n\t\tvar errorCode = resArray[1];\n\t\tvar errorMsg = resArray[2];\n\t\t\n\t\tif(errorCode==\"S\" && response!=\"null\"){\t\n\t\t\tdocument.getElementById(\"VerifyReqOption\").value = \"VERIFYMOBILEOTP\";\t\n\t\t\tdocument.getElementById(\"txnId\").value = jsonResponse.txnId;\t\t\t\t\n\t\t\totpDiv.style.display = \'block\';\n\t\t\totpEle.disabled=false;\n\t\t\tResponseMsg(\'green\',\'OTP successfully sent to this mobile number (\'+mobile_no+\').\');\n\t\t}else if(errorCode==\"F\" && response!=\"null\")  {\n\t\t\tdocument.getElementById(\"genMobOTPBtn\").disabled = false;\n\t\t\totpEle.disabled = false;\n\t\t\tif(jQuery.parseJSON(response)){\n\t\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\t\n\t\t\t\tif(jObj.details[0].code!=null){\n\t\t\t\t\tvar resmsg = jObj.details[0].code+\":\"+jObj.details[0].message;\n\t\t\t\t\tResponseMsg(\'red\',resmsg);\n\t\t\t\t\t\n\t\t\t\t\tif(jObj.details[0].code==\"HIS-1023\"){\n\t\t\t\t\t\tdocument.getElementById(\"genMobOTPBtn\").disabled = true;\n\t\t\t\t\t\totpEle.disabled=true;\n\t\t\t\t\t\tvar timerOn = document.getElementById(\'timerOn\').value;\n\t\t\t\t\t\tvar waitTime = document.getElementById(\'waitTime\').value;\n\t\t\t\t\t\ttimer(waitTime,timerOn,option);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tResponseMsg(\'red\',response);\n\t\t\t}\n\t\t}else{\n\t\t\tdocument.getElementById(\"genMobOTPBtn\").disabled = false;\n\t\t\totpEle.disabled = false;\n\t\t\tResponseMsg(\'red\',response);\n\t\t}\t\t\n\t}\n}\n\nfunction verifyOtpOrCreateAbha(){\n\t\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\t\n\tvar otpEle = document.getElementById(\"Otp\");\n\tvar otp = otpEle.value;\n\tvar txnId = document.getElementById(\"txnId\").value;\n\tvar VerifyReqOption = document.getElementById(\"VerifyReqOption\").value;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'Verify Otp / Create ABHA... otp:\'+otp+\' txnId:\'+txnId+\' option: \'+VerifyReqOption);\n\t\n\tvar verCreBtnEle = document.getElementById(\"verCreateBtn\");\n\tverCreBtnEle.disabled = true;\n\totpEle.disabled=true;\n\t\n\tvar request_type=\"CREATEABHAID\";\n\tvar request_option=VerifyReqOption;//\"VERIFYOTP\";\n\tvar request_data = formRequestData(request_type,request_option);\n\trequest_data = request_data+\"<OTP>\"+otp+\"$!^<TXN_ID>\"+txnId;\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\"requestData: \"+request_data);\n\t\n\tvar responseMsg = callABDM(request_type,request_option,request_data);\n\t\n\tif(isDebugYN==\"true\")\n\t\talert(\'responseMsg: \'+responseMsg);\n\t\n\tvar resArray = responseMsg.split(\"$!^\");\n\tvar response = resArray[0];\n\tvar errorCode = resArray[1];\n\tvar errorMsg = resArray[2];\n\t\n\tif(errorCode==\"S\" && response!=\"null\"){\n\t\t\n\t\tvar jObj = jQuery.parseJSON(response);\n\t\tvar name = jObj.name;\n\t\tvar gender = jObj.gender;\n\t\tvar dayOfBirth = jObj.dayOfBirth;\n\t\tvar monthOfBirth = jObj.monthOfBirth;\n\t\tvar yearOfBirth = jObj.yearOfBirth;\n\t\tvar healthIdNumber = jObj.healthIdNumber;\n\t\tvar mobile = jObj.mobile;\n\t\t\n\t\tvar email = \"Not Available\";\n\t\tif(jObj.email)\n\t\t\temail = jObj.email;\n\t\t\n\t\tvar tableData = \'[{\"Name\":\"\' + name +\'\",\"Gender\":\"\' + gender +\'\",\"DOB\":\"\' + dayOfBirth + \'/\' + monthOfBirth + \'/\' + yearOfBirth + \'\",\"ABHA ID\":\"\' + healthIdNumber + \'\",\"Mobile Numbrer\":\"\' + mobile + \'\",\"Email ID\":\"\' + email + \'\"}]\';\n\t\ttableData = jQuery.parseJSON(tableData);\n\t\t\n\t\tif(jObj.token!=null){\n\n\t\t\tdocument.getElementById(\"abhaInfo\").value = response;\n\t\t\t\n\t\t\tdocument.getElementById(\"abhaIdInfoTable\").style.display = \'block\';\n\t\t\t$(\"#abhaIdInfoTable\").append(\'<tr id=\"headerRow\"></tr>\');\n\t\t\t$.each(tableData[0], function(a, b) {\n\t\t\t\t$(\"#headerRow\").append(\'<th>\' + a + \'</th>\');\n\t\t\t});\n\n\t\t\t$.each(tableData, function(a, b) {\n\t\t\t\t$(\"#abhaIdInfoTable\").append(\'<tr id=\"\' + a + \'\"></tr>\');\n\t\t\t\tvar dataRowId = \'#\' + a;\n\t\t\t\t$.each(tableData[a], function(c, d) {\n\t\t\t\t\t$(dataRowId).append(\'<td>\' + d + \'</td>\');\n\t\t\t\t});\n\t\t\t});\n\t\t\t\n\t\t\tdocument.getElementById(\"otpDiv\").style.display=\'none\';\t\t\t\n\t\t\tdocument.getElementById(\"createOkBtn\").disabled = false;\n\t\t\t\n\t\t\tif(jObj.New){\n\t\t\t\tResponseMsg(\'green\',\'ABHA ID Created Successfully!\');\n\t\t\t}else{\n\t\t\t\tResponseMsg(\'green\',\'ABHA ID Details Retrieved Successfully!\');\n\t\t\t}\n\t\t}else if(jObj.txnId!=null){\n\t\t\tdocument.getElementById(\"VerifyReqOption\").value = \"VERIFYMOBILEOTP\";\t\n\t\t\tdocument.getElementById(\"txnId\").value = jObj.txnId;\t\t\t\t\n\t\t\totpDiv.style.display = \'block\';\n\t\t\tdocument.getElementById(\"etrAotpLabel\").style.display = \'none\';\n\t\t\tdocument.getElementById(\"etrMotpLabel\").style.display = \'block\';\n\t\t\totpEle.value = \"\";\n\t\t\totpEle.disabled=false;\n\t\t\tverCreBtnEle.disabled = true;\n\t\t\t\n\t\t\tvar mobile_no = document.getElementById(\"CreateMobileNo\").value;\n\t\t\tResponseMsg(\'green\',\'OTP successfully sent to this mobile number (\'+mobile_no+\').\');\n\t\t\t\n\t\t}else{\n\t\t\tverCreBtnEle.disabled = false;\n\t\t\totpEle.disabled=false;\n\t\t\tif(jQuery.parseJSON(response)){\n\t\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\t\n\t\t\t\tif(jObj.details[0].code!=null)\n\t\t\t\t\tResponseMsg(\'red\',jObj.details[0].code+\":\"+jObj.details[0].message);\n\t\t\t}else{\n\t\t\t\tResponseMsg(\'red\',response);\n\t\t\t}\n\t\t}\n\t\t\n\t} else if(errorCode==\"F\" && response!=\"null\")  {\n\t\tverCreBtnEle.disabled = false;\n\t\totpEle.disabled=false;\n\t\tif(jQuery.parseJSON(response)){\n\t\t\tvar jObj = jQuery.parseJSON(response);\n\t\t\n\t\t\tif(jObj.details[0].code!=null)\n\t\t\t\tResponseMsg(\'red\',jObj.details[0].code+\":\"+jObj.details[0].message);\n\t\t}else{\n\t\t\tResponseMsg(\'red\',response);\n\t\t}\n\t}else{\n\t\tverCreBtnEle.disabled = false;\n\t\totpEle.disabled=false;\n\t\tResponseMsg(\'red\',\'Unable to process response data, please check with your system administrator.\');\n\t}\n}\n\nfunction cancel(){\n\tvar returnVal = \"\";\n\t\t\n\t\t\n\t\twindow.returnValue=returnVal;\n\twindow.close();\n}\n\nfunction finish(option) {\n\tvar isDebugYN = document.getElementById(\"isDebugYN\").value;\n\t//var consent = document.getElementById(\"consent\")\").value;\n\t\n\t//if(consent){\n\t\tvar responseData = document.getElementById(\"abhaInfo\").value;\n\t\tvar aadhaar_no = document.getElementById(\"AadhaarNo\").value;\n\t\tvar returnVal = responseData+\"$!^\"+aadhaar_no+\"$!^\"+option;\n\t\t\n\t\tif(isDebugYN==\"true\")\n\t\t\talert(\"ReturnVal: \"+returnVal);\n\t\t\n\t\twindow.returnValue=returnVal;\n\t//}\t\n\twindow.close();\n}\n\nfunction otpValidation(evt) {\n\tvar val = document.getElementById(\"Otp\").value;\n\tif (val.length == 6) {\n\t\tdocument.getElementById(\"verCreateBtn\").disabled = false;\n\t} else {\n\t\tdocument.getElementById(\"verCreateBtn\").disabled = true;\n\t}\n\t\n\tvar retVal = numberValidation(evt);\n\t\n\treturn retVal;\n}\n\nfunction numberValidation(evt) {\n\t// Only ASCII character in that range allowed\n\tvar ASCIICode = (evt.which) ? evt.which : evt.keyCode;\n\tif (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))\n\t\treturn false;\n\t\n\treturn true;\n}\n\nfunction timer(remaining,timerOn,reqOption) {\n\t  var m = Math.floor(remaining / 60);\n\t  var s = remaining;\n\t  \n\t  m = m < 10 ? \'0\' + m : m;\n\t  s = s < 10 ? \'0\' + s : s;\n\t  document.getElementById(\'timer\').innerHTML = m + \':\' + s;\n\t  remaining -= 1;\n\t  \n\t  if(remaining >= 0 && timerOn) {\n\t    setTimeout(function() {\n\t        timer(remaining,timerOn,reqOption);\n\t    }, 1000);\n\t    return;\n\t  }\n\n\t  if(!timerOn) {\n\t    // Do validate stuff here\n\t    //alert(\'validate stuff\');\n\t    return;\n\t  }\n\t  \n\t  // Do timeout stuff here\n\t  document.getElementById(\'timer\').innerHTML = \"\";\n\t  if(reqOption==\"GENERATEOTP\"){\n\t\t  document.getElementById(\"genOTPBtn\").disabled = false;  \n\t  }else if(reqOption==\"GENERATEMOBILEOTP\"){\t\t  \n\t  \t  document.getElementById(\"genMobOTPBtn\").disabled = false;\n\t  }\n}\n\nfunction ResponseMsg(color,resMsg){\n\t$(\"#footerResId\").html(\"\");\n\t$(\"#footerResId\").append(\'<p id=\"resMsg\" style=\"color: \'+color+\';\">\'+resMsg+\'</p>\');\n}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n<body>\n<form name=\"linkHealthIDForm\" id=\"linkHealthIDForm\" method=\"post\" >\n\t<div class=\"content\">\n\t\t<table cellspacing=0 cellpadding=3>\n\t\t\t<tr>\n\t\t\t\t<td align=\"left\">\n\t\t\t\t\t<input type=\"radio\" id=\"searchRad\" name=\"searchRad\" id=\"searchRad\" value=\"SEARCHABHA\" onclick=\"SearchCreateEvent(this)\" checked /><label for=\"searchRad\">Search ABHA</label>\n\t\t\t\t\t<input type=\"radio\" id=\"createRad\" name=\"searchRad\" id=\"searchRad\" value=\"CREATEABHA\" onclick=\"SearchCreateEvent(this)\" /><label for=\"createRad\">Create ABHA</label>\n\t\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\n\t\t</table>\n\t\t<div id=\"searchDiv\" style=\"display: block;\">\t\t\n\t\t\t<table cellspacing=0 cellpadding=3>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t<td align=\"left\"><input type=\"number\" title=\"10 Digit mobile number Ex. 9840012345\" id=\"SearchMobileNo\" name=\"SearchMobileNo\" id=\"SearchMobileNo\" size=20 maxlength=10 value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' \n\t\t\t\t\t\tonkeyup=\"return numberValidation(event)\" onkeydown=\"return numberValidation(event)\" onkeypress=\"return numberValidation(event)\"></td>\n\t\t\t\t\t\n\t\t\t\t\t<td align=\"right\" class=\'label\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t<td align=\"left\"><input type=\"text\" id=\"Name\" name=\"Name\" id=\"Name\" size=20 value=\'\'></td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t<td align=\"left\"><input type=\"number\" id=\"BirthYear\" name=\"BirthYear\" id=\"BirthYear\" size=8 maxlength=4 value=\'\'\n\t\t\t\t\t\tonkeyup=\"return numberValidation(event)\" onkeydown=\"return numberValidation(event)\" onkeypress=\"return numberValidation(event)\"></td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t<select id=\"genSltId\" name=\"gender\" id=\"gender\">\n\t\t\t\t\t\t\t<option selected disabled value=\"\">Select Gender</option>\n\t\t\t\t\t\t\t<option value=\"M\">Male</option>\n\t\t\t\t\t\t\t<option value=\"F\">Female</option>\n\t\t\t\t\t\t\t<option value=\"U\">Unknown</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<td align=\"right\"><input id=\"searchBtn\" type=\"button\" class=\"button\" value=\"Search\" onclick=\"search()\"></td>\n\t\t\t\t\t<td align=\"right\"><input id=\"resetBtn\" type=\"button\" class=\"button\" value=\"Reset\" onclick=\"SearchCreateEvent(this)\"></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t\n\t\t<div id=\"createDiv\" style=\"display: none;\">\n\t\t\t<table cellspacing=0 cellpadding=3>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t<td align=\"left\"><input type=\"number\" title=\"10 Digit mobile number Ex. 9840012345\" id=\"CreateMobileNo\" name=\"CreateMobileNo\" id=\"CreateMobileNo\" size=20 maxlength=10 value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' \n\t\t\t\t\t\tonkeyup=\"return numberValidation(event)\" onkeydown=\"return numberValidation(event)\" onkeypress=\"return numberValidation(event)\"></td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t<td align=\"left\"><input type=\"text\" title=\"12 Digit Aadhaar number Ex. 123456789012\" id=\"AadhaarNo\" name=\"AadhaarNo\" id=\"AadhaarNo\" size=20 maxlength=12 value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' \n\t\t\t\t\t\tonkeyup=\"return numberValidation(event)\" onkeydown=\"return numberValidation(event)\" onkeypress=\"return numberValidation(event)\"></td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td align=\"right\"><input id=\"genOTPBtn\" type=\"button\" class=\"button\" value=\"Generate OTP\" onclick=\"generateOTP(\'GENERATEOTP\')\"></td>\n\t\t\t\t\t<td align=\"right\"><input id=\"genMobOTPBtn\" type=\"button\" class=\"button\" value=\"Generate Mobile OTP\" onclick=\"generateOTP(\'GENERATEMOBILEOTP\')\" style=\"display: none;\"></td>\n\t\t\t\t\t<td align=\"right\"><input id=\"resetBtn\" type=\"button\" class=\"button\" value=\"Reset\" onclick=\"fieldsReset(\'CREATEABHA\')\"></td>\t\t\t\t\t\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\t\t\t\n\t\t</div>\n\t\t</br>\n\t\t<hr style=\"border-top: 1px solid #bbb\">\n\t\t</br>\n\t\t<div id=\"abhaNumDiv\" style=\"text-align: center;display: none;width: 100%;\">\n\t\t\t<input id=\"abhaId\" name=\"abhaId\" id=\"abhaId\" style=\"display: block;\" value=\"\"/>\n\t\t</div>\n\t\t<div id=\"otpDiv\" style=\"text-align: center;display: none;width: 100%;\">\n\t\t\t<table cellspacing=0 cellpadding=3>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' id=\"etrAotpLabel\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td class=\'label\' id=\"etrMotpLabel\" style=\"display: none;\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td align=\"right\"><input type=\"number\" id=\"Otp\" name=\"Otp\" id=\"Otp\" size=10 maxlength=6 value=\'\' \n\t\t\t\t\t\tonkeydown=\"return otpValidation(event)\" onkeyup=\"return otpValidation(event)\" onkeypress=\"return otpValidation(event)\"></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<p id=\"timer\" style=\"color:blue;\"></p>\n\t\t</div>\n\t\t</br></br>\n\t\t<table id=\'abhaIdInfoTable\' border=1 cellspacing=0 cellpadding=3 align=\"center\" width=\"95%\"></table>\t\t\n\t</div>\n\t<div id=\"footer\">\n\t\t<div id=\"footerResId\" style=\"padding-left: 10px;float: left;text-align: left;\"><p id=\"resMsg\"></p></div>\n\t\t<div id=\"searchFooter\" style=\"width:40%;padding-right: 10px;\">\t\t\n\t\t\t<input type=\"button\" class=\"button\" value=\"Cancel\" onclick=\"cancel()\">\t\n\t\t\t<input id=\"searchOkBtn\" type=\"button\" class=\"button okBtn\" value=\"OK\" onclick=\"finish(\'SEARCH\')\" disabled>\n\t\t</div>\n\t\t<div id=\"createFooter\" style=\"width:60%;display: none;padding-right: 10px;\">\n\t\t\t<input type=\"button\" class=\"button\" value=\"Cancel\" onclick=\"cancel()\">\n\t\t\t<input id=\"verCreateBtn\" type=\"button\" class=\"button\" value=\"Verify OTP / Create ABHA\" onclick=\"verifyOtpOrCreateAbha()\">\n\t\t\t<input id=\"createOkBtn\" type=\"button\" class=\"button okBtn\" value=\"OK\" onclick=\"finish(\'CREATE\')\" disabled>\n\t\t</div>\n\t</div>\n\n\t<input type=\"hidden\" id=\"isDebugYN\" name=\"isDebugYN\" id=\"isDebugYN\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"> \n\t<input type=\"hidden\" id=\"txnId\" name=\"txnId\" id=\"txnId\" value=\"\"> \n\t<input type=\"hidden\" id=\"patient_id\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> \n\t<input type=\"hidden\" id=\"facility_id\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" id=\"logged_in_user\" name=\"logged_in_user\" id=\"logged_in_user\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"> \n\t<input type=\"hidden\" id=\"logged_in_ws_no\" name=\"logged_in_ws_no\" id=\"logged_in_ws_no\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"> \n\t<input type=\"hidden\" id=\"session_id\" name=\"session_id\" id=\"session_id\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"> \n\t<input type=\"hidden\" id=\"abhaInfo\" name=\"abhaInfo\" id=\"abhaInfo\" value=\"\">\n\t<input type=\"hidden\" id=\"timerOn\" name=\"timerOn\" id=\"timerOn\" value=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\n\t<input type=\"hidden\" id=\"waitTime\" name=\"waitTime\" id=\"waitTime\" value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n\t<input type=\"hidden\" id=\"VerifyReqOption\" name=\"VerifyReqOption\" id=\"VerifyReqOption\" value=\"\">\n</form>\n</body>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
	
	String aadhaar_no = checkForNull(request.getParameter("aadhaar_no"));
	String mobile_no = checkForNull(request.getParameter("mobile_no"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String logged_in_user = checkForNull(request.getParameter("logged_in_user"));
	String logged_in_ws_no = checkForNull(request.getParameter("logged_in_ws_no"));
	String session_id = checkForNull(request.getParameter("session_id"));
	boolean timerOn = true;
	String waitTime = "30";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( mobile_no ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( mobile_no ));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( aadhaar_no ));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(isDebugYN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(logged_in_user));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(logged_in_ws_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( timerOn ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( waitTime ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.BirthYear.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Gender.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.MobileNumber.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AadhaarNumber.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.EnterAadhaarOTP.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.EnterMobileOTP.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
