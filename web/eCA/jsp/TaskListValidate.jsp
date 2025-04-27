<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name         Description
--------------------------------------------------------------------------------------------------------------
?             	100           		?           	created
09/01/2014	    IN045571		  Nijitha S	   TTM-SCF-0060
---------------------------------------------------------------------------------------------------------------
 */
%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCA.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<% /*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
31/05/2021      IN017999         Chandrashekar a    AAKH-CRF-0132.1
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter( "bean_id" )==null?"":request.getParameter( "bean_id" );
	String validate 		= request.getParameter( "validate" )==null?"":request.getParameter( "validate" );
	String flag				= request.getParameter("flag")==null?"":request.getParameter( "flag" );
	

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

		
	//String isRDInstalled_yn="";
	//String isOTInstalled_yn="";


	//String practitioner_id	= (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	//String resp_id 			= (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");	
	PatTaskListRepository beanObj = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);

	//beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	 if (flag == null || flag.equals("")) {
		  if ( validate.equals( "ord_cat" ) ) {
			 String order_cat = (String)hash.get("OrderCategory") ;			
			 if(order_cat==null || order_cat.equals("null") || order_cat.equals("") )
			  {
				 out.println( "clearOrderTValues('document');");
			  }
			  /* else if(order_cat.equalsIgnoreCase("OT"))
			  {					
					out.println( "clearOrderTValues('document');");
					String isOTInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"OT");
					out.println( "setOTvalue(\"" + isOTInstalled_yn+ "\") ; " ) ;
					if(isOTInstalled_yn.equalsIgnoreCase("Y"))
					{
						order_cat="";
					}
			  } */
			  else if(order_cat.equalsIgnoreCase("RD"))
			  {					
					out.println( "clearOrderTValues('document');");
					String isRDInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"RD");
					out.println( "setRDvalue(\"" + isRDInstalled_yn+ "\") ; " ) ;
					if(isRDInstalled_yn.equalsIgnoreCase("Y"))
					{
						order_cat="";
					}
			  }
			  else
			  {
					String c_OrderType = (String)hash.get("c_OrderType") ;
					
					ArrayList OrderTypeData = beanObj.getOrderType(property,order_cat) ;
					out.println( "clearOrderTValues('document');");
					for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
					{

						String[] record = (String[])OrderTypeData.get(i);
						
						
						String selected = "false";
						if(c_OrderType.equals(record[1])) selected="selected";
							out.println( "addOrderTypeList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
					}
				}
	 }
	 else if ( validate.equals( "save" ) ) {
		 //beanObj.putHashvalues("c_locn_desc",(String)hash.get("c_locn_desc")) ;//Commented for IN045571	
		 beanObj.putHashvalues("c_locn_desc",java.net.URLDecoder.decode((String)hash.get("c_locn_desc"),"UTF-8")) ;//IN045571	
		 beanObj.putHashvalues("c_location_type",(String)hash.get("c_location_type")) ;
		 beanObj.putHashvalues("c_locn_code",(String)hash.get("c_locn_code")) ;
		 beanObj.putHashvalues("c_patient_id",(String)hash.get("c_patient_id")) ;
		 beanObj.putHashvalues("c_status_code",(String)hash.get("c_status_code")) ;
		 beanObj.putHashvalues("c_taskSelect",(String)hash.get("c_taskSelect")) ;
		 beanObj.putHashvalues("c_OrderCategory",(String)hash.get("c_OrderCategory")) ;
		 beanObj.putHashvalues("c_OrderType",(String)hash.get("c_OrderType")) ;
		 beanObj.putHashvalues("c_Groupby",(String)hash.get("c_Groupby")) ;
		 beanObj.putHashvalues("c_To_date",(String)hash.get("c_To_date")) ;
		 beanObj.putHashvalues("c_From_date",(String)hash.get("c_From_date")) ;
		 beanObj.putHashvalues("c_pat_discharge",(String)hash.get("c_pat_discharge")) ;
		 beanObj.putHashvalues("c_onclickS",(String)hash.get("c_onclickS")) ;
		 beanObj.putHashvalues("c_clickdate",(String)hash.get("c_clickdate")) ;
		 beanObj.putHashvalues("c_search",(String)hash.get("c_search")) ;
		 beanObj.putHashvalues("c_patientname",(String)hash.get("c_patientname")) ;
		 beanObj.putHashvalues("c_chkAll",(String)hash.get("c_chkAll")) ;
		 beanObj.putHashvalues("c_ckhDue",(String)hash.get("c_ckhDue")) ;
		 beanObj.putHashvalues("c_chkOverdue",(String)hash.get("c_chkOverdue")) ;
		 beanObj.putHashvalues("c_chkElapsed",(String)hash.get("c_chkElapsed")) ;
		 beanObj.putHashvalues("c_chkPerformed",(String)hash.get("c_chkPerformed")) ;
		 beanObj.putHashvalues("c_chkReg",(String)hash.get("c_chkReg")) ;
		 beanObj.putHashvalues("c_chkFuture",(String)hash.get("c_chkFuture")) ;
		 beanObj.putHashvalues("c_taskListFlag",(String)hash.get("c_taskListFlag")) ;
		 beanObj.putHashvalues("c_taskSelectAll",(String)hash.get("c_taskSelectAll")) ;
		 beanObj.putHashvalues("c_chkUnclassify",(String)hash.get("c_chkUnclassify")) ;
		 
	}
	else if(validate.equals("definition"))
	{
		String definition = (String)hash.get("definition");
		if(definition==null || definition.equals("null") || definition.equals("") )
		{
			out.println( "clearIntervention('document');");
		}
		else
		{
			ArrayList InterventionData = beanObj.getInterventionType(property,definition) ;
			
			out.println( "clearIntervention('document');");
			for( int i=0 ; i< InterventionData.size() ; i++ ) 
			{
				String[] record = (String[])InterventionData.get(i);
				out.println( "addInterventionType(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
		}

	}else if(validate.equals("encounter_list"))//Added function for IN017999
	{
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String sel_encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		
			ArrayList EncounterList = beanObj.getEncounterList(patient_id) ;
						//System.err.println("EncounterList @@@==="+EncounterList);
			
			out.println( "clearEncounterList('document');");
			for( int i=0 ; i< EncounterList.size() ; i++ ) 
			{
				String encounter_id = (String)EncounterList.get(i);
				out.println( "addEncounterList(\"" + encounter_id + "\",\""+sel_encounter_id+"\") ; " ) ;
			}
		

	}

	 }%>
	 <%putObjectInBean("patTask",beanObj,request);%>	 
	 
