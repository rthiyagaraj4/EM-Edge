package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __repwehuaddiagnosisqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/repWEHUADDiagnosisQueryResult.jsp", 1709119083457L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\n\t<script src=\'../js/rowcolor.js\' language=\'javascript\'></script>\n\t\n\t\t\n\t<script src=\'../../eMR/js/MRReports.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n</head>\n<script>\n\n\n\nsrl_no_array = new Array();\nvar prev=1;\nvar i=0;\nvar prev1=0;\nvar j=0;\n\n\n</script>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n<form name=\'query_form\' id=\'query_form\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eMR.RepWEHUADDiagServlet\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<center>\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n\t\t<tr>\n\t\t\t<td>\t\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<table border=\"1\" width=\'100%\' id=\'dataTitleTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'>\n\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n                <tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>&nbsp</td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t\t<th align=\'center\' width=\'10%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t<th align=\'center\' width=\'10%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t<th align=\'center\' width=\'35%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t<th align=\'center\' width=\'20%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'14\' class=\'CAGROUPHEADING\' align=\'left\'><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\'14\' class=\'CAGROUPHEADING\' align=\'left\'><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n\t\t\t\t\t<script>\n\t\t\t\t\tsrl_no_array[i] = null;\n\t\t\t\t\ti++;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<tr style=\'background-color:;\'><td align=\"center\" class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' ><a name=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'  href=javascript:submitFormrepWEHUADiagQRes(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'> <a name=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</a></td>\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' align=\"center\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td><input type=\"hidden\" name=\'diag_desc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'diag_desc";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"><input type=\"hidden\" name=\'onset_dt";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'onset_dt";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t<script>\n\t\t\t\t\t\tsrl_no_array[i] = ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\ti++;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n</table>\n</center>\n\n<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"PatientId\" id=\"PatientId\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\"diag_code\" id=\"diag_code\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"recordNo\" id=\"recordNo\" value=\"\"> \n<input type=\"hidden\" name=\"NumRecords\" id=\"NumRecords\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\"hidden\" name=\"recode_count\" id=\"recode_count\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

/**
	MODULE			:	Medical Records..(MR)
	Function Name	:	WEHU - A1 / A2 && WEHU - D1 / D2
	Developer		:	SRIDHAR R
	Created On		:	10 JAN 2005
**/

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId		= (String) session.getValue("facility_id");
	String PatientId		= request.getParameter("PatientId");
    String Encounter_Id     = request.getParameter("Encounter_Id");
	int j=1;
		
	String call_function	= request.getParameter("call_function");	

    //String scheme       ="";
   // String scheme_desc  ="";
	String significant_yn = "";
	significant_yn			=	request.getParameter("significant_yn");
	if(significant_yn==null) significant_yn = "N";
    int k=1;
    int aname=2;
    String classValue = "";
	String diag_type="", temp="";

	/*String sql_1="select diag_code_scheme scheme,decode(diag_code_scheme,'1','ICD 10','2','ICD 9CM','5','READ')scheme_desc from mr_parameter";*/


            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

        Connection conn 	= null; 
        PreparedStatement  pstmt = null;
        ResultSet  rs		= null;
        //Statement  stmt_1	= null;
        //ResultSet  rs_1		= null;
		
		Statement  recode_count_stmt	= null;
        ResultSet  recode_count_rs		= null;
		Statement  recode_stmt	= null;

		int recode_count	= 0;
        int maxRecord 		= 0;
		String diag_code			= "";
		//String diag_code_scheme_desc= "";
		//String DIAG_CODE_SCHEME		= "";


/// Added by SRIDHAR R on 8 Oct 2004...
/// This will execute if the function is Diagnosis Recoding & will display the values to the user in the update mode.. if records already exists in mr_diag_recoding...

		//String added_date			= "";
		//String added_by_id			= "";

try
{
	conn = ConnectionManager.getConnection(request);

	String recode_count_sql = " SELECT COUNT (*) FROM mr_diag_recoding WHERE onset_facility_id = '"+facilityId+"' AND onset_encounter_id = '"+Encounter_Id+"' ";
	recode_count_stmt	= conn.createStatement();
	recode_count_rs		= recode_count_stmt.executeQuery(recode_count_sql);
	if(recode_count_rs.next())
	{
		recode_count = recode_count_rs.getInt(1);
	}

	if(recode_count_stmt!=null)	recode_count_stmt.close();
	if(recode_count_rs!=null)	recode_count_rs.close();
	
	/*stmt_1=conn.createStatement();
	rs_1=stmt_1.executeQuery(sql_1);
	if(rs_1.next())
	{
		//scheme      = rs_1.getString("scheme");
		//scheme_desc = rs_1.getString("scheme_desc");
	}

	if(rs_1 !=null) rs_1.close();
	if(stmt_1!=null) stmt_1.close();
*/
	String strsql = "";
	
	strsql = "select count(1) from pr_problem_vw where patient_Id = ? and onset_encounter_id = ?  and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N' and close_date is null ";
	
	pstmt	=	conn.prepareStatement(strsql);
	pstmt.setString(1,PatientId);
	pstmt.setString(2,Encounter_Id);
	rs = pstmt.executeQuery();
	if(rs.next())
	  maxRecord = rs.getInt(1);

	if (maxRecord==0)
	{			
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.window.close();</script>");
	}

	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();

	StringBuffer  sql = new StringBuffer();
	sql.append("");

	if(recode_count == 0)
	{
		sql.append("select DIAG_CODE_SCHEME,srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc,ONSET_PRACTITIONER_NAME, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null  ");
	}


	if(recode_count == 0)
	{
		sql.append(" order by diagtype, onset_date desc ");
	}

	if(recode_count == 0)
	{
		String sql1 = sql.toString();
		pstmt	=	conn.prepareStatement(sql1);
		pstmt.setString(1,PatientId);
		pstmt.setString(2,Encounter_Id);
		rs = pstmt.executeQuery();
	}

	if(recode_count > 0)
	{
		String recode_sql = " SELECT a.added_by_id, TO_CHAR (a.added_date, 'dd/mm/yyyy') added_date, decode(b.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, TO_CHAR (b.onset_date, 'dd/mm/yyyy') onset_date1, b.DIAG_DESC diag_desc, a.orig_diag_code, b.diag_code diag_code, a.orig_diag_code_scheme DIAG_CODE_SCHEME, b.primary_yn, b.significant_yn significant_yn, TO_CHAR(b.onset_recorded_date, 'dd/mm/yyyy') onset_recorded_date, b.onset_practitioner_id ONSET_PRACTITIONER_NAME, a.recoded_diag_desc , a.recoded_diag_code, a.RECODED_REMARKS recoded_remarks, nvl(b.PRIMARY_YN,'N') primary_diag, b.diag_code||nvl2(b.cause_indicator,'/'||b.CAUSE_INDICATOR,null)diag_code_desc, b.diag_code_scheme_desc, b.srl_no srl_no, b.sensitive_yn sensitive_yn FROM MR_DIAG_RECODING_VW a, PR_PROBLEM_VW b WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+Encounter_Id+"' AND a.patient_id = b.patient_id AND a.srl_no = b.srl_no ORDER BY b.diag_type " ;
		if(rs != null) rs.close();
		recode_stmt	= conn.createStatement();
		rs	= recode_stmt.executeQuery(recode_sql);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block12Bytes, _wl_block12);
	if(rs == null)
		{
            for (int x=0; x<6 ; x++)
            {
                if ( k%2 == 0 )
                    classValue = "QRYEVEN" ;
                else
	                classValue = "QRYODD" ;
				
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
  k++;
            }
        }
        else
        {	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
	
			String onset_date		= "";
			String diag_desc		= "";
			String srl_no			= "";
			String sensitive_yn		= "";
			String Recorded_by		= "";
			String recorded_date	= "";

			while(rs.next())
			{
				/*if(recode_count > 0)
				{
					//added_by_id = checkForNull(rs.getString("added_by_id"));
					added_date	= checkForNull(rs.getString("added_date"));
				}*/

				//DIAG_CODE_SCHEME	=	rs.getString("DIAG_CODE_SCHEME");
				onset_date		=	rs.getString("onset_date1");
				Recorded_by		=	checkForNull(rs.getString("ONSET_PRACTITIONER_NAME"));
				recorded_date	=	checkForNull(rs.getString("onset_recorded_date"));
				diag_desc		=	checkForNull(rs.getString("diag_desc"));
				diag_code		=	checkForNull(rs.getString("diag_code"));
				diag_type		=	rs.getString("diagtype");
					if(diag_type == null)	diag_type ="";
				//diag_code_scheme_desc=	rs.getString("diag_code_scheme_desc");
				srl_no 			= 	rs.getString("srl_no");
				sensitive_yn	=	rs.getString("sensitive_yn");
		
				significant_yn	=	rs.getString("significant_yn");
				if(significant_yn==null)	significant_yn  = "N";
				if(diag_code==null)			diag_code		= "&nbsp;";
				if(sensitive_yn!=null)
				{
				   if(sensitive_yn.equals("Y"))
						classValue="PATQRED";
				}
				if(significant_yn.equals("Y"))
				{
					classValue="SIGNIFICANT";
				}
				
				if ((!(diag_type.equals(temp))))
				{
					if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
					{	
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(diag_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}else 
					{	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(diag_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
				temp=diag_type;

				if ( k%2 == 0 )
					classValue = "QRYEVEN" ;
				 else
					classValue = "QRYODD" ;					

			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(aname));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(aname));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Recorded_by));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recorded_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(k));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(k));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(k));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(k));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block44Bytes, _wl_block44);
	

				out.println("<input type='hidden' name='srl_no"+k+"' id='srl_no"+k+"' value='"+srl_no+"'></td>");
				out.println("</tr>");
				
				
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
	k++;
					j++;
			}
				if(rs!=null)    rs.close();
				if(recode_stmt != null) recode_stmt.close();
		}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recode_count));
            _bw.write(_wl_block54Bytes, _wl_block54);

}catch(Exception e)
{
	//out.print("ERROR in repWEHUADDiagnosisQueryResult.jsp : "+e);
	e.printStackTrace();
}
finally
{
	try
	{
	if(pstmt!=null)  pstmt.close();
	}
	catch(Exception e)
	{
	}
	ConnectionManager.returnConnection(conn, request);
}

            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.recordeddate.label", java.lang.String .class,"key"));
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
