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

public final class __recdiagnosisdifferentialgrouppopup1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisDifferentialGroupPopup1.jsp", 1732535768375L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onKeyDown=\'lockKey()\'>\n\n<form name=\'new_diff_group\' id=\'new_diff_group\' action=\'../../servlet/eMR.RecDiagnosisDiffGroupServlet\' method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table border=0  width=\'100%\' cellpadding=\'0\' cellspacing=\'0\'  align=center style=\'border-bottom:#ffffff\'>\t\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<p>\n\t\t<!-- <table border=0 cellpadding=0 cellspacing=0 width=\'100%\'>\n\t\t\t<th align=\'left\' colspan=\'0\'>Current Diagnosis</th>\n\t\t\t<tr><td class=\'label\'><B>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<B></td></tr>\n\t\t\t<tr><td class=\'label\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td></tr>\n\t\t\t<tr><td colspan=\'2\'></td></tr>\n\t\t</table> -->\n\t\t<p>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<br><br>\n\t<input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'qryStr\' id=\'qryStr\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type=\'hidden\' name=\'grp_mode\' id=\'grp_mode\' value=\'\'>\n\t<input type=\'hidden\' name=\'curr_grp_id\' id=\'curr_grp_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type=\'hidden\' name=\'term_set_code\' id=\'term_set_code\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=\'hidden\' name=\'occur_srl_no\' id=\'occur_srl_no\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=\'hidden\' name=\'termValues\' id=\'termValues\' value=\'\'>\n\t<input type=\'hidden\' name=\'diff_mode\' id=\'diff_mode\' value=\'Y\'>\n\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\n</form>\t\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	PreparedStatement pstmt_extgrp = null;
	ResultSet rs_extgrp = null;
	
	String patient_id = "";
	String term_set_id = "";
	String strQry = "";
	String term_set_code = "";
	String diff_group_id	= "";
	String diag_Description	= "";
	String shortdesc	= "";
	String occur_srl_no	= "";
	String mode	= "";
	String flag	= "";

	int currentdiffid=0;
	int prevdiffid=0;
	int i=0,grpid = 0;
	int grp_id_temp=0;
	
	String classValue = "";
	String Differ_flag = "";
	
	patient_id=request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");
	strQry=request.getQueryString();
	term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	term_set_code = request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	occur_srl_no=request.getParameter("occur_srl_no")==null?"":request.getParameter("occur_srl_no");
	diag_Description = request.getParameter("diag_Description")==null?"":request.getParameter("diag_Description");
	diag_Description=java.net.URLDecoder.decode(diag_Description);
	mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	flag = request.getParameter("flag")==null?"":request.getParameter("flag");
	if(mode.equals("") || mode.equals("R"))
		mode = "insert";
		//out.println("<script>alert(\""+diag_Description+"\");</script>");

try
	{
		con = ConnectionManager.getConnection(request);
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT 1 FROM PR_DIFFERENTIAL_DIAGNOSIS ");
		sql.append("  WHERE PATIENT_ID=? AND FINALIZED_YN='N' and term_set_id=? ");

		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,patient_id);
		pstmt.setString(2,term_set_id);
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			Differ_flag = rs.getString(1);
		}
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
			
		if(Differ_flag.equals("1"))
		{
		 sql = new StringBuffer();
		 sql.append("select a.term_set_id,a.term_code,a.TERM_CODE_SHORT_DESC SHORT_DESC,C.LONG_DESC, ");
		 sql.append("a.occur_srl_no,nvl(b.diff_group_id,'0') diff_group_id from pr_diagnosis a, ");
		 sql.append("pr_differential_diagnosis b, MR_TERM_CODE C where a.patient_id = ? "); 
		 sql.append("and a.term_set_id = ? and a.curr_accuracy_ind ='U' ");
		 sql.append("and a.curr_status='A' and b.term_set_id(+)=a.term_set_id and ");
		 sql.append("b.term_code(+)=a.term_code  AND b.occur_srl_no(+) = a.occur_srl_no and "); 
		 sql.append("C.TERM_SET_ID=a.term_set_id AND C.TERM_CODE=a.term_code  AND b.patient_id(+) = a.patient_id ORDER BY "); 
		 sql.append("diff_group_id , a.term_code");

		 pstmt_extgrp=con.prepareStatement(sql.toString());
		 pstmt_extgrp.setString(1,patient_id);
		 pstmt_extgrp.setString(2,term_set_id);
		 rs_extgrp=pstmt_extgrp.executeQuery();

            _bw.write(_wl_block9Bytes, _wl_block9);

		while(rs_extgrp.next())
		{
			shortdesc		=	 rs_extgrp.getString("SHORT_DESC")==null?"":rs_extgrp.getString("SHORT_DESC");
			currentdiffid	=	 rs_extgrp.getInt("diff_group_id");
			
			if(currentdiffid!=0)
			{
				if(i==0)
				{
					out.println("<Td class='COLUMNHEADER' colspan='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ExistingDifferentialDiagnosis.label","mr_labels")+"</Td></table>"); 
				}
				classValue= ((i%2) == 0) ? "QRYEVEN" : "QRYODD";
				out.println("<table border= 0  cellpadding='0' cellspacing='0'  width='100%' align='center' style='border-bottom:#ffffff'>");
				if(prevdiffid!=currentdiffid )
				{
					
					grpid++;
					out.println("<tr><td align='left' class='CAGROUPHEADING' colspan='2'><font color='black' size='1'>Group"+(grpid)+"</td></tr></table>");
				}
				
				out.println("<table border= 1 cellpadding='0' cellspacing='0' width='100%' align='center' style='border-bottom:#ffffff'>");
				
				out.println("<tr><td class='"+classValue+"' align = 'left'  valign='top' style='border-left: #B2B6D7' >&nbsp;&nbsp; "+shortdesc+"</td>");
				 
				
				out.println("</tr>");
				prevdiffid=currentdiffid;
				i++;
			}
		}
		
		out.println("</table>");
		
		if(rs_extgrp!=null)
			rs_extgrp.close();
		if(pstmt_extgrp!=null)
			pstmt_extgrp.close();

		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(diag_Description));
            _bw.write(_wl_block12Bytes, _wl_block12);


		String sql_diffgrp = "select distinct diff_group_id from pr_differential_diagnosis where patient_id = ? and TERM_SET_ID=? and FINALIZED_YN='N'";
		pstmt = con.prepareStatement(sql_diffgrp);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,term_set_id);
		
		rs = pstmt.executeQuery();
	
		out.println("<table border= 0  cellpadding='0' cellspacing='0'  width='100%' align='center' style='border-bottom:#ffffff'>");
		
		out.println("<tr><Td class='COLUMNHEADER' colspan=10><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PleaseSelectGroupforthenewDiagnois.label","mr_labels")+" </b>"+diag_Description+" ?</Td></tr>");
		
		
		int j = 0;
		out.println("<tr>");
		
		while(rs.next())
		{
			diff_group_id = rs.getString("diff_group_id");
			grp_id_temp++;
			
			
			out.println("<td align='right' width='10%'><input type='radio' name='grp_id' id='grp_id'  value='"+diff_group_id+"' onClick=RecordUnassignedGrp(this,'N') ></input></td><td class='label'>Group "+grp_id_temp+"</td>");

			
			
		
			j++;
		}
		
		out.println("<td align='right' width='10%'>&nbsp;&nbsp;<input type='radio' name='grp_id' id='grp_id'  value='Create New Group' onClick=RecordUnassignedGrp(this,'N')></input></td><td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NewGroup.label","mr_labels")+"</td>");
		
		out.println("</tr>");
		out.println("</table>");

	}
	else
		out.println("<script>var error=getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common');alert(error);parent.parent.document.getElementById('dialog_tag').close(); </script>");
	}
	catch(Exception e)
	{
		//out.println("Exception at try"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con != null)ConnectionManager.returnConnection(con,request);

		}
		catch(Exception e){
			//out.println("Exception in finally block"+e.toString());
			e.printStackTrace();
		}
	}
	
		 

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strQry));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(term_set_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
