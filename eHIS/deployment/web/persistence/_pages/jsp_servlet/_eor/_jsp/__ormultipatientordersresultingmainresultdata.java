package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import eCommon.Common.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ormultipatientordersresultingmainresultdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ORMultiPatientOrdersResultingMainResultData.jsp", 1709119882000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head><title>MultiPatientOrdersResultingHdr</title>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t<script language=\"JavaScript\" src=\"../../eOR/js/ORMultiPatientOrdersResultingReport.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script><!-- used for date validation-->\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\tresultingRecordsNotFound();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body onload=\'FocusFirstElement()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"multiPatientOrdersResultingMainResult\" id=\"multiPatientOrdersResultingMainResult\">\n<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"order_id";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\"hidden\" name=\"order_line_num";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\"hidden\" name=\"order_type_code";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"order_type_code";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\"hidden\" name=\"catalog_code";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"catalog_code";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"patient_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"encounter_id";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\"hidden\" name=\"patient_class";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"patient_class";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<script>\n\t\tloadOrderValues();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n<div id=\'divUnitTitle\' style=\'postion:relative\'>\n\t<table border=\'1\' width=\'100%\' id=\'unitTitleTable\' >\n\t\t<TR>\n\t\t\t<!--<TD style=\"width: 35px;\" class=\"COLUMNHEADER\">\n\t\t\t</TD>-->\n\t\t\t<TD style=\"width: 125px;\" class=\"COLUMNHEADER\" nowrap>\n\t\t\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t \n\t\t\t</TD>\n\t\t\t<TD style=\"width: 125px;\" class=\"COLUMNHEADER\" nowrap> \n\t\t\t\t ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t \n\t\t\t</TD>\n\t\t\t<TD style=\"width: 125px;\" class=\"COLUMNHEADER\" nowrap>\n\t\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<!--<TD style=\"width: 25px;\" class=\"COLUMNHEADER\">&nbsp;\n\t\t\t</TD>-->\n\t\t\t<TD class=\"COLUMNHEADER\" nowrap>\n\t\t\t\t ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</TD>\n\t\t\t<TD class=\"COLUMNHEADER\" colspan=\"2\" nowrap>\t\t\t \n\t\t\t\t  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t</TD>\n\t\t</TR>\n\t</table>\n</div>\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'90%\' align=\'center\'>\n\t<tr align=\'right\' width=\'10%\'>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<td class=\'WHITE\' width=\'89%\'>&nbsp;</td>\n\t\t<td class=\'WHITE\' width=\'11%\'>\n\t\t<!--<A HREF=\'javascript:onClick=submitPage(\"Previous\");\' text-decoration=\'none\' >Previous</A>-->\n\t\t</td>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<td class=\'WHITE\' width=\'94%\'>&nbsp;</td>\n\t\t<td class=\'WHITE\' width=\'6%\'>\n\t\t<!--<A HREF=\'javascript:onClick=submitPage(\"Next\");\' text-decoration=\'none\' >Next</A>-->\n\t\t</td>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t</tr>\n</table> \n<table width=\"100%\" border=\"0\" id=\'unitTable\' style=\"border-bottom:#ffffff\">\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t<TR>\n\t\t<!--<TD style=\"width: 35px;\" class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" align=\"left\">&nbsp;\n\t\t\t\n\t\t</TD>-->\n\t\t<TD style=\"width: 125px;\" class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" align=\"left\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t</TD>\n\t\t<TD style=\"width: 125px;\" class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" nowrap>\n\t\t\t ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t</TD>\n\t\n\t</TR>\n\t<TR>\n\t\t<!--<TD style=\"width: 25px;\" class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">&nbsp;\n\t\t<a href=\"#\" onClick=\"displayOrder(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\')\"> + </a>\n\t\t</TD>-->\n\t\t<TD class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" nowrap>\n\t\t\t&nbsp; ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" colspan=\"2\" align=\"left\" nowrap>\n\t\t\t&nbsp; <a href=\"#\" onClick=\"displayOrder(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')\"> ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" </a>\n\t\t</TD>\n\t\t\n\t</TR>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t<!--<TR style=\"display: none;\">\n\t\t<TD class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">&nbsp;</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">&nbsp;</TD>\n\t</TR>\n\t<TR style=\"display: none;\">\n\t\t<TD class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" colspan=\"2\">&nbsp;</TD>\n\t</TR>--> \n</table>\n\n<input type=\"hidden\" name=\"text_area_exists\" id=\"text_area_exists\" value=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" >\n<input type=\"hidden\" name=\"count\" id=\"count\" value=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" >\n<input type=\"hidden\" name=\"result_format\" id=\"result_format\" value=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" >\n<input type=\"hidden\" name=\"header_values\" id=\"header_values\" value=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" >\n<input type=\"hidden\" name=\"order_values\" id=\"order_values\" value=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" >\n\n<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<input type=\"hidden\" name=\"to\" id=\"to\" value=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =">\n\n<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<input type=\"hidden\" name=\"dispMode\" id=\"dispMode\" value=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" >\n<input type=\"hidden\" name=\"temp_dispMode\" id=\"temp_dispMode\" value=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" >\n<input type=\"hidden\" name=\"temp_from\" id=\"temp_from\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<input type=\"hidden\" name=\"temp_to\" id=\"temp_to\" value=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n<input type=\'hidden\' name=\'localeName\' id=\'localeName\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n<script>\n\tsetTimeout(\"alignUnitsAndTitle()\",100);\n\tloadResultingMainResult1();\n\tparent.multiPatientOrdersResultingMainButtons.location.href=\"../../eOR/jsp/ORMultiPatientOrdersResultingMainButtons.jsp\";\n</script>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );
	
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

int row_count=0;

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	/* Mandatory checks start */


	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";
	String facility_id = (String)session.getValue("facility_id");

	String text_area_exists = request.getParameter("text_area_exists");
	int count = Integer.parseInt(request.getParameter("count"));
	String result_format = request.getParameter("result_format");

	String header_values = request.getParameter("header_values");

	String order_values = request.getParameter("order_values");
	String location			= "";
	String catalog_desc		= "";
	String catalog_code		= "";
	String patient_name		= "";
	String patient_id		= "";
	String order_start_time = "";
	String classval			= "";
	String order_id			= "";
	String order_line_num	= "";
	String order_type_code	= "";
	String encounter_id		= "";
	String patient_class	= "";
	String sex="";


	String header_location_type		= "";
	String header_locn				= "";
	String header_period_from		= "";
	String header_period_to			= "";
	String header_order_category	= "";
	String header_order_type		= "";
	String header_order_catalog_code = "";
	String header_result_format_code = "";
	String group_by					= "";
	if(header_values!=null && !header_values.equals("") && !header_values.equals("null"))
	{
		StringTokenizer st = new StringTokenizer(header_values,"~~~");
		while(st.hasMoreElements())
		{
			header_location_type			= st.nextToken();
			header_locn						= st.nextToken();
			header_period_from				= st.nextToken();
			header_period_to				= st.nextToken();
			header_order_category			= st.nextToken();
			header_order_type				= st.nextToken();
											  st.nextToken();
			header_order_catalog_code		= st.nextToken();
											  st.nextToken();
			header_result_format_code		= st.nextToken();
			group_by						= st.nextToken();
											  st.nextToken();
											  st.nextToken();
											  st.nextToken();
			header_location_type			= header_location_type.trim();
			header_locn						= header_locn.trim();
			header_period_from				= header_period_from.trim();
			header_period_to				= header_period_to.trim();
			header_order_category			= header_order_category.trim();
			header_order_type				= header_order_type.trim();
			header_order_catalog_code		= header_order_catalog_code.trim();
			header_result_format_code		= header_result_format_code.trim();
			group_by						= group_by.trim();
		}
	}
	ArrayList allValues = new ArrayList();
	allValues.add(header_order_catalog_code);
	allValues.add(header_order_category);
	allValues.add(header_order_type);
	allValues.add(result_format);
	allValues.add(header_period_from);
	allValues.add(header_period_to);
	allValues.add(header_location_type);
	allValues.add(header_locn);
	allValues.add(group_by);
	allValues.add(order_values);
	allValues.add(facility_id);
	String[] resultList = null;

	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;


	int row_disp=OrRepository.DISPLAY_MIN_RECORDS;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String dispMode="";

	String temp_dispMode="", temp_from="", temp_to="";

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;


	eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();

	dispMode			=	request.getParameter("dispMode") ;
	from				=	request.getParameter("from") ;
	to					=	request.getParameter("to") ;

	temp_dispMode		=	dispMode;
	temp_from			=	from;
	temp_to				=	to;


	if ( from == null || from=="null" || from.equals("null") )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp - 1;
	else
		end = Integer.parseInt( to ) ;

	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(dispMode.equals(""))
	{
		bean.getOrdersResultingValues(allValues);

		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
		row_count			=  MultiRecordSet.getSize("DB");
		
		if(row_count ==0)
		{
			
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start);
		to   = ""+(end);
	}
	else
	{
//		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
		}else if(dispMode.equals("Previous")){
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
		if(to_val > (row_count-1))
			to_val=(row_count-1);
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block11Bytes, _wl_block11);

if(dispMode.equals(""))
{
	for(int i=0;i<row_count;i++)
	{
		htListRecord		= (java.util.HashMap)	MultiRecordSet.getObject(i);
		resultList = (String[]) htListRecord.get("result");
		order_id		= resultList[0];
		order_line_num	= resultList[1];
		order_type_code = resultList[10];
		catalog_code	= resultList[2];
		patient_id		= resultList[5];
		encounter_id	= resultList[11];
		patient_class	= resultList[12];
		sex	= resultList[13];
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block27Bytes, _wl_block27);

	}
	
            _bw.write(_wl_block28Bytes, _wl_block28);

}

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

	
	if ( (!(start <= 1)) && (start < row_count)){
	
            _bw.write(_wl_block35Bytes, _wl_block35);
	
	}
//	if ( !( (start+row_disp) > row_count ) ){
	if ( !( (start+row_disp) >= row_count ) ){
	
            _bw.write(_wl_block36Bytes, _wl_block36);

	}
	
            _bw.write(_wl_block37Bytes, _wl_block37);

for(int i=fm_disp;i<=to_disp;i++)
{
	
	if(i % 2 == 0 )
	{
		classval	=	"CACHARTQRYEVEN";
	}
	else
	{
		classval	=	"CACHARTQRYEVEN";
	}

	htListRecord		= (java.util.HashMap)	MultiRecordSet.getObject(i);
	resultList = (String[]) htListRecord.get("result");

	order_id = resultList[0];
	location = resultList[9];
	patient_name = resultList[6];
	patient_id = resultList[5];
	order_start_time = resultList[4];
	catalog_desc = resultList[3];
	if(catalog_desc==null)
		catalog_desc ="";
	if(order_start_time==null)
		order_start_time ="";
	if(patient_name==null)
		patient_name ="";
	if(location==null)
		location ="";
	if(patient_id==null)
		patient_id ="";

	if(!localeName.equals("en"))
	{
		order_start_time = com.ehis.util.DateUtils.convertDate(order_start_time,"DMYHM","en",localeName);
	}



            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(location));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(order_start_time));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);

}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(text_area_exists));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(result_format));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(header_values));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(order_values));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(from));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(to));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(temp_dispMode));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(temp_from));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(temp_to));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block70Bytes, _wl_block70);

	// set it back persistence
	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderStartDate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.catalog.label", java.lang.String .class,"key"));
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
}
