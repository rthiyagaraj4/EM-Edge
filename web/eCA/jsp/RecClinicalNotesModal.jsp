<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100           		?           	created
17/12/2013		IN044085		Ramesh G		Bru-HIMS-CRF-024.2 
12/05/2015		IN053733		Ramesh G		Bru-HIMS-CRF-024.3 
----------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------
04/02/2016		IN057201		Karthi L											View Forwarded Referral Letter Under Consults
01/11/2016		IN061988		Vijayakumar K										AAKH-CRF-0088.3 [IN:061988]
08/01/2019		IN069251		Prakash			10/09/2018		Ramesh Goli			ML-MMOH-CRF-1130.3
28/02/2025	    68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
----------------------------------------------------------------------------------------------------------------------------------
 */
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!--  <script>alert('<%=request.getQueryString()%>');</script>   -->
<html>
<head>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//IN053733 Start.
String sessionNFKey=(request.getParameter("patient_id"))+(request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"))+"NFERROR";
%>
<script>
	function windowUnload(){
		var xmlHttp = new XMLHttpRequest();
		
		xmlStr ="<root><SEARCH /></root>" ;
		
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","NotifiableIntermediate.jsp?sessionNFKey=<%=sessionNFKey%>",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		if(responseText=="MakeAsError"){
			window.returnValue=responseText;
		}else{
			window.returnValue = top.NotifiableNoteFrm.document.NotifiableNoteForm.tempAccession_Num.value;
			
		}
	  }
	

	</script>
<%
	//IN053733 End.
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rset = null;	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	


	String respid		= "";
	String strFileName	= "";
	String title		= request.getParameter("title")==null?"":request.getParameter("title");
	String function_id	= request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String event_class	= request.getParameter("event_class")==null?"":request.getParameter("event_class");
	String appl_task_id = request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");
	String note_type	= request.getParameter("note_type")==null?"":request.getParameter("note_type");
//	String disp_pat_line_yn	= request.getParameter("disp_pat_line_yn")==null?"N":request.getParameter("disp_pat_line_yn");
	String patient_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String visit_adm_date	= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
	String episode_id	= request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String patient_id	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String location_code	= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String speciality_code	= request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String open_in_normal_yn	= request.getParameter("open_in_normal_yn")==null?"N":request.getParameter("open_in_normal_yn");
	String notifiable_code	= request.getParameter("notifiable_code")==null?"":request.getParameter("notifiable_code");  //IN044085 
	String notifiable_emailYN  = request.getParameter("notifiable_emailYN")==null?"N":request.getParameter("notifiable_emailYN");  //IN044085 
	String called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");  //IN053733 
	String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num");  //IN053733 
	String contr_oth_accession_num = request.getParameter("contr_oth_accession_num")==null?"":request.getParameter("contr_oth_accession_num");  //IN053733
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");  //IN044085
	String deflt_search_mode_from_refral_yn = request.getParameter("deflt_search_mode_from_refral_yn")==null?"":request.getParameter("deflt_search_mode_from_refral_yn");  //ML-MMOH-CRF-0362 [IN057201]  
	String orderStatusCodeHdr = request.getParameter("orderStatusCodeHdr")==null?"":request.getParameter("orderStatusCodeHdr");  //68801
	StringBuffer queryString = new StringBuffer();
	String episode_type = "";
	String speciality_name = "";
	//String speciality_code = "";
	//String location_code = "";

	boolean returnFlag	= false;

	try
	{
		con =  ConnectionManager.getConnection(request);    

		if(appl_task_id.equals(""))
		{
			if(function_id.equals("SPCL_NOTE"))
			{
				if(event_class.equals("MDB$"))
					appl_task_id = "PRE_MEDICAL_BOARD";
				else if(event_class.equals("MDR$"))
					appl_task_id = "MR_MEDICAL_REPORT";
				else
					appl_task_id = "CP_ASSESSMENT";
			}
			else if(function_id.equals("NOTIFIABLEFORM"))
				appl_task_id = "NOTIFIABLEFORM";
		}
	 
		if(appl_task_id.equals(""))
		{
			 try
			{
				 String qry = "select appl_task_id from ca_note_group a , ca_note_type b where b.note_group_id=a.note_group and b.note_type=?";
			 
				stmt = con.prepareStatement(qry);
				stmt.setString(1, note_type);
				
				rset = stmt.executeQuery();
				
				if(rset.next())
				 appl_task_id = rset.getString("appl_task_id");

				if(rset !=null) rset.close();
				if(stmt!= null ) stmt.close();
			}
			catch(Exception e)
			{
			 e.printStackTrace();
			}
		 }
		
		 if(appl_task_id.equals(""))
			returnFlag = true;




		 
	String clinician_id		=	(String)	session.getValue("ca_practitioner_id");
	String clinician_name	=	(String)	session.getValue("practitioner_name");
		
	if(clinician_id == null || clinician_name == null)
	{
		try
		{
			String login_user=(String)session.getValue("login_user");
			String sql= "select a.func_role_id, B.practitioner_name, B.pract_type,c.TAB_MENU_YN ,c.ESTABLISH_RELN_REQ_YN from sm_appl_user a,AM_PRACTITIONER_LANG_VW B,ca_encntr_param c where a.appl_user_id = ? and a.func_role ='P' AND B.PRACTITIONER_ID = A.FUNC_ROLE_ID AND B.LANGUAGE_ID = ?";
			
			String func_role_id="",		practitioner_name="",	pract_type="";

			stmt=con.prepareStatement(sql);
			stmt.setString(1,login_user);
			stmt.setString(2,locale);
			rset=stmt.executeQuery();

			if(rset.next())
			{
				func_role_id=rset.getString(1);
				
				if(func_role_id == null) 
					func_role_id="";

				practitioner_name=rset.getString(2);
				
				if(practitioner_name == null) 
					practitioner_name="";

				pract_type = rset.getString(3);
				
				if(pract_type == null) 
					pract_type="";

				session.putValue("ca_practitioner_id",func_role_id);
				session.putValue("practitioner_name",practitioner_name);
				session.putValue("practitioner_type",pract_type);
			}

			if(rset !=null) rset.close();
			if(stmt!= null ) stmt.close();

			String qry = "select SM_GET_DESC.SM_RESP(?,?,'1') resp_name from dual";
			respid=(String) session.getValue("responsibility_id");
			
			if(respid == null) 
				respid = "";
			
			stmt	=	con.prepareStatement(qry);
			stmt.setString(1,respid);
			stmt.setString(2,locale);
			rset=stmt.executeQuery();
			
			String resp_name = "";
			
			if(rset.next())
				resp_name = rset.getString(1);
		
			if(rset !=null) rset.close();
			if(stmt!= null ) stmt.close();

			session.putValue("resp_name",resp_name);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception @1=" + e);//COMMON-ICN-0181
		}
	}

	if(patient_class.equals("")||location_code.equals("")||speciality_code.equals(""))
	{		
		//queryString = new StringBuffer();
		String patQuery = "select P.PATIENT_CLASS PATIENT_CLASS ,P.EPISODE_ID EPISODE_ID ,to_char(P.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE,SPECIALTY_CODE speciality_code,AM_get_desc.AM_SPECIALITY(SPECIALTY_CODE,?,2) speciality_name,P.ASSIGN_CARE_LOCN_CODE LOCN_CODE from  PR_ENCOUNTER P where  P.PATIENT_ID =? and P.ENCOUNTER_ID =?" ;

		stmt	=	con.prepareStatement(patQuery);
		stmt.setString(1,locale);
		stmt.setString(2,patient_id);
		stmt.setString(3,encounter_id);
		rset=stmt.executeQuery();
	
		if(rset.next())
		{
			patient_class =rset.getString("PATIENT_CLASS")==null?"":rset.getString("PATIENT_CLASS");
			episode_id =rset.getString("EPISODE_ID")==null?"":rset.getString("EPISODE_ID");
			visit_adm_date =rset.getString("VISIT_ADM_DATE")==null?"":rset.getString("VISIT_ADM_DATE");
			speciality_code =rset.getString("speciality_code")==null?"":rset.getString("speciality_code");
			speciality_name =rset.getString("speciality_name")==null?"":rset.getString("speciality_name");
			location_code =rset.getString("LOCN_CODE")==null?"":rset.getString("LOCN_CODE");
		
		}
	}
		if(patient_class.equals("IP")||patient_class.equals("DC"))
			episode_type ="I";
		if(patient_class.equals("OP")||patient_class.equals("EM"))
			episode_type ="O";

		queryString.append("appl_task_id="+appl_task_id);		
		queryString.append("&title="+title);
		queryString.append("&patient_id="+patient_id);
		queryString.append("&encounter_id="+encounter_id);
		queryString.append("&episode_type="+episode_type);
		queryString.append("&visit_adm_date="+visit_adm_date);
		queryString.append("&patient_class="+patient_class);
		queryString.append("&speciality_name="+speciality_name);
		queryString.append("&speciality_code="+speciality_code);
		queryString.append("&location_code="+location_code);
		queryString.append("&function_id="+function_id);
		queryString.append("&notifiable_code="+notifiable_code);	//IN044085
		queryString.append("&notifiable_emailYN="+notifiable_emailYN);	//IN044085
		queryString.append("&accession_num="+accession_num);
		queryString.append("&called_from="+called_from);  //IN053733
		queryString.append("&contr_mod_accession_num="+contr_mod_accession_num);//IN053733
		queryString.append("&contr_oth_accession_num="+contr_oth_accession_num);//IN053733
		queryString.append("&deflt_search_mode_from_refral_yn="+deflt_search_mode_from_refral_yn); //ML-MMOH-CRF-0362 [IN057201]
		queryString.append("&orderStatusCodeHdr="+orderStatusCodeHdr); //68801

		/*	if(queryString.indexOf("&patient_class=") >= 0)
		{
			String temp ="&patient_class="+patient_class ;
			String temp1 ="&patient_class=";
			queryString.replaceAll(temp1,temp);
			
			
		}  */
	


/*
	String strQuery = "SELECT GET_TASK_APPLICABILITY('CLINICAL_NOTES',NULL,?,?,?,?,?)   FROM DUAL";

	stmt = con.prepareStatement(strQuery);
	stmt.setString(1,respid);
	stmt.setString(2,"");
	stmt.setString(3,facility_id);
	stmt.setString(4,encounter_Id);
	stmt.setString(5,patient_id);			

	rset = stmt.executeQuery();

	if(rset.next())
		strApplicability =  rset.getString(1);
*/
	
//	if(strApplicability.equals("A") )
		strFileName = "../../eCA/jsp/RecClinicalNotesModalFrame.jsp?"+request.getQueryString();
//	else
//		strFileName = "../../eCA/jsp/RecClinicalNotesModalFrame.jsp?"+request.getQueryString()+"&appl_task_id="+appl_task_id;

	if(rset !=null) rset.close();
	if(stmt!= null ) stmt.close();
}
catch(Exception e)
{
	e.printStackTrace();
	out.println("Exception @ RecClinicalNotesModal"+e.toString());
}
finally
{
		if (con !=null) ConnectionManager.returnConnection(con,request);
}
//IN069251 starts
	if(appl_task_id.equals("REPLY_NOTES")){
		%>
	<title><%=(title==""?"Reply Notes":title)%></title>
	
	<%
	}else{ 
//IN069251 ends
%>
	<title><%=(title==""?"Record Clinical Notes":title)%></title>
	
	<%
	}//IN069251	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<%
	if(!returnFlag)
	{
	 
	if (open_in_normal_yn.equals("Y"))
	{
	%>
	<script>
	top.content.workAreaFrame.location.href ='../../eCA/jsp/RecClinicalNotes.jsp?<%=queryString.toString()%>';
	</script>
	<%}
	else
	{
		//IN053733 Start.
		if(!"".equals(notifiable_code)){
			session.setAttribute(sessionNFKey, "");
			%>
			<iframe name="content" id="content" frameborder="0" scrolling="no" noresize src="<%=strFileName%>" frameborder='0' style="height:100vh;width:100vw"></iframe>
			<iframe name="NotifiableNoteFrm" id="NotifiableNoteFrm" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/NotifiableNoteHistory.jsp" frameborder='0' style="height:0%;width:100vw"></iframe>
			
		<%}else{
		//IN053733 End.
		%>
			<!-- IN061988 starts -->
			<script>
			if(!'<%=appl_task_id%>' == 'PH_NOTES')
				top.content.workAreaFrame.location.href ='../../eCA/jsp/RecClinicalNotes.jsp?<%=queryString.toString()%>';
			</script>
			<!-- IN061988 ends --->
			<iframe name="content" id="content" frameborder="0" scrolling="no" noresize src="<%=strFileName%>" frameborder='0' style="height:100vh;width:100vw"></iframe>
			
		<%} //IN053733%>
	<%}}else{%>
		<script>
		alert(getMessage("INSUFFICIENT_PARAMS","CA"));	
		//alert('CA APP-11059  Enough Parameters have not been passed for this function to record Notes. Please Contact your administrator..');
			window.close();
		</script>
	<%}%>
</head>
</html>


