<!DOCTYPE html>
<!--
-----------------------------------------------------------------------
Date       		Edit History   Name       Description
-----------------------------------------------------------------------
22/03/2013	IN030469	DineshT		Order Entry Place order screen to show catalogs on load
07/05/2013  IN039476	Akbar		Not to display Place order button for patient without encounter
27/07/2022	26826		Ramesh G	MMS-DM-CRF-0197
-----------------------------------------------------------------------
-->
<%@ page import ="eOR.*,java.sql.*,java.util.*,java.net.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String reqString = request.getQueryString();
reqString=reqString.replaceAll("&option_id=CA_HEALTH_RISK","&option_id=NEW_ORDER");
String patid=request.getParameter("Patient_ID"); 
String encId=request.getParameter("encounter_id"); 
String defaultDiag = request.getParameter("TermSetCode")==null?"":(String)request.getParameter("TermSetCode");
String[] defaultDiag_=defaultDiag.split("\\|");
defaultDiag="";
for(int i=0;i<defaultDiag_.length;i++){
	defaultDiag=defaultDiag+"'"+defaultDiag_[i]+"'";
	if((i+1)!=defaultDiag_.length)
		defaultDiag=defaultDiag+",";
}
//26826 Start.
String patient_class =request.getParameter("patient_class")==null?"":(String)request.getParameter("patient_class");
String facility_id				= (String)session.getValue("facility_id");
String or_bean_id 						= "@orderentrybean"+patid+encId;
String or_bean_name 					= "eOR.OrderEntryBean";
OrderEntryBean bean					= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
bean.setLanguageId(localeName);
HashMap  dxChkBfrPlaceOrderMap=new HashMap();
//26826 End.	
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCA/js/RiskFactorGroup.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var check_box_value = new Array();
var totalChecked = 0;

async function showPlaceOrderScreen(reqString,patId,encId)
{
	
	//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;

var xmlDoc = ""; 
var xmlHttp = new XMLHttpRequest();	
 	xmlStr					= "<root><SEARCH " ;

	if(parseInt(totalChecked)==0)
	{
		alert("APP-CA0401 Atleaset one catalog should be selected");
		return;
	}

	form_obj = document.CAHealthRiskAssessmentOrderCatalogsForm;

   	var formObj 			= form_obj.elements;
	
	for(var i=0;i<formObj.length;i++)
	{
		var value 		= "" ;

		if(formObj[i].type == "checkbox")
		{
			if(formObj[i].checked && !formObj[i].disabled)
				value 	= formObj[i].value;

			if(formObj[i].name != null && formObj[i].name != "" && !formObj[i].disabled)
				xmlStr	+= formObj[i].name+"=\"" + (value) + "\" " ;//IN030469
		}
		else if(formObj[i].type == "hidden")
		{
			value	= formObj[i].value;
			xmlStr	+= formObj[i].name+"=\"" + escape(value) + "\" " ;
		}
	}
	xmlStr += " CHECK_BOX_VALUE = \""+check_box_value+"\" ";

	bean_id = "@orderentrybean"+patId+encId;
	bean_name = "eOR.OrderEntryBean";
	
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/OrderEntryStoreValues.jsp?"+reqString+"&bean_id=" + bean_id + "&bean_name="+ bean_name+"&function_from=STORE_ASSESS_CATALOG&l_patientId="+patId+"&l_encounter_id="+encId, false ) ;//IN030469
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

	var dialogHeight ='90vh' ;
	var dialogWidth = '90vw' ;
	var dialogTop	= '';
	var dialogLeft = '' ;

	reqString = "option_id=NEW_ORDER&"+reqString
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var retVals = await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+reqString+"&function_from=HIGH_RISK_ASSESS&bean_id="+bean_id+"&bean_name="+bean_name+"&check_box_value="+check_box_value,arguments,features);
	
}

//function onclickCatalog(thisObj)  //26826
function onclickCatalog(thisObj,orderCategory)//26826
{		
	if(thisObj.checked)
	{	if(eval("document.CAHealthRiskAssessmentOrderCatalogsForm.dxChkBfrPlaceOrder"+orderCategory).value=='Y' && document.CAHealthRiskAssessmentOrderCatalogsForm.dxChkBfrPlaceOrderSpec.value=="Y" ){  ////26826
			check_box_value[check_box_value.length]=thisObj.name;
			totalChecked = parseInt(totalChecked)+1;
		//26826 Start.
		}else{
			alert(getMessage("DIAG_NOT_RECORDED","OR"));
			thisObj.checked=false;
		}
		////26826 End.
	}
	else
	{
		for(i=0;i<check_box_value.length;i++)
		{
			if(thisObj.name == check_box_value[i])
			{
				delete(check_box_value[i]);		
				totalChecked = parseInt(totalChecked)-1
			}
		}
	}	
}
</script>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='CAHealthRiskAssessmentOrderCatalogsForm' id='CAHealthRiskAssessmentOrderCatalogsForm'>
<table cellpadding='0' cellspacing='0' border='0' width='100%'>	
	<tr style="height:30px" width='100%'>
		<th class='columnHeadercenter' colspan="2" width="100%" align="center">Order Catalogs for Screening</th>
		<!--IN039476/start-->
		<%
		if(!"".equals(encId)){
		%>
		<!--IN039476/End-->
		<th class='columnHeadercenter'  width="100%" align="right"><input type="button"  value="Place Order" onclick="showPlaceOrderScreen('<%=reqString%>','<%=patid%>','<%=encId%>')" /></th>
		<% } %>  <!--IN039476-->
	</tr>

	<tr width='100%'>
		<td valign="top" colspan="3">
			<DIV style="height:160px;overflow:auto;" id ='catalogTable'>
			
			
				<table cellpadding='0' cellspacing='0' border='0' width='100%'>					
				<%
				PreparedStatement pstmt2 = null;
				ResultSet rs2 = null;
				Connection con = null;
				System.out.println("	CAHealthRiskAssessmentOrderCatalogs.jsp===============>"+defaultDiag+"<------");
				String qry2 = "SELECT distinct A.ORDER_CATALOG_CODE CODE,B.SHORT_DESC DESCRIPTION,b.ORDER_CATEGORY,b.ORDER_TYPE_CODE FROM OR_ORDER_SET_COMPONENT A, OR_ORDER_CATALOG B WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE AND A.ORDER_SET_CODE IN (SELECT ORDER_SET_CODE FROM OR_ORDER_SET_BY_INDEX WHERE DIAGNOSIS_CODE IN ("+defaultDiag+"))";

				System.out.println("CAHealthRiskAssessmentOrderCatalogs.jsp,100,qry2=>"+qry2);
				try
				{
					con = ConnectionManager.getConnection(request);
					//int cnt = 0; //Checkstyle 4.0 Beta 6
					
					pstmt2 = con.prepareStatement(qry2);
					rs2 = pstmt2.executeQuery();					

					while(rs2!=null && rs2.next())
					{
						//String ORDER_CATALOG_CODE  = rs2.getString("CODE")==null?"":(String)rs2.getString("CODE"); //Checkstyle 4.0 Beta 6
						String catalogCode1 = "<input type ='checkbox' name = 'ck"+rs2.getString("CODE")+"' value='Y' onclick = \"onclickCatalog(this,'"+rs2.getString("ORDER_CATEGORY")+"')\"/>";
						catalogCode1 = catalogCode1 + "<input type = 'hidden' name = 'h1"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_CATEGORY")+"'/>";//IN030469
						catalogCode1 = catalogCode1 + "<input type = 'hidden' name = 'h2"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_TYPE_CODE")+"'/>";//IN030469
						String catalogDesc1 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");
						String catalogCode2 = "&nbsp;";
						String catalogDesc2 = "&nbsp;";
						String catalogCode3 = "&nbsp;";
						String catalogDesc3 = "&nbsp;";
						String catalogCode4 = "&nbsp;";
						String catalogDesc4 = "&nbsp;";
						catalogDesc1 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");//IN030469
						if(rs2.next()){
							catalogCode2 = "<input type ='checkbox' name = 'ck"+rs2.getString("CODE")+"' value='Y' onclick = \"onclickCatalog(this,'"+rs2.getString("ORDER_CATEGORY")+"')\"/>";
							catalogCode2 = catalogCode2 + "<input type = 'hidden' name = 'h1"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_CATEGORY")+"'/>";
							catalogCode2 = catalogCode2 + "<input type = 'hidden' name = 'h2"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_TYPE_CODE")+"'/>";
							catalogDesc2 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");
						}
						if(rs2.next()){
							catalogCode3 = "<input type ='checkbox' name = 'ck"+rs2.getString("CODE")+"' value='Y' onclick = \"onclickCatalog(this,'"+rs2.getString("ORDER_CATEGORY")+"')\"/>";
							catalogCode3 = catalogCode3 + "<input type = 'hidden' name = 'h1"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_CATEGORY")+"'/>";
							catalogCode3 = catalogCode3 + "<input type = 'hidden' name = 'h2"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_TYPE_CODE")+"'/>";
							catalogDesc3 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");
						}
						if(rs2.next()){
							catalogCode4 = "<input type ='checkbox' name = 'ck"+rs2.getString("CODE")+"' value='Y' onclick = \"onclickCatalog(this,'"+rs2.getString("ORDER_CATEGORY")+"')\"/>";
							catalogCode4 = catalogCode4 + "<input type = 'hidden' name = 'h1"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_CATEGORY")+"'/>";
							catalogCode4 = catalogCode4 + "<input type = 'hidden' name = 'h2"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_TYPE_CODE")+"'/>";
							catalogDesc4 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");
						}
						System.out.println("CAHealthRiskAssessmentOrderCatalogs.jsp,138,catalogCode1=>"+catalogCode1+",catalogCode2=>"+catalogCode2+",catalogCode3=>"+catalogCode3+",catalogCode4=>"+catalogCode4);
					%>				
						<tr>					
							<td width="20%" class='fields'>
								<%=catalogDesc1%>
							</td>
							<td width="5%">
								<%=catalogCode1%>
							</td>	
							<td width="20%" class='fields'>
								<%=catalogDesc2%>
							</td>
							<td width="5%">
								<%=catalogCode2%>
							</td>
							<td width="20%" class='fields'>
								<%=catalogDesc3%>
							</td>
							<td width="5%">
								<%=catalogCode3%>
							</td>
							<td width="20%" class='fields'>
								<%=catalogDesc4%>
							</td>
							<td width="5%">
								<%=catalogCode4%>
							</td>
						</tr>
					<%
					}
					
					
					dxChkBfrPlaceOrderMap = bean.allowedNewOrders(patid,encId,patient_class,facility_id,"");//26826
				}
				catch(Exception e)
				{
					e.printStackTrace();				
				}finally
				{
						if(pstmt2!=null)pstmt2.close();			
						if(rs2!=null)rs2.close();
						if(con!=null)con.close();
				}
				%>				
				</table>
				<input type="hidden" name ="dxChkBfrPlaceOrderSpec" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderSpec")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderMI" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderMI")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderOT" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOT")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderCN" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCN")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderLB" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderLB")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderTR" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderTR")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderPC" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPC")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderPH" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPH")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderNC" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderNC")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderDS" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderDS")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderRX" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRX")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderRD" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRD")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderCS" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCS")%>"> <!-- 26826 -->
				<input type="hidden" name ="dxChkBfrPlaceOrderOH" value="<%=(String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOH")%>"> <!-- 26826 -->
			</DIV>
		</td>
	</tr>
</table>
</form>
</body>
</html>

