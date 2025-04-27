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

public final class __qaanalyzepartialindcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAAnalyzePartialIndCriteria.jsp", 1742817542386L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<head>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="   \n <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eQA/js/QAAnalyzePartialIndicators.js\" language=\"javascript\"></script>\n<script src=\"../../eQA/js/QAMessages.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n\n\n<body onload=\'FocusFirstElement()\' onKeyDown = \'lockKey()\' onMouseDown=\"CodeArrest();\">\n<form name=\"QA_SEARCH_FORM\" id=\"QA_SEARCH_FORM\" action=\"QAAnalyzePartialIndSearchResult.jsp\" method=\"post\"  target=\'query_result\'>\n\n \n \n <table  width=\'100%\' align=\"center\" cellpadding=\'3\' cellspacing=\'0\' border=\'0\'>\n<tr>\n<td   class=\"label\" align=\"right\" nowrap>&nbsp;Period From&nbsp;</td>\n<td align=left><input type=\'text\' name=\'PERIOD_FROM\' id=\'PERIOD_FROM\' value=\'\'  onBlur=\"CheckDate(this)\" size=10 maxlength=10><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'PERIOD_FROM\');\" >&nbsp;</td>\n<td class=label align=right>&nbsp;To&nbsp;</td>\n<td align=left><input type=\'text\' name=\'PERIOD_TO\' id=\'PERIOD_TO\' value=\'\' onBlur=\"CheckDate(this)\" size=10 maxlength=10><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendar(\'PERIOD_TO\');\">\n</td>\n\t<td width=\"\" class=\"label\" align=\"right\"  nowrap>&nbsp;Patient Class&nbsp;</td>\n\t<td align=\'left\'><select name=\'PATIENT_CLASS\' id=\'PATIENT_CLASS\' onChange=\'clearResult()\'>\n\t\t<option value=\'\'>&nbsp;---- Select ---&nbsp</option>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</option>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</select>&nbsp;\n\t</td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</tr>\n\n\t<tr>\n<td width=\"\" class=\"label\" align=\"right\"  nowrap>&nbsp;Clinical Group&nbsp;</td>\n\t<td align=\'left\' ><select name=\'clinical_group\' id=\'clinical_group\' onChange=\'getClindInd(),clearResult()\'>\n\t\t<option value=\'\'>&nbsp;---------------- Select ---------------&nbsp</option>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</select>\n</td>\n\t\t<td width=\"\" class=\"label\" align=\"right\"  nowrap>&nbsp;Clinical Indicator&nbsp;</td>\n\t<td align=\'left\' colspan=\'3\' ><select name=\'clinical_ind\' id=\'clinical_ind\' onChange=\'clearResult()\'>\n\t\t<option value=\'\'>&nbsp;---------------- Select ---------------&nbsp</option>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t <option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option> \n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</select>&nbsp;\n</td>\n</tr>\n\n<tr>\n<td class=label align=\'right\' >&nbsp;Status&nbsp;</td>\n<td align=\'left\'><select name=\'STATUS\' id=\'STATUS\' onChange=\'clearResult()\'>\n\t\t<option value=\'Partial\' selected>Partial &nbsp;</option>\n\t\t<option value=\'Complete\' >Complete&nbsp;</option>\n\t\t<option value=\'All\' >All&nbsp;</option>\n\t\t</select>\n</td> \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<td class=label  align=right nowrap>&nbsp;Patient ID&nbsp;</td>\n<td nowrap><input type=\'text\' name=\'PatientId\' id=\'PatientId\' value=\"\" size=\'20\' maxlength=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'onBlur=\"makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);\" onKeypress=\'return CheckForSpecChars(event);\'  >\t\t\t\t\t\t\n<input type=\'button\' class=\'button\' value=\'?\' name=\'pat_button\' id=\'pat_button\' onClick=\"funPatient();\" >\n</td>\n<td CLASS=\'LABEL\' align=\'right\'>Sentinel</td>\n<td align=\'left\'><select name=\'sentinel\' id=\'sentinel\' onChange=\'clearResult()\'>\n\t\t<option value=\'\' selected>Select &nbsp;</option>\n\t\t<option value=\'Y\' >Yes&nbsp;</option>\n\t\t<option value=\'N\' >No&nbsp;</option>\n\t\t</select></td>\n\n\n</tr>\n<tr>\n<td class=label align=right>Order By&nbsp;</td>\n<td><select name=\'ORDER_BY\' id=\'ORDER_BY\' onChange=\'clearResult()\'>\n<option value=\'ENCOUNTER_ID\' selected>Encounter Id&nbsp;</option>\n<option value=\'PATIENT_NAME\' >Patient Name&nbsp;\n<option value=\'ENCOUNTER_START_DATE\'>Admission Date&nbsp;\n</select></td>\n<td>&nbsp;<td>\n<td>&nbsp;\t</td>\n        <td colspan=2 nowrap align=right><input type=\'button\' class=\'button\' value=\'Search\' name=\'Search\' id=\'Search\'\n\t\tonClick=\'funQATransactionSearch(document.forms[0])\' ><input type=\'button\' class=\'button\' value=\'Clear\' name=\'Clear\' id=\'Clear\'\n\t\tonClick=\'clearPage()\'></td>\n<tr>\n</table>\n<input type=\'hidden\' name=\'sql\' id=\'sql\' value=\"\">\n</form>\n</body>\n\n</html>\n\n\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String pat_id_length ="";
try{
	conn					 = ConnectionManager.getConnection(request);
	pstmt                    = conn.prepareStatement("select count(*) from qa_qind_param");
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
	pstmt = conn.prepareStatement("select patient_class,short_desc FROM am_patient_class");
	 rs = pstmt.executeQuery();
	


            _bw.write(_wl_block4Bytes, _wl_block4);

	while(rs.next())
		{
		
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rs.getString("patient_class")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block7Bytes, _wl_block7);

		}
			
            _bw.write(_wl_block8Bytes, _wl_block8);
if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
	String clinic_class="select qind_group_id,qind_group_desc FROM qa_qind_group WHERE eff_status LIKE 'E'"; 
	pstmt = conn.prepareStatement(clinic_class);
	 rs = pstmt.executeQuery();
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	while(rs.next())
		{
		
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rs.getString("qind_group_id")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("qind_group_desc")));
            _bw.write(_wl_block7Bytes, _wl_block7);

		}
			
            _bw.write(_wl_block10Bytes, _wl_block10);

    if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();	 
	pstmt = conn.prepareStatement("select qind_clind_id,qind_clind_desc FROM qa_qind_clind");
	 rs = pstmt.executeQuery();

            _bw.write(_wl_block11Bytes, _wl_block11);

	while(rs.next())
		{
		
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs.getString("qind_clind_id")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("qind_clind_desc")));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
			
            _bw.write(_wl_block10Bytes, _wl_block10);

	if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();

            _bw.write(_wl_block14Bytes, _wl_block14);
if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
	pstmt = conn.prepareStatement("select patient_id_length from mp_param");
	 rs = pstmt.executeQuery();
	if (rs.next())
			{
				pat_id_length = rs.getString(1);
				

			}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block16Bytes, _wl_block16);
	}
	
	if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
	}catch(Exception e) 
		{
			e.printStackTrace();
		}
	finally{
    ConnectionManager.returnConnection(conn,request);
	}
	
	
	
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
