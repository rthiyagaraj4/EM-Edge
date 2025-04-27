package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
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
        if (sci.isResourceStale("/eip/jsp/PractitionerComponent.jsp", 1709117844339L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eIP/js/IPPractitionerComponent.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script>\n\n// Added by Sridhar on 2 FEB 2004\n// This Function will check for empty values before calling up the common lookup func..\nfunction BeforeGetPractitioner(obj, target, getVal)\n{\n\tif(document.forms[0].practid_desc.value !=\"\")\n\t\tgetPractitionerLocal(obj, target, getVal);\n\telse\n\t\tdocument.forms[0].practid.value =\"\"\n}\n\n\n// By Annadurai 2/6/2004 ., to use Common Lookup. starts.,\nfunction getPractitionerLocal(obj, target, getVal)\n{\n\tvar practName_FName=\"\";\n\tvar practName_FValue=\"\";\n\tvar practId_FName=\"\";\n\tvar call_function = getVal;\t\n\n\tpractName_FName=target.name;\n\tpractName_FValue=target.value;\n\tpractId_FName=document.forms[0].practid.name;\n\tvar locale =document.forms[0].locale.value;\n\tvar facility_id\t\t= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\n\tif (call_function == \'AdmitPatient\')\n\t{\n\t\tgetPractitioner(obj, target, facility_id, \"\",\"\",\"Q4\");\n\t\t/*var sql = \"SELECT a.Practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1) practitioner_name,am_get_desc.AM_PRACT_TYPE(d.PRACT_TYPE,\'\"+locale+\"\',2) practitioner_type,am_get_desc.AM_SPECIALITY(e.SPECIALITY_CODE,\'\"+locale+\"\',2 ) primary_specialty, am_get_desc.AM_POSITION(f.position_code,\'\"+locale+\"\',1) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e, am_position f WHERE a.operating_facility_id=\"+facility_id+\" AND a.pract_type IN (\'MD\',\'SG\',\'PS\',\'DN\') AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.position_code=f.position_code(+) and b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL)\";\n\n\t\tvar sql2 =\"SELECT a.Practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1) practitioner_name,am_get_desc.AM_PRACT_TYPE(d.PRACT_TYPE,\'\"+locale+\"\',2) practitioner_type,am_get_desc.AM_SPECIALITY(e.SPECIALITY_CODE,\'\"+locale+\"\',2 ) primary_specialty, am_get_desc.AM_POSITION(f.position_code,\'\"+locale+\"\',1) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e, am_position f WHERE a.operating_facility_id=\"+facility_id+\" AND a.pract_type IN (\'MD\',\'SG\',\'PS\',\'DN\') AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type and b.position_code=f.position_code(+) AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL)\";\n\t\t*/\n\t}\n\telse\n\t{\n\n\t\t\tgetPractitioner(obj, target, facility_id, \"\",\"\",\"Q2\");\n\t\n\t\t\t/*var sql = \"SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id, \'\"+locale+\"\', 1) practitioner_name,  am_get_desc.am_pract_type(b.PRACT_TYPE,  \'\"+locale+\"\',  1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE, \'\"+locale+\"\',  2) primary_specialty,  DECODE(b.gender,  \'M\',  \'Male\',  \'F\',  \'Female\',  \'U\',  \'Unknown\') gender,  b.position_code job_title FROM am_pract_for_facility a,am_practitioner b WHERE   a.practitioner_id = b.practitioner_id AND   b.pract_type LIKE (?) AND  b.primary_speciality_code LIKE UPPER(?) AND  (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR   UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND   b.gender LIKE (?) AND  (b.position_code LIKE (?) OR b.position_code IS NULL) AND  a.facility_id= \'\"+facility_id+\"\'\" ;\n\n\t\t\tvar sql2 = \"SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id, \'\"+locale+\"\', 1) practitioner_name,  am_get_desc.am_pract_type(b.PRACT_TYPE,  \'\"+locale+\"\',  1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE, \'\"+locale+\"\',  2) primary_specialty,  DECODE(b.gender,  \'M\',  \'Male\',  \'F\',  \'Female\',  \'U\',  \'Unknown\') gender,  b.position_code job_title FROM am_pract_for_facility a,am_practitioner b WHERE   a.practitioner_id = b.practitioner_id AND   b.pract_type LIKE (?) AND  b.primary_speciality_code LIKE UPPER(?) AND  (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  and  UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,\'\"+locale+\"\',1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND   b.gender LIKE (?) AND  (b.position_code LIKE (?) OR b.position_code IS NULL) AND  a.facility_id= \'\"+facility_id+\"\'\" */\n\n\n\t\t\n\t}\n\t/*var xmlDoc\t= new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\tvar xmlHttp\t= new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;\n\txmlStr\t=\"<root><SEARCH \" ;\n\txmlStr += \" practName_FName=\\\"\" +practName_FName + \"\\\"\";\n\txmlStr += \" practName_FValue=\\\"\" + encodeURIComponent(practName_FValue) + \"\\\"\";\n\txmlStr += \" sql=\\\"\" +escape(sql)+ \"\\\"\";\n\txmlStr += \" sqlSec=\\\"\" +escape(sql2)+ \"\\\"\";\n\txmlStr += \" practitioner_type=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" specialty_code=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" job_title=\\\"\" + \"\" + \"\\\"\";\n\txmlStr += \" gender=\\\"\" + \"\" + \"\\\"\";\n\txmlStr +=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\",\"../../eAM/jsp/callGeneralPractitionerSearch.jsp\", false ) ;\n\txmlHttp.send(xmlDoc);\n\tresponseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText);\n//\talert(responseText);\n\teval(responseText);\t*/\n\n} // End of getPractitioner.\n\n// To be called by the GeneralPractitionerSearch to set Practitioner.\nfunction PractLookupRetVal(retVal,objName)\n{\n\tvar arr;\n\tif (retVal != null)\n\t{\n\t\tarr=retVal.split(\"~\");\n\t\tdocument.forms[0].practid.value=arr[0];\n\t\tdocument.forms[0].practid_desc.value=arr[1];\t\t\t\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].practid.value=\"\";\n\t\tdocument.forms[0].practid_desc.value=\"\";\t\t\t\n\t}\n\n} // End of PractLookupRetVal().\n\n</script>\n\t<input type=\'text\' name=\'practid_desc\' id=\'practid_desc\' size=\"25\" maxlength=\"30\" onblur=\"BeforeGetPractitioner(document.forms[0].practid, practid_desc, \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"\" size=\"15\" maxlength=\"15\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerLocal(document.forms[0].practid, practid_desc, \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\">\n\n\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	
	String facilityID			= (String)session.getValue("facility_id");	
	String called_function_id	= request.getParameter("called_function_id");
	called_function_id			= (called_function_id == null)?"":called_function_id;
	String practitioner_desc	= request.getParameter("practitioner_desc");
	practitioner_desc			= (practitioner_desc == null)?"":practitioner_desc;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(called_function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(practitioner_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(called_function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
