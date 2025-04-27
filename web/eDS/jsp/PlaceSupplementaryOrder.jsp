
<DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,eDS.Common.JSONObject,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<jsp:setProperty name="DSCommonBeanObj" property="Locale" value='<%=session.getAttribute("LOCALE").toString()%>'/>

<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip = "",current_date="";//Added Against ML-MMOH-CRF-0825-US007
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";	
	
	ArrayList<JSONObject> DS_Param_List = new ArrayList<JSONObject>();
	String maximum_days_allowed="",Attendent_Label_Name="";
	try{
		DS_Param_List=DSCommonBeanObj.getDSParameterValue();
		JSONObject paramObj=new JSONObject();
		Iterator<JSONObject> itr1=DS_Param_List.iterator();
		while(itr1.hasNext()){
			paramObj=itr1.next();
			maximum_days_allowed=paramObj.get("Maximum_Days_Allowed").toString();
			Attendent_Label_Name=paramObj.get("Attendent_Label_Name").toString();	
	}
	//Added Against Starts ML-MMOH-CRF-0825-US007
	Connection conn = null;
	conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String suppl_diet_order_yn="";
	String gPQuery = "select GRACE_PERIOD_APPLICABLE_YN,GRACE_PERIOD,restrict_date_inpatients_yn,nvl(maximum_days_allowed,'1') maximum_days_allowed,GEN_MEALPLAN_FOR_NBM_PAT_YN,LATE_IRREGULAR_DIET_ORD_FOR_SP,IRREGULAR_MEAL_ORD_MESSAGE,Attendent_Label_Name,NVL(No_Of_Attendant,'0') No_Of_Attendant from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
	try{
		pstmt = conn.prepareStatement(gPQuery);
		rs	= pstmt.executeQuery();
	if(rs != null && rs.next()){
		suppl_diet_order_yn=checkForNull(rs.getString("LATE_IRREGULAR_DIET_ORD_FOR_SP"));
		}
	pstmt = conn.prepareStatement(sql_curr_date);
	rs	= pstmt.executeQuery();
	if(rs!=null && rs.next()){
		current_date = com.ehis.util.DateUtils.convertDate(rs.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	if(rs != null) rs.close();
	}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception es){
			es.printStackTrace();
		} 
	}
	//  Added Against Ends ML-MMOH-CRF-0825-US007
	
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="X-UA-Compatible" content="IE=5,8,9" >
  <meta charset="utf-8">
    <title>Place Supplementary Order</title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> <%-- AAKH-CRF-0065 --%>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>		
	<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
	<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
	<script type="text/javascript" src="../../eDS/js/simpletreemenu.js"></script>
	<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
	<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>		
	<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="Javascript" src="../../eDS/js/Moment.js"></script>
	<script language="Javascript" src="../../eDS/js/MomentRange.js"></script>
	<script language="Javascript" src="../../eDS/js/PlaceSupplementaryOrder.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
	 
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery.datetimepicker.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery-ui-timepicker-addon.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/timepicker.css"/>

	
	
	
	
	
  
	<!-- ML-MMOH-CRF-409 -->
	<script src="../../eDS/js/Moment.js"></script>
	<script src="../../eDS/js/MomentRange.js"></script>
	<!-- ML-MMOH-CRF-409 -->
  
	<!--<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-ar.js"></script>
	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-th.js"></script>-->
	<script type="text/javascript" src="../../eDS/js/common/semiDisabledDateTime/datepicker-<%=locale%>.js"></script>  
		
	<script type="text/javascript">
	   $(document).ready(function () {
		var localeName="<%=localeName%>";
           //$('#mealType').SumoSelect({placeholder: 'All Suburbs'});	
			getSavedSupplementaryMeal();
			FormSupplementaryOrderTable();
	});
    </script>
	<style type="text/css">
        body{font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;color:#444;font-size:13px;}
        p,div,ul,li{padding:0px; margin:0px;}
		.popupgrid
		{
		width:100%;height:75%; POSITION: absolute;overflow-y: scroll;width:100%;border: 1px outset #9999FF;    word-break: break-word;border-bottom: 1pt solid black;
		}
		//new
		th, td { white-space: nowrap; }
		
	.thwrap{
			position: relative;
            		top: expression(this.offsetParent.scrollTop);
			/*white-space:nowrap;*/
			/*color:#ff0000;*/
			font-size:12px;
			width:auto;		
			background: url("../../eCommon/images/headerSeparator.jpg") repeat-y;
			background-position:right;
			COLOR: white ;
			background-color:#83AAB4;
			border:2px;
			padding-left:3px;
			font-family: Verdana;
			font-size: 8pt;
			/*font-weight:bold;*/
			border-collapse:collapse; 
			/*position:absolute;*/
			left:0;			
			}
			.datawrap{
			/*align:center;*/
    </style>
    
</head>
<body>
<%
	String patientId=request.getParameter("patientId");
	String encounterId=request.getParameter("encounterId");
	String locationCode=request.getParameter("locationCode");
	String patientClass=request.getParameter("patientClass");
	String room=request.getParameter("room");
	String bed=request.getParameter("bed");
	String locationType=request.getParameter("locationType");
	String dateOfBirth=request.getParameter("dateOfBirth");
	String gender=request.getParameter("gender");
	String fecthedMealTypes="";
	ArrayList<JSONObject> SupplementarykeyValueList = new ArrayList<JSONObject>();
						
	SupplementarykeyValueList=DSCommonBeanObj.getSupplementaryMeal();						
						
	Iterator<JSONObject> itr=SupplementarykeyValueList.iterator();
	JSONObject childobject=new JSONObject();
	if(SupplementarykeyValueList.size()>0){
	while(itr.hasNext()){
		childobject=itr.next();
		String code=childobject.get("Meal_Type").toString();
		String Desc=childobject.get("Short_Desc").toString();
		//Added Against ML-MMOH-CRF-0825 Starts Here
		String ServingStartTimeSUP=childobject.get("Serving_Start_Time_sup").toString();
		String ServingEndTimeSUP=childobject.get("Serving_End_Time_sup").toString();
		String IrregularStartTimeSUP=childobject.get("Irregular_Start_Time_sup").toString();
		String IrregularEndTimeSUP=childobject.get("Irregular_End_Time_sup").toString();
		String nextServingStartTimeSUP=childobject.get("next_Serving_Start_Time_sup").toString();
		//Added Against ML-MMOH-CRF-0825 Ends Here							
		fecthedMealTypes+=code+","+Desc+",";//Commented Against ML-MMOH-CRF-0825		
		}
		}
				
%>
<form action="" style="width:100%;height:100%;">
<div id="SearchLayer" style="width:100%;height:28vh;border: 0px outset #9999FF;">
<br>
<br>
<table width="100%" border="0" align="center" CELLSPACING="2" cellpadding="0" >
		<tr>
			<td class="label"><fmt:message key="eDS.SupplementaryDietFor.Label" bundle="${ds_labels}" /></td>
			<td>
				<select name="supplementaryfor" id="supplementaryfor" id="supplementaryfor" onChange="">
				<option value="B">Both</option>							
				<option value="P">Patient</option>							
				<option value="A"><%=Attendent_Label_Name%></option> 							
				</select>
			</td>
			<td class="label">
				<fmt:message key="Common.date.label" bundle="${common_labels}" />
			</td>
			<td>
				<input type="text" id="date" name="date" id="date" value="" onkeypress="return checkForSpecCharsforID(event);"  onblur="isValidDate(this);" size="10" maxlength="10">
				<img src='../../eCommon/images/CommonCalendar.gif'  onClick="return showCalendar('date');">
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
			<td class="label" id="mealTypesId" onclick="return mealTypeSpFoodItems(this,'<%=fecthedMealTypes%>');">
				<fmt:message key="eDS.mealTypes.Label" bundle="${ds_labels}" />
			</td>
		</tr>
		<tr>
			<td class="label">
				<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}" />
			</td>
			<td>
			<select name="itemtype" id="itemtype" id="itemtype" onChange="clearFoodItem();">
			<option value="">--select--</option>
			<%
				ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
						
				keyValueList=DSCommonBeanObj.getItemTypes();
				System.err.println("keyValueList in jsp--->"+keyValueList);
						
				itr=keyValueList.iterator();
				//JSONObject childobject=new JSONObject();
				while(itr.hasNext()){
					childobject=itr.next();
				%>
					<option value=<%=childobject.get("Code") %>><%= childobject.get("Short_Desc")%></option>
				<%	
				}
				 %>			
				</select>
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
			<td class="label">
				<fmt:message key="eDS.FoodItem.Label" bundle="${ds_labels}" />
			</td>
			<td>
				<input type="text" name="item" id="item" id="item" value="" onblur="itemLookUp();">
				<input type="button" name="click" id="click" value="?" onclick="itemLookUp();">
				<img src='../../eCommon/images/mandatory.gif'></img>
				<input type="hidden" id="itemcode" name="itemcode" id="itemcode" value="">
			</td>
			<td class="label">
				<fmt:message key="eOT.qty.Label" bundle="${ot_labels}" />
				<input type="text" name="qty" id="qty" id="qty" value="" maxlength="6" size="6" onkeyup="if(!CheckForNumber(this.value))this.value=''">
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td></td>
		</tr>
		<tr>
			<td class="label">
				<fmt:message key="Common.Instructions.label" bundle="${common_labels}" />
			</td>
			<td >
				<textarea style="resize: none;" name="Instructions" cols='30' id="Instructions" onkeypress="restrictSpecialChars(event)" onblur="textAreaLimit(this,150);"></textarea>
			</td>
			<!-- td></td-->
			<td>						
			</td>
			<td>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td>	
			</select>
			</td>
			<td></td>
			<td></td>
			<td align="right">
					
			<input type="button" name="button1" id="button1" value="<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />" class="button" onClick="addSupplementaryFood()"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#" onClick="viewAllRecord();">View All</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
			<input type="button" align="right" name="button2" id="button2" id="cancelButton" value="<fmt:message key="Common.cancel.label" bundle="${common_labels}" />" class="button" onClick="RemoveItem()" disabled/>
			</td>					
		</tr>
		</table>
</div>
	<div id="ResultLayer" class="popupgrid" style="width:100%;border: 1px outset #9999FF;overflow-y: scroll;width:100%;border: 1px outset #9999FF;">
	<table border='1' cellpadding='1' cellspacing='2' width='100%' align='center' id="SupplementaryOrderTable" style="border-bottom: 1pt solid black;">
		<!--tbody></tbody-->
	</table>
	</div>
	<input type="hidden" id="patientId" name="patientId" id="patientId" value="<%=patientId%>">
	<input type="hidden" id="encounterId" name="encounterId" id="encounterId" value="<%=encounterId%>">
	<input type="hidden" id="locationCode" name="locationCode" id="locationCode" value="<%=locationCode%>">
	<input type="hidden" id="patientClass" name="patientClass" id="patientClass" value="<%=patientClass%>">
	<input type="hidden" id="room" name="room" id="room" value="<%=room%>">
	<input type="hidden" id="bed" name="bed" id="bed" value="<%=bed%>">
	<input type="hidden" id="locationType" name="locationType" id="locationType" value="<%=locationType%>">
	<input type="hidden" id="dateOfBirth" name="dateOfBirth" id="dateOfBirth" value="<%=dateOfBirth%>">
	<input type="hidden" id="gender" name="gender" id="gender" value="<%=gender%>">
	<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type="hidden" id="locale" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" id="maximum_days_allowed" name="maximum_days_allowed" id="maximum_days_allowed" value="<%=maximum_days_allowed%>">
	<input type="hidden" id="Attendent_Label_Name" name="Attendent_Label_Name" id="Attendent_Label_Name" value="<%=Attendent_Label_Name%>">
	<!-- Added Against Start ML-MMOH-CRF-825 -->
	<input type="hidden" name="suppl_diet_order_yn" id="suppl_diet_order_yn" id="suppl_diet_order_yn" value="<%=suppl_diet_order_yn%>" />
	<input type="hidden" name="current_date" id="current_date" value="<%=current_date%>">	
	<!-- Added Against End ML-MMOH-CRF-825 -->
</form>
<%
			}catch(Exception e)
			{
				e.printStackTrace();
			}
%>
<script>
window.onbeforeunload = function() 
{	
	var dataModifyFlag=checkDataModification();
	if(
	$("#supplementaryfor").val()!="B" ||
	$("#date").val()	!="" ||
	$("#itemtype").val()!="" ||
	$("#item").val()!="" ||
	$("#itemcode").val()!="" ||
	$("#qty").val()!="" ||
	$("#Instructions").val()!="" 
	//|| meal_Type_Arr.length!=0
	){
		dataModifyFlag=false;
	}
	if(!dataModifyFlag){
		
		return getMessage("DS_UNSAVED_CHANGE_LOST","DS");
	}	
	};
</script>
</body>
</html>

