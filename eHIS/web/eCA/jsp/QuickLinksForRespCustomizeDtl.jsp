<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	webbeans.eCommon.RecordSet CustomizeResp = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeResp"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet CustomizeRespDef = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeRespDef"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session);
	//out.println("CustomizeResp "+CustomizeResp.getRecordSetHandle());
%>


<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
	String userId=((String) session.getValue("login_user")).trim();
	String resp_id				= (String)session.getValue("responsibility_id");
	//String reln_id				= (String)session.getValue("relationship_id");
	String reln_id				= request.getParameter("relationship_id");
	String facilityId			= (String)session.getValue("facility_id");
	if(resp_id == null) resp_id = "";
	if(reln_id == null) reln_id = "";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script src='../js/CAMenu.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



    
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()" style='background-color:#E2E3F0;'>
<form name='QuickLinksForRespCustomizeDtl' id='QuickLinksForRespCustomizeDtl' action="QuickLinksForRespCustomizeDtl.jsp?<%=request.getQueryString()%>"  method='post'>
<%
	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String checkedOnes	= "";
	String req_start   =   "", req_end     =   "";
	//String function_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
	String link_type = "";
	String checkdef_dis = "";
	String df_checkStatus = "";

	String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	link_type = request.getParameter("link_type")==null?"":request.getParameter("link_type");
	String patientclass = request.getParameter("patientclass") == null ? "" : request.getParameter("patientclass");

	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	
	String prev_notes_called_from = request.getParameter("prev_notes_called_from") == null ? "" : request.getParameter("prev_notes_called_from");

	if(!prev_notes_called_from.equals("") && prev_notes_called_from.equals("PREVIOUS_NOTES"))
		function_id = prev_notes_called_from;

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;
		
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 13 ; }   else {  end = Integer.parseInt( to ) ; }


	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");

	if(from != null && to != null) {
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		{
			if(request.getParameter("chk"+(i-1)) != null)
			{
				checkedOnes = request.getParameter("chk"+(i-1));
				if(!(CustomizeResp.containsObject(checkedOnes)))
				{
					CustomizeResp.putObject(checkedOnes);
				}
				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
		
		if(link_type.equals("F"))
		{
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			{
				if(request.getParameter("default_chk"+(i-1)) != null)
				{
					checkedOnes = request.getParameter("default_chk"+(i-1));
					if(CustomizeRespDef.getSize() > 0)
					{
						CustomizeRespDef.removeObject(0);
						CustomizeRespDef.putObject(checkedOnes);
					}
					else
						CustomizeRespDef.putObject(checkedOnes);
				}
			}
		}



	}
	putObjectInBean("CustomizeResp"+patient_id+encounterId, CustomizeResp,session);
	putObjectInBean("CustomizeRespDef"+patient_id+encounterId, CustomizeRespDef,session);
	i = 1;
	try
	{
		con = ConnectionManager.getConnection(request);
		String ql_ref	= "";
		String description	= "";
		int ilCkeckedYN = 0;
		int initial_count = -1;
		int recordCount = 0;
		String checkStatus  = "";	
		String checkProp = "";
		StringBuffer sql = new StringBuffer();

		String checked_yn="";
		String default_yn="";
		String allow_yn="";
		String checkdef="";
		String pat_appl_yn = "";
		String hist_or_record = "";
		String option_id = "";
		String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
		String desktop_yn = "";
		
		/*sql.append("select QUICK_LINK_REF, QUICK_LINK_DESCRIPTION from SM_QUICK_LINK_LIST a where a.EFF_STATUS = 'E' ");
		if(!function_id.equals(""))
			sql.append(" and a.OPTION_ID = ? ");
		else
			sql.append(" and a.GLOBAL_YN = 'Y' "); */

		sql.append("SELECT DISTINCT A.QUICK_LINK_REF , A.QUICK_LINK_DESCRIPTION , nvl2(c.QUICK_LINK_REF,'Y','N') checked_yn,NVL(C.DEFAULT_YN,'N') DEFAULT_YN "); 
		if(!patient_id.equals(""))
		{
			if(patientclass.equals(""))
				patientclass = "XT";

			sql.append(", APPL_"+patientclass+"_YN Pat_APPL_YN , D.DESKTOP_YN, HIST_OR_RECORD HIST_OR_RECORD");
		}
		else
		{
			sql.append(", 'N' Pat_APPL_YN , D.DESKTOP_YN, '' HIST_OR_RECORD ");
		}
		sql.append(" , NVL((SELECT 'Y' FROM CA_APPL_TASK ia WHERE ia.option_id = a.option_id and 'A' = Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) and  (ia.BASE_MODULE_ID = 'CA' or  exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");

		if(!patient_id.equals(""))
		{
			sql.append(" and ( MODULE_GROUP_ID! = 'SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID = ia.BASE_MODULE_ID AND  SPECIALITY_CODE = ? )) ");
		}
		sql.append(" )) and rownum=1),'N') Allow_yn, a.option_id, a.QUICK_LINK_TYPE FROM SM_QUICK_LINK_LIST_LANG_VW A,SM_QUICK_LINK_RESP B,SM_QUICK_LINK_FOR_USER c, CA_OPTION D WHERE  A.eff_STATUS='E' and a.LANGUAGE_ID = '"+locale+"' and B.RESP_ID=? AND A.QUICK_LINK_REF = B.QUICK_LINK_REF and c.APPL_USER_ID(+)=? AND c.LINK_TYPE(+) =?  AND c.QUICK_LINK_REF(+) = A.QUICK_LINK_REF AND D.OPTION_ID(+) = A.OPTION_ID "); // AND c.QUICK_LINK_REF(+) =A.QUICK_LINK_REF
		
		if(patient_id.equals(""))
		{
			sql.append(" and D.DESKTOP_YN = 'Y' ");
		}
		else
		{
			 sql.append(" and D.DESKTOP_YN = 'N' ");
		}

		if(link_type.equals("Q"))
			sql.append(" AND A.GLOBAL_YN='Y' and b.LINK_TYPE = 'Q'");
		else if(link_type.equals("F"))
			sql.append(" AND A.FUNCTION_SPEC_YN ='Y' AND A.OPTION_ID = ? and b.LINK_TYPE = 'F'");	
		
		if(!link_type.equals("F"))
		{		
			sql.append("UNION ALL SELECT DISTINCT a.quick_link_ref ,(SELECT quick_link_description FROM sm_quick_link_list_lang_vw WHERE LANGUAGE_ID = ? AND QUICK_LINK_REF = a.quick_link_ref) quick_link_description,nvl2(d.QUICK_LINK_REF,'Y','N') checked_yn,NVL(d.DEFAULT_YN,'N') DEFAULT_YN,");
			
			if(patient_id.equals(""))
			{
				sql.append(" 'N' Pat_APPL_YN ,'Y' DESKTOP_YN ");
			}
			else
			{
				 sql.append(" 'Y' Pat_APPL_YN ,'N' DESKTOP_YN ");
			}
			sql.append(",'' HIST_OR_RECORD,'Y' Allow_yn,'' OPTION_ID, a.QUICK_LINK_TYPE FROM sm_quick_link_list_lang_vw A, SM_QUICK_LINK_RESP C,SM_QUICK_LINK_FOR_USER d WHERE A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.RESP_ID =? AND A.QUICK_LINK_REF = C.QUICK_LINK_REF  AND  d.quick_link_ref(+) = c.quick_link_ref AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX'");
		}
 		sql.append("  order by 2");
		
		
		pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		
		int indval =1;

		pstmt.setString(indval++,resp_id);
		pstmt.setString(indval++,reln_id);
		pstmt.setString(indval++,facilityId);
		pstmt.setString(indval++,episode_id);
		pstmt.setString(indval++,patient_id);
		if(!patient_id.equals(""))
			pstmt.setString(indval++,speciality_code);
		
		pstmt.setString(indval++,resp_id);
		pstmt.setString(indval++,userId);
		pstmt.setString(indval++,link_type);
		if(link_type.equals("F"))
		{
			pstmt.setString(indval++,function_id);
		}
		if(!link_type.equals("F"))
		{
			pstmt.setString(indval++,locale);
			pstmt.setString(indval++,resp_id);
		}	
		
		rs = pstmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		if(maxRecord == 0)
		{
			/* out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);window.close();</script>"); */
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
		}
		else
		{
			rs.beforeFirst();
%>	

	 <table border='0' width='100%'>
		<tr>
			<td width='65%'></td> 
			<td align='right' width='35%'>
	<%
		if ( !(start <= 1)) {
	%>
		
		<a  class='gridLink' href='javascript:submitPrevNext(<%=(start-13)%>,<%=(end-13)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}	
	
		if ( !((start+13) > maxRecord )){		
	%>
	
		<a class='gridLink' href='javascript:submitPrevNext(<%=(start+13)%>,<%=(end+13)%>)' text-decoration='none'>&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
	%>
			</td>
		</tr>
	 </table>
	  <table border='1' cellpadding='3' cellspacing='0' width='100%' align='center' id=tableId>
		<td class='columnHeadercenter'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='columnHeadercenter'><fmt:message key="eCA.CurrentPrivilege.label" bundle="${ca_labels}"/></td>
		<td class='columnHeadercenter'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<%
			if(link_type.equals("F")){
		 %>
		
		<td class='columnHeadercenter'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>

		<% }
		%>

		<%
			if (start != 0){
            for(int j=1; j<start; i++,j++){
                rs.next() ;
             }
			 ilCkeckedYN+=start;
             --ilCkeckedYN ;
			}
			recordCount			=	CustomizeResp.getSize();

			while(rs.next()&& i<=end)
			{
				
				ql_ref = rs.getString("QUICK_LINK_REF")==null?"":rs.getString("QUICK_LINK_REF");
				description = rs.getString("QUICK_LINK_DESCRIPTION")==null?"":rs.getString("QUICK_LINK_DESCRIPTION");
				checked_yn = rs.getString("checked_yn")==null?"":rs.getString("checked_yn");
				default_yn = rs.getString("DEFAULT_YN")==null?"":rs.getString("DEFAULT_YN");
				allow_yn = rs.getString("Allow_yn")==null?"":rs.getString("Allow_yn");
				pat_appl_yn = rs.getString("Pat_APPL_YN")==null?"":rs.getString("Pat_APPL_YN");
				hist_or_record = rs.getString("HIST_OR_RECORD")==null?"":rs.getString("HIST_OR_RECORD");
				option_id = rs.getString("option_id")==null?"":rs.getString("option_id");
				desktop_yn = rs.getString("DESKTOP_YN")==null?"":rs.getString("DESKTOP_YN");
			
				try
				{
					if(CustomizeResp.containsObject(ql_ref))
						checkStatus = "Y";
					else
						checkStatus = "N";


					int recordIndex = CustomizeResp.indexOfObject(ql_ref);
					if(recordIndex!=-1)
					{
						if(checkStatus.equals("Y"))
						{
							CustomizeResp.removeObject(recordIndex);
						}
					}
										
					if(CustomizeRespDef.containsObject(ql_ref))
						df_checkStatus = "Y";
					else
						df_checkStatus = "N";
					
					int recordIndex1 = CustomizeRespDef.indexOfObject(ql_ref);
					if(recordIndex1 != -1)
					{
						if(df_checkStatus.equals("Y"))
						{
							CustomizeRespDef.removeObject(recordIndex1);
						}
					}


				}
				catch(Exception e)
				{
					//out.println("Exception in QuickLinksForRespCustomizeDtl.jsp: "+e.toString());//COMMON-ICN-0181
                                          e.printStackTrace();//COMMON-ICN-0181
				}
								
				//if(checkStatus.trim().equals("Y")||checked_yn.equals("Y"))
				if(checkStatus.trim().equals("Y"))
				{
					checkProp = " CHECKED ";
					checkdef_dis="";
				}
				else
				{
					checkProp = "";
					checkdef_dis ="disabled";
				}

				//if(df_checkStatus.equals("Y")||default_yn.equals("Y"))
				if(df_checkStatus.equals("Y"))
				{
					checkdef ="CHECKED";
					initial_count = ilCkeckedYN;
					
				}
				else
				{
					checkdef ="";
					
				}
		%>
				<tr>
				<td class='CAGROUP'><%=description%></td>
		<% 
				if(!function_id.equals("PREVIOUS_NOTES"))
				{
					
					if(!patient_id.equals(""))
					{
						if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
						{
							if(!option_id.equals("CLINICAL_NOTES") && !option_id.equals("CLINICAL_NOTES_NEW") && !option_id.equals("PATCHIEFCOMPLAINT") && !option_id.equals("REL_PAT_TREAT_PAT") && !option_id.equals("CA_TASK_LIST") && !option_id.equals("CA_TASK_LIST_DT"))
							{
								if(mode.equals("V"))
								{
									if( pat_appl_yn.equals("Y") && !hist_or_record.equals("R") && allow_yn.equals("Y"))
										out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
									else
										out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
								}
								else
								{
									if(pat_appl_yn.equals("Y") && allow_yn.equals("Y"))
										out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
									else
										out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
								}
							}
							else
								out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
						}
						else
						{
							if(mode.equals("V"))
							{
								if( pat_appl_yn.equals("Y") && !hist_or_record.equals("R") && allow_yn.equals("Y"))
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
								else
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
							}
							else
							{
								if(pat_appl_yn.equals("Y") && allow_yn.equals("Y"))
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
								else
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
							}
						}
					}
					else
					{
						if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
						{
							if(!option_id.equals("CA_TASK_LIST") && !option_id.equals("REL_PAT_TREAT") && !option_id.equals("CA_TASK_LIST_DT"))
							{
								if(desktop_yn.equals("Y") && allow_yn.equals("Y"))
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
								else
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
							}
							else
								out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
						}
						else
						{
							if(desktop_yn.equals("Y") && allow_yn.equals("Y"))
								out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
							else
								out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
						}
					} 
				}else{
					
					out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
				}
		%>
				<td class='CAGROUP' align='center'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value='<%=ql_ref%>' <%=checkProp%> onclick="enableDefault(this,'<%=ilCkeckedYN%>')"></td>
				<%
				if(link_type.equals("F")){
				%>
				<td class='CAGROUP' align='center'><input type='checkbox' name="default_chk<%=ilCkeckedYN%>" id="default_chk<%=ilCkeckedYN%>" value='<%=ql_ref%>' <%=checkdef%> <%=checkdef_dis%> onclick='defaultSelect(this);'></td>
				<% } %>
				</tr>
		<%
				ilCkeckedYN = ilCkeckedYN + 1;		
				i=i+1;
			}
			out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
 			out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
			out.println("<input type=hidden name=occurance value='next'>");
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		%>

		<input type=hidden name=from value='<%=start%>'>
		<input type=hidden name=to value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type=hidden name='link_type' id='link_type' value='<%=link_type%>'>
		<input type=hidden name='default_yn' id='default_yn' value=''>
		<input type=hidden name='initial_count' id='initial_count' value='<%=initial_count%>'>
	 </table>
	 	 
	 <table border='0' width='100%'>
	 <tr><td align='right'><input type='button' class='white' value='Update' width='25%' onclick='updateResp()'></td></tr></table>
	 <%
		}	
	
	 }
		catch(Exception e)
		{
			out.println("Exception in CAMainCustomizeToolbarDtl.jsp"+e.toString());
		}
		finally
		{
		    if(con != null)ConnectionManager.returnConnection(con,request);
		}
	 %>
</form>
</body>
<script>
	function submitPrevNext(from, to)
	{
		
		document.QuickLinksForRespCustomizeDtl.from.value = from;
        document.QuickLinksForRespCustomizeDtl.to.value = to; 
        document.QuickLinksForRespCustomizeDtl.target = "detailFrame"
        document.QuickLinksForRespCustomizeDtl.submit();
	}
	
	function updateResp()
	{			
		document.QuickLinksForRespCustomizeDtl.action = "../../servlet/eCA.QuickLinksRespUpdateServlet?function_id=<%=function_id%>&<%=request.getQueryString()%>"
		document.QuickLinksForRespCustomizeDtl.target = "messageFrame"
        document.QuickLinksForRespCustomizeDtl.submit();
	}
	var pre_default='';
	function chkdefault(count,obj)
	{
		document.forms[0].default_yn.value=obj;
		
		if(pre_default!='')
		{
			eval("document.forms[0].chkdefault"+pre_default).checked = false;
		}
		else
		{
			var initial_count = document.forms[0].initial_count.value;
			
				if(initial_count!= -1)
				{
					eval("document.forms[0].chkdefault"+initial_count).checked = false;
				}
		}
		pre_default = count;
	}

function defaultSelect(object)
{
	var start = eval(document.forms[0].from.value)-1;
	var end = eval(document.forms[0].end.value)-1;
	for(i=start;i<=end;i++)
	{
		if(object.checked == true)
		{
			if(eval("document.forms[0].default_chk"+i)!=null)
			{
				var obj = eval("document.forms[0].default_chk"+i);
				
				if(object == obj)
				{
					if(eval("document.forms[0].chk"+i).checked == true)
						obj.checked = true;
					else
						object.checked = false;
				}
				else
				{
					obj.checked = false;
				}
			}
		}
	}
}




	function enableDefault(obj,count)
	{
		if(eval("document.forms[0].default_chk"+count)!=null)
		{
			if(obj.checked==true)
			{
				
				eval("document.forms[0].default_chk"+count).disabled = false;	
			}
			else
			{
				
				eval("document.forms[0].default_chk"+count).checked = false;
				eval("document.forms[0].default_chk"+count).disabled = true;
			}
		}

	}


</script>
</html>

