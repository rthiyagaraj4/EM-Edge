<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../js/RecDiagnosisEOC.js' language='javascript'></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	request.setCharacterEncoding("UTF-8");

	Connection con      = null;
	
	PreparedStatement stmt		= null;
	ResultSet rset		= null;
	
	PreparedStatement stmt_cnt	= null;
	ResultSet rset_cnt		= null;
	
	//String Practitioner_Id	="";	
	//String relationship_id	="";
	//String Locn_Code	="";	String Locn_Type	="";
	String Patient_Id	="";	
	//String Encounter_Id	="";
	//String currentdate	="";	
	//String facilityId ="";
	//String dob = ""; 
	//String age = "";
	//String sex = ""; 
	//String associate_codes ="";
	String code_set = "";

	//String patient_class	="";
	//String srl_no = "";     
	String term_set_id = "";
	String onsetdate_from = "";
	String onsetdate_to = "";

	String episode_info = "";
	//String term_set_desc = "";
	//String term_code = "";
	String diag_short_desc = "";
	String onset_date = "";
	String primary_yn = "";
	String significant_yn = "";
	//String diag_set_id = "";
	String eoc_id = "";

	StringBuffer EOCquery = new StringBuffer();
	//StringBuffer EOCqueryForCount = new StringBuffer();
	
	String prev_eoc_id = "";
	String prev_term_set_id = "";
	//String prev_term_code = "";
	String yn_value = "";
	
	String Classvalue = "";
	//String first_epid = "";

	//int maxrecord = 0;
	
	int i =0,count = 0,j = 0;
	int epid_cnt = 0;
	//int epid_cnt1 = 0;
	int term_id_count = 0;
	int incr= 1;
	try
		{
			con = ConnectionManager.getConnection(request);
			
			//srl_no           = checkForNull(request.getParameter("srl_no"));
			//Practitioner_Id  =checkForNull(request.getParameter("Practitioner_Id"));	
			//relationship_id  = checkForNull(request.getParameter("relationship_id"));
			//Locn_Code           = checkForNull(request.getParameter("Locn_Code"));			
			//Locn_Type           = checkForNull(request.getParameter("Locn_Type"));
			Patient_Id       = checkForNull(request.getParameter("Patient_Id"));
			//patient_class       = checkForNull(request.getParameter("patient_class"));
			//Encounter_Id       = checkForNull(request.getParameter("Encounter_Id"));
			//associate_codes  =checkForNull(request.getParameter("associate_codes"));		
			//age   = checkForNull(request.getParameter("Age"));	
			//dob   = checkForNull(request.getParameter("Dob"));	

			//sex   = checkForNull(request.getParameter("Sex"));	
			//String mode = checkForNull(request.getParameter("mode"));
			term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");

			//diag_set_id = checkForNull(request.getParameter("diag_set_id"));	
			code_set = checkForNull(request.getParameter("code_set"));	

			onsetdate_to = checkForNull(request.getParameter("onsetdate_to"));	
			onsetdate_from = checkForNull(request.getParameter("onsetdate_from"));
		
%>
	<body onKeyDown='lockKey()'>
		<form name='EOCResultForm' id='EOCResultForm'>
		<center>
		<table cellspacing=0 cellpadding=0 width='100%' border=1 id='tb1'>
<%
			
				EOCquery.append( "SELECT   a.eoc_id, a.eoc_code || '   Period From   ' || TO_CHAR (c.ONSET_DATE, 'dd/mm/yyyy') || '  To  ' || TO_CHAR (a.resolve_date, 'dd/mm/yyyy') episode_info,d.term_set_desc, d.term_set_id, b.term_code, e.short_desc,TO_CHAR (c.onset_date, 'dd/mm/yyyy') onset_date, b.primary_yn, b.significant_yn,(select count(TERM_CODE) from PR_EPISODE_OF_CARE_DETAIL where patient_id=? and EOC_ID=a.eoc_id and term_set_id = b.term_set_id) count,(select count(distinct TERM_SET_ID) from PR_EPISODE_OF_CARE_DETAIL where patient_id=? and EOC_ID=a.eoc_id ");
				
				if(!code_set.equals(""))
				{
					EOCquery.append(" AND term_set_id = ?"); 
				}
				
				EOCquery.append(" ) term_id_count  FROM pr_episode_of_care a,pr_episode_of_care_detail b,pr_diagnosis c,mr_term_set d, mr_term_code e  WHERE a.patient_id = b.patient_id AND b.eoc_id = a.eoc_id  AND c.patient_id = b.patient_id  AND c.term_set_id = b.term_set_id AND c.term_code = b.term_code AND c.occur_srl_no = b.occur_srl_no     AND d.term_set_id = b.term_set_id  AND c.term_set_id = b.term_set_id  AND e.term_set_id = b.term_set_id  AND e.term_code = b.term_code  AND e.term_set_id = d.term_set_id  AND b.patient_id = ?  ");
				
				if(!code_set.equals(""))
				{
					EOCquery.append(" AND b.term_set_id = ?"); 
				}
				if(!(onsetdate_from.equals("") || onsetdate_to.equals("")))
				{
					EOCquery.append("	and c.ONSET_DATE between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy')");
				}
				else if(!(onsetdate_from.equals("") && onsetdate_to.equals("")))
				{
				
					if(onsetdate_from!=null && !onsetdate_from.equals(""))
					{
						EOCquery.append(" and trunc(c.ONSET_DATE) >= to_date('");
						EOCquery.append(onsetdate_from);
						EOCquery.append("' , 'dd/mm/yyyy') ");
					}	
					if(onsetdate_to!=null && !onsetdate_to.equals(""))
					{
						EOCquery.append(" and trunc(c.ONSET_DATE) <= to_date('");
						EOCquery.append(onsetdate_to);
						EOCquery.append("' , 'dd/mm/yyyy') ");
					}
				}
				
				EOCquery.append(" ORDER BY a.open_date DESC, d.term_set_desc, c.onset_date");

				//out.println("EOCquery "+EOCquery.toString());
				stmt = con.prepareStatement(EOCquery.toString());
				stmt.setString(incr++,Patient_Id);
				stmt.setString(incr++,Patient_Id);
				
				if(!code_set.equals(""))
				{
					stmt.setString(incr++,code_set);
				}
				
				stmt.setString(incr++,Patient_Id);
	
				if(!code_set.equals(""))
				{
					stmt.setString(incr++,code_set);
				}
				if(!(onsetdate_from.equals("") ||  onsetdate_to.equals("")))
				{
					stmt.setString(incr++,onsetdate_from);
					stmt.setString(incr++,onsetdate_to);
				}
			
				rset = stmt.executeQuery();
				while(rset.next())
				{
					eoc_id = rset.getString("EOC_ID");
					episode_info = rset.getString("EPISODE_INFO");
					//term_set_desc = rset.getString("TERM_SET_DESC");
					term_set_id = rset.getString("TERM_SET_ID");
					//term_code = rset.getString("TERM_CODE");
					diag_short_desc = rset.getString("SHORT_DESC");
					onset_date = rset.getString("ONSET_DATE");
					primary_yn = rset.getString("PRIMARY_YN");
					significant_yn = rset.getString("SIGNIFICANT_YN");
					count = rset.getInt("COUNT");
					term_id_count = rset.getInt("term_id_count");
									
					if(primary_yn.equals("Y"))
							yn_value = "Primary";
					else if(significant_yn.equals("Y"))
							yn_value = "Significant";
					else
							yn_value = "&nbsp;";

					/*if(i==0)
						first_epid = eoc_id;*/
			
					if(!prev_eoc_id.equals(eoc_id) ){
						epid_cnt = 0;
						//epid_cnt1 = 1;
					}
				if(j%2 == 0)
						Classvalue = "QRYEVEN ";
				else
						Classvalue = "QRYODD";
				
				if(!term_set_id.equals(prev_term_set_id))
						epid_cnt ++;

				out.println("<tr>");
				if(!prev_eoc_id.equals(eoc_id) || !prev_term_set_id.equals(term_set_id))
					{
						if(!prev_eoc_id.equals(eoc_id))
						{
							out.println("<td width='2%' ><font style='FONT-SIZE: 8pt;'><a id='anchor_"+eoc_id+"' href=\"javascript:expandCollapse('"+eoc_id+"')\">-</a></font></td>");
							out.println("<td class='CAGROUPHEADING' colspan='5' ><font size=1>");
							out.println(episode_info+"</font></td>");		
							out.println("<td><input type='hidden' name='term_cnt_"+eoc_id+"' id='term_cnt_"+eoc_id+"' value='"+term_id_count+"' ></td></tr>");
						}
				//		if(!(prev_term_set_id.equals(term_set_id) || prev_eoc_id.equals(eoc_id) ) )
						{
							//out.println("epid_cnt "+epid_cnt);
							if(epid_cnt == 0)
								epid_cnt = 1;

							out.println("<tr>");
							out.println("<td width='2%' class='QRYODD' id='tab1_"+eoc_id+"_"+epid_cnt+"' style='visibility:none'>&nbsp;</td><td width='2%' class='QRYODD' id='tab2_"+eoc_id+"_"+epid_cnt+"' style='visibility:none'><a id='sub_anchor_"+eoc_id+"_"+epid_cnt+"' href=\"javascript:expandCollapse_sub('"+eoc_id+"','"+epid_cnt+"')\">-</a></td>");
							out.println("<td class='QRYODD'  colspan = '4' id='tab3_"+eoc_id+"_"+epid_cnt+"' style='visibility:none'><font size=1>");
							out.println("<B>"+term_set_id+"</B></font><input type='hidden' name='cnt_"+eoc_id+"_"+epid_cnt+"' id='cnt_"+eoc_id+"_"+epid_cnt+"' value='"+count+"' ></td>");
							out.println("</tr>");		
							
						}
						if(!(i==0))
						{
							if(!prev_eoc_id.equals(eoc_id))
							{
								//out.println("<script>expandCollapse('"+prev_eoc_id+"')</script>");
							}
						}
						
				//	if(!prev_eoc_id.equals(eoc_id))
								j = 1;
						
				}	
			//	if(!term_code.equals(prev_term_code))
				//	{
						//out.println("<font size='1'");
						out.println("<td colspan = 2 class="+Classvalue+" id='td1_"+eoc_id+"_"+epid_cnt+"_"+j+"'  style='visibility:none'>&nbsp;</td>");
						out.println("<td class="+Classvalue+" id='td2_"+eoc_id+"_"+epid_cnt+"_"+j+"'  style='visibility:none' >&nbsp;&nbsp;&nbsp;</td>");
						out.println("<td  class="+Classvalue+" width='50%' align='left' id='td3_"+eoc_id+"_"+epid_cnt+"_"+j+"'  style='visibility:none'><font size=1>"+diag_short_desc+"</font></td>");
						out.println("<td class="+Classvalue+" width='25%' align='center' id='td4_"+eoc_id+"_"+epid_cnt+"_"+j+"' style='visibility:none'  ><font size=1>"+onset_date+"</font></td>");
						out.println("<td class="+Classvalue+" width='25%' align='center' id='td5_"+eoc_id+"_"+epid_cnt+"_"+j+"' style='visibility:none' ><font size=1>"+yn_value+"</font></td>");
						out.println("</tr>");		
						j++;
						 
				i++;
				prev_eoc_id = eoc_id;
				prev_term_set_id = term_set_id;
				//prev_term_code = term_code;
				
				}
				if(i==0)
				out.println("<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",'Common'))</script>");
				out.println("</table>");
				if(i !=0){
				//out.println("<script>expandCollapse('"+prev_eoc_id+"')</script>");
				//out.println("<script>expandAll('"+first_epid+"')</script>");
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
	</form>
<%
			if(rset!=null)
					rset.close();
			if(stmt!=null)
					stmt.close();
			
			if(rset_cnt!=null)
					rset_cnt.close();
			if(stmt_cnt!=null)
					stmt_cnt.close();
			
	}
		catch(Exception ex)
		{
			//out.println("Exception @ try block "+ex.toString());
			ex.printStackTrace();
		}
		finally
		{
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}
		%>
	</body>
</html>

