<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
 		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

	</head>

<% try{
	String administration_status= request.getParameter("administration_status");
	String admin_from_date	    = request.getParameter("admin_from_date");
	String admin_to_date	    = request.getParameter("admin_to_date");
	String from_time			= request.getParameter("from_time");
	String to_time			    = request.getParameter("to_time");
	String mode					= request.getParameter("mode");
    String patient_id			= request.getParameter("patient_id");
	String encounter_id         = request.getParameter("encounter_id");
	String bean_id				= "MedicationAdministrationBean";
	String bean_name			= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean bean			= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name , request);
	bean.setLanguageId(locale);

	String ft_bean_id			= "MedicationAdministrationFTBean";
	String ft_bean_name			= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean ft_bean	= (MedicationAdministrationFTBean)getBeanObject( ft_bean_id, ft_bean_name, request );	
	ft_bean.setLanguageId(locale);

%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="MedicationAdministrationChartForm" id="MedicationAdministrationChartForm" >
<br>
<table cellpadding="0" cellspacing="0"  border="0"  width="100%">
<%	
	ArrayList al=new ArrayList();
	ArrayList al_times=new ArrayList();
	ArrayList al_drug_desc=new ArrayList();
	ArrayList al_qty=new ArrayList();
	HashMap drug_desc_qty_hm=new HashMap();
	String o_date="";									String drug_desc="";
	String drug_strength="";						    String te_qty="";
	String drug_code="";								String order_id="";
	String admin_recorded_yn="";						//String admin_recorded_date_time="";
	String administered_yn="";							//String admin_date_time="";
	//String admin_due_flag="n";						
	String iv_prep_yn="";
	HashMap hm_qty=null;								String drug_class="";
	String drug_class_ind="";							String order_line_num="";
	int srl_no=1;										String time="";
	String order_line_num1="";							String classvalue="";
	String freq_nature="";								String order_id1="";
	String order_line_status="";						int count=0;
	int t=0;											int c1=0;
	int c2=0;											int tep=0;
	int n=0;
				
		al=(ArrayList)bean.getRecord(encounter_id,from_time, to_time);
				for(int i=0;i<al.size();i++) { 
					HashMap record1=new HashMap();
				    record1=(HashMap)al.get(i);
					o_date=(String)record1.get("dates");
	%>
				 
<tr>
	<th  colspan="18"><fmt:message key="ePH.AdministrationDetailfor.label" bundle="${ph_labels}"/> <%=o_date%></th>
</tr>
</table>
<table cellpadding="0" cellspacing="0"  border="2%"   id="drugTable" name="drugTable" id="drugTable" width="100%">
<th class="HEADERTITLE"  width="2">&nbsp;</th>
<th  class="HEADERTITLE" width="300"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
<th  class="HEADERTITLE" width="2"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>		
	 <%  count+=3;
		 al_times=(ArrayList)record1.get("times");
		 t=al_times.size();
	%>
<th  class="HEADERTITLE" colspan="<%=t%>"><fmt:message key="ePH.Timings/Dosage.label" bundle="${ph_labels}"/></th>
	<tr><td class='TIMING'>&nbsp;</td>
		<td class='TIMING'width="300">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td class='TIMING'  width="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

		<%
			c1=0;
		    c2=0;
			  for(int p=0;p<al_times.size();p++){ 
		%>
		<td class='TIMING'><b><%=al_times.get(p) %></b></td>
		<%
			       } 
		%>
	 </tr>
		<% 
			 al_drug_desc=(ArrayList)record1.get("desc_qty");
			 tep=al_drug_desc.size();
							     for(int x=0;x<al_drug_desc.size();x++){
								 drug_desc_qty_hm=(HashMap)al_drug_desc.get(x);
								 drug_code=(String)drug_desc_qty_hm.get("drug_code");
								 drug_desc=(String)drug_desc_qty_hm.get("drug_desc"); 
								 order_id1=(String)drug_desc_qty_hm.get("order_id");
								 drug_class=(String)drug_desc_qty_hm.get("drug_class");
								 order_line_num1=(String)drug_desc_qty_hm.get("order_line_num");
								 iv_prep_yn=(String)bean.checkIVOrder(order_id1);
								 order_line_status=bean.gethold_discontinue(order_id1,order_line_num1);
								 //out.println("----"+order_line_num1);
								n=(count+x+1);
if(order_line_status.equals("DC")){classvalue = "red";}
else if(order_line_status.equals("HD")){classvalue = "yellow";}
if(iv_prep_yn.equals("")){c2++;}
if(!iv_prep_yn.equals(""))
	{ c1++;
     if(order_line_num1.equals("1")){drug_class_ind = "#FFBFBF";}
     else if(order_line_num1.equals("2")||order_line_num1.equals("3")||order_line_num1.equals("4")||order_line_num1.equals("5")){
	   drug_class_ind = "#FFDFDF";
	 }
 }
else if(drug_class!=null && drug_class.equals("N")){
					drug_class_ind = "#66FFFF";
}else if(drug_class!=null && drug_class.equals("C")){
					drug_class_ind = "#CCFFCC";
}else
	{ drug_class_ind ="white";}

 if( c1==1 ) { count++;%>
<tr><td width="100%" style=" background-color:#515151;color=white;" colspan="20"><b<fmt:message key="ePH.IVDrugs.label" bundle="${ph_labels}"/><fmt:message key="ePH.IVDrugs.label" bundle="${ph_labels}"/></b></td></tr>
<%}else if(c2==1 ) { count++;%>
<tr><td width="100%" style=" background-color:#515151;color=white;"  colspan="20"><b<fmt:message key="ePH.Non-IVDrugs.label" bundle="${ph_labels}"/><fmt:message key="ePH.Non-IVDrugs.label" bundle="${ph_labels}"/></b></td></tr>
<% } %>
<tr>
<td style="background-color=<%=classvalue%>" width='2%'>&nbsp;&nbsp;&nbsp;</td>							    
<td   style=" background-color:<%=drug_class_ind %>" ><font size='1' ><%=drug_desc%></font></td> 
	
							     <%drug_strength=(String)drug_desc_qty_hm.get("drug_strength"); %> 
<td   style=" background-color:white" ><font size='1' ><%=drug_strength %></font></td>
                                  
	<%	
		al_qty=(ArrayList)drug_desc_qty_hm.get("qty");
			for(int k=0;k<al_qty.size();k++){ 
							hm_qty=new HashMap();
							hm_qty=(HashMap)al_qty.get(k);
							order_id=(String)hm_qty.get("order_id");
							//admin_due_flag=(String)hm_qty.get("admin_due_flag");
							admin_recorded_yn=(String)hm_qty.get("admin_recorded_yn");
					       // admin_recorded_date_time=(String)hm_qty.get("admin_recorded_date_time");
							administered_yn=(String)hm_qty.get("administered_yn");
					       // admin_date_time=(String)hm_qty.get("admin_date_time");
							te_qty=(String)hm_qty.get("f_qty");
							if(te_qty==null){te_qty="";}
							order_line_num=(String)hm_qty.get("order_line_num");
							time=(String)hm_qty.get("time");
							if(!iv_prep_yn.equals(""))
	{  mode="Y";} else {mode="N";}
	freq_nature  =bean.callfrequency(order_id,order_line_num);
	%>
<% if(te_qty==""){ %><td  id ="qid"  style=" background-color:white;"><font  size='1'>&nbsp</td>
<%} else if(!order_line_num.equals("1")){%>
	<td  id ="qid"  style=" background-color:white;"><font  size='1'><%=te_qty%></td> 
<%} else if(freq_nature.equals("P") ||ft_bean.enableSelect(o_date+""+time,admin_from_date,admin_to_date)){ %> 
<%  if(!administered_yn.equals("") && administered_yn.equals("Y")){ %>
	<td   style="background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue" onclick="setframe(<%=n %>);callAdminDetails(this,'<%=order_id%>','<%=drug_code%>','<%=srl_no%>','<%= drug_strength%>','<%=mode%>','<%=o_date%>','<%=time%>','<%=te_qty%>','<%=encounter_id %>','<%=order_line_num%>','<%=patient_id%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=from_time%>','<%=to_time%>','<%=administration_status%>')" ><font size='1' ><%=te_qty%></font></td>
<%} else if(!admin_recorded_yn.equals("") && admin_recorded_yn.equals("Y")){%>
	<td    style="background-color:white;color:blue;cursor:pointer;border-right:15px solid black;color:blue" onclick="setframe(<%=n %>);callAdminDetails(this,'<%=order_id%>','<%=drug_code%>','<%=srl_no%>','<%= drug_strength%>','<%=mode%>','<%=o_date%>','<%=time%>','<%=te_qty%>','<%=encounter_id %>','<%=order_line_num%>','<%=patient_id%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=from_time%>','<%=to_time%>','<%=administration_status%>')" ><font size='1' ><%=te_qty%></font></td>

<%} else if(freq_nature.equals("O")){ %>
<td  style="background-color:white;color:blue;cursor:pointer;border-right:15px solid #CE00CE;color:blue" onclick="setframe(<%=n %>);callAdminDetails(this,'<%=order_id%>','<%=drug_code%>','<%=srl_no%>','<%= drug_strength%>','<%=mode%>','<%=o_date%>','<%=time%>','<%=te_qty%>','<%=encounter_id %>','<%=order_line_num%>','<%=patient_id%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=from_time%>','<%=to_time%>','<%=administration_status%>')"><font  size='1'><%=te_qty%></font></td>

<%}else if(freq_nature.equals("P")){%><td style="background-color:white;color:blue;cursor:pointer;border-right:15px solid #804040;color:blue" onclick="setframe(<%=n %>);callAdminDetails(this,'<%=order_id%>','<%=drug_code%>','<%=srl_no%>','<%= drug_strength%>','<%=mode%>','<%=o_date%>','<%=time%>','<%=te_qty%>','<%=encounter_id %>','<%=order_line_num%>','<%=patient_id%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=from_time%>','<%=to_time%>','<%=administration_status%>')"><font  size='1'><%=te_qty%></font></td> 
<%} else { %>
	<td style="background-color:white;color:blue;cursor:pointer;" onclick="setframe(<%=n %>);callAdminDetails(this,'<%=order_id%>','<%=drug_code%>','<%=srl_no%>','<%= drug_strength%>','<%=mode%>','<%=o_date%>','<%=time%>','<%=te_qty%>','<%=encounter_id %>','<%=order_line_num%>','<%=patient_id%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=from_time%>','<%=to_time%>','<%=administration_status%>')"><font  size='1'><%=te_qty%></font></td> 
	<%}%>
  <%} else  { %>
<td  id ="qid" style=" background-color:white;"><font  size='1'><%=te_qty%></td> 
         <% } }%>
					 </tr> 
	<% }count=(count+tep+1); %>

<% }%>
</TABLE>

</SPAN>
<input type='hidden' value='<%=encounter_id%>' name='encounter_id'>
<input type="hidden" value="<%=patient_id%>" name="patient_id">  
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(ft_bean_id,ft_bean,request);
}catch(Exception e){
out.println(e.toString());
e.printStackTrace();

}
%>

