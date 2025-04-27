<!DOCTYPE html>
<!--
	Module			:	eMR
	Function			:	MR Queries -> View Death Register
	Developed By 	:	Vinod Babu 
	Created On	 	:	12/05/2005
	Modified On		:	12/05/2005
-->

<html>
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
	<script src='../../eMR/js/CreatePatientFile.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<body  onKeyDown = 'lockKey()'>
	<center>
	<form name='DiagDtl_form' id='DiagDtl_form' >
	<%! 
		ArrayList arrDiagCode		=	new ArrayList();
		ArrayList arrDiagType		=	new ArrayList();
		ArrayList arrDiagDesc		=	new ArrayList();
//		ArrayList arrRecordType		=	new ArrayList();
		//ArrayList arrCauseIndicator	=	new ArrayList();
		ArrayList arrRemarks		=	new ArrayList();
		ArrayList arrAddItem		=	new ArrayList();
		//ArrayList arrChkItem		=	new ArrayList();
		//ArrayList arrUpdProb		=	new ArrayList();
	%>
	<%
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
	%>
		</form>
     </center>
	</body>
	<%
} //end of try
catch(Exception e) 
{
	//out.println("Exception=@=Death Register Diag====>"+e);
	e.printStackTrace();
}
finally{
	if ( con != null ) ConnectionManager.returnConnection(con,request);
}
%>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

