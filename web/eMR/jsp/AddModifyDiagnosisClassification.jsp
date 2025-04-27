<!DOCTYPE html>
<!--
*	Copyright © ibaHealth Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Created By		:	Anjaneya R M 
*	Created On		:	8 aug 2008
-->
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<!-- JSP Page specific attributes end -->
<!--Mandatory declarations start-->
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<jsp:useBean id="DiagnosysSetBean" class="webbeans.eCommon.RecordSet" scope="request"/> 
<%-- Mandatory declarations end --%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="javascript" src="../js/DiagnosisClassification.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	 String locale=(String)session.getAttribute("LOCALE");

	 String mode=request.getParameter("mode");
	 String diagCode="";
	 String long_desc="";
	 String short_desc="";
	 String diag_class_type="";
	 String eff_status="";
	 /*Added by Maheshwaran for the SKR-CRF-0020 as on 04/05/2012*/
	/*Start*/
	 String default_status="";
	String default_status_chk="";
	String default_termset_value_j="";
	/*End*/
	 Connection con =null;
	PreparedStatement pstmt=null ;
	PreparedStatement pstmt1=null ;
	Statement stmt=null;
	//Statement stmt1=null;
	ResultSet reset=null;
	ResultSet reset1=null;
	
	String diagTypecode="";
	String shortdesc="";
	//boolean newVisitType=true;
	String termSetId=" ";

	//String checkValue="D";
	String checked="";

	int i=0;
	int j=0;

	int max_record=0;
	//String selected="selected";
	String CheckValue;
	
	 String readOnly=" ";
	 String readOnlyMod=" ";
	String status="checked";
	String disable="";
	String sql1="";
	String Display_TD_Default= "display:none;";
	try{
	con = ConnectionManager.getConnection(request);
	 if(mode.equals("modify"))
	 {
		readOnly="readonly";

		 diagCode=checkForNull(request.getParameter("diag_class_code"));
		 
		
		//con=ConnectionManager.getConnection(request);			
			/*Added by Maheshwaran for the SKR-CRF-0020 as on 07/05/2012*/
			/*Default Status Column was added in the select query*/
			sql1="select a.DIAG_CLASS_CODE ,a.LONG_DESC,a.SHORT_DESC,a.DIAG_CLASS_TYPE,a.EFF_STATUS,b.DEFAULT_STATUS  from mr_diag_class a ,mr_diag_class_dtl b where a.diag_class_code=? and a.diag_class_code=b.diag_class_code ";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,diagCode);
			//pstmt = con.prepareStatement("select a.DIAG_CLASS_CODE ,a.LONG_DESC,a.SHORT_DESC,a.DIAG_CLASS_TYPE,a.EFF_STATUS  from mr_diag_class a where a.diag_class_code='"+diagCode+"'  ");
			reset=pstmt.executeQuery();
			
			if( reset != null )
			{
			 
					while(reset.next( )){
						long_desc=reset.getString("long_desc")==null ? "":reset.getString("long_desc");
						short_desc=reset.getString("short_desc")==null ? "":reset.getString("short_desc");
						diag_class_type=reset.getString("diag_class_type")==null ? "":reset.getString("diag_class_type");
						eff_status=reset.getString("EFF_STATUS");
						/*Added by Maheshwaran for the SKR-CRF-0020 as on 04/05/2012*/
						/*Start*/
					/*	default_status=reset.getString("default_status");
						if(default_status.equals("Y"))
							{
							default_status_chk="Checked";
							}
						else
							{
							default_status_chk="";
							}*/
						/*End*/
						if(diag_class_type.equals("PD")){
							Display_TD_Default= "display:inline;";
						}
						if(eff_status.equals("E"))
						{
							status="checked";
							readOnlyMod=" ";
							 disable="";
						}
						else if(eff_status.equals("D")) 
						{
							status="";
							readOnlyMod="readonly";
							disable="disabled";

						}

					}
			 }
			
		 



	 }
	

	
	
%>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement()">
<form name="diagonlosis_form" id="diagonlosis_form" action="../../servlet/eMR.DiagnosisClassificationServlet" method="post" target="messageFrame">
<table border="0" cellpadding="5" cellspacing="0" width="90%" align='center'>
<tr>
      <td  class="label" width="50%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  class='fields' width='50%' >
      <input type="text" name="diag_class_code" id="diag_class_code"  value="<%=diagCode%>" size="10" maxlength="2" onBlur='ChangeUpperCase(this);' <%=readOnly%> onKeyPress="return CheckForSpecChars(event)" > <img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>

	<tr>
      <td class="label" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td  class='fields'><input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>" size="30" maxlength="30" <%=readOnlyMod%> onBlur='ValidString(this)' style='{ font-size: ;}' ><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

	<tr>
      <td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td class='fields' ><input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>" size="15" maxlength="15"  <%=readOnlyMod%> onBlur='ValidString(this)' ><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>


	<tr>
  <td  class="label" ><fmt:message key="Common.Classification.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
  <td  class="fields" >
	<!--Added by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012-->
	<!--Start-->
	<!--onchange condition was added-->
	<!-- <select name="diag_class_type" id="diag_class_type"  <%=disable%> onchange="ShowDefaultChkBox(diag_class_type,default_chkbox_id,default_status); CheckPrinipalDiag_TermSet(chk_TermSet_IdDig<%=i%>,default_termset_value<%=i%>,default_status,diag_class_type,'chk');"> --> 
	  <select name="diag_class_type" id="diag_class_type"  <%=disable%> onchange="ShowDefaultChkBox(diag_class_type);">
	 <!--<select name="diag_class_type" id="diag_class_type"  <%=disable%> >-->
	<!--End-->
	 <OPTION value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
		  <%
			//con=ConnectionManager.getConnection(request);
			//pstmt = con.prepareStatement("SELECT diag_class_type,description FROM   mr_diag_class_type ORDER BY 2 ");
			pstmt = con.prepareStatement("SELECT diag_class_type,description FROM   MR_DIAG_CLASS_TYPE_LANG_VW where LANGUAGE_ID = '"+locale+"' and  EFF_STATUS = 'E' ORDER BY 2 ");
			reset=pstmt.executeQuery();
			if( reset != null )
			{
			   while( reset.next() )
				{
					 diagTypecode = reset.getString( "diag_class_type" ) ;
					 shortdesc=reset.getString("description");
					 %>
					 <%
					 if(diagTypecode.equals(diag_class_type))
					{
						 out.println("<option value ='"+diag_class_type+"' selected>"+shortdesc);
					}else
					{
						 out.println("<option value ='"+diagTypecode+"'>"+shortdesc);
					}
					%>
					<%
				}
				
			}
			
		%>
	</select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>


<tr>
	<td  class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  class='fields' ><input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>" value="E" <%=status%> ></td>
</tr>
	<tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr></tr>
	<tr>
<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
<!--
<tr >
		<td  class="COLUMNHEADER" nowrap colspan='3'><fmt:message key="Common.Associate.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>
		</td>
		
		
	</tr>-->
	<tr>
			<td class="COLUMNHEADER"   nowrap width='60%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap width='20%'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap width='20%' id="tdDefaultHeader" style="<%=Display_TD_Default%>"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
			
	</tr>
	<%
	 
	String classValue		="";
	String termSet=" ";
	String termDec=" ";
	
	//String checkValue="D";
	String sql="";

	String sql2=" ";
	ArrayList Default_Value_Modify = new ArrayList();
	String Default_Value_Check="";
	String Enable_Default_Check="";
	sql="select term_set_id, term_set_desc from mr_term_set where DIAG_CLASS_APPL_YN='Y' and EFF_STATUS='E' order by 2";
	if(mode.equals("modify")){

		//sql="select a.term_set_id from mr_diag_class_dtl a,mr_diag_class b,mr_term_set c where 	b.DIAG_CLASS_CODE='"+diagCode+"'and DIAG_CLASS_APPL_YN='Y' and EFF_STATUS='E' order by 2";
         
		  //System.out.println("diagCode===>"+diagCode);
		 
		  sql2="SELECT  a.term_set_id,a.DEFAULT_STATUS  FROM mr_diag_class_dtl a, mr_diag_class b, mr_term_set c   WHERE b.diag_class_code =?  AND c.diag_class_appl_yn = 'Y' AND c.eff_status = 'E' AND a.diag_class_code=b.diag_class_code AND a.term_set_id=c.term_set_id ORDER BY 1";
			//System.err.println("sql2==>"+sql2);
			pstmt=con.prepareStatement(sql);
			reset 	= pstmt.executeQuery();

			//stmt=con.createStatement();
			pstmt1=con.prepareStatement(sql2);
			pstmt1.setString(1,diagCode);
			reset1 	= pstmt1.executeQuery();

			while(reset1.next()){
				if(reset1.getString("DEFAULT_STATUS").equals("Y")){
					Default_Value_Modify.add(reset1.getString("term_set_id"));
				}
				DiagnosysSetBean.putObject(reset1.getString("term_set_id"));
			}
			
			String originalTermId="";
			while(reset.next()){

				if ( j % 2 == 0 )
					  classValue = "QRYEVEN" ;
				   else
					  classValue = "QRYODD" ;

					originalTermId			= reset.getString("term_set_id");

					// System.out.println("DiagnosysSetBean==>1==>"+DiagnosysSetBean.containsObject(reset.getString("term_set_id")));
					
					// System.out.println("my id"+reset.getString("term_set_id"));
					if(DiagnosysSetBean.containsObject(reset.getString("term_set_id"))){ 
						checked="checked";
						CheckValue="E";
						Enable_Default_Check	= "";
						if(Default_Value_Modify.contains(originalTermId)){
							Default_Value_Check	= "checked";
						}else{
							Default_Value_Check	= "";
						}
				}
				else{
					checked=" ";
					CheckValue="D";
					Default_Value_Check	= "";
					Enable_Default_Check	= "disabled";
				}
			/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
			/*Start*/
			//This Method is created below in this page,it is used to get the default status of the Termset for Principal Diagnosis Type
			//"CheckPrinipalDiag_TermSet" function also added in the Termset checkbox field
			//default_termset_value hidden field also added
			//default_termset_value_j=CheckDefault(originalTermId,con);
			/*End*/
			%>
		<tr>
		
		<td  class='<%=classValue%>'  nowrap ><%=originalTermId%></td>
		<td  class='<%=classValue%>'  nowrap >
		<!--Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012-->
		<!--Start-->
		 <% //System.out.println("CheckValue2==>"+CheckValue);
		 //System.out.println("checked2==>"+checked);
		 
		 %>
		  <input type='checkbox' class='fields' name="chk_ModTermSet_IdDig<%=j%>" id="chk_ModTermSet_IdDig<%=j%>" value="<%=originalTermId%>" <%=checked%> id="AppTerset" onclick="FnEnableDefaultCheckbox(document);"></td>
		<!-- <input type='checkbox' class='fields' name="chk_ModTermSet_IdDig<%=j%>" id="chk_ModTermSet_IdDig<%=j%>" value="<%=CheckValue%>" <%=checked%> onClick='CheckPrinipalDiag_TermSet(chk_ModTermSet_IdDig<%=j%>,default_termset_value<%=j%>,default_status,diag_class_type,"chk")'></td> -->
		<!--End-->
		<!--<input type='checkbox' class='fields' name="chk_ModTermSet_IdDig<%=j%>" id="chk_ModTermSet_IdDig<%=j%>" value="<%=CheckValue%>" <%=checked%> ></td>-->
		<input type='hidden' name='originalTermId<%=j%>' id='originalTermId<%=j%>' value='<%=originalTermId%>' >
		<!--Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012
			Start-->
		<input type='hidden' name='default_termset_value<%=j%>' id='default_termset_value<%=j%>' value='<%=default_termset_value_j%>'>
		
		<!--End-->
		</td>
		<td  class='<%=classValue%>'  nowrap id="tdDefaultValues" style="<%=Display_TD_Default%>"> <input type="checkbox" name="chkdefault" id="chkdefault" id="chkdefault" value="<%=originalTermId%>" onclick="FnSelectOneCheckbox('<%=originalTermId%>','modify');"  <%=Default_Value_Check%> <%=Enable_Default_Check%>></td>
		<%	j++;
%>
	
	</tr>
			<%

				}
	}
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	reset 	= stmt.executeQuery(sql);
	reset.last();
	max_record = reset.getRow();
	reset.beforeFirst();
		if(mode.equals("insert")){
		if(reset!=null)
			{
				while(reset.next())
				{
					if ( i % 2 == 0 )
			  classValue = "QRYEVEN" ;
		   else
			  classValue = "QRYODD" ;
		    termSet=reset.getString("term_set_id");
			 termDec=reset.getString("term_set_desc");
			/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
			/*Start*/
			//This Method is created below in this page,it is used to get the default status of the Termset for Principal Diagnosis Type
			//"CheckPrinipalDiag_TermSet" function also added in the Termset checkbox field
			//default_termset_value hidden field also added
			default_termset_value_j=CheckDefault(termSet,con);
			/*End*/
		%>
	 <tr>
		
		<td  class='<%=classValue%>'  nowrap ><%=termSet%></td>
		<td  class='<%=classValue%>'  nowrap >
		<!--Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012-->
		<!--Start-->
		<!--<input type='checkbox' class='fields' name="chk_TermSet_IdDig<%=i%>" id="chk_TermSet_IdDig<%=i%>" value="" onClick="CheckPrinipalDiag_TermSet(chk_TermSet_IdDig<%=i%>,default_termset_value<%=i%>,default_status,diag_class_type,'chk')">  -->
		<input type='checkbox' class='fields' name="chk_TermSet_IdDig<%=i%>" id="chk_TermSet_IdDig<%=i%>" value="<%=termSet%>" id="AppTerset" onclick="FnEnableDefaultCheckbox(document);"> 
		</td>
		<!--End-->
		<!--<input type='checkbox' class='fields' name="chk_TermSet_IdDig<%=i%>" id="chk_TermSet_IdDig<%=i%>" value="" ></td>-->
		<input type='hidden' name='term_set<%=i%>' id='term_set<%=i%>' value='<%=termSet%>' >
		<!--Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
		--Start-->
		<input type='hidden' name='default_termset_value<%=i%>' id='default_termset_value<%=i%>' value='<%=default_termset_value_j%>'>
		<!--End-->
		</td>
		<td  class='<%=classValue%>'  nowrap id="tdDefaultValues"  style="<%=Display_TD_Default%>" > <input type="checkbox" name="chkdefault" id="chkdefault" id="chkdefault" value="<%=termSet%>" onclick="FnSelectOneCheckbox('<%=termSet%>','insert');" disabled></td>
	<%	i++;
%>
	
	</tr> 
<%

				}
			}	
		}
		


%>
</tr>
</table>
<%
if (reset != null) reset.close();
if (pstmt != null) pstmt.close();
if (pstmt1 != null) pstmt1.close();
if(stmt!=null) stmt.close();
if(reset1 !=null) reset1.close();
}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}finally{
    ConnectionManager.returnConnection(con,request);
}

%>
</tr>

	
</table>


<input type='hidden' name='tot_cnt' id='tot_cnt' value='<%=max_record%>'>
<input type='hidden' name='final_termSet' id='final_termSet' value='<%=termSetId%>'>
<!--<input type='hidden' name='final_ModTermSet' id='final_ModTermSet' value='<%=termSetId%>'>-->
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='diag_class_type1' id='diag_class_type1' value='<%=diag_class_type%>'>
<input type='hidden' name='defaulttermset' id='defaulttermset' id="defaulttermset" value=''>
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
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
	/*Start*/
	/*This Method is created to check the record exists for a TermSet as default for Principal Diagnosis Type in MR_DIAG_CLASS table*/
	public static String CheckDefault(String term_set_id,Connection con)
		{
		Statement chk_default_stmt = null;
		ResultSet chk_default_result = null;
		StringBuffer chk_default_buf=new StringBuffer();
		String default_termset_value="N";
		try
			{   
			 
			chk_default_buf.append("select * from  mr_diag_class_dtl a, mr_diag_class b where a.term_set_id='"+term_set_id+"' and b.diag_class_type='PD'  and a.default_status='Y' and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE ");
			chk_default_stmt=con.createStatement();
			chk_default_result 	= chk_default_stmt.executeQuery(chk_default_buf.toString());
			}
		catch(SQLException e)	
			{
			e.printStackTrace();
			System.out.println("Exception occurred while getting the count from mr_diag_class_dtl ,mr_diag_class table");
			}
		try
			{
			if(chk_default_result.next())
				{
				default_termset_value="Y";
				}
			chk_default_result.close();	
			chk_default_stmt.close();
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		finally
			{
			try
				{
				if(chk_default_stmt!=null)
				chk_default_stmt.close();
				}
			catch(Exception e)	
				{}
			}
		return default_termset_value;			
		}
		/*End*/
%>

