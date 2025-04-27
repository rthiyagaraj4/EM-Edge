package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifydiag extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/addModifyDiag.jsp", 1722863338121L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<!--\n\tDeveloped by \t:\tKumar\n\tCreated on \t:\t29/11/2001\n\tModule\t\t:\tmr\n-->\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMR/js/CreatePatientFile.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\n</head>\n<body onKeyDown = \'lockKey()\'>\n\t<center>\n\t\t<form name=\'DiagDtl_form\' id=\'DiagDtl_form\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0>\n\t\t\t<tr><td colspan=2 class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td></tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t<input type=\'hidden\' name=\'death_date_time\' id=\'death_date_time\' value= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\'hidden\' name=\'death_by_pregnancy_yn\' id=\'death_by_pregnancy_yn\' value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\'hidden\' name=\'autopsy_yn\' id=\'autopsy_yn\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\t\t\n\t\t<input type=\'hidden\' name=\'medical_legal_case_yn\' id=\'medical_legal_case_yn\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\t\t\n\t\t<input type=\'hidden\' name=\'finalize_yn\' id=\'finalize_yn\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\t\t\n\t\t<input type=\'hidden\' name=\'diag_code_scheme\' id=\'diag_code_scheme\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t</form>\n\t</center>\n\t</body>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</html>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
 
	ArrayList arrDiagCode		=	new ArrayList();
	ArrayList arrDiagType		=	new ArrayList();
	ArrayList arrDiagDesc		=	new ArrayList();
	ArrayList arrRecordType		=	new ArrayList();
	ArrayList arrCauseIndicator	=	new ArrayList();
	ArrayList arrRemarks		=	new ArrayList();
	ArrayList arrAddItem		=	new ArrayList();
	ArrayList arrChkItem		=	new ArrayList();
	ArrayList arrUpdProb		=	new ArrayList();


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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		Connection con=null;
		Statement stmt	= null;

		try{
		con=ConnectionManager.getConnection(request);
		ResultSet rset		= null;
		String facilityId		= (String)session.getValue("facility_id");


		String sql		= "";
		String diag_code_scheme = "";

		String eid = request.getParameter("encounter_id");
		String call_from = request.getParameter("call_from");
		if (call_from==null) call_from="";
		long encounterid = Long.parseLong(eid);
		String class_val = "QRYEVENSMALL";
		String record_type ="";
		String diag_code ="";
		String diag_type ="";
		String diag_desc ="";
		String add_item = "",rowCount = "";
		String cause_indicator ="", mode = "";
		String remarks	= "";
		String check_item ="";
		String cur_death_date_time = "death_date_time";
		String cur_practid ="practid";
		String cur_remarks ="remarks";
		String cur_death_by_pregnancy_yn ="death_by_pregnancy_yn";
		String cur_autopsy_yn ="autopsy_yn";		
		String cur_medical_legal_case_yn ="medical_legal_case_yn";
		String cur_finalize_yn ="N";
		String update_problem = "";
		String checkBoxProp = "";
		String dfltChkProp = "";
		

		int cnt =0,i=0,row_count = 0, totalRecords=0;
		boolean error_flag = false;
		
			mode = request.getParameter("mode");
			if(mode==null) mode = "";
			rowCount = request.getParameter("row_count");
			if(rowCount==null) rowCount = "0";
			row_count = Integer.parseInt(rowCount);
			
			/*out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
			out.println("<tr><td colspan=2 class="COLUMNHEADER"><fmt:message key='Common.DiagnosisDetails.label' bundle='${common_labels}'/></td>");
			out.println("<td class="COLUMNHEADER">Cause of Death</td>");		
			out.println("<td class="COLUMNHEADER">Add to Problem List</td></tr>");
			*/
			
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

			stmt = con.createStatement();
			rset = stmt.executeQuery("select diag_code_scheme from mr_parameter");
			if(rset != null)
			{
				rset.next();
				diag_code_scheme = rset.getString(1);
			}
			if (diag_code_scheme==null) diag_code_scheme="";


			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

			if(mode.equals(""))
			{
				sql = "select count(*) from mr_death_Register_diag_dtl where encounter_id = "+encounterid+" and facility_id = '"+facilityId+"'";

				stmt = con.createStatement();
				rset	 =	 stmt.executeQuery(sql);		
				int dtlcnt = 0;
				if(rset != null)
				{
				rset.next();
				dtlcnt = rset.getInt(1);
				}
	
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

			stmt = con.createStatement();

				if (dtlcnt==0) 					
					sql = "select b.diag_code_scheme, srl_no, '1' num1, b.diag_code, b.record_type, nvl2(b.cause_indicator,'/' || b.cause_indicator,null) cause_indicator,a.short_desc diag_desc, update_problem_yn, 'Y' chkitem, problem_remarks, diag_type from mr_death_register_diag_dtl b, mr_icd_code a where a.diag_code= b.diag_code and  b.encounter_id = "+encounterid+" and b.facility_id = '"+facilityId+"' and (b.diag_code_scheme='1' or (b.diag_code_scheme = '2' and a.record_type = 'D' and	nvl(a.cause_indicator,'E') = 'E')) union select a.diag_code_scheme, 0 srlno, '2' num1, a.diag_code, a.record_type, nvl2(a.cause_indicator,'/' || a.cause_indicator,null) cause_indicator,diag_desc, 'X' update_problem_yn, 'N' chkitem, problem_remarks, diag_type  from pr_problem a where 	a.onset_encounter_id = "+encounterid+" and	a.onset_facility_id = '"+facilityId+"' order by num1, srl_no";
				else
					sql = "select b.diag_code_scheme, srl_no, '1' num1, b.diag_code, b.record_type, nvl2(b.cause_indicator,'/' || b.cause_indicator,null) cause_indicator,a.short_desc diag_desc, update_problem_yn, 'Y' chkitem, problem_remarks, diag_type from mr_death_register_diag_dtl b, mr_icd_code a where a.diag_code= b.diag_code and  b.encounter_id = "+encounterid+" and b.facility_id = '"+facilityId+"' and (b.diag_code_scheme='1' or (b.diag_code_scheme = '2' and a.record_type = 'D' and	nvl(a.cause_indicator,'E') = 'E')) union select a.diag_code_scheme, 0 srl_no, '2' num1, a.diag_code, a.record_type, nvl2(a.cause_indicator,'/' || a.cause_indicator,null) cause_indicator,diag_desc, 'X' update_problem_yn, 'N' chkitem, problem_remarks, diag_type from pr_problem a where 	a.onset_encounter_id = "+encounterid+" and	a.onset_facility_id = '"+facilityId+"' and a.diag_code not in (select diag_code from mr_death_register_diag_dtl where encounter_id = "+encounterid+" and facility_id = '"+facilityId+"') order by num1, srl_no";
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

				stmt = con.createStatement();
				rset	 =	 stmt.executeQuery(sql);				
				arrAddItem.clear();
				arrDiagCode.clear();
				arrDiagType.clear();
				arrDiagDesc.clear();
				arrRecordType.clear();
				arrCauseIndicator.clear();
				arrRemarks.clear();
				arrChkItem.clear();
				arrUpdProb.clear();
				if(rset != null)
				{
					while(rset.next())
					{									
					diag_code = "";
					diag_type = "";
					diag_desc = "";
					record_type = "";
					cause_indicator = "";
					check_item = "";
					remarks = "";

					diag_code = rset.getString("diag_code") == null ? "" : rset.getString("diag_code");
					diag_type = rset.getString("diag_type") == null ? "" : rset.getString("diag_type");
					record_type = rset.getString("record_type") == null ? "" : rset.getString("record_type");
					cause_indicator	= rset.getString("cause_indicator") == null ? "" : 	rset.getString("cause_indicator"); 
					remarks	= rset.getString("problem_remarks") == null ? "" : 	rset.getString("problem_remarks"); 
					diag_desc = rset.getString("diag_desc") == null ? "" : rset.getString("diag_desc"); 
					check_item = rset.getString("chkitem") == null ? "" : rset.getString("chkitem");
					update_problem = rset.getString("update_problem_yn") == null ? "" : rset.getString("update_problem_yn");
					

					add_item = "N";
					arrAddItem.add(add_item);
					arrDiagCode.add(diag_code);
					arrDiagType.add(diag_type);
					arrDiagDesc.add(diag_desc);
					arrRecordType.add(record_type);
					arrCauseIndicator.add(cause_indicator);
					arrRemarks.add(remarks);
					arrChkItem.add(check_item);
					arrUpdProb.add(update_problem);
					cnt++;
					} // end of while
				}
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();

				sql = "select count(*) from mr_death_register_diag_dtl b where encounter_id = "+encounterid+" and b.facility_id = '"+facilityId+"'";
				stmt = con.createStatement();
				rset	 =	 stmt.executeQuery(sql);
				if(rset != null)
				{
					rset.next();
					totalRecords = rset.getInt(1);
				}
				if(rset!=null) 	rset.close();
				if(stmt!=null) 	stmt.close();

				//totalRecords = arrAddItem.size();
			} // end of mode empty - modify

			
			if(mode.equals("Add")||mode.equals("Modify"))
			{
				arrAddItem.clear();
				arrDiagCode.clear();
				arrDiagType.clear();
				arrDiagDesc.clear();
				arrRecordType.clear();
				arrCauseIndicator.clear();
				arrRemarks.clear();
				arrChkItem.clear();
				arrUpdProb.clear();

				cur_death_date_time = request.getParameter(cur_death_date_time);
				cur_practid = request.getParameter(cur_practid);
				cur_remarks = request.getParameter(cur_remarks);
				cur_death_by_pregnancy_yn = request.getParameter(cur_death_by_pregnancy_yn);
				cur_autopsy_yn = request.getParameter(cur_autopsy_yn);
				cur_medical_legal_case_yn = request.getParameter(cur_medical_legal_case_yn);

				String curr_diag_code = "diag_code"+(row_count-1);
				String totalRec = request.getParameter("totalRecords");
				if(totalRec==null) totalRec = "0";
				totalRecords = Integer.parseInt(totalRec);

				curr_diag_code = request.getParameter(curr_diag_code);
				for(i=0;i<row_count;i++)
				{
					add_item = "add_item"+i;
					diag_code = "diag_code"+i;
					diag_type = "diag_type"+i;
					diag_desc = "diag_desc"+i;
					record_type = "record_type"+i;
					cause_indicator = "cause_indicator"+i;
					remarks = "remarks"+i;
					check_item = "check_item"+i;
					update_problem = "update_problem"+i;
				
					add_item = request.getParameter(add_item);					
					diag_code = request.getParameter(diag_code);
					diag_type = request.getParameter(diag_type);
					diag_desc = request.getParameter(diag_desc);
					record_type = request.getParameter(record_type);
					cause_indicator = request.getParameter(cause_indicator);
					remarks = request.getParameter(remarks);
					check_item = request.getParameter(check_item);
					update_problem = request.getParameter(update_problem);

					if(add_item==null) add_item = "N";
					if(diag_code==null) diag_code = "";
					if(diag_type==null) diag_type = "";	
					if(diag_desc==null) diag_desc = "";
					if(record_type==null) record_type = "";
					if(cause_indicator==null) cause_indicator = "";
					if(remarks==null) remarks = "";
					if(check_item==null) check_item = "";
					if(update_problem==null) update_problem = "N";
					
					boolean valid_data = true;
					if (mode.equals("Add")) 
					{
						if(i!=(row_count-1))
						{
							if(diag_code.equals(curr_diag_code))
							{
								valid_data = false;
								error_flag = true;
							}
						}
					}
					if(valid_data)
					{
						arrAddItem.add(add_item);
						arrDiagCode.add(diag_code);
						arrDiagType.add(diag_type);
						arrDiagDesc.add(diag_desc);
						arrRecordType.add(record_type);
						arrCauseIndicator.add(cause_indicator);
						arrRemarks.add(remarks);
						arrChkItem.add(check_item);
						arrUpdProb.add(update_problem);
					}
				} // end of row_count
			} // end of mode

			if(error_flag)
			{
				out.println("<script>alert('RECORD_EXISTS','SM');parent.frames[0].document.forms[0].diag_code.select();parent.frames[0].document.forms[0].diag_code.focus();</script>");
			}
			else
			{
				if(!(mode.equals("")))
					out.println("<script>parent.frames[0].document.forms[0].reset();</script>");			
			}
			for(i=0;i<arrAddItem.size();i++)
			{
				add_item		= (String) arrAddItem.get(i);
				diag_code		= (String) arrDiagCode.get(i);
				diag_type		= (String) arrDiagType.get(i);
				diag_desc		= (String) arrDiagDesc.get(i);
				record_type		= (String) arrRecordType.get(i);
				cause_indicator = (String) arrCauseIndicator.get(i);
				remarks			= (String) arrRemarks.get(i);
				check_item		= (String) arrChkItem.get(i);
				update_problem  = (String) arrUpdProb.get(i);
				
				if(class_val.equals("QRYEVENSMALL"))
					class_val = "QRYODDSMALL";
				else
					class_val = "QRYEVENSMALL";


				if (update_problem.equals("N")||update_problem.equals("Y"))
				{
					out.print("<tr><td class='"+class_val+"' ><a href=\"javascript:showDetail("+i+")\">"+diag_code+cause_indicator+"</a></td>");
				}
				else
				{
					out.print("<tr><td class='"+class_val+"' >"+diag_code+""+cause_indicator+"</td>");
				}

				out.print("<td class='"+class_val+"' >"+diag_desc+"</td>");
				out.println("<td class='"+class_val+"' align='center'>");				

				
				dfltChkProp = "";

				if (check_item.equals("Y") ||
				   (check_item.equals("") && (mode.equals("Add")||mode.equals("Modify"))))
					dfltChkProp = " checked ";
				
				if (check_item.equals("N")) 
					out.println("<INPUT TYPE='checkbox' value='Y' "+dfltChkProp+" name='add_item"+i+"' id='add_item"+i+"'>");
				else					
					out.println("<INPUT TYPE='checkbox' "+dfltChkProp+" value='Y' name='add_item"+i+"' id='add_item"+i+"'>");

				out.println("</td>");				

				checkBoxProp = "";

				if (update_problem.equals("N")||update_problem.equals("Y"))
				{
					if (update_problem.equals("Y")) {  checkBoxProp = "checked"; } 

					out.println("<td class='"+class_val+"' align='center'>");
					out.println("<INPUT TYPE='checkbox' value='Y' "+checkBoxProp+" name='update_problem"+i+"' id='update_problem"+i+"'>");					
				}
				else 
				{
					out.println("<td class='"+class_val+"' align='center'><input type='hidden' name = 'update_problem"+i+"' checked value = '"+update_problem+"'>");
				}
				
				out.println("<input type='hidden' name = 'diag_code"+i+"' value = '"+diag_code+"'>");
				out.println("<input type='hidden' name = 'diag_type"+i+"' value = '"+diag_type+"'>");
				out.println("<input type='hidden' name = 'diag_desc"+i+"' value = '"+diag_desc+"'>");
				out.println("<input type='hidden' name = 'record_type"+i+"' value = '"+record_type+"'>");
				out.println("<input type='hidden' name = 'check_item"+i+"' value = '"+check_item+"'>");
				out.println("<input type='hidden' name = 'cause_indicator"+i+"' value = '"+cause_indicator+"'>");
				out.println("<input type='hidden' name = 'remarks"+i+"' value = '"+remarks+"'>");
				out.println("</td>");
			} // end of for

			out.println("</table>");
			
			out.println("<input type='hidden' name = 'diag_code"+i+"' value = '"+diag_code+"'>");
			out.println("<input type='hidden' name = 'diag_type"+i+"' value = '"+diag_type+"'>");
			out.println("<input type='hidden' name = 'diag_desc"+i+"' value = '"+diag_desc+"'>");
			out.println("<input type='hidden' name = 'record_type"+i+"' value = '"+record_type+"'>");
			out.println("<input type='hidden' name = 'cause_indicator"+i+"' value = '"+cause_indicator+"'>");
			out.println("<input type='hidden' name = 'remarks"+i+"' value = '"+remarks+"'>");
			out.println("<input type='hidden' name='update_problem"+i+"' id='update_problem"+i+"' value='"+update_problem+"'>");
			out.println("<input type='hidden' name = 'row_count' value = '"+(i+1)+"'>");
			out.println("<input type='hidden' name = 'mode' value = 'Add'>");
			out.println("<input type='hidden' name = 'totalRecords' value = '"+totalRecords+"'>");			
		
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cur_death_date_time));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cur_practid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cur_remarks));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cur_death_by_pregnancy_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cur_autopsy_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cur_medical_legal_case_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cur_finalize_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block22Bytes, _wl_block22);

} //end of try
		catch(Exception e) {
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CauseofDeath.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AddtoProblemList.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
