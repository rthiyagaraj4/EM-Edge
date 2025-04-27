<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<title><fmt:message key="ePH.ApplicibilitySetting.label" bundle="${ph_labels}"/></title>
	<head>
<%
	try{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/TpnConsNsRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest();" onKeyDown="lockKey()" topmargin="0"">
<%
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );

       ArrayList ageGroups=new ArrayList();
       String bean_id					= "TPNConsNSRegimenBean";
       String bean_name				= "ePH.TPNConsNSRegimenBean";
       TPNConsNSRegimenBean bean			= (TPNConsNSRegimenBean)getBeanObject( bean_id,bean_name,request);
       bean.setLanguageId(locale);
       String drug_code=request.getParameter("drug_code");
       String regimen_code=request.getParameter("regimen_code");
       String mode=request.getParameter("mode");
       HashMap  map= null;
	   HashMap  map1= null;  
	   boolean value=false;//added for ml-mmoh-crf-1201
	   ArrayList applicablList  = new ArrayList();
       if(mode.equals("MODIFY")){
    	     map = bean.getApplicabulityMap();
    	     if( !map.containsKey(drug_code) ) {
  			   bean.getModifiedApplicabilitySettings(drug_code,regimen_code);
  		  
	    	   map = bean.getApplicabulityMap();
  		   
  	   }
    	     map1 = (HashMap)map.get(drug_code);  
    	    applicablList=bean.getApplicablList();
      
       }
       else if(mode.equals("EDIT")){
    	   map = bean.getApplicabulityMap();
    	  
    		   if( !map.containsKey(drug_code) ) {
    			   bean.getModifiedApplicabilitySettings(drug_code,regimen_code);
    		  
  	    	   map = bean.getApplicabulityMap();
    		   
    	   }
    	 
  	      map1 = (HashMap)map.get(drug_code);  
  	     applicablList=bean.getApplicablList();
  	    
       }
       else{
    	   map = bean.getApplicabulityMap();
    	   if(map.size()!=0){
    		   map1 = (HashMap)map.get(drug_code);  
    	  	  if(map.containsKey(drug_code)){ 
    	  		  applicablList=bean.getApplicablList();
    	  	     mode="MODIFY";
    	  	  }
    	  	  else{
    	  		ageGroups=bean.getAgeGroupsNS(locale,drug_code);
    	  	  }
    	   }
    	   else{
    		   ageGroups=bean.getAgeGroupsNS(locale,drug_code);
    	   }
       }
       System.out.println("MODE"+mode);
       int count=0;
%>

<form name="applicabulitySettingsForm" id="applicabulitySettingsForm" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prathyusha">
<tr ><thead  display: inline-block;><TH width="20%"  ><lable ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></lable></TH>
<TH width="20%"><lable >Applicability</lable ></TH></thead></tr>
</table>
	<div style="width:100%; overflow:auto;height:180px;">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<%if(!mode.equals("MODIFY") && !mode.equals("EDIT")){	
	 
						for (int i=0;i<ageGroups.size();i=i+2){
														
							String code		=(String)ageGroups.get(i);
							String desc		=(String)ageGroups.get(i+1);
						%>
<tr >	<td  class="label" width="20%"><lable ><%=desc%></lable><input type="hidden" value="<%=code%>" name="age<%=count%>"></td>


<td align="left" width="20%" >&nbsp;&nbsp;<select name="applicibulity<%=count%>" id="applicibulity<%=count%>" onchange="AssignValues('<%=code%>')"><option value="N">&nbsp;Not Applicable&nbsp;</option><option value="A">&nbsp;Applicable&nbsp;</option>
</select>
</td>
	</tr>
	<%count++;}}else{
		 System.out.println(" IN  ELSE applicablList"+applicablList);
         System.out.println("IN ELSE map1"+map1);
         if(((String)map1.get("*A")).equals("A")){
    		 
    		 value=true;
    	 }
    	 else{
    		 value=false;
    	 }
    	 System.out.println(value);
	for (int i=0;i<applicablList.size();i=i+2){
														
							String code		=(String)applicablList.get(i);
							String desc		=(String)applicablList.get(i+1);
						%>
<tr >	<td  class="label" width="20%"><lable ><%=desc%></lable><input type="hidden" value="<%=code%>" name="age<%=count%>"></td>
<% if( value== true ){

if(code.equals("*A") )	{ %>
	<td align="left" width="20%">&nbsp;&nbsp;<select name="applicibulity<%=count%>" id="applicibulity<%=count%>"  onchange="AssignValues('<%=code%>')" ><option value="N" >&nbsp;Not Applicable&nbsp;</option><option selected value="A">&nbsp;Applicable&nbsp;</option>
	</select>
	</td>
	
<% }else{%>
	<td align="left" width="20%">&nbsp;&nbsp;<select name="applicibulity<%=count%>" id="applicibulity<%=count%>"  disabled onchange="AssignValues('<%=code%>')" ><option value="N" >&nbsp;Not Applicable&nbsp;</option><option value="A">&nbsp;Applicable&nbsp;</option>
	</select>
	</td>
<% }
}else{if(((String)map1.get(code)).equals("N")){ System.out.println(""+map1);%>

         
<td align="left" width="20%" >&nbsp;&nbsp;<select name="applicibulity<%=count%>" id="applicibulity<%=count%>"  onchange="AssignValues('<%=code%>')" ><option value="N" selected>&nbsp;Not Applicable&nbsp;</option><option value="A">&nbsp;Applicable&nbsp;</option>
</select>
</td>
<%}else{ %>
<td align="left" width="20%">&nbsp;&nbsp;<select name="applicibulity<%=count%>" id="applicibulity<%=count%>"  onchange="AssignValues('<%=code%>')" ><option value="N" >&nbsp;Not Applicable&nbsp;</option><option value="A" selected>&nbsp;Applicable&nbsp;</option>
</select>
</td>
<%} }%>
	</tr>
	<%count++;}
	} %>
	
			
			
</table>
</div>
<table >
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr>
					<td width ="50%"></td>
					<td width ="50%"></td>
					<td class='button' align='left'>
						<input type='Button' class='Button' name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  onclick='setOnlineSetuptoBean(this);' >
					</TD>
					<td class='button' align='left'>
						<input type='Button' class='Button' name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick='setOnlineSetuptoBean(this)' >&nbsp;&nbsp;&nbsp;
					</TD>
				</tr>
			
</table>
<input type="hidden" name="count" id="count" value=<%=count%> >
<input type="hidden" name="drug_code" id="drug_code" value=<%=drug_code%> >
<input type="hidden" name="regimen_code" id="regimen_code" value=<%=regimen_code%> >


</form>
		</body>
<%
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

