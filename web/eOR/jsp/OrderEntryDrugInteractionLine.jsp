<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------

29/02/2020	  IN072592		Nijitha S	29/02/2020		Ramesh G	OR-MMS-KH-CRF-0029.3/03-Place order
09/03/2020	  IN072669		Nijitha S	09/03/2020		Ramesh G	
06/07/2020	  IN072654		Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
04/08/2020		IN073562		Nijitha S	04/08/2020	Remesh G	MMS-KH-CRF-0029.4/01
14/08/2020	IN072627	Nijitha S	14/08/2020	Ramesh G	MMS-KH-CRF-0029.4/04
------------------------------------------------------------------------------------------
*/
%>
<%@page import="eOR.*, java.util.*,java.text.*,eCommon.XSSRequestWrapper "
	contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	String druginter_called_from 	= request.getParameter("druginter_called_from");
	
	OrderEntryBean bean	  = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
    bean.setLanguageId(localeName);
    HashMap<String, ArrayList<OrderDrugInteractionVO>> interdrugDtls = bean.getDruginteractionDtl();
    HashMap<String, String> restrictYNMap = bean.getDruginteractionYN(); 
%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /></link>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<title>Drug Interactions</title>
<script>

function storeDrugOverRemarks(mandCnt){
var data ="";
var remarks = "";
var queryString ="";
var di_called_from = document.getElementById("di_called_from").value;//IN072669
	for(var i=0; i < mandCnt; i++){
		data = document.getElementById("data"+i).value;
		remarks = document.getElementById("overRemarks"+data).value;//IN072669
		if(""== remarks){
			var msg = getMessage("CAN_NOT_BE_BLANK","eCommon");
			msg = msg.replace('$', "Override Remarks");
			alert(msg);
			return;
		}	
		queryString+= "interOverRmks"+data+"=\""+encodeURIComponent(remarks)+"\" ";//IN072669//IN072654
	}
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " p_bean_id=\""+document.getElementById("bean_id").value+ "\" ";
	xmlStr += " p_bean_name=\""+document.getElementById("bean_name").value+ "\" ";
	xmlStr += queryString;
	
	xmlStr += " p_action=\"DRUG_OVERRIDE_REMARKS\"";
	xmlStr += "/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "OrderLineIntermediate.jsp", false );
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText; 
	if("success" == trimString(responseText))
	{	
			window.close();
			if("RECORD" == di_called_from)//IN072669
				window.returnValue=true;//IN072669
	}
	
}
function  checkMandatory(){
	var indexfilled = 0;
	var di_called_from = document.getElementById("di_called_from").value;
	var mandCnt = document.getElementById("mandatoryCnt").value;
	for(var i=0; i < mandCnt; i++){
		data = document.getElementById("data"+i).value;
		remarks = document.getElementById("overRemarks"+data).value;//IN072669
		if(""== remarks){
			indexfilled++;
		}	
	}
	if(indexfilled==0  && "L_DRUG_INTERACTION" != di_called_from )
	{
		window.close();
		//IN072669
		if("RECORD" == di_called_from)
			window.returnValue=true;
	}
} 

</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"><!-- IN072592 --><!--Removed unload IN072669-->
	<form name="OrderDrugInteractionForm" id="OrderDrugInteractionForm" method="post">
		<table width='100%'  align='center' border="0">	
			<tr><td style="padding-left:10px;">		
		<%
		String	catalog_code ="";
		String newStartDate="";//IN072591
		String newEndDate="";//IN072591
		SimpleDateFormat fromformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//IN072591
		SimpleDateFormat toformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");//IN072591
		String status="";
		String catalog_desc="";
		String restrictYN ="";
		int mandatoryCnt = 0;
		ArrayList arrayList = new ArrayList();
		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
		StringTokenizer st1 = null;
		//IN072592 Starts
		
	    String overremarks ="";
		
		//IN072592 Ends
		if(null!=interdrugDtls){
    		for (Map.Entry<String,ArrayList<OrderDrugInteractionVO>> drugs : interdrugDtls.entrySet())  
			{
				catalog_code = drugs.getKey();
				
				catalog_desc = bean.getOrderCatalogDesc(catalog_code);
				st1= new StringTokenizer(catalog_desc, "~");
				while (st1.hasMoreTokens()) 
					catalog_desc = st1.nextToken(); 
				restrictYN = restrictYNMap.get(catalog_code);
    			if(!"H".equals(restrictYN)){//IN072595 %>
				<table width='100%' style="padding-left:50px;border-right: 1px solid #bbb;border-left: 1px solid #bbb;border-top: 1px solid #bbb;border-bottom: 1px solid #bbb;" align='center' border="0">	
				<tr><th class='columnHeadercenter' align ="center" > <%=catalog_desc%></th></tr>
				<tr> <td align="center">&nbsp;</td></tr>
			<% 	
				ArrayList<OrderDrugInteractionVO> interDrugsforLBOrder = drugs.getValue();
				for(int i=0;i<interDrugsforLBOrder.size();i++)
				{
					OrderDrugInteractionVO data=	interDrugsforLBOrder.get(i);    			
					status = data.getDrugRestrictYN();
					arrayList.add(data.getDrugCode());
					overremarks =  bean.getTempvalue("drugOverrideRemarks"+catalog_code+data.getDrugCode())==null?data.getOverrideRemarks():bean.getTempvalue("drugOverrideRemarks"+catalog_code+data.getDrugCode());//IN068314////IN072592
					if(null!=data.getDrugStartDate() && !"".equals(data.getDrugStartDate()))//IN072654
						newStartDate = toformat.format(fromformat.parse(data.getDrugStartDate()));//IN072591
					if(null!=data.getDrugEndDate() && !"".equals(data.getDrugEndDate()))	//IN072654
						newEndDate = toformat.format(fromformat.parse(data.getDrugEndDate()));//IN072591
					if("Y".equals(status))
					{
						status = "<font color='RED'>REJECT</FONT>";
					}else{
						status = "WARNING";
					}  
					//IN072627
					if(!"en".equals(localeName) && null!=newStartDate && null!=newEndDate)
					{
						newStartDate = DateUtils.convertDate(newStartDate,"DMYHM","en",localeName);
						newEndDate = DateUtils.convertDate(newEndDate,"DMYHM","en",localeName);
					}
				    //IN072627	
					%>
					<tr> <td align="left">
					<table width='99%' style="border-right: 1px solid #bbb;border-left: 1px solid #bbb;border-top: 1px solid #bbb;border-bottom: 1px solid #bbb;" align='center' border="0">
					<tr>
						<th class='columnHeadercenter' colspan="9" align ="left" ><fmt:message  key="Common.DrugName.label" bundle="${common_labels}"/>/Generic Name : <%=data.getDrugDesc() %></th><!-- IN073562 -->
					</tr>
					<tr> 
						<td width="20%" align="left" class="label"><fmt:message  key="Common.Drug.label" bundle="${common_labels}"/> <fmt:message  key="Common.StartDate.label" bundle="${common_labels}"/></td>
						<td width="2%" align="center" class="label">:</td>
						<td width="16%" align="left" class="data"><%=newStartDate %></td><!-- IN072591 -->
						<td width="12%" align="left" class="label"><fmt:message  key="Common.Drug.label" bundle="${common_labels}"/> <fmt:message  key="Common.enddate.label" bundle="${common_labels}"/></td>
						<td width="2%" align="center" class="label">:</td>
						<td width="16%" align="left" class="data"><%=newEndDate%></td><!-- IN072591 -->
						<td width="15%" align="left" class="label"><fmt:message  key="ePH.Interaction.label" bundle="${ph_labels}"/> <fmt:message  key="Common.status.label" bundle="${common_labels}"/></td>
						<td width="2%" align="center" class="label">:</td>
						<td width="13%" align="left" class="data"><%=status %></td>
					</tr>
					<tr> 
						<td width="20%" align="left" class="label"><fmt:message  key="ePH.Interaction.label" bundle="${ph_labels}"/> <fmt:message  key="Common.description.label" bundle="${common_labels}"/></td>
						<td width="2%"  align="center" class="label">:</td>
						<td width="78%" align="left" class="data" colspan="7"><%=data.getDrugRemarks() %></td>							
					</tr>
					<%				
					if(!"R".equals(restrictYN)){
						//mandatoryCnt++; //IN072592
					%>
					<input type="hidden" id = "data<%= mandatoryCnt%>" value="<%=catalog_code %><%= data.getDrugCode()%><%= i%>" /><!--IN072669-->
					<tr> 
						<td width="20%" align="left" class="label"><fmt:message  key="Common.override.label" bundle="${common_labels}"/> <fmt:message  key="ePH.Remarks.label" bundle="${ph_labels}"/></td>
						<td width="2%"  align="center" class="label">:</td>
						<td width="78%" align="left" class="fields" colspan="7">
							<textarea  rows="4" cols="90" maxLength="4000" onblur="makeValidString(this)" onpaste="makeValidString(this)" placeholder="Enter text here" id='overRemarks<%=catalog_code %><%= data.getDrugCode()%><%= i%>' ><%=overremarks %></textarea><!-- //IN072592 IN072669 -->
							&nbsp;<img src="../../eCommon/images/mandatory.gif">
						</td>							
					</tr>
					
					<!-- IN072595 -->
					<%
					mandatoryCnt++;//IN072592
					
					}
					%>
					
					</table>
					</td></tr>
				<%
				
				}
				
				%>
				<tr> <td align="center">&nbsp;</td></tr>
				</table>
				<%
				
				}
				
				%>
				<br>
				<%
			}
		}    
    %>	
    <input type="hidden" id = "mandatoryCnt" value="<%= mandatoryCnt%>" />
    <input type="hidden" id = "di_called_from" value="<%=druginter_called_from %>" />
    </td></tr>
    </table>
    <div>
    <table width='100%'  align='right' border="0">
    <tr><td width="20%" align="right">
    <%if(mandatoryCnt > 0){
    %><input type="button" value="Ok" class="button" onclick='javascript:return storeDrugOverRemarks("<%= mandatoryCnt%>")'/>
    <% }%><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'></td>
	</tr>
    </table>	
	</div>
    <input type="hidden"  id= "bean_id"  name = "bean_id" value="<%= bean_id%>" />
    <input type="hidden"  id = "bean_name" name = "bean_name" value="<%= bean_name%>" />
	</form>
</body>
<script>
checkMandatory();
</script>
</html>

