<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
	<head>
		<%String sStyle	=	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js">	</script>
		<script language='javascript' src='../js/AdverseReaction.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<!-- <script language="JavaScript" src="../js/eMRmessages.js"></script> // file not found -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
		<%
		String locale			= (String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		Statement stmt1=null;
		ResultSet rsas=null;
		ResultSet rsas1=null;
		ResultSet rs=null;
		String mode="";
		String checkBoxAttribute="";
		mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		if(mode ==null || mode=="") mode="insert";
		//String from = request.getParameter( "from" )==null?"":request.getParameter("from");
		//String from = checkForNull(request.getParameter("from"));
		
		//String to = request.getParameter( "to" )==null?"":request.getParameter("to") ;
		//String to = checkForNull(request.getParameter("to"));
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		int start = 0 ;
		int end = 0 ;
		String causative_code="";
		String causative_desc="";
		int m=1;
				String adv_event_type_ind_desc="";
				String reac_code="";
				reac_code=request.getParameter("reac_code");
				if(reac_code ==null ) reac_code="";
				String adv_event_type=request.getParameter("adv_event_type")==null?"":request.getParameter("adv_event_type");
				String adv_event_type_ind=request.getParameter("adv_event_indicator")==null?"":request.getParameter("adv_event_indicator");



				String classValue	 = "";
				String eff_status="";
				String sql_cnt="";
				int maxRecord=0;
				if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from ) ;

			if ( to == null )
				end = 15 ;
			else
				end = Integer.parseInt( to ) ;


	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
//out.println("<script>alert(\"search_txt :"+search_txt+"\");</script>");
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";

	String search_by1="";
	String search_by2="";

	
	if(search_by.equals("01"))
	{
	   search_by1="ALLERGEN_CODE";
	   search_by2="GENERIC_ID";
	}
	else if(search_by.equals("02"))
	{
		search_by1="LONG_DESC";
		search_by2="GENERIC_NAME";
	}

	

		 %>
		 
	 </head>
	<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
	<form name='Adverse_reaction_res' id='Adverse_reaction_res' action='../../servlet/eMR.AdverseReactionServlet' method='post' target='messageFrame' > 



<%	try
		{
 
				conn = ConnectionManager.getConnection(request);
				stmt1 = conn.createStatement();
				

	if(adv_event_type.equals("DA"))
			{
			
				if(!search_by.equals("") && !search_txt.equals(""))
				{
					sql_cnt="SELECT count(1) count from (SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description,'Y' eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' and upper(mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1))  like upper('"+search_txt+"%') UNION SELECT a.GENERIC_ID code, a.GENERIC_NAME description, 'Y' eff_status1 FROM PH_GENERIC_NAME a,mr_adv_rea_cause_agent b where a.generic_id = b.ALLERGEN_CODE and b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' and b.adv_reac_code ='"+reac_code+"' and upper(a."+search_by2+")  like upper('"+search_txt+"%') UNION SELECT ALLERGEN_CODE code, mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM MR_ALLERGEN  WHERE  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') and upper(mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1))  like upper('"+search_txt+"%') UNION SELECT GENERIC_ID code, GENERIC_NAME description,'N' eff_status1 FROM PH_GENERIC_NAME  WHERE GENERIC_ID NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') and upper("+search_by2+")  like upper('"+search_txt+"%'))";
				}else
				{
					sql_cnt="SELECT count(1) count from (SELECT a.ALLERGEN_CODE code, a.long_desc description,'Y' eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' AND  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' UNION SELECT a.GENERIC_ID code, a.GENERIC_NAME description, 'Y' eff_status1 FROM PH_GENERIC_NAME a,mr_adv_rea_cause_agent b where a.generic_id = b.ALLERGEN_CODE and b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' and b.adv_reac_code ='"+reac_code+"'  UNION SELECT ALLERGEN_CODE code, long_desc description,'N' eff_status1 FROM MR_ALLERGEN  WHERE   ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') UNION SELECT GENERIC_ID code, GENERIC_NAME description,'N' eff_status1 FROM PH_GENERIC_NAME  WHERE GENERIC_ID NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"'))";
				}
				 
			}else
			{
					

			if(!search_by.equals("") && !search_txt.equals(""))
				{
				sql_cnt="SELECT  count(1) count from ( SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(b.allergen_code,'"+locale+"',1) description, 'Y' eff_status1 FROM mr_adv_rea_cause_agent a, mr_allergen b WHERE  a.adv_reac_code ='"+reac_code+"' AND a.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND b.ADV_EVENT_TYPE_CODE='"+adv_event_type+"'and a.allergen_code=b.allergen_code AND upper(mr_get_desc.mr_allergen(b.allergen_code,'"+locale+"',1)) like upper('"+search_txt+"%') UNION SELECT ALLERGEN_CODE code,mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM  MR_ALLERGEN WHERE ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND ADV_EVENT_TYPE_CODE='"+adv_event_type+"'AND upper(mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1)) like upper('"+search_txt+"%') AND ALLERGEN_CODE NOT IN(SELECT DISTINCT ALLERGEN_CODE FROM mr_adv_rea_cause_agent WHERE adv_reac_code ='"+reac_code+"' AND ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"'))";
				}else
				{
				sql_cnt="SELECT  count(1) count from ( SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(b.allergen_code,'"+locale+"',1) description, 'Y' eff_status1 FROM mr_adv_rea_cause_agent a, mr_allergen b WHERE  a.adv_reac_code ='"+reac_code+"' AND a.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND b.ADV_EVENT_TYPE_CODE='"+adv_event_type+"'and a.allergen_code=b.allergen_code UNION SELECT ALLERGEN_CODE code,mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM  MR_ALLERGEN WHERE ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT DISTINCT ALLERGEN_CODE FROM mr_adv_rea_cause_agent WHERE adv_reac_code ='"+reac_code+"' AND ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"'))";
				}
//out.println("<script>alert(\"search_txt :"+sql_cnt+"\");</script>");

			}
			rsas1=stmt1.executeQuery(sql_cnt);
			if(rsas1 !=null && rsas1.next())
			{
				maxRecord=rsas1.getInt("count");
			}
		if(adv_event_type_ind.equals("01"))
					{
						adv_event_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergy.label","common_labels");
					}else if(adv_event_type_ind.equals("02"))
					{
						adv_event_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels") + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeII.label","mr_labels");
					}else if(adv_event_type_ind.equals("03"))
					{
						adv_event_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeIII.label","mr_labels");
					}else if(adv_event_type_ind.equals("04"))
					{
						adv_event_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeIV.label","mr_labels");
					}
				int k=0;
				
				String sql_list="";
				if(adv_event_type.equals("DA"))
			{
			
				if(!search_by.equals("") && !search_txt.equals(""))
				{
					sql_list="SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description,'Y' eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' AND  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND a.allergen_code NOT IN ( SELECT generic_id FROM ph_generic_name) and upper(mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1))  like upper('"+search_txt+"%') UNION SELECT a.GENERIC_ID code, a.GENERIC_NAME description, 'Y' eff_status1 FROM PH_GENERIC_NAME a,mr_adv_rea_cause_agent b where a.generic_id = b.ALLERGEN_CODE and b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' and b.adv_reac_code ='"+reac_code+"' and upper(a."+search_by2+")  like upper('"+search_txt+"%') UNION SELECT ALLERGEN_CODE code, mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM MR_ALLERGEN  WHERE ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') AND allergen_code NOT IN ( SELECT generic_id FROM ph_generic_name) and upper(mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1))  like upper('"+search_txt+"%') UNION SELECT GENERIC_ID code, GENERIC_NAME description,'N' eff_status1 FROM PH_GENERIC_NAME  WHERE GENERIC_ID NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') and upper("+search_by2+")  like upper('"+search_txt+"%')";
				}else
				{
					sql_list="SELECT a.ALLERGEN_CODE code,  mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description,'Y' eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' AND  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND a.allergen_code NOT IN ( SELECT generic_id FROM ph_generic_name) UNION SELECT a.GENERIC_ID code, a.GENERIC_NAME description, 'Y' eff_status1 FROM PH_GENERIC_NAME a,mr_adv_rea_cause_agent b where a.generic_id = b.ALLERGEN_CODE and b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' and b.adv_reac_code ='"+reac_code+"'  UNION SELECT ALLERGEN_CODE code,  mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM MR_ALLERGEN  WHERE ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') AND allergen_code NOT IN ( SELECT generic_id FROM ph_generic_name) UNION SELECT GENERIC_ID code, GENERIC_NAME description,'N' eff_status1 FROM PH_GENERIC_NAME  WHERE GENERIC_ID NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') ";
				}
				
		

				sql_list=sql_list+" order by description ";



			}else
			{
				//sql_list="SELECT   a.ALLERGEN_CODE code, a.long_desc description,b.eff_status eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' ";

				
				
				if(!search_by.equals("") && !search_txt.equals(""))
				{
				sql_list="SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description , 'Y' eff_status1 FROM mr_adv_rea_cause_agent a, mr_allergen b WHERE  a.adv_reac_code ='"+reac_code+"' AND a.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND b.ADV_EVENT_TYPE_CODE='"+adv_event_type+"'and a.allergen_code=b.allergen_code AND upper(mr_get_desc.mr_allergen(b.allergen_code,'"+locale+"',1)) like upper('"+search_txt+"%') UNION SELECT ALLERGEN_CODE code,mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM  MR_ALLERGEN WHERE ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND ADV_EVENT_TYPE_CODE='"+adv_event_type+"'AND upper(mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1)) like upper('"+search_txt+"%') AND ALLERGEN_CODE NOT IN(SELECT DISTINCT ALLERGEN_CODE FROM mr_adv_rea_cause_agent WHERE adv_reac_code ='"+reac_code+"' AND ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"')";
				}else
				{
				sql_list="SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description, 'Y' eff_status1 FROM mr_adv_rea_cause_agent a, mr_allergen b WHERE  a.adv_reac_code ='"+reac_code+"' AND a.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND b.ADV_EVENT_TYPE_CODE='"+adv_event_type+"'and a.allergen_code=b.allergen_code UNION SELECT ALLERGEN_CODE code,mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM  MR_ALLERGEN WHERE ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT DISTINCT ALLERGEN_CODE FROM mr_adv_rea_cause_agent WHERE adv_reac_code ='"+reac_code+"' AND ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"')";
				}


				sql_list=sql_list+" order by description ";
			}
				rsas=stmt1.executeQuery(sql_list);
%>
<P>
		<table align='right'>
		<tr>
		<td>
		<%
	int start_val=start-15;
	int end_val=end-15;
		if ( !(start <= 1) )
			{
			%><td align ='right' id='prev'><A HREF='javascript:submitPrevNext("<%=start_val%>","<%=end_val%>","Previous")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td><%
			}

		if ( !( (start+15) > maxRecord ) )
			{
			%>
			<td align ='right' id='next'><A HREF='javascript:submitPrevNext("<%=(start+15)%>","<%=(end+15)%>","Next")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
		<%}	%>
		</tr>
		</td>
		</table>
		<br><br>
		</P>
	<table border='1' cellpadding='0' cellspacing='0' width='85%' align='center'>
			<%if(maxRecord > 0){%>
					<th><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></th>
					<th><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' onClick='selectAll_S(this);' ></th>
			<%}
	
			
			if ( start != 1 )
			 for( int j=1; j<start; m++,j++ ){
			  rsas.next() ;

			  }

			while ( rsas.next() && m<=end )
			{
							causative_code =	rsas.getString("code");
							causative_desc =	rsas.getString("description");
							eff_status     =    rsas.getString("eff_status1");
							if(eff_status ==null) eff_status="";
								if(adv_event_type.equals("DA"))
			{
							if(eff_status.equals("Y") )
							{
								checkBoxAttribute="CHECKED";
							}else {
								checkBoxAttribute="";

							}
			}else
				{
					if(eff_status.equals("Y") )
							{
								checkBoxAttribute="CHECKED";
							}else {
								checkBoxAttribute="";

							}
			}
						if ( m % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							%>
					<tr>
						<td class='<%=classValue%>' width='14%' nowrap>&nbsp;<%=causative_desc%></td>
						<td class="<%=classValue%>" nowrap width='2%'>&nbsp;<input type='checkbox' id='check_box'name='checkBox<%=k%>'onClick='javascript:checkBoxOnClick(this);' value='' <%=checkBoxAttribute%> ><input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=causative_code%>'></td>
						<input type='hidden' name='causative_code<%=k%>' id='causative_code<%=k%>' value='<%=causative_code%>'>
						<input type='hidden' name='reaction_val<%=k%>' id='reaction_val<%=k%>' value='<%=adv_event_type_ind%>'>
						
					</tr>
				<%	
					k=k+1;
					m++;	
					
				  }
			%>
 				<input type='hidden' name='cnt' id='cnt' value="<%=(start+15)%>">
				<input type='hidden' name='mode' id='mode' value="<%=mode%>">
				<input type='hidden' name='eff_status1' id='eff_status1' value="">
				<input type='hidden' name='fin_vals' id='fin_vals' value="">
				<input type='hidden' name='adv_reac_code' id='adv_reac_code' value="">
				<input type='hidden' name='adv_reac_long_desc' id='adv_reac_long_desc' value="">
				<input type='hidden' name='adv_reac_short_desc' id='adv_reac_short_desc' value="">
				<input type='hidden' name='eff_status' id='eff_status' value="">
				<input type='hidden' name='causative_code_val' id='causative_code_val' value=''>
				<input type='hidden' name='reaction_fin_val' id='reaction_fin_val' value=''>
				<input type='hidden' name='reac_code' id='reac_code' value='<%=reac_code%>'>
				<input type='hidden' name='adv_event_type_ind' id='adv_event_type_ind' value='<%=adv_event_type_ind%>'>
				<input type='hidden' name='adv_event_type' id='adv_event_type' value='<%=adv_event_type%>'>
				<input type='hidden' name='finalval' id='finalval' value=''>
				<input type='hidden' name='allergen_code_all' id='allergen_code_all' value=''>
				<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
				<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>
				<input type='hidden' name='isOnApply' id='isOnApply' value='N'>
				<input type='hidden' name='cnt_to' id='cnt_to' value='<%=(end+15)%>'>
				<input type='hidden' name='end' id='end' value=''>

					</table>
		</form>
	</body>
</html>
	<%!	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	? "" : inputString;
		}

		private String checkForNull(String inputString, String defaultValue)
		{
			return (inputString==null)	? defaultValue : inputString;
		}
%><%
		if(rs !=null) rs.close();
		if(rsas !=null) rsas.close();
		if(stmt1 !=null) stmt1.close();
		if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));				parent.frames[2].location.href='../../eCommon/html/blank.html';</script>");
				}
	}catch(Exception e)
	{
		out.println("Exception "+e);
		e.printStackTrace();

	}finally{
			ConnectionManager.returnConnection(conn,request);

	}%>

