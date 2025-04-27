package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __viewcareplancriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ViewCarePlanCriteria.jsp", 1736942409116L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="facilty_id<!DOCTYPE html>\n<html>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link><link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<!--<script src=\"../../eCP/js/common.js\" language=\"JavaScript\"></script>-->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<!--<script src=\"../../eCommon/js/MstCodeCommon.js\" language=\"javascript\"></script>-->\n<script src=\"../../eCP/js/ViewCarePlan.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCP/js/CpMessages.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body OnMouseDown=\'CodeArrest()\' onload=\'Load_Diagnosis()\'>\n<form name=\'view_cp_crit\' id=\'view_cp_crit\'>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<tr style=\'display:";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =";\'>\n\t<td class=\'label\' align=\'right\' width=\'12%\'>Source</td>\n\t<td width=\'50%\'>&nbsp;&nbsp;\n\t\t<SELECT name=\"view_src\" id=\"view_src\" onchange=\'popuval()\'>\n\t\t\t<option value=\"\">--------Select--------</option>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t</SELECT>&nbsp;<SELECT name=\"view_ind\" id=\"view_ind\">\n\t\t\t<option value=\"\">---Select---</option>\n\t\t</SELECT><img src=\"../../eCommon/images/mandatory.gif\">\n\t</td>\n\t<td colspan=4></td>\n</tr>\n<tr>\n\t<td class=\'label\' align=\'right\' width=\'12%\'>Care Manager</td>\n\t<td width = \'30%\'>&nbsp;<INPUT TYPE=\"text\" name=\"view_cp_care_mnagr\" id=\"view_cp_care_mnagr\"  value=\"\" size=\"30\" onblur=\"show_CareManager(this,view_cp_care_mnagr,care_manager_id);\"><input type=\"hidden\" name=\"care_manager_id\" id=\"care_manager_id\" value=\"\"><INPUT TYPE=\"button\" class=\"button\" value=\"?\" onClick=\"show_CareManager(this,view_cp_care_mnagr,care_manager_id);\">\n\t</td>\n\t<td class=\'label\' align=\'right\' width=\'6%\'>&nbsp;Diagnosis</td>\n\t<td colspan=\'2\'>&nbsp;<select name=\"view_diag\" id=\"view_diag\" onchange=\"Load_Diagnosis();\">\n\t\t\t<option value=\"\">------Select------</option>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t</select>&nbsp;<select name=\"diagnosis\" id=\"diagnosis\">\n\t<option value=\"\">---Select---</option>\n\t</select>\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' align=\'right\' width=\'12%\'>Period From</td>\n\t<td class=\'label\' width=\'20%\'>&nbsp;<input name=\'view_frmdate\' id=\'view_id_frmdate\' type=\'text\' size=\'8\' maxlength=\'10\' value=\'\' onBlur=\"CheckDate(this)\" onKeyPress=\'return AllowDateFormat(event);\'><img  name=\'view_frmdate_img\' src=\'../../eCommon/images/CommonCalendar.gif\' onclick=\"return showCal(view_frmdate,\'view_id_frmdate\');\">&nbsp;&nbsp;To&nbsp;<input name=\'view_todate\' id=\'view_id_todate\' type=\'text\' size=\'8\' maxlength=\'10\' value=\'\' onBlur=\"CheckDate(this);chkfrmdate()\" onKeyPress=\'return AllowDateFormat(event);\'><img  name=\'view_todate_img\' id=\'view_todate_img\'  src=\'../../eCommon/images/CommonCalendar.gif\' onclick=\"return showCal(view_todate,\'view_id_todate\');\">\n\t</td>\n\t<td class=\'label\' align=\'right\'>View&nbsp;</td>\n\t<td colspan=\'2\'>&nbsp;<SELECT name=\"view_plans\" id=\"view_plans\"><option value=\'A\'>Active Plans</option><option value=\'L\' selected>All Plans</option></SELECT>&nbsp;<input name=\"view_summary\" id=\"view_summary\" type=\"hidden\" value=\"D\"></td>\n</tr>\n<tr >\n\t<td class=\'label\' align=\'right\' width=\'12%\' ><font style=\'visibility:";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =";\'>Patient ID&nbsp;</font></td>\n\t<td width=\'20%\' >&nbsp;&nbsp;<INPUT TYPE=\"text\" name=\"patient_id\" id=\"patient_id\" size=\"15\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" style=\'visibility:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";\' ><INPUT TYPE=\"button\" class=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" onclick=\"PatientSearch()\" style=\'visibility:";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\'>\n\t</td>\n\t<td colspan=\'2\'></td>\n\t<td align=\'right\'><INPUT TYPE=\"button\" class=\"button\" value=\"Search\" onclick=\"callresult();\"><INPUT TYPE=\'button\' class=\'button\' value=\'Clear\' onclick=\'clearresult()\'></td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" name=\"facilty_id\" id=\"facilty_id\">\n<input type=hidden name=\"p_patient_id\" id=\"p_patient_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" name=\"encounter_id\" id=\"encounter_id\">\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" name=\"location_code\" id=\"location_code\">\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" name=\"location_type\" id=\"location_type\">\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\"Sex\"  id=\"Sex\">\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" name=\"Age\" id=\"Age\">\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" name=\"Dob\" id=\"Dob\">\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" name=\"relationship_id\" id=\"relationship_id\">\n<INPUT TYPE=\"hidden\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" name=\"patient_class\" id=\"patient_class\">\n<INPUT TYPE=\"hidden\"  name=\"prevNextPlan_id\" id=\"prevNextPlan_id\" value=\"\" >\n\n</form>\n<script>\ncallresult();\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String p_pract_id = (String)session.getAttribute("ca_practitioner_id");
	String facilty_id = (String)session.getAttribute("facility_id");
	Connection con = ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	ResultSet rs = null;
	PreparedStatement stmt_pract=null;
    ResultSet rset_pract=null;  
	String readonly = "";
	String disable = "";
	String display="", visible="";;
	String pract_name="";
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String p_patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String Sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
	String Age = request.getParameter("Age")==null?"":request.getParameter("Age");
	String Dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
	String relationship_id = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String sql_pract="select practitioner_name from am_practitioner where practitioner_id=?";
	try
	{
	stmt_pract=con.prepareStatement(sql_pract);
	stmt_pract.setString(1,p_pract_id);
	rset_pract=stmt_pract.executeQuery();
	if(rset_pract!=null)
	{
		while(rset_pract.next())
		{
			pract_name=rset_pract.getString("practitioner_name");
		}
	}
	if(!p_patient_id.equals(""))
	{
		readonly = "readonly"; 
		disable = "disabled"; 
		display = "none";
		visible	= "hidden";
	}
	String sql_source = "Select locn_type, short_desc from am_care_locn_type where care_locn_type_ind in ('C','N') order by short_desc ";

		stmt = con.prepareStatement(sql_source);
		rs = stmt.executeQuery();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(display));
            _bw.write(_wl_block5Bytes, _wl_block5);

			if(rs!=null)
			{
				while(rs.next())
				{
					out.println("<option value='"+rs.getString("locn_type")+"'>"+rs.getString("short_desc")+"</option>");
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sql_diag = "select term_set_id from mr_term_set_for_facility where facility_id = ?  order by term_set_id";
	stmt = con.prepareStatement(sql_diag);
	stmt.setString(1,facilty_id);
	rs = stmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{
					out.println("<option value='"+rs.getString("term_set_id")+"'>"+rs.getString("term_set_id")+"</option>");
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(visible));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(visible));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(visible));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
		System.out.println("Exception in ViewCarePlanCriteria.jsp="+e.toString());
	}
	finally
	{
		try
		{
		if(rs!=null) rs.close();
		if(rset_pract!=null) rset_pract.close();
		if(stmt_pract!=null) stmt_pract.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
					System.out.println(e.toString());
			e.printStackTrace(System.err);

		}
	}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facilty_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
