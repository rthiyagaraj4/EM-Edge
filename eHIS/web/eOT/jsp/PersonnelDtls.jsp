<%@ page contentType=" text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.Common.CommonBean,webbeans.eCommon.ConnectionManager" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String surgeon_doc_comp_yn = "";
	String nursing_doc_comp_yn = "";
	String tab = CommonBean.checkForNull(request.getParameter("tab"));
	//Added Against ML-MMOH_CRF-1979-US02...starts
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String operation_desc = "";
	String locale = (String)session.getAttribute("LOCALE");
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String operation_code = "";
	//Added Against ML-MMOH_CRF-1979-US02...ends
	String disp_hosp = CommonBean.checkForNull(request.getParameter("disp_hosp"));//Added for CHL-CRF-0020.1 [IN:043132]
	if(tab.equals("record_surgeon")){
		 surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	}else if(tab.equals("record_nursing")){
		 nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn")); 
	}
	
	boolean isMandateEffortEstimation = false;
	Connection con = null;
	try{
		con = ConnectionManager.getConnection(request);
		String sql = "SELECT M.LONG_DESC,D.OPER_CODE FROM OT_OPER_MAST M,OT_POST_OPER_DTLS D WHERE M.OPER_CODE = D.OPER_CODE AND D.OPER_NUM = ? AND D.OPERATING_FACILITY_ID = ? AND D.OPER_LINE_NUM = 1";
;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,oper_num);
		pstmt.setString(2,facility_id);
		rst = pstmt.executeQuery();	 
		while(rst.next()){
           operation_desc = CommonBean.checkForNull(rst.getString(1));
           operation_code = CommonBean.checkForNull(rst.getString(2));
		}
		
		isMandateEffortEstimation = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "MANDATE_EFFORT_ESTIMATION");//Added Against ML-MMOH-CRF-1979-US02
		//isMandateEffortEstimation = true;
		System.err.println("personeldtl.jsp isMandateEffortEstimation-------------->"+isMandateEffortEstimation);
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{ 
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>
<html>
<head>
<title> <%= request.getParameter("title")%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>
<script language="javascript">
var code=new String();
var splty_code=new String(); 

function sendparams(index){
	var isMandateEffortEstimation = document.forms(0).isMandateEffortEstimation.value;
	var rows = parent.parent.parent.ObjectCollect.personnelrows[index]; 
	var mode = '';
	var	time_in_date = '';
	var	time_in_time = '';
	var	time_out_date = '';
	var	time_out_time = '';
	if(rows.time_in == null || rows.time_in == 'undefined') rows.time_in = '';
	if(rows.time_out == null || rows.time_out == 'undefined') rows.time_out = '';
	var	time_out = rows.time_out;
	//Added Against ML-MMOH-CRF-1979-US2...starts
	if(isMandateEffortEstimation == 'true'){
	var	operation_code=rows.operation_code;
	var	operation_desc=rows.operation_desc;
	if(operation_desc == '' || operation_desc == 'undefined' || operation_desc == null) operation_desc = document.forms(0).operation_desc2.value;
	if(operation_code == '' || operation_code == 'undefined' || operation_code == null) operation_code = document.forms(0).operation_code2.value;
	var	team=rows.team;
	if(rows.time_in.length > 15 && rows.time_out.length > 15){
	time_in_date = trimString((rows.time_in).slice(0,10));
	time_in_time = trimString((rows.time_in).slice(11,16));
	time_out_date = trimString((rows.time_out).slice(0,10));
	time_out_time = trimString((rows.time_out).slice(11,16));
	}
	if(rows.db_mode == 'I') mode = 'L';
	else mode = 'U';
	}else{
		mode = 'U';
	}
	//Added Against ML-MMOH-CRF-1979-US2...ends	
	var	speciality_code=rows.speciality_code;
	var	speciality_desc=rows.speciality_desc;
	var	role_id=rows.role_id;
	var	role_desc=rows.role_id+"##"+rows.role_type;
	var	practitioner_id=rows.practitioner_id;
	var	practitioner_name=rows.practitioner_name;
	var	recId = rows.recId;			   
	var role_type=rows.role_type;
	var mode = "U";
	var str =  speciality_code+"::"+speciality_desc+'::'+role_id+'::'+role_desc+'::'+practitioner_id+'::'+practitioner_name+'::'+recId+'::'+role_type+'::'+mode+'::'+operation_code+'::'+operation_desc+'::'+team+'::'+time_in_date+'::'+time_in_time+'::'+time_out_date+'::'+time_out_time;
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}
function createTable(){    
 <%Thread.sleep(1500); //Added Against SKR-SCF-1744 %>
 var isMandateEffortEstimation = document.forms(0).isMandateEffortEstimation.value;
  var rows = parent.parent.parent.ObjectCollect.personnelrows; 
  var tempPersonnelRows = parent.parent.parent.ObjectCollect.tempPersonnelRows;
  var obj=document.getElementById("test");
  var disp_hosp = document.forms(0).disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
  var tab_data="";
  var speciality_desc="";
  var speciality_code="";
  var role_id = "";
  var role_desc = "";
  var practitioner_id="";
  var practitioner_name = "";
  var queryVal="";
  var recId="";
  var args="";
  tab_data="<table border='1' cellpadding=3 cellspacing='0' width='100%' align='center'>"
  if(isMandateEffortEstimation=='true'){
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.Operation.Label" bundle="${ot_labels}"/></td>"//Added Against ML-MMOH-CRF-1979-US02
  }
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>"
  if(isMandateEffortEstimation=='true'){
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.Team.Label" bundle="${ot_labels}"/></td>"//Added Against ML-MMOH-CRF-1979-US02
  }
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></td>"
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>"
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>"
  if(isMandateEffortEstimation=='true'){
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.TimeIn.Label" bundle="${ot_labels}"/></td>"//Added Against ML-MMOH-CRF-1979-US02
  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.TimeOut.Label" bundle="${ot_labels}"/></td>"//Added Against ML-MMOH-CRF-1979-US02
  }
 

 if(rows!=null && rows.length>0)
  {
	for(var jj=0;jj<rows.length;jj++)
	{
	  if(rows[jj]!=null &&  rows[jj].db_mode!='D'){
	   //Added Against ML-MMOH-CRF-1979-US2...starts
	   if(isMandateEffortEstimation=='true'){
	   operation_code=rows[jj].operation_code;
	   operation_desc=rows[jj].operation_desc;
	   team=rows[jj].team;
	   time_in=rows[jj].time_in;
	   time_out=rows[jj].time_out;
	   if(operation_desc == '' || operation_desc == 'undefined' || operation_desc == null) operation_desc = document.forms(0).operation_desc2.value;
	   if(operation_code == '' || operation_code == 'undefined' || operation_code == null) operation_code = document.forms(0).operation_code2.value;
	   if(team == '' || team == 'undefined' || team == null) team = '';
	   if(time_in == '' || time_in == 'undefined' || time_in == null) time_in = '';
	   if(time_out == '' || time_out == 'undefined' || time_out == null) time_out = '';
	   }
	   //Added Against ML-MMOH-CRF-1979-US2...ends 
	   speciality_code=rows[jj].speciality_code;
	   speciality_desc=rows[jj].speciality_desc;
	   role_id=rows[jj].role_id;
	   role_desc= rows[jj].role_id+"::"+rows[jj].role_type;
	   role_type = rows[jj].role_type;
	   practitioner_id=rows[jj].practitioner_id;
	   practitioner_name=rows[jj].practitioner_name;
	   recId = rows[jj].recId;			   
	   args = jj;

	   code+=practitioner_id+","; 
	   splty_code+=speciality_code+","; 
		//if(disp_hosp == "Y")//Added for CHL-CRF-0020.1 [IN:043132]
		//{
		   if(jj%2==0)
			 qryVal="gridData";
		   else
			 qryVal="gridData"; 
			 <% if (surgeon_doc_comp_yn.equals("Y") ||  nursing_doc_comp_yn.equals("Y") ){ %>
				tab_data+="<tr>";
				
				if(isMandateEffortEstimation=='true') tab_data+="<td nowrap class="+qryVal+">"+operation_desc+"</td>";
				tab_data+="<td nowrap class="+qryVal+">"+speciality_desc+"</td>";
				if(isMandateEffortEstimation=='true') tab_data+="<td nowrap class="+qryVal+">"+team+"</td>";
				tab_data+="<td nowrap class="+qryVal+">"+rows[jj].role_desc+"</td>";
				tab_data+="<td nowrap class="+qryVal+">&nbsp;"+rows[jj].practitioner_name+"</td>";
				tab_data+="<td nowrap class="+qryVal+">&nbsp;"+rows[jj].position_desc+"</td>";
				if(isMandateEffortEstimation=='true'){
				tab_data+="<td nowrap class="+qryVal+">&nbsp;"+time_in+"</td>";
				tab_data+="<td nowrap class="+qryVal+">&nbsp;"+time_out+"</td>";
				}
				tab_data+="</tr>"; 
			<% } else {%>
				tab_data+="<tr>";
				if(isMandateEffortEstimation=='true') tab_data+="<td nowrap class="+qryVal+">"+operation_desc+"</td>";
				tab_data+="<td class="+qryVal+">";
				tab_data+="<a class='gridLink' href=\"javascript:sendparams("+args+");\">"+speciality_desc+"</a></td>";
				if(isMandateEffortEstimation=='true') tab_data+="<td nowrap class="+qryVal+">"+team+"</td>";
				tab_data+="<td nowrap class="+qryVal+">"+rows[jj].role_desc+"</td>";
				tab_data+="<td nowrap class="+qryVal+">&nbsp;"+rows[jj].practitioner_name+"</td>";
				tab_data+="<td nowrap class="+qryVal+">&nbsp;"+rows[jj].position_desc+"</td>";
				if(isMandateEffortEstimation=='true'){
				tab_data+="<td nowrap class="+qryVal+">&nbsp;"+time_in+"</td>";				
				tab_data+="<td nowrap class="+qryVal+">&nbsp;"+time_out+"</td>";
				}
				tab_data+="</tr>"; 
			<% } %>
		//}//Added for CHL-CRF-0020.1 [IN:043132]
		}
	  }//end of for Loop
  }// end if 
	if(tempPersonnelRows != null && tempPersonnelRows.length > 0)
	{
		for(var kk=0; kk < tempPersonnelRows.length; kk++)
		{
			if(tempPersonnelRows[kk]!=null &&  tempPersonnelRows[kk].db_mode!='D')
			{
				speciality_code=tempPersonnelRows[kk].speciality_code;
				speciality_desc=tempPersonnelRows[kk].speciality_desc;
				role_id=tempPersonnelRows[kk].role_id;
				role_desc= tempPersonnelRows[kk].role_id+"::"+tempPersonnelRows[kk].role_type;
				role_type = tempPersonnelRows[kk].role_type;
				practitioner_id=tempPersonnelRows[kk].practitioner_id;
				practitioner_name=tempPersonnelRows[kk].practitioner_name;
				recId = tempPersonnelRows[kk].recId;			   
				args = kk;
				code += practitioner_id+","; 
				splty_code+=speciality_code+","; 
				if(disp_hosp == "N")//Added for CHL-CRF-0020.1 [IN:043132]
				{
					if(kk%2==0)
						qryVal="gridData";
					else
						qryVal="gridData"; 
<% 
					if (surgeon_doc_comp_yn.equals("Y") ||  nursing_doc_comp_yn.equals("Y"))
					{
%>
						tab_data+="<tr>";
						tab_data+="<td nowrap class="+qryVal+">"+speciality_desc+"</td>";
						tab_data+="<td nowrap class="+qryVal+">"+tempPersonnelRows[kk].role_desc+"</td>";
						tab_data+="<td nowrap class="+qryVal+">&nbsp;"+tempPersonnelRows[kk].practitioner_name+"</td>";
						tab_data+="<td nowrap class="+qryVal+">&nbsp;"+tempPersonnelRows[kk].position_desc+"</td>";
						tab_data+="</tr>"; 
<% 
					}
					else
					{
%>
						tab_data+="<tr><td class="+qryVal+">";
						tab_data+="<a class='gridLink' href=\"javascript:sendparams("+args+");\">"+speciality_desc+"</a></td>";
						tab_data+="<td nowrap class="+qryVal+">"+tempPersonnelRows[kk].role_desc+"</td>";
						tab_data+="<td nowrap class="+qryVal+">&nbsp;"+tempPersonnelRows[kk].practitioner_name+"</td>";
						tab_data+="<td nowrap class="+qryVal+">&nbsp;"+tempPersonnelRows[kk].position_desc+"</td>"; 
						tab_data+="</tr>"; 
<%
					}
%>
				}//Added for CHL-CRF-0020.1 [IN:043132]
			}
		}//end of for Loop
	}
	tab_data+="</table>";

  document.getElementById('test').innerHTML = tab_data;
  document.getElementById('test').style.visibility="visible";
  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}

</script>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id="test"></div>
<form name="PersonnelDetailForm" >
<!-- Added for CHL-CRF-0020.1 [IN:043132] -->
<input type='hidden' name='disp_hosp' id='disp_hosp' value='<%=disp_hosp%>'>
<input type='hidden' name='isMandateEffortEstimation' value='<%=isMandateEffortEstimation%>'>
<input type='hidden' name='operation_desc2' value='<%=operation_desc%>'>
<input type='hidden' name='operation_code2' value='<%=operation_code%>'>
<!-- Added for CHL-CRF-0020.1 [IN:043132] -->
</form>
</body>