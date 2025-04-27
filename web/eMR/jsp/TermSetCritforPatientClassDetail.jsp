<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Janet George
*	Created On		:	6 Jan 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*, eMR.*,java.net.*, eCommon.Common.*,com.ehis.eslp.*,   webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../js/TermSetCritforPatientClass.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='detail_form' id='detail_form' action='../../servlet/eMR/TermSetCritforPatientClassServlet'  method='post'>
 <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
 int totalRecords=0;
 int totalRecords1=0;
 String criteria ="";
 String criteria1 ="";
	String List_val ="";
String criteria2 =  checkForNull(request.getParameter("criteria"));
criteria = criteria2.toUpperCase();

String List_val1 =  checkForNull(request.getParameter("List_val"));
List_val = List_val1.toUpperCase();

String accuracy_code =  checkForNull(request.getParameter("add_List"));
StringBuffer whereClause = new StringBuffer();
StringBuffer sql2 = new StringBuffer();

	if(accuracy_code==null){ 
	accuracy_code = "";}
		
	String[] record=null;
	String[] pat_class1=null;
	String db_action="";
	String classvalue="";
	Connection conn=null;
	PreparedStatement pstmt=null;
	//Statement stmt1=null;
	PreparedStatement stmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ArrayList AccuracyList=new ArrayList();
	ArrayList patClassArray=new ArrayList();
	String default_val = "";
	String patient_class= "";


	
	String accuracy_code1 ="";
	String patient_class1 ="";
	
	Boolean isEncounterStage = false;//Added by KAMATCHI S for ML-MMOH-CRF-1581


	try
	{
		conn = ConnectionManager.getConnection(request);
		isEncounterStage =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","TERM_RECODE_DIAG"); //Added by KAMATCHI  S for ML-MMOH-CRF-1581

		//String sql1="select patient_class, long_desc patient_class_desc,'I' db_action from am_patient_class where patient_class not in (select patient_class from mr_accuracy_for_pat_class where accuracy_code =?) union all select a.patient_class patient_class,    b.long_desc patient_class_desc, 'U' db_action from mr_accuracy_for_pat_class a, am_patient_class b where a.accuracy_code = ? and b.patient_class = a.patient_class order by patient_class";

		if(!criteria.equals(""))
			whereClause.append("  a.criteria ='"+criteria+"'");

		if(!List_val.equals(""))
			whereClause.append("  and a.list_value ='"+List_val+"'");

		if(!accuracy_code.equals(""))
			whereClause.append(" and a.accuracy_code ='"+accuracy_code+"'");

		




		String sql1="select patient_class, long_desc patient_class_desc,'' criteria,'' list_value,'N' dflt_value_yn, 'I' db_action from am_patient_class where patient_class not in (select patient_class from mr_term_set_crit_for_pc a where "+whereClause+") union all select a.patient_class patient_class,b.long_desc patient_class_desc,a.criteria criteria,a.list_value list_value,a.dflt_value_yn dflt_value_yn,'U' db_action from mr_term_set_crit_for_pc a, am_patient_class b where b.patient_class = a.patient_class and "+whereClause+" order by patient_class";
		
		pstmt = conn.prepareStatement(sql1);
		rs = pstmt.executeQuery();
		while(rs!= null && rs.next())
		{	
			patient_class = rs.getString("patient_class");
			record=new String[9];
			record[0]=rs.getString("patient_class");
			record[1]=rs.getString("patient_class_desc");
			record[2]=rs.getString("criteria");
			record[4] = rs.getString("list_value");
			record[5] = rs.getString("dflt_value_yn");
			record[6] = rs.getString("db_action");
			record[7] = accuracy_code;
			
			AccuracyList.add(record);
			}

	} catch ( Exception e )	
			{
				e.printStackTrace();
				throw e ;
			} finally 
				{
					//conn.close();
					rs.close() ;
					pstmt.close() ;
					//ServiceLocator.getInstance().returnConnection(conn,request);
				}

		totalRecords=AccuracyList.size();


if(totalRecords == 0)
		{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
else{
%>
	
			<table align='center' cellspacing='0' cellpadding='0' border='1' width='90%'>
			<tr>
				<td class="COLUMNHEADER"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				<td class="COLUMNHEADER"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
			</tr>
<%
	String select="";
	String checked="";
	String select1="";
	String checked1="";
	String disabled1="";
	//String disabled2="";
	String dflt_value_yn2="";
	pat_class1=new String[5];
	int j=0;
	
		sql2.append("SELECT PATIENT_CLASS FROM  MR_TERM_SET_CRIT_FOR_PC WHERE CRITERIA=? AND ");

		//if(criteria1.equals("Accuracy"))
		//sql2.append(" LIST_VALUE='"+List_val+"' AND ");

		sql2.append(" DFLT_VALUE_YN='Y'");
		

	//String pat_class="";
	//stmt1 = conn.createStatement();
	stmt1 = conn.prepareStatement(sql2.toString());
	stmt1.setString(1,criteria);
	rs1 = stmt1.executeQuery();
	while(rs1!= null && rs1.next())
	{

		pat_class1[j]=rs1.getString("PATIENT_CLASS");
		
		j++;
			patClassArray.add(pat_class1);


	}
	totalRecords1=patClassArray.size();



		rs1.close() ;
		stmt1.close() ;
					

	
	conn.close();
	ServiceLocator.getInstance().returnConnection(conn,request);


	for(int i=0;i<totalRecords;i++){
		disabled1="";
	if(i%2==0) 
				classvalue="QRYEVEN";
			else 
				classvalue="QRYODD";
			record=(String[])AccuracyList.get(i);
			db_action=record[6];
			criteria1=record[2];
			if(criteria1 == null)
				criteria1="";
			List_val1=record[4];
			accuracy_code1=record[7];
			patient_class1=record[0];
			if(patient_class1 == null)
				patient_class1="";
			dflt_value_yn2=record[5];
			

			for(int z=0;z<totalRecords1;z++){
			
				pat_class1=(String[])patClassArray.get(z);
				String pc1ass=pat_class1[z];

				
			

			if(patient_class1.equals(pc1ass))
				{
					if(!dflt_value_yn2.equals("Y"))
						disabled1 = "disabled";
					
				}

				}
				
				
			

			select="";
			checked="";
			
				

				if(db_action.equals("U")){
					checked="checked";
					select="Y";
				}
				else{
					checked="";
					select="N";					
				}

				default_val=record[5];
				
				if(default_val.equals("Y"))
				{
					checked1="checked";
					select1="Y";
				}
				else
				{
					checked1="";
					select1="N";

					
				}
				
		//}
				
%>
			<tr>
					<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value='<%=record[0]%>'>
					<input type='hidden' name='db_action<%=i%>' id='db_action<%=i%>' value='<%=db_action%>'>
					<td class=<%=classvalue%>><%=record[1]%></td>
					<%

	if(criteria.equals("ENCOUNTER_STAGE"))
		{
		if(!patient_class1.equals("IP") && isEncounterStage && !patient_class1.equals("DC"))//Added for ML-MMOH-CRF-1581 by KAMATCHI S
        {%>
			<td align='center' class=<%=classvalue%>><input type="checkbox" name='select_yn<%=i%>' id='select_yn<%=i%>' value=''    disabled onClick=""></td>
			<td align='center' class=<%=classvalue%>><input type="checkbox" name='default_yn<%=i%>' id='default_yn<%=i%>' value='' disabled  ></td>
        <%}else if(!patient_class1.equals("IP") && !isEncounterStage )//Condition changed for ML-MMOH-CRF-1581 by KAMATCHI S
         {%>
			<td align='center' class=<%=classvalue%>><input type="checkbox" name='select_yn<%=i%>' id='select_yn<%=i%>' value=''    disabled onClick=""></td>
			<td align='center' class=<%=classvalue%>><input type="checkbox" name='default_yn<%=i%>' id='default_yn<%=i%>' value='' disabled  ></td>
         <%}else
		{%>
			<td align='center' class=<%=classvalue%>><input type="checkbox" name='select_yn<%=i%>' id='select_yn<%=i%>' value='<%=select%>' <%=checked%>  onClick="chk1(select_yn<%=i%>,<%=i%>);"></td>
			<td align='center' class=<%=classvalue%>><input type="checkbox" name='default_yn<%=i%>' id='default_yn<%=i%>' value='<%=select1%>' <%=checked1%> <%=disabled1%> onClick="chk2(default_yn<%=i%>,<%=i%>);" ></td>
			
		<%}}
		else
		{%>
			<td align='center' class=<%=classvalue%>><input type="checkbox" name='select_yn<%=i%>' id='select_yn<%=i%>' value='<%=select%>' <%=checked%>  onClick="chk1(select_yn<%=i%>,<%=i%>);"></td>
					<td align='center' class=<%=classvalue%>><input type="checkbox" name='default_yn<%=i%>' id='default_yn<%=i%>' value='<%=select1%>' <%=checked1%> <%=disabled1%> onClick="chk2(default_yn<%=i%>,<%=i%>);" ></td>
				
		<%}
	}

%>
</tr>
		</table>
<%}%>
<input type='hidden' name='accuracy_code' id='accuracy_code' value='<%=accuracy_code%>'>
<input type='hidden' name='total_records' id='total_records' value='<%=totalRecords%>'>
<input type='hidden' name='criteria' id='criteria' value='<%=criteria%>'>
<input type='hidden' name='list_value' id='list_value' value='<%=List_val%>'>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

