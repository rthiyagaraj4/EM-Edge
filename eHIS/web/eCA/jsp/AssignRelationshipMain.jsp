<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created
01/10/2014    IN051373		Chowminya      									Patient List By PPR Relationship Issue 	
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title> <fmt:message key="eCA.AssignPatientRelationship.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/AssignRelationship.js'></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='makeInvisible()'>
 <br><br>
	<center>
	<form name='AssignRelationshipForm' id='AssignRelationshipForm' method='POST' action='../../servlet/eCA.AssignRelationshipServlet' target=''>
	<table border='0' cellpadding='3' cellspacing='0' width='95%' align='center' height='60%'>

	<%
		
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");

		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;

		String patient_id = "";
		//String sex="";
		String episode_type = "",location_code="";
		String episode_id = "", visit_id = "", resp_id = "", phys_prov_reln_id = "",phys_prov_reln="";
		String all_all = "", all_enc = "", self_all = "", self_enc = "", my_all = "", my_enc = "";
		String clinician_type = "";
		String reln_rule="";//IN051373
		//String physician_id = "";
		//String clinician_id_prop = "", 
		String login_user_id = ""; 
		//query_clinician_details  = "";
		String query_applicable_tasks = "", clinician_id = "";
		String phys_prov_reln_name = "", phys_prov_id = "";
		String clinician_prop = "",modal_yn="",patient_class="",clinician_value="";
		String pract_type = "";
		String facility_id = "";
		String fromOpenChart_yn = "";
		String pract_name = "";
		String current_relationship_id = "";
		String speciality_code = "";
		String reason_Short_Desc="";
		String reason="";
		String reasonText="";
		String Flag="display : none; ";
		String remarks_relationships_yn ="";

		int	boundCount = 0;
		MessageManager mm = null; 
		java.util.Hashtable message = null;
		PreparedStatement psPract=null;
		ResultSet	rsPract = null;
		//IN051373 - Start
		PreparedStatement psPractRule = null;
		ResultSet rsPractRule = null;
		String pat_discharged_yn = "N"; 
		//IN051373 - End
		Connection	conReason	=	null;
		PreparedStatement psReason  = null;
		ResultSet rsReason = null;
		StringBuffer whereClause = new StringBuffer();


		try
		{
			con = ConnectionManager.getConnection(request);
			conReason = ConnectionManager.getConnection(request);
			login_user_id		=	(String) session.getValue("login_user");
			mm					=	new MessageManager();
			resp_id				=	(String)session.getValue("responsibility_id");
			
			clinician_id		=	(String)session.getValue("ca_practitioner_id");
			facility_id			=	(String)session.getValue("facility_id");
			clinician_type		= (String)session.getValue("practitioner_type");
			pract_type			= 	(String)session.getValue("practitioner_type");
			pract_name			= 	(String)session.getValue("practitioner_name");
			
			
			//String sqlPract="select pract_type, DESC_USERDEF   from am_pract_Type order by DESC_USERDEF ";
			String sqlPract = "select pract_type,  DESC_USERDEF   from am_pract_Type_lang_Vw where language_id= ?  order by DESC_USERDEF";
			psPract = con.prepareStatement(sqlPract);
			psPract.setString(1,locale);
			rsPract = psPract.executeQuery();

			patient_id			=	request.getParameter("patient_id");
			episode_type		=	request.getParameter("episode_type");
			episode_id			=	request.getParameter("episode_id");
			visit_id			=	request.getParameter("visit_id");
			phys_prov_id		=	request.getParameter("phys_prov_id");
			location_code		=	request.getParameter("location_code");
			fromOpenChart_yn		=	request.getParameter("fromOpenChart_yn");
			current_relationship_id		=	request.getParameter("relationship_id");
			speciality_code		=	request.getParameter("speciality_code");

			if (fromOpenChart_yn==null) fromOpenChart_yn="N";
			if ((phys_prov_id==null) ||(phys_prov_id.equals("") ))
					phys_prov_id		=	clinician_id ;
			modal_yn			= request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");

			if(location_code==null)		location_code		=	"";
			if(episode_id==null)		episode_id			=	"";
			if(visit_id==null)			visit_id			=	"";
			if(resp_id==null)			resp_id				=	"";
			if(phys_prov_id==null)		phys_prov_id		=	"";
			if(clinician_type==null)	clinician_type		=	"";
			if(clinician_id==null)		clinician_id		=	"";
			if(login_user_id==null)		login_user_id		=	"";
			if(speciality_code==null)		speciality_code		=	"";
			if(current_relationship_id==null)		current_relationship_id		=	"";
			
			patient_class=request.getParameter("patient_class") == null?"":request.getParameter("patient_class");

			whereClause = new StringBuffer();

			if( modal_yn.equals("Y") )
			{
				clinician_prop = " disabled ";
				clinician_value = pract_name;
			}
		
			
			/* commended by Rajan/Shaiju on 03/05/2007 as it is not used anywhere
			String query_patient_encounter_details="select A.patient_id    , b.sex   , GET_AGE(b.date_of_birth, NVL(b.deceased_date,SYSDATE)) age     , a.ATTEND_PRACTITIONER_ID  physician_id     , AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,'2') physician_name     ,to_char(VISIT_ADM_DATE_TIME    ,'dd/mm/yyyy HH24:MI:SS') visit_adm_date_time     ,ASSIGN_CARE_LOCN_CODE||decode(ASSIGN_ROOM_NUM,null,null,', room no:'||ASSIGN_ROOM_NUM)|| decode(assign_bed_num,null,null,', bed no:'||assign_bed_num) locn_name,    decode(a.patient_class,'OP','O','EM','O','I')from pr_encounter a, mp_patient b where a.facility_id=?   and a.encounter_id=?   and b.patient_id=a.patient_id ";

			pstmt		=	con.prepareStatement(query_patient_encounter_details);

			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,episode_id);
			
			rs	=	pstmt.executeQuery();

			
			try
			{
				if(rs.next())
				{
					patient_id			=	rs.getString("patient_id");
					sex=rs.getString("sex");
					physician_id		=	rs.getString("physician_id");
					//episode_type		=	rs.getString("episode_type");
				}
			
				if(sex.equals("M"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				if(sex.equals("F"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();

				*/

			try
			{
				//IN051373 - Start
				String sqlPractRule = "Select DISCHARGE_DATE_TIME from pr_encounter b where PATIENT_ID = ?  and encounter_id=? ";
				psPractRule = con.prepareStatement(sqlPractRule);
				psPractRule.setString(1,patient_id);
				psPractRule.setString(2,episode_id);
				rsPractRule = psPractRule.executeQuery();
				if(rsPractRule.next())
				{
					String dis_date = rsPractRule.getString("DISCHARGE_DATE_TIME");
					if(dis_date !=null && (current_relationship_id.equals("")))
					{
						pat_discharged_yn = "Y";
					}
				}
				//IN051373 - End
				query_applicable_tasks = " select GET_TASK_APPLICABILITY('EST_RELN_ALL_LFT',null,?,?) all_all, GET_TASK_APPLICABILITY('EST_RELN_ALL_ENC',null,?,?) all_enc, GET_TASK_APPLICABILITY('EST_RELN_SELF_LFT',null,?,?) self_all,  GET_TASK_APPLICABILITY('EST_RELN_SELF_ENC',null,?,?) self_enc, GET_TASK_APPLICABILITY('EST_RELN_MYPAT_LFT',null,?,?) my_all, GET_TASK_APPLICABILITY('EST_RELN_MYPAT_ENC',null,?,?) my_enc from dual ";
					
				pstmt = con.prepareStatement(query_applicable_tasks);
				pstmt.setString(1, resp_id);
				pstmt.setString(2, current_relationship_id);
				pstmt.setString(3, resp_id);
				pstmt.setString(4, current_relationship_id);	
				pstmt.setString(5, resp_id);
				pstmt.setString(6, current_relationship_id);
				pstmt.setString(7, resp_id);
				pstmt.setString(8, current_relationship_id);
				pstmt.setString(9, resp_id);
				pstmt.setString(10, current_relationship_id);
				pstmt.setString(11, resp_id);
				pstmt.setString(12, current_relationship_id);
				
				rs	=	pstmt.executeQuery();

				if(rs.next())
				{
					all_enc = "";
					all_all		=	rs.getString("all_all");
					all_enc		=	rs.getString("all_enc");
					self_all	=	rs.getString("self_all");
					self_enc	=	rs.getString("self_enc");
					my_all		=	rs.getString("my_all");
					my_enc		=	rs.getString("my_enc");
				

					if(all_all==null)	all_all		=	"";
					if(all_enc==null)	all_enc		=	"";
					if(self_all==null)	self_all	=	"";
					if(self_enc==null)	self_enc	=	"";
					if(my_all==null)	my_all		=	"";
					if(all_all==null)	my_enc		=	"";
				}

				if(phys_prov_id.equals(clinician_id))
				{
					if(my_all.equals("A")) all_all = "A";
					if(my_enc.equals("A")) all_enc = "A";
				}
			}
			catch(Exception e)
			{
				e.printStackTrace() ;				
			}

			if(all_all.equals("A"))   // if EST_RELN_ALL_LFT (all_all) is Y 
			{
				if(episode_id.equals("")) // if episode ID is not null then No restrictuin else then following condition
				{
					whereClause.append(" and lifetime_or_encntr = 'L' ");
				}
			}
			else   // if EST_RELN_ALL_LFT (all_all) is N
			{
				if(all_enc.equals("A")) // if EST_RELN_ALL_ENC is Y
				{
					if(self_all.equals("A"))  // if EST_RELN_SELF_LFT is Y
					{
						if(!(episode_id.equals("")))
						{						
							whereClause.append(" and ( ( ? != ? and lifetime_or_encntr = 'E' ) or ? = ? ) ");
							boundCount = 4;
						}
						else
						{
							whereClause.append(" and ( ? = ? and lifetime_or_encntr = 'L' ) ");
							boundCount = 2;
							clinician_prop = " DISABLED ";
						}
					}
					else   // if EST_RELN_ALL_ENC is N
					{
						if(!(episode_id.equals("")))
						{
							whereClause.append(" and ( lifetime_or_encntr = 'E' ) ");
						}
						else
						{
							out.println("<script>alert(getMessage('RELN_REQ_ENC_ID','CA'));parent.window.close()</script>");
						}
					}
				}
				else   //  // if EST_RELN_ALL_ENC is N
				{
					if(self_all.equals("A"))
					{
						if(episode_id.equals(""))
						{
							whereClause.append(" and ( lifetime_or_encntr = 'L' ) ");
						}
					}
					else
					{
						if(self_enc.equals("A"))
						{
							if(!(episode_id.equals("")))
							{
								whereClause.append(" and ( lifetime_or_encntr = 'E' ) ");
							}
							else
							{
								//message = mm.getMessage( con, "RELN_REQ_ENC_ID" ) ;
								out.println("<script>alert(getMessage('RELN_REQ_ENC_ID','CA'));parent.window.close()</script>");
								//throw new Exception ((String) message.get("message"));
							}
						}
						else
						{
							//message = mm.getMessage( con, "RELN_NOT_ELGIBLE" ) ;							
							//out.println("<script>alert('RELN_NOT_ELGIBLE','CA');parent.window.close()</script>");
							out.println("<script>alert(getMessage('RELN_NOT_ELGIBLE','CA'));parent.window.close()</script>");
							
							
							
							//throw new Exception ((String) message.get("message"));
						} // end of else
					} // end of else
					clinician_prop = " DISABLED ";
				} // end of else
			} // end of else

			if(message!=null)message.clear();
		} // end of try
		catch(Exception e)
		{

			e.printStackTrace() ;
			if(modal_yn.equals("Y"))
			{
				//out.println("<script>parent.window.close();");
				//out.println("</script>");
			}
			else
			{
				//out.println("<script>alert('"+e.getMessage()+"');");//COMMON-ICN-0181
				out.println("top.secondframe.thirdframe.location.href='../../eCommon/html/blank.html';//document.location.href='../../eCommon/html/blank.html';</script>");
				//out.println(e.getMessage());//common-icn-0181				
			}
		}
		//ReasonCode 
		
		try{
			
			String sqlPractRule ="SELECT  REMARKS_RELATIONSHIPS_YN FROM ca_encntr_param";
			psPractRule = con.prepareStatement(sqlPractRule);
			rsPractRule = psPractRule.executeQuery();
			if(rsPractRule.next())
			{  
				remarks_relationships_yn = rsPractRule.getString("REMARKS_RELATIONSHIPS_YN");
					if(remarks_relationships_yn.equalsIgnoreCase("Y") && (episode_id.equals(""))){
					 Flag="";
				}else{
					 Flag="display : none; ";
				}
			}		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//ReasonCode
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}catch(Exception ex){
				ex.printStackTrace() ;
			}
		}
		
	%>
		
		<tr id='tempCheckList'>
			<td  class='LABEL' width='25%'><fmt:message key="eCA.LimitPractitionerListtoAccessLocation.label" bundle="${ca_labels}"/></td>
			<td class='fields' width='25%'><input type='checkbox' name='chkLimitPractList' id='chkLimitPractList'></td>
			<td colspan=2></td>
		</tr>
		<tr>
			<td class='LABEL' width='25%'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/> </td>
			<td class='fields' width='25%'><select name='clinician_type' id='clinician_type' '<%=clinician_prop%>'>
				<option value=''>&nbsp;&nbsp;&nbsp;---- ---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- ----&nbsp;&nbsp;&nbsp;</option>
			<%
				String PType = "";
				String selOpt = "";
				while(rsPract.next())
				{
					PType = rsPract.getString(1);
					if(clinician_type.equals(PType))
						selOpt = "selected";
					%>

					<option value='<%=rsPract.getString(1)%>'  <%=selOpt%>><%=rsPract.getString(2)%></option>
			<%	
					selOpt = "";
					}
			%>
				</select><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<!--<script>document.forms[0].clinician_type.value='<%=pract_type%>';</script> -->
			<td class='LABEL' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			<input type='text' name='clinician_name' id='clinician_name' value='<%=clinician_value%>' size=20 '<%=clinician_prop%>' onblur='get_name(this)'><input type="button" class='Button' name="clinician_name_button" id="clinician_name_button" title='search_code' value="?" onClick='get_name(this)' '<%=clinician_prop%>'><img src='../../eCommon/images/mandatory.gif'></img>
			<%
				try
				{
					if(rsPract!=null) rsPract.close();
					if(psPract!=null) psPract.close();
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
			
			%>

			</td>
		</tr>
		<tr>
			<td class='LABEL' width='25%' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><select name='relationship' id='relationship' onChange='return checkOnBlurRelationship(this);'>
				<!-- option value set as '' IN051373-->
				<option value=''>&nbsp;&nbsp;&nbsp;---- ---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- ----&nbsp;&nbsp;&nbsp;</option>
				<%
				try
				{
						
				 if (modal_yn.equals("Y"))
				 {
						String query_relationship_details ="select PRACT_RELN_ID phys_prov_reln_id, PRACT_RELN_NAME pract_name,LIFETIME_OR_ENCNTR phys_prov_reln_name,EXPIRY_RULE rule from ca_pract_reln_lang_vw O where LANGUAGE_ID   =? and direct_yn='Y' and EFF_STATUS='E' and exists (select 1 from ca_pract_reln_for_resp a, sm_resp_for_user b where b.appl_user_id =  ? and a.resp_id =? and pract_reln_id= O.pract_reln_id and a.resp_id = b.resp_id and CAN_ASSIGN_YN='Y') 	and exists (select 1 from ca_pract_reln_for_resp a, sm_resp_for_user b, sm_appl_user c where c.FUNC_ROLE_ID = ? and pract_reln_id= O.pract_reln_id and c.APPL_USER_ID=b.appl_user_id and a.resp_id = b.resp_id and CAN_HOLD_YN='Y' ) "+whereClause.toString()+" order by phys_prov_reln_name "; //IN051373 included rule
					
					pstmt		=	con.prepareStatement(query_relationship_details);					
					pstmt.setString(1,locale);
					pstmt.setString(2,login_user_id);
					pstmt.setString(3,resp_id);
					pstmt.setString(4,phys_prov_id);
							
					if(boundCount==2)
					{
						pstmt.setString(4,phys_prov_id);
						pstmt.setString(5,clinician_id);

					}
					else if(boundCount==4)
					{
						pstmt.setString(4,phys_prov_id);
						pstmt.setString(5,clinician_id);
						pstmt.setString(6,phys_prov_id);
						pstmt.setString(7,clinician_id);

					
					}
					rs	=	pstmt.executeQuery();

					while(rs.next())
					{
						phys_prov_reln_id	=	rs.getString("phys_prov_reln_id");
						phys_prov_reln		=	rs.getString("phys_prov_reln_name");
						pract_name			=	rs.getString("pract_name");
						//IN051373 - Start
						reln_rule			=	rs.getString("rule");
						if(reln_rule==null)
							reln_rule = "";	
						phys_prov_reln_id = phys_prov_reln_id+"~"+reln_rule;
						//IN051373 - End
						if(phys_prov_reln.equals("E"))
							phys_prov_reln_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
			
						else if(phys_prov_reln.equals("L"))
							phys_prov_reln_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
						phys_prov_reln_name=pract_name+"/"+phys_prov_reln_name;

				%>
							<option value='<%=phys_prov_reln_id%>'><%=phys_prov_reln_name%></option>
				<%
					
					}

				
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				 }
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
				finally
				{
					
					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
				%>
				</select><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td class='LABEL'  ><fmt:message key="Common.ExpiryBased.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type='checkbox' disabled name='expiry_based_yn' id='expiry_based_yn' value='Y'></td>
			</tr><tr>
			<td class='LABEL'  width='25%'><fmt:message key="Common.rule.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type='text' name='expiry_rule' id='expiry_rule' readOnly value='' size=20></td>
			<td colspan=4></td>
		</tr>
	<!-- ReasonCode Start --><!--  605.5 -->
		<tr style="<%=Flag %>">
			<td class='LABEL' width='25%'><fmt:message key="eCA.Reason.label" bundle="${ca_labels}"/></td>
			<td class='fields' width='25%'><select name='reason' id='reason' onChange='return setReasonText(this)'>
			<%-- <input type='text' name='reason_short_desc' id='reason_short_desc' size='40' maxLength='40' value='<%=reason_Short_Desc %>' /> --%>
			<option value=''>&nbsp;&nbsp;&nbsp;---- ---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- ----&nbsp;&nbsp;&nbsp;</option>
			<%
			try{
				 String sqlReasonTxt = "select Reason_Desc, Reason_text from CA_REASON_CODE where eff_status='E' ";
				 psReason = conReason.prepareStatement(sqlReasonTxt);
				 rsReason = psReason.executeQuery();
					while(rsReason.next())
					{
						reason= rsReason.getString("Reason_Desc");
						reasonText=rsReason.getString("Reason_text");
						%>
						<option value='<%=reasonText%>'><%=reason%></option>
						<%					
						}
					
			}
			catch(Exception e){
				e.printStackTrace();
			}finally{
				rsReason.close();
				psReason.close();
				conReason.close();
			}
			%>
			</select><img src='../../eCommon/images/mandatory.gif'></img>
			</td>

			<td class='LABEL' width='25%'><fmt:message key="eOR.ReasonText.label" bundle="${or_labels}"/></td>
			<td class='fields' width='25%'><TEXTAREA NAME="reasonText" ROWS="3" COLS="40" onBlur = "return makeValidString(this)" onKeyPress="return CheckMaxLength(this,200)" readonly></TEXTAREA></td>
		</tr>
	<!-- ReasonCode End --><!--  605.5 -->
		<tr>
			<td class='LABEL' width='25%'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type='text' name='start_date' id='start_date'  readOnly value='' size=14 maxlength=14></td>
			<td class='LABEL' width='25%'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type='text' name='end_date' id='end_date'  readOnly value='' size=14  maxlength=14></td>
		</tr><tr id='tdTerminate'>
			<td class='LABEL' width='25%' ><fmt:message key="eCA.TerminateRelation.label" bundle="${ca_labels}"/></td>
			<td class='fields' id=''><input type='checkbox' name='chkTerminate' id='chkTerminate' value='N' onClick='return funTerminateReln()' ></td>	
			<td class='LABEL' id='tempRelation' ></td>
			<td colspan=4></td>
		</tr>
		<tr>
			<td colspan=4 align=right>
			<input type='button' class='BUTTON' name='record' id='record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick = 'return checkOnSubAssignRelationship();'>
			<input type='button' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'  onClick='return callOnCancel();'>
			<input type='reset' class='BUTTON' name='clear' id='clear' '<%=clinician_prop%>' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick = 'return callClear();' >
			</td>
		</tr>

	</table>
		<input type='hidden' name='clinician_id' id='clinician_id' value='<%=clinician_id%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='pline' id='pline' value='<%=request.getParameter("pline")%>'>
		<input type='hidden' name='query_string' id='query_string' value='<%=request.getQueryString()%>'>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
		<input type='hidden' name='act_clinician_type' id='act_clinician_type' value=''>
		<input type='hidden' name='act_clinician_id' id='act_clinician_id' value=''>
		<input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type%>'>
		<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>'>
		<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id%>'>
		<input type='hidden' name='phys_prov_id' id='phys_prov_id' value='<%=phys_prov_id%>'>
		<input type='hidden' name='phys_prov_reln_id' id='phys_prov_reln_id' value='<%=phys_prov_reln_id%>'>
		<input type='hidden' name='resp_id' id='resp_id' value='<%=resp_id%>'>
		<input type='hidden' name='all_all' id='all_all' value='<%=all_all%>'>
		<input type='hidden' name='all_enc' id='all_enc' value='<%=all_enc%>'>
		<input type='hidden' name='self_all' id='self_all' value='<%=self_all%>'>
		<input type='hidden' name='self_enc' id='self_enc' value='<%=self_enc%>'>
		<input type='hidden' name='my_all' id='my_all' value='<%=my_all%>'>
		<input type='hidden' name='my_enc' id='my_enc' value='<%=my_enc%>'>
		<input type='hidden' name='whereClause' id='whereClause' value="<%=whereClause.toString()%>">
		<input type='hidden' name='boundCount' id='boundCount' value="<%=boundCount%>">
		<input type='hidden' name='modal_yn' id='modal_yn' value="<%=modal_yn%>">
		<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
		<input type='hidden' name='hyperLinkStartDate' id='hyperLinkStartDate' value=''>
		<input type='hidden' name='hyperLinkEndDate' id='hyperLinkEndDate' value=''>
		<input type='hidden' name='currentDateTime' id='currentDateTime' value=''>
		<input type='hidden' name='tempEndDate' id='tempEndDate' value=''>
		<input type='hidden' name='added_date' id='added_date' value=''>
		<input type='hidden' name='terminate' id='terminate' value=''>
		<input type='hidden' name='location_code' id='location_code' value='<%=location_code%>'>
		<input type='hidden' name='fromOpenChart_yn' id='fromOpenChart_yn' value='<%=fromOpenChart_yn%>'>
		<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
		<input type='hidden' name='pat_discharged_yn' id='pat_discharged_yn' value='<%=pat_discharged_yn%>'><!-- IN051373 -->
		<input type='hidden' name='act_reason_short_desc' id='act_reason_short_desc' value=''>
		<input type='hidden' name='reason_text' id='reason_text' value=''>
		<input type='hidden' name='remarks_relationships_yn' id='remarks_relationships_yn' value='<%=remarks_relationships_yn%>'>
		
	</form>
	</center>
</body>
</html>

