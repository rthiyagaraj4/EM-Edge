 <%-- saved on 30/12/2009 --%>

<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*" contentType="text/html;charset=ISO-8859-1 " %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	try {
		String func_mode			= request.getParameter("func_mode");
		String bean_id				=  request.getParameter("bean_id");
		String bean_name			=  request.getParameter("bean_name");
//		String locale = request.getParameter("locale");
		String locale = (String)session.getAttribute("LOCALE");
		//String func_mode = request.getParameter("bean_name");
		
		
		

		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		

		if(func_mode!= null && func_mode.equals("populateDispLocs"))
		{
			SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request ) ;
			bean.setLanguageId(locale);
			String facility_id     =  request.getParameter("facility_id");
						
			out.println("clearList()");
			ArrayList dispLocs = (ArrayList) bean.getDispLocnList(facility_id);	
			out.println("addOption('','A')");
			for(int i=0;i<dispLocs.size();i=i+2){
				
				 //Added code for  replacing spaces in Displocs for the incident num 23336 in spira on 31/Aug/2010
				String displocation=(String)dispLocs.get(i+1)==null?"":(String)dispLocs.get(i+1);	
				displocation=displocation.replaceAll(" ","%20");
				displocation=java.net.URLEncoder.encode(displocation,"UTF-8");
				displocation=displocation.replaceAll("%2520","%20");			
			out.println("addOption('"+dispLocs.get(i)+"','"+displocation+"')");
			}
			putObjectInBean(bean_id, bean, request);
		} 
		else if(func_mode!= null && func_mode.equals("populateDispLocsByLocationType"))
		{
			String facility_id     =  request.getParameter("facility_id");
			String disp_locn_type  =  request.getParameter("disp_locn_type");	
			SRRPHDrugUsageByPractBean bean= (SRRPHDrugUsageByPractBean)getBeanObject( bean_id, bean_name,request ) ;
			out.println("clearList()");
			ArrayList dispLocs = (ArrayList) bean.getDispLocnList(facility_id,disp_locn_type);
			out.println("addOption('','A')");
			for(int i=0;i<dispLocs.size();i=i+2){
				 //Added code for  replacing spaces in Displocs for the incident num 23698 in spira on 08/SEpt/2010
				String displocation1=(String)dispLocs.get(i+1)==null?"":(String)dispLocs.get(i+1);	
				displocation1=displocation1.replaceAll(" ","%20");								
				displocation1=java.net.URLEncoder.encode(displocation1,"UTF-8");		
				displocation1=displocation1.replaceAll("%2520","%20");			//ends		
				out.println("addOption('"+dispLocs.get(i)+"','"+displocation1+"')");
			}
			putObjectInBean(bean_id, bean, request);
		} 
		else if(func_mode!= null && func_mode.equals("populateFillProcIDs")){
			String p_fill_proc_type		= (String) hash.get( "p_fill_proc_type" );
			String p_fill_proc_dt		= (String) hash.get( "p_fill_proc_dt" );
			String process_id			=	"";
			SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request ) ;
			bean.setLanguageId(locale);
			ArrayList fill_process_id		=	bean.loadFillProcessID(p_fill_proc_type,p_fill_proc_dt);
			
			for(int i=0; i<fill_process_id.size(); i++)	{
				process_id	=	(String)fill_process_id.get(i);		
				out.println("addList('"+process_id+"')");
			}
			putObjectInBean(bean_id, bean, request);
		}
		else if(func_mode!= null && func_mode.equals("populateDispLocs1")){
			String facility_id     =  request.getParameter("facility_id");
			//String disp_locn_type  =  request.getParameter("disp_locn_type");	
			SRRPHDrugUsageByPractBean bean= (SRRPHDrugUsageByPractBean)getBeanObject( bean_id, bean_name,request ) ;
			out.println("clearList()");
			ArrayList dispLocs = (ArrayList) bean.getDispLocnList(facility_id);
			out.println("addOption('','A')");
			for(int i=0;i<dispLocs.size();i=i+2){
				//Added code for  replacing spaces in Displocs   on 01/Oct/2010 ===By Sandhya
				String displocation2=(String)dispLocs.get(i+1)==null?"":(String)dispLocs.get(i+1);	
				displocation2=displocation2.replaceAll(" ","%20");
				displocation2=java.net.URLEncoder.encode(displocation2,"UTF-8");
				displocation2=displocation2.replaceAll("%2520","%20");			//ends
				out.println("addOption('"+dispLocs.get(i)+"','"+displocation2+"')");
			}
			putObjectInBean(bean_id, bean, request);
		} 
		else if(func_mode!= null && func_mode.equals("populateEventType")){
			String hypersensitivity = request.getParameter("hypersensitivity");
			SRRPHDrugUsageByPractBean bean= (SRRPHDrugUsageByPractBean)getBeanObject( bean_id, bean_name,request ) ;
			out.println("clearList_eventType()");
			ArrayList eventType = (ArrayList) bean.getEventTypeList(hypersensitivity);
			out.println("addOption_eventType('','A')");
			for(int i=0;i<eventType.size();i=i+2){
				out.println("addOption_eventType('"+eventType.get(i)+"','"+eventType.get(i+1)+"')");
			}
			putObjectInBean(bean_id, bean, request);
		}
		
	else if(func_mode.equals("CALLPATIENT")){
		ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
		String patient_id			= request.getParameter("patient_id");
		bean.setLanguageId(locale);
	    ArrayList patientdetails = bean.getPatientDetails(patient_id);
		
			if(patientdetails.size()!=0)
			{
				 String p_name=(String)patientdetails.get(0)==null?"":(String)patientdetails.get(0);
				 //Added code for  replacing spaces in Patien name for the incident num 23230 in spira on 11/Aug/2010.
				p_name=p_name.replaceAll(" ","%20");
				p_name=java.net.URLEncoder.encode(p_name,"UTF-8");
				p_name=p_name.replaceAll("%2520","%20");				
				out.println("assignPatientLine(\""+p_name+"\")");
			}
			putObjectInBean(bean_id, bean, request);
		}
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
