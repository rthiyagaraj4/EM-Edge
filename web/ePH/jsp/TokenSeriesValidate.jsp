<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* , eCommon.Common.*"%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");	
	String locale			= (String)session.getAttribute("LOCALE");

	String chekdispcode="",facility_id="";
	facility_id          = (String)session.getValue( "facility_id" );
	ArrayList GenTokenUponYN=new ArrayList();

	String bean_id	= request.getParameter( "bean_id" ) ;
	String bean_name= request.getParameter( "bean_name" ) ;

	chekdispcode= request.getParameter( "chekdispcode" ) ;
	String disp_code= request.getParameter( "disp_code" ) ;

	String ReIssueMediYN="";
	String ReturnMediYN="";
	String DirectDispYN="";
	TokenSeriesBean bean = (TokenSeriesBean)getBeanObject(bean_id,bean_name,request) ;
	//bean.setLanguageId(locale);
	bean.clear();
	ArrayList wsno = new ArrayList();
	for (int i=0;i<wsno.size();i++){
		out.println("loadIntoWS('"+(String)wsno.get(i)+"','"+(String)wsno.get(++i)+"')");
	}
   
	if(chekdispcode.equals("chekdispcode")){
		int countVal=0;
		int ReturnMediCount=0;
		int DirectDispCount=0;
		int ReissueCount=0;
		countVal=bean.getCount(facility_id,disp_code);
		ReissueCount=bean.getGenTokenUponCount(facility_id,disp_code);

		ReturnMediCount=bean.getReturnMediCount(facility_id,disp_code);
		DirectDispCount=bean.getDirectDispCount(facility_id,disp_code);
		bean.setCountValue(countVal);
		GenTokenUponYN=bean.GenTokenUponYN(facility_id,disp_code,locale);
		int j=0;
		ReIssueMediYN=(String)GenTokenUponYN.get(j);
		ReturnMediYN=(String)GenTokenUponYN.get(j+1);
		DirectDispYN=(String)GenTokenUponYN.get(j+2);
		out.println("CheckStatus('"+countVal+"','"+ReIssueMediYN+"','"+ReturnMediYN+"','"+DirectDispYN+"','"+ReissueCount+"','"+ReturnMediCount+"','"+DirectDispCount+"');");
   }
	putObjectInBean(bean_id,bean,request);
%>
