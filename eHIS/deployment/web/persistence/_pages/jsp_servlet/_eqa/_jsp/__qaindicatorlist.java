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

public final class __qaindicatorlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorList.jsp", 1742817544510L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n   ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/Common.js\" language=\"javascript\"> </script>\n\t<Script src=\"../../eQA/js/QADirRecordOfClinIndicators.js\" language=\"JavaScript\"></Script>\n\t\n\t<Script src=\"../../eQA/js/QAMessages.js\" language=\"JavaScript\"></Script>\n\t<!--<script src=\"../../eCommon/js/messages.js\" language=\"javascript\"></script> -->\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onKeyDown = \'lockKey()\'>\n<form name=\"QA_QIND_ENCOUNTER_TRN\" id=\"QA_QIND_ENCOUNTER_TRN\"  action=\"QAIndicatorList.jsp\" method=\"post\">\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\'));\n\t\t</script>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n <P>\n<table  width=\'90%\' align=\'center\' >\t\n<tr >\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n        \n\t   <td class=\'white\' width=\'95%\'>&nbsp;</td>\n    \t<td  align=\'right\' nowrap>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t    \n\t\t<td class=\'white\'>\n\n\t   ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<a HREF=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =", ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =");\' text-decoration=\'none\'>Previous</a>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =");\'  text-decoration=\'none\'>Next</a>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</td>\n</tr>\n</table>\n\n\t<table  width=\'100%\' style=\"Color:blue\" border=1  CELLSPACING=0 CELLPADDING=0>\n    <font face=\"Verdana\" color=\"white\" size=\"2\">\n\n   <tr>\n\t<td Class=\"PATIENTLINECOLOR\" align=\'left\' colspan=\'8\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;&nbsp;,\n\tPatient Id:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n  </tr>  \n\n  <tr>\n<td class=\"label\" >\n\t<U>\n\t<b class=\"label\">\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</b>\n\t</U>\n</td>\n<td class=\"label\" align=\'right\'>System Indicator</td>\n<td class=\"brown\" align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n<td class=\"label\" align=\'right\'>Partially Analyzed</td>\n<td class=\"Yellow\" align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\t\n<td class=\"label\" align=\'right\'>Completed</td>\t\n<td class=\"Green\" align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n</tr>\n</table> \n\n<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<tr>\n\t\t<th width=\'5%\'>Status</th>\n\t\t<th width=\'2%\'>Clinical Indicator</th>\t\t\n\t\t<th width=\'70%\'>Clinical Indicator Desc</th>\t\t\n\t\t<th width=\'2%\'>Creation</th>\n\t\t<th width=\'2%\'>Applicability</th>\n\t\t<th width=\'15%\'>Inclusive Status</th>\t\t \n</tr>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t   <tr>\n\t   <td  \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >&nbsp;</td>\n       <td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  style=\'cursor:pointer;color:blue\' onClick=\'fun1(this)\'  id=\'qind_clind_id";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' value=\'\'  align=center>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n<script>\n       var index = parseInt(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\");\n       index = index - 1;\n\t   var tdId = eval(\"document.getElementById(\"qind_clind_id\")\"+index);\n       tdId.value = escape(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\")\n</script>\t\n\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"  nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n    <td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"; >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t<td class=label nowrap>\tYes&nbsp;\n\t<input type=\'Radio\'  name=\'INCL_FOR_YES";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'INCL_FOR_YES";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=Y  disabled>\n\t\tNo&nbsp;\n\t<input type=\'Radio\'  name=\'INCL_FOR_NO";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'INCL_FOR_NO";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' value=\'N\' disabled >\n   </td>\t\t\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"Hidden\" name=\"k\" id=\"k\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=hidden name=\'rowVal\' id=\'rowVal\'  value=\'\'>\n<input type=hidden name=\'PATIENT_ID\' id=\'PATIENT_ID\'  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=hidden name=\'PATIENT_NAME\' id=\'PATIENT_NAME\'  value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=hidden name=\'ENCOUNTER_ID\' id=\'ENCOUNTER_ID\'   value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=hidden name=\'FACILITY_ID\' id=\'FACILITY_ID\'   value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=hidden name=\'PATIENT_CLASS\' id=\'PATIENT_CLASS\'   value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=hidden name=\'QIND_DISCIPLINE_ID\' id=\'QIND_DISCIPLINE_ID\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=hidden name=\'QUERY_PARAM\' id=\'QUERY_PARAM\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=hidden name=\'QIND_DISCIPLINE_DESC\' id=\'QIND_DISCIPLINE_DESC\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=hidden name=\'Analyzepart\' id=\'Analyzepart\' value=\'\'>\n\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

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

	
	String strDescUserSystem="";
	String strUserSystem="";
	String strMasterUserSystem = "";
	String strClindId="";
	String strClindDes="";
	String strClindAnalysisStatus="";
	String strApplicableYN = "";
	String strInclusiveYN = "";
	String strApplicableText ="";
	//String strRadioSelected1="",strRadioSelected2="";
    String class_value				= "QRYEVEN";
	String jval=request.getParameter("k")==null?"0":request.getParameter("k");
	int k=Integer.parseInt(jval);

// Hidden Parameters to be stored

	String strEncounterId = "";
	String strPatientId = "";
	String strPatientName = "";
	String strPatientClass = "";
	String strFacilityId = "";
	String strQueryParam = "";
	String strInclProcCode = "";
	String strInclDiagCode = "";
	String StrDisciplineID="";
	String StrDisciplineDesc="";
	String classes="";
	
	int i=1;
	strEncounterId = request.getParameter("ENCOUNTER_ID");    
	strPatientId = request.getParameter("PATIENT_ID");      
	strPatientName = request.getParameter("PATIENT_NAME");    
	strPatientClass = request.getParameter("PATIENT_CLASS");   
	strFacilityId = request.getParameter("FACILITY_ID");    
	StrDisciplineID=request.getParameter("QIND_DISCIPLINE_ID"); 
	StrDisciplineDesc=request.getParameter("QIND_DISCIPLINE_DESC"); 

	strQueryParam = request.getQueryString();

	Connection conn                    = null;
	PreparedStatement pstmt            = null;
	ResultSet rset                     = null;
	StringBuffer sqlCountBuff          = new StringBuffer();
	StringBuffer sqlBuff               = new StringBuffer();
	int start = 0 ;
	int end = 0 ;
	int maxRecord=0;
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
try
 {
    conn = ConnectionManager.getConnection(request);
	if ( from==null)
	start = 1 ;
	else
	start = Integer.parseInt(from) ;
  	if (to==null)
	end = 14 ;
	else
	end = Integer.parseInt(to) ;
  
   sqlCountBuff.append(" SELECT  count(*) FROM ");
   sqlCountBuff.append(" (select X.FACILITY_ID FACILITY_ID,");
   sqlCountBuff.append(" QIND_CLIND_ID QIND_CLIND_ID,");
   sqlCountBuff.append(" SYS_USER_CREATED,CLIND_ANALYSIS_STATUS,");
   sqlCountBuff.append(" APPLICABLE_YN,nvl(INCL_DIAG_CODE,' ') INCL_DIAG_CODE ,");
   sqlCountBuff.append(" nvl(INCL_PROC_CODE,' ')  INCL_PROC_CODE, ");
   sqlCountBuff.append(" NVL(INCL_FOR_YES_YN,'E')  INCL_FOR_YES_YN ");
   sqlCountBuff.append(" from PR_ENCOUNTER X,QA_QIND_ENCOUNTER_CLIND_TRN XX ");
   sqlCountBuff.append(" where X.FACILITY_ID = XX.FACILITY_ID(+)  AND  ");
   sqlCountBuff.append(" X.ENCOUNTER_ID = XX.ENCOUNTER_ID(+)  AND  ");
   sqlCountBuff.append(" X.FACILITY_ID=?   AND  X.ENCOUNTER_ID=?) Y, ");
   sqlCountBuff.append(" QA_QIND_CLIND YY,QA_QIND_DISCIPLINE_CLIND YYY,");
   sqlCountBuff.append(" QA_QIND_FACILITY_CLIND YYYY ");
   sqlCountBuff.append(" WHERE YY.QIND_CLIND_ID = Y.QIND_CLIND_ID(+) AND ");
   sqlCountBuff.append(" YY.QIND_CLIND_ID = YYY.QIND_CLIND_ID(+) AND ");
   sqlCountBuff.append(" YY.QIND_CLIND_ID = YYYY.QIND_CLIND_ID AND ");
   sqlCountBuff.append(" QIND_DISCIPLINE_ID =?  AND ");
   sqlCountBuff.append(" YYYY.OPERATING_FACILITY_ID= ? ORDER BY YYY.QIND_SLNO ");

try
		{
			
			pstmt=conn.prepareStatement(sqlCountBuff.toString());
			pstmt.setString(1,request.getParameter("FACILITY_ID"));
			pstmt.setString(2,request.getParameter("ENCOUNTER_ID"));
			pstmt.setString(3,request.getParameter("QIND_DISCIPLINE_ID"));
			pstmt.setString(4,request.getParameter("FACILITY_ID"));
			rset=pstmt.executeQuery();
		}
		catch(Exception e)
		{
		out.println("e"+e);
		}
     while(rset.next())
	{	 
	maxRecord=rset.getInt(1);
	}if(rset!=null) rset.close();
	 if(pstmt!=null) pstmt.close();
	if (maxRecord==0)
	{

	
            _bw.write(_wl_block4Bytes, _wl_block4);

		return;
	}
	else
	{
	sqlBuff.append(" SELECT Y.PATIENT_CLASS, ");
	sqlBuff.append(" YYY.QIND_CLIND_ID QIND_CLIND_ID_DUMMY, ");
	sqlBuff.append(" YY.QIND_CLIND_ID QIND_CLIND_ID, ");
	sqlBuff.append(" YY.QIND_CLIND_DESC QIND_CLIND_DESC, ");
	sqlBuff.append(" NVL(CLIND_ANALYSIS_STATUS,'0') CLIND_ANALYSIS_STATUS , ");
	sqlBuff.append(" NVL(Y.SYS_USER_CREATED,'E') TRN_SYS_USER_CREATED, ");
	sqlBuff.append(" NVL(YY.SYS_USER_CREATED,'E') MASTER_SYS_USER_CREATED, ");
	sqlBuff.append(" NVL(APPLICABLE_YN,'E') APPLICABLE_YN ,nvl(INCL_DIAG_CODE,' ') "); sqlBuff.append(" INCL_DIAG_CODE,nvl(INCL_PROC_CODE,' ') INCL_PROC_CODE, ");
	sqlBuff.append(" NVL(INCL_FOR_YES_YN,'E')  INCL_FOR_YES_YN  ");
	sqlBuff.append(" FROM  (select   ");
	sqlBuff.append(" X.PATIENT_CLASS, X.FACILITY_ID FACILITY_ID,QIND_CLIND_ID QIND_CLIND_ID, ");
	sqlBuff.append(" SYS_USER_CREATED, CLIND_ANALYSIS_STATUS,");
	sqlBuff.append(" APPLICABLE_YN,nvl(INCL_DIAG_CODE,' ') INCL_DIAG_CODE, ");
	sqlBuff.append(" nvl(INCL_PROC_CODE,' ')  INCL_PROC_CODE, ");
	sqlBuff.append(" NVL(INCL_FOR_YES_YN,'E')  INCL_FOR_YES_YN ");
	sqlBuff.append(" from  PR_ENCOUNTER X,QA_QIND_ENCOUNTER_CLIND_TRN XX ");
	sqlBuff.append(" where  X.FACILITY_ID = XX.FACILITY_ID(+) AND ");
	sqlBuff.append(" X.ENCOUNTER_ID = XX.ENCOUNTER_ID(+) AND  ");
	sqlBuff.append(" X.FACILITY_ID=?  AND X.ENCOUNTER_ID=?) Y, ");
	sqlBuff.append(" QA_QIND_CLIND_VW YY,QA_QIND_DISCIPLINE_CLIND YYY, ");
	sqlBuff.append(" QA_QIND_FACILITY_CLIND YYYY ");
	sqlBuff.append(" WHERE YY.QIND_CLIND_ID = Y.QIND_CLIND_ID(+) AND ");
	sqlBuff.append(" YY.QIND_CLIND_ID = YYY.QIND_CLIND_ID(+) AND ");
	sqlBuff.append(" YY.QIND_CLIND_ID = YYYY.QIND_CLIND_ID AND ");
	sqlBuff.append(" QIND_DISCIPLINE_ID =? AND ");
	sqlBuff.append(" YYYY.OPERATING_FACILITY_ID= ?                 AND    'Y' = DECODE(?,'EM',PATIENT_CLASS_EM,'OP',PATIENT_CLASS_OP,'IP',PATIENT_CLASS_IP, 'DC',PATIENT_CLASS_DC )              	 ORDER BY to_number(YY.QIND_CLIND_ID)");

	}
            _bw.write(_wl_block5Bytes, _wl_block5);
if (!(start <= 1) || !( (start+14) > maxRecord ))
		{
            _bw.write(_wl_block6Bytes, _wl_block6);
}else{
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start-14));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end-14));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}

	if ( !( (start+14) > maxRecord ) )
	{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start+14));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end+14));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getParameter("PATIENT_NAME")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getParameter("PATIENT_ID")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getParameter("QIND_DISCIPLINE_DESC")));
            _bw.write(_wl_block16Bytes, _wl_block16);
 try
		{ 	 if(pstmt!=null) pstmt.close();
			pstmt=conn.prepareStatement(sqlBuff.toString());
			pstmt.setString(1,request.getParameter("FACILITY_ID"));
			pstmt.setString(2,request.getParameter("ENCOUNTER_ID"));
			pstmt.setString(3,request.getParameter("QIND_DISCIPLINE_ID"));
			pstmt.setString(4,request.getParameter("FACILITY_ID"));
			pstmt.setString(5,strPatientClass);
			rset=pstmt.executeQuery();
	
	      if( start != 1 )
	      for( int j=1; j<start; i++,j++ )
		  {
	         rset.next() ;
          }
			
		 while(rset.next()&& i<=end)
		 {	 
			strClindId = rset.getString("QIND_CLIND_ID");
			strClindDes = rset.getString("QIND_CLIND_DESC");
			strUserSystem = rset.getString("TRN_SYS_USER_CREATED");
			strMasterUserSystem = rset.getString("MASTER_SYS_USER_CREATED");
			strClindAnalysisStatus = rset.getString("CLIND_ANALYSIS_STATUS");
			strApplicableYN = rset.getString("APPLICABLE_YN");
			strInclProcCode	= rset.getString("INCL_PROC_CODE");
			strInclDiagCode = rset.getString("INCL_DIAG_CODE");
			strInclusiveYN =  rset.getString("INCL_FOR_YES_YN");
			if(class_value.equals("QRYEVEN"))
			class_value = "QRYODD";
		 	else
			class_value = "QRYEVEN";

			if(strClindAnalysisStatus.equals("5"))
			classes=" class='Yellow'";
			else if(strClindAnalysisStatus.equals("9"))
			classes=" class='Green'";
			else if (strMasterUserSystem.equalsIgnoreCase("S"))
			classes=" class='brown'";
			else
			classes="";
            
			if(strUserSystem.equalsIgnoreCase("S"))
		    strDescUserSystem="System";
			else if(strUserSystem.equalsIgnoreCase("D"))
			strDescUserSystem="User";
			else
			strDescUserSystem="&nbsp;";

			if (strInclusiveYN.equalsIgnoreCase("Y"))
			{
			    	//strRadioSelected1 = "checked";
					//strRadioSelected2="";
			}
			else if (strInclusiveYN.equalsIgnoreCase("N"))
			{
			    	//strRadioSelected1 = "";
					//strRadioSelected2="checked ";
			}
			else
			{
			    	//strRadioSelected1 = " ";
					//strRadioSelected2=" ";
			}


          	if(strApplicableYN.equalsIgnoreCase("E"))
			{
					strApplicableText = "NA";
			}
				else
				{
					strApplicableText = " ";
				}
				String tempString = strClindId+"||"+strMasterUserSystem+"||"+strUserSystem+"||"+strClindDes+"||"+strInclProcCode+"||"+strInclDiagCode+"||"+strClindAnalysisStatus+"||"+k;
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classes));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(k++));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strClindId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(k));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tempString));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strClindDes));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strDescUserSystem));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strApplicableText));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(k));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k));
            _bw.write(_wl_block33Bytes, _wl_block33);
i++;	}
	 if(rset!=null) rset.close();
	 if(pstmt!=null) pstmt.close();
	}catch(Exception e)
		{
		}
	if((sqlCountBuff != null) && (sqlCountBuff.length() > 0))
	{
		sqlCountBuff.delete(0,sqlCountBuff.length());
	}
	if((sqlBuff != null) && (sqlBuff.length() > 0))
	{
		sqlBuff.delete(0,sqlBuff.length());
	}
  }
  catch(Exception e)
  {
		out.println("Err="+e);
  }
  finally
  {
	    ConnectionManager.returnConnection(conn, request);
  }

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(from));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(k));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(StrDisciplineID));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strQueryParam));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(StrDisciplineDesc));
            _bw.write(_wl_block45Bytes, _wl_block45);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
