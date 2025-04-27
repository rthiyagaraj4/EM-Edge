 <%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
---------------------------------------------------------------------------------------
1	     240513           52917           MMS-DM-CRF-0247.4          Srinivasa N T            

---------------------------------------------------------------------------------------
*/
%>
<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/> 
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgUtilization.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script>
	$(document).ready(function(){
		var noofdecimal = $('#noofdecimal').val() 
		
		
				$('[id^=utilizedAmt]').each(function(){
					if($.trim($(this).text() != '')){
						putDecimal_Text($(this),17,noofdecimal);				
					}
					else{
						$(this).text('0');
						putDecimal_Text($(this),17,noofdecimal);
					}
				});
				$('[id^=amtLmt]').each(function(){
					if($.trim($(this).text() != '')){
						putDecimal_Text($(this),17,noofdecimal);				
					}
					else{
						$(this).text('0');
						putDecimal_Text($(this),17,noofdecimal);
					}
				});
				$('[id^=balanceAmt]').each(function(){
					if($.trim($(this).text() != '')){
						putDecimal_Text($(this),17,noofdecimal);				
					}
					else{
						$(this).text('0');
						putDecimal_Text($(this),17,noofdecimal);
					}
				});
			});
	</script>
		
	<style>
         thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;} 
 
 

 
	</style>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		Connection con			= null;	
                CallableStatement cstmt = null ;
		PreparedStatement pstmt = null;
		ResultSet rs		= null; 
                String str_err_text="",str_err_id="";

		String locale			= (String)session.getAttribute("LOCALE");
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String p_patient_id		= request.getParameter("patientId");
		p_patient_id				= p_patient_id==null ?"":p_patient_id;
		String p_pacakge_code		= request.getParameter("packageCode");
		p_pacakge_code				= p_pacakge_code==null ?"":p_pacakge_code;
/* 		String pkgDesc			= request.getParameter("pkgDesc");
		pkgDesc					= pkgDesc==null ?"":pkgDesc; */ 
		String p_pkg_seq_no		= request.getParameter("packageSeqNo");
		p_pkg_seq_no			= p_pkg_seq_no==null ?"":p_pkg_seq_no;
		String p_user_id	= checkForNull((String)session.getValue("login_user"));
		p_user_id			= p_user_id==null ?"":p_user_id;

		String packageSrvCode	= "";
		String classval			= "QRYEVEN";
		String classvalForAmt	= "QRYEVEN_AMT";
		String excludeyn         ="";
		double qtyLmt			= 0.0;
		double utilizedQty		= 0.0; 
		double balanceSrvQty	= 0.0;
		double amtLmt			= 0.0;
		double utilizedAmt		= 0.0; 
		double balanceAmt		= 0.0;
		double OrdPlaced		= 0.0;
		double OrdRegisterd		= 0.0;
		double balanceOrd		= 0.0;
		String Amount_limit_ind =""; 
		double daily_amt_limt	= 0.0;
		boolean dailyLimitSiteSpec = false;
		String toDisplay	="&nbsp";
		int noofdecimal=2;
		String serviceCatgory=null;
		String AmtLimitInd=null;
		String pkgServCode =null;
		String serDesc =null;
		int qtyLimit;
		int utilizedServQty;
		int amtLimit;
		int utilizedServAmt;
		int dailyamtlimit;
		int dailyqtylimit;
		String OrderCatYN =null;
		

		%>

<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
 	
<%
	try{
	
		int i =0;
		int counter = 0;
		con = ConnectionManager.getConnection(request);
		
		String preAppQueryIns = "";
		preAppQueryIns="{call bl_proc_pkg_utilization_dtls(?,?,?,?,?,?,?,?,?)}";
		cstmt = con.prepareCall(preAppQueryIns);
		cstmt.setString(1, p_facility_id);
		cstmt.setString(2, locale);
		cstmt.setString(3, p_patient_id);
		cstmt.setString(4, p_pacakge_code);
		cstmt.setString(5, p_pkg_seq_no);
		cstmt.setString(6, p_user_id);
 		cstmt.registerOutParameter(7, Types.VARCHAR);
		cstmt.registerOutParameter(8, Types.VARCHAR);
		cstmt.registerOutParameter(9, Types.INTEGER);
		System.out.println("@@execute--777---");
		cstmt.execute();
		System.out.println("@@execute-----");
		int session_id = cstmt.getInt(9);
		str_err_text=checkForNull(cstmt.getString(7));
		str_err_id=checkForNull(cstmt.getString(8));
		System.out.println("str_err_text----"+str_err_text);
		System.out.println("str_err_id---::"+str_err_id);
		String sql = "SELECT SERV_CATG,PKG_SERV_CODE,SERVICE_DESC,QTY_LIMIT,AMT_LIMIT,AMT_LIMIT_IND,EXCLUDE_YN,DAILY_AMT_LIMIT,DAILY_QTY_LIMIT,SERV_CODE,HDR_DTL_FLAG,UTILIZED_QTY,UTILIZED_AMT,IND_FLAG from bl_pkg_utilization_dtls_tmp where session_id="+session_id+" and user_id='"+p_user_id+"'";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		System.out.println("resultSet---"+rs);

		%>
		   <div id="tbl-container" STYLE="overflow: auto;  height: 550px;   padding:3px; margin: 0px">
		      <table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
	           <table class='grid' width='100%' id="PkgUtilSerDtlsForPatient"> 
					  <thead> 
							<tr>
							    <td class='columnheader' style="width: 4%;" ><fmt:message key="Common.Sno.label" bundle="${common_labels}"/></td>
								<td class='columnheader' style="width: 10%;" ><fmt:message key="eBL.INDICATOR.label" bundle="${bl_labels}"/></td> 
								<td class='columnheader'style="width: 10%;" ><fmt:message key="eBL.ServiceGroup.label" bundle="${bl_labels}"/></td> 
								<td class='columnheader' style="width: 20%;" > <fmt:message key="eBL.Description.label" bundle="${bl_labels}"/></td> 
								<td class='columnheader' style="width: 8%;" ><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
								<td class='columnheader' style="width: 10%;" ><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
								<td class='columnheader' style="width: 10%;" ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></td>
								<td class='columnheader' style="width: 10%;" ><fmt:message key="eBL.Excluded.label" bundle="${bl_labels}"/></td>
								<td class='columnheader' style="width: 10%;" ><fmt:message key="eBL.DailyAmountlimit.label" bundle="${bl_labels}"/></td>
								<td  class='COLUMNHEADER' style="width: 10%;" ><fmt:message key="eBL.DailyQtylimit.label" bundle="${bl_labels}"/></td>
							</tr>
					</thead> 
			 
 <%	
 int rowcount=1;
 String strCount="";
 String innerTableRow= "";  
 float totalQty=0,totalAmt=0;
 while(rs.next())
	{
	 String Service_cat =(String)rs.getString("SERV_CATG");
	 String flag =(String)rs.getString("HDR_DTL_FLAG");
	 String excludeYn = rs.getString("exclude_yn");
	 if(flag.equalsIgnoreCase("H")){
		 counter++;
		 if(counter>1){
			 //out.println("<tr><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td></tr>");
			 out.println("<tr ><td></td><td></td><td class='classval' >Service/Itemcode</td><td class='classval'>Description</td><td class='classval'>Utilized Qty</td><td class='classval'>Utilized Amt</td></tr>");
			 out.println(innerTableRow);
			 innerTableRow="";
			 String formattedTotalQty;
			    if (totalQty % 1 != 0) {
			    	formattedTotalQty = String.format("%.2f", totalQty); 
			    } else {
			    	formattedTotalQty = String.valueOf((int) totalQty); 
			    }
			 out.println("<tr><td></td><td></td><td class='" + classval+"' nowrap>Total</td><td class='" + classval+"'></td><td class='" + classval+"'>"+formattedTotalQty+"</td><td class='" + classval+"'>"+totalAmt+"</td></tr>");
			 
			out.println("<tr><td colspan='10'><hr style='border-top: 4px solid black;'></td></tr>");
			totalQty=0;totalAmt=0;
			 //out.println("<tr><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td><td class='"+classval+"' nowrap></td></tr>");		 
		 }
		 strCount = String.valueOf(counter);
		 System.out.println(strCount+"---------1----------strCount");
	 }else{
		 strCount="";
		 System.out.println(strCount+"-----------2--------strCount"); }
	 if (!flag.equalsIgnoreCase("S")) {
 %>

		   <tr>
				    <td><%=strCount%></td>
				    <td class="<%=classval%>" nowrap ><%=Service_cat%></td>
				 <% if (Service_cat.equals("Package Group")){%>
					<td class='<%=classval%>' nowrap><a href="javascript:callResults('<%=(String)rs.getString("PKG_SERV_CODE")%>')"><%=(String)rs.getString("PKG_SERV_CODE")%></a></td>
				  <%} else {%>
				        <td class='<%=classval%>' nowrap><%=(String)rs.getString("PKG_SERV_CODE")%></td>
			      <%}%>
			        <td class='<%=classval%>' nowrap><%=(String)rs.getString("service_desc")%></td>
					<td class='<%=classval%>' style='text-align: center;' nowrap><%=(String)rs.getString("qty_limit")==null?"":(String)rs.getString("qty_limit")%></td>
					<td class='<%=classval%>' style='text-align: center;' nowrap ><%=(String)rs.getString("AMT_LIMIT")==null?"":(String)rs.getString("AMT_LIMIT")%></td>
					<td class='<%=classval%>' style='text-align: center;' nowrap><%=(String)rs.getString("AMT_LIMIT_IND")==null?"":(String)rs.getString("AMT_LIMIT_IND")%></td>
					<td class='<%=classval%>' style='text-align: center;' nowrap ><%=(String)rs.getString("exclude_yn")==null?"":(String)rs.getString("exclude_yn")%></td>
					<td class='<%=classval%>' style='text-align: center;' nowrap><%=(String)rs.getString("DAILY_AMT_LIMIT")==null?"":(String)rs.getString("DAILY_AMT_LIMIT")%></td>
					<td class='<%=classval%>' style='text-align: center;' nowrap><%=(String)rs.getString("DAILY_QTY_LIMIT")==null?"":(String)rs.getString("DAILY_QTY_LIMIT")%></td>
		    </tr>
		
 	 <%}
	 if(rs.getString("HDR_DTL_FLAG").equalsIgnoreCase("S") || rs.getString("IND_FLAG").equalsIgnoreCase("P") && rs.getDouble("UTILIZED_QTY") > 0 && rs.getDouble("UTILIZED_AMT") > 0 && (excludeYn == null || !"Y".equalsIgnoreCase(excludeYn))){
		   
		  utilizedQty = rs.getDouble("UTILIZED_QTY");
		    String formattedUtilizedQty;		 
		 
		    if (utilizedQty % 1 != 0) {
		        formattedUtilizedQty = String.format("%.2f", utilizedQty); 
		    } else {
		        formattedUtilizedQty = String.valueOf((int) utilizedQty); 
		    }	
		 
		 innerTableRow+="<tr><td></td><td></td><td class='QRYEVEN'>"+rs.getString("PKG_SERV_CODE")+"</td><td class='QRYEVEN'>"+rs.getString("service_desc")+"</td><td class='QRYEVEN'>"+formattedUtilizedQty+"</td><td class='QRYEVEN'>"+rs.getString("UTILIZED_AMT")+"</td></tr>";
		 totalQty+= Float.parseFloat(rs.getString("UTILIZED_QTY")); 
		 totalAmt+= Float.parseFloat(rs.getString("UTILIZED_AMT")); 
 	 
 	 }

 rowcount++;
	} 
 if(!rs.next()){
	 out.println("<tr><td></td><td></td><td class='classval'>ServiceGroup</td><td class='classval'>Description</td><td class='classval'>Utilized Qty</td><td class='classval'>Utilized Amt</td></tr>");
	 out.println(innerTableRow);
	 String formattedTotalQty;
	    if (totalQty % 1 != 0) {
	    	formattedTotalQty = String.format("%.2f", totalQty); 
	    } else {
	    	formattedTotalQty = String.valueOf((int) totalQty); 
	    }
	 out.println("<tr><td></td><td></td><td class='" + classval+"' nowrap>Total</td><td class='" + classval+"'></td><td class='" + classval+"'>"+formattedTotalQty+"</td><td class='" + classval+"'>"+totalAmt+"</td></tr>");
 }
 
%>  
  </table>
 </table>
</div>
	 <%
	 
}
catch(Exception e)
{
	System.out.println("Exception from Package Service Utilization Details For Patient :"+e);
	e.printStackTrace();
}
finally{
	try{
		
 
	 if(rs!=null){
		 rs.close();
	 }
	if(cstmt!=null){
		cstmt.close();
		 }
	
	if(pstmt!=null){
		pstmt.close();
	}
	if(str_err_text.equals("")  && str_err_id.equals("")){
		con.commit();
		
	}else{
		con.rollback();
	}
	if(con !=null){
		con.close();
	}
	
	}catch(Exception e){
	   e.printStackTrace();
	}
	
	
}%>
<input type='hidden' name='noofdecimal' id='noofdecimal' id='noofdecimal' value='<%=noofdecimal %>'>

</form>
</body>
</html>

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

