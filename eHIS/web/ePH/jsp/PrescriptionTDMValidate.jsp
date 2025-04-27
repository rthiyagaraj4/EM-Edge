 <%--This file is saved on 07/11/2005 --%>
<%@page import="java.util.*, ePH.Common.*, ePH.*,eST.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
try 
{
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String identity		  = request.getParameter( "identity" );
	String order_id		  = request.getParameter( "order_id" );
	String order_line_num		  = request.getParameter( "order_line_num" );
	String bean_id		  = request.getParameter( "bean_id" ) ;
	String bean_name	  = request.getParameter( "bean_name" ) ; 
	String strSampType	  = request.getParameter( "samp_type" );
	String strDrugCode	  = request.getParameter("drug_code");
	String strLdObj		  = request.getParameter("ldObj");
	if(strLdObj == null){strLdObj="";}
	String strIdxNo		  = request.getParameter("IdxNo");
	

	PrescriptionTDMBean bean	= (PrescriptionTDMBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Hashtable htLabTests = new Hashtable();
	ArrayList alDrugDur  = new ArrayList();

	if(identity != null && identity.equals("getLabTest") )
	{
		htLabTests	= bean.getLabTests2(strDrugCode,strSampType);
		if(htLabTests.size()==0){
          out.println("chkTdmAttributes();");
        }
		alDrugDur	= bean.getDrugDuration(strSampType);
		Enumeration enTemp = htLabTests.keys();
		
		String strcode ="";
		String strdesc = "";
		String dur_val=(String)alDrugDur.get(0);
		if(dur_val == null){dur_val="";}
		out.println("assignDurationValues('"+strIdxNo+"','"+dur_val+"');");
		out.println("assignDurationTypes('"+strIdxNo+"','"+(String)alDrugDur.get(1)+"');");

		out.println("clearData(document.formTDMAdminDetls."+strLdObj+");");
		
		while (enTemp.hasMoreElements() )
		{
			strcode = (String) enTemp.nextElement();
			strdesc = (String) htLabTests.get(strcode);
		 out.println("addOption('"+strcode+"','"+strdesc+"',document.formTDMAdminDetls."+strLdObj+");");

		}

	}
		if(identity != null && identity.equals("getLabTesttrough") )
	{
		htLabTests	= bean.getLabTests2(strDrugCode,strSampType);
		alDrugDur	= bean.getDrugDuration(strSampType);
		Enumeration enTemp = htLabTests.keys();
		
		String strcode ="";
		String strdesc = "";
		String dur_val=(String)alDrugDur.get(0);
		if(dur_val == null){dur_val="";}
		out.println("assignTroughDurationValues('"+strIdxNo+"','"+dur_val+"');");
		out.println("assignTroughDurationTypes('"+strIdxNo+"','"+(String)alDrugDur.get(1)+"');");

		out.println("clearData(document.formTDMAdminDetls."+strLdObj+");");
		while (enTemp.hasMoreElements() ){
			strcode = (String) enTemp.nextElement();
			strdesc = (String) htLabTests.get(strcode);
			out.println("addOption('"+strcode+"','"+strdesc+"',document.formTDMAdminDetls."+strLdObj+");");
		}
	}
	if(identity != null && identity.equals("getLabTestrandom") ){
		htLabTests	= bean.getLabTests2(strDrugCode,strSampType);

		alDrugDur	= bean.getDrugDuration(strSampType);

		Enumeration enTemp = htLabTests.keys();
		
		String strcode ="";
		String strdesc = "";
		String dur_val=(String)alDrugDur.get(0);
		if(dur_val == null){dur_val="";}
		out.println("assignRandomDurationValues('"+strIdxNo+"','"+dur_val+"');");
		out.println("assignRandomDurationTypes('"+strIdxNo+"','"+(String)alDrugDur.get(1)+"');");

		out.println("clearData(document.formTDMAdminDetls."+strLdObj+");");
		while (enTemp.hasMoreElements() )
		{
			strcode = (String) enTemp.nextElement();
			strdesc = (String) htLabTests.get(strcode);
			out.println("addOption('"+strcode+"','"+strdesc+"',document.formTDMAdminDetls."+strLdObj+");");

		}

	}
		if(identity != null && identity.equals("getLabTestextended") )
	{
		htLabTests	= bean.getLabTests2(strDrugCode,strSampType);

		alDrugDur	= bean.getDrugDuration(strSampType);

		Enumeration enTemp = htLabTests.keys();
		
		String strcode ="";
		String strdesc = "";
		String dur_val=(String)alDrugDur.get(0);
		if(dur_val == null){dur_val="";}
		out.println("assignExtendedDurationValues('"+strIdxNo+"','"+dur_val+"');");
		out.println("assignExtendedDurationTypes('"+strIdxNo+"','"+(String)alDrugDur.get(1)+"');");

		out.println("clearData(document.formTDMAdminDetls."+strLdObj+");");
		while (enTemp.hasMoreElements() )
		{
			strcode = (String) enTemp.nextElement();
			strdesc = (String) htLabTests.get(strcode);
			out.println("addOption('"+strcode+"','"+strdesc+"',document.formTDMAdminDetls."+strLdObj+");");

		}

	}
	if(identity != null && identity.equals("getUpdatedStatus") )
	{
		ArrayList record		= new ArrayList();
		HashMap order_details	= new HashMap();
		String sch_dose_date    = "";
	String sch_dose_time	= "";
	String order_catalog_code="";
	String order_catalog_desc="";
	String sampling_type	= "";
	String sampling_durn	= "";
	String sampling_durn_type="";
	String sampling_indicator="";
	String date				= "";
		ArrayList alOrdDetl		= new ArrayList();
		alOrdDetl = bean.getOrderDetails();
		int nAlSize = 0;
		nAlSize = alOrdDetl.size();
		record= bean.getOrderDetails(order_id,order_line_num);
		int nOrdCtr = 0;
		int nOrdCtr1 = 0;
		int nOrdCtr2 = 0;
		int nOrdCtr3 = 0;
		int nCtr = 0;
			//int nAlSize = 0;
	if(record != null)
	{
		for(nCtr = 0; nCtr < nAlSize; nCtr+=5)
			{
			 //String 	strOrdDate		= (String) alOrdDetl.get(nCtr);
			//String 	strOrdTime		= (String) alOrdDetl.get(nCtr+1);
				//String strOrdDose		= (String) alOrdDetl.get(nCtr+2);
				String sch_date_time	= (String) alOrdDetl.get(nCtr+3);
				  nOrdCtr++;
				  nOrdCtr1++;
				  nOrdCtr2++;
				  nOrdCtr3++;
		for(int i=0;i<record.size();i++){
			
			 order_details		=(HashMap)record.get(i);

			 date				=(String)order_details.get("SCH_DATE_TIME");
			sch_dose_date		=(String)order_details.get("SCH_DOSE_DATE");
			sch_dose_time		=(String)order_details.get("SCH_DOSE_TIME");
			order_catalog_code	=(String)order_details.get("ORDER_CATALOG_CODE");
			order_catalog_desc 	=(String)order_details.get("ORDER_CATALOG_DESC");
			sampling_type		=(String)order_details.get("SAMPLING_TYPE");
			sampling_durn=(String)order_details.get("SAMPLING_DURN");
			sampling_durn_type=(String)order_details.get("SAMPLING_DURN_TYPE");
			sampling_indicator=(String)order_details.get("SAMPLING_INDICATOR");
			
			
			if(date.equals(sch_date_time))
			{
			 if(sampling_type.equals("T")){
				//out.println("assignTroughvalue('"+nOrdCtr+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"');");
				out.println("assignTroughvalue('"+nOrdCtr+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+sampling_indicator+"');");
				 //nOrdCtr++;
			 }
			if(sampling_type.equals("P")){
			out.println("assignPeakvalue('"+nOrdCtr1+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+sampling_indicator+"');");
				 // nOrdCtr1++;
			 }
			 if(sampling_type.equals("R")){
				out.println("assignRandomvalue('"+nOrdCtr2+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+sampling_indicator+"');");
				  //nOrdCtr2++;
			 }
			 if(sampling_type.equals("E")){
			out.println("assignExtendedvalue('"+nOrdCtr3+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+sampling_indicator+"');");
				  //nOrdCtr3++;
			 }
			}
		}
	}}
	}
	putObjectInBean(bean_id,bean,request);

}
catch (Exception e)
{

}
%>


