<!DOCTYPE html>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@page   import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
//	String DB_term_code_associated_str = request.getParameter("Db_term_code")==null?"":request.getParameter("Db_term_code");
	String DB_Term_code_Exisits = request.getParameter("Db_term_code")==null? "N" :"Y";
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/TerminologyGroup.js"></script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	window.onload=function(){
			if(document.getElementById("term_associated")!=null)			
				fxheaderInit('term_associated',210);
			else
				document.getElementById("term_associated_div").style.display='none';
		};
	</script>

</head>
<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		
	String mode = request.getParameter("mode");
//	String function_id = request.getParameter("function_id");
	String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");

	String term_set = request.getParameter("term_set")==null?"":request.getParameter("term_set");
	//String term_code_associated_str = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated");

	
	String level1 = request.getParameter("level")==null?"0":request.getParameter("level") ;

	String term_group_id=request.getParameter("term_group_id");
	String term_set_id=request.getParameter("term_set_id");
	String status_yn=request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
	String indextype_yn=request.getParameter("indextype_yn")==null?"":request.getParameter("indextype_yn");
	StringBuffer DB_term_code_associated = new StringBuffer();
	StringBuffer term_code_associated = new StringBuffer();
	StringBuffer term_code_associated1 = new StringBuffer();
	StringBuffer DB_term_code_associated1 = new StringBuffer();
	String classvalue="", checked = "";
	int db_count=0;
	String returnVal  =request.getParameter("returnVal")==null?"":request.getParameter("returnVal") ;
	String tag = "",tag1="";
	String checkbox="";
	StringBuffer temp_db_chk = new StringBuffer("");
	StringBuffer temp_term_code = new StringBuffer("");
	StringBuffer sr_nos= new StringBuffer("");
	StringBuffer sr_nos1= new StringBuffer("");
	String temp_no="";
	int cnt=0;
	if(status_yn.equals("D"))
		checkbox="disabled";
	else
		checkbox="enabled";

	boolean mode_flag=false;

		Connection con = null;
		PreparedStatement pstmt_code = null;
		ResultSet rs_code = null;
		PreparedStatement pstmt_code1 = null;
		ResultSet rs_code1 = null;
		String temp="";
		String code_level_desc="";
		String returnVal1="";
	mode_flag = false;
	StringBuffer term_code_buf= new StringBuffer();
	con = ConnectionManager.getConnection(request);
	StringTokenizer stoken2=new StringTokenizer(returnVal,"$");
	if(stoken2.hasMoreTokens()){
	returnVal1= stoken2.nextToken();
	term_group_id= stoken2.nextToken();
	term_set_id= stoken2.nextToken();	
	}
	StringBuffer returnVa2= new StringBuffer();
	returnVa2.append(returnVal1);
	if(!returnVal1.equals(""))
		{		
			StringTokenizer stoken1=new StringTokenizer(returnVal1,"~");
			int j=1;
			cnt=stoken1.countTokens();
			while(stoken1.hasMoreTokens())
				{
				if(j!=cnt)
				term_code_buf.append("'"+stoken1.nextToken()+"',");
				else
				term_code_buf.append("'"+stoken1.nextToken()+"'");
				j++;
				}
			try
			{
			StringBuffer s1=new StringBuffer();
			s1.append(" select b.TERM_CODE,b.short_desc term_code_desc,b.code_level code_level,DECODE (b.code_level,'1', level_1_desc,'2', level_2_desc, ");
            s1.append(" '3', level_3_desc,'4', level_4_desc,'5', level_5_desc,'6', level_6_desc,'7', level_7_desc,'8', level_8_desc,'9', level_9_desc,'10', level_10_desc ) code_level_desc " );
			s1.append(" FROM  mr_term_set a, mr_term_code b where  b.TERM_CODE in ("+term_code_buf.toString()+") AND a.term_set_id = b.term_set_id and b.term_set_id='"+term_set_id+"' ");
			pstmt_code1 = con.prepareStatement(s1.toString());
			rs_code1=pstmt_code1.executeQuery();
			while(rs_code1.next())
				{
			    level1=rs_code1.getString("code_level");
				code_level_desc=checkForNull(rs_code1.getString("code_level_desc"));
				if(code_level_desc.equals(""))
					code_level_desc = "||";
				temp = rs_code1.getString("term_code")+"~"+level1+"~"+code_level_desc+"~"+rs_code1.getString("term_code_desc")+"`";
				temp_db_chk.append(rs_code1.getString("term_code")+"~");
				sr_nos1.append("~");
				if(term_code_associated.indexOf(temp) == -1)
				{
//				DB_term_code_associated1 += temp ;
				DB_term_code_associated1.append(temp);
				db_count++;
				}
			mode_flag =true;
		}
	//	 if (DB_Term_code_Exisits == "N")
		//{
//			term_code_associated = DB_term_code_associated + term_code_associated;
			term_code_associated1.append(DB_term_code_associated1);
	//	}
		}
		catch(Exception e)
			{
			System.err.println("Exception e**********"+ e );
			}
		 if ( rs_code1 !=null ) rs_code1.close();
	  if ( pstmt_code1 !=null ) pstmt_code1.close();
			}
	if(mode.equals("2"))
	{
		tag = "<B>";tag1="</B>";
		String sql_code = "select a.TERM_CODE term_code, c.SHORT_DESC term_code_desc, c.CODE_LEVEL code_level, Decode(c.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC, '3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC , '6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,  '9',LEVEL_9_DESC ,'10',LEVEL_10_DESC ) code_level_desc, ORDER_SRL_NO order_no from MR_TERM_GROUP_DTL a, mr_term_set b,mr_term_code c where   a.term_set_id = b.term_set_id and b.term_set_id = c.term_set_id and a.term_code  = c.term_code and a.term_group_id like upper(?) and a.TERM_SET_ID like upper(?)";
		
	
		
		pstmt_code = con.prepareStatement(sql_code);
		pstmt_code.setString(1,term_group_id);
		pstmt_code.setString(2,term_set_id);
		rs_code=pstmt_code.executeQuery();
		
//		String DB_term_code_associated="";

		/*String temp="";
		String code_level_desc="";
		mode_flag = false;*/
		while(rs_code.next())
		{
		    level1=rs_code.getString("code_level");
			code_level_desc=checkForNull(rs_code.getString("code_level_desc"));
			if(code_level_desc.equals(""))
				code_level_desc = "||";
			temp = rs_code.getString("term_code")+"~"+level1+"~"+code_level_desc+"~"+rs_code.getString("term_code_desc")+"`";
			temp_db_chk.append(rs_code.getString("term_code")+"~");
//			sr_nos+=rs_code.getString("order_no")+"~";
			sr_nos.append(rs_code.getString("order_no")+"~");

			if(term_code_associated.indexOf(temp) == -1)
			{
//				DB_term_code_associated += temp ;
				DB_term_code_associated.append(temp);
				db_count++;
			}
			mode_flag =true;
		}

	
	  if ( rs_code !=null ) rs_code.close();
	  if ( pstmt_code !=null ) pstmt_code.close();
	  if(returnVal.equals(""))
		{
//			term_code_associated = DB_term_code_associated + term_code_associated;
			term_code_associated.append(DB_term_code_associated);
		}
		else
			{
			term_code_associated=DB_term_code_associated;
			}
		}
	sr_nos.append(sr_nos1);
	term_code_associated.append(term_code_associated1);
	StringTokenizer stoken=new StringTokenizer(term_code_associated.toString(),"`");
	cnt=stoken.countTokens();
	  try{
		if (con != null) ConnectionManager.returnConnection(con,request);
	  }
	  catch(Exception e)
	  {
		out.println("Exception "+e.toString());
	  }

	if(mode_flag && mode.equals("2"))
	{
			session.putValue("db_count",String.valueOf(db_count));
			session.putValue("sr_nos",sr_nos.toString());
	}
	else if(!mode.equals("2"))
	{
		session.putValue("db_count",String.valueOf(0));
					session.putValue("sr_nos","");
	}

	if(!mode_flag)
			db_count=Integer.parseInt((String)session.getValue("db_count"));

	if(sr_nos==null || (sr_nos.toString()).equals(""))
	{
		String s_tmp = (String)session.getValue("sr_nos")==null?"":(String)session.getValue("sr_nos");
		sr_nos.append(s_tmp);
	}
	
%>

	<form name='term_code_associated' id='term_code_associated' method='post' target='messageFrame' action='../../servlet/eMR.TerminologyGroupServlet'>
	<!--Maheshwaran K has added div and width added in <td> for PMG2014-MOD-CRF-0004(ENM-139) as on 29/1/2015-->
		<div  id="term_associated_div" style="position:relative;width:100%;height:300px;overflow:auto;vertical-align:top;"> 
		<table style='border-spacing:0px ;border-collapse: collapse;' width="100%"  id='term_associated'>
		<tr align='left'>
			<td width='20%' border="0" class="COLUMNHEADER" style="background-color: black; color: white;"><fmt:message key="eMR.TerminologyCodeAssociated.label" bundle="${mr_labels}"/><br><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
			<td width='20%' border="0" class="COLUMNHEADER" style="background-color: black; color: white;"><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
			<td width='35%' class="COLUMNHEADER" style="background-color: black; color: white;"><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></td>
			<td width='15%' class="COLUMNHEADER" style="background-color: black; color: white;"><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
			<td width='10%' class='COLUMNHEADERCENTER' style="background-color: black; color: white;"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr><%
	
	if(cnt>0)
	{
		String display="display:none";String term_assc_temp="";
		String term_code="",level="",term_code_desc="",level_code_desc="";
		int tmp_level=0;
		//int i=0;
		/*while(rs_code.next())
			{
			term_code=rs_code.getString("term_code");
			term_code_desc=checkForNull(rs_code.getString("term_code_desc"));
			level_code_desc=checkForNull(rs_code.getString("code_level_desc"));
			//code_level_desc=checkForNull(rs_code.getString("code_level"));*/
		StringTokenizer token_no=null;
		if(sr_nos!=null || !(sr_nos.toString()).equals(""))
			token_no= new StringTokenizer(sr_nos.toString(),"~");
		
		for(int i=0;i<cnt;i++)
		{
			display ="";
			if(stoken.hasMoreTokens())
			{
				term_assc_temp=stoken.nextToken();
				
				
				StringTokenizer token= new StringTokenizer(term_assc_temp,"~");
				term_code=token.nextToken();
				if(token.hasMoreTokens())
				{
					level=token.nextToken();
					if(level.equals("||"))
						level="";
				}

				if(token.hasMoreTokens())
				{
					level_code_desc=token.nextToken();
					if(level_code_desc.equals("||"))
						level_code_desc="";
				}

				if(token.hasMoreTokens())
					term_code_desc=token.nextToken();
//				temp_term_code +=term_code+"~";
				temp_term_code.append(term_code+"~");
				
				if(!level.equals("") && tmp_level < Integer.parseInt(level))
					tmp_level = Integer.parseInt(level);

				
			}

			if(token_no!=null && !(sr_nos.toString()).equals("") && token_no.hasMoreTokens())
				temp_no=token_no.nextToken();
			else
			{
				temp_no="";
			}

			if(i<db_count)
			{
				//tag = "<B>";tag1="</B>";
				tag = "";tag1="";
				checked="checked";
			}
			else
			{
				tag = "";tag1="";
				checked="checked";
			}
			
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	
%>
		<tr style='<%=display%>' id='term_set_tr<%=i%>'>
		
			<td  id='Level<%=i%>'  class="<%=classvalue%>"><%=tag%><%=level_code_desc%><%=tag1%></td>

			<td   id='term_code<%=i%>'  class="<%=classvalue%>" id='term_set<%=i%>'><%=tag%><%=term_code%><%=tag1%></td>

			<td   id='term_code_desc<%=i%>'  class="<%=classvalue%>" id='term_code_desc<%=i%>'><%=tag%><%=term_code_desc%><%=tag1%></td>

			<td   id='term_sn<%=i%>'  class="<%=classvalue%>"><%=tag%>
				<input type="text" size='3' maxLength='3' name="term_sn<%=i%>" id="term_sn<%=i%>" onkeypress="return allowPositiveNumber()" onBlur="CheckPositiveNumber(this)" <%=checkbox%> value='<%=temp_no%>'>
				<%if(i==0)
				{%>
					<img src="../../eCommon/images/mandatory.gif"> </img>
				<%}%>
			</td>


			<td   align='center' class="<%=classvalue%>"><input type="checkbox" name="term_chk<%=i%>" id="term_chk<%=i%>" value="Y" <%=checked%> <%=checkbox%>></td>
		</tr>
			<input type="hidden" name="term_code<%=i%>" id="term_code<%=i%>" value="<%=term_code%>">
			<input type="hidden" name="code_level<%=i%>" id="code_level<%=i%>" value="<%=level%>">	
<%
	}
}
 if ( rs_code !=null ) rs_code.close();
	  if ( pstmt_code !=null ) pstmt_code.close();
		//if(mode.equals("2") || db_count!=0)
		if(mode.equals("2"))
		{%>		
		<input type="hidden" name="fun" id="fun" value="modify">
		<%
		}
		else
		{%>
		<input type="hidden" name="fun" id="fun" value="insert">
<%		}%>
</tr>
</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="function_id" id="function_id" value="">
	<input type="hidden" name="count" id="count" value="<%=cnt%>">
	<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
	<input type="hidden" name="term_set_id" id="term_set_id" value="<%=term_set%>">
	<input type="hidden" name="term_group_id" id="term_group_id" value="<%=term_group_id%>">
	<input type="hidden" name="temp_term_code" id="temp_term_code" value="<%=temp_term_code.toString()%>">
	<input type="hidden" name="term_code_associated" id="term_code_associated" value="<%=term_code_associated.toString()%>">
	<input type="hidden" name="DB_term_code_associated" id="DB_term_code_associated" value="<%=DB_term_code_associated.toString()%>">
	<input type="hidden" name="db_tot" id="db_tot" value="<%=db_count%>">
	<input type="hidden" name="indextype_yn" id="indextype_yn" value="<%=indextype_yn%>">
	<input type='hidden' name='count1' id='count1' value='<%=(cnt-1)%>'>
	<input type='hidden' name='returnVal1' id='returnVal1' value='<%=returnVal1%>'>
</form>

</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

