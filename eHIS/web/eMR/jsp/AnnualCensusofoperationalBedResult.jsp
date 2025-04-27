<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<!-- <script src='../../eMR/js/eMRmessages.js' language='javascript'></script> -->
	<Script src="../../eCommon/js/ValidateControl.js" Language="JavaScript"></Script>
	<script src='../../eMR/js/AnnualCensusofoperationalBed.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()">

<form name="annualCenoperationalBedresult" id="annualCenoperationalBedresult" action="../../servlet/eMR.AnnualCensusOfoperationalBedServlet" method='post' target="messageFrame">
<% 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rset			= null;
	//ResultSet	rset2			= null;//commented for checkstyle by munisekhar
	//ResultSet	rset3			= null;//commented for checkstyle by munisekhar
	StringBuffer sb=null;
	String classValue			= "";
	//String ord_cat				= "";//commented for checkstyle by munisekhar
	String chkd					= "";
	//String tab_list_no			= "";//commented for checkstyle by munisekhar
	String report_id			= "";
	String group_code			= "";
	String sub_group_code		= "";	
	String type					= "";
	StringBuffer concat		= new StringBuffer("");
	//String code_from			= "";//commented for checkstyle by munisekhar
	//String code_to				= "";//commented for checkstyle by munisekhar
	//String code_desc			= "";//commented for checkstyle by munisekhar
	//String group_type			= "";//commented for checkstyle by munisekhar
	String census_date			= "";
	int		maxrecord			= 0;
	//float   count_float			= 0; //commented for checkstyle by munisekhar
	int		count				= 0;
	int		countr1				= 0;
	int		countr2				= 0;
	int		countr3				= 0;
	int		countr4				= 0;
	try
	{
		type						= checkForNull(request.getParameter("alphabet"));
		report_id					= checkForNull(request.getParameter("report_id"));
		group_code					= checkForNull(request.getParameter("group_code"));
		sub_group_code				= checkForNull(request.getParameter("sub_group_code"));
		census_date		= checkForNull(request.getParameter("census_date"));
		type						= type.trim();
		report_id					= report_id.trim();
		group_code					= group_code.trim();
		sub_group_code				= sub_group_code.trim();
		con				            = ConnectionManager.getConnection(request);
		stmt			            = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	%>
	<table cellspacing=0 cellpadding=0 width='98%' border=1 align='center'>
   <tr>
	<th align="left" width=15%>Bed Class Group</th>	
    <th align="left" width=45%>Bed Class Group Description</th>
	 <% 
	 if(report_id.equals("MRIPCSOBD"))
		{%>
		<!--Child field Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] -->
		<!--<th width=20%>Comm&nbsp;Male&nbsp;Female&nbsp;</th>-->
		<th align="left" width=8%>Comm</th>
		<th align="left" width=8%>Male</th>
		<th align="left" width=8%>Female</th>
		<th align="left" width=8%>Child</th> <!-- added by Mujafar on 25th June 2019 against ML-MMOH-CRF-1345 -->
		<%}%>
		<!-- <th width=20%>Order Serial No</th> -->		
		<th width=20%>Select</th>
	</tr>
	<% 
	
	 // int p=0; //commented for checkstyle by munisekhar
	  sb = new StringBuffer();
	  
           if(type.equals("BD"))
		  {
				/* sb.append("SELECT BED_CLASS_CODE mast_code, short_desc, 0 cnt1, 0 cnt2, 0 cnt3, 0 cnt4, NULL group_code, 'N' chkd FROM ip_bed_class WHERE BED_CLASS_CODE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"'  )) UNION SELECT  a.BED_CLASS_GROUP_CODE mast_code, (SELECT short_desc from ip_bed_class where BED_CLASS_CODE = a.BED_CLASS_GROUP_CODE) short_desc,COMM_BED_CNT cnt1,MALE_BED_CNT cnt2,FEMALE_BED_CNT cnt3,CHILD_BED_CNT cnt4, a.group_code, 'Y' chkd FROM MR_ANNUAL_CENSUS_OF_BED a WHERE   a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'" );*/

				//cnt4 removed by by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120]
				//cnt4 added by Mujafar on 25th June 2019 against ML-MMOH-CRF-1345 

				 sb.append("SELECT BED_CLASS_CODE mast_code, short_desc, 0 cnt1, 0 cnt2, 0 cnt3,0 cnt4, NULL group_code, 'N' chkd FROM ip_bed_class WHERE BED_CLASS_CODE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"'  )) UNION SELECT  a.BED_CLASS_GROUP_CODE mast_code, (SELECT short_desc from ip_bed_class where BED_CLASS_CODE = a.BED_CLASS_GROUP_CODE) short_desc,COMM_BED_CNT cnt1,MALE_BED_CNT cnt2,FEMALE_BED_CNT cnt3,CHILD_BED_CNT cnt4, a.group_code, 'Y' chkd FROM mr_annual_census_of_opr_bed a WHERE   a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'" );
		  }
		  else if(type.equals("SP") && report_id.equals("MRIPCSOBD"))
		  {
				/*sb.append("SELECT GROUP_CODE mast_code, group_desc short_desc,0 cnt, 0 cnt1, 0 cnt2, 0 cnt3, 0 cnt4, NULL group_code, 'N' chkd FROM mr_report_grouping WHERE report_id =  'MRIPCSOBD' AND mast_table_name_reference = 'BD' AND GROUP_CODE NOT IN (SELECT BED_CLASS_GROUP_CODE FROM MR_ANNUAL_CENSUS_OF_BED WHERE ( GROUP_CODE = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"'  ) and to_char(census_year,'YYYY') = '"+census_date+"') UNION SELECT  a.BED_CLASS_GROUP_CODE mast_code, (SELECT group_desc from mr_report_grouping where group_code = a.BED_CLASS_GROUP_CODE) short_desc,0 cnt,COMM_BED_CNT cnt1,MALE_BED_CNT cnt2,FEMALE_BED_CNT cnt3,CHILD_BED_CNT cnt4, a.group_code, 'Y' chkd FROM MR_ANNUAL_CENSUS_OF_BED a WHERE   a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"' and to_char(census_year,'YYYY') = '"+census_date+"'" );*/
				
				//cnt4 removed by by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120]
				//cnt4 added by Mujafar on 25th June 2019 against ML-MMOH-CRF-1345
				sb.append("SELECT GROUP_CODE mast_code, group_desc short_desc,0 cnt, 0 cnt1, 0 cnt2, 0 cnt3,0 cnt4, NULL group_code, 'N' chkd FROM mr_report_grouping WHERE report_id =  'MRIPCSOBD' AND mast_table_name_reference = 'BD' AND GROUP_CODE NOT IN (SELECT BED_CLASS_GROUP_CODE FROM mr_annual_census_of_opr_bed WHERE ( GROUP_CODE = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"'  ) and to_char(census_year,'YYYY') = '"+census_date+"') UNION SELECT  a.BED_CLASS_GROUP_CODE mast_code, (SELECT group_desc from mr_report_grouping where group_code = a.BED_CLASS_GROUP_CODE and report_id =  'MRIPCSOBD') short_desc,0 cnt,COMM_BED_CNT cnt1,MALE_BED_CNT cnt2,FEMALE_BED_CNT cnt3,CHILD_BED_CNT cnt4, a.group_code, 'Y' chkd FROM mr_annual_census_of_opr_bed a WHERE   a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"' and to_char(census_year,'YYYY') = '"+census_date+"'" );
		  }
			int i=1;
			 //String count_float_string="";//commented for checkstyle by munisekhar
			// stmt			= con.createStatement();
		    		    
			//out.println("SQL = "+sb.toString());	 
			rset	= stmt.executeQuery(sb.toString());
			
			if(rset!=null)
			 {
				rset.last();
				maxrecord = rset.getRow();
				rset.beforeFirst();
				while(rset.next())
				{
					
				    count              = rset.getInt("cnt");
					chkd               = rset.getString("chkd");			
					countr1             = rset.getInt("cnt1");
					countr2             = rset.getInt("cnt2");
					countr3             = rset.getInt("cnt3");
					countr4             = rset.getInt("cnt4");	//Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120]	
																//cnt4 added by Mujafar on 25th June 2019 against ML-MMOH-CRF-1345
					count              = rset.getInt("cnt");
   										                   
					 if ( (i+1) % 2 == 0 )
						 classValue = "QRYEVEN" ;
					 else
						 classValue = "QRYODD" ;
						
			       %>    
					<tr>
						<input type="hidden" name="count1" id="count1" value=<%=i%>>												
						
							<td class='<%=classValue%>'><%=rset.getString("MAST_CODE")%> </td>
							<td class='<%=classValue%>'>
							<%=checkForNull(rset.getString("short_desc"))%> </td>
							<input type="hidden" name="tab_list<%=i%>" id="tab_list<%=i%>" value="<%=checkForNull(rset.getString("short_desc"))%>">
							<input type="hidden" name="tab_list_no<%=i%>" id="tab_list_no<%=i%>" value="<%=rset.getString("mast_code")%>">
						
						<% //if(countr1 > 0)
							//{%>
								
								<% if(report_id.equals("MRIPCSOBD"))
								{%>
								<td class='<%=classValue%>' align=center>
								<%if(countr1>0){%><INPUT TYPE="text" name="textr1<%=i%>" id="textr1<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="<%=countr1%>" maxLength='3' >
								<% }else {%><INPUT TYPE="text" name="textr1<%=i%>" id="textr1<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="" maxLength='3' >
								<%}%></td><td class='<%=classValue%>' align=center>
								<%if(countr2>0){%><INPUT TYPE="text" name="textr2<%=i%>" id="textr2<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="<%=countr2%>" maxLength='3' >
							<%}else {%><INPUT TYPE="text" name="textr2<%=i%>" id="textr2<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="" maxLength='3' >
							<%}%></td><td class='<%=classValue%>' align=center>
								<%if(countr3>0){%>
								<INPUT TYPE="text" name="textr3<%=i%>" id="textr3<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="<%=countr3%>" maxLength='3' >
								<%}else {%><INPUT TYPE="text" name="textr3<%=i%>" id="textr3<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="" maxLength='3' >
								<%}%></td><td class='<%=classValue%>' align=center>
								<!--Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] 
								 added by Mujafar on 25th June 2019 against ML-MMOH-CRF-1345
								Start-->
								<%if(countr4>0){%>
								<INPUT TYPE="text" name="textr4<%=i%>" id="textr4<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="<%=countr4%>" maxLength='3' >
								<% }else {%><INPUT TYPE="text" name="textr4<%=i%>" id="textr4<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="" maxLength='3' >
								<%}%>
								<!--Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] 
								added by Mujafar on 25th June 2019 against ML-MMOH-CRF-1345
								End-->
								
								</td>
									<!-- <td class='<%=classValue%>' align=center>
									<INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='6' maxLength='3' onBlur="chkSerialno(this);" onkeypress="return allowPositiveNumber()"  value="<%=count%>" maxLength='3' onBlur="chkvalidnum(this);"></td> -->
								<%}
								else
								{}
						//	 }
						// else 
						//  {  if(report_id.equals("MRIPCSOBD"))
						//		{%>
								<!--<td class='<%=classValue%>' align=center>
								<INPUT TYPE="text" name="textr1<%=i%>" id="textr1<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="" maxLength='3' ><INPUT TYPE="text" name="textr2<%=i%>" id="textr2<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="" maxLength='3' ><INPUT TYPE="text" name="textr3<%=i%>" id="textr3<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="" maxLength='3' >
								-->
								<!--Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] Start-->
								<!--
								<INPUT TYPE="text" name="textr4<%=i%>" id="textr4<%=i%>" size='3' maxLength='3'  onkeypress="return allowPositiveNumber()"  value="" maxLength='3' ></td>
								-->
								<!--Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] End>

								<!-- <td class='<%=classValue%>' align=center>
								<INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='6'  maxLength='3' onBlur="chkSerialno(this);" onkeypress="return allowPositiveNumber()" value="" onBlur="chkdup(this); chkvalidnum(this);"></td> -->
								<%//}
						//		else
							//	{}
						//  }
						 if((chkd.equals("N"))||((countr1==0)&&(countr2==0)&&(countr3==0)))
						 {%>
								<td class='<%=classValue%>' align='center'><input type='checkbox' name='inc<%=i%>' id='inc<%=i%>' value='<%=chkd%>' onClick='funchk(this)'></td>
						<%} 
						else 
						{%>
								<td class='<%=classValue%>' align='center'><input type='checkbox' name='inc<%=i%>' id='inc<%=i%>' value='<%=chkd%>' checked onClick='funchk(this)'></td>
						<%}%>
						<% i++;
				}
				 if(rset!=null) rset.close(); %>
			</tr>
						
			<%		
			}
			   if(maxrecord==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}%>
				</table>
				 <input type ='hidden' name ='alphabet' value ='<%=type%>'>
				 <input type ='hidden' name ='report_id' value ='<%=report_id %>'>
				 <input type ='hidden' name ='group_code' value ='<%=group_code%>'>
				 <input type ='hidden' name ='sub_group_code' value ='<%=sub_group_code%>'>
				 <input type ='hidden' name ='census_date' value ='<%=census_date%>'>
				 <input type ='hidden' name ='maxrecord' value ='<%=maxrecord%>'>
				 <input type ='hidden' name ='maxrecord1' value ='<%=i%>'>
				 <input type ='hidden' name ='concat' value ='<%=concat.toString()%>'>
				 <input type ='hidden' name ='mast_table_name_reference' value ='<%=type%>'>
				 <input type ='hidden' name ='function_name1' value =''>
				 <input type ='hidden' name ='level_code' value =''>

				 
<%  if(stmt!=null) stmt.close();
   
   }
  catch(Exception e)
  {
	  //out.println("Exception in File AnnualCensusofoperationalBedResult"+e.toString());
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


