<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*, java.io.*,java.util.*,java.text.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="TerminologyLookup" scope="session" class="webbeans.eCommon.RecordSet" />


<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<head>
	<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="Javascript" src="../../eOR/js/NewProcedureTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var code1=obj.cells[0].innerText;
		var code2=obj.cells[1].innerText;
		var code3=obj.cells[2].innerText;
		var code4=obj.cells[3].children(0).value;
		var retVal = code1 + "||" + code2 + "||" + code3 + "||" + code4 +"~";
		top.window.returnValue = retVal ;
		top.close()
	}
	</script>
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 <%
    
	// String sqlData         = "select a.term_Code term_code, a.short_Desc term_code_description,a.long_Desc long_description, Decode(CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_5_DESC )  code_level_desc,code_level from mr_term_code a, mr_Term_set b    where a.term_set_id = b.term_set_ID and upper(select_yn) like upper('Y') and upper(a.term_Set_id) = upper(?)  and 	upper(a.term_code)  like upper(?) and upper(a.short_Desc) like upper(?) and upper(short_Desc) like  DECODE   ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and code_level= nvl(?,code_level) order by 1";
     

    String searchCriteria  = CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
    String term_set_id	   = CommonBean.checkForNull( request.getParameter( "term_set_id" ) ) ;
    String term_code	   = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
    String search_by	   = CommonBean.checkForNull( request.getParameter( "search_by" ) ) ;
  //  String search_text	   = CommonBean.checkForNull( request.getParameter( "search_text" ) ) ;
  //  String term_code_desc  = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
    String code_level	   = CommonBean.checkForNull( request.getParameter( "code_level" ) ) ;
    String multiple_yn     = CommonBean.checkForNull( request.getParameter( "multiple_yn" ) ) ;
    String temp_term_code  = CommonBean.checkForNull( request.getParameter( "temp_term_code" ) ) ;
    String term_code_associated  = CommonBean.checkForNull( request.getParameter( "term_code_associated" ) ) ;
    String Db_term_code  = CommonBean.checkForNull( request.getParameter( "Db_term_code" ) ) ;
    String term_grp_id  = CommonBean.checkForNull( request.getParameter( "term_grp_id" ) ) ;
    String radioval  = CommonBean.checkForNull( request.getParameter( "radioval" ) ) ;

	StringBuffer sqlData	= new StringBuffer("");
	if(term_grp_id.equals("") && radioval.equals("C")){
	sqlData.append("select a.term_Code term_code, a.short_Desc term_code_description,a.long_Desc long_description, Decode(CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_5_DESC )code_level_desc,code_level,b.term_set_id term_set_id,b.term_set_desc term_set_desc from mr_term_code a, mr_Term_set b where a.term_set_id = b.term_set_ID and upper(select_yn) like upper('Y') and upper(a.term_Set_id) = upper(?) and ");
	}else{
		  sqlData.append("SELECT a.TERM_CODE term_code, c.SHORT_DESC term_code_description, c.CODE_LEVEL code_level, DECODE(c.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC, '3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC , '6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,  '9',LEVEL_9_DESC ,'10',LEVEL_10_DESC ) code_level_desc,b.term_set_id term_set_id,b.term_set_desc term_set_desc FROM MR_TERM_GROUP_DTL a, mr_term_set b,mr_term_code c   WHERE   a.term_set_id = b.term_set_id AND b.term_set_id = c.term_set_id AND a.term_code  = c.term_code   AND a.term_group_id LIKE UPPER(?) AND a.TERM_SET_ID LIKE UPPER(?) and ");
		
		multiple_yn = "N";
	}
	 if(search_by.equals("C"))
		sqlData.append("upper(a.term_code)");
	 else
		sqlData.append("upper(short_desc)");
	 
	 sqlData.append(" like  DECODE   ((?), 'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and code_level= nvl(?,code_level) order by 1");
/*	if(search_by.equals("C"))
		term_code_desc = "";
	else
		term_code = "";*/
		
	boolean searched	   = request.getParameter( "searched" ) == null ? false : true  ;
	//out.println("<script>alert('"+term_set_id+"===="+term_code+"');</script>");
try
{
	//out.println("--clearAll--"+TerminologyLookup.clearAll()+"==");
	ArrayList Terminology		=	(ArrayList)TerminologyLookup.getRecordSetHandle();
	HashMap Termcode= new HashMap();
	//out.println("--getSize--"+TerminologyLookup.getSize()+"==");
	if(Terminology.size()>0)
	{
		//Termcode=(HashMap)Terminology.get(0);
		Terminology = (ArrayList)TerminologyLookup.getObject(0);
		Termcode = (HashMap)Terminology.get(0);
		/*Set itr_set			=	Termcode.keySet();
		Iterator recordItr		=	itr_set.iterator();
		while(recordItr.hasNext()){
			String grpid1="";
			grpid1=(String)recordItr.next();
			//out.println("--Termcode--"+grpid1+"====");
		}*/
		//out.println("--Termcode-size-"+Termcode.size()+"====");
	}
	
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
	displayFields.add( "term_set_id" );
	displayFields.add( "term_set_desc" );
    //  displayFields.add( "term_set_desc" );
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	if(!term_grp_id.equals("") || !radioval.equals("C"))
		chkFields.add(term_grp_id.trim());

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
	
	String link_columns = "1";
	
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
	%>
		<table cellpadding=1 cellspacing=0 width="100%" align="center">
		<tr onclick='retainCodeChk()'>
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
		<th width='20%'><font size='1'>Term Code</font></th>
		<th width='40%'><font size='1'>Term Code Description</font></th>
		<th width='20%'><font size='1'>Code Level</font></th>
		<!-- <th width='45%'>Term Set Description</th> -->
	<%  if(multiple_yn.equals("Y"))
			{
	 %>
			<th><font size='1'>Select</font></th>
	<%   
			}
		  //Retriving the records from result arraylist
		   ArrayList records=new ArrayList();
		   String tmp_hdr = "",tmp_setid= "",tmp_code= "",tmp_desc= "",level= "",level_desc= "";
		   for ( int recCount=2; recCount<result.size(); recCount++) 
		   {
		 	 if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
		   if (multiple_yn.equals("Y"))
				link_columns = "0";
		   else if(radioval.equals("G"))
				link_columns = "0";	
        
			records=(ArrayList) result.get( recCount );
			
			tmp_code	 = (String)records.get( 0 );
			tmp_desc	 = (String)records.get( 1 );
			level_desc	 = (String)records.get( 2 );
			level		 = (String)records.get( 3 );
			tmp_setid	 = (String)records.get( 4 );
			
			if(!tmp_hdr.equals((String)records.get( 4 )) && radioval.equals("G")){
		%>
			<tr>
				<td colspan='4' class='CAHIGHER'><%=(String)records.get( 5 )%> </td>
			</tr>
		<%  tmp_hdr = (String)records.get( 4 );
			}
		%>
             <tr onClick="Modify(this);" >
		<% 
			for (int colCount=0; colCount<records.size(); colCount++)
			 {
				if(!multiple_yn.equals("Y"))
				 {
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					 {
		%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK' size='1'>
					<%=(String)records.get( colCount ) %>
					</font></td>
		<% 
			        }
					else
					{ 
						if ( colCount == 0 ||colCount == 1 || colCount == 2 )
						{
		%>
							<td class="<%=classvalue%>" onclick="disableClick(event);"><font size='1'><%=(String)records.get( colCount )%></font></td>
		<%	
						}
						else if ( colCount == 3 )
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
						if ( colCount == 0 ||colCount == 1 || colCount == 2 )
						 {
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"><font size='1'><%=(String)records.get( colCount )%></font></td>
		<%
						}
						else if ( colCount == 3)
						{
		%>
						<td style='display:none'><input type='hidden' name='code_level<%=recCount%>' id='code_level<%=recCount%>' value='<%=records.get( colCount )%>'></td>
		<%
						}
						if ( (String.valueOf(colCount)).equals("3") )
						 {
    						
							//out.println("==in=="+Termcode.containsKey(tmp_setid+tmp_code+tmp_desc+level+level_desc)+"=="+tmp_code);	
							//if(Termcode.containsKey(tmp_code+tmp_desc+level+level_desc)){
							if(Termcode.containsKey(tmp_code+"|"+tmp_desc)){
								String chk_val = (String)Termcode.get(tmp_code+"|"+tmp_desc);
								//out.println("==in=="+(String)Termcode.get(tmp_setid+tmp_grpid));
								if(chk_val != null && chk_val.equals("Y"))
									checked = "checked";
								else
									checked = "";
							}else
								checked = "";
							//	String temp_rec= (String)records.get( 0 )+"~";
							/*	if	(temp_term_code.indexOf((String)records.get( 0 )+"~") != -1)
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
								}*/
/* Modified by vinod 9/13/2005
	To handle the term codes which are substrings of other term codes.
	A term code will be suffixed with "~" before comparing with the string "DB_term_code" to identify the exact matching sub string
*/	
					//		String temp_rec1 = (String)records.get( 0 )+"~";
					/*		if (Db_term_code.indexOf((String)records.get( 0 )+"~") != -1) 
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
							}*/
		%>
						 <td class="<%=classvalue%>" align='center' onclick="disableClick(event);"><input type="checkbox" name="term_chk<%=recCount%>" id="term_chk<%=recCount%>" <%=checked%> <%=disabled%>></td>
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
   <input type="hidden" name='temp_term_code1' id='temp_term_code1' value='<%=temp_term_code%>'>
	<input type="hidden" name="ret_term_code" id="ret_term_code" value="<%=term_code_associated%>">
	<input type="hidden" name="db_term_code" id="db_term_code" value="<%=Db_term_code%>">
    <input type="hidden" name='qry_string' id='qry_string' value='<%=request.getQueryString()%>'>
    <input type="hidden" name='multiple_yn' id='multiple_yn' value='<%=multiple_yn%>'>
	<input type="hidden" name='search_by' id='search_by' value='<%=search_by%>'>  <!-- Added By vinod 14/05/2005 -->
	
</table>
		<%out.flush();
	}
	else /* If  result.size() not >=3) */
     {
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
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
	out.println(CommonBean.setForm(request ,"NewProcTermCodeQueryResult.jsp?\"+request.getQueryString()+\"", searched));
	if ( displayFields != null ) displayFields.clear();
	if ( result != null ) result.clear();
 }
catch(Exception e) 
	{
		//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}	
%>
</body>
	<script>
			parent.lookup_head.document.CriteriaForm.Search.disabled = false;
	</script> 
</html>

