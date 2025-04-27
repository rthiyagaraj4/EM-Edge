package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __recdiagnosisdifferentialgrouppopup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisDifferentialGroupPopup.jsp", 1740481568202L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n    ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n\t<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></SCRIPT>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body onKeyDown=\'lockKey()\'>\n\n<form name=\'diff_group\' id=\'diff_group\' action=\'../../servlet/eMR.RecDiagnosisDiffGroupServlet\' method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<!-- <div align=\'center\'> -->\n\t<table border=0  width=\'100%\' cellpadding=\'0\' cellspacing=\'0\'  align=center style=\'border-bottom:#ffffff\'>\n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t</table>\n\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<br><br>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\' >\n\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t</table>\n\t</div>\t\n\t\n\t<input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'\'>\n\t<input type=\'hidden\' name=\'qryStr\' id=\'qryStr\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t<input type=\'hidden\' name=\'grp_mode\' id=\'grp_mode\' value=\'\'>\n\t<input type=\'hidden\' name=\'curr_grp_id\' id=\'curr_grp_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'diff_mode\' id=\'diff_mode\' value=\'N\'>\n\t<input type=\'hidden\' name=\'record_count\' id=\'record_count\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t<input type=\'hidden\' name=\'group_count\' id=\'group_count\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type=\'hidden\' name=\'termValues\' id=\'termValues\' value=\'\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
 

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String patient_id = "";
	String  term_set_id = "";
	String strQry = "";

 	Connection con = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	PreparedStatement grp_pstmt = null;
	ResultSet grp_rs = null;
	
	String shortdesc = "";
	String classValue = "";
	String term_code = "";
	String occur_srl_no = "";
	String termVals = "";
	String term_set_code = " ";
	StringBuffer append_grpid = new StringBuffer("");
	StringBuffer temp_grpid = new StringBuffer("");

	String style_colr = "";
	String display_mode = "";
	String chk = "";

	int diff_grp_id = 0;
	int j=0;
	int k=0;
	int cnt  = 0;
	int currentdiffid=0,prevdiffid=0;
	int i=0,grpid = 0;
	int rec_cnt = 0;

	patient_id=request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");
	strQry=request.getQueryString();
	term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	
	display_mode=request.getParameter("display_mode")==null?"":request.getParameter("display_mode");
	term_set_code=request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	
try
{
	 con  = ConnectionManager.getConnection(request);
	 StringBuffer sql = new StringBuffer();

	 if(sql.length() > 0) sql.delete(0,sql.length());
	 sql.append("select a.term_set_id,a.term_code,a.TERM_CODE_SHORT_DESC SHORT_DESC,C.LONG_DESC, ");
	 sql.append("a.occur_srl_no,nvl(b.diff_group_id,'0') diff_group_id from pr_diagnosis a, ");
	 sql.append("pr_differential_diagnosis b, MR_TERM_CODE C where a.patient_id = ? "); 
	 sql.append("and a.term_set_id = ? and a.curr_accuracy_ind ='U' and CURR_STATUS ='A' ");
	 sql.append("and b.term_set_id(+)=a.term_set_id and ");
	 sql.append("b.term_code(+)=a.term_code  AND b.occur_srl_no(+) = a.occur_srl_no and "); 
	 sql.append("C.TERM_SET_ID=a.term_set_id AND C.TERM_CODE=a.term_code AND b.patient_id(+) = a.patient_id ORDER BY "); 
	 sql.append("b.diff_group_id, a.term_code");
	 pstmt=con.prepareStatement(sql.toString());
	 pstmt.setString(1,patient_id);
	 pstmt.setString(2,term_set_id);
	 rs=pstmt.executeQuery();

	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append("select distinct diff_group_id from ");
	sql.append("pr_differential_diagnosis where patient_id = ? and TERM_SET_ID=? and FINALIZED_YN='N' order by diff_group_id ");
	 
	 grp_pstmt = con.prepareStatement(sql.toString());
	 grp_pstmt.setString(1,patient_id);
	 grp_pstmt.setString(2,term_set_id);
	 grp_rs = grp_pstmt.executeQuery();	

		while(grp_rs.next())
		{
			diff_grp_id = grp_rs.getInt(1);
			//if(diff_grp_id>0)
			{
				cnt++;
				append_grpid.append(diff_grp_id);
				temp_grpid.append(cnt);
				if(cnt > 0){
					append_grpid.append("|");
					temp_grpid.append("|");
				}
			}
		}
		
		if(grp_rs!=null)
				grp_rs.close();
		if(grp_pstmt!=null)
				grp_pstmt.close();

		if ( (append_grpid.toString()).equals(""))
		{	
			if ( append_grpid != null ) append_grpid.delete(0,append_grpid.length());
			append_grpid.append("0");
		}

            _bw.write(_wl_block6Bytes, _wl_block6);
	while(rs.next())
	{
		rec_cnt++;
		shortdesc			= rs.getString("SHORT_DESC");
		currentdiffid		= rs.getInt("diff_group_id");
		term_code	    = rs.getString("term_code");
		occur_srl_no	    = rs.getString("occur_srl_no");
		
		termVals        = term_set_id+"|"+term_code+"|"+occur_srl_no+"|"+currentdiffid;
		termVals		=java.net.URLEncoder.encode(termVals);

		if(term_set_code.equals(term_code) && display_mode.equals("result_page")){
			style_colr = "RED";
			chk = "checked";
		}
		else{
			style_colr = "";
			chk = "";
		}

		if(currentdiffid!=0)
		{	
			if(j==0)
			{
				out.println("<Td class='COLUMNHEADER' colspan='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DifferentialDiagnosis.label","mr_labels")+"</Td></table>"); 
			}
			classValue= ((i%2) == 0) ? "QRYEVEN" : "QRYODD";
			out.println("<table border= 1  cellpadding='0' cellspacing='0'  width='100%' align='center' style='border-bottom:#ffffff'>");
			if(prevdiffid!=currentdiffid)
			{
				grpid++;
				out.println("<tr><td align='left' class='CAGROUPHEADING' colspan='2'><font color='black' size='1'>Group"+(grpid)+"</td></tr></table>");
			}
			out.println("<table border= 1 cellpadding='0' cellspacing='0' width='100%' align='center' style='border-bottom:#ffffff';");
			out.println("<tr><td class='"+classValue+"'  width='5%'><input type='checkbox' name ='termvals' id='"+(grpid)+ "' value='"+termVals+"' " +chk+" Onclick=\"return CheckMultiSelect('"+grpid+"')\"></td><td class='"+classValue+"' align = 'left'  valign='top' style='border-left: #B2B6D7;' >");
			out.println("<a href='javascript:' onClick=displayToolTip('"+termVals+"','"+append_grpid.toString()+"','"+currentdiffid+"','"+grpid+"','"+temp_grpid.toString()+"','U') onMouseOver='hideToolTip()'><font color='"+style_colr+"'> "+shortdesc+"</font></td>");
			out.println("</tr>");
			prevdiffid=currentdiffid;
			j++;
		}
			
	   if(currentdiffid==0)
	   {
		   if(k==0)
			 {
			out.println("<table border= 1 width='100%' cellpadding='0' cellspacing='0' align='center' style='border-bottom:#ffffff'>");
			out.println("<Td class='COLUMNHEADER' colspan='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.UngroupDiagnosis.label","mr_labels")+"</Td></table>"); 
			 }
			classValue= ((i%2) == 0) ? "QRYEVEN" : "QRYODD";
			out.println("<table border= 1 cellpadding='0' cellspacing='0' width='100%' align='center' style='border-bottom:#ffffff'>");
			out.println("<tr>");
			out.println("<td class='"+classValue+"' width='5%'><input type='checkbox' name ='termvals' " +chk+" value='"+termVals+"'></td>");
			out.println("<td class='"+classValue+"' align = 'left  valign='top' style='border-left:#B2B6D7;'><a href='javascript:' onClick=displayToolTip('"+termVals+"','"+append_grpid.toString()+"','"+currentdiffid+"','"+grpid+"','"+temp_grpid.toString()+"','N') onMouseOver='hideToolTip()'><font color='"+style_colr+"'>"+shortdesc+"</font></td>");
		  	out.println("</tr>");
			k++;
		}
	   i++;
	}
	
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

		if(i==0)
		out.println("<script>var error=getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common');alert(error); parent.parent.document.getElementById('dialog_tag').close(); </script>");
		out.println("<input type='hidden' name='countTermVal' id='countTermVal' value='"+k+"'>");
	
            _bw.write(_wl_block7Bytes, _wl_block7);
 
} 
	catch(Exception e)
	{
		//out.println("Exception in try@:"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strQry));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rec_cnt));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
