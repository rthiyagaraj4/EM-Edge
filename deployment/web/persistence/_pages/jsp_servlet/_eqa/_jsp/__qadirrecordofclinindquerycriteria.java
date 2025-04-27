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

public final class __qadirrecordofclinindquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QADirRecordOfClinIndQueryCriteria.jsp", 1742817543293L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eQA/js/QADirRecordOfClinIndicators.js\" language=\"javascript\"></script>\n<script src=\"../../eQA/js/QAMessages.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n\n\n\n<body onload=\'FocusFirstElement()\' onKeyDown = \'lockKey()\' onMouseDown=\"CodeArrest();\">\n<form name=\"QA_SEARCH_FORM\" id=\"QA_SEARCH_FORM\" action=\"\" method=\"post\"  target=\'query_result\'>\n\n \n<INPUT TYPE=\"hidden\" name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'>\n <table  width=\'100%\' align=\"center\" cellpadding=\'0\' cellspacing=\'0\' border=\'0\'>\n<tr>\n<td class=label  align=right nowrap>Enconter ID&nbsp;</td>\n<td align=left><Input type =text name=\'ENCOUNTER_ID\' id=\'ENCOUNTER_ID\' size=\'13\' maxlength=\'12\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this)\'></td>\n\n <td width=\"\" class=\"label\" align=\"left\"  nowrap>&nbsp;Patient Class&nbsp;</td>\n\t<td>\t<select name=\'PATIENT_CLASS\' id=\'PATIENT_CLASS\' onChange=\'clearResult()\'>\n\t\t<option value=\'\'>&nbsp;---- Select ---&nbsp</option>\n\t\t<option value=\'DC\'>Day Care</option>\n\t\t<option value=\'EM\' >Emergency&nbsp;</option>\n\t\t<option value=\'IP\'>Inpatient&nbsp;</option>\n\t\t<option value=\'OP\'>Outpatient&nbsp;</option>\n\t\t</select>&nbsp;&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n</td>\n\n<td class=label  align=right nowrap>&nbsp;Patient ID&nbsp;</td>\n<td nowrap><input type=\'text\' name=\'PatientId\' id=\'PatientId\' value=\"\" size=\'\' maxlength=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" onBlur=\"makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);\" onKeypress=\'return CheckForSpecChars(event);\'  >\t\t\t\t\t\t\n<input type=\'button\' class=\'button\' value=\'?\' name=\'pat_button\' id=\'pat_button\' onClick=\"funPatient()\" >\n</td>\n</tr>\n\n<tr>\n<td align=right class=label nowrap>Location&nbsp;</td>\n<td><input type=\"text\" name =\"ASSIGN_CARE_LOCN_CODE\" maxlength=\"6\" size=\"15\" onBlur=\'if ((ASSIGN_CARE_LOCN_CODE.value !=\"\") && (ASSIGN_CARE_LOCN_CODE.value !=null))  {getLocation(this,target); checkCodes(this);}\'  > <input type=\'button\' class=\'button\' value=\'?\' name=\'loc_button\' id=\'loc_button\' onClick=\"getLocation(this,target);\" ></td> \n<td align=\"right \"  class=\"label\" nowrap>&nbsp;Period From&nbsp;</td>\n<td align=left><input type=\'text\' name=\'PERIOD_FROM\' id=\'PERIOD_FROM\' value=\'\'  onBlur=\"CheckDate(this)\" size=10 maxlength=10>\n<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'PERIOD_FROM\');\" ></td>\n<td class=label align=right>To&nbsp;</td>\n<td align=left><input type=\'text\' name=\'PERIOD_TO\' id=\'PERIOD_TO\' value=\'\' onBlur=\"CheckDate(this)\" size=10 maxlength=10>\n<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendar(\'PERIOD_TO\');\">\n</td>\n\n</tr>\n\n<tr>\n<td align=\"right\" class=\"label\"  nowrap>Practitioner ID&nbsp;</td>\n<td align=\'left\'><input type=\"text\" name =\"PRACTITIONER_ID\" maxlength=\"30\" size=\"20\" onBlur=\'if ((PRACTITIONER_ID.value !=\"\") && (PRACTITIONER_ID.value !=null))  { funQAPractioner(this,target);checkCodes(this);}  \'>\n<input type=\'button\' class=\'button\'  name=\'pract_button\' id=\'pract_button\' value=\'?\' onclick=\"funQAPractioner(PRACTITIONER_ID,target)\">\n<input type=\'hidden\' name=\'PRACTITIONER_NAME\' id=\'PRACTITIONER_NAME\' value=\'\'></td>\n<td class=label align=right >&nbsp;Status&nbsp;</td>\n<td>\t<select name=\'STATUS\' id=\'STATUS\' onChange=\'\'>\n\t\t<option value=\'1\'>Open &nbsp;</option>\n\t\t<option value=\'2\' >Closed&nbsp;\n\t\t<option value=\'\' selected>All&nbsp;\n\t\t</select>\n</td>     \n\n<td  class=\'label\' align=right> \n\tInclude Analyzed Encounters \t\t\t\t\t\t\t\n<td><input type=\"checkbox\" name=\"INCL_ANALYZED_YN\" id=\"INCL_ANALYZED_YN\" value=\"N\" onClick=\'Incl_Encounter(); \'> </td>\n\n</tr>\n<tr>\n<td class=label align=right>Order By&nbsp;</td>\n<td><select name=\'ORDER_BY\' id=\'ORDER_BY\' onChange=\'\'>\n<option value=\'ENCOUNTER_ID\' selected>Encounter Id&nbsp;</option>\n<option value=\'PATIENT_NAME\' >Patient Name&nbsp;\n<option value=\'VISIT_ADM_DATE_TIME\'>Admission Date&nbsp;\n</select></td>\n<td>&nbsp;<td>\n<td>&nbsp;\t</td>\n        <td colspan=2 nowrap align=right><input type=\'button\' class=\'button\' value=\'Search\' name=\'Search\' id=\'Search\'\n\t\tonClick=\'funQATransactionSearch(document.forms[0])\' >\n\t\t<input type=\'button\' class=\'button\' value=\'Clear\' name=\'Clear\' id=\'Clear\'\n\t\tonClick=\'clearPage()\' ></td> \n<tr>\n</table>\n \t\n</form>\n</body>\n\n</html>\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
	String qaparm            = "select count(*) from qa_qind_param";

String facilityid			=(String)session.getValue("facility_id");
   Statement stmt=null;
   ResultSet rs1=null;	
   String pat_id_length = "";
	Connection conn					 = ConnectionManager.getConnection(request);
	try{
	PreparedStatement pstmt                    = conn.prepareStatement(qaparm);
	ResultSet rs                       = pstmt.executeQuery();
	rs.next();
	if(rs.getInt(1)==0)
	{
	out.println("<script>alert(getMessage('QA_PARAM_NOT_FOUND'));parent.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		 
	}
	else
	{
	try
		{
			stmt = conn.createStatement();
			rs1	=	stmt.executeQuery("select patient_id_length from mp_param");
			if (rs1.next() && rs1 != null)
			{
				pat_id_length = rs1.getString(1);
				

			}
			if (rs1 != null ) rs1.close();
	     if (stmt != null) stmt.close();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block6Bytes, _wl_block6);
	}
	
	if (rs != null ) rs.close();
	if (pstmt != null) pstmt.close();
	}catch(Exception e1) 
		{
			e1.printStackTrace();
		}
	finally{
    ConnectionManager.returnConnection(conn,request);
	}
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
