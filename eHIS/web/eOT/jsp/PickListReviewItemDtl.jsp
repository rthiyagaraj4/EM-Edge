<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*,java.sql.Connection,  java.sql.PreparedStatement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)
session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
 	<script src="../../eOT/js/PickList.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
</head>
<%
String from_val="";
from_val=request.getParameter("from_val");
String patient_id	= request.getParameter("patient_id");
String mode=request.getParameter("mode");
if(mode ==null) mode="I";
	if(from_val ==null) from_val="PI";

//Added newly by MuthuN against CRF-268 Starts
	String qty_avail = checkForNull(request.getParameter("qty_avail"));
	String facility_id	= (String)session.getValue("facility_id");	
	String booking_num = request.getParameter("param");
	String ot_Param="";
	Connection connection   = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		connection	= ConnectionManager.getConnection(request);
		String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
		pstmt = connection.prepareStatement(sqlOtParam);
		pstmt.setString(1,facility_id);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			ot_Param=rs.getString("facility");
		}
		pstmt = null;
		rs = null;

//Added newly by MuthuN against CRF-268 Ends
%>
<script language="javascript">
var code = new String();
var code_mode = new String();
var code_exist_db = new String();

function createTable(){
  var formObj = document.forms[0];
  var ot_Param = formObj.ot_Param.value;
  var rows=parent.frames[1].rows;
  var tab_data="";
  var from_val=parent.frames[1].document.forms[0].from_val.value;
  var st_interface_flag=parent.frames[1].document.forms[0].st_interface_flag.value;
  var OperRoomCode=parent.frames[1].document.forms[0].OperRoomCode.value;
  var flag=document.forms[0].selflag.value;
	tab_data="<table class='grid' border='1' cellpadding='3' cellspacing='0' width='100%'>"
	if(from_val =="PI")
	{
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.Finalise.Label" bundle="${ot_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>";
	if(st_interface_flag =="Y")
		{
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.RequestingStore.Label" bundle="${ot_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.IssuingStore.Label" bundle="${ot_labels}"/></th>";
		}
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/></th>";
		if(st_interface_flag =="Y")
		{
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.QOHofReqStore.Label" bundle="${ot_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.ReserveQty.Label" bundle="${ot_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.RequestQty.Label" bundle="${ot_labels}"/></th>";
		}
	}else if(from_val =="IE")
	{
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.Finalise.Label" bundle="${ot_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/></th>";
	//Added  by Muthu against CRF-268 on 11/23/2012 Starts
	if(ot_Param == 'Y' || ot_Param=='y'){
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>";
	}
	//Added  by Muthu against CRF-268 on 11/23/2012 Ends
	}else if(from_val =="PD")
	{
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.Finalise.Label" bundle="${ot_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.NoOfPersons.Label" bundle="${ot_labels}"/></th>";
	}else if(from_val =="PP")
	{
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.Finalise.Label" bundle="${ot_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>";
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/></th>";
	//Added  by Muthu against CRF-268 on 11/23/2012 Starts
	if(ot_Param == 'Y' || ot_Param=='y'){
	tab_data+="<th class='columnHeader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>";
	}
	//Added  by Muthu against CRF-268 on 11/23/2012 Ends
	}

  var args='';
  if(rows!=null){
	 for(var jj=0;jj<rows.length;jj++) {
	   if(rows[jj]!=null ){
		  	args=jj;

			//Added  by Muthu against CRF-268 on 11/23/2012 Starts
			var cssd_status = rows[jj].cssd_status;
			if(cssd_status ==null) cssd_status="";			
			//Added  by Muthu against CRF-268 on 11/23/2012 Ends			
	
			var reserve_qty=rows[jj].reserve_qty;
			if(reserve_qty ==null) reserve_qty="";
			var request_qty=rows[jj].request_qty;
			if(request_qty ==null) request_qty="";
			var QOHqty_qty=rows[jj].QOHqty_qty;
			if(QOHqty_qty ==null) QOHqty_qty="";
			var requeststore="";
			var issuing_store="";
			requeststore=rows[jj].requeststore;
			if(requeststore ==null) requeststore="";
			var req_vals=requeststore.split("|")
			var desc="";
			var req_code=req_vals[0];
			desc=req_vals[1];
			if(desc ==null) desc="";

			issuing_store=rows[jj].issuing_store;
			if(issuing_store ==null) issuing_store="";
			var iss_val=issuing_store.split("|")
			var Iss_desc="";
			var Iss_code=iss_val[0];
			Iss_desc=iss_val[1];
			if(Iss_desc ==null) Iss_desc="";
			var mode=rows[jj].mode;
			var exist_db=rows[jj].exist_db;
if(from_val =="PI" && st_interface_flag =="Y")
		   {
code+= rows[jj].item_type+rows[jj].item_id+req_code+Iss_code+",";
code_mode+= rows[jj].item_type+rows[jj].item_id+req_code+Iss_code+mode+",";
code_exist_db=jj+rows[jj].exist_db;
		   }else
		   {
code+= rows[jj].item_type+rows[jj].item_id+",";
		   }
			
			if(rows[jj].db_mode=='DBD')
			 continue;	  
			    if(jj%2==0)			     qryVal="gridData";
			   else				 qryVal="gridData";
				  tab_data+="<tr>";		

				  if(flag=='1')
		   {
				   tab_data+="<td class="+qryVal+" nowrap><input type='checkbox' name='chk"+jj+"' id='chk"+jj+"' onClick=\"chkBoxChecked(this,"+jj+");\" checked></td>";
		   }
		   else if(flag=='2')
		   {
				 tab_data+="<td class="+qryVal+" nowrap><input type='checkbox' name='chk"+jj+"' id='chk"+jj+"' onClick=\"chkBoxChecked(this,"+jj+");\" ></td>";
		   }
		   //First Column
		   else
		   { 
			   if(rows[jj].finalize_yn=='Y')
			   {				   
			   	 tab_data+="<td class="+qryVal+" nowrap><input type='checkbox' name='chk"+jj+"' id='chk"+jj+"' onClick=\"chkBoxChecked(this,"+jj+");\" checked></td>";
			   }
			   else
			   {				  
				 if((from_val =="IE" || from_val =="PP") && cssd_status =="Finalized" && (rows[jj].item_type=='I' || rows[jj].item_type=='P')){
					 tab_data+="<td class="+qryVal+" nowrap><input type='checkbox' name='chk"+jj+"' id='chk"+jj+"' onClick=\"chkBoxChecked(this,"+jj+");\" checked disabled></td>";
				 }
				 else{
				 tab_data+="<td class="+qryVal+" nowrap><input type='checkbox' name='chk"+jj+"' id='chk"+jj+"' onClick=\"chkBoxChecked(this,"+jj+");\" ></td>";
				 }
			   }
		   }
			//Second
  				 tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].item_type_desc+"</td>";
			//third
				if((from_val =="IE" || from_val =="PP") && cssd_status =="Finalized" && (rows[jj].item_type=='I' || rows[jj].item_type=='P')){
					//tab_data+="<td class="+qryVal+" nowrap><a href=\"javascript:sendparams("+args+");\" disabled>"+rows[jj].item_desc+"</a></td>";
					tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].item_desc+"</td>";
					}
				else{
					tab_data+="<td class="+qryVal+" nowrap><a href=\"javascript:sendparams("+args+");\">"+rows[jj].item_desc+"</a></td>";
					}
				  /* tab_data+="<td class="+qryVal+">"+rows[jj].item_desc+"</td>";*/
				  if(from_val =="PI" && st_interface_flag =="Y")
				  {
					   tab_data+="<td class="+qryVal+" nowrap>"+desc+"</td>";
					   tab_data+="<td class="+qryVal+" nowrap>"+Iss_desc+"</td>";
				  }
			 //Fourth
				   tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].no_units+"</td>";				  
			// Fifth
				if((from_val =="IE" || from_val =="PP") && cssd_status =="Finalized" && (rows[jj].item_type=='I' || rows[jj].item_type=='P')){
					rows[jj].cssd_status = "Finalized";
					tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].cssd_status+"</td>";
				}else if((from_val =="IE" || from_val =="PP") && cssd_status =="Requested" && (rows[jj].item_type=='I' || rows[jj].item_type=='P')){
					rows[jj].cssd_status = "Requested";
					tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].cssd_status+"</td>";
				}else if((from_val =="IE" || from_val =="PP") && cssd_status =="Not Requested" && (rows[jj].item_type=='I' || rows[jj].item_type=='P')){
					rows[jj].cssd_status = "Not Requested";
					tab_data+="<td class="+qryVal+" nowrap>"+rows[jj].cssd_status+"</td>";
				}
				if(from_val =="PI" && st_interface_flag =="Y")
				  {
					 tab_data+="<td class="+qryVal+" nowrap>"+QOHqty_qty+"</td>";
					 tab_data+="<td class="+qryVal+" nowrap>"+reserve_qty+"</td>";
					 tab_data+="<td class="+qryVal+" nowrap>"+request_qty+"</td>";
				  }
				  tab_data+="</tr>"; 
			}	   				   
	 }
	 tab_data+="</table>"; 
  }
	if(flag=='1')
		checkBoxCheckedAll('Y');
	else if(flag=='2')
		checkBoxCheckedAll('N');
	document.getElementById("test").innerHTML = tab_data;
	document.getElementById("test").style.visibility='visible';
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onLoad='createTable();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='InstrumentDtlsForm' id='InstrumentDtlsForm'>

<%
  String flag=CommonBean.checkForNull(request.getParameter("flag"));
  if(flag.length()==0)
  flag="0";
	%>
<input type='hidden' name='selflag' id='selflag' value='<%=flag%>'>
<!-- Added  by Muthu against CRF-268 on 11/23/2012 Starts -->
<%
	}catch ( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountCreateSet: "+e);
		e.printStackTrace() ;
	}finally {
		try{			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception es){}
	}
%>
<input type='hidden' name='qty_avail' id='qty_avail' value='<%=qty_avail%>'>
<input type='hidden' name='booking_num' id='booking_num' value='<%=booking_num%>'>
<input type='hidden' name='ot_Param' id='ot_Param' value='<%=ot_Param%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='rowNum' id='rowNum' value=''>
<!-- Added  by Muthu against CRF-268 on 11/23/2012 Ends -->
</form>
<div id='test'></div>
</body>
</html>

