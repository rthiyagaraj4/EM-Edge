<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html><head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
<script Language="JavaScript" src='../../eCA/js/ViewClinicalNote.js'></script>

 



<%
	Connection			conlCon		=	null;
	PreparedStatement	stmt		=	null;
	ResultSet			rset		=	null;
	
	String splty="";
	String shortdesc="";

	String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
	
	if(ca_practitioner_id == null) ca_practitioner_id="";
	String facilityId = (String) session.getValue("facility_id");
	if(facilityId == null) facilityId="";
	String patclass=request.getParameter("encounterType")==null?"":request.getParameter("encounterType");
	

    try 
		{

    conlCon=ConnectionManager.getConnection(); 
	
	stmt = conlCon.prepareStatement("select DISTINCT SERVICE_CODE SPLTY_CODE,SERVICE_SHORT_DESC SHORT_DESC from CA_PRACT_BY_SPLTY_LOCN_VIEW  WHERE FACILITY_ID=? AND PRACTITIONER_ID=? AND PATIENT_CLASS=? order by 2 ");
	
	stmt.setString(1,facilityId);
	stmt.setString(2,ca_practitioner_id);
	stmt.setString(3,patclass);
	rset = stmt.executeQuery();
									
	while(rset.next())
	{
	splty=rset.getString("SPLTY_CODE");
	shortdesc=rset.getString("SHORT_DESC");
		
								
			%>
<script Language="JavaScript">
				
   				var opt		=	document.createElement('OPTION'); 
 				opt.text	=	"<%=shortdesc%>";
				opt.value	=	"<%=splty%>";
		top.content.workAreaFrame.PatCriteriaFr.document.PatCriteriaFrm.medServiceCode.add(opt); 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 		 	<%
			} // end of while

				
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		
		
		
	}catch(Exception e){
	//	out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181

	}finally{
%>
		</head><body class='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'></body></html>
<%		
		if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
	}

%>
</head>
</html>

