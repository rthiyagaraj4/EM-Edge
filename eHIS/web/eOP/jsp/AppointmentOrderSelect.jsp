<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
 
<%
	
	request.setCharacterEncoding("UTF-8");
	String bean_id ="refusalOrdersBean";
	String bean_name = "eOR.RefusalOrdersBean";		
    localeName=(String)session.getAttribute("LOCALE");	
	RefusalOrdersBean beanObj = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;	
	beanObj.setLanguageId(localeName);
%>
<html>
<head>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
	<script src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js'></script>
	<script language="JavaScript" src="../js/Orderable.js"></script>
	<Script src="../../eOP/js/VisitRegistration1.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<script>
	function getDescriptionOrder(obj,key,count)
	{  
		var rowno=rowno-1; 
		var bean_id=document.getElementById("bean_id").value;
		var bean_name=document.getElementById("bean_name").value;
		/*var value=eval("document.getElementById("short_desc")"+count).value;
		var order_type_code=eval("document.getElementById("order_type_code1")"+count).value; 
		var order_category=eval("document.getElementById("order_category1")"+count).value; */
		
		var value=document.getElementById('short_desc'+count).value;
		var order_type_code=document.getElementById('order_type_code1'+count).value;
		var order_category=document.getElementById('order_category1'+count).value;
		/*value=document.getElementById("short_desc")+count+.value;
		order_type_code=document.getElementById("order_type_code1")+count+.value; 
		order_category=document.getElementById("order_category1")+count+.value; */			
		/*alert("value==>"+value);
		alert("order_type_code===>"+order_type_code);
		alert("order_category===>"+order_category);	*/
		
		
		if(obj.checked)
		{	
			
			var functional_mode="Add_Temp_Order_Catalog";
			var order="validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
		
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");			
			
			xmlHttp.open( "POST", "../../eOR/jsp/OrderableValidate.jsp?"+order,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ; 
			var responseTxt = eval(responseText); 
			if(responseTxt=="ORDER_SET_SELECTED")
			{
				alert(getMessage("ORDER_SET_SELECTED","OR"));
				obj.checked = false;
				return; // Don't allow the user to select more than one
			}
		
		}
		else 
		{ 
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
		
			var functional_mode="Remove_Temp_Order_Catalog";
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			xmlHttp.open( "POST", "../../eOR/jsp/OrderableValidate.jsp?validate="+functional_mode+"&key="+key+"&value="+encodeURIComponent(value)+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code="+order_type_code+"&order_category="+order_category,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText );
		}
		
}
	function addCatalog(orderSet)
	{ 
		return orderSet;
	}
	
	</script>
	
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onunload="SelectOrderUnload()">
<!-- <form name='AppointmentOrderResult' id='AppointmentOrderResult' action="AppointmentOrderSelect.jsp?<%=request.getQueryString()%>"  method='post'>-->
		 <form name='AppointmentOrderResult' id='AppointmentOrderResult' action="AppointmentOrderSelect.jsp"  method='post'>
			<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>
		<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>
<%
	String appt_ref_no= (request.getParameter("appt_ref_no")==null||request.getParameter("appt_ref_no").equals("null"))?"":request.getParameter("appt_ref_no");
	String appt_order= (request.getParameter("appt_order")==null||request.getParameter("appt_order").equals("null"))?"":request.getParameter("appt_order");
	String facility_id = (String)session.getValue("facility_id");
				
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;	
	int maxRecord = 0;
	int counts=0;
	String order_category1 = "",order_type_code1="";
	String option_id	= "";
	String short_desc	= "";
	int ilCkeckedYN = 0;		
	String checkProp = "";	
	String classValue="";			
	String validateIDFn="";
	StringBuffer sql = new StringBuffer();
	
	//putObjectInBean("refusalOrdersBean",beanObj,request);	

	try
	{
		con = ConnectionManager.getConnection(request);
		
		sql.append("SELECT   a.order_catalog_code, or_get_desc.or_order_catalog (a.order_catalog_code, '"+localeName+"','2') long_desc, order_catalog_nature order_catalog_nature, order_category, order_type_code FROM  or_order_catalog a, OR_APPT_REF_CATALOG b where APPT_REF_NO='"+appt_ref_no+"' and FACILITY_ID ='"+facility_id+"' and a.ORDER_CATALOG_CODE =b.ORDER_CATALOG_CODE");
	   
		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		//maxRecord = rs.getRow();
		//int tot_records=rs.getRow();
		
		
	
%>


<table>	 
 	<tr><td clospan='3'><div style="position:relative;height:8vh0px;width:780px;vertical-align:top;overflow:auto"> 
	  <table border='10' cellpadding='3' cellspacing='0' width='100%' align='center'>
		
<%	while(rs.next())	
		{  
			
			counts++;
			option_id = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
			short_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
			order_category1 = rs.getString("order_category")==null?"":rs.getString("order_category");
			order_type_code1 = rs.getString("order_type_code")==null?"":rs.getString("order_type_code");
		    
			//checkProp = " CHECKED "; 
						
			classValue="gridData";
			
			option_id=java.net.URLEncoder.encode(option_id,"UTF-8");  
			
			//validateIDFn ="onclick='getDescription(this,"+option_id+","+counts+")'";
			//validateIDFn ="onclick='getDescriptionOrder(this,"+option_id+","+counts+")'";
			//System.out.println("validateIDFn==>"+validateIDFn);
            %>
           
			<tr>
			<td class='<%=classValue%>'><%=option_id%></td>
			<td class='<%=classValue%>'><%=short_desc%></td>
			<td class='<%=classValue%>' align='left'><input type='checkbox' name="chk<%=ilCkeckedYN%>" id="chk<%=ilCkeckedYN%>" value="<%=option_id%>$$<%=short_desc%>$$<%=order_type_code1%>$$<%=order_category1%>"  >
			
			<input type="hidden" name="option_id<%=counts%>" id="option_id<%=counts%>" id="option_id<%=counts%>" value="<%=option_id%>">			
			<input type="hidden" name="short_desc<%=counts%>" id="short_desc<%=counts%>" id="short_desc<%=counts%>" value="<%=short_desc%>">
			<input type="hidden" name="order_type_code1<%=counts%>" id="order_type_code1<%=counts%>" id="order_type_code1<%=counts%>" value="<%=order_type_code1%>">
			<input type="hidden" name="order_category1<%=counts%>" id="order_category1<%=counts%>" id="order_type_code1<%=counts%>" value="<%=order_category1%>">
	
            
			</td></tr>	
			<script>document.AppointmentOrderResult.chk<%=ilCkeckedYN%>.checked=true;getDescriptionOrder(document.AppointmentOrderResult.chk<%=ilCkeckedYN%>,decodeURIComponent(document.AppointmentOrderResult.option_id<%=counts%>.value,'UTF-8'),"<%=counts%>");document.AppointmentOrderResult.chk<%=ilCkeckedYN%>.disabled=true;</script>
				
          <%ilCkeckedYN = ilCkeckedYN + 1;		
			//i=i+1;			
				
		}	
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
%>	
	</table></div></td></tr>	
	<tr><td clospan='3'>&nbsp;</td></tr>
	<tr><td clospan='3' align='center' class='button'><input type='button' name="clicksubmit" id="clicksubmit"  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  onclick='submitOrderable()' class='BUTTON'>&nbsp;&nbsp;&nbsp;</td></tr>
	</table>			
<%
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	}
%>

<script>

/*setTimeout("SelectOrder()",500);
function SelectOrder(){
document.AppointmentOrderResult.clicksubmit.onclick();
}*/
var call_count=1;
function SelectOrderUnload(){
 if(call_count=="1")submitOrderable();
}
function submitOrderable()
{  
    call_count=call_count+1;  
	
	var bean_id=document.getElementById("bean_id").value;
	var bean_name=document.getElementById("bean_name").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	var functional_mode="Submit_Order_Catalog";
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;  
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST", "../../eOR/jsp/OrderableValidate.jsp?validate="+functional_mode+"&bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ; 
	eval(responseText ); 
	//window.close();	
	setTimeout("Winclose()",350);
	
}
function Winclose(){
window.close();
}
</script>
<%putObjectInBean("refusalOrdersBean",beanObj,request);	%>
</form>
</body>
</html>


