package jsp_servlet._eipad._jsp._chartwidgets._recordconsent;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.recordconsent.healthobject.RecordConsentFieldItem;
import java.util.List;
import eIPAD.chartsummary.recordconsent.response.RecordConsentFieldResponse;
import eIPAD.chartsummary.recordconsent.bc.RecordConsentBC;
import java.util.Locale;
import java.util.ResourceBundle;

public final class __recordconsentbasepage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/recordconsent/RecordConsentBasePage.jsp", 1738426377905L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<!DOCTYPE html> \n<html> \n<head> \n<title>Record Consent</title>\n\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery-1.9.1.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/jquery.mobile-1.0.1.min.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/js/iscroll5/iscroll.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/js/lib/ckeditor/ckeditor.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/jquery.mobile-1.0.1.min.css\" /> \n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/css/iPadNew_IP.css\" />  \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/css/iPADNew.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/css/mCommon.css\" /> \n\n\n<script>\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nfunction logout()\n{\n\tvar xmlhttp;\n\t\tif (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari\n\t\t\txmlhttp = new XMLHttpRequest();\n\t\t} else {// code for IE6, IE5\n\t\t\txmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\t}\n\t\txmlhttp.onreadystatechange = function() {\n\t\t\tif (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n\t\t\t\twindow.location = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/ipadlogin\";\n\t\t\t}\n\t\t}\n\t\txmlhttp.open(\"POST\", \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15_0 ="/eIPAD/jsp/Logoff.jsp\", true);\n\t\txmlhttp.send();\n}\n\n//This small jQuery plugin is used to assign the event handler function for the OK button of the confirm dialog\n(function ( $ ) {\n    $.fn.configureConfirmDialog = function(options) {\n    \tvar defaultVal =  {\n    \t        callBackForTrue: function () { },\n    \t    };\n    \tvar obj = $.extend(defaultVal, options);\n    \t$(this).find(\"[data-value=\'true\']\").off();\n        $(this).find(\"[data-value=\'true\']\").on(\"click\",obj.callBackForTrue);\n        return this;\n    };\n \n}( jQuery ));\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nvar path;\n\n$(document).ready(function(){\n\t//TODO Remove these JS variables if not used\n\tvar transactionMessage=\"\";\n\tvar transactionResult=\"\";\n\tvar formValErrClass=\"\";\n\t\n\tpath = $(\"#hdnPath\").val();\n\t$(\"#consentItemView\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t\n\tdisableButtonId(\'RecordConsentTickBtn\');\n\t\n\t\n\t$.getJSON( path+\"/mobile/charts/consent/RecordConsentJSONServlet?field=CONSENTCOUNT\", function(data){\n\t\t if(data.map.COUNT == 1){\n\t\t\t map = data.map;\n\t\t\t if(map.TOTAL_CONSENTS == 1){\n\t\t\t\t var order_id = map.ORDER_ID;\n\t\t\t\t var consent_form_id = map.CONSENT_FORM_ID;\n\t\t\t\t var consent_form_desc = map.CONSENT_FORM_DESC;\n\t\t\t\t var consent_stage = map.CONSENT_STAGE;\n\t\t\t\t if(consent_form_id==\"\"){\n\t\t\t\t\t $(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp?SingleVariable=true\');\n\t\t\t\t\t //Open consent form selection dialog -- ARAVINTHA\n\t\t\t\t }else{\n\t\t\t\t\t $(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp\',{order_id: order_id, consent_form_id: consent_form_id, consent_form_desc: consent_form_desc, consent_stage: consent_stage} );\n\t\t\t\t }\n\t\t\t\t //$(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp\');\n\t\t\t\t \n\t\t\t }else{\n\t\t\t\t $(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp\');\n\t\t\t }\n\t\t\t \n\t\t }else{\n\t\t\t $(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp\');\n\t\t }\n\t});\n\n});\n\nfunction returnToIPList(){\n\t var ipPage = path + \"/eIPAD/jsp/IPad.jsp?ActivePage=IP\";\n\t window.location.replace(ipPage); \n}\nfunction returnToIPListWithWarning(){\n\tvar toIPList = function()\n\t{\n\t\tcloseConfirmDialog();\n\t\treturnToIPList();\n\t\t\n\t};\n\t$(\"#RecordConsentConfirmDialog\").configureConfirmDialog({\n\t\tcallBackForTrue: toIPList\n\t});\n\tvar errorMsg = \"Are you sure you wish to cancel the current operation?\";\n\tshowConfirmDialog(errorMsg);\n\t \n}\nfunction showConfirmDialog(errorMsg){\n\t$(\"#RecordConsentConfirmDialogMsg\").html(errorMsg);\n\t$(\"#RecordConsentConfirmDialog\").show();\n\tshowMez(\'RecordConsentConfirmDialog\');\n}\nfunction closeConfirmDialog(){\n\t$(\"#RecordConsentConfirmDialog\").hide();\n\tcloseMez();\n}\nfunction closeMez(){\n\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t$(\"#\"+popid).hide();\n\t$(\"#dvMez\").hide();\n\t$(\"#dvMez\").off();\n\t//consentSelectPopup.refresh();\n}\nfunction showMez(popid){\n\t$(\'#dvMez\').show();\n\t$(\"#dvMez\").data(\"popid\",popid);\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t}, 500);\n}\n\nvar consentSelectPopup;\nfunction showConsentSelPop(cuurentObj){\t\n\t//alert(cuurentObj);\n\t//console.log(cuurentObj);\n\t//alert(\"cuurentObj\"+$(cuurentObj).data(\"order-catalog\"));\n\t\n\tvar orderCatalog=$(cuurentObj).data(\"order-catalog\");\n\tvar orderId=$(cuurentObj).data(\"order_id\");\n\tvar orderLineNum=$(cuurentObj).data(\"order_line_num\");\n\t//var orderSeq=$(cuurentObj).data(\"consent_seq\");\n\tvar stage=$(cuurentObj).data(\"stage-catalog\");\n\tvar currentindex=$(cuurentObj).data(\"order_index\");\n\tvar orderItemObj=$(\"#consentOrderItem\"+currentindex);\n\tvar orderSeq = orderItemObj.data(\"consent_seq\");\n\n\t\n\t$(\"#currentCode\").val(orderCatalog);\n\t$(\"#currentOrderId\").val(orderId);\n\t$(\"#currentLineNum\").val(orderLineNum);\n\t$(\"#currentSeq\").val(orderSeq);\n\t$(\"#currentstage\").val(stage);\n\t$(\"#currentindex\").val(currentindex);\n\t\n\t\n\t\n\t$(\"#ConsentFormSelPopup\").show();\n\tshowMez(\'ConsentFormSelPopup\');\t \n\tif(consentSelectPopup)\n\t\tconsentSelectPopup.destroy();\n\t setTimeout(function () {\n\t\t consentSelectPopup = new IScroll(\'#navConsentScrollWrapper\', { scrollbars: true, click: true,  mouseWheel: true } );\n   \t}, 100);\n}\nfunction closeConsentSelPop(){\n\t$(\"#ConsentFormSelPopup\").hide();\n\tcloseMez();\n\tconsentSelectPopup.refresh();\n}\t\n\n\nfunction consentFormEditorView(){\t\t\n\tcloseConsentSelPop();\n\t$(\"#consentItemView\").empty();\n\t$(\"#consentItemView\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t$(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp\');\n}\nfunction chooseConsentForm(desp,code){\n\tvar validation=\"true\";\n\tvar currentCode= $(\"#currentCode\").val();\n\tvar currentOrderId =$(\"#currentOrderId\").val();\n\tvar currentLineNum =$(\"#currentLineNum\").val();\n\tvar currentSeq =$(\"#currentSeq\").val();\n\t//alert(currentSeq);\n\tvar currentindex =$(\"#currentindex\").val();\n\t$(\'[data-order_id = \"\'+currentOrderId+\'\"]\').each(function (i,v ){\n\t\tvar const_id =$(this).data(\'consent-id\');\n\t\t//console.log(\"get values 12\"+const_id+\"===\"+code);\n\t\n\t\tif(const_id==code){\n\t\t\tvalidation=\"false\";\n\t\t\tsetTransactionMessage(false,\"Duplicate Values Not Allowed\");\n\t\t\t$(\"#ConsentFormSelPopup\").hide();\n\t\t\tcloseMez();\n\t\t\treturn;\n\t\t}\n\t});\n\tvar currentstage =$(\"#currentstage\").val();\n\tif(validation==\"true\")\t{\n\t\t\n\t\t $.ajax({\n\t\t\t  method: \"GET\",\n\t\t\t  url: path+\"/eIPAD/jsp/chartwidgets/recordconsent/AssignConsentFormControl.jsp\",\n\t\t\t  data: {desc: desp,code:code,currentCode:currentCode,currentOrderId: currentOrderId,currentLineNum:currentLineNum,currentSeq:currentSeq,currentstage:currentstage,currentindex:currentindex}\n\t\t})\n\t\t.done(function( data ) {\n\t\t\t$(\"#consentItemView\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t\t\t$(\"#consentItemView\").empty();\n\t\t\t$(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp\',{order_id: currentOrderId, consent_form_id: code, consent_form_desc: desp, consent_stage: currentstage} );\n\t\t\treturn;\n\t\t});\n\t\t$(\"#ConsentFormSelPopup\").hide();\n\t\tcloseMez();\n\t}\n}\nfunction disableButtonId(btnId){\n\t$(\"#\"+btnId).off();\n\t$(\"#\"+btnId).addClass(\"cstFieldDull\");\n}\n\nfunction enableRecordConsentTickBtn(){\n\t$(\"#RecordConsentTickBtn\").removeClass(\"cstFieldDull\");\n\t$(\"#RecordConsentTickBtn\").off();\n\t$(\"#RecordConsentTickBtn\").click(function() {\n\t\tperformRecordConsentTransaction();\n\t});\n}\nfunction performRecordConsentTransaction(){\n\t\n\t$(\"#consent_form_text0\").val(CKEDITOR.instances.RecConsentRTE.getData());\n\t$.ajax({\n\t\t  method: \"POST\",\n\t\t  url: path+\"/mobile/charts/consent/RecordConsentJSONServlet?field=RECORDCONSENT\",\n\t\t  data: $(\"#RecordConsentForm\").serialize()\n\t})\n\t.done(function(res) {\n\t\t//show toast message\n\t\tif(res.transactionResult == 0){\n\t\t\tvar msg=\"Consent recorded successfully\";\n\t\t\tsetTransactionMessage(true,msg);\n\t\t}else{\n\t\t\tvar msg=\"Consent could not be recorded\";\n\t\t\tsetTransactionMessage(false,msg);\n\t\t}\n\t\t$.getJSON( path+\"/mobile/charts/consent/RecordConsentJSONServlet?field=CONSENTCOUNT\", function(data){\n\t\t\t if(data.map.COUNT == 0){\n\t\t\t\t var transactionParams = \"&transactionOccurred=true&transactionMessage=\"+res.transactionMessage+\"&transactionResult=\"+res.transactionResult;\n\t\t\t\t var ipPage = path + \"/eIPAD/jsp/IPad.jsp?ActivePage=IP\"+transactionParams;\n\t\t\t\t window.location.replace(ipPage); \n\t\t\t }else{\n\t\t\t\t backToOrderList();\n\t\t\t }\n\t\t});\n\t});\n}\nfunction setTransactionMessage(result,errMsg){\n\tif(result){\n\t\t$(\"#transactionMsg\").addClass(\"formValSuccessTheme\").removeClass(\"formValErrorTheme\");\n\t\t$(\"#transactionMessageContent\").html(errMsg);\n\t}else{\n\t\t$(\"#transactionMsg\").addClass(\"formValErrorTheme\").removeClass(\"formValSuccessTheme\");\n\t\t$(\"#transactionMessageContent\").html(errMsg);\n\t\t\n\t}\n\t showTransactionMessage();\n}\n\nfunction showTransactionMessage(){\n\t$(\"#transactionMsg\").show();\n\tsetTimeout(function(){\n\t\t$(\"#transactionMsg\").hide();\n\t},5000);\n\t$(\"#transactionMsg\").bind(\'click\',function(){\n\t\t$(this).hide();\n\t});\n}\nfunction backToOrderList(){\n\t$(\"#consentItemView\").empty();\n\t$(\"#consentItemView\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t$(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentList.jsp\');\n}\nfunction editConsentForm(index, consent_form_id, consent_form_desc, consent_stage){\n\tvar orderItemObj=$(\"#consentOrderItem\"+index);\n\tvar order_catalog_code=orderItemObj.data(\"order_catalog_code\");\n\tvar order_id=orderItemObj.data(\"order_id\");\n\tvar ord_id=orderItemObj.data(\"ord_id\");\n\tvar ord_typ_code=orderItemObj.data(\"ord_typ_code\");\n\tvar ord_line_num=orderItemObj.data(\"ord_line_num\");\n\tvar cont_order_ind=orderItemObj.data(\"cont_order_ind\");\n\tvar ord_appr_by_user_id=orderItemObj.data(\"ord_appr_by_user_id\");\n\tvar ord_appr_reqd_yn=orderItemObj.data(\"ord_appr_reqd_yn\");\n\tvar order_set_id=orderItemObj.data(\"order_set_id\");\n\tvar pat_id=orderItemObj.data(\"pat_id\");\n\tvar pat_class=orderItemObj.data(\"pat_class\");\n\tvar encount_id=orderItemObj.data(\"encount_id\");\n\tvar ord_catalog_desc=orderItemObj.data(\"ord_catalog_desc\");\n\tvar link_ref=orderItemObj.data(\"link_ref\");\n\tvar link_ref_no=orderItemObj.data(\"link_ref_no\");\n\tvar ord_auth_reqd_yn=orderItemObj.data(\"ord_auth_reqd_yn\");\n\tvar ord_auth_by_pract_id=orderItemObj.data(\"ord_auth_by_pract_id\");\n\tvar priority=orderItemObj.data(\"priority\");\n\tvar location_type=orderItemObj.data(\"location_type\");\n\tvar location_code=orderItemObj.data(\"location_code\");\n\tvar consent_form_list=orderItemObj.data(\"consent_form_list\");\n\tvar link_ref_det=orderItemObj.data(\"link_ref_det\");\n\tvar appt_reqd_yn=orderItemObj.data(\"appt_reqd_yn\");\n\t//var consent_stage=orderItemObj.data(\"consent_stage\");\n\tvar patientdetails=orderItemObj.data(\"patientdetails\");\n\t\n\tvar facility_id = $(\"#facility_id\").val();\n\tvar practitioner_id = $(\"#practitioner_id\").val();\n\t\n\t$(\"#consentItemView\").empty();\n\t$(\"#consentItemView\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t$(\'#consentItemView\').load(path+\'/eIPAD/jsp/chartwidgets/recordconsent/PatientConsentListEditorView.jsp\',{order_id: order_id, consent_form_id: consent_form_id, consent_form_desc: consent_form_desc, consent_stage: consent_stage} );\n\t\t\n}\n</script>\n<style>\n#RecordConsentConfirmDialog {\n  display: none;\n  width: 340px;\n  height: 280px;\n  z-index: 500;\n}\n.Error_Window {\n\twidth: 325;\n\theight: 200px;\n\tborder: 2px solid #ffffff;\n\tbackground: #074860;\n\tmargin: 10px;\n\tmin-height: 200px;\n\tmax-width: 325px;\n\tbox-sizing: border-box;\n\t-moz-box-sizing: border-box;\n\t-webkit-box-sizing: border-box;\n\t-webkit-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\t-moz-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\tbox-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\tmargin: 10px;\n\tborder-radius: 10px;\n\tbox-sizing: border-box;\n\t-moz-box-sizing: border-";
    private final static byte[]  _wl_block15_0Bytes = _getBytes( _wl_block15_0 );

    private final static java.lang.String  _wl_block15_1 ="box;\n\t-webkit-box-sizing: border-box;\n\toverflow: hidden\n}\n\t.Error_msg_box {\n\twidth: 100%;\n\theight: 150px;\n\tmax-height: 150px;\n\tmax-width: 100%;\n\tborder-bottom: 1px solid #000000;\n}\n\t\n\t.Error_msg {\n\theight: 150px;\n\twidth: 100%;\n\toverflow: auto;\n\tz-index: 999999;\n\tposition: relative;\n\tdisplay: table;\n}\n\t.Error_msg_Frame {\n\tdisplay: table-cell;\n\tvertical-align: middle\n}\n\t.Error_icon\n{\n\twidth:60px;\n\theight:100%;\n\tfloat:left;\n\ttext-align:right;\n\t\n}\n.Error_cont\n{\n\theight:100%;\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:12px;\n\tcolor:#ffffff;\n\ttext-align:center;\n\tpadding-top: 10px;\n\tpadding-left:10px;\n}\n.Error_msg_btn {\n\twidth: 100%;\n\theight: 49px;\n\tbackground: #2ea3c0; /* Old browsers */\n\tbackground: -moz-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* FF3.6+ */\n\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2ea3c0), color-stop(50%, #2195b0), color-stop(51%, #0c7f9a), color-stop(100%, #0c7d9a)); /* Chrome,Safari4+ */\n\tbackground: -webkit-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Chrome10+,Safari5.1+ */\n\tbackground: -o-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Opera 11.10+ */\n\tbackground: -ms-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* IE10+ */\n\tbackground: linear-gradient(to bottom, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* W3C */\nfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#2ea3c0\', endColorstr=\'#0c7d9a\', GradientType=0 ); /* IE6-9 */\ndisplay:table;\n}\n\n.Error_btn_div_con_single\n{\n\twidth:100%;\n\theight:100%;\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:12px;\n\tfont-weight:bold;\n\tcolor:#ffffff;\n\ttext-align:center;\t\n\tdisplay: table-cell;\n\tvertical-align: middle;\n\tcursor:pointer;\n}\n.Error_btn_div_con\n{\n\twidth:159px;\n\theight:100%;\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:12px;\n\tfont-weight:bold;\n\tcolor:#ffffff;\n\ttext-align:center;\t\n\tdisplay: table-cell;\n\tvertical-align: middle;\n\tcursor:pointer;\n\t\n}\n.Error_btn_div\n{\n\twidth:0px;\n\theight:100%;\n\tborder-left:1px solid #0bb5dd;\n\tborder-right:1px solid #023542;\n\tfloat: left;\n}\n\t.top_shadow {\n\twidth: 100%;\n\theight: 90px;\n\tbackground: #3b6f81; /* Old browsers */\n\tbackground: -moz-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* FF3.6+ */\n\tbackground: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, #3b6f81), color-stop(64%, #074860)); /* Chrome,Safari4+ */\n\tbackground: -webkit-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Chrome10+,Safari5.1+ */\n\tbackground: -o-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Opera 12+ */\n\tbackground: -ms-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* IE10+ */\n\tbackground: radial-gradient(ellipse at center, #3b6f81 0%, #074860 64%); /* W3C */\nfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#3b6f81\', endColorstr=\'#074860\', GradientType=1 ); /* IE6-9 fallback on horizontal gradient */\n\tmargin-top: -40px;\n\tmargin-top: -240px;\n\tz-index: -999;\n}\n\n</style>\n</head>\n<body>\n\t<div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" onclick=\"\" data-popid=\"\" style=\"z-index:10000\"></div><!-- TODO -->\n\t<div id=\"RecordConsentConfirmDialog\" class=\"absoluteCenter\" style=\"z-index:10005\"><!-- TODO -->\n\t\t<div class=\"Error_Window\">\n\t\t  <div class=\"Error_msg_box\">\n\t\t    <div class=\"Error_msg\">\n\t\t      <div class=\"Error_msg_Frame\">\n\t\t        <div>\n\t\t          <div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block15_1Bytes = _getBytes( _wl_block15_1 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\" /> </div>\n\t\t          <div class=\"Error_cont\" id=\"RecordConsentConfirmDialogMsg\"></div>\n\t\t        </div>\n\t\t      </div>\n\t\t    </div>\n\t\t  </div>\n\t\t  <div class=\"Error_msg_btn\">\n\t\t    <div class=\"Error_btn_div_con\" onclick=\"closeConfirmDialog()\">Cancel </div>\n\t\t    <div class=\"Error_btn_div\"> </div>\n\t\t    <div class=\"Error_btn_div_con\" data-value=\"true\">OK </div><!-- Onclick event for OK button will be binded dynamically -->\n\t\t  </div>\n\t\t  <div class=\"top_shadow\"> </div>\n\t\t</div>\n\t</div>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\n\t<div id=\"ConsentFormSelPopup\" class=\"absoluteCenter\" >\n\t\t<div class=\"navModal-content\">\n\t\t\t<div class=\"navAccess\">SELECT CONSENT FORM</div>\n\t\t<div  id=\"navConsentScrollWrapper\">\n\t\t\t\t<div  id=\"navConsentScroll\">\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\n\t\t\t\t\t<!-- Each Form Item STARTS -->\n\t\t\t\t\t<div class=\"popTable navControl\" onclick=\"chooseConsentForm(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">\n\t\t\t\t\t\t<div class=\"popTableRow\">\n\t\t\t\t\t\t\t<div class=\"popTableRowCellLab\" >\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eIPAD/images/Consent16x16.PNG\"></img>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"popTableRowCellCont\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div>\n\t\t\t\t\t\t\t<div class=\"popTableRowCellClick\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/eIPAD/images/Arrow_24x24.png\"></img>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- Each Form Item ENDS -->\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"navConsentCancel\"  id=\"closePoPUp\" onclick=\"closeConsentSelPop()\">CANCEL</div>   \n\t\t</div>\n\t</div>  \n\n\n\t<div id=\"divParent\" class = \"mdivParent\" data-role=\"page\">\n\t\t\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<div id=\"divTable\" class = \"mdivTable\" data-role = \"none\">\n\t\t\t\n\t\t\t\t<!-- header starts -->\n\t\t\t\t<div data-role = \"none\" class = \"mheaderRow\" id=\"EMHeader\">\n\t\t\t\t\t<table class=\"mheader grd1-theme\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t        <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t<td style = \"width:90%;height:100%\" align = \"left\" ><span class=\"mheaderText headerText1-theme\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" - ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</span></td>\n\t\t\t\t\t\t\t<td style = \"width:10%;height:100%\" valign = \"center\" align = \"right\" onclick = \"logout()\">\n\t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/eIPAD/images/Logout1.png\" class=\"mHeaderImgLogout\" ></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t        </tr>\n\t\t       \t\t</table>\n\t\t\t       \n\t\t\t\t\t<div class = \"PatienBannerContainer PatientBannerContainerTheme\" data-role = \"none\" >\n\t\t\t\t\t    <div class = \"PatientBannerRow\" data-role = \"none\">\n\t\t\t\t\t    \t<div class = \"PatientBannerPhotoCol\" data-role = \"none\">\n\t\t\t\t\t    \t\t<img class=\"PatientBannerImage\" width=\"55\" height=\"55\" src=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/mobile/PatientImageServlet?PatientId=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t    \t</div>\n\t\t\t\t\t    \t<div class = \"PatientBannerDataCol\" data-role = \"none\">\n\t\t\t\t\t\t    \t<div data-role = \"none\" class = \"PatientBannerDataLine1\">\n\t\t\t\t\t\t    \t\t<div class = \"PatientBannerDataRow1\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerPatientIDCol PatientBannerPatientIDColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div>\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerPatientNameCol PatientBannerPatientNameColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</div>\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerTextCol PatientBannerTextColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div>\n\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t    \t<div data-role = \"none\" class = \"PatientBannerDataLine2\">\n\t\t\t\t\t\t    \t\t<div class = \"PatientBannerDataRow2\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerTextCol PatientBannerTextColTheme\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t    \t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;-\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t    \t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =",&nbsp;\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t    \t\t\t\t \t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",&nbsp; \n\t\t\t\t\t\t    \t\t\t\t\t\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&nbsp; \n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" \n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t    \t\t\t</div>\n\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerLabelCol PatientBannerLabelColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</div><!-- TODO replace with message bundle text --> \n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerTextCol PatientBannerTextColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</div>\n\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t    \t\t\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerLabelCol PatientBannerLabelColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</div><!-- TODO replace with message bundle text -->\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerTextCol PatientBannerTextColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</div>\n\t\t\t\t\t\t    \t\t\n\t\t\t\t\t\t    \t\t\t\n\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t    \t</div> \n\t\t\t\t\t    \t</div>\n\t\t\t\t\t    \t<div class = \"PatientBannerIconCol\" data-role = \"none\">\n\t\t\t\t\t    \t\t<div class = \"PatientBannerIconTable\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t<div class = \"PatientBannerIconRow\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerIcons\" data-role = \"none\"><img class=\"PatientBannerIconImg\" src=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="/eIPAD/images/VIP.png\"></div>\n\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t    \t\t<div class = \"PatientBannerIconRow\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerIcons\" data-role = \"none\"><img class=\"PatientBannerIconImg\" src=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="/eIPAD/images/Down Arrow.png\" style=\"display:none\"></div>\n\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t    \t</div>\n\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t     \n\t\t\t       \t</div>\n\t\t   \t\t</div><!-- div first row header ends  -->\n\t\t   \t\t\n\t\t   \t\t<!-- Page content starts -->\n<div data-role = \"none\" class = \"secondRow secondRowTheme\">\n<div class=\"ChartsContent\">\n<div class=\"ChartsIframeContainer\" id=\"patientConsentListContainer\">\n<div id=\"ContentPageID\" style=\"display:table;height: 100%;width: 100%;-moz-box-sizing: border-box;-webkit-box-sizing: border-box;-ms-box-sizing: border-box;box-sizing: border-box;position: absolute;overflow: hidden;left: 0;right: 0;top: 0;bottom: 0;border: 5px solid transparent;\">\n<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px;height: 1%;display:table-row;\" data-role=\"none\">\n\t<div style=\"display:table-cell;\">\n\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\" data-role=\"none\">\n\t\t<tr class=\"normalTr\">\n\t\t\t<td class=\"normalTd\">\n\t\t\t\t<div class=\"viewNotesHeader  RecordAllergyHeaderTheme\" style=\"border-bottom: 1px solid transparent;\">\n\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 95%; text-align: left\">\n\t\t\t\t\t\t\t\t<div class=\"allergyHeaderPageTitle ipHeaderPageTitleTheme\">Record Consent</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 5%\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme heightAlignment\" style = \"margin-right:10px;margin-top: 4px;\" onclick=\"\" id=\"RecordConsentTickBtn\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="/eIPAD/images/Tick25x25.png\">\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 5%\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme heightAlignment\" style = \"margin-right:10px;\" onclick=\"\" id=\"RecordConsentCanceBtn\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t</div>\n</div>\n<form id=\"RecordConsentForm\" name=\"RecordConsentForm\" id=\"RecordConsentForm\" style=\"width:100%;height:100%;\">\n\t<div id=\"consentItemView\" style =\"width:100%;height:100%;display: table;background:white;\">\n\t</div>\n</form>\n<div class=\"CSTransactionMessage\" id=\"transactionMsg\" style=\"bottom: 10px; left: 10px; display: none\">\n\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id = \"transactionMessageContent\"></div>\n\t\t\t\t\t\t\t\t</div>\n</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t   \t\t\n\t\t   \t\t<!-- Page content ends here -->\n\t\t   \t\t\n\t\t   \t\t<!-- Footer starts -->\n\t\t\t\t<div data-role = \"none\" class = \"footer\" id=\"EMFooter\" >\n\t\t\t\t\t<div class = \"footerContent footerContentTheme\" data-role = \"none\">\n\t\t\t     \t\t<table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t        \t<tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t\t<td style = \"width:65%;height:100%\" valign = \"top\">\n\t\t\t\t\t            \t<table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t\t            \t<tr style = \"width:100%;height:50%\">\n\t\t\t\t\t\t            \t\t<td style = \"width:100%;height:100%\" valign = \"top\" align = \"left\">\n\t\t\t\t\t\t            \t    \t<span class=\"spUserInfo\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</span>\n\t\t\t\t\t\t            \t  \t</td>\n\t\t\t\t\t\t            \t</tr>\n\t\t\t\t\t\t            \t<tr style = \"width:100%;height:50%\">\n\t\t\t\t\t\t            \t\t<td style = \"width:100%;height:100%\" valign = \"top\" align = \"left\">\n\t\t\t\t\t\t            \t  \t\t<span class=\"spUserInfo\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</span>\n\t\t\t\t\t\t            \t  \t</td>\n\t\t\t\t\t\t            \t</tr>\n\t\t\t\t\t            \t</table>\n\t\t\t\t\t          \t</td>\n\t\t\t\t\t          \t<td style = \"width:30%;height:100%\" align = \"right\" valign = \"top\">\n\t\t\t\t\t          \t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" <!-- TODO replace with message bundle text --> \n\t\t\t\t\t         \t\t<img src=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="/eIPAD/images/CSC_Logo.png\" class=\"imgCopyRights\"></img>\n\t\t\t\t\t          \t</td>\n\t\t\t\t        \t</tr>\n\t\t\t       \t\t</table>\n\t\t\t   \t\t</div>    \n\t\t   \t\t</div>\n\t\t   \t\t<!-- Footer Ends -->\n\t\t   \t\t\n\t\t\t</div><!-- divTable ends here -->\n\t\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnSelectedEncounter\" id = \"hdnSelectedEncounter\" value=\"\" />\n\t\t\t<input type = \"hidden\" name = \"hdnopeningPage\" id = \"hdnopeningPage\" value=\"\" />\n\t\t\t<input type = \"hidden\" name = \"hdnEpisodeId\" id = \"hdnEpisodeId\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnPatientId\" id = \"hdnPatientId\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnLocnType\" id =  \"hdnLocnType\" value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" />\n\t\t    <input type = \"hidden\" name = \"hdnLocnCode\" id =  \"hdnLocnCode\" value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" />\n\t\t    <input type=\"hidden\" name=\"hdnPatClass\" id=\"hdnPatClass\" id=\"hdnPatClass\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/>\n\t\t\t\n\t\t\t<input type = \"hidden\" name = \"currentOrderId\" id = \"currentOrderId\" value =\"\" />\n\t\t\t<input type = \"hidden\" name = \"currentCode\" id = \"currentCode\" value =\"\" />\n\t\t\t<input type = \"hidden\" name = \"currentLineNum\" id = \"currentLineNum\" value =\"\" />\n\t\t\t<input type = \"hidden\" name = \"currentSeq\" id = \"currentSeq\" value =\"\" />\n\t\t\t<input type = \"hidden\" name = \"currentstage\" id = \"currentstage\" value =\"\" />\n\t\t\t<input type = \"hidden\" name = \"currentindex\" id = \"currentindex\" value =\"\" />\n\t\t<!-- </form> -->\n\t</div> <!-- divParent ends here -->\n\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15_0Bytes, _wl_block15_0);
            _bw.write(_wl_block15_1Bytes, _wl_block15_1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);

	PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
	RecordConsentBC bc = new RecordConsentBC();
	RecordConsentFieldResponse consentFormListResp = bc.getConsentFormList(patientContext);
	List<RecordConsentFieldItem> consentFormList = consentFormListResp.getFieldList();
			

            _bw.write(_wl_block17Bytes, _wl_block17);

		if(!consentFormList.isEmpty()){
			
			for(int i=0;i<consentFormList.size();i++){
				RecordConsentFieldItem consentFormItem = consentFormList.get(i);
		
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(consentFormItem.getDesc() ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(consentFormItem.getCode()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consentFormItem.getDesc() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
		}else{
			out.println("No consent forms configured");
		}
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"product_description\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"version_no\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerPatientId}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerPatientId}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerPatientName}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerPatientNameLocal}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            _bw.write(_wl_block44Bytes, _wl_block44);
             org.apache.taglibs.standard.tag.rt.core.IfTag __tag5 = null ;
            int __result__tag5 = 0 ;

            if (__tag5 == null ){
                __tag5 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
            }
            __tag5.setPageContext(pageContext);
            __tag5.setParent(null);
            __tag5.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerEncounterId}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
            _activeTag=__tag5;
            __result__tag5 = __tag5.doStartTag();

            if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block45Bytes, _wl_block45);
                    out.print( String.valueOf(csResBundle.getString("common.encounterId") ));
                    _bw.write(_wl_block46Bytes, _wl_block46);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerEncounterId}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block47Bytes, _wl_block47);
                } while (__tag5.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag5);
                return;
            }
            _activeTag=__tag5.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
            __tag5.release();
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(csResBundle.getString("common.practitioner") ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerAttendPractName}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"login_user\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"facility_name\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"userSite\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.encounterId}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.patientId}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.locationType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.locationCode}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.patientClass}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block66Bytes, _wl_block66);
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerDob}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block34Bytes, _wl_block34);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerDob}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block35Bytes, _wl_block35);
            } while (__tag1.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerAge}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block37Bytes, _wl_block37);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerAge}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block38Bytes, _wl_block38);
            } while (__tag2.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerGender}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block39Bytes, _wl_block39);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerGender}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block40Bytes, _wl_block40);
            } while (__tag3.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerNationality}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block41Bytes, _wl_block41);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerNationality}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block42Bytes, _wl_block42);
            } while (__tag4.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerVip == \'true\' }",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block51Bytes, _wl_block51);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block52Bytes, _wl_block52);
            } while (__tag6.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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
}
