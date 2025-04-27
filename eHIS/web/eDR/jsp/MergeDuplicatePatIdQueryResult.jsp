<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicatePatient.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	String locale = (String)session.getAttribute("LOCALE");
	Connection con				= null;
	java.sql.Statement stmt		= null;
	java.sql.PreparedStatement pstmt	= null;	 
	ResultSet rs				= null;
	ResultSet rs1				= null;	 
	StringBuffer fin_querysb	= null;
	StringBuffer date_query		= null;	 
	 
	StringBuffer p_linesb		= null;	 
	String asc_desc="1";	 
	String first_name_init		= "";  
	String second_name_init		= "";
	String third_name_init		= "";
	String family_name_init		= "";
	String first_name_prompt	= "";	
	String second_name_prompt	= "";	
	String third_name_prompt	= "";	
	String family_name_prompt	= "";
	String area_type			= "";
	String classValue			= "";
	String str					= "";	 
	String s_lable					= "";	 
 
	int i					= 1;
	int count				= 0;

	String facilityId	= (String) session.getValue("facility_id");

//	String from			= request.getParameter("from");
//	String to			= request.getParameter("to");
	String p_line		= request.getParameter("p_line")==null?"":request.getParameter("p_line");
	
//	String acc_btn_dis		= request.getParameter("acc_btn_dis")==null?"":request.getParameter("acc_btn_dis");
	String fin_query	= request.getParameter("final_query");
//	String call_again	= "";
	String date_val		= request.getParameter("date_val");
	String date_form	= request.getParameter("date_form");
//	String order_by_val	= request.getParameter("order_by_val");
//	if(order_by_val==null) order_by_val="";
	String all_facil	= request.getParameter("all_facil");
	asc_desc = request.getParameter("asc_desc") == null ? "1" : request.getParameter("asc_desc");
	String date_value = "" ;
	String names_in_oth_lang_yn = "" ;
	try
	{ 
		
	//	call_again	= request.getParameter("call_again");	 
		fin_querysb		= new StringBuffer();
		date_query		= new StringBuffer(); 
		p_linesb		= new StringBuffer();
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();			 
		 if(date_val != null) {			 
			date_value =  DateUtils.convertDate(date_val,"DMY",locale,"en");			
			if(date_form.equals("Y")) {
					date_query.append("");
					date_query.append(" AND ");
					date_query.append("to_number(to_char(date_of_birth,'YYYY')) = "+"to_number(to_char(to_date('"+date_value+"','DD/MM/RRRR'),'YYYY'))");
			}else if(date_form.equals("MY")) {
					date_query.append("");
					date_query.append(" AND ");
					date_query.append("to_date(to_char(date_of_birth,'MMYYYY'),'MMYYYY') = "+"to_date(to_char(to_date('"+date_value+"','DD/MM/RRRR'),'MMYYYY'),'MMYYYY')");
			}else if(date_form.equals("D")) {
					date_query.append("");
					date_query.append(" AND ");
					date_query.append("date_of_birth between to_date('"+date_value+"','dd/mm/yyyy') AND TO_DATE ('"+date_value+" 23:59:59', 'dd/mm/yyyy hh24:mi:ss') ");					   
			}
		}		 
		
        fin_querysb.append(fin_query);
		fin_querysb.append(date_query);
		if(!all_facil.equals("N")) {
				fin_querysb.append(" AND regn_facility_id = '"+facilityId+"'");
		}
				
	 
		
		str="";
		
		if(rs!=null) rs.close();
		
		str="";
		str="SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn, family_name_accept_yn, nvl(first_name_prompt,'First name') first_name_prompt,nvl(second_name_prompt,'Second name') second_name_prompt, nvl(third_name_prompt,'Third name') third_name_prompt ,nvl(family_name_prompt,'Family name') family_name_prompt,nvl(first_name_loc_lang_prompt,'First Name Loc Lang') first_name_loc_lang_prompt 		,nvl(second_name_loc_lang_prompt,'Second Name Loc Lang') second_name_loc_lang_prompt ,nvl(third_name_loc_lang_prompt,'Third Name Loc Lang') third_name_loc_lang_prompt ,nvl(family_name_loc_lang_prompt,'Family Name Loc Lang') family_name_loc_lang_prompt , accept_national_id_no_yn,nvl(Nat_ID_Prompt,'National ID No') Nat_ID_Prompt, mp_get_desc.mp_alternate_id_type (alt_id1_type, '"+locale+"', 1) alt_id1_desc,mp_get_desc.mp_alternate_id_type (alt_id2_type,'"+locale+"', 1) alt_id2_desc,       mp_get_desc.mp_alternate_id_type (alt_id3_type, '"+locale+"', 1) alt_id3_desc, mp_get_desc.mp_alternate_id_type (alt_id4_type, '"+locale+"', 1) alt_id4_desc,accept_oth_alt_id_yn,dflt_sndx_type, res_area_prompt,search_threshold_records,names_in_oth_lang_yn FROM mp_param_lang_vw a, sm_site_param_lang_vw b WHERE a.language_id = '"+locale+"' AND b.language_id = '"+locale+"'";		
		 
		String first_name_loc_lang_prompt = "";
		String second_name_loc_lang_prompt = "";
		String third_name_loc_lang_prompt = "";
		String family_name_loc_lang_prompt = "";
		String accept_national_id_no_yn = "";
		String Nat_ID_Prompt = "";
		String alt_id1_desc = "";
		String alt_id2_desc = "";
		String alt_id3_desc = "";
		String alt_id4_desc = "";
		String accept_oth_alt_id_yn = "";
		rs = stmt.executeQuery(str);
		if(rs!=null)
		{
			if(rs.next())
			{
				first_name_init        =rs.getString("first_name_accept_yn")==null?"":rs.getString("first_name_accept_yn");
				 second_name_init		=rs.getString("second_name_accept_yn")==null?"":rs.getString("second_name_accept_yn");
				 third_name_init		=rs.getString("third_name_accept_yn")==null?"":rs.getString("third_name_accept_yn");
				 family_name_init		=rs.getString("family_name_accept_yn")==null?"":rs.getString("family_name_accept_yn");
				 first_name_prompt		=rs.getString("first_name_prompt")==null?"":rs.getString("first_name_prompt");
				 second_name_prompt		=rs.getString("second_name_prompt")==null?"":rs.getString("second_name_prompt");
				 third_name_prompt		=rs.getString("third_name_prompt")==null?"":rs.getString("third_name_prompt");
				 family_name_prompt		=rs.getString("family_name_prompt")==null?"":rs.getString("family_name_prompt");
				 area_type				=rs.getString("res_area_prompt")==null?"":rs.getString("res_area_prompt");
				 names_in_oth_lang_yn				=rs.getString("names_in_oth_lang_yn")==null?"":rs.getString("names_in_oth_lang_yn");
				 first_name_loc_lang_prompt				=rs.getString("first_name_loc_lang_prompt")==null?"":rs.getString("first_name_loc_lang_prompt");
				 second_name_loc_lang_prompt				=rs.getString("second_name_loc_lang_prompt")==null?"":rs.getString("second_name_loc_lang_prompt");
				 third_name_loc_lang_prompt				=rs.getString("third_name_loc_lang_prompt")==null?"":rs.getString("third_name_loc_lang_prompt");
				 family_name_loc_lang_prompt				=rs.getString("family_name_loc_lang_prompt")==null?"":rs.getString("family_name_loc_lang_prompt");
				 accept_national_id_no_yn				=rs.getString("accept_national_id_no_yn")==null?"":rs.getString("accept_national_id_no_yn");
				 Nat_ID_Prompt				=rs.getString("Nat_ID_Prompt")==null?"":rs.getString("Nat_ID_Prompt");
				 alt_id1_desc				=rs.getString("alt_id1_desc")==null?"":rs.getString("alt_id1_desc");
				 alt_id2_desc				=rs.getString("alt_id2_desc")==null?"":rs.getString("alt_id2_desc");
				 alt_id3_desc				=rs.getString("alt_id3_desc")==null?"":rs.getString("alt_id3_desc");
				 alt_id4_desc				=rs.getString("alt_id4_desc")==null?"":rs.getString("alt_id4_desc");
				 accept_oth_alt_id_yn				=rs.getString("accept_oth_alt_id_yn")==null?"":rs.getString("accept_oth_alt_id_yn");
			}	
		} if(rs!=null) rs.close();

			 
		String modeQuery="select contact_mode, short_desc from mp_contact_mode_lang_vw where contact_mode in ('PRN', 'ORN') and language_id = '"+locale+"'";
		String cnt_mode = "";
		String prn_label = "";
		String orn_label = "";

		rs = stmt.executeQuery(modeQuery);
		while(rs.next()){
				cnt_mode=rs.getString("contact_mode");
			if(cnt_mode.equals("PRN"))
				prn_label=rs.getString("short_desc")==null?"":rs.getString("short_desc");
			if(cnt_mode.equals("ORN"))
				orn_label=rs.getString("short_desc")==null?"":rs.getString("short_desc");
		}	
		 if(rs!=null) rs.close();	 
	

	StringBuffer sqlQuery = new StringBuffer();
	 
	sqlQuery.append("SELECT patient_id,curr_patient_class,patient_name_loc_lang ,first_name, second_name, third_name, family_name, national_id_no, alt_id1_no, alt_id2_no, alt_id3_no, alt_id4_no, oth_alt_id_no,mp_get_desc.mp_res_area (res_area_code, 'en', 2) area_desc,active_yn, suspend_yn, deceased_yn, sex, (CASE WHEN oth_alt_id_no IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = oth_alt_id_type AND language_id = '"+locale+"') END) other_alt_id_type_desc, TO_CHAR (date_of_birth, 'dd/mm/yyyy') date_of_birth, contact1_no, contact2_no,first_name_loc_lang, second_name_loc_lang, third_name_loc_lang,family_name_loc_lang FROM mp_patient where ");
	if(!fin_querysb.equals(""))
		sqlQuery.append(fin_querysb);	 
		
		rs1 = stmt.executeQuery(sqlQuery.toString());
%><body onMouseDown="CodeArrest()" onKeyDown ='lockKey();'>
	<form name='search_result_form' id='search_result_form' action='../../servlet/eDR.MergeDuplicateServlet' method='post' target='messageFrame'>	
	<%
		 
		pstmt=con.prepareStatement(sqlQuery.toString());
		%>

		<%
		rs1=pstmt.executeQuery();
	 
		int header = 0;
		%>
		
		<table border=1 cellpadding=0 cellspacing=0 align='center' ID='tb1'>		

		<%
		while((rs1 != null && rs1.next())) {				
			count++;
			 
			if(count==21){
				%>
				<script>alert(getMessage('TOOMANY_RECORDS_REFINE_SEARCH','DR'));					 
				    parent.frames[2].document.getElementById('search').disabled=false;					 
					parent.frames[2].document.getElementById('accept').disabled=true;
					self.location.href='../../eCommon/html/blank.html';
				</script>
				<%
				break;
			}
			
	 
		if(header==0) {		 
	%>
		<tr>
		<th class='columnheader' colspan='25' align=left><fmt:message key="eDR.PossibleDuplicates.label" bundle="${dr_labels}"/></th>
		</tr>			
		 <tr><th width='2%' class='label' nowrap align='center'><b>+</b></th>	
		<th align='center' nowrap><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></th>
		<!-- <th align='center' nowrap><b><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></b></th> -->
		<th align='center' nowrap><b>S</b></th>
		<th align='center' nowrap><b>PC</b></th>
		<th align='center' nowrap><b><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></b></th>
		<th align='center' nowrap><b><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></b></th>
	   <% 		
		if(first_name_init.equals("Y")){
		if(!first_name_prompt.equals("")){%>
		<th align='center' nowrap><b><%=first_name_prompt%></b></th>
		<%}}
		if(second_name_init.equals("Y")){
		if(!second_name_prompt.equals("")){%>
		<th align='center' nowrap><b><%=second_name_prompt%></b></th>
		<%}}
		if(third_name_init.equals("Y")){
		if(!third_name_prompt.equals("")){%>
		<th align='center' nowrap><b><%=third_name_prompt%></b></th>
		<%}}
		if(family_name_init.equals("Y")){
		if(!family_name_prompt.equals("")){%>
		<th align='center' nowrap><b><%=family_name_prompt%></b></th>
		<%}}
		if(names_in_oth_lang_yn.equals("Y")){%>
		<th align='center' nowrap><b><fmt:message key="eMP.PatientNameInLocalLang.label" bundle="${mp_labels}"/></b></th>
		<%
		if(first_name_init.equals("Y")){
			if(!first_name_loc_lang_prompt.equals("")){ %>
				<th align='center' nowrap><b><%=first_name_loc_lang_prompt%></b></th>
			<%
			} 
		  }		
		if(second_name_init.equals("Y")){
			if(!second_name_loc_lang_prompt.equals("")){ %>
				<th align='center' nowrap><b><%=second_name_loc_lang_prompt%></b></th>
			<%
			} 
		  }		
		if(third_name_init.equals("Y")){
			if(!third_name_loc_lang_prompt.equals("")){ %>
				<th align='center' nowrap><b><%=third_name_loc_lang_prompt%></b></th>
			<%
			} 
		  }		
		if(family_name_init.equals("Y")){
			if(!family_name_loc_lang_prompt.equals("")){ %>
				<th align='center' nowrap><b><%=family_name_loc_lang_prompt%></b></th>
			<%
			} 
		  }
		}
		if(accept_national_id_no_yn.equals("Y")){
		%>
		  <th nowrap ><b><%=Nat_ID_Prompt%></b></th><%
		}
		if(!alt_id1_desc.equals("")){
		%>
		<th nowrap ><b><%=alt_id1_desc%></b></th><%
		}
		if(!alt_id2_desc.equals("")){
		%>
		<th nowrap ><b><%=alt_id2_desc%></b></th><%
		}if(!alt_id3_desc.equals("")){
		%>
		<th nowrap ><b><%=alt_id3_desc%></b></th><%
		}if(!alt_id4_desc.equals("")){
		%>
		<th nowrap ><b><%=alt_id4_desc%></b></th><%
		}
		if(accept_oth_alt_id_yn.equals("Y")){%>			 
			 <th nowrap ><b><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></b></th>
			 <th nowrap ><b><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></b></th>
			<%
			}
		if(!area_type.equals("")){%>
		<th align='center' nowrap><b><%=area_type%></b></th>
		<%} if(!prn_label.equals("")){%>
		<th align='center' nowrap><b><%=prn_label%></b></th>
		<%}if(!orn_label.equals("")){%>
		<th align='center' nowrap><b><%=orn_label%></b></th>
		<%}%>
		
		
		 
		<%	
		}
		 	
			p_linesb.append(rs1.getString("patient_id"));		 
			p_linesb.append("|");		 
	
		if(i % 2 == 0) classValue = "QRYEVEN" ;
				else classValue = "QRYODD" ;		
		
		if(rs1.getString("deceased_yn").equals("Y")){
			s_lable="DECEASED";
		}else if(rs1.getString("suspend_yn").equals("Y")){
			s_lable="SUSPENDED";
		}else if(rs1.getString("active_yn").equals("N")){
			s_lable="INACTIVE";
		}
	
		out.println("<tr><td class='" + classValue + "' nowrap align='center'>");
		out.println("<a href=javascript:viewPatientDetails('"+rs1.getString("patient_id")+"')>");
		out.println("+</a></td>");
		%>
		<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("patient_id")%></td>
		<%			 
		if(s_lable.equals("")){ %>
			 <TD nowrap class=<%=classValue%>>&nbsp;</TD>
		<%}else{ %>
				 <TD nowrap class=<%=s_lable%>></TD> 
		<%} %>
		<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("curr_patient_class")==null?"&nbsp;":rs1.getString("curr_patient_class")%></td>
		<%if(rs1.getString("sex").equals("M")) {%>
		<td class=<%=classValue%> align='center'  nowrap><fmt:message key="Common.male.label" bundle="${common_labels}"/></td>
		<%} else if(rs1.getString("sex").equals("F")) {%>
		<td class=<%=classValue%> align='center'  nowrap><fmt:message key="Common.female.label" bundle="${common_labels}"/></td>
		<%} else if(rs1.getString("sex").equals("U")) {%>
		<td class=<%=classValue%> align='center'  nowrap><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></td>
		<%} %>
		<td class=<%=classValue%> align='center' nowrap><%=DateUtils.convertDate(rs1.getString("date_of_birth"),"DMY","en",locale)%></td>		
		<% if(first_name_init.equals("Y")){
		if(!first_name_prompt.equals("")){%>
		<td class=<%=classValue%> nowrap align='center'><%=rs1.getString("first_name")==null?"&nbsp;":rs1.getString("first_name")%></td>
		<%}}
		if(second_name_init.equals("Y")){
		if(!second_name_prompt.equals("")){%>
		<td class=<%=classValue%> nowrap align='center'><%=rs1.getString("second_name")==null?"&nbsp;":rs1.getString("second_name")%></td>
		<%}}
		if(third_name_init.equals("Y")){
		if(!third_name_prompt.equals("")){%>
		<td class=<%=classValue%> nowrap align='center'><%=rs1.getString("third_name")==null?"&nbsp;":rs1.getString("third_name")%></td>
		<%}}
		if(family_name_init.equals("Y")){
		if(!family_name_prompt.equals("")){%>
		<td class=<%=classValue%> nowrap align='center'><%=rs1.getString("family_name")==null?"&nbsp;":rs1.getString("family_name")%></td>
		<%}}
		if(names_in_oth_lang_yn.equals("Y")){%>
		<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("patient_name_loc_lang")==null?"&nbsp;":rs1.getString("patient_name_loc_lang")%></td>
		<%		
		if(first_name_init.equals("Y")){
			if(!first_name_loc_lang_prompt.equals("")){ %>
				<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("first_name_loc_lang")==null?"&nbsp;":rs1.getString("first_name_loc_lang")%></td>
			<%
			} 
		  }
		  if(second_name_init.equals("Y")){
			if(!second_name_loc_lang_prompt.equals("")){ %>
				<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("second_name_loc_lang")==null?"&nbsp;":rs1.getString("second_name_loc_lang")%></td>
			<%
			} 
		  }
		  if(third_name_init.equals("Y")){
			if(!third_name_loc_lang_prompt.equals("")){ %>
				<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("third_name_loc_lang")==null?"&nbsp;":rs1.getString("third_name_loc_lang")%></td>
			<%
			} 
		  }
		  if(family_name_init.equals("Y")){
			if(!family_name_loc_lang_prompt.equals("")){ %>
				<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("family_name_loc_lang")==null?"&nbsp;":rs1.getString("family_name_loc_lang")%></td>
			<%
			} 
		  }
		}
		if(accept_national_id_no_yn.equals("Y")){
			%>
		<td class=<%=classValue%> align='center'  nowrap><%=rs1.getString("national_id_no")==null?"&nbsp;":rs1.getString("national_id_no")%></td>
		<%}
		if(!alt_id1_desc.equals("")){
		%><td class=<%=classValue%> align='center'  nowrap><%=rs1.getString("alt_id1_no")==null?"&nbsp;":rs1.getString("alt_id1_no")%></td>
		<%} 
		if(!alt_id2_desc.equals("")){
		%><td class=<%=classValue%> align='center'  nowrap><%=rs1.getString("alt_id2_no")==null?"&nbsp;":rs1.getString("alt_id2_no")%></td>
		<%} 
		if(!alt_id3_desc.equals("")){
		%><td class=<%=classValue%> align='center'  nowrap><%=rs1.getString("alt_id3_no")==null?"&nbsp;":rs1.getString("alt_id3_no")%></td>
		<%} 
		if(!alt_id4_desc.equals("")){
		%><td class=<%=classValue%> align='center'  nowrap><%=rs1.getString("alt_id4_no")==null?"&nbsp;":rs1.getString("alt_id4_no")%></td>
		<%} 
		if(accept_oth_alt_id_yn.equals("Y")){
		%>		
		<td class=<%=classValue%> align='center'  nowrap><%=rs1.getString("other_alt_id_type_desc")==null?"&nbsp;":rs1.getString("other_alt_id_type_desc")%></td>
		<td class=<%=classValue%> align='center'  nowrap><%=rs1.getString("oth_alt_id_no")==null?"&nbsp;":rs1.getString("oth_alt_id_no")%></td>
		<%} if(!area_type.equals("")){%>
		<td class=<%=classValue%> align='center'  nowrap><%=rs1.getString("area_desc")==null?"&nbsp;":rs1.getString("area_desc")%></td>
		<%}%>
		<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("contact1_no")==null?"&nbsp;":rs1.getString("contact1_no")%></td>		
		<td class=<%=classValue%> align='center' nowrap><%=rs1.getString("contact2_no")==null?"&nbsp;":rs1.getString("contact2_no")%></td>	
		
		</tr>
		<%	 
			i++;	
			header++;		
		%>
		
<%  }// while loop
	%>
	</table>
	
	<%
		
	if(count==0){				 
				 	
	 	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	} 
		 p_line=p_linesb.toString();
		 

	 	fin_query=fin_querysb.toString();
		if(fin_querysb!=null || fin_querysb.length() >0)
		fin_querysb.setLength(0);
		if(date_query!=null || date_query.length() >0)
		date_query.setLength(0);	 
		if(p_linesb!=null || p_linesb.length() >0)
		p_linesb.setLength(0);
		
		if (rs!=null) rs.close();
		if(stmt !=null) stmt.close();
		if(rs1 != null) rs1.close();
        if(pstmt !=null) pstmt.close();
		 
	}
	catch(Exception es)
	{
		out.println("Exception display query "+es);
		es.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	<input type='hidden' name='count' id='count' value='<%=count%>'>
 
	 
	 <script>
        parent.frames[2].document.getElementById('search').disabled=false;
	 
		var count = document.getElementById('count').value ;		 
		if(parseInt(count) > 1 && parseInt(count) <=20) {  
			parent.frames[2].document.getElementById('accept').disabled=false;
		} else {  
		   parent.frames[2].document.getElementById('accept').disabled=true;
		}

	</script> 
	<input type='hidden' name='mode' id='mode' value='delete'>
	<input type='hidden' name='fin_query' id='fin_query' value="<%=fin_query%>"> 
	<input type='hidden' name='date_form' id='date_form' value='<%=date_form%>'> 
	<input type='hidden' name='date_val' id='date_val' value='<%=date_value%>'> 
	<input type='hidden' name='search_all' id='search_all' value=''> 
	<input type='hidden' name='p_line' id='p_line' value='<%=p_line%>'> 
	<input type='hidden' name='modal' id='modal' value='Y'> 
	<input type='hidden' name='asc_desc' id='asc_desc' value='<%=asc_desc%>'> 
	</table>
	</form>
</body>
</html>

