<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
27-Nov-2013      100           	Karthikeyan.K       Created to Display package Information  
---------------------------------------------------------------------------------------------------------------
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ page import= "eBL.*,eBL.Common.*,webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%!
public String getDescription(String query,String ...args){
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String descriptionResult=new String();	
	
	try {
		con = ConnectionManager.getConnection();
		pst = con.prepareStatement(query);
		for(int i=0;i<args.length;i++){
		pst.setString(i+1, args[i]);
		}
		rs = pst.executeQuery();

		if (rs.next()) {
			descriptionResult=rs.getString(1);	
		}		

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return  descriptionResult;		
}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/> 
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>   


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	onSelect="codeArrestThruSelect();">

	<FORM name="BLBillSlmtPkgInfoForm" id="BLBillSlmtPkgInfoForm" >
	<TABLE width='100%' border='0' cellpadding='3' cellspacing='0'>
			<tr>
			<td width='50%' class='fields'> </td>			
			<td width='50%' class='fields'> <input type='button' class='button'  value='<fmt:message key="Common.close.label" bundle="${common_labels}" />' size='20'  onClick='window.close();' ></td>
			</tr>
	</TABLE>
 	<div id="BLBillSlmtPkgInfoDiv" STYLE="width:100%; height:86vh; overflow: auto;">

	<TABLE  width="100%"  id="BLBillSlmtPkgInfoTable" border='0' cellpadding='3' cellspacing='0'>
			<tr>
			<th width="15%"><fmt:message key="Common.episodeid.label" bundle="${bl_labels}"/></th>
			<th width="5%"><fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}"/></th>
			<th width="10%"><fmt:message key="Common.PackageCode.label" bundle="${bl_labels}"/></th>
			<th width="10%"><fmt:message key="eBL.PackageDesc.Label" bundle="${bl_labels}"/></th>
			<th width="10%"><fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels}"/></th>
			<th width="10%"><fmt:message key="eBL.ServiceDescription.label" bundle="${bl_labels}"/></th>
			<th width="5%"><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></th>
			<th width="5%"><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></th>
			<th width="5%"><fmt:message key="Common.NetAmount.label" bundle="${bl_labels}"/></th>
			<th width="5%"><fmt:message key="Common.priority.label" bundle="${bl_labels}"/></th>
			<th width="10%"><fmt:message key="Common.BillingGroup.label" bundle="${bl_labels}"/></th>
			<th width="10%"><fmt:message key="Common.Customer.label" bundle="${bl_labels}"/></th>
			</th>
			</tr>	
			<%
			Connection con	= null;
			try{
			String pkgCode=request.getParameter("pkgCode");
			String pkgSeqNo=request.getParameter("pkgSeqNo");
			String patientId=request.getParameter("patientId");
			String locale	= (String)session.getAttribute("LOCALE");
			String facilityid = (String) session.getValue("facility_id");
			
// 			pkgCode="321";
// 			pkgSeqNo="387";
// 			patientId="HC00011186";
			
			String serviceCodeDescQuery="select SHORT_DESC  from bl_blng_serv where BLNG_SERV_CODE=?";	
			String custCodeDescQuery="select SHORT_NAME from ar_customer_lang_vw	where LANGUAGE_ID=?	and CUST_CODE=?";	
			String pkgdescriptionQuery="SELECT SHORT_DESC FROM  bl_package_lang_vw	WHERE  PACKAGE_CODE =?	and  language_id=? and  operating_facility_id=?";
			String pkgsql= "select EPISODE_ID,EPISODE_TYPE,BLNG_SERV_CODE,UPD_GROSS_CHARGE_AMT,UPD_DISC_AMT,UPD_NET_CHARGE_AMT,PRIORITY,BLNG_GRP_ID,CUST_CODE from BL_PACKAGE_FOLIO where PACKAGE_SEQ_NO=? and PATIENT_ID=?";
			con	=	ConnectionManager.getConnection(request);
			PreparedStatement pkgstmt = con.prepareStatement(pkgsql);
			pkgstmt.setString(1, pkgSeqNo);
			pkgstmt.setString(2, patientId);
			ResultSet pkgrs =  pkgstmt.executeQuery();
			int i=0;

			while(pkgrs.next())
			{
				String episode_id=    pkgrs.getString(1);			
				String episode_type=  pkgrs.getString(2);		
				String package_code=  pkgCode;		
				String package_desc=  getDescription(pkgdescriptionQuery,package_code,locale,facilityid);		
				String serv= 	  pkgrs.getString(3);		
				String serv_desc= getDescription(serviceCodeDescQuery,serv);			
				String gross_amt= pkgrs.getString(4);		
				String disc_amt=  pkgrs.getString(5);		
				String net_amt=   pkgrs.getString(6);		
				String priority=  pkgrs.getString(7);		
				String blng_grp=  pkgrs.getString(8);		
				String cust_cd=   pkgrs.getString(9);	
				String cust=  	  getDescription(custCodeDescQuery,locale,cust_cd);	
				
				if(episode_id==null) episode_id="";
				if(episode_type==null) episode_type="";
				if(package_code==null) package_code="";
				if(package_desc==null) package_desc="";
				if(serv==null) serv="";
				if(serv_desc==null) serv_desc="";
				if(gross_amt==null) gross_amt="";
				if(disc_amt==null) disc_amt="";
				if(net_amt==null) net_amt="";
				if(priority==null) priority="";
				if(blng_grp==null) blng_grp="";
				if(cust==null) cust="";
				
			%>		

			<tr>
			<td width="15%" class="fields"><input type='text' name='episode_id<%=i%>' id='episode_id<%=i%>' value="<%=episode_id%>"></td>
			<td width="5%" class="fields"><input type='text' size='5' name='episode_type<%=i%>' id='episode_type<%=i%>' value="<%=episode_type%>"></td>
			<td width="10%" class="fields"><input type='text' name='package_code<%=i%>' id='package_code<%=i%>' value="<%=package_code%>"> </td>
			<td width="10%" class="fields"><input type='text' name='package_desc<%=i%>' id='package_desc<%=i%>' value="<%=package_desc%>"> </td>
			<td width="10%" class="fields"><input type='text' name='serv<%=i%>' id='serv<%=i%>' value="<%=serv%>"> </td>
			<td width="10%" class="fields"><input type='text' name='serv_desc<%=i%>' id='serv_desc<%=i%>' value="<%=serv_desc%>"> </td>
			<td width="5%" class="fields"><input type='text'  name='gross_amt<%=i%>' id='gross_amt<%=i%>' value="<%=gross_amt%>"> </td>
			<td width="5%" class="fields"><input type='text'  size='5' name='disc_amt<%=i%>' id='disc_amt<%=i%>' value="<%=disc_amt%>"> </td>
			<td width="5%" class="fields"><input type='text'  size='5' name='net_amt<%=i%>' id='net_amt<%=i%>' value="<%=net_amt%>"> </td>
			<td width="5%" class="fields"><input type='text'  name='priority<%=i%>' id='priority<%=i%>' value="<%=priority%>"> </td>
			<td width="10%" class="fields"><input type='text' name='blng_grp<%=i%>' id='blng_grp<%=i%>' value="<%=blng_grp%>"> </td>
			<td width="10%" class="fields"><input type='text' name='cust<%=i%>' id='cust<%=i%>' value="<%=cust%>"> </td>
			</tr>
			<%
			i++;
			}
			if(pkgstmt!=null) {
				pkgstmt.close();	
			}
			if(pkgrs!=null) {
				pkgrs.close();	
			}
			
	}
	catch(Exception e )
	{ 
		System.err.println("Main Exception,BLBillSlmtPkgInfo.jsp:"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con, request);
	}
			%>

	</TABLE> 
 	</div> 

	</FORM>


</body>
</html>

