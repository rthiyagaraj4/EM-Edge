<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eMR/js/SSOrderCatalog.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<form name="ssorderresult" id="ssorderresult" action="../../servlet/eMR.OrderCatalogForReportServlet" method='post' target="messageFrame">
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rs				= null;
	ResultSet	rset			= null;
	//ResultSet	rset1			= null;
	ResultSet	rset2			= null;

	String selalpha				= "";
	String classValue			= "";
	//String str21				= "";
	String str22				= "";
	String ord_cat				= "";
	String chkd					= "";
	String order_catalog_code	= "";
	String diag_code	= "";
	String dbvalue				= "";
	String report_id			= "";
	String group_code			= "";
	String sub_group_code		= "";
	
	StringBuffer concat	  	= new StringBuffer("");
    String master= "";
	String alphadescription="";
     String searchby="";
	 String searchcrt="";
	int maxrecord =0;
	int count     =0;
	try
	{

	dbvalue						= checkForNull(request.getParameter("alphabet"));
	report_id					= checkForNull(request.getParameter("report_id"));
	group_code					= checkForNull(request.getParameter("group_code"));
	sub_group_code				= checkForNull(request.getParameter("sub_group_code"));
     
	searchby					= checkForNull(request.getParameter("searchby"));
	 searchcrt					= checkForNull(request.getParameter("searchcrt"));
	alphadescription				= checkForNull(request.getParameter("alphadescription"));
	master   = checkForNull(request.getParameter("reference"));
	//String sp_mast_table_name_reference   = checkForNull(request.getParameter("sp"));

    dbvalue						= dbvalue.trim();
	report_id					= report_id.trim();
	group_code					= group_code.trim();
	sub_group_code				= sub_group_code.trim();
	
	con				            = ConnectionManager.getConnection(request);
	stmt			            = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
   
    ArrayList hr				= new ArrayList();
	rs = stmt.executeQuery("select distinct upper(substr(short_desc,1,1))selaplha  from or_order_catalog where short_desc between 'A%' AND 'Z%' Order by selaplha");// Modified by Kamatchi S for ML-MMOH-SCF-2007
	while (rs.next())
	{
		selalpha = rs.getString("selaplha");
		hr.add(selalpha);
	}

    if(rs != null )rs.close();
		
 if(!alphadescription.equals("") && report_id.equals("MRIPCSMH") && master.equals("IC")) {} else {%>
  <table cellspacing=0 cellpadding=0 width='100%' border=1>
	
	<tr id='alpha'>
	<%
	  Iterator e7 = hr.iterator();
	         
	  while(e7.hasNext())
	   {
		 String jj = (String)e7.next();
	%>
<TD colspan='2' >
 <a href="javascript:callMember('<%=jj%>')"><%=jj%></a>&nbsp;&nbsp;
			
  <%}
  %>
		&nbsp;&nbsp;</td><td>
 <a href="javascript:callMember('Others')"><fmt:message key="Common.others.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;
</TD>
</TR>
</table>
<%}%>
 <table cellspacing=0 cellpadding=0 width='100%' border=1>
   <%if(report_id.equals("MRIPCSMH")){%>
	    <th align="left" width=15%>Diag Code</th>
		<th align="left" width=70%>Description</th>
		
		<th width=15%>Select</th></tr>
	<%}else {%>
	   <th align="left" width=60%>Description</th>
		<th width=20%>Order Srl No</th>
		<th width=20%>Select</th></tr>
	<%}%>
			<% 
			  if(dbvalue.equals("Others"))
			   {
					
					if(report_id.equals("MRBRADEX") || report_id.equals("MRBLABRG"))
					{
						str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'RD' and eff_status = 'E' and upper(substr(long_desc,1,1)) not between 'A' and 'Z' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )  and (sub_group_code = '"+sub_group_code+"' or sub_group_code is not null )) UNION select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"'  and a.sub_group_code ='"+sub_group_code+"'  and upper(substr(report_desc,1,1)) not between 'A' and 'Z' order by 2";
						
					}
					else if(report_id.equals("MRBLABWL"))
				    {
                         str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'LB' and eff_status = 'E' and upper(substr(long_desc,1,1)) not between 'A' and 'Z' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )) UNION select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and upper(substr(report_desc,1,1)) not between 'A' and 'Z' order by 2";
					}
					//Newly added by Shyam on 16/12/2005 for PD-205 and Master is IC
					/*else if(report_id.equals("MRIPCSMH"))
				     {
							
							str22="select diag_srl_no, short_desc, 'N' chkd from mr_icd_code where upper(substr(long_desc,1,1)) not between 'A' and 'Z' and to_char(diag_srl_no) not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"'  and (group_code ='"+group_code+"' or group_code is not null ))UNION select to_number(a.mast_code) diag_srl_no, b.short_desc,  'Y' chkd from mr_report_mapping a, mr_icd_code b where a.mast_code = b.diag_srl_no and a.report_id = '"+report_id+"' and a.group_code = '"+group_code+"' and upper(substr(report_desc,1,1)) not between 'A' and 'Z'  order by 2";
					 }*/
					 //end 
					 else
					 {
						 str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'TR' and eff_status = 'E' and upper(substr(long_desc,1,1)) not between 'A' and 'Z' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )) UNION select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and upper(substr(report_desc,1,1)) not between 'A' and 'Z' order by 2";
						
					}
					 
				 
			   }
			 else
				{
					 
					 if(report_id.equals("MRBRADEX") || report_id.equals("MRBLABRG"))
					 {
							 str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'RD' and eff_status = 'E' and UPPER (long_desc) LIKE '"+dbvalue+"%' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )  and (sub_group_code = '"+sub_group_code+"' or sub_group_code is not null )) UNION  select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"' and UPPER (b.long_desc) LIKE '"+dbvalue+"%' order by 2";
					 }
					 else if(report_id.equals("MRBLABWL"))
				     {
							 str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'LB' and eff_status = 'E' and UPPER (long_desc) LIKE '"+dbvalue+"%' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null)) UNION  select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and UPPER (b.long_desc) LIKE '"+dbvalue+"%' order by 2";
					 }
					 //Newly added for PD-205 BY SHYAM ON 15/12/2005
					 else if(report_id.equals("MRIPCSMH"))
				     {
							
							//str22="select diag_code,diag_srl_no, short_desc, 'N' chkd from mr_icd_code where ";  JIT 27/may/2016
							str22="select term_code diag_code, 1 diag_srl_no, short_desc, 'N' chkd from mr_term_code where ";
							if(searchby.equals("D"))
							{
								if(searchcrt.equals("C"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
							}
							else if(searchby.equals("C"))
							{
								/*if(searchcrt.equals("C"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '"+alphadescription+"%')";&*/ //  JIt 27-may -2016

								if(searchcrt.equals("C"))
								str22=str22+" UPPER (term_code) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (term_code) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (term_code) LIKE  upper( '"+alphadescription+"%')";
							}
							//str22=str22+" and to_char(diag_srl_no) not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"'  and (group_code ='"+group_code+"' or group_code is not null ))UNION select b.diag_code,to_number(a.mast_code) diag_srl_no, b.short_desc,  'Y' chkd from mr_report_mapping a, mr_icd_code b where a.mast_code = to_char(b.diag_srl_no) and a.report_id = '"+report_id+"' and a.group_code = '"+group_code+"' and "; JIT 27/may/2016
							str22=str22+" and term_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"'  and (group_code ='"+group_code+"' or group_code is not null ))UNION select b.term_code diag_code, 1 diag_srl_no ,b.short_desc,  'Y' chkd from mr_report_mapping a, mr_term_code b where a.mast_code = b.term_code and a.report_id = '"+report_id+"' and a.group_code = '"+group_code+"' and ";
							if(searchby.equals("D"))
							{
								if(searchcrt.equals("C"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
							}
							else if(searchby.equals("C"))
							{
								/*if(searchcrt.equals("C"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '"+alphadescription+"%')";*/// jit 27th mau 2016

								if(searchcrt.equals("C"))
								str22=str22+" UPPER (term_code) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (term_code) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (term_code) LIKE  upper( '"+alphadescription+"%')";
							}
							if(searchby.equals("D"))
								str22=str22+" order by 2";
							else if(searchby.equals("C"))
								str22=str22+" order by 1";
							
					 }
					 ///END
					 else
						{
					
							str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'TR' and eff_status = 'E' and UPPER (long_desc) LIKE '"+dbvalue+"%' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )) UNION  select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and UPPER (b.long_desc) LIKE '"+dbvalue+"%' order by 2";
						}
				
				}
				
				int i=1;
				//stmt			= con.createStatement();
				 if(!report_id.equals("MRIPCSMH")){
				 String supsql="select order_by_srl_no from mr_report_mapping where report_id ='"+report_id+"' and group_code = '"+group_code+"' and sub_group_code ='"+sub_group_code+"'";
				 
                 rset2=stmt.executeQuery(supsql);
				 while(rset2.next())
				 {
					  concat.append(rset2.getString("order_by_srl_no")+"#");
					   
				 }
				 if(rset2!=null) rset2.close();

                  concat.append("1000#");
				 }
				  rset	= stmt.executeQuery(str22);
		  
                     
				 if(rset!=null)
				 {
					rset.last();
			        maxrecord = rset.getRow();
			        rset.beforeFirst();
					while(rset.next())
					{
						 if(report_id.equals("MRIPCSMH"))
						{
							// order_catalog_code = rset.getString("diag_srl_no");
							 order_catalog_code = rset.getString("diag_code");//Modified by Dharma
						     ord_cat            = rset.getString("short_desc");
							 diag_code          = rset.getString("diag_code");
						}
						else
						{
						 order_catalog_code = rset.getString("order_catalog_code");
						 ord_cat            = rset.getString("long_desc");
						 count              = rset.getInt("count");
						}
						 chkd               = rset.getString("chkd");
	                    
						
				if ( (i+1) % 2 == 0 )
						classValue = "QRYEVEN" ;
				else
						classValue = "QRYODD" ;
						
			%>    
				<tr>
			  <input type="hidden" name="count1" id="count1" value=<%=i%>>	
			<% if(report_id.equals("MRIPCSMH")){%>
				<td class='<%=classValue%>'><%=diag_code%> </td>
			<%}%>
			<td class='<%=classValue%>'><%=ord_cat%> </td>
			   <input type="hidden" name="ord_cat<%=i%>" id="ord_cat<%=i%>" value="<%=ord_cat%>">
			   <input type="hidden" name="order_catalog_code<%=i%>" id="order_catalog_code<%=i%>" value="<%=order_catalog_code%>">
			 <% 
			  if(count > 0)
			  { 
				   if(report_id.equals("MRIPCSMH")){%>
                   
				   <%}else {%>
			       <td class='<%=classValue%>' align=center>
			       <INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='3' onkeypress="return allowPositiveNumber()"  value="<%=count%>" maxLength='3' onBlur="chkdup(this)"></td>
			  <%}}else { 
				    if(report_id.equals("MRIPCSMH")){%>
                     <%}else {%>
			      <td class='<%=classValue%>' align=center>
			      <INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='3'  maxLength='3' onkeypress="return allowPositiveNumber()" value="" onBlur="chkdup(this)"></td>
		     <%}} 
			 if(chkd.equals("N")) {%>
				 <td class='<%=classValue%>' align='center'><input type='checkbox' name='inc<%=i%>' id='inc<%=i%>' value='<%=chkd%>' onClick='funchk(this)'></td>
			<%} 
			  else {%>
     			 <td class='<%=classValue%>' align='center'><input type='checkbox' name='inc<%=i%>' id='inc<%=i%>' value='<%=chkd%>' checked onClick='funchk(this)'></td>
	    	<%}%>
	
				
					<% i++;
					}if(rset!=null) rset.close(); %>
				</tr>
						
			<%		
					

				
				}
				   
				if(maxrecord==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}%>
				</table>
				 <input type ='hidden' name ='alphabet' value =''>
				 <input type ='hidden' name ='report_id' value ='<%=report_id%>'>
				 <input type ='hidden' name ='group_code' value ='<%=group_code%>'>
				 <input type ='hidden' name ='sub_group_code' value ='<%=sub_group_code%>'>
				 <input type ='hidden' name ='maxrecord' value ='<%=maxrecord%>'>
				 <input type ='hidden' name ='maxrecord1' value ='<%=i%>'>
				 <input type ='hidden' name ='concat' value ='<%=concat.toString()%>'>
				 <input type ='hidden' name ='mast_table_name_reference'  value ='<%=master%>'>
				 
<%  if(stmt!=null) stmt.close();
   //if(rs!=null) rs.close();
   }
  catch(Exception e)
  {
	  //out.println("Exception in File SSOrderCatalogLinkResult"+e.toString());
	  e.printStackTrace();
  }
   finally
 {
    ConnectionManager.returnConnection(con,request);
 }

 %>	
</form>
</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>


