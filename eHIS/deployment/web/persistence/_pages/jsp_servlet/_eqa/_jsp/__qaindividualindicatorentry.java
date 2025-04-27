package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __qaindividualindicatorentry extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndividualIndicatorEntry.jsp", 1742817545410L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<head>\n<title>Indicator Entry </title>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/messages.js\" language=\"javascript\"></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\nfunction checkMaxLimit(obj,maxSize)\t{\n\t\tvar len  = obj.value;\n\t   \tif ( len.length > maxSize ){\t  \n\t\t  \talert(\"APP-OT0016 Value Should be within the specified limit of \"+maxSize+\" characters\" );\n\t        event.returnValue = false; obj.focus();\n   \t\t}\t\n}\t\n</SCRIPT>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<!-- The files  QAAnalyzePartialIndicators.js and QADirRecordOfClinIndicators.js should not \nbe included in a single jsp -->\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n <script src=\'../../eQA/js/QAAnalyzePartialIndicators.js\' language=\'javascript\'></script>\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script src=\"../../eQA/js/QADirRecordOfClinIndicators.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<!-- <body  OnMouseDown=\"CodeArrest()\" OnLoad=\"Focusing(\'pat_ser_grp_code\')\" > -->\n<body  OnMouseDown=\"CodeArrest()\"  onKeyDown = \'lockKey()\' >\n<form name=\'QA_QIND_ENCOUNTER_CLIND_TRN1\' id=\'QA_QIND_ENCOUNTER_CLIND_TRN1\' method=\"post\" target=\"messageFrame\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td colspan=\'2\'>&nbsp;\n\t\t\t</td>\n\t\t</tr>\n\t<tr>\n\t<td class=\"label\" align=\"right\" width=\"20%\">Encounter Id\n\t</td>\n\t<td class=\"label\" align=\"left\" width=\"60%\">\t\t\t\t&nbsp;&nbsp;<B>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</B>\n\t</td>\t\t\t\t\n\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=\'2\'>&nbsp;\n\t\t\t</td>\n\t\t</tr>\n<tr>\n\t\t\t<td class=\"label\" align=\"right\" width=\"20%\">Reference\n\t\t\t</td>\n\t\t\t<td align=\"left\" width=\"60%\" onClick=\'funShowNote()\'>\n\t\t\t\t<b class=\'label\' style=\'cursor:pointer\'>&nbsp;&nbsp;<U>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</U>\n\t\t\t\t</b>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td colspan=\'2\'>&nbsp;\n\t\t</td>\n\t\t</tr>\n\n\n\t<INPUT TYPE=\"hidden\" name=\'CLIND_ANALYSIS_STATUS\' id=\'CLIND_ANALYSIS_STATUS\'>\n\n<!-- <tr>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"40%\"><b>Analysis Status</b></td>\n\t\t\t\t<td align=\"left\" width=\"60%\">&nbsp;&nbsp;\n\t\t\t\t<select name=\'CLIND_ANALYSIS_STATUS\' id=\'CLIND_ANALYSIS_STATUS\' disabled>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<option value=\'9\' selected>Analyzed&nbsp;</option>\n\t\t\t\t<option value=\'5\' >Partially Analyzed&nbsp;\n\t\t\t\t<option value=\'\'>Not Analyzed&nbsp;\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<option value=\'9\' >Analyzed&nbsp;</option>\n\t\t\t\t<option value=\'5\' selected>Partially Analyzed&nbsp;\n\t\t\t\t<option value=\'\'>Not Analyzed&nbsp;\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<option value=\'9\' >Analyzed&nbsp;</option>\n\t\t\t\t<option value=\'5\' >Partially Analyzed&nbsp;\n\t\t\t\t<option value=\'\' selected>Not Analyzed&nbsp;\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr> -->\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"20%\"><b>Applicability</b></td>\n\t\t\t\t<td align=\"left\" class=\"label\" width=\"60%\">&nbsp;&nbsp;Yes\n\t\t\t\t<input type=\"RADIO\" name=\"INCL_FOR_YES_YN\" id=\"INCL_FOR_YES_YN\" value=\"Y\"   ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >&nbsp;&nbsp;\t\n\t\t\t\tNo<input type=\"RADIO\" name=\"INCL_FOR_YES_YN\" id=\"INCL_FOR_YES_YN\" value=\"N\"   ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"20%\"><b><i>Inclusion Criteria</i></b></td>\n\t\t\t\t<td valign=\'top\' class=\"label\" width=\"60%\" valign=\'top\'>&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td colspan=\'2\'>&nbsp;\n\t\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"20%\">Diagnosis</td>\n\t\t\t\t<td align=\"left\" class=\"label\" width=\"60%\">&nbsp;&nbsp;&nbsp;<textarea rows=\"2\" name=\"INCL_DIAG_CODE\"  cols=\"10\" readonly>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  </textarea>\n\t\t\t\t&nbsp;<textarea rows=\"2\" name=\"DIAG_DESC\"  cols=\"41\" readonly>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</textarea>\n\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<!-- \n<input type=\"text\" name=\"INCL_DIAG_CODE\" id=\"INCL_DIAG_CODE\"  VALUE=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'size=5 maxlength=20 readonly>\t\n\t\t\t\t&nbsp;<input type=\"text\" name=\"DIAG_DESC\" id=\"DIAG_DESC\" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'   size=60 maxlength=70 readonly>\t -->\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"20%\">Procedure</td>\n\t\t\t\t<td align=\"left\" class=\"label\" width=\"60%\">\n\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t<textarea rows=\"2\" name=\"INCL_PROC_CODE\"  cols=\"10\" readonly>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="  </textarea>\n\t\t\t\t&nbsp;<textarea rows=\"2\" name=\"PROC_DESC\"  cols=\"41\" readonly>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</textarea></td>\n\t\t\t\t</td>\n\n<!-- <input type=\"text\" name=\"INCL_PROC_CODE\" id=\"INCL_PROC_CODE\"  VALUE=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  size=5 maxlength=5 readonly>\t\n<input type=\"text\" name=\"PROC_DESC\" id=\"PROC_DESC\" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'   size=60 maxlength=100 readonly> \n -->\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"20%\">Complication</td>\n\t\t\t\t<td align=\"left\" class=\"label\" width=\"60%\">\n\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t<input type=\"text\" name=\"INCL_COMPL_CODE\" id=\"INCL_COMPL_CODE\"   value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' size=5 maxlength=5 disabled>&nbsp;\t\n\t\t\t\t<input type=\"text\" name=\"COMPL_DESCRIPTION\" id=\"COMPL_DESCRIPTION\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"   size=20 maxlength=20 disabled>\n\t\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'COMPL_button\' id=\'COMPL_button\' onClick=\" funQAComplication(INCL_COMPL_CODE,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\" >\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\n<tr>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"20%\">Comments</td>\n\n\t\t\t\t<td align=\"left\" class=\"label\" width=\"60%\">\n\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t      <textarea rows=\"6\" name=\"INCL_COMMENTS\"  cols=\"31\" onBlur=\"checkMaxLimit(this,500);\"> ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</textarea></td>\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t<td colspan=\'2\'>&nbsp;\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td class=\"label\" align=\"right\" width=\"20%\">&nbsp;</td>\n\t\t\t\t<td align=\"left\" class=\"label\" width=\"60%\">\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t<input name=\'close_button\' id=\'close_button\' type=\'button\' class=\'button\' value=\'Apply\' onClick=\'collectData()\'>\n\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t<input name=\'cancel_button\' id=\'cancel_button\' type=\'button\' class=\'button\' value=\'Cancel\' onClick=\'funCancel()\'>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n<tr>\n<td colspan=\'2\'>&nbsp;\n</tr>\n\t             <tr>\n\t\t\t\t<td colspan=\'2\'>&nbsp;\n\t\t\t\t</tr>\n\n<tr>\n\t\t\t<td colspan=\'2\'>&nbsp;\n\t\t\t</td>\n\t\t</tr>\n\n</table>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<input type=\"hidden\" name=\"EPISODE_ID\" id=\"EPISODE_ID\" value=\'\'>\n<input type=\"hidden\" name=\"VISIT_ID\" id=\"VISIT_ID\" value=\'\'>\n<input type=\"hidden\" name=\"PATIENT_CLASS\" id=\"PATIENT_CLASS\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\"hidden\" name=\"ENCOUNTER_ID\" id=\"ENCOUNTER_ID\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\"hidden\" name=\"QIND_CLIND_ID\" id=\"QIND_CLIND_ID\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\"hidden\" name=\"QIND_CLIND_DESC\" id=\"QIND_CLIND_DESC\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\"hidden\" name=\"SYS_USER_CREATED\" id=\"SYS_USER_CREATED\" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\"hidden\" name=\"QUERY_STRING\" id=\"QUERY_STRING\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\"hidden\" name=\"close_property\" id=\"close_property\" value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\"hidden\" name=\"H_CLIND_ANALYSIS_STATUS\" id=\"H_CLIND_ANALYSIS_STATUS\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\"hidden\" name=\"rowVal\" id=\"rowVal\" value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\n\n</form>\n</center>\n<Script></Script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

String callfun = request.getParameter("Analyzepart")==null?"": request.getParameter("Analyzepart");
	if(callfun.equals("yes")){
	
            _bw.write(_wl_block4Bytes, _wl_block4);
}else{
            _bw.write(_wl_block5Bytes, _wl_block5);
}
            _bw.write(_wl_block6Bytes, _wl_block6);

	String strClinicalIndicatorId = request.getParameter("QIND_CLIND_ID");
//	String QIND_CLIND_Desc = request.getParameter("QIND_CLIND_DESC");
							
	String strInclProcCode = request.getParameter("INCL_PROC_CODE");
	String strInclDiagCode = request.getParameter("INCL_DIAG_CODE");
	String strInclYN = "N";
	String strYesChecked = "checked";
	String strNoChecked = "checked";
	String strRefNote = "null";
    String COMPL_DESCRIPTION="";
	String COMPL_CODE="";
	String strCloseButton = "disabled=true";
	String strFacilityId = request.getParameter("FACILITY_ID");
	String strUserSystem = request.getParameter("SYS_USER_CREATED");
	String strClindAnalysisStatus = request.getParameter("CLIND_ANALYSIS_STATUS");
	String strEncounterId = request.getParameter("ENCOUNTER_ID");
	String rowVal = request.getParameter("rowVal");
	if ( (strUserSystem.equalsIgnoreCase("S") && !(strClindAnalysisStatus.equalsIgnoreCase("5")))
		||(strClindAnalysisStatus.equalsIgnoreCase("A")))
	{
		strCloseButton = "disabled=true";
	}
	else
		strCloseButton = "disabled=false";

	String strComments = "";
	String diag_desc="";
	String proc_desc="";


            _bw.write(_wl_block7Bytes, _wl_block7);


	Connection conn=null;

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuffer sqlBuff = new StringBuffer();
	StringBuffer sql2Buff = new StringBuffer();
	StringBuffer sql3Buff = new StringBuffer();

    sqlBuff.append("select  REF_NOTE_TEXT REF_NOT   from QA_QIND_CLIND_REF_NOTE ");
	sqlBuff.append("where  SECTION_ID= 50 ");

	sql2Buff.append("select  nvl(INCL_FOR_YES_YN,'N') INCL_FOR_YES_YN,");
	sql2Buff.append("INCL_COMMENTS from QA_QIND_ENCOUNTER_CLIND_TRN ");
	sql2Buff.append(" where  FACILITY_ID =? AND ENCOUNTER_ID=? AND  ");
	sql2Buff.append(" QIND_CLIND_ID=?  ");

	sql3Buff.append("select a.INCL_COMPL_CODE, b.COMPL_DESCRIPTION ");
	sql3Buff.append(" from QA_QIND_ENCOUNTER_CLIND_TRN a,QA_QIND_CLIND_COMPL b");
	sql3Buff.append(" where  a.FACILITY_ID =? AND a.ENCOUNTER_ID=? AND  ");
	sql3Buff.append(" a.QIND_CLIND_ID=? and a.INCL_COMPL_CODE=b.COMPL_CODE(+)");

	String sql_diag = "SELECT  diag_desc from pr_problem a,pr_problem_enc_dtl b where a.patient_id=b.patient_id and a.srl_no=b.srl_no and encounter_id=? and diag_code=?";
	
	String sql_proc = "SELECT  proc_narration from pr_encounter_procedure  where encounter_id=? and proc_code=?";

	try
	{
		conn = ConnectionManager.getConnection(request);
		pstmt=conn.prepareStatement(sqlBuff.toString());
		rs=pstmt.executeQuery();
		if(rs.next())
		{	 
			strRefNote=rs.getString("REF_NOT");

		}	
	
		if ((strRefNote ==null)||(strRefNote =="null")||(strRefNote ==""))
		{
			strRefNote ="Not Defined";
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
		if((sqlBuff != null) && (sqlBuff.length() > 0))
		{
			sqlBuff.delete(0,sqlBuff.length());
		}
	
		pstmt=conn.prepareStatement(sql2Buff.toString());
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strEncounterId);
		pstmt.setString(3,strClinicalIndicatorId);
		rs=pstmt.executeQuery();
		
		if(rs.next())
		{	 
			strComments = rs.getString("INCL_COMMENTS");
			strInclYN = rs.getString("INCL_FOR_YES_YN");
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
		
		pstmt=conn.prepareStatement(sql3Buff.toString());
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strEncounterId);
		pstmt.setString(3,strClinicalIndicatorId);
		rs=pstmt.executeQuery();
		if(rs.next())
		{	 
			COMPL_CODE = rs.getString("INCL_COMPL_CODE")==null?"":rs.getString("INCL_COMPL_CODE");
			COMPL_DESCRIPTION = rs.getString("COMPL_DESCRIPTION")==null?"":rs.getString("COMPL_DESCRIPTION");
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
		
		if((sql2Buff != null) && (sql2Buff.length() > 0))
		{
			sql2Buff.delete(0,sql2Buff.length());
		}

	 
		pstmt=conn.prepareStatement(sql_diag);
		pstmt.setString(1,strEncounterId);
		pstmt.setString(2,strInclDiagCode);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
		   diag_desc = rs.getString("diag_desc")==null?"":rs.getString("diag_desc");
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();
	
		pstmt=conn.prepareStatement(sql_proc);
		pstmt.setString(1,strEncounterId);
		pstmt.setString(2,strInclProcCode);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
		   proc_desc = rs.getString("proc_narration")==null?"":rs.getString("proc_narration");
		}
		if (rs != null) rs.close();
		if (pstmt != null)  pstmt.close();


	if (strInclYN!= null)
	{
		if (strInclYN.equalsIgnoreCase("Y"))
		{
			strYesChecked = "checked";
			strNoChecked = "";
		}
		else
		{
			strNoChecked = "checked";
			strYesChecked = "";

		}
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getParameter("ENCOUNTER_ID")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getParameter("QIND_CLIND_ID")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("QIND_CLIND_DESC")));
            _bw.write(_wl_block11Bytes, _wl_block11);
if(strClindAnalysisStatus.equals("9")){
            _bw.write(_wl_block12Bytes, _wl_block12);
} else if(strClindAnalysisStatus.equals("5")){
            _bw.write(_wl_block13Bytes, _wl_block13);
} else {
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strYesChecked));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strNoChecked));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strRefNote));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strInclDiagCode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strInclDiagCode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strInclProcCode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(proc_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strInclProcCode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(proc_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(COMPL_CODE));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(COMPL_DESCRIPTION));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strClinicalIndicatorId));
            _bw.write(_wl_block29Bytes, _wl_block29);
 	if(strComments==null)
					strComments="";
					
				
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strComments));
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
	 catch (Exception sqlExp)
	 {
		out.println(sqlExp+"");
		
	 }
     finally
     {
	    	ConnectionManager.returnConnection(conn,request);
     }

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(request.getParameter("PATIENT_CLASS")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(request.getParameter("QIND_CLIND_ID")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(request.getParameter("QIND_CLIND_DESC")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(request.getParameter("SYS_USER_CREATED")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strCloseButton));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strClindAnalysisStatus));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rowVal));
            _bw.write(_wl_block41Bytes, _wl_block41);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
