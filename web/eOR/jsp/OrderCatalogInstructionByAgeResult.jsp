<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 


<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<style>
		textarea {
		  	resize: none;
		}
	</style>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function callme(obj,index){

	var val = eval(parent.frames[0].document.getElementById("age_i_y"+index))
	var	objLowerDoc = parent.frames[1].document;
	var sex										= obj.innerText;
	objLowerDoc.min_age_in_yrs.value		= eval(parent.frames[0].document.getElementById("age_i_y"+index)).innerText;
	objLowerDoc.temp_min_age_in_yrs.value		= eval(parent.frames[0].document.getElementById("age_i_y"+index)).innerText;
	objLowerDoc.min_age_in_mths.value		= eval(parent.frames[0].document.getElementById("age_i_m"+index)).innerText;
	objLowerDoc.temp_min_age_in_mths.value		= eval(parent.frames[0].document.getElementById("age_i_m"+index)).innerText;
	objLowerDoc.min_age_in_days.value		= eval(parent.frames[0].document.getElementById("age_i_d"+index)).innerText;
	objLowerDoc.temp_min_age_in_days.value		= eval(parent.frames[0].document.getElementById("age_i_d"+index)).innerText;
	objLowerDoc.temp_max_age_in_yrs.value		= eval(parent.frames[0].document.getElementById("maxage_i_y"+index)).innerText;
	objLowerDoc.max_age_in_yrs.value		= eval(parent.frames[0].document.getElementById("maxage_i_y"+index)).innerText;
	objLowerDoc.max_age_in_mths.value		= eval(parent.frames[0].document.getElementById("maxage_i_m"+index)).innerText;
	objLowerDoc.temp_max_age_in_mths.value		= eval(parent.frames[0].document.getElementById("maxage_i_m"+index)).innerText;
	objLowerDoc.max_age_in_days.value		= eval(parent.frames[0].document.getElementById("maxage_i_d"+index)).innerText;
	objLowerDoc.temp_max_age_in_days.value		= eval(parent.frames[0].document.getElementById("maxage_i_d"+index)).innerText;
	var sexInd = "0";

	if(sex == getLabel("Common.male.label","Common"))
	sexInd = 1;
	
	if(sex == getLabel("Common.female.label","Common"))
	sexInd = 2;

	if(sex == getLabel("Common.Both.label","Common"))
	sexInd = 3;

		
	objLowerDoc.sex_spec_ind.selectedIndex  = sexInd; 
	objLowerDoc.temp_sex_spec_ind.value = sexInd;
		
	var Objtxt = eval(parent.frames[0].document.getElementById("pat_preps_or_instrns_txt_im" + index ));


	objLowerDoc.pat_preps_or_instrns_txt_im.value = Objtxt.value ;
	objLowerDoc.temp_pat_preps_or_instrns_txt_im.value = Objtxt.value ;
	objLowerDoc.index.value = index ;
}


</script>

<body STYLE="overflow-y:hidden;overflow-X:hidden"  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='detailUpperForm' id='detailUpperForm' >
<%
	
try{
	
	/* Mandatory checks start */
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	
	String valSource[]  ={"M","F","N"} ;
	String descsource[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")} ;


	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name ,request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	HashMap recordByAge =  bean.getInstructionStdByAge("IM") ;
	ArrayList  records=null;
	int size = 0;

	if(!recordByAge.isEmpty()){
	records  = (ArrayList)recordByAge.get("records");
	size = records.size();
	}else{
	size =0 ;
	}
%>
<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center' class="grid">
	
		<tr>
		<td class='COLUMNHEADER'></td>
		<td class='COLUMNHEADER' colspan='3'><b><-----<fmt:message key="Common.MinAge.label" bundle="${common_labels}"/>----------></b></td>
		<td class='COLUMNHEADER' colspan='5'><b><-----<fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/>----------></b></td>
		</tr>

	<tr>
		<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>
		
		<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
		<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
		<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		
		<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
		<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
		<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="eOR.Instrn.label" bundle="${or_labels}"/></td>
   </tr>


<%
	String classValue="";
if(size != 0)
{	
	for(int i = 0 ; i  < size ; i++){
		/*if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;*/
			classValue="gridData";
			
		HashMap currRec =(HashMap)records.get(i);

%>
	 <tr >
		<td  onClick='callme(this , "<%=i%>")' class='<%=classValue%>' onmouseover="changeCursor(this);" ><a class="gridLink" href="#"><%=eHISFormatter.chkReturn(valSource,(String)currRec.get("sex_spec_ind"),descsource,"")%></a></td>	
		
		<td class='<%=classValue%>' id="age_i_y<%=i%>" ><font class=''><%=(String)currRec.get("min_age_in_yrs")%></font></td>		
		<td class='<%=classValue%>' id="age_i_m<%=i%>" ><font class=''><%=(String)currRec.get("min_age_in_mths")%></font></td>		
		<td class='<%=classValue%>' id="age_i_d<%=i%>" ><font class=''><%=(String)currRec.get("min_age_in_days")%></font></td>		
		<td class='<%=classValue%>' id="maxage_i_y<%=i%>" ><font class=''><%=(String)currRec.get("max_age_in_yrs")%></font></td>		
		<td class='<%=classValue%>' id="maxage_i_m<%=i%>" ><font class=''><%=(String)currRec.get("max_age_in_mths")%></font></td>		
		<td class='<%=classValue%>' id="maxage_i_d<%=i%>" ><font class=''><%=(String)currRec.get("max_age_in_days")%></font></td>	
		<td class='<%=classValue%>' ><font class=''>Instr</font></td>	

		<INPUT TYPE="hidden" name="pat_preps_or_instrns_txt_im<%=i%>" id="pat_preps_or_instrns_txt_im<%=i%>" value="<%=(String)currRec.get("pat_preps_or_instrns_txt")%>">
		
		
	</tr>  
		
<%  	}
	}//End of if Size != 0
%>

<%putObjectInBean(bean_id,bean,request);}catch(Exception e){
	System.out.println(e);
}
%>
  
</form>
</body>
</html>

