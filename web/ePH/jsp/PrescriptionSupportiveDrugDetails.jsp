<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		     Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/10/2011        		          Chandra Shekar a  26/07/2019                              TH-KW-CRF-0008
--------------------------------------------------------------------------------------------------------------
*/
%>

<%	
request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
%>
<html>
<head>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script language="javascript" src="../../ePH/js/Prescription_1.js"></script>
<script language="javascript" src="../../ePH/js/PrescriptionTest.js"></script>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
try{
    String locale			          = (String)session.getAttribute("LOCALE");
	String patient_id		          = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id		          = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String drug_code		          = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
    String bean_id					  =	request.getParameter("bean_id");
	String bean_name				  =	request.getParameter("bean_name");
	String presBean_id				  =	request.getParameter("presBean_id")==null?"":request.getParameter("presBean_id"); 
	String presBean_name			  =	request.getParameter("presBean_name")==null?"":request.getParameter("presBean_name");

	PrescriptionBean presBean		  = (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request) ;
	PrescriptionBean_1 bean           = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);

	ArrayList presDetails_1					= (ArrayList) bean.getpresDetails();//Adding start for ICN-37525
	HashMap ext_drugData                    = new HashMap();
	String ext_drug_code                    = "";
	String sel_disable                      ="";
	String checked_yn                          ="";
	String classvalue				=		"";//Adding end for ICN-37525
	int k= 1;

	ArrayList drugList = presBean.getSupportdrugList(drug_code);
		
	int total_records =drugList.size()/6;
	System.err.println("drugList@@@=="+drugList);
	
%>
		<form name='supportdrugsdetails' id='supportdrugsdetails'>
			<table border="0" align="center" width="100%" cellpadding="0" cellspacing="0">
			<tr>
	            <th align="center" width ='35%'><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
	            <th align="center" width ='22%'><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
				<th align="center" width ='5%'><fmt:message key="Common.Form.label" bundle="${common_labels}"/></th>
				<th align="center" width ='5%'><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></th>
				<th align="center" width ='8%'><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
				<th align="center" width ='5%'><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></th>
           </tr>
<%
                if(drugList.size()>0){
					for(int j=0;j<drugList.size();j=j+6){
                         boolean found_in_prescription           = false;//Adding start for ICN-37525
						for(int z=0;z<presDetails_1.size();z++){
					       ext_drugData=(HashMap) presDetails_1.get(z);
					       ext_drug_code = (String) ext_drugData.get("DRUG_CODE");
						   if(ext_drug_code.equals((String)drugList.get(j+1))){
							   found_in_prescription =true;
							   break;
						   }				   
						}
						 if(found_in_prescription){
                               sel_disable   = "disabled";
	                           checked_yn       =  "";
						 }else{
							   sel_disable   = "";
	                           checked_yn    = "checked";
						 }//Adding end for ICN-37525

					   if (j % 2 == 0)
					       classvalue = "OAQRYEVEN" ;
				      else
					       classvalue = "OAQRYODD" ;
%>
                <tr>
                     <td class="<%=classvalue%>" name="drug_name_<%=k%>"  id ="drug_name_<%=k%>">
						<%=drugList.get(j)%>
						<input type="hidden" name="drug_code_<%=k%>" id="drug_code_<%=k%>" value="<%=drugList.get(j+1)%>">
					</td>
					<td class="<%=classvalue%>" name="generic_<%=k%>"  id ="generic_<%=k%>">
						<%=drugList.get(j+2)%>
					</td>
					<td class="<%=classvalue%>" name="form_<%=k%>"  id ="form_<%=k%>">
						<%=drugList.get(j+3)%>
					</td>
					<td class="<%=classvalue%>"  name="route_<%=k%>"  id ="route_<%=k%>">
						<%=drugList.get(j+4)%>
					</td>
					<td class="<%=classvalue%>" name="strength_<%=k%>"  id ="strength_<%=k%>">
						<%=drugList.get(j+5)%>
					</td>
					
					<td class="<%=classvalue%>">
						<input type="checkbox" value="" name="check_<%=k%>" id="check_<%=k%>"  id ="check_<%=k%>"   onClick="" <%=checked_yn%> <%=sel_disable%> >
					</td>
               </tr>
			   
<%
	       k++;
		   }		  
		}
%>
		    
			</table>
			        <input type="hidden" name="total_records" id="total_records" value="<%=total_records%>">
					<input type="hidden" name="main_drug" id="main_drug" value="<%=drug_code%>">
				    <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">		
			       <input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">	
			       <input type="hidden" name="presBean_id" id="presBean_id" value="<%=presBean_id%>">		
			       <input type="hidden" name="presBean_name" id="presBean_name" value="<%=presBean_name%>">	
        </form>
	</body>
<%
				 putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>

</html>

