<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>
<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
    <script src='../../eQA/js/QAIndicatorsForFacility.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  
<script>
//moved to JS

</script>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<form name='result_form' id='result_form' action="QAIndicatorForFacility2.jsp" method="post">
<%

Connection con					=	null;
HashMap hashIndicator = null;
PreparedStatement pstmt			=	null;
ResultSet rset					=	null ;
//String	facilityId 					= (String) session.getValue( "facility_id" ) ;

int  count = request.getParameter("n")==null ? 0 : Integer.parseInt(request.getParameter("n"));
String flagYN = request.getParameter("flagYN")==null ? "N" : request.getParameter("flagYN");
//String valid_values="";
String checkedValues = "";
String checkedKey="";
String strKey="";
String strValue="";
int n=0;
int counter = request.getParameter("counter")==null ? 0 : Integer.parseInt(request.getParameter("counter"));
String from = request.getParameter( "from" ) ;
//valid_values		=	request.getParameter("valid_values")==null?"":request.getParameter("valid_values");

String to = request.getParameter( "to" ) ;
ArrayList keys = (ArrayList)session.getValue("arrayKeys");

if(keys == null)
{
	keys = new ArrayList();
}

StringTokenizer strToken1		= null;

boolean boolFlag = false;
String class_value				= "QRYEVEN";
String clindid					= "";
String fac_id                   = "";
String checked_yn				= "";
String dflt_rep_periodicity     = "";
String dflt_bd_by_gender_yn     = "";
String dflt_bd_age_range_id     = "";

int maxRecord=0;

StringBuffer sql   = new StringBuffer();
String indi="";
int start = 0 ;
int end = 0 ;
int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;
%>

<%try
{
	
	
	con						=	ConnectionManager.getConnection(request);
	fac_id				    =	checkForNull(request.getParameter("fac_id"));
	indi				    =	checkForNull(request.getParameter("indi"));
	String removeValue = "";
	StringBuffer countsql		= new StringBuffer();
	countsql.append("select  count(*)  FROM QA_QIND_CLIND  A,QA_QIND_FACILITY_CLIND B ");	countsql.append("WHERE B.OPERATING_FACILITY_ID(+) ='"+fac_id+"' and A.QIND_CLIND_ID=B.QIND_CLIND_ID(+) and A.QIND_CLIND_ID like '"+indi+"%'");
	 
	hashIndicator = (HashMap)session.getValue("hashIndicator");
	if(hashIndicator == null)
	{
		hashIndicator = new HashMap();
	}
	int count_value=0;
	int index=0;
	if(hashIndicator != null)
	{

		for(index=0 ;index < count;index++)
		{
				checkedKey = request.getParameter("strKey"+index) == null ? "" : request.getParameter("strKey"+index);
				
				if(!checkedKey.equals(""))
				{
					checkedValues = request.getParameter("strValue"+index) == null ? "" : request.getParameter("strValue"+index);
					hashIndicator.put (checkedKey,checkedValues);
				}
				else
				{
					removeValue = request.getParameter("removedValue"+index) == null ? "" : request.getParameter("removedValue"+index);
					if(!removeValue.equals(""))
					{
						hashIndicator.remove (removeValue);
						counter++;
					}
				}
			}
		}
	pstmt	=	con.prepareStatement(countsql.toString());
	rset = pstmt.executeQuery();
  	if ((rset != null) && (rset.next()))
	{
		count_value= rset.getInt(1);
		maxRecord=count_value;
	} if(rset!=null) rset.close();
	  if(pstmt!=null) pstmt.close();
	if (count_value==0)
	{
	%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));
		</script>
	<%
		return;
	}
	else
	{
		if (sql.length() > 0) sql.delete(0,sql.length());
		
sql.append("select to_number(QIND_CLIND_ID) CLINDID,'Y' CHECKED_YN, DFLT_REP_PERIODICITY  DFLT_REP_PERIODICITY,DFLT_BD_BY_GENDER_YN DFLT_BD_BY_GENDER_YN,DFLT_BD_AGE_RANGE_ID DFLT_BD_AGE_RANGE_ID  FROM QA_QIND_FACILITY_CLIND WHERE OPERATING_FACILITY_ID ='"+fac_id+"' and QIND_CLIND_ID like '"+indi+"%'UNION select to_number(QIND_CLIND_ID) CLINDID,'N' CHECKED_YN, DFLT_REP_PERIODICITY  DFLT_REP_PERIODICITY,DFLT_BD_BY_GENDER_YN DFLT_BD_BY_GENDER_YN,DFLT_BD_AGE_RANGE_ID DFLT_BD_AGE_RANGE_ID  FROM QA_QIND_CLIND  WHERE QIND_CLIND_ID like '"+indi+"%'AND QIND_CLIND_ID NOT IN (SELECT QIND_CLIND_ID FROM QA_QIND_FACILITY_CLIND WHERE OPERATING_FACILITY_ID ='"+fac_id+"') order by 1");

		//sql.append("select  A.QIND_CLIND_ID CLINDID,DECODE(B.OPERATING_FACILITY_ID,'");
		//sql.append(fac_id+"','Y','N') DB_YN,DECODE(B.OPERATING_FACILITY_ID,'");
		//sql.append(fac_id+"','CHECKED','UNCHECKED')  CHECKED_YN,B.DFLT_REP_PERIODICITY  DFLT_REP_PERIODICITY,B.DFLT_BD_BY_GENDER_YN DFLT_BD_BY_GENDER_YN,B.DFLT_BD_AGE_RANGE_ID DFLT_BD_AGE_RANGE_ID  FROM QA_QIND_CLIND  A,QA_QIND_FACILITY_CLIND B ");		
		//sql.append("WHERE B.OPERATING_FACILITY_ID(+) ='"+fac_id+"' and A.QIND_CLIND_ID=B.QIND_CLIND_ID(+) and A.QIND_CLIND_ID like '"+indi+"%' ORDER BY TO_NUMBER(A.QIND_CLIND_ID)");
	}
	pstmt = con.prepareStatement(sql.toString());
	rset = pstmt.executeQuery();
	%>
<P>
<table  width='90%' align='center' >	
<tr >
		<%if (!(start <= 1) || !( (start+10) > maxRecord ))
		{%>
        
	   <td class='white' width='95%'>&nbsp;</td>
    	<td  align='right' nowrap>
		<%}else{%>
	    
		<td class='white'>
	   <%}%>
<%
if ( !(start <= 1) )
		{
%>
	<a HREF='javascript:submitPrevNext(<%=start-10%>, <%=end-10%>);' text-decoration='none'>Previous</a>
<%
		}

	if ( !( (start+10) > maxRecord ) )
	{
%>
	<a HREF='javascript:submitPrevNext(<%=start+10%>, <%=end+10%>);'  text-decoration='none'>Next</a>
<%
	}
%>

</td>
</tr>
</table>

	<table cellpadding=0 cellspacing=0 border=1 width='90%' align='center'>
		<th nowrap>Indicator ID</th>
		<th nowrap>Periodicity</th>
	<th nowrap>Age</th>	
	<th nowrap>Gender</th>
		
	   <th nowrap>Select</th>
	
		<%

	  String tempString = "";
		if(hashIndicator != null)
		{
			if(flagYN.equals("N"))
				hashIndicator.clear();
		if(hashIndicator.size() == 0)
		{
			while(rset.next())
			{
				checked_yn= checkForNull(rset.getString("CHECKED_YN"));
				dflt_rep_periodicity=checkForNull(rset.getString("DFLT_REP_PERIODICITY"));
				dflt_bd_by_gender_yn= checkForNull(rset.getString("DFLT_BD_BY_GENDER_YN"));
				dflt_bd_age_range_id= checkForNull(rset.getString("DFLT_BD_AGE_RANGE_ID"));
				clindid= checkForNull(rset.getString("CLINDID"));
				strKey = fac_id + "~" + clindid;
				if(checked_yn.equals("Y"))
				{
				 if(dflt_bd_by_gender_yn.equals(""))
				   dflt_bd_by_gender_yn="X";
				 if(dflt_bd_age_range_id.equals(""))
				   dflt_bd_age_range_id="X";
				 if(dflt_rep_periodicity.equals(""))
				   dflt_rep_periodicity="X";
					
					strValue = dflt_rep_periodicity+"||"+ dflt_bd_age_range_id+"||"+dflt_bd_by_gender_yn ;
					hashIndicator.put(strKey,strValue);
				}
				if(!keys.contains(strKey))
				{
					keys.add(strKey);
				}
			}if(rset!=null) rset.close();
		}
	}
	
	rset = pstmt.executeQuery();
	if (rset != null)
	{
		if( start != 1 )
	   for( int j=1; j<start; i++,j++ ){
	  rset.next() ;
	  }
		while(rset.next() && i<=end)
		{
			clindid= checkForNull(rset.getString("CLINDID"));
			dflt_rep_periodicity=checkForNull(rset.getString("DFLT_REP_PERIODICITY"));
			dflt_bd_by_gender_yn= checkForNull(rset.getString("DFLT_BD_BY_GENDER_YN"));
			dflt_bd_age_range_id= checkForNull(rset.getString("DFLT_BD_AGE_RANGE_ID"));
			
			checked_yn= checkForNull(rset.getString("CHECKED_YN"));
			
			

             if(dflt_bd_by_gender_yn.equals(""))
               dflt_bd_by_gender_yn="X";
			 if(dflt_bd_age_range_id.equals(""))
               dflt_bd_age_range_id="X";
			 if(dflt_rep_periodicity.equals(""))
               dflt_rep_periodicity="X";
		    strKey = fac_id + "~" + clindid;
			strValue = dflt_rep_periodicity+"||"+ dflt_bd_age_range_id+"||"+dflt_bd_by_gender_yn ;
			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			
				if(hashIndicator != null)
				{
					tempString = hashIndicator.get(strKey) == null ? "" : (String) hashIndicator.get(strKey) ;
					if(!tempString.equals(""))
					{
						 strToken1= new StringTokenizer(tempString,"||");
						  dflt_rep_periodicity=strToken1.nextToken();
						  dflt_bd_age_range_id= strToken1.nextToken();
						  dflt_bd_by_gender_yn=strToken1.nextToken();
						 boolFlag=true;
					}
					else
					{
						boolFlag=false;
					}
				}
			
				if(boolFlag==true)
				{
					checked_yn = "CHECKED";
				}
				else
				{
					checked_yn = "";
				}	
			%>

			<tr>
				<td class="<%=class_value%>" nowrap align=center  width=25%><%=clindid%></td>
			<input type=hidden name=qd<%=n% id=qd<%=n%> value='<%=clindid%>'>	
			<td class="<%=class_value%>"  width=15% nowrap >&nbsp;&nbsp;
				<select name=period<%=n% id=period<%=n%>>
				<option value='X'>-----------------Select--------------------&nbsp;&nbsp;&nbsp;
			    <%if(dflt_rep_periodicity.equals("M"))
			{%>
				<option value='M'  selected>Monthly&nbsp;
			<%}else{%>
			    <option value='M' >Monthly&nbsp;
			   <%}%>
				     <%if(dflt_rep_periodicity.equals("Q"))
			{%>
				<option value='Q'  selected>Quarterly&nbsp;
			<%}else{%>
			    <option value='Q' >Quarterly&nbsp;
			   <%}%>
			  <%if(dflt_rep_periodicity.equals("B"))
			{%>
				<option value='B'  selected>Bi-Annually&nbsp;
			<%}else{%>
			    <option value='B' >Bi-Annually&nbsp;
			   <%}%>
			  <%if(dflt_rep_periodicity.equals("A"))
			{%>
				<option value='A'  selected>Annually &nbsp;
			<%}else{%>
			    <option value='A' >Annually &nbsp;
			   <%}%>
			</select></td>
			
				<%if(dflt_bd_age_range_id.equals("X"))dflt_bd_age_range_id="";%>
			   <td class="<%=class_value%>" width=10% nowrap align=center>&nbsp;<input type='text'  onKeyPress='return(ChkNumberInput(this,event,0))' OnBlur='CheckPositiveNumberLocal(this);onBlur=CheckNum(this)'	 name=age<%=n% id=age<%=n%>  size=4 maxlength=3 value=<%=dflt_bd_age_range_id%>>&nbsp;</td>
			<td class="<%=class_value%>"width=10% nowrap align=center>
			  <% if(dflt_bd_by_gender_yn.equals("Y")){%>
				   
			   <input type='checkbox'  name=gender<%=n% id=gender<%=n%> value='Y' checked  onclick="genYN(this)">
			   <%}else{%>
			   <input type='checkbox'  name=gender<%=n% id=gender<%=n%>   value='N'  onclick="genYN(this)">
			   <%}%>
			   
			   </td>
			   <td class="<%=class_value%>" nowrap align=center>
				<input type=checkbox  onclick="chkValue(this,<%=n%>)"  name='strKey<%=n%>' 	value ='<%=strKey%>' <%=checked_yn%> value='<%=strKey%>'></td>
                 <input type=hidden name=h<%=n% id=h<%=n%>>
				<input type=hidden name='strValue<%=n%>'>
				<input type=hidden name='removedValue<%=n%>'>
				 
			</tr>
			<%
			i++;
			n++;
		}%>
		<%}if(pstmt!=null) pstmt.close();
	       if(rset!=null) rset.close();
%>
</table>
<%
	session.putValue("hashIndicator",hashIndicator);
	session.putValue("arrayKeys",keys);
	

	}
	catch (Exception e){
	out.println("Exception in query="+e);
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</div>
<input type=hidden name='count' id='count' value=<%=i%>>
<input type='hidden' name=fac_id id=fac_id value=<%=fac_id%>>
<input type='hidden' name=indi id=indi value=<%=indi%>>
<input type='hidden' name='n' id='n' value=<%=n%>>
<input type='hidden' name='fnname' id='fnname' value="Insert">
<input type='hidden' name='insert_table' id='insert_table' value='Y'>
<input type='hidden' name='flagYN' id='flagYN' value='Y'>

<input type="Hidden" name="from" id="from" value="<%=from%>">
<input type="Hidden" name="to" id="to" value="<%=to%>">
<input type="Hidden" name="counter" id="counter" value="<%=counter%>">

</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
	}
%>

