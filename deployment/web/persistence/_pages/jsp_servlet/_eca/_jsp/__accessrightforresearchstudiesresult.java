package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __accessrightforresearchstudiesresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AccessRightForResearchStudiesResult.jsp", 1709115422280L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\'javascript\' src=\'../../eCA/js/AccessRightForResearchStudies.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' <= 0){\n\t\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\");\t\n\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body  OnMouseDown=\"CodeArrest();\"  class=\'CONTENT\' onKeyDown = \'lockKey()\'>\n<form name=\'formAccessRightForResearchStudiesResult\' id=\'formAccessRightForResearchStudiesResult\' >\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'85%\' align=\'center\'>\n<tr  width=\'10%\'>\n<td class=\'white\' width=\'89%\'></td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\n\t\t<td width=\'6%\' class=\'label\'>\n\t\t<A class=\'gridLink\' HREF=\'javascript:onClick=checkVal(\"Previous\");\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td width=\'6%\' class = \'label\'><A class=\'gridLink\' HREF=\'javascript:onClick=checkVal(\"Next\");\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</tr>\n</table> \n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\t\n\t<tr>\n\t\t<th rowspan=\"2\">Practitioner</th>\n\t\t<th colspan=\"2\">Access Rights for Clinical Studies Patient List</th>\t\t\n\t\t<td>&nbsp;</td>\n\t\t<th colspan=\"2\">Access Rights for Clinical Studies</th>\n\t</tr> \n\t<tr>\n\t\t<th>Date From</th>\n\t\t<th>Date To</th>\n\t\t<td>&nbsp;</td>\n\t\t<th>Record</th>\n\t\t<th>Update</th>\n\t</tr> \n\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<TR>\n\t\t<TD>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TD>\n\t\t<input type=\"hidden\" name=\"practitionerId";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"practitionerId";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\"hidden\" name=\"practitionerName";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"practitionerName";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\"hidden\" name=\"studyAllowedIU";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"studyAllowedIU";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\"hidden\" name=\"studyRightsIU";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"studyRightsIU";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<TD>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'textbox\' id=\'resFromDate";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' name=\'resFromDate";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' size=\'14\' maxlength=\'16\' >&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'resFromDate";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\"></img></TD>\n\t\t<TD>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<input type=\'textbox\' id=\'resToDate";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' name=\'resToDate";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' size=\'14\' maxlength=\'16\' >&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'resToDate";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\"></img>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a href=\"javascript:showAccessRightsHistory(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\">H</a>\n\t\t</TD>\n\t\t<TD>&nbsp;</TD>\n\t\t<TD align=\"center\"><input type=\"checkbox\" id=\'resRecord";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' name=\'resRecord";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' onclick=\"checkRecUpd(\'resRecord";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" checked ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="  /></TD>\n\t\t<TD align=\"center\"><input type=\"checkbox\" id=\'resUpdate";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' name=\'resUpdate";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onclick=\"checkRecUpd(\'resUpdate";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="  /></TD>\n\t</TR>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\n </table>\n <input type=\"hidden\" name=\"dispMode\" id=\"dispMode\" value=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" > \n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"optionValStr\" id=\"optionValStr\" value=\"\"/>\n\t<input type=\"hidden\" name=\"resePatCategory\" id=\"resePatCategory\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"/>\n\t<input type=\"hidden\" name=\"reseCategoryFact\" id=\"reseCategoryFact\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"/>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	webbeans.eCommon.RecordSet accRightForResStuRecSet = (webbeans.eCommon.RecordSet)getObjectFromBean("accRightForResStuRecSet","webbeans.eCommon.RecordSet",session);

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facilityId = (String)session.getValue( "facility_id" ) ;


Connection con			= null;
PreparedStatement pstmt = null,pstmt1=null;
ResultSet rs			= null,rs1=null;
HashMap hMapRecords		= null; 

	
String practitionerId ="", practitionerName = "", resFromDate = "", resToDate = "", resRecord = "", resUpdate = "", studyAllowedIU="", studyRightsIU="", classValue="";
int row_disp=14;
int start = 0 ;
int end = 0 ;
int fm_disp=0, to_disp=0;

String dispMode		=	request.getParameter("dispMode")==null?"": request.getParameter("dispMode");
String from			=	request.getParameter( "from" )==null?"1": request.getParameter( "from" );
String to				=	request.getParameter( "to" )==null?String.valueOf(row_disp): request.getParameter( "to" );
String resePatCategory = request.getParameter("resePatCategory")==null?"":(String)request.getParameter("resePatCategory");
String reseCategoryFact = request.getParameter("reseCategoryFact")==null?"":(String)request.getParameter("reseCategoryFact");
String search_by = request.getParameter("search_by")==null?"":request.getParameter("search_by");
String search_txt = request.getParameter("search_txt")==null?"":request.getParameter("search_txt");
start = Integer.parseInt( from ) ;
end = Integer.parseInt( to ) ;
StringBuffer sql_query = new StringBuffer();
sql_query.append("SELECT APLV.PRACTITIONER_ID ,APLV.PRACTITIONER_NAME, SM_CONVERT_DATE_2T(CRSA.RES_FROM_DATE,?) RES_FROM_DATE,SM_CONVERT_DATE_2T(CRSA.RES_TO_DATE,?) RES_TO_DATE ,(select CRSR.RES_RECORD  from CA_RES_STUDY_RIGHTS CRSR where CRSR.PRACTITIONER_ID =APLV.PRACTITIONER_ID AND CRSR.RESEARCH_CATEG_ID = ? AND CRSR.RESEARCH_CATEG_FACT_ID=? AND CRSR.FACILITY_ID=?) RES_RECORD,(select CRSR.RES_UPDATE  from CA_RES_STUDY_RIGHTS CRSR where CRSR.PRACTITIONER_ID =APLV.PRACTITIONER_ID  AND CRSR.RESEARCH_CATEG_ID = ? AND CRSR.RESEARCH_CATEG_FACT_ID=? AND CRSR.FACILITY_ID=?) RES_UPDATE,(SELECT 'U' FROM CA_RES_STUDY_ALLOWED WHERE PRACTITIONER_ID =APLV.PRACTITIONER_ID AND FACILITY_ID=?) PRACT_YN FROM AM_PRACTITIONER_LANG_VW APLV, CA_RES_STUDY_ALLOWED CRSA WHERE CRSA.PRACTITIONER_ID (+) =APLV.PRACTITIONER_ID AND /*(APLV.REPORTING_FACILITY_ID=? OR ALL_FACILITIES_YN='Y')*/ (? IN (SELECT sffu.facility_id FROM sm_facility_for_user_vw sffu,SM_APPL_USER sau WHERE sffu.appl_user_id =  sau.APPL_USER_ID AND sau.FUNC_ROLE_ID = aplv.practitioner_id) OR all_facilities_yn = 'Y') AND APLV.LANGUAGE_ID=? AND /*CRSA.FACILITY_ID (+) = NVL(APLV.REPORTING_FACILITY_ID,?)*/ CRSA.FACILITY_ID (+) =? ");
if("01".equals(search_by)){
	sql_query.append("AND  UPPER(APLV.PRACTITIONER_ID) LIKE UPPER(?)");
}else if("02".equals(search_by)){
	sql_query.append("AND UPPER(APLV.PRACTITIONER_NAME) LIKE UPPER(?)");
}
sql_query.append(" ORDER BY PRACTITIONER_NAME ASC  ");

try{
	con = ConnectionManager.getConnection(request);
	if(dispMode.equals("")){
		accRightForResStuRecSet.clearAll();
		pstmt = con.prepareStatement(sql_query.toString());
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,resePatCategory);
		pstmt.setString(4,reseCategoryFact);
		pstmt.setString(5,facilityId);
		pstmt.setString(6,resePatCategory);
		pstmt.setString(7,reseCategoryFact);
		pstmt.setString(8,facilityId);
		pstmt.setString(9,facilityId);
		pstmt.setString(10,facilityId);
		pstmt.setString(11,locale);
		pstmt.setString(12,facilityId);
		if("01".equals(search_by)||"02".equals(search_by)){
		pstmt.setString(13,"%"+search_txt+"%");
		}
		rs = pstmt.executeQuery();
		while(rs.next()){
		practitionerId 		=	rs.getString("PRACTITIONER_ID")==null?"":(String)rs.getString("PRACTITIONER_ID");
		practitionerName		=	rs.getString("PRACTITIONER_NAME")==null?"":(String)rs.getString("PRACTITIONER_NAME");
		resFromDate 	=	rs.getString("RES_FROM_DATE")==null?"":(String)rs.getString("RES_FROM_DATE");
		resToDate 		=	rs.getString("RES_TO_DATE")==null?"":(String)rs.getString("RES_TO_DATE");
		resRecord 		=	rs.getString("RES_RECORD")==null?"N":(String)rs.getString("RES_RECORD");
		resUpdate 		=	rs.getString("RES_UPDATE")==null?"N":(String)rs.getString("RES_UPDATE");
		studyAllowedIU	=	rs.getString("PRACT_YN")==null?"I":(String)rs.getString("PRACT_YN");
		studyRightsIU	=	rs.getString("RES_RECORD")==null?"I":"U"; 
		
		HashMap hMapRecs = new HashMap();
		hMapRecs.put("practitionerId"		, practitionerId);
		hMapRecs.put("practitionerName"		, practitionerName);
		hMapRecs.put("resFromDate"		, resFromDate);
		hMapRecs.put("resToDate"		, resToDate);
		hMapRecs.put("resRecord"		, resRecord);
		hMapRecs.put("resUpdate"		, resUpdate);
		hMapRecs.put("studyAllowedIU"	, studyAllowedIU);
		hMapRecs.put("studyRightsIU"	, studyRightsIU);
		
		accRightForResStuRecSet.putObject(hMapRecs);
		}
		row_count	=	accRightForResStuRecSet.getSize();
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}else{
		int from_val	= (Integer.parseInt(from));
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

		
		for(int j=from_val; j<=to_val; j++){			
			practitionerId 		=	request.getParameter("practitionerId"+j)==null?"":request.getParameter("practitionerId"+j);
			practitionerName		=	request.getParameter("practitionerName"+j)==null?"":request.getParameter("practitionerName"+j);
			resFromDate 	=	request.getParameter("resFromDate"+j)==null?"":request.getParameter("resFromDate"+j);
			resToDate 		=	request.getParameter("resToDate"+j)==null?"":request.getParameter("resToDate"+j);
			resRecord 		=	request.getParameter("resRecord"+j)==null?"":request.getParameter("resRecord"+j);
			resUpdate 		=	request.getParameter("resUpdate"+j)==null?"":request.getParameter("resUpdate"+j);
			studyAllowedIU	=	request.getParameter("studyAllowedIU"+j)==null?"":request.getParameter("studyAllowedIU"+j);
			studyRightsIU	=	request.getParameter("studyRightsIU"+j)==null?"":request.getParameter ("studyRightsIU"+j);
			HashMap hMapAlter = (java.util.HashMap)accRightForResStuRecSet.getObject(j);
			hMapAlter.put("practitionerId"	, practitionerId);
			hMapAlter.put("practitionerName"	, practitionerName);
			hMapAlter.put("resFromDate"	, resFromDate);
			hMapAlter.put("resToDate"	, resToDate);
			hMapAlter.put("resRecord"	, resRecord);
			hMapAlter.put("resUpdate"	, resUpdate);
			hMapAlter.put("studyAllowedIU"	, studyAllowedIU);
			hMapAlter.put("studyRightsIU"	, studyRightsIU);
			accRightForResStuRecSet.setObject(j, hMapAlter);
		}
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	putObjectInBean("accRightForResStuRecSet",accRightForResStuRecSet,session);

            _bw.write(_wl_block11Bytes, _wl_block11);

	if ( (!(start <= 1)) && (start < row_count)){
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
	
	}
	if ( !( (start+row_disp) >= row_count ) ){
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	}

            _bw.write(_wl_block15Bytes, _wl_block15);

	for(int i=fm_disp; i<=to_disp; i++){
		classValue		=	( (i%2)==0 )? "gridData" : "gridData";
		java.sql.Date fromDate = null;
		java.sql.Date toDate = null;
		hMapRecords 	= (java.util.HashMap)accRightForResStuRecSet.getObject(i);
		practitionerId		=	(String)	hMapRecords.get("practitionerId");
		practitionerName		=	(String)	hMapRecords.get("practitionerName");
		resFromDate		=	(String)	hMapRecords.get("resFromDate");
		resToDate		=	(String)	hMapRecords.get("resToDate");	
		resRecord		=	(String)	hMapRecords.get("resRecord");
		resUpdate		=	(String)	hMapRecords.get("resUpdate");
		studyAllowedIU	=	(String)	hMapRecords.get("studyAllowedIU");
		studyRightsIU	=	(String)	hMapRecords.get("studyRightsIU");			
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(practitionerId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(studyAllowedIU));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(studyRightsIU));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(resFromDate));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(resToDate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(practitionerId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resRecord));
            _bw.write(_wl_block39Bytes, _wl_block39);
if("Y".equals(resRecord)){
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(resUpdate));
            _bw.write(_wl_block39Bytes, _wl_block39);
if("Y".equals(resUpdate)){
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block44Bytes, _wl_block44);

	}
}catch(Exception e)
{
		e.printStackTrace();
}
finally
{		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(from));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(to));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(resePatCategory));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(reseCategoryFact));
            _bw.write(_wl_block53Bytes, _wl_block53);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TaskForResponsibilityRelationship.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
}
