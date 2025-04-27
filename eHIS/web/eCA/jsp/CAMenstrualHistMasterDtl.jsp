<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
		<script src='../js/CAMenstrualHistDtl.js'			language='javascript'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	</head>
	<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
	
	<%
	//IN072674 starts
	int recordExists =0;
	String facility_name			= "";
	 int minAge=1;
	 int maxAge=999;
	 int cutOffBackdate=0;
	 int cutOffDeliveryDate=0;
	 int cutOffDeliveryLmp=1;
	 int CutOffMiscarriageLmp=1;
	 String enableMarkAsErrorYN="N";
	 String enable_mark_as_error_checked = "";
     String facility_id              = request.getParameter( "facility_id" ) ;		
		String mode	                    = request.getParameter( "mode" ) ;
     if(facility_id == null){
			facility_id = (String)session.getValue("facility_id") ;
		}
     String or_bean_id 						= "@CAMenstrualHistDtlBean";
     String or_bean_name 					= "eCA.CAMenstrualHistDtlBean";
     CAMenstrualHistDtlBean bean		= (CAMenstrualHistDtlBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	ArrayList  resArray = bean.getMenstrualHistoryDetailsRecords(facility_id);
	recordExists = bean.checkForMode(facility_id);
	facility_name = bean.getFacilityName(facility_id);
	
	
	if(resArray.size()>0){
		for(int i=0;i<resArray.size();i++){
			ArrayList array = (ArrayList)resArray.get(i);
			minAge = Integer.parseInt((String) array.get(1)); 
			maxAge = Integer.parseInt((String) array.get(2)); 
			cutOffBackdate = Integer.parseInt((String) array.get(3)); 
			cutOffDeliveryDate = Integer.parseInt((String) array.get(4)); 
			cutOffDeliveryLmp = Integer.parseInt((String) array.get(5)); 
			CutOffMiscarriageLmp = Integer.parseInt((String) array.get(6)); 
			enableMarkAsErrorYN=(String)array.get(7);
		}
}
	
	
	if("Y".equals(enableMarkAsErrorYN))
	{
	  enable_mark_as_error_checked="checked";
	}
	else
	{
		enable_mark_as_error_checked = "unchecked";
	}
			%>
	
		<form name="CAMenstrualHistoryDtl" id="CAMenstrualHistoryDtl" method="post" target="messageFrame">
			<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
			<table cellpadding='3' cellspacing='0' border='0' width='80%' align='center'>
				<tr>
					<td  class="label"  width='40%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td  class='fields'>
						<input type=text name="facility_disp" id="facility_disp" value='<%=facility_name%>' readonly>						
					</td>
				</tr>
				<tr>
					<td class="label"	width="40%" ><fmt:message key="eCA.ApplicableAgeforMenstrual.label" bundle="${ca_labels}"/></td>
					<td  class='fields'>
					<fmt:message key="Common.MinimumAge.label" bundle="${ca_labels}"/>
					<input type=text name="Min_Age" id="Min_Age" id='Min_Age' size='3' maxlength='3'  class="NUMBER"  onblur="zerocheck();return checkForMinus(this)" value='<%=minAge%>' onKeyPress="return isValidInteger(this);"/>
					<fmt:message key="Common.Years.label" bundle="${ca_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'>&emsp;&emsp;	
					<fmt:message key="eCA.MaximumAge.label" bundle="${ca_labels}"/>
					<input type=text name="Max_Age" id="Max_Age" id='Max_Age' size='3' maxlength='3'  class="NUMBER"   onblur="zerocheck();return checkForMinus(this)" value='<%=maxAge%>' onKeyPress="return isValidInteger(this);"/>
					<fmt:message key="Common.Years.label" bundle="${ca_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'>&emsp;		
					</td>				
				</tr>
				<tr>
					<td  class="label"  width='40%'><fmt:message key="eCA.CutOffBackdateDelivery.label" bundle="${ca_labels}"/></td>
					<td  class='fields'>
					<input type=text name="Cut_Off_Backdate_Delivery" id="Cut_Off_Backdate_Delivery" id='Cut_Off_Backdate_Delivery' size='2' maxlength='2'  class="NUMBER"  onblur="return checkForMinus(this)" value='<%=cutOffBackdate%>' onKeyPress="return isValidInteger(this);"/>
					<fmt:message key="Common.days.label" bundle="${ca_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
					</td>
				</tr>
				<tr>
					<td  class="label"  width='40%'><fmt:message key="eCA.CutOffDateDelivery.label" bundle="${ca_labels}"/></td>
					<td  class='fields'>
					<input type=text name="Cut_Off_Date_Delivery" id="Cut_Off_Date_Delivery" id='Cut_Off_Date_Delivery' size='2' maxlength='2'  class="NUMBER"  onblur="return checkForMinus(this)"  value='<%=cutOffDeliveryDate%>' onKeyPress="return isValidInteger(this);"/>
					<fmt:message key="Common.days.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
					</td>
				</tr>
				<tr>
					<td  class="label"  width='40%'><fmt:message key="eCA.CutOffDeliveryLmp.label" bundle="${ca_labels}"/></td>
					<td  class='fields'>
					<input type=text name="Cut_Off_Delivery_Lmp" id="Cut_Off_Delivery_Lmp" id='Cut_Off_Delivery_Lmp' size='3' maxlength='3'  class="NUMBER"  onblur="zerocheck();return checkForMinus(this)" value='<%=cutOffDeliveryLmp%>' onKeyPress="return isValidInteger(this);"/>
					<fmt:message key="Common.days.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
					</td>
				</tr>	
				<tr>
					<td  class="label"  width='40%'><fmt:message key="eCA.CutOffMiscarriageLmp.label" bundle="${ca_labels}"/></td>
					<td  class='fields'>
					<input type=text name="Cut_Off_Miscarriage_Lmp" id="Cut_Off_Miscarriage_Lmp" id='Cut_Off_Miscarriage_Lmp' size='3' maxlength='3'  class="NUMBER"  onblur="zerocheck();return checkForMinus(this)" value='<%=CutOffMiscarriageLmp%>' onKeyPress="return isValidInteger(this);"/>
					<fmt:message key="Common.days.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
					</td>
				</tr>
				<tr>
	   				<td class="label" align='left'><fmt:message key="eCA.EnableMarkAsError.label" bundle="${ca_labels}"/></td>
	   				<td><input type="checkbox" name="Enable_Mark_As_Error_YN" id="Enable_Mark_As_Error_YN" id='Enable_Mark_As_Error_YN' value ='<%=enableMarkAsErrorYN%>' <%=enable_mark_as_error_checked%>  onclick ="toEnableMark(this)" ></td> 
	   		 </tr>	
			</table>
			<input type=hidden name="facility" id="facility" value='<%=facility_id%>'>
		</form>
	</body>
</html>

