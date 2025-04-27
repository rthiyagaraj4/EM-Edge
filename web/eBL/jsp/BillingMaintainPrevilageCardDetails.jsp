<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*, eBL.Common.*,eBL.resources.*,  eCommon.Common.*,eBL.BillingPrevilageCardPatientBean,eBL.BillingPrevilageCardMemberBean ,eBL.BillingPrevilageCardVisiiUtilizationBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- <%@ page import ="eBL.BLChargePatientDAO" %> --%>


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
String billingServiceCode												=	"";
String rowCount															=	"";
ArrayList<String[]> PatientDetailsList									=	null;
ArrayList<String[]> visitUtilizationDetailsList							=	null;
ArrayList			 PrevilageCardList									=	null;
String cardIndex														=	null;
String readonly															=	"DISABLED";
String disableMode														=	"DISABLED";
ArrayList<String[]> priceClassCodeAndDescList							= 	null;
String selected 														=	"SELECTED";
String disablePrint														=	"DISABLED";


try
{
	
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	
	bean_id																					= 	"BillingPrevilageCardPatientBean" ;
	bean_name																				= 	"eBL.BillingPrevilageCardPatientBean";
	BillingPrevilageCardPatientBean billingPrevilageCardPatientBean							= 	(BillingPrevilageCardPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	mode																					=	(String)session.getAttribute("maintainMode");
	mode																					=	checkForNull(mode);
	PrevilageCardList																		= 	new ArrayList(); 
	priceClassCodeAndDescList																=	new ArrayList();
	hiddenPatientId																			=	checkForNull(request.getParameter("patientId"));
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	authorized 																				=	(String)session.getAttribute("authorized");
	 System.out.println("mode::::: "+mode+" ::authorized::: "+authorized);
	 if(mode.equalsIgnoreCase("modify") && authorized.equalsIgnoreCase("Y"))
	{
		 readonly ="READONLY";
		 disablePrint="";
	}
	 else
	 {
		 readonly ="DISABLED";
		 disablePrint="DISABLED";
	 }
	 System.out.println("mode::::: "+mode);
	  disableMode ="DISABLED";
//	System.out.println("hiddenPatientId::BillingMaintainPrevilageCardDetails.jsp::::: "+hiddenPatientId);
//	System.out.println("disableMode::::: "+disableMode);
	

%>

<html>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
		
	  <link rel="stylesheet" type="text/css" href="../../eBL/html/ui.dropdownchecklist.css" />
         <link rel="stylesheet" type="text/css" href="../../eBL/html/main.css" />
    

      
  
	
</head>
<BODY onLoad="  "  onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" >

 <FORM method='post' name="BillingMaintainPrevilageCardDetails" id="BillingMaintainPrevilageCardDetails"  id="BillingMaintainPrevilageCardDetails"  action="" onsubmit="return funQry()">

   		<table class='grid' width='100%' id="pkgSubs_tabId" name="pkgSubs_tabId" id="pkgSubs_tabId" >
			<tr>
				<td  class='COLUMNHEADER' colspan='4' ><b><%= billingPrevilageCardPatientBean.getPatientDetails(hiddenPatientId, facilityId, locale)%></b><b></td>
			</tr>
		</table>

   <br/>
  
    
   <table align='center' border='1' cellpadding=3 cellspacing=0  width='100%'> 

		 <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="eBL.PrimaryPatientID.label"  bundle="${bl_labels}"/></th> 
	     <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="eBL.CARD_TYPE.label"			bundle="${bl_labels}"/></th> 
		 <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="eBL.PRICE_CLASS.label"		bundle="${bl_labels}"/></th>				 <th class='CAFLOWSHEETLEVEL1'  width="1%"  align='left'><fmt:message key="Common.fromdate.label"		   bundle="${common_labels}"/></th>	
         <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="Common.todate.label"			bundle="${common_labels}"/></th>	
		 <th class='CAFLOWSHEETLEVEL1' 	width="1%"	align='left'><fmt:message key="eBL.MEMBER_SHIP_FEES.label"	bundle="${bl_labels}"/></th>	
	</table>		 
<div id="card_type_div" name="card_type_div" style="width:100%; height:145px; overflow: auto;">		 
	<table align='center' border='0' cellpadding=3 cellspacing=0  width='100%' id="primary_patient_table" name="primary_patient_table" id="primary_patient_table">	 
<%
PrevilageCardList = billingPrevilageCardPatientBean.getBillingPrevilageCardPatient(hiddenPatientId,facilityId,locale);
if(PrevilageCardList.size()>0)
{
for(int index=0;index<PrevilageCardList.size();index++)
{
	billingPrevilageCardPatientBean = (BillingPrevilageCardPatientBean)PrevilageCardList.get(index);
	priceClassCodeAndDescList		= billingPrevilageCardPatientBean.getPriceClassCodeAndDescList();
	
	for(int priceListIndex=0;priceListIndex<priceClassCodeAndDescList.size();priceListIndex++)
	{
		System.out.println("priceClassCodeAndDescList::::::::: "+priceClassCodeAndDescList.get(priceListIndex)[0]+" - "+priceClassCodeAndDescList.get(priceListIndex)[1]);
	}

%> 
    	 <tr onclick="ShowCardsubsciptionDetails('<%=hiddenPatientId%>','<%=index%>');">
			  <td class="fields" width="1%"><input type="text"  	name="primary_patientId<%=index%>" id="primary_patientId<%=index%>" 			id="primary_patientId<%=index%>"		  	<%=disableMode%>	size="15" 	maxlength='12' 	value='<%= billingPrevilageCardPatientBean.getPrimaryPatientId()				!=null ? billingPrevilageCardPatientBean.getPrimaryPatientId() 			: "" %>' 	onKeyPress='changeToUpper()' 	onBlur="" 	align="left"></td>
		     <td class="fields" width="1%"><input type="text"  	name="card_type<%=index%>" id="card_type<%=index%>" 			id="card_type<%=index%>"		  	<%=disableMode%>	size="25" 	maxlength='20' 	value='<%= billingPrevilageCardPatientBean.getPrevilageCardType()				!=null ? billingPrevilageCardPatientBean.getPrevilageCardType() 			: "" %>' 	onKeyPress='changeToUpper()' 	onBlur="" 	align="left"></td>
		          <td class="fields" width="1%"><select style="width: 180px;" id="price_class_Code<%=index%>" name="price_class_Code<%=index%>" <%=readonly%> onChange="showAlert('<%=billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode() %>',this);">
		              <%
		              for(int priceListIndex=0;priceListIndex<priceClassCodeAndDescList.size();priceListIndex++)
		          		{
		            	  
		              %>
		              <option title="<%=billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode()%> - <%=priceClassCodeAndDescList.get(priceListIndex)[1]%>" value=<%=priceClassCodeAndDescList.get(priceListIndex)[0]%> <%= priceClassCodeAndDescList.get(priceListIndex)[0].equalsIgnoreCase(billingPrevilageCardPatientBean.getPrevilageCardPriceClassCode()) ? "SELECTED" : "" %> > <%=priceClassCodeAndDescList.get(priceListIndex)[0]%> - <%=priceClassCodeAndDescList.get(priceListIndex)[1]%> </option>
		              <%
		          		}
		              %>
		     								</select></td>         
			 <td class="fields" width="1%"><input type='text' 	name="from_date<%=index%>" id="from_date<%=index%>" 			id="from_date<%=index%>"			<%=disableMode%>	size="27" 	maxlength='12' 	value='<%= billingPrevilageCardPatientBean.getPrevilageCardFromDate()			!=null ? billingPrevilageCardPatientBean.getPrevilageCardFromDate() 		: "" %>'  	onKeyPress='ChkNumberInput()' 	onBlur=""	align="left"></td> 
			 <td class="fields" width="1%"><input type='text' 	name="to_date<%=index%>" id="to_date<%=index%>" 			id="to_date<%=index%>"				<%=disableMode%>	size="27" 	maxlength='12' 	value='<%= billingPrevilageCardPatientBean.getPrevilageCardToDate()				!=null ? billingPrevilageCardPatientBean.getPrevilageCardToDate() 			: "" %>'  	onKeyPress='ChkNumberInput()' 	onBlur=""	align="left"></td> 
			 <td class="fields" width="1%"><input type='text' 	name="memeber_fees<%=index%>" id="memeber_fees<%=index%>" 		id="memeber_fees<%=index%>"			<%=disableMode%>	size="15" 	maxlength='12' 	value='<%= billingPrevilageCardPatientBean.getPrevilageCardMemberFees()			!=null ? billingPrevilageCardPatientBean.getPrevilageCardMemberFees() 		: "" %>'  	onKeyPress='ChkNumberInput()' 	onBlur=""	align="left">
				 <input type='button' class= 'button' name ='Print<%=index%>'  value='Print'  <%=disablePrint%> onclick="printPrevilageCardReport('<%=index%>')" >
				 </td>
			 					 <input type="hidden"  	name="hcardseqno<%=index%>" id="hcardseqno<%=index%>" 		id="hcardseqno<%=index%>"															value='<%= billingPrevilageCardPatientBean.getHcardSeqNo()						!=null ? billingPrevilageCardPatientBean.getHcardSeqNo()					: "" %>'												/>
			 					 <input type="hidden"  	name="card_type_code<%=index%>" id="card_type_code<%=index%>" 	id="card_type_code<%=index%>"														value='<%= billingPrevilageCardPatientBean.getPrevilageCardTypeCode()			!=null ? billingPrevilageCardPatientBean.getPrevilageCardTypeCode()			: "" %>'												/>
			 					 <input type='hidden' 	name='packageCode<%=index%>' id='packageCode<%=index%>' 		id='packageCode<%=index%>'															value="<%= billingPrevilageCardPatientBean.getPackageCode()						!=null ? billingPrevilageCardPatientBean.getPackageCode()					: "" %>"												/>
			 					 <input type='hidden' 	name='billingServiceCode<%=index%>' id='billingServiceCode<%=index%>' id='billingServiceCode<%=index%>'													value="<%= billingPrevilageCardPatientBean.getBillingServiceCode()				!=null ? billingPrevilageCardPatientBean.getBillingServiceCode()			: "" %>"												/>	
		</tr>
<%
if(index==0)
{
	%>
	<script>
	var hiddenPatientId ="<%=hiddenPatientId%>";
	ShowCardsubsciptionDetails(hiddenPatientId,"0");
	</script>
<%	}
}
}
else
{
%>	
<script>
	alert(getMessage("BL9132","BL"));
</script>
<%
}
%>		
    </table>	
    
</div>    
<br/>
    
  
  		<input type='hidden' name='locale' id='locale' 				 	id='locale'  				value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId'	 	     	id='facilityId'  			value="<%=facilityId%>" >
		<input type='hidden' name='mode' id='mode' 				 	id='mode' 					value="<%=mode%>" >
		<input type='hidden' name='authorized' id='authorized'			 	id='authorized'  			value="<%=authorized%>" /> 
		<input type='hidden' name='isUserCanAcess' id='isUserCanAcess'		 	id='isUserCanAcess' 		value="<%=isUserCanAcess%>" />
		<input type='hidden' name='hiddenCardTypeCode' id='hiddenCardTypeCode' 	 	id='hiddenCardTypeCode'		value="<%=hiddenCardTypeCode%>">
		<input type='hidden' name='hiddenPatientId' id='hiddenPatientId' 	 	id='hiddenPatientId'		value="<%=hiddenPatientId%>">
		<input type='hidden' name='hiddenPriceClassCode' id='hiddenPriceClassCode' 	id='hiddenPriceClasscode'	value="<%=hiddenPriceClasscode%>">
		<input type='hidden' name='hiddenPriceClassDesc' id='hiddenPriceClassDesc' 	id='hiddenPriceClassDesc'	value="<%=hiddenPriceClassDesc%>">
		<input type='hidden' name='rowCount' id='rowCount'			 	id='rowCount'				value="<%=rowCount%>">
		<input type='hidden' name='primaryPatientId' id='primaryPatientId' 	 	id='primaryPatientId'		value="<%=checkForNull(billingPrevilageCardPatientBean.getPrimaryPatientId())%>">
		
		
		
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

