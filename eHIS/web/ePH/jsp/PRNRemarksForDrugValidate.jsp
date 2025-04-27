 <%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%	
	request.setCharacterEncoding("UTF-8");
	//String locale			= (String)session.getAttribute("LOCALE");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;	
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	PRNRemarksForDrugBean beanObj = (PRNRemarksForDrugBean)getBeanObject( bean_id, bean_name,request ) ;

	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if ( validate.equals( "defaultSelectChecked" ) ) {
		int changedAtIndex = Integer.parseInt(hash.get("changedAtIndex").toString());
		String changedValue = (String) hash.get("changedValue");		
		
		ArrayList remarksList = beanObj.getList();
		for (int i=0;i<remarksList.size();i+=4){
			if ((i+2) == changedAtIndex)
                 remarksList.set(changedAtIndex,changedValue);
			else
				remarksList.set(i+2,"N");				
		}
		beanObj.setList(remarksList);	
	}

	if ( validate.equals( "selectChecked" ) ) {
		int changedAtIndex = Integer.parseInt(hash.get("changedAtIndex").toString());
		String changedValue = (String) hash.get("changedValue");		
		ArrayList remarksList = beanObj.getList();
		remarksList.set(changedAtIndex,changedValue);
		beanObj.setList(remarksList);
	}
	
	if ( validate.equals( "onApply" ) ) {
		String drug_code = (String) hash.get("drug_code");
		//String drug_desc = (String) hash.get("drug_desc");
		ArrayList remarksList = beanObj.getList();
		beanObj.setDrugCode(drug_code);
		String flag = "";
		String flag1 = "";
	
		
		for (int i=0;i<remarksList.size();i+=4){
			 if (!(remarksList.get(i+2).toString().equals("N") && remarksList.get(i+3).toString().equals("N"))){
			   flag ="true";
			   break;
			  }		 
		}
		if (!flag.equals("")){
			for (int i=0;i<remarksList.size();i+=4){
			 if ((remarksList.get(i+2).toString().equals("Y") && remarksList.get(i+3).toString().equals("N"))){
			   flag1 ="false";
			   break;
			  }			  
			}			
		}		
		 out.println("checkForm('"+flag+"','"+flag1+"')");
		}
		
		



%>
<%
putObjectInBean(bean_id, beanObj, request);
%>
