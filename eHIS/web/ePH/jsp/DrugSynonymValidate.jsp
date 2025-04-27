 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*" contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id = "DrugSynonymBean" ;
	String bean_name = "ePH.DrugSynonymBean";
	DrugSynonymBean bean			= (DrugSynonymBean)getBeanObject( bean_id, bean_name, request);
	String validate		= request.getParameter("validate");
	String synonym_type_code		= request.getParameter("synonym_type_code");
	bean.setLanguageId(locale);

	if(validate.equals("STORECODE")){
	/*	ArrayList storeDetails = bean.getStoreDetails(disp_loc_code1);
		if(storeDetails.size()!=0){
			{
				
				 String store_desc  = (String)storeDetails.get(1);
			 out.println("assignStoreCode('"+store_desc+"');") ;	 
			}*/
	}
	else if(validate.equals("UPDATESELECT")){
		ArrayList alDrugsforSynonym = bean.getDrugListForSynonym("OT",synonym_type_code);
		String drug_code= (String)request.getParameter("drug_code")==null?"":(String)request.getParameter("drug_code");	
		String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");
		String temp_drug_code="";
		int count=0;
		if(!drug_code.equals("")){
			while((alDrugsforSynonym != null) && (count < alDrugsforSynonym.size())){
				temp_drug_code = (String)alDrugsforSynonym.get(count);
				if(drug_code.equals(temp_drug_code)){
					if(selected_yn.equals("Y"))
						 alDrugsforSynonym.set(count+4, "Y");
					else
						 alDrugsforSynonym.set(count+4, "N");

				}
				count+=5;
			}
		}
		else{
			int from =   Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
			int to =   Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
			count= from *5;
			to = to *5;
			if(to > alDrugsforSynonym.size())
				to = alDrugsforSynonym.size();
			while((alDrugsforSynonym != null) && (count <=to)){
				if(selected_yn.equals("Y"))
					 alDrugsforSynonym.set(count+3, "Y");
				else
					 alDrugsforSynonym.set(count+3, "N");
				count+=5;
			}
		}
		bean.setDrugListForSynonym(alDrugsforSynonym);
	}
	putObjectInBean(bean_id,bean,request);
%>
