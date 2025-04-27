<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<HTML>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//RUT-CRF-0091
Connection con=null;
PreparedStatement pstmt_st=null;
ResultSet rst_st=null;
String customer_id="";
	try
		{	
			con=ConnectionManager.getConnection(request);
			pstmt_st = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rst_st = pstmt_st.executeQuery();	
			if ( rst_st.next() && rst_st != null )
			{
				customer_id  =  rst_st.getString(1);
			}
	//RUT-CRF-0091
%>
<input type='hidden' name='customer_id' id='customer_id' value="<%=customer_id%>">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="javascript">	
var code=new String();
var masterFrame=window.parent.parent.frames[1].frames[0];
var formObj=masterFrame.document.forms[0];
var customer_id =document.getElementById("customer_id").value; //RUT-CRF-0091
function sendparams(index){
	var rows = parent.parent.frames[1].frames[1].rows[index];
	var item_code=rows.item_code;
	var item_description=rows.description;
	if(rows.quantity=="&nbsp;")
	 rows.quantity='';
	var quantity=rows.quantity;
	var st_location=rows.st_location;//RUT-CRF-0091
	var recId =rows.recId;
	var mode="U";
	//var str = item_code+"::"+item_description+"::"+quantity+"::"+recId+"::"+mode;
	var str = item_code+"::"+item_description+"::"+quantity+"::"+recId+"::"+mode+"::"+st_location;
	var frmObj = window.parent.parent.frames[1].frames[3];
	frmObj.splitString(str);

} 

function createTable(){ 
	 var rows=window.parent.parent.frames[1].frames[1].rows;
	 var args="";
	 
	 //tab_data="<!--div id='listContentLayer' style='overflow: auto;height: 400px; width: 1024px;align:left'--><table id='listContentLayer' border='1' cellpadding='3' cellspacing='0' width='100%'>"
	 tab_data="<table id='listContentLayer' border='1' cellpadding='3' cellspacing='0' width='100%'>"
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>"
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>"	 
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>"
		//Added by MuthuN against RUT-CRF-0091 on 18-April-2013 starts here 
	if (customer_id == 'RTN'){	
	 tab_data+="<th class='columnHeader nowrap'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>"
	//Added by MuthuN against RUT-CRF-0091 on 18-April-2013 Ends here
	} 	
	if(rows!=null){
	  for(var jj=0;jj<rows.length;jj++){
		if( rows[jj]!=null&&rows[jj].mode!="D")	{
		   
		   code+="@"+rows[jj].item_code+"@";
		   	if(jj%2==0) qryVal="gridData";
			   else
				 qryVal="gridData"; 
	     	   args=jj;
			 
				/* tab_data+="<tr><td class="+qryVal+">";
				   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].item_code+"</a></td>";
				   tab_data+="<td class="+qryVal+">"+rows[jj].description+"</td>";
				   tab_data+="<td class="+qryVal+">"+rows[jj].quantity+"</td>";
				   tab_data+="</tr>";
				   */
			  
				   tab_data+="<tr><td class="+qryVal+" nowrap>";
				   tab_data+="<a href=\"javascript:sendparams("+args+");\">"+rows[jj].description+"</a></td>";
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].item_code+"</td>";				  
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].quantity+"</td>";
				   //Added by MuthuN against RUT-CRF-0091 on 18-April-2013 starts here
				   	if (customer_id == 'RTN'){	
				   if(rows[jj].st_location != undefined){
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].st_location+"</td>";
				   }
				  }
				   tab_data+="</tr>";
		  }
	  }//end of for Loop
  }// end if 
  	
	tab_data+="</table></div>";

  //alert(tab_data);
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
 
//  window.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
  
}

</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="SetComponentsDetailForm" id="SetComponentsDetailForm" >
<%
}
			catch(Exception e)
			{   e.printStackTrace();
				System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rst_st != null)   rst_st.close();
				if (pstmt_st != null) pstmt_st.close();	
				if(con!=null) ConnectionManager.returnConnection(con);
				
			}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>

