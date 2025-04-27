<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %> 

<%request.setCharacterEncoding("UTF-8"); %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%									    
//String sStyle =
//(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String sStyle	="IeStyle.css";
%> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>
<script src='../../eXH/js/FilterLayerReferenceApplication.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language="JavaScript" src="../js/FilteringAndSchdulingLookup.js"></script> 
<script Language="JavaScript" >
var arr=new Array();
var arr2=new Array();
var arr3=new Array();   
var arr4=new Array();
var allselect=new Array();

function checkfun(cou1)
{
	var len=(document.forms[0].count_fields.value);
	   for(var i=1;i<len;i++)
	{
var obj2="Element_code_Query"+i;
var obj3="Element_code_Querys"+i+i;
var anotherobj1="Element_code_Query"+cou1;
        anotherobj12="Element_code_Querys"+cou1+cou1; 




 var Str3="";
		 var Str4de="";
        if(document.getElementById(obj3).value=='')
		{
		document.getElementById(anotherobj1).value='';
         document.getElementById(anotherobj12).value='';
		}
		else
		{
           // document.getElementById(obj3).value='';
            // document.getElementById(obj2).value='';
         


		  if(document.getElementById(anotherobj1).name==document.getElementById(obj2).name)
            {
         document.getElementById(anotherobj1).value='';
         document.getElementById(anotherobj12).value='';
			}
			else
			{
          
			}
               
		} 

	}

} 
function testfun(cou)
{
	var c=0;
	var len=(document.forms[0].count_fields.value)
    for(var i=1;i<len;i++)
	{
		
		obj=i+"Filter_element_desc";
		obj1=i+"Filter_subtype_desc_combo";
		obj2="Element_code_Query"+i;
		obj3="Element_code_Querys"+i+i;
		anotherobj="Element_code_Query"+cou;
        anotherobj2="Element_code_Querys"+cou+cou;
       var index		= document.getElementById(obj2).options.selectedIndex;
	
	document.getElementById(obj3).value= document.getElementById(obj2).options[index].text;

allselect[c]=document.getElementById(obj).value+"-";
c++;
allselect[c]=document.getElementById(obj1).value+"-";
c++;
allselect[c]=document.getElementById(obj2).value+"-";
c++;

		var str="";
		var Str2="";
		if(document.getElementById(obj).value=='') 
		{
		   str="|";
		}
		else
		{
           str=document.getElementById(obj).value;
		}
        var Str2="";
		if(document.getElementById(obj1).value=='')
		{
		   str2="|";
		}
		else
		{
           str2=document.getElementById(obj1).value;
		}
         
		 var Str3="";
		 var Str4de=""; 
        if(document.getElementById(obj2).value=='')
		{
		   str3="|";
		   Str4de="|";
		}
		else
		{
			str3=document.getElementById(obj2).value;
            /*if(document.getElementById(anotherobj).name==document.getElementById(obj2).name)
            {
            str3="|";
            Str4de="|";
			}
			else
			{
           str3=document.getElementById(obj3).value;
		  Str4de=document.getElementById(obj2).value;
			}*/

		} 

          arr2[i-1]=str2;
          arr3[i-1]=str3;
          // arr4[i-1]=str3;

          arr[i-1]=str;






	}
}

function Trim(str)
{ 
while(str.charAt(0) == ("/") )
  {  str = str.substring(1);
  }
  while(str.charAt(str.length-1) == "/" )
  {  str = str.substring(0,str.length-1);
  }
  return str;
 }

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()"  onKeyDown ='lockKey()'>
<form name="FilterSearchForm" id="FilterSearchForm" target='messageFrame' action='FilterAndSchedulingRecord.jsp'>


<table cellspacing=0 cellpadding=3 width='100%' align=center>

<%
		int sel=0;int sel2=0;int sel3=0;
		String flag="0";
		String selectedStr="";String selectedStr2="";String selectedStr3="";
		int levelcount=0; 
		ResultSet resultset = null;
		PreparedStatement pstmt = null ;
		Statement stment=null; 
		Connection conn = null;
		ResultSet rset = null;
		String Defval="";String Defval2="";String Defval3="";
		int j=1;
		String filter_group = request.getParameter("Filter_group_code");

		try
		{
			if(conn==null) conn = ConnectionManager.getConnection();
		}
		catch(Exception exp)
	    {

			 System.out.println("Error in calling getconnection method of FilteringandschedulingApplicationLevel1.jsp  :"+exp.toString());
			 exp.printStackTrace(System.err);
				//exceptions=exceptions+"1"+"*"+exp.toString();
		 }
   try
   {
			 stment= conn.createStatement();
			 resultset = stment.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+filter_group+"'");
			 resultset.next();
			 levelcount = resultset.getInt("rowcount") ;
			 j=1 ;
			 resultset.close() ;
		     stment.close();
			 String sql="select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME ,A.FACILITY_ID,A.APPLICATION_ID, A.EVENT_TYPE, A.PROTOCOL_LINK from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+filter_group+"' ORDER BY 1";
			

			 
			 pstmt = conn.prepareStatement(sql);
			 rset = pstmt.executeQuery();
			 while(rset.next())
			 {
                 int arraylist=Integer.parseInt(rset.getString(1).toString().trim());
                // ArrayList countfield=new ArrayList(arraylist);
             String facility=rset.getString(8).toString().trim();
              

  %> 
 
<tr>
 <input type=hidden name="applicationID" id="applicationID" id="applicationID" value='<%=rset.getString(9).toString().trim()%>'>
<input type=hidden name="facilityID" id="facilityID" id="facilityID" value='<%=facility%>'>
<input type=hidden name="event_type" id="event_type" id="event_type" value='<%=rset.getString(10).toString().trim()%>'>
<input type=hidden name="protocol_link" id="protocol_link" id="protocol_link" value='<%=rset.getString(11).toString().trim()%>'>

	<input type=hidden name="<%=j+"querys"%>"  id="<%=j+"querys"%>" value='<%=rset.getString(2)%>'>
    <td class="label"><%=rset.getString(5)%></td>
		<input type=hidden name=<%=j+"Filter_element_lbl"%> value='<%=rset.getString(5)%>' >
    <td class='fields'><select name="<%=j+"Filter_element_desc"%>" id="<%=j+"Filter_element_desc"%>" onChange="testfun('<%=j%>');location.href='../../eXH/jsp/FilteringAndSchedulingApplicationSearchAdd.jsp?Filter_group_code=<%=filter_group%>&selectcount=<%=j%>&flag=5&qryString='+arr+'&qryString2='+arr2+'&qryString3='+arr3+'&qryString4='+arr4+'&querys='+escape(document.getElementById('<%=j%>'+'querys').value)+'&selectall='+allselect;"     style="width:200">
	<option value=' '>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>  
   <%
			String sql1=rset.getString(2);	
			PreparedStatement pstmt1 = null ;
			ResultSet resultset1 = null;
			try
			{
			   flag=XHDBAdapter.checkNull(request.getParameter("flag"));
       
			   if(flag.equals("5"))
			   {
                     

        		  Defval= request.getParameter("qryString");
					String[] values=Defval.split(",");
					if(values[sel].equals("|") )
					{
						selectedStr=" ";
					}
					else
					{
					    selectedStr=values[sel];
					}

					sel++;
					String typevalue=request.getParameter("selectall");
                	 String[] selectAll=typevalue.split(",");
                         for(int i=0;i<selectAll.length;i++)
				   {
							 String appstr=":"+(i+1);
							 String cop=selectAll[i].toString().trim().substring(0,(selectAll[i].toString().trim().length()-1));
                               sql1=sql1.replaceAll(appstr,"'"+cop+"'");
							   
				   }


					//String selcou=request.getParameter("selectcount");
               }
                 else
				{
                     for(int i=1;i<(arraylist*3);i++)
				   {
							 String appstr=":"+i;
                               sql1=sql1.replaceAll(appstr,"' '");
				   }
				}

                    if(sql1.indexOf(":FACILITY")!=-1)
	{

        sql1=sql1.replaceAll(":FACILITY","'"+facility+"'");
	}
	else
	{
        sql1=sql1;
	}
                  

					pstmt1 = conn.prepareStatement(sql1);
					resultset1 = pstmt1.executeQuery();		    
					while(resultset1.next())
					{
			    		if ((resultset1.getString(2)+"").equalsIgnoreCase(selectedStr))
						  {
               %> 
		<option value='<%=resultset1.getString(2)%>' selected ><%=resultset1.getString(1)%></option>
  <%                      }
                          else
                          {
  %>
        <option value='<%=resultset1.getString(2)%>' ><%=resultset1.getString(1)%></option>
  <%    
                          }
		            }
  %>

<%	
	
            }
           catch(Exception exp)
           {

		        System.out.println("Error in calling getconnection method of FilteringandschedulingApplicationsearch1.jsp  :"+exp.toString());
		        exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
           }
	       finally
	      {
			if(pstmt1!=null )
		    pstmt1.close() ;
    	    resultset1.close() ;
	      }
		%>

	    </select><img src='../../eCommon/images/mandatory.gif' align='middle'></td>
		<td class="label"><%=rset.getString(6)%></td>
		<input type=hidden name=<%=j+ id=<%=j+"Filter_desc_lbl"%> value='<%=rset.getString(6)%>' >
		<td class='fields'><select name='<%=j+"Filter_subtype_desc_combo"%>' id='<%=j+"Filter_subtype_desc_combo"%>' onChange="testfun('<%=j%>');location.href='../../eXH/jsp/FilteringAndSchedulingApplicationSearchAdd.jsp?Filter_group_code=<%=filter_group%>&selectcount=<%=j%>&flag=5&qryString='+arr+'&qryString2='+arr2+'&qryString3='+arr3+'&qryString4='+arr4+'&querys='+escape(document.getElementById('<%=j%>'+'querys').value)+'&selectall='+allselect;" style="width:200">
		<option value=' '>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>  
		<%
			
		//String reSecond = new String("'"+selectedStr+"'");
        String sql2="";
              sql2=rset.getString(3).toString().trim();
         
       if(sql2.indexOf(":FACILITY")!=-1)
	{

        sql2=sql2.replaceAll(":FACILITY","'"+facility+"'");
	}
	else
	{
        sql2=sql2;
	}

			   
		/*if(rset.getString(3).indexOf(":1")!=-1)
			{
		sql2=rset.getString(3).replaceAll(":1",reSecond);
			} 
			else
			{
				sql2=rset.getString(3);
			}*/

			String setvalue=XHDBAdapter.checkNull(request.getParameter("selectall"));
			

			 
		PreparedStatement pstmt2 = null ;
		ResultSet resultset2 = null;
    try 
	 {	
		if(flag.equals("5"))
			   {
        		   Defval2= request.getParameter("qryString2");
					String[] values2=Defval2.split(",");
					if(values2[sel2].equals("|") )
					{
						selectedStr2=" ";
					}
					else
					{
					    selectedStr2=values2[sel2];
					}

					sel2++;
                    

					String[] selectallsub=setvalue.split(",");
                for(int i=0;i<selectallsub.length;i++)
				   {
							 String appstr=":"+(i+1);

							 String cop=selectallsub[i].toString().trim().substring(0,(selectallsub[i].toString().trim().length()-1));
                               sql2=sql2.replaceAll(appstr,"'"+cop+"'");
                               
				   }
              
					//String selcou=request.getParameter("selectcount");
               }
			   else
		 {
				    for(int i=1;i<(arraylist*3);i++)
				   {
							 String appstr=":"+i;
                               sql2=sql2.replaceAll(appstr,"' '");
				   }
		 }
			   
		pstmt2 = conn.prepareStatement(sql2);
//System.out.println(" sql2 397:"+sql2);

	    resultset2 = pstmt2.executeQuery(); 
    	 while(resultset2.next())
	     {
	if ((resultset2.getString(2)+"").equalsIgnoreCase(selectedStr2))
						  {
               %> 
		<option value='<%=resultset2.getString(2)%>' selected ><%=resultset2.getString(1)%></option>
  <%                      }
                          else 
                          {
  %>
        <option value='<%=resultset2.getString(2)%>' ><%=resultset2.getString(1)%></option>
  <%    
                          }
  }

     }catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of FilteringAndSchedulingApplicationSearchAdd.jsp :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
     finally
	 {

		if(pstmt2!=null )
		 pstmt2.close() ;
		 resultset2.close() ;
      }
	  %>
		</select><img src='../../eCommon/images/mandatory.gif' align='middle'></td>
	
<% 
	
	if((rset.getString(7).trim().indexOf("None")!=-1) ||(rset.getString(7).trim().indexOf("none")!=-1))
	{
	%>
	<td class="label"> </td>

<td class='fields'><select name='<%="Element_code_Query"+j%>'  id='<%="Element_code_Query"+j%>' onChange="testfun('<%=j%>');location.href='../../eXH/jsp/FilteringAndSchedulingApplicationSearchAdd.jsp?Filter_group_code=<%=filter_group%>&selectcount=<%=j%>&flag=5&qryString='+arr+'&qryString2='+arr2+'&qryString3='+arr3+'&qryString4='+arr4+'&querys='+escape(document.getElementById('<%=j%>'+'querys').value)+'&selectall='+allselect;" style="display:none;" >
<option value=' '>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>  
	<%
		
        String sql4="";
              sql4=rset.getString(4).toString().trim();
         
       if(sql4.indexOf(":FACILITY")!=-1)
	{

        sql4=sql4.replaceAll(":FACILITY","'"+facility+"'");
	}
	else
	{
        sql4=sql4;
	}

			
		/*if(rset.getString(3).indexOf(":1")!=-1)
			{
		sql2=rset.getString(3).replaceAll(":1",reSecond);
			} 
			else
			{
				sql2=rset.getString(3);
			}*/

			String setvalue4=XHDBAdapter.checkNull(request.getParameter("selectall"));
			

			 
		PreparedStatement pstmt4 = null ;
		ResultSet resultset4 = null;
    try 
	 {	
			if(flag.equals("5"))
			   {
        		   Defval3= request.getParameter("qryString3");
					String[] values3=Defval3.split(",");
					if(values3[sel3].equals("|") )
					{
						selectedStr3=" ";
					}
					else
					{
					    selectedStr3=values3[sel3];
					}

                     
                   /* Defval4= request.getParameter("qryString4");
					String[] values4=Defval4.split(",");
					if(values4[sel3].equals("|") )
					{
						selectedStr4=" ";
					}
					else
					{
					    selectedStr4=values3[sel3];
					}  
                         */


					sel3++; 
					String[] selectallelement=setvalue4.split(",");
                for(int i=0;i<selectallelement.length;i++)
				   {
							 String appstr=":"+(i+1);
                         String cop=selectallelement[i].toString().trim().substring(0,(selectallelement[i].length()-1));
                             sql4=sql4.replaceAll(appstr,"'"+cop+"'");
							   

				   }
					//String selcou=request.getParameter("selectcount");
               }  
	     else
		 {
				    for(int i=1;i<(arraylist*3);i++)
				   {
							 String appstr=":"+i;
                               sql4=sql4.replaceAll(appstr,"' '");
				   }
		 }
			  
		pstmt4 = conn.prepareStatement(sql4);
	    resultset4 = pstmt4.executeQuery(); 
    	 while(resultset4.next())
	     {
	if ((resultset4.getString(2)+"").equalsIgnoreCase(selectedStr3))
						  {
               %> 
		<option value='<%=resultset4.getString(2)%>' selected ><%=resultset4.getString(1)%></option>
  <%                      }
                          else 
                          {
  %>
        <option value='<%=resultset4.getString(2)%>' ><%=resultset4.getString(1)%></option>
  <%    
                          }
  }

     }catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of FilteringAndSchedulingApplicationSearchAdd.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
     finally
	 {

		if(pstmt4!=null )
		 pstmt4.close() ;
		 resultset4.close() ;
      }
	  %>
		</select><input type="hidden" name="<%="Element_code_Querys"+j+j%>"  id="<%="Element_code_Querys"+j+j%>"></td>
<%	}
	else
	{
	%>
	<td class="label"><%=rset.getString(7)%> </td>
  <input type=hidden name=<%=j+"Element_code_lbl"%> value='<%=rset.getString(7)%>' >
<td class='fields'><select name='<%="Element_code_Query"+j%>' id='<%="Element_code_Query"+j%>' onChange="testfun('<%=j%>');location.href='../../eXH/jsp/FilteringAndSchedulingApplicationSearchAdd.jsp?Filter_group_code=<%=filter_group%>&selectcount=<%=j%>&flag=5&qryString='+arr+'&qryString2='+arr2+'&qryString3='+arr3+'&qryString4='+arr4+'&querys='+escape(document.getElementById('<%=j%>'+'querys').value)+'&selectall='+allselect;" style="width:200">
	<option value=' '>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>  
	<%
		
        String sql4="";
              sql4=rset.getString(4).toString().trim();
         
       if(sql4.indexOf(":FACILITY")!=-1)
	{																		  

        sql4=sql4.replaceAll(":FACILITY","'"+facility+"'");
	}
	else
	{
        sql4=sql4;
	}

			
		/*if(rset.getString(3).indexOf(":1")!=-1)
			{
		sql2=rset.getString(3).replaceAll(":1",reSecond);
			} 
			else
			{
				sql2=rset.getString(3);
			}*/

			String setvalue4=XHDBAdapter.checkNull(request.getParameter("selectall"));
			

			 
		PreparedStatement pstmt4 = null ;
		ResultSet resultset4 = null;
    try 
	 {	
			if(flag.equals("5"))
			   {
        		   Defval3= request.getParameter("qryString3");
					String[] values3=Defval3.split(",");
					if(values3[sel3].equals("|") )
					{
						selectedStr3=" ";
					}
					else
					{
					    selectedStr3=values3[sel3];
					}

                     
                   /* Defval4= request.getParameter("qryString4");
					String[] values4=Defval4.split(",");
					if(values4[sel3].equals("|") )
					{
						selectedStr4=" ";
					}
					else
					{
					    selectedStr4=values3[sel3];
					}  
                         */


					sel3++; 
					String[] selectallelement=setvalue4.split(",");
                for(int i=0;i<selectallelement.length;i++)
				   {
							 String appstr=":"+(i+1);
                         String cop=selectallelement[i].toString().trim().substring(0,(selectallelement[i].length()-1));
                             sql4=sql4.replaceAll(appstr,"'"+cop+"'");
							   

				   }
					//String selcou=request.getParameter("selectcount");
               }  
	     else
		 {
				    for(int i=1;i<(arraylist*3);i++)
				   {
							 String appstr=":"+i;
                               sql4=sql4.replaceAll(appstr,"' '");
				   }
		 }
			  
		pstmt4 = conn.prepareStatement(sql4);
	    resultset4 = pstmt4.executeQuery(); 
    	 while(resultset4.next())
	     {
	if ((resultset4.getString(2)+"").equalsIgnoreCase(selectedStr3))
						  {
               %> 
		<option value='<%=resultset4.getString(2)%>' selected ><%=resultset4.getString(1)%></option>
  <%                      }
                          else 
                          {
  %>
        <option value='<%=resultset4.getString(2)%>' ><%=resultset4.getString(1)%></option>
  <%    
                          }
  }

     }catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of inga than FilteringAndSchedulingApplicationSearchAdd.jsp :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
     finally
	 {

		if(pstmt4!=null )
		 pstmt4.close() ;
		 resultset4.close() ;
      }
	  %>
		</select><img src='../../eCommon/images/mandatory.gif' align='middle'><input type="hidden" name="<%="Element_code_Querys"+j+j%>"  id="<%="Element_code_Querys"+j+j%>"></td>

		<%
				 }
		%>

		<input type="hidden" name='<%=j+"leval_number"%>' id='<%=j+"leval_number"%>' value='<%=rset.getString(1)%>'> 
		<td>
		</td> 
		<td>    
		</td>
		<td>
		</td>
		<td>
		</td>
		<td>
		</td>

<%
				
	j++;
	
	 }
 		if(pstmt!=null)
		pstmt.close();
		if(rset!=null)
		rset.close() ;
	}						    
    catch(Exception exp)
    {

    	 System.out.println("Error in calling getconnection method of FilteringAndSchedulingApplicationSearchAdd.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
    }
  finally
  {
	ConnectionManager.returnConnection(conn);
  }
 %>
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr> 
<td class="BUTTON" colspan="5" align=right><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record()"> 
</td>
</tr>
<tr>
   <td colspan=3></td>
</tr>
</table>
<input type=hidden name=count_fields id=count_fields value='<%=j%>'>
<input type=hidden name=actualmode id=actualmode value='I'>
<input type=hidden name=Filter_group_desc_id id=Filter_group_desc_id value='<%=filter_group%>'>
<input type=hidden name=element_field id=element_field value=''>

</form>	
</BODY>
</HTML>

