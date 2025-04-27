package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import com.ehis.util.*;
import eFM.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmchfileretdateresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMChFileRetDateResult.jsp", 1726141453525L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tPrakash.S\n\tCreated on \t\t:\t01/07/2002\n\tModule\t\t\t:\tFM - File Storage Location for Bed.\n\tFunction\t\t:\tThis function is used split into three frame structure.\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html> \n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMChFileRetDate.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onMouseDown=\'CodeArrest()\' onLoad=\'document.forms[0].return_date_time.focus()\' onKeyDown = \'lockKey();\'>\n<center>\n<form name=\'FMChFileRetDateResultFrame\' id=\'FMChFileRetDateResultFrame\'>\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\n<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'curr_file_status\' id=\'curr_file_status\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' size=\'30\'  disabled > </td>\n<!-- </tr>\n<tr> -->\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'curr_fs_locn_desc\' id=\'curr_fs_locn_desc\'\n\tvalue=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" (";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\' size =\'30\' maxlength=\'45\' disabled ><input type=\'hidden\' name=\'curr_fs_locn_code\' id=\'curr_fs_locn_code\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'><font size=1>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></td>\n</tr>\n<tr>\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'fields\' ><input type=\'text\' name=\'curr_holder_name\' id=\'curr_holder_name\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' size=\'30\' disabled ></td>\n<!-- </tr>\n<tr> -->\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td class=\'fields\' ><input type=\'text\' name=\'iss_date_time\' id=\'iss_date_time\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' size=\'16\' disabled></td>\n</tr>\n<tr>\n\t<!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763-->\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td class=\'fields\' ><input type=\'text\' id =\'returndatetime\' name=\'return_date_time\' id=\'return_date_time\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' size=\'16\' maxlength=\'16\' onBlur=\'validDateObj(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\");";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="holidayvalidation(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\",\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'returndatetime\', null, \'hh:mm\');\"><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t<td class=\'fields\' colspan=\'2\' ><textarea style=\'resize:none\'; rows=\'3\' cols=\'35\' name=\'remarks\'  onkeypress=\"checkMaxLimit(this,100)\" onBlur=\"makeValidString(this);CheckMaxLen(\'Remarks\',this,100,parent.parent.frames[2])\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</textarea></td>\n\t<td class=\'label\' >&nbsp;</td>\n</tr>\n<input type=\'hidden\' name=\'file_no\' id=\'file_no\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'volume_no\' id=\'volume_no\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'localeName\' id=\'localeName\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'> <!-- Added for this CRF HSA-CRF-0306.1 -->\n<input type=\'hidden\' name=\'return_date_time_defaulted\' id=\'return_date_time_defaulted\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'> <!-- Added for this CRF HSA-CRF-0306.1 -->\n<input type=\'hidden\' name=\'isCurrentFsLocation\' id=\'isCurrentFsLocation\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'> <!-- Added for this CRF HSA-CRF-0306.1 --> \n<input type=\'hidden\' name=\'current_fs_locn_code\' id=\'current_fs_locn_code\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>  <!-- Added for this CRF HSA-CRF-0306.1 --> \n<input type=\'hidden\' name=\'curr_locn_id\' id=\'curr_locn_id\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'> \n</table>\n</form>\n</center>\n</body>\n</html>\n<script>\n\tparent.frames[0].document.forms[0].p_curr_fs_loc.disabled=true;\n\tparent.frames[0].document.forms[0].patient_id.disabled=true;\n\tparent.frames[0].document.forms[0].pat_search.disabled=true;\n\tif(parent.frames[0].document.forms[0].file_no != null)\n\t\tparent.frames[0].document.forms[0].file_no.disabled=true;\n\tif(parent.frames[0].document.forms[0].file_type_code != null)\n\t\tparent.frames[0].document.forms[0].file_type_code.disabled=true;\n\tparent.frames[0].document.forms[0].reset1.disabled=false;\n\tparent.frames[0].document.forms[0].search_dtl.disabled=false;\n\tparent.frames[0].document.forms[0].pat_search.disabled=false;\n\tparent.frames[0].document.forms[0].p_curr_fs_loc.disabled=false;\n</script>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<script>\n\t\t\t\tvar msg = getMessage(\'FILE_RET_DATE_NOT_CHANGE\',\'FM\');\n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].reset1.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].search_dtl.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pat_search.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].p_curr_fs_loc.disabled=false;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<script>\n\t\t\t\tvar msg = getMessage(\'FILE_IS_LOST\',\'FM\');\n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].reset1.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].search_dtl.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].pat_search.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].p_curr_fs_loc.disabled=false;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con				=	null;
java.sql.Statement stmt		=	null;
PreparedStatement pstmt		=	null;
ResultSet rs				=	null;
ResultSet prs				=	null;

//Added for this CRF HSA-CRF-0306.1
PreparedStatement pstmt1 = null;
ResultSet rset = null;
StringBuffer query_result = null;

String str					 = "";
String facility_id			 = "";
String curr_file_status      = "";
String curr_fs_locn_code     = "";
String curr_fs_locn_identity = "";
String short_desc            = "";
String login_user            = "";
String user_id               = "";
String curr_holder_name      = "";
String iss_date_time		 = "", return_date_time = "";
String user_security_yn      = "N";
String remarks				 = "", file_no = "", curr_facility_name = ""; 
String volume_no			 = "", sys_date = "";
String p_access_all			 = "";
String curr_file_status_old="";
String patient_id="";
String  volume_no1="";
String filenum="";
String str1="";
String curr_file_status1="";
String current_fs_location=""; //Added for this CRF HSA-CRF-0306.1
boolean isCurrentFsLocation=false;//Added for this CRF HSA-CRF-0306.1
String curr_locn_id="";//Added for this CRF HSA-CRF-0306.1
try
{
	con		= ConnectionManager.getConnection(request);
	
	isCurrentFsLocation = CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306.1
	
	stmt	= con.createStatement();

	query_result	= new StringBuffer();
	
	facility_id	= (String)session.getValue("facility_id");
	login_user	= (String)session.getValue("login_user");
	
	str					= request.getParameter("whereClause"); 
	user_id				= request.getParameter("user_id");
	user_security_yn	= request.getParameter("user_security_yn");
	p_access_all		= request.getParameter("p_access_all");
	sys_date			= request.getParameter("sysDate");

	patient_id			= request.getParameter("patient_id");
	volume_no1			= request.getParameter("volume_no");
	filenum			= request.getParameter("filenum");
	
	//Added for this CRF HSA-CRF-0306.1
	current_fs_location=request.getParameter("current_fs_location");
	if(current_fs_location==null || current_fs_location.equals("null"))current_fs_location="";
	
	if(patient_id == null || patient_id.equals("null")) patient_id = ""; 
	if(volume_no1 == null || volume_no1.equals("null")) volume_no1 = ""; 
	if(filenum == null || filenum.equals("null")) filenum = ""; 
	
	if(user_security_yn == null || user_security_yn.equals("null")) user_security_yn = "N"; 
	if(p_access_all == null || p_access_all.equals("null")) p_access_all = ""; 
	if(sys_date == null || sys_date.equals("null")) sys_date = ""; 
	if(str == null) str = "";

	   if(!filenum.equals(""))
     { 
      str1="select curr_file_status from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";
     
		
		pstmt	= con.prepareStatement(str1);
	rs		= pstmt.executeQuery();
	if(rs != null)
	{
		if(rs.next())
		{
	     curr_file_status1=rs.getString("curr_file_status");
		
		}
	}	
	
	}

	
  if(rs!=null)	rs.close();
  if(pstmt != null) pstmt.close();
	if(!curr_file_status1.equals("L"))
	{
	if(user_security_yn.equals("Y"))
	{
		if(p_access_all.equals("*ALL"))/*Modified by Sangeetha S on 26-SEP-2016 against ML-MMOH-SCF-0442*/
		{
			/*query_result.append("SELECT decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , decode(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name, TO_CHAR(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time, file_no,file_type_code, TO_CHAR(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks,(CASE WHEN a.curr_facility_id<>a.facility_id THEN '/ (' || curr_facility_name ||')' ELSE '' END )curr_facility_name,volume_no FROM fm_curr_locn_vw a WHERE a.facility_id = ? AND curr_file_status NOT IN ('T','L','A','R') AND  ((curr_file_status = 'I' AND mr_pat_fs_locn_code != curr_fs_locn_code ) OR (curr_file_status = 'O' ))  ");*/
			query_result.append("SELECT" );
			query_result.append("  Curr_File_Status" );
			query_result.append("  , Curr_fs_Locn_Code" );
			query_result.append("  , Curr_fs_Locn_Identity" );
			query_result.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',1) Short_desc" );
			query_result.append("  , SM_GET_DESC.SM_APPL_USER(CURR_HOLDER_USER_ID,'"+localeName+"','1') Curr_Holder_Name" );
			query_result.append("  , TO_CHAR(Iss_Date_Time,'dd/mm/yyyy hh24:mi') Iss_Date_Time" );
			query_result.append("  , File_No" );
			query_result.append("  , File_Type_Code" );
			query_result.append("  , TO_CHAR(Return_Date_Time,'dd/mm/yyyy hh24:mi') Return_Date_Time" );
			query_result.append("  , Remarks" );
			query_result.append("  , (" );
			query_result.append("  CASE " );
			query_result.append("  WHEN a.Curr_Facility_Id <> a.Facility_Id " );
			query_result.append("  THEN" );
			query_result.append("    '/ (' ||SM_GET_DESC.SM_FACILITY_PARAM(CURR_FACILITY_ID,'"+localeName+"','1') ||')' " );
			query_result.append("  ELSE '' " );
			query_result.append("  END) Curr_Facility_Name" );
			query_result.append("  , Volume_No ,curr_locn_id " );
			query_result.append("FROM" );
			query_result.append("  fm_Curr_Locn a " );
			query_result.append("WHERE a.Facility_Id = ? " );
			query_result.append("  AND Curr_File_Status NOT IN ('T', 'A', 'R') " );
			query_result.append("  AND " );
			query_result.append("  (" );
			query_result.append("    " );
			query_result.append("    (" );
		//	query_result.append("      Curr_File_Status IN( 'I','L') " );
			query_result.append("      Curr_File_Status IN('L') " );
			query_result.append("      AND PERM_FS_LOCN_CODE != Curr_fs_Locn_Code" );
			query_result.append("    ) " );
			query_result.append("  OR " );
			query_result.append("    (" );
			query_result.append("      Curr_File_Status = 'O'" );
			query_result.append("    )" );
			query_result.append("  )" );
			query_result.append(str);
			//out.println(query_result.toString());
			pstmt	= con.prepareStatement(query_result.toString());
						
			pstmt.setString(1,facility_id);
		}
		else
		{
			//query_result.append("SELECT decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , decode(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name, to_char(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time,file_no,file_type_code, to_char(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks,(CASE WHEN a.curr_facility_id<>a.facility_id THEN '/ (' || curr_facility_name ||')' ELSE '' END )curr_facility_name,volume_no FROM fm_curr_locn_vw a, fm_user_access_rights d WHERE return_date_time is not null and  a.facility_id = ? and curr_file_status NOT IN ('T','L','A','R') AND  ((curr_file_status = 'I' AND mr_pat_fs_locn_code != curr_fs_locn_code ) OR (curr_file_status = 'O' )) AND a.facility_id=d.facility_id AND a.mr_pat_fs_locn_code=d.fs_locn_code AND d.change_return_date_yn='Y' AND d.appl_user_id = ? ");
			query_result.append("SELECT" );
			query_result.append("  Curr_File_Status" );
			query_result.append("  , Curr_fs_Locn_Code" );
			query_result.append("  , Curr_fs_Locn_Identity" );
			query_result.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',1) Short_desc" );
			query_result.append("  , SM_GET_DESC.SM_APPL_USER(CURR_HOLDER_USER_ID,'"+localeName+"','1') Curr_Holder_Name" );
			query_result.append("  , TO_CHAR(Iss_Date_Time,'dd/mm/yyyy hh24:mi') Iss_Date_Time" );
			query_result.append("  , File_No" );
			query_result.append("  , File_Type_Code" );
			query_result.append("  , TO_CHAR(Return_Date_Time,'dd/mm/yyyy hh24:mi') Return_Date_Time" );
			query_result.append("  , Remarks" );
			query_result.append("  , (" );
			query_result.append("  CASE " );
			query_result.append("  WHEN a.Curr_Facility_Id <> a.Facility_Id " );
			query_result.append("  THEN" );
			query_result.append("    '/ (' ||SM_GET_DESC.SM_FACILITY_PARAM(CURR_FACILITY_ID,'"+localeName+"','1') ||')' " );
			query_result.append("  ELSE '' " );
			query_result.append("  END) Curr_Facility_Name" );
			query_result.append("  , Volume_No ,curr_locn_id " );
			query_result.append("FROM" );
			query_result.append("  fm_Curr_Locn a" );
			query_result.append("  , fm_User_Access_Rights d " );
			query_result.append("WHERE" );/*Modified by Sangeetha S on 26-SEP-2016 against ML-MMOH-SCF-0442*/
//			query_result.append("WHERE Return_Date_Time IS" );
//			query_result.append("  NOT NULL " );
			query_result.append("  a.Facility_Id = ? " );
			query_result.append("  AND Curr_File_Status NOT IN ('T','A', 'R') " );
			query_result.append("  AND " );
			query_result.append("  (" );
			query_result.append("    " );
			query_result.append("    (" );
			//query_result.append("      Curr_File_Status IN( 'I','L') " );
			query_result.append("      Curr_File_Status IN('L') " );
			query_result.append("      AND PERM_FS_LOCN_CODE != Curr_fs_Locn_Code" );
			query_result.append("    ) " );
			query_result.append("  OR " );
			query_result.append("    (" );
			query_result.append("      Curr_File_Status = 'O'" );
			query_result.append("    )" );
			query_result.append("  ) " );
			query_result.append("  AND a.Facility_Id = d.Facility_Id " );
		//	query_result.append("  AND a.PERM_FS_LOCN_CODE = d.fs_Locn_Code " );
			query_result.append("  AND d.Change_Return_Date_yn = 'Y' " );
			query_result.append("  AND d.apPl_User_Id = ?" );

			query_result.append(str);
			
			if(pstmt != null) pstmt.close();
			pstmt	= con.prepareStatement(query_result.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,login_user);
		}
	}
	else if(user_security_yn.equals("N"))
	{
		//query_result.append("SELECT decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , DECODE(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit') curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name,file_no,file_type_code, to_char(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time, to_char(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks, file_no,(CASE WHEN curr_facility_id<>facility_id THEN '/ (' || curr_facility_name ||')' ELSE '' END )curr_facility_name,volume_no FROM fm_curr_locn_vw  WHERE return_date_time IS NOT NULL AND  facility_id = ? AND curr_file_status NOT IN ('T','L','A','R') AND  ((curr_file_status = 'I' AND mr_pat_fs_locn_code != curr_fs_locn_code) OR (curr_file_status = 'O' and mr_pat_fs_locn_code !=  curr_fs_locn_code)) ");

		query_result.append("SELECT" );
		query_result.append("  Curr_File_Status" );
		query_result.append("  , Curr_fs_Locn_Code" );
		query_result.append("  , Curr_fs_Locn_Identity" );
		query_result.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',1) Short_desc" );
		query_result.append("  , SM_GET_DESC.SM_APPL_USER(CURR_HOLDER_USER_ID,'"+localeName+"','1') Curr_Holder_Name" );
		query_result.append("  , File_No" );
		query_result.append("  , File_Type_Code" );
		query_result.append("  , TO_CHAR(Iss_Date_Time,'dd/mm/yyyy hh24:mi') Iss_Date_Time" );
		query_result.append("  , TO_CHAR(Return_Date_Time,'dd/mm/yyyy hh24:mi') Return_Date_Time" );
		query_result.append("  , Remarks" );
		query_result.append("  , File_No" );
		query_result.append("  , (" );
		query_result.append("  CASE " );
		query_result.append("  WHEN Curr_Facility_Id <> Facility_Id " );
		query_result.append("  THEN" );
		query_result.append("    '/ (' ||SM_GET_DESC.SM_FACILITY_PARAM(CURR_FACILITY_ID,'"+localeName+"','1') ||')' " );
		query_result.append("  ELSE '' " );
		query_result.append("  END) Curr_Facility_Name" );
		query_result.append("  , Volume_No ,curr_locn_id " );
		query_result.append("FROM" );
		query_result.append("  fm_Curr_Locn " );
		query_result.append("WHERE" );/*Modified by Sangeetha S on 26-SEP-2016 against ML-MMOH-SCF-0442*/
	//	query_result.append("WHERE Return_Date_Time IS" );
	//	query_result.append("  NOT NULL " );
		query_result.append("  Facility_Id = ? " );
		query_result.append("  AND Curr_File_Status NOT IN ('T','A', 'R') " );
		query_result.append("  AND " );
		query_result.append("  (" );
		query_result.append("    " );
		query_result.append("    (" );
		//query_result.append("      Curr_File_Status IN ( 'I','L') " );
		query_result.append("      Curr_File_Status IN ('L') " );
		query_result.append("      AND PERM_FS_LOCN_CODE != Curr_fs_Locn_Code" );
		query_result.append("    ) " );
		query_result.append("  OR " );
		query_result.append("    (" );
		query_result.append("      Curr_File_Status = 'O' " );
		query_result.append("      AND PERM_FS_LOCN_CODE != Curr_fs_Locn_Code" );
		query_result.append("    )" );
		query_result.append("  )" );

		query_result.append(str);
		
		if(pstmt != null) pstmt.close();
		pstmt	= con.prepareStatement(query_result.toString());
		pstmt.setString(1,facility_id);
	}
	
	System.out.println(" ********************* Inside FMChFileRetDateResult 279 query_result : "+query_result);
	prs		= pstmt.executeQuery();
	if(prs != null)
	{
		if(prs.next())
		{
			curr_file_status		=	prs.getString("curr_file_status");
			curr_fs_locn_code		=	prs.getString("curr_fs_locn_code");
			curr_fs_locn_identity	=	prs.getString("curr_fs_locn_identity");
			short_desc				=	prs.getString("short_desc");
			curr_holder_name		=	prs.getString("curr_holder_name");
			iss_date_time			=	prs.getString("iss_date_time");
			return_date_time		=	prs.getString("return_date_time");
			remarks					=	prs.getString("remarks");
			file_no					=	prs.getString("file_no");
			curr_facility_name		=	prs.getString("curr_facility_name");
			volume_no		        =	prs.getString("volume_no");
			curr_locn_id            =	prs.getString("curr_locn_id"); //Added for this CRF HSA-CRF-0306.1
			
			if(curr_locn_id==null || curr_locn_id.equals("null")) curr_locn_id=""; //Added for this CRF HSA-CRF-0306.1
			
			if(curr_file_status == null || curr_file_status.equals("null")) curr_file_status="";
			if(curr_fs_locn_code == null || curr_fs_locn_code.equals("null")) curr_fs_locn_code="";
			if(curr_fs_locn_identity == null || curr_fs_locn_identity.equals("null")) curr_fs_locn_identity="";
			if(short_desc == null || short_desc.equals("null")) short_desc="";
			if(curr_holder_name == null || curr_holder_name.equals("null")) curr_holder_name="";
		curr_file_status_old=curr_file_status;
			if(iss_date_time != null)
			{
				iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName);
			}
			else
				iss_date_time="";


			if(return_date_time != null)
			{
				return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
			}
			else
				return_date_time="";
			if(remarks == null || remarks.equals("null")) remarks="";
			if(curr_facility_name == null || curr_facility_name.equals("null")) curr_facility_name="";

			if(!curr_fs_locn_identity.equals(""))
		{
			switch(curr_fs_locn_identity.charAt(0))
			{
				case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}

		if(!curr_file_status.equals(""))
		{
			switch(curr_file_status.charAt(0))
			{
				case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

				case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

				case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

				case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

				case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;
		
			}
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_file_status));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(curr_fs_locn_identity));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(curr_fs_locn_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_facility_name));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(curr_holder_name));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(iss_date_time));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(return_date_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(isCurrentFsLocation){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(current_fs_location));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(return_date_time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(isCurrentFsLocation));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(curr_fs_locn_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(curr_locn_id));
            _bw.write(_wl_block36Bytes, _wl_block36);

			

}
		else
		{
			
            _bw.write(_wl_block37Bytes, _wl_block37);

		}
	
	
	}
	if((query_result != null) && (query_result.length() > 0))
	{
		query_result.delete(0,query_result.length());
	}
	
	}else{
   
	
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
	
	if(rs!=null)	rs.close();
	if(prs!=null)	prs.close();
	if(stmt!= null) stmt.close();
	if(pstmt!= null)pstmt.close();
}catch(Exception e){out.println("Exception e :"+e);}
finally
{	
	ConnectionManager.returnConnection(con, request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileStatus.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSLocation.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.HolderName.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.IssueDateTime.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnDueDateTime.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
