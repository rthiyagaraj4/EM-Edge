<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<form name ="ppp">
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");	
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");		
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id=(String) session.getValue( "facility_id");
		String name_prefix=request.getParameter("name_prefix")==null?"":request.getParameter("name_prefix");
		String first_name=request.getParameter("first_name")==null?"":request.getParameter("first_name");	
		String second_name=request.getParameter("second_name")==null?"":request.getParameter("second_name");
		String third_name=request.getParameter("third_name")==null?"":request.getParameter("third_name");
		String family_name=request.getParameter("family_name")==null?"":request.getParameter("family_name");
		String name_suffix=request.getParameter("name_suffix")==null?"":request.getParameter("name_suffix");
		String name_prefix_oth_lang=request.getParameter("name_prefix_oth_lang")==null?"":request.getParameter("name_prefix_oth_lang");
		String first_name_oth_lang=request.getParameter("first_name_oth_lang")==null?"":request.getParameter("first_name_oth_lang");	
		String second_name_oth_lang=request.getParameter("second_name_oth_lang")==null?"":request.getParameter("second_name_oth_lang");
		String third_name_oth_lang=request.getParameter("third_name_oth_lang")==null?"":request.getParameter("third_name_oth_lang");
		String family_name_oth_lang=request.getParameter("family_name_oth_lang")==null?"":request.getParameter("family_name_oth_lang");
		String name_suffix_oth_lang=request.getParameter("name_suffix_oth_lang")==null?"":request.getParameter("name_suffix_oth_lang");
		String gender=request.getParameter("gender")==null?"":request.getParameter("gender");
		String contact_no=request.getParameter("contact_no")==null?"":request.getParameter("contact_no");
		String nationality=request.getParameter("nationality")==null?"":request.getParameter("nationality");
		String language=request.getParameter("language")==null?"":request.getParameter("language");
		StringBuffer whereClause = new StringBuffer("");
		String sql="";		
		String classValue = "";
		String drvdname="";
		String prev_drvdname="";
		String patient_name = "";
		int t=0;
		int no_of_records=0;		
		Connection con = null;
		PreparedStatement ps=null ;
		ResultSet rset=null;
		/*System.out.println("name_prefix :"+name_prefix);
		System.out.println("first_name :"+first_name);
		System.out.println("second_name :"+second_name);
		System.out.println("third_name :"+third_name);
		System.out.println("family_name :"+family_name);
		System.out.println("name_suffix :"+name_suffix);
		System.out.println("name_prefix_oth_lang :"+name_prefix_oth_lang);
		System.out.println("first_name_oth_lang :"+first_name_oth_lang);
		System.out.println("second_name_oth_lang :"+second_name_oth_lang);
		System.out.println("third_name_oth_lang :"+third_name_oth_lang);
		System.out.println("family_name_oth_lang :"+family_name_oth_lang);
		System.out.println("name_suffix_oth_lang :"+name_suffix_oth_lang);*/
		
		int no_of_fut_appts_for_alert=Integer.parseInt(request.getParameter("no_of_fut_appts_for_alert")==null?"0":request.getParameter("no_of_fut_appts_for_alert"));
		int per_chk_for_fut_appts_alert=Integer.parseInt(request.getParameter("per_chk_for_fut_appts_alert")==null?"0":request.getParameter("per_chk_for_fut_appts_alert"));
		int no_of_resch_appts_for_alert=Integer.parseInt(request.getParameter("no_of_resch_appts_for_alert")==null?"0":request.getParameter("no_of_resch_appts_for_alert"));
		int per_chk_past_resch_appts=Integer.parseInt(request.getParameter("per_chk_past_resch_appts")==null?"0":request.getParameter("per_chk_past_resch_appts"));
		int per_chk_fut_resch_appts=Integer.parseInt(request.getParameter("per_chk_fut_resch_appts")==null?"0":request.getParameter("per_chk_fut_resch_appts"));
		int no_of_cancld_appts_for_alert=Integer.parseInt(request.getParameter("no_of_cancld_appts_for_alert")==null?"0":request.getParameter("no_of_cancld_appts_for_alert"));
		int per_chk_cancld_past_appts=Integer.parseInt(request.getParameter("per_chk_cancld_past_appts")==null?"0":request.getParameter("per_chk_cancld_past_appts"));
		int per_chk_cancld_fut_appts=Integer.parseInt(request.getParameter("per_chk_cancld_fut_appts")==null?"0":request.getParameter("per_chk_cancld_fut_appts"));		
		int no_of_noshow_appts_for_alert=Integer.parseInt(request.getParameter("no_of_noshow_appts_for_alert")==null?"0":request.getParameter("no_of_noshow_appts_for_alert"));
		int per_chk_for_no_show_alert=Integer.parseInt(request.getParameter("per_chk_for_no_show_alert")==null?"0":request.getParameter("per_chk_for_no_show_alert"));
		
		
		
		String name_prefix_prompt="";
		String first_name_prompt="";
		String second_name_prompt="";
		String third_name_prompt="";
		String family_name_prompt="";
		String name_suffix_prompt="";
		String name_prefix_accept_yn="";
		String first_name_accept_yn="";
		String second_name_accept_yn="";
		String third_name_accept_yn="";
		String family_name_accept_yn="";
		String name_suffix_accept_yn="";		
		String pat_name_as_multipart_yn="";
		String names_in_oth_lang_yn="";
		String name_prefix_oth_lang_prompt="";
		String first_name_oth_lang_prompt="";
		String second_name_oth_lang_prompt="";
		String third_name_oth_lang_prompt="";
		String family_name_oth_lang_prompt="";
		String name_suffix_oth_lang_prompt="";
		int count=3;
		

		try
		{	
			con = ConnectionManager.getConnection(request);
			sql="Select pat_name_as_multipart_yn,NAMES_IN_OTH_LANG_YN,NAME_PREFIX_ACCEPT_YN,NAME_PREFIX_PROMPT,FIRST_NAME_ACCEPT_YN, FIRST_NAME_PROMPT,SECOND_NAME_ACCEPT_YN, SECOND_NAME_PROMPT,THIRD_NAME_ACCEPT_YN, THIRD_NAME_PROMPT,FAMILY_NAME_ACCEPT_YN,FAMILY_NAME_PROMPT,name_suffix_accept_yn,NAME_SUFFIX_PROMPT,NAME_PREFIX_LOC_LANG_PROMPT,FIRST_NAME_LOC_LANG_PROMPT,SECOND_NAME_LOC_LANG_PROMPT,THIRD_NAME_LOC_LANG_PROMPT,FAMILY_NAME_LOC_LANG_PROMPT,NAME_SUFFIX_LOC_LANG_PROMPT from mp_param where module_id='MP'";
			ps = con.prepareStatement(sql);
			rset=ps.executeQuery();	
			if(rset!=null && rset.next()){
				pat_name_as_multipart_yn=rset.getString("pat_name_as_multipart_yn")==null?"":rset.getString("pat_name_as_multipart_yn");
				names_in_oth_lang_yn=rset.getString("NAMES_IN_OTH_LANG_YN")==null?"":rset.getString("NAMES_IN_OTH_LANG_YN");
				name_prefix_prompt=rset.getString("name_prefix_prompt")==null?"":rset.getString("name_prefix_prompt");
				first_name_prompt=rset.getString("FIRST_NAME_PROMPT")==null?"":rset.getString("FIRST_NAME_PROMPT");
				second_name_prompt=rset.getString("SECOND_NAME_PROMPT")==null?"":rset.getString("SECOND_NAME_PROMPT");
				third_name_prompt=rset.getString("THIRD_NAME_PROMPT")==null?"":rset.getString("THIRD_NAME_PROMPT");
				family_name_prompt=rset.getString("FAMILY_NAME_PROMPT")==null?"":rset.getString("FAMILY_NAME_PROMPT");
				name_suffix_prompt=rset.getString("NAME_SUFFIX_PROMPT")==null?"":rset.getString("NAME_SUFFIX_PROMPT");
				name_prefix_accept_yn=rset.getString("NAME_PREFIX_ACCEPT_YN")==null?"":rset.getString("NAME_PREFIX_ACCEPT_YN");
				first_name_accept_yn=rset.getString("FIRST_NAME_ACCEPT_YN")==null?"":rset.getString("FIRST_NAME_ACCEPT_YN");
				second_name_accept_yn=rset.getString("SECOND_NAME_ACCEPT_YN")==null?"":rset.getString("SECOND_NAME_ACCEPT_YN");
				third_name_accept_yn=rset.getString("THIRD_NAME_ACCEPT_YN")==null?"":rset.getString("THIRD_NAME_ACCEPT_YN");
				family_name_accept_yn=rset.getString("FAMILY_NAME_ACCEPT_YN")==null?"":rset.getString("FAMILY_NAME_ACCEPT_YN");
				name_suffix_accept_yn=rset.getString("name_suffix_accept_yn")==null?"":rset.getString("name_suffix_accept_yn");
				name_prefix_oth_lang_prompt=rset.getString("NAME_PREFIX_LOC_LANG_PROMPT")==null?"":rset.getString("NAME_PREFIX_LOC_LANG_PROMPT");
				first_name_oth_lang_prompt=rset.getString("FIRST_NAME_LOC_LANG_PROMPT")==null?"":rset.getString("FIRST_NAME_LOC_LANG_PROMPT");
				second_name_oth_lang_prompt=rset.getString("SECOND_NAME_LOC_LANG_PROMPT")==null?"":rset.getString("SECOND_NAME_LOC_LANG_PROMPT");
				third_name_oth_lang_prompt=rset.getString("THIRD_NAME_LOC_LANG_PROMPT")==null?"":rset.getString("THIRD_NAME_LOC_LANG_PROMPT");
				family_name_oth_lang_prompt=rset.getString("FAMILY_NAME_LOC_LANG_PROMPT")==null?"":rset.getString("FAMILY_NAME_LOC_LANG_PROMPT");
				name_suffix_oth_lang_prompt=rset.getString("NAME_SUFFIX_LOC_LANG_PROMPT")==null?"":rset.getString("NAME_SUFFIX_LOC_LANG_PROMPT");
				if(name_prefix_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("Y") && first_name_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("Y") && second_name_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("Y") && third_name_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("Y") && family_name_accept_yn.equals("Y"))
					count++;
				if(pat_name_as_multipart_yn.equals("N"))
					count++;
				if(name_suffix_accept_yn.equals("Y"))
					count++;					
				if(names_in_oth_lang_yn.equals("Y")){
					if(name_prefix_accept_yn.equals("Y"))
					count++;
					if(pat_name_as_multipart_yn.equals("Y") && first_name_accept_yn.equals("Y"))
						count++;
					if(pat_name_as_multipart_yn.equals("Y") && second_name_accept_yn.equals("Y"))
						count++;
					if(pat_name_as_multipart_yn.equals("Y") && third_name_accept_yn.equals("Y"))
						count++;
					if(pat_name_as_multipart_yn.equals("Y") && family_name_accept_yn.equals("Y"))
						count++;
					if(name_suffix_accept_yn.equals("Y"))
						count++;
				}
			}
			
			
			if(rset!=null)rset.close();
			if (!name_prefix.equals("")){					
						whereClause.append(" and name_prefix =?");					
			}
			if (!first_name.equals("")){					
						whereClause.append(" and upper(first_name) like upper(?)");					
			}
			if (!second_name.equals("")){					
						whereClause.append(" and upper(second_name) like upper(?)");					
			}
			if (!third_name.equals("")){				
						whereClause.append(" and upper(third_name) like upper(?)");						
			}
			if (!family_name.equals("")){					
						whereClause.append(" and upper(family_name) like upper(?)");											
			}
			if (!name_suffix.equals("")){					
						whereClause.append(" and name_suffix =?");					
			}
			
			if(names_in_oth_lang_yn.equals("Y")){
				if (!name_prefix_oth_lang.equals("")){					
					whereClause.append(" and NAME_PREFIX_LOC_LANG =?");					
				}
				if (!first_name_oth_lang.equals("")){					
							whereClause.append(" and upper(FIRST_NAME_LOC_LANG) like upper(?)");					
				}
				if (!second_name_oth_lang.equals("")){					
							whereClause.append(" and upper(SECOND_NAME_LOC_LANG) like upper(?)");					
				}
				if (!third_name_oth_lang.equals("")){				
							whereClause.append(" and upper(THIRD_NAME_LOC_LANG) like upper(?)");						
				}
				if (!family_name_oth_lang.equals("")){					
							whereClause.append(" and upper(FAMILY_NAME_LOC_LANG) like upper(?)");											
				}
				if (!name_suffix_oth_lang.equals("")){					
							whereClause.append(" and NAME_SUFFIX_LOC_LANG =?");					
				}
			}
			if (!contact_no.equals("")){					
						whereClause.append(" and oth_contact_no=?");											
			}
			if(!nationality.equals("")){			
						whereClause.append(" and country_code=?");					
			}

			if(!language.equals("")){				
						whereClause.append(" and language_id=?");		
					
			}
			sql="select appt_ref_no,name_prefix,first_name,second_name,third_name,family_name,NAME_SUFFIX,gender,oth_contact_no,(FIRST_NAME||second_name||Third_name||family_name||gender) drvdname,patient_name,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG from oa_appt where facility_id=? and gender=?"+whereClause+" order by first_name,second_name,third_name,family_name,gender";
		
			ps = con.prepareStatement(sql);
			int psCount=1;
			ps.setString(psCount++,fac_id);
			ps.setString(psCount++,gender);
			
			if (!name_prefix.equals("")){
				ps.setString(psCount++,name_prefix);
			}
			if (!first_name.equals("")){
				ps.setString(psCount++,first_name+"%");
			}
			if (!second_name.equals("")){
				ps.setString(psCount++,second_name+"%");
			}
			if (!third_name.equals("")){				
				ps.setString(psCount++,third_name+"%");					
			}
			if (!family_name.equals("")){					
				ps.setString(psCount++,family_name+"%");										
			}
			if (!name_suffix.equals("")){					
				ps.setString(psCount++,name_suffix+"%");					
			}
			if(names_in_oth_lang_yn.equals("Y")){
				if (!name_prefix_oth_lang.equals("")){
					ps.setString(psCount++,name_prefix_oth_lang);
				}
				if (!first_name_oth_lang.equals("")){
					ps.setString(psCount++,first_name_oth_lang+"%");
				}
				if (!second_name_oth_lang.equals("")){
					ps.setString(psCount++,second_name_oth_lang+"%");
				}
				if (!third_name_oth_lang.equals("")){				
					ps.setString(psCount++,third_name_oth_lang+"%");					
				}
				if (!family_name_oth_lang.equals("")){					
					ps.setString(psCount++,family_name_oth_lang+"%");										
				}
				if (!name_suffix_oth_lang.equals("")){					
					ps.setString(psCount++,name_suffix_oth_lang+"%");					
				}
			}
			if (!contact_no.equals("")){					
				ps.setString(psCount++,contact_no);											
			}
			if(!nationality.equals("")){			
				ps.setString(psCount++,nationality);				
			}

			if(!language.equals("")){				
				ps.setString(psCount++,language);					
			}
			//System.out.println("sql:"+sql.toString());
			rset=ps.executeQuery();	
			%>
			<table  border='1' cellpadding='0' cellspacing='0' width='100%' >
			<tr>
			<td class='CAHIGHERLEVELCOLOR' align = 'center' colspan='<%=count%>'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			<td class='CAGROUP' nowrap></td>
			<%if(name_prefix_accept_yn.equals("Y")){%>
				<td class='CAGROUP' nowrap><%=name_prefix_prompt%></td>
			<%}%>
			<%if(first_name_accept_yn.equals("Y")){%>
				<td class='CAGROUP' nowrap><%=first_name_prompt%></td>
			<%}%>
			<%if(second_name_accept_yn.equals("Y")){%>
				<td class='CAGROUP' nowrap><%=second_name_prompt%></td>	
			<%}%>			
			<%if(third_name_accept_yn.equals("Y")){%>			
				<td class='CAGROUP' nowrap><%=third_name_prompt%></td>
			<%}%>
			<%if(family_name_accept_yn.equals("Y")){%>
				<td class='CAGROUP' nowrap><%=family_name_prompt%></td>
			<%}%>
			<%if(pat_name_as_multipart_yn.equals("N")){%>
				<td class='CAGROUP' nowrap><%=family_name_prompt%></td>
			<%}%>		
			<%if(name_suffix_accept_yn.equals("Y")){%>
				<td class='CAGROUP' nowrap><%=name_suffix_prompt%></td>
			<%}%>
			<%if(names_in_oth_lang_yn.equals("Y")){
				if(name_prefix_accept_yn.equals("Y")){%>
					<td class='CAGROUP' nowrap><%=name_prefix_oth_lang_prompt%></td>
				<%}
				if(first_name_accept_yn.equals("Y")){%>
					<td class='CAGROUP' nowrap><%=first_name_oth_lang_prompt%></td>
				<%}
				if(second_name_oth_lang.equals("Y")){%>
					<td class='CAGROUP' nowrap><%=second_name_oth_lang_prompt%></td>
				<%}
				if(third_name_oth_lang.equals("Y")){%>
					<td class='CAGROUP' nowrap><%=third_name_oth_lang_prompt%></td>
				<%}
				if(family_name_oth_lang.equals("Y")){%>
					<td class='CAGROUP' nowrap><%=family_name_oth_lang_prompt%></td>
				<%}
				if(name_suffix_oth_lang.equals("Y")){%>
					<td class='CAGROUP' nowrap><%=name_suffix_oth_lang_prompt%></td>
				<%}
			}
			%>			
			<td class='CAGROUP' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>			
			<td class='CAGROUP' nowrap><fmt:message key="Common.contactNo.label" bundle="${common_labels}"/></td>			
			</tr>		
			<%
			t = 1;				
			while ( rset.next() )
			{
				if ( t % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				 patient_name=rset.getString("patient_name") == null ?"" : rset.getString("patient_name");
				 name_prefix=rset.getString("name_prefix") == null ?"" : rset.getString("name_prefix");
				 first_name=rset.getString("first_name") == null ?"" : rset.getString("first_name");
				 second_name=rset.getString("second_name") == null ?"" : rset.getString("second_name");
				 third_name=rset.getString("third_name") == null ?"" : rset.getString("third_name");
				 family_name=rset.getString("family_name") == null ?"" : rset.getString("family_name");		
				 name_suffix=rset.getString("name_suffix") == null ?"" : rset.getString("name_suffix");
				 name_prefix_oth_lang=rset.getString("name_prefix_loc_lang") == null ?"" : rset.getString("name_prefix_loc_lang");
				 first_name_oth_lang=rset.getString("first_name_loc_lang") == null ?"" : rset.getString("first_name_loc_lang");
				 second_name_oth_lang=rset.getString("second_name_loc_lang") == null ?"" : rset.getString("second_name_loc_lang");
				 third_name_oth_lang=rset.getString("third_name_loc_lang") == null ?"" : rset.getString("third_name_loc_lang");
				 family_name_oth_lang=rset.getString("family_name_loc_lang") == null ?"" : rset.getString("family_name_loc_lang");		
				 name_suffix_oth_lang=rset.getString("name_suffix_loc_lang") == null ?"" : rset.getString("name_suffix_loc_lang");
				 gender=rset.getString("gender") == null ?"" : rset.getString("gender");		
				 contact_no=rset.getString("oth_contact_no") == null ?"" : rset.getString("oth_contact_no");		
				 drvdname=rset.getString("drvdname") == null ?"" : rset.getString("drvdname");
				 if(!drvdname.equals(prev_drvdname)){
					no_of_records++;
		%>
			<tr id='Summary_row<%=no_of_records%>'>
				<td nowrap><a href='javascript:ShowSummary("<%=gender%>","<%=contact_no%>","<%=java.net.URLEncoder.encode(patient_name)%>","<%=no_of_records%>")' id="plus">+</a></td>
			<%if(name_prefix_accept_yn.equals("Y")){%>
				<td nowrap id='name_prefix<%=no_of_records%>'>&nbsp;<%=name_prefix%></td>					
			<%}%>
			<%if(first_name_accept_yn.equals("Y")){%>
				<td nowrap id='first_name<%=no_of_records%>' >&nbsp;<%=first_name%></td>				
			<%}%>
			<%if(second_name_accept_yn.equals("Y")){%>
				<td nowrap id='second_name<%=no_of_records%>'>&nbsp;<%=second_name%></td>				
			<%}%>			
			<%if(third_name_accept_yn.equals("Y")){%>			
				<td nowrap id='third_name<%=no_of_records%>'>&nbsp;<%=third_name%></td>				
			<%}%>
			<%if(family_name_accept_yn.equals("Y")){%>
				<td nowrap id='family_name<%=no_of_records%>'>&nbsp;<%=family_name%></td>				
			<%}%>
			<%if(pat_name_as_multipart_yn.equals("N")){%>
				<td nowrap id='family_name<%=no_of_records%>'>&nbsp;<%=family_name%></td>
			<%}%>
			<%if(name_suffix_accept_yn.equals("Y")){%>
				<td nowrap id='name_suffix<%=no_of_records%>'>&nbsp;<%=name_suffix%></td>
			<%}%>
			<%if(names_in_oth_lang_yn.equals("Y")){
				if(name_prefix_accept_yn.equals("Y")){%>
					<td nowrap id='name_prefix_oth_lang<%=no_of_records%>'>&nbsp;<%=name_prefix_oth_lang%></td>
				<%}
				if(first_name_accept_yn.equals("Y")){%>
					<td nowrap id='first_name_oth_lang<%=no_of_records%>'>&nbsp;<%=first_name_oth_lang%></td>
				<%}
				if(second_name_oth_lang.equals("Y")){%>
					<td nowrap id='second_name_oth_lang<%=no_of_records%>'>&nbsp;<%=second_name_oth_lang%></td>
				<%}
				if(third_name_oth_lang.equals("Y")){%>
					<td nowrap id='third_name_oth_lang<%=no_of_records%>'>&nbsp;<%=third_name_oth_lang%></td>
				<%}
				if(family_name_oth_lang.equals("Y")){%>
					<td nowrap id='third_name_oth_lang<%=no_of_records%>'>&nbsp;<%=family_name_oth_lang%></td>
				<%}
				if(name_suffix_oth_lang.equals("Y")){%>
					<td nowrap id='name_suffix_oth_lang<%=no_of_records%>'>&nbsp;<%=name_suffix_oth_lang%></td>
				<%}
			}%>			
				<td nowrap>&nbsp;<%=gender%></td>
				<td nowrap>&nbsp;<%=contact_no%></td>				
			</tr>
<%}
		t++;
		prev_drvdname=drvdname;
		}
		if(no_of_records == 0){
			out.println("<script>alert(getMessage('APPT_NOT_EXISTS_FOR_SEL_PAT','OA'));window.close();</script>");
		}
		%>
	</table>		
	<script>			
		if('<%=no_of_records%>' == 1){			
				document.getElementById("plus").style.visibility='hidden';
				parent.frames[1].location.href="../../eOA/jsp/OAPatApptSummary.jsp?name_prefix=<%=java.net.URLEncoder.encode(name_prefix)%>&first_name=<%=java.net.URLEncoder.encode(first_name)%>&second_name=<%=java.net.URLEncoder.encode(second_name)%>&third_name=<%=java.net.URLEncoder.encode(third_name)%>&family_name=<%=java.net.URLEncoder.encode(family_name)%>&name_suffix=<%=java.net.URLEncoder.encode(name_suffix)%>&name_prefix_oth_lang=<%=java.net.URLEncoder.encode(name_prefix_oth_lang)%>&first_name_oth_lang=<%=java.net.URLEncoder.encode(first_name_oth_lang)%>&second_name_oth_lang=<%=java.net.URLEncoder.encode(second_name_oth_lang)%>&third_name_oth_lang=<%=java.net.URLEncoder.encode(third_name_oth_lang)%>&family_name_oth_lang=<%=java.net.URLEncoder.encode(family_name_oth_lang)%>&name_suffix_oth_lang=<%=java.net.URLEncoder.encode(name_suffix_oth_lang)%>&patient_name=<%=java.net.URLEncoder.encode(patient_name)%>&gender=<%=gender%>&contact_no=<%=contact_no%>&per_chk_cancld_past_appts=<%=per_chk_cancld_past_appts%>&per_chk_cancld_fut_appts=<%=per_chk_cancld_fut_appts%>&per_chk_past_resch_appts=<%=per_chk_past_resch_appts%>&per_chk_fut_resch_appts=<%=per_chk_fut_resch_appts%>&no_of_cancld_appts_for_alert=<%=no_of_cancld_appts_for_alert%>&no_of_resch_appts_for_alert=<%=no_of_resch_appts_for_alert%>&Per_chk_for_no_show_alert=<%=per_chk_for_no_show_alert%>&no_of_noshow_appts_for_alert=<%=no_of_noshow_appts_for_alert%>&per_chk_for_fut_appts_alert=<%=per_chk_for_fut_appts_alert%>&no_of_fut_appts_for_alert=<%=no_of_fut_appts_for_alert%>";

			}
	</script>
		<%}catch(Exception e){
			//out.println(e.toString());
			e.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(con,request);
		}
%>
		<input type="hidden" name='name_prefix' id='name_prefix' value="<%=name_prefix%>">
		<input type="hidden" name='no_of_fut_appts_for_alert' id='no_of_fut_appts_for_alert' value="<%=no_of_fut_appts_for_alert%>">
		<input type="hidden" name='per_chk_for_fut_appts_alert' id='per_chk_for_fut_appts_alert' value="<%=per_chk_for_fut_appts_alert%>">
		<input type="hidden" name='no_of_resch_appts_for_alert' id='no_of_resch_appts_for_alert' value="<%=no_of_resch_appts_for_alert%>">
		<input type="hidden" name='per_chk_past_resch_appts' id='per_chk_past_resch_appts' value="<%=per_chk_past_resch_appts%>">
		<input type="hidden" name='per_chk_fut_resch_appts' id='per_chk_fut_resch_appts' value="<%=per_chk_fut_resch_appts%>">
		<input type="hidden" name='no_of_cancld_appts_for_alert' id='no_of_cancld_appts_for_alert' value="<%=no_of_cancld_appts_for_alert%>">
		<input type="hidden" name='per_chk_cancld_past_appts' id='per_chk_cancld_past_appts' value="<%=per_chk_cancld_past_appts%>">
		<input type="hidden" name='per_chk_cancld_fut_appts' id='per_chk_cancld_fut_appts' value="<%=per_chk_cancld_fut_appts%>">
		<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value="<%=no_of_noshow_appts_for_alert%>">		
		<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value="<%=per_chk_for_no_show_alert%>">
		<input type="hidden" name='max_no_of_records' id='max_no_of_records' value="<%=no_of_records%>">

</form>
</body>
</html>

