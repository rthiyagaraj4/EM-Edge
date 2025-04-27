<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="BatchBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
        <!-- <modifeid by Archana  @08-12-2008> -->
        
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/ClinicalRepMast.js'></script>


<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll="scrollTitle1()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>	

<form name="ClinicalEventGroupBatchBeanForm" id="ClinicalEventGroupBatchBeanForm">
<div id='divDataTitle'>
 <table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr ><td colspan=2 class='CAGROUP' align="center"><b><font size='2'><fmt:message key="eCA.SelectedItems.label" bundle="${ca_labels}"/></b></td></tr> 
 <table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<tr >
<td class='COLUMNHEADERCENTER' width='25%' style="font-size:10"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='50%' style="font-size:10"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='25%' style="font-size:10"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</tr>
</table>
</div>



<div id="finalDiv1">
<table  border="1"  class='grid' width="100%" align="center">



<%

	//String ret_str="";
	String rowid="";
	String temp="";
	String value="";
	String remval="";
	String code="";
	String description="";
	PreparedStatement stmt=null;
	ResultSet rs=null;
	Connection con=null;
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	String return_format="";
	String classValue="";
	String eventcode="";
	String shortdesc="";
	String  code1="";
	String description1="";


	int w=0;
	return_format=(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");

	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
   	String ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	
	remval=(request.getParameter("remval")==null)?"0":request.getParameter("remval");
	removebean=(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

	String hist_rec_type=(request.getParameter("hist_rec_type")==null)?"":request.getParameter("hist_rec_type");


	String contr_system=(request.getParameter("contr_system")==null)?"":request.getParameter("contr_system");

	String mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");

	
	if(sel_all.equals("select"))
	{	
		
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"));
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

	int i=0;
	
	//if(ret_str.trim().equals(""))
	if(mode.equals("insert"))
		BatchBean.clearAll();

		
	if(mode.equals("insert"))
	{

		try
		{
			con =	ConnectionManager.getConnection(request);

			{
					String sql="SELECT ROWID, EVENT_CODE, replace(SHORT_DESC,'@','')SHORT_DESC FROM CR_CLIN_EVENT_MAST WHERE HIST_REC_TYPE = ?  AND EVENT_CODE_TYPE = ?";

					stmt=con.prepareStatement(sql);
					stmt.setString(1,hist_rec_type );
					stmt.setString(2,contr_system);
					rs = stmt.executeQuery();

					StringBuffer sbRetStr = new StringBuffer();

					while(rs.next())
					{
						eventcode=(rs.getString("EVENT_CODE")==null)?"":rs.getString("EVENT_CODE");
						shortdesc=(rs.getString("SHORT_DESC")==null)?"":rs.getString("SHORT_DESC");

						rowid=(rs.getString("ROWID")==null)?"":rs.getString("ROWID");

						sbRetStr.append(rowid);
						sbRetStr.append("~");
						sbRetStr.append(eventcode);
						sbRetStr.append("|");
						sbRetStr.append(shortdesc);
						sbRetStr.append("@");
					}
					
					ret_str = sbRetStr.toString();
				
					if(rs != null) rs.close();
					if(stmt!=null) stmt.close();
				}
			}

			catch(Exception e)
			{
				//out.println("Exception in eventselected form"+e.toString());//common-icn-0181
				e.printStackTrace();
			}

			finally
			{
				if (con!= null)
					ConnectionManager.returnConnection(con,request);
			}
	}
	
	if(!removebean.equals("Y"))
	{
		if(ret_str!=null && ret_str!="")
		{
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"@");

			while(strtCodes.hasMoreTokens())
			{
				temp= (String) strtCodes.nextToken();

			   StringTokenizer tempCodes = new StringTokenizer(temp,"~");
			   String key = "";
				
				while(tempCodes.hasMoreTokens())
				{
					key		=	tempCodes.nextToken();
					value	=	tempCodes.nextToken();
					
					
					BatchBean.putObject(key);
					BatchBean.putObject(value);
				}
 			}
		}		
		
		for(i=1;i<BatchBean.getSize();i+=2)
		{
			if ( w % 2 == 0 )
		       classValue = "gridData" ;
		    else
		        classValue = "gridData" ;
			
			w++;

			disbean=BatchBean.getObject(i).toString();
			
			StringTokenizer valCodes = new StringTokenizer(disbean,"|");

			while(valCodes.hasMoreTokens())
				{
					
				   code=valCodes.nextToken();
				   
	               description=valCodes.nextToken();  

				   
 	              %> 
              <tr>
				<td class="<%=classValue%>" width='25%'><%=code%></td>
				<td class="<%=classValue%>" width='50%'><%=description%></td>   
				<td class="<%=classValue%>" width='25%'><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=BatchBean.getObject(i-1).toString()%>">
					<input type=hidden name='selcode<%=(i-1)%>' id='selcode<%=(i-1)%>' value="<%=code%>">
				</tr>
				
				
					<%
				
				//	cat=formet+textbuffer.toString();
				//	cat=cat.replace('|' , ',');
                    //cat=cat.replace('|' , '');  
				}
				}
				%>
		   	
		<%
	}

				

%>
</td>
</tr>
<%

	if(removebean.equals("Y"))
	{
	
//	 String beankey="";
	 String beankey1="";
	  for(int l=0;l<BatchBean.getSize();l+=2)
	   {
						
			beankey1=BatchBean.getObject(l+1).toString();
			
			StringTokenizer valCodes = new StringTokenizer(beankey1,"|");

			while(valCodes.hasMoreTokens())
			{
					
				   code1=valCodes.nextToken();
				  			   
	               description1=valCodes.nextToken();
					
			
			
			if(remval.equalsIgnoreCase(code1))
				{		
				
					BatchBean.removeObject(l);
					BatchBean.removeObject(l);
					break;
				}
			}
		}
              
				/*ArrayList d=new ArrayList();
				d=BatchBean.getRecordSetHandle();
				int size=0;
				size=d.size();
				d.clear();*/
				w=0;
				for( i=1;i<BatchBean.getSize();i+=2)
				{
					
					//beanval=d.get(i).toString();
				    if ( w % 2 == 0 )
		          classValue = "gridData" ;
		        else
		           classValue = "gridData" ;
				 w++;

					beanval=BatchBean.getObject(i).toString();  

					
					
					StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
					{
					
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();
				   
					
 	            				
				%>
				<tr>
				<td class="<%=classValue%>" width="25%"><%=code%></td>
				<td class="<%=classValue%>" width="50%" colspan=2><%=description%></td>   
				<td class="<%=classValue%>" width="25%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>">
				<input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=BatchBean.getObject(i-1).toString()%>">
				<input type=hidden name='selcode<%=(i-1)%>' id='selcode<%=(i-1)%>' value="<%=code%>">

				</tr>
				<%
						//cat=formet+textbuffer.toString();
						//cat=cat.replace('|' , ',');
                       // cat=cat.replace('|' , ' ');  
					}
		
	}
}

%>


</table>
</div>

<input type="hidden" name="count" id="count" value="<%=i-2%>">

<%
%>
</body>
</form>


