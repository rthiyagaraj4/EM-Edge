
 
<%@page import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %><%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

		String locale			= (String)session.getAttribute("LOCALE");
		
	String bean_id	= request.getParameter( "bean_id" ) ;
	String bean_name= request.getParameter( "bean_name" ) ;
	String validate= request.getParameter( "validate" ) ;
	if(validate==null)  validate="";
	

	ArrayList arrListResult	=	new ArrayList();
	int flag=0;
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	DrugDosageLimitBean bean = (DrugDosageLimitBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(locale);
	if( !(validate.equals("checkforvalid"))|| validate=="")
	{
	//DrugDosageLimitBean bean = (DrugDosageLimitBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	arrListResult =(ArrayList)bean.getDrugCodeRelatedInfo(request.getParameter( "drug_code" ));
	String drug_name="";
	for (int i=0;i<arrListResult.size();i++) {
	//------------------------- added for allowing special characters in drug_name
		if(i==1) 
		{
			if(!arrListResult.get(i).equals("")&&arrListResult.get(i)!=null)
				{
					drug_name = (String)arrListResult.get(i);
					drug_name=drug_name.replaceAll(" ","%20");
					drug_name=	java.net.URLEncoder.encode(drug_name);
					drug_name=drug_name.replaceAll("%2520","%20");	
				}
			out.println("addToGlobalDrugRelated('"+drug_name+"')");
			
		}
		else{
			out.println("addToGlobalDrugRelated('"+arrListResult.get(i)+"')");
		}
	}
	}
	else {
		String drug_code=request.getParameter("drug_code");
		String age_group_code=request.getParameter("age_group_code");
		String calc_by_ind=request.getParameter("calc_by_ind");
		flag =bean.checkforvalid( drug_code, age_group_code,calc_by_ind);
		out.println("addtocheckforvalid('"+flag+"')");
	}
	putObjectInBean(bean_id,bean,request);
%>
