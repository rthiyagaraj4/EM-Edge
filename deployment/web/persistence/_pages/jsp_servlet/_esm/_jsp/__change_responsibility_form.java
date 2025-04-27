package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __change_responsibility_form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/change_responsibility_form.jsp", 1711000119100L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n<!-- added for new look need to do some changes -->\n <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/login.css\'></link> \n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="</title>\n\n<script language=\"JavaScript\">\n\tvar loadFlag=true;\n\tvar login_resp_flag=true;\n\tvar login_fac_flag=true;\n\t/*\n\tif(window.parent.opener!=null)\n\t{\n\t\tif(!window.parent.opener.closed)\n\t\t{\n\t\t\t//window.parent.opener.close();\n\t\t}\n\t}\n\t*/\n\tfunction cancelWindow(){\n\t\tvar myBars = \'directories=no,location=no,menubar=no,status=no\' ;\n\t\tvar myOptions = \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=yes, fullscreen=yes,scrollbars=no\' ;\n\t\tvar myFeatures = myBars + \', \' + myOptions ;\n\t\tvar ecisWindow = open( \'../../eCommon/jsp/eHIS.jsp\', \'eHISMain1\', myFeatures ) ;\n\t\tecisWindow.focus() ;\n\t\t window.close();\n\t}\n\tfunction changeFacility( listvalue ) {\n\t\tif(listvalue){\n\t\t\tdocument.forms[0].all.changeOK.disabled=false;\n\t\t\tdocument.forms[0].all.changeOK.style.cursor=\"hand\";\n\t\t\tvar lists=listvalue.split(\"|\");\n\t\t\tvar id=lists[0];\n\t\t\tvar name=lists[1];\n\t\t\tchange_responsibility_form.facility_id.value=id;\n\t\t\tchange_responsibility_form.facility_name.value=name;\n\t\t}else{\n\t\t\tdocument.forms[0].all.changeOK.disabled=true;\n\t\t\tdocument.forms[0].all.changeOK.style.cursor=\"default\";\n\t\t}\n\t}\n\tfunction change_resp(obj){\n\t\t//login_resp_flag=false;\t\n\t\tif(obj.getSelectedValue()!=null){\n\t\t\tvar id\t\t=obj.getSelectedValue() ;\n\t\t\tvar name\t=obj.getSelectedText() ;\n\t\t\tchange_responsibility_form.responsibility_id.value  = id ;\n\t\t\tchange_responsibility_form.responsibility_name.value    = name ;\n\t\t\tdocument.forms[0].all.changeOK.disabled=true;\n\t\t\tvar user_name=change_responsibility_form.current_user.value;\n\t\t\tvar resp_ID=change_responsibility_form.responsibility_id.value;\n\t\t\tdocument.change_responsibility_form.facility_id.value=\"\";\n\t\t\tvar xmlDoc=\"\";\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\t\txmlStr += \" user_name=\\\"\" + user_name + \"\\\"\"\t;\n\t\t\txmlStr += \" resp_ID=\\\"\" + resp_ID + \"\\\"\";\n\t\t\txmlStr += \" from=\\\"changeresp\\\"\";\n\t\t\txmlStr +=\" /></root>\" ;\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open( \"POST\",\"../../eSM/jsp/FacilitySelect.jsp\", false ) ;\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText=xmlHttp.responseText;\n\t\t\tresponseText = trimString(responseText);\n\t\t\taddfacility(responseText);\n\t\t}else{\n\t\t\t//document.getElementById(\"facilityRowID\").style.display=\"None\";\n\t\t\tdocument.change_responsibility_form.responsibility_id.value=\"\";\n\t\t\t/*document.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_RESPONSIBILITY\",\"Common\");\n\t\t\tvar obj=document.forms[0].elements[0];\n\t\t\tobj.focus();\n\t\t\tobj.select();*/\n\t\t\tlogin_resp_flag=false;\n\t\t}\n\t}\n\tfunction changeResponsibility( obj ) {\n\t\tvar facIndex;\n\t\tvar listvalue=obj.value;\n\t\tvar lists   = listvalue.split( \"|\" ) ;\n\t\tvar id  = lists[0] ;\n\t\tvar name    = lists[1] ;\n\t\tchange_responsibility_form.responsibility_id.value  = id ;\n\t\tchange_responsibility_form.responsibility_name.value    = name ;\n\t\tdocument.forms[0].all.changeOK.disabled=true;\n\t\tvar user_name=change_responsibility_form.current_user.value;\n\t\tvar resp_ID=change_responsibility_form.responsibility_id.value;\n\t\tdocument.change_responsibility_form.facility_id.value=\"\";\n\t\tvar xmlDoc=\"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\txmlStr += \" user_name=\\\"\" + user_name + \"\\\"\"\t;\n\t\txmlStr += \" resp_ID=\\\"\" + resp_ID + \"\\\"\";\n\t\txmlStr += \" from=\\\"changeresp\\\"\";\n\t\txmlStr +=\" /></root>\" ;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open( \"POST\",\"../../eSM/jsp/FacilitySelect.jsp\", false ) ;\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=xmlHttp.responseText;\n\t\tresponseText = trimString(responseText);\n\t\taddfacility(responseText);\n\t}\n\tfunction addfacility(valueText){\n\t\tvar cap_sep=valueText.split(\'^\')\n\t\tvar fc_value=cap_sep[0];\n\t\tvar fc_count=cap_sep[1];\n\t\tvar ival=0;\n\t\tvar facilityselectIndex=\"0\";\n\t\tvar facIndex;\n\t\tvar facilityString=\"<select class=\'select\' style=\'width: 290px\' name=\'facility\' id=\'facility\' id=\\\"facility\\\"  onchange=\\\"selectfacility(this)\\\" onkeypress=\\\"loginAppl_fac_event(this)\\\" onblur=\\\"facility_blur(facility)\\\">\";\n\t\tvar facility_id_active=\"\";\n\t\tfacility_id_active=document.change_responsibility_form.facility_id_active.value;\n\t\tif(!loadFlag){\n\t\t\t//var facility_id_active=\"\";\n\t\t\tvar dol_facility=fc_value.split(\'$\');\n\t\t\tvar len=dol_facility.length;\n\t\t\t//facility_id_active=document.change_responsibility_form.facility_id_active.value;\n\t\t\tfor(var i=0;i<len;i++){\n\t\t\t\tvar facility_id_local=\"\";\n\t\t\t\tvar facility_name_local=\"\";\n\t\t\t\tvar split_fac=dol_facility[i].split(\'~\');\n\t\t\t\tfacility_id_local=split_fac[0];\n\t\t\t\tfacility_name_local=split_fac[1];\n\t\t\t\tdocument.forms[0].all.changeOK.disabled=false;\n\t\t\t\tdocument.forms[0].all.changeOK.style.cursor=\"hand\";\n\t\t\t\tif(facility_id_active==facility_id_local){\n\t\t\t\t\tdocument.change_responsibility_form.facility_id.value    = facility_id_local ;\n\t\t\t\t\tdocument.change_responsibility_form.facility_name.value  = facility_name_local ;\n\t\t\t\t\tfacIndex=i;\n\t\t\t\t}\n\t\t\t\tloadFlag=true;\n\t\t\t\tfacilityString +=\"<option value=\"+facility_id_local+\"|\"+facility_name_local+\">\"+facility_name_local+\"</option>\";\n\t\t\t}\n\t\t\tfacilityString +=\"</select>\";\n\t\t\tdocument.getElementById(\"facilityIDTd\").innerHTML=facilityString;\n\t\t\teval(\"var facility=dhtmlXComboFromSelect(\\\"facility\\\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\\\"click\\\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\\\"onOpen\\\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\\\"\\\");facility.filterSelf();},1);return true;});dhtmlxEvent(facility.DOMelem_input,\\\"onchange\\\",function(){selectfacility(this)});dhtmlxEvent(facility.DOMelem_input,\\\"keypress\\\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\\\"blur\\\",function(){facility_blur(facility)});\");\n\t\t\tvar obj=document.forms[0].elements[0];\n\t\t\tobj.focus();\n\t\t\tobj.select();\n\t\t\tfacility.selectOption(facIndex);\n\t\t\tlogin_resp_flag=true;\n\t\t\tlogin_fac_flag=true;\n\t\t}else{\n\t\t\tif(fc_count==0){\n\t\t\t\tdocument.getElementById(\"facilityRowID\").style.display=\"None\";\n\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"NO_FACILITIES\",\"Common\");\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"None\";\n\t\t\t\tdocument.getElementById(\"facilityRowID\").style.display=\"\";\n\t\t\t\tvar dol_facility=fc_value.split(\'$\');\n\t\t\t\tvar len=dol_facility.length;\n\t\t\t\tfor(var i=0;i<len;i++){\n\t\t\t\t\tvar split_fac=dol_facility[i].split(\'~\');\n\t\t\t\t\tdocument.forms[0].all.changeOK.disabled=false;\n\t\t\t\t\tdocument.forms[0].all.changeOK.style.cursor=\"hand\";\n\t\t\t\t\tif(i==0){\n\t\t\t\t\t\tchange_responsibility_form.facility_id.value    = split_fac[0] ;\n\t\t\t\t\t\tchange_responsibility_form.facility_name.value  = split_fac[1] ;\n\t\t\t\t\t}\n\t\t\t\t   \n\t\t\t\t   var isSelect\t = \"\";\n\t\t\t\t   if(split_fac[0]==facility_id_active){\n\t\t\t\t\t isSelect\t= \"selected\";\n\t\t\t\t\t change_responsibility_form.facility_id.value    = split_fac[0] ;\n\t\t\t\t\t change_responsibility_form.facility_name.value  = split_fac[1] ;\n\t\t\t\t    }\n\t\t\t\t\t\n\t\t\t\t\tfacilityString +=\"<option value=\"+split_fac[0]+\"|\"+split_fac[1]+\" \"+isSelect+\">\"+split_fac[1]+\"</option>\";\n\t\t\t\t}\n\t\t\t\tfacilityString +=\"</select>\";\n\t\t\t\tdocument.getElementById(\"facilityIDTd\").innerHTML=facilityString;\n\t\t\t\teval(\"var facility=dhtmlXComboFromSelect(\\\"facility\\\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\\\"click\\\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\\\"onOpen\\\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\\\"\\\");facility.filterSelf();},1);return true;});dhtmlxEvent(facility.DOMelem_input,\\\"onchange\\\",function(){selectfacility(this)});dhtmlxEvent(facility.DOMelem_input,\\\"keypress\\\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\\\"blur\\\",function(){facility_blur(facility)});\");\n\t\t\t\tvar obj=document.forms[0].elements[0];\n\t\t\t\tobj.focus();\n\t\t\t\tobj.select();\n\t\t\t\tdocument.forms[0].all.changeOK.disabled=false;\n\t\t\t}\n\t\t}\n\t}\n\tfunction facility_blur(obj){\n\t\tdocument.getElementById(\"errMSGID0\").style.display=\"None\";\n\t\tdocument.forms[0].all.changeOK.disabled=false;\n\t\tdocument.forms[0].all.changeOK.style.cursor=\"hand\";\n\t\tobj.setComboText((obj.getSelectedText()).replace(/\\&amp;/g,\'&\'));\n\t\tif(obj.getSelectedValue()==null){\n\t\t\tdocument.change_responsibility_form.facility_id.value=\"\";\n\t\t}else{\n\t\t}\n\t}\n\tfunction responsibility_blur(obj){\n\t\tobj.setComboText((obj.getSelectedText()).replace(/\\&amp;/g,\'&\'));\n\t\tdocument.getElementById(\"errMSGID0\").style.display=\"None\";\n\t\tdocument.forms[0].all.changeOK.disabled=false;\n\t\tdocument.forms[0].all.changeOK.style.cursor=\"hand\";\n\t\tif(obj.getSelectedValue()==null){\n\t\t\tdocument.change_responsibility_form.responsibility_id.value=\"\";\n\t\t\tlogin_resp_flag=false;\n\t\t}else{\n\t\t\tlogin_resp_flag=true;\n\t\t}\n\t}\n\tfunction selectfacility(obj){\n\t\tdocument.getElementById(\"errMSGID0\").style.display=\"None\";\n\t\tif(obj.getSelectedValue()!=null){\n\t\t\tchangeFacility(obj.getSelectedValue());\n\t\t}else{\n\t\t\tdocument.change_responsibility_form.facility_id.value=\"\";\n\t\t}\n\t}\n\tfunction loginAppl_resp_event(e){\n\t\tdocument.getElementById(\"errMSGID0\").style.display=\"None\";\t\t\n\t\tif(event.keyCode==13){\n\t\t\tif((document.change_responsibility_form.responsibility_id.value!=null && document.change_responsibility_form.responsibility_id.value!=\"\") && (document.change_responsibility_form.facility_id.value!=null && document.change_responsibility_form.facility_id.value!=\"\")){\t\n\t\t\t\t\tif(login_resp_flag){\n\t\t\t\t\t\tlogin();\n\t\t\t\t\t}else{\n\t\t\t\t\t\tlogin_resp_flag=true;\n\t\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tdocument.forms[0].all.changeOK.disabled=true;\n\t\t\t\tdocument.forms[0].all.changeOK.style.cursor=\"default\";\n\t\t\t\tif(document.change_responsibility_form.responsibility_id.value==\"\" && document.change_responsibility_form.facility_id.value==\"\"){\n\t\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_RESP_FACILITY\",\"Common\");\n\t\t\t\t}else if(document.change_responsibility_form.responsibility_id.value==\"\"){\n\t\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_RESPONSIBILITY\",\"Common\");\n\t\t\t\t}else if(document.change_responsibility_form.facility_id.value==\"\"){\n\t\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_FACILITY\",\"Common\");\n\t\t\t\t}\n\t\t\t}\n\t\t}else{\n\t\t\tlogin_resp_flag=false;\n\t\t}\n\t}\n\tfunction loginAppl_fac_event(e){\n\t\tdocument.getElementById(\"errMSGID0\").style.display=\"N";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="one\";\n\t\tif(event.keyCode==13){\n\t\t\tif((document.change_responsibility_form.responsibility_id.value!=null && document.change_responsibility_form.responsibility_id.value!=\"\") && (document.change_responsibility_form.facility_id.value!=null && document.change_responsibility_form.facility_id.value!=\"\")){\t\n\t\t\t\t\tif(login_fac_flag){\n\t\t\t\t\t\tlogin();\n\t\t\t\t\t}else{\n\t\t\t\t\t\tlogin_fac_flag=true;\n\t\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tdocument.forms[0].all.changeOK.disabled=true;\n\t\t\t\tdocument.forms[0].all.changeOK.style.cursor=\"default\";\n\t\t\t\tif(document.change_responsibility_form.responsibility_id.value==\"\" && document.change_responsibility_form.facility_id.value==\"\"){\n\t\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_RESP_FACILITY\",\"Common\");\n\t\t\t\t}else if(document.change_responsibility_form.responsibility_id.value==\"\"){\n\t\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_RESPONSIBILITY\",\"Common\");\n\t\t\t\t}else if(document.change_responsibility_form.facility_id.value==\"\"){\n\t\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_FACILITY\",\"Common\");\n\t\t\t\t}\n\t\t\t}\n\t\t}else{\n\t\t\tlogin_fac_flag=false;\n\t\t}\n\t}\n\tfunction login(){\n\t\tif((document.change_responsibility_form.responsibility_id.value!=null && document.change_responsibility_form.responsibility_id.value!=\"\") && (document.change_responsibility_form.facility_id.value!=null && document.change_responsibility_form.facility_id.value!=\"\")){\t\t\t\t\t\n\t\t\tdocument.change_responsibility_form.level.value=\'2\';\n\t\t\tdocument.change_responsibility_form.submit();\n\t\t}else{\n\t\t\tdocument.forms[0].all.changeOK.disabled=true;\n\t\t\tdocument.forms[0].all.changeOK.style.cursor=\"default\";\n\t\t\tif(document.change_responsibility_form.responsibility_id.value==\"\" && document.change_responsibility_form.facility_id.value==\"\"){\n\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_RESP_FACILITY\",\"Common\");\n\t\t\t}else if(document.change_responsibility_form.responsibility_id.value==\"\"){\n\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_RESPONSIBILITY\",\"Common\");\n\t\t\t}else if(document.change_responsibility_form.facility_id.value==\"\"){\n\t\t\t\tdocument.getElementById(\"errMSGID0\").style.display=\"\";\n\t\t\t\tdocument.getElementById(\"errMSGID\").innerHTML=getMessage(\"INAVLID_FACILITY\",\"Common\");\n\t\t\t}\n\t\t}\n\t}\n\tfunction MyAddress(data) {\n\t\tvar hostIP;\n\t\tvar index = data.indexOf(\"&\");\n\t\thostName = data.substr(0,index);\n\t\thostIP = data.substr(index+1,data.length);\n\t\tdocument.getElementById(\"clientIP\").value = hostIP;\n\t}\n\tfunction changeresload(){\n\t\tvar obj=document.forms[0].elements[0];\n\t\tobj.focus();\n\t\tobj.select();\n\t\tdocument.forms[0].all.changeOK.disabled=false;\n\t\t//document.change_responsibility_form.all.changeOK.disabled=true;\n\t\t//changeResponsibility(document.forms[0].dflt_respID);\n\t}\n\tfunction helpfunction(){\n\t\tvar dialogHeight= \"38.8\" ;\n\t\tvar dialogTop = \"125\" ;\n\t\tvar dialogWidth\t= \"63.8\" ;\n\t\tvar dialogLeft   = \"0\";\n\t\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\t\tvar arguments    = \"\" ;\t\t\n\t\tretVal \t \t = window.showModalDialog(\"../../eCommon/html/Switch_Responsibility.htm\",arguments,features); \n\t}\n\tfunction login_ok_event(e){\n\t\tif(event.keyCode==13||event.keyCode==32){\n\t\t\tlogin();\n\t\t}\n\t}\n\tfunction callUnloadFunction(){\n\t\t/*var xmlDoc\t\t= new ActiveXObject(\"Microsoft.XMLDom\");\n\t\tvar xmlHttp\t\t= new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\txmlStr += \" from=\\\"onloadswitchresp\\\"\";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc.loadXML( xmlStr );\n\t\txmlHttp.open( \"POST\",\"../../eSM/jsp/FacilitySelect.jsp\", false );\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=xmlHttp.responseText;\n\t\tresponseText = trimString(responseText);\n\t\taddfacility(responseText);*/\n\t}\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n<body class=\"mainSwitchResponsibility\" onload=\'changeresload()\' onunload=\'callUnloadFunction()\' onKeyDown = \'lockKey()\' scroll=\"no\" onLoad=\"window.document.title=Switch Responsibility\';\">\n<form name=\'change_responsibility_form\' id=\'change_responsibility_form\' method=\'post\' action=\'../../servlet/eSM.ChangeResponsibilityServlet\'>\n<!-- added for new look START-->\n<div id=\"Maincontainer\">\t\t\n    <div id=\"Contentcontainer\" style=\"background-image:url(\'../../eCommon/images/LoginBg.jpg\')\">\n       \t<div id=\"Contentcontainerbg\" >\n       \t  <table align=\"center\" width=\"637px\" height=\"425px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n     <tr>\n\t <!--Added by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t <td colspan=\"2\" style=\"padding-top: 45px;padding-right: 15px;\" align=\"right\">\n\t\t\t<br><img src=\"../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\"  width=\"57\" height=\"52\" /></br>\n\t\t</td>\n\t\t<tr>\n\t\t\t<td class=\"heading\" style=\"padding-top: 0px;padding-right: 15px;\" align=\"right\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t</tr>\n\t\t<!--Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t<!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n    <!--<td height=\"140\" colspan=\"2\" valign=\"bottom\">\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >-->\n      <!--<tr>-->\n       <!-- <td  class=\"version\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>--><!--Commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t\t   <!--<td ></td>\n      </tr>\n      <tr>\n        <td>&nbsp;</td>--><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n     <!-- </tr>\n    </table></td>-->\n\t<!--Commented End by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n  </tr>\n\t \n\t<tr>\n\t   <td class=\"version\" height=\"15px\">&nbsp;</td><!--Added by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\n\t    <!--<td class=\"heading\" style=\"padding-left:40px;\" height=\"30px\">\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>--><!--Commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n\t\t\t\t\t\t\t\t\t\t\t\n\t</tr>\n\t<tr class=\"HEADER\">\n\t<!--Below Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n    <td align=\"center\" colspan=\"2\" valign=\"top\" class=\"heading\" style=\"padding-left:40px; padding-right:40px; padding-top:6px;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td><!--Added padding-top:6px;  by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n    </tr> \n\t<tr class=\"HEADER\">\n    <td align=\"center\" colspan=\"2\" valign=\"top\" class=\"heading\" style=\"padding-left:40px; padding-right:40px;\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n    </tr> \n\n\t<tr>\n\t<!--Modified width=\"387\" as width=\"587\" by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t\t<td width=\"587\" valign=\"top\" style=\"padding-left:40px;\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n     \n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t<tr>\n        <td class=\"heading\" height=\"35px\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n      </tr>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t\t\t\t\t\t\t\t<tr>\n        <td class=\"heading\" height=\"35px\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </td>\n      </tr>\n\n\t  <tr id=\"facilityRowID\">\n        <td id=\"facilityIDTd\" class=\"heading\">\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="          \n       </td>\n      </tr>\n\t\t\t\t\t <tr>\n        <td>&nbsp;</td>\n      </tr>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<tr>\n\n\n        <td><table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n          <tr>\n            <td><table  style=\"border-collapse: collapse;\">\n              <tr>\n\t\t\t   <!--buttonLeft.PNG & ButtonRight.PNG commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002 -->\n\t\t\t <!-- <td width=\"8px\"><img src=\"../../eCommon/images/buttonLeft.PNG\" onclick=\"login()\"   style=\"cursor:pointer\"  ></img></td>--><td width=\"auto\"><input type=\"button\" class=\"button\" id=\"changeOK\"  style=\"cursor:pointer;\"  onclick=\"login()\" onkeypress=\'login_ok_event(event)\' onKeyDown=\'login_ok_event(event)\'  value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!--\t<td><img src=\"../../eCommon/images/ButtonRight.PNG\"  onclick=\"login()\"   style=\"cursor:pointer\"  ></img></td>-->\n              </tr>\n            </table></td>\n            <td>&nbsp;&nbsp; </td>\n            <td><table style=\"border-collapse: collapse;\">\n              <tr>\n\t\t\t   <!--buttonLeft.PNG & ButtonRight.PNG commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002 -->\n               <!-- <td width=\"8px\"><img src=\"../../eCommon/images/buttonLeft.PNG\" onclick=\"cancelWindow()\"   style=\"cursor:pointer\"  ></img></td>-->\n\t\t\t\t  <td width=\"auto\"><input type=\"button\"  class=\"button\"  onClick=\"cancelWindow()\" onkeypress=\"cancelWindow()\" style=\"cursor:pointer;\" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--<td><img src=\"../../eCommon/images/ButtonRight.PNG\" onclick=\"cancelWindow()\"   style=\"cursor:pointer\" ></img></td>-->\n              </tr>\n            </table></td>\n\t\t\t<!--Modified by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t\t<td><table align=\"centre\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n\t\t\t\t\t<tr id=\"errMSGID0\" style=\"display:none\">\n\t\t\t\t\t<td style=\"padding-left:10px;\"><img src=\"../../eCommon/images/Alert.png\" /></img> \n\t\t\t\t\t<span id=\"errMSGID\" class=\"loginError\" style=\"font-color:red;\" ></span></td>\n\t\t\t\t\t<!--Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n          </tr>\n        </table></td>\n      </tr>\n\n\t\t<tr>\n        <td>&nbsp;</td>\n      </tr>\n\t\t </table></td>\n\t\t <!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t\t <!--Below Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n    <!--<td width=\"325px\" style=\"padding-right:10px;\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\n\n\t<tr>\n        <td align=\"left\"><img src=\"../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\"  width=\"57\" height=\"51\" valign=\"middle\" /></td>\n        <td width=\"97%\" class=\"heading\" style=\"padding-left:10px;\"><span style=\"width:100px;\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span></td>-->\n\t\t<!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n     <!-- </tr>\n\n\n      <tr>\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      <tr id=\"errMSGID0\" style=\"display:none\">\n        <td colspan=\"2\"><img src=\"../../eCommon/images/Alert.png\" /></img>\n\t\t<span id=\"errMSGID\" class=\"loginError\" style=\"font-color:red;\"></span></td>\n      </tr>\n\t\n\t\t <tr>\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n\n      <tr>-->\n      <!--Below Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n       <!-- <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      <tr>\n        <td colspan=\"2\">&nbsp;</td>\n      </tr>\n      </table></td>\n  </tr>-->\n    <!--<tr>\n\t<td align=\"right\" valign=\"top\" style=\"padding-right:10px;padding-bottom:5px\" class=\"heading\" >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t  </tr>-->\n\t<!--<tr>\n\t   <td colspan=\"2\" align=\"center\" valign=\"top\" class=\"heading\" >&nbsp;</td>-->\n\t   <!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->\n      <!--</tr> -->\n\t   <!--Commented END by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n</table>\n\t\t<tr>\n\t<td align=\"right\" valign=\"top\" style=\"padding-right:10px;padding-bottom:5px\" class=\"heading\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td><!--Modified by Kamatchi for PMG2022-COMN-CRF-0012 US001-->\n\t  </tr>\n        </div>\n    </div>\n</div>\n<!-- added for new look END-->\n<input type=\"hidden\" name=\"responsibility_id\" id=\"responsibility_id\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name=\"responsibility_name\" id=\"responsibility_name\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"facility_id_active\" id=\"facility_id_active\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\">\n<input type=\"hidden\" name=\"level\" id=\"level\"               value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"dflt_respID\" id=\"dflt_respID\"               value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\n<!-- added  on 7/2/2003 for ip/name-->\n<input type=\"hidden\" name=\"clientIP\" id=\"clientIP\" value=\"\">          \n<input type=\"hidden\" name=\"user\" id=\"user\" value=\"\">\n<input type=\"hidden\" name=\"compname\" id=\"compname\" value=\"\">\n<input type=\"hidden\" name=\"domain\" id=\"domain\" value=\"\">\n<input type=\"hidden\" name=\"current_user\" id=\"current_user\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\n<!-- added  on 7/2/2003 for ip/name-->\n </form>\n</body>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n<Script Language=\"VBScript\">\n    Dim objNet\n    On Error Resume Next\n\n\t\'Set WshShell33 = CreateObject(\"WScript.Shell\")\n\t\'WshShell33.SendKeys \"{F11}\"\n    \n    Set objNet = CreateObject(\"WScript.NetWork\") \n    \n    Dim user\n    Dim compname\n    Dim domain\n    Set TheForm = Document.forms(\"change_responsibility_form\")\n    \n    TheForm.user.Value = objNet.UserName\n    TheForm.compname.Value = objNet.ComputerName\n    TheForm.domain.Value = objNet.UserDomain\n    \'msgBox TheForm.user\n\n    strInfo = \"Your Logged User Name is: \" & TheForm.user.Value & vbCRLF & _\n                \"Your PC Computer Name is: \" & TheForm.compname.Value & vbCRLF & _\n              \"Your Active Domain Name : \" & TheForm.domain.Value\n    \n\n\n    user = objNet.UserName\n    compname = objNet.ComputerName\n    domain = objNet.UserDomain\n\n    Set objNet = Nothing                        \n\n</Script>\n\n    <!-- <APPLET code=\"eCommon.ClientIP.class\" MAYSCRIPT  archive=\"../applet/clientIP.jar\" height=0 width=0></APPLET>  -->\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");


            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);

	Connection con =null;
	try {
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt         = null ;
		HashMap respMap=null;
		HashMap facMap=null;
		ResultSet rs                = null ;
		String dflt_respID="";
		String level                = request.getParameter( "level" ) ;
		String current_user         = (String) session.getAttribute( "login_user" ) ;
		String facility_id        = (String) session.getAttribute( "facility_id" ) ;
		String facility_name            = java.net.URLDecoder.decode((String) session.getAttribute( "facility_name" ),"UTF-8");
		
		//session.putValue("Login","Y");
		String responsibility_id        = (String) session.getAttribute( "responsibility_id" ) ;
		String responsibility_name      = (String) session.getAttribute( "responsibility_name" ) ;
		String locale            = (String) session.getAttribute( "LOCALE" ) ;
		locale = (locale == null || locale.equals(""))?"en":locale;
		//java.util.Locale loc = new java.util.Locale(locale);
		String desktop_code="";
		Properties p;
		//boolean flag=false;
		
		
		String userName="";
		p=( java.util.Properties ) session.getValue( "jdbc" ) ;
		userName=(String)session.getAttribute( "appl_user_name");
		if(userName==null || userName.equals("")){
			userName="";
		}
		String product_name="";
		String product_description="";
		String version_info="";
		String copyright_info="";
		String site_name="";
		String copyrights_dtls = "";//Added by Kamatchi S for PMG2021-COMN-CRF-0002
		try{
			//Modified by Kamatchi S for PMG2021-COMN-CRF-0002
			String inst_info="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.SITE_NAME  SITE_NAME,a.COPYRIGHTS_DTLS COPYRIGHTS_DTLS from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id=?";		
			pstmt=con.prepareStatement(inst_info) ;
			pstmt.setString(1,locale);		
			rs=pstmt.executeQuery() ;
			if(rs!=null && rs.next()){
				product_name=rs.getString("PRODUCT_NAME");
				product_description=rs.getString("PRODUCT_DESCRIPTION");
				version_info=rs.getString("VERSION_NO");
				copyright_info=rs.getString("COPYRIGHT_INFO");
				site_name=rs.getString("SITE_NAME");
				copyrights_dtls=rs.getString("COPYRIGHTS_DTLS");//Added by Kamatchi S for PMG2021-COMN-CRF-0002
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)
			pstmt.close();			
			if(version_info==null || version_info.equals("")){
				version_info="";
			}
			if(copyright_info==null || copyright_info.equals("")){
				copyright_info="";
			}
			//Added by Kamatchi S for PMG2021-COMN-CRF-0002
			if(copyrights_dtls==null || copyrights_dtls.equals("")){
				copyrights_dtls="";
				}
		}catch(Exception ex){		
			ex.printStackTrace();
		}
		//java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		//String sql="select resp_user.resp_id, resp_name,desktop_code  from sm_resp_lang_vw resp, sm_resp_for_user resp_user  where resp.resp_id = resp_user.resp_id and language_id = ? and resp.menu_id in (select menu_id from sm_menu_hdr where dev_tool='J') and resp_user.appl_user_id =? and resp_user.RESP_ID=?    and ( ( resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to >= trunc(sysdate) ) or ( resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to is null )  or ( resp_user.eff_date_to >= trunc(sysdate) and resp_user.eff_date_from is null)   or ( resp_user.eff_date_from is null and resp_user.eff_date_to is null ) ) and ( ( resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to >= trunc(sysdate) )   or ( resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to is null )  or ( resp.eff_date_to >= trunc(sysdate) and resp.eff_date_from is null)  or ( resp.eff_date_from is null and resp.eff_date_to is null ) ) and resp.eff_status='E' order by 2";
		String sql="SELECT   resp_user.resp_id, resp_name, desktop_code,(SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME FROM sm_resp_lang_vw resp, sm_resp_for_user resp_user WHERE resp.resp_id = resp_user.resp_id  AND language_id = ? AND resp.menu_id IN (SELECT menu_id FROM sm_menu_hdr WHERE dev_tool = 'J') AND resp_user.appl_user_id = ? AND resp_user.resp_id = ? AND NVL(resp_user.eff_date_from,TRUNC(SYSDATE)) <= TRUNC (SYSDATE) AND NVL(resp_user.eff_date_to,TRUNC(SYSDATE)) >= TRUNC (SYSDATE) AND NVL(resp.eff_date_from,TRUNC(SYSDATE)) <= TRUNC (SYSDATE) AND NVL(resp.eff_date_to,TRUNC(SYSDATE)) >= TRUNC (SYSDATE) AND resp.eff_status = 'E' ORDER BY 2";
		try{
			pstmt = con.prepareStatement( sql ) ;
			pstmt.setString( 1, locale ) ;
			pstmt.setString( 2, facility_id ) ;
			pstmt.setString( 3, locale ) ;
			pstmt.setString( 4, current_user ) ;
			pstmt.setString( 5, responsibility_id ) ;
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				responsibility_name=rs.getString("RESP_name");
				desktop_code	= rs.getString( "desktop_code" );
				facility_name = rs.getString("FACILITY_NAME");
				
				if(desktop_code!=null){
					session.putValue(responsibility_id,desktop_code);
				}else{
					session.putValue(responsibility_id,null);
				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)
					pstmt.close();
			
		}catch(Exception e){
			e.printStackTrace();	
		}
		if(level==null){
			level="1";
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(version_info));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(userName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(version_info));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(userName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(responsibility_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

												String  desktop_code_local="";
												//String respsql = "   select resp_user.resp_id, resp_name,desktop_code  from sm_resp_lang_vw resp, sm_resp_for_user resp_user  where resp.resp_id = resp_user.resp_id and language_id = ? and resp.menu_id in (select menu_id from sm_menu_hdr where dev_tool='J' OR (ADHOC_MENU_YN ='Y' AND TRUNC(SYSDATE) BETWEEN Nvl(ADHOC_MENU_EFF_FROM,TRUNC(SYSDATE)) AND NVL(ADHOC_MENU_EFF_TO ,TRUNC(SYSDATE)))) and resp_user.appl_user_id = ?  and ( ( resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to >= trunc(sysdate) ) or ( resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to is null )  or ( resp_user.eff_date_to >= trunc(sysdate) and resp_user.eff_date_from is null)   or ( resp_user.eff_date_from is null and resp_user.eff_date_to is null ) ) and ( ( resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to >= trunc(sysdate) )   or ( resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to is null )  or ( resp.eff_date_to >= trunc(sysdate) and resp.eff_date_from is null)  or ( resp.eff_date_from is null and resp.eff_date_to is null ) ) and resp.eff_status='E' order by 2";
												String respsql = "SELECT   RESP_USER.RESP_ID, RESP_NAME, DESKTOP_CODE FROM SM_RESP_LANG_VW RESP, SM_RESP_FOR_USER RESP_USER  WHERE RESP.RESP_ID = RESP_USER.RESP_ID AND language_id =? AND resp.menu_id IN (SELECT menu_id FROM sm_menu_hdr WHERE dev_tool = 'J' OR (adhoc_menu_yn = 'Y' AND TRUNC (SYSDATE) BETWEEN NVL (adhoc_menu_eff_from,TRUNC (SYSDATE)) AND NVL (adhoc_menu_eff_to,TRUNC (SYSDATE)))) AND resp_user.appl_user_id = ? AND NVL(resp_user.eff_date_from,TRUNC(SYSDATE)) <= TRUNC (SYSDATE) AND NVL(resp_user.eff_date_to,TRUNC(SYSDATE)) >= TRUNC (SYSDATE) AND NVL(resp.eff_date_from,TRUNC(SYSDATE)) <= TRUNC (SYSDATE) AND NVL(resp.eff_date_to,TRUNC(SYSDATE)) >= TRUNC (SYSDATE) AND resp.eff_status = 'E' ORDER BY 2";//Fine tuned Query for above Query
												
												pstmt = con.prepareStatement( respsql ) ;
												
												pstmt.setString(1,locale);
												pstmt.setString( 2, current_user ) ;
												rs = pstmt.executeQuery() ;
												int cls=0;
												respMap=new HashMap();
										
													while(rs!=null && rs.next()){
														String respId   = rs.getString( "resp_id" ) ;
														
														String respName = rs.getString( "resp_name" ) ;
														desktop_code_local	= rs.getString( "desktop_code" ) ;
														if(desktop_code_local!=null){ 
															session.putValue(respId,desktop_code_local);
														}else{ 
															session.putValue(respId,null);
														}
														if(responsibility_id.equals(respId)){
															dflt_respID=respId+"|"+respName;
														}
														respMap.put(respId,respName);
														cls++;
													}
													if(rs!=null)rs.close();
													if(pstmt!=null)
														pstmt.close();		
												
            _bw.write(_wl_block16Bytes, _wl_block16);
             com.iba.autocomplete.tags.IbaAutoCompleteComboTag __tag3 = null ;
            int __result__tag3 = 0 ;

            if (__tag3 == null ){
                __tag3 = new  com.iba.autocomplete.tags.IbaAutoCompleteComboTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
            }
            __tag3.setPageContext(pageContext);
            __tag3.setParent(null);
            __tag3.setMap(respMap
);
            __tag3.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("loginresponsibility", java.lang.String .class,"id"));
            __tag3.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("loginresponsibility", java.lang.String .class,"name"));
            __tag3.setDefaultSelection(responsibility_id
);
            __tag3.setOnchange(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("change_resp(this)", java.lang.String .class,"onchange"));
            __tag3.setOnkeypress(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("loginAppl_resp_event(this)", java.lang.String .class,"onkeypress"));
            __tag3.setOnblur(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("responsibility_blur(loginresponsibility)", java.lang.String .class,"onblur"));
            __tag3.setWidth(java.lang.Integer.valueOf( weblogic.utils.StringUtils.valueOf("290")).intValue());
            _activeTag=__tag3;
            __result__tag3 = __tag3.doStartTag();

            if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag3);
                return;
            }
            _activeTag=__tag3.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
            __tag3.release();
            _bw.write(_wl_block17Bytes, _wl_block17);
/* change starts for cross facility validation 17/Jul/2012*/
											String restrict_facility_by_db="N";
											try{
												pstmt = con.prepareStatement( "SELECT nvl(RESTRICT_FCY_BY_CURR_DB_YN,'N') RESTRICT_FCY_BY_CURR_DB_YN FROM SM_SITE_PARAM" ) ;
												rs = pstmt.executeQuery() ;					
												while(rs!=null && rs.next()){
													restrict_facility_by_db=rs.getString("RESTRICT_FCY_BY_CURR_DB_YN");
												}
											}catch ( Exception ex){
												restrict_facility_by_db="N";
											}finally{
												if (pstmt != null)pstmt.close();
												if (rs != null)rs.close();
											}
											String facSql ="";
											if(restrict_facility_by_db.equals("Y")) {
												facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = ?)  AND UPPER(CURR_DB)= 	(select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-LENGTH(CURR_DB)+1, LENGTH(CURR_DB))) from sm_db_info) ORDER BY 2";
											}else{
												 facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = ?) ORDER BY 2";
											}
											/* change ends for cross facility validation*/
											
											pstmt = con.prepareStatement( facSql ) ;
											pstmt.setString(1,locale);
											pstmt.setString( 2, current_user ) ;
											pstmt.setString( 3, responsibility_id ) ;
											rs = pstmt.executeQuery() ;
											facMap=new HashMap();
											while(rs!=null && rs.next()){
												String facId   = rs.getString( "facility_id" ) ;
												String facName = rs.getString( "facility_name" ) ;
												facMap.put(facId,facName);
											}
											if(rs!=null)rs.close();
											if(pstmt!=null)
												pstmt.close();
										
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
             com.iba.autocomplete.tags.IbaAutoCompleteComboTag __tag5 = null ;
            int __result__tag5 = 0 ;

            if (__tag5 == null ){
                __tag5 = new  com.iba.autocomplete.tags.IbaAutoCompleteComboTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
            }
            __tag5.setPageContext(pageContext);
            __tag5.setParent(null);
            __tag5.setMap(facMap
);
            __tag5.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("facility", java.lang.String .class,"id"));
            __tag5.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("facility", java.lang.String .class,"name"));
            __tag5.setDefaultSelection(facility_id
);
            __tag5.setOnchange(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("selectfacility(this)", java.lang.String .class,"onchange"));
            __tag5.setOnkeypress(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("loginAppl_fac_event(this)", java.lang.String .class,"onkeypress"));
            __tag5.setOnblur(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("facility_blur(facility)", java.lang.String .class,"onblur"));
            __tag5.setWidth(java.lang.Integer.valueOf( weblogic.utils.StringUtils.valueOf("290")).intValue());
            _activeTag=__tag5;
            __result__tag5 = __tag5.doStartTag();

            if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag5);
                return;
            }
            _activeTag=__tag5.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
            __tag5.release();
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(copyrights_dtls));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(copyrights_dtls));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(responsibility_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( level ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( dflt_respID ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(current_user));
            _bw.write(_wl_block31Bytes, _wl_block31);
 respMap.clear();
    }catch(Exception e){
		//out.println("Error "+e);
		e.printStackTrace();
		}
    finally { 
    ConnectionManager.returnConnection(con,request);
	//if(rs!=null)rs.close();
	//if(pstmt!=null)
			//pstmt.close();
			
    }
    
            _bw.write(_wl_block32Bytes, _wl_block32);
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
         com.iba.autocomplete.tags.IbaAutoCompleteSetupTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  com.iba.autocomplete.tags.IbaAutoCompleteSetupTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.switchResponsibility.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.responsibility.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancelhome.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
