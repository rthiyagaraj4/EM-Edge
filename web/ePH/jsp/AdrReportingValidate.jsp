 <%@page import="java.util.*,java.io.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	    request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
	    Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		

	   String bean_id		= request.getParameter( "bean_id" ) ;
	   String bean_name		= request.getParameter( "bean_name" ) ;
	   String patient_id	= request.getParameter( "patient_id" ) ;
	   String validate		= request.getParameter("validate");
	   String facility_id   = (String)session.getValue("facility_id" );
	   String login_user	= (String)session.getValue("login_user");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	if(validate.equals("CALLPATIENT")){
	    ArrayList patientdetails = bean.getPatientDetails(patient_id);
		
			if(patientdetails.size()!=0)
			{
				 String p_name=(String)patientdetails.get(0);
				 String p_age  = (String)patientdetails.get(1);
				 String p_sex  = (String)patientdetails.get(2);
				 out.println("assignPatientLine(\""+p_name+"\",'"+p_age+"','"+p_sex+"');") ;
			}
		} else if(validate.equals("DOSAGEDETAILS"))	{
			String adminsteredDate	=	request.getParameter("administeredDate");
			adminsteredDate			=	com.ehis.util.DateUtils.convertDate(adminsteredDate,"DMYHM",locale,"en");
			String orderId			=	request.getParameter("orderId");
			String orderlineno		=	request.getParameter("orderline");
			ArrayList dosageDetails	=	bean.loadDosageDetails(patient_id,orderId,orderlineno,adminsteredDate);
			
			if(dosageDetails.size()>0 ){
				for(int i=0;i<dosageDetails.size();i++){
					out.println("displayDosageDetails('"+(String)dosageDetails.get(i)+"','"+i+"')");
				}
			}else{
				for(int i=0;i<6;i++){
					out.println("displayDosageDetails('','"+i+"')");
				}
			}
		}else if(validate.equals("ONSETREACTION")){
			String administeredDate=request.getParameter("administeredDate");
			String onSetDate=request.getParameter("onSetDate");
			String datetype=bean.onSetReactionTime(onSetDate,administeredDate);
			out.println("displayOnsetValue('"+datetype+"')");
				
			}else if(validate.equals("ONSETDATE")){
			String onsetvalue=request.getParameter("onsetvalue");
			String onsettimetype=request.getParameter("onsettimetype");
			String adminsterDate=request.getParameter("adminsterDate");
			String datetype=bean.loadOnsetDate(onsetvalue,onsettimetype,adminsterDate);
			out.println("displayOnsetDate('"+datetype+"')");

		}
		else if(validate.equals("DIAG_TEXT"))
		{
			String params	=	 request.getParameter( "params" ) ;
			boolean entered	=	false;
			StringTokenizer	 vals	=	new StringTokenizer(params,"|");
			StringBuffer diag_text		=	new StringBuffer();

			String code		=	null;
			String desc		=	null;
			int i=0;
			while(vals.hasMoreTokens()) 
			{
				entered			=	true;
				code		= (String)vals.nextToken();
				desc		= (String)vals.nextToken();
				diag_text.append(code);
				diag_text.append(" :---  ");
				diag_text.append(desc);
				diag_text.append("##");
				i++;
				
				
		}
		out.println("populatediagnosis(\""+diag_text.toString()+"\",\""+i+"\")");

		// objects nullified after usage
		vals	=	null;
		diag_text	=	null;
		}
			else if(validate.equals("WEIGHT")){
			 String ord_id = request.getParameter( "ord_id" ) ;
			 String ord_line = request.getParameter( "ord_line" ) ;
			 String weight = bean.getWeight(ord_id,Integer.parseInt(ord_line));		 	   
			 if(weight == null) weight="";

			out.println("assignWeight('"+weight+"');") ;
		}else if(validate.equals("SETSIGNEDBYVALUES")){
			String SignedBy = request.getParameter( "SignedBy" ) ;
			String SignedDateTime = request.getParameter( "DateTime" ) ;
			//Added by Jyothi.G on 01/10/2010 to fix IN024115
			SignedDateTime = com.ehis.util.DateUtils.convertDate(SignedDateTime,"DMYHM",locale,"en");
			//End
			bean.setSignedBy(SignedBy);
			bean.setSignedDateTime(SignedDateTime);
			}else if(validate.equals("ONLINEREPORT")){
			
			String report_id = "PHRADRREP";
			patient_id		=	request.getParameter("patient_id");
			String adr_no			=	request.getParameter("adr_no");
			ecis.utils.OnlineReports onlineReports		=	null;
			ecis.utils.OnlineReport report1				=	null;
			onlineReports 		= new ecis.utils.OnlineReports() ;
			report1				= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
			report1.addParameter("p_patient_id",patient_id) ;
			report1.addParameter("p_adr_no",adr_no) ;
			report1.addParameter("p_report_id",report_id) ;
			report1.addParameter("p_user_name",login_user) ;
			report1.addParameter("p_facility_id",facility_id) ;
			report1.addParameter("p_module_id", "PH") ;
			onlineReports.add( report1) ;
		}else if(validate.equals("ADRREPORTQUSETION")){
			String adrcode=request.getParameter("adrcode");
			String num=request.getParameter("num");
			bean.updateQuestionnaire(adrcode,num);
		}else if(validate.equals("ADRREPORTUPDATE")){
			String qverifiedby=request.getParameter("qverifiedby");
			String cer_code=bean.updateResscore(qverifiedby);
			 if(cer_code!=null){
				 out.println("setcertainity('"+cer_code+"');");
			 }
		}else if(validate.equals("ADRREPORTCANCEL")){
			bean.cancelQuestionnaire();			 
		}
		else if(validate.equals("ADRremarks")){ //code added for HSA-CRF-0005[40601] -- Start 
			String canErrorIDTemp = request.getParameter( "canErrorIDTemp" ) ;
			String canErrorDate = request.getParameter( "canErrorDate" ) ;
			String canReason = request.getParameter( "canReason" ) ;
			String canRemarks = (String)hash.get( "canRemarks" ) ;
			
            if(!canRemarks.equals("null") && !canRemarks.equals("")) 
			    canRemarks = java.net.URLDecoder.decode(canRemarks,"UTF-8");
						
			bean.setcanErrorIDTemp(canErrorIDTemp);
			bean.setcanErrorDate(canErrorDate);
			bean.setcanRemarks(canRemarks);	
			bean.setcanReason(canReason);  	
		} 
		else if(validate.equals("ADRCancelReason")){			
			String canReason = request.getParameter("canReason") ;			
			String remarks ="";
			if(!canReason.equals("") ){	
				remarks = (String)bean.getAdrReasons(canReason);
				remarks=remarks.replaceAll(" ","%20");
				remarks = java.net.URLEncoder.encode(remarks,"UTF-8" );
				remarks=remarks.replaceAll("%2520","%20"); 
			}		   			
			out.println("setRemarks(\""+remarks+"\")");		
		} 
		else if(validate.equals("ADRClearReason")){ 							
				bean.setcanErrorIDTemp("");
				bean.setcanErrorDate("");
				bean.setcanRemarks("");						
				bean.setcanReason("");					
			} //code added for HSA-CRF-0005[40601] -- End 

		putObjectInBean(bean_id,bean,request);
	%>
												
