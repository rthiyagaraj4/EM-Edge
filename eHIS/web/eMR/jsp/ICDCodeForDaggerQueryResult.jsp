<!DOCTYPE html>
<%
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Asterisk Codes for Dagger Codes 
/// Developer		:	SRIDHAR R
/// Created On		:	1 DEC 2004
/// Function 		:   Used to associate Asterisk Codes for a selected Dagger Code...
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="accessLeftRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
     <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script language='javascript' src='../js/ICDCodeForTabList.js'></script>
	<script src='../../eMR/js/ICDCodeForDagger.js' language='javascript'></script>
    <script language=javascript>

	</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection Con = null;
	int initCount = 1;
	Statement stmt1		= null;
	ResultSet rstlRs1	= null;
	//Statement stmt2		= null;
	//ResultSet rstlRs2	= null;
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	try
	{
		Con = ConnectionManager.getConnection(request);
		String dagger_code = request.getParameter("dagger_code");
		if(dagger_code == null) dagger_code="";
	
		String selectedAlpha = request.getParameter("selectedAlpha");
		if(selectedAlpha == null) selectedAlpha="";

		String scheme = request.getParameter("scheme");
		if(scheme == null) scheme="";

		String flagSelect = request.getParameter("fromSelect");
		if(flagSelect !=null)
		{
			accessRightRecSet.clearAll();
			accessLeftRecSet.clearAll();
		
			String sqlinsVals= " SELECT astk_diag_srl_no diag_srl_no, astk_diag_code diag_code, astk_short_desc short_desc FROM mr_icd_code_dtl_vw WHERE dag_diag_code = '"+dagger_code+"' ";
			stmt3=Con.createStatement();
			rstlRs3 = stmt3.executeQuery(sqlinsVals);
			if(rstlRs3 !=null)
			{
				while(rstlRs3.next())
				{
					accessRightRecSet.putObject(rstlRs3.getString(1));
					accessLeftRecSet.putObject(rstlRs3.getString(2));
				}
			}
		}
//		int recordCount			=	0;
		String  req_start   =   "", req_end     =   "";
		String  checkedOnes         =   "";
		String  checkedOnesCode         =   "";
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;

		if(from == null)
			start = 1 ;  
		else 
			start = Integer.parseInt(from); 

		if(to == null)
			end = 12 ; 
		else 
			end = Integer.parseInt(to); 
		
		req_start = request.getParameter("start");
			if(req_start== null) req_start = "0";

		req_end =   request.getParameter("end");
			if(req_end== null) req_end = "0";

		if(from != null && to != null)
		{
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			{
				if(request.getParameter("astk_diag_srl_no"+(i)) != null)
				{
					checkedOnes = request.getParameter("astk_diag_srl_no"+(i));
					checkedOnesCode = request.getParameter("astk_diag_code"+(i));
					if(!(accessRightRecSet.containsObject(checkedOnes)))
					{
						accessRightRecSet.putObject(checkedOnes);
						accessLeftRecSet.putObject(checkedOnesCode);

					}
					j++;
				}
			}
			out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
			out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
		}

		i = 1 ;
		//String sqlCount="";

		/*if(selectedAlpha.equals("Others"))
		{
			sqlCount=" select count(*) from MR_ICD_CODE where eff_status = 'E' and DIAG_CODE_SCHEME = '"+scheme+"' and code_indicator = 'A' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' ";
		}
		else
		{
			sqlCount=" SELECT count(*) from MR_ICD_CODE where eff_status = 'E' and DIAG_CODE_SCHEME = '"+scheme+"' and code_indicator = 'A' and UPPER (short_desc) like '"+selectedAlpha+"%' ";
		}


		stmt2	= Con.createStatement();
		rstlRs2 = stmt2.executeQuery(sqlCount);
		rstlRs2.next();
		maxRecord = rstlRs2.getInt(1);*/
		String sql="";

		if(selectedAlpha.equals("Others"))
		{
			sql=" select diag_code ,short_desc, diag_srl_no from mr_icd_code where eff_status = 'E' and DIAG_CODE_SCHEME = '"+scheme+"' and code_indicator = 'A' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' ";
		}
		else
		{
			sql=" SELECT diag_code ,short_desc,diag_srl_no from mr_icd_code where eff_status = 'E' and DIAG_CODE_SCHEME = '"+scheme+"' and code_indicator = 'A' and UPPER (short_desc) like '"+selectedAlpha+"%' ";
		}

		//stmt1 = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt1 = Con.createStatement();
		rstlRs1 = stmt1.executeQuery(sql);

//out.println("Final SQL : "+sql);

		if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rstlRs1.next() ;
			}
			initCount+=start;
			--initCount;
		}

	//while(i<=end && rstlRs1.next()) 
		//{

	if (maxRecord==0)
			{
	%>


	<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();" onKeyDown='lockKey()'>
	<form name='tablistQueryResult' id='tablistQueryResult' method="post" action="../../eMR/jsp/ICDCodeForDaggerQueryResult.jsp"   >
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<th width='100%'>&nbsp;</th>
	<tr>
		<td colspan='4'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:callMember('A')">A</a>&nbsp;&nbsp;<a href="javascript:callMember('B')">B</a>&nbsp;&nbsp;<a href="javascript:callMember('C')">C</a>&nbsp;&nbsp;<a href="javascript:callMember('D')">D</a>&nbsp;&nbsp;<a href="javascript:callMember('E')">E</a>&nbsp;&nbsp;<a href="javascript:callMember('F')">F</a>&nbsp;&nbsp;<a href="javascript:callMember('G')">G</a>&nbsp;&nbsp;<a href="javascript:callMember('H')">H</a>&nbsp;&nbsp;<a href="javascript:callMember('I')">I</a>&nbsp;&nbsp;<a href="javascript:callMember('J')">J</a>&nbsp;&nbsp;<a href="javascript:callMember('K')">K</a>&nbsp;&nbsp;<a href="javascript:callMember('L')">L</a>&nbsp;&nbsp;<a href="javascript:callMember('M')">M</a>&nbsp;&nbsp;<a href="javascript:callMember('N')">N</a>&nbsp;&nbsp;<a href="javascript:callMember('O')">O</a>&nbsp;&nbsp;<a href="javascript:callMember('P')">P</a>&nbsp;&nbsp;<a href="javascript:callMember('Q')">Q</a>&nbsp;&nbsp;<a href="javascript:callMember('R')">R</a>&nbsp;&nbsp;<a href="javascript:callMember('S')">S</a>&nbsp;&nbsp;<a href="javascript:callMember('T')">T</a>&nbsp;&nbsp;<a href="javascript:callMember('U')">U</a>&nbsp;&nbsp;<a href="javascript:callMember('V')">V</a>&nbsp;&nbsp;<a href="javascript:callMember('W')">W</a>&nbsp;&nbsp;<a href="javascript:callMember('X')">X</a>&nbsp;&nbsp;<a href="javascript:callMember('Y')">Y</a>&nbsp;&nbsp;<a href="javascript:callMember('Z')">Z</a>&nbsp;&nbsp;<a href="javascript:callMember('Others')"><fmt:message key="Common.others.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;</td>
	</tr>
	</table>
	<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
	<tr>
		<td class="white">
		<table border='0' align='right'>
			<tr>
				
				<%	
					if(!(start <= 1)) 
					{	%><td align ='right' id='prev'>
						<a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'>Previous</a></td>
				<%	}
					//if(!((start+12) > maxRecord ))
						%><td align ='right' id='next' style='visibility:hidden'>
						<a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'>Next</a></td>
				<%		%>
				
			</tr>
		</table>
		</td>
	</tr>	
	<tr>
	<td>
	<table  align='center' cellpadding=0 cellspacing=0 border=1 width='100%'>
		<tr id='header'>
			<th nowrap><fmt:message key="eMR.AsteriskCode.label" bundle="${mr_labels}"/></th>
			<th><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</tr>
	<% 
	}
		String classValue = "" ;
		String diag_srl_no="";
//		recordCount =	accessRightRecSet.getSize();
		String chkAttribute="";

		/*if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rstlRs1.next() ;
			}
			initCount+=start;
			--initCount;
		}*/

		//while(rstlRs1.next() && i<=end ) 
		//{
		while(i<=end && rstlRs1.next()) 
		{

			diag_srl_no = rstlRs1.getString(3);
			
			if(accessRightRecSet.containsObject(diag_srl_no))  
				chkAttribute = "CHECKED";
			else
				chkAttribute="";
			
			int recordIndex = accessRightRecSet.indexOfObject(diag_srl_no);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    
			{
				accessRightRecSet.removeObject(recordIndex);
				accessLeftRecSet.removeObject(recordIndex);
			}
			
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			out.println("<tr>");
			out.println("<td class='"+classValue+"' width='5%' >"+rstlRs1.getString(1)+"</td>");
			out.println("<td class='"+classValue+"' width='90%'>"+rstlRs1.getString(2)+"</td>");
			out.println("<td align='center' width='5%' class='"+classValue+"'><input type='checkbox'  "+chkAttribute+" name='astk_diag_srl_no"+initCount+"' id='astk_diag_srl_no"+initCount+"' value='"+diag_srl_no+"'     </td>");
			out.println("</tr>");
			out.println("<input type='hidden'  "+chkAttribute+" name='astk_diag_code"+initCount+"' id='astk_diag_code"+initCount+"'  value='"+rstlRs1.getString(1)+"'>");
			out.println("</tr>");
			i++;
			initCount++;
			maxRecord++;
		} 

			
			if ( maxRecord < 12 || (!rstlRs1.next()) )
			{
				%>
				<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
				</script>
				<% 
			}
			else
			{%>
				<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='visible';
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%
			}
	%>
			<input type='hidden' name='dagger_code' id='dagger_code' value='<%=dagger_code%>' >
			<input type='hidden' name='selectedAlpha' id='selectedAlpha' value='<%=selectedAlpha%>' >
			<input type=hidden name=from value='<%=start%>'>
			<input type=hidden name=to value='<%=end%>'>
			<input type=hidden name='start' id='start' value='<%=start%>'>
			<input type=hidden name='end' id='end' value='<%=end%>'>
			<input type=hidden name='scheme' id='scheme' value='<%=scheme%>'>
		</table>
		</td>
	</tr>
	</table>
</form>
</body>
</html>
<%  }catch(Exception e)
	{
        //out.println("Error in displaying the records "+e);
		e.printStackTrace();
    }finally
	{
		try
		{
		if(rstlRs1 != null) rstlRs1.close(); 
		if(stmt1 != null)	stmt1.close(); 
		//if(rstlRs2 != null) rstlRs2.close(); 
		//if(stmt2 != null)	stmt2.close(); 
		if(rstlRs3 != null)	rstlRs3.close();
		if(stmt3 != null)	stmt3.close(); 
		}
		catch(Exception e)
	{
			//out.println("Exception @ try "+e.toString());
			e.printStackTrace();
    }
		session.setAttribute("AXSRightRecSet", accessRightRecSet);
		session.setAttribute("AXSLeftRecSet", accessLeftRecSet);
		ConnectionManager.returnConnection(Con,request);
	}
%>
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

