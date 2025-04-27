<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
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

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>


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
<div id='divDataTitle' style='postion:relative'>
<table border="1" id="finalDiv" cellpadding="0" cellspacing="0" width="100%" align="center">
<tr ><td colspan=2 class='CAGROUP' align=center><b><font size='2'>Selected Items</b></td></tr>
<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<tr>
<th nowrap width="26%" style="font-size:10">Code</th>
<th nowrap width="64%" style="font-size:10">Description</th>
<th nowrap width="10%" style="font-size:10">Select</th>
</tr>
</table>
</div>



<div id="finalDiv1">
<table  border="1"  cellpadding="0" cellspacing="0" width="100%">



<%
	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	String code="";
	String description="";
	
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	String return_format="";

	
	
	String classValue="";
	int w=0;
	return_format=(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	
//	String formet="";
					//out.println("return_format :" +return_format);
	
	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
   	ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	
	remval=(request.getParameter("remval")==null)?"0":request.getParameter("remval");
	removebean=(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

	
	

	if(sel_all.equals("select"))
	{	
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"));
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

//	String cat = "";
	int i=0;
   if(flag.equals("clear"))
	{
		
      
		BatchBean.clearAll();
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
 				while(tempCodes.hasMoreTokens())
				{
					String key= tempCodes.nextToken();
					value=tempCodes.nextToken();

				 BatchBean.putObject(key);
				 BatchBean.putObject(value);
				 
			}
 					
		}
		 
	}		
				
				for(i=1;i<BatchBean.getSize();i+=2)
				{
  		         if ( w % 2 == 0 )
		          classValue = "QRYODD" ;
		        else
		           classValue = "QRYEVEN" ;
				 w++;
				//out.println("<script>alert('classValue"+classValue+"')</script>");
		
					disbean=BatchBean.getObject(i).toString();
					
					StringTokenizer valCodes = new StringTokenizer(disbean,"|");
					while(valCodes.hasMoreTokens())
				{
					
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();  
 	              %> 
              <tr>
				<td class="<%=classValue%>" width="26%"><%=code%></td>
				<td class="<%=classValue%>" width="64%" colspan=2><%=description%></td>   
				<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=BatchBean.getObject(i-1).toString()%>">
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
	 String beankey="";
	  for(int l=0;l<BatchBean.getSize();l++)
	   {
			beankey=BatchBean.getObject(l).toString();  


			if(remval.equalsIgnoreCase(beankey))
			{
					BatchBean.removeObject(l);
					BatchBean.removeObject(l);
					break;
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
		          classValue = "QRYODD" ;
		        else
		           classValue = "QRYEVEN" ;
				 w++;

					beanval=BatchBean.getObject(i).toString();  

					
					
					StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
					{
					
				   code=valCodes.nextToken(); 
	               description=valCodes.nextToken();  
 	            				
				%>
				<tr>
				<td class="<%=classValue%>" width="26%"><%=code%></td>
				<td class="<%=classValue%>" width="64%" colspan=2><%=description%></td>   
				<td class="<%=classValue%>" width="10%"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=BatchBean.getObject(i-1).toString()%>">
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


</body>
</form>


