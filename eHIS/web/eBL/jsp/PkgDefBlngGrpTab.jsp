<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<html>
<head>



<%
//Added by muthu against 31860 on 5/4/2012
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt	= null;
	ResultSet rs = null;
	CallableStatement call = null;
	request.setCharacterEncoding("UTF-8");
//Added by muthu against 31860 on 5/4/2012
	String fromDate	= request.getParameter("fromDate")== null ? "": request.getParameter("fromDate");
	String blng_grp_code	= request.getParameter("blng_grp_code")== null ? "": request.getParameter("blng_grp_code");
	String blng_grp_desc	= request.getParameter("blng_grp_desc")== null ? "": request.getParameter("blng_grp_desc");	
	String parent_index	= request.getParameter("parent_index")== null ? "": request.getParameter("parent_index");

	//Added by muthu against 31860 on 5/4/2012 Starts Here
	String str_error_level="", str_error_text="", str_sysmesage_id="", str_error_code="";
	String copyReplaceFlag = request.getParameter("param") == null ? "" : request.getParameter("param");//Modified V190401-Aravindh/Handled null
	String packageCode = request.getParameter("param1") == null ? "" : request.getParameter("param1");//Modified V190401-Aravindh/Handled null
	//String effFromDate	= request.getParameter("pakEffDate")== null ? "": request.getParameter("pakEffDate");
	String effFromDate = request.getParameter("param2") == null ? "" : request.getParameter("param1");//Modified V190401-Aravindh/Handled null
	String isMaterPackageYN = request.getParameter("isMaterPackageYN");
	if(isMaterPackageYN == null || isMaterPackageYN == "") isMaterPackageYN="N";
	String frm_date = "";
	String str_facility_id	=  (String) session.getValue("facility_id");
	//String packageCode		=	request.getParameter("packageCode")== null ? "": request.getParameter("packageCode");
	//String effFromDate		= request.getParameter("effFromDate")== null ? "": request.getParameter("effFromDate");
String allow_masterChild_package=request.getParameter("allow_masterChild_package");
System.out.println("PkgDefBlngGrpTab.jsp allow_masterChild_package="+allow_masterChild_package);
	try{	
		
			HttpSession httpSession = request.getSession(false);
			String locale	= (String)session.getAttribute("LOCALE");
			Properties p = (Properties)httpSession.getValue("jdbc");	

			java.util.Locale loc = new java.util.Locale(locale);
			java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
			con	=	ConnectionManager.getConnection(request);
/*	Newly Added
	try{
			String sql_date="select to_char( to_date('"+fromDate+"','dd/mm/yyyy')) from dual";
			System.out.println("Entering Date Try "+sql_date);

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_date);
			if( rs != null ) 
			{
				System.out.println("If con ");
				while( rs.next() )
				{			
					System.out.println("While con ");
					frm_date = rs.getString(1);
				System.out.println("frm_date===> "+frm_date);
				}
			}
			if(rs!=null) rs.close();
			stmt.close();			
		}	
		catch(Exception e)
		{
			System.out.println("Exception @ Date Format :"+e);
			e.printStackTrace();
		}			

//Newly Added*/

		if(copyReplaceFlag.equals("C"))
			{
				String sqlcopybase="{ call   blpackage.replacebgpkgdefwithbasedef(?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?)}";
				/* Fixed SQL Injection for Common-ICN-0222 */
				call = con.prepareCall(sqlcopybase);
				call.setString(1,str_facility_id);
				call.setString(2,packageCode);
				call.setString(3,blng_grp_code);
				call.setString(4,fromDate);
				call.setString(5,copyReplaceFlag);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);

				call.execute();
				str_error_text=call.getString(6);
				str_error_code=call.getString(7);
				str_sysmesage_id=call.getString(8);
				
				if(str_error_text==null) str_error_text="";
				if(str_error_code==null) str_error_code="";
				if(str_sysmesage_id==null) str_sysmesage_id="";		
				
	
				if ((!str_error_text.equals("")) || !str_sysmesage_id.equals(""))
				{
					if(!str_error_text.equals(""))
					{
	%>
						<script>
							alert('<%=str_error_text%>');
						</script>
	<%
						con.rollback();
						call.close();
					}
					if(!str_sysmesage_id.equals(""))
					{
	%>
					<script>
						alert(getMessage('<%=str_sysmesage_id%>',"BL"));
					</script>
	<%
						con.rollback();
						call.close();
					}
				}
			}
			else if(copyReplaceFlag.equals("R"))
			{

				String sqlreplacebase="{ call   blpackage.replacebgpkgdefwithbasedef(?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?)}";
				/* Fixed SQL Injection for Common-ICN-0222 */
				call = con.prepareCall(sqlreplacebase);
				call.setString(1,str_facility_id);
				call.setString(2,packageCode);
				call.setString(3,blng_grp_code);
				call.setString(4,fromDate);
				call.setString(5,copyReplaceFlag);
				call.registerOutParameter(6,java.sql.Types.VARCHAR);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);

				call.execute();
				str_error_text=call.getString(6);
				str_error_code=call.getString(7);
				str_sysmesage_id=call.getString(8);
				
				if(str_error_text==null) str_error_text="";
				if(str_error_code==null) str_error_code="";
				if(str_sysmesage_id==null) str_sysmesage_id="";					

				if ((!str_error_text.equals("")) || !str_sysmesage_id.equals(""))
				{
					if(!str_error_text.equals(""))
					{
%>
						<script>
							alert('<%=str_error_text%>');
						</script>
<%
						con.rollback();
						call.close();
					}
					if(!str_sysmesage_id.equals(""))
					{

%>						<script>
						alert(getMessage('<%=str_sysmesage_id%>',"BL"));
					</script>
<%
						con.rollback();
						call.close();
					}
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Exception in qry :" +e);
			e.printStackTrace();
			con.rollback();
		}
	//Added by muthu against 31860 on 5/4/2012 Ends Here

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src='../js/PkgDef.js'></script> 
<script language="javascript" src='../js/PkgDefBlngGrp.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


  

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > <!-- onLoad="chkMasterpack1()">  -->
<form name="blng_grp_tab" id="blng_grp_tab">

<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
			 <li class='tablistitem' title='<fmt:message key="eBL.BillingGroupBasePrice.label" bundle="${bl_labels}"/>'>
				<a onclick='showBlngGrpTabDetail("BLNG_GRP_PRICE",parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader,parent.PkgDefBlngGrpDetailFrame,parent.PkgDefBlngGrpTabFrame,document.forms[0].blng_grp_code.value,document.forms[0].blng_grp_desc.value,"<%=parent_index%>",document.forms[0].fromDate.value)' class="tabA" id="BLNG_GRP_PRICE">
					<span class="tabAspan" id="BLNG_GRP_PRICEspan">
					<fmt:message key="eBL.BillingGroupBasePrice.label" bundle="${bl_labels}"/>			
						</span></a>
			</li> 

			<li class="tablistitem" title='<fmt:message key="eBL.BillingGroupRateBasedServices.label" bundle="${bl_labels}"/>'>
				<a onclick="showBlngGrpTabDetail('BLNG_GRP_RATE_BASED',parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader,parent.PkgDefBlngGrpDetailFrame,parent.PkgDefBlngGrpTabFrame,document.forms[0].blng_grp_code.value,document.forms[0].blng_grp_desc.value,'<%=parent_index%>',document.forms[0].fromDate.value)" class="tabA" id="BLNG_GRP_RATE_BASED">
					<span class="tabAspan" id="BLNG_GRP_RATE_BASEDspan">
						<!--<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>-->
						<fmt:message key="eBL.BillingGroupRateBasedServices.label" bundle="${bl_labels}"/>			
						</span></a>
			</li>

			<li class="tablistitem" title='<fmt:message key="eBL.BillingGroupChargeBasedServices.label" bundle="${bl_labels}"/>'>
				<a onclick="showBlngGrpTabDetail('BLNG_GRP_CHARGE_BASED',parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader,parent.PkgDefBlngGrpDetailFrame,parent.PkgDefBlngGrpTabFrame,document.forms[0].blng_grp_code.value,document.forms[0].blng_grp_desc.value,'<%=parent_index%>',document.forms[0].fromDate.value)" class="tabA" id="BLNG_GRP_CHARGE_BASED">
					<span class="tabAspan" id="BLNG_GRP_CHARGE_BASEDspan">
						<!--<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>-->
						<fmt:message key="eBL.BillingGroupChargeBasedServices.label" bundle="${bl_labels}"/>			
						</span></a>
			</li>	
			
			
		</ul>
	</td>	
	</tr>
</table>
<input type='hidden' name='prevTabObj' id='prevTabObj' value="" />
<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
<input type='hidden' name='blng_grp_code' id='blng_grp_code' value="<%=blng_grp_code%>" />
<input type='hidden' name='blng_grp_desc' id='blng_grp_desc' value="<%=blng_grp_desc%>" />
<input type='hidden' name='parent_index' id='parent_index' value="<%=parent_index%>" />
<input type='hidden' name='isMaterPackageYN' id='isMaterPackageYN' value="<%=isMaterPackageYN%>" />
<input type='hidden' name='allow_masterChild_package_map' id='allow_masterChild_package_map' value="<%=allow_masterChild_package%>" />
<input type='hidden' name='isMasterPackYN' id='isMasterPackYN' value="<%=isMaterPackageYN%>" />
<!-- sarath added MMS-QF-SCF-0545 Below Fields added -->
<input type='hidden' name='BLNG_GRP_PRICE_CHK' id='BLNG_GRP_PRICE_CHK' id='BLNG_GRP_PRICE_CHK' value="N" /> 
<input type='hidden' name='BLNG_GRP_RATE_BASED_CHK' id='BLNG_GRP_RATE_BASED_CHK' id='BLNG_GRP_RATE_BASED_CHK' value="N" /> 
<input type='hidden' name='BLNG_GRP_CHARGE_BASED_CHK' id='BLNG_GRP_CHARGE_BASED_CHK' id='BLNG_GRP_CHARGE_BASED_CHK' value="N" />

<!-- The below line is required to change the select state of Initial tab selected -->
<script>
showBlngGrpTabDetail("BLNG_GRP_PRICE",parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader,parent.PkgDefBlngGrpDetailFrame,parent.PkgDefBlngGrpTabFrame,document.forms[0].blng_grp_code.value,document.forms[0].blng_grp_desc.value,document.forms[0].parent_index.value,document.forms[0].fromDate.value);
changeBlngGrpTabClass("BLNG_GRP_PRICE",parent.PkgDefBlngGrpDetailFrame,parent.PkgDefBlngGrptTabFrame);</script> 


</form>
</body>
</html>

