package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patientgrpdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/PatientGrpDetails.jsp", 1731644430589L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script><!-- Supporting Js File For Fixed Header with scroll.... -->\n\t<script language=\'javascript\' src=\'../../eOA/js/PatientGroup1.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style type=\"text/css\">\n    table.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}\n    table.mt th {border-width: 1px;padding: 1px;;white-space: normal; text-align:left;}\n    table.mt td {border-width: 1px;padding: 1px;text-align: left;vertical-align:middle;white-space:normal;word-wrap: break-word; word-break: break-all;}\n</style>\n\n\t</head>\n\t<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey()\'>\n\t<form name=\"GroupSearchCriteria\" id=\"GroupSearchCriteria\" method=\"post\" action=\"../../servlet/eOA.GenerateGroupPatientsServlet\">\n\t<table cellpadding=\'1\' cellspacing=\'1\' width=\'100%\' border=\'0\'>\n\t\t<tr>\n\t\t<td class = \'label\'  width = \'10%\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td width=\'10%\' class=\'fields\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"group_id\"  id=\"group_id\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"min_patient\" id=\"min_patient\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"max_patient\"  id=\"max_patient\" >\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"Existing_Group_Members\" id=\"Existing_Group_Members\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"group_location_id\" id=\"group_location_id\" >\n\t\t\t\t\t\t<input type=\"hidden\" name=\"HidSelectedPatIds\" id=\"HidSelectedPatIds\">\n\t\t\t\t\t\t<input type=\"text\" name=\"group_name\" id=\"group_name\" onblur=\'if(this.value!=\"\"){callgroupname(this,document.forms[0].group_name,\"delete\")}else{clearValues();}\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> <input type=\"button\" name=\"group_name_lookup\" id=\"group_name_lookup\" value=\"?\" class=\"button\" onclick=\"callgroupname(this,document.forms[0].group_name,\'insert\')\"><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"delete\">\n\t\t\t\t\t</td>\n\t\t</tr>\n\t\t<tr></tr>\n\t</table>\n\t<div id=\"DivLocationResult\" style=\"margin-top:20px;margin-left:10px;\"></div>\n\t<br/>\n\t<div id=\"DivPatientDetails\" style=\"margin-top:20px;margin-left:10px;\"></div>\n\t\n\t\n\t\n\t\n\n<script>\n\nfunction clearAll(){\n\tparent.frames[2].location.href =\"../../eCommon/html/blank.html\";\n}\n\n\n\n/*function FnShowExistingPatientsDetails(GroupId){\n\t $.ajax({  \n\t     url:\'../../eOA/jsp/GetGroupLocation.jsp\',  \n\t     type:\'post\',  \n\t     data:{\'GroupId\':GroupId,\'action\':\'get_existing_grp_patient_details\'},\n\t     dataType: \'json\',\n\t     success: function(data) {\n\t      \tvar recordlist=eval(data.recordslist);\n\t      \tvar DisplayData\t\t= \"\";\n\t      \tvar patient_id\t\t= \"\";\n\t      \tvar patient_data\t= \"\";\n\t      \tvar tdclass\t\t\t= \"\";\t\t\n\t    \tif(data.count > 0){\n\t    \t\tDisplayData\t\t= \"<table border=\'1\' width=\'98%\' style=\'border-spacing:0px ;border-collapse: collapse;\' id=\'dataTable\' class=\'mt\'><tr><th width=\'80%\'><b>\"+getLabel(\"Common.PatientDetails.label\",\"Common\")+\"</b></th><th  width=\'20%\'><b>\"+getLabel(\"Common.delete.label\",\"Common\")+\" \"+getLabel(\"Common.all.label\",\"Common\")+\"</b><input type=\'checkbox\' name=\'chkallexistingpatients\' id=\'chkallexistingpatients\' > </th></tr>\";\n\t\t\t    $.each(recordlist,function(index,value){\n\t\t\t    \tpatient_id\t\t= value.patient_id;\n\t\t\t    \tpatient_data\t= value.patient_line;\n\t\t\t    \ttdclass\t\t\t= value.tdclass;\n\t\t\t    \tDisplayData\t\t+= \"<tr>\";\n\t\t\t    \tDisplayData\t\t+= \"<td class=\"+tdclass+\" valign=\'top\'>\";\n\t\t\t      \tDisplayData\t\t+= \"<a href=\'javascript:viewPatientDetails(\\\"\"+patient_id+\"\\\")\'>+</a><font size=1>\"+patient_data+\"</font></td>\";\n\t\t\t\n\t\t\t    \tDisplayData\t\t+= \"<td class=\"+tdclass+\" > <input type=checkbox name=\'existingpatid\' id=\'existingpatid\' value=\'\"+patient_id+\"\' > </td></tr>\";\n\t            });\n\t\t\t    DisplayData\t\t\t+=\"</table>\";\n\t    \t}\n\t    \t$(\"#DivPatientDetails\").html(DisplayData);\n\t    \tif($(\"#dataTable\").length > 0){\n\t    \t\tfxheaderInit(\'dataTable\',350);\t\n\t    \t}\n\t     },\n\t     error: function(jqXHR, textStatus, errorThrown) {\n\t         alert(\"incoming Text \" + jqXHR.responseText);\n\t     }\n\t });\n\n}\n*/\n/*//$(\"input[name=\'chkallexistingpatients\']\").live(\'click\',function() \n\t$(document).on(\'click\', \"input[name=\'chkallnewpatients\']\", function(){\n/*\tvar checked = $(this).attr(\'checked\');\n\tif(checked == \'checked\') {\n\t\t$(\"input[name=\'existingpatid\']\").attr(\"checked\", true);\n\t} else {\n\t\t$(\"input[name=\'existingpatid\']\").attr(\"checked\", false);\n\t}\n});\n\n\n//$(\"input[name=\'existingpatid\']\").live(\'click\',function() \n  $(document).on(\'click\', \"input[name=\'existingpatid\']\", function(){\n\tif($(\"input[name=\'existingpatid\']\").length == $(\"input[name=\'existingpatid\']\").filter(\':checked\').length) {\n\t\t$(\"input[name=\'chkallexistingpatients\']\").attr(\"checked\", true);\n\t} else {\n\t\t$(\"input[name=\'chkallexistingpatients\']\").attr(\"checked\", false);\n\t}\n});\n*/\nfunction FnShowExistingPatientsDetails(GroupId){\n\t$.ajax({  \n\t     url: \'../../eOA/jsp/GetGroupLocation.jsp\',  \n\t     type: \'post\',  \n\t     data: {\'GroupId\': GroupId, \'action\': \'get_existing_grp_patient_details\'},\n\t     dataType: \'json\',\n\t     success: function(data) {\n\t      \tvar recordlist = eval(data.recordslist);\n\t      \tvar DisplayData = \"\";\n\t      \tvar patient_id = \"\";\n\t      \tvar patient_data = \"\";\n\t      \tvar tdclass = \"\";\t\t\n\t    \tif (data.count > 0) {\n\t    \t\tDisplayData = \"<table border=\'1\' width=\'98%\' style=\'border-spacing:0px ;border-collapse: collapse;\' id=\'dataTable\' class=\'mt\'><tr><th width=\'80%\'><b>\"+getLabel(\"Common.PatientDetails.label\", \"Common\")+\"</b></th><th  width=\'20%\'><b>\"+getLabel(\"Common.delete.label\", \"Common\")+\" \"+getLabel(\"Common.all.label\", \"Common\")+\"</b><input type=\'checkbox\' name=\'chkallexistingpatients\' id=\'chkallexistingpatients\' > </th></tr>\";\n\t\t\t    $.each(recordlist, function(index, value) {\n\t\t\t    \tpatient_id = value.patient_id;\n\t\t\t    \tpatient_data = value.patient_line;\n\t\t\t    \ttdclass = value.tdclass;\n\t\t\t    \tDisplayData += \"<tr>\";\n\t\t\t    \tDisplayData += \"<td class=\"+tdclass+\" valign=\'top\'>\";\n\t\t\t      \tDisplayData += \"<a href=\'javascript:viewPatientDetails(\\\"\"+patient_id+\"\\\")\'>+</a><font size=1>\"+patient_data+\"</font></td>\";\n\t\t\t    \tDisplayData += \"<td class=\"+tdclass+\" > <input type=checkbox name=\'existingpatid\' id=\'existingpatid\' value=\'\"+patient_id+\"\' > </td></tr>\";\n\t            });\n\t\t\t    DisplayData += \"</table>\";\n\t    \t}\n\t    \t$(\"#DivPatientDetails\").html(DisplayData);\n\t    \tif ($(\"#dataTable\").length > 0) {\n\t    \t\tfxheaderInit(\'dataTable\', 350);\t\n\t    \t}\n\t     },\n\t     error: function(jqXHR, textStatus, errorThrown) {\n\t         alert(\"incoming Text \" + jqXHR.responseText);\n\t     }\n\t});\n}\n\n// Select/Deselect All checkboxes when the \"Select All\" checkbox is clicked\n$(document).on(\'click\', \"input[name=\'chkallexistingpatients\']\", function(){\n\tvar isChecked = $(this).prop(\'checked\');  // Check the state of the \"Select All\" checkbox\n\t$(\"input[name=\'existingpatid\']\").prop(\'checked\', isChecked); // Set all checkboxes based on \"Select All\"\n});\n\n// Update the \"Select All\" checkbox based on individual checkbox states\n$(document).on(\'click\', \"input[name=\'existingpatid\']\", function(){\n\tvar allChecked = $(\"input[name=\'existingpatid\']\").length === $(\"input[name=\'existingpatid\']:checked\").length;\n\t$(\"input[name=\'chkallexistingpatients\']\").prop(\'checked\', allChecked); // If all are checked, mark \"Select All\" as checked\n});\n\nfunction FnDelete(){\n\tvar VarPatIds=FnGetCheckdValues();\n\tvar IsError\t\t\t= 0;\n\tif(VarPatIds==\"\"){\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\", \"common\"));\n\t\tparent.parent.commontoolbarFrame.document.location.reload();\n\t\tIsError\t=1;\n\t}\n\tif(IsError==0){\n\t\t$(\"#HidSelectedPatIds\").val(VarPatIds);\n\t\t$(\"#GroupSearchCriteria\").submit();\n\t}\n}\n\nfunction FnGetCheckdValues(){\n\tvar VarPatIds\t= \"\";\n\t$(\"input[name=\'existingpatid\']\").filter(\':checked\').each(function() {\n\t\tVarPatIds+=$(this).val()+\"|\";\n\t});\n\tif(VarPatIds!=\'\'){\n\t\tVarPatIds\t= VarPatIds.slice(0,-1);\n\t}\n\treturn VarPatIds;\n}\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\tcallGroupLocation(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\nfunction callGroupLocation(GroupId){  \n\t $.ajax({  \n     url:\'../../eOA/jsp/GetGroupLocation.jsp\',  \n     type:\'post\',  \n     data:{\'GroupId\':GroupId},\n     dataType: \'json\',\n     success: function(data) {\n\t     \t if(data.isJsonResults==1){\n\t     \t\tvar ResultString\t= \"<table border=\'1\' width=\'100%\' style=\'border-spacing:0px ;border-collapse: collapse;\' ><tr><th colspan=\'2\'><b>\"+getLabel(\"Common.GroupDetails.label\",\"Common\")+\"</b></th></tr>\";\n\t     \t\tResultString\t\t+= \"<tr><td class=\'AR_QRYEVEN\' width=\'50%\'>\"+getLabel(\'Common.Location.label\',\'Common\')+\"</td><td class=\'AR_QRYEVEN\' width=\'50%\'>\"+data.LOCN_NAME+\"</td></tr>\";\n\t     \t\tResultString\t\t+= \"<tr><td class=\'AR_QRYODD\' width=\'50%\'>\"+getLabel(\'Common.MIN.label\',\'Common\')+\" \"+getLabel(\'Common.Patients.label\',\'Common\')+\"</td><td class=\'AR_QRYODD\' width=\'50%\'>\"+data.MIN_PATIENTS+\"</td></tr>\";\n\t     \t\tResultString\t\t+= \"<tr><td class=\'AR_QRYEVEN\' width=\'50%\'>\"+getLabel(\'Common.Max.label\',\'Common\')+\" \"+getLabel(\'Common.Patients.label\',\'Common\')+\"</td><td class=\'AR_QRYEVEN\' width=\'50%\'>\"+data.MAX_PATIENTS+\"</td></tr>\";\n\t     \t\tif(data.TotMemberInGroup > 0){\n\t     \t\t\tResultString+=\"<tr><td class=\'AR_QRYODD\' width=\'50%\'>\"+getLabel(\'eOA.TotalPatientsLinkedInGroup.label\',\'OA\')+\"</td><td class=\'AR_QRYODD\' width=\'50%\'>\"+data.TotMemberInGroup+\"</td></tr>\";\n\t     \t\t}\n\t     \t\tResultString\t\t+=\"</table>\";\n\t     \t\t\n\t     \t\t$(\"#min_patient\").val(data.MIN_PATIENTS);\n\t     \t\t$(\"#max_patient\").val(data.MAX_PATIENTS);\n\t     \t\t$(\"#Existing_Group_Members\").val(data.TotMemberInGroup);\n\t     \t\t$(\"#group_location_id\").val(data.LOCN_CODE);\n\t     \t\t$(\"#DivLocationResult\").html(ResultString);\n\t     \t\t$(\"#PatientId\",parent.frames[1].GroupSearchCreate).attr(\"disabled\",false);\n\t     \t\t$(\"#commonLookup\",parent.frames[1].GroupSearchCreate).attr(\"disabled\",false);\n\t     \t\t$(\"#AddPatientQueue\",parent.frames[1].GroupSearchCreate).attr(\"disabled\",false);\n\t     \t\tif(data.TotMemberInGroup > 0){\n\t     \t\t\tFnShowExistingPatientsDetails(GroupId);\n\t     \t\t}else{\n\t     \t\t\t$(\"#DivPatientDetails\").html(\"\");\n\t     \t\t}\n\t     \t }else{\n\t     \t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t     \t\tclearValues();\n\t     \t }\n\t     \t$(\"#PatientId\",parent.frames[1].GroupSearchCreate).val(\"\");\n\t    \t$(\"#DivPatListQueue\",parent.frames[1].GroupSearchCreate).html(\"\");\n\t       \tparent.frames[1].GlbExistingIds.length=0;\n     } ,\n     error: function(jqXHR, textStatus, errorThrown) {\n         alert(\"incoming Text \" + jqXHR.responseText);\n     }\n });  \n}\n\n</script>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</form> \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

try{
	Connection con 				= null;
	PreparedStatement pstmt 	= null;
	ResultSet rs				=null;
	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String group_name		= request.getParameter("group_name")==null?"":request.getParameter("group_name");
	String group_id			= request.getParameter("group_id")==null?"":request.getParameter("group_id");


            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(group_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
if(!group_id.equals("") && !group_name.equals("")){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
}catch(Exception e){
	e.printStackTrace();
}
            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupName.label", java.lang.String .class,"key"));
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
