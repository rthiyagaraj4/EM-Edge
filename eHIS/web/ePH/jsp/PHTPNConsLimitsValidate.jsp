<%--corrected on 10/25/2005--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	try {		
		String bean_id				=	request.getParameter( "bean_id" ) ;
		String bean_name			=	request.getParameter( "bean_name" ) ;
		String ageGroupcode			=	request.getParameter( "ageGroupcode" ) ;
		String regimencode			=	request.getParameter( "regimen_code" ) ;
		String validate             =request.getParameter( "validate" ) ;
		Hashtable hash			= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash					= (Hashtable)hash.get( "SEARCH" ) ;
		
		TPNConsLimitsBean beanObj =null;
		beanObj		= (TPNConsLimitsBean)getBeanObject(bean_id,bean_name, request);
		String age_group_flag=beanObj.getAgegroupFlag(regimencode,ageGroupcode);
		String sel_gender="";
		String min_age_in_days="";
		String max_age_in_days ="";
		String overlapp_flag="";
		String mode="";
		ArrayList agegroup_values=new ArrayList();
		if ( validate.equals( "saveRemarks" ) ) {
			String row_no			 = request.getParameter("row_no");
		    String remarks			 = (String)hash.get("remarks");
		    beanObj.saveRemarks(row_no,remarks);
			putObjectInBean(bean_id,beanObj,request);
		    
	}
		
		else if ( validate.equals( "agegroup" ) ) {

		 if(age_group_flag.equals("Y")){
			mode="update";
		}
		else{
			mode="create";
			agegroup_values =beanObj.getAgeGroupDetails(ageGroupcode,regimencode);
			if(agegroup_values.size() >0){
				sel_gender = agegroup_values.get(0)==null?"":(String)agegroup_values.get(0);
				min_age_in_days =  agegroup_values.get(1)==null?"":(String)agegroup_values.get(1); 
				max_age_in_days = agegroup_values.get(2)==null?"":(String)agegroup_values.get(2);
				overlapp_flag=beanObj.getOverlappFlag(sel_gender,min_age_in_days,max_age_in_days,regimencode);
			   if(overlapp_flag.equals("Y")){
				out.println("ageGroupOverlapp('"+overlapp_flag+"');");
			    }
			}
		}
		out.println("constituentLimitsMode('"+mode+"','"+overlapp_flag+"','"+ageGroupcode+"');");
		putObjectInBean(bean_id,beanObj,request);
		 }
		

	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>
