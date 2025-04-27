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
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __diagnosisquerydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagnosisQueryDetail.jsp", 1722863571411L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\">\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\n<script src=\'../js/PatProblem.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../js/DateValidation.js\' language=\'javascript\'></SCRIPT>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCA/js/PatHighRisk.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eMR/js/MedRecRequest.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\n\n//added on 23/08/2004 for facilitating input of \'.\' in Code text field the existing function was CheckForSpecChars(event)\n\t \n//Addition ends\n\n</script>\n<form name=\'diagnosis_recode\' id=\'diagnosis_recode\'  action=\'../../servlet/eMR.DiagnosisRecodeServlet\' method=\'post\' target=\'messageFrame\'>\n</br>\n<table border=0 cellpadding=\'2\' cellspacing=\'0\' width=\"110%\">\n<tr>\n\t<td class=\"COLUMNHEADER\"colspan=\'8\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n</tr>\n<tr><td class=label colspan=4></td></tr><tr><td class=label colspan=4></td></tr>\n<tr><td class=label colspan=4></td></tr><tr><td class=label colspan=4></td></tr>\n<tr><td class=label colspan=4></td></tr><tr><td class=label colspan=4></td></tr>\n<tr>\n\t<td align=\"right\" class=\'label\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" &nbsp;</td>\n\t<td><input type=\"text\"  name=\"recode\" id=\"recode\" value=\"\"  size=15 maxlength=\'10\' onKeyPress=\"return(valid_ch(event))\" onblur=\"getDiagnosis1(this)\"><input type=\"button\" class=\'Button\' name=\"search_button\" id=\"search_button\" title=\'Search\' value=\"?\" onClick=show_window1(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\') >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\'img1\' style=\'visibility:visible\'></img>&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td align=\'left\' colspan=\'3\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td align=\"right\" class=\'label\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</td>\n\t<td colspan=4><input type=\"text\"  name=\"Recoded_Description\" id=\"Recoded_Description\" value=\"\" size=70 readonly></td>\n\t<td align=\'left\' colspan=\'4\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td align=\'right\' class=\'label\' valign=\'top\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;</td>\n\t<td colspan=\'5\'><textarea name=\"remarks\" rows=\"3\" cols=\"60\" maxlength=\'2000\'  value=\"\" ></textarea></td>\n</tr>\n<tr>\n\t<td colspan=\"3\">&nbsp;&nbsp;</td><td class=\'button\'><input type=\"button\" class=\'Button\' name=\"record\" id=\"record\" title=\'Record\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onclick=\"apply1();\" disabled><input type=\"button\" class=\'Button\' name=\"close\" id=\"close\" title=\'Close\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onClick=\"window.close();\" ></td><td>&nbsp;</td>\n</tr>\n<!-- Following lines added for proper display of scren-->\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<tr><td class=label colspan=4></td></tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<input type=\'hidden\' name=\"scheme_desc\" id=\"scheme_desc\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\'hidden\' name=\"onSet_facilityID\" id=\"onSet_facilityID\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\"hidden\" name=\"onSet_EncounterID\" id=\"onSet_EncounterID\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"Patient_Id\" id=\"Patient_Id\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=\"scheme\" id=\"scheme\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name=\"diag_code_scheme\" id=\"diag_code_scheme\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name=\"cause_indicator\" id=\"cause_indicator\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"record_type\" id=\"record_type\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"org_diag_code\" id=\"org_diag_code\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"formFields\" id=\"formFields\" value=\"\">\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<script>\n\n\t\tdocument.forms[0].recode.value\t\t\t= \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\tdocument.forms[0].recode.readOnly\t\t= true;\n\t\tdocument.forms[0].search_button.disabled= true;\n\t\tdocument.forms[0].Recoded_Description.value\t\t\t= \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\tdocument.forms[0].remarks.value\t\t\t= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\tdocument.forms[0].remarks.readOnly\t\t= true;\n\t\tdocument.forms[0].record.disabled\t\t= true;\n\t\tdocument.getElementById(\"img1\").style.visibility=\'hidden\';\n\n\t</script>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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

/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Diagnosis Recoding
/// Developer		:	SRIDHAR R
/// Created On		:	27 JULY 2004
/// Function 		:   Used to define the result page of recode diagnosis
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con				= null; 
	Statement stmt				= null;
    PreparedStatement stmt_1	= null;
    ResultSet rs				= null;
    ResultSet rs_1				= null;

    SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
    String currentdate			= dateFormat.format(new java.util.Date()) ;
    String facilityId				= (String) session.getValue( "facility_id" ) ;

	String srl_no					= request.getParameter("srl_no");
    String Patient_Id			= request.getParameter("patient_id");
    String Encounter_Id		= request.getParameter("Encounter_Id");


	String scheme_desc			= "";
    String scheme					= "";
	String srl_no_from_table	="";
    String diag_code				="";
    String diag_desc				="";
    String primary_yn				="N";
    String onset_date				=currentdate;
    String close_date				="";
    String problem_status		="";

   // String id[] ={"","B","W","S","C"};
   // String val[]={"-- Select --","Better","Worse","Same","Close"};

    String cause_ind="";
	primary_yn		=	(request.getParameter("primary_yn")==null)?"N" : request.getParameter("primary_yn");

	StringBuffer sql_1 = new StringBuffer();
	String record_type="";
	String onSet_facilityID="";
	String onSet_EncounterID="";
	String diag_code_scheme="";
	int count = 0;
	String recoded_code			= "";
	String recoded_code_desc	= "";
	String recoded_remarks		= "";

try{
	con = ConnectionManager.getConnection(request);

	String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date from mr_parameter ";
	
	if(rs!=null) rs.close();
	if(stmt != null) stmt.close();
	stmt=con.createStatement();
	rs=stmt.executeQuery(sql);
	
	if(rs.next())
	{
		scheme      = rs.getString("scheme");
		out.print("<script>scheme='"+scheme+"'</script>");
		scheme_desc = rs.getString("scheme_desc");
//		db_date     = rs.getString("db_date");
	}
	else
		 out.print("<script>scheme=''</script>");

	if(rs!=null) rs.close();
	if(stmt != null) stmt.close();

    if(srl_no != null)
    {
    
	String count_sql = "SELECT count(*) FROM  mr_diag_recoding WHERE patient_id = ? AND srl_no = ? and ONSET_FACILITY_ID = ?";
	PreparedStatement countStmt = null;
	ResultSet countRS  = null;

	countStmt = con.prepareStatement(count_sql);
	countStmt.setString(1,Patient_Id);
	countStmt.setString(2,srl_no);
	countStmt.setString(3,facilityId);

	countRS	  = countStmt.executeQuery();

	if(countRS != null )
	{
		if(countRS.next())
		{
			count = countRS.getInt(1);
		}
	}
	if(countStmt != null) countStmt.close();
	if(countRS != null) countRS.close() ;

	if(count == 0)
	{	
//		read_only	= "readonly";
//        data_state	= "modify";
//        dis			= "disabled";
		
		sql_1.append("Select ONSET_ENCOUNTER_ID, ONSET_FACILITY_ID,RECORD_TYPE, srl_no,diag_code,diag_desc,primary_yn,to_char(onset_date,'dd/mm/yyyy') onset_date,to_char(close_date,'dd/mm/yyyy') close_date, problem_status, cause_indicator, ip_diag_stage, decode(ip_diag_stage,'I','Intermediate','A','Admission','D','Discharge') diag_stage_desc, problem_remarks, diag_type, significant_yn, DIAG_CODE_SCHEME ");
        sql_1.append(" from pr_problem where patient_id = ? and srl_no = ? ");

		stmt_1 = con.prepareStatement(sql_1.toString());
		stmt_1.setString(1,Patient_Id);
		stmt_1.setString(2,srl_no);

        rs_1 = stmt_1.executeQuery();

        if (rs_1.next())
        {
			onSet_facilityID			=  rs_1.getString("ONSET_FACILITY_ID");
			onSet_EncounterID	=  rs_1.getString("ONSET_ENCOUNTER_ID");
			diag_code_scheme	=  rs_1.getString("DIAG_CODE_SCHEME");
			srl_no_from_table		=  rs_1.getString("srl_no");

			diag_code					=   rs_1.getString("diag_code");
				if(diag_code==null) diag_code = "";
			record_type   =   rs_1.getString("RECORD_TYPE");
				if(record_type==null) record_type = "";
            diag_desc   =   rs_1.getString("diag_desc");
	            if (diag_desc == null) diag_desc = "";

			primary_yn  =   rs_1.getString("primary_yn");
	            if (primary_yn == null) primary_yn = "";

			onset_date  =   rs_1.getString("onset_date");
	            if (onset_date == null) onset_date = "";
			
			close_date  =   rs_1.getString("close_date");
	            if (close_date == null) close_date = "";

            problem_status= rs_1.getString("problem_status");
	            if (problem_status.equals("A")) problem_status="";

			cause_ind=rs_1.getString("cause_indicator");
	            if(cause_ind==null) cause_ind="";
            
//			diagstage		= rs_1.getString("diag_stage_desc");
//          diagstagecode	= rs_1.getString("ip_diag_stage");
//			significant_yn	= rs_1.getString("significant_yn");

//			diagtype = rs_1.getString("diag_type");
//			if(!(diagtypeselected.equals("") || diagtypeselected.equals("null")))
//              diagtype = diagtypeselected;

//          problemremarks = rs_1.getString("problem_remarks");
//			if(!(remarksselected.equals("") || remarksselected.equals("null")))
//                problemremarks = remarksselected;
/*
            if(diagtype.equals("P"))
				sel1 = "selected";
            else if(diagtype.equals("D"))	
				sel2 = "selected";
            else if(diagtype.equals("F"))	
				sel3 = "selected";
*/

        }
		if(stmt_1!=null)
			stmt_1.close();
		if(rs_1!=null)
			rs_1.close();
    }// count == 0
	else
	{
		 
	String MRsql = " SELECT RECODED_DIAG_CODE mr_diag_code, RECODED_REMARKS mr_remarks, RECODED_DIAG_DESC mr_desc FROM mr_diag_recoding_vw WHERE PATIENT_ID = ? AND SRL_NO = ? AND FACILITY_ID = ? ";

	if(countStmt != null) countStmt = null;
	if(countRS != null) countRS = null;

	countStmt = con.prepareStatement(MRsql);
	countStmt.setString(1,Patient_Id);
	countStmt.setString(2,srl_no);
	countStmt.setString(3,facilityId);

	countRS  = countStmt.executeQuery();

		if(countRS != null )
		{
			if(countRS.next())
			{
				recoded_code		= countRS.getString("mr_diag_code");
					if(recoded_remarks	== null ) recoded_remarks = "";
				recoded_code_desc	= countRS.getString("mr_desc");
					if(recoded_remarks	== null ) recoded_remarks = "";
				recoded_remarks		= countRS.getString("mr_remarks");
					if(recoded_remarks	== null ) recoded_remarks = "";
			}
		}
	}
        if(countRS!=null)  countRS.close();
		if(countStmt!=null) countStmt.close();
	}


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
 for(int i=0;i<75;i++) { 
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(scheme_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(onSet_facilityID));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(onSet_EncounterID));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(srl_no_from_table));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(cause_ind));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block29Bytes, _wl_block29);

	if(count > 0)	
	{ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(recoded_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(recoded_code_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(recoded_remarks));
            _bw.write(_wl_block33Bytes, _wl_block33);
	}	
            _bw.write(_wl_block34Bytes, _wl_block34);

}catch(Exception e)
{
    //out.print("Exception :"+sql_1.toString()+""+e.toString());
	e.printStackTrace();
}
finally
{
	try
	{
	if(rs!=null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
	}
	if(con != null) 
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisRecodingDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Recode.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
