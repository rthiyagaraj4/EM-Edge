<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations start --%>
 <jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to 	the bean to get the connection if using the query bean and not the functional bean 
	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String report_id="EMPATINS";
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	ArrayList  EmailDetails=(ArrayList)bean.getEmailDetails(report_id);
	String[]  EmailDataDetails=bean.getEmailDataDetails(facility_id);
	//ArrayList	  arrSeqNo		= new ArrayList();
	//String[] email_record	   = null;
	
%>
<html>
<title><fmt:message key="Common.email.label" bundle="${common_labels}"/></title>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//String key						 = (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
   	//HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	//String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,"");
	String dateString							= bean.getSysDate();
	//String physician_name				= bean.getPractitionerName();
	//String pract_id				 			= bean.getPractitionerId();
	//String priority								= bean.checkForNull(request.getParameter("priority"+0),"");
	//String comment 			 =  "";
	//String pat_preps_instrn="";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrderEntrySearch.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="">
<table cellpadding=3 cellspacing=0 border=0 width="100%" id="tableheader" class="grid">
	<%
	StringBuffer sbEmail=new StringBuffer();
	sbEmail	= buildEmailDetails(bean, EmailDetails,EmailDataDetails,pageContext,dateString);
	if(sbEmail!=null)
	{	
		out.println(sbEmail.toString().replace("##ORDERID##",""));
	}
	
	%>	
	</table>
	<table cellpadding=3 cellspacing=0 border=0 width="100%" id="tableresult" class="grid">
	<%
	StringBuffer sbEmailData=new StringBuffer();
	sbEmailData	= buildEmailDetailData(bean, orderEntryRecordBean,request,pageContext);
	if(sbEmailData!=null)
	{		
			out.println(sbEmailData.toString());
	}
	%>
	</table>
</FORM>
</BODY>
</HTML>
<%!
	private java.lang.StringBuffer buildEmailDetails(eOR.OrderEntryBean bean, ArrayList EmailDetails,String[] EmailDataDetails,PageContext pageContext,String dateString) throws Exception
	{
	 	String[] email_record					= null;	
		//String classValue				= "";
		StringBuffer sbEmail		= new StringBuffer();

		int count_display=1;
		for(int i=0; i<EmailDetails.size(); i++)
		{
				email_record = (String[])EmailDetails.get(i);
				if(email_record[0].equals(email_record[2]))
				{
					if(email_record[0].equals("PAT_DTL"))
					{
							count_display=1;
						
							sbEmail.append("<tr><td class=\"label\" colspan=\"4\"><font size=\"2\"><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientDetails.label","common_labels")+"</font></b></td></tr>");
						
						}
						else if(email_record[0].equals("ENC_ID"))
						{
							count_display=1;
						
							sbEmail.append("<tr><td class=\"label\"colspan=\"4\"><font size=\"2\"><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"</font></b></td></tr>");
						
						}
						else if(email_record[0].equals("ORD_DTL"))
						{
							count_display=1;
						
							sbEmail.append("<tr><td class=\"label\" colspan=\"4\"><font size=\"2\"><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderDetails.label","or_labels")+"</font></b></td></tr>");
						
						}
					}
					else
					{
						count_display++;
						if(count_display%2==0)
						sbEmail.append("</tr><tr>");
						if(email_record[0].equals("PAT_NAME"))
						{
						
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)EmailDataDetails[2],"")+"</B></td>");
						
						}
						else if(email_record[0].equals("PAT_AGE"))
						{
						
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)bean.getAge(),"")+"</B></td>");
						
						}
						else if(email_record[0].equals("PAT_SEX"))
						{
							String sex=bean.checkForNull((String)bean.getSex(),"");
							if (sex.equalsIgnoreCase("M"))
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if(sex.equalsIgnoreCase("F"))
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sex.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+sex+"</B></td>");
						
						}
						else if(email_record[0].equals("PAT_ID"))
						{
						
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)bean.getPatientId(),"")+"</td>");
						
						}
						else if(email_record[0].equals("PAT_NATIONAL_ID"))
						{
					
							sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalID.label","mp_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)EmailDataDetails[3],"")+"</B></td>");
						
						}
						else if(email_record[0].equals("ENC_SPLTY"))
						{
							
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)EmailDataDetails[0],"")+"</B></td>");
							
							}
							else if(email_record[0].equals("ENC_LOCATION"))
							{
								String enc_location_type=bean.checkForNull((String)EmailDataDetails[5],"");
								if(enc_location_type.equalsIgnoreCase("C"))
								{								
									enc_location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
								}
								else if(enc_location_type.equalsIgnoreCase("N"))
								{
									enc_location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
								}else if(enc_location_type.equalsIgnoreCase("R"))
								{
									enc_location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
								}
								else if(enc_location_type.equalsIgnoreCase("D"))
								{
									enc_location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
								}
								String enc_location=enc_location_type+"/"+bean.checkForNull((String)EmailDataDetails[6],"");
							
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull(enc_location,"")+"</td>");
							
							}
							else if(email_record[0].equals("ENC_ATTEND_PRAC"))
							{
							
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)bean.getAttendPractitionerName(),"")+"</B></td>");
							
							}
							else if(email_record[0].equals("ENC_VISIT_DATE"))
							{
						
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitDate.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)dateString,"")+"</B></td>");
							
							}
							else if(email_record[0].equals("ORD_NO"))
							{
							
								sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderNo.label","common_labels")+"</td><td class=\"label\" width=\"25%\">##ORDERID##</td>");
							
							}
							else if(email_record[0].equals("ORD_LOC"))
							{
								String location_type=bean.checkForNull((String)bean.getLocationType(),"");
								if(location_type.equalsIgnoreCase("C"))
								{								
									location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
								}
								else if(location_type.equalsIgnoreCase("N"))
								{
									location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
								}else if(location_type.equalsIgnoreCase("R"))
								{
									location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
								}
								else if(location_type.equalsIgnoreCase("D"))
								{
									location_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
								}

									String ordering_location=location_type+"/"+bean.checkForNull((String)EmailDataDetails[7],"");
							
									sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+ordering_location+"</B></td>");
								
								}
								else if(email_record[0].equals("ORD_DATE"))
								{
							
									sbEmail.append("<td class=\"label\" width=\"25%\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderDate.label","common_labels")+"</td><td class=\"label\" width=\"25%\"><B>"+bean.checkForNull((String)dateString,"")+"</B></td>");
								}
							}
							
					}
					
				email_record = null;
				
		return sbEmail;
	} // End of Method
%>
<%!
	private java.lang.StringBuffer buildEmailDetailData(eOR.OrderEntryBean bean,  eOR.Common.OrderEntryRecordBean orderEntryRecordBean,HttpServletRequest request,PageContext pageContext) throws Exception
	{
	 	//String[] email_record					= null;	
		//String classValue				= "";
		StringBuffer sbEmail		= new StringBuffer();
		ArrayList	  arrSeqNo		= new ArrayList();
		HashMap instructionsMap		= new HashMap();
		Object prepins				= "IS";

		
		sbEmail.append("<tr><td width=\"20%\" class=\"columnheader\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderCatalogs.label","or_labels")+"</td><td width=\"40%\" class=\"columnheader\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientInstructions.label","common_labels")+"</td><td width=\"40%\" class=\"columnheader\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")+"</td></tr>");
		int total_rows          		= Integer.parseInt(bean.checkForNull(request.getParameter("total_rows"),"0"));
		for(int i=0;i<total_rows;i++)
		{
	        String catalog_code	= bean.checkForNull(request.getParameter("catalog_code"+i),"");
			String amend_line_comments=bean.checkForNull(request.getParameter("amend_line_comments"+i),"");
			String amend_line_preps=bean.checkForNull(request.getParameter("amend_line_preps"+i),"");
			String amend_line_pat_instrn=bean.checkForNull(request.getParameter("amend_line_pat_instrn"+i),"");
			String amend_line_dept_instrn=bean.checkForNull(request.getParameter("amend_line_dept_instrn"+i),"");
	        String pat_instrn_age_sex_yn	= bean.checkForNull(request.getParameter("pat_instrn_age_sex_yn"+i),"");
			String catalog_desc=bean.getEmailCatalogDesc(catalog_code);
			arrSeqNo	=(ArrayList)orderEntryRecordBean.getOrderFormats("Comments"+catalog_code,catalog_code);
			String comment="";
			String pat_preps_instrn="";
			String pat_dep_instrn="";
			String pat_preps_instrns="";
			if(arrSeqNo!=null && arrSeqNo.size()>0)
			 {
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
				  		pat_preps_instrns 			 =  bean.checkForNull((String) arrSeqNo.get(1),""); // preps instrns
				  		pat_dep_instrn 			 =  bean.checkForNull((String) arrSeqNo.get(2),""); //dep instrns
			  			pat_preps_instrn     =  bean.checkForNull((String) arrSeqNo.get(3),""); // patient Instrn.
			 }
			 if(comment.equals("")&&pat_preps_instrn.equals("")&&pat_dep_instrn.equals("")&&pat_preps_instrns.equals(""))
			{
					String sex_yn="";
					int age_in_days=0;
					//String pat_pat_preps_instrns="";
					//String EnableEmail="N";
					if(bean.checkForNull(pat_instrn_age_sex_yn,"N").equalsIgnoreCase("Y")) // For pat_instrn_age_sex_yn ="Y" to check for the Patient Instructions
					{
						ArrayList AgeSexPatInstrn = bean.getAgePreps();
						for(int j=0; j<AgeSexPatInstrn.size(); j++)
						{
							String[] record 	= (String[])AgeSexPatInstrn.get(j);
							age_in_days			= (Integer.parseInt(record[0]));
							sex_yn			 	= record[1];
						}
						pat_preps_instrn 		= bean.checkForNull(bean.getPrepsInstructions(catalog_code,age_in_days,sex_yn),""); // For Patient Preps. Insructions
					}
					else
				    {
						//pat_preps_instrn 		= bean.checkForNull(bean.getPreps(catalog_code,"IS"),"");  // For Patient Preps. Insructions.
						instructionsMap 		= bean.getPreps(catalog_code);  // For Patient Preps. Insructions.
						pat_preps_instrn		= (String)instructionsMap.get(prepins);
				    }
						if(!(amend_line_comments.equals("")&&amend_line_preps.equals("")&&amend_line_pat_instrn.equals("")&&amend_line_dept_instrn.equals("")))
						{
							comment=amend_line_comments;
							pat_preps_instrn=amend_line_pat_instrn;
						}
			}
			
			 if(comment.equals("")&&pat_preps_instrn.equals(""))
			{
			}
			else
			{
					sbEmail.append("<tr><td width=\"20%\">"+catalog_desc+"</td><td width=\"38%\" id=\"patinst"+catalog_code+"\"><TEXTAREA  name=\"pattxtarea"+catalog_desc+"\" rows='5' cols=\"40\" readonly>"+pat_preps_instrn+"</textarea></td><td id=\"cmts"+catalog_code+"\" width=\"38%\"><TEXTAREA name=\"cmttxtarea"+catalog_desc+"\" rows=\"5\" cols=\"40\" readonly>"+comment+"</textarea></td></tr>");
				
			}
		}
		return sbEmail;
	}
	%>

