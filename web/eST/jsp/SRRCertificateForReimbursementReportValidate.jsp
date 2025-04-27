 <%-- saved on 03/11/2005 --%>
<%@page  import="java.sql.*, java.util.*,java.text.DecimalFormat, java.io.*, eST.Common.*, ePH.*,eST.*,eST.Common.*,eOR.*,java.text.DecimalFormat" contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
try{

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String login_user       = (String)session.getValue("login_user");
		String facility    = (String)session.getValue("facility_id");

		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String validate             = request.getParameter("validate") ; 
		if(validate.equals("RECORDS_FOR_CERTIFREIMBURSEMENT")){

		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String doc_no			= hash.get( "doc_no" )==null?"":(String) hash.get( "doc_no" );
		String mode			=	 hash.get( "mode" )==null?"": (String) hash.get( "mode" );
		String p_store_code			=	 hash.get( "p_store_code" )==null?"": (String) hash.get( "p_store_code" );
	//	String checked_yn = hash.get( "checked_yn" ) == null?"":(String) hash.get( "checked_yn" ) ;
	//	String order_date="";
		SRRCertificateForReimbursementBean beanObj = (SRRCertificateForReimbursementBean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
	
		if (mode.equals("ADD_ELEMENT"))
		{
	        beanObj.setSelectedValue(doc_no);				

   		}else if(mode.equals("REMOVE_ELEMENT"))
		{
			beanObj.removeValue(doc_no);			
		}else if(mode.equals("ADD_ELEMENT_ALL"))
		{
			if(!doc_no.equals(""))
			{
			   if(doc_no.indexOf("~") > 0){
	
				String[] strArr = doc_no.split("~");
				for(int i=0;i<strArr.length;i++){
					beanObj.setSelectedValue(strArr[i]);	
				}
			}else{
	               beanObj.setSelectedValue(doc_no);				
        		}
			}
		}else if(mode.equals("REMOVE_ELEMENT_ALL"))
		{
			if(!doc_no.equals(""))
			{
                  if(doc_no.indexOf("~") > 0){
				String[] strArr = doc_no.split("~");
				for(int i=0;i<strArr.length;i++){
					beanObj.removeValue(strArr[i]);		
				  }
				}else{
			beanObj.removeValue(doc_no);			
     		}	
		  }
		}else if(mode.equals("PRINT_FOR_CERTIFREIMBURSEMENT")){
		ArrayList active_CertiforReimbursements		=	new ArrayList();
		String []record=new String[11];
		active_CertiforReimbursements	=	beanObj.getCertiforReimbursementRecds();
		for(int i=0;i<active_CertiforReimbursements.size();i++){
		record= (String[])active_CertiforReimbursements.get(i);


	if(record[6].equals("Y")){

    	ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport(facility,"ST","STCERTREIM_SRR") ;
		    
		report1.addParameter("P_REPORT_ID","STCERTREIM_SRR") ;
		report1.addParameter("p_user_name",login_user) ;
		report1.addParameter("P_FACILITY_ID",facility) ;
		report1.addParameter("p_module_id","ST") ;
		report1.addParameter("P_LANGUAGE_ID",locale);
		report1.addParameter("P_DOC_NO",record[2]) ;
		report1.addParameter("P_DOC_DATE",record[0]) ;
		report1.addParameter("P_STORE_CODE",p_store_code) ;
		report1.addParameter("P_REPRINT","Y");
		onlineReports.add(report1) ;
		String ReportOutput = onlineReports.execute(request,response );

		}  

	   }

      }else if(mode.equals("CLEAR")){

	        beanObj.clear();
	    }
		
        putObjectInBean(bean_id,beanObj,request);
      }
		}catch (Exception e) {
	out.println("alert(\"" + e + "\");") ;
	e.printStackTrace();
	}
	
		
%>
