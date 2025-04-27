<!DOCTYPE html>
<!-- Modified 9/21/2005 -->
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@page   import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String bLvl_In_DB =( (request.getParameter("bLvl_In_DB")== null )|| (request.getParameter("bLvl_In_DB").equals("null")) || (request.getParameter("bLvl_In_DB").equals(""))) ? "N" : request.getParameter("bLvl_In_DB") ;
	String DB_term_code_associated_str = request.getParameter("DB_term_code")==null?"":request.getParameter("DB_term_code");
	String DB_Term_code_Exisits = request.getParameter("DB_term_code")==null? "N" :"Y";
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/NoteTerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	int ilevels=0,j=0;
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code") ;
	String proc_code = request.getParameter("note_type")==null?"":request.getParameter("note_type") ;
	String term_set = request.getParameter("term_set")==null?"":request.getParameter("term_set") ;
	String term_code_associated_str = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated") ;
	String level1 = request.getParameter("level")==null?"":request.getParameter("level") ;
	//out.println("level1 is :"+level1);
	String note_type		= checkForNull( request.getParameter( "note_type" ) ) ;
	String classvalue="";String checked = "";int db_count=0;
	StringBuffer temp_term_code = new StringBuffer();
	StringBuffer DB_term_code_associated = new StringBuffer(DB_term_code_associated_str);
	StringBuffer term_code_associated = new StringBuffer(term_code_associated_str);
	
	String tag = "",tag1="";
	StringBuffer temp_db_chk = new StringBuffer("");
	
	temp_term_code.append("");
	if ( mode.equals("2") )
	{
		tag = "<B>";tag1="</B>";
		String sql_code = "select a.SERVICE_CODE,b.SHORT_DESC service_description, a.NOTE_TYPE,note_type_desc , a.TERM_SET_ID,term_set_desc, a.TERM_CODE term_code,e.SHORT_DESC term_code_desc, a.CODE_LEVEL code_level,Decode(a.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_10_DESC )  code_level_desc from MR_TERM_FOR_NOTE_TYPE_dtl a,am_service b,ca_note_type c,mr_term_set d,mr_term_code e where b.SERVICE_CODE = a.service_code and c.NOTE_TYPE = a.NOTE_TYPE and d.term_set_id = a.term_set_id and d.term_set_id = e.term_set_id and e.term_code = a.term_code and upper(a.service_code) like upper(?) and upper(a.note_type) like upper(?)  and a.TERM_SET_ID like upper(?) union select a.SERVICE_CODE,b.SHORT_DESC service_description, a.NOTE_TYPE,note_type_desc , a.TERM_SET_ID,term_set_desc, '*ALL' term_code,'ALL' term_code_desc, a.CODE_LEVEL code_level,Decode(a.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_10_DESC )  code_level_desc from MR_TERM_FOR_NOTE_TYPE_dtl a,am_service b,ca_note_type c,mr_term_set d where b.SERVICE_CODE = a.service_code and c.NOTE_TYPE = a.NOTE_TYPE and d.term_set_id = a.term_set_id and a.term_code = '*ALL' and upper(a.service_code) like upper(?) and upper(a.note_type) like upper(?)  and a.TERM_SET_ID like upper(?) order by code_level, term_code";
		Connection con = null;
		PreparedStatement pstmt_code = null;
		ResultSet rs_code = null;
		String temp="";
		boolean mode_flag = false;

		
		con = ConnectionManager.getConnection(request);
		pstmt_code = con.prepareStatement(sql_code);
		pstmt_code.setString(1,service_code);
		pstmt_code.setString(2,note_type);
		pstmt_code.setString(3,term_set);
		pstmt_code.setString(4,service_code);
		pstmt_code.setString(5,note_type);
		pstmt_code.setString(6,term_set);
		rs_code = pstmt_code.executeQuery();
	
//out.println("=service_code=="+service_code+"==note_type=="+note_type+"==term_set="+term_set+"===");	//out.println("<script>alert('=service_code=="+service_code+"==note_type=="+note_type+"==term_set="+term_set+"===')</script>");

	while (rs_code.next() )
	{
		temp = rs_code.getString("term_code")+"~"+rs_code.getString("code_level")+"~"+rs_code.getString("code_level_desc")+"~"+rs_code.getString("term_code_desc")+"`";
///	temp_db_chk +=  rs_code.getString("term_code")+"~";
		temp_db_chk.append(rs_code.getString("term_code")+"~");
		if(term_code_associated.indexOf(temp) == -1 )
		{
//			DB_term_code_associated += temp ;
			DB_term_code_associated.append(temp);
			db_count++;
			/* If the Level 1 code is in DB i it should be bold */
			if(rs_code.getString("code_level").equals("1") )
			{
				bLvl_In_DB = "Y";
			}
			
		}
		mode_flag =true;
	}
	if (rs_code != null) rs_code.close();
	if (pstmt_code != null) pstmt_code.close();

	if(!mode_flag)
		mode = "1";

	if (DB_Term_code_Exisits == "N")
		{
			term_code_associated.append(DB_term_code_associated);
		}
	try
	{
		ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
 }

StringTokenizer stoken=new StringTokenizer(term_code_associated.toString(),"`");
int cnt=stoken.countTokens();
try
{
%>

<form name='term_code_associated' id='term_code_associated' method='post' target='messageFrame' action='../../servlet/eMR.NoteTerminologyCode'>
<input type="hidden" name="term_code_0" id="term_code_0" value="">	
<input type="hidden" name="lvl_code_0" id="lvl_code_0" value="">
<input type="hidden" name="term_desc_0" id="term_desc_0" value="">
<input type="hidden" name="bLvl_1_InDB" id="bLvl_1_InDB" value="false">

<table cellpadding=0 cellspacing=0 border=1 width="100%" align=center id='term_associated'>
	<tr>
		<td colspan="4" class="COLUMNHEADER" style="color: white;"><fmt:message key="eMR.TerminologyCodeAssociated.label" bundle="${mr_labels}"/></td>
	</tr>
	<tr>
		<td width='20%' class="COLUMNHEADER" style=" color: white;"><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
		<td width='20%' class="COLUMNHEADER" style="color: white;"><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
		<td width='50%' class="COLUMNHEADER" style="color: white;"><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></td>
		<td width='10%' class='COLUMNHEADERCENTER' style="color: white;"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	</tr>
	<%
	//out.println("cnt is:"+cnt);
//out.println("Mode "+mode);
	if(cnt == 0)
	{
		for(int i=0;i<(Integer.parseInt(level1));i++)
			{  
			
				if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				if(i!=0)
					checked="checked";
				else
					checked="";
				
		%>	
			<tr id='term_set_tr<%=i%>'>
				<td   id='Level<%=i%>'  class="<%=classvalue%>">Level <%=(i+1)%></td>
				<!--<td id='tbl_term_code<%=i%>' class="<%=classvalue%>"><%if(i != 0){%>*ALL<%}%></td>
				<td id='term_code_desc<%=i%>' class="<%=classvalue%>"><%if(i != 0){%>ALL<%}%></td>-->
				<!--Modified on 16 june 2008 for SPR-4435 -->
				<td   id='tbl_term_code<%=i%>' class="<%=classvalue%>">*ALL</td>
				<td  id='term_code_desc<%=i%>' class="<%=classvalue%>">ALL</td>
				<td align='center' class="<%=classvalue%>">
				<input type="checkbox" name="term_chk<%=i%>" id="term_chk<%=i%>" <%=checked%> value="Y"><%if(i == 0){%><img src="../../eCommon/images/mandatory.gif"><%}%></td>
			</tr>
		<%	
			}
				
	} 
	else 
	{	String display="display:none";
		String term_assc_temp="";
		String term_code="",level="",term_code_desc="",level_code_desc="";
		String slevel="",slvl_in_trm="";
		/*	 To enable the check box in detail frame after selecting record in modal window during insertion mode  */
		checked="checked";
		ilevels = Integer.parseInt(level1);

		/* If the database has already *ALL values cnt should be the same  for all those '*ALL~<level>~' */
		for (j=0; j<ilevels;++j) 
		{
			//display ="display:inline";
			if (j==0)
			{	//term_code=" ";
				//<!--Modified on 16 june 2008 for SPR-4435 -->
				term_code = "*ALL";
				level="1";
				level_code_desc="Level 1";
				//term_code_desc = " ";
				//<!--Modified on 16 june 2008 for SPR-4435 -->
				term_code_desc="ALL ";
//				temp_term_code +=term_code+"~";
				temp_term_code.append(term_code);
				temp_term_code.append("~");
				tag ="<b>";
				tag1="</b>";
			} 
			else 
			{	slevel="*ALL~"+(j+1)+"~" ;
				if (term_code_associated.indexOf(slevel)!=-1) 
				{	
					/* To resord the *ALL records already existing in the DB. j+1 gives level no. */
					slvl_in_trm = slvl_in_trm + (j+1) + "~" ; 
					/* The entries in DB should be bold */
					if (DB_term_code_associated.indexOf(slevel)!=-1) 
					{
						tag = "<B>";
						tag1="</B>";
						checked="checked";
					}
					else
					{
						tag = "";
						tag1="";
					}
				} 
				else
				{
					//term_code_associated = term_code_associated + "*ALL~"+(j+1)+"~Level"+(j+1)+"~ALL`";
					term_code_associated.append("*ALL~"+(j+1)+"~Level"+(j+1)+"~ALL`");
					cnt++;
					tag = "";
					tag1="";
				}
				term_code="*ALL";
				level=(j+1)+"";
				level_code_desc="Level " +( j+1);
				term_code_desc="ALL";
				//temp_term_code +=term_code+"~";
				temp_term_code.append(term_code);
				temp_term_code.append("~");
				}
			if ( j % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		%>
		<tr <%-- style='<%=display%>'  --%>id='term_set_tr<%=j%>'>
			<td  id='Level<%=j%>'  class="<%=classvalue%>"><%=tag%><%=level_code_desc%><%=tag1%></td>
			<td   id='tbl_term_code<%=j%>'  class="<%=classvalue%>"><%=tag%><%=term_code%><%=tag1%></td>
			<td   id='term_code_desc<%=j%>'  class="<%=classvalue%>" ><%=tag%><%=term_code_desc%><%=tag1%></td>
			<td  align='center'  class="<%=classvalue%>">
			<input type="checkbox" name="term_chk<%=j%>" id="term_chk<%=j%>" value="Y" <%=checked%>></td>
		</tr>
			<input type="hidden" name="term_code<%=j%>" id="term_code<%=j%>" value="<%=term_code%>">
			<input type="hidden" name="code_level<%=j%>" id="code_level<%=j%>" value="<%=level%>">
		<%
		} 

/* From  0 to j the rows are filled(The default levels).  The rest of the rows should be painted now. 
	so from j to (cnt + j) rows are painted below. ir is the row number */
	int ir=0, i=0, iflag_cnt=0;
	boolean flag = false;
	for(i=j,ir=j; i<cnt+j; i++,ir++)
	{
		display ="";
		if(stoken.hasMoreTokens())
		{
			term_assc_temp=stoken.nextToken();
			StringTokenizer token= new StringTokenizer(term_assc_temp,"~");
			term_code=token.nextToken();
			level=token.nextToken();
			level_code_desc=token.nextToken();
			term_code_desc=token.nextToken();
//			temp_term_code +=term_code+"~";
			temp_term_code.append(term_code);
			temp_term_code.append("~");

			if ( (slvl_in_trm.indexOf( level+"~" ) !=-1) && (term_code.equals("*ALL") ))
			{
				/* The next row should be painted in the current row as the operation is aborted for this row since it is already painted */
				--ir; 
				continue;
			} 
			else  
			{
				if  ( level.equals("1") ) 
				{  
					if(iflag_cnt==0)
					{
						flag = true;
						ir--;
					}
				iflag_cnt++;
			%> 
				<script>
				if(document.getElementById('term_associated').rows[2].cells[1].innerText==' ' )
					//if(document.forms[0].all.term_associated.all.tbl_term_code0.innerText==' ' )
					{   
						document.forms[0].bLvl_1_InDB.value='<%=bLvl_In_DB%>';
						/* Storing the values in hidden Variables*/
						document.forms[0].term_code_0.value='<%=term_code%>';
						document.forms[0].lvl_code_0.value='<%=level_code_desc%>';
						document.forms[0].term_desc_0.value='<%=term_code_desc%>';	
						if(document.forms[0].bLvl_1_InDB.value=='Y')
						{
							/* Populating the values in the first row in BOLD */
							document.forms[0].all.term_associated.all.tbl_term_code0.innerHTML="<b>"+document.forms[0].term_code_0.value+"</b>";
							document.forms[0].all.term_associated.all.Level0.innerHTML="<b>"+document.forms[0].lvl_code_0.value+"</b>";
							document.forms[0].all.term_associated.all.term_code_desc0.innerHTML="<b>"+document.forms[0].term_desc_0.value+"</b>";
						}
						else
							/* If the Level 1 record is not in DB it should not be bold */
						{
							document.forms[0].all.term_associated.all.tbl_term_code0.innerHTML=document.forms[0].term_code_0.value;
							document.forms[0].all.term_associated.all.Level0.innerHTML=document.forms[0].lvl_code_0.value;
							document.forms[0].all.term_associated.all.term_code_desc0.innerHTML=document.forms[0].term_desc_0.value;
						}
						document.forms[0].all.term_code0.value='<%=term_code%>';
						document.forms[0].all.code_level0.value='<%=level%>';
						document.forms[0].all.term_chk0.value='Y';
					}
				</script>
		<%
				}
				if(level.equals(""))
				level = "0";
			} 			
			if(temp_db_chk.indexOf(term_code+"~") != -1 )
				{
					tag = "<B>";
					tag1="</B>";
					checked="checked";
				}
			else
				{
					tag = "";
					tag1="";
				}

			if ( ir % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			if (flag) 
				{
					flag = false;
					continue;
				}    
		%>
		<tr <%-- style='<%=display%>' --%> id='term_set_tr<%=ir%>'>
			<td  id='Level<%=ir%>'  class="<%=classvalue%>"><%=tag%><%=level_code_desc%><%=tag1%></td>
			<td   id='tbl_term_code<%=ir%>'  class="<%=classvalue%>"><%=tag%><%=term_code%><%=tag1%></td>
			<td   id='term_code_desc<%=ir%>'  class="<%=classvalue%>" ><%=tag%><%=term_code_desc%><%=tag1%></td>
			<td  align='center'  class="<%=classvalue%>"><input type="checkbox" name="term_chk<%=ir%>" id="term_chk<%=ir%>" value="Y" <%=checked%>></td>
		</tr>
			<input type="hidden" name="term_code<%=ir%>" id="term_code<%=ir%>" value="<%=term_code%>">
			<input type="hidden" name="code_level<%=ir%>" id="code_level<%=ir%>" value="<%=level%>">
		<% 
		}
	}
	}
	//out.println("cnt:"+cnt);
  %>
	</table>
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="function_id" id="function_id" value="">
		<input type="hidden" name="totalRecords" id="totalRecords" value="<%=cnt%>">
		<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
		<input type="hidden" name="term_set_id" id="term_set_id" value="<%=term_set%>">
		<input type="hidden" name="proc_code" id="proc_code" value="<%=proc_code%>">
		<input type="hidden" name="temp_term_code" id="temp_term_code" value="<%=temp_term_code.toString()%>">
		<input type="hidden" name="term_code_associated" id="term_code_associated" value="<%=term_code_associated.toString()%>">
		<input type="hidden" name="DB_term_code_associated" id="DB_term_code_associated" value="<%=DB_term_code_associated.toString()%>">
		<input type="hidden" name="bLvl_In_DB" id="bLvl_In_DB" value="<%=bLvl_In_DB%>">
	</form>
	  
<%
}
  catch(Exception Ex)
  {
		Ex.printStackTrace();
  }
  finally
  {
	
  }
%>
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

