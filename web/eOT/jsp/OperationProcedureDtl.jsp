
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,eCommon.Common.CommonBean,eOT.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE");
	String params = request.getQueryString(); 
	System.err.println("====params===OperationProcedureDtl==="+params);
%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
String end_time=checkForNull(request.getParameter("end_time"));
String start_time=checkForNull(request.getParameter("start_time"));
String facilityid=(String)session.getValue("facility_id");//Added Against ML-MMOH-CRF-1939-US2
String Patient_class = request.getParameter("Patient_class");
String function_id = request.getParameter("function_id");
//out.println("fid = "+function_id);
	Patient_class = (Patient_class == null) ? "":Patient_class;
	//out.println("Pat= "+Patient_class);
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
<script language="JavaScript" src="../../eOT/js/BookingPatientSearch.js"></script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js' ></script>
			<style>
textarea {
  resize: none;
}
</style>
<script language='javascript'>	

function setAllValues(keyData,oper_code,oper_desc,right_left,remarks,duration,avg_time,std_durn,splty_code,fpp_category)
{
	var frmObj=document.forms[0];
	frmObj.oper_code.value=oper_code;
	frmObj.operation_desc.value=oper_desc;
	frmObj.appl_right_left_flag.value=right_left;
	if(right_left=='R'||right_left=='L'||right_left=='B')
	{
		 frmObj.appl_right_left_flag.Mandatory='Y';
		 frmObj.appl_right_left_flag.disabled=false;
	}
	else
	{
		 frmObj.appl_right_left_flag.Mandatory='N';
		 frmObj.appl_right_left_flag.disabled=true;
	}
	frmObj.operation_desc.disabled=true;
	frmObj.OperationLookUp.disabled=true;
	frmObj.mode.value='U';
	frmObj.key.value=keyData;
	frmObj.remarks.value=remarks;
	frmObj.duration.value=duration;
	frmObj.avgTime.value=avg_time;
	frmObj.f_duration.value=std_durn;
	var arr = std_durn.split(" ");
	if(typeof arr[1]=="undefined")
	{
	frmObj.stdduration.value="";
	}
	else
	{
	frmObj.stdduration.value=arr[1];
	}
	frmObj.speciaitycode.value=splty_code;
	frmObj.fpp_category.value=fpp_category;
	frmObj.remarks.disabled=false;	
}

function checkForSpecCharsforID(event)
{	
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
function checkForSpecCharsforID1(event)
{   
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;  // Not a valid key
	return true ;
}

function CheckChars2(Obj){
        var str = Obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=42) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)|| (str.charCodeAt(u)==32)|| (str.charCodeAt(u)==61) || (str.charCodeAt(u)==13) || (str.charCodeAt(u)==10));
            else{
                specCharsExist = true;
                break;
            }
        }
        return specCharsExist;
    }
	function CheckChars1(obj)
	{ 
	   var specCharsExist=CheckChars2(obj);
   
	   
	   if(specCharsExist==true) 
		{
		 alert(getMessage("APP-OT0162","OT"));
		
		  obj.focus();
	      return;
		}
		checkLength();
	}
function validateDuration(obj){
	var retval=true;	
	
	var duration=obj.value;
	var arr=duration.split(":");
	
	if(duration!=''){
	if(duration.length!="5" || arr[0].length!="2"){
		alert(getMessage("APP-OT0130","OT"));
		obj.select();
		obj.focus()
		return;
	    }
    }
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2){
			var retval=cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		if(retval==true)
		{
		if(arr_time[1]=='' || arr_time[0]==''){
		cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		}
		if(retval==true)
		{
		if(arr_time[0]<0 || arr_time[0]>23 ){
			err_text+=getMessage("APP-OT0040","OT");
		}
		}
		if(retval==true)
		{
		if(arr_time[1]<0 || arr_time[1]>59 ){
			err_text+=getMessage("APP-OT0041","OT");
		}
		}
		if(err_text.length>0)	
			var retval=cal_error(err_text,obj);
	}
	
	return true
}
function exceedngTheatreEndtime()
{  	
	/* Below Code is for Duration should not exceed Theatre End time By Sathish.K on 20-06-2009 against 11538*/
	
    var frmObj=document.forms[0];
	var msgFrm=parent.parent.parent.messageFrame;
	var duration=frmObj.duration.value;
	var arr=duration.split(":");
	var end_time=frmObj.end_time.value;
    var start_time=frmObj.start_time.value;
    end_time=end_time.split(":");
	start_time=start_time.split(":");
	var hr="";
	var min="";
	var hrmin="";

	
	var h2=parseInt(Math.abs(end_time[0]));
	var m2=parseInt(Math.abs(end_time[1]));
	var h1=parseInt(Math.abs(start_time[0]));
	var m1=parseInt(Math.abs(start_time[1]));
	var arr0=parseInt(Math.abs(arr[0]));
	var arr1=parseInt(Math.abs(arr[1]));
	var h="";
	var m="";

    if(m2==m1){
		h=h2-h1;
		m=0;
	}
	else if(m2>m1)
	{  
		h=h2-h1;
		m=m2-m1;
	}else 
	{   
		h=h2-h1-1;
		m=m2-m1+60;
	}
   msg1=getMessage("APP-OT0146","OT");
  if((parseInt(arr0))>(parseInt(h)))
	{
	  
	msgFrm.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg1;
	return false;
	}
	else if((parseInt(arr0))==(parseInt(h)))
    {   
	       
		if((parseInt(arr1))>(parseInt(m)))
		{   
			msgFrm.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg1;
			return false;
		}
		else
		{  
		hr=end_time[0]-arr[0];
		min=end_time[1]-arr[1];

		if(arr[1]==end_time[1]){
		hr=end_time[0]-arr[0];
		min=0;
		}
		else if(end_time[1]>arr[1])
		{  
		hr=end_time[0]-arr[0];
		min=end_time[1]-arr[1];
		}else 
		{   
		hr=end_time[0]-arr[0]-1;
		min=end_time[1]-arr[1]+60;
		}
		
		hr=parseInt(Math.abs(hr));
		min=parseInt(Math.abs(min));
		if(hr<10)
		{
			hr="0"+hr;
		}
		if(min<10)
		{
		min="0"+min;
		}

		hrmin=hr+":"+min;
		
        frmObj.end_time.value=hrmin;
		return true;
		}
	}
	else{
		hr=end_time[0]-arr[0];
		min=end_time[1]-arr[1];

		if(arr[1]==end_time[1]){
		hr=end_time[0]-arr[0];
		min=0;
		}
		else if(end_time[1]>arr[1])
		{  
		hr=end_time[0]-arr[0];
		min=end_time[1]-arr[1];
		}else 
		{   
		hr=end_time[0]-arr[0]-1;
		min=end_time[1]-arr[1]+60;
		}
		
		if(parseInt(Math.abs(hr))<10)
		hr="0"+hr;
		if(parseInt(Math.abs(min))<10)
		min="0"+min;

		hrmin=hr+":"+min;
        frmObj.end_time.value=hrmin;
	
		return true;
	}
}


function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return;
}

function validate(){
	var obj=document.forms[0];
	var validatStr; 
	var dispStr; 
	var msgFrm=parent.parent.parent.messageFrame;
	//var REG_EXP = /^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/
	//Mesg  
	var msg = "APP0T05-Invalid Duration";
	
	var description =getLabel("Common.description.label","Common");
	var sideApplicable =getLabel("eOT.SideApplicable.Label","OT");
	var duration   =getLabel("Common.duration.label","Common");

	if(obj.duration.value=="00:00"){
		msgFrm.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		return false;
	}
	if(obj.appl_right_left_flag.Mandatory=='Y'){
		 validatStr = new Array("operation_desc","appl_right_left_flag","duration");
		 dispStr    = new Array(description,sideApplicable,duration);
	}else{
		validatStr=new Array("operation_desc","duration");
		dispStr=new Array(description,duration);
		obj.appl_right_left_flag.value="";
	}
	return(validateMandatory(obj,validatStr,dispStr,msgFrm));
}

function setInitialValue(){	
	var frmObj=document.forms[0];
	if(frmObj!=null){
		var orderid=frmObj.orderid.value;
		if(orderid.length>0){
			frmObj.appl_right_left_flag.disabled=true;
			frmObj.remarks.disabled=true;
		}	 
	}
}

function makeValidString2(txtObj)
{
    /* This function is available in common.js  
	To show proper message  written this function here*/
	var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }
    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        //alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));
		var max_len = getMessage("MAX_LENGTH_DATA","OT");
		var max_len_msg_arr = max_len.split("#");
		var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+" 500 "+max_len_msg_arr[2];
		alert(errors)

        txtObj.select();
        txtObj.focus();
    }
}

</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body onLoad="setInitialValue(); onLoadOperation(); enableProcedudureDtlFields();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

	String spltycode="";
	String spltycodedesc="";
	String strSpecialityYN1="";
	String customerId = ""; //IN050472
	String strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));	
	spltycode=checkForNull(request.getParameter("spltycode"));
	spltycodedesc=checkForNull(request.getParameter("spltydesc"));
	strSpecialityYN1=checkForNull(request.getParameter("speciality_access"));
	String strOrderId=checkForNull(request.getParameter("orderid")).intern();
	String selOrderIds = checkForNull(request.getParameter("selOrderIds")); // ChAiTu - 186
	String ammendFlag = checkForNull(request.getParameter("ammendFlag")); // ChAiTu - 186
	System.err.println("====selOrderIds===OperationProcedureDtl==="+selOrderIds);
	System.err.println("====ammendFlag===OperationProcedureDtl==="+ammendFlag);
	String called_from=checkForNull(request.getParameter("called_from")).intern();
	String disable_flag=(strOrderId!="")?"disabled":"";
	String operation_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.operation.label","common_labels")+",";
	String bill_flag = request.getParameter("bill_flag");
	System.err.println("====bill_flag===OperationProcedureDtl==="+bill_flag);
	String book_proc = checkForNull(request.getParameter("procedure"));
	
	//Added against ML-MMOH-CRF-1939-US2...starts
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	boolean isIncludeFpp = false;
	String Include_Fpp_yn = null;
	Integer count = 0;
	//Added against ML-MMOH-CRF-1939-US2...starts

	//CRF-004 Authorize Slots for Booking - Rajesh V 
	String fullVacant=checkForNull(request.getParameter("full_vacant"));
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String otParam = "";
	String sqlFacilityChk = "select NVL(SCHEDULE_RESTRICT_YN,'N') facility from OT_PARAM where rownum = 1";
	String sql_sm_report = "select customer_id from SM_SITE_PARAM where rownum = 1";//IN050472
	try
	{
		//Added Against ML-MMOH-CRF-1939-US2...starts
		con = ConnectionManager.getConnection(request);
		Include_Fpp_yn = checkForNull(bean.getIncludeFpp(facilityid));
		System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
		isIncludeFpp = CommonBean.isSiteSpecific(con,"OT","OT_FPP");
		System.err.println("isIncludeFpp --->"+isIncludeFpp);
		//isIncludeFpp = true;
		
		count = bean.getFppIcon();
		
		//Added Against ML-MMOH-CRF-1939-US2...starts
			
		stmt=con.prepareStatement(sqlFacilityChk);
		rs=stmt.executeQuery();
		if(rs !=null && rs.next())
			otParam=checkForNull(rs.getString("facility"));		
		 //IN050472 start
		stmt=null;
		rs=null;
		stmt = con.prepareStatement(sql_sm_report);
		rs = stmt.executeQuery();
		if(rs.next())
			customerId = rs.getString("CUSTOMER_ID");
		 //IN050472 end
	}
	catch(Exception e){
		e.printStackTrace();
		//System.err.println("Error in OperationProcedureDtl.jsp"+e);
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e){
			e.printStackTrace();
			//System.err.println("Error in OperationProcedureDtl.jsp"+e);
		}
	}
	//CRF-004 Authorize Slots for Booking - Rajesh V 
%>

<form name='dtlForm' id='dtlForm' method='post' action='../../eOT/jsp/OperationProcedureDtl.jsp'>
<table border='0' cellpadding=2  cellspacing='0' width='99%'>
	<tr> 
		<td class='label' width="25%">
			 <fmt:message key="Common.operation.label" bundle="${common_labels}"/>
			<input type='hidden' name='oper_code' id='oper_code' value=''> 
		</td> 
		<%if(!book_proc.equals("")){%>
		
				<td class='fields' width="25%">
			<input type='text' name='operation_desc' id='operation_desc' size='30'  value='' maxlength='30' readonly  disabled >
			<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' 
			onClick="funOTCheckDetail1('Operation','<%=operation_title%>','<%=locale%>')"  disabled >
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<%}else{%>
		<!--Added Against ML-MMOH-CRF-1939-US2...starts-->
		<%if(isIncludeFpp){%>
		<td class='fields' width="25%">
			<input type='text' name='operation_desc' id='operation_desc' size='30'  value='' maxlength='30' <%=disable_flag%> onBlur="if(this.value!='')funOTCheckDetail1('Operation','<%=operation_title%>','<%=locale%>');" disabled >
			<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' 
			onClick="funOTCheckDetail1('Operation','<%=operation_title%>','<%=locale%>')"  <%=disable_flag%> disabled >
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<%}else{%>
		<td class='fields' width="25%">
			<input type='text' name='operation_desc' id='operation_desc' size='30'  value='' maxlength='30' <%=disable_flag%> onBlur="if(this.value!='')funOTCheckDetail1('Operation','<%=operation_title%>','<%=locale%>');" >
			<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' 
			onClick="funOTCheckDetail1('Operation','<%=operation_title%>','<%=locale%>')"  <%=disable_flag%> >
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<!--Added Against ML-MMOH-CRF-1939-US2...ends-->
		<%}}%>

	
		<td class='label' width="25%" >
			<fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/> 
		</td>
		<td class='fields' width="25%">
			<select name='appl_right_left_flag' id='appl_right_left_flag' DB_VALUE='' Mandatory=''>
			<option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<option value='R' ><fmt:message key="eOT.RightSide.Label" bundle="${ot_labels}"/> </option>
			<option value='L' ><fmt:message key="eOT.LeftSide.Label" bundle="${ot_labels}"/> </option>
			<option value='B' ><fmt:message key="eOT.Bilateral.Label" bundle="${ot_labels}"/> </option>
			</select>
			<img name='imageflag' src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>

	<tr>
		<td class='label' width="25%">
			<fmt:message key="eOT.StandardDuration.Label" bundle="${ot_labels}"/> 
		</td>
		<td class='fields' width="25%" >
			<input type='text' name='stdduration' id='stdduration' size='6'  value='' maxlength='6'  readonly>
		</td>
	
		<td class='label' width="25%" >
			<fmt:message key="eOT.SurgeonAvgTime.Label" bundle="${ot_labels}"/> 
		</td>
		<td class='fields' width="25%">
			<input type='text' name='avgTime' id='avgTime' size='6'  value='' maxlength='6'  readonly>
		</td>
	</tr>

	<tr>
		<td class='label' width="25%">
		<fmt:message key="Common.duration.label" 	bundle="${common_labels}"/> 
		</td>
		<td class='fields' width="25%">
			<input type='text' name='duration' id='duration' size='6'  value='' maxlength='5' onkeypress="return checkForSpecCharsforID(event);" OnBlur='validateDuration(this)'>
			<img src='../../eCommon/images/mandatory.gif'></img>(HH24:mi)
		</td>
	<td class='label'   width="25%"  >
	<!-- Modified by Dhanasekar against issue Remarks 29473
			<fmt:message key="Common.remarks.label" bundle="${common_labels}"/> -->

			<fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/> 
			
		</td>
		<td class='fields' width="25%">
			<textarea rows='2' cols='30' name='remarks'   maxLength='500' Onblur="makeValidString2(this);"></textarea>
		</td>

	</tr>

	<tr>
		
		<td width="25%"></td>
		<td width="25%"></td>
		<td width="25%"></td>
		<td width="25%" >
			<input type='button' class='button'  value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='methodSubmit();'>
			<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='funRemoveDtl();' <%=disable_flag%> >
		</td>
		<input type='hidden' name='fpp_category' id='fpp_category' value=''>
	</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<!--<input type='hidden' name='duration' id='duration' value=''>-->
<input type='hidden' name='catalog_code' id='catalog_code' value=''>
<input type='hidden' name='f_duration' id='f_duration' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='key' id='key' value=''>
<input type='hidden' name='codeCollect' id='codeCollect' value=''>
<input type='hidden' name='specialityCollect' id='specialityCollect' value=''>
<input type='hidden' name='speciaitycode' id='speciaitycode' value='<%=spltycode%>' >
<input type='hidden' name='surgeonCode' id='surgeonCode' value='<%=strSurgeonCode%>'>
<input type='hidden' name='orderid' id='orderid' value='<%=strOrderId%>'>
<input type='hidden' name='selOrderIds' id='selOrderIds' id='selOrderIds' value='<%=selOrderIds%>'> <%-- ChAiTu - 186 --%>
<input type='hidden' name='spltycode' id='spltycode' value='<%=spltycode%>'>
<input type='hidden' name='spltycodedesc' id='spltycodedesc' value='<%=spltycodedesc%>'>
<input type='hidden' name='strSpecialityYN' id='strSpecialityYN' value='<%=strSpecialityYN1%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">
<input type='hidden' name='bill_flag' id='bill_flag' value="<%=bill_flag%>">
<input type='hidden' name='end_time' id='end_time' value="<%=end_time%>">
<input type='hidden' name='start_time' id='start_time' value="<%=start_time%>">
<input type='hidden' name='book_proc' id='book_proc' value="<%=book_proc%>">
<!-- CRF-004 Authorize Slots for Booking - Rajesh V  -->
<input type='hidden' name='durFromFrame' id='durFromFrame' value="">
<input type='hidden' name='ot_Param' id='ot_Param' value='<%=otParam%>'>
<input type='hidden' name='full_vacant' id='full_vacant' value="<%=fullVacant%>">
<!-- CRF-004 Authorize Slots for Booking - Rajesh V  -->
<input type='hidden' name='customerId' id='customerId' id='customerId' value='<%=customerId%>'> <!--  IN050472 -->
<input type='hidden' name='ammendFlag' id='ammendFlag' id='ammendFlag' value='<%=ammendFlag%>'> <!--  186 -->
 <!--Added Against ML-MMOH-CRF-1939-US2...starts-->
<input type='hidden' name='include_fpp_yn' id='include_fpp_yn' value="<%=Include_Fpp_yn%>">
<input type='hidden' name='isincludefpp' id='isincludefpp' value="<%=isIncludeFpp%>">
<input type='hidden' name='count' id='count' value="<%=count%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<!--Added Against ML-MMOH-CRF-1939-US2...ends-->
</form>
</BODY>
</HTML>

