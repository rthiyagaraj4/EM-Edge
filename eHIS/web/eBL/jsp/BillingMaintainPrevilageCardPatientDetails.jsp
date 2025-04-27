<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*, eBL.Common.*,eBL.resources.*,  eCommon.Common.*,eBL.BillingPrevilageCardPatientBean,eBL.BillingPrevilageCardMemberBean ,eBL.BillingPrevilageCardVisiiUtilizationBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- <%@ page import ="eBL.BLChargePatientDAO" %> --%>



<html>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String applyMode														=	new String();
String locale															=	"";
String facilityId														=	"";
String hiddenPatientId													=	"";
String patientDetails													=	"";
String mode																=	"";
String isUserCanAcess													=	"";
String sStyle 															=	"";
String authorized 														=	"";
String bean_id															=	"";
String bean_name														=	"";
String bean_id1															=	"";
String bean_name1														=	"";
String bean_id2															=	"";
String bean_name2														=	"";
String hiddenPriceClasscode												=	"";
String hiddenPriceClassDesc												=	"";
String hiddenCardTypeCode												=	"";
String hiddenCardTypeDesc												=	"";
String rowCount															=	"";
ArrayList<String[]> PatientDetailsList									=	null;
ArrayList<String[]> visitUtilizationDetailsList							=	null;
ArrayList			 PrevilageCardList									=	null;
String cardIndex														=	null;
String hCardSeqnNo														=	null;
String priceClassCode													=	null;
String priceClassDesc													=	null;
String prmaryPatientId													=	null;
String from_date														=	null;
String toDate															= 	null;
String mebnmberFees														=	null;
String billingServiceCode												=	null;
String hiddenhiddenPackageCode											=	null;
String oPAllotement														=	null;
String oPAvailed														=	null;
String defaultCode														=	"";
String disableMode														=	"DISABLED";
String readonly															=	"DISABLED";
String primaryPatientId													=	"";
ArrayList<String[]> priceClassCodeAndDescList							= 	null;

try
{
	
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	
	bean_id																					= 	"BillingPrevilageCardPatientBean" ;
	bean_name																				= 	"eBL.BillingPrevilageCardPatientBean";
	BillingPrevilageCardPatientBean billingPrevilageCardPatientBean							= 	(BillingPrevilageCardPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	bean_id1																				= 	"BillingPrevilageCardMemberBean" ;
	bean_name1																				= 	"eBL.BillingPrevilageCardMemberBean";
	BillingPrevilageCardMemberBean billingPrevilageCardMemberBean							= 	(BillingPrevilageCardMemberBean)getBeanObject( bean_id1, bean_name1, request ) ;
	bean_id2																				= 	"BillingPrevilageCardVisiiUtilizationBean" ;
	bean_name2																				= 	"eBL.BillingPrevilageCardVisiiUtilizationBean";
	BillingPrevilageCardVisiiUtilizationBean billingPrevilageCardVisiiUtilizationBean		= 	(BillingPrevilageCardVisiiUtilizationBean)getBeanObject( bean_id2, bean_name2, request ) ;
	PatientDetailsList																		= 	new ArrayList();
	hiddenPatientId																			=	checkForNull(request.getParameter("hiddenPatientId"));
	//billingPrevilageCardPatientBean.getBillingPrevilageCardPatient(hiddenPatientId, facilityId,locale);
 	hiddenPriceClasscode																	=	checkForNull(request.getParameter("priceClassCode"));
 	hiddenPriceClassDesc																	=	checkForNull(request.getParameter("priceClassDesc"));
 	hiddenCardTypeCode																		=	checkForNull(request.getParameter("cardTypeCode")); 
 	hiddenCardTypeDesc																		=	checkForNull(request.getParameter("cardTypeDesc"));
 	hiddenhiddenPackageCode																	=	checkForNull(request.getParameter("packageCode"));
	visitUtilizationDetailsList																=	new ArrayList();
	PrevilageCardList																		=	new ArrayList();
	//cardIndex																				=	checkForNull(request.getParameter("patientId"));
	hCardSeqnNo																				=	checkForNull(request.getParameter("hCardSeqnNo"));
	priceClassCode																			=	checkForNull(request.getParameter("priceClassCode"));
	priceClassDesc																			=	checkForNull(request.getParameter("priceClassDesc"));
	from_date																				=	checkForNull(request.getParameter("fromDate"));
	toDate																					=	checkForNull(request.getParameter("toDate"));
	mebnmberFees																			=	checkForNull(request.getParameter("mebnmberFees"));
	billingServiceCode																		=	checkForNull(request.getParameter("billingServiceCode"));
	primaryPatientId																		=	checkForNull(request.getParameter("primaryPatientId"));
	mode																					=	(String)session.getAttribute("maintainMode");
	mode																					=	checkForNull(mode);
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	authorized 																				=	(String)session.getAttribute("authorized");
	priceClassCodeAndDescList																=	new ArrayList();
	 System.out.println("mode::::: "+mode+" ::authorized::: "+authorized);
	 if(mode.equalsIgnoreCase("modify") && authorized.equalsIgnoreCase("Y"))
	{
		 disableMode ="READONLY";
		 readonly ="READONLY";

	}
	 else
	 {
		 disableMode ="DISABLED";
		 readonly ="DISABLED";
	 }
	System.out.println("disableMode::::: "+disableMode);
	
	System.out.println("hiddenPatientId	::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+hiddenPatientId);
	System.out.println("hCardSeqnNo		::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+hCardSeqnNo);
	System.out.println("priceClassCode	::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+priceClassCode);
	System.out.println("priceClassDesc	::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+priceClassDesc);
	System.out.println("hiddenPriceClasscode	::	BillingMaintainPrevilageCardPatientDetails.jsp::::: "+hiddenPriceClasscode);

%>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
    <!--<script language="javascript" src="../../eCommon/js/common.js"></script> -->
        <script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>		

        
        <script language ="javaScript"    src ='../../eCommon/js/CommonLookup.js'></Script>	
		<script language="javascript"     src="../../eCommon/js/ValidateControl.js"></script> 
		<script language='javascript'     src='../../eCommon/js/FieldFormatMethods.js'></script>
		
	 	<script language="javascript" src="../../eBL/js/BLPatientEncounters.js"></script> 	
		
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../js/BillingMainatainPrevilageCard.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		
		

		
	  <link rel="stylesheet" type="text/css" href="../../eBL/html/ui.dropdownchecklist.css" />
         <link rel="stylesheet" type="text/css" href="../../eBL/html/main.css" />
    

      
  
	
</head>


<BODY onLoad="  "  onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" >

<FORM method='post' name="BillingMaintainPrevilageCardPatientDetails" id="BillingMaintainPrevilageCardPatientDetails"  id="BillingMaintainPrevilageCardPatientDetails"  action="" >

     <table align='center' border='0' cellpadding=3 cellspacing=0  width='100%' align="center"> 		
				<tr>	
					<td class='COLUMNHEADER'  align='left' ><fmt:message key="eBL.PRIVILIEGE_CARD_MEMBER.label" bundle="${bl_labels}"/> - <%=hiddenCardTypeDesc%> </th>
				</tr>
				
	</table>
		
		   
    
    <!--  table border='0' cellspacing="5"-->    
  
    
    
    <table border='0' cellpadding='1' cellspacing='0' width='100%' >
		<tr>
			<td class='fields' width="10%"></td>
			<td class='fields' width="55%"></td>
			<td class='fields' width="55%"></td>
			<td class='fields' width="55%"></td>
			<td ><input type="button" class='button' name="addnew" id="addnew"	id="addnew"   value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" <%=disableMode%>	onclick="addNewRow('patient_subscribe_modify','patient_id');" /></td>	
 			<td ><input type="button" class='button' name="reprint" id="reprint"	id="reprint"   value="Reprint" <%=disableMode%> style="visibility: hidden;" /></td>

		</tr>
	</table>
			
  
   <table align='center' border='0' cellpadding=2 cellspacing=0  width='100%'  id="patient_subscribe_modify_header" name="patient_subscribe_modify_header" id="patient_subscribe_modify_header"> 
    
      	<tr>
		     <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'> </th> 
		     <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="Common.PatientName.label"   bundle="${common_labels}"/></th>					 
	         <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="Common.age.label"   bundle="${common_labels}"/></th>	
	         <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="eBL.PRICE_CLASS.label"   bundle="${bl_labels}"/></th>
	         <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="Common.delete.label"   bundle="${common_labels}"/></th>	
			 
    	 </tr>  
    </table>
 <div id="patient_subscribe_modify_div" name="patient_subscribe_modify_div" style="width:100%; height:120; overflow: auto;">
   	<table align='center' border='0' cellpadding=2 cellspacing=0  width='100%'  id="patient_subscribe_modify" name="patient_subscribe_modify" id="patient_subscribe_modify"> 
  
<%
		PatientDetailsList = billingPrevilageCardMemberBean.getAdditionalPatientId(hCardSeqnNo,facilityId);
		priceClassCodeAndDescList = billingPrevilageCardPatientBean.LoadPriceClassCodeAndDesc(hiddenCardTypeCode, locale);
		for(int index=0;index<PatientDetailsList.size();index++)
		{
			defaultCode=PatientDetailsList.get(index)[3];
						
 %>   		
 	 		<tr>
			     <td class="fields" width="1%"><input type="text"  	name="patient_id<%=index%>" id="patient_id<%=index%>" 				id="patient_id<%=index%>"			size="15" 	maxlength='12' 	value='<%=  PatientDetailsList.get(index)[0]	!=null 	? 	PatientDetailsList.get(index)[0]	: 	"" %>'	<%=disableMode%>  	onKeyPress='changeToUpper()' 		onBlur="" 	></td>         
				 <td class="fields" width="1%"><input type="text"  	name="patient_name<%=index%>" id="patient_name<%=index%>"				id="patient_name<%=index%>" 		size="25" 	maxlength='12' 	value='<%=	PatientDetailsList.get(index)[1]	!=null 	? 	PatientDetailsList.get(index)[1]	: 	"" %>'	<%=disableMode%>  	onKeyPress='changeToUpper()' 		onBlur="" 	></td>         
				 <td class="fields" width="1%"><input type='text' 	name="patient_age<%=index%>" id="patient_age<%=index%>"				id="patient_age<%=index%>" 			size="15" 	maxlength='12' 	value='<%=	PatientDetailsList.get(index)[2]	!=null	?	PatientDetailsList.get(index)[2]	:	"" %>'	<%=disableMode%>  																																											onKeyPress='ChkNumberInput()' 		onBlur=""	></td> 
				 <td class="fields" width="1%"><select style=" width: 200px; " id="price_class_Code<%=index%>" name="price_class_Code<%=index%>" <%=readonly%>>
		              <%
		              for(int priceListIndex=0;priceListIndex<priceClassCodeAndDescList.size();priceListIndex++)
		          		{
		            	  
		              %>
		              <option title="<%=defaultCode %> - <%=priceClassCodeAndDescList.get(priceListIndex)[1]%>" value=<%=priceClassCodeAndDescList.get(priceListIndex)[0]%> <%= priceClassCodeAndDescList.get(priceListIndex)[0].equalsIgnoreCase(defaultCode) ? "SELECTED" : "" %> > <%=priceClassCodeAndDescList.get(priceListIndex)[0]%> - <%=priceClassCodeAndDescList.get(priceListIndex)[1]%> </option>
		              <%
		          		}
		              %>
		     								</select></td>       
				 <%-- <td class="fields" width="1%"><input type="text"  	name="price_class_Code<%=index%>" id="price_class_Code<%=index%>" 			id="price_class_Code<%=index%>"		size="6" 	maxlength='12' 	value='<%= 	PatientDetailsList.get(index)[3]	!=null 	? 	PatientDetailsList.get(index)[3]	: 	"" %>'	<%=readonly%>	 	onKeyPress='changeToUpper()' 		onBlur="" 	>
			 					 	 			<input type="text" 	name="price_class_desc<%=index%>" id="price_class_desc<%=index%>" 			id="price_class_desc<%=index%>"		size="12" 	maxlength='12' 	value='<%= 	PatientDetailsList.get(index)[4]	!=null 	? 	PatientDetailsList.get(index)[4]	: 	"" %>'	<%=readonly%>	  	onKeyPress='changeToUpper()' 		onBlur="" 	>
			 					 	 			<input type='button'class='button' 								name='patientidbut"+index+"' id='patientidbut"+index+"' 		<%=readonly%>		value='?' 	onClick="return PriceClassCodeLookup('<%=index%>')"  	tabindex='2' ></td></td>         
 --%>			 	 <td class="fields" width="1%"><input type="checkbox"	name="chk<%=index%>" id="chk<%=index%>"						id="chk<%=index%>" 					value=''  	onKeyPress='ChkNumberInput()'  <%=disableMode%>	onBlur=""	onclick="checkSelected(this)"></td> 
			 						 		   <input type="hidden"  	name="type<%=index%>" id="type<%=index%>"  						id="type<%=index%>"	 				value='<%= 	PatientDetailsList.get(index)[5]	!=null 	? 	PatientDetailsList.get(index)[5]	: 	"" %>'	/>
			</tr>
<%
		}
	%>	
 	</table>
</div>
    
    <br/>
    
    <TABLE align='center' border='0' cellpadding=3 cellspacing=0  width='100%' align="center"> 		
				<tr>	
					<td class='COLUMNHEADER'  align='left' ><fmt:message key="eBL.BLOpVisitUtilazationStatus.label" bundle="${bl_labels}"/></th>
				</tr>
				
		</table>
   	<br/>	

	   
    <%
		  disableMode ="DISABLED";

		%>
    <!--  table border='0' cellspacing="5"-->    
    
    <table align='center' border='0' cellpadding=3 cellspacing=0  width='100%' align="center">
    <%
    
    billingPrevilageCardVisiiUtilizationBean.getOpVisitUtilizationStatus(primaryPatientId, hCardSeqnNo, facilityId, locale);
    
    %>
    <tr>
        <td class="label" width="4%" nowrap><fmt:message key="eBL.BLNoOfOPAllotment.label"   bundle="${bl_labels}"/></td>	
		<td class="fields" ><input type="text"  name="op_allotement" id="op_allotement" id="op_allotement" size="17" maxlength='12' 	value='<%= billingPrevilageCardVisiiUtilizationBean.getOpVistsAllowed() !=null ? billingPrevilageCardVisiiUtilizationBean.getOpVistsAllowed()  : "" %>' <%=disableMode%>  onKeyPress='changeToUpper()' onBlur="" ></td>
	 	
		<td class="label" width="4%" nowrap><fmt:message key="eBL.BLTillDateAvailed.label"   bundle="${bl_labels}"/></td>	
		<td class="fields" ><input type="text"  name="till_date" id="till_date" 	id="till_date"	size="17" maxlength='12' 		value='<%= billingPrevilageCardVisiiUtilizationBean.getOpVistsAvailed() !=null ? billingPrevilageCardVisiiUtilizationBean.getOpVistsAvailed() : ""%>' <%=disableMode%> onKeyPress='changeToUpper()' onBlur="" ></td>
		
		<td class="label" width="4%" nowrap style="visibility: hidden;"><fmt:message key="eBL.BLDetails.label"   bundle="${bl_labels}"/></td>	
		<td class="fields" ><input type="checkbox" checked="checked" style="visibility: hidden;"></td>
				
	</tr>  
    </table>		
  
	
   	
 <div id="patient_visiit_utilization_header_div" name="patient_visiit_utilization_header_div"  >  		
    
    <table align='center' border='1' cellpadding=3 cellspacing=0  width='100%' > 

      <tr>
	     <th class='CAFLOWSHEETLEVEL1' width="1%"	align='left'><fmt:message key="eBL.BLClinic.label"   		bundle="${bl_labels}"/></th>		  			   
		 <th class='CAFLOWSHEETLEVEL1' width="2%"	align='left'><fmt:message key="eBL.BLVisitType.label"   	bundle="${bl_labels}"/></th>					   
         <th class='CAFLOWSHEETLEVEL1' width="1%"	align='left'><fmt:message key="eBL.BLNoOfVisit.label"   	bundle="${bl_labels}"/></th>	
         <th class='CAFLOWSHEETLEVEL1' width="1%"	align='left'><fmt:message key="eBL.BLAvailed.label"   		bundle="${bl_labels}"/></th>	 
	  </tr>
	</table>
</div>
<div id="patient_visiit_utilization_div" name="patient_visiit_utilization_div" style="width:100%; height:60; overflow: auto;">
	 <table align='center' border='0' cellpadding=3 cellspacing=0  width='100%' >	  
<%

		 
		//visitUtilizationDetailsList = billingPrevilageCardVisiiUtilizationBean.getVisitUtilizationDetails(billingPrevilageCardPatientBean.getHcardSeqNo(),  facilityId,locale);
		visitUtilizationDetailsList = billingPrevilageCardVisiiUtilizationBean.getVisitUtilizationDetails(hCardSeqnNo, facilityId,locale);
		System.out.println("visitUtilizationDetailsList SIZE:::: "+visitUtilizationDetailsList.size());
		for(int visistIndex= 0;visistIndex<visitUtilizationDetailsList.size();visistIndex++)
		{
%>	  
	 <tr>
     	<td class="fields"  width="1%"><input type="text"  name="clinic<%=visistIndex %>" id="clinic<%=visistIndex %>" 			id="clinic<%=visistIndex %>"			size="15" 	maxlength='12' 	value='<%=  visitUtilizationDetailsList.get(visistIndex)[0]	!=null 	? 	visitUtilizationDetailsList.get(visistIndex)[0]	: 	"" %>'	<%=disableMode%>  	onKeyPress='changeToUpper()' 	onBlur="" 	></td>         
	 	<td class="fields"  width="2%"><input type="text"  name="visit_type<%=visistIndex %>" id="visit_type<%=visistIndex %>" 		id="visit_type<%=visistIndex %>"		size="38" 	maxlength='12' 	value='<%=  visitUtilizationDetailsList.get(visistIndex)[1]	!=null 	? 	visitUtilizationDetailsList.get(visistIndex)[1]	: 	"" %>'	<%=disableMode%>  	onKeyPress='changeToUpper()' 	onBlur="" 	></td>         
	 	<td class="fields"  width="1%"><input type='text' 	name="no_of_visit<%=visistIndex %>" id="no_of_visit<%=visistIndex %>" 	id="no_of_visit<%=visistIndex %>"		size="25" 	maxlength='12' 	value='<%=  visitUtilizationDetailsList.get(visistIndex)[2]	!=null 	? 	visitUtilizationDetailsList.get(visistIndex)[2]	: 	"" %>'	<%=disableMode%>  	onKeyPress='ChkNumberInput()' 	onBlur=""	></td> 
	 	<td class="fields"  width="1%"><input type='text' 	name="availed<%=visistIndex %>" id="availed<%=visistIndex %>" 		id="availed<%=visistIndex %>"			size="25" 	maxlength='12' 	value='<%=  visitUtilizationDetailsList.get(visistIndex)[3]	!=null 	? 	visitUtilizationDetailsList.get(visistIndex)[3]	: 	"" %>'	<%=disableMode%>  	onKeyPress='ChkNumberInput()' 	onBlur=""	></td> 
	 
     </tr>
<%
		}
%>     
    </table>	
 </div>   
   
   		<input type='hidden' name='locale' id='locale' 				 	id='locale'  				value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId'	 	     	id='facilityId'  			value="<%=facilityId%>" >
		<input type='hidden' name='mode' id='mode' 				 	id='mode' 					value="<%=mode%>" >
		<input type='hidden' name='authorized' id='authorized'			 	id='authorized'  			value="<%=authorized%>" /> 
		<input type='hidden' name='isUserCanAcess' id='isUserCanAcess'		 	id='isUserCanAcess' 		value="<%=isUserCanAcess%>" />
		<input type='hidden' name='hiddenCardTypeCode' id='hiddenCardTypeCode' 	 	id='hiddenCardTypeCode'		value="<%=hiddenCardTypeCode%>">
		<input type='hidden' name='hiddenPatientId' id='hiddenPatientId' 	 	id='hiddenPatientId'		value="<%=hiddenPatientId%>">
		<input type='hidden' name='hiddenPriceClasscode' id='hiddenPriceClasscode' 	id='hiddenPriceClasscode'	value="<%=hiddenPriceClasscode%>">
		<input type='hidden' name='hiddenPriceClassDesc' id='hiddenPriceClassDesc' 	id='hiddenPriceClassDesc'	value="<%=hiddenPriceClassDesc%>">
		<input type='hidden' name='rowCount' id='rowCount'			 	id='rowCount'				value="<%=rowCount%>">
		<input type='hidden' name='from_date' id='from_date'			 	id='from_date'				value="<%=from_date%>">
		<input type='hidden' name='hCardSeqnNo' id='hCardSeqnNo'			 	id='hCardSeqnNo'			value="<%=hCardSeqnNo%>">
		<input type='hidden' name='hiddenhiddenPackageCode' id='hiddenhiddenPackageCode'	id='hiddenhiddenPackageCode'value="<%=hiddenhiddenPackageCode%>">
		<input type='hidden' name='to_date' id='to_date'					id='to_date'				value="<%=toDate%>">
		<input type='hidden' name='member_fees' id='member_fees'				id='member_fees'			value="<%=mebnmberFees%>">
		<input type='hidden' name='billingServiceCode' id='billingServiceCode'		id='billingServiceCode'		value="<%=billingServiceCode%>">
		<input type='hidden' name='primaryPatientId' id='primaryPatientId' 	 	id='primaryPatientId'		value="<%=primaryPatientId%>">
		
		<input type='hidden' name='oPAllotement' id='oPAllotement'			id='oPAllotement'			value="<%=checkForNull(billingPrevilageCardVisiiUtilizationBean.getOpVistsAllowed())%>">
		<input type='hidden' name='oPAvailed' id='oPAvailed'				id='oPAvailed'				value="<%=checkForNull(billingPrevilageCardVisiiUtilizationBean.getOpVistsAvailed())%>">
		
		
   	</form>
</body>
<%
putObjectInBean(bean_id, billingPrevilageCardPatientBean, request);
}
catch(Exception e)
{
	System.out.println("Exception in BillingMaintainPrevilageCardPatientDetails.jsp.jsp::"+e);
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</html>

