<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,eBL.Common.BLHelper,webbeans.eCommon.*,webbeans.op.CurrencyFormat,eBL.PkgAssociationExistingPackagesBean " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<%
/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V220309             29311 	       	MMS-MD-SCF-0194		           Mohana Priya K
2			 V220614			 32364			MMS-ME-SCF-0102				   Manivel Natarajan
-----------------------------------------------------------------------------------------------
*/
%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script>
$(document).ready(function () {
	
	
	 var function_id=parent.frames[1].document.getElementById('function_id').value;
	 
	 $('[id^=from_date]').prop('disabled',true);
	 $('[id^=fromDateimg_]').prop('disabled',true);
	 
	 $('#functionId').val(function_id);

    $('.PkgChecked').click(function () {
    	 
    	 var addOrRemove='';
    	 if( $(this).is(":checked") == true ){
    		 addOrRemove='add';
    	 }else{
    		 addOrRemove='remove';
    	 }
    	 
		  $.ajax({
	              url:"../../eBL/jsp/PkgAssociationExistingPackagesPersistance.jsp",
	              type:'post',
	              data:{
	            	  existingPkgCode: $('#existingPkgCode'+$(this).val()).val(),
	            	  existingPkgSeqNo:$('#existingPkgSeqNo'+$(this).val()).val(),
	            	  existingPkgEpiType:$('#existingPkgEpiType'+$(this).val()).val(),
	            	  existingPkgFrmDte:$('#from_date'+$(this).val()).val(),
			  existingPkgBlngClassCode:$('#existingPkgBlngClassCode'+$(this).val()).val(),
	            	  operation: addOrRemove
	              },
	              async:false,
	              success: function(data) {
	              }
	          });
    });     
     
});



function checkDate(index)
{
/* alert('fn call');
alert($('#fromdatehdn'+index).val());
 */

var starr=$('#from_date'+index).val();
var enarr= $('#to_date'+index).text();
var locale=$('#locale').val();

 
if(starr!='' && enarr!='')
{
	if(validDate(starr,'DMYHMS',locale))
	{
	
	 	callvalidate(index,'null','PkgAssocnExisting');
	 	$.ajax({
            url:"../../eBL/jsp/PkgAssociationExistingPackagesPersistance.jsp",
            type:'post',
            data:{
          	  existingPkgCode: $('#existingPkgCode'+index).val(),
          	  existingPkgSeqNo:$('#existingPkgSeqNo'+index).val(),
          	  existingPkgEpiType:$('#existingPkgEpiType'+index).val(),
          	  existingPkgFrmDte:$('#from_date'+index).val(),
          	  operation: 'modify'
            },
            async:false,
            success: function(data) {
            }
        });

	}else
	{
	alert(getMessage("INVALID_DATE_FMT", "SM"));
	 $('#from_date'+index).val($('#fromdatehdn'+index).val());
	return false;	
	}
}
else
	{
	alert(getMessage('BL00683','BL'));
	$('#from_date'+index).val($('#fromdatehdn'+index).val());
	return false;
	}
	$('#fromdatehdn'+index).val(starr);
}
function getPatClass(count){
	//alert($('#existingPkgChecked'+count).is(":checked"));
	var selectedRows = $("tr:has(:checked)");
	//alert("selectedRows "+selectedRows.length);
	if($('#existingPkgChecked'+count).is(":checked")==true){
	var blngClassCode= $('#blngClassCode'+count).val();
	$('#from_date'+count).prop('disabled',false);
	$('#fromDateimg_'+count).prop('disabled',false);
	 $.ajax({
         url:"../../eBL/jsp/PkgSubscriptionPatClassFinderAjax.jsp?blngClassCode="+blngClassCode,
         type:'post',
         async:false,
         success: function(data) {
         	 var patClass = $.trim(data);
        	 var prevVal=$('#prevVal').val();
            // alert( "patClass/prevVal :: "+patClass+" / "+prevVal);
        	 if(prevVal!=""){
        		 if(selectedRows.length==1){
        			 $('#prevVal').val(patClass);
        		 }
        		 else if(prevVal!=patClass){
        			 alert(getMessage("BL00987","BL")); 
         			 $('#existingPkgChecked'+count).attr('checked',false);
         			 $('#from_date'+count).prop('disabled',true);
         			 $('#fromDateimg_'+count).prop('disabled',true);
         		 }
        	 }
        	 else{
        	 $('#prevVal').val(patClass);
        	 }
          }
     });
	 
	}
else
{
	$('#from_date'+count).prop('disabled',true);
	$('#fromDateimg_'+count).prop('disabled',true);
	$(parent.PkgSubscriptionHeader.document).find('#strMessageId').val('');
	$(parent.PkgSubscriptionHeader.document).find('#strErrorText').val('');	
	/* alert(parent.frames[0].document.getElementById('strMessageId').value);
	alert(parent.frames[0].document.getElementById('strErrorText').value);
	 */
	//alert(parent.frames[1].id;);
	
	
}
	
	
}







</script>

<% 
String facility_id 		= (String) session.getValue( "facility_id" ) ; //V220309
Connection con = null;	
PreparedStatement pstmt = null;
ResultSet rs = null;
CurrencyFormat cf1 = new CurrencyFormat(); //Added V171212-Gayathri/MMS-DM-CRF-0118
String query="select PACKAGE_CODE,BLNG_CLASS_CODE,CUST_GROUP_CODE,CUST_CODE,to_char(EFF_FROM_DATE,'dd/mm/yyyy hh24:mi:ss') EFF_FROM_DATE,to_char(EFF_TO_DATE,'dd/mm/yyyy hh24:mi:ss') EFF_TO_DATE,PACKAGE_AMT,PHYSICIAN_ID,PACKAGE_SEQ_NO,ACROSS_ENCOUNTER_YN,ADDL_CHG_VALUE from BL_PACKAGE_SUB_HDR where patient_id=? and status='O' and operating_facility_id=? ORDER BY ADDED_DATE DESC"; //Added facility condn V220309, V220614 - added order by condition
String patientId=request.getParameter("patientId");
String locale= (String)session.getAttribute("LOCALE");
Boolean siteSpec=false;
int noofdecimal=2; //Added V171212-Gayathri/MMS-DM-CRF-0118

try
{
	con = ConnectionManager.getConnection();	
	siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","GRP_SIMILAR_CLASS_PKG_ENC");
	System.out.println("SiteSpec"+siteSpec);
}catch(Exception e)
{
	e.printStackTrace();
	System.out.println("Exception in site specific "+e);
}
//Added V171212-Gayathri/MMS-DM-CRF-0118/Starts
Boolean SiteSpec_VAT=false;
String SiteSpecific_VAT ="";
try
{
	
	SiteSpec_VAT = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","VAT_CHANGES_APPLICABLE_YN");	
}catch(Exception e)
{
	e.printStackTrace();
}
if(SiteSpec_VAT){
	SiteSpecific_VAT="Y";
}
else{
	SiteSpecific_VAT="N";
}

try
{		
	pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
	ResultSet rscurr = pstmt.executeQuery();	
	while(rscurr.next())
	{
		noofdecimal  =  rscurr.getInt(1);		
	}		
	rscurr.close();
	pstmt.close();
}
catch(Exception e)
{
	System.err.println("3="+e.toString());
}
//Added V171212-Gayathri/MMS-DM-CRF-0118/Ends
%>
<html>
<form id="pkgSubsExistingPkgFrm" name="pkgSubsExistingPkgFrm" id="pkgSubsExistingPkgFrm">
<table  id="pkgSubsExistingPkgTbl" name="pkgSubsExistingPkgTbl" width='100%' >
<tr style="position: sticky;z-index: 1;top: 0;">
<td  class='COLUMNHEADER' width ='5%' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>	
<td  class='COLUMNHEADER' width ='13%' ><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>	
<td  class='COLUMNHEADER' width ='10%'><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
<td  class='COLUMNHEADER' width ='10%'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
<td  class='COLUMNHEADER' width ='10%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>		
<td  class='COLUMNHEADER' width ='10%'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>	
<td  class='COLUMNHEADER' width ='10%'><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>	
<td  class='COLUMNHEADER' width ='10%'><fmt:message key="eBL.PKG_AMT.label" bundle="${bl_labels}"/></td>
<!--//Added V171212-Gayathri/MMS-DM-CRF-0118-->
<%if("Y".equals(SiteSpecific_VAT)){ %>

<td  class='COLUMNHEADER' width ='10%'><fmt:message key="eBL.ADDL_CHARGE.label" bundle="${bl_labels}"/></td>
<%} %>
<td  class='COLUMNHEADER' width ='10%'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
<td  class='COLUMNHEADER' width ='*'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
</tr>

<%
try{	
	
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, patientId);
	pstmt.setString(2, facility_id); //V220309
	rs = pstmt.executeQuery();
	int count=0;
	PkgAssociationExistingPackagesBean beanObj=new PkgAssociationExistingPackagesBean();
	//String episode_type,String pkg_code,String pkg_seq_no,tring login_user,String client_ip_address

	while(rs.next()){
					String pkgCodeHdn=rs.getString(1);
					System.out.println("pkgCodeHdn "+pkgCodeHdn);
					String addlCharge="";
					String blngClassCode=rs.getString(2);
					String pkgSeqNo=rs.getString(9);
					String acrossEncounterYn=rs.getString(10);
					if("Y".equals(SiteSpecific_VAT)){
					 addlCharge=rs.getString(11);
					//Added V171212-Gayathri/MMS-DM-CRF-0118
					try{
					if(addlCharge==null||"E".equals(addlCharge)) addlCharge="0";
	
					}
					catch(Exception e)
					{
						System.out.println("Exception from Package defintion header :"+e);
						addlCharge="0";
						e.printStackTrace();
					}
					finally{
					
						addlCharge=cf1.formatCurrency(addlCharge, noofdecimal);
						
					}
					
					}
					String countStr=BLHelper.getDescriptionViaSQL(con,"select count(*) from bl_package_encounter_dtls where PATIENT_ID=? and PACKAGE_SEQ_NO=?",patientId,pkgSeqNo);
					String billingClass=BLHelper.getDescriptionViaSQL(con,"select short_desc from bl_blng_class_lang_vw where blng_class_code=? and language_id=?",rs.getString(2),locale);
					//Below codes are added by Subha -- Starts
					String pkg_amt = rs.getString(7);
					if(pkg_amt == null) pkg_amt = "0";
					pkg_amt = cf1.formatCurrency(pkg_amt, noofdecimal);
					//End
					int countInt=Integer.parseInt(countStr);
					%>
					<tr>
					<td>
					<% if(siteSpec)
	{
					if((acrossEncounterYn.equals("N") &&  countInt==0 ) || acrossEncounterYn.equals("Y")){%>
					<input type='checkbox' class="PkgChecked" id="existingPkgChecked"  name="existingPkgChecked" onClick='getPatClass("<%=count%>");' value="<%=count%>" >
					<%}
	}
   else{
					if((acrossEncounterYn.equals("N") &&  countInt==0 ) || acrossEncounterYn.equals("Y")){%>
					<input type='checkbox' class="PkgChecked" id="existingPkgChecked"  name="existingPkgChecked" value="<%=count%>" >
				  <%}		

   }%>
					</td>
					<td class='fields' id='pkg_desc<%=count%>' name='pkg_desc<%=count%>'><%=BLHelper.getDescriptionViaSQL(con,"select short_desc from bl_package_lang_vw where package_code=? and language_id=?",rs.getString(1),locale) %></td>
					
					<td class='fields' id='blng_class<%=count%>' name='blng_class<%=count%>'><%=BLHelper.getDescriptionViaSQL(con,"select short_desc from bl_blng_class_lang_vw where blng_class_code=? and language_id=?",rs.getString(2),locale) %></td>
				 
				 	
					<td class='fields' id='payer_group_desc<%=count%>' name='payer_group_desc<%=count%>'><%=BLHelper.getDescriptionViaSQL(con,"select short_desc from ar_cust_group_lang_vw where  cust_group_code=? and language_id=?",rs.getString(3),locale) %></td>
				 
				 	<input type='hidden' id='payer_group_code<%=count%>' name='payer_group_code<%=count%>' value='<%=rs.getString(3)%>'/>
				 	
				 	<input type='hidden' id='payer_code<%=count%>' name='payer_code<%=count%>' value='<%=rs.getString(4)%>'/>
					<td class='fields' id='payer_desc<%=count%>' name='payer_desc<%=count%>'><%=BLHelper.getDescriptionViaSQL(con,"select short_name from ar_customer_lang_vw where  cust_code=? and language_id=?",rs.getString(4),locale) %></td>
	 					
	 				
	 				<%
	 				if(siteSpec){
	 				%>
	 				
	 				<td class='fields' ><input type='text' name='from_date<%=count%>' id='from_date<%=count%>'  onBlur=" checkDate('<%=count%>'); "  value='<%=rs.getString(5) %>' style="width:76%;">
					<img id = 'fromDateimg_<%=count%>' name="fromDateimg_<%=count%>"	 src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date<%=count%>','dd/mm/yyyy hh:mm:ss');" STYLE="display:inline;"></td>
					<input type='hidden' name='fromdatehdn<%=count %>' id='fromdatehdn<%=count %>' value='<%=rs.getString(5) %>'>
					<%}
					else{						
					%>
					<td class='fields' ><span class="text" name="from_date<%=count %>" id='from_date<%=count %>'> <%=rs.getString(5) %></span>
						<%
					}
						%>
				
					<td class='fields' ><span class="text" id='to_date<%=count%>' name='to_date<%=count%>' > <%=rs.getString(6) %></span></td>
		
					<td class='fields' id='pkg_amt<%=count%>' name='pkg_amt<%=count%>' ><%=pkg_amt %></td> <!-- pkg_amt added by Subha -->
					<!--//Added V171212-Gayathri/MMS-DM-CRF-0118-->
					
					<%if("Y".equals(SiteSpecific_VAT)){ %>
					
						<td class='fields' id='addl_charge<%=count%>' name='addl_charge<%=count%>' ><%=addlCharge %></td>
						
						<%} %>
		
					<td class='fields'id='episode_type<%=count%>' name='episode_type<%=count%>' ><%=beanObj.getEpisodeTypeForPackage(con,rs.getString(1)) %></td>
		
					<td class='fields' id='practioner_name<%=count%>' name='practioner_name<%=count%>'><%=BLHelper.getDescriptionViaSQL(con,"select short_name from am_practitioner_lang_vw where PRACTITIONER_ID=? and language_id=?",rs.getString(8),locale) %></td>
					
					<input type='hidden' name='practioner_id<%=count%>'  id='practioner_id<%=count%>' value=''>
					<input type='hidden' id='blngClassCodeHdn<%=count%>' name='blngClassCodeHdn<%=count%>' value=''>
					<input type='hidden' name='pkg_code_hdn<%=count%>' id='pkg_code_hdn<%=count%>'  value='<%=pkgCodeHdn %>'> 
					<input type='hidden' name='payer_code<%=count%>' id='payer_code<%=count%>'  value=''>
					
										<input type='hidden'  id="prevVal"  name="prevVal"  value=""></input> 
					
					<input type='hidden'  id="blngClassCode<%=count%>"  name="blngClassCode<%=count%>" value="<%=blngClassCode%>"></input> 
					
					<input type='hidden'  id="existingPkgCode<%=count%>"  name="existingPkgCode<%=count%>" value="<%=rs.getString(1)%>"></input> 
					<input type='hidden'  id="existingPkgSeqNo<%=count%>"  name="existingPkgSeqNo<%=count%>" value="<%=rs.getString(9)%>"></input> 
					<input type='hidden'  id="existingPkgEpiType<%=count%>"  name="existingPkgEpiType<%=count%>" value="<%=beanObj.getEpisodeTypeForPackage(con,rs.getString(1))%>">
					<input type='hidden' id='functionId' name='functionId'  value=''>
					<input type='hidden' name='site_spec'  id='site_spec' value='<%=siteSpec %>'> 
					<input type='hidden'  id="existingPkgBlngClassCode<%=count%>"  name="existingPkgBlngClassCode<%=count%>" value="<%=rs.getString(2)%>"></input>
					</tr>
					<%
					count++;
	}
}
catch(Exception e)
{
	System.out.println("Exception from Package defintion header :"+e);
	e.printStackTrace();
}
finally
		{
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) ConnectionManager.returnConnection(con, request);
		}
%>
</table>
</form>

