package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.healthobject.*;
import eIPAD.chartsummary.common.healthobject.PatContext;

public final class __recordvitals extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/RecordVitals.jsp", 1738426238338L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n\n<title>Record Vitals</title>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/css/kendo.common.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/kendo.default.min.css\" />\n<script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery-1.9.1.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/kendo.web.min.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/console.js\"></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/cultures/kendo.culture.";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =".min.js\"></script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/css/iPADNew.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/css/iPADThemeA.css\" />\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14_0 ="/eIPAD/js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<style>\n.buttonContainer \n\t{\n\t\tmargin-right: 10px;\n\t}\n\t.dvControlTable\n\t{\n\t\tdisplay : table;\n\t\twidth : 100%;\n\t\tmin-height : 65px;\n\t\theight: auto;\n\t}\n\t.dvControlRow\n\t{\n\t\tdisplay : table-row;\n\t\twidth : 100%;\n\t\tmin-height : 65px;\n\t\theight: auto;\n\t}\n\t.Cell1\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 30%;\n\t\tmin-height : 65px;\n\t\theight: auto;\n\t\tvertical-align : middle;\n\t\ttext-align : right;\n\t\t\n\t}\n\t.Cell2\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 57%;\n\t\tmin-height : 65px;\n\t\theight: auto;\n\t\tvertical-align : middle;\n\t\ttext-align : left;\n\t\n\t}\n\t.cell3\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 15%;\n\t\tmin-height :65px;\n\t\theight : auto;\n\t\tvertical-align : middle;\n\t\ttext-align :center;\n\t}\n\t.dateCell\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 50%;\n\t\tmin-height : 40px;\n\t\theight: auto;\n\t\tvertical-align : middle;\n\t\ttext-align : right;\n\t}\n\t.dateCell2\n\t{\n\t\tdisplay : table-cell;\n\t\twidth : 70%;\n\t\tmin-height : 65px;\n\t\theight: auto;\n\t\tvertical-align : middle;\n\t\ttext-align : left;\n\t}\n\t.dvControlLabel\n\t{\n\t\tposition : relative;\n\t\tmargin-right : 10px;\n\t\tfont-family :Arial;\n        font-size : 13px;\n        font-weight : bold;\n        color : #44484a;\t\n\t}\n\t.dvRange\n\t{\n\tposition : relative;\n\tfont-family : Arial;\n\tfont-size : 13px;\n\tfont-weight :bold;\n\t}\n\t.dvUnit\n\t{\n\tposition : relative;\n\tfont-family : Arial;\n\tfont-size : 10px;\n\t}\n\t .divEvent1\n\t {\n\t   position:relative;\n\t   height : 40px;\n\t   width : 100%;\n\t   margin-left : 10px;\n\t   vertical-align : middle;\n\t   text-align : center;\n\t   \n\t }\n\t  .divEvent2\n\t {\n\t   position:relative;\n\t   height : 40px;\n\t   width : 575px;\n\t   margin-left : 10px;\n\t   vertical-align : middle;\n\t   text-align : left;\n\t   \n\t }\n\t .chkChart\n\t{\n\t  margin-top : 10px;\n\t  margin-left : 5px;\n\t  width : 20px;\n\t  height : 20px;\n\t}\n</style>\n<script>\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\ndocument.addEventListener(\'DOMContentLoaded\', vitalsScroll, false);\n//document.addEventListener(\'focusout\', function(e) {setRecordVitalsDimensions();});\n\n\nvar vitalsRecordScroll;\nvar screenOrienttation = \"landscape\";\nvar bAllcontrolsLoaded = false;\n\nfunction changeOrientation(orient, EMHFheight)\n{\n\tvar CSHFheight = $(\'#allergyHeader\').height();\n   \tHFheight = EMHFheight;\n   \tscreenOrienttation = orient;\n   \t\t \n   \tvar content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;\n   \tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n   //\t$(\'#header1\').focus();\n   \tscrollRefresh();\n   \tif( bAllcontrolsLoaded)\n\t{\n\t\t // to close all the Kendo pop up controls when orientation changes\n\t\t $(\"[data-type = \'DateTime\']\").each(function(index, value) { \n\t\t\t $(this).data(\"kendoDateTimePicker\").close(\"date\");\n\t\t\t $(this).data(\"kendoDateTimePicker\").close(\"time\");\n\t\t });\n\t\t\n\t\t $(\"[data-type = \'Date\']\").each(function(index, value) { \n\t\t\t $(this).data(\"kendoDatePicker\").close();\n\t\t\t\n\t\t });\n\t\t $(\"[data-type = \'ComboBox\']\").each(function(index, value) { \n\t\t\t $(this).data(\"kendoComboBox\").close();\t\t\n\t\t });\n\t}\t\n}\nfunction scrollRefresh()\n{\n \tif(vitalsRecordScroll != null)\n \t\tvitalsRecordScroll.refresh();\n}\nfunction cancelTransaction(){\n\tvar path = document.getElementById(\"hdnPath\").value + \"/mobile/chartsummary/ChartWidgetsView\";\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src = path;\n}\n\nfunction vitalsScroll() {\n\t\t setTimeout(function () {\n\t\t\t vitalsRecordScroll = new iScroll(\'divcnt\', {\n\t\t\tuseTransform: true,\n\t\t\tzoom: false,\n\t\t\tonBeforeScrollStart: function (e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\t\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' && target.tagName != \'DIV\')\n\t\t\te.preventDefault();\n\t\t\t}\n\t\t\t});\n\t}, 1000); \n}\nfunction valueChange(obj,index)\n{\n\t  var sHidden = \"comp_\" + index;\n\t  document.getElementById(sHidden).value = obj.value;\n\t // alert( document.getElementById(sHidden).value);\n\t  \n\t  \n}\nfunction setComboValue(objcombo,rownumber)\n{\n\t/*\n\t  var sHidden = \"listItemValue\" + rownumber;\n\t  var sCompValue = \"comp_\" + rownumber;\n\t  document.getElementById(sHidden).value = objcombo.options[objcombo.selectedIndex].text;\n\t  document.getElementById(sCompValue).value = objcombo.value;\n\t  */\n\n}\n\n$(document).ready(function () {\n\tsetRecordVitalsDimensions();\n});\nfunction setRecordVitalsDimensions()\n{\n\t   parent.setOnLoadContentPaneHeight();\n\t   bAllcontrolsLoaded = true;\n}\nfunction setScreen()\n{\n\talert(window.event.keyCode);\n\talert(window.event);\n    parent.myOrientResizeFunction();\n\tparent.setOnLoadContentPaneHeight();\n}\nfunction allowValidNumberLocal3(fld,e){\n\tvar count=fld.value.length;//ok\n    var whichCode = (window.Event) ? e.which : e.keyCode;//ok\n\t//var whichCode = (window.Event) ? e.which : e.keyCode;\n\tif (whichCode == 13) return false; \n\t else return true;\n}\nfunction allowValidNumberLocal2(fld, e, maxInt, deci)\n{\n\n    var count=fld.value.length;//ok\n    var whichCode = (window.Event) ? e.which : e.keyCode;//ok\n   // alert(whichCode);\n    if(whichCode == 8)  \n\t{\n\t  \t  return true;\n\t}\n\tvar minusOccurance = fld.value.indexOf(\'-\');\n\tvar plusOccurance = fld.value.indexOf(\'+\');\n\tif(minusOccurance != -1 || plusOccurance != -1)\n\t{\n\t\tmaxInt++;\n\t\tfld.setAttribute(\"maxLength\",maxInt);\n\t}\n\telse\n\t{\n\t\tfld.setAttribute(\"maxLength\",maxInt);\n\t}\n\tif((whichCode == 45 && count>0) || (whichCode == 43 && count>0))\n\t{\n\t\treturn false\n\t}\n\n    if(count >= maxInt)\n    {\n        \n\t\treturn false;\n    }\n\t\n\t//you donot require this just var strCheck = \'.0123456789\' for deci > 0\n\t//strCheck = \'0123456789\' for deci=0\n\t      var strCheck = \'.0123456789-+\';\n\n//\talert(e.getKeyCode())\n    if (parseInt(deci)==0)//For Only Nos 0 - 9\n        strCheck = \'0123456789-+\';\n\n    var fldvalue=fld.value;\n  //g  var whichCode = (window.Event) ? e.which : e.keyCode;\n  // if (whichCode == 13) return true;  // Enter     commented by Channaveer B\n    var pointCount=0;\n\n    for(var i=0;i<fldvalue.length;i++)\n    {\n        if(fldvalue.charAt(i)==\'.\') pointCount++;\n    }\n\n    if (pointCount>0 && whichCode == 46) return false;\n\n    var fldValue    =   fld.value;\n    var dotIndex    =   fldValue.indexOf(\".\");\n    var fldLength   =   fldValue.length;\n\tvar count = 0;\n    if(dotIndex!=-1){\n       /* if( fldLength > (parseInt(dotIndex)+parseInt(deci)) )\n\t\t\treturn false;*/\n\t}\n\n\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n  \n\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\telse if((key == \"-\" && fldValue.indexOf(key) != -1) || (key == \"+\" && fldValue.indexOf(key) != -1) )\n\t{\n\t\tif(fldValue.indexOf(key) != 1 )\n\t\t\treturn false\n\t}\n    return true;\n}\nfunction CheckForNumber1(val) {\n\t  \n\treturn true;\n}\nfunction validateNumber(obj,numdigitsdec,mindigits,minValue,maxValue,lowlevel,highlevel,rownumber,critlow,crithigh,cricLowStr,cricHighStr,lowStr,highStr)\n{\n\t  tempField = obj;\n\t  var val = obj.value;\n\t  var msrId = $(obj).attr(\'data-discMsrId\');\n\t  //alert(msrId);\n\t\tif(isNaN(val))\n\t\t{\n\t\t\tobj.value = \"\";\n\t\t\treturn;\n\t\t}\n\t\tif(val.indexOf(\".\") != -1)\n\t\t{\n\t\t\tvar str = val.substring(val.indexOf(\".\")+1, val.length);\n\t\t\t\n\t\t\tif (parseInt(numdigitsdec) != 0 && (str.length) > parseInt(numdigitsdec) )\n\t\t\t{\t\n\t\t\t\tvar msg = \"Only \" + numdigitsdec + \" decimal digit(s) allowed\";//getMessage(\'VARIABLE_DEC_DIGIT\',\'CA\');\n\t\t\t\t//msg = msg.replace(\'@\',numdigitsdec);\n\t\t\t\talert(msg);\n\t\t\t\tobj.value = \'\';\n\t\t\t\t//obj.focus(); // this will work only in IE\n\t\t\t\t//setTimeout(\"tempField.focus();\",10);\n\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\t\tif(val != null && val != \'\' && minValue != \'\' && maxValue != \'\')\n\t\t{\n\t\t\tif(parseFloat(minValue) > val || parseFloat(maxValue) < val)\n\t\t\t{\n\t\t\t\tvar msg = \"The value of \" + msrId + \" should be between \" +minValue + \" and \" + maxValue;//getMessage(\"MIN_MAX_VALUE_RANGE\",\"CA\");\n\t\t\t\t//msg =msg.replace(\'(1)\',minValue);\n\t\t\t\t//msg =msg.replace(\'(2)\',maxValue);\n\t\t\t\t//alert(msg);\n\t\t\t\tsetWarningMessage(obj,msg);\n\t\t\t\tshowWarningDialog(obj);\n\t\t\t\tobj.value=\'\';\n\t\t\t\t//obj.select();\n\t\t\t\t//obj.focus();\n\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t}\n\t\t//--------\n\t    if(val != null && val != \'\')\n\t\t{\n\t    \tvar colorIndicator = \"\"\n\t\t\tif((lowlevel != \'\' && parseFloat(lowlevel) != 0) && (highlevel != \'\' &&  parseFloat(highlevel) != 0)   && (critlow != \'\' && parseFloat(critlow) != 0) &&  (crithigh != 0 && parseFloat(crithigh) != \'\'))\n\t\t\t{\n\t\t\t\tif(parseFloat(val) >= parseFloat(critlow) && parseFloat(val) < parseFloat(lowlevel))\n\t\t\t\t\tcolorIndicator = lowStr;\n\t\t\t\telse if(parseFloat(val) > parseFloat(crithigh))\n\t\t\t\t\tcolorIndicator = cricHighStr;\n\t\t\t\telse if(parseFloat(val) < parseFloat(critlow))\n\t\t\t\t\tcolorIndicator = cricLowStr;\n\t\t\t\telse if(parseFloat(val) > parseFloat(highlevel) && parseFloat(val) <= parseFloat(crithigh))\n\t\t\t\t\tcolorIndicator = highStr;\n\t\t\t}// end of if\n\t\t\telse\n\t\t\t{\n\t\t\t\tif((lowlevel != \'\' && parseFloat(lowlevel) != 0))\n\t\t\t\t{\n\t\t\t\t\tif((critlow != \'\' && parseFloat(critlow) != 0))\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseFloat(val) < parseFloat(critlow)) \n\t\t\t\t\t\t\tcolorIndicator = cricLowStr;\n\t\t\t\t\t\telse if((parseFloat(val) >= parseFloat(critlow)) && (parseFloat(val) < parseFloat(lowlevel))) \n\t\t\t\t\t\t\tcolorIndicator = lowStr;\n\t\t\t\t\t}\n\t\t\t\t\telse if(parseFloat(val) < parseFloat(lowlevel)) \n\t\t\t\t\t\tcolorIndicator = lowStr;\n\t\t\t\t}\n\t\n\t\t\t\tif((highlevel != \'\' &&  parseFloat(highlevel) != 0))\n\t\t\t\t{\n\t\t\t\t\tif((crithigh != \'\' && parseFloat(crithigh) != 0))\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseFloat(val) > parseFloat(crithigh)) \n\t\t\t\t\t\t\tcolorIndicator = cricHighStr;\n\t\t\t\t\t\telse if((parseFloat(val) <= parseFloat(crithigh)) && (parseFloat(val) > parseFloat(highlevel))) \n\t\t\t\t\t\t\tcolorIndicator = highStr;\n\t\t\t\t\t}\n\t\t\t\t\telse if(parseFloat(val) > parseFloat(highlevel)) \n\t\t\t\t\t\tcolorIndicator = highStr;\n\t\t\t\t}\n\t\t\t}// end of else\n\t        /*\n\t\t\tif(parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm != null)\n\t\t\t{\n\t\t\t\tvar normal_abnormal_ind = eval(\"document.ChartLayoutDetailForm.normal_abnormal_ind_\"+rownumber);\n\t\t\t\tnormal_abnormal_ind.value=colorIndicator;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar normal_abnormal_ind = eval(\"document.chartRecordingAmendErrorForm.normal_abnormal_ind_\"+rownumber);\n\t\t\t\tnormal_abnormal_ind.value=colorIndicator ;\n\t\t\t}\n\t    \t*/\n\t    \tvar normal_abnormal_ind = \"normal_abnormal_ind_\" +rownumber;\n\t    \t//alert(normal_abnormal_ind);\n\t    \t//alert(document.getElementById(normal_abnormal_ind));\n\t    \tdocument.getElementById(normal_abnormal_ind).value = colorIndicator;\n\t\t}\n\t\t//--------\n\t\tif ( val != null && val != \'\')\n\t\t{\n\t\t\tvar val1=val;\n\t\t\tif(eval(mindigits) != 0) {\n\t\t\t\t\n\t\t\t\tif(val1.indexOf(\"-\")>=0)\n\t\t\t\t{\n\t\t\t\t\tval1 = val1.substr(val1.indexOf(\"-\")+1,val1.length);\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(val1.indexOf(\".\")>=0)\n\t\t\t\t{\n\t\t\t\t\tval1 = val1.substr(0, val";
    private final static byte[]  _wl_block14_0Bytes = _getBytes( _wl_block14_0 );

    private final static java.lang.String  _wl_block14_1 ="1.indexOf(\".\"));\n\t\t\t\t}\n\t\t\t\tif(val1.length < eval(mindigits))  {\n\t\t\t\t\tvar short_desc_alert;\n\n\t\t\t\t\n\n\t\t\t\t\t//var message_alert=\"Please enter minimum\" + mindigits + \" digits\";//getMessage(\"MINIMUM_DIGITS\",\"CA\");\n\t\t\t\t\tvar message_alert=\"Minimum number of digits for \" + msrId + \" must be \" + mindigits;\n\t\t\t\t\t//message_alert=message_alert.replace(\'$\',short_desc_alert.value);\n\t\t\t\t\t//alert(message_alert+\' \'+mindigits);\t\n\t\t\t\t\t//alert(message_alert);\n\t\t\t\t\tsetWarningMessage(obj,message_alert);\n\t\t\t\t    showWarningDialog(obj);\n\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\t//obj.focus();\n\t\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\t\t\t\t\t//obj.select();\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(!CheckForNumber1(val)) \n\t\t\t{\n\t\t\t\t//obj.focus();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t    var n = obj.value;\n\t\t\t\tif((n.indexOf(\".\")) >= 0)\n\t\t\t\t{\n\t\t\t\t\tif(numdigitsdec !=0 )  {\n\t\t\t\t\t\tvar arr =  new Array();\n\t\t\t\t\t\tarr = n.split(\".\");\n\t\t\t\t\t\tvar num = arr[0].length;\n\t\t\t\t\t\tvar frac = arr[1].length;\n\n\t\t                if (frac > numdigitsdec )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar msg = \"Decimal digits greate\";//getMessage(\"VARIABLE_DEC_DIGIT\",\"CA\");\n\t\t\t\t\t\t\t//msg = msg.replace(\"@\",numdigitsdec);\n\t\t\t\t\t\t\t//alert(msg);\n\t\t\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\t\t\t//obj.focus();\n\t\t\t\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\t\t\t\t\t\t}\n\t\t\t\t\t}else {\n\t\t\t\t\t\t//alert(\"No decimal\");\n\t\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\t\t//obj.focus();\n\t\t\t\t\t\t//setTimeout(function(){obj.focus();},2);\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t}\n\t\t}\n}\nfunction setWarningMessage(field,errmsg){\n\tvar id= $(field).attr(\"id\");\n\t$(\"#\"+id+\"_WarningMsg\").html(errmsg);\n}\nfunction showWarningDialog(field){\n\tvar id= $(field).attr(\"id\");\n\t$(\"#\"+id+\"_Warning\").show();\n\t$(\"#\"+id+\"_Warning\").bind(\'click\',function(){\n\t\t$(this).hide();\n\t});\n\t//hide after 5 secs\n\tsetTimeout(function() {\n\t\t$(\"#\"+id+\"_Warning\").hide();\n\t}, 5000);\n\t\n}\nfunction hideWarningDialog(field){\n\tvar id= $(field).attr(\"id\");\n\t$(\"#\"+id+\"_Warning\").hide();\n}\nfunction evalCheckBox(objCheck,index)\n{\n\t  var sHidden = \"comp_\" + index;\n\t // alert(objCheck.checked);\n\tif(objCheck.checked==true)\n\t\tdocument.getElementById(sHidden).value = \'Y\';\n\t   \telse\n\t   \tdocument.getElementById(sHidden).value =\'\';\n\t\n\t//alert(index);\n\t//alert(document.getElementById(sHidden).value);\n}\t\nfunction validate()\n{\n\tvar mandatoryValPassed = true;\n\t\n\t$(\"[data-mandatory=\'Y\']\").each(function(index,field){\n\t\t//alert($(field).val());\n\t\tvar type  = $(this).attr(\"data-type\");\n\t\tvar rowIndex = $(this).attr(\"data-rowIndex\");\n\t\t//alert(\"type = \" + type);\n\t\t//alert(\"rowIndex = \" + rowIndex); \n\t\tvar cntrl = \"comp_\" + rowIndex\n \t    var cntrlValue = document.getElementById(cntrl).value;\n \t  //  alert(cntrlValue);\n \t   var lCntrl = \"listItemValue\" + rowIndex;\n \t   var lCntrlValue = document.getElementById(lCntrl).value;\n \t   \n \t   if(type == \"L\")\n \t   {\n \t\t// if(lCntrlValue != null && lCntrlValue != \"------Select------\" && lCntrlValue != \"Select\" && lCntrlValue.trim() != \"\")\n \t\t//\talert(cntrlValue);\n \t\t   if(cntrlValue != null && cntrlValue != \"------Select------\" && cntrlValue != \"Select\" && cntrlValue.trim() != \"\")\t\n \t\t  {\n \t\t\t $(\"#\"+$(field).attr(\"id\")+\"_Label\").css(\"color\",\"black\");\n \t      }\n \t\t  else\n \t\t\t  {\n \t\t\t    mandatoryValPassed = false;\n \t\t\t    $(\"#\"+$(field).attr(\"id\")+\"_Label\").css(\"color\",\"red\");\n \t\t\t  }\n \t   }\n \t  \n \t  if(type == \"C\" || type == \"E\" || type == \"D\")\n\t   {\n \t\t  /*\n \t\t  if(type == \"E\")\n \t\t\t  {\n \t\t\t \t\tvar datetimepicker = $(this).data(\"kendoDateTimePicker\");\n \t\t\t \t\talert(datetimepicker.value());\n \t\t\t  }\n \t\t  */\n\t\t  if(cntrlValue != null && cntrlValue != \"\" && cntrlValue.trim() != \"\")\n\t\t  {\n\t\t\t  \n\t\t\t  $(\"#\"+$(field).attr(\"id\")+\"_Label\").css(\"color\",\"black\");\n\t\t\t  //alert(\"passed\");\n\t      }\n\t\t  else\n\t\t\t  {\n\t\t\t   \n\t\t\t    mandatoryValPassed = false;\n\t\t\t   // alert($(\"#\"+$(field).attr(\"id\")+\"_Label\"));\n\t\t\t    $(\"#\"+$(field).attr(\"id\")+\"_Label\").css(\"color\",\"red\");\n\t\t\t    //alert(\"failed\");\n\t\t\t  }\n\t   }\n \t  \n \t   \n \t   var fieldValue = $(field).val();\n \t   if(type != \"C\" && type != \"L\" && type != \"E\" && type != \"D\")\n \t   {\n \t\t  if(fieldValue == \"\" || fieldValue == null){ \n \t\t\t\tmandatoryValPassed = false;\n \t\t\t\t$(\"#\"+$(field).attr(\"id\")+\"_Label\").css(\"color\",\"red\");\n \t\t\t}\n \t\t\telse{\n \t\t\t\t$(\"#\"+$(field).attr(\"id\")+\"_Label\").css(\"color\",\"black\");\n \t\t\t}\n \t   }\n\t\t\n\t});\n\tif(mandatoryValPassed != true ){\n\t\t$(\"#MandatoryFields_Error\").show();\n\t\tsetTimeout(function(){\n\t\t\t$(\"#MandatoryFields_Error\").hide();\n\t\t},5000);\n\t\t$(\"#MandatoryFields_Error\").bind(\'click\',function(){\n\t\t\t$(this).hide();\n\t\t});\n\t}\n\telse\n\t\t{\n\t\t\tdocument.getElementById(\"frmRecordVitals\").submit();\n\t\t}\n}\nfunction StringToDate(string){\n\tvar d = new Date();\n\t//var str=\'01/07/2013 11:18:13\';\n\tvar datenum,month,year;\n\tvar hr=0, min=0, sec=0;\n\tvar datetimearr = string.split(\" \");\n\tif(datetimearr[0]){\n\t\tvar datearr = datetimearr[0].split(\"/\");\n\t\tif(datearr[0])\n\t\t\tdatenum = parseInt(datearr[0]);\n\t\tif(datearr[1])\n\t\t\tmonth = parseInt(datearr[1]);\n\t\tif(datearr[2])\n\t\t\tyear = parseInt(datearr[2]);\n\t}\n\tif(datetimearr[1]){\n\t\tvar timearr = datetimearr[1].split(\":\");\n\t\tif(timearr[0])\n\t\t\thr = parseInt(timearr[0]);\n\t\tif(timearr[1])\n\t\t\tmin = parseInt(timearr[1]);\n\t\tif(timearr[2])\n\t\t\tsec = parseInt(timearr[2]);\n\t}\n\t\n\td.setDate(datenum);\n\td.setMonth(month-1);\n\td.setFullYear(year);\n\t//if(hr!=0)\n\td.setHours(hr);\n\t//if(min!=0)\n\td.setMinutes(min);\n\t//if(sec!=0)\n\td.setSeconds(sec);\n\treturn d;\n\t\n}\nfunction twoDigits(num){\n\tif(num<10)\n\t\tnum = \"0\" + num;\n\treturn num;\n}\nfunction DMYHMToString(dateobj){\n\tvar d = new Date();\n\tif(dateobj){\n\t\td = dateobj;\n\t}\n\t//--15/07/2013 10:45\n\tvar stringDate = twoDigits(d.getDate()) + \"/\" + twoDigits((d.getMonth()+1)) + \"/\" + twoDigits(d.getFullYear()) + \" \" + twoDigits(d.getHours()) + \":\" + twoDigits(d.getMinutes());\n\treturn stringDate;\n}\nfunction DMYToString(dateobj){\n\tvar d = new Date();\n\tif(dateobj){\n\t\td = dateobj;\n\t}\n\t//--15/07/2013\n\tvar stringDate = twoDigits(d.getDate()) + \"/\" + twoDigits((d.getMonth()+1)) + \"/\" + twoDigits(d.getFullYear());\n\treturn stringDate;\n}\nfunction checkVitalsDate(obj,cntrlIndex,fieldId,type)\n{\n\t \tvar sHidden = \"comp_\" + cntrlIndex;\n\t \t//alert($(\"#\" + fieldId));\n\t \tvar controlObject = $(\"#\" + fieldId);\n\t    if(obj.value() != null)\n\t    \t{\n\t    \t    var today_str = $(\"#today\").val();\n\t    \t    var patDOB_str = $(\"#patientDOB\").val();\n\t    \t    var patDOB = StringToDate(patDOB_str);\n\t    \t    var today_date = StringToDate(today_str);\n\t    \t    if(obj.value() >= patDOB && obj.value() <= today_date)\n\t    \t    \t{\n\t    \t    \t\tif(type == \"E\")\n\t    \t    \t\t\t{\n\t    \t    \t\t\t\tdocument.getElementById(sHidden).value = DMYHMToString(obj.value());\n\t    \t    \t\t\t}\n\t    \t    \t\tif(type == \"D\")\n\t    \t    \t\t\t{\n\t    \t    \t\t\t\tdocument.getElementById(sHidden).value = DMYToString(obj.value());\n\t    \t    \t\t\t}\n\t    \t    \t}\n\t    \t    else\n\t    \t    \t{\n\t    \t    \t    if(obj.value() > today_date)\n\t    \t    \t    \t{\n\t    \t    \t    \t \tvar msg = \"Value cannot be greater than today\'s date\";\n\t \t    \t    \t\t\tsetWarningMessage(controlObject,msg);\n\t \t    \t\t\t\t\tshowWarningDialog(controlObject); \n\t    \t    \t    \t}\n\t    \t    \t    if(obj.value() < patDOB)\n\t    \t    \t    \t{\n\t\t    \t    \t    \tvar msg = \"Value cannot be less than Patient\'s DOB\";\n\t \t    \t    \t\t\tsetWarningMessage(controlObject,msg);\n\t \t    \t\t\t\t\tshowWarningDialog(controlObject); \n\t    \t    \t    \t}\n\t    \t    \t    obj.value(null);\n\t    \t    \t    document.getElementById(sHidden).value = \"\";\n\t    \t    \t}\n\t    \t}\n\t    else\n\t    \t{\n\t    \t\tvar msg = \"Invalid Date\";\n \t\t\t\tsetWarningMessage(controlObject,msg);\n\t\t\t\tshowWarningDialog(controlObject); \n\t    \t    obj.value(null);\n\t    \t    document.getElementById(sHidden).value = \"\";\n\t    \t}\n}\nfunction chkValidityOfTime(strfromTime)\n{\n\tif(strfromTime.value != \'\')\n\t{\n\t\tstrfromTimeVal = strfromTime.value;\n\t\tstrTemp = strfromTimeVal.indexOf(\":\");\n\t\tif(strTemp == -1 || strTemp != 2){\n\t\t\t//alert(\"Invalid Time Format\");\n\t\t\tvar msg = \"Invalid Time Format\";\n\t\t\tsetWarningMessage(strfromTime,msg);\n\t\t\tshowWarningDialog(strfromTime); \n\t\t\t//strfromTime.select();\n\t\t\tstrfromTime.value = \"\";\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcheckTimeForDetail(strfromTime);\n\t\t}\n\t}\n}\nfunction checkTimeForDetail(strfromTime)\n{\n\tstrfromTimeVal = strfromTime.value;\n\tstrSplitTime = strfromTimeVal.split(\":\");\n\thr = strSplitTime[0];\n\tmin = strSplitTime[1];\n\n\tif(strfromTime.value.length !=5)\n\t{\n\t\t//alert(\"Invalid Time Format\");\n\t\tvar msg = \"Invalid Time Format\";\n\t\tsetWarningMessage(strfromTime,msg);\n\t\tshowWarningDialog(strfromTime); \n\t\t\t\t//strfromTime.select();\n\t\t\t\tstrfromTime.value = \"\";\n\t\treturn false;\n\t}\n\t\n\tif(!(hr.charCodeAt(0) >= 48 && hr.charCodeAt(0) <=57 &&\n\t\thr.charCodeAt(1) >= 48 && hr.charCodeAt(1) <=57 &&\n\t\tmin.charCodeAt(0) >= 48 && min.charCodeAt(0) <=57 &&\n\t\tmin.charCodeAt(1) >= 48 && min.charCodeAt(1) <=57  ))\n\t\t{\n\t\t    //alert(\"Invalid Time Format\");\n\t\t    var msg = \"Invalid Time Format\";\n\t\t    setWarningMessage(strfromTime,msg);\n\t\t\tshowWarningDialog(strfromTime); \n\t\t\t//strfromTime.select();\n\t\t\tstrfromTime.value = \"\";\n\t\t\treturn false;\n\t\t}\n\n\n\n\tif(hr>23){\n\t\t//  alert(\"Invalid Hour\");\n\t\t  var msg = \"Invalid Hour\";\n\t\t  setWarningMessage(strfromTime,msg);\n\t\t  showWarningDialog(strfromTime); \n\t\t//strfromTime.select();\n\t\tstrfromTime.value = \"\";\n\t\treturn false;\n\t}\n\tif(min>59){\n\t\t // alert(\"Invalid minute\");\n\t\t  var msg = \"Invalid minute\";\n\t\t  setWarningMessage(strfromTime,msg);\n\t\t  showWarningDialog(strfromTime); \n\t\t//strfromTime.select();\n\t\tstrfromTime.value = \"\";\n\t\treturn false;\n\t}\n\treturn true;\n}\n\n</script>\n</head>\n<body>\n\t<div id=\"divParent\" class=\"divParent\" data-role=\"page\" style=\"padding: 0px\">\n\t\t<form name = \"frmRecordVitals\" id = \"frmRecordVitals\" style=\"width: 100%; height: 100%\" method = \"post\" action=\"";
    private final static byte[]  _wl_block14_1Bytes = _getBytes( _wl_block14_1 );

    private final static java.lang.String  _wl_block15 ="/mobile/RecordVitals\">\n\t\t\t<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px\"\n\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\"\n\t\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t<td class=\"normalTd\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyHeader RecordAllergyHeaderTheme\">\n\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 99%; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"allergyHeaderPageTitle ipHeaderPageTitleTheme\" id  = \"header1\">Record Vitals</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 1%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"RecordAllergySubmitButton\" onclick = \"validate()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/CS_Ok16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" onclick=\"cancelTransaction()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<div id=\"divcnt\" class=\"divAllergyContent divAllergyContentTheme\" style=\"padding: 0px; overflow: hidden\" data-role=\"none\">\n\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\n\t\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\t<!-- container start -->\t\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"AllergyDetailsHeader AllergyDetailsHeaderTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"spanAllergyDetailsHeader\" data-role=\"none\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t   <div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div data-role = \"none\" class = \"dvControlTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell1\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"dvControlLabel\" id = \"custom_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="_Label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <font style=\"color: red\">*</font> ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div data-role = \"none\" class=\"divEvent1 divEventTheme\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"formValWarningTheme formValError\" id = \"custom_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id = \"custom_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="_WarningMsg\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<input  type=\"text\" data-role=\"none\" class=\"txtContent\" style = \"width:97%\" data-type = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" data-rowIndex = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" data-discMsrId = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onchange = \"valueChange(this,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\" name = \"custom_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id = \"custom_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  data-mandatory = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" maxLength= \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onkeypress=\"return allowValidNumberLocal2(this, event, \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\" onblur = \"validateNumber(this,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role=\"none\" class=\"cell3\">\n                                                                                        <div data-role=\"none\" class=\"dvRange\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="-";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" </div> \n                                                                                        <div data-role=\"none\" class=\"dvUnit\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</div>\n                                                                       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t   ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div data-role = \"none\" class = \"dvControlTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell1\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"dvControlLabel\" id = \"custom_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="_Label\" >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="_WarningMsg\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<input data-rowIndex = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" data-type = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" data-type=\"Date\" data-count=\"I\" \tstyle=\"text-align:right\" data-role=\"none\" data-mandatory = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                $(\"#custom_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\").kendoDatePicker({\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \tformat : \"dd/MM/yyyy\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \tculture : \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \tchange : function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t        var cntrlIndex = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t        checkVitalsDate(this,cntrlIndex,\'custom_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\');\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t\t\t\t\t\t                                   </script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div data-role=\"none\" class=\"cell3\">\n                                                                                        <div data-role=\"none\"> &nbsp </div> \n                                                                                        <div data-role=\"none\"> &nbsp </div>\n                                                                       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t \n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div data-role = \"none\" class = \"dvControlTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell1\"><div data-role = \"none\" class = \"dvControlLabel\" id = \"custom_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="_WarningMsg\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<input  data-rowIndex = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" type=\"text\" data-role=\"none\" onchange = \"valueChange(this,\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\')\" onblur = \"chkValidityOfTime(this)\" class=\"txtContent\" style = \"width:97%\" name = \"custom_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"  maxLength= \"5\"  />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role=\"none\" class=\"cell3\">\n                                                                                        <div data-role=\"none\"> &nbsp </div> \n                                                                                        <div data-role=\"none\"> &nbsp </div>\n                                                                       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t \n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t\t\t   \t     \t\t<div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div data-role = \"none\" class = \"dvControlTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell1\"><div data-role = \"none\" class = \"dvControlLabel\" id = \"custom_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"  data-type = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" data-type = \"DateTime\" data-count=\"I\" \tstyle=\"text-align:right;\" data-role=\"none\" data-mandatory = \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t              //  var today = new Date();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                $(\"#custom_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\").kendoDateTimePicker({\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t interval: 1,\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t format : \"dd/MM/yyyy HH:mm\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t change : function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t        var cntrlIndex = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t        checkVitalsDate(this,cntrlIndex,\'custom_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\');\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t\t\t\t\t\t                                   </script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role=\"none\" class=\"cell3\">\n                                                                                        <div data-role=\"none\"> </div> \n                                                                                        <div data-role=\"none\"> </div>\n                                                                       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\n\t\t\t\t\t\t\t\t\t\t\t\t   \t     \t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t\t\t\t\t   \t     \t\t <div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div data-role = \"none\" class = \"dvControlTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell1\"><div data-role = \"none\" class = \"dvControlLabel\" id = \"custom_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\')\" class=\"txtContent\" style = \"width:97%\" name = \"custom_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" maxLength= \"20\" onkeypress=\"return allowValidNumberLocal3(this, event)\"  />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role=\"none\" class=\"cell3\">\n                                                                                        <div data-role=\"none\"> </div> \n                                                                                        <div data-role=\"none\"> </div>\n                                                                       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \n\t\t\t\t\t\t\t\t\t\t\t\t   \t     \t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\t\t    \t    \t   <div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div data-role = \"none\" class = \"dvControlTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell1\"><div data-role = \"none\" class = \"dvControlLabel\" id = \"custom_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t<div data-role = \"none\" class=\"divEvent2 divEventTheme\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<div class=\"formValWarningTheme formValError\" id = \"custom_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="_WarningMsg\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t <input data-mandatory = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" type = \"checkbox\" data-role = \"none\" class = \"chkChart\" id = \"custom_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" onclick = \"evalCheckBox(this,\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\')\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role=\"none\" class=\"cell3\">\n                                                                                        <div data-role=\"none\"> &nbsp </div> \n                                                                                        <div data-role=\"none\"> &nbsp </div>\n                                                                       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\n\t\t\t\t\t\t\t\t\t\t    \t    \t  \n\t\t\t\t\t\t\t\t\t\t    \t    \t ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t\t\t\t\t   \t \t\t<div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div data-role = \"none\" class = \"dvControlTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell1\"><div data-role = \"none\" class = \"dvControlLabel\" id = \"custom_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="_WarningMsg\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<select data-rowIndex = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" data-type = \"ComboBox\" data-count=\"I\" \t onchange = \"setComboValue(this,\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\')\" data-role=\"none\" data-mandatory = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t <option value = \"\">Select</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t    ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t    \t\t\t\t\t    <option value = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</option> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t    \t\t\t\t\t   ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                $(\"#custom_";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t   change : function(e) {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t\t  // alert(\" index = \" + this.select());\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t\t   //alert(this.value());\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t\t   var cntrlIndex = \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t       // alert(cntrlIndex);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t       \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t       // alert(document.getElementById(sHidden));\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t          var sHidden = \"listItemValue\" + cntrlIndex;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   var sCompValue = \"comp_\" + cntrlIndex;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t       if(this.select() != -1)\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   if(this.value() == \"\")\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t\t   document.getElementById(sHidden).value = this.text();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   document.getElementById(sCompValue).value = this.value();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   else\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t\t   document.getElementById(sHidden).value = this.text();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   document.getElementById(sCompValue).value = this.value();\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t       else\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   document.getElementById(sHidden).value = \"\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t   document.getElementById(sCompValue).value = \"\";\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t    \t}\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t  \t    \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t   }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t\t);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t\t\t\t\t\t                                   </script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role=\"none\" class=\"cell3\">\n                                                                                        <div data-role=\"none\"> </div> \n                                                                                        <div data-role=\"none\"> </div>\n                                                                       </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \n\t\t\t\t\t\t\t\t\t\t\t\t   \t \t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t   \t\t <input type=\"hidden\" name=\"discr_msr_id_grp_id";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" id=\"discr_msr_id_grp_id";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" value= \"custom_";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t                 <input type=\"hidden\" name=\"dis_msr_type_";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"dis_msr_type_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t                 <input type=\"hidden\" name=\"dis_msr_id_";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" id=\"dis_msr_id_";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" id =\"dis_msr_id_";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type= \"hidden\" name=\"chat_grp_id_";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"chat_grp_id_";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id =\"chat_grp_id_";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"comp_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"comp_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id = \"comp_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"  value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"normal_low_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"normal_low_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id =\"normal_low_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" value= \"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"normal_high_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"normal_high_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" id =\"normal_high_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"critical_low_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" id=\"critical_low_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" id =\"critical_low_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"critical_high_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" id=\"critical_high_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id =\"critical_high_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"associate_score_yn";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"associate_score_yn";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" id =\"associate_score_yn";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"normal_abnormal_ind_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\"normal_abnormal_ind_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id =\"normal_abnormal_ind_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"listItemValue";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" id=\"listItemValue";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id =\"listItemValue";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"uom_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"uom_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"hdnSF";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"hdnSF";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" id =\"hdnSF";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t   \t\t ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t \t<div class=\"rowContainer\" data-role=\"none\" style=\"display: block\">\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t\t<div data-role = \"none\" class = \"dvControlTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div data-role = \"none\" class = \"dvControlRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell1\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t<div data-role = \"none\" class = \"Cell3\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t </div>\n\t\t\t\t\t\t\t\t\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t \t\n\t\t\t\t\t\t</div><!-- container -->\n\t\t\t\t\t</div> <!-- scroller -->\n\t\t\t\t\t<div class=\"formValErrorTheme formValError\"\n\t\t\t\t\tid=\"MandatoryFields_Error\"\n\t\t\t\t\tstyle=\"bottom: 0px; left: 0px; display: none\">\n\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"MandatoryFields_ErrorMsg\">All\n\t\t\t\t\t\tmandatory fields must be entered</div>\n\t\t\t\t</div>\n\t\t\t\t</div> <!-- divcnt -->\n\t\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" /> \n\t\t\t\t<input type = \"hidden\" name = \"today\" id = \"today\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"/>\n\t\t\t    <input type = \"hidden\" name = \"patientDOB\" id = \"patientDOB\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"/>\n\t\t\t    <input type = \"hidden\" name = \"hdnPatientId\" id = \"hdnPatientId\" value = \"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" />\n\t\t\t    <input type = \"hidden\" name = \"hdnPatientClass\" id = \"hdnPatientClass\" value = \"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" />\n\t\t\t    <input type = \"hidden\" name = \"count\" id = \"count\" value = \'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'/>\n\t\t\t      <input type = \"hidden\" name = \"hdnChartId\" id = \"hdnChartId\" value = \"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"/>\n\t\t\t     \n\t\t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);


Locale appLocale;
String locale = "en";
String patientDOB = "";
String patientId = "";
String patientClass = "";
String chartId = "";
int nLoopCount1 = 0;

if (session.getAttribute("LOCALE") != null
		&& !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle(
		"eIPAD.chartsummary.common.resourcebundle.cslabels",
		appLocale);

VitalsPanelResponse oVitalsPanelRespone = null;
if(request.getAttribute("VitalsPanelResponse") != null)
{
	oVitalsPanelRespone = (VitalsPanelResponse)request.getAttribute("VitalsPanelResponse");
}
;

PatContext oPatContext = null;
if(session.getAttribute("PatientContext") != null)
{
	oPatContext = (PatContext)session.getAttribute("PatientContext");
	 
}
if(oPatContext != null)
{
	patientDOB = oPatContext.getDob();
	//locale = oPatContext.getLocale();
	patientId = oPatContext.getPatientId();
	patientClass = oPatContext.getPatientClass();
	
	
}
//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

	if(appLocale != null && appLocale.getLanguage() != null && !appLocale.getLanguage().equalsIgnoreCase("en"))
	{
		locale = appLocale.getLanguage();
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( appLocale.getLanguage()));
            _bw.write(_wl_block10Bytes, _wl_block10);
 
	}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14_0Bytes, _wl_block14_0);
            _bw.write(_wl_block14_1Bytes, _wl_block14_1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);

						 	if(oVitalsPanelRespone != null && oVitalsPanelRespone.isSuccessResponse() && !oVitalsPanelRespone.isEmptyDataResponse())
						 	{
						 		List<VitalsPanel> vitalsPanelList = null;
						 		vitalsPanelList = oVitalsPanelRespone.getListVitalsPanel();
						 		chartId = oVitalsPanelRespone.getChartId();
						 		//int nLoopCount1 = 0;
						 		if(vitalsPanelList != null && vitalsPanelList.size() > 0)
						 		{
						 			for(VitalsPanel oVitalsPanel : vitalsPanelList)
						 			{
						 				if(oVitalsPanel != null)//to print panel header
						 				{
						 					
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( oVitalsPanel.getSectionDesc()));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
						 					
						 					List<VitalsConfig> vitalsConfigList = null;
						 					vitalsConfigList = oVitalsPanel.getVitalsConfigList();
						 					if(vitalsConfigList != null && vitalsConfigList.size() > 0)
						 					{
						 						for(VitalsConfig oVitalsConfig : vitalsConfigList)
						 						{
						 							if(oVitalsConfig != null)
						 							{
						 								 String maxSize = oVitalsConfig.getNumDigitsMax();
											    	     String minSize = oVitalsConfig.getNumDigitsMin();
											    	     String decSize =  oVitalsConfig.getNumDigitsDecimal();
											    	     String defaultValue = oVitalsConfig.getDefaultValue();
											    	     String minValue = oVitalsConfig.getMinValue();
											    	     String maxValue = oVitalsConfig.getMaxValue();
											    	     String num_dflt_result = oVitalsConfig.getNumDfltResult();
											    	     String defaultText = "";
											    	     String mandatory = oVitalsConfig.getMandatoryYN();
											    	    // mandatory = "Y";
											    	     String  normalInd = "";
											    	     if (maxSize.equals(""))
											   			 {
											   				 maxSize = "20";
											   			 }
											              // if(Integer.parseInt(maxSize)==0)
												   		 if(Float.parseFloat(maxSize)==0)
												         {
												                   maxSize = "20";
												         }
												   		String type = oVitalsConfig.getResultType();
												   	   // type = "T";
												   	    if(type != null && !type.equals("L") && !type.equals("C")) // to display text box and date control
												   	    {
												   	    	if(type.equals("N")||type.equals("I"))
												   	    	{
												   	    		normalInd = oVitalsConfig.getNormalIndicator();
												   	    		if(defaultValue != null && defaultValue.length() > Integer.parseInt(maxSize))
												   	    		{
												   	    		  defaultValue = "";
												   	    		}
												   	    	 
												   	    	   if(type.equals("I") )
											    	    	   {
											    	    		   decSize = "0"; 
											    	    	   }
												   	    	   
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureDesc() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mandatory != null && mandatory.equals("Y")){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureDesc()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mandatory ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultValue ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(maxSize));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(maxSize));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(decSize));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(decSize));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(minSize ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(minValue ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( maxValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oVitalsConfig.getNormalLow() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oVitalsConfig.getNormalHigh() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oVitalsConfig.getCriticalLow() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oVitalsConfig.getCriticalHigh() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oVitalsConfig.getCriticalLowStr() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oVitalsConfig.getCriticalHighStr() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oVitalsConfig.getLowStr() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oVitalsConfig.getHighStr() ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(oVitalsConfig.getNormalLow()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(oVitalsConfig.getNormalHigh()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(oVitalsConfig.getUnits()));
            _bw.write(_wl_block42Bytes, _wl_block42);

												   	    	
												   	    	}
												   	    	else if(type.equals("D"))
												   	    	{
												   	    		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureDesc() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mandatory != null && mandatory.equals("Y")){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(mandatory ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block49Bytes, _wl_block49);

																			                	    if(locale != null && !locale.equalsIgnoreCase("en"))
																			                	    {
																			                	    	
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block51Bytes, _wl_block51);

																			                	    }
																			                	 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(type));
            _bw.write(_wl_block54Bytes, _wl_block54);
 
												   	    	}
												   	    	else if(type.equals("T"))
												   	    	{
												   	    		
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureDesc() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mandatory != null && mandatory.equals("Y")){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mandatory ));
            _bw.write(_wl_block59Bytes, _wl_block59);
 
												   	    	}
												   	     	else if(type.equals("E"))
												   	     	{
												   	     		
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureDesc() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mandatory != null && mandatory.equals("Y")){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(mandatory ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block64Bytes, _wl_block64);

																			                	    if(locale != null && !locale.equalsIgnoreCase("en"))
																			                	    {
																			                	    	
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block51Bytes, _wl_block51);

																			                	    }
																			                	 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(type));
            _bw.write(_wl_block67Bytes, _wl_block67);
 
												   	     	}
												   	     	else if(type.equals("A"))
												   	     	{
												   	     	  	nLoopCount1--;
												   	     	}
												   	        else
												   	     	{
												   	     		
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureDesc() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mandatory != null && mandatory.equals("Y")){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mandatory ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultValue ));
            _bw.write(_wl_block70Bytes, _wl_block70);
 
												   	     	}
												   	    	 
												   	    	
												   	    }
												   	 if(type != null &&  type.equals("C")) // to display checkbox control
										    	       {
										    	    	   
										    	    	  
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureDesc() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mandatory != null && mandatory.equals("Y")){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(mandatory ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block76Bytes, _wl_block76);
   
										    	       }
												   	 	if(type != null &&  type.equals("L")) // to display list box control
												   	 	{
												   	 		
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureDesc() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mandatory != null && mandatory.equals("Y")){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId()));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(mandatory ));
            _bw.write(_wl_block81Bytes, _wl_block81);

																 				   List<ChartCombo> oChartComboList = null;
																 				   oChartComboList = oVitalsConfig.getChartComboList();
																 				   if(oChartComboList != null && oChartComboList.size() > 0)
																 				   {
																 					   for(ChartCombo oChartCombo : oChartComboList)
																 					   {
																 						   if(oChartCombo != null)
																 						   {
																 							   String selected = "";
																			    	    	   String dfSelected = "";
																			    	    	   
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
															    	    					   
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(oChartCombo.getRefRangeSeq()));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(selected ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( oChartCombo.getRefRangeDesc()));
            _bw.write(_wl_block85Bytes, _wl_block85);
 
																 						   }
																 					   }
																 				   }
																 				    	 	
																 				     
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
 
												   	 	}
													   	 if(type != null &&  !type.equals("A"))
													   	 {
													   		 
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(type ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(oVitalsConfig.getDiscreteMeasureId() ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(oVitalsConfig.getSectionId() ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(defaultValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(oVitalsConfig.getNormalLow() ));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(oVitalsConfig.getNormalHigh() ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(oVitalsConfig.getCriticalLow() ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(oVitalsConfig.getCriticalHigh()));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(oVitalsConfig.getAssociateScoreYN() ));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf( normalInd ));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(defaultText));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( oVitalsConfig.getUnits()));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(oVitalsConfig.getSummationFormula()));
            _bw.write(_wl_block132Bytes, _wl_block132);
 
													   	 }
						 							}// if config not null
						 						
						 							nLoopCount1++;
						 						}//config list loop
						 					}
						 				}
						 			}//panel loop
						 		}
						 	}
						 
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(today));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(patientDOB));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(nLoopCount1 ));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(chartId ));
            _bw.write(_wl_block140Bytes, _wl_block140);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
}
