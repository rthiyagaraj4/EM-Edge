<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
16-Nov-2013      100           	Karthikeyan.K          created for MMS-CRF-0023
---------------------------------------------------------------------------------------------------------------
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ page import= "eBL.*,eBL.Common.*,webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ page import="eBL.Common.BlRepository"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/> 
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>   
<script> 
/* MMS-SCF-0389- Karthik added the below function for to allow Zero in Parial Deposit , provided Partial Depository Mandatory flag is unchecked*/
function partialDepositDataValidation(index){
	var depositMandatoryYN=eval("document.PkgDefBasePriceDepositForm.depositMandatoryYN"+index);
	var partialDepositValue=eval("document.PkgDefBasePriceDepositForm.partialDeposit"+index).value;
	if(parseInt(partialDepositValue)==0){
		depositMandatoryYN.checked=false;
		depositMandatoryYN.value='false';
	}
}
function depositMandatoryChkBox(index){
	var depositMandatoryYN=eval("document.PkgDefBasePriceDepositForm.depositMandatoryYN"+index);
	var partialDepositValue=eval("document.PkgDefBasePriceDepositForm.partialDeposit"+index).value;
	
	
	if(depositMandatoryYN.checked){
			if(partialDepositValue=='' || parseInt(partialDepositValue)==0){ // MMS-SCF-0389- Karthik added the below logic for to allow Zero in Parial Deposit , provided Partial Depository Mandatory flag is unchecked
				alert("Partial Deposit Value cannot be null or Zero");
				depositMandatoryYN.checked=false;
				depositMandatoryYN.value='false';
			}else{
				depositMandatoryYN.value='true';
			}
	}else{
		depositMandatoryYN.value='false';
	}
}

function pkgPriceDepositAdd(){
	if(doPartialDepositPageValidation()==true){
	
	var form=document.PkgDefBasePriceDepositForm;	
	var errMsg=partialDepositValidation(form);
	
	if(errMsg==''){

	var table = document.getElementById('pkgPriceDepositTable');
	document.PkgDefBasePriceDepositForm.recordCount.value=table.rows.length;
	var index=table.rows.length-1;//-1 because iteration normally shud start with 0 on retreiving page.

	//alert(index);
	var row=document.getElementById('pkgPriceDepositTable').insertRow();
	var cell1=row.insertCell(0);
	var cell2=row.insertCell(1);
	var cell3=row.insertCell(2);
	var cell4=row.insertCell(3);
	
	var seqNo=index+1;
	cell1.innerHTML="<input type='text' size='5' name='encSeqNo"+index+"' id='encSeqNo"+index+"' value='"+seqNo+"'>";
	cell2.innerHTML="<select id='partialDepositType"+index+"' name='partialDepositType"+index+"' id='partialDepositType"+index+"' ><option value='P'>Percentage</option><option value='A'>Amount</option></select>";
	cell3.innerHTML="<input type='text' name='partialDeposit"+index+"' id='partialDeposit"+index+"' value='' onblur='partialDepositDataValidation("+index+")'>";//// MMS-SCF-0389- Karthik added onblur to allow Zero in Parial Deposit , provided Partial Depository Mandatory flag is unchecked
	cell4.innerHTML="&nbsp;&nbsp;<input type='checkbox' checked value='true' name='depositMandatoryYN"+index+"' id='depositMandatoryYN"+index+"' onclick='depositMandatoryChkBox("+index+")'>";//48042
		
	var objDiv = document.getElementById("pkgPriceDepositTableDiv");
	objDiv.scrollTop = objDiv.scrollHeight;
	window.scrollTo(0, objDiv.scrollHeight);
	}
	else{
		alert(errMsg);
	}
	}
}

function partialDepositValidation(previlageCardForm){
	for(var i=0; i<previlageCardForm.elements.length; i++)
	{
	var fieldName=previlageCardForm.elements[i].name;
	var indexFound=fieldName.indexOf("partialDeposit");
		if(indexFound!=-1){
			if(previlageCardForm.elements[i].value=='')
			return "Partial Deposit value should be Provided";
		}
	}
	return "";
}

/* Provide Input FormObject(POST requestXML) and JSP Page for that FormObject Processing  */
function doPartialDepositValidationMain() {

if(doPartialDepositPageValidation()==true){
	var frmObj=document.PkgDefBasePriceDepositForm;
	var temp_jsp="../../eBL/jsp/PkgDefBasePricePartialDepositValidation.jsp?action=submit";
			
			if(frmObj!="" && frmObj!=null && frmObj !=undefined )
			{
			var xmlString=formXMLStringMain(frmObj);
			var updation=formValidation(xmlString,temp_jsp);
			}
	
	var recCount=frmObj.recordCount.value
	if(recCount>0){
	window.returnValue=document.PkgDefBasePriceDepositForm.partialDepositType0.value+"|"+document.PkgDefBasePriceDepositForm.partialDeposit0.value;
	}else{//48042
	window.returnValue="|";	
	}
	window.close(); 
}
}

function doPartialDepositPageValidation()
{
	var frmObj=document.PkgDefBasePriceDepositForm;
	var count=frmObj.recordCount.value;
	var pkgPrice=frmObj.pkgPrice.value;
	var manipulatedAmount=0;
	var totalPercentage=0;
	for(var i=0;i<count;i++){
		if(eval("document.PkgDefBasePriceDepositForm.partialDepositType"+i).value =='P'){
		manipulatedAmount	+= (parseFloat(eval("document.PkgDefBasePriceDepositForm.partialDeposit"+i).value)  *  pkgPrice/100.0 );
		totalPercentage		+=  parseFloat(eval("document.PkgDefBasePriceDepositForm.partialDeposit"+i).value);
		}else{		
		manipulatedAmount	+=  parseFloat(eval("document.PkgDefBasePriceDepositForm.partialDeposit"+i).value);		
		}
	}
	
	if(totalPercentage>100){
	alert('Total Partial Deposit Percentage must not exceed 100');
	return false;
	}
			
	if(manipulatedAmount>pkgPrice){
	alert("The entered Amount " +manipulatedAmount+ " cannot be greater than Package Price "+ pkgPrice);
	return false;
	}

 return true;
}

function deleteFromSession() {

	var frmObj=document.PkgDefBasePriceDepositForm;
	var temp_jsp="../../eBL/jsp/PkgDefBasePricePartialDepositValidation.jsp?action=delete";
			
			if(frmObj!="" && frmObj!=null && frmObj !=undefined )
			{
			var xmlString=formXMLStringMain(frmObj);
			var updation=formValidation(xmlString,temp_jsp);
			}	
	window.location.href=window.location.href+"&deleteCode=Y";//47933 delete Issue
	}


//XML String passing for validation
function formValidation(xmlStr,temp_jsp)
{	
/*var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
xmlDoc.loadXML(xmlStr);*/

var xmlHttp = new XMLHttpRequest();
var xmlDoc = "";
new DOMParser().parseFromString(getXMLString(xmlStr), "text/xml");
xmlHttp.open("POST",temp_jsp,false);
xmlHttp.send(xmlDoc);
var responseText=xmlHttp.responseText ;
return true;
}	

function formXMLStringMain(frmObj)
{
if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
{	
	var xmlStr ="<root><SEARCH ";
	if(true)
	{
	var arrObj = frmObj.elements;
	for(var i=0;i<arrObj.length;i++)
	{
		var val = "" ;
		if(arrObj[i].type == "checkbox")
		{
			val = arrObj[i].value;
			if(arrObj[i].name != null && arrObj[i].name != "")
				xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
        }
	    else if(arrObj[i].type == "radio")
		{
			if(arrObj[i].checked)
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
	    }
		else if(arrObj[i].type == "select-multiple" )
		{
			for(var j=0; j<arrObj[i].options.length; j++)
		    {
				if(arrObj[i].options[j].selected)
					val+=arrObj[i].options[j].value +"~";
            }
	        val= val.substring(0,val.lastIndexOf('~'));
		    if(arrObj[i].name != null && arrObj[i].name != "")
			    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
		}
	    else
		{
			val = arrObj[i].value;
	        if(arrObj[i].name != null && arrObj[i].name != "")
				xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
        }
	}
}
xmlStr +=" /></root>";	
}
return xmlStr;
}

function checkSpl( val ) {
    var result = "" ;
    var ch = "" ;

    var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
    {
        val = val.replace("\n","\"");
    }

    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
    for(var i=0; i<val.length; i++) {
        for(var j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }
    return result ;
}

</script>
<%!

public String QueryReplacer(String query,String locale){
	query=query.replace("@locale", "'"+locale+"'");
	return query;
}
%>
<% 

String locale=(String)session.getAttribute("LOCALE");
String facility_id=(String)session.getAttribute("facility_id");
String blgClsCode=request.getParameter("blgClsCode");
String packageCode=request.getParameter("packageCode");
String effFromDate=request.getParameter("effFromDate");
String pkgPrice=request.getParameter("pkgPrice");
String modifyStatus = request.getParameter("modifystatus");

String deleteCode="N";//47933 delete Issue
deleteCode=request.getParameter("deleteCode");
if(deleteCode==null)deleteCode="N";

System.out.println("PartialDepositPage Called, blgClsCode,deleteCode:"+blgClsCode + packageCode + effFromDate+deleteCode);

HashMap<String,ArrayList<String>> dataMap=new HashMap<String,ArrayList<String>>();
ArrayList<String> partialDepositList=null;

String beanId = "bl_PkgDefBean";
String beanName = "eBL.PkgDefBean";
PkgDefBean bean=(PkgDefBean) getBeanObject(beanId, beanName, request);

/* Checks whether data is already present in Session */
dataMap=bean.getPartialDepositList();
partialDepositList=dataMap.get(blgClsCode);
System.out.println("partialDepositList from sess :"+partialDepositList);

/* If it is not Present in Session fetch from DB */
if( (partialDepositList==null || partialDepositList.size()==0) && deleteCode.equals("N") && dataMap.containsKey(blgClsCode) == false ){//47933 delete Issue
	
	bean.fetchPartialDepositList(blgClsCode,facility_id,packageCode,effFromDate);
//bean.fetchPartialDepositList(blgClsCode,facility_id,effFromDate,packageCode);
dataMap=bean.getPartialDepositList();
partialDepositList=dataMap.get(blgClsCode);
System.out.println("partialDepositList from DB :"+partialDepositList);
}

if(partialDepositList==null) partialDepositList=new ArrayList<String>();

System.out.println("blgClsCode:"+blgClsCode);
System.out.println("dataMap:"+dataMap);
System.out.println("partialDepositList:"+partialDepositList);
int i=0;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	onSelect="codeArrestThruSelect();">

	<FORM name="PkgDefBasePriceDepositForm" id="PkgDefBasePriceDepositForm" >
	<TABLE width='100%' border='0' cellpadding='3' cellspacing='0'>
			<tr>
			<td width='50%' class='fields'> </td>			
			<td width='50%' class='fields'> <input type='button' class='button'  value='<fmt:message key="Common.Add.label" bundle="${common_labels}" />' size='20'  onClick='pkgPriceDepositAdd();' <%=modifyStatus%>>
			<input type='button' class='button'  value='<fmt:message key="Common.delete.label" bundle="${common_labels}" />' size='20'  onClick='deleteFromSession();' <%=modifyStatus%> >
			<input type='button' class='button'  value='<fmt:message key="Common.Submit.label" bundle="${common_labels}" />' size='20'  onClick='doPartialDepositValidationMain();' <%=modifyStatus%>>
			</td>
			</tr>
	</TABLE>
	<div id="pkgPriceDepositTableDiv" STYLE="width:100%; height:300; overflow: auto;">
	<TABLE width="100%" border='0' cellpadding='3' cellspacing='0'>

	</TABLE>

	<TABLE  width="100%"  id="pkgPriceDepositTable" border='0' cellpadding='3' cellspacing='0'>
			<tr>
			<th width="10%"><fmt:message key="eBL.EncounterSequenceNo.label" bundle="${common_labels}" /></th>
			<th width="15%"><fmt:message key="eBL.PartialDepositType.label" bundle="${common_labels}" /></th>
			<th width="15%"><fmt:message key="eBL.PartialDeposit.label" bundle="${common_labels}" /></th>
			<th width="15%"><fmt:message key="eBL.PartialDepositMandatory.label" bundle="${common_labels}" /></th>
			<th width="10%"><fmt:message key="Common.delete.label" bundle="${common_labels}" /></th>
			<th width="*"></th>
			</tr>	
	<% 
	
	for(i=0;i<partialDepositList.size();i++) {	
		
		StringTokenizer st=new StringTokenizer(partialDepositList.get(i),"~");
		String partialDepositSeq="";
		String partialDepositType="";
		String partialDepositValue="";
		String partialDepositMandatory="";
		
		while(st.hasMoreTokens()){
			partialDepositSeq=st.nextToken();
			partialDepositType=st.nextToken();
			partialDepositValue=st.nextToken();
			partialDepositMandatory=st.nextToken();
		}				
	
	%>
			<tr>
			<td width="10%"><input type="text" size='5' name='encSeqNo<%=i%>' id='encSeqNo<%=i%>' value='<%=i+1%>' <%=modifyStatus%>></td>
			<td width="15%">
				<select id='partialDepositType<%=i%>' name='partialDepositType<%=i%>'  <%=modifyStatus%>>
				<option <%if(partialDepositType.equals("P")){%>selected<%}%> value='P'>Percentage</option>
				<option <%if(partialDepositType.equals("A")){%>selected<%}%> value='A'>Amount</option>				
				</select>
			</td>
			<!-- 	 MMS-SCF-0389- Karthik added the below logic for to allow Zero in Parial Deposit , provided Partial Depository Mandatory flag is unchecked -->
			<td width="15%"><input type="text" name='partialDeposit<%=i%>' id='partialDeposit<%=i%>' value='<%=partialDepositValue%>' <%=modifyStatus%> onblur='partialDepositDataValidation(<%=i%>)'></td>
			<td width="15%">&nbsp;&nbsp;<input type="checkbox" name='depositMandatoryYN<%=i%>' id='depositMandatoryYN<%=i%>'  <%if(partialDepositMandatory.equals("Y")){%>checked value='true'<%}else{%>value='false'<%}%> onclick='depositMandatoryChkBox(<%=i%>)' <%=modifyStatus%>>
			<td width="10%">&nbsp;&nbsp;<input type="radio" name='deletePartialRecord' id='deletePartialRecord' value='<%=i+1%>' <%=modifyStatus%>></td>	
			<td width="*"></td>
			</tr>
	<% } %>
		</TABLE> 
	</div>
	
	<input type='hidden' name='blgClsCode' id='blgClsCode' value="<%=blgClsCode%>">	
	<input type='hidden' name='pkgPrice' id='pkgPrice' value="<%=pkgPrice%>">		
	<input type='hidden' name='recordCount' id='recordCount' value="<%=partialDepositList.size()%>">	
	</FORM>


</body>
</html>

