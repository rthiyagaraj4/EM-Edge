<!DOCTYPE html>
<%@ page import = "java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.RecClinicalNotesSectionBean matBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("matBean","webbeans.eCA.RecClinicalNotesSectionBean",session);	


%>
<html>
	<head>
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>	
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		/*java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;		//Ramesh
		String locale = (String) p.getProperty("LOCALE");									//Ramesh*/

		String sectionType = request.getParameter("sectionType") == null ? "" : request.getParameter("sectionType");
		String moduleId = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
		String cycle_no = request.getParameter("cycle_no") == null ? "0" : request.getParameter("cycle_no");
		String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
		String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
		String accessionNum = request.getParameter("accession_number") == null ? "" : request.getParameter("accession_number");
		
		/*****/
		String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");//[CRF-118]

		String tabClick = request.getParameter("tabClick") == null ? "" : request.getParameter("tabClick");
		String modeValue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");
		String ageDependentCompIds = "";
		String compDependentAgeGrps = "";
		String ageDependentResults = "";
		String prevSecHdgCode = request.getParameter("prevSecHdgCode") == null ? "" : request.getParameter("prevSecHdgCode");
		String prevSubSecHdgCode = request.getParameter("prevSubSecHdgCode") == null ? "" : request.getParameter("prevSubSecHdgCode");
		String 	grid_component_ids					=		request.getParameter("grid_component_ids");
		 if(grid_component_ids==null) grid_component_ids="";
		String   no_of_rows							=		request.getParameter("no_of_rows");
		
		if(no_of_rows==null) no_of_rows="";

			 

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		eCA.DomParser parser = new eCA.DomParser();
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" );
		String  locale = (String) p.getProperty("LOCALE");

		Hashtable htParameter=new Hashtable();

		String secHdgCode = request.getParameter("sec_hdg_code") == null ? "" : request.getParameter("sec_hdg_code");
		String subSecHdgCode = request.getParameter("sub_sec_hdg_code") == null ? secHdgCode :  request.getParameter("sub_sec_hdg_code");
		String closeFlag = request.getParameter("closeFlag") == null ? "N" :  request.getParameter("closeFlag");

		String close_episode_yn = request.getParameter("close_episode_yn") == null ? "" :  request.getParameter("close_episode_yn");
		String outcome_event_code = request.getParameter("outcome_event_code") == null ? "" :  request.getParameter("outcome_event_code");
		String outcome_code = request.getParameter("outcome_code") == null ? "" :  request.getParameter("outcome_code");
		String contentXML = "";

		
		//out.println("secHdgCode ="+secHdgCode+"=  subSecHdgCode="+subSecHdgCode+"=");
		Enumeration enumParameter=request.getParameterNames();
		String parameterName="";
		String parameterValue="";
			
		while(enumParameter.hasMoreElements())
		{
			parameterName=(String)enumParameter.nextElement();
			parameterValue = request.getParameter(parameterName) == null  ? "" : request.getParameter(parameterName);
			htParameter.put(parameterName, parameterValue);
			

		}
		
		if(tabClick.equals("Y") || tabClick.equals(""))
		{			

			if(!prevSecHdgCode.equals("") && !prevSubSecHdgCode.equals(""))
			{
				contentXML = (String)matBean.getSectionContent(prevSecHdgCode,prevSubSecHdgCode);

			}

			StringBuffer xmlContent = new StringBuffer();
			StringBuffer sectionContentXML = new StringBuffer();
			
			try
			{
				con = ConnectionManager.getConnection(request);

				if(contentXML == null || contentXML.equals("") || contentXML.equals(" "))
				{
					pstmt = con.prepareStatement(" Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code = ? ");				
				
					if(prevSubSecHdgCode.equals("") )
						pstmt.setString	(1,subSecHdgCode);
					else
						pstmt.setString	(1,prevSubSecHdgCode);

					res = pstmt.executeQuery();
					if(res.next())
					{
						ageDependentCompIds = res.getString("AGE_GRP_DEP_COMP_INFO") == null ? "" : res.getString("AGE_GRP_DEP_COMP_INFO");
						compDependentAgeGrps = res.getString("DEP_AGE_GRP_INFO") == null ? "" : res.getString("DEP_AGE_GRP_INFO");
						Clob tmplFormat = res.getClob("TEMPLATE_FORMAT");

						if(tmplFormat != null)
						{

							/*java.io.Reader r = tmplFormat.getCharacterStream();
							char sbuf[] = new char[255];
							int i=0;
							while((i = r.read(sbuf)) != -1) */
							java.io.BufferedReader r = new java.io.BufferedReader(tmplFormat.getCharacterStream());
							String line = null;

							while((line=r.readLine()) != null) 
							{
								//xmlContent.append(sbuf,0,i);
								xmlContent.append(line);
							}
						}
					}//end of if - 1
				
					if(res != null) res.close();
					if(pstmt != null) pstmt.close();

					PreparedStatement psAge = null;
					ResultSet rsAge = null;

					if(!ageDependentCompIds.equals(""))
					{
						psAge =con.prepareStatement("Select ca_comp_visibility(?,?) from dual");
						psAge.setString(1,compDependentAgeGrps);
						psAge.setString(2,patientId);
						rsAge = psAge.executeQuery();
						
						if(rsAge.next())
						{
							ageDependentResults = rsAge.getString(1);
							eCA.AgeGroupCodeDependencyParser ageGroupBeanObj=new eCA.AgeGroupCodeDependencyParser();
							xmlContent = ageGroupBeanObj.removeAgeDependentComponents(xmlContent,ageDependentCompIds,ageDependentResults);
						}
						
						if(rsAge!=null) rsAge.close();
						if(psAge!=null) psAge.close();
					}//end f if ageDependentCompIds

					contentXML = xmlContent.toString();
					
				}//end of if contentXML

				//out.println("contentXML ="+contentXML+"=");
				//sectionContentXML.append(contentXML);
				//out.println("sectionContentXML ="+sectionContentXML.toString()+"=");
//				String tempStr = (String) matBean.getSectionContent(prevSecHdgCode,prevSubSecHdgCode);

				 if(!grid_component_ids.equals(""))
				{	
					 
					eCA.GridComponent gridComp = new eCA.GridComponent();			
					contentXML = gridComp.updateXML(no_of_rows, contentXML).toString();			
					gridComp = null;
				}

				sectionContentXML.append(contentXML);	

				//out.println("sectionContentXML later ="+sectionContentXML.toString()+"=");

				StringBuffer sectionContentUpdatedXML=new StringBuffer();
				if(!sectionContentXML.toString().equals("")&&!sectionContentXML.toString().equals(" "))
				{
					//***************************** [CRF-118] Start *****************************					
					eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
					HashMap paramHash=new HashMap();
					Hashtable tempParameter=new Hashtable();
					paramHash.put("#p_patient_id#",patientId);
					paramHash.put("#p_encounter_id#",encounter_id);
					paramHash.put("#p_accNum#",accessionNum);
					paramHash.put("#p_locale#",locale);
					tempParameter = dynamicCompDetails.getDynamicCompDetails(sectionContentXML,paramHash);
					if(tempParameter.size()>0){					
					htParameter.putAll(tempParameter);
					}
					//*****************************[CRF-118] Ends *****************************
					sectionContentUpdatedXML=parser.updateXMLContentValues(sectionContentXML,htParameter,locale);

					parser=null;
					if(!prevSecHdgCode.equals("") && !prevSubSecHdgCode.equals(""))
					{
						
		//				matBean.setSectionValues(prevSecHdgCode,prevSubSecHdgCode,"","","","","","", "","", sectionContentUpdatedXML.toString(), "");
						matBean.setSectionContent(prevSecHdgCode,prevSubSecHdgCode,sectionContentUpdatedXML.toString());
					}
					putObjectInBean("matBean",matBean,session);
				}
				//tempStr = (String) matBean.getSectionContent(prevSecHdgCode,prevSubSecHdgCode);
			}//end of try
			catch(Exception e)
			{
				e.printStackTrace();
				
				//out.println("Exception in try of RecMaternityConsControl.jsp --"+e.toString());//COMMON-ICN-0181			
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
		}//end of if tabClick
		else
		{
			if(!closeFlag.equals("Y"))
				{
				contentXML = (String)matBean.getSectionContent(secHdgCode,subSecHdgCode);

				StringBuffer sectionContentXML = new StringBuffer();
				
				 if(!grid_component_ids.equals(""))
				{
					eCA.GridComponent gridComp = new eCA.GridComponent();			
					contentXML = gridComp.updateXML(no_of_rows, contentXML).toString();
					gridComp = null;
				}

				sectionContentXML.append(contentXML);
				StringBuffer sectionContentUpdatedXML=new StringBuffer();
			
				if(!sectionContentXML.toString().equals("")&&!sectionContentXML.toString().equals(" "))
					{

						sectionContentUpdatedXML=parser.updateXMLContentValues(sectionContentXML,htParameter,locale);
						parser=null;
						matBean.setSectionContent(secHdgCode,subSecHdgCode,sectionContentUpdatedXML.toString());
						putObjectInBean("matBean",matBean,session);
					}
				
				}
		}
	%>
	<body onKeyDown='lockKey()'>
		<form name='RecMaternityControlForm' id='RecMaternityControlForm' method='post'>
			<input type='hidden' name='prevSecHdgCode' id='prevSecHdgCode' value='<%=prevSecHdgCode%>'>

		</form>
	</body>
</html>
<script>
if('<%=tabClick%>' == 'Y' || '<%=tabClick%>' == '')
{
	if('<%=modeValue%>'=='V')
	{		
		parent.recMatConsDetailsFrame.location.href = '../../eCA/jsp/RecMaternityConsView.jsp?<%=request.getQueryString()%>';
	}
	else
	{		
		parent.recMatConsDetailsFrame.location.href = '../../eCA/jsp/RecMaternityConsDetailPage.jsp?<%=request.getQueryString()%>';
	}
}
else
{	
	if('<%=closeFlag%>' == 'Y')
	{
	//parent.recMatConsDetailsFrame.location.href = '../../eCA/jsp/RecMaternityConsDetailPage.jsp?<%=request.getQueryString()%>';
	//setTimeout('',3000);
	//alert("page loaded..."+parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.closeFlag.value);

//	htmlVal = "<html><form name='tempForm' id='tempForm' enctype='multipart/form-data' action='../../servlet/eCA.RecMaternityConsServlet?<%=request.getQueryString()%>' method='post'><input type='hidden' name='closeFlag' id='closeFlag' value='<%=closeFlag%>'><input type='hidden' name='close_episode_yn' id='close_episode_yn' value='<%=close_episode_yn%>'><input type='hidden' name='outcome_event_code' id='outcome_event_code' value='<%=outcome_event_code%>'><input type='hidden' name='outcome_code' id='outcome_code' value='<%=outcome_code%>'></form></html>";
	htmlVal = "<html><form name='tempForm' id='tempForm' enctype='multipart/form-data' action='../../servlet/eCA.RecMaternityConsServlet?moduleId=<%=moduleId%>&patientId=<%=patientId%>&sectionType=<%=sectionType%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splty_event_code%>&splty_task_code=<%=splty_task_code%>&accessionNum=<%=accessionNum%>&closeFlag=<%=closeFlag%>&close_episode_yn=<%=close_episode_yn%>&outcome_event_code=<%=outcome_event_code%>&outcome_code=<%=outcome_code%>' method='post'></form></html>";
		parent.recMatConsBlankFrame.document.write(htmlVal);
		parent.recMatConsBlankFrame.document.tempForm.submit();
	
	}
	//parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.closeFlag.value='<%=closeFlag%>';	
	//parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.close_episode_yn.value='<%=close_episode_yn%>';	
	//parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.outcome_event_code.value='<%=outcome_event_code%>';	
	//parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.outcome_code.value='<%=outcome_code%>';	
 else {
	// alert("In closeFlag Else ");
parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.action='../../servlet/eCA.RecMaternityConsServlet';
	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.target='messageFrame';
	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.method='post';
	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.submit();
 }
}
</script>

