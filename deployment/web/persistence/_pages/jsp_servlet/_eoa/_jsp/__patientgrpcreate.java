package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __patientgrpcreate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/PatientGrpCreate.jsp", 1731644503638L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<html>\n\t<head>\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script><!-- Supporting Js File For Fixed Header with scroll.... -->\n\t<script language=\'javascript\' src=\'../../eOA/js/PatientGroup1.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey()\'>\n\t<form name=\"GroupSearchCreate\" id=\"GroupSearchCreate\" id=\"GroupSearchCreate\" method=\"post\" action=\"../../servlet/eOA.GenerateGroupPatientsServlet\">\n\t<table cellpadding=\'1\' cellspacing=\'1\' width=\'100%\' border=\'0\'>\n\t\t<tr>\n\t\t<td class = \'label\'  width = \'20%\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td width=\'30%\' class=\'fields\'>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=text name=\'PatientId\' id=\'PatientId\' id=\"PatientId\" size=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" maxlength=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"  value=\'\' onBlur=\"changeCase(this),FnPatientValidation();\" disabled><input type=button name=\'commonLookup\' id=\'commonLookup\' id=\"commonLookup\"  value=\'?\' class=\'button\' onclick=\'callPatientSearch(); \' disabled> <img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td><!--  ChangeUpperCase(this); -->\n\t\t<td width=\'50%\'><input type=\"button\" name=\"AddPatientQueue\" id=\"AddPatientQueue\" id=\"AddPatientQueue\" class=\'button\' value=\"Add\" disabled onclick=\"FnAddToQueue();\"> </td>\n\t\t</tr>\n\t\t<tr></tr>\n\t\t<tr></tr>\n\t\t\t\n\t</table>\n\t<input type=\"hidden\" name=\"HidSelectedPatIdsInsert\" id=\"HidSelectedPatIdsInsert\" id=\"HidSelectedPatIdsInsert\" >\n\t<input type=\"hidden\" name=\"group_id\" id=\"group_id\" id=\"group_id\" >\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" id=\"mode\" value=\"insert\">\n\t<input type=\"hidden\" name=\"group_name\" id=\"group_name\" id=\"group_name\" >\n\t<div id=\"DivPatListQueue\"></div>\n\t</form> \n\t\n\t\n\t\n\n<script>\n\nasync function callPatientSearch(){\n\t var patientId=await PatientSearch();\n\t if (patientId!=null && patientId!=\'\'){\n\t  \t//alert(parent.frames[0].GroupSearchCriteria.group_location_id.value)\n\t  \tFnChkAlreadyExistsInGroup(patientId);\n\t }\n}\n\nfunction FnChkAlreadyExistsInGroup(patientId){\n\tvar LocnCode\t= $(\"#group_location_id\",parent.frames[0].GroupSearchCriteria).val();\n\t $.ajax({  \n\t     url:\'../../eOA/jsp/GetGroupLocation.jsp\',  \n\t     type:\'post\',  \n\t     data:{\'patientId\':patientId,\'action\':\'get_patient_details\',\'LocnCode\':LocnCode},\n\t     dataType: \'json\',\n\t     success: function(data) {\n\t      \tif(data.IsAlreadyExists==0){\n\t      \t\tGlbPatDetails\t= data.recordslist;\n\t      \t\t$(\"#PatientId\").val(patientId);\n\t\t\t\t\n\t      \t}else{\n\t      \t \tvar Message\t= getMessage(\"PATIENT_ALREADY_ASSIGNED\", \"OA\");\n\t      \t \tMessage\t\t= Message.replace(\"#\",data.group_name);\n\t      \t \talert(Message);\n\t      \t\tGlbPatDetails\t= \"\";\n\t      \t\t$(\"#PatientId\").val(\"\");\n\t       \t}\n\t     },\n\t     error: function(jqXHR, textStatus, errorThrown) {\n\t         alert(\"incoming Text \" + jqXHR.responseText);\n\t     }\n\t });\n}\n\n\nfunction changeCase(Obj){\n\tObj.value=Obj.value.toUpperCase();\n\tif(Obj.value !=\"\"){\n\t\tvar HTML=\"<html><body onKeyDown = \'lockKey()\'><form name=\'chkpatient_id\' id=\'chkpatient_id\' method=\'post\'  action=\'../../eOA/jsp/ServerSideValidation.jsp\'><input type=hidden name=\'from\' id=\'from\' value=\'chkpatient_id_valid\'><input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'\"+Obj.value+\"\'></form></body></html>\";\n\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTML);\n\t\tparent.messageFrame.document.chkpatient_id.submit();\n\t\t\n\t}\n}\n\nfunction FnAddToQueue(){\n\tparent.parent.frames[2].document.location.href=\"../../eCommon/jsp/error.jsp\";\n\tvar patid\t= $(\"#PatientId\").val();\n\tif(patid==\"\"){\n\t\talert(getMessage(\"PATIENT_SELECT\", \"OA\"));\n\t\treturn false\n\t}\n\tvar recordlist\t= eval(GlbPatDetails);\n\tvar DisplayData\t\t= \"\";\n\tvar patient_id\t\t= \"\";\n\tvar patient_data\t= \"\";\n\tvar tdclass\t\t\t= \"\";\n\tvar tdid\t\t\t= \"\";\n\t/*$.each(GlbExistingIds,function(i,v){\n\t\talert(v);\n\t});*/\n\t\n\t\n\tif(FnInArray(patid,GlbExistingIds)==false){\n\n\n\t\tif($(\"#tablepatlist\").is(\':visible\')==false){\n\t\t\tDisplayData\t\t= \"<table border=\'1\' width=\'99%\' style=\'border-spacing:0px ;border-collapse: collapse;\' id=\'tablepatlist\' ><tr><th width=\'80%\'><b>\"+getLabel(\"eOA.SelectedPatientList.label\",\"OA\")+\"</b></th><th  width=\'20%\'>\"+getLabel(\"Common.all.label\",\"Common\")+\"</b><input type=\'checkbox\' name=\'chkallnewpatients\' id=\'chkallnewpatients\' id=\'chkallnewpatients\' checked > </th></tr>\";\n\t\t}\n\t\t\n\t\t//if($(\"#pat_id_chk\").length > 0)\n\t\t$.each(recordlist,function(index,value){\n\t\t\tpatient_id\t\t= value.patient_id;\n\t\t\tpatient_data\t= value.patient_line;\n\t\t\ttdclass\t\t\t= \"AR_QRYEVEN\";\n\t\t\t\n\t\t\tDisplayData\t\t+= \"<tr>\";\n\t\t\tDisplayData\t\t+= \"<td class=\"+tdclass+\" valign=\'top\'>\";\n\t\t\tDisplayData\t\t+= \"<a href=\'javascript:viewPatientDetails(\\\"\"+patient_id+\"\\\")\'>+</a><font size=1>\"+patient_data+\"</font></td>\";\n\t\t\tDisplayData\t\t+= \"<td class=\"+tdclass+\" > <input type=checkbox name=\'pat_id_chk\' id=\'pat_id_chk\' value=\'\"+patient_id+\"\' checked  /> </td></tr>\";\n\t\t\t\n\t\t});\n\t\tif($(\"#tablepatlist\").is(\':visible\')==false){\n\t\t\tDisplayData\t\t\t+=\"</table>\";\n\t\t\t$(\"#DivPatListQueue\").html(DisplayData);\n\t\t}else{\n\t\t\t$(\"#tablepatlist\").append(DisplayData);\n\t\t}\n\t\tfxheaderInit(\'tablepatlist\',480);\n\t\t\n\t}else{\n\t\talert(getMessage(\"PATIENT_ALREADY_AVAILABLE_IN_LIST\", \"OA\"));\n\t\t$(\"#PatientId\").val(\"\");\n\t\treturn false;\n\t}\n\tGlbExistingIds.push(patid);\n\t$(\"#PatientId\").val(\"\");\n\tGlbPatDetails\t= \"\";\n}\n\n//Select/Deselect All checkboxes when the \"Select All\" checkbox is clicked\n$(document).on(\'click\', \"input[name=\'chkallnewpatients\']\", function() {\n    var isChecked = $(this).prop(\'checked\'); // Get the state of the \"Select All\" checkbox\n    $(\"input[name=\'pat_id_chk\']\").prop(\'checked\', isChecked); // Set all checkboxes to match \"Select All\"\n});\n\n// Update the \"Select All\" checkbox based on individual checkbox states\n$(document).on(\'click\', \"input[name=\'pat_id_chk\']\", function() {\n    var allChecked = $(\"input[name=\'pat_id_chk\']\").length === $(\"input[name=\'pat_id_chk\']:checked\").length;\n    $(\"input[name=\'chkallnewpatients\']\").prop(\'checked\', allChecked); // If all are checked, mark \"Select All\" as checked\n});\n\n\nfunction FnInArray(needle, haystack) {\n    var length = haystack.length;\n    for(var i = 0; i < length; i++) {\n        if(haystack[i] == needle)\n        \treturn true;\n    }\n    return false;\n}\n\nfunction FnInsert(){\n\tvar VarPatIds\t\t= FnGetCheckdValues();\n\tvar VarPatCount\t\t= FnGetCheckedCount();\n\t$(\"#HidSelectedPatIdsInsert\").val(\"\");\n\tvar VarMaxPatient\t= $(\"#max_patient\",parent.frames[0].GroupSearchCriteria).val();\n\tvar VarCheckCount\t= parseInt($(\"#Existing_Group_Members\",parent.frames[0].GroupSearchCriteria).val())+VarPatCount;\n\tvar IsError\t\t\t= 0;\n\tif(VarPatIds==\"\"){\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\", \"common\"));\n\t\tparent.parent.commontoolbarFrame.document.location.reload();\n\t\tIsError\t= 1;\n\t}else if(VarCheckCount > VarMaxPatient){\n\t\talert(getMessage(\"MAX_PAT_LIMIT_REACHED\", \"OA\"));\n\t\tparent.parent.commontoolbarFrame.document.location.reload();\n\t\tIsError\t= 1;\n\t}\n\tif(IsError==0){\n\t\t$(\"#HidSelectedPatIdsInsert\").val(VarPatIds);\n\t\t$(\"#group_id\").val($(\"#group_id\",parent.frames[0].GroupSearchCriteria).val());\n\t\t$(\"#group_name\").val($(\"#group_name\",parent.frames[0].GroupSearchCriteria).val());\n\t\t$(\"#GroupSearchCreate\").submit();\n\t}\n}\n\n\nfunction FnGetCheckedCount(){\n\tvar count\t= 0;\n\t$(\"input[name=\'pat_id_chk\']\").filter(\':checked\').each(function() {\n\t\tcount\t= count + 1;\n\t});\n\treturn parseInt(count);\n}\n\n\nfunction FnGetCheckdValues(){\n\tvar VarPatIds\t= \"\";\n\t$(\"input[name=\'pat_id_chk\']\").filter(\':checked\').each(function() {\n\t\tVarPatIds+=$(this).val()+\"|\";\n\t});\n\tif(VarPatIds!=\'\'){\n\t\tVarPatIds\t= VarPatIds.slice(0,-1);\n\t}\n\treturn VarPatIds;\n}\n\n//$(\"input[name=\'chkallnewpatients\']\").live(\'click\',function() \n\t$(document).on(\'click\', \"input[name=\'chkallnewpatients\']\", function(){\n\tvar checked = $(this).attr(\'checked\');\n\tif(checked == \'checked\') {\n\t\t$(\"input[name=\'pat_id_chk\']\").attr(\"checked\", true);\n\t} else {\n\t\t$(\"input[name=\'pat_id_chk\']\").attr(\"checked\", false);\n\t}\n});\n\n//$(\"input[name=\'pat_id_chk\']\").live(\'click\',function()\n  $(document).on(\'click\', \"input[name=\'pat_id_chk\']\", function(){\n\tif($(\"input[name=\'pat_id_chk\']\").length == $(\"input[name=\'pat_id_chk\']\").filter(\':checked\').length) {\n\t\t$(\"input[name=\'chkallnewpatients\']\").attr(\"checked\", true);\n\t} else {\n\t\t$(\"input[name=\'chkallnewpatients\']\").attr(\"checked\", false);\n\t}\n});\n\n\nfunction FnPatientValidation(){\n\t\n\tvar patientId\t= $(\"#PatientId\").val();\n\tif(patientId!=\'\'){\n\t\t$.ajax({  \n\t\t     url:\'../../eOA/jsp/GetGroupLocation.jsp\',  \n\t\t     type:\'post\',  \n\t\t     data:{\'patientId\':patientId,\'action\':\'chk_valid_patient\'},\n\t\t     dataType: \'json\',\n\t\t     success: function(data) {\n\t\t\t      if(data.pat_status!=\"\" || data.pat_status!=null){\n\t\t\t    \t  var pat_status\t= data.pat_status;\n\t\t\t\t\t  var ErrorMessage\t= \"\";\n\t\t\t    \t  if (pat_status==\"SUSPENDED\"){  \n\t\t\t    \t\t ErrorMessage= getMessage(\'PAT_SUSPENDED_NOT_ALLOWED\',\'MP\'); \n\t\t\t          }else if (pat_status==\"DECEASED\"){\n\t\t\t\t\t\t ErrorMessage= getMessage(\'PAT_DECEASED_NOT_ALLOWED\',\'MP\'); \n\t\t\t\t\t  }else if (pat_status==\"SECURED\"){\n\t\t\t\t\t\t ErrorMessage= getMessage(\'SECURED_NOT_ALLOWED\',\'COMMON\'); \n\t\t\t\t\t  }else if (pat_status==\"INACTIVE\"){\n\t\t\t\t\t\t ErrorMessage= getMessage(\'PAT_INACTIVE_NOT_ALLOWED\',\'MP\'); \n\t\t\t\t\t  }else if (pat_status==\"BLACKLISTED_PATIENT\"){\n\t\t\t\t\t\t ErrorMessage= getMessage(\'BLACKLISTED_PATIENT\',\'MP\'); \n\t\t\t\t\t  }else if ( pat_status==\"INVALID_PATIENT\"){\n\t\t\t\t\t\t ErrorMessage\t= getMessage(\'INVALID_PATIENT\',\'MP\');\n\t\t\t\t\t  }else if(pat_status.indexOf(\"PATIENT_MERGED_VALID\") > -1){\n\t\t\t\t\t\t var valid_patient_id\t= pat_status.split(\"$\");\n\t\t\t\t\t\t  if(pat_status.length>0){\n\t\t\t\t\t\t\t  ErrorMessage\t= getMessage(\'PATIENT_MERGED_VALID\',\'MP\');\n\t\t\t\t\t\t\t  ErrorMessage\t= ErrorMessage.replace(\"#\",valid_patient_id[1]);\n\t\t\t\t\t\t  }\n\t\t\t\t\t  }\n\t\t\t\t\t  if(ErrorMessage!=\'\'){\n\t\t\t\t\t\talert(ErrorMessage);\n\t\t\t\t\t\t$(\"#PatientId\").val(\"\");\n\t\t\t\t\t\t\n\t\t\t\t\t  }else{\n\t\t\t\t\t\t  FnChkAlreadyExistsInGroup(patientId);\n\t\t\t\t\t  }\n\t\n\t\t\t      }\n\t\t     },\n\t\t     error: function(jqXHR, textStatus, errorThrown) {\n\t\t         alert(\"incoming Text \" + jqXHR.responseText);\n\t\t     }\n\t\t });\n\t}\n\t\n}\n\nfunction changeCase(Obj){\n    Obj.value=Obj.value.toUpperCase();\n\t\n}\n\n\n</script>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

    Connection con=null;
	Statement stmt = null;
	ResultSet rs =null;
try{
	con 		= ConnectionManager.getConnection(request);

	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String pat_length="";
	stmt=con.createStatement();
	rs=stmt.executeQuery("select patient_id_length from mp_param where MODULE_ID='MP'");
	if (rs!=null&&rs.next())
       pat_length = rs.getString(1);


            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pat_length));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pat_length));
            _bw.write(_wl_block12Bytes, _wl_block12);
}catch(Exception e){
	e.printStackTrace();
}finally{
    if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
