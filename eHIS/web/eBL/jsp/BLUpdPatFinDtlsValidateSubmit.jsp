<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

  <%
	Connection con				= null;

	try
	{	
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);

		String invalid_blng_grp="N",invalid_non_ins_blng_grp="N",invalid_cust_code="N";
		String prio_1_pyr_invalid_YN="N",str_inv_prio_values="",invalid_ins_blng_grp="";

		String str_err_level="",str_sys_message_id="",str_err_txt="";

//		System.out.println("Query String:"+request.getQueryString());

		String str_patient_id=request.getParameter("patient_id");
		if(str_patient_id == null) str_patient_id="";

		String str_facility_id=request.getParameter("facility_id");
		if(str_facility_id == null) str_facility_id="";

		String str_blng_grp=request.getParameter("blng_grp");
		if(str_blng_grp == null) str_blng_grp="";

		String str_slmt_ind=request.getParameter("slmt_ind");
		if(str_slmt_ind == null) str_slmt_ind="";

		String str_slmt_type_code=request.getParameter("slmt_type_code");
		if(str_slmt_type_code == null) str_slmt_type_code="";

		String str_cust_code=request.getParameter("cust_code");
		if(str_cust_code == null) str_cust_code="";

		String str_ins_policy_type_code=request.getParameter("rtn_ins_policy_type_code");
		if(str_ins_policy_type_code == null) str_ins_policy_type_code="";

		String str_ins_priority=request.getParameter("ins_priority");
		if(str_ins_priority == null) str_ins_priority="";

		String str_non_ins_blng_grp=request.getParameter("non_ins_blng_grp");
		if(str_non_ins_blng_grp == null) str_non_ins_blng_grp="";

		String str_non_ins_cust_code=request.getParameter("non_ins_cust_code");
		if(str_non_ins_cust_code == null) str_non_ins_cust_code="";

		try
		{
			CallableStatement call = con.prepareCall("{ call BLCOMMON.BL_VALIDATE_UPD_FIN_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");						
			call.setString(1,str_facility_id);
			call.setString(2,str_patient_id);
			call.setString(3,str_blng_grp);
			call.setString(4,str_slmt_ind);
			call.setString(5,str_slmt_type_code);
			call.setString(6,str_cust_code);
			call.setString(7,str_ins_policy_type_code);
			call.setString(8,str_ins_priority);
			call.setString(9,str_non_ins_blng_grp);
			call.setString(10,str_non_ins_cust_code);

			call.registerOutParameter(11,java.sql.Types.VARCHAR); 
			call.registerOutParameter(12,java.sql.Types.VARCHAR); 
			call.registerOutParameter(13,java.sql.Types.VARCHAR); 
			call.registerOutParameter(14,java.sql.Types.VARCHAR); 
			call.registerOutParameter(15,java.sql.Types.VARCHAR); 
			call.registerOutParameter(16,java.sql.Types.VARCHAR);  
			call.registerOutParameter(17,java.sql.Types.VARCHAR);	
			call.registerOutParameter(18,java.sql.Types.VARCHAR);
			call.registerOutParameter(19,java.sql.Types.VARCHAR);

			call.execute();
			
			invalid_blng_grp = call.getString(11);
			if(invalid_blng_grp == null) invalid_blng_grp="N";

			invalid_non_ins_blng_grp = call.getString(12);
			if(invalid_non_ins_blng_grp == null) invalid_non_ins_blng_grp="N";

			invalid_cust_code = call.getString(13);
			if(invalid_cust_code == null) invalid_cust_code="N";

			prio_1_pyr_invalid_YN = call.getString(14);
			if(prio_1_pyr_invalid_YN == null) prio_1_pyr_invalid_YN="N";

			invalid_ins_blng_grp = call.getString(15);
			if(invalid_ins_blng_grp == null) invalid_ins_blng_grp="";

			str_inv_prio_values = call.getString(16);
			if(str_inv_prio_values == null) str_inv_prio_values="";

			str_err_level=call.getString(17);
			if(str_err_level == null) str_err_level="";

			str_sys_message_id = call.getString(18);
			if(str_sys_message_id == null) str_sys_message_id="";

			str_err_txt = call.getString(19);
			if(str_err_txt == null) str_err_txt="";

			call.close();

//			System.out.println("invalid_blng_grp:"+invalid_blng_grp);
//			System.out.println("invalid_non_ins_blng_grp:"+invalid_non_ins_blng_grp);
//			System.out.println("invalid_cust_code:"+invalid_cust_code);
//			System.out.println("prio_1_pyr_invalid_YN:"+prio_1_pyr_invalid_YN);
//			System.out.println("invalid_ins_blng_grp:"+invalid_ins_blng_grp);
//			System.out.println("str_inv_prio_values:"+str_inv_prio_values);
		}
		catch(Exception e)
		{
			System.out.println("Error while calling BLCOMMON.BL_VALIDATE_UPD_FIN_DTLS :"+e);
		}
%>

<html>
<head>
<script language='javascript'>

	function continuemodifybut(Obj)
	{
		var retArr=new Array();
		if (Obj == "C")
		{
			retArr[0]="1";
			window.returnValue=retArr;
			//window.close();	
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();
		}
		else
		{	
			retArr[0]="2";
			if(document.forms[0].prio_1_pyr_invalid_YN.value == "Y")
			{
				document.forms[0].str_inv_prio_values.value="1|"+document.forms[0].str_inv_prio_values.value;
			}
			retArr[1]=document.forms[0].str_inv_prio_values.value;
			retArr[2]=document.forms[0].invalid_ins_blng_grp.value;
			window.returnValue=retArr;
			//window.close();	
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();
		}
	}

	function validate_fun()
	{
		var show_msg_blng_grp="";
		var show_msg_cust="";
		var show_msg_non_ins="";
		var show_msg_non_ins_cust="";
		var show_msg_prio1="";
		var sho_msg_prio_val="";
		var show_msg_foot="";

		if(document.getElementById("invalid_mess") != null)
		{
			document.getElementById("invalid_mess").innerText=(getMessage("BL9841","BL")).substring(11,(getMessage("BL9841","BL")).length);
		}

		if(document.getElementById("inv_blng_grp_cust_mess") != null)
		{
			document.getElementById("inv_blng_grp_cust_mess").innerText="* "+(getMessage("BL9836","BL")).substring(11,(getMessage("BL9836","BL")).length);
		}

		if(document.getElementById("inv_pmry_blng_grp_mess") != null)
		{
			document.getElementById("inv_pmry_blng_grp_mess").innerText="* "+(getMessage("BL9837","BL")).substring(11,(getMessage("BL9837","BL")).length);
		}

		if(document.getElementById("inv_prio1_pyr_mess") != null)
		{
			document.getElementById("inv_prio1_pyr_mess").innerText="* "+(getMessage("BL9838","BL")).substring(11,(getMessage("BL9838","BL")).length);
		}

		if(document.getElementById("inv_non_ins_blng_grp_cust_mess") != null)
		{
			document.getElementById("inv_non_ins_blng_grp_cust_mess").innerText="* "+(getMessage("BL9839","BL")).substring(11,(getMessage("BL9839","BL")).length);
		}

		if(document.getElementById("inv_ins_pyrs_mess") != null)
		{
			document.getElementById("inv_ins_pyrs_mess").innerText="* "+(getMessage("BL9840","BL")).substring(11,(getMessage("BL9840","BL")).length);
		}

		if(document.forms[0].invalid_blng_grp.value == "N" && document.forms[0].invalid_non_ins_blng_grp.value == "N" && document.forms[0].invalid_cust_code.value == "N" && document.forms[0].prio_1_pyr_invalid_YN.value == "N" && document.forms[0].str_inv_prio_values.value =="" && document.forms[0].invalid_ins_blng_grp.value == "")
		{
			var retArr=new Array();
			retArr[0]="1";
			
			if(parent.document.getElementById("dialog_tag"))
			{
				parent.document.getElementById('dialog-body').contentWindow.returnValue = retArr; 
				parent.document.getElementById('dialog_tag').close();
				
			}
			else
			{
				parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = retArr; 
				parent.parent.document.getElementById('dialog_tag').close();
				
			}
		}

	}

</script>

	<title><%=request.getParameter("title")%></title>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" onLoad='validate_fun()'>
<form name='updPatFinDtls' id='updPatFinDtls' method='post' action=''>		
<table cellpadding='3' cellspacing='0' border='0' align='center' width='100%' height='100%' >	
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<tr>
		<td colspan='4'>
<%
				if(!(str_slmt_ind.equals("X") && !str_non_ins_blng_grp.equals("")))
				{
%>
			<table cellpadding='3' cellspacing='0' border='2' BORDERCOLOR='WHITE' align='center' width='50%' height='25%'>	
<%				
				}
				else
				{		
%>
			<table cellpadding='3' cellspacing='0' border='2' BORDERCOLOR='WHITE' align='center' width='98%' height='25%'>	
<%
				}
%>
				<tr>
					<td class="COLUMNHEADER"><fmt:message key="eBL.PRIMARY_BILLING_GROUP.label" bundle="${bl_labels}"/></td>
<%
				if(!(str_slmt_ind.equals("X") && !str_non_ins_blng_grp.equals("")))
				{
%>
					<td class="COLUMNHEADER"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
<%				
				}
				else
				{		
%>
					<td class="COLUMNHEADER"><fmt:message key="eBL.NON_INS_BILLING_GROUP.label" bundle="${bl_labels}"/></td>
					<td class="COLUMNHEADER"><fmt:message key="eBL.NON_INS_CUSTOMER.label" bundle="${bl_labels}"/></td>
					<td class="COLUMNHEADER"><fmt:message key="eBL.SEC_INS_BLNG_GRP.label" bundle="${bl_labels}"/></td>
					<td class="COLUMNHEADER"><fmt:message key="eBL.PRIO_1_INS_PYR.label" bundle="${bl_labels}"/></td>
					<td class="COLUMNHEADER"><fmt:message key="eBL.OTH_INS_PYR.label" bundle="${bl_labels}"/></td>
<%
				}
%>
				</tr>

				<tr>
					<td class="label">
					<%
						if(invalid_blng_grp.equals("Y"))
						{
					%>
					<CENTER><FONT color="RED">#</font></CENTER>
					<%
						}
						else
						{	
					%>
					&nbsp;
					<%	
						}
					%>
					</td>
<%
					if(!(str_slmt_ind.equals("X") && !str_non_ins_blng_grp.equals("")))
					{	
%>
					<td  class="label">
<%									
						if(invalid_cust_code.equals("Y"))
						{
					%>
					<CENTER><FONT color="RED">#</font></CENTER>
					<%	
						}
						else
						{
						%>
							&nbsp;
						<%
						}
%>					
					</td>
<%
					}
					else
					{
%>

					<td  class="label">
					<%
						if(invalid_non_ins_blng_grp.equals("Y"))
						{
					%>
					<CENTER><FONT color="RED">#</font></CENTER>
					<%
						}
						else
						{	
					%>
					&nbsp;
					<%	
						}
					%>
					</td>

					<td  class="label">
					<%
						if(invalid_cust_code.equals("Y"))
						{
							if(str_slmt_ind.equals("X") && !str_non_ins_blng_grp.equals(""))
							{
					%>
					<CENTER><FONT color="RED">#</font></CENTER>
					<%
							}
						}
						else
						{	
					%>
					&nbsp;
					<%	
						}
					%>
					</td>

					<td  class="label">
					<%
						if(!invalid_ins_blng_grp.equals(""))
						{
					%>
					<CENTER><FONT color="RED">#</font></CENTER>
					<%
						}
						else
						{	
					%>
					&nbsp;
					<%	
						}
					%>
					</td>
					
					<td  class="label">
					<%
						if(prio_1_pyr_invalid_YN.equals("Y"))
						{
					%>
					<CENTER><FONT color="RED">#</font></CENTER>
					<%
						}
						else
						{	
					%>
					&nbsp;
					<%	
						}
					%>
					</td>

					<td class="label">
					<%
						if(!str_inv_prio_values.equals(""))
						{
					%>
					<CENTER><FONT color="RED">#</font></CENTER>
					<%
						}
						else
						{	
					%>
					&nbsp;
					<%	
						}
					%>
					</td>
				</tr>
<%
				}
%>

				<tr>
					<td colspan='7'><b><font color="RED"><b id='invalid_mess'></b></font></b></td>

				</tr>
			</table>
		</td>

	</tr>

	<tr>		 
		
<%
	if( invalid_blng_grp.equals("N") && invalid_non_ins_blng_grp.equals("N") && invalid_cust_code.equals("N") &&  prio_1_pyr_invalid_YN.equals("N") )
	{
%>
		<td width="25%" class="label" colspan='4'>
			<div align='right' ><input type=button class='button' name='continue' id='continue' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" onClick='return continuemodifybut("C");'>
			<input type=button class='button' name='Revise' id='Revise' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")%>" onClick='return continuemodifybut("M");'></div>
		</td>
<%
	}
	else
	{
%>
		<td width="25%" class="label" align='right' colspan='4'>
			<div align='right' ><input type=button class='button' name='Revise' id='Revise' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")%>" onClick='return continuemodifybut("M");'></div>
		</td>
<%
	}
%>
	</tr>
	<tr>
		<td colspan='4' class='label'><B><U><fmt:message key="eBL.PREREQ_UPD_PAT_FIN_DTLS.label" bundle="${bl_labels}"/></U></B></td>
	</tr>

	<tr>
		<td colspan='4' class='label'>
<%
				if(!(str_slmt_ind.equals("X") && !str_non_ins_blng_grp.equals("")))
				{
%>
					<div id='inv_blng_grp_cust_mess'></div>

<%
				}
				else
				{
%>
					<div id='inv_pmry_blng_grp_mess'></div>
					<br>
					<div id='inv_prio1_pyr_mess'></div>
					<br>
					<div id='inv_non_ins_blng_grp_cust_mess'></div>
<%
				}
%>
		</td>
	</tr>
<%
	if(str_slmt_ind.equals("X") && !str_non_ins_blng_grp.equals(""))
	{
		if((!invalid_ins_blng_grp.equals("") || !str_inv_prio_values.equals("")) && invalid_blng_grp.equals("N") && invalid_non_ins_blng_grp.equals("N") && invalid_cust_code.equals("N") &&  prio_1_pyr_invalid_YN.equals("N") )
		{
%>
	<tr>
		<td colspan='4' class='label'><B><U><fmt:message key="Common.note.label" bundle="${common_labels}"/></U></B></td>
	</tr>

	<tr>
		<td colspan='4' class='label'>
			<div id='inv_ins_pyrs_mess'></div>			
		</td>
	</tr>
<%
		}
	}
%>
</table>

<input type='hidden' name='invalid_blng_grp' id='invalid_blng_grp' value='<%=invalid_blng_grp%>'>
<input type='hidden' name='invalid_non_ins_blng_grp' id='invalid_non_ins_blng_grp' value='<%=invalid_non_ins_blng_grp%>'>
<input type='hidden' name='invalid_cust_code' id='invalid_cust_code' value='<%=invalid_cust_code%>'>
<input type='hidden' name='invalid_ins_blng_grp' id='invalid_ins_blng_grp' value='<%=invalid_ins_blng_grp%>'>
<input type='hidden' name='prio_1_pyr_invalid_YN' id='prio_1_pyr_invalid_YN' value='<%=prio_1_pyr_invalid_YN%>'>		
<input type='hidden' name='str_inv_prio_values' id='str_inv_prio_values' value='<%=str_inv_prio_values%>'>

<input type='hidden' name='str_patient_id' id='str_patient_id' value='<%=str_patient_id%>'>
<input type='hidden' name='str_facility_id' id='str_facility_id' value='<%=str_facility_id%>'>
<input type='hidden' name='rtn_blng_grp' id='rtn_blng_grp' value='<%=str_blng_grp%>'>
<input type='hidden' name='rtn_slmt_ind' id='rtn_slmt_ind' value='<%=str_slmt_ind%>'>
<input type='hidden' name='rtn_slmt_type_code' id='rtn_slmt_type_code' value='<%=str_slmt_type_code%>'>
<input type='hidden' name='rtn_cust_code' id='rtn_cust_code' value='<%=str_slmt_type_code%>'>
<input type='hidden' name='rtn_non_ins_blng_grp' id='rtn_non_ins_blng_grp' value='<%=str_non_ins_blng_grp%>'>
<input type='hidden' name='rtn_non_ins_cust_code' id='rtn_non_ins_cust_code' value='<%=str_non_ins_cust_code%>'>

	 
</form>
</body>

<%
	}
	catch(Exception e)
	{
		System.out.println("Main Exception:"+e);
	}
	finally
	{ 
		ConnectionManager.returnConnection(con, request);
	}
%>

</html>



