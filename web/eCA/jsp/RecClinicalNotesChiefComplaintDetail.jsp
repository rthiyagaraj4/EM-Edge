<!DOCTYPE html>
<%@page import="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
%>

<html>
<head>
	<title><fmt:message key="eCA.CannedText.label" bundle="${ca_labels}"/></title>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
    <!-- **** Added By Archana on 3/1/2010 at 9:53 AM applied new css grid. **** -->
	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	service_code		=	"";//,		login_user_id	=	"";
	String	text_blk_id			=	"",		text_blk		=	"";
	String	selectBlockId		=	"";
	String	text_blk_id_name	=	"",		text_blk_name	=	"";
	String	classValue			=	"";//,		note_type		=	"";
	String	sec_hdg_code		=	"";
	String  patient_id			=	"",		child_sec_hdg_code	= "";
	String  encounter_id		=	"";

	StringBuffer query_canned_text	=new StringBuffer();
	
	int selectIndex = 0;
%>
	<center>
	<form name='RecClinicalNotesCannedTextForm' id='RecClinicalNotesCannedTextForm' action='../../eCA/jsp/RecClinicalNotesChiefComplaintControl.jsp' target=RecClinicalNotesCCControlFrame method=post>
		<table class='grid' width='100%' >
		<td class='columnheadercenter'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<%

		try
		{
			con							=	ConnectionManager.getConnection(request);

			service_code				=	(request.getParameter("service_code")==null) ?	""	:	request.getParameter("service_code");
			sec_hdg_code				=	(request.getParameter("sec_hdg_code")==null) ?	""	:	request.getParameter("sec_hdg_code");
			child_sec_hdg_code			=	(request.getParameter("child_sec_hdg_code")==null) ?	""	:	request.getParameter("child_sec_hdg_code");

			String searchCriteria		=(request.getParameter("search_criteria")==null) ?	""	:	request.getParameter("search_criteria");
			String radio				=(request.getParameter("radio")==null) ?	""	:	request.getParameter("radio");
			String searchText			=(request.getParameter("search_text")==null) ?	""	:	request.getParameter("search_text");
			String facility_id			= (String) session.getValue("facility_id");
			encounter_id				= request.getParameter("encounter_id");
			patient_id					= request.getParameter("patient_id");

			String strKey = "";

			strKey	=	patient_id + "~"+ encounter_id;

			strKey = strKey.trim();
			sectionBean.getPatientSection(strKey);
			
			HashSet set = (HashSet) sectionBean.getSectionChiefComplaint	(sec_hdg_code,child_sec_hdg_code);

			boolean flag=false;
			String checked = "";
			
			if(set != null )
				flag=true;
			//----------------
			
			if(service_code==null)		service_code	= "";

			/*if (radio.equalsIgnoreCase("CE"))
			{
				query_canned_text.append("select b.complaint_id,b.complaint_text from ca_encntr_chief_complaint a, ca_chief_complaint b where a.facility_id=? and a.encounter_id=?  and b.complaint_id=a.complaint_id and nvl( b.SPECIALITY_CODE, ? ) = ? and b.EFF_STATUS = 'E' ");
			}	
			else if (radio.equalsIgnoreCase("AE"))
			{
				query_canned_text.append("select distinct b.complaint_id,b.complaint_text from ca_encntr_chief_complaint a, ca_chief_complaint b where (a.facility_id, a.encounter_id) in (select facility_id,encounter_id from pr_encounter where patient_id=?)  and b.complaint_id=a.complaint_id and nvl( b.SPECIALITY_CODE, ? ) = ? and b.EFF_STATUS = 'E' ");
			}
			else
			{
				query_canned_text.append("select b.COMPLAINT_ID,b.COMPLAINT_TEXT from CA_CHIEF_COMPLAINT b where nvl( b.SPECIALITY_CODE, ? ) = ? and b.EFF_STATUS = 'E' ");
			} */
			//In Below queries 'and  nvl( b.SPECIALITY_CODE, ? ) = ?' this condition is commented by Archana Dhal on 6/17/2010 related to IN022163.
 
			if (radio.equalsIgnoreCase("CE"))
			{
				query_canned_text.append("select b.complaint_id,b.complaint_text from 	 ca_encntr_chief_complaint a, ca_chief_complaint_lang_Vw b where  a.facility_id=? and a.encounter_id=? and b.complaint_id=a.complaint_id /*and  nvl( b.SPECIALITY_CODE, ? ) = ?*/ and 	 b.EFF_STATUS = 'E'  and b.language_id = ?");				
			}	
			else if (radio.equalsIgnoreCase("AE"))
			{
				query_canned_text.append("select distinct b.complaint_id,b.complaint_text from ca_encntr_chief_complaint a, ca_chief_complaint_lang_vw b where (a.facility_id, a.encounter_id) in (select facility_id,encounter_id from pr_encounter where patient_id=?)  and b.complaint_id=a.complaint_id /*and nvl( b.SPECIALITY_CODE, ? ) = ?*/ and	   b.EFF_STATUS = 'E' and b.language_id = ?");
			}
			else
			{
				query_canned_text.append("select  b.COMPLAINT_ID,b.COMPLAINT_TEXT from 	  CA_CHIEF_COMPLAINT_lang_Vw b where /*nvl( b.SPECIALITY_CODE, ? ) = ? and*/  b.EFF_STATUS = 'E' and language_id = ?");
			}
			//
			if (!searchText.equals(""))
			{
				if(searchCriteria.equals("S"))
					searchText=searchText+"%";
				else if(searchCriteria.equals("E"))
					searchText="%"+searchText;
				else if(searchCriteria.equals("C"))
					searchText="%"+searchText+"%";

				query_canned_text.append(" and upper(b.COMPLAINT_TEXT) like upper(?)");
			}

			query_canned_text.append(" order by 2 ");
			
			pstmt		=	con.prepareStatement(query_canned_text.toString());
			
			int st=0;

				if (radio.equalsIgnoreCase("CE"))
				{
					pstmt.setString(++st,facility_id);
					pstmt.setString(++st,encounter_id);
				}
				else if(radio.equalsIgnoreCase("AE"))
				{
					pstmt.setString(++st,patient_id);
				}

				//Commented by Archana Dhal on 6/17/2010 related to IN022163.

				//pstmt.setString(++st,service_code);
				//pstmt.setString(++st,service_code);
				pstmt.setString(++st,locale);
				if (!searchText.equals(""))
				{
					pstmt.setString(++st,searchText);
				}
			
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				text_blk_id		=	rs.getString("COMPLAINT_ID");
				text_blk		=	rs.getString("COMPLAINT_TEXT");

				//checking wether already present in the bean
				if(flag)
				{
					if(set.contains(text_blk_id))
						checked = "checked";					
				}
				text_blk = text_blk.replaceAll("\r\n","<br>");	

				text_blk_name		=	"text_blk" + selectIndex ;
				text_blk_id_name	=	"text_blk_id" + selectIndex ;
				selectBlockId		=	"block_id"	  + selectIndex ;

				if( (selectIndex%2)==0 )
					classValue = "gridDataChart";
				else
					classValue = "gridDataChart";

				selectIndex ++ ;
	%>
				<tr>
					<td class='<%=classValue%>'>
					<input type='checkbox' <%=checked%> name='<%=selectBlockId%>' id='<%=selectBlockId%>'  value='Y'>
					<input type='hidden' name='<%=text_blk_id_name%>' id='<%=text_blk_id_name%>' value='<%=text_blk_id%>'>	
					</td>
					<td class='<%=classValue%>' id='<%=text_blk_name%>'><%=text_blk%>
					</td>

				</tr>
	<%
				checked = "";
			} // end of while(rs.next())
             /*added by Archana on 3/1/2010 at 9:53 AM for IN019554*/
		/*
			Added the condition,if there are no records it will display the below alert message.

		*/
			 if(selectIndex==0){ %>
		     <Script language=javascript>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
             </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

            <%}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@1: "+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
	%>
		</table>
		<input type=hidden name='child_sec_hdg_code' id='child_sec_hdg_code' value='<%=child_sec_hdg_code%>'>
		<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
		<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		<input type='hidden' name='totalBlocks' id='totalBlocks' value='<%=selectIndex%>'>
		<input type=hidden name='sec_hdg_code' id='sec_hdg_code' value='<%=sec_hdg_code%>'>
	</form>
	</center>
</body>
</html>

