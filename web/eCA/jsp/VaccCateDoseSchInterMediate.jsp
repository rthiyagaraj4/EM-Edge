<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
----------------------------------------------------------------------------------------------------------------------------------------
18/05/2023       41653             Twinkle Shah     18/05/2023     M.f.mohamed Ali           Commented for Non-Linked issue against MMS-JU-CRF-0015.3
------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCA.*, webbeans.eCommon.MessageManager" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try 
	{
		request.setCharacterEncoding("UTF-8");		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String callFrom =(String) hash.get("CallFrom");
		Properties properties = (Properties) session.getAttribute("jdbc") ;
		String locale = (String) properties.getProperty("LOCALE");
		
		/*if(callFrom.equals("VaccineScheduleDose"))
		{
			
		}else{*/
			VaccineForCategoryBean vaccineBean = (VaccineForCategoryBean)getObjectFromBean("vaccinebean","eCA.VaccineForCategoryBean",session);		

			if(callFrom.equals("VaccineScheduleDose"))
			{		
				String vaccineId =(String) hash.get("vaccineId");
				String duplicateYN =(String) hash.get("duplicateYN");
				String duplicateDays =(String) hash.get("duplicateDays");
//				String duplicateAction =(String) hash.get("duplicateAction");
				String isAdhocAgeSpec =(String) hash.get("isAdhocAgeSpec");
				String categoryId =(String) hash.get("categoryId");
				int doseCnt = Integer.parseInt((String) hash.get("rowCount"));		
				
				
				hash.remove("vaccineId");
				hash.remove("rowCount");
				hash.remove("CallFrom");
				hash.remove("duplicateYN");
				hash.remove("duplicateDays");
				hash.remove("duplicateAction");
				hash.remove("isAdhocAgeSpec");
				hash.remove("categoryId");

				String retMsg = vaccineBean.setVaccnieSchedule(vaccineId, doseCnt, hash, duplicateYN, duplicateDays, isAdhocAgeSpec, categoryId);
				
				
				if(retMsg != null && retMsg.equals("DUPLICATE_CHECK"))
				{
					//out.println("alert(getMessage('VACCINE_ALLREADY_DEFINED','CA'))");
					vaccineBean.removeVaccineSchedule(vaccineId);
					out.println("DUPLICATE_CHECK");
					
				}
			}
			else if(callFrom.equals("clearScheduleVaccineDose"))
			{		
				//vaccineBean = new VaccineForCategoryBean();
				vaccineBean.clearVaccineBean();	

				
				out.println("var categoryId = document.vaccinesForCategoryHeaderForm.categoryCode.value;");			
				out.println("parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';");
				out.println("parent.VaccinesForCategoryMiddleFrame.location.href='../../eCA/jsp/VaccinesForCategoryList.jsp?categoryId='+categoryId");
				out.println("parent.VaccinesForCategorySearchFrame.location.href='../../eCA/jsp/VaccinesForCategorySearch.jsp'");
				out.println("parent.VaccinesForCategoryBottomFrame.location.href='../../eCA/jsp/VaccinesForCategoryDtl.jsp?categoryId='+categoryId");
			}
			else if(callFrom.equals("checkVacccineSchedules"))
			{
				
				String vaccineCnt =(String) hash.get("vaccineCnt")==null?"":(String) hash.get("vaccineCnt");
				String categoryId =(String) hash.get("categoryId")==null?"":(String) hash.get("categoryId");
				hash.remove("vaccineCnt");
				hash.remove("categoryId");
				hash.remove("checkVacccineSchedules");
				vaccineCnt = vaccineCnt.equals("")?"0":vaccineCnt;
				int vaccCnt = Integer.parseInt(vaccineCnt);
				
				
				
				vaccineBean.setSelectedVaccineList(hash, vaccCnt);	
				boolean isAdhoc =  vaccineBean.isAdhocCategory(categoryId);

				if(isAdhoc)
				{		
					String facilityId = (String) session.getAttribute("facility_id") ;
					vaccineBean.insertOrUpdate(categoryId, properties, facilityId);
					Hashtable tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
					String errorMsg = (String) tabdata.get("message");
					out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=1'");
				}else
				{
					List<String> notScheduleVaccLst = vaccineBean.checkAllSelectedVaccineAreScheduled(locale);

					if(notScheduleVaccLst == null)
					{
						String facilityId = (String) session.getAttribute("facility_id") ;						
						vaccineBean.insertOrUpdate(categoryId, properties, facilityId);
						Hashtable tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
						String errorMsg = (String) tabdata.get("message");
						out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=1'");
					}
					else if(notScheduleVaccLst != null)
					{
						String notSchVaccStr = "";
						for(String str : notScheduleVaccLst)
						{
							String []st = str.split("`~");
							String doseErr = "";
							if(st != null && st.length >1)
							{
								str = st[0].trim();
								doseErr = st[1]==null?"":st[1];

							}
							if(notSchVaccStr.equals(""))
							{
								notSchVaccStr = vaccineBean.getVaccineList().get(str) + doseErr;
							}
							else
							{
								notSchVaccStr = notSchVaccStr + ", "+vaccineBean.getVaccineList().get(str) + doseErr;
							}
							
						}
						Hashtable tabdata = MessageManager.getMessage(locale, "VACC_FREQ_NOT_EMPTY","CA");
						String errorMsg = (String) tabdata.get("message");
						errorMsg = errorMsg.replace("$$", notSchVaccStr);
						out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"'");
					}
				}	
			}
			else if(callFrom.equals("RemoveVaccineFormSchedule"))
			{
				String vaccineId =(String) hash.get("vaccineId");
				String categoryId =(String) hash.get("categoryId");
				vaccineBean.removeVaccineList(vaccineId);
				vaccineBean.removeSelectedVaccineList(vaccineId);				
				vaccineBean.deleteVaccineFromSchedule(categoryId, vaccineId);
				vaccineBean.removeVaccineSchedule(vaccineId); //41653	
			}
			else if(callFrom.equals("AddVaccineToSchedule"))
			{
				String vaccineId =(String) hash.get("vaccineId");
				String vaccDesc =(String) hash.get("vaccineDesc");
				vaccineBean.removeVaccineList(vaccineId);
				vaccineBean.setVaccine(vaccineId, vaccDesc);
			}
			else if(callFrom.equals("AddDoseNO"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String doseNo =(String) hash.get("doseNo");
				vaccineBean.setDoseNo(vaccineId, doseNo);
			}  
			else if(callFrom.equals("AddDLFTSite"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String DLFTSite =(String) hash.get("DLFTSite");
				vaccineBean.setDLFTSite(vaccineId, DLFTSite);
			}  
			else if(callFrom.equals("AddPrevAdminYN"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String prevAdminYN =(String) hash.get("prevAdminYN");
				vaccineBean.setChkPrevAdmin(vaccineId, prevAdminYN);
			}  
			else if(callFrom.equals("AddPrevDays"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String prevDays =(String) hash.get("prevDays");
				vaccineBean.setChkPrevDays(vaccineId, prevDays);
			}  
			else if(callFrom.equals("AddPrevAction"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String prevAction =(String) hash.get("prevAction");				
				vaccineBean.setChkPrevAction(vaccineId, prevAction);
			}  
			else if(callFrom.equals("RemoveVaccineFromSchedule"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				vaccineBean.removeVaccineSchedule(vaccineId);
			}  

			putObjectInBean("vaccinebean",vaccineBean,session);
		//}
	}catch(Exception e){
		e.printStackTrace();	
	}
%>	 
	 
