 <%--This file is saved on 07/11/2005 --%>
<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id			=	 request.getParameter( "bean_id" ) ;
	String bean_name		=	 request.getParameter( "bean_name" ) ;
	String validate			=	 request.getParameter( "validate" ) ;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;
	TDMAttributesBean bean	=	 (TDMAttributesBean)getBeanObject( bean_id,bean_name,request);
	Hashtable hash						=	 ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash										=	 ( Hashtable )hash.get( "SEARCH" ) ;
	try{
		if ( validate.equals( "LAB_ORDER_FINAL" ) ) {
			String sample				=		request.getParameter("sample");
			bean.setSelectLabOrderFinal(sample);
		}
		else if ( validate.equals( "LAB_ORDER_SELECT_REMOVE" ) ) {
			String labOrdercode		=		request.getParameter("labOrdercode")==null?"":request.getParameter("labOrdercode");
			String labOrderdesc		=		request.getParameter("labOrderdesc")==null?"":request.getParameter("labOrderdesc");
		//	if(!labOrderdesc.equals(""))
		//		labOrderdesc = java.net.URLDecoder.decode(labOrderdesc,"UTF-8"); //decoded for IN24564-reopen --04/11/2010-- priya
			String sample				=		request.getParameter("sample");
			String flag						=		request.getParameter("flag");
			String final_yn						=		request.getParameter("final_yn")==null?"N":request.getParameter("final_yn");
			bean.setSelectLabOrder(labOrdercode,labOrderdesc,flag,sample);
			if(final_yn.equals("Y")){
				bean.setSelectLabOrderFinal(sample);
			}
		}
		else if ( validate.equals( "LAB_ORDER_RESET" ) ) {
			String sample				=		request.getParameter("sample");
			bean.setSelectLabOrderReset(sample);
		}
		else if ( validate.equals( "saveRemark" ) ) {
			String stype			 = (String)hash.get("stypecode");
			String remarks = "";
			if(stype.equals("P")){
				remarks = (String)hash.get("remarks");
				bean.setPeakRemarks(remarks);
			} 
			else if(stype.equals("T")){
				remarks	   = (String)hash.get("remarks");
				bean.setTroughRemarks(remarks);
			} 
			else if(stype.equals("E")){
				remarks	 = (String)hash.get("remarks");
				bean.setExtendRemarks(remarks);
			} 
			else if(stype.equals("R")){
				remarks	  = (String)hash.get("remarks");
				bean.setRandomRemarks(remarks);
			}
		}
		else if ( validate.equals( "CLEAR_SAMPLE" ) ) {
			String sample			=		request.getParameter("sample");
				bean.clearSampleList(sample);
				bean.clearSamplingDetails(sample);
			out.println("loadResult()");
		}
		else if ( validate.equals( "CHECKFORVALID" ) ) {
			String drugCode			=		request.getParameter("drugCode");
			String ageGrpCode		=		request.getParameter("ageGrpCode");
			int flag=0;
			flag=bean.checkforvalid(drugCode,ageGrpCode);
			out.println("clearCheckForValid('"+flag+"')");	
		}
		else if ( validate.equals( "SAMPLETIME" ) ) {
			String sampleType		=		request.getParameter("sampleType");
			String sampleTime		=		request.getParameter("sampleTime");
			String sampleTimeType	=		request.getParameter("sampleTimeType");
			bean.setSamplingDetails(sampleType,sampleTime,sampleTimeType);
		}
		else if ( validate.equals( "CHECKFOROVERLAP" ) ) {
			String drug_code		= (String) hash.get("drugCode");
			String age_group_code	= (String) hash.get("age_group_code");
			String exists_yn	=	bean.CheckForOverlap(drug_code,age_group_code);
			out.println("clearCheckForOverlap('"+exists_yn+"')");	
		}
		else if ( validate.equals( "CHECKFOROVERLAP" ) ) {
			String drug_code		= (String) hash.get("drugCode");
			String age_group_code	= (String) hash.get("age_group_code");
			String exists_yn	=	bean.CheckForOverlap(drug_code,age_group_code);
			out.println("clearCheckForOverlap('"+exists_yn+"')");	
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	putObjectInBean(bean_id,bean,request);
%>
