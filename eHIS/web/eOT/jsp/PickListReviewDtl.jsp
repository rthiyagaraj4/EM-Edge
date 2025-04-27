<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                              
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import= "java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*,eOT.Common.*,eCommon.Common.CommonBean" %>
<html>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>                
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eOT/js/OTCommon.js" language="javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script language='javascript'>
//Added by MuthuN against CRF-268 Starts Here 

function hideToolTip(){
  document.getElementById("tooltiplayer1").style.visibility = 'hidden';
}

function localTrimString(sInString) {
	  return sInString.replace(/[\[\]']+/g,"");
}

function  reasonToolTip_pick(rownum,booking_num,oper_code){
	var formObj = document.forms[0];
    var formObj1= parent.parent.frames[1].frames[2].document.forms[0]
	var facilityid=formObj.facilityid.value;
	var surgeryDate = formObj.surgeryDate.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=pick_list_complete_status&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&booking_num="+booking_num+"&oper_code="+oper_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrMsg=retVal;
	var arr=new Array();
	arr=arrMsg.split(",");
	var cou=0;
	var oper_proc_label=getLabel("eOT.PickListStatus.Label","ot_labels");
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='0' class='BOX' width='50%' height='50%' align='center'>";
	var id_name_colval  ='';
	if(arr[0]=="" || arr[0]==null){
	id_name_colval  =oper_proc_label;
	}else{
	id_name_colval  = arr[0];
	}
	tab_dat     += "<tr>"
	//tab_dat     += "<th   nowrap > <B>"+id_name_colval + " </B> </a> </th>" //for testing
	tab_dat     += "</tr> ";

	for( cou=0;cou<arr.length;cou++){
		msg=arr[cou];//- commented by MuthuN for testing
		var msg1 = localTrimString(msg);//Added By MuthuN against CRF-268
		tab_dat     += "<tr>"
		tab_dat     += "<td class='label' > <B>"+msg1+ " </B> </a> </td>"
		tab_dat     += "</tr> ";
	}
	tab_dat     += "</table> ";
	document.getElementById("tooltiplayer1").innerHTML = tab_dat;
	resizeWindow1();
}

function resizeWindow1(){
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight

	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer1").offsetWidth)
	y = y + (document.getElementById("tooltiplayer1").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer1").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer1").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer1").style.posLeft= x
	document.getElementById("tooltiplayer1").style.posTop = y
	document.getElementById("tooltiplayer1").style.visibility='visible'
}
//Added by MuthuN against CRF-268 Ends Here

function callNoRecord()
{
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}

function addNewItem(coun,highlightcnt)
{
var frmObj=parent.parent.frames[1].frames[0];
if(frmObj.isModify()==false)
	{
var obj=document.forms[0];
var patient_id=eval("obj.patient_id"+coun+".value");
var locale=obj.locale.value;
var surgery_date=dateUtils(eval("obj.surgery_date"+coun+".value"),locale);
var surgeoncode=eval("obj.surgeoncode"+coun+".value");
var booking_no=eval("obj.booking_no"+coun+".value");
var oper_code=eval("obj.oper_code"+coun+".value");
var oper_room_code=eval("obj.oper_room_code"+coun+".value");
var end=obj.endcnt.value;
//Add by MuthuN against CRF -268
var cssd_doc_type = obj.cssd_doc_type.value;
var cssd_store_req = obj.cssd_store_req.value;
var cssd_store_ret = obj.cssd_store_ret.value;
	var oddeven="";
	for(i=0;i<=end;i++)
	{
	if(i%2==0)
	{
		oddeven='gridData';
	}else{
		oddeven='gridData';
	}

		
	 	if(("operdesc"+i)==highlightcnt)
		{
		  eval(document.getElementById("date"+i)).style.backgroundColor='#FF99FF';
		  eval(document.getElementById("patname"+i)).style.backgroundColor='#FF99FF';
		  eval(document.getElementById("surgname"+i)).style.backgroundColor='#FF99FF';
		  eval(document.getElementById("booknum"+i)).style.backgroundColor='#FF99FF';
		  eval(document.getElementById("operdesc"+i)).style.backgroundColor='#FF99FF';
		  eval(document.getElementById("operroomdesc"+i)).style.backgroundColor='#FF99FF';
		}else
		{
			if(eval(document.getElementById("date"+i)))
			{
		  eval(document.getElementById("date"+i)).style.backgroundColor='';
		  eval(document.getElementById("date"+i)).className=oddeven
			}
if(eval(document.getElementById("date"+i)))
			{
		  eval(document.getElementById("patname"+i)).style.backgroundColor='';
		  eval(document.getElementById("patname"+i)).className=oddeven
    	  eval(document.getElementById("surgname"+i)).style.backgroundColor='';
		  eval(document.getElementById("surgname"+i)).className=oddeven
		  eval(document.getElementById("booknum"+i)).style.backgroundColor='';
		  eval(document.getElementById("booknum"+i)).className=oddeven
		  eval(document.getElementById("operdesc"+i)).style.backgroundColor='';
		  eval(document.getElementById("operdesc"+i)).className=oddeven
		  eval(document.getElementById("operroomdesc"+i)).style.backgroundColor='';
		  eval(document.getElementById("operroomdesc"+i)).className=oddeven
			}

		}
	}
//var param="patient_id="+patient_id+"&surgery_date="+surgery_date+"&surgeoncode="+surgeoncode+"&booking_no="+booking_no+"&oper_code="+oper_code+"&oper_room_code="+oper_room_code;

var param="patient_id="+patient_id+"&surgery_date="+surgery_date+"&surgeoncode="+surgeoncode+"&booking_no="+booking_no+"&oper_code="+oper_code+"&oper_room_code="+oper_room_code+"&cssd_doc_type="+cssd_doc_type+"&cssd_store_req="+cssd_store_req+"&cssd_store_ret="+cssd_store_ret;

var from_val=parent.parent.frames[1].frames[1].document.forms[0].from_val.value;
parent.parent.frames[1].location.href="../../eOT/jsp/PickListReviewItemFrame.jsp?"+param+"&from_val="+from_val;
	}
	else
	{
		alert("Finalize already selected data");
	}
}
</script>
<%
	String facilityid=(String)session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;	
	ResultSet rs=null;
	ResultSet rs2=null;//Added By MuthuN CRF-268
	Statement stmt2=null;//Added By MuthuN CRF-268
	PreparedStatement pstmt1=null;	
	ResultSet rs1=null;
	String ot_Param="";
	//Added By MuthuN CRF-268
	String sql_pick_param ="";
	String cssd_doc_type ="";
	String cssd_store_req ="";
	String cssd_store_ret ="";

	//Added newly by MuthuN against CRF-268 Starts
 sql_pick_param ="select CSSD_DOC_TYPE_REQ, CSSD_STORE_REQ, CSSD_STORE_RET from OT_PARAM_FOR_FACILITY where operating_facility_id ='"+facilityid+"'";
	try{
			conn=ConnectionManager.getConnection(request);
			stmt2 = conn.createStatement();
			rs2 = stmt2.executeQuery(sql_pick_param);
			if (rs2!= null && rs2.next())
			{
				cssd_doc_type=checkForNull(rs2.getString(1));
				cssd_store_req=checkForNull(rs2.getString(2));
				cssd_store_ret=checkForNull(rs2.getString(3));
			}
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			try{
			if(rs2!=null)       rs2.close();
			if(stmt2!=null)       stmt2.close();
			if(conn!=null)  ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}


	String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
	try{
			conn=ConnectionManager.getConnection(request);
			pstmt = conn.prepareStatement(sqlOtParam);
		pstmt.setString(1,facilityid);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			ot_Param=rs.getString("facility");
		}		
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			try{
			if(rs!=null)       rs.close();
			if(pstmt!=null)       pstmt.close();
			if(conn!=null)  ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}	
//Added newly by MuthuN against CRF-268 Ends

%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<form name='picklistReviewDtl' id='picklistReviewDtl' action='' method = 'post'>
<table  border='1' width='100%' cellpadding=3  cellspacing=0>
<tr>
<%
if("Y".equalsIgnoreCase(ot_Param)){
%>
<!-- Added By MuthuN against CRF - 268 Starts -->
	<td class='columnHeader'></td>
<!-- Added By MuthuN against CRF - 268 Ends -->
<%}%>
	<th class='columnHeader' nowrap><fmt:message key="eOT.SurgeryDate.Label" bundle="${ot_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="eOT.BookingNumber.Label" bundle="${ot_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.operation.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></th>
	</tr>
<%
	/*String facilityid=(String)session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;*/		
	Statement stmt=null;
	ResultSet rs_oper_room=null;
	String sql="";
	String strQuery="";
	String strPatientId="";
	String strSurgeryDate="";
	String strPatientName="";
	String strSurgeonCode="";
	String strSurgeonName="";
	String strBookingNum="";
	String strOperCode="";
	String strOperDesc="";
	String sql_oper_room="";
	String oper_room_code="";
	String oper_room_desc="";

//Added by lakshmi for CRF-0146
String strPatientIdFltr=checkForNull(request.getParameter("patient_id"));
String strFacilityId=checkForNull(request.getParameter("facility_id"));
String strSourceType=checkForNull(request.getParameter("source_type"));
String strSourceCode=checkForNull(request.getParameter("source_code"));

int fetchCount=0;

try{
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();

//Modified by lakshmi against CRF-0146 starts here
if((strPatientIdFltr.length()==0)&&(strSourceCode.length()==0)){
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
}
else if((strPatientIdFltr.length()!=0)&&(strSourceCode.length()==0)){
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and PATIENT_ID='"+strPatientIdFltr+"'and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
}
/*else if((strPatientIdFltr.length()!=0)&&(strSourceCode.length()!=0)){
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and PATIENT_ID='"+strPatientIdFltr+"' and SOURCE_TYPE='"+strSourceType+"' and SOURCE_CODE='"+strSourceCode+"'and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
}*/
else if((strPatientIdFltr.length()==0)&&(strSourceCode.length()!=0)){
	if (strSourceType.equals("W")== true || strSourceType.equals("N")== true) 
	{
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and SOURCE_TYPE IN ('W','N')  and SOURCE_CODE='"+strSourceCode+"'and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
	}
	else
	{
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and SOURCE_TYPE ='"+strSourceType+"' and SOURCE_CODE='"+strSourceCode+"'and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
	}

}
//Modified by lakshmi against CRF-0146 ends here

     pstmt=conn.prepareCall(sql);
	 pstmt.setString(1,facilityid);
	 rs=pstmt.executeQuery();
while(rs.next())
{
	fetchCount++;
strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
strPatientName=CommonBean.checkForNull(rs.getString("PATIENT_NAME1"));
//strSurgeryDate=CommonBean.checkForNull(rs.getString("SURGERY_DATE1"));
strSurgeryDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("SURGERY_DATE1"),"DMY","en",locale));
strSurgeonCode=CommonBean.checkForNull(rs.getString("SURGEON_CODE1"));
strSurgeonName=CommonBean.checkForNull(rs.getString("SURGEON_NAME1"));	strBookingNum=CommonBean.checkForNull(rs.getString("BOOKING_NUM1"));
strOperDesc=CommonBean.checkForNull(rs.getString("OPER_DESC1"));
strOperCode=CommonBean.checkForNull(rs.getString("OPER_CODE1"));
%>
<input type='hidden' name='booking_num<%=fetchCount%>' id='booking_num<%=fetchCount%>' value="<%=strBookingNum%>">
<%
	//Added Newly for Icon Disable on 12/28/2012
	int count_val=0;
	String sqlPickList_Status = "SELECT count(*) FROM ot_pick_lists WHERE booking_num = '"+strBookingNum+"' AND OPER_CODE = '"+strOperCode+"' AND operating_facility_id = '"+facilityid+"' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') and (item_type='I' or item_type='P') and (nvl(cssd_status,'X') <>'F')";
	try{
//			conn=ConnectionManager.getConnection(request); //Perf issue 05Dec
			pstmt1 = conn.prepareStatement(sqlPickList_Status);
			pstmt1.setString(1, strSurgeryDate);
			rs1=pstmt1.executeQuery();
		if(rs1 !=null && rs1.next())
		{
			count_val=rs1.getInt(1);
		}	
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(rs1!=null) rs1.close();	
			if(pstmt1 != null) pstmt1.close();
// 			if(conn!=null)  ConnectionManager.returnConnection(conn,request); Perf issue 05Dec
			//ConnectionManager.returnConnection(conn,request);
			}
//Added Newly for Icon Disable on 12/28/2012

	sql_oper_room="SELECT a.OPER_ROOM_CODE, b.SHORT_DESC FROM OT_booking_hdr a, OT_OPER_ROOM_LANG_VW b WHERE a.OPER_ROOM_CODE=b.OPER_ROOM_CODE  and  a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID AND b.OPERATING_FACILITY_ID = '"+facilityid+"'  AND a.BOOKING_NUM='"+strBookingNum+"' and b.LANGUAGE_ID='"+locale+"'";
		rs_oper_room=stmt.executeQuery(sql_oper_room);

		if(rs_oper_room !=null && rs_oper_room.next())
		{
			oper_room_code=rs_oper_room.getString("OPER_ROOM_CODE");
			if(oper_room_code ==null) oper_room_code="";
			oper_room_desc=rs_oper_room.getString("SHORT_DESC");
			if(oper_room_desc ==null) oper_room_desc="";
		}

// Modified by DhanasekarV on 1/8/2011
		if(rs_oper_room!=null)rs_oper_room.close();		
if(fetchCount%2==0)	
	strQuery="class='gridData'";
else
	strQuery="class='gridData'";


out.println("<tr>");
//Added By MuthuN against CRF-268 
if("Y".equalsIgnoreCase(ot_Param)){
	if(count_val > 0){
	out.println("<td><img src='../../eOT/images/picklist.png' class='img' name='img1' OnMouseOver=\"reasonToolTip_pick('"+fetchCount+"','"+strBookingNum+"','"+strOperCode+"')\" onmouseout=\"hideToolTip()\"></td>");
	}else{
		out.println("<td></td>");
	}
}
//Added By MuthuN against CRF - 268
out.println("<td "+strQuery+"  id='date"+fetchCount+"'  class='"+strQuery+"'  align='left'>"+strSurgeryDate+"</td>");
out.println("<td "+strQuery+"  id='patname"+fetchCount+"'  class='"+strQuery+"'  align='left'>"+strPatientName+"</td>");

out.println("<td "+strQuery+"  id='surgname"+fetchCount+"'  class='"+strQuery+"'  align='left'>"+strSurgeonName+"</td>");

out.println("<td "+strQuery+"  id='booknum"+fetchCount+"'  class='"+strQuery+"'  align='left'>"+strBookingNum+"</td>");

out.println("<td  "+strQuery+"  id='operdesc"+fetchCount+"'  class='"+strQuery+"'   onClick=\"addNewItem('"+fetchCount+"','operdesc"+fetchCount+"')\"  nowrap><font class='HYPERLINK' style='font-size:7pt;color:blue;cursor:pointer;font-weight:normal'> "+strOperDesc+"</font></td>");

out.println("<td "+strQuery+"  id='operroomdesc"+fetchCount+"'   class='"+strQuery+"'  align='left'>"+oper_room_desc+"</td>");

out.println("<input type='hidden' name='patient_id"+fetchCount+"' id='patient_id"+fetchCount+"' value='"+strPatientId+"'>");
out.println("<input type='hidden' name='surgery_date"+fetchCount+"' id='surgery_date"+fetchCount+"'  value='"+strSurgeryDate+"'>");
out.println("<input type='hidden' name='surgeoncode"+fetchCount+"' id='surgeoncode"+fetchCount+"'  value='"+strSurgeonCode+"'>");
out.println("<input type='hidden' name='booking_no"+fetchCount+"' id='booking_no"+fetchCount+"' value='"+strBookingNum+"'>");
out.println("<input type='hidden' name='oper_code"+fetchCount+"' id='oper_code"+fetchCount+"'  value='"+strOperCode+"'>");
out.println("<input type='hidden' name='oper_room_code"+fetchCount+"' id='oper_room_code"+fetchCount+"'  value='"+oper_room_code+"'>");
out.println("</tr>");
	}
out.println("<input type='hidden' name='endcnt' id='endcnt'  value='"+fetchCount+"'>");
if(fetchCount==0)
	out.println("<script>callNoRecord();</script>");
if(stmt !=null) stmt.close();
if(rs_oper_room !=null) rs_oper_room.close();
}catch(Exception ee)
{

}
finally
{
	if(rs!=null) rs.close();	
	pstmt.close();
	if(conn!=null)  ConnectionManager.returnConnection(conn,request);
}
%>
 </table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<!-- Added By MuthuN against CRF - 268 Starts -->

<input type='hidden' name='booking_num' id='booking_num' value="<%=strBookingNum%>">
<input type='hidden' name='patient_id_pick' id='patient_id_pick' value="<%=strPatientIdFltr%>">
<input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
<input type='hidden' name='surgeryDate' id='surgeryDate' value="<%=strSurgeryDate%>">
<input type='hidden' name='cssd_doc_type' id='cssd_doc_type' value="<%=cssd_doc_type%>">
<input type='hidden' name='cssd_store_req' id='cssd_store_req' value="<%=cssd_store_req%>">
<input type='hidden' name='cssd_store_ret' id='cssd_store_ret' value="<%=cssd_store_ret%>">
<!-- Added newly by MuthuN against CRF-268 Ends -->
 </form>
 <!-- Added By MuthuN against CRF - 268 Starts -->
		<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue' ></div>
	 	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>	
	</div>
<!-- Added By MuthuN against CRF - 268 Ends -->
</html>

