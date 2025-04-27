<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%		
		request.setCharacterEncoding("UTF-8");
		Connection con 	= null;
		Statement  stmt	= null;
		ResultSet  rs 	= null;
		Statement  stmt10	= null;
		ResultSet  rs10 	= null;
	
   try{
		   	con = ConnectionManager.getConnection(request);
			String window_styl=request.getParameter("window_styl");
	
			if( window_styl == null) window_styl="";
			String close_yn	=request.getParameter("close_yn");
			
			if( close_yn == null) close_yn="";
			String win_top =request.getParameter("win_top");
			
			if( win_top == null) win_top="";
			String win_height =request.getParameter("win_height");
			
			if(win_height ==null) win_height="";
			String win_width =request.getParameter("win_width");
			
			if( win_width == null) win_width="";
			String call_function=request.getParameter("call_function");
			
			if(call_function == null) call_function="";

			String mandat="";
			
			String modal=request.getParameter("modal");
			if(modal == null) modal="";			
			
			String dialogTop =request.getParameter("dialogTop");
			if(dialogTop ==null) dialogTop="";			

			String module=request.getParameter("module");
			if(module == null) module="";

			String model_window=request.getParameter("model_window");
			if( model_window == null) model_window="";
			
			String function_id=request.getParameter("function_id");
			if( function_id == null) function_id="";
			
			String prog_id=request.getParameter("prog_id");
			if( prog_id == null) prog_id="";

			String practitioner_id=request.getParameter("practitioner_id");
			if( practitioner_id == null) practitioner_id="";
			
			String wherecondn = request.getParameter("wherecondn");
				if(wherecondn == null) wherecondn ="";	
			
			String operstn	= request.getParameter("wherecondn");
				if(wherecondn == null) wherecondn ="";	
			
			String facilityID=(String)session.getValue("facility_id");
			
			String loginUser = (String)session.getValue("login_user");
			
			String p_module_id=request.getParameter("p_module_id");
			
			if(p_module_id == null) p_module_id="";
			
	try{
			String operSql = " select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b 	   "+
			 " where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   "+
			 " and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   "+
			 " and trunc(sysdate) between b.eff_date_from and 			   "+
			 " nvl(b.eff_date_to,trunc(sysdate)) ";
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(operSql);
			
			if(rs!=null)
			{
				while(rs.next())
				{
					operstn	 = rs.getString("oper_stn_id");
					if(operstn == null) operstn ="";
				}
			}		

	}catch(Exception e)
	{
		e.toString();
	}
	
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(rs10!=null) rs10.close();
	if(stmt10!=null) stmt10.close();
%>	
	<script>

	function compareDates(Obj)
	{
		if(!doDateCheckAlert(document.forms[0].from_date,document.forms[0].to_date))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
	
			document.forms[0].to_date.focus();
			
			document.forms[0].to_date.select();
		}
	}	
		
function DateCompare(from,to,messageFrame,getVal) 
		{
			
			var getValue = getVal;
			
			var fromarray; var toarray;
			
			var fromdate = from.value ;
			
			var todate = to.value ;
			
			if(fromdate.length > 0 && todate.length > 0 ) {
			
					fromarray = fromdate.split("/");
					
					toarray = todate.split("/");
					
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
					
					if(Date.parse(todt) < Date.parse(fromdt)) 
					{
						if(messageFrame.name =="f_query_add_mod1")
						alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
						else
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT","SM");
						to.focus();
						return false;
					}
					else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
			}
			return true;
		}
           
		function clearAll()
		{			
				parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
				if(parent.messageFrame)
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		}
		function validSplchars1(obj)
			{	
				var val = obj.value.toUpperCase();			
				
				obj.value = val;	
				
				var fields=new Array();
				
				var names=new Array();
				
				fields[0]=obj;
				
				names[0]="Encounter ID";
				
				if(SpecialCharCheck( fields, names,'',"A",''))
					return true;
				else
				{
					obj.select();
					obj.focus();
					return false;
				}
			}
	</script>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
		<script>
		async function getNursingUnit(getFacilitID)
		{
			var msg="";
			var facility_id				="`"+getFacilitID+"`";
			var loginUser				="`"+'<%=loginUser%>'+"`";
			var operstn					="`"+'<%=operstn%>'+"`";
			var target			= document.forms[0].nursing_unit_desc;
			var retVal			=    new String();
			var dialogTop			= "40";
			var dialogHeight		= "10" ;
			var dialogWidth			= "40" ;
			var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments			= "" ;
			var sql				= "";
			var search_desc			= "";
			var tit				= "";
			var wherecondn      = '<%=wherecondn%>';
		if (wherecondn.length>0)
			{
			sql = "select a.nursing_unit_code,a.short_desc from ip_nursing_unit a, am_os_user_locn_access_vw b where a.eff_status = 'E' and a.facility_id="+facility_id+" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.oper_stn_id="+operstn+" and b.appl_user_id="+loginUser+"  and b."+wherecondn+" =`Y` ";
		}
		else
		{
			sql="Select nursing_unit_code,short_desc  from ip_nursing_unit where facility_id="+facility_id+"  and eff_status=`E` ";
		}
		search_code="nursing_unit_code";
		search_desc="short_desc";
		tit=getLabel('Common.nursingUnit.label','common');;
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);
	
		var arr=new Array();

		if (!(retVal == null))
		{

  			var retVal=unescape(retVal);
		    arr=retVal.split("::");
		    document.forms[0].nursing_unit_desc.value=arr[0];
			document.forms[0].nursing_unit.value=arr[1];
		    document.forms[0].nursing_unit_desc.focus();
		}
		else
		{
			target.focus();
		}
	}

		async function getSpecialty(getFacilitID)
		{
			var msg="";
			var facility_id				="`"+getFacilitID+"`";
			var target			= document.forms[0].specialty_desc;
			var retVal			=    new String();
			var dialogTop			= "40";
			var dialogHeight		= "10" ;
			var dialogWidth			= "40" ;
			var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments			= "" ;
			var sql				= "";
			var search_desc			= "";
			var tit				= "";
			sql="Select speciality_code,short_desc from am_speciality where eff_status=`E` ";

			search_code="speciality_code";
			search_desc="short_desc";
			var tit=getLabel('Common.speciality.label','common');
			retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);
			
			var arr=new Array();

			if (!(retVal == null))
			{
				var retVal=unescape(retVal);
				arr=retVal.split("::");
				document.forms[0].specialty_desc.value=arr[0];
				document.forms[0].Splcode.value=arr[1];
				document.forms[0].specialty_desc.focus();
			}
			else
			{
				target.focus();
			}
		}

		function submitPage()
		{
				var flag="<%=mandat%>";
				if(flag=="true")
				{	
					if(document.forms[0].patient_id.value=="")
					{
						var msg = getMessage("CAN_NOT_BE_BLANK","common");
						msg = msg.replace('$',getLabel("Common.patientId.label","Common"))
						alert(msg);
						document.forms[0].patient_id.focus();
						return false;
					}
				}

				var condition=""
				for(var i=0; i<document.forms[0].elements.length; i++)
						condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
					
				oper_stn = document.forms[0].operstn.value;
				var callfunc = "<%=call_function%>";
				if(callfunc == "ReferralPatientDetails")
				   document.forms[0].nursing_unit.disabled = true
				else
					document.forms[0].nursing_unit_lookup.disabled = true;

				document.forms[0].specialty_lookup.disabled = true;
				document.forms[0].pract_id_search.disabled = true;
				document.forms[0].from_date.readOnly = true;
				document.forms[0].to_date.readOnly = true;
				document.forms[0].encounter_id.readOnly = true;
				document.forms[0].patient_id.readOnly = true;
				document.forms[0].patient_search.disabled = true;
				document.forms[0].gender.disabled = true;
				document.forms[0].soundex.disabled = true;
				document.forms[0].search.disabled = true;
				document.forms[0].clear.disabled = true;

				if(document.forms[0].modal.value == 'yes')
				{					
				parent.frames[1].location.href= '../../eIP/jsp/CancelTransferResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y';
				}
				else
				{
				parent.frames[2].location.href= '../../eIP/jsp/CancelTransferResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y';
				}
			}			
		</script>		
	</head>	

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad= 'FocusFirstElement()' onSelect="codeArrestThruSelect()" >
		<form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
				<tr>			
					<td  class='label' align='right' width=12%><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> &nbsp;</td>
					<td><input type=text name=nursing_unit_desc id=nursing_unit_desc size=15 readonly><input type=hidden class=label name=nursing_unit id=nursing_unit size=15 readonly><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick='getNursingUnit("<%=facilityID%>")'>
				    </td>
					<td  class='label' align='right' width=9%><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
					<td><input type=text name=specialty_desc id=specialty_desc size=15 readonly><input type=hidden class=label name=Splcode id=Splcode size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick='getSpecialty("<%=facilityID%>")'>
					<td  class='label' align='right'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class='label' align='left'>
							<jsp:include page="PractitionerComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include>
					</td>
			</tr>
			<tr>
					<% 
						if(modal.equals("yes")) { 
					%>
					<td class='label' align=right nowrap><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.from.label" bundle="${common_labels}"/></td><td colspan='2' nowrap><input type='text' maxlength='10' size='10' name='from_date' id='from_date'  value="" onBlur='CheckDate(this);compareDates(this);'> - <input type='text' value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='CheckDate(this);compareDates(this);'></td>						
					<% 		
						}
					else 
						{
						%>
					<td class='label' align=right nowrap><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.from.label" bundle="${common_labels}"/></td><td colspan='2' nowrap><input type='text' maxlength='10' size='10' name='from_date' id='from_date'  value="" onBlur='CheckDate(this);DateCompare(to_date,this,parent.frames[3],"Admission Date");'> - <input type='text' value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='CheckDate(this);DateCompare(from_date,this,parent.frames[3],"Admission Date");'></td>
					<%		
					}  					
					%>
					<td>&nbsp;</td>
					<td class='label' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class='2' align='left'><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this)"></td>
			</tr>
			<tr>
					<td colspan=6>
						<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name="mandat" value="<%=mandat%>"/>
						</jsp:include>
					</td>
				
			</tr>	
	</table>
	<table align='right'>
				<tr>
					<td align='right' class='white'>
						<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'>
						<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'>
					</td>
				</tr>
	</table>
	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='param' id='param' value="<%=call_function%>" >	
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
	<input type='hidden' name='module' id='module' value="<%=module%>" >
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>" >
	<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
	<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
	<input type='hidden' name='p_module_id' id='p_module_id' value="<%=p_module_id%>" >

		</form>
	</body>
<% }catch(Exception e)	{out.println(e);}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</html>
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

