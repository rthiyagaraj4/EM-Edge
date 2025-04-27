package jsp_servlet._emr._jsp;

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

public final class __addassociatecodevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AddAssociateCodeValidate.jsp", 1709118859954L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n</head>\n<body onKeyDown = \'lockKey()\'>\n<form name=\'getDiagValForm\' id=\'getDiagValForm\'>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\n\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\talert(getMessage(\"MR_INVALID_DIAG_CODE_FOR_PATIENT\",\"MR\"));\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = \'\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = \'\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = \'\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = \'\';\n\t\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = \'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=false;\n\t\t\t\tif(parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value == \'Y\')\n\t\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.doSelect(\'A\');\n\t\t\t\telse\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = \'Y\'\n\n\t\t\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
	Connection con = null; 
	PreparedStatement stmt_appln_yn=null;
	ResultSet rs_appln_yn = null;
	
	PreparedStatement stmt=null;
	ResultSet rs = null;
	PreparedStatement stmt1=null;
	ResultSet rs1 = null;
	
	
		
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String term_set_code = request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
	String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
//out.println("dob"+dob);
//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	//String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
//	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
    
	term_set_code = term_set_code.toUpperCase();
	String short_desc = "";
	String long_desc = "";

	String age_spec_ind_val = "";
	String age_group_appl_yn = "";

	int recordcnt = 0;
	int maxrecord = 0;
	StringBuffer sql = new StringBuffer();
	String sql_appln_yn = "";
	String sql_cnt = "";
	try
	{
		con = ConnectionManager.getConnection(request);
			
		sql_cnt="select count(*) count from MR_D_"+term_set_id+"_VW where term_code = ?" ; 
		stmt1 = con.prepareStatement(sql_cnt);
		stmt1.setString(1,term_set_code);
		rs1 =  stmt1.executeQuery();
		while(rs1.next())
		{
			maxrecord = rs1.getInt(1);
		}
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();

	
		if(maxrecord == 0)
		{
			//out.println("<script> var msg = getMessage('INVALID_VALUE','Common'); msg	= msg.replace('#',getLabel('Common.DiagnosisCode.label','Common')); alert(msg);parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.select();parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.focus();</script>");

			out.println("<script> var msg = getMessage('INVALID_VALUE','Common'); msg	= msg.replace('#',getLabel('Common.DiagnosisCode.label','Common')); alert(msg);parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = '';			parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '';		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = '';		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;</script>");
		}
		else
		{
			sql_appln_yn = "select AGE_GROUP_APPL_YN,SENSITIVITY_APPL_YN,TERM_SET_DESC,NOTIFICATION_APPL_YN from mr_term_set where TERM_SET_ID = ?";
			stmt_appln_yn = con.prepareStatement(sql_appln_yn);
			stmt_appln_yn.setString(1,term_set_id);
			
			rs_appln_yn = stmt_appln_yn.executeQuery();

			while(rs_appln_yn.next())
			{
				age_group_appl_yn = rs_appln_yn.getString("AGE_GROUP_APPL_YN")==null?"":rs_appln_yn.getString("AGE_GROUP_APPL_YN");
			}

			
			if(rs_appln_yn!=null)  rs_appln_yn.close();
			if(stmt_appln_yn!=null)  stmt_appln_yn.close();
		
			if(age_group_appl_yn.equals("Y"))
			{

				String sql_age_spec_ind = " select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ";
				stmt_appln_yn = con.prepareStatement(sql_age_spec_ind);
				stmt_appln_yn.setString(1,dob);
				stmt_appln_yn.setString(2,dob);
				stmt_appln_yn.setString(3,dob);
				
				rs_appln_yn = stmt_appln_yn.executeQuery();
				while(rs_appln_yn.next())
					age_spec_ind_val = rs_appln_yn.getString(1)==null?"":rs_appln_yn.getString(1);	
			
			}	
			

				
			

		


			if(rs_appln_yn!=null)  rs_appln_yn.close();
			if(stmt_appln_yn!=null)  stmt_appln_yn.close();

			int j = 0;
			j++;
   
			sql.append("select short_desc,long_desc,code_indicator from MR_D_"+term_set_id+"_VW where term_code = ?" ); 
			if(!sex.equals(""))
			{
				sql.append(" and (GENDER_SPEC_IND = ? OR gender_spec_ind IS NULL)");
			}
			if(age_group_appl_yn.equals("Y") && (!age_spec_ind_val.equals("")))
			{
				sql.append(" and (age_spec_ind is null or AGE_SPEC_IND = ?) ");
			}
			/*if(!code_indicator.equals(""))
			{
				sql.append(" and code_indicator = ?");
			}*/

			stmt = con.prepareStatement(sql.toString());
			stmt.setString(j++,term_set_code);
			
			if(!sex.equals(""))
			{
				stmt.setString(j++,sex);
			}
			if( age_group_appl_yn.equals("Y") && (!age_spec_ind_val.equals("")))
			{
				stmt.setString(j++,age_spec_ind_val);
			}
			/*if(!code_indicator.equals(""))
			{
				stmt.setString(j++,code_indicator);
			}*/
		
			rs = stmt.executeQuery();

			while(rs.next())
			{
				short_desc = rs.getString("short_desc");
				long_desc = rs.getString("long_desc");
				//code_indicator = rs.getString("code_indicator");
				recordcnt++;

			}

			if(rs!=null) rs.close();		
			if(stmt!=null) stmt.close();
		
			if(recordcnt ==  0)
			{	
				
            _bw.write(_wl_block2Bytes, _wl_block2);

			}
			else
			{
			
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);

			}

		}
	}
	catch(Exception e)
	{
		//out.println("Exception @ try "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	


            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
