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
    <script src='../../eQA/js/QAIndicatorsForDiscipline.js' language='javascript' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='result_form' id='result_form' action="QAIndicatorsForDiscipline2.jsp" method="post">
<%

Connection con					=	null;
HashMap hashIndicator           =   null;
PreparedStatement pstmt			=	null;
ResultSet rset					=	null ;

String class_value				= "QRYEVEN";
String clindid					= "";
String dispid					= "";
String checked_yn				= "";
String qind_clind_desc			= "";
String checkedValues	        = "";
String checkedKey		        = "";
String strKey			        = "";
String strValue			        = "";

boolean boolFlag                = false;

int	   n						= 0;

try
{
int  count                = request.getParameter("n")==null ? 0 : Integer.parseInt(request.getParameter("n"));
//String	facilityId 		  = (String) session.getValue( "facility_id" ) ;
String from               = request.getParameter( "from" ) ;
String to                 = request.getParameter( "to" ) ;
ArrayList keys            = (ArrayList)session.getValue("arrayKeys");

if(keys == null)
{
	keys = new ArrayList();
}
String flagYN = request.getParameter("flagYN")==null ? "N" : request.getParameter("flagYN");
int counter   = request.getParameter("counter")==null ? 0 : Integer.parseInt(request.getParameter("counter"));

String indi         =  "";
String sql          =  "";

int maxRecord       =  0;
int start           =  0;
int end             =  0;
int i               =  1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;


%>

<%
		
	con					=	ConnectionManager.getConnection(request);
	dispid				=	checkForNull(request.getParameter("dispid"));
	indi				=	checkForNull(request.getParameter("indi"));
	if(indi.equals("null")||indi==null) indi="";
	String removeValue = "";
	String countsql ="select  count(*)  FROM QA_QIND_CLIND  A,QA_QIND_DISCIPLINE_CLIND B WHERE B.QIND_DISCIPLINE_ID(+) ='"+dispid+"' and A.QIND_CLIND_ID=B.QIND_CLIND_ID(+)  and A.QIND_CLIND_ID like '"+indi+"%'";
	hashIndicator   = (HashMap)session.getValue("hashIndicator");
	if(hashIndicator == null)
	{
		hashIndicator = new HashMap();
	}
	int count_value=0;
	if(hashIndicator != null)
	{
		
		for(int index=0 ;index < count;index++)
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

						hashIndicator.remove(removeValue);
						counter++;
					}
					}
				}
		
	}
	pstmt	=	con.prepareStatement(countsql);
	rset    =   pstmt.executeQuery();
  	if ((rset != null) && (rset.next()))
	{
		count_value= rset.getInt(1);
		maxRecord=count_value;
	}   if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
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
		 sql="select  A.QIND_CLIND_ID CLINDID,A.QIND_CLIND_DESC   QIND_DISCIPLINE_DESC,DECODE(B.QIND_DISCIPLINE_ID,'"+dispid+"','CHECKED','UNCHECKED')  CHECKED_YN FROM QA_QIND_CLIND  A,QA_QIND_DISCIPLINE_CLIND  B WHERE B.QIND_DISCIPLINE_ID(+)='"+dispid+"' and A.QIND_CLIND_ID=B.QIND_CLIND_ID(+)  and A.QIND_CLIND_ID like '"+indi+"%' ORDER BY TO_NUMBER(A.QIND_CLIND_ID)";

	}

	pstmt = con.prepareStatement(sql);
	rset  = pstmt.executeQuery();
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
		<th nowrap>Description</th>
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
			clindid           = checkForNull(rset.getString("CLINDID"));
			qind_clind_desc   = checkForNull(rset.getString("QIND_DISCIPLINE_DESC"));
	        checked_yn        = rset.getString("CHECKED_YN");
            strKey = dispid + "~" + clindid;
			
			if(checked_yn.equals("CHECKED"))
				{
				
			strValue = ""+"I";
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
			clindid           = checkForNull(rset.getString("CLINDID"));
			qind_clind_desc   = checkForNull(rset.getString("QIND_DISCIPLINE_DESC"));
	        checked_yn        = rset.getString("CHECKED_YN");
           	strKey            = dispid + "~" + clindid;
			strValue          = ""+"I";

			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
						
			if(hashIndicator != null)
			{
				tempString = hashIndicator.get(strKey) == null ? "" : (String) hashIndicator.get(strKey) ;
			    
				
				if(!tempString.equals(""))
				{
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
				<td class="<%=class_value%>" nowrap align=center  width=10%><%=clindid%></td>
			<input type=hidden name=qd<%=n% id=qd<%=n%> value='<%=clindid%>'>	
			<td class="<%=class_value%>"  width=15% nowrap > <%=qind_clind_desc%> &nbsp;&nbsp;
				</td>
				
			   
				<td class="<%=class_value%>" nowrap align=center>
				<input type=checkbox  onclick="chkValue(this,<%=n%>)"  name='strKey<%=n%>' 					value ='<%=strKey%>'  <%=checked_yn%>  value='<%=strKey%>' > </td>
                 <input type=hidden name=h<%=n% id=h<%=n%>>
				<input type=hidden name='strValue<%=n%>' id='strValue<%=n%>'>
				<input type=hidden name='removedValue<%=n%>' id='removedValue<%=n%>'>
			</tr>
			<%
			

			i++;
		n++;
		
		}
		}if(pstmt!=null) pstmt.close();
		 if(rset!=null)  rset.close();
%>
</table>

</div>
<input type=hidden name='count' id='count' value=<%=i%>>

	
<input type='hidden' name=dispid id=dispid value=<%=dispid%>>
<input type='hidden' name=indi id=indi value=<%=indi%>>

<input type='hidden' name='n' id='n' value=<%=n%>>
<input type='hidden' name='fnname' id='fnname' value="Insert">
<input type='hidden' name='insert_table' id='insert_table' value='Y'>
<input type='hidden' name='flagYN' id='flagYN' value='Y'>
<input type='hidden' name='temp' id='temp'>
<input type="Hidden" name="from" id="from" value="<%=from%>">
<input type="Hidden" name="to" id="to" value="<%=to%>">
<input type="Hidden" name="counter" id="counter" value="<%=counter%>">
<%
	
	session.putValue("hashIndicator",hashIndicator);
	session.putValue("arrayKeys",keys);
	}

	catch (Exception e){
	out.println("Exception in QAIndicatorsForDiscipline2"+e.toString());
	}
	finally {
			
		 ConnectionManager.returnConnection(con,request);
	}

%>
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

