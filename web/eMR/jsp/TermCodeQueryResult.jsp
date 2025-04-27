<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*, java.io.*,java.util.*,java.text.*, eOR.Common.*, eOR.* " contentType="text/html;charset=UTF-8" %>
<%@page   import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="TermCodevalues" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
	<head>
	<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale					= (String) session.getValue( "LOCALE" ) ;
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="Javascript" src="../../eMR/js/NoteTerminologyCode.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var code1=trimString(obj.cells[0].innerText);
		var retVal = code1;
		if (obj && obj.cells && obj.cells.length > 1 && obj.cells[1]) {
		    var code2 = trimString(obj.cells[1].innerText);
		    retVal = retVal + "||" + code2;
		}
		if (obj && obj.cells && obj.cells.length > 1 && obj.cells[2]) {
		    var code3 = trimString(obj.cells[2].innerText);
		    retVal = retVal + "||" + code3;
		}
		//var code2=trimString(obj.cells[1].innerText);
		//var code3=trimString(obj.cells[2].innerText);
		if (obj && obj.cells && obj.cells.length > 2 && obj.cells[3] && obj.cells.children && obj.cells.children.length > 1 && obj.cells[3].children[0]) {
			var code4=trimString(obj.cells[3].children[0].value);
			retVal = retVal + "||" + code4 ;
		}
		//var code4=trimString(obj.cells[3].children[0].value);
		retVal = retVal + "~";
		//var retVal = code1 + "||" + code2 + "||" + code3 + "||" + code4 +"~";
		window.returnValue = retVal ;
		/* parent.window.returnValue = retVal ;
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  */
		window.close();
	}
	//Maheshwaran K added for PMG2014-MOD-CRF-0004 
	function GetValuesChk(obj,valobj,chkValues_obj,returnVal2_obj)
		{
		var  temp_term_code1 = parent.lookup_detail.document.getElementById("temp_term_code1").value;
		var chkValues = chkValues_obj.value;
		var returnVal2 = returnVal2_obj.value;
		if(obj.checked)
			{
			chkValues=chkValues+""+valobj+"~"
			}
		else
			{
			obj.checked=false;
			valobj=valobj+"~";
			chkValues=chkValues.replace(valobj,"");
			returnVal2=returnVal2.replace(valobj,"");
			temp_term_code1=temp_term_code1.replace(valobj,"");
			}
		chkValues_obj.value=chkValues;
		returnVal2_obj.value=returnVal2;
		parent.lookup_detail.document.getElementById("temp_term_code1").value=temp_term_code1;
		}
	</script>
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 <%
    request.setCharacterEncoding("UTF-8");
	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	// String sqlData         = "select a.term_Code term_code, a.short_Desc term_code_description,a.long_Desc long_description, Decode(CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_5_DESC )  code_level_desc,code_level from mr_term_code a, mr_Term_set b    where a.term_set_id = b.term_set_ID and upper(select_yn) like upper('Y') and upper(a.term_Set_id) = upper(?)  and 	upper(a.term_code)  like upper(?) and upper(a.short_Desc) like upper(?) and upper(short_Desc) like  DECODE   ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and code_level= nvl(?,code_level) order by 1";
	String chkValues  =  CommonBean.checkForNull(request.getParameter("chkValues")) ;

	String searchCriteria  = CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
	String returnVal1  =  request.getParameter("returnVal1") ;
	String term_set_id	   = CommonBean.checkForNull( request.getParameter( "term_set_id" ) ) ;
	String term_code	   = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
	String search_by	   = CommonBean.checkForNull( request.getParameter( "search_by" ) ) ;
	//  String search_text	   = CommonBean.checkForNull( request.getParameter( "search_text" ) ) ;
	//  String term_code_desc  = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
	String code_level	   = CommonBean.checkForNull( request.getParameter( "code_level" ) ) ;
	String multiple_yn     = CommonBean.checkForNull( request.getParameter( "multiple_yn" ) ) ;
	String temp_term_code  = CommonBean.checkForNull( request.getParameter( "temp_term_code" ) ) ;
	//String term_code_associated  = CommonBean.checkForNull( request.getParameter( "term_code_associated" ) ) ;
	//String Db_term_code  = CommonBean.checkForNull( request.getParameter( "Db_term_code" ) ) ;
	String term_group_id	   = CommonBean.checkForNull( request.getParameter( "term_group_id" ) ) ;
	int db_count=0;
	String Db_term_code="";
	String term_code_associated="";
	StringBuffer DB_term_code_associated = new StringBuffer();
	StringBuffer DB_term_code_associated1 = new StringBuffer();
	StringBuffer term_code_associated1 = new StringBuffer();
	StringBuffer term_code_associated2 = new StringBuffer();
	StringBuffer temp_db_chk = new StringBuffer("");
	String DB_Term_code_Exisits = request.getParameter("Db_term_code")==null? "N" :"Y";
	boolean mode_flag=false;
	StringBuffer sr_nos= new StringBuffer("");
	String temp_no="";
	try
		{
		String sql_code = "select a.TERM_CODE term_code, c.SHORT_DESC term_code_desc, c.CODE_LEVEL code_level, Decode(c.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC, '3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC , '6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,  '9',LEVEL_9_DESC ,'10',LEVEL_10_DESC ) code_level_desc, ORDER_SRL_NO order_no from MR_TERM_GROUP_DTL a, mr_term_set b,mr_term_code c where   a.term_set_id = b.term_set_id and b.term_set_id = c.term_set_id and a.term_code  = c.term_code and a.term_group_id like upper(?) and a.TERM_SET_ID like upper(?)";
		Connection con = null;
		PreparedStatement pstmt_code = null;
		ResultSet rs_code = null;
		con = ConnectionManager.getConnection(request);
		pstmt_code = con.prepareStatement(sql_code);
		pstmt_code.setString(1,term_group_id);
		pstmt_code.setString(2,term_set_id);
		rs_code=pstmt_code.executeQuery();				
//		String DB_term_code_associated="";
		String temp="";
		String temp1="";
		String code_level_desc="";
		String level1="";
		mode_flag = false;
		while(rs_code.next())
		{
		    level1=rs_code.getString("code_level");
			code_level_desc=CommonBean.checkForNull(rs_code.getString("code_level_desc"));
			if(code_level_desc.equals(""))
			code_level_desc = "||";
			temp = rs_code.getString("term_code")+"~"+level1+"~"+code_level_desc+"~"+rs_code.getString("term_code_desc")+"`";
			temp1 = rs_code.getString("term_code")+"||"+rs_code.getString("term_code_desc")+"||"+code_level_desc+"||"+level1+"~";
			temp_db_chk.append(rs_code.getString("term_code")+"~");
//			sr_nos+=rs_code.getString("order_no")+"~";
			sr_nos.append(rs_code.getString("order_no")+"~");
			if(term_code_associated1.indexOf(temp) == -1)
			{
//				DB_term_code_associated += temp ;
				DB_term_code_associated.append(temp);
				db_count++;
			}
			if(term_code_associated1.indexOf(temp1) == -1)
			{
//				DB_term_code_associated1 += temp1;
				DB_term_code_associated1.append(temp1);
				db_count++;
			}
			mode_flag =true;
		}
		if ( rs_code !=null ) rs_code.close();
		if ( pstmt_code !=null ) pstmt_code.close();
//		term_code_associated1 = DB_term_code_associated + term_code_associated;
		term_code_associated1.append(DB_term_code_associated);
		term_code_associated2.append(DB_term_code_associated1);
		
	  try{
		if (con != null) ConnectionManager.returnConnection(con,request);
	  }
	  catch(Exception e)
	  {
		//out.println("Exception "+e.toString());
		 e.printStackTrace();
	  }
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		Db_term_code  =term_code_associated1.toString();
		term_code_associated  =term_code_associated2.toString();
	StringBuffer sqlData	= new StringBuffer("");
	sqlData.append("select a.term_Code term_code, a.short_Desc term_code_description,a.long_Desc long_description, Decode(a.CODE_LEVEL,'1',b.LEVEL_1_DESC,'2',b.LEVEL_2_DESC,'3',b.LEVEL_3_DESC, '4',b.LEVEL_4_DESC ,'5',b.LEVEL_5_DESC ,'6',b.LEVEL_6_DESC ,'7',b.LEVEL_7_DESC ,'8',b.LEVEL_8_DESC ,'9',b.LEVEL_9_DESC ,'10',b.LEVEL_5_DESC )code_level_desc,a.code_level from mr_term_code a, mr_Term_set b where a.term_set_id = b.term_set_ID and upper(a.select_yn) like upper('Y') and upper(a.term_Set_id) = upper(?) and ");
	 
	if(search_by.equals("C"))
		sqlData.append("upper(a.term_code)");
	 else
		sqlData.append("upper(short_desc)");
	 sqlData.append(" like  DECODE   ((?), 'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and code_level=		nvl(?,code_level)   AND a.eff_status = 'E'");
	 if(!multiple_yn.equals("Y"))
	{
		 sqlData.append("   AND a.procedure_yn = 'Y' AND b.proc_spec_yn = 'Y'  ");
	}
	sqlData.append(" order by 1");
	
/*	if(search_by.equals("C"))
		term_code_desc = "";
	else
		term_code = "";*/
		
//multiple_yn = "Y";
	boolean searched	   = request.getParameter( "searched" ) == null ? false : true  ;
	
try
{
	String classvalue			= "";
	String checked="",disabled="";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", sqlData.toString());
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "term_code" );
    displayFields.add( "term_code_description" );
	//displayFields.add( "long_description" );
    displayFields.add( "code_level_desc" );
	displayFields.add( "code_level" );
    //  displayFields.add( "term_set_desc" );
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add(term_set_id.trim());
	chkFields.add(searchCriteria.trim());
	chkFields.add(term_code);
	chkFields.add(term_code);
	chkFields.add(term_code);
	chkFields.add(code_level.trim());
	

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	if ( sqlMap != null ) sqlMap.clear();
	if ( funcMap != null ) funcMap.clear();
	if ( chkFields != null ) chkFields.clear();
	
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
	%>
		<table cellpadding=1 cellspacing=0 width="100%" align="center">
		<tr onclick='retainChk()'>
			<td width="80%" class="white" >&nbsp;</td>
			<td width="20%" class="white" >&nbsp;
			
	<%
			//For displaying the previous/next link
			 out.println(result.get(1));
	%>
			</td>
		</tr> 
		</table>
		
	<table border="2" cellpadding="0" cellspacing="0" width="100%" align="center" id='result_tbl'>
		<th width='20%'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></th>
		<th width='40%'><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></th>
		<th width='20%'><fmt:message key="Common.CodeLevel.label" bundle="${common_labels}"/></th>
		<!-- <th width='45%'>Term Set Description</th> -->
	<%  if(multiple_yn.equals("Y"))
			{
	 %>
			<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	<%   
			}
		  //Retriving the records from result arraylist
		    ArrayList records=new ArrayList();

		   for ( int recCount=2; recCount<result.size(); recCount++) 
		   {
		 	 if ( recCount % 2 == 0 )
				    classvalue = "QRYEVEN" ;
			else
				 classvalue = "QRYODD" ;
		%>
             <tr onClick="Modify(this);" >
		<%

           String link_columns = "1";
		   if (multiple_yn.equals("Y"))
				link_columns = "0";
            records=(ArrayList) result.get( recCount );
		    
			for (int colCount=0; colCount<records.size(); colCount++)
			 {
				if(!multiple_yn.equals("Y"))
				 {
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					 {
		%>
					<td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer';" ><font class='HYPERLINK'>
					<%=(String)records.get( colCount )%>
					</font></td>
		<% 
			        }
					else
					{ 
						if ( colCount != 3 )
						{

		%>
							<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get( colCount ))%></td>
		<%	
						}
						else
						{
		%>
							<td style='display:none'><input type='hidden' name='code_level<%=recCount%>' id='code_level<%=recCount%>' value='<%=records.get( colCount )%>'></td>
   	   <% 
						}
					}
				 }
				else
			      {
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					 {
						%>
						<td class="<%=classvalue%>" onclick="" ><font class=''><%=(String)records.get( colCount )%></font></td> 
		<%		}
					else
					{ 
						if (colCount != 3)
						 {
							
		%>
						
						<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get( colCount ))%></td>
		<%
						}
						else
						{
		%>
						<td style='display:none'><input type='hidden' name='code_level<%=recCount%>' id='code_level<%=recCount%>' value='<%=records.get( colCount )%>'></td>
		<%
						}
						if ( (String.valueOf(colCount)).equals("3") )
						 {
    						//	String temp_rec= (String)records.get( 0 )+"~";
								if	(temp_term_code.indexOf((String)records.get( 0 )+"~") != -1)
								{
									int ind = temp_term_code.indexOf((String)records.get( 0 )+"~") ;
									String temp1=temp_term_code.substring(ind,temp_term_code.length());
									int ind1=temp1.indexOf("~") ;
									String temp2=temp1.substring(0,ind1);
									if (temp2.equals((String)records.get( 0 )) )
									 {
										checked = "checked";
										disabled= "";
									}
									else
									{
										checked = "";
										disabled= "";
									}
								}
								else
								{
									checked = "";
									disabled= "";
								}
/* Modified by vinod 9/13/2005
	To handle the term codes which are substrings of other term codes.
	A term code will be suffixed with "~" before comparing with the string "DB_term_code" to identify the exact matching sub string
*/	
					//		String temp_rec1 = (String)records.get( 0 )+"~";
							if (Db_term_code.indexOf((String)records.get( 0 )+"~") != -1) 
							 {
								int ind = Db_term_code.indexOf((String)records.get( 0 )+"~") ;
								String temp1=Db_term_code.substring(ind,Db_term_code.length());
								int ind1=temp1.indexOf("~") ;
								String temp2=temp1.substring(0,ind1);
								 if(temp2.equals((String)records.get( 0 )))
									{
										checked = "checked";
										disabled= "disabled";
									}
									else
									{
										checked = "";
										disabled= "";
									}
							}
		%>
						 <td class="<%=classvalue%>" align='center' onclick="disableClick(event);"><input type="checkbox" name="term_chk<%=recCount%>" id="term_chk<%=recCount%>" <%=checked%> <%=disabled%> onclick="GetValuesChk(term_chk<%=recCount%>,'<%=records.get( 0 )%>',chkValues1,returnVal2)"></td>
		<%
						}
				}
			}	
         } /* End of For column Count */
 		if ( records != null ) records.clear();
    %>		
           </tr>
		
    <%
      } /* End of For record Count */

    %>
	<input type="hidden" name='cnt' id='cnt' value='<%=result.size()%>'>
	<input type="hidden" name='chkValues1' id='chkValues1' value="<%=chkValues%>">
   <input type="hidden" name='temp_term_code1' id='temp_term_code1' value='<%=temp_term_code%>'>
	<input type="hidden" name="ret_term_code" id="ret_term_code" value="<%=term_code_associated%>">
	<input type="hidden" name="term_code_associated" id="term_code_associated" value="<%=term_code_associated%>">
	<input type="hidden" name="db_term_code" id="db_term_code" value="<%=Db_term_code%>">
    <input type="hidden" name='qry_string' id='qry_string' value='<%=request.getQueryString()%>'>
	<input type="hidden" name="term_group_id1" id="term_group_id1" value="<%=term_group_id%>">
	<input type="hidden" name="term_set_id1" id="term_set_id1" value="<%=term_set_id%>">
	<input type="hidden" name="returnVal2" id="returnVal2" value="<%=returnVal1%>">
	<input type="hidden" name='search_by' id='search_by' value='<%=search_by%>'>  <!-- Added By vinod 14/05/2005 -->
	
</table>
		<%out.flush();
	}
	else /* If  result.size() not >=3) */
     {
%>
		
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
			
			parent.lookup_head.document.CriteriaForm.Search.disabled = false;
			/*
			This component TermCodeSearch is used commonly. If OK button is not there it gives error
			*/
			if (parent.lookup_cancel.document.getElementById("ok") != null)
			{
				parent.lookup_cancel.document.getElementById("ok").disabled = false;
			}
			
			history.go(-1);
		</script> 
		
<%
	  }
	/**Following code changed by vinod 06/09/2005 - Extra characters were printing in result page  */
	out.println(CommonBean.setForm(request ,"TermCodeQueryResult.jsp?\"+request.getQueryString()+\"", searched));
	if ( displayFields != null ) displayFields.clear();
	if ( result != null ) result.clear();
 }
catch(Exception e) 
	{
		//out.print("Exception @ Result JSP :"+e.toString());
		 e.printStackTrace();
	}
	
%>

</body>
	
	<script>
			parent.lookup_head.document.CriteriaForm.Search.disabled = false;
	</script> 
</html>

