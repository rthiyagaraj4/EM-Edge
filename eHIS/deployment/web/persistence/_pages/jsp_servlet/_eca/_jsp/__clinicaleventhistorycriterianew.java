package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __clinicaleventhistorycriterianew extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventHistoryCriteriaNew.jsp", 1738833027495L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eCA/js/DateCheck.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/ClinicalEventHistoryNew.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/MedicationOrders.js\'></script>\n\t<script language=\'javascript\'>\n\t\t\n\tfunction isNumeric(obj) {\n\tvar numb = \'0123456789\';\n\tvar inputparam = obj.value;\n\tvar blnVal = isValid(inputparam,numb);\n\tif(blnVal == false)\n\t{\n\tobj.value = \'\';\n\talert(getMessage(\"CHARACTER_NOT_ALLOWED\",\'CA\')); \n\tobj.focus();\n\treturn blnVal;\n\t}\n\telse\n\t{\n\treturn blnVal;\n\t}\n\t}\n\n\tfunction isValid(parm,val) {\n\tif (parm == \"\") return true;\n\tfor (i=0; i<parm.length; i++) {\n\tif (val.indexOf(parm.charAt(i),0) == -1) return false;\n\t}\n\treturn true;\n\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<FORM name=\"criteria_form\" id=\"criteria_form\">\n<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_personalView";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<input type=\'hidden\'  name =\'default_eventClass";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<input type=\'hidden\'  name =\'default_eventGroup";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<input type=\'hidden\'  name =\'default_eventGroupDesc";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<input type=\'hidden\'  name =\'default_eventItem";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<input type=\'hidden\'  name =\'default_eventItemDesc";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_patientClass";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_viewBy";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_abnormal";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_date";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'def_facility";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_normalcyInd";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_encounterid";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_fromDate";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_toDate";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<input type=\'hidden\'  name =\'default_personalView\' value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<input type=\'hidden\'  name =\'default_eventClass\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<input type=\'hidden\'  name =\'default_eventGroup\' value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<input type=\'hidden\'  name =\'default_eventGroupDesc\' value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<input type=\'hidden\'  name =\'default_eventItem\' value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<input type=\'hidden\'  name =\'default_eventItemDesc\' value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<input type=\'hidden\'  name =\'default_patientClass\' value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<input type=\'hidden\'  name =\'default_viewBy\' value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<input type=\'hidden\'  name =\'default_abnormal\' value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<input type=\'hidden\'  name =\'default_date\' value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<input type=\'hidden\'  name =\'def_facility\' value = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<input type=\'hidden\'  name =\'default_normalcyInd\' value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<input type=\'hidden\'  name =\'default_encounterid\' value = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<input type=\'hidden\'  name =\'default_fromDate\' value = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t<input type=\'hidden\'  name =\'default_toDate\' value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n<!--IN069654 ends -->\n<br>\n\t<TABLE  cellpadding=3 cellspacing=0 width=\"90%\" align=left border=0>\n\t\t<TR>\n\t\t\t<TD class=\"label\" width=\'10%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&nbsp;";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t</TD>\n\t\t\t<TD class=\"fields\" >\n\t\t\t\t<input type=\"text\" maxlength=16 size=\"16\" value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' name=\"from_date\" id=\"from_date\" onBlur=\'chkDateTime(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\");\'> \n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'from_date\');\" /> \n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<input type=\"text\" maxlength=16 size=\"16\" value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' name=\"to_date\" id=\"to_date\" onBlur=\'chkDateTime(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\");\'> \n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'to_date\');\" />\n\t\t\t</TD>\n\t\t  <TD class=\"label\" width=\'10%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</TD>\n\t\t\t<TD class=\"fields\">\n\t\t\t\t<input type=\"text\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" maxlength=12 size=13 onKeyPress = \'return allowValidNumber(this,event,12,0)\' onblur = \'isNumeric(this)\'> \n\t\t\t</TD>\n\t\t\t<TD class=\"label\">Facility</TD>\n\t\t\t<TD width=\'10%\' class=\"fields\">\n\t\t\t\t<SELECT name=\"fac_id_sel\" id=\"fac_id_sel\">\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\n\t\t\t\t</SELECT>\n\t\t\t</TD>\n\t\t\t<TD class=\"label\" align=\"left\">\n\t\t\t\t<input type=\"button\" class=button name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'  onClick=\"populateValues(\'\',\'ONCLICK\')\">\n\t\t\t</TD>\n\t\t</TR>\n\t</TABLE>\n<input type=\'hidden\'  name =\'patient_id\' value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\'hidden\'  name =\'enc_id\' value = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<input type=\'hidden\'  name =\'ql_ref\' value = \"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"><!--IN069654-->\n<input type=\'hidden\'  name=\'relationship_id\' id=\'relationship_id\' value =\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<input type=\'hidden\'  name=\'grphistory_type\' id=\'grphistory_type\' value =\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><!--IN071596-->\n<input type=\'hidden\'  name =\'queryString\' value = \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<input type=\'hidden\' value=\"\" name=\"histSelectedCriteria\" id=\"histSelectedCriteria\" /><!--IN073728 -->\n</FORM>\n<script>\npopulateValues(\'\',\'ONLOAD\');\n</script>\n</BODY>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
28/08/2019	IN071263	sivabagyam M 	07/04/2019		Ramesh G		CA-MO-CRF-20101.6/03-Select-drop down
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7
05/08/2020  IN072762    chandrashekar                                   MO-CRF-20101.11
04/11/2020		IN073728	Nijithas		04/11/2020		Ramesh 		MO-CRF-20101.16
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	//IN069654  starts
	PreparedStatement stmtsql = null;
	ResultSet rs = null;
	//IN069654 ends
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	PreparedStatement pstmt1 = null;//IN071596
	PreparedStatement pstmt7= null;//IN072762
	PreparedStatement pstmt8= null;//IN072762
	ResultSet rset1 = null;//IN071596
	ResultSet rs7 = null;//IN072762
	ResultSet rs8 = null;//IN072762
	String facilityId 	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String resp_id	= (String)session.getValue("responsibility_id");//IN069654
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	//IN069654 starts
	String encounterId = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patientclass = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
	String grphistory_type			= "";//IN071596
	String fromDate="",toDate="";
	String normalcy_ind="",abnormal1="",date_Ordr="",fid="",fname="";
	String facility_Id_param="";
	String view_by = "", patient_class1 = "";
	String event_class = "",	event_group = "", event_item = "", abnormal = "";
	String date_checked = "", event_checked = "checked";
	String all_check = "selected";
	String self_checked = "";
	String speciality_checked = "";
	String personal_view = "";
	String event_group_desc = "";
	String event_item_desc = "";
	String date_ind = "", date_val = "", date_unit = "", date_ref = "";
	StringTokenizer strToken = null;
	//IN069654 ends
try{

	con = ConnectionManager.getConnection(request);
	String sql_facility="",sql_hist="";//IN071596
	sql_facility="select facility_id,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"', 1) facility_name,DECODE(FACILITY_ID,?,'Y','N') facility_YN  from sm_facility_for_user where appl_user_id=?";
	sql_hist="SELECT HIST_TYPE FROM sm_quick_link_list_vw WHERE QUICK_LINK_REF=?";//IN071596
//IN069654 starts
	String sqlConfResult = "select GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,?) viewConfRes from dual";
	String viewConfRes = "";
	String sqlFilter = "";
	String column_id = "",	column_desc = "",	value_type = "",	actual_value = "";
	String date_time_rel_id = "",	date_time_rel_val = "",	date_time_rel_unit = "",	relative_value = "";
	String final_value = "";
	String field_desc = "";
	HashMap map = new HashMap();
	String default_sql = "";
	boolean isfacilitySelct=false;//IN070032
	StringBuffer default_query = new StringBuffer();
	ArrayList<String> functionIds = new ArrayList<String>();//IN070032
	functionIds.add("FACILITY_SELCT_NCEH");//IN070032
	int Existance_Count = 0;
	String login_user	= (String)session.getValue("login_user");
	String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
	String bean_id					= "CAClinicalHistoryBean" ;
	String bean_name				= "eCA.CAClinicalHistoryBean";
	CAClinicalHistoryBean bean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);	
	bean.setSiteSpecific(functionIds,"CA");//IN070032
	isfacilitySelct = bean.isSiteSpecific("FACILITY_SELCT_NCEH");//IN070032
	//IN073728 Starts
	String hist_type_new =  "" ;
	ArrayList eventHistArr = new ArrayList() ;
	String bean_id_new					= "NewClinicalEventHistBean" ;
	String bean_name_new			= "eCA.NewClinicalEventHistBean";
	NewClinicalEventHistBean beanNew	= (NewClinicalEventHistBean)getBeanObject( bean_id_new, bean_name_new , request) ; 
	//IN073728 Ends
	try
	{
		stmtsql = con.prepareStatement(sqlConfResult);
		stmtsql.setString(1,resp_id);
		stmtsql.setString(2,reln_id);
		rs = stmtsql.executeQuery();

		while(rs.next())
		{
			viewConfRes = rs.getString("viewConfRes");
		}

		if(stmtsql != null) stmtsql.close();
		if(rs != null) rs.close();

		if(ql_ref.equals("") && !default_yn.equals("N"))
		{
			default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = 'FLOW_SHEET_NEW' AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";
			stmtsql = con.prepareStatement(default_sql);
		
			stmtsql.setString(1,login_user);
			stmtsql.setString(2,resp_id);
			stmtsql.setString(3,locale);
			rs = stmtsql.executeQuery();
			if(rs.next())
			{
				Existance_Count = rs.getInt("EXISTANCE_COUNT");
			}
			if(rs != null) rs.close();
			if(stmtsql != null) stmtsql.close();

			default_query.append("select A.QUICK_LINK_REF quick_link_ref from ");
			if(Existance_Count>0)
				default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
			else
				default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
			default_query.append(" and OPTION_ID = 'FLOW_SHEET_NEW' and LINK_TYPE = 'F' and DEFAULT_YN = 'Y'");
			default_query.append(" and added_facility_id = ? "); 
			
			stmtsql = con.prepareStatement(default_query.toString());
			if(Existance_Count>0)
				stmtsql.setString(1,login_user);
			else
				stmtsql.setString(1,resp_id);
			stmtsql.setString(2,facilityId); 
			rs = stmtsql.executeQuery();

			if(rs.next())
			{
				ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
			}

			if(stmtsql != null) stmtsql.close();
			if(rs != null) rs.close();
		}

		if(!ql_ref.equals(""))
		{
		//IN071596 starts
			pstmt1=con.prepareStatement(sql_hist);
			pstmt1.setString(1,ql_ref);
			rset1=pstmt1.executeQuery();
			while(rset1.next())
			{
				grphistory_type=rset1.getString("HIST_TYPE")==null?"":rset1.getString("HIST_TYPE");
			}
			if(pstmt1 != null) pstmt1.close();
			if(rset1 != null) rset1.close();
			//IN071596 ends
			//IN073728 Starts
			if("*ALL".equals(grphistory_type)){
				
				eventHistArr = beanNew.getHistRecType(con,locale);
				for(int i =0;i < eventHistArr.size(); i ++){
					String[] eventHistStr =(String[])eventHistArr.get(i);
					hist_type_new = eventHistStr[0];
				
					sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID and OPTION_ID = 'FLOW_SHEET_NEW') COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ? AND HIST_TYPE = ? " ;
					stmtsql = con.prepareStatement(sqlFilter);
					stmtsql.setString(1,ql_ref);
					stmtsql.setString(2,hist_type_new);
					rs = stmtsql.executeQuery();

					while(rs.next())
					{
						column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
						column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
						value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
						actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
						date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
						date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
						date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
						relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");
						if(value_type.equals("A"))
							final_value = actual_value;
						else
						{
							if(column_id.equals("PERIOD_FROM") || column_id.equals("PERIOD_TO"))
							{
								if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
								{
									final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
								}
								else
									final_value = "";
							}
							else
								final_value = relative_value;
						}

						map.put(column_id+hist_type_new,final_value);

						
					}
					System.out.println("map==>"+map);
					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();
				}
			}
			else{
				
				sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID and OPTION_ID = 'FLOW_SHEET_NEW') COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
				stmtsql = con.prepareStatement(sqlFilter);
				stmtsql.setString(1,ql_ref);
				rs = stmtsql.executeQuery();

				while(rs.next())
				{
					column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
					column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
					value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
					actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
					date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
					date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
					date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
					relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");
					if(value_type.equals("A"))
						final_value = actual_value;
					else
					{
						if(column_id.equals("PERIOD_FROM") || column_id.equals("PERIOD_TO"))
						{
							if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
							{
								final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
							}
							else
								final_value = "";
						}
						else
							final_value = relative_value;
					}

					//map.put(column_id+grphistory_type,final_value);
					map.put(column_id,final_value);


				}
				//out.println(map);
				if(stmtsql != null) stmtsql.close();
				if(rs != null) rs.close();
			}
			
			
			
/* 			
			sqlFilter = "select a.COLUMN_ID, (select COLUMN_DESC from SM_QUICK_LINK_CRITERIA where COLUMN_ID = a.COLUMN_ID and OPTION_ID = 'FLOW_SHEET_NEW') COLUMN_DESC , a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
			stmtsql = con.prepareStatement(sqlFilter);
			stmtsql.setString(1,ql_ref);
			rs = stmtsql.executeQuery();

			while(rs.next())
			{
				column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
				column_desc = rs.getString("COLUMN_DESC") == null ? "" : rs.getString("COLUMN_DESC");
				value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
				actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
				date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
				date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
				date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
				relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");
				if(value_type.equals("A"))
					final_value = actual_value;
				else
				{
					if(column_id.equals("PERIOD_FROM") || column_id.equals("PERIOD_TO"))
					{
						if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
						{
							final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
						}
						else
							final_value = "";
					}
					else
						final_value = relative_value;
				}

				map.put(column_id,final_value);


			}
			//out.println(map);
			if(stmtsql != null) stmtsql.close();
			if(rs != null) rs.close(); *///IN073728 Ends
		}
			
	}
	catch(Exception e)
	{
		//out.println("Exception in try of FlowSheetCriteria.jsp  -"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	//IN069654 ends
	if (fromDate.equals(""))
	{
		toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	    fromDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMYHM",locale,7,"d");

	}
	else
	{
        toDate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	    fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM","en",locale);
    }
    //IN069654 starts
	if(resp_id == null) resp_id ="";
	if(facilityId == null)facilityId="";	
	
	if(!ql_ref.equals(""))
	{//IN073728 Starts
		if("*ALL".equals(grphistory_type))
				{
				eventHistArr = beanNew.getHistRecType(con,locale);
					for(int m=0;m<eventHistArr.size();m++){
						normalcy_ind="";
						abnormal1="";
						date_Ordr="";
						event_class = "";
						event_group = ""; 
						event_item = "";
						abnormal = "";
						event_group_desc = "";
						event_item_desc = "";
						toDate		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					    fromDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMYHM",locale,7,"d");
						String[] eventHistStr =(String[])eventHistArr.get(m);
						personal_view = "";
						hist_type_new = eventHistStr[0];
						if(!"*ALL".equals(grphistory_type)){
							hist_type_new = "";
						}
					field_desc = (String) map.get("PERSONAL_VIEW"+hist_type_new) == null ? "S" : (String) map.get("PERSONAL_VIEW"+hist_type_new);
					if(!field_desc.equals(""))
					{
						personal_view = field_desc;
						if(personal_view.equals("A"))
						{
							all_check = "selected";
							self_checked = "";
							speciality_checked = "";
						}
						else if(personal_view.equals("S"))
						{
							all_check = "";
							self_checked = "selected";
							speciality_checked = "";
						}
						else if(personal_view.equals("M"))
						{
							all_check = "";
							self_checked = "";
							speciality_checked = "selected";
						}
					}
					else{
						personal_view = "S";
						all_check = "";
						self_checked = "selected";
						speciality_checked = "";
					}
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(personal_view));
            _bw.write(_wl_block11Bytes, _wl_block11);

						field_desc = (String) map.get("EVENT_CLASS"+hist_type_new) == null ? "" : (String) map.get("EVENT_CLASS"+hist_type_new);
						
						if(!field_desc.equals(""))
							event_class = field_desc;
						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_class));
            _bw.write(_wl_block14Bytes, _wl_block14);

							field_desc = (String) map.get("EVENT_GROUP"+hist_type_new) == null ? "" : (String) map.get("EVENT_GROUP"+hist_type_new);
							if(!field_desc.equals(""))
								event_group = field_desc;
							
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(event_group));
            _bw.write(_wl_block16Bytes, _wl_block16);

								sqlFilter = "select long_desc description from CR_CLN_EVT_GRP_LANG_VW where EVENT_GROUP = ? and hist_rec_type = 'LBIN' and LANGUAGE_ID = ?";
								stmtsql = con.prepareStatement(sqlFilter);
								stmtsql.setString(1,event_group);
								stmtsql.setString(2,locale);
								rs = stmtsql.executeQuery();
								if(rs.next())
									event_group_desc = rs.getString("description") == null ? "" : rs.getString("description");
								if(rs != null) rs.close();
								if(stmtsql != null) stmtsql.close();
						
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(event_group_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

						field_desc = (String) map.get("EVENT_ITEM"+hist_type_new) == null ? "" : (String) map.get("EVENT_ITEM"+hist_type_new);
						if(!field_desc.equals(""))
							event_item = field_desc;
						
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(event_item));
            _bw.write(_wl_block14Bytes, _wl_block14);

							if(!grphistory_type.equals("MEDN") && !event_item.equals(""))//Adding start for //IN072762
							{
								sqlFilter = "select long_desc description from CR_CLN_EVT_MST_LANG_VW where EVENT_CODE = ? and hist_rec_type = 'LBIN' and LANGUAGE_ID = ?";
								stmtsql = con.prepareStatement(sqlFilter);
								stmtsql.setString(1,event_item);
								stmtsql.setString(2,locale);
								rs = stmtsql.executeQuery();
								if(rs.next())
									event_item_desc = rs.getString("description") == null ? "" : rs.getString("description");
								if(rs != null) rs.close();
								if(stmtsql != null) stmtsql.close();
							}
							if(grphistory_type.equals("MEDN") && !event_item.equals(""))
							{
								pstmt8 = con.prepareStatement("select DRUG_DESC from ph_drug_lang_vw where  drug_code = ? and LANGUAGE_ID =?");
							    pstmt8.setString(1,event_item);
								pstmt8.setString(2,locale);
								rs8 = pstmt8.executeQuery();
									if(rs8.next())
									{
									  event_item_desc = rs8.getString("DRUG_DESC") == null ? "" : rs8.getString("DRUG_DESC");
														
								 	}
									if(rs8 != null) rs8.close();
									if(pstmt8 != null) pstmt8.close();
							}//Addding end for //IN072762
						
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(event_item_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

					field_desc = (String) map.get("PATIENT_CLASS"+hist_type_new) == null ? "" : (String) map.get("PATIENT_CLASS"+hist_type_new);
					if(!field_desc.equals(""))
					{
						patient_class1 = field_desc;
						if(patient_class1.equals("CURR_PAT_CLASS"))
							patient_class1 = patientclass;
					}
					else
						patient_class1="";	
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_class1));
            _bw.write(_wl_block11Bytes, _wl_block11);

					field_desc = (String) map.get("VIEW_BY"+hist_type_new) == null ? "" : (String) map.get("VIEW_BY"+hist_type_new);
					if(!field_desc.equals(""))
					{
						view_by = field_desc;
						if(view_by.equals("I"))
						{
							date_checked = "checked";
							event_checked = "";
						}
						else if(view_by.equals("P"))
						{
							date_checked = "";
							event_checked = "checked";
						}
					}
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block11Bytes, _wl_block11);

					field_desc = (String) map.get("ABNORMAL"+hist_type_new) == null ? "" : (String) map.get("ABNORMAL"+hist_type_new);
					abnormal1=field_desc;
					if(field_desc.equals("Y"))
						abnormal = "checked";
					else
						abnormal = "";
					
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(abnormal1));
            _bw.write(_wl_block11Bytes, _wl_block11);

					field_desc = (String) map.get("DISPLAY_ORDER"+hist_type_new) == null ? "" : (String) map.get("DISPLAY_ORDER"+hist_type_new);
					date_Ordr=field_desc;
					
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(date_Ordr));
            _bw.write(_wl_block11Bytes, _wl_block11);

					field_desc=(String) map.get("FACILITY_ID"+hist_type_new) == null ? "" : (String) map.get("FACILITY_ID"+hist_type_new);//
					if(field_desc.equals("LOGGED_IN_FCY"))
						facility_Id_param=facilityId;
					else if(!field_desc.equals(""))
						facility_Id_param=field_desc;
					else
						facility_Id_param="";
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_Id_param));
            _bw.write(_wl_block11Bytes, _wl_block11);

					field_desc = (String) map.get("NORMALCY_IND"+hist_type_new) == null ? "" : (String) map.get("NORMALCY_IND"+hist_type_new);
					normalcy_ind=field_desc;
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(normalcy_ind));
            _bw.write(_wl_block11Bytes, _wl_block11);

					field_desc = (String) map.get("ENCOUNTER_ID"+hist_type_new) == null ? "" : (String) map.get("ENCOUNTER_ID"+hist_type_new);
					if(!field_desc.equals(""))
					{
						if(field_desc.equals("ENCOUNTER_ID"))
							encounterid = encounterId;
					}
					else
						encounterid ="";//IN070032
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block11Bytes, _wl_block11);

					field_desc = (String) map.get("PERIOD_FROM"+hist_type_new) == null ? "" : (String) map.get("PERIOD_FROM"+hist_type_new);
					String currDate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
					int noOfdays = 0;
					if(!field_desc.equals(""))
					{
						strToken = new StringTokenizer(field_desc,"|");
						if(strToken.hasMoreTokens())
						{
							date_ind = strToken.nextToken();
							date_val = strToken.nextToken();
							date_unit = strToken.nextToken();
							date_ref = strToken.nextToken();
						}
						noOfdays = Integer.parseInt(date_val);
						if(date_ind.equals("B"))
							fromDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
						else if(date_ind.equals("A"))
							fromDate = com.ehis.util.DateUtils.plusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
					}
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block11Bytes, _wl_block11);

					field_desc = (String) map.get("PERIOD_TO"+hist_type_new) == null ? "" : (String) map.get("PERIOD_TO"+hist_type_new);
					if(!field_desc.equals(""))
					{
						strToken = new StringTokenizer(field_desc,"|");
						if(strToken.hasMoreTokens())
						{
							date_ind = strToken.nextToken();
							date_val = strToken.nextToken();
							date_unit = strToken.nextToken();
							date_ref = strToken.nextToken();
						}
						noOfdays = Integer.parseInt(date_val);
						if(date_ind.equals("B"))
							toDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
						else if(date_ind.equals("A"))
							toDate = com.ehis.util.DateUtils.plusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
					}
					
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(hist_type_new));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
			}
		else//IN073728 ENDS
		{
			field_desc = (String) map.get("PERSONAL_VIEW") == null ? "S" : (String) map.get("PERSONAL_VIEW");
			if(!field_desc.equals(""))
			{
				personal_view = field_desc;
				if(personal_view.equals("A"))
				{
					all_check = "selected";
					self_checked = "";
					speciality_checked = "";
				}
				else if(personal_view.equals("M"))
				{
					all_check = "";
					self_checked = "";
					speciality_checked = "selected";
				}
				else if(personal_view.equals("S"))
				{
					all_check = "";
					self_checked = "selected";
					speciality_checked = "";
				}
			}
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(personal_view));
            _bw.write(_wl_block30Bytes, _wl_block30);

				field_desc = (String) map.get("EVENT_CLASS") == null ? "" : (String) map.get("EVENT_CLASS");
				
				if(!field_desc.equals(""))
					event_class = field_desc;
				
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(event_class));
            _bw.write(_wl_block32Bytes, _wl_block32);

					field_desc = (String) map.get("EVENT_GROUP") == null ? "" : (String) map.get("EVENT_GROUP");
					if(!field_desc.equals(""))
						event_group = field_desc;
					
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(event_group));
            _bw.write(_wl_block11Bytes, _wl_block11);

						sqlFilter = "select long_desc description from CR_CLN_EVT_GRP_LANG_VW where EVENT_GROUP = ? and hist_rec_type = 'LBIN' and LANGUAGE_ID = ?";
						stmtsql = con.prepareStatement(sqlFilter);
						stmtsql.setString(1,event_group);
						stmtsql.setString(2,locale);
						rs = stmtsql.executeQuery();
						if(rs.next())
							event_group_desc = rs.getString("description") == null ? "" : rs.getString("description");
						if(rs != null) rs.close();
						if(stmtsql != null) stmtsql.close();
				
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(event_group_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);

				field_desc = (String) map.get("EVENT_ITEM") == null ? "" : (String) map.get("EVENT_ITEM");
				if(!field_desc.equals(""))
					event_item = field_desc;
				
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(event_item));
            _bw.write(_wl_block32Bytes, _wl_block32);

				if(!grphistory_type.equals("MEDN") && !event_item.equals(""))//Adding start for //IN072762
				{
					sqlFilter = "select long_desc description from CR_CLN_EVT_MST_LANG_VW where EVENT_CODE = ? and hist_rec_type = 'LBIN' and LANGUAGE_ID = ?";
					stmtsql = con.prepareStatement(sqlFilter);
					stmtsql.setString(1,event_item);
					stmtsql.setString(2,locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
						event_item_desc = rs.getString("description") == null ? "" : rs.getString("description");
					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();
				}
				if(grphistory_type.equals("MEDN") && !event_item.equals(""))
				{
					pstmt8 = con.prepareStatement("select DRUG_DESC from ph_drug_lang_vw where  drug_code = ? and LANGUAGE_ID =?");
				    pstmt8.setString(1,event_item);
					pstmt8.setString(2,locale);
					rs8 = pstmt8.executeQuery();
						if(rs8.next())
						{
						  event_item_desc = rs8.getString("DRUG_DESC") == null ? "" : rs8.getString("DRUG_DESC");
											
					 	}
						if(rs8 != null) rs8.close();
						if(pstmt8 != null) pstmt8.close();
				}//Addding end for //IN072762
				
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(event_item_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);

			field_desc = (String) map.get("PATIENT_CLASS") == null ? "" : (String) map.get("PATIENT_CLASS");
			if(!field_desc.equals(""))
			{
				patient_class1 = field_desc;
				if(patient_class1.equals("CURR_PAT_CLASS"))
					patient_class1 = patientclass;
			}
			else
				patient_class1="";	
			
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_class1));
            _bw.write(_wl_block30Bytes, _wl_block30);

			field_desc = (String) map.get("VIEW_BY") == null ? "" : (String) map.get("VIEW_BY");
			if(!field_desc.equals(""))
			{
				view_by = field_desc;
				if(view_by.equals("I"))
				{
					date_checked = "checked";
					event_checked = "";
				}
				else if(view_by.equals("P"))
				{
					date_checked = "";
					event_checked = "checked";
				}
			}
			
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block30Bytes, _wl_block30);

			field_desc = (String) map.get("ABNORMAL") == null ? "" : (String) map.get("ABNORMAL");
			abnormal1=field_desc;
			if(field_desc.equals("Y"))
				abnormal = "checked";
			else
				abnormal = "";
			
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(abnormal1));
            _bw.write(_wl_block30Bytes, _wl_block30);

			field_desc = (String) map.get("DISPLAY_ORDER") == null ? "" : (String) map.get("DISPLAY_ORDER");
			date_Ordr=field_desc;
			
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(date_Ordr));
            _bw.write(_wl_block30Bytes, _wl_block30);

			field_desc=(String) map.get("FACILITY_ID") == null ? "" : (String) map.get("FACILITY_ID");//
			if(field_desc.equals("LOGGED_IN_FCY"))
				facility_Id_param=facilityId;
			else if(!field_desc.equals(""))
				facility_Id_param=field_desc;
			else
				facility_Id_param="";
			
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(facility_Id_param));
            _bw.write(_wl_block30Bytes, _wl_block30);

			field_desc = (String) map.get("NORMALCY_IND") == null ? "" : (String) map.get("NORMALCY_IND");
			normalcy_ind=field_desc;
			
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(normalcy_ind));
            _bw.write(_wl_block30Bytes, _wl_block30);

			field_desc = (String) map.get("ENCOUNTER_ID") == null ? "" : (String) map.get("ENCOUNTER_ID");
			if(!field_desc.equals(""))
			{
				if(field_desc.equals("ENCOUNTER_ID"))
					encounterid = encounterId;
			}
			else
				encounterid ="";//IN070032
			
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block30Bytes, _wl_block30);

			field_desc = (String) map.get("PERIOD_FROM") == null ? "" : (String) map.get("PERIOD_FROM");
			String currDate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			int noOfdays = 0;
			if(!field_desc.equals(""))
			{
				strToken = new StringTokenizer(field_desc,"|");
				if(strToken.hasMoreTokens())
				{
					date_ind = strToken.nextToken();
					date_val = strToken.nextToken();
					date_unit = strToken.nextToken();
					date_ref = strToken.nextToken();
				}
				noOfdays = Integer.parseInt(date_val);
				if(date_ind.equals("B"))
					fromDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
				else if(date_ind.equals("A"))
					fromDate = com.ehis.util.DateUtils.plusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
			}
			
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block30Bytes, _wl_block30);

			field_desc = (String) map.get("PERIOD_TO") == null ? "" : (String) map.get("PERIOD_TO");
			if(!field_desc.equals(""))
			{
				strToken = new StringTokenizer(field_desc,"|");
				if(strToken.hasMoreTokens())
				{
					date_ind = strToken.nextToken();
					date_val = strToken.nextToken();
					date_unit = strToken.nextToken();
					date_ref = strToken.nextToken();
				}
				noOfdays = Integer.parseInt(date_val);
				if(date_ind.equals("B"))
					toDate = com.ehis.util.DateUtils.minusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
				else if(date_ind.equals("A"))
					toDate = com.ehis.util.DateUtils.plusDate(currDate,"DMYHM",locale,noOfdays,date_unit);
			}
			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
		}
		
		
	}//IN073728

            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block55Bytes, _wl_block55);

	String selString ="";//IN070032
	String facility_YN="";//IN070032
	pstmt=con.prepareStatement(sql_facility,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	pstmt.setString(1,facility_Id_param);
	pstmt.setString(2,p_user_name);
	rset=pstmt.executeQuery();
	while(rset.next())
	{
		//String facility_YN=rset.getString("facility_YN");//IN070032
		 facility_YN=rset.getString("facility_YN");//IN070032
		if(facility_YN.equals("Y"))
			facilityId=facility_Id_param;
     }
	rset.beforeFirst();
	if(rset!=null)
	{
	//IN070032 starts
		if(isfacilitySelct)//IN071263
		{
		 selString = "<option selected>-------------Select----------------</option>";
		}
		else
			 selString ="";
	   while(rset.next())
	   {
		 fid= rset.getString("facility_id")==null?"":rset.getString("facility_id");
		 fname=rset.getString("facility_name")==null?"":rset.getString("facility_name");
		 if(!(facility_Id_param.equals("")) && !(isfacilitySelct)){
			if(facilityId.equals(fid))//IN069654
			{
				selString += "<option selected value='"+fid+ "' >"+fname+"  </option>";
			}else{
				selString += "<option value='"+fid+ "' >"+fname+"</option>";
		    }
		}
		 else if(facility_Id_param.equals("")&&isfacilitySelct)
		 {
			 if(facilityId.equals(fid))//IN069654
				{
					selString += "<option  value='"+fid+ "' >"+fname+"  </option>";
				}else{
					selString += "<option value='"+fid+ "' >"+fname+"</option>";
			    }
		 }
		 else
		 {
			 if(facilityId.equals(fid))//IN069654
				{
					selString += "<option selected value='"+fid+ "' >"+fname+"  </option>";
				}else{
					selString += "<option value='"+fid+ "' >"+fname+"</option>";
			    }
		 }
	   }
	   	System.out.println("selString: "+selString);
		out.println(selString);
    }//IN070032 ends
	if(rset != null)rset.close();
	if(pstmt != null)pstmt.close();
	
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(ql_ref));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(reln_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(grphistory_type));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block63Bytes, _wl_block63);

}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block64Bytes, _wl_block64);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
