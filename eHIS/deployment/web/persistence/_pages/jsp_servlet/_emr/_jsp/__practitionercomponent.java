package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;

public final class __practitionercomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/PractitionerComponent.jsp", 1718273487698L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMR/js/MRPractitionerComponent.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\n// This Function will check for empty values before calling up the common lookup func..\n\nfunction BeforeGetPractitioner(obj, target, getVal)\n{\n\tif(document.forms[0].practid_desc.value !=\"\")\n\t\tgetPractitionerLocal(obj, target, getVal);\n\telse\n\t\tdocument.forms[0].practid.value =\"\"\n}\n\nasync function getPractitionerLocal(obj, target, getVal)\n{\n\tvar usertype=document.forms[0].user_type.value;\n\tvar user=document.forms[0].user.value;\n\tif(usertype ==\'I\' && user==\'U\')\n\t{\n\t\t await getAuthoriser(obj,target);\n\t}\n\telse\n\t{\n\t\tvar practName_FName=\"\";\n\t\tvar practName_FValue=\"\";\n\t\tvar practId_FName=\"\";\n\t\tvar call_function = getVal;\t\n\n\t\tpractName_FName=target.name;\n\t\tpractName_FValue=target.value;\n\t\tpractId_FName=document.forms[0].practid.name;\n\n\t\tvar facility_id\t\t= \"\'\"+\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'+\"\'\";\n\t\tif(usertype==\'E\')\n\t\t{\n\t\t\t\n\t\t\tgetPractitioner(obj, target,facility_id,\"Q3\");\n\t\t\t/*\n\t\t\tvar sql = \"SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,PRACT_TYPE practitioner_type,PRIMARY_SPECIALITY_CODE primary_specialty, DECODE(b.gender,\'M\',\'Male\',\'F\',\'Female\',\'U\',\'Unknown\') gender, DECODE(b.job_title,\'CC\',\'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr. Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\',\'Trainee\' ) job_title FROM am_ext_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)\";\n\n\t\t\tvar sql2 = \"SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,PRACT_TYPE practitioner_type,PRIMARY_SPECIALITY_CODE primary_specialty, DECODE(b.gender,\'M\',\'Male\',\'F\',\'Female\',\'U\',\'Unknown\') gender, DECODE(b.job_title,\'CC\',\'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr. Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\',\'Trainee\' ) job_title FROM am_ext_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)\";\n\t\t\t*/\n\t\t}\n\t\telse\n\t\t{\n\t\t\tgetPractitioner(obj, target,facility_id,\"Q4\");\n\t\t\t/*\n\t\t\tvar sql = \"SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,PRACT_TYPE practitioner_type,PRIMARY_SPECIALITY_CODE primary_specialty, DECODE(b.gender,\'M\',\'Male\',\'F\',\'Female\',\'U\',\'Unknown\') gender, DECODE(b.job_title,\'CC\',\'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr. Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\',\'Trainee\' ) job_title FROM am_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)\";\n\n\t\t\tvar sql2 = \"SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,PRACT_TYPE practitioner_type,PRIMARY_SPECIALITY_CODE primary_specialty, DECODE(b.gender,\'M\',\'Male\',\'F\',\'Female\',\'U\',\'Unknown\') gender, DECODE(b.job_title,\'CC\',\'Chief Consultant\', \'CO\', \'Consultant\', \'RG\', \'Registrar\', \'RS\', \'Resident\', \'ST\', \'Specialist\', \'SC\', \'Sr. Consultant\', \'SR\', \'Sr. Resident\', \'SP\', \'Sr. Specialist\', \'TR\',\'Trainee\' ) job_title FROM am_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)\";\n\t\t\t*/\n\t\t}\n\t\t\n\t\t//\talert(sql);\n\t\t\n\t\t/*\n\t\tvar xmlDoc=\"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\txmlStr += \" practName_FName=\\\"\" +practName_FName + \"\\\"\";\n\t\txmlStr += \" practName_FValue=\\\"\" + encodeURIComponent(practName_FValue) + \"\\\"\";\n\t//\txmlStr += \" practId_FName=\\\"\" + practId_FName + \"\\\"\";\n\t\txmlStr += \" sql=\\\"\" +escape(sql)+ \"\\\"\";\n\t\txmlStr += \" sqlSec=\\\"\" +escape(sql2)+ \"\\\"\";\n\t\txmlStr += \" practitioner_type=\\\"\" + \"\" + \"\\\"\";\n\t\txmlStr += \" specialty_code=\\\"\" + \"\" + \"\\\"\";\n\t\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\t\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\t\txmlStr +=\" /></root>\" ;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t//\tdocument.forms[0].practid_desc.value=sql+\"****\"+sql2;\n\t\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=xmlHttp.responseText;\n\t\tresponseText = trimString(responseText);\n\t\teval(responseText);\t\n\t\t*/\n\n\t}\n} // End of getPractitioner.\n\n// To be called by the GeneralPractitionerSearch to set Practitioner.\nfunction PractLookupRetVal(retVal,objName)\n{\n\tvar arr;\n\tif (retVal != null)\n\t{\n\t\tarr=retVal.split(\"~\");\n\t\tdocument.forms[0].practid.value=arr[0];\n\t\tdocument.forms[0].practid_desc.value=arr[1];\t\t\t\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].practid.value=\"\";\n\t\tdocument.forms[0].practid_desc.value=\"\";\t\t\t\n\t}\n\n}\nasync function getAuthoriser(target_id,target)\n{\n\tvar facility_id =\"\'\"+\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'+\"\'\";\n\tvar title=\"\";\n\t\n\tvar argumentArray=new Array(8);\n\t\n\ttitle=getLabel(\"Common.user.label\",\"Common\");\n \n\targumentArray[0]=\"select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER where EFF_STATUS like ? and APPL_USER_ID like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) \";\n\t\n\targumentArray[1]=new Array(\"EFF_STATUS\");\n\targumentArray[2]=new Array(\"E\");\n\targumentArray[3]=new Array(STRING,STRING);\n\targumentArray[4]=\"2,3\";\n\targumentArray[5]=target.value;\n\targumentArray[6]=CODE_DESC_LINK;\n\targumentArray[7]=CODE_DESC;\n\n\t\t\t\n\tvar retVal=await CommonLookup(title,argumentArray);\n\tif(retVal != null && retVal != \"\" )\n\t{\n\t\tvar ret1=unescape(retVal);\n\t\tarr=ret1.split(\",\");\n\t\tdocument.forms[0].practid.value\t\t=\tarr[0];\t\t\n\t\tdocument.forms[0].practid_desc.value\t=\tarr[1];\n\t\t//document.forms[0].practid_desc.focus();\n\t\t//document.forms[0].practid.value\t\t= document.forms[0].practid_desc.value;\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].practid.value\t\t= \"\";\t\t\n\t\tdocument.forms[0].practid_desc.value\t= \"\";\n\t}\n}\n\n</script>\n\t<input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' size=\"25\" maxlength=\"30\" onblur=\"BeforeGetPractitioner(document.forms[0].practid, practid_desc, \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\');\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"\" size=\"15\" maxlength=\"15\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(document.forms[0].practid, practid_desc, \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\');\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
	
	 request.setCharacterEncoding("UTF-8");
	//Connection con = null;
	//Statement stmt=null;
	//ResultSet rs =null;
	String facilityID=(String)session.getValue("facility_id");	
	String called_function_id	= request.getParameter("called_function_id");
	String practitioner_desc		= request.getParameter("practitioner_desc");
	called_function_id	= (called_function_id == null)?"":called_function_id;
	practitioner_desc		= (practitioner_desc == null)?"":practitioner_desc;

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(called_function_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(practitioner_desc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(called_function_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
