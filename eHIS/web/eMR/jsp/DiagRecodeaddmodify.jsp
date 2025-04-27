<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,com.ehis.util.*"   contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../js/DiagRecodePatProblem.js' language='javascript'></SCRIPT>
<script>
async function ShowSupportingDiag(associate_codes,title)
{
	var dialogHeight= "10vh" ;
    var dialogWidth = "35vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eMR/jsp/ShowSupportDiagCodeFrames.jsp?associate_codes="+escape(associate_codes)+"&title=" + title,"",features);
}


</script>

  <% String classValue = "";
	String original_diag="";
	String old_diag="";
	String recoded_diag="";
	String support_diag="";
	String recodedby="";
	String recodeddate="";
	String remarks="";
	String sql_query="";
	String Patient_Id="";
	String srl_no="";
	//String trn_srl_no="";
	String scheme="";
	String diag_desc = "";
	String diag_code_desc="";

	StringBuffer associate_codes = new StringBuffer();
	request.setCharacterEncoding("UTF-8");
	 String facility_id       = checkForNull((String)session.getValue( "facility_id" ));
	
	 String Encounter_Id      =checkForNull( request.getParameter("Encounter_Id"));
	String  tr_srl_no    =checkForNull(request.getParameter("trn_srl_no"));
	 


  %>
<form name='result_form' id='result_form' >
<center>
<table border='1' width='100%' id='resulttableheader' cellpadding='0' cellspacing='0' align='center' >

<tr><th align='left' colspan='8'><font size=1><fmt:message key="eMR.RecordDiagnosis.label" bundle="${mr_labels}"/> </font></th></tr>

<tr>

<th align='left' width='15%'><font size=1><fmt:message key="eMR.OriginalDiagnosisCode.label" bundle="${mr_labels}"/></font></th>
<th align='left' width='12%'><font size=1><fmt:message key="eMR.OldDiagnosisCode.label" bundle="${mr_labels}"/></font></th>
<th align='left' width='15%'><font size=1><fmt:message key="eMR.RecodedDiagnosis.label" bundle="${mr_labels}"/></font></th>
<!--<th  align='left'><font size=1>Supporting Diagnosis</font></th>-->
<th align='left' width='10%'><font size=1><fmt:message key="eMR.RecodedBy.label" bundle="${mr_labels}"/></font></th>
<th align='left' width='15%'><font size=1><fmt:message key="eMR.RecodedDate.label" bundle="${mr_labels}"/></font></th>

<th align='left' width='18%'><font size=1><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp; </font></th>
<th align='left' width='15%'><font size=1><fmt:message key="Common.SupportingDiagnosis.label" bundle="${common_labels}"/></font></th>
</tr>
</table>
<table border='1' width='100%' id='resulttable' cellpadding='0' cellspacing='0' align='center' >
<%

		Connection conn 	= null;
		PreparedStatement  pstmt = null;
		PreparedStatement pstmt_1=null;
		
		ResultSet  rs_associatecodes=null;
		ResultSet  rs		= null;
		  int k=1;
		try
        {
			conn = ConnectionManager.getConnection(request);

			

			sql_query="select  a.curr_facility_id, a.curr_encounter_id, a.patient_id,a.new_recoded_diag_code || nvl2(a.new_recoded_cause_indicator,'/' || a.new_recoded_cause_indicator,null) diag_code_desc, a.srl_no,a.new_recoded_diag_code_scheme,a.orig_diag_code, a.old_recoded_diag_code, a.new_recoded_diag_code,(select count(*) from pr_problem_detail where patient_id = a.patient_id and srl_no = a.srl_no) supp_diag,(select appl_user_name from sm_appl_user where appl_user_id = a.added_by_id) recoded_by, to_char(added_date,'dd/mm/yyyy hh24:mi') recoded_date, new_remarks remarks from mr_diag_recoding_audit a where a.curr_facility_id =? and a.curr_encounter_id = ? and a.trn_srl_no=?  order by to_date(recoded_date,'dd/mm/yyyy hh24:mi') desc";

			 pstmt=conn.prepareStatement(sql_query);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Encounter_Id);
			pstmt.setString(3,tr_srl_no);
			rs=pstmt.executeQuery();
			
       
			while(rs.next())
			{
				original_diag=rs.getString("orig_diag_code");
				old_diag=rs.getString("old_recoded_diag_code");
				recoded_diag=rs.getString("new_recoded_diag_code");
				diag_code_desc=rs.getString("diag_code_desc");
				support_diag=rs.getString("supp_diag");
				recodedby=rs.getString("recoded_by");
				recodeddate=rs.getString("recoded_date");
				if(recodeddate!=null && !recodeddate.equals(""))
					recodeddate = DateUtils.convertDate(recodeddate,"DMYHM","en",localeName);
			
				remarks=rs.getString("remarks");
				Patient_Id=rs.getString("patient_id");
				
				srl_no=rs.getString("srl_no");
				//trn_srl_no=rs.getString("trn_srl_no");
				scheme=rs.getString("new_recoded_diag_code_scheme");

				if(old_diag==null)
					old_diag="";
				if(remarks==null)
					remarks="";



				
				String sql_assosicate_code = "select a.support_diag_code , b.short_desc,b.long_desc, b.code_indicator from pr_problem_detail a, mr_icd_code b where a.patient_id =? and   a.srl_no =? and      a.diag_code = ? and b.diag_code_scheme = ? and b.diag_code = a.support_diag_code" ;

				pstmt_1 = conn.prepareStatement(sql_assosicate_code);
				pstmt_1.setString(1, Patient_Id);
				pstmt_1.setString(2, srl_no);
				pstmt_1.setString(3, recoded_diag);
				pstmt_1.setString(4, scheme);

				rs_associatecodes = pstmt_1.executeQuery();
				int temp_associate_code = 0;
				associate_codes = new StringBuffer();
				while(rs_associatecodes.next())
				{
					String temp_supporting_code = java.net.URLEncoder.encode((String)rs_associatecodes.getString("support_diag_code"));
					String temp_short_desc = java.net.URLEncoder.encode((String)rs_associatecodes.getString("short_desc"));
                    String long_desc=java.net.URLEncoder.encode((String)rs_associatecodes.getString("long_desc"));
					//code_indicator = rs_associatecodes.getString("code_indicator");
					
					if(temp_associate_code == 0)
						associate_codes.append(temp_supporting_code + "~" + temp_short_desc+"~"+long_desc);
					else
						associate_codes.append("|" + temp_supporting_code + "~" + temp_short_desc+"~"+long_desc);	
					temp_associate_code++;
				}

				 if ( k%2 == 0 )
                    classValue = "QRYEVEN" ;
                else
                classValue = "QRYODD" ;
				out.println("<tr>");
				
	out.println("<td class='"+classValue+"' width='15%'><font size=1>"); 
	out.println("<input type='hidden' name='originaldiag' id='originaldiag' value='"+""+"'>");
	out.println(original_diag+"</font></td> ");

	out.println("<td class='"+classValue+"' width='12%'><font size=1>"); 
	out.println("<input type='hidden' name='olddiag' id='olddiag' value='"+""+"'>");
	out.println(old_diag+"</font></td>");

	out.println("<td class='"+classValue+"' width='15%'><font size=1>"); 
	out.println("<input type='hidden' name='recodeddiag' id='recodeddiag' value='"+""+"'>");
	out.println(recoded_diag+"</font></td>");

	out.println("<td class='"+classValue+"' width='10%'><font size=1>"); 
	out.println("<input type='hidden' name='recordedby' id='recordedby' value='"+""+"'>");
	out.println(recodedby+"</font></td>");

	out.println("<td class='"+classValue+"' width='15%'><font size=1>"); 
	out.println("<input type='hidden' name='recordeddate' id='recordeddate' value='"+""+"'>");
	out.println(recodeddate+"</font></td>");

	out.println("<td class='"+classValue+"' width='18%' noresize><font size=1>"); 
	out.println("<input type='hidden' name='remarks' id='remarks' value='"+""+"'>");
	out.println(remarks+"</font></td>");

	if(temp_associate_code > 0)
	{
		out.println("<td class='"+classValue+"' width='15%'><font size=1>");
		out.println("<a href=\"javascript: ShowSupportingDiag('"+java.net.URLEncoder.encode(associate_codes.toString())+"','" + diag_desc+"(" + diag_code_desc+")')\" >View</a>");
		//out.println("<a href=\"javascript: ShowSupportingDiag('"+java.net.URLEncoder.encode(associate_codes.toString())+"','" + diag_desc+"(" + diag_code_desc+")','"+original_diag+"','"+old_diag+"','"+recoded_diag+"','"+diag_code_desc+"','"+support_diag+"','"+Patient_Id+"','"+srl_no+"','"+scheme+"')\" >View</a>");
		out.println("</font></td>");
	}
	else{
		out.println("<td class='"+classValue+"' width='15%'><font size=1>");
		out.println("&nbsp");
		out.println("</font></td>");
		}

			k++;
			}
		}catch(Exception e)
			{
			//out.print("ERROR"+e.toString());
			e.printStackTrace(System.err);
			}
		 finally
            {
                if(rs!=null)    rs.close();
				if(pstmt!=null)  pstmt.close();
				ConnectionManager.returnConnection(conn, request);
            }

%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>





