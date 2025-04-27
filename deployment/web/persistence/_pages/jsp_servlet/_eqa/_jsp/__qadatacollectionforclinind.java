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

public final class __qadatacollectionforclinind extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QADataCollectionForClinInd.jsp", 1742817542897L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\"  language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\"\t\t  language=\"javascript\"> </script>\n\t<script src=\"../../eCommon/js/dchk.js\"\t\t\t  language=\"javascript\"> </script>\n\t<Script src=\"../../eQA/js/QAMessages.js\"  language=\"JavaScript\"></Script>\n\t<Script src=\"../../eQA/js/QADataCollectionForClinInd.js\" language=\"JavaScript\"></Script>\n\t<script language=\'javascript\' src=\'../js/NoteDisclaimer.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"QABGEngine\" id=\"QABGEngine\" action=\"../../servlet/eQA.QADataCollectionForClinIndServlet\" method=\"post\" target=\"messageFrame\">\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<br>\n<br><BR><BR><BR>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"60%\" align=\'center\'>\n<tr><td colspan=6>&nbsp</td></tr>\n<tr>\n\t\t<td> &nbsp;</td>\n\t\t<td> &nbsp;</td>\n\t\t<td>&nbsp;</td>\n\t   <td class=label><b> From</b></td>\n\t   <td class=label><b>To</b></td>\n\t   <td class=label><b>Run</b></td>\n\t</tr>\n     <tr >\n  \t  <td> &nbsp; </td>\n      <td> &nbsp;</td>\n\t  \n\t  <td align=\"right\" align =\'left\' class=\"label\"><!-- <b>Inpatient</b> -->&nbsp;&nbsp;</td>\n\t\t\n     <td class=\"label\" align=\'left\'> \n\t  <INPUT TYPE=\"text\" id=\'IP_FROM\' name=\"PROC_DATE_IP_FROM\"  size=17 maxlength=20   value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'  readonly ><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'IP_FROM\');\" disabled>\n     <td>\n          <INPUT TYPE=\"text\" id=\'IP_TO\' name=\"PROC_DATE_IP_TO\"  size=17 maxlength=20   value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' onkeypress=\"return chkchar(this,event)\"; onBlur=\'ValidateDateTimesp(forms[0].IP_FROM,this)\' ><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'IP_TO\',null,\'hh:mm:ss\') ;\">\n\t\t  </td>\n            <td  align=left> <INPUT TYPE=\"checkbox\" name=\"ipgenerate\" id=\"ipgenerate\"  checked value=\"Y\" onClick=\'checkyn(this)\'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> \n\t  \n\t </tr>\n\n\t <tr><td colspan=6>&nbsp</td></tr>\n\n<!-- <tr>\n\t  <td> &nbsp; </td>\n      <td> &nbsp;</td>\n\t  <td align=\"right\" align =\'left\' class=\"label\"><b>Daycare</b>&nbsp;&nbsp;</td>\n     <td class=\"label\" align=\'left\'>\n      <INPUT TYPE=\"text\" id=\'DC_FROM\' name=\"PROC_DATE_DC_FROM\" id=\"PROC_DATE_DC_FROM\" size=17 maxlength=20     value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' readonly><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'DC_FROM\');\" disabled></td>\n\t\n     <td> \n\t\t <INPUT TYPE=\"text\" id=\'DC_TO\' name=\"PROC_DATE_DC_TO\" id=\"PROC_DATE_DC_TO\" size=17 maxlength=20  value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' onkeypress=\"return chkchar(this,event)\"; onBlur=\'ValidateDateTimesp(forms[0].DC_FROM,this)\'><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'DC_TO\',null,\'hh:mm:ss\');\">&nbsp\n\t  </td>\n <td > <INPUT TYPE=\"checkbox\" name=\"dcgenerate\" id=\"dcgenerate\" value=\"Y\"  checked onClick=\'checkyn(this)\'> </td> \n</tr>\n\n\t \t<tr><td colspan=6>&nbsp</td></tr>\n<tr >\n  \t  <td> &nbsp; </td>\n       <td> &nbsp; </td>\n      <td align=\"right\" align =\'right\' class=\"label\"><b>Emergency</b>&nbsp;&nbsp;</td>\n\n     <td class=\'Label\' align=\'left\'>\n      <INPUT TYPE=\"text\" id=\'EM_FROM\' name=\"PROC_DATE_EM_FROM\" id=\"PROC_DATE_EM_FROM\" size=17 maxlength=20   value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  readonly><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'EM_FROM\');\" disabled></td>\n    \n     <td> <INPUT TYPE=\"text\" id=\'EM_TO\' name=\"PROC_DATE_EM_TO\" id=\"PROC_DATE_EM_TO\" size=17 maxlength=20  value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onkeypress=\"return chkchar(this,event)\";\t  onBlur=\'ValidateDateTimesp(forms[0].EM_FROM,this)\'><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'EM_TO\',null,\'hh:mm:ss\');\">&nbsp\n\t  </td>\n\n<td > <INPUT TYPE=\"checkbox\" name=\"emgenerate\" id=\"emgenerate\" value=\"Y\"  checked onClick=\'checkyn(this)\'> </td> \n</tr>\n\t<tr><td colspan=6>&nbsp</td></tr>\n<tr >\n  \t <td> &nbsp; </td> \n     <td> &nbsp; </td>\n      <td align=\"right\" align =\'right\' class=\"label\"><b>Outpatient</b>&nbsp;&nbsp;</td>\n\n     <td class=\"label\" align=\'left\'>\n      <INPUT TYPE=\"text\" id=\'OP_FROM\' name=\"PROC_DATE_OP_FROM\" id=\"PROC_DATE_OP_FROM\" size=17 maxlength=20\t   value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  readonly><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'OP_FROM\');\" disabled></td>\n\t\n     <td> <INPUT TYPE=\"text\" id=\'OP_TO\' name=\"PROC_DATE_OP_TO\" id=\"PROC_DATE_OP_TO\" size=17 maxlength=20   value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onkeypress=\"return chkchar(this,event)\"; onBlur=\'ValidateDateTimesp(forms[0].OP_TO,this)\'><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'OP_TO\',null,\'hh:mm:ss\');\">&nbsp\n  </td>\n<td > <INPUT TYPE=\"checkbox\" name=\"opgenerate\" id=\"opgenerate\" value=\"Y\"  checked onClick=\'checkyn(this)\'> </td> \n</tr>  -->\n<tr><td colspan=6>&nbsp</td></tr>\n</table>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n Exception Occured ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t<input type=\'hidden\' name=\'ip_StartDate\' id=\'ip_StartDate\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type=\'hidden\' name=\'dc_StartDate\' id=\'dc_StartDate\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type=\'hidden\' name=\'op_StartDate\' id=\'op_StartDate\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=\'hidden\' name=\'em_StartDate\' id=\'em_StartDate\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=\'hidden\' name=\'ip_EndDay\' id=\'ip_EndDay\'\t value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t<input type=\'hidden\' name=\'dc_EndDay\' id=\'dc_EndDay\'\t value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\'hidden\' name=\'op_EndDay\' id=\'op_EndDay\'\t value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<input type=\'hidden\' name=\'em_EndDay\' id=\'em_EndDay\'\t value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n</form>\n</body>\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

  String ip_StartDate="",ip_EndDay="",op_StartDate="",op_EndDay="",
  dc_StartDate="",
  dc_EndDay="",em_StartDate="",em_EndDay="";


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
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	Connection conn          = null;
	PreparedStatement pstmt  = null;
	ResultSet rs             = null;
	try
	{
		String qaparm            = "select count(*) from qa_qind_param";
		conn					 = ConnectionManager.getConnection(request);
		pstmt                    = conn.prepareStatement(qaparm);
		rs                       = pstmt.executeQuery();
		rs.next();
		if(rs.getInt(1)==0)
		{
			out.println("<script>alert(getMessage('QA_PARAM_NOT_FOUND'));parent.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		 
		}
		else
		{
			if (rs != null ) rs.close();
			if (pstmt != null) pstmt.close();
			String sql="select to_char((SYS_REC_PROC_UPTO_DATE_IP),'dd/mm/yyyy hh24:mi:ss') IP_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') IP_TO_DAY, to_char(SYS_REC_PROC_UPTO_DATE_DC,'dd/mm/yyyy hh24:mi:ss') DC_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') DC_TO_DAY, to_char(SYS_REC_PROC_UPTO_DATE_OP,'dd/mm/yyyy hh24:mi:ss') OP_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') OP_TO_DAY , to_char(SYS_REC_PROC_UPTO_DATE_EM,'dd/mm/yyyy hh24:mi:ss') EM_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') EM_TO_DAY, to_char(SYS_REC_PROC_UPTO_DATE_XT,'dd/mm/yyyy hh24:mi:ss') XT_START_DAY,to_char((SYSDATE),'dd/mm/yyyy hh24:mi:ss') XT_TO_DAY from QA_QIND_PARAM";
			//java.util.Date dat=new java.util.Date();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{	 
				ip_StartDate=rs.getString("IP_START_DAY");			
				if(ip_StartDate==null)
				ip_StartDate="01/01/1900 12:00:01";
				ip_EndDay=rs.getString("IP_TO_DAY");

				dc_StartDate=rs.getString("DC_START_DAY");
				if(dc_StartDate==null)
				dc_StartDate="01/01/1900 12:00:01";
				dc_EndDay=rs.getString("DC_TO_DAY");

				em_StartDate=rs.getString("EM_START_DAY");
				if(em_StartDate==null)
				em_StartDate="01/01/1900 12:00:01";
				em_EndDay=rs.getString("EM_TO_DAY");

				op_StartDate=rs.getString("OP_START_DAY");
				if(op_StartDate==null)
				op_StartDate="01/01/1900 12:00:01";
				op_EndDay=rs.getString("OP_TO_DAY");
 			}
		if (rs != null ) rs.close();
		if (pstmt != null) pstmt.close();
	   }

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(ip_StartDate));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(ip_EndDay));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(dc_StartDate));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(dc_EndDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(em_StartDate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(em_EndDay));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(op_StartDate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(op_EndDay));
            _bw.write(_wl_block13Bytes, _wl_block13);

   }
	catch(Exception ee)
	{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ee));
            _bw.write(_wl_block1Bytes, _wl_block1);

 }
finally
{
	ConnectionManager.returnConnection(conn, request);
}	

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ip_StartDate));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dc_StartDate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(op_StartDate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(em_StartDate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ip_EndDay));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dc_EndDay));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(op_EndDay));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(em_EndDay));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
