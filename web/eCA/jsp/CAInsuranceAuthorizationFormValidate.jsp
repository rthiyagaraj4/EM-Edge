<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
12/11/2018  IN059704        PRATHYUSHA   12/11/2018          Ramesh G      AAKH-CRF-0079.2										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*,eCommon.Common.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String identity   = request.getParameter( "identity" )==null?"": request.getParameter( "identity" );
	String bean_id="CAInsurenceAuthorizationFormsBean";
	String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
	System.out.println("POPULATEENCOUNTERFOROP");
	CAInsurenceAuthorizationFormsBean bean = (CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;
	
		  
	 if(identity.equals("POPULATEENCOUNTERFOROP")){ 
		String patient_id	= request.getParameter( "patient_id" ) ;
		String facility_id=(String) session.getAttribute("facility_id");
			System.out.println("POPULATEENCOUNTERFOROP"+patient_id);
		ArrayList encounterDetails = bean.getEncounterIdDetails(patient_id,facility_id) ;	
		System.out.println("encounterDetails"+encounterDetails);
		out.println("clearData('document.formClaimFormsCriteria.encounterId');") ;
		if(encounterDetails.size() <= 0){
			out.println("addEncounter('',' ---Select---','document.formClaimFormsCriteria.encounterId');");
		}
		else {	
			for(int i=0; i<encounterDetails.size(); i++) {			
				out.println("addEncounterDefault('"+ encounterDetails.get(i) + "', '" + encounterDetails.get(i) +"', 'document.formClaimFormsCriteria.encounterId','');") ;			
			}
		}
	} 
	
		
	
%>
