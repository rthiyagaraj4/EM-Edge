<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ page import ="java.text.ParseException,java.sql.Connection,java.sql.Timestamp,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>

<% 
request.setCharacterEncoding("UTF-8");	
java.util.Properties prop = null;
String client_ip_address="";
String login_user=""; 

prop = (java.util.Properties) session.getValue( "jdbc" ) ;
client_ip_address = prop.getProperty( "client_ip_address" );
login_user = prop.getProperty( "login_user" );
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;		
int seqNo=0;
String sql="";
//String previous_remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PreviousRemarks.Label","OH");
%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script lanaguage='javascript'>
	function windowClosing()
	{if(parseInt((document.forms[0].remarks.value).length )> 0)
		{
		 
			if((document.forms[0].remarks.value).length > 4000){
				alert(getMessage("APP-OH000158",'OH'));
				return false;
				
			}
			
			else{
				var formObj = document.forms[0];
				var remarks =document.getElementById("remarks").value;
			
				formObj.remarks.value = encodeURIComponent(remarks);
				
				 var xmlDoc="";
				 var xmlHttp = new XMLHttpRequest();
				 var arrObj = formObj.elements;
				 var frmObjs = new Array()
				 if(formObj.name == null){
					frmObjs = formObj ;
				 }
				 else{
					frmObjs[0] = formObj ;
				 }
				 var xmlStr ="<root><SEARCH ";
				 for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
					formObj = frmObjs[frmCount];
					var arrObj = formObj.elements;
					for(var i=0;i<arrObj.length;i++) {
						val = arrObj[i].value;
					//	alert("Name is ::" + arrObj[i].name+" Value is ::" + val);
						
						if(arrObj[i].name != null && arrObj[i].name != ""){
							xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
						}
					}
				}

	
			xmlStr +=" /></root>";
			//alert("xmlStr ::: " + xmlStr);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//beforePost(xmlStr) ;
			xmlHttp.open("POST", "PerioCommonValidation.jsp?func_mode=setRemarksHistory", false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			//alert(responseText);
			window.close();	
			
			}
	}
	}

	function setValue(){
		window.returnValue='CL_REM';
		window.close();
	}
function enCodeSpecialChars(){
	  	 obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		document.forms[0].remarks.value += encodeURIComponent(obj);
   		}
		else
		{
			document.forms[0].remarks.value +=obj;
		}
   	}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<% 
		String title=checkForNull(request.getParameter("heading"));
		String readOnly="";
		String disabled="";
		String readOnlyYN=checkForNull(request.getParameter("readOnlyYN"));
		if(readOnlyYN.equals("Y")){	   
			readOnly="readOnly";
			disabled = "disabled";
		}
	
		String patient_id = request.getParameter("patient_id"); 
		String chart_code = request.getParameter("chart_code"); 
		String chart_num = request.getParameter("chart_num"); 
		String chart_line_num = request.getParameter("chart_line_num"); 
			
	 %>

<TITLE><%=title%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>

<BODY class="MESSAGE" OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form>
<table  cellspacing='0'>
<tr>
	<td>
		
		<textarea name='remarks' rows='5' cols='67' <%=readOnly%>   id='remarks'></textarea>
	</td>
</tr>
<tr>
	<td class='MESSAGE' align='center'>
		
		<input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='windowClosing();' <%=disabled%>>
		<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="setValue()">
		
</td>
</tr>
</table>
	

  <input type="hidden" name='patient_id' id='patient_id' value="<%=patient_id%>" >
  <input type="hidden" name='chart_num' id='chart_num' value="<%=chart_num%>" >
  <input type="hidden" name='chart_line_num' id='chart_line_num' value="<%=chart_line_num%>" >
  <input type="hidden" name='chart_code' id='chart_code' value="<%=chart_code%>" >
  <%
 try{
		
		con = ConnectionManager.getConnection(request);	
  //The below code gets the REM_SEQ_NUM from OH_PERIODONTAL_CHART_REMARKS table
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		sql="SELECT REM_SEQ_NUM FROM OH_PERIODONTAL_CHART_REMARKS WHERE PATIENT_ID=? AND CHART_NUM = ? AND CHART_CODE= ?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		//pstmt.setString(3,chart_line_num);
		pstmt.setString(3,chart_code);
		rs=pstmt.executeQuery();
		while(rs.next()){
			seqNo=Integer.parseInt(checkForNull(rs.getString("REM_SEQ_NUM"),"0"));
		}
		seqNo=seqNo+1;
			
%>

  
<input type="hidden" name='rem_seq_no' id='rem_seq_no' value="<%=seqNo%>" >
  <input type="hidden" name='added_by_id' id='added_by_id' value="<%=login_user%>" > 
  <input type="hidden" name='added_at_ws_no' id='added_at_ws_no' value="<%=client_ip_address%>" > 
 <%
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		   }catch(Exception es){es.printStackTrace();}
	}
%>

</form>
</body>
</HTML>

