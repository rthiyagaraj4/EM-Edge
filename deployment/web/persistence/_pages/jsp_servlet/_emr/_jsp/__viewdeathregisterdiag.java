package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __viewdeathregisterdiag extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ViewDeathRegisterDiag.jsp", 1709119133941L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tModule\t\t\t:\teMR\n\tFunction\t\t\t:\tMR Queries -> View Death Register\n\tDeveloped By \t:\tVinod Babu \n\tCreated On\t \t:\t12/05/2005\n\tModified On\t\t:\t12/05/2005\n-->\n\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\n\t<script src=\'../../eMR/js/CreatePatientFile.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\n</head>\n<body  onKeyDown = \'lockKey()\'>\n\t<center>\n\t<form name=\'DiagDtl_form\' id=\'DiagDtl_form\' >\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t</form>\n     </center>\n\t</body>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );
 
		ArrayList arrDiagCode		=	new ArrayList();
		ArrayList arrDiagType		=	new ArrayList();
		ArrayList arrDiagDesc		=	new ArrayList();
//		ArrayList arrRecordType		=	new ArrayList();
		//ArrayList arrCauseIndicator	=	new ArrayList();
		ArrayList arrRemarks		=	new ArrayList();
		ArrayList arrAddItem		=	new ArrayList();
		//ArrayList arrChkItem		=	new ArrayList();
		//ArrayList arrUpdProb		=	new ArrayList();
	

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

		request.setCharacterEncoding("UTF-8");
		Connection con=null;
		Statement stmt	= null;
		ResultSet rset		= null;
		try
		{
			con=ConnectionManager.getConnection(request);
			String facilityId		= (String)session.getValue("facility_id");
			String sql		= "";
			String diag_code_scheme = "";
			String patient_id = request.getParameter("patient_id");
			String call_from = request.getParameter("call_from");
			if (call_from==null) call_from="";
			long encounterid = -1;
			String class_val = "QRYEVEN";
			String record_type ="";
			String diag_code ="";
			String diag_type ="";
			String diag_desc ="";
			String add_item = "";
			String cause_indicator ="";
			String remarks	= "";
			String check_item ="";
			String update_problem = "";
			String cause_of_death_yn = "";
			int cnt =0,i=0;

			stmt = con.createStatement();
			rset = stmt.executeQuery("select diag_code_scheme from mr_parameter");
			if ( (rset != null) && (rset.next()) )
			{
				diag_code_scheme = rset.getString(1);
			}
			if (diag_code_scheme==null) diag_code_scheme="";
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

			stmt = con.createStatement();
			rset = stmt.executeQuery("select encounter_id from mr_death_register_hdr where facility_id='"+facilityId+"' and patient_id='"+patient_id+"'");
			if ( (rset != null) &&	(rset.next()) )
			{
				encounterid = rset.getLong("encounter_id");
			}
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();


			//stmt = con.createStatement();
			//stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			stmt = con.createStatement();
			//sql = "select b.diag_code_scheme, srl_no, '1' num1, b.diag_code, b.record_type, nvl2(b.cause_indicator,'/' || b.cause_indicator,null) cause_indicator,a.short_desc diag_desc, update_problem_yn, 'Y' chkitem, problem_remarks, diag_type from mr_death_register_diag_dtl b, mr_icd_code a where a.diag_code= b.diag_code and  b.encounter_id = "+encounterid+" and b.facility_id = '"+facilityId+"' and (b.diag_code_scheme='1' or (b.diag_code_scheme = '2' and a.record_type = 'D' and	nvl(a.cause_indicator,'E') = 'E')) union select a.diag_code_scheme, 0 srl_no, '2' num1, a.diag_code, a.record_type, nvl2(a.cause_indicator,'/' || a.cause_indicator,null) cause_indicator,diag_desc, 'X' update_problem_yn, 'N' chkitem, problem_remarks, diag_type from pr_problem a where 	a.onset_encounter_id = "+encounterid+" and	a.onset_facility_id = '"+facilityId+"' and a.diag_code not in (select diag_code from mr_death_register_diag_dtl where encounter_id = "+encounterid+" and facility_id = '"+facilityId+"') order by num1, srl_no";

			sql = "SELECT a.patient_id, a.encounter_id, a.remarks, a.term_code, b.short_desc,a.cause_of_death_yn FROM pr_diagnosis_enc_dtl a, mr_term_code b WHERE a.term_set_id = b.term_set_id AND a.term_code = b.term_code AND a.facility_id = '"+facilityId+"' AND a.encounter_id = "+encounterid+" AND a.patient_id='"+patient_id+"'";
			//System.out.println("sql===>" +sql);
			rset	 =	 stmt.executeQuery(sql);	
			


			//if ( (rset != null) && (rset.next()) )
			//if ( (rset != null))
			out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
			while(rset.next())
			{
				//out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
				if(cnt==0)
				{
					out.println("<tr><th align=left colspan=4>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisDetails.label","common_labels")+"</th></tr>");
					out.println("<tr><th align=center>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ICDCode.label","common_labels")+"</th>");		
					out.println("<th align=center>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</th>");		
					out.println("<th align=center>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CauseofDeath.label","common_labels")+"</th>");		
					//out.println("<th align=center>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AddtoProblemList.label","mr_labels")+"</th></tr>");
				}
				//rset.beforeFirst();
				//while(rset.next())
				//{									
					/*diag_code = rset.getString("diag_code") == null ? "" : rset.getString("diag_code");
					diag_type = rset.getString("diag_type") == null ? "" : rset.getString("diag_type");
					record_type = rset.getString("record_type") == null ? "" : rset.getString("record_type");
					cause_indicator	= rset.getString("cause_indicator") == null ? "" : 	rset.getString("cause_indicator"); 
					remarks	= rset.getString("problem_remarks") == null ? "" : 	rset.getString("problem_remarks");
					diag_desc = rset.getString("diag_desc") == null ? "" : rset.getString("diag_desc"); 
					check_item = rset.getString("chkitem") == null ? "" : rset.getString("chkitem");
					update_problem = rset.getString("update_problem_yn") == null ? "" : rset.getString("update_problem_yn");*/
					
					diag_code = rset.getString("term_code") == null ? "" : rset.getString("term_code");
					diag_desc = rset.getString("short_desc") == null ? "" : rset.getString("short_desc"); 
					remarks = rset.getString("remarks") == null ? "" : rset.getString("remarks"); 
					cause_of_death_yn = rset.getString("cause_of_death_yn") == null ? "" : rset.getString("cause_of_death_yn"); 
					


					add_item = "N";
					arrAddItem.add(add_item);
					arrDiagCode.add(diag_code);
					arrDiagDesc.add(diag_desc);
					arrDiagType.add(cause_of_death_yn);
					//arrRecordType.add(record_type);
					//arrCauseIndicator.add(cause_indicator);
					arrRemarks.add(remarks);
					//arrChkItem.add(check_item);
					//arrUpdProb.add(update_problem);
					cnt++;
			}// end of while
			//}

			for ( i=0; i<arrAddItem.size(); i++ )
			{
				add_item		= (String) arrAddItem.get(i);
				diag_code		= (String) arrDiagCode.get(i);
				cause_of_death_yn		= (String) arrDiagType.get(i);
				diag_desc		= (String) arrDiagDesc.get(i);
				//record_type	= (String) arrRecordType.get(i);
				//cause_indicator = (String) arrCauseIndicator.get(i);
				remarks			= (String) arrRemarks.get(i);
				//check_item		= (String) arrChkItem.get(i);
				//update_problem  = (String) arrUpdProb.get(i);

				if(class_val.equals("QRYEVEN"))
					class_val = "QRYODD";
				else
					class_val = "QRYEVEN";

				out.print("<tr><td class='"+class_val+"' align='left'>"+diag_code+""+cause_indicator+"</td>");
				out.print("<td class='"+class_val+"' align='left'>"+diag_desc+"</td>");
					
					//out.println("<script>alert(\"diag_code 1:"+diag_code+"\");</script>");
					//out.println("<script>alert(\"cause_of_death_yn 1:"+cause_of_death_yn+"\");</script>");

				if (cause_of_death_yn.equals("N")) 
					out.println("<td align='center' class='"+class_val+"'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
				else				
					out.println("<td align='center' class='"+class_val+"'><img src='../../eCommon/images/enabled.gif'></img></td>");

				/*if ( update_problem.equals("Y") )
				{
					out.println("<td align='center' class='"+class_val+"'><img src='../../eCommon/images/enabled.gif'></img></td>");
				}
				else 
				{
					out.println("<td align='center' class='"+class_val+"'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
				}*/
				out.println("</td>");
			} // end of for
			arrAddItem.clear();
			arrDiagCode.clear();
			arrDiagType.clear();
			arrDiagDesc.clear();
			//arrRecordType.clear();
			//arrCauseIndicator.clear();
			arrRemarks.clear();
			//arrChkItem.clear();
			//arrUpdProb.clear();
			out.println("</table>");	
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();
	
            _bw.write(_wl_block5Bytes, _wl_block5);

} //end of try
catch(Exception e) 
{
	//out.println("Exception=@=Death Register Diag====>"+e);
	e.printStackTrace();
}
finally{
	if ( con != null ) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block6Bytes, _wl_block6);
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
