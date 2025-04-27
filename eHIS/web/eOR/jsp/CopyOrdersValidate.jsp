
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <jsp:useBean id="beanObj" scope="page" class="eOR.ExistingOrder"/>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	 request.setCharacterEncoding("UTF-8");

	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String localeName = request.getParameter("localeName");
      beanObj.setLanguageId(localeName);
	//String practitioner_id 	= (String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id"); //--[IN029659]
	//String resp_id 			= (String)session.getValue("responsibility_id");

	//String xmlStr			= "'";
    StringBuffer xmlStr			= new StringBuffer();
	xmlStr.append("'");
    String errorMessage		= "";

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	//ExistingOrder beanObj = (ExistingOrder)mh.getBeanObject( bean_id, request , "eOR.ExistingOrder") ;
	//ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id,  "eOR.ExistingOrder", request ) ;
	Properties properties			= (Properties) session.getValue( "jdbc" );

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	//--[IN029659] - start
	String patientId 				= (String)hash.get("patientId");
	String encounterId 				=  (String)hash.get("encounterId");
	String patientClass 				=  (String)hash.get("patientClass");
	String Adv_date = 				(String)beanObj.getDischargeAdvDateTime(patientId, encounterId);
	String[] Dis_dtl = new String[2] ;
	Dis_dtl = 				beanObj.getDischargeDateTime(patientId, encounterId);
	
	//--[IN029659] - end
    if ( validate.equals( "patient_class" ) ) {
		out.println( "clearPatientClassList('document') ; " ) ;
        ArrayList PatientClass = new ArrayList();
		//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
		PatientClass = beanObj.getPatientClass(properties);

		for( int i=0 ; i< PatientClass.size() ; i++ ) {
			String[] record = (String[])PatientClass.get(i);
			out.println( "addPatientClassList(\"" + record[0] + "\",\"" + record[1] +  "\") ; " ) ;
		}
	}  else if (validate.equals("order_line_num")) {
		int totCount			= 0;
		int count				= Integer.parseInt(beanObj.checkForNull((String)hash.get("count"),"0"));
		String catelogStr		= "~";
		
		for (int j = 0;j < count;j++) 
		{
			String order_id 		= (String)hash.get("order_id"+j);
			String order_category	= (String)hash.get("order_category"+j);
			String order_type_code	= (String)hash.get("order_type_code"+j);
			String ord_cat_chk      = (String)beanObj.getCategoryChk(order_category, facility_id, encounterId, patientClass, Dis_dtl[0], Dis_dtl[1], Adv_date); //--[IN029659]
			
			//String xmlStr			= "'";
			if(ord_cat_chk == "" || ord_cat_chk == null)
			{
				//errorMessage	= "CONFIRM_COPY";
			} 
			else
			{
				ArrayList orderLineData	= new ArrayList();
				orderLineData			= beanObj.getOrderLineData(properties,order_id);
				for (int i = 0; i < orderLineData.size();i++) 
				{
					String [] record 	= (String[])orderLineData.get(i);
					if (catelogStr.indexOf("~"+record[1]+"~") != -1) 
					{
						errorMessage	= "DUPLICATE_ORDERABLES";
						//errorMessage	= "APP-OR0206 Orderables cannot be Duplicate";
						break;
					}
					//catelogStr += record[1] + "~";
					catelogStr =catelogStr+record[1] + "~";
					/*xmlStr += "order_id"+(totCount+i)+"=\""+ order_id +"\" " ;
					xmlStr += "order_line_num"+(totCount+i)+"=\""+ record[0] +"\" " ;
					xmlStr += "catalog_code"+(totCount+i)+"=\""+ record[1] +"\" " ;
					xmlStr += "order_category"+(totCount+i)+"=\""+ order_category +"\" " ;
					xmlStr += "order_type_code"+(totCount+i)+"=\""+ order_type_code +"\" " ;*/
					xmlStr.append("order_id"+(totCount+i)+"=\""+ order_id +"\" ");
					xmlStr.append("order_line_num"+(totCount+i)+"=\""+ record[0] +"\" ");
					xmlStr.append("catalog_code"+(totCount+i)+"=\""+ record[1] +"\" ");
					xmlStr.append("order_category"+(totCount+i)+"=\""+ order_category +"\" ");
					xmlStr.append("order_type_code"+(totCount+i)+"=\""+ order_type_code +"\" ");
				
				}
				//totCount += orderLineData.size();
				totCount =totCount+orderLineData.size();
			}
		}
		if(totCount == 0)
			errorMessage	= "CONFIRM_COPY"; //--[IN029659]
		out.println("totCountGlobal = "+totCount+";");
		out.println("errorMessage = \"" + errorMessage + "\";");
		out.println("xmlStr = " + xmlStr.toString()+"';");
	} else if (validate.equals("diag")) {
		String patient_id = (String)hash.get("patientId");
		ArrayList diagData	= new ArrayList();
		out.println( "clearDiagList('document') ; " ) ;
		diagData			= beanObj.getDiagnosisSpecific(properties, patient_id);

		for (int i = 0; i < diagData.size();i++) {
			String [] record	= (String[])diagData.get(i);
			out.println( "addDiagList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	} else if (validate.equals("diag_desc")) {
		String diag_code= beanObj.checkForNull(request.getParameter( "diag_code" ),"") ;
		String diag_desc		= beanObj.getDiagnosisDesc(properties, diag_code) ;
		if(diag_desc!=null)
			out.println( "addCareSetDiagnosisDesc('document.copy_orders_search',\"" +diag_desc+" \") ; " ) ;
	} //--[IN029659]-Start
	else if (validate.equals("order_line"))  
	{
		int totCount			= 0;
		int count				= Integer.parseInt(beanObj.checkForNull((String)hash.get("count"),"0"));
		
		String catelogStr		= "~";
		
		for (int j = 0;j < count;j++) 
		{
			String order_id 		= (String)hash.get("order_id"+j);
			String order_category	= (String)hash.get("order_category"+j);
			String order_type_code	= (String)hash.get("order_type_code"+j);
			String order_line_num	= (String)hash.get("order_line_num"+j);
			String catalog_code		= (String)hash.get("catalog_code"+j);
			String ord_cat_chk      = (String)beanObj.getCategoryChk(order_category, facility_id, encounterId, patientClass, Dis_dtl[0], Dis_dtl[1], Adv_date);
			
			if(ord_cat_chk == "" || ord_cat_chk == null)
			{
			//	errorMessage	= "CONFIRM_COPY";
			
			}
			else
			{
				catelogStr =catelogStr+catalog_code + "~";
				xmlStr.append("order_id"+(totCount)+"=\""+ order_id +"\" ");
				xmlStr.append("order_line_num"+(totCount)+"=\""+ order_line_num +"\" ");
				xmlStr.append("catalog_code"+(totCount)+"=\""+ catalog_code +"\" ");
				xmlStr.append("order_category"+(totCount)+"=\""+ order_category +"\" ");
				xmlStr.append("order_type_code"+(totCount)+"=\""+ order_type_code +"\" ");
				totCount =totCount+1;
			}
		}
		if(totCount == 0)
			errorMessage	= "CONFIRM_COPY";
		out.println("totCountGlobal = "+totCount+";");
		out.println("errorMessage = \"" + errorMessage + "\";");
		out.println("xmlStr = " + xmlStr.toString()+"';");

	} //--[IN029659] - end

	//putObjectInBean(bean_id,beanObj,request);
%>
