<!DOCTYPE html>
<!--
---------------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V220413            30399          MMS-ME-SCF-0064-TF               Mohanapriya K
--------------------------------------------------------------------------------------------------------
-->
<%@page  import="webbeans.eCommon.ConnectionManager,org.apache.commons.codec.binary.Base64"%>
<%@page  import="java.sql.PreparedStatement"%>
<%@page  import="java.sql.ResultSet"%>
<%@page  import="java.sql.Connection"%>
<%@page  import="eBL.Common.BlRepository"%>
<%@page   language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String facility_id = (String)session.getAttribute("facility_id");
	String payerGroup = checkForNull(request.getParameter("payerGroup"));
	String payer = checkForNull(request.getParameter("payer"));
	String policy = checkForNull(request.getParameter("policy"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String encGrpId = checkForNull(request.getParameter("encGrpId"));
	String episodeId = checkForNull(request.getParameter("episodeId"));
	String priority =  checkForNull(request.getParameter("priority"));
	String patientId ="";
	//V220413
	if("Y".equals(request.getParameter("compressed")==null?"":request.getParameter("compressed"))) {
			patientId = new String(Base64.decodeBase64(((String)request.getParameter("patientId")).getBytes())); 
	}else{
		patientId = checkForNull(request.getParameter("patientId"));
	}
	//V220413
    if(encGrpId.length()==0 && priority.length()> 0)
    {
    	HashMap validAcrossEncMap = (HashMap)session.getAttribute("VALID_ACROSS_ENCOUNTER_MAP");
    	if( validAcrossEncMap !=null)
    	{
    	encGrpId=(String)validAcrossEncMap.get(policy+priority);
    	encGrpId=checkForNull(encGrpId);
    	
    	}
    	
    }
    	
    	
    	
	String  strfield ="YELLOW";
	String  strGroupId ="";
	
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Across Encounters Details</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<form name='frmAcrossEncounter' id='frmAcrossEncounter'>
<br>
<br>
<table width='90%' cellpadding='3'  cellspacing=0 align="center" border="1">  
<tr>				
	<th class='CAFLOWSHEETLEVEL1'	align="left"	width="4%">Sr.No</th>
	<th class='CAFLOWSHEETLEVEL1'	align="left"	width="30%">Encounter Group ID</th>
	<th class='CAFLOWSHEETLEVEL1' 	align="left"	width=30%">Encounter Id</th>
	<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="30%" >Policy No</th>
</tr>
<%

try{
	String acrossEncounter = "";
	con = ConnectionManager.getConnection(request);
	if(("I".equals(episodeType)) || ("D".equals(episodeType))||("IP".equals(episodeType))||("DC".equals(episodeType))){		
		acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ENC_GRP_ID");
	}
	else if(("O".equals(episodeType)) || ("E".equals(episodeType)) ||("OP".equals(episodeType)) || ("AE".equals(episodeType))){		
		acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ENC_GRP_OE");
	}
	else {
		acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ENC_GRP_R");
	}
	pstmt = con.prepareStatement(acrossEncounter);			
	pstmt.setString(1,payerGroup);
	//System.out.println("#### Payer Group  "+payerGroup);
	pstmt.setString(2,payer);
	//System.out.println("#### Payer Group  "+payer);
	pstmt.setString(3,policy);
	//System.out.println("#### Payer Group  "+policy);
	pstmt.setString(4,facility_id);
	//System.out.println("#### Payer Group  "+facility_id);
	pstmt.setString(5,patientId);
	//System.out.println("#### Payer Group  "+patientId);
	rst = pstmt.executeQuery();
	int rstCnt = 0;
	if(rst != null){
		while(rst.next()){
			//acrossEncCount = rst.getInt("enc_count");	
			strGroupId =checkForNull(rst.getString("ACROSS_ENC_GROUP_ID"));
			if(strGroupId.equals(encGrpId))
				strfield = "YELLOW";
			else
				strfield ="fields";
			
			rstCnt++;
			out.println("<tr>");
			out.println("<td class='fields' id='sno"+rstCnt+"'>");
			%>
			<a href='javascript:fnChangeAcrossGrpId(<%=strGroupId %>)'><%=rstCnt %></a>
			<%
			out.println("</td>");
			out.println("<td class='"+strfield+"' id='encGrpid"+rstCnt+"'>");
			out.println(strGroupId);
			out.println("</td>");
			out.println("<td class='"+strfield+"' id='encId"+rstCnt+"'>");
			out.println(rst.getString("ENCOUNTER_ID"));
			out.println("</td>");
			out.println("<td class='"+strfield+"' id='policyNo"+rstCnt+"'>");
			out.println(rst.getString("POLICY_NUMBER"));
			out.println("</td>");
			out.println("</tr>");
		}
		rst.close();
	}
	pstmt.close();

}
catch(Exception e){
	System.err.println("Exception in Across Enc Popup - "+e);
}
finally{
	ConnectionManager.returnConnection(con);
}
	
%>      	
	
      	</table>	
     </form>
</body>
</html>

