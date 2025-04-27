<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="adverseReaction1" class="webbeans.eCommon.RecordSet" scope="session"/>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<head><title><fmt:message key="Common.Reaction.label" bundle="${common_labels}"/></title>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
    <!-- <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
   <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
 <script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>

</head>
<%
	  
	  Connection con = ConnectionManager.getConnection(request);
	  ResultSet rs   = null;
	  Statement stmt = null;
	  HashSet tabdata;	
	  HashSet tabdata1;	
	  String adv_reac_code="";
	  String adv_reac_code1="";
	  String long_desc = "";
	  String reac_val="";
	 // String react_val1="";
	  String react_val2="";
	  String dsib="";
		boolean first_time			= true;
		String allergenCode = "";
		StringBuffer allergenCodelist = new StringBuffer();
		StringBuffer allergenCodelist1 = new StringBuffer();
		StringBuffer reac_caused = new StringBuffer();
	  ArrayList a= new ArrayList();
	  a= adverseReaction1.getRecordSetHandle();
	  int size=0;
	  size=a.size();
	  String locale = (String)session.getAttribute("LOCALE");
	   String react_val=request.getParameter("react_val")==null?"":request.getParameter("react_val");
	   String allergen=request.getParameter("allergen")==null?"":request.getParameter("allergen");
	   String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	   	String flag=request.getParameter("flag")==null?"":request.getParameter("flag");
	   	String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
		String event_done=request.getParameter("event_done")==null?"":request.getParameter("event_done");
		//String errorMsg=request.getParameter("errorMsg")==null?"":request.getParameter("errorMsg");
		String checkedRec=request.getParameter("checkedRec")==null?"":request.getParameter("checkedRec");
		String onblurRec=request.getParameter("onblurRec")==null?"N":request.getParameter("onblurRec");

	   //	String adv_event_ind=request.getParameter("adv_event_ind")==null?"":request.getParameter("adv_event_ind");
	   //	String adv_event_type=request.getParameter("adv_event_type")==null?"":request.getParameter("adv_event_type");
	   //	String patientId=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");


	try 
	{
	
		
	%>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'view_form'>

		<%
		//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt=con.createStatement();
		tabdata = new HashSet();
		tabdata1 = new HashSet();
		if(mode.equals("record"))
		{
			 for(int j=0;j<size;j++)
				{
					react_val2=a.get(j).toString();
					if(!react_val2.equals(""))
					{
						StringTokenizer token=new StringTokenizer(react_val2,"@");
						while(token.hasMoreTokens()){
							reac_val=token.nextToken();
							tabdata1.add(reac_val);
						}
					}
				}
		}
		 if(mode.equals("record") )
		{
			 if(react_val.equals(""))
			 {
				 for(int i=0;i<size;i++)
				{
					 
					react_val2=a.get(i).toString();
					if(!react_val2.equals(""))
					{
						StringTokenizer token=new StringTokenizer(react_val2,"@");
						while(token.hasMoreTokens()){
							reac_val=token.nextToken();
							tabdata.add(reac_val);
						}
					}
				}
			 }else
			{
				StringTokenizer token=new StringTokenizer(react_val,"@");
				while(token.hasMoreTokens()){
				reac_val=token.nextToken();
				
				tabdata.add(reac_val);
			}
			}
			allergenCodelist1.setLength(0);
			if(!react_val.equals(""))
			{
				StringTokenizer token=new StringTokenizer(react_val,"@");
				while(token.hasMoreTokens()){
					reac_val=token.nextToken();
					tabdata.add(reac_val);
					if(first_time){
					allergenCode="'"+reac_val+"',";
								}else{
					allergenCode=allergenCode+"'"+reac_val+"',";
					}
				first_time = false;
				}
				if(allergenCode!=""){
				allergenCode =allergenCode.substring(0,allergenCode.length()-1);
				}
				allergenCodelist1.append(allergenCode) ;
			}
			allergenCodelist.setLength(0);
			if(!checkedRec.equals(""))
			{
				StringTokenizer token=new StringTokenizer(checkedRec,"@");
				while(token.hasMoreTokens()){
				reac_val=token.nextToken();
				tabdata.add(reac_val);
				if(first_time){
					allergenCode="'"+reac_val+"',";
								}else{
					allergenCode=allergenCode+"'"+reac_val+"',";
					}
				first_time = false;
				
				}
				if(allergenCode!=""){
				allergenCode =allergenCode.substring(0,allergenCode.length()-1);
				}
				allergenCodelist.append(allergenCode) ;
			}
		}else 
		{
			allergenCodelist1.setLength(0);
			if(!react_val.equals(""))
			{
				StringTokenizer token=new StringTokenizer(react_val,"@");
				while(token.hasMoreTokens()){
					reac_val=token.nextToken();
					tabdata.add(reac_val);
					if(first_time){
					allergenCode="'"+reac_val+"',";
								}else{
					allergenCode=allergenCode+"'"+reac_val+"',";
					}
				first_time = false;
				}
				if(allergenCode!=""){
				allergenCode =allergenCode.substring(0,allergenCode.length()-1);
				}
				allergenCodelist1.append(allergenCode) ;
			}
			allergenCodelist.setLength(0);
			if(!checkedRec.equals(""))
			{
				StringTokenizer token=new StringTokenizer(checkedRec,"@");
				while(token.hasMoreTokens()){
				reac_val=token.nextToken();
				tabdata.add(reac_val);
				if(first_time){
					allergenCode="'"+reac_val+"',";
								}else{
					allergenCode=allergenCode+"'"+reac_val+"',";
					}
				first_time = false;
				
				}
				if(allergenCode!=""){
				allergenCode =allergenCode.substring(0,allergenCode.length()-1);
				}
				allergenCodelist.append(allergenCode) ;
			}
		}
		
		String checkBoxAttribute1="";
		int maxRecord=0;
		int maxRecordCnt=0;
		int i=0;
		int rowcolor=0;
		if(rs !=null) rs.close();
			reac_caused.setLength(0);
			reac_caused.append("select count(1)  from (select '#'ORD,REACTION_CODE REACTION_CODE ,LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW Where REACTION_CODE LIKE 'UNKN%' and language_id='"+locale+"' and EFF_STATUS='E' UNION select '$' ORD,a.REACTION_CODE REACTION_CODE,a.LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where a.REACTION_CODE=b.ADV_REAC_CODE AND UPPER(a.LONG_DESC) like upper('"+search_text+"%') and a.language_id='"+locale+"' ");
			if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
				reac_caused.append(" and b.ALLERGEN_CODE='"+allergen+"' ");
			reac_caused.append(" and a.EFF_STATUS='E') ORDER BY reaction_code ");

			rs=stmt.executeQuery(reac_caused.toString());
			if(rs !=null && rs.next())
					maxRecordCnt = rs.getInt(1);
			if(maxRecordCnt > 0)
			{
			reac_caused.setLength(0);
			if(!checkedRec.equals(""))
			{
				reac_caused.append("select REACTION_CODE ,LONG_DESC   from (select '#'ORD,REACTION_CODE REACTION_CODE ,LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW Where ");
				if(search_text.equals(""))
					reac_caused.append(" REACTION_CODE LIKE 'UNKN%' ");
				else
					reac_caused.append(" ( REACTION_CODE LIKE 'UNKN%' or reaction_code in ("+allergenCodelist+")) ");
				reac_caused.append(" and language_id='"+locale+"' and EFF_STATUS='E' UNION select '$' ORD,a.REACTION_CODE REACTION_CODE,a.LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where (a.REACTION_CODE=b.ADV_REAC_CODE) ");
				reac_caused.append(" AND UPPER(a.LONG_DESC) like upper('"+search_text+"%') ");
				reac_caused.append(" and a.language_id='"+locale+"' ");
				if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					reac_caused.append(" and  b.ALLERGEN_CODE='"+allergen+"' ");
				reac_caused.append(" and a.EFF_STATUS='E' ");
				if(onblurRec.equals("Y"))
					reac_caused.append(" and a.reaction_code not in (SELECT reaction_code  FROM am_reaction_lang_vw WHERE (reaction_code LIKE 'UNKN%' OR reaction_code IN ("+allergenCodelist+")) AND language_id = '"+locale+"'     AND eff_status = 'E') ");
				reac_caused.append(" ) ORDER BY reaction_code ");
			}else if(!react_val.equals("")){
				reac_caused.append("select REACTION_CODE ,LONG_DESC   from (select '#'ORD,REACTION_CODE REACTION_CODE ,LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW Where ");
				if(search_text.equals(""))
					reac_caused.append(" REACTION_CODE LIKE 'UNKN%' ");
				else
					reac_caused.append(" ( REACTION_CODE LIKE 'UNKN%' or reaction_code in ("+allergenCodelist1+")) ");
				reac_caused.append(" and language_id='"+locale+"' and EFF_STATUS='E' UNION select '$' ORD,a.REACTION_CODE REACTION_CODE,a.LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where (a.REACTION_CODE=b.ADV_REAC_CODE) ");
				reac_caused.append(" AND UPPER(a.LONG_DESC) like upper('"+search_text+"%') ");
				reac_caused.append(" and a.language_id='"+locale+"' ");
				if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					reac_caused.append(" and  b.ALLERGEN_CODE='"+allergen+"' ");
				reac_caused.append(" and a.EFF_STATUS='E' ");
				if(onblurRec.equals("Y"))
					reac_caused.append(" and a.reaction_code not in (SELECT reaction_code  FROM am_reaction_lang_vw WHERE (reaction_code LIKE 'UNKN%' OR reaction_code IN ("+allergenCodelist1+")) AND language_id = '"+locale+"'     AND eff_status = 'E') ");
				reac_caused.append(" ) ORDER BY reaction_code ");
			}
			else
			{
				reac_caused.append(" select REACTION_CODE ,LONG_DESC   from (select '#'ORD,REACTION_CODE REACTION_CODE ,LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW Where REACTION_CODE LIKE 'UNKN%' and language_id='"+locale+"' and EFF_STATUS='E' UNION select '$' ORD,a.REACTION_CODE REACTION_CODE,a.LONG_DESC  LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where a.REACTION_CODE=b.ADV_REAC_CODE AND UPPER(a.LONG_DESC) like upper('"+search_text+"%') and a.language_id='"+locale+"' ");
				if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
					reac_caused.append(" and  b.ALLERGEN_CODE='"+allergen+"' ");
				reac_caused.append(" and a.EFF_STATUS='E') ORDER BY reaction_code");
			}
			//if(rs !=null) rs.close();
			//if(stmt !=null) stmt.close();
			rs=stmt.executeQuery(reac_caused.toString());
			/*rs.last();
			count = rs.getRow();
			rs.beforeFirst();
			if(count >0)*/
		if(rs !=null)
		{
			while(rs.next())
			{
			if(maxRecord == 0)
		{	%>
	<table cellpadding='0'  border='1' cellspacing='0' width='100%' align='left' >	
		<th><div  id='head1' class='myClass' nowrap width='25%'><fmt:message key="Common.ReactionCode.label" bundle="${common_labels}"/></div></th>
		<th><div  id='head2' class='myClass' nowrap width='25%'><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></div></th>
		<th><div  id='head3' class='myClass' nowrap  width='25%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' onClick='selectAll_S(this);' /></div></th>

<%		}
		/*if(rs !=null)
		{

			while(rs.next())
			{*/
				long_desc=rs.getString("LONG_DESC");
				adv_reac_code=rs.getString("REACTION_CODE");
				if(flag.equals("N"))
				{
					dsib="disabled";
				}else
				{
					dsib="";
				}
			
				if(!adv_reac_code.equals(adv_reac_code1))
				{
					if(tabdata.contains(adv_reac_code))
					{
						checkBoxAttribute1="CHECKED";
					}else
					{
						checkBoxAttribute1="";
					}
%>				
				<tr>
					<td align='left' class='label' nowrap >&nbsp;<%=adv_reac_code%>&nbsp</td>
					<td align='left' class='label' nowrap >&nbsp;<%=long_desc%>&nbsp;</td>
					<td align='center' class='label' nowrap ><input type=checkbox name='checkBox<%=i%>' id='checkBox<%=i%>' value='' onClick="javascript:react_chkbox(this,'<%=i%>');" <%=checkBoxAttribute1%> <%=dsib%>>
					<input type='hidden' name='reaction_code_index<%=i%>' id='reaction_code_index<%=i%>' value=''>
					<input type='hidden' name='ret_value' id='ret_value' value='<%=adv_reac_code%>'>
					<input type='hidden' name='reaction_code<%=i%>' id='reaction_code<%=i%>' value='<%=adv_reac_code%>'>	&nbsp;</td>
				</tr>
				<%
					i=i+1;
					rowcolor++;	
				}
				adv_reac_code1=rs.getString("REACTION_CODE");
				maxRecord++;
			}
			
			}
		}
		//else
		//{
		if(maxRecordCnt == 0)
		{
			%>
			<script>
				var error=getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
				alert(error);
				if(parent.frames[0].document.forms[0])
				{
					if(parent.frames[0].document.forms[0].search_text.value != "")
					{
						parent.frames[0].document.forms[0].search_text.value = "";
						valtextReaction(parent.frames[0].document.forms[0].search_text.value);
					}
				}
			</script>
			<%
		}
		%>
			<input type='hidden' name='count_reac' id='count_reac' value='<%=rowcolor%>'>
			<input type='hidden' name='finalval' id='finalval' value=''>
			<input type='hidden' name='react_val' id='react_val' value='<%=react_val%>'>
			<input type='hidden' name='event_done' id='event_done' value='<%=event_done%>'>
		<%
			if(rs !=null) rs.close();
		  if(stmt !=null) stmt.close();
     } catch(Exception e) {
          //out.println(e.toString());
		  e.printStackTrace();
          if(rs !=null) rs.close();
		  if(stmt !=null) stmt.close();
     }
     finally {
    
		  ConnectionManager.returnConnection(con,request);
     }
%>
  </form>
</body>
<script>if(parent.frames[0].document.forms[0])
{
	parent.frames[0].document.forms[0].Search.disabled=false;
}
</script>
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

