package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import eCA.ChartRecording.*;
import javax.rmi.*;
import webbeans.eCommon.MessageManager;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __recordcharts extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/RecordCharts.jsp", 1709118031255L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1_0 ="\n<!DOCTYPE html> \n<html>\n<head>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<link rel=\"stylesheet\" href=\"../css/iPadRecordCharts.css\" />\n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n \n<title></title>\n\n</head>\n<script>\nvar tempField;\n  function submitForm()\n  {\n\t  document.getElementById(\"hdnPostBack\").value = \"true\";\n\t  document.getElementById(\"frmRecordChart\").submit();\n  }\n  function cancelRecord(objBtn)\n  {\n\t  //document.getElementById(\"frmRecordChart\").submit(); \n\t   objBtn.style.border = \"3px solid #48d1d8\";\n\t  window.parent.showRecordChart();\n  }\n  function changeOrientation(orient)\n  {\n  \t\t//alert(orient);\n  \tif(orient == \"landscape\")\n  \t   {\n  \t//\tdocument.getElementById(\"dvNotesMenu\").style.min-height = \"492px\";\n  \t    $(\"#dvmain\").css(\'min-height\',\'512px\');\n  \t    \n\n\n  \t    \n  \t   }\n       else\n  \t   {\n      \t //alert(document.getElementById(\"dvNotesMenu\").style.min-height);\n      \t// document.getElementById(\"dvNotesMenu\").style.min-height = \"748px\";\n      \t$(\"#dvmain\").css(\'min-height\',\'768px\');\n  \n  \t   }\n   \n  }\n  function loadValues()\n  {\n\t  document.getElementById(\"cmbChartType\").value = document.getElementById(\"hdnChartTypeCombo\").value;\n\t \n\t  var tranState = document.getElementById(\"hdnTranState\").value;\n\t  var record = document.getElementById(\"hdnRecord\").value;\n\t  if(record == \"Record\")\n\t  {\n\t\t  document.getElementById(\"cmbChartType\").value = \"select\";\n\t\t\t  if(tranState == \"false\")\n\t\t\t  {\n\t\t\t\t alert(\"Operation Completed Successfully\") ;\n\t\t\t  }\n\t\t\t  else if(tranState == \"true\")\n\t\t\t  {\n\t\t\t\t    alert(\"Operation failed\") ;\n\t\t\t  }\n\t\t\t  else\n\t\t\t\t  {\n\t\t\t\t     alert(tranState);\n\t\t\t\t  }\n\t\t}\n\t  document.getElementById(\"hdnTranState\").value = \"\";\n\t  document.getElementById(\"hdnRecord\").value = \"\";\n\t  \n  }\n  function loadWidgets()\n  {\n  \twindow.parent.showLoadingMsg();\n  }\n  function allowValidNumberLocal3(fld,e){\n\t\tvar count=fld.value.length;//ok\n\t    var whichCode = (window.Event) ? e.which : e.keyCode;//ok\n\t\t//var whichCode = (window.Event) ? e.which : e.keyCode;\n\t\tif (whichCode == 13) return false; \n\t\t else return true;\n\t}\n  function allowValidNumberLocal2(fld, e, maxInt, deci)\n  {\n\n      var count=fld.value.length;//ok\n      var whichCode = (window.Event) ? e.which : e.keyCode;//ok\n     // alert(whichCode);\n    if(whichCode == 8)  \n    {\n    \t  return true;\n    }\n  \tvar minusOccurance = fld.value.indexOf(\'-\');\n  \tvar plusOccurance = fld.value.indexOf(\'+\');\n  \tif(minusOccurance != -1 || plusOccurance != -1)\n  \t{\n  \t\tmaxInt++;\n  \t\tfld.setAttribute(\"maxLength\",maxInt);\n  \t}\n  \telse\n  \t{\n  \t\tfld.setAttribute(\"maxLength\",maxInt);\n  \t}\n  \tif((whichCode == 45 && count>0) || (whichCode == 43 && count>0))\n  \t{\n  \t\treturn false\n  \t}\n\n      if(count >= maxInt)\n      {\n          \n  \t\treturn false;\n      }\n  \t\n  \t//you donot require this just var strCheck = \'.0123456789\' for deci > 0\n  \t//strCheck = \'0123456789\' for deci=0\n  \t      var strCheck = \'.0123456789-+\';\n\n//  \talert(e.getKeyCode())\n      if (parseInt(deci)==0)//For Only Nos 0 - 9\n          strCheck = \'0123456789-+\';\n\n      var fldvalue=fld.value;\n    //g  var whichCode = (window.Event) ? e.which : e.keyCode;\n    // if (whichCode == 13) return true;  // Enter     commented by Channaveer B\n      var pointCount=0;\n\n      for(var i=0;i<fldvalue.length;i++)\n      {\n          if(fldvalue.charAt(i)==\'.\') pointCount++;\n      }\n\n      if (pointCount>0 && whichCode == 46) return false;\n\n      var fldValue    =   fld.value;\n      var dotIndex    =   fldValue.indexOf(\".\");\n      var fldLength   =   fldValue.length;\n  \tvar count = 0;\n      if(dotIndex!=-1){\n         /* if( fldLength > (parseInt(dotIndex)+parseInt(deci)) )\n  \t\t\treturn false;*/\n  \t}\n\n\n  \tkey = String.fromCharCode(whichCode);  // Get key value from key code\n    \n  \tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n  \telse if((key == \"-\" && fldValue.indexOf(key) != -1) || (key == \"+\" && fldValue.indexOf(key) != -1) )\n  \t{\n  \t\tif(fldValue.indexOf(key) != 1 )\n  \t\t\treturn false\n  \t}\n      return true;\n  }\n  function validateNumber(obj,numdigitsdec,mindigits,minValue,maxValue,lowlevel,highlevel,rownumber,critlow,crithigh,cricLowStr,cricHighStr,lowStr,highStr)\n  {\n\t  tempField = obj;\n\t  var val = obj.value;\n\t  var msrId = $(obj).attr(\'data-discMsrId\');\n\t  //alert(msrId);\n\t\tif(isNaN(val))\n\t\t{\n\t\t\tobj.value = \"\";\n\t\t\treturn;\n\t\t}\n\t\tif(val.indexOf(\".\") != -1)\n\t\t{\n\t\t\tvar str = val.substring(val.indexOf(\".\")+1, val.length);\n\t\t\t\n\t\t\tif (parseInt(numdigitsdec) != 0 && (str.length) > parseInt(numdigitsdec) )\n\t\t\t{\t\n\t\t\t\tvar msg = \"Only \" + numdigitsdec + \" decimal digit(s) allowed\";//getMessage(\'VARIABLE_DEC_DIGIT\',\'CA\');\n\t\t\t\t//msg = msg.replace(\'@\',numdigitsdec);\n\t\t\t\talert(msg);\n\t\t\t\tobj.value = \'\';\n\t\t\t\t//obj.focus(); // this will work only in IE\n\t\t\t\t//setTimeout(\"tempField.focus();\",10);\n\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\t\tif(val != null && val != \'\' && minValue != \'\' && maxValue != \'\')\n\t\t{\n\t\t\tif(parseFloat(minValue) > val || parseFloat(maxValue) < val)\n\t\t\t{\n\t\t\t\tvar msg = \"The value of \" +msrId + \" should be between \" +minValue + \" and \" + maxValue;//getMessage(\"MIN_MAX_VALUE_RANGE\",\"CA\");\n\t\t\t\t//msg =msg.replace(\'(1)\',minValue);\n\t\t\t\t//msg =msg.replace(\'(2)\',maxValue);\n\t\t\t\talert(msg);\n\t\t\t\tobj.value=\'\';\n\t\t\t\t//obj.select();\n\t\t\t\t//obj.focus();\n\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t}\n\t\t//--------\n\t    if(val != null && val != \'\')\n\t\t{\n\t    \tvar colorIndicator = \"\"\n\t\t\tif((lowlevel != \'\' && parseFloat(lowlevel) != 0) && (highlevel != \'\' &&  parseFloat(highlevel) != 0)   && (critlow != \'\' && parseFloat(critlow) != 0) &&  (crithigh != 0 && parseFloat(crithigh) != \'\'))\n\t\t\t{\n\t\t\t\tif(parseFloat(val) >= parseFloat(critlow) && parseFloat(val) < parseFloat(lowlevel))\n\t\t\t\t\tcolorIndicator = lowStr;\n\t\t\t\telse if(parseFloat(val) > parseFloat(crithigh))\n\t\t\t\t\tcolorIndicator = cricHighStr;\n\t\t\t\telse if(parseFloat(val) < parseFloat(critlow))\n\t\t\t\t\tcolorIndicator = cricLowStr;\n\t\t\t\telse if(parseFloat(val) > parseFloat(highlevel) && parseFloat(val) <= parseFloat(crithigh))\n\t\t\t\t\tcolorIndicator = highStr;\n\t\t\t}// end of if\n\t\t\telse\n\t\t\t{\n\t\t\t\tif((lowlevel != \'\' && parseFloat(lowlevel) != 0))\n\t\t\t\t{\n\t\t\t\t\tif((critlow != \'\' && parseFloat(critlow) != 0))\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseFloat(val) < parseFloat(critlow)) \n\t\t\t\t\t\t\tcolorIndicator = cricLowStr;\n\t\t\t\t\t\telse if((parseFloat(val) >= parseFloat(critlow)) && (parseFloat(val) < parseFloat(lowlevel))) \n\t\t\t\t\t\t\tcolorIndicator = lowStr;\n\t\t\t\t\t}\n\t\t\t\t\telse if(parseFloat(val) < parseFloat(lowlevel)) \n\t\t\t\t\t\tcolorIndicator = lowStr;\n\t\t\t\t}\n\t\n\t\t\t\tif((highlevel != \'\' &&  parseFloat(highlevel) != 0))\n\t\t\t\t{\n\t\t\t\t\tif((crithigh != \'\' && parseFloat(crithigh) != 0))\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseFloat(val) > parseFloat(crithigh)) \n\t\t\t\t\t\t\tcolorIndicator = cricHighStr;\n\t\t\t\t\t\telse if((parseFloat(val) <= parseFloat(crithigh)) && (parseFloat(val) > parseFloat(highlevel))) \n\t\t\t\t\t\t\tcolorIndicator = highStr;\n\t\t\t\t\t}\n\t\t\t\t\telse if(parseFloat(val) > parseFloat(highlevel)) \n\t\t\t\t\t\tcolorIndicator = highStr;\n\t\t\t\t}\n\t\t\t}// end of else\n\t        /*\n\t\t\tif(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)\n\t\t\t{\n\t\t\t\tvar normal_abnormal_ind = eval(\"document.ChartLayoutDetailForm.normal_abnormal_ind_\"+rownumber);\n\t\t\t\tnormal_abnormal_ind.value=colorIndicator;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar normal_abnormal_ind = eval(\"document.chartRecordingAmendErrorForm.normal_abnormal_ind_\"+rownumber);\n\t\t\t\tnormal_abnormal_ind.value=colorIndicator ;\n\t\t\t}\n\t    \t*/\n\t    \tvar normal_abnormal_ind = \"normal_abnormal_ind_\" +rownumber;\n\t    \t//alert(normal_abnormal_ind);\n\t    \t//alert(document.getElementById(normal_abnormal_ind));\n\t    \tdocument.getElementById(normal_abnormal_ind).value = colorIndicator;\n\t\t}\n\t\t//--------\n\t\tif ( val != null && val != \'\')\n\t\t{\n\t\t\tvar val1=val;\n\t\t\tif(eval(mindigits) != 0) {\n\t\t\t\t\n\t\t\t\tif(val1.indexOf(\"-\")>=0)\n\t\t\t\t{\n\t\t\t\t\tval1 = val1.substr(val1.indexOf(\"-\")+1,val1.length);\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(val1.indexOf(\".\")>=0)\n\t\t\t\t{\n\t\t\t\t\tval1 = val1.substr(0, val1.indexOf(\".\"));\n\t\t\t\t}\n\t\t\t\tif(val1.length < eval(mindigits))  {\n\t\t\t\t\tvar short_desc_alert;\n\n\t\t\t\t\n\n\t\t\t\t\t//var message_alert=\"Please enter minimum\" + mindigits + \" digits\";//getMessage(\"MINIMUM_DIGITS\",\"CA\");\n\t\t\t\t\tvar message_alert=\"Minimum number of digits for \" + msrId + \" must be \" + mindigits;\n\t\t\t\t\t//message_alert=message_alert.replace(\'$\',short_desc_alert.value);\n\t\t\t\t\t//alert(message_alert+\' \'+mindigits);\t\n\t\t\t\t\talert(message_alert);\n\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\t//obj.focus();\n\t\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\t\t\t\t\t//obj.select();\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(!CheckForNumber1(val)) \n\t\t\t{\n\t\t\t\t//obj.focus();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t    var n = obj.value;\n\t\t\t\tif((n.indexOf(\".\")) >= 0)\n\t\t\t\t{\n\t\t\t\t\tif(numdigitsdec !=0 )  {\n\t\t\t\t\t\tvar arr =  new Array();\n\t\t\t\t\t\tarr = n.split(\".\");\n\t\t\t\t\t\tvar num = arr[0].length;\n\t\t\t\t\t\tvar frac = arr[1].length;\n\n\t\t                if (frac > numdigitsdec )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar msg = \"Decimal digits greate\";//getMessage(\"VARIABLE_DEC_DIGIT\",\"CA\");\n\t\t\t\t\t\t\t//msg = msg.replace(\"@\",numdigitsdec);\n\t\t\t\t\t\t\t//alert(msg);\n\t\t\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\t\t\t//obj.focus();\n\t\t\t\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\t\t\t\t\t\t}\n\t\t\t\t\t}else {\n\t\t\t\t\t\t//alert(\"No decimal\");\n\t\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\t\t//obj.focus();\n\t\t\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t}\n\t\t}\n  }\n  function CheckForNumber1(val) {\n\t  \n\t\t\treturn true;\n\t}\n  function displayDate(txtObj,rownumber)\n  {\n\t  //alert(\"hi\");\n\t // alert(txtObj);\n\t  var sHidden = \"comp_\" + rownumber;\n\t  document.getElementById(txtObj).value = document.getElementById(\"hdnCurrentDate\").value;\n\t // txtObj.value = document.getElementById(\"hdnCurrentDate\").value;\n\t  document.getElementById(sHidden).value = document.getElementById(\"hdnCurrentDate\").value;\n\t  \n  }\n  function displayDateTime(txtObj,rownumber)\n  {\n\t  //alert(\"hi\");\n\t // alert(txtObj);\n\t var sHidden = \"comp_\" + rownumber;\n\t  document.getElementById(txtObj).value = document.getElementById(\"hdnCurrentDateTime\").value;\n\t // txtObj.value = document.getElementById(\"hdnCurrentDate\").value;\n\t  document.getElementById(sHidden).value = document.getElementById(\"hdnCurrentDateTime\").value;\n\t  \n  }\n  function chkValidityOfTime(strfromTime)\n  {\n  \tif(strfromTime.value != \'\')\n  \t{\n  \t\tstrfromTimeVal = strfromTime.value;\n  \t\tstrTemp = strfromTimeVal.indexOf(\":\");\n  \t\tif(strTemp == -1 || strTemp != 2){\n  \t\t\talert(\"Invalid Time Format\");\n  \t\t\t//strfromTime.select();\n  \t\t\tstrfromTime.value = \"\";\n  \t\t\treturn false;\n  \t\t}\n  \t\telse\n  \t\t{\n";
    private final static byte[]  _wl_block1_0Bytes = _getBytes( _wl_block1_0 );

    private final static java.lang.String  _wl_block1_1 ="  \t\t\tcheckTimeForDetail(strfromTime);\n  \t\t}\n  \t}\n  }\n  function checkTimeForDetail(strfromTime)\n  {\n  \tstrfromTimeVal = strfromTime.value;\n  \tstrSplitTime = strfromTimeVal.split(\":\");\n  \thr = strSplitTime[0];\n  \tmin = strSplitTime[1];\n\n  \tif(strfromTime.value.length !=5)\n  \t{\n  \t\talert(\"Invalid Time Format\");\n  \t\t\t\t//strfromTime.select();\n  \t\t\t\tstrfromTime.value = \"\";\n  \t\treturn false;\n  \t}\n  \t\n  \tif(!(hr.charCodeAt(0) >= 48 && hr.charCodeAt(0) <=57 &&\n  \t\thr.charCodeAt(1) >= 48 && hr.charCodeAt(1) <=57 &&\n  \t\tmin.charCodeAt(0) >= 48 && min.charCodeAt(0) <=57 &&\n  \t\tmin.charCodeAt(1) >= 48 && min.charCodeAt(1) <=57  ))\n  \t\t{\n  \t\t    alert(\"Invalid Time Format\");\n  \t\t\t//strfromTime.select();\n  \t\t\tstrfromTime.value = \"\";\n  \t\t\treturn false;\n  \t\t}\n\n\n\n  \tif(hr>23){\n  \t\t  alert(\"Invalid Hour\");\n  \t\t//strfromTime.select();\n  \t\tstrfromTime.value = \"\";\n  \t\treturn false;\n  \t}\n  \tif(min>59){\n  \t\t  alert(\"Invalid minute\");\n  \t\t//strfromTime.select();\n  \t\tstrfromTime.value = \"\";\n  \t\treturn false;\n  \t}\n  \treturn true;\n  }\n  function displayFormula()\n  {\n\t  $(\"[data-summation = \'Y\']\").each(function(index, value) {      \n\t\t\t // console.log(\'div\' + index + \':\' + $(this).attr(\'id\')); \n\t\t\t //alert(index);data-discMsrId\n\t\t\t// alert($(this).val());\n\t\t\t//alert(\"hi\");\n\t\t\t   var rownumber = $(this).attr(\'data-rownumber\');\n\t\t\t   //alert(rownumber);\n\t\t\t   var SF = \"hdnSF\" + rownumber;\n\t\t\t   var formula =  document.getElementById(SF).value;\n\t\t\t  // alert(formula);\n\t\t\t   var sCompValue = \"comp_\" + rownumber;\n\t\t\t   var objHidden =  document.getElementById(sCompValue);\n\t\t\t   var objText = $(this);\n\t\t\t  // alert(objText);\n\t\t\t  // alert(index);\n\t\t\t  // alert(value);\n\t\t\t   var flag\n\t\t\t\tvar objTextValue  = \"\";\n\t\t\t\tif(formula != \'X\')\t\n\t\t\t\t{\n\t\t\t\t\tvar number = parseFloat(eval(formula))\n\t\t\t\t\t//alert(number);\n\t\t\t\t\tflag = \tisFinite(number)\n\t\t\t\t\tvar index = 0;\n\t\t\t\t\tif(flag == true)\n\t\t\t\t\t{\n\t\t\t\t\t\tnumber = number * 1000\n\t\t\t\t\t\tnumber = Math.round(number);\n\t\t\t\t\t\tnumber = number /1000;\n\t\t\t\t\t\t//objText.value = number\n\t\t\t\t\t\t//alert(objText.value);\n\t\t\t\t\t\tobjHidden.value = number;\n\t\t\t\t\t\t$(this).attr(\'value\', number);\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\t//objText.value = \"\"\n\t\t\t\t\t\t//objHidden.value = \"\"\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t \n\t\t\t \n\t  }); \n  }\n  function recordCharts(objBtn)\n  {\n\t  var brec = true;\n\t  objBtn.style.border = \"3px solid #48d1d8\";\n\t  $(\"[data-mandatory = \'Y\']\").each(function(index, value) {      \n\t\t // console.log(\'div\' + index + \':\' + $(this).attr(\'id\')); \n\t\t //alert(index);data-discMsrId\n\t\t// alert($(this).val());\n\t\t\n\t\t var msrId = $(this).attr(\'data-discMsrId\');\n\t\t var dataValue =  $(this).val();\n\t\t if(dataValue == null || dataValue == \"\")\n\t\t\t {\n\t\t\t   var msg = \"\" + msrId + \" Should Not Be Blank\";\n\t\t\t   if(brec)\n\t\t\t\t   {\n\t\t\t\t   alert(msg);\n\t\t\t\t   }\n\t\t\t   \n\t\t\t   brec = false;\n\t\t\t   return false;\n\t\t\t }\n\t\t \n\t\t  }\n\t  ); \n\t  \n\t  if(brec)\n\t\t  {\n\t\t     \n\t\t      \n\t           var count = document.getElementById(\"count\").value;\n\t           count =  parseInt(count);\n\t          // alert(\"count \" + count);\n\t           var index =0;\n\t           var bValuePresent = false;\n\t           for(index=0;index<count;index++)\n\t           {\n\t        \t   var msrtype = \"dis_msr_type_\" + index;\n\t        \t   var type = document.getElementById(msrtype).value;\n\t        \t  //alert(\"type \" + type);\n\t        \t   var cntrl = \"comp_\" + index\n\t        \t   var cntrlValue = document.getElementById(cntrl).value;\n\t        \t  //alert(\"cntrlvalue \" + cntrlValue);\n\t        \t   var lCntrl = \"listItemValue\" + index;\n\t        \t   var lCntrlValue = document.getElementById(lCntrl).value;\n\t        \t //alert(\"lcntrlvalue \" + lCntrlValue);\n\t        \t   if(type == \"N\" || type == \"A\" || type == \"I\" ||type == \"D\" || type == \"E\" || type == \"T\" || type == \"C\")\n\t        \t\t{\n\t        \t\t    if(cntrlValue != null && cntrlValue != \"\")\n\t        \t\t    \t{\n\t        \t\t    \t  bValuePresent = true;\n\t        \t\t    \t  break;\n\t        \t\t    \t}\n\t        \t\t}\n\t        \t   else if(type == \"L\")\n\t        \t\t{\n\t        \t\t   if(lCntrlValue != null && lCntrlValue != \"------Select------\" && lCntrlValue != \"Select\")\n\t       \t\t    \t{\n\t       \t\t    \t  bValuePresent = true;\n\t       \t\t    \t  break;\n\t       \t\t    \t}\n\t        \t\t}\n\t        \t   else\n\t        \t\t{\n\t        \t\t   if(cntrlValue != null && cntrlValue != \"\")\n\t       \t\t    \t{\n\t       \t\t    \t  bValuePresent = true;\n\t       \t\t    \t  break;\n\t       \t\t    \t}\n\t        \t\t}   \n\t        \t\t   \n\t           }\n\t           if(bValuePresent)\n\t        \t   {\n\t\t\t\t\t  document.getElementById(\"hdnPostBack\").value = \"true\";\n\t\t\t\t\t  document.getElementById(\"hdnRecord\").value = \"Record\";\n\t\t\t\t\t  document.getElementById(\"frmRecordChart\").submit();\n\t        \t   }\n\t           else\n\t        \t   {\n\t        \t     alert(\"Atleast one value should be entered\");\n\t        \t   }\n\t\t  }\n\t  objBtn.style.border = \"1px solid #48d1d8\";\n  }\n  function valueChange(obj,index)\n  {\n\t  var sHidden = \"comp_\" + index;\n\t  document.getElementById(sHidden).value = obj.value;\n\t // alert( document.getElementById(sHidden).value);\n\t  \n\t  \n  }\n  function evalCheckBox(objCheck,index)\n  {\n\t  var sHidden = \"comp_\" + index;\n  \tif(objCheck.checked==true)\n  \t\tdocument.getElementById(sHidden).value = \'Y\';\n  \t   \telse\n  \t   \tdocument.getElementById(sHidden).value =\'\';\n  }\t\n  function setComboValue(objcombo,rownumber)\n  {\n\t  var sHidden = \"listItemValue\" + rownumber;\n\t  var sCompValue = \"comp_\" + rownumber;\n\t  document.getElementById(sHidden).value = objcombo.options[objcombo.selectedIndex].text\n\t  document.getElementById(sCompValue).value = objcombo.value;\n\t  //alert(objcombo.value);\n\t // alert(document.getElementById(sHidden).value);\n\t // alert(document.getElementById(sCompValue).value);\n  }\n  function checkForNaN(obj,TextId,rownumber)\n  {\n\t  var formula = \"\";\n\t  // alert(formula);\n\t  // alert($(this));\n\t   \n\t  // alert($(this).attr(\"data-formula\"));\n\t  // formula = $(this).attr(\'data-formula\');\n\t  \n\t   var objText = document.getElementById(TextId);\n\t   var sCompValue = \"comp_\" + rownumber;\n\t   var SF = \"hdnSF\" + rownumber;\n\t   var objHidden =  document.getElementById(sCompValue);\n\t   var SFId = document.getElementById(SF).value;\n\t   //formula = SFId;\n\t   formula = $(obj).attr(\'data-formula\');\n\t  // alert(formula);\n\t    var flag\n\t\tvar objTextValue  = \"\";\n\t\tif(formula != \'X\')\t\n\t\t{\n\t\t\tvar number = parseFloat(eval(formula))\n\t\t\t//alert(number);\n\t\t\tflag = \tisFinite(number)\n\t\t\tvar index = 0;\n\t\t\tif(flag == true)\n\t\t\t{\n\t\t\t\tnumber = number * 1000\n\t\t\t\tnumber = Math.round(number);\n\t\t\t\tnumber = number /1000;\n\t\t\t\tobjText.value = number\n\t\t\t\tobjHidden.value = number\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tobjText.value = \"\"\n\t\t\t\tobjHidden.value = \"\"\n\t\t\t}\n\t\t}\n  }\n</script>\n<body onload = \"loadValues()\">\n<section data-role = \"page\" style = \"padding:0px;background:#ffffff\">\n <form name = \"frmRecordChart\" id = \"frmRecordChart\" method = \"post\">\n    <div data-role = \"none\" class =\'divmain\' id = \'dvmain\'  style=\"padding:0px\" >\n\t     <div data-role = \"none\" class = \"dvRecordChart\">\n\t\t     <table style=\"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t       <tr style=\"width:100%;height:100%\">\n\t\t         <td style = \"width : 95%\" align = \"left\"  valign = \"center\">\n\t\t            <span class = \"spanRecordChart\">Record Charts</span>\n\t\t            \n\t\t         </td> \n\t\t         <td style=\"width:5%\" align = \"center\" valign = \"middle\"  onclick = \"loadWidgets()\" >\n\t\t         <img src = \"../images/Close.png\"></img>\n\t\t         </td>\n\t\t       </tr>\n\t\t     </table>\n\t    </div>\n\t    <div id = \"dvCriteria\" class = \"dvCriteria\" data-role = \"none\">\n\t      <table style=\"height:68px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t     <tr style=\"height:30px;width:100%\">\n\t\t\t\t\t      <td align = \"left\" style=\"width:34%\"><span class = \"spanFilterBy\">Select Chart</span></td>\n\t\t\t\t\t      <td align = \"left\" style=\"width:33%\">             \n\t\t\t\t\t      </td>\n\t\t\t\t\t      <td align = \"left\" style=\"width:33%\">\n\t\t\t\t\t      </td>  \n\t\t\t\t     </tr>\n\t\t\t\t     <tr style=\"height:35px;width:100%\">\n\t\t\t\t\t      <td align = \"left\" style=\"width:34%\">\n\t\t\t\t\t        <select  class=\"cmbFilterBy\" data-role=\"none\" id=\"cmbChartType\" name = \"cmbChartType\" onchange = \"submitForm()\"> \n\t\t           \n\t\t                                           <option value=\"select\">Select</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block1_1Bytes = _getBytes( _wl_block1_1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <option value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t            </select> \n\t\t\t\t\t      </td>\n\t\t\t\t\t     <td align = \"left\" style=\"width:33%\" valign = \"middle\"></td>\n\t\t\t\t\t     <td align = \"center\" style=\"width:33%\"> </td>\n\t\t\t\t     </tr>\n\t\t\t\t     \n\t\t\t\t     \n\t\t\t\t     <tr style=\"height:3px;width:100%\">\n\t\t\t\t        <td>&nbsp;</td>\n\t\t\t\t     </tr>\n\t\t\t   </table>\n\t   </div>\n\t    <div data-role = \"none\" id = \"dvChartFields\" class = \"dvChartFields\" >\n\t    \n\t     <table style = \"width:100%;height:44px\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t    \t <tr class = \"dvRecordChart\">\n\t    \t    <td  class = \"CFirstCol\" valign = \"center\" align = \"left\"> \n\t    \t      <span class = \"spChartHeader\" >Event</span>\n\t    \t    </td>\n\t    \t     <td class = \"CSecCol\" valign = \"center\" align = \"left\"> \n\t    \t       <span class = \"spChartHeader\">Value</span>\n\t    \t     </td>\n\t    \t     <td class = \"CThirdCol\" valign = \"center\" align = \"left\">\n\t    \t     <span class = \"spChartHeader\">Unit</span>\n\t    \t     </td>\n\t     \t </tr>\n\t     </table>\n\t     ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t\t\t<table style = \"width:100%;height:20px\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t\t\t\t\t    \t <tr class = \"trChartGroup\">\n\t\t\t\t\t\t\t\t\t    \t    <td  style = \"width:100%\" valign = \"center\" align = \"left\"> \n\t\t\t\t\t\t\t\t\t    \t      <span class = \"spChartRow\" >";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span>\n\t\t\t\t\t\t\t\t\t    \t    </td>\n\t\t\t\t\t\t\t\t\t    \t   \n\t\t\t\t\t\t\t\t\t     \t </tr>\n\t\t\t\t\t\t\t\t\t     </table>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t  <table style = \"width:100%;height:40px\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t\t\t\t    \t <tr class = \"trChartRows";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t\t\t\t\t\t    \t    <td  class = \"CFirstCol\" valign = \"center\" align = \"left\"> \n\t\t\t\t\t\t\t\t    \t      <span class = \"spChartRow\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span>\n\t\t\t\t\t\t\t\t    \t    </td>\n\t\t\t\t\t\t\t\t    \t     <td class = \"CSecCol\" valign = \"center\" align = \"left\"> \n\t\t\t\t\t\t\t\t    \t       ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t    \t    \t    <input type = \"textbox\"   data-role = \"none\" onchange = \"valueChange(this,\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" data-discMsrId = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name = \"custom_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id = \"custom_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  data-mandatory = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" class = \"txtChart\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" maxLength= \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onkeypress=\"return allowValidNumberLocal2(this, event, \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\" onblur = \"validateNumber(this,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');displayFormula()\" />\n\t\t\t\t\t\t\t\t    \t    \t    \n\t\t\t\t\t\t\t\t    \t    \t   ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t    \t    \t   <img  src=\'../images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t\t    \t    \t    ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t    \t    \t\t     <input type = \"textbox\"  data-discMsrId = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" data-role = \"none\" readonly class = \"txtChartD\" name = \"custom_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" /><input type =\"button\"  value=\'Now\' class=\"btnTypeD\"  data-role = \"none\" onclick = \"displayDate(\'custom_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\"/>\n\t\t\t\t\t\t\t\t    \t    \t\t     \n\t\t\t\t\t\t\t\t    \t    \t\t  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t    \t    \t   <img  src=\'../images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t\t\t    \t    \t    ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t    \t    \t\t    <input type = \"textbox\"   onchange = \"valueChange(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" data-role = \"none\" maxLength= \"5\" class = \"txtChartD\" name = \"custom_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onblur = \"chkValidityOfTime(this)\" />\n\t\t\t\t\t\t\t\t    \t    \t\t  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t    \t    \t\t     <input type = \"textbox\"    data-discMsrId = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" /><input type =\"button\"  value=\'Now\' class=\"btnTypeD\"  data-role = \"none\" onclick = \"displayDateTime(\'custom_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\"/>\n\t\t\t\t\t\t\t\t    \t    \t\t  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t    \t    \t\t  <input type = \"textbox\"   onchange = \"valueChange(this,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\')\" data-summation = \"Y\" data-rownumber = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" data-discMsrId = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" data-role = \"none\"  class = \"txtChartD\" name = \"custom_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" />\n\t\t\t\t\t\t\t\t    \t    \t\t  <input type =\"button\"  value=\'+\' class=\"btnTypeA\"   data-formula = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" data-role = \"none\" onclick = \"checkForNaN(this,\'custom_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\')\" />\n\t\t\t\t\t\t\t\t    \t    \t\t  ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t    \t    \t\t <input type = \"textbox\"   onchange = \"valueChange(this,\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\" data-role = \"none\" data-discMsrId = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" class = \"txtChart\" maxLength= \"20\" onkeypress=\"return allowValidNumberLocal3(this, event)\"  />   \n\t\t\t\t\t\t\t\t    \t    \t\t  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t    \t    \t   <input type = \"checkbox\" data-role = \"none\"  class = \"chkChart\"  onclick = \"evalCheckBox(this,\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\')\"/>  \n\t\t\t\t\t\t\t\t    \t    \t  \n\t\t\t\t\t\t\t\t    \t    \t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t    \t    \t      <select  class=\"cmbChart\" data-role=\"none\" onchange = \"setComboValue(this,\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\" data-combo = \"yes\"> \n\t\t\t\t\t\t\t\t    \t    \t      <option value=\'\'>Select</option>\n\t\t\t\t\t\t\t\t    \t    \t   ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t    \t    \t\t\t\t\t    <option value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option> \n\t\t\t\t\t\t\t\t    \t    \t\t\t\t\t   ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t    \t    \t   </select>\n\t\t\t\t\t\t\t\t    \t    \t   ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t    \t      \n\t\t\t\t\t\t\t\t    \t       \n\t\t\t\t\t\t\t\t    \t     </td>\n\t\t\t\t\t\t\t\t    \t     <td class = \"CThirdCol\" valign = \"center\" align = \"left\">\n\t\t\t\t\t\t\t\t    \t        <span class = \"spChartRow\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</span>\n\t\t\t\t\t\t\t\t    \t     </td>\n\t\t\t\t\t\t\t\t     \t </tr>\n\t\t\t\t\t\t\t\t     </table>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"discr_msr_id_grp_id";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"discr_msr_id_grp_id";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" value= \"custom_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" />\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"dis_msr_type_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"dis_msr_type_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"dis_msr_id_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"dis_msr_id_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id =\"dis_msr_id_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" />\n\t\t\t\t\t\t\t\t\t <input type= \"hidden\" name=\"chat_grp_id_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"chat_grp_id_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id =\"chat_grp_id_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"comp_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"comp_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id = \"comp_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"  value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"/>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"normal_low_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"normal_low_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id =\"normal_low_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" value= \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"/>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"normal_high_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"normal_high_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id =\"normal_high_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"/>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"critical_low_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"critical_low_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id =\"critical_low_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"/>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"critical_high_";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"critical_high_";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id =\"critical_high_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"/>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"associate_score_yn";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"associate_score_yn";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id =\"associate_score_yn";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" />\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"normal_abnormal_ind_";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"normal_abnormal_ind_";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id =\"normal_abnormal_ind_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" />\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"listItemValue";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"listItemValue";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id =\"listItemValue";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" value = \"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"/>\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"uom_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" id=\"uom_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"hdnSF";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id=\"hdnSF";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" id =\"hdnSF";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/>\n\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t     \n\t      \n\t    \n\t   </div>\n\t\n    </div>\n       <div class = \"dvRecordControls\">\n\t      <table class = \"tbRecordControls\" cellspacing = \"0\" cellpadding = \"0\" border = \"0\">\n\t        <tr class = \"trRecordControls\">\n\t          <td style = \"width:55%\"></td>\n\t          <td style =\"width:15%\" valign = \"center\" align = \"right\">\n\t            <!--  <input type =\"button\" name=\'btnVwHist\' id=\'btnVwHist\' value=\'View History\' class=\"btnType1\"  data-role = \"none\"/> -->\n\t          </td>\n\t           <td style =\"width:15%\" valign = \"center\" align = \"center\">\n\t              <input type =\"button\" name=\'btnRecord\' id=\'btnRecord\' value=\'Record\' class=\"btnType1\"  data-role = \"none\" onclick = \"recordCharts(this)\"/>\n\t           </td>\n\t            <td style =\"width:15%\" valign = \"center\" align = \"left\">\n\t              <input type =\"button\" name=\'btnCancel\' id=\'btnCancel\' value=\'Cancel\' class=\"btnType1\"  data-role = \"none\" onclick = \"cancelRecord(this)\"/>\n\t            </td>\n\t        </tr>\n\t      </table>\n       </div>\n    <input type = \"hidden\" name = \"hdnPostBack\" id = \"hdnPostBack\" value = \"false\" />\n    <input type = \"hidden\" name = \"hdnChartTypeCombo\" id = \"hdnChartTypeCombo\" value = \"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"/>\n    <input type = \"hidden\" name = \"hdnCurrentDate\" id = \"hdnCurrentDate\" value = \"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"/>\n    <input type = \"hidden\" name = \"hdnCurrentDateTime\" id = \"hdnCurrentDateTime\" value = \"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"/>\n     <input type = \"hidden\" name = \"count\" id = \"count\" value = \'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'/>\n     <input type = \"hidden\" name = \"hdnRecord\" id = \"hdnRecord\" value = \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"/>\n    <input type = \"hidden\" name = \"hdnPatientId\" id = \"hdnPatientId\" value = \"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" /> \n    <input type = \"hidden\" name = \"hdnTranState\" id = \"hdnTranState\" value = \"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" />\n    <input type = \"hidden\" name = \"hdnPatientClass\" id = \"hdnPatientClass\" value = \"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" />\n    \n     \n    \n </form>\n</section>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

private String insertRecord(HttpServletRequest request,java.util.Properties p, HttpSession session)
{
	//PrintWriter out;
	//java.util.Properties p;
	
	String sStyle = "";

	
	//if(session.getValue("jdbc") != null)
	//{
	//   p = (java.util.Properties) session.getValue("jdbc") ;
	//}
	
	StringBuffer replaceString = null;
	Connection con = null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmtSelect=null;
	CallableStatement cs = null;
	String sysdate = "";
	ResultSet rs=null;
	//List<String> oTransResultList = new ArrayList<String>();
	//p = (java.util.Properties) session.getValue("jdbc") ;
	String locale		= "en";//(String) p.getProperty("LOCALE");
	HashMap hashRecord = new HashMap();
	boolean bool = false;
	String disMsrId = "", disMsrResultType = "",  uom = "", normalLow = "",normalHigh = "",criticalLow = "",criticalHigh = "",normalAbnormalInd ="",chartGrpId = "",resultNum="",resultStr="",result_prefix="", remarks="";
	boolean flag=true;
	String taskSrlNo = request.getParameter("taskSrlNo") == null ? "" : request.getParameter("taskSrlNo");
	if(taskSrlNo.equals("null"))
	taskSrlNo = "";
	hashRecord.put("taskSrlNo",taskSrlNo);
	String taskCode = request.getParameter("taskCode") == null ? "" : request.getParameter("taskCode");
	if(taskCode.equals("null"))
	taskCode = "";
	hashRecord.put("taskCode",taskCode);
	String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
	hashRecord.put("facilityId",facilityId);
	String practitionerId = (String)	session.getValue("ca_practitioner_id")==null ? "" :(String)	session.getValue("ca_practitioner_id");
	hashRecord.put("practitionerId",practitionerId);
	String function_from = request.getParameter("function_from")==null ? "" : request.getParameter("function_from");
	hashRecord.put("function_from",function_from);
	String addedById   = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
	hashRecord.put("addedById",addedById);
	String addedAtWSNo = "IPAD";//p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
	hashRecord.put("addedAtWSNo",addedAtWSNo);
	//String encounterId = request.getParameter("episode_id")==null ? "0" :request.getParameter("episode_id");
	String encounterId = (String)session.getValue("EpisodeId") == null ? "" : (String)session.getValue("EpisodeId");
	if(encounterId.equals("")) encounterId = "0";
	hashRecord.put("encounterId",encounterId);
	String patientId = request.getParameter("hdnPatientId")==null ? "" :request.getParameter("hdnPatientId");
	hashRecord.put("patientId",patientId);

	String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null ? "" :request.getParameter("contr_mod_accession_num");
	hashRecord.put("contr_mod_accession_num",contr_mod_accession_num);
	String module_id = request.getParameter("module_id")==null ? "" :request.getParameter("module_id");
	hashRecord.put("module_id",module_id);

	//String patientClass = "IP"; //request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
	String patientClass =  request.getParameter("hdnPatientClass")==null ? "" : request.getParameter("hdnPatientClass");
	hashRecord.put("patientClass",patientClass);
	String chartId = request.getParameter("cmbChartType")==null ? "" :request.getParameter("cmbChartType");
	hashRecord.put("chartId",chartId);
	String recTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);//request.getParameter("rec_time")==null ? "" : request.getParameter("rec_time");
	
	recTime		= com.ehis.util.DateUtils.convertDate(recTime,"DMYHM",locale,"en");
	hashRecord.put("recTime",recTime);

	String errorMsg = "";
	String count = request.getParameter("count") == null ? "0" : request.getParameter("count") ;
	int counter = Integer.parseInt(count);
	hashRecord.put("count",count);
	//boolean bTranResult = false;
	String bTranResult = "false";
	try
	{
		con  = ConnectionManager.getConnection(request);
		con.setAutoCommit(false);
		String query = "";
		
		/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
		String chartType = "";
		
		query = "SELECT SPL_CHART_TYPE FROM CA_CHART WHERE CHART_ID = ?";
		pstmtSelect = con.prepareStatement(query);
		pstmtSelect.setString(1,chartId);
		rs = pstmtSelect.executeQuery();
		while(rs.next())
		{
			chartType = rs.getString("SPL_CHART_TYPE") == null ? "" : rs.getString("SPL_CHART_TYPE");
		}

		if(rs != null) rs.close();
		if(pstmtSelect != null) pstmtSelect.close();
		query = "";

		/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
	
		if(!function_from.equals("CP"))
		{
		query = "select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  >= to_date(?,'dd/mm/yyyy hh24:mi') and rownum=1 AND DISCR_MSR_RESULT_TYPE!='S' ";
//		union  select 1 from dual where to_date(?,'dd/mm/yyyy hh24:mi') > SYSDATE ) ";
		}
		else
		{
			query = " select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  = to_date(?,'dd/mm/yyyy hh24:mi') AND DISCR_MSR_RESULT_TYPE!='S' ";
		}
		
		
		pstmtSelect = con.prepareStatement(query);
		pstmtSelect.setString(1,encounterId);
		pstmtSelect.setString(2,facilityId);
		pstmtSelect.setString(3,chartId);
		pstmtSelect.setString(4,recTime);

		rs= pstmtSelect.executeQuery();
		while(rs.next())
		{
			flag=false;
			break;
		}
		if(pstmtSelect !=null) pstmtSelect.close();
		if(rs != null)rs.close();

			sysdate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			if(flag==true)
			{
				for(int i=0;i<counter;i++)
				{
					resultStr="";
					resultNum="";
					disMsrResultType = request.getParameter("dis_msr_type_"+i)==null ? "":request.getParameter("dis_msr_type_"+i);

					hashRecord.put("dis_msr_type_"+i,disMsrResultType);
					 if(disMsrResultType.equals("N")||disMsrResultType.equals("A")||disMsrResultType.equals("S")||disMsrResultType.equals("I"))	 
					{
						resultNum = request.getParameter("comp_"+i)==null ? "":request.getParameter("comp_"+i);
						hashRecord.put("comp_"+i,resultNum);
						result_prefix = request.getParameter("result_prefix"+i)==null ? "":request.getParameter("result_prefix"+i);
						hashRecord.put("result_prefix"+i,result_prefix);
					}
				else	if(disMsrResultType.equals("L"))	 
					{

							resultStr = request.getParameter("listItemValue"+i)==null ? "":request.getParameter("listItemValue"+i);
							if(resultStr.equals("------Select------")) resultStr = "";
							resultNum = request.getParameter("comp_"+i)==null ? "": request.getParameter("comp_"+i);
							hashRecord.put("comp_"+i,resultNum);	
							hashRecord.put("listItemValue"+i,resultStr);
					}
					 else
					{
						resultStr = request.getParameter("comp_"+i)==null ? "": request.getParameter("comp_"+i);

						if(disMsrResultType.equals("D") )	 
							resultStr = com.ehis.util.DateUtils.convertDate(resultStr,"DMY",locale,"en");
						else if(disMsrResultType.equals("E") )	 
							resultStr = com.ehis.util.DateUtils.convertDate(resultStr,"DMYHM",locale,"en");

						hashRecord.put("comp_"+i,resultStr);	
					}
					disMsrId = request.getParameter("dis_msr_id_"+i)==null ? "":request.getParameter("dis_msr_id_"+i) ;
					hashRecord.put("dis_msr_id_"+i,disMsrId);	
					uom = request.getParameter("uom_"+i)==null ? "":request.getParameter("uom_"+i);
					hashRecord.put("uom_"+i,uom);	
					normalLow = request.getParameter("normal_low_"+i)==null ? "": request.getParameter("normal_low_"+i);
					hashRecord.put("normal_low_"+i,normalLow);	
					normalHigh = request.getParameter("normal_high_"+i)==null ? "":request.getParameter("normal_high_"+i);
					hashRecord.put("normal_high_"+i,normalHigh);	
					criticalLow = request.getParameter("critical_low_"+i)==null ? "":request.getParameter("critical_low_"+i);
					hashRecord.put("critical_low_"+i,criticalLow);	
					criticalHigh = request.getParameter("critical_high_"+i)==null ? "":request.getParameter("critical_high_"+i);
					hashRecord.put("critical_high_"+i,criticalHigh);	
					normalAbnormalInd = request.getParameter("normal_abnormal_ind_"+i)==null ? "":request.getParameter("normal_abnormal_ind_"+i);
					hashRecord.put("normal_abnormal_ind_"+i,normalAbnormalInd);	
					chartGrpId = request.getParameter("chat_grp_id_"+i)==null ? "":request.getParameter("chat_grp_id_"+i);
					hashRecord.put("chat_grp_id_"+i,chartGrpId);
					remarks = request.getParameter("remarksField"+i)==null ? "":request.getParameter("remarksField"+i);
					hashRecord.put("remarksField"+i,remarks);
//					hashRecord.put("locale_"+i,locale);
					
				}//for
				boolean local_ejbs = false;
				
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ChartRecording",ChartRecordingManager.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[3];

				argArray[0] = p;
				argArray[1] = hashRecord;
				argArray[2] = locale;

				Class paramArray[] = new Class[3];

				paramArray[0] = p.getClass();
				paramArray[1] = hashRecord.getClass();;
				paramArray[2] = locale.getClass();
					
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertChartRecords",
				paramArray)).invoke(busObj,argArray);


				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				bool = ((Boolean)results.get("results")).booleanValue();
				//bTranResult = bool;
				
				if(!bool)
				{
					bTranResult = "false";
				}
				else
				{
					bTranResult = "true";
				}
				
				//if(bTranResult == false)
				//int chk = 0 ;
				//int pi = 5/chk ;
				if(bool == false)	
				{
					try
					{
						if(chartType.equals("GR"))
						{
							cs = con.prepareCall("{call CABUILDSPLCHART.GR(?,?)}");
							cs.setString(1,patientId);
							cs.setString(2,chartId);
							cs.execute();

							con.commit();
						}					
					}
					catch (Exception proc)
					{
						//proc.printStackTrace(System.err);
						bTranResult = proc.toString();
					}
				}
			}
			//con.commit();
	}
	catch(Exception e)
	{
		try{
		con.rollback();
		}catch(Exception ee)
		{}
		//e.printStackTrace(System.err);
		//out.println("Exception in try2 of RecordCharts.jsp" +e.toString());
		bTranResult = "Exception in try2 of RecordCharts.jsp" +e.toString();
	}
	finally
	{
		try{
			if(rs!=null)rs.close();
			if(cs!=null)cs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
				ConnectionManager.returnConnection(con,p);
		}
		catch(Exception e)
		{
			bTranResult = "Exception in try3 of RecordCharts.jsp" +e.toString();
		}
	}
	
	hashRecord.clear();
	return bTranResult;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
 
request.setCharacterEncoding("UTF-8");

String locale = "en";
String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String strPracType = "";
String strPostBack = "";
String strInterval = "";
String strPatientId = "";
String strEncounterId = "";
String strChartType = "";
PatientContext oPatientContext = new PatientContext();
oPatientContext.request = request;
String strRowCount = "";
String strCurrentDate = "";
String strCurrentDatetime = "";
String strRecord = "";
int nListSize1 = 0;
String normalInd = "";
String strPatientClass = "";
//boolean recInsert = false;
String recInsert = "false";

if(session.getValue("facility_id") != null )
{
	oPatientContext.sFacilityId = (String)session.getValue("facility_id");
}
if(session.getValue("ca_practitioner_id") != null)
{
	oPatientContext.sClinicianId  = (String)session.getValue("ca_practitioner_id");
}
if(session.getValue("practitioner_type") != null )
{
	oPatientContext.sPracType = (String)session.getValue("practitioner_type");
}
if(session.getValue("PatientID") != null)
{
	oPatientContext.sPatientId = (String)session.getValue("PatientID");
}
if(session.getValue("EpisodeId") != null )
{
	oPatientContext.sEncounterId = (String)session.getValue("EpisodeId");
}
if(session.getValue("Gender") != null )
{
	oPatientContext.sGender = (String)session.getValue("Gender");
}
if(session.getValue("DOB") != null )
{
	oPatientContext.sDob = (String)session.getValue("DOB");
}
if(request.getParameter("cmbChartType") != null )
{
	strChartType = request.getParameter("cmbChartType");
}
if(request.getParameter("patclass") != null )
{
	strPatientClass = request.getParameter("patclass");
}

ChartDetails oChartDetails = new ChartDetails();
List<ChartType> oChartList = new ArrayList<ChartType>(); 
int nListSize = 0;
int nLoopCount = 0;

strPostBack = request.getParameter("hdnPostBack");
strCurrentDate = DateUtils.getCurrentDate("DMY", locale);
strCurrentDatetime = DateUtils.getCurrentDate("DMYHM", locale);
strRecord = request.getParameter("hdnRecord");
if(strPostBack != null && strPostBack.equals("true"))
{
	if(request.getParameter("hdnPatientClass") != null )
	{
		strPatientClass = request.getParameter("hdnPatientClass");
	}
	if(strRecord != null && strRecord.equals("Record") )
	{
		PrintWriter out1;
		java.util.Properties p1 = null;
		//out1 = response.getWriter();
		if(session.getValue("jdbc") != null)
		{
		   p1 = (java.util.Properties) session.getValue("jdbc") ;
		}
		if(p1 != null)
		{
		 //recInsert = insertRecord(request,out1,p1,session);
			recInsert = insertRecord(request,p1,session);
		}
	}
}

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1_0Bytes, _wl_block1_0);
            _bw.write(_wl_block1_1Bytes, _wl_block1_1);

													ChartType oChartType = null;
													try {
														oChartList = oChartDetails.getChartForCombo(oPatientContext);
														 if(oChartList != null)
											        	      nListSize =  oChartList.size();
														if(nListSize > 0)
											            {
															 for(nLoopCount = 0 ; nLoopCount < nListSize; nLoopCount ++)
															 {
																 oChartType = oChartList.get(nLoopCount);	
																 if(oChartType != null)
																 {
																	 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(oChartType.getChartId()));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oChartType.getChartDesc() ));
            _bw.write(_wl_block4Bytes, _wl_block4);
 
																 }
															 }
											            }
														
													}
													catch ( Exception e ){
														out.println("Exception " + e);
														//out.println(sqlStr.toString());
														e.printStackTrace();
													}
													
            _bw.write(_wl_block5Bytes, _wl_block5);

	       
			if(strPostBack != null && strPostBack.equals("true") && strRecord != null && !strRecord.equals("Record"))	
			{
				oPatientContext.sChartId = strChartType;
				List<ChartConfig> oChartConfigList = new ArrayList<ChartConfig>(); 
				String strSectionId = "";
				int nCssCount = 1;  // To display alternate Row Color.
				int nLoopCount1 = 0;
				
				//int nListSize1 = 0;
				  
				
				
				try {
						
						oChartConfigList = oChartDetails.getChartConfig(oPatientContext) ; 
						if(oChartConfigList != null)
						{
							nListSize1 = oChartConfigList.size();
							
						}
						if(nListSize1 > 0)
						{
							ChartConfig oChartConfig = null;
							for(nLoopCount1 = 0 ; nLoopCount1 < nListSize1;nLoopCount1 ++)
							{
								oChartConfig = oChartConfigList.get(nLoopCount1);
								if(oChartConfig != null)
								{
									if(!strSectionId.equals(oChartConfig.getSectionId()))
									{
										
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oChartConfig.getSectionDesc() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
									}//sectionid
									
									
									
									
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(nCssCount));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oChartConfig.getDiscMsrDesc()));
            _bw.write(_wl_block10Bytes, _wl_block10);

								    	       String maxSize = oChartConfig.getNumDigitsMax();
								    	       String minSize = oChartConfig.getNumDigitsMin();
								    	       String decSize =  oChartConfig.getNumDigitsDecimal();
								    	       String defaultValue = oChartConfig.getDefaultValue();
								    	       String minValue = oChartConfig.getMinValue();
								    	       String maxValue = oChartConfig.getMaxValue();
								    	       String num_dflt_result = oChartConfig.getNumDfltResult();
								    	       String defaultText = "";
								    	       
								    	       if (maxSize.equals(""))
								   			   {
								   				 maxSize = "20";
								   			   }
								              // if(Integer.parseInt(maxSize)==0)
									   		   if(Float.parseFloat(maxSize)==0)
									            {
									                   maxSize = "20";
									             }
								   			    String type = oChartConfig.getResultType();
								    	       
								    	       if(type != null && !type.equals("L") && !type.equals("C")) //to display textbox control
								    	       {
								    	    	  if(type.equals("N")||type.equals("I"))
								    	    	  {
								    	    		  normalInd = "";
								    	    		  if(defaultValue != null && defaultValue.length() > Integer.parseInt(maxSize))
								    	    			  defaultValue = "";
								    	    		  normalInd = oChartConfig.getNormalIndicator();
									    	    	   if(type.equals("I") )
									    	    	   {
									    	    		   decSize = "0"; 
									    	    	   } 
								    	    	   
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oChartConfig.getDiscMsrDesc()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oChartConfig.getMandatoryYN() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(defaultValue ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(maxSize));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(maxSize));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(decSize));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(decSize));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(minSize ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(minValue ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( maxValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oChartConfig.getNormalLow() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oChartConfig.getNormalHigh() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oChartConfig.getCriticalLow() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oChartConfig.getCriticalHigh() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oChartConfig.getCriticalLowStr() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oChartConfig.getCriticalHighStr() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oChartConfig.getLowStr() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oChartConfig.getHighStr() ));
            _bw.write(_wl_block22Bytes, _wl_block22);

								    	    	   if(oChartConfig.getMandatoryYN().equals("Y"))
								    	    	    {
								    	    	    
            _bw.write(_wl_block23Bytes, _wl_block23);
 
								    	    	    }
								    	    	   
								    	    	  }
								    	    	  else if(type.equals("D"))
								    	    	  {
								    	    		  normalInd = "";
								    	    		  
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oChartConfig.getDiscMsrDesc()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oChartConfig.getMandatoryYN() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block27Bytes, _wl_block27);
 
								    	    		  if(oChartConfig.getMandatoryYN().equals("Y"))
									    	    	    {
									    	    	    
            _bw.write(_wl_block28Bytes, _wl_block28);
 
									    	    	    }
								    	    		  
								    	    		  
								    	    	  }
								    	    	  else if(type.equals("T"))
								    	    	  {
								    	    		  normalInd = "";
								    	    		  
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oChartConfig.getDiscMsrDesc()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oChartConfig.getMandatoryYN() ));
            _bw.write(_wl_block31Bytes, _wl_block31);

								    	    		  
								    	    		  if(oChartConfig.getMandatoryYN().equals("Y"))
									    	    	    {
									    	    	    
            _bw.write(_wl_block28Bytes, _wl_block28);
 
									    	    	    }
								    	    	  }
								    	    	  else if(type.equals("E"))
								    	    	  {
								    	    		 
								    	    		  
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oChartConfig.getDiscMsrDesc()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oChartConfig.getMandatoryYN() ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block34Bytes, _wl_block34);

								    	    		  if(oChartConfig.getMandatoryYN().equals("Y"))
									    	    	    {
									    	    	    
            _bw.write(_wl_block28Bytes, _wl_block28);
 
									    	    	    }
								    	    	  }
								    	    	  else if(type.equals("A"))
								    	    	  {
								    	    		
								    	    		  
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oChartConfig.getDiscMsrDesc()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oChartConfig.getMandatoryYN() ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(oChartConfig.getSummationFormula()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block41Bytes, _wl_block41);
 
								    	    	  }
								    	    	  else
								    	    	  {
								    	    		  normalInd = "";
								    	    		  
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(oChartConfig.getDiscMsrDesc()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oChartConfig.getMandatoryYN() ));
            _bw.write(_wl_block44Bytes, _wl_block44);
 
								    	    	  }
								    	    	  
								    	       }
								    	       if(type != null &&  type.equals("C")) // to display checkbox control
								    	       {
								    	    	   
								    	    	  
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block46Bytes, _wl_block46);
   
								    	       }
								    	       if(type != null &&  type.equals("L")) // to display list box control
								    	       {
								    	    	   normalInd = "";
								    	    	   defaultText = "------Select------";
								    	    	   
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block48Bytes, _wl_block48);
 
								    	    	   int nCount = 0;
								    	    	   int nsize = 0;
								    	    	   List<ChartCombo> oChartComboList = null;
								    	    	   oChartComboList = oChartConfig.getChartComboList();
								    	    	   String selected = "";
								    	    	   String dfSelected = "";
								    	    	   if(oChartComboList != null)
								    	    	   {
								    	    		   nsize = oChartComboList.size();
								    	    		   if(nsize > 0)
								    	    		   {
								    	    			   ChartCombo oChartCombo = null;
								    	    			   for(nCount = 0 ;nCount < nsize;nCount++)
								    	    			   {
								    	    				   oChartCombo = oChartComboList.get(nCount);
								    	    				   
								    	    				   if(oChartCombo != null)
								    	    				   {
								    	    					   normalInd = oChartCombo.getNormAbnormIndicator();
								    	    					   dfSelected = oChartCombo.getDfltYN();
								    	    					   if( dfSelected != null &&  dfSelected.equals("Y"))
								    	    					   {
								    	    						   selected = "selected";
								    	    						   defaultValue = oChartCombo.getRefRangeSeq();
								    	    						   defaultText = oChartCombo.getRefRangeDesc();
								    	    						   
								    	    					   }
								    	    					   else
								    	    					   {
								    	    						   selected = "";
								    	    					   }
								    	    					   
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(oChartCombo.getRefRangeSeq()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(selected ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( oChartCombo.getRefRangeDesc()));
            _bw.write(_wl_block52Bytes, _wl_block52);
 
								    	    				   }
								    	    				   
								    	    			   }
								    	    			   
								    	    		   }
								    	    	   }
								    	    	   
            _bw.write(_wl_block53Bytes, _wl_block53);
 
								    	    	   
								    	       }
								    	       
								    	       
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( oChartConfig.getUnits()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(oChartConfig.getDiscMsrId() ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(oChartConfig.getSectionId() ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(defaultValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oChartConfig.getNormalLow() ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oChartConfig.getNormalHigh() ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oChartConfig.getCriticalLow() ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oChartConfig.getCriticalHigh()));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oChartConfig.getAssociateScoreYN() ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( normalInd ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(defaultText));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( oChartConfig.getUnits()));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(oChartConfig.getSummationFormula()));
            _bw.write(_wl_block99Bytes, _wl_block99);
 
								
									strSectionId = oChartConfig.getSectionId();
								}//chartconfig
								 if(nCssCount==1)
								  {
									   nCssCount = nCssCount +1;
								  }
								  else
								  {
									  nCssCount = nCssCount -1;
								  }	  
							}//for
						}
					
					}
					catch ( Exception e ){
						out.println("Exception " + e);
						//out.println(sqlStr.toString());
						e.printStackTrace();
					}
			}
           
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strChartType ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(strCurrentDate ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(strCurrentDatetime ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(nListSize1 ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(strRecord ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(oPatientContext.sPatientId ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(recInsert ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block108Bytes, _wl_block108);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
