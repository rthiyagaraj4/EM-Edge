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
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __medboardrequestbuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedBoardRequestButtons.jsp", 1733977698402L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\"../../eMR/js/MedBoardReqButtons.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onKeyDown=\'lockKey()\'>\n<form name=\'recordButton_form\' id=\'recordButton_form\'>\n<table align=\'center\' border=\"0\" width=\"100%\" cellpadding=\'0\' cellspacing=\'0\'>\n<tr align=\"right\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\n\t\t\t<td class=\'button\' width=\"90%\" ><input type=\'button\' name=\'Notes\' id=\'Notes\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' class=\'button\' onclick=\'openCAModal()\'></td>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td class=label width=\"50%\" >&nbsp;</td>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<td class=\'button\' width=\"50%\" ><input type=\'button\' name=\'print\' id=\'print\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' class=\'button\' onclick=\'printReport();\' ><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' name=\'record\' onclick=\"apply();\"><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' name=\'close\' onclick=\"closeME();\"></td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td class=\'button\' width=\"100%\" ><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<td class=\'button\' width=\"100%\"><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</tr>\n<!-- \t<tr><td colspan=\"4\" class=\'label\' height=5>&nbsp;</td></tr> -->\n</table>\n<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\"\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name=\"PatientId\" id=\"PatientId\"\t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"patient_line\" id=\"patient_line\"\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\"\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name=\"event_status\" id=\"event_status\"\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name=\"request_id\" id=\"request_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"call_function\" id=\"call_function\"\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\"\tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"location_code\" id=\"location_code\"\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	Connection con = null;
	PreparedStatement stmt = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	String Facility_Id = (String) session.getValue("facility_id");

            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String call_function= checkForNull(request.getParameter("call_function"));
	String PatientId	= checkForNull(request.getParameter("PatientId"));
	String request_id	= checkForNull(request.getParameter("request_id"));
	String called_from	= checkForNull(request.getParameter("called_from"));
	String patient_class=""; String encounter_id="";
	String accession_num	=""; String event_status ="";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String facility_name = "";
String patient_line	= "";
String location_code	= "";
String specialty_code	= "";
try
{
	try
	{
		con = ConnectionManager.getConnection(request);
		String facilitySql = " select facility_name, get_patient.get_line_detail(?,?) patient_line from SM_FACILITY_PARAM where facility_id = ? ";

		stmt = con.prepareStatement(facilitySql);
		stmt.setString(1,PatientId);
		stmt.setString(2,locale);
		stmt.setString(3,Facility_Id);
		rs	=	stmt.executeQuery();

		if (rs.next() && rs != null)
		{
			facility_name	= rs.getString("facility_name");
			patient_line	= rs.getString("patient_line");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("select a.event_status, a.accession_num from CA_ENCNTR_NOTE a ");
		sqlBuff.append(" where a.patient_id=? and a.ACCESSION_NUM= ");
		sqlBuff.append("(select ACCESSION_NUM from MR_REPORT_REQUEST_HDR where ");
		sqlBuff.append("facility_id=? and patient_id =?");
		sqlBuff.append(" and REQUEST_ID = ?)");
		
		pstmt = con.prepareStatement(sqlBuff.toString());
		pstmt.setString(1,PatientId);
		pstmt.setString(2,Facility_Id);
		pstmt.setString(3,PatientId);
		pstmt.setString(4,request_id);
		rs	=pstmt.executeQuery();

		if (rs.next() && rs != null)
		{
			accession_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
			event_status= rs.getString("EVENT_STATUS")==null?"":rs.getString("EVENT_STATUS");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

		////Fetching patient_calss from pr_encounter for Record..
		String pat_class_slq=" select a.PATIENT_CLASS,b.ENCOUNTER_ID,a.PAT_CURR_LOCN_CODE,a.SPECIALTY_CODE from PR_ENCOUNTER a,MR_REPORT_REQUEST_DTL b where  a.facility_id = ? and a.PATIENT_ID=b.PATIENT_ID and a.facility_id=b.facility_id and b.patient_id=? and b.REQUEST_ID=?";
		stmt = con.prepareStatement(pat_class_slq);
		stmt.setString(1,Facility_Id);
		stmt.setString(2,PatientId);
		stmt.setString(3,request_id);
		rs	=	stmt.executeQuery();

		while(rs.next())
		{
			patient_class = rs.getString("PATIENT_CLASS");
			encounter_id = rs.getString("ENCOUNTER_ID");
			location_code = rs.getString("PAT_CURR_LOCN_CODE")==null?"":rs.getString("PAT_CURR_LOCN_CODE");
			specialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
		}

	if(rs!=null)
		rs.close();
	if(stmt!=null)
		stmt.close();

	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 5: "+exp.toString());
		exp.printStackTrace();
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
	if(call_function.equals("PREPARE_MEDICAL_BOARD") || call_function.equals("DELIVER_MEDICAL_BOARD"))
	{	
		if(call_function.equals("PREPARE_MEDICAL_BOARD") && called_from.equals("CA"))
		{	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RecordNotes.label","mr_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}else{	
            _bw.write(_wl_block12Bytes, _wl_block12);
	}	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewMedicalReport.label","mr_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
	}else if(!call_function.equals("MEDICAL_BOARD_COMPLETED"))
	{	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
	}else if(call_function.equals("MEDICAL_BOARD_COMPLETED") || call_function.equals("MEDICAL_REPORT_COMPLETED") ){	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
	}	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_line));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
	/*
	if(called_from.equals("CA"))
	{
	out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = false;</script>");
	}
	else
	{
	if(!accession_num.equals("") && ( event_status.equals("4") || event_status.equals("5") ) )
	{
	out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = false;</script>");
	}
	else
	{
	out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = true;</script>");
	}
	}
	*/
}
catch(Exception e)
{
	//out.println("Exception @ try 1 "+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
