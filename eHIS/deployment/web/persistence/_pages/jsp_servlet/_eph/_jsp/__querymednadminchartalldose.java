package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __querymednadminchartalldose extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/QueryMednAdminChartAllDose.jsp", 1709121342674L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--This file is saved on 28/10/2005-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/QueryMednAdminChart.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/PhMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<body onKeyDown=\"lockKey()\"  onKeyDown = \'lockKey()\'  >\n<form name=\"AdminChart\" id=\"AdminChart\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\n\n<table cellpadding=\"0\" cellspacing=\"0\"  border=\"0\"  width=\"100%\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<th align=\"left\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<tr>\n\t<td align=\"left\" colspan=\"10\" class=\"CURRTEXT\"><font  style=\"font-weight:bold;color:black\" size=1><fmt:message key=\"ePH.AdministrationDetailfor.label\" bundle=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></th>\n</tr>\n</table>\n<table cellpadding=\"0\" cellspacing=\"0\"  border=\"1\"   id=\"drugTable\" name=\"drugTable\" id=\"drugTable\" width=\"100%\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<th align=\"center\"  class=\"HEADERTITLE\" width=\"350\"><fmt:message key=\"Common.Drug.label\" bundle=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/></th>\n\t<th align=\"center\" class=\"HEADERTITLE\" width=\"2\"><fmt:message key=\"Common.uom.label\" bundle=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/></th>\t\n\t<!---->\n\t<th align=\"center\" class=\"HEADERTITLE\" colspan=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"><fmt:message key=\"ePH.Timings/Dosage.label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/></th>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\n\t\t\t\t<tr>\n\t\t\t\t<td class=\'EMPTY\' width=\"300\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td class=\'EMPTY\'  width=\"2\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t\t<td   align=\"center\" width=\"60\" class=\'TIMING\' ><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></td>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</tr>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<tr>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'><font size=\'1\'>\n\t ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;<img src=\"../../ePH/images/stop.gif\" title=\"Held Order!!!\" ></font></td>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'><font size=\'1\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<img src=\"../../ePH/images/stop.gif\" title=\"Discontinued Order!!!\" >\t\n\t\t\t</font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<td  class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td>\n\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t<td   align=\'center\' class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  style=\"font-size:8pt;cursor:pointer;background-color:white;border-right:15px solid #00FF00;color:blue\" title=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onClick=\"callAdminDetails(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'Y\',this,0)\" >&nbsp;&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<td align=\'center\' lass=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' style=\"cursor:pointer;background-color:white;border-right:15px solid #CC99CC; color:blue\" onClick=\"callAdminDetails(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\t\t\t\t\t\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'Y\',this,1)\" >\n\t\t\t\t\t\t<font align=\'center\' size=\'1\'  title=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</font></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t<td  align=\'center\' class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' style=\"background-color:white;cursor:pointer;border-right:15px solid green;color:blue\" onClick=\"callAdminDetails(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<td   align=\'center\' class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' style=\"\n\t\t\t\t\t\t background-color:white; border-right:15px solid black;color:black\" ><font size=\'1\'  title=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</font></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t<td  align=\'center\' class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' style=\" background-color:white;border-right:15px solid SILVER;color:black;\" ><font size=\'1\'  title=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</font></td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t<td  align=\'center\' class=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' style=\"background-color:white;color:blue;border-right:15px solid red;cursor:pointer\" onClick=\"callAdminDetails(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\',\'N\',this,1)\" ><font size=\'1\'  title=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t<td   align=\'center\' class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" style=\"background-color:white;\"> \n\t\t\t\t\t\t\t\t\t<font size=\'1\'  title=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t</font></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t</tr>\n\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t</TABLE>\n\t</SPAN>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n<input type=\"hidden\" name=\"admindate\" id=\"admindate\" value=\"\">\t\n<input type=\"hidden\" name=\"fromtime\" id=\"fromtime\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<input type=\"hidden\" name=\"totime\" id=\"totime\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<input type=\"hidden\" name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<input type=\"hidden\" name=\"helddiscontinued\" id=\"helddiscontinued\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<input type=\"hidden\" name=\"relevantencounter\" id=\"relevantencounter\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );
	
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
        response.setHeader("Content-Type", "text/html; ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

	String  called_from			=	request.getParameter("called_from");
	String  relevantencounterid	=	request.getParameter("relevantencounter");
	String  admindate			=	"";
	String  fromtime			=	request.getParameter("fromtime");
	String  totime				=	request.getParameter("totime");
	String  helddiscontinued	=	request.getParameter("helddiscontinued");
	String  facilityid			=	request.getParameter("facilityid");
	String	mode				=	request.getParameter("mode");
	String admindate1			=	"";

	String bean_id				= "QueryMednAdminChartBean";
	String bean_name			= "ePH.QueryMednAdminChartBean";

	QueryMednAdminChartBean bean = (QueryMednAdminChartBean)getBeanObject( bean_id,bean_name,request);
	HashMap scheduleDetails		=	new HashMap();



	HashMap sch_dates			=	bean.loadSchDates(relevantencounterid);
	ArrayList records			=	new ArrayList();
	String tab_title				=	"";

            _bw.write(_wl_block6Bytes, _wl_block6);

if(called_from.equals("PAST")) {
	 records		=	(ArrayList) sch_dates.get("past_records");
	 tab_title			=	"Past Dosage Detail";
} else if(called_from.equals("FUTURE")) {
	 records		=	(ArrayList) sch_dates.get("future_records");
	 tab_title			=	"Future Dosage Detail";
}




            _bw.write(_wl_block1Bytes, _wl_block1);

for(int n=0; n<records.size(); n++) { 

	admindate	=	(String)records.get(n);

	String dflt_sch_date	=	admindate;
if (totime.equals(""))
	{
		admindate1=admindate+" 23:00";
	}
else
	{
		admindate1=admindate+" "+totime;
	}

if (fromtime.equals(""))
	{
		admindate=admindate+" 00:00";
	}
else
	{
		admindate=admindate+" "+fromtime;
	}

	if (helddiscontinued.equals("1"))
	{
	scheduleDetails=bean.populateScheduleDetails(facilityid,relevantencounterid,admindate,admindate1,"Y");

	}
	else
	{
	
	scheduleDetails=bean.populateScheduleDetails(facilityid,relevantencounterid,admindate,admindate1,"N");
	}

	
		String col_count=(String)scheduleDetails.get("COL_COUNT");
		int total_col=Integer.parseInt(col_count);
		String col_timings=(String)scheduleDetails.get("COL_TIMINGS");
		String sch_detail=(String)scheduleDetails.get("SCH_DETAILS");
		//String date_details=(String)scheduleDetails.get("DATE_DETAILS");
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(n==0) { 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tab_title));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dflt_sch_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
 if(n==0) { 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(total_col));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
	}	
            _bw.write(_wl_block18Bytes, _wl_block18);

		StringTokenizer time_token = new StringTokenizer(col_timings, "|");
		int time_counter=time_token.countTokens();
		String sch_time[]=new String[time_counter];
			int time_track=0;
			while (time_token.hasMoreTokens())
			{
			sch_time[time_track]=time_token.nextToken();
			time_track++;
			}
		for(int i=0;i<time_counter;i++){
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sch_time[i]));
            _bw.write(_wl_block20Bytes, _wl_block20);
	
	}//end of for-time-counter


            _bw.write(_wl_block21Bytes, _wl_block21);

	String classvalue,title;
	StringTokenizer schedule_dose_details = new StringTokenizer(sch_detail, "$$");
	int count=0;
	while (schedule_dose_details.hasMoreTokens())
	{
	String detail=(String)schedule_dose_details.nextToken();
	if ( count++ % 2 == 0 ){
					classvalue = "QRYEVEN" ;
			}else{
					classvalue = "QRYODD" ;
					}
	
            _bw.write(_wl_block22Bytes, _wl_block22);

	StringTokenizer dose_details = new StringTokenizer(detail, "~");
	String held	=	(String)dose_details.nextToken();
	String discontinued	=	(String)dose_details.nextToken();
	String order_id		=	(String)dose_details.nextToken();
	String drug_code	=	(String)dose_details.nextToken();
	String drug_name	=	(String)dose_details.nextToken();
	String schdatetime	=	(String)dose_details.nextToken();
	String qty_details	=	(String)dose_details.nextToken();
	String uom			=	(String)dose_details.nextToken();
	
		if ( held.equals("Y") )
		{

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
		else
		{
		if (discontinued.equals("Y") )
		{
			
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}
		else
			{
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block29Bytes, _wl_block29);

			}

		}
		
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block31Bytes, _wl_block31);


		
			StringTokenizer qty_token = new StringTokenizer(qty_details, "|");
			int qty_counter=(qty_token.countTokens()/7);
			String date_qty[]=new String[qty_counter];
			String time_qty[]=new String[qty_counter];
			String sch_qty[]=new String[qty_counter];
			String sch_link[]=new String[qty_counter];
			String admin_recorded[]=new String[qty_counter];
			String systimegreater[]=new String[qty_counter];
			String altdrug1[]=new String[qty_counter];
			int qty_track=0;
			while (qty_token.hasMoreTokens())
			{
			altdrug1[qty_track]=qty_token.nextToken();
			date_qty[qty_track]=qty_token.nextToken();
			time_qty[qty_track]=qty_token.nextToken();
			sch_qty[qty_track]= qty_token.nextToken();
			sch_link[qty_track]=qty_token.nextToken();
			admin_recorded[qty_track]=qty_token.nextToken();
			systimegreater[qty_track]=qty_token.nextToken();
			qty_track++;
			}
				for(int i=0;i<qty_counter;i++){
				title				="Time - "+time_qty[i]+" -- "+drug_name+" "+sch_qty[i]+" "+uom;
				//This link denotes whether medication was administered or not
				if(sch_link[i].equals("Y")){
				//ADMINISTERED IS TRUE
							if(sch_qty[i].equals("0")){
						//direct administration has been carried out
						
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(title));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(date_qty[i]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block36Bytes, _wl_block36);
				
						}
					else if (altdrug1[i].equals("0")) 
					{
						//alternate drug has been administered and so
								
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(date_qty[i]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(title));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sch_qty[i]));
            _bw.write(_wl_block42Bytes, _wl_block42);

					}
					else
					{
								
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(date_qty[i]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(title));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sch_qty[i]));
            _bw.write(_wl_block42Bytes, _wl_block42);

					}
					
							
				}else{
						//ADMINISTERED IS FALSE		
						
						if(sch_qty[i].equals("M")){
							sch_qty[i]="&nbsp;";
						}
					if(admin_recorded[i].equals("N")&&(systimegreater[i].indexOf("Y")!=-1 )  ){
												//admin not recorded 
						
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(title));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sch_qty[i]));
            _bw.write(_wl_block47Bytes, _wl_block47);

															
					}
					else if(admin_recorded[i].equals("N")&& (systimegreater[i].indexOf("N")!=-1 ) )
					{
						//admin not recorded 
					
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(title));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sch_qty[i]));
            _bw.write(_wl_block50Bytes, _wl_block50);

					}
					else if(admin_recorded[i].equals("Y"))
					{
							//admin recorded  but administration not carried out
					
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(schdatetime));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(title));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sch_qty[i]));
            _bw.write(_wl_block47Bytes, _wl_block47);

					}
					else
					{
						
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(title));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sch_qty[i]));
            _bw.write(_wl_block56Bytes, _wl_block56);

					}

			
				}
		
	}
	
            _bw.write(_wl_block57Bytes, _wl_block57);

	}



	
            _bw.write(_wl_block58Bytes, _wl_block58);
	
		}

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(helddiscontinued));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(relevantencounterid));
            _bw.write(_wl_block65Bytes, _wl_block65);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block66Bytes, _wl_block66);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
