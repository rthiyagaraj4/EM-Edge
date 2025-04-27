<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
--------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
--------------------------------------------------------------------------------------------------------------------------------
-->
<%@page import="eOR.*,java.util.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>

<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>  
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/FrequencyScope.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>

  <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >  


<%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_FrequencyScope" ;
	String bean_name = "eOR.FrequencyScopeBean";
//	int ordNum=0;
	String l_freq_nature = "";//IN062992
	
	mode = mode.trim();
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	FrequencyScopeBean bean = (FrequencyScopeBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
//	bean.setMode( mode ) ;
//ordNum=bean.getTotalOrdCat();
//out.println("ordNum::"+ordNum+"::ordNum");
						ArrayList Category_Data = new ArrayList();
						String freq_code			= request.getParameter("frequency");
						boolean check=true;
					try{
								check= bean.dupliFreqCodeYn(freq_code);

						}catch(Exception E){
								System.out.println("in exception");
						}
		 
						if(check==true){
										mode=CommonRepository.getCommonKeyValue( "MODE_MODIFY");
										bean.setMode(mode);
								}
						else {
										mode=CommonRepository.getCommonKeyValue( "MODE_INSERT");
										bean.setMode(mode);
								}

//IN062992, starts
boolean isSiteSpecificYN = bean.isSiteSpecificYN();
if(isSiteSpecificYN)
{
	l_freq_nature = bean.getFrequencyNature(freq_code);//IN062992
}
//IN062992, ends
%>
<form name="form_f_detail" id="form_f_detail" method='post' target='messageFrame'>


 
	<table cellpadding=3 cellspacing=0 width="100%" align='center'>
	<tr rowspan=4>
		<td colspan=2>
		
			<table class='grid' width='100%'>
			<tr>
				<th class='columnheader' width='50%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
				<th class='columnheader' width='15%'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></th>
			</tr>	
		<%
			int ilRow=0;
			String slClassValue = "";
			String checked		= "";
			//String nature		="";
			//String disable      = "";
			//int flag = 0;
			String enableCatChkBox = "";//IN062992
		
			//nature        =	bean.getNature(freq_code);
 			

			Category_Data = bean.getOrderCategoryList(freq_code) ;

			String[] record = null;;
			//String category =  "" ;
			for(int i=0; i<Category_Data.size(); i++){
				record = (String [])Category_Data.get(i);
				//category =  record[0] ;
			
				if(ilRow % 2 == 0){
					slClassValue = "gridData";
				}else   {
					slClassValue = "gridData";
				}

				
				//disable      = ""; 		//Intialise every time

				/*if(nature.trim().equalsIgnoreCase("C")){
					if(!category.trim().equalsIgnoreCase("PC") && 					!category.trim().equalsIgnoreCase("PH") && 
							!category.trim().equalsIgnoreCase("NC") &&
								!category.trim().equalsIgnoreCase("TR"))
				disable      = "disabled"; 
				}


				if(nature.trim().equalsIgnoreCase("P")){
					if(!category.trim().equalsIgnoreCase("PH"))
						disable      = "disabled"; 
				}
				*/

				if(record[2].equals("Y"))
				checked = "checked";
				else checked="";

				//IN062992, starts
				if (isSiteSpecificYN && "Y".equals(l_freq_nature))
				{
					if("PH".equals(record[0]))
						enableCatChkBox = "";
					else
						enableCatChkBox = "disabled";
				}
				//IN062992, ends				
		%>
				<!--IN062992, starts-->
				<!-- <tr>
					<td  class='<%= slClassValue %>'><%=record[1]%>
					<input type=hidden name=ordercategory<%=i%> value=<%=record[0]%>></td>	
					<td class='<%= slClassValue%>'>
					<input type=checkbox name=scope<%=i%>  <%=checked%>   ></td>
					</tr> -->
				<tr>
					<td  class='<%= slClassValue %>'><%=record[1]%>
					<input type='hidden' name='ordercategory<%=i%>' id='ordercategory<%=i%>' value=<%=record[0]%>></td>	
					<td class='<%= slClassValue%>'>
					<input type='checkbox' name='scope<%=i%>' id='scope<%=i%>'  <%=checked%>  <%=enableCatChkBox%> ></td>
				</tr>
				<!--IN062992, ends-->
				<%	ilRow++;
						checked = "";
					}Category_Data=null;
				%>

			</table> 
			
			</td>
		</tr>
	</table>
 
<input type=hidden name='frequency' id='frequency' value ="<%=freq_code%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="FrequencyScope" >
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</form>
</body>
</html>


<%
		putObjectInBean(bean_id,bean,request);
 
%>

