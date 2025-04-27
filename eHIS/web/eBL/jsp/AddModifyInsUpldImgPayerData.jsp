<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Policy Details</title>
<%String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src='../js/InsUpldImage.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

<%
	String sql = ""; 
	String inParam = checkForNull(request.getParameter("inParam"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
	String episode_id = checkForNull(request.getParameter("episode_id"));
	String facility_id = checkForNull(request.getParameter("facility_id"));

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//GHL- CRF-0550 --- PALANI NARAYANAN - STARTS
	boolean siteSpecUploadDocAll = false;

try {
	con	=	ConnectionManager.getConnection(request);
	siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");
	/*
	} catch(Exception ex) {
		System.err.println("AddModifyInsUpldImgPayerData.jsp:"+ex);
		ex.printStackTrace();
	} */ //Commented V211018
	if(siteSpecUploadDocAll)
	{
	if(("I".equals(episode_type)) || ("D".equals(episode_type)) || ("O".equals(episode_type)) || ("E".equals(episode_type))){
		if(episode_id.length() > 0){		
		sql = 	"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
			"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date "+
			"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
			"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And upper(Bl.Episode_Id) Like upper('%"+episode_id+"%') "+
			"And Bl.Cust_Code Is Not Null "+
			"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
			"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id";
	}
	else{
		if(("I".equals(episode_type)) || ("D".equals(episode_type))) {
		//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020 query modified added union for credit
		sql = "SELECT NVL (bl.encounter_id,bl.episode_id || LPAD (bl.visit_id, 4, 0)) episode_id1,bl.cust_group_code, grp.long_desc payer_group, bl.cust_code, cust.long_name payer, bl.policy_type_code,"+ 
			       " 'CREDIT' policy_type,bl.policy_number, TO_CHAR (bl.policy_start_date, 'dd/mm/yyyy') policy_start_date, TO_CHAR (bl.policy_expiry_date, 'dd/mm/yyyy') policy_expiry_date, a.short_desc short_desc "+
					  " FROM bl_encounter_payer_priority bl,ar_cust_group grp,ar_customer cust,bl_blng_grp a,bl_episode_fin_dtls b "+
			 		" WHERE bl.patient_id ='"+patient_id+"' AND bl.episode_type = '"+episode_type+"' AND bl.cust_code IS NOT NULL AND bl.operating_facility_id = '"+facility_id+"' AND bl.cust_group_code = grp.cust_group_code AND bl.cust_code = cust.cust_code "+   
			   		" AND a.blng_grp_id = bl.blng_grp_id AND bl.patient_id = b.patient_id AND bl.episode_type = b.episode_type AND bl.episode_id = b.episode_id AND bl.SETTLEMENT_IND = b.SETTLEMENT_IND and B.SETTLEMENT_IND = 'R' "+
					" UNION " + 
				"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
				"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date,A.SHORT_DESC short_desc "+
				"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust,bl_BLNG_GRP A ,bl_episode_fin_dtls b "+
				"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
				"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
				"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id AND A.BLNG_GRP_ID = BL.BLNG_GRP_ID "+
				"And bl.patient_id=b.patient_id and bl.episode_type=b.episode_type and bl.episode_id=b.episode_id "+
				" UNION "+
	            "select nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,' ' Cust_Group_Code,'CASH' payer_group,' ' Cust_Code,' ' payer,' ' Policy_Type_Code,'CASH' policy_type,' ' Policy_Number,' ' Policy_Start_Date,' ' Policy_Expiry_Date ,' ' short_desc "+ 
				" From Bl_Encounter_Payer_Priority BL , bl_episode_fin_dtls b where bl.patient_id='"+patient_id+"' and bl.settlement_ind='C' "+
	            "and bl.patient_id=b.patient_id and bl.episode_type=b.episode_type and bl.episode_id=b.episode_id and b.settlement_ind='C' And Bl.Episode_Type ='"+episode_type+"'";
		}
		else{
		//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020 query modified added union for credit
		sql = 	"SELECT NVL (bl.encounter_id,bl.episode_id || LPAD (bl.visit_id, 4, 0)) episode_id1,bl.cust_group_code, grp.long_desc payer_group, bl.cust_code,"+
		       " cust.long_name payer, bl.policy_type_code, 'CREDIT' policy_type,bl.policy_number, TO_CHAR (bl.policy_start_date, 'dd/mm/yyyy') policy_start_date, TO_CHAR (bl.policy_expiry_date, 'dd/mm/yyyy') policy_expiry_date, a.short_desc short_desc "+
				  " FROM bl_encounter_payer_priority bl,ar_cust_group grp,ar_customer cust,bl_blng_grp a,bl_visit_fin_dtls b "+
		 		" WHERE bl.patient_id ='"+patient_id+"' AND bl.episode_type = '"+episode_type+"' AND bl.cust_code IS NOT NULL AND bl.operating_facility_id = '"+facility_id+"' AND bl.cust_group_code = grp.cust_group_code AND bl.cust_code = cust.cust_code "+   
		   		" AND a.blng_grp_id = bl.blng_grp_id AND bl.patient_id = b.patient_id AND bl.episode_type = b.episode_type AND bl.episode_id = b.episode_id AND bl.visit_id = b.visit_id AND bl.SETTLEMENT_IND = b.SETTLEMENT_IND and B.SETTLEMENT_IND = 'R' "+
				" UNION " + 
				"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
					"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date,A.SHORT_DESC short_desc "+
					"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust,bl_BLNG_GRP A ,bl_visit_fin_dtls b "+
					"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
					"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
					"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id AND A.BLNG_GRP_ID = BL.BLNG_GRP_ID "+
					"And bl.patient_id=b.patient_id and bl.episode_type=b.episode_type and bl.episode_id=b.episode_id and bl.visit_id=b.visit_id "+
					" UNION "+
		            "select nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,' ' Cust_Group_Code,'CASH' payer_group,' ' Cust_Code,' ' payer,' ' Policy_Type_Code,'CASH' policy_type,' ' Policy_Number,' ' Policy_Start_Date,' ' Policy_Expiry_Date ,' ' short_desc "+ 
					" From Bl_Encounter_Payer_Priority BL , bl_visit_fin_dtls b where bl.patient_id='"+patient_id+"' and bl.settlement_ind='C' "+
		            "and bl.patient_id=b.patient_id and bl.episode_type=b.episode_type and bl.episode_id=b.episode_id and bl.visit_id=b.visit_id and b.settlement_ind='C' And Bl.Episode_Type ='"+episode_type+"'";
		}
	}
	}
	else if("R".equals(episode_type)){
		/*	sql = "select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
					"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date  "+
					"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
					"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
					"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
					"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id ";*/
		//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020 query modified added union for credit
		sql = "SELECT NVL (bl.encounter_id,bl.episode_id || LPAD (bl.visit_id, 4, 0)) episode_id1,bl.cust_group_code, grp.long_desc payer_group, bl.cust_code,"+
	       " cust.long_name payer, bl.policy_type_code, 'CREDIT' policy_type,bl.policy_number, TO_CHAR (bl.policy_start_date, 'dd/mm/yyyy') policy_start_date, TO_CHAR (bl.policy_expiry_date, 'dd/mm/yyyy') policy_expiry_date, a.short_desc short_desc "+
			  " FROM bl_encounter_payer_priority bl,ar_cust_group grp,ar_customer cust,bl_blng_grp a,bl_patient_fin_dtls b "+
	 		" WHERE bl.patient_id ='"+patient_id+"' AND bl.episode_type = '"+episode_type+"' AND bl.cust_code IS NOT NULL AND bl.operating_facility_id = '"+facility_id+"' AND bl.cust_group_code = grp.cust_group_code AND bl.cust_code = cust.cust_code "+   
	   		" AND a.blng_grp_id = bl.blng_grp_id AND bl.patient_id = b.patient_id AND  bl.SETTLEMENT_IND = b.SETTLEMENT_IND and B.SETTLEMENT_IND = 'R' "+
			" UNION " + 
		"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
		"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date,A.SHORT_DESC short_desc "+
		"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust,bl_BLNG_GRP A ,bl_patient_fin_dtls b "+
		"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
		"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
		"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id AND A.BLNG_GRP_ID = BL.BLNG_GRP_ID "+
		"And bl.patient_id=b.patient_id  "+
		" UNION "+
	        "select nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,' ' Cust_Group_Code,'CASH' payer_group,' ' Cust_Code,' ' payer,' ' Policy_Type_Code,'CASH' policy_type,' ' Policy_Number,' ' Policy_Start_Date,' ' Policy_Expiry_Date ,' ' short_desc "+ 
			" From Bl_Encounter_Payer_Priority BL , bl_patient_fin_dtls b where bl.patient_id='"+patient_id+"' and bl.settlement_ind='C' "+
	        "and bl.patient_id=b.patient_id and b.settlement_ind='C' And Bl.Episode_Type ='"+episode_type+"'";	
	}
	}
//GHL- CRF-0550 --- PALANI NARAYANAN - ENDS
else
{	
	if(("I".equals(episode_type)) || ("D".equals(episode_type)) || ("O".equals(episode_type)) || ("E".equals(episode_type))){
		if(episode_id.length() > 0){
			sql =	"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
					"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date "+
					"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
					"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And upper(Bl.Episode_Id) Like upper('%"+episode_id+"%') "+
					"And Bl.Cust_Code Is Not Null "+
					"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
					"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id";
		}
		else{
			sql = "Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
					"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date "+
					"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
					"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
					"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
					"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id";

		}		
	}
	else if("R".equals(episode_type)){
		sql = "Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
				"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date "+
				"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
				"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
				"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
				"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id";
			
	}
}

%>	
</head>
<body>
	<br>
	<br>
	<table class='grid' border='1' width='95%' align="center">
	<tr>
		<td class='COLUMNHEADER' nowrap>
			<fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
		</td>
		<td class='COLUMNHEADER' nowrap>
			<fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>
		</td>
		<td class='COLUMNHEADER' nowrap>
			<fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/>
		</td>
		<td class='COLUMNHEADER' nowrap>
			<fmt:message key="Common.episodeid.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<%
	try{
		int rsCnt = 0;
		//con = ConnectionManager.getConnection(request);			
		
		pstmt = con.prepareStatement(sql);
		if("Y".equals(inParam)){
			pstmt.setString(1,episode_id);
		}
		rst = pstmt.executeQuery();
		if(rst != null){
		while(rst.next()){
		rsCnt++;
		%>
		<tr>
			<td>
			<% 
			if(siteSpecUploadDocAll)
			{ %>
				<a href="javascript:retuenPayerData('<%=checkForNull(rst.getString("Episode_Id1")) %>',
				'<%=checkForNull(rst.getString("Cust_Group_Code")) %>','<%=checkForNull(rst.getString("payer_group")) %>',
				'<%=checkForNull(rst.getString("Cust_Code")) %>','<%=checkForNull(rst.getString("payer")) %>','<%=checkForNull(rst.getString("Policy_Type_Code")) %>',
				'<%=checkForNull(rst.getString("policy_type")) %>','<%=checkForNull(rst.getString("Policy_Number")) %>',
				'<%=checkForNull(rst.getString("Policy_Start_Date")) %>','<%=checkForNull(rst.getString("Policy_Expiry_Date"))%>','<%=checkForNull(rst.getString("short_desc"))%>');"><%=rst.getString("policy_type") %></a>
			<% } else{ %>						
				<a href="javascript:retuenPayerData('<%=checkForNull(rst.getString("Episode_Id1")) %>',
				'<%=checkForNull(rst.getString("Cust_Group_Code")) %>','<%=checkForNull(rst.getString("payer_group")) %>',
				'<%=checkForNull(rst.getString("Cust_Code")) %>','<%=checkForNull(rst.getString("payer")) %>','<%=checkForNull(rst.getString("Policy_Type_Code")) %>',
				'<%=checkForNull(rst.getString("policy_type")) %>','<%=checkForNull(rst.getString("Policy_Number")) %>',
				'<%=checkForNull(rst.getString("Policy_Start_Date")) %>','<%=checkForNull(rst.getString("Policy_Expiry_Date"))%>');"><%=rst.getString("policy_type") %></a>						
			<% }%>
			</td>
			<td>
				<%=rst.getString("payer_group") %>
			</td>
			<td>
				<%=rst.getString("payer") %>
			</td>
			<td>
				<%=checkForNull(rst.getString("Episode_Id1")) %>
			</td>
		</tr>
		<%}
		}
		if(rsCnt<1){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Exception in AddModifyInsUpldImgPayerData -> "+e);
		}
		finally{
			//ConnectionManager.returnConnection(con);//Commented V211018
			pstmt = null;
			rst = null;
		}
	} catch(Exception ex) {   //V211018
		System.err.println("AddModifyInsUpldImgPayerData.jsp Exception:::"+ex);
		ex.printStackTrace();
	}  
	finally{
		ConnectionManager.returnConnection(con);
	} //V211018
	
	
	%>
	</table>
	<%! private String checkForNull(String inputString)
	{
		//return (inputString == null) ? "0000" :	inputString;
		return (inputString == null) ? "" :	inputString;	//Modified Against ICN:10055
	} %>
</body>
</html>

