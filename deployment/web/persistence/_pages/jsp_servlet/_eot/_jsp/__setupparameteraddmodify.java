package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __setupparameteraddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SetUpParameterAddModify.jsp", 1709120348000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../../eOT/js/SetUpParameter.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\"SetUpParameterForm\" id=\"SetUpParameterForm\"  onload=\'FocusFirstElement()\'  action=\"../../servlet/eOT.SetUpParameterServlet\" method=\"post\" target=\"messageFrame\"> \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<br><br><br><br><br><br><br><br><br>\n<table border=0 cellspacing=0 cellpadding=3 width=\'80%\'  align=center>\n<tr>\n\t<td width=\'35%\'></td>\n\t<td width=\'65%\'></td>\n</tr>\n   \n<tr> \n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t  <td class=\'label\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t  </td>\n\t\t  <td class=\'fields\'>\n\t\t  <select name=\"oper_code_scheme\" id=\"oper_code_scheme\" >  \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' > ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="  </option>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\n\t\t  </select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\n\t\t  <td class=\'label\'nowrap>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t</td>\n\t\t  <input type=\"hidden\" name=\"oper_code_scheme1\" id=\"oper_code_scheme1\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t  <td> \n\t\t\t<select name=\"oper_code_scheme\" id=\"oper_code_scheme\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n    ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\t\t\t \n</tr> \n\n<tr> \n \t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\t\t</td>\n\t\t  <td>\n\t\t\t\t<select name=\"diag_code_scheme\" id=\"diag_code_scheme\" > \t\t\t  \n\t    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t  </select>\n\t\t\t  </td>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t  <td class=\'label\' nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\t\t   </td>\n\t\t  <td> <select name=\"diag_code_scheme\" id=\"diag_code_scheme\">\n\t\t     \t    ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</select>\n\t\t\t  \n\t\t </td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</tr> \n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<tr>\n\t<td class=label nowrap>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</td>\n\t<td class=\'fields\'>\n\t\t<input type=\"checkbox\" name=\"oper_num_date_prefix_yn\" id=\"oper_num_date_prefix_yn\" disabled value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t</td>\n\t<td class=\'fields\'>\n\t\t<input type=\"checkbox\" name=\"oper_num_date_prefix_yn\" id=\"oper_num_date_prefix_yn\" onClick=\'setCheckValue();\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" >\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t</td>\n\t<td align=\'left\' nowrap>\n\t\t\n\t\t<input type=\'text\' name=\'operative_records_note_type_desc\' id=\'operative_records_note_type_desc\' size=\'30\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"  onBlur=\"if(this.value!=\'\')searchOperativeRecordNoteType(operative_records_note_type,operative_records_note_type_desc); else operative_records_note_type.value=\'\'\"> \n\t\t<input type=\'hidden\' name=\'operative_records_note_type\' id=\'operative_records_note_type\'  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'notetypelkp\' id=\'notetypelkp\' onClick=\"searchOperativeRecordNoteType(operative_records_note_type,operative_records_note_type_desc);\" >\n\n\t</td>\n\n</tr>\n<tr> \n\t<td class=label nowrap>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t</td>\n\t<td class=\'fields\'>\n\t\t<input type=\"checkbox\" name=\"build_anaesthesia_into_cr_yn\" id=\"build_anaesthesia_into_cr_yn\" onClick=\'setCheckValue1();\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >\n\t</td>\n</tr>\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V & IN050472-->\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n<tr> \n\t<td class=label nowrap>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t</td>\n\t<td class=\'fields\'>\n\t\t<input type=\"checkbox\" name=\"schedule_restrict_yn\" id=\"schedule_restrict_yn\" onClick=\'setCheckValueSlots();\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V & IN050472 -->\n  <tr>\n\t<td width=\'35%\'></td>\n\t<td width=\'65%\'></td>\n</tr>\n</table>\n<input type=\"hidden\" name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\"hidden\" name=\"tot_records\" id=\"tot_records\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\"hidden\" name=\"oper_num_date_prefix_yn_dup\" id=\"oper_num_date_prefix_yn_dup\" value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" >\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con=null;
PreparedStatement stmt=null;
PreparedStatement icd_stmt=null;
ResultSet rs=null;
ResultSet icd_rs=null;
String mode=request.getParameter("mode");
String chk_checked="";
String chk_value="N";
String chk_checked1="";
String chk_value1="N";
//CRF-004 Authorize Slots for Booking - Rajesh V
String checkedYnSlots = "";
String chkValueSlots = "N";
String scheduleRestrictYn = "";
//CRF-004 Authorize Slots for Booking - Rajesh V
String disable_flag="";
String diag_code_scheme="";
String oper_code_scheme_db = "";
String oper_num_date_prefix_yn="";
String operative_records_note_type = "";    
String note_type = "";
String note_type_desc = "";
String build_anaesthesia_into_cr_yn="";
String sql="";
String mr_term_code="";
String mr_term_desc="";
String diag_code_desc="";
//Added for BRU-CRF-004 Starts & IN050472
PreparedStatement pstmt=null;
String customer_id="";
String sql_sm_cust="select customer_id from SM_SITE_PARAM where rownum = 1";
//Added for BRU-CRF-004 Ends & IN050472
int total_records=0;

	try{
		con=ConnectionManager.getConnection(request);
		sql=" Select count(*) as total_records_existing from OT_PARAM";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
	    rs.next();
		
		total_records=rs.getInt(1);
			
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}

		if(total_records==1)
		{
		   mode="modify";
		   disable_flag="disabled";
		}
		else
		{
		   mode="insert";
		   disable_flag="";
		}

		if(mode.equals("modify"))
{

	try{
		con=ConnectionManager.getConnection(request);
		//CRF-004 Authorize Slots for Booking - Rajesh V
		//Added for site specific IN050472
			pstmt=con.prepareStatement(sql_sm_cust); 
			rs=pstmt.executeQuery();
			if(rs !=null && rs.next())
			{
			customer_id=checkForNull(rs.getString("customer_id"));
			}	
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		//Added for site specific IN050472
		sql="Select A.OPER_CODE_SCHEME, NVL(A.OPER_NUM_DATE_PREFIX_YN, 'N') OPER_NUM_DATE_PREFIX_YN , A.DIAG_CODE_SCHEME,    A.OPERATIVE_RECORDS_NOTE_TYPE, NVL(B.NOTE_TYPE,'') NOTE_TYPE, A.BUILD_ANAESTHESIA_INTO_CR_YN, GET_DESC(?,'MR_TERM_SET_LANG_VW','TERM_SET_DESC','TERM_SET_ID',A.OPER_CODE_SCHEME) DIAG_CODE_DESC, A.SCHEDULE_RESTRICT_YN  from OT_PARAM A, CA_NOTE_TYPE B WHERE A.OPERATIVE_RECORDS_NOTE_TYPE = B.NOTE_TYPE(+)";
		//CRF-004 Authorize Slots for Booking - Rajesh V
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();

		if(rs!=null && rs.next())
		{

			oper_code_scheme_db=rs.getString("OPER_CODE_SCHEME");
			oper_num_date_prefix_yn=rs.getString("OPER_NUM_DATE_PREFIX_YN");
			diag_code_scheme=checkForNull(rs.getString("DIAG_CODE_SCHEME"));
			operative_records_note_type=rs.getString("OPERATIVE_RECORDS_NOTE_TYPE");			
			//note_type_desc=rs.getString("NOTE_TYPE_DESC");
			note_type=rs.getString("NOTE_TYPE");
			build_anaesthesia_into_cr_yn=checkForNull(rs.getString("BUILD_ANAESTHESIA_INTO_CR_YN"));
			diag_code_desc=checkForNull(rs.getString("DIAG_CODE_DESC"));
			//CRF-004 Authorize Slots for Booking - Rajesh V
			scheduleRestrictYn = checkForNull(rs.getString("SCHEDULE_RESTRICT_YN"));
			//CRF-004 Authorize Slots for Booking - Rajesh V
		}
		if(note_type!=null && !note_type.equals("")){
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

			sql="Select NOTE_TYPE_DESC from CA_NOTE_TYPE_LANG_VW WHERE LANGUAGE_ID = ? AND NOTE_TYPE=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,locale);
			stmt.setString(2,note_type);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				note_type_desc=rs.getString("NOTE_TYPE_DESC");
			}
		}
		if(oper_num_date_prefix_yn.equals("Y"))
		{
			chk_checked="checked";
			chk_value = "Y";
		}
		else
		{
			chk_checked="";
			chk_value = "N";
		}

		if(build_anaesthesia_into_cr_yn.equals("Y"))
		{
			chk_checked1="checked";
			chk_value1 = "Y";
		}
		else
		{
			chk_checked1="";
			chk_value1 = "N";
		}

		if (note_type_desc==null) {
		  note_type_desc = "";
		}

		//CRF-004 Authorize Slots for Booking - Rajesh V
		if(scheduleRestrictYn.equals("Y"))
		{
			checkedYnSlots="checked";
			chkValueSlots = "Y";
		}
		else
		{
			checkedYnSlots="";
			chkValueSlots = "N";
		}
		//CRF-004 Authorize Slots for Booking - Rajesh V
		
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		//out.println(note_type);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
}


            _bw.write(_wl_block8Bytes, _wl_block8);

	if((mode.equals("insert")) || total_records==0){
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	  	try{
		//Newly added by rajesh for CRF 303.1
		con=ConnectionManager.getConnection(request);
		/*Commented by Suma as told by Dilip to show more coding scheme's*/

		//String icd_sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND EFF_STATUS='E'";	

		String icd_sql="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4') AND PROC_SPEC_YN  ='Y' and A.eff_status='E' AND LANGUAGE_ID = ? union SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('OTH') AND PROC_SPEC_YN  ='Y'  AND LANGUAGE_ID = ? " ;
		icd_stmt=con.prepareStatement(icd_sql);
		icd_stmt.setString(1,locale);
		icd_stmt.setString(2,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mr_term_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mr_term_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
	}catch(Exception e){
		e.printStackTrace();
		//out.println("Exception in SetupPrameterAddModify.jsp : "+e);
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception in SetupPrameterAddModify.jsp MR Term CSet List Item "+e);
		}		
	}


            _bw.write(_wl_block14Bytes, _wl_block14);
 }else if (mode.equals("modify"))	{
		
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oper_code_scheme_db));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);

	  	try{
		//Newly added by rajesh for CRF 303.1
		con=ConnectionManager.getConnection(request);
		
		/*Commented by Suma as told by Dilip to show more coding scheme's*/

		//String icd_sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and term_set_id in('ICD10PCS','ICD9CMP','CPT4','OTH')";	

		String icd_sql="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4') AND PROC_SPEC_YN  ='Y' and A.eff_status='E' AND LANGUAGE_ID = ? union SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('OTH') AND PROC_SPEC_YN  ='Y'  AND LANGUAGE_ID = ? " ;

		icd_stmt=con.prepareStatement(icd_sql);
		icd_stmt.setString(1,locale);
		icd_stmt.setString(2,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
			if(oper_code_scheme_db.equals(mr_term_code))
			{
				out.println("<option selected value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
			else
			{
				out.println("<option value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Exception in SetupParameterAddModify: "+e);
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception in SetupParameterAddModify.jsp MR Term CSet List Item "+e);
		}		
	}


            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block20Bytes, _wl_block20);

	if ((mode.equals("insert")) || total_records==0){
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

	  	try{
			/*Added by Suma as told by Dilip to show more coding scheme's*/

		con=ConnectionManager.getConnection(request);
		
	String icd_sql2="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4','OTH') AND DIAG_SPEC_YN  ='Y' AND LANGUAGE_ID  = ? " ;

		icd_stmt=con.prepareStatement(icd_sql2);
		icd_stmt.setString(1,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
			if(diag_code_scheme.equals(mr_term_code))
			{
				out.println("<option selected value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
			else
			{
				out.println("<option value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Exception in SetupParameterAddModify: "+e);
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception in SetupParameterAddModify.jsp MR Term CSet List Item "+e);
		}		
	}


            _bw.write(_wl_block22Bytes, _wl_block22);
 }else if (mode.equals("modify"))
	{
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

	  	try{
			/*Added by Suma as told by Dilip to show more coding scheme's*/

		con=ConnectionManager.getConnection(request);
		
	String icd_sql2="SELECT A.TERM_SET_ID,B.TERM_SET_DESC FROM MR_TERM_SET A,MR_TERM_SET_LANG_VW B WHERE A.TERM_SET_ID = B.TERM_SET_ID  AND A.TERM_SET_ID IN('ICD10TM','ICD9CM','ICD9CMD','ICD9CMP','ICD9','ICD10','ICD10PCS','CPT4','OTH') AND DIAG_SPEC_YN  ='Y' AND LANGUAGE_ID  = ? " ;

		icd_stmt=con.prepareStatement(icd_sql2);
		icd_stmt.setString(1,locale);
		icd_rs=icd_stmt.executeQuery();
		while(icd_rs.next()){
			mr_term_code=icd_rs.getString(1);
			mr_term_desc=icd_rs.getString(2);
			if(diag_code_scheme.equals(mr_term_code))
			{
				out.println("<option selected value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
			else
			{
				out.println("<option value=\""+mr_term_code+"\">"+mr_term_desc+"</option>");
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Exception in SetupParameterAddModify: "+e);
	}finally{
		try{
			if(icd_stmt!=null) icd_stmt.close();
			if(icd_rs!=null)icd_rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Exception in SetupParameterAddModify.jsp MR Term CSet List Item "+e);
		}		
	}


            _bw.write(_wl_block25Bytes, _wl_block25);
} 
            _bw.write(_wl_block26Bytes, _wl_block26);
 if (mode.equals("modify"))
{
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chk_checked));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else {
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chk_checked));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(operative_records_note_type));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(chk_value1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chk_checked1));
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(customer_id.equalsIgnoreCase("MOHBR")){
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chkValueSlots));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(checkedYnSlots));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(total_records ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chk_value));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(chk_checked));
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProcedureCodingScheme.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProcedureCodingScheme.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisCodingScheme.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisCodingScheme.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PrefixDateOperationNumber.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PrefixDateOperationNumber.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperativeRecordsNoteType.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.BuildAnaesthesiaIntoCR.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RestrictBookingYN.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
