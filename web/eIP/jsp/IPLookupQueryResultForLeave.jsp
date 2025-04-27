<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="ForSplChars.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
	String call_function =request.getParameter("param");
	if( call_function == null) call_function="";
	String oper_stn_id = request.getParameter("oper_stn_id");
	String login_user = (String)session.getValue("login_user");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var locn;
	async function callRemarksPage(encounter_id)
	{
		var retVal;
		var dialogHeight ='9' ;
		var dialogWidth = '30' ;
		var	remarksvalue = "";
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		var arguments;
		var comments;
		   if(comments=='' || comments == "null")
			  comments ='';
		arguments = comments;
		var remarks = escape(encounter_id);
		retVal = await window.showModalDialog('../../eIP/jsp/IPLookupQueryRemarks.jsp?p_remarks='+remarks,arguments,features);
	}

	async function showModal(enc,srl_no,call_fn_id)
	{	
		var tot_count=document.forms[0].total_count.value;
		var win_height="1000px";
		var dialogTop="72";
		var win_width="1400px";
		var dialogHeight="1000px";
		var dialogWidth="1400px";
		
		if( document.forms[0].modal.value != 'yes')
		{
			var jsp_name=document.forms[0].jsp_name.value;
			var win_height=document.forms[0].win_height.value;
			if(win_height == "") win_height="1000px";

			var dialogTop=document.forms[0].dialogTop.value;
			if(dialogTop == "") dialogTop="130";				

			var win_width=document.forms[0].win_width.value;
			if(win_width == "") win_width="1400px";

			var module=document.forms[0].module.value;
			if(module == "") module="eIP";

			var model_window=document.forms[0].model_window.value;
			if( model_window == "") model_window ="";

			var p_oper_stn_id=document.forms[0].p_oper_stn_id.value;
			if( p_oper_stn_id == "") p_oper_stn_id ="";

			if( model_window == 'N')
			{
				parent.frames[3].document.location.href="../../"+module+"/jsp/"+jsp_name+"?encounter_id="+enc+"&srl_no="+srl_no+"&call_function="+call_fn_id+"&p_oper_stn_id="+p_oper_stn_id;
			}			
			else
			{					
				var retVal = 	new String();
				var center = "1" ;
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;				
				retVal = await window.showModalDialog("../../"+module+"/jsp/"+jsp_name+"?encounter_id="+enc+"&srl_no="+srl_no+"&call_function="+call_fn_id+"&p_oper_stn_id="+p_oper_stn_id,arguments,features);
				if(tot_count >= 1)
				{
					parent.frames[2].document.location.reload();
				}
				else
				{
					parent.frames[2].document.location.href="../../eCommon/html/blank.html";
				}
			}
		  }
		  else
		  {
			window.parent.returnValue=enc;
			window.parent.close();
		  }
	}
	async function showEncounterDetails(enc,patid)
	{
		var retVal = 	new String();
		//var dialogHeight= "41";
		//var dialogWidth = "65";
		var dialogHeight= "800px";
	var dialogWidth	= "1400px";
		var dialogTop	= "65";
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../eIP/jsp/CurrentEncounterMain.jsp?encounterId="+enc+"&patientId="+patid,arguments,features);
	}
	</script>
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;

	try
	{
	con = ConnectionManager.getConnection(request);

	String facility_id			= (String)session.getValue("facility_id");
	StringBuffer where_criteria = new StringBuffer();
	String soundex_function		= "";
	String sql					= "";
	String leave_status			= "";
	String class_val			= "QRYEVENSMALL";
	String color_code_scheme	= "";
	String whereClause			= request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String soundex_type			= request.getParameter("soundex");
	String nursing_unit_code	= "";
	nursing_unit_code=request.getParameter("nursing_unit");
	if( nursing_unit_code == null) nursing_unit_code = "";
	String speciality_code		= request.getParameter("Splcode");
	String encounter_id			= request.getParameter("encounter_id");
	String practitioner_id		= request.getParameter("practid");
	String from_date			= request.getParameter("from_date");
	if(from_date == null || !from_date.equals(""))
		from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
	String to_date				= request.getParameter("to_date");
	if(to_date == null || !to_date.equals(""))
		to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
	String patient_id			= request.getParameter("patient_id");
	String gender				= request.getParameter("gender");
	String name_prefix			= checkForNull(request.getParameter("name_prefix"));
	String name_suffix			= checkForNull(request.getParameter("name_suffix"));
	
	
	if(name_prefix!=null || !name_prefix.equals(""))
		name_prefix				= singleToDoubleQuotes(name_prefix);
	if(name_suffix!=null || !name_suffix.equals(""))
		name_suffix				= singleToDoubleQuotes(name_suffix);
	
	String first_name			= request.getParameter("first_name");
	String second_name			= request.getParameter("second_name");
	String third_name			= request.getParameter("third_name");
	String family_name			= request.getParameter("family_name");
	String searchby				= request.getParameter("searchby");
	String pat_name_as_multipart_yn = request.getParameter("pat_name_as_multipart_yn");
	if (pat_name_as_multipart_yn==null) pat_name_as_multipart_yn = "";
	if (searchby==null) searchby = "";
	if (searchby.equals("")) searchby="S";
	String srl_no			="" ;
	String patient_name		="";
	String leave_fr_date	= "";
	String leave_to_date	= "";
	String leave_fr_date_display	= "";
	String leave_to_date_display	= "";
	String leave_remarks	= "";
	String sex				= "";

	String jsp_name =request.getParameter("jsp_name");
	if( jsp_name == null) jsp_name="";
	String window_styl=request.getParameter("window_styl");
	if( window_styl == null) window_styl="";
	String close_yn	=request.getParameter("close_yn");
	if( close_yn == null) close_yn="";
	String win_top =request.getParameter("win_top");
	if( win_top == null) win_top="";
	String win_height =request.getParameter("win_height");
	if(win_height ==null) win_height="";

	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";			

	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";

	String modal=request.getParameter("modal");
	if(modal == null) modal="";

	String module=request.getParameter("module");
	if(module == null) module="";

	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";

	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";

	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";

	String p_practitioner_id=request.getParameter("practitioner_id");
	if( p_practitioner_id == null) p_practitioner_id="";

	String call_func=request.getParameter("call_function");
	if(call_func == null) call_func="";
%>
</head>							
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='iplookupqueryresult' id='iplookupqueryresult'>
	<%
	if(whereClause==null)
	{
		if(soundex_type!=null)
		{
			if(soundex_type.equals("E"))
				soundex_function = "ethnic_soundex";
			else if(soundex_type.equals("G"))
				soundex_function = "soundex";
			else 
				soundex_function = "";
		}

		if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
		where_criteria.append(" where facility_id='"+facility_id+"' and leave_status in ('1','4') ");

		if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
			where_criteria.append(" and ASSIGN_CARE_LOCN_CODE='"+nursing_unit_code+"' ");
		else
			where_criteria.append(" and ASSIGN_CARE_LOCN_CODE in (Select a.nursing_unit_code from ip_nursing_unit a, am_os_user_locn_access_vw b where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.eff_status = 'E' and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' )"); 

		if(speciality_code!=null && !speciality_code.equals(""))
		where_criteria.append(" and specialty_code='"+speciality_code+"' ");

		if(practitioner_id!=null && !practitioner_id.equals(""))
		where_criteria.append(" and attend_practitioner_id='"+practitioner_id+"' ");

		if(from_date!=null && !from_date.equals(""))
		where_criteria.append(" and trunc(admission_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");

		if(to_date!=null && !to_date.equals(""))
		where_criteria.append(" and trunc(admission_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");

		if(patient_id!=null && !patient_id.equals(""))
		where_criteria.append(" and patient_id like '"+patient_id+"%' ");

		if(encounter_id != null && !encounter_id.equals(""))
		where_criteria.append(" and encounter_id='"+encounter_id+"' ");

		if(gender!=null && !gender.equals(""))
		where_criteria.append(" and sex='"+gender+"' ");

		if(name_prefix!=null && !name_prefix.equals(""))
		where_criteria.append(" and name_prefix='"+name_prefix+"' ");

		if(name_suffix!=null && !name_suffix.equals(""))
		where_criteria.append(" and name_suffix='"+name_suffix+"' ");

		if (!soundex_function.equals(""))
		{
		if(first_name!=null && !first_name.equals(""))
		where_criteria.append(" and "+soundex_function+"(first_name) like "+soundex_function+"('"+first_name+"') || '%' ");

		if(second_name!=null && !second_name.equals(""))
			where_criteria.append(" and "+soundex_function+"(second_name) like "+soundex_function+"('"+second_name+"') || '%' ");

		if(third_name!=null && !third_name.equals(""))
			where_criteria.append(" and "+soundex_function+"(third_name) like "+soundex_function+"('"+third_name+"') || '%' ");
		}
		else
		{
			if(first_name!=null && !first_name.equals(""))
			where_criteria.append(" and upper(first_name) like upper('"+first_name+"') || '%' ");

			if(second_name!=null && !second_name.equals(""))
			where_criteria.append(" and upper(second_name) like upper('"+second_name+"') || '%' ");

			if(third_name!=null && !third_name.equals(""))
			where_criteria.append(" and upper(third_name) like upper('"+third_name+"') || '%' ");
		}

		if(family_name!=null && !family_name.equals(""))
		{
			if (pat_name_as_multipart_yn.equals("Y"))
			{							
				where_criteria.append(" and "+soundex_function+"(family_name) like "+soundex_function+"('"+family_name+"') || '%' ");
			}
			else
			{
				if (soundex_function.equals(""))
				{
					if (searchby.equals("C"))
					{
						where_criteria.append(" and upper(family_name) like '%' || upper('"+family_name+"') || '%' ");
					}
					else if (searchby.equals("E"))
					{
						where_criteria.append(" and upper(family_name) like '%' || upper('"+family_name+"') ");
					}
					else
					{
						where_criteria.append(" and upper(family_name) like upper('"+family_name+"') || '%' ");
					}
				}
				else
				{
					String fam_name_search = "";
					if (pat_name_as_multipart_yn.equals("N"))
					{
						StringTokenizer stktok = new StringTokenizer(family_name, " ");
						if (stktok.hasMoreTokens())
							fam_name_search = stktok.nextToken();
						else
							fam_name_search = family_name;
					}
					else
						fam_name_search = family_name;

					where_criteria.append(" and "+soundex_function+"(family_name) like "+soundex_function+"('"+fam_name_search+"') || '%' ");
				}
			}
		}

		if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
		{
			where_criteria.append(" and (practitioner_id ='"+ p_practitioner_id +"'  ");
			where_criteria.append(" or encounter_id in ");
			where_criteria.append("(select encounter_id  ");
			where_criteria.append("  from pr_encounter_pract ");
			where_criteria.append(" where operating_facility_Id= '"+ facility_id +"'  ");
			where_criteria.append(" and practitioner_id= '"+ p_practitioner_id +"' )) ");
		}
		} 
		else
		{
			if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
			where_criteria.append(whereClause) ;
		}
		int start = 0 ;
		int end = 0 ;
		int i=1;
		int cnt=0;
		int endOfRes=1;
		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 12 ;
		else
			end = Integer.parseInt( to ) ;

		sql  = " select encounter_id,patient_id,decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, sex, to_char(leave_fr_date,'dd/mm/rrrr hh24:mi') leave_fr_date,leave_fr_date leave_fr_date1, to_char(leave_to_date,'dd/mm/rrrr hh24:mi') leave_to_date,srl_no,leave_remarks,LEAVE_STATUS from ip_leave_detail_vw "+where_criteria.toString() + " order by leave_fr_date1";
		//out.println(sql);
		
		stmt = con.createStatement();
		rs= stmt. executeQuery(sql);
	

		if ( start != 1 )		
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
		
		while ( i<=end && rs.next() ) 
		{
			if(cnt == 0)
			{
				out.println("<p><table align='right'><tr><td>");

				if ( !(start <= 1) )
					out.println("<A HREF='../jsp/IPLookupQueryResultForLeave.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

				if ( endOfRes == 1 )
					out.println("<A id='nextval' HREF='../jsp/IPLookupQueryResultForLeave.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				out.println("</td></tr></table></p>");
				out.println("<br><br>");				

				out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
				out.println("<tr>");
				out.println("<th width='5%'>"+"&nbsp;"+"</th>");
				out.println("<th width='20%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='30%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='6%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th>");
				out.println("<th width='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='18%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LeaveFrom.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='17%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LeaveTo.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='5%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th>");
				out.println("</tr>"); 
			}

			encounter_id	= rs.getString("encounter_id") == null ? "&nbsp;" : rs.getString("encounter_id");
			patient_name	= rs.getString("patient_name") == null ? "&nbsp;" : rs.getString("patient_name");
			sex				= rs.getString("sex") == null ? "" : rs.getString("sex");

			if (sex.equals("M"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if (sex.equals("F"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else 
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
	
			leave_fr_date=rs.getString("leave_fr_date") == null ? "" : rs.getString("leave_fr_date");
			leave_to_date=rs.getString("leave_to_date") == null ? "" : rs.getString("leave_to_date");
			if(leave_fr_date.equals(""))
				leave_fr_date_display = "&nbsp;";
			else
				leave_fr_date_display = DateUtils.convertDate(leave_fr_date,"DMYHM","en",locale);

			if(leave_to_date.equals(""))
				leave_to_date_display = "&nbsp;";
			else
				leave_to_date_display = DateUtils.convertDate(leave_to_date,"DMYHM","en",locale);

			leave_remarks	= rs.getString("leave_remarks") == null ? "" : rs.getString("leave_remarks");
			leave_status	= rs.getString("leave_status") == null? "":rs.getString("leave_status");
			srl_no			= rs.getString("srl_no") == null ? "" : rs.getString("srl_no");

			if(leave_status.equals("4"))
				color_code_scheme = "#9DCECE";
			else
				color_code_scheme = "";

			if(class_val.equals("QRYEVENSMALL"))
				class_val = "QRYODDSMALL";
			else
				class_val = "QRYEVENSMALL";

			out.println("<tr>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'><a href=\"javascript:showEncounterDetails('"+encounter_id+"','"+patient_id+"')\">+</a></td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'><a href=\"javascript:showModal('"+encounter_id+"','"+srl_no+"','"+call_function+"')\">"+rs.getString("patient_id")+"</a></td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+patient_name+"</td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+sex+"</td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+encounter_id+"</td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+leave_fr_date_display+"</td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+leave_to_date_display+"</td>");

			if (!leave_remarks.equals(""))
			{
				out.print("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>");
				out.print("<input type='hidden' name='l_remark' id='l_remark' value='"+leave_remarks+"' >");
				%>
				<a href='javascript:callRemarksPage("<%=encounter_id%>")'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
				<% 
			}
			else
			{
				out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>&nbsp;</td>");
			}
			out.println("</tr>");
			%>
			<input type='hidden' name='leave_remark' id='leave_remark' value='<%=leave_remarks%>' >
			<%
			i++;
			cnt++;
		}

		if( !rs.next() && cnt!=0 )
		{
			endOfRes=0;
		%>
		<script>					
			document.getElementById('nextval').innerHTML = " ";
		</script>
		<%
		}	

		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();

	%>
	<script>
	if (parseInt('<%=cnt%>') == 0)
	{
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		parent.frames[1].document.forms[0].search.disabled=false	
		parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	}
	</script>
<%				
		out.println("</table>");				
%>
	<input type='hidden' name='total_count' id='total_count' value="<%=(i-1)%>" >
	<input type='hidden' name='jsp_name' id='jsp_name' value='<%=jsp_name%>' >
	<input type='hidden' name='win_height' id='win_height' value='<%=win_height%>' >
	<input type='hidden' name='win_width' id='win_width' value='<%=win_width%>' >
	<input type='hidden' name='dialogTop' id='dialogTop' value='<%=dialogTop%>' >
	<input type='hidden' name='modal' id='modal' value='<%=modal%>' >
	<input type='hidden' name='module' id='module' value='<%=module%>' >
	<input type='hidden' name='model_window' id='model_window' value='<%=model_window%>' >
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>' >
	<input type='hidden' name='call_function' id='call_function' value='<%=call_func%>' >
	<input type='hidden' name='prog_id' id='prog_id' value='<%=prog_id%>' >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=p_practitioner_id%>' >
	<input type='hidden' name='p_oper_stn_id' id='p_oper_stn_id' value='<%=oper_stn_id%>' >
	</form>
	</body>
<% }
	catch(Exception e)
	{
		out.println(e);
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null)	stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);

		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
	}
	%>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

