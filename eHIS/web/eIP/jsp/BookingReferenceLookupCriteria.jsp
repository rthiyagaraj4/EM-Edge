<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String locale				= (String)session.getAttribute("LOCALE");
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
String param				= request.getParameter("param");
	if(param == null) param = "";
String function_id			= request.getParameter("function_id");
	if(function_id == null) function_id = "";
String wherecondn			= request.getParameter("wherecondn");
	if(wherecondn == null) wherecondn = "";

String admission_for		= request.getParameter("admission_for");
	if(admission_for == null) admission_for="";

String call_function		= request.getParameter("call_function");
	if((call_function == null) || (call_function.equals(""))) call_function = "";
String oper_stn_id			= request.getParameter("oper_stn_id");
	if (oper_stn_id == null) oper_stn_id = ""; 

String revise_booking_yn	= request.getParameter("revise_booking_yn");
	if(revise_booking_yn == null) revise_booking_yn="";

String cancel_booking_yn	= request.getParameter("cancel_booking_yn");
	if(cancel_booking_yn == null) cancel_booking_yn="";

String confirm_booking_yn	= request.getParameter("confirm_booking_yn");
	if(confirm_booking_yn == null) confirm_booking_yn="";

String create_booking_with_conf_yn = request.getParameter("create_booking_with_conf_yn");
	if(create_booking_with_conf_yn == null) create_booking_with_conf_yn="";

String create_booking_yn	= request.getParameter("create_booking_yn");
	if(create_booking_yn == null) create_booking_yn="";

String ismult_bkg_yn_flag	= checkForNull(request.getParameter("ismult_bkg_yn"));

String patient_id			= checkForNull(request.getParameter("patient_id"));
String bkg_grace_period		= checkForNull(request.getParameter("bkg_grace_period"));
String capture_fin_dtls_yn	= checkForNull(request.getParameter("capture_fin_dtls_yn"));
String bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"));
String noshow_bkng_period   ="";//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas

String facilityID			=(String)session.getAttribute("facility_id");
String loginUser			= (String)session.getAttribute("login_user");
String medservdesc			= "";
String medservcode			= "";

ArrayList bookingtype_list	= new ArrayList();
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
		<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
		<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src="../../eCommon/js/CommonLookup.js"></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	
		var x_Vals = new Array ();
		var e_Vals = new Array ();
		var l_Vals = new Array ();
		var i=0

		async function getRefPractitioner(getFacilitID)
		{
			var msg="";
			var facility_id				="`"+getFacilitID+"`";
			var target				= document.forms[0].pract_desc;
			var retVal				= new String();
			var dialogTop			= "40";
			var dialogHeight		= "10";
			var dialogWidth			= "40";
			var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments			= "";
			var sql					= "";
			var search_desc			= "";
			var tit					= "";
			sql="Select practitioner_id,practitioner_name from am_pract_for_facility_vw where operating_facility_id="+facility_id;

			search_code="practitioner_id";
			search_desc="practitioner_name";
			var tit=getLabel('Common.practitioner.label','common');
			retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);
			
			var arr=new Array();

			if (!(retVal == null))
			{
				if (!(unescape(retVal) == null))
				{
					arr=unescape(retVal).split("::");
					document.forms[0].ref_pract_desc.value=arr[0];
					document.forms[0].ref_practid.value=arr[1];
					document.forms[0].ref_pract_desc.focus();
				}
			}
			else
			{
					document.forms[0].ref_pract_desc.value="";
					document.forms[0].ref_practid.value="";
			}
		}


		function compareDates(obj)
		{
			
			if(validDateObj(obj,"DMY",localeName))
			{

				var from = document.forms[0].from_date;
				var to = document.forms[0].to_date;
			
				if(from.value !='' && to.value !='')// DateUtils.js
				{
					var fromDt	= convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
					var toDt	= convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");

					if(!isBefore(fromDt,toDt,'DMY',"en"))// DateUtils.js
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
						document.forms[0].to_date.value = "" ;
						document.forms[0].to_date.select();
					}
				}

			}
			else
			{
				obj.value='';
				return false;
			}

		}


			function populateRefVals(obj)
			{
				/*while(document.getElementById("ref_source").options.length>1) 
					document.getElementById("ref_source").options.remove(1);
				
				if(obj.value == 'E')
				{
					for(var i=0; i<e_Vals.length;i++)
					{
						 var opt=document.createElement("OPTION");
						 var temp = e_Vals[i].split('`') ;
						 opt.text=temp[1];
						 opt.value=temp[0];
						 document.getElementById("ref_source").add(opt);
					}
				}
				else if(obj.value == 'X')
				{
					for(var i=0; i<x_Vals.length;i++)
					{
						 var opt= document.createElement("OPTION");
						 var temp = x_Vals[i].split('`') ;
						 opt.text=temp[1];
						 opt.value=temp[0];
						 document.getElementById("ref_source").add(opt);
					}  
				}	
				else if(obj.value == 'L')
				{
					for(var i=0; i<l_Vals.length;i++)
					{
						 var opt= document.createElement("OPTION");
						 var temp = l_Vals[i].split('`');
						 opt.text=temp[1];
						 opt.value=temp[0];
						 document.getElementById("ref_source").add(opt);
					}
					document.getElementById("ref_source").selectedIndex = 1;
				}*/
				/*Friday, October 01, 2010 , referral source in Active Booking changed to lookup since AM_REFERRAL has huge data and screen taking time to load*/
					document.forms[0].referral_source.value="";
					document.forms[0].referral_source1.value="";
					if(obj.value != '')
					{
						document.forms[0].referral_source.disabled=false;
						document.forms[0].referral_source_lkp_but.disabled=false;
					}else
					{
						document.forms[0].referral_source.disabled=true;
						document.forms[0].referral_source_lkp_but.disabled=true;
					}

				 if(obj.value == 'L')
				{
					var ref_type=obj.value;
					var hcare_type='';

					HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/BookingValidation.jsp'><input type='hidden' name='field4' id='field4' value='Active_booking'><input name='ref_type' id='ref_type' type='hidden' value='"+ref_type + "'><input name='hcare_type' id='hcare_type' type='hidden' value='"+hcare_type + "'></form></BODY></HTML>";
					
					parent.messageFrame.document.write(HTMLVal);
					parent.messageFrame.document.form1.submit();
				}
			}

			function DateCompare(from,to) 
			{
				var fromarray; var toarray;
				var fromdate = from.value ;
				var todate = to.value ;
				if(fromdate.length > 0 && todate.length > 0 ) 
				{
					fromarray = fromdate.split("/");
					toarray = todate.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
					var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
					if(Date.parse(todt) < Date.parse(fromdt)) 
					{
						return false;
					}
					else if(Date.parse(todt) >= Date.parse(fromdt)) 
						return true;
				}
				return true;
			}

			function submitPage()
			{
				//alert("inside submit"+document.forms[0].Splcode.value)
				//Code changes starts by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011
				var chk_status = true;//document.getElementById("myCheckBox").status; 

                if(chk_status==true)	 
			    {
			    document.forms[0].loc_lang.value='th';
			    }

			   //Code changes ends by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011
			if(validateDate())   
				{
					var condition=""
					for(var i=0; i<document.forms[0].elements.length; i++)
					{
						condition+= document.forms[0].elements[i].name +"="+ document.forms[0].elements[i].value+"&"
						
					}

					document.forms[0].search.disabled=true;

					var patient_id = '<%=patient_id%>';
					
					if('<%=patient_id%>'=='' && document.getElementById("patient_id").value!='')
				
						patient_id = document.getElementById("patient_id").value;
						parent.result.location.href= "../jsp/BookingReferenceLookupResult.jsp?function_id=<%=function_id%>&oper_stn_id=<%=oper_stn_id%>&call_function=<%=call_function%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&ismult_bkg_yn_flag=<%=ismult_bkg_yn_flag%>&patient_id="+patient_id+"&"+condition
				
				}
			}

			function popDynamicValues(Obj){}

			function DisReset()
			{
				if('<%=ismult_bkg_yn_flag%>'=='Y')
				{
					
					for(var i=0; i<document.forms[0].elements.length; i++)
						document.forms[0].elements[i].disabled = true;
					submitPage();
				}
			} 

			function validateDate()
			{
				var from = document.forms[0].date_from;
				var to = document.forms[0].date_to;
				var msgframe = parent.parent.frames[1];
				var curdate = document.forms[0].currDate;
				var callFunction = "<%=call_function%>" ;
				if(callFunction == 'AT')   
				{
					if(document.forms[0].past_booking.checked == true)
					{
						var retval	= DateCompare(to,curdate)
						if(retval!=true)
						{
							alert(getMessage("TODT_LT_SYSDATE",'IP'));
							to.value = "" ;
							to.select();
							return false;
						}
						var retval	= DateCompare(from,to)
						if(retval!=true)
						{
							alert(getMessage("FRDT_LTEQ_TODT",'IP'));
							from.value = "";
							from.select();
							return false;
						}
					}
					else
					{
						var retval	= DateCompare(curdate,from)
						if(retval!=true)
						{
							alert(getMessage("FRM_DT_GREATER_CURRENT_DT",'IP'));
							from.value = "" ;
							from.select();
							return false;
						}
						var retval	= DateCompare(from,to)
						if(retval!=true)
						{
							alert(getMessage("FRDT_LTEQ_TODT",'IP'));
							to.value="";
							to.select();
							return false;
						}
					}
				}
				else if(callFunction == 'RCB')
				{
					var retval	=	DateCompare(from,to);
					if(retval!=true)
					{
						alert(getMessage("INVALID_DATE_RANGE","Common"));
						to.value="";
						to.select();
						return false;
					}
				}
				return true;
			}
			function dateVal(from,to,msgframe)
			{
				CheckDate(to);
				var retval	=	doDateCheck(from,to,msgframe);
				if(retval!=true)
				{
					alert(getMessage("INVALID_DATE_RANGE","Common"));
					to.value="";
					to.select();	
				}
			}
			
			function clearAll()
			{
				
				var param="<%=param%>";
				var callFunction = "<%=call_function%>" ;
				//AB - FOR ACTIVE BOOKING
				//RCB - FOR REVISE/CANCEL BOOKING
				if(callFunction == 'AB')   
				{
					parent.frames[2].document.location.href ='../../eCommon/html/blank.html'; 
				}
				else
				{
					parent.frames[1].document.location.href ='../../eCommon/html/blank.html'; 
				}
			
				document.forms[0].search.disabled=false;

				if(callFunction == 'AT')   
				{
					document.forms[0].reset();
					document.forms[0].booking_type.value = "<%=admission_for%>";
						if(document.forms[0].booking_type.value != "")
							document.forms[0].booking_type.disabled = true;
					document.forms[0].past_booking.value = 'N';
				}
			}			
			
			function setValue(Obj)
			{
				if(Obj.checked)
					Obj.value = "Y";
				else
					Obj.value = "N";
			}
			
	function validateBkgType()
	{
		if(document.forms[0].booking_type.value =='D')
		{
			document.forms[0].priority_ind.disabled=true;
			document.forms[0].past_booking.value='';
			if(document.forms[0].past_booking.checked == true)
				document.forms[0].past_booking.checked=false;
			document.forms[0].nursing_unit_desc.value='';
			document.forms[0].daycare_unit_desc.readOnly=false;
			document.forms[0].day_care_lookup.disabled=false;
		}
		else
		{
			document.forms[0].priority_ind.disabled=false;
			document.forms[0].past_booking.disabled=false;
			if(document.forms[0].past_booking.checked == true)
				document.forms[0].past_booking.checked=false;
			document.forms[0].daycare_unit_desc.value='';
			document.forms[0].nursing_unit_desc.value='';
			document.forms[0].daycare_unit_desc.readOnly=true;
			document.forms[0].day_care_lookup.disabled=true;
		}
	}
	
		</script>
		<%
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt=new java.util.Date();
			String currDate = dateFormat.format( dt ) ;
			currDate = DateUtils.convertDate(currDate,"DMY","en",locale);
		%>
	</head>

	<body onLoad= "DisReset();FocusFirstElement();" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name='BookingReferenceLookup_Form' id='BookingReferenceLookup_Form' action='../jsp/BookingReferenceLookupResult.jsp' target='result' >
		<input type='hidden' name='pract_desc_hid' id='pract_desc_hid' value=''>
		<input type='hidden' name='spec_desc_hid' id='spec_desc_hid' value=''>
		<input type='hidden' name='referral_source_hid' id='referral_source_hid' value=''>
		<input type='hidden' name='nurs_desc_hid' id='nurs_desc_hid' value=''>
		<input type='hidden' name='dcare_desc_hid' id='dcare_desc_hid' value=''>
	<%

	Connection con			=  null;
	//Statement stmt			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;

try
{

	con						=  ConnectionManager.getConnection(request);
	
	/*if(call_function.equals("AB"))
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT" );
		sql.append("  sm_get_desc.sm_facility_param(facility_id ,?,1) facility_name" );
		sql.append("  , facility_id " );
		sql.append("FROM" );
		sql.append("  sm_facility_param " );
		sql.append("WHERE STATUS = 'E' " );
		sql.append("  AND facility_id !=? " );
		sql.append("ORDER BY" );
		sql.append("  1 " );

		pstmt				= con.prepareStatement(sql.toString()) ; 
		pstmt.setString(1,locale);
		pstmt.setString(2,facilityID);
		ResultSet rset		= pstmt.executeQuery();


		while(rset.next())
		{
			%>
				<!--
				<script>
					e_Vals[i] = "<%--=rset.getString(2)--%>`<%--=rset.getString(1)--%>";
					i++;
				</script>-->
			<%
		/*}
		/*out.println("<script>i=0</script>") ;
		if(rset !=null) rset.close() ;
		if(pstmt != null)    pstmt.close();

		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("Select sm_get_desc.sm_facility_param(facility_id ,?,1) facility_name, facility_id from sm_facility_param Where STATUS = 'E' and facility_id =? " );
		pstmt		   = con.prepareStatement(sql.toString()) ; 
		pstmt.setString(1,locale);
		pstmt.setString(2,facilityID);
		rset = pstmt.executeQuery();
		while(rset.next())
		{*/
			%><!--
				<script>
					l_Vals[i] = "<%--=rset.getString(2)--%>`<%--=rset.getString(1)--%>";
					i++;
					</script>-->
			<%
		/*}
		/*out.println("<script>i=0</script>") ;
		if(rset !=null) rset.close() ;
		if(pstmt != null)    pstmt.close();
				
		if(sql.length() > 0) sql.delete(0,sql.length());
		//sql.append("Select short_Desc, referral_Code from am_referral_lang_vw where language_id='"+locale+"' and eff_status = 'E' order by 1" );
		sql.append("Select am_get_desc.am_referral(referral_Code,?,2)short_Desc, referral_Code from am_referral where eff_status = 'E' order by 1" );
		pstmt		   = con.prepareStatement(sql.toString()) ; 
		pstmt.setString(1,locale);
		rset = pstmt.executeQuery();
		String referral_Code   = "";
		String referral_desc   = "";

		while(rset.next())
		{
			*/%><!--
				<script>
				<%--
					referral_Code=rset.getString("referral_Code");
					referral_desc=rset.getString("short_Desc");
				--%>
					x_Vals[i] ="<%--=referral_Code--%>`<%--=referral_desc--%>"
					i++;
				</script>-->
			<%
		/*}
		
		if(rset != null)    rset.close();
		if(pstmt != null)    pstmt.close();
	}*/
	          
	            //Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	             StringBuffer sql = new StringBuffer();
                 sql.append("select noshow_bkng_period from ip_param where facility_id='"+facilityID+"'");
				 pstmt				= con.prepareStatement(sql.toString()) ; 
				 rs=pstmt.executeQuery();
				  
				 if(rs!= null){
				 if(rs.next()){
				 noshow_bkng_period = rs.getString("noshow_bkng_period");
				 
				               }                   
			                 }
				   if(rs!=null) rs.close();
				   if(pstmt	 != null)   pstmt.close();
                 //end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
 }
 catch(Exception e){//out.println(e);
 e.printStackTrace();}
 finally
 {
	if(con!=null) ConnectionManager.returnConnection(con,request);
 }
	try
		{

			con  =  ConnectionManager.getConnection(request);	
			StringBuffer sqlmedserv = new StringBuffer();
			if(sqlmedserv.length() > 0) sqlmedserv.delete(0,sqlmedserv.length());
			sqlmedserv.append(" select booking_type_code,ip_get_desc.ip_booking_type(booking_type_code,'"+locale+"','2')short_desc from ip_booking_type where eff_status = 'E' order by 2 ");
			pstmt	=   con.prepareStatement(sqlmedserv.toString());
			rs = pstmt.executeQuery();

			while( rs.next() )
			{
				bookingtype_list.add(checkForNull(rs.getString(1)));
				bookingtype_list.add(checkForNull(rs.getString(2)));
				
			}

			if(rs	 != null)   rs.close();
			if(pstmt	 != null)   pstmt.close();
		}
		 catch(Exception e){//out.println(e);
		 e.printStackTrace();}
		 finally
		 {
			if(con!=null) ConnectionManager.returnConnection(con,request);
		 }
		
%>
<table cellspacing=1 cellpadding=0 align='center' width='100%' border='0'>
<%
	if(call_function.equals("AT")){%>
	<tr>
		<input type='hidden' name='booking_type' id='booking_type' value='<%=admission_for%>'>
		<input type='hidden' name='param' id='param' value="<%=param%>">
		<%	if(admission_for.equals("I"))
		{	%>
		<td  class='label'  width='20%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='25%'><input type=text name=nursing_unit_desc size=15  onBlur='getNursingUnitBlur("<%=facilityID%>","<%=loginUser%>","<%=oper_stn_id%>","<%=call_function%>")' ><input type=hidden class=label name=nursing_unit size=15 readonly><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick='getNursingUnit("<%=facilityID%>","<%=loginUser%>","<%=oper_stn_id%>","<%=call_function%>")'> 
		</td>
	<%	}else {	%>
		<td  class='label'  width='20%'><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='25%'><input type=text name=daycare_unit_desc  size=15  readonly onBlur='getDaycareUnitBlur("<%=facilityID%>","<%=loginUser%>","<%=oper_stn_id%>","<%=call_function%>")' ><input type=hidden class='label' name=daycare_unit size=15 readonly><input type=button class=button  disabled name='day_care_lookup' id='day_care_lookup' value='?' onClick='getDaycareUnit("<%=facilityID%>","<%=loginUser%>","<%=oper_stn_id%>","<%=call_function%>")'> </td>
	<%	}	%>
		<td class='label'  width='25%' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/><%if(call_function.equals("RCB")){%>&nbsp;<%}%></td>
		<td   class='fields'  width='25%'><select name="priority_ind" id="priority_ind" ><option value=''><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option><option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option><option value="N"><fmt:message key="Common.nonurgent.label" bundle="${common_labels}"/></option></select></td>
	</tr>
	<%	}else{	%>
	<tr>
		<input type='hidden' name='param' id='param' value="<%=param%>">
		<input type='hidden' name='booking_type' id='booking_type' value=''>
		<input type='hidden' name='daycare_unit' id='daycare_unit' value=''>
		<td  class='label'  width='25%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='25%' ><input type=text name=nursing_unit_desc size=15 onBlur='getNursingUnitBlur("<%=facilityID%>","<%=loginUser%>","<%=oper_stn_id%>","<%=call_function%>")'><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup'value='?'onClick='getNursingUnit("<%=facilityID%>","<%=loginUser%>","<%=oper_stn_id%>","<%=call_function%>")'>
		<input type=hidden  name=nursing_unit size=15 readonly>
		</td>
<%	if(call_function.equals("RCB"))
	{	%>
		<td class='label'  width='25%' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/><%if(call_function.equals("RCB")){%>&nbsp;<%}%></td>
		<td  class='fields'  width='25%'><select name="priority_ind" id="priority_ind" ><option value=''><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option><option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option><option value="N"><fmt:message key="Common.nonurgent.label" bundle="${common_labels}"/></option></select></td>
<%	}
	else if(call_function.equals("AB"))
	{	%>
		<td class='label'  width='25%' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/><%if(call_function.equals("RCB")){%>&nbsp;<%}%></td>
		<td   class='fields'  width='25%'><select name="priority_ind" id="priority_ind" ><option value=''><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option><option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option><option value="N"><fmt:message key="Common.nonurgent.label" bundle="${common_labels}"/></option></select></td>
	<%	} 
	else 
	{	%>
		<td class='label'  width='50%' colspan='2'>&nbsp;</td>
	<%	}	%>
	</tr>
<%	}	%>
	<tr>
		<td  class='label'  width='20%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='25%'><input type=text name=specialty_desc size=15  onBlur='beforeGetSpecialty(specialty_desc,"<%=facilityID%>")'><input type=hidden class=label name=Splcode size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick='getSpecialty(specialty_desc,"<%=facilityID%>")'></td>
		<td  class='label'  width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='25%'><input type=text name=pract_desc size=20 onBlur='beforeGetPractitioner(document.forms[0].practitioner_lookup,pract_desc,"<%=facilityID%>")'><input type=hidden name=practid size=15 readonly><input type=button class=button name='practitioner_lookup' id='practitioner_lookup' value='?' onClick="if(document.forms[0].pract_desc.value  == '') getPractitionerLocal(this,pract_desc,'<%=facilityID%>');"></td>
	</tr>
<%	
if( call_function.equals("AB") || call_function.equals("AT") || call_function.equals("RCB") ||  call_function.equals("BookingReport"))
{	
		if(!admission_for.equals("D"))
		{
		%>
	<tr>
		<td  class='label'  nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
		<td class="fields"><jsp:include page="BedClassComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include></td>
		<td  class='label'  nowrap><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
		<td class="fields" ><jsp:include page="BedTypeComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include></td>
	</tr>
	<tr>
		<td  class='label'  nowrap  width='20%'><fmt:message key="eIP.MedicalServiceGroup.label" bundle="${ip_labels}"/></td>
		<td  class='fileds' width='25%'><SELECT name="med_service_grp" id="med_service_grp" >
		<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%  
		//This query is used for populating the medical service group
		try
		{

			con  =  ConnectionManager.getConnection(request);
			StringBuffer sqlmedserv = new StringBuffer();
			if(sqlmedserv.length() > 0) sqlmedserv.delete(0,sqlmedserv.length());
			//sqlmedserv.append(" select SHORT_DESC , MED_SER_GRP_CODE FROM IP_MEDICAL_SERVICE_GRP_LANG_VW where facility_id = '"+facilityID+"'  and language_id='"+locale+"'");
			/*Saturday, April 24, 2010 modified for PE*/
			sqlmedserv.append(" select ip_get_desc.ip_medical_service_group (?,med_ser_grp_code,?,2) short_desc , med_ser_grp_code from ip_medical_service_group where facility_id = ? and eff_status = 'E'");
			pstmt	=   con.prepareStatement(sqlmedserv.toString());
			pstmt.setString(1,facilityID);
			pstmt.setString(2,locale);
			pstmt.setString(3,facilityID);
			rs = pstmt.executeQuery();

			while( rs.next() )
			{
				medservdesc   = checkForNull(rs.getString(1));
				medservcode   = checkForNull(rs.getString(2));	
				%>
				<option value = "<%=medservcode%>"><%=medservdesc%></option>
		<%	}

			if(rs	 != null)   rs.close();
			if(pstmt	 != null)   pstmt.close();
		}
		 catch(Exception e){//out.println(e);
		 e.printStackTrace();}
		 finally
		 {
			if(con!=null) ConnectionManager.returnConnection(con,request);
		 }
		%>	     
		</SELECT>
		</td>
		<td  class='label'  nowrap width='25%'><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/></td>
		<td  class='fileds' width='25%'><SELECT name="ip_booking_type" id="ip_booking_type" >
		<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
			for(int i=0;i<bookingtype_list.size();i+=2){
		%>
			<option value=<%=bookingtype_list.get(i)%>><%=bookingtype_list.get(i+1)%></option>
		<%}%>	     
		</SELECT>
		</td>
	</tr>
	<%	
	}	
		}	%>

	<tr>
		<td class='label'  width='20%' nowrap><fmt:message key="Common.PreferredDateFrom.label" bundle="${common_labels}"/></td>
		<!-- Below code is commented by Akhilesh Because unnecessary function is calling.-->
		<!--<td  class='fields'  width='25%'><input type='text' id="date_from" maxlength='10' size='10' name='from_date' id='from_date'  value='' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');">&nbsp;-&nbsp;<input type='text' id="date_to" value='' maxlength='10' size='10' name='to_date' id='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"></td>-->
		<td  class='fields'  width='25%'><input type='text' id="date_from" maxlength='10' size='10' name='from_date' id='from_date'  value='' onBlur='compareDates(this);'><img  id='fromdate_img' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');"/>&nbsp;-&nbsp;<input type='text' id="date_to" value='' maxlength='10' size='10' name='to_date' id='to_date' onBlur='compareDates(this);'><img  id='todate_img' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"/></td>
<%	if(!call_function.equals("AT"))
	{	%>
		<td class='label' width='25%' ><fmt:message key="Common.BookingRefNo.label" bundle="${common_labels}"/></td>
		<td  class='fields'  width='25%'><input type="textbox" onKeyPress="return(CheckForSpecChars(event))" onBlur="ChangeUpperCase(this);" name="booking_ref_no" id="booking_ref_no" maxlength="12"></td>
<%	}else if(call_function.equals("AT") ) {	%>

		<td class='label'   width = '25%' ><fmt:message key="eIP.PastOpenBookings.label" bundle="${ip_labels}"/></td>
		<td  class='fields'  width='25%'><input type="checkbox" name="past_booking" id="past_booking" value = 'N' onClick="setValue(this);"></td>
<%	}else if(call_function.equals("AB")) {	%>
		<td  class='label'   width='23%' nowrap><fmt:message key="Common.ReferredPractitioner.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='27%' ><input type="text" name="ref_pract_name" id="ref_pract_name" value='' size="30" maxlength="30"></td>
<%	}	
	if(call_function.equals("AB"))
	{	%>
	</tr>
	<tr>
		<td class='label'   width='25%' nowrap><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>
		<td   class='fields'  width='25%' >
		<select name='ref_type' id='ref_type' onChange='populateRefVals(this);'>
		<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
		<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
		<option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
		</select><!--select name='ref_source'><option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option></select--><!--referral source in Active Booking changed to lookup since AM_REFERRAL has huge data and screen taking time to load-->
		<input type='text' name='referral_source' id='referral_source' size='20' onBlur ="beforereferralSourceLookup(referral_source,'<%=facilityID%>')" value="" disabled><input type='button' class='button' name='referral_source_lkp_but' id='referral_source_lkp_but' value='?' onClick="referralSourceLookup(referral_source,'<%=facilityID%>')" disabled>
		<input type='hidden' name='referral_source1' id='referral_source1'   value="">
		</td>
		<td  class='label'   width='25%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
		<td class='fields'  width='25%'><input type=text name=referral_id value='' size=15 maxlength=14></td>
	</tr>
<%	}	%>

	<tr>	
		<td   colspan='4' class='COLUMNHEADER'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name ="patient_id"   value= "" />
		<jsp:param name ="alert_reqd_yn"   value= ""  /> 
		</jsp:include>	
	</tr>
</table>
	
	<%
		String search = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels");
		String clear = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels");
	%>
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
	<tr>
		<jsp:include page="IPPatientDetailCriteria.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name ="function_id"   value= "BOOKING_LOOKUP"  />
		</jsp:include>
	</tr>
	</table>
	<table cellspacing=0 cellpadding='3' class='button' width='100%' border='0'align='center'>
	<tr>
		<td class='white' class='button' align='right'>
		<input type='button' name='search' id='search' value='<%=search%>' class='button' onclick='submitPage()'>
		<input type='button' name='clear' id='clear' value='<%=clear%>'   class='button' onclick='clearAll()'></td>
	</tr>	
	</table>
					
		<input type='hidden' name='currDate' id='currDate' value ="<%=currDate%>">
		<input type='hidden' name='call_function' id='call_function' value ="<%=call_function%>">
		<input type='hidden' name='locale' id='locale' value ="<%=locale%>">
		<input type='hidden' name='bkg_grace_period' id='bkg_grace_period' value ="<%=bkg_grace_period%>">
		<input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value ="<%=bl_interfaced_yn%>">
		<input type='hidden' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value ="<%=capture_fin_dtls_yn%>">
		<input type='hidden' name='noshow_bkng_period' id='noshow_bkng_period' value ="<%=noshow_bkng_period%>">
		</form>
	</body>
</html>
<%
	if ( bookingtype_list != null) bookingtype_list.clear();
%>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

