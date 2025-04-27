
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/05/2018	IN066237	   Prakash C 		08/05/2018		Ramesh G			MMS-DM-CRF-0123
19/06/2018	IN067981	   Prakash C 		19/06/2018		Ramesh G			CA-MMS-DM-CRF-0123/01
26/2/2021	TFS15204		   Ramesh Goli		26/2/2021		Ramesh G			COMMN-ICN-0026
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.*"%>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% 
	request.setCharacterEncoding("UTF-8");

	try{
		String bean_id = "Ca_CAMenuDetailsBean" ;
		String bean_name = "eCA.CAMenuDetailsBean";
		CAMenuDetailsBean bean = (CAMenuDetailsBean)getBeanObject( bean_id, bean_name , request ) ;
		String mode	   = "1";
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String summaryId				= (String)hash.get("summ_id");
		String desktopId				= (String)hash.get("desktopID");
		String resp_id		= (String)session.getValue("responsibility_id");
		String pract_id		= (String)session.getValue("ca_practitioner_id");
		String facility_id=(String) session.getValue("facility_id");
		
		int count=0;
		String desktopFunctionID="";
		String summarySubHrd="";
		String summ_hrd_bg="";
		String count_result="";
		String summcompid="";
		
		ArrayList result =new ArrayList();
		
			if("HPC_NT_RVP".equals(summaryId)){ //51215
				result = (ArrayList)bean.selfNotesCount(summaryId,desktopId,resp_id,pract_id,facility_id);
				if(result.size()>0){	//TFS15204
		 		summcompid=(String)result.get(0);
				desktopFunctionID=(String)result.get(1);
				summarySubHrd=(String)result.get(2);
				summ_hrd_bg=(String)result.get(3);
				count_result	 = (String)result.get(4);
				count = Integer.parseInt(count_result);
				}  //TFS15204
				if(count!=0)
				{
			 		out.println(summcompid+"|<a  href='"+desktopFunctionID+"'  onclick=\"loadTitleName('"+summarySubHrd+"')\" title='"+summarySubHrd+"' target=\"workAreaFrame\" >"+summ_hrd_bg+"("+count+")</a>");
				}//IN067981 starts
				else{
					out.println(summcompid+"|"+summ_hrd_bg+"("+count+")");
				}
				//IN067981 ends
				//51215 Start.
			}else if("HPC_PL_OP".equals(summaryId)){
				int totalNotifCount=0;
				int c4cstatuCount =0;
				result = (ArrayList)bean.outPatientCount(summaryId,desktopId,resp_id,pract_id,facility_id);
				if(result.size()>0){	
					summcompid=(String)result.get(0);
					desktopFunctionID=(String)result.get(1);
					summarySubHrd=(String)result.get(2);
					summ_hrd_bg=(String)result.get(3);
					count_result	 = (String)result.get(4);
					count = Integer.parseInt(count_result);
					c4cstatuCount= Integer.parseInt((String)result.get(5));
				}  
				String responString="";
				if(count!=0)
				{
					responString=summcompid+"|<a  href='"+desktopFunctionID+"'  onclick=\"loadTitleName('"+summarySubHrd+"')\" title='"+summarySubHrd+"' target=\"workAreaFrame\" >"+summ_hrd_bg+"("+count+")</a>";
				}
				else{
					responString=summcompid+"|"+summ_hrd_bg+"("+count+")";
				}
				totalNotifCount=bean.getC4CNofication(pract_id,facility_id);
				responString=responString+"|"+totalNotifCount+"|"+c4cstatuCount;
				
				out.println(responString);
			}
			//51215 End.
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	
%>
