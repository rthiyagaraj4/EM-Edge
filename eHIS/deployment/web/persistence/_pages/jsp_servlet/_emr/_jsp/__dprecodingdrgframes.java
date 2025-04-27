package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __dprecodingdrgframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingDRGFrames.jsp", 1709118909923L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script> \n\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' >\n<FORM name=\"drg_query_results_form\" id=\"drg_query_results_form\" method=\"post\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<script>\n\t\t\n\t\talert(getMessage(\'MRDRG_ERROR\',\'MR\'))\n\t\tparent.frames[4].document.forms[0].seqDrg.disabled=true;\t\n\t\t</script>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<script>\n\t\t\n\t\talert(getMessage(\'MRDRG_IDL_TM\',\'MR\'))\n\t\tparent.frames[4].document.forms[0].seqDrg.disabled=true;\t\t\n\t\t</script>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\'PREVIOUS_REQ_NOT_PROCESSED\',\'MR\'))\n\t\t\t\tparent.frames[4].document.forms[0].seqDrg.disabled=true;\t\t\n\t\t\t</script>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\n\t\t\t\t\tparent.frames[4].document.forms[0].seqDrg.disabled=true;\t\t\n\t\t\t\t</script>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<script>\n\t\t\t\t\t\n\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\n\t\t\t\t\tparent.frames[4].document.forms[0].seqDrg.disabled=true;\t\t\n\t\t\t\t\t</script>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\n\t\t\t\t\t\t<!--<DIV ID=\"drgResultsDiv\">-->\n\t\t\t\t\t\t<TABLE cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=center >\n\t\t\t\t\t\t<TR><td class=\'PANELTOOLBAR\' colspan=\'11\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TD></TR>\n\t\t\t\t\t\t<TR><TD class=\"label\" colspan=\"11\">&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD class=\"label\" COLSPAN=\"1\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TD>\t\n\t\t\t\t\t\t\t<TD colspan=\"2\" class=\'fields\'><INPUT TYPE=\"text\" name=\"drgMdc\" id=\"drgMdc\" ID=\"drgMdc\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" Readonly></TD>\n\t\t\t\t\t\t\t<TD class=\"label\" COLSPAN=\"1\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</TD>\t\n\t\t\t\t\t\t\t<TD class=\'fields\' colspan=\"2\"><INPUT TYPE=\"text\" name=\"drg_drg\" id=\"drg_drg\" ID=\"drg_drg\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" Readonly title=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t\t<TD class=\"label\" COLSPAN=\"1\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</TD>\n\t\t\t\t\t\t\t<TD class=\'fields\' colspan=\"2\"><INPUT TYPE=\"text\" name=\"drg_wtlos\" id=\"drg_wtlos\" ID=\"drg_wtlos\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" Readonly></TD>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR><TD class=\"label\">&nbsp;</TD><TD class=\"label\">&nbsp;</TD><TD class=\"label\">&nbsp;</TD><TD class=\"label\">&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD class=\"label\" COLSPAN=\"1\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TD>\n\t\t\t\t\t\t\t<TD class=\'fields\' colspan=\"2\"><INPUT TYPE=\"text\" name=\"drg_rw\" id=\"drg_rw\" ID=\"drg_rq\" VALUE=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</TD>\n\t\t\t\t\t\t\t<TD class=\'fields\' colspan=\"2\"><INPUT TYPE=\"text\" name=\"drg_ot\" id=\"drg_ot\" ID=\"drg_ot\" VALUE=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" Readonly></TD>\n\t\t\t\t\t\t\t<TD class=\"label\" COLSPAN=\"1\" nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</TD>\n\t\t\t\t\t\t\t<TD class=\'fields\' colspan=\"2\"><INPUT TYPE=\"text\" name=\"drg_adrrw\" id=\"drg_adrrw\" ID=\"drg_adrrw\" VALUE=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" Readonly></TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR><TD class=\"label\">&nbsp;</TD><TD class=\"label\">&nbsp;</TD><TD class=\"label\">&nbsp;</TD><TD class=\"label\">&nbsp;</TD>\n\t\t\t\t\t\t</TR>\n\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD class=\"label\" COLSPAN=\"1\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</TD>\n\t\t\t\t\t\t\t<TD class=\'fields\' colspan=\"2\"><textarea NAME=\"drgwarn_desc\"  Readonly cols=\"30\" rows=\"3\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</textarea></TD>\n\t\t\t\t\t\t\t<TD class=\"label\" COLSPAN=\"1\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</TD>\n\t\t\t\t\t\t\t<TD class=\'fields\' colspan=\"2\"><textarea NAME=\"drg_error_desc\"  Readonly cols=\"30\" rows=\"3\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</textarea></td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"warn\" id=\"warn\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"drg_error\" id=\"drg_error\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</TD>\n\t\t\t\t\t\t\t<TD class=\'fields\' colspan=\"5\"><textarea NAME=\"drg_result_msg\"  Readonly cols=\"20\" rows=\"3\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</textarea></td>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"drg_result_code\" id=\"drg_result_code\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<td COLSPAN=\"11\" align=right><input type=\'button\' width=\'5%\' name=\'Save\' id=\'Save\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' class=\'button\' onclick=\'Save_DRG()\'></td>\n\t\t\t\t\t\t</TR>\n\n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t<!--\n\t\t\t\t\t\t</DIV>\n\t\t\t\t\t\t-->\n\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"drgstatus\" id=\"drgstatus\" ID=\"drgstatus\" VALUE=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"drgexception\" id=\"drgexception\" ID=\"drgexception\" VALUE=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" ID=\"mode\" VALUE=\"\">\n\t\t<INPUT TYPE=\"hidden\" name=\"rep_EncounterId\" id=\"rep_EncounterId\"  VALUE=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"EncounterId\" id=\"EncounterId\"  VALUE=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"stage_no\" id=\"stage_no\"  VALUE=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"Pat_id\" id=\"Pat_id\"  VALUE=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"rep_Pat_id\" id=\"rep_Pat_id\"  VALUE=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"activity\" id=\"activity\"  VALUE=\"SaveDRG\">\n\t\t<INPUT TYPE=\"hidden\" name=\"Patient_Class\" id=\"Patient_Class\"  VALUE=\"IP\">\n\t\t<INPUT TYPE=\"hidden\" name=\"rep_language_id\" id=\"rep_language_id\"  VALUE=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"rep_facility_id\" id=\"rep_facility_id\"  VALUE=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"rep_sStyle\" id=\"rep_sStyle\"  VALUE=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\'hidden\' name=\'hdr_modified_dt\' id=\'hdr_modified_dt\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\n\n\t\t<script>\n\t\t\tparent.frames[6].location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n\t\t\topen_Print(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\n\t\t</script>\n\n\t\t</FORM>\n\t\t</BODY>\n\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n</html>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
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

 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
 String facility_id		= (String) session.getValue( "facility_id" ) ;

 


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

Connection con = null;
try
{
			con = ConnectionManager.getConnection();
	Statement stmt = null;
	Statement stmt1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ArrayList elements = new ArrayList();
	CallableStatement drgCalStmt = null;		
	//HashMap results = new HashMap();		
	
	String drgMdc = "";
	String drgVal = "";
	String drgRw = "";
	String drgWtlos = "";
	String drgOt = "";
	String drgAdjrw = "";
	String drgError = "";
	String drgWarn = "";
	String drgException = "";
	String drgStatus = "";
	String drgResult = "";//Added On 3/17/2010 for Site Enhancmenent.
	String msgID = "";
	String hdr_modified_dt = "";// Added For 3/8/2010 Site Issue.
	String responseText = "";
	String profileID = "";
	String standardCode = "";
//	HashMap map = (HashMap)request.getAttribute("results");
	HashMap map = (HashMap)session.getAttribute("DRG_VAL");
	session.removeAttribute("DRG_VAL");
	String Pat_id = request.getParameter("Pat_id");
	String EncounterId = request.getParameter("EncounterId");
	String stage_no = request.getParameter("stage_no");
//	HashMap map111 = (HashMap)session.getAttribute("DRG_VAL");
	String p_language_id=request.getParameter("p_language_id");
	String	success="N";
	//String results1 = request.getParameter("results");
	String DRGcal = request.getParameter("DRGcal");
	String idle_time="";  // added on 16th Oct 2009 for crf 510
	String errTxt=""; // added on 16th Oct 2009 for crf 510
	String resp_text="";
	String drgDesc="";
	boolean is_map_null=true;
	
					//out.println("<script>alert(\"EncounterId :"+EncounterId+"\");</script>");
//					out.println("<script>alert(\"DRGcal :"+DRGcal+"\");</script>");
	if(DRGcal.equals("Y"))
	{
		try
		{

			stmt = con.createStatement();
			String msgSql="SELECT TRX_NO FROM MR_DIAG_PROC_RECODING_HDR WHERE  PATIENT_ID='"+Pat_id+"' AND ENCOUNTER_ID='"+EncounterId+"' AND FACILITY_ID='"+facility_id+"'";
			rs = stmt.executeQuery(msgSql);
			if(rs.next()){
				msgID = rs.getString("TRX_NO");
			}
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT response_text,profile_id FROM xh_interactive_integration WHERE message_id='"+msgID+"'");
			if(rs.next()){
				responseText = rs.getString("response_text");
				profileID = rs.getString("profile_id");
			}
			
						//out.println("<script>alert(\"responseText :"+responseText+"\");</script>");
						//out.println("<script>alert(\"profileID :"+profileID+"\");</script>");

			responseText = responseText;
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery("SELECT standard_code FROM xh_standard_profile WHERE profile_id='"+profileID+"'");
			if(rs1.next())
			{
				standardCode = rs1.getString("standard_code");
			}
			else
			{
				standardCode = "TGRP1";
			}
			
//			out.println("<script>alert(\"standardCode :"+standardCode+"\");</script>");

			elements.add(":DRG[38]");
			elements.add(":DRG[39]");
			elements.add(":DRG[40]");
			elements.add(":DRG[41]");
			elements.add(":DRG[42]");
			elements.add(":DRG[43]");
			elements.add(":DRG[44]");
			elements.add(":DRG[45]");
			elements.add(":DRG[48]");
			elements.add(":DRG[50]");		
			drgCalStmt = con.prepareCall("{call XHINTERACTIVE.INTERACTIVE_RESPONSE_FETCH(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			drgCalStmt.setString(1,msgID);						
			drgCalStmt.registerOutParameter(2,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(11,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(12,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(13,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(14,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(15,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(16,java.sql.Types.VARCHAR);
			drgCalStmt.registerOutParameter(17,java.sql.Types.VARCHAR);
			drgCalStmt.execute();
			/*drgMdc = checkForNull(drgCalStmt.getString(8));
			drgVal = checkForNull(drgCalStmt.getString(4));
			drgRw = checkForNull(drgCalStmt.getString(5));
			drgWtlos = checkForNull(drgCalStmt.getString(7));
			drgOt = checkForNull(drgCalStmt.getString(6));
			drgAdjrw = checkForNull(drgCalStmt.getString(13));
			drgError = checkForNull(drgCalStmt.getString(9));
			drgWarn = checkForNull(drgCalStmt.getString(10));
			drgResult = checkForNull(drgCalStmt.getString(11));//Added On 3/17/2010 For Site Enhancement
			drgException = checkForNull(drgCalStmt.getString(16));
			drgStatus = checkForNull(drgCalStmt.getString(15));
			errTxt=checkForNull(drgCalStmt.getString(3));
			resp_text=checkForNull(drgCalStmt.getString(2));*/
			drgWtlos = checkForNull(drgCalStmt.getString(8));
			drgVal = checkForNull(drgCalStmt.getString(4));
			drgDesc = checkForNull(drgCalStmt.getString(5));
			drgOt = checkForNull(drgCalStmt.getString(7));
			drgRw = checkForNull(drgCalStmt.getString(6));
			drgResult = checkForNull(drgCalStmt.getString(12));
			drgAdjrw = checkForNull(drgCalStmt.getString(14));
			drgMdc = checkForNull(drgCalStmt.getString(9));
			drgError = checkForNull(drgCalStmt.getString(10));
			drgWarn = checkForNull(drgCalStmt.getString(11));//Added On 3/17/2010 For Site Enhancement
			drgException = checkForNull(drgCalStmt.getString(17));
			drgStatus = checkForNull(drgCalStmt.getString(16));
			errTxt=checkForNull(drgCalStmt.getString(3));
			resp_text=checkForNull(drgCalStmt.getString(2));
			

		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}

	}else{
		if(map != null)
		{
			is_map_null=false;


			drgDesc = checkForNull((String)map.get("desc"));
			drgMdc = checkForNull((String)map.get("mdc"));
			drgVal = checkForNull((String)map.get("drg"));
			drgRw = checkForNull((String)map.get("rw"));
			drgWtlos = checkForNull((String)map.get("wtlos"));
			drgOt = checkForNull((String)map.get("ot"));
			drgAdjrw = checkForNull((String)map.get("adjrw"));
			drgError = checkForNull((String)map.get("err"));
			drgWarn = checkForNull((String)map.get("warn"));
			drgResult = checkForNull((String)map.get("result"));// Added On 3/17/2010 For Site(Walkthrough) Enhancement.
			drgException = checkForNull((String)map.get("drgErrMsg"));
			drgStatus = checkForNull((String)map.get("drgErrCode"));
			idle_time=checkForNull((String)map.get("idletime"));  // added on 16th oct 2009 for crf 510
			errTxt=checkForNull((String)map.get("errTxt")); // added on 16th oct 2009 for crf 510
		}
	}

String [] warn_ary=drgWarn.split(" - ");
int i=0;
String drg_warn_code="";
for (String warn : warn_ary){
	if(i==0){
		drg_warn_code=warn;
	}
	i++;
}
String [] err_ary=drgError.split(" - ");
int j=0;
String drg_err_code="";
for (String error : err_ary){
	if(j==0){
		drg_err_code=error;
	}
	j++;
}
String result_msg="";
if(drgResult.equals("0")){
	result_msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Success.label","common_labels");
}else if(drgResult.equals("1")){
	result_msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels");;
}else if(drgResult.equals("2")){
	result_msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Error.label","common_labels");
}else if(drgResult.equals("3")){
	result_msg =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Warning.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.and.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Error.label","common_labels");
}

String msgSql="SELECT to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE  PATIENT_ID='"+Pat_id+"' AND ENCOUNTER_ID='"+EncounterId+"' AND FACILITY_ID='"+facility_id+"'";
stmt = con.createStatement();
rs = stmt.executeQuery(msgSql);

if(rs.next()){
	hdr_modified_dt = rs.getString("MODIFIED_DATE");
}
if(stmt != null) stmt.close();
if(rs != null) rs.close();


            _bw.write(_wl_block7Bytes, _wl_block7);



if(is_map_null && DRGcal.equals("N")){

	
            _bw.write(_wl_block8Bytes, _wl_block8);


		

}else{
	if(idle_time.equals("1")){

		
            _bw.write(_wl_block9Bytes, _wl_block9);

	}else{
		if(resp_text.equals("") && !errTxt.equals("")&&DRGcal.equals("Y")){
            _bw.write(_wl_block10Bytes, _wl_block10);

		}else{
			if(drgStatus.equals("E")){
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(drgException));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}else{
				
				if(drgStatus.equals("S") && !errTxt.equals("")){

					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(errTxt));
            _bw.write(_wl_block14Bytes, _wl_block14);


				}else{
					success="Y";
					
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(drgMdc));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(drgVal));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drgDesc));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drgWtlos));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drgRw));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drgOt));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(drgAdjrw));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drgWarn));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drgError));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(drg_warn_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(drg_err_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(result_msg));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drgResult));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drgStatus));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(drgException));
            _bw.write(_wl_block39Bytes, _wl_block39);


						if(DRGcal.equals("N")){
							//doOnlineReports(facility_id,EncounterId,Pat_id,p_language_id,sStyle);
						}
				} // end error S check
			} // end error E check
		}// end of idle time check
	}// end of previous req not processed
}// end of null check for map

	
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(stage_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(p_language_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(hdr_modified_dt));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(DRGcal));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(success));
            _bw.write(_wl_block51Bytes, _wl_block51);

}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}finally{
		if(con!=null){
			ConnectionManager.returnConnection(con,request);
		}
 }

            _bw.write(_wl_block52Bytes, _wl_block52);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DRGCalculation.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MDC.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DRG.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.WTLOS.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RW.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.OT.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdjRW.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.WARN.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Error.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Result.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
