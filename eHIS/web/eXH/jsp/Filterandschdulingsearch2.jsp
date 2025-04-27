<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHSelectQuery,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>

<HTML> 
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<script src='../../eXH/js/filterlayerrefrence.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/filterlayerrefrenceApplication.js' language='javascript'></script>
<script Language="JavaScript" >
var arr=new Array();
var arr2=new Array();
var arr3=new Array();
var arr4=new Array();
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
	 
	var len=(document.forms[0].count_fields.value)
    for(var i=1;i<len;i++)
	{
		obj=i+"Filter_element_desc";
		obj1=i+"Filter_subtype_desc_combo";
		obj2="Element_code_Query"+i;
		obj3="Element_code_Querys"+i+i;
		anotherobj="Element_code_Query"+cou;
        anotherobj2="Element_code_Querys"+cou+cou;
	
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
        if(document.getElementById(obj3).value=='')
		{
		   str3="|";
		   Str4de="|";
		}
		else
		{
           // document.getElementById(obj3).value='';
            // document.getElementById(obj2).value='';
         


		  if(document.getElementById(anotherobj).name==document.getElementById(obj2).name)
            {
            str3="|";
            Str4de="|";
			}
			else
			{
           str3=document.getElementById(obj3).value;
		  Str4de=document.getElementById(obj2).value;
			}

		} 

          arr2[i-1]=str2;
          arr3[i-1]=Str4de;
           arr4[i-1]=str3;

          arr[i-1]=str;






	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' >
<form name="FilterSearchForm" id="FilterSearchForm" target='messageFrame' action='../../eXH/jsp/FilterAndSchedulingUpdateRecord.jsp'>


<table cellspacing=0 cellpadding=3 width='100%' align=center>
<%

			String selectedStr="";String selectedStr2="";String selectedStr3="";String selectedStr4="";
			int c=1;
			String Filter_type_code=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
			String tranaction_number=XHDBAdapter.checkNull(request.getParameter("Transnumber"));
			String levelcount1=XHDBAdapter.checkNull(request.getParameter("levelcount")); 

			//System.out.println("levelcount1"+levelcount1);
			String [] Filterleveltype=new String[Integer.parseInt(levelcount1)];
			String [] Filterlevelsubtype=new String[Integer.parseInt(levelcount1)];	
			String [] Filterlevelcode=new String[Integer.parseInt(levelcount1)];
			String [] Filterlevelvalue=new String[Integer.parseInt(levelcount1)];
			for(int k=0;k<Integer.parseInt(levelcount1);k++)
			{
				Filterleveltype[k]=XHDBAdapter.checkNull(request.getParameter("Filter_level"+c+"_type"));
				Filterlevelsubtype[k]=XHDBAdapter.checkNull(request.getParameter("Filter_level"+c+"_subtype"));
				Filterlevelcode[k]=XHDBAdapter.checkNull(request.getParameter("Filter_level"+c+"_code"));
				Filterlevelvalue[k]=XHDBAdapter.checkNull(request.getParameter("Filter_level"+c+"_value"));
				c++;
			}
%>
<%
			int sel=0;int sel2=0;int sel3=0;
			String flag="0";
			int i=0;
			int levelcount=0;
			ResultSet resultset = null;
			PreparedStatement pstmt = null ;
			String Defval="";String Defval2="";String Defval3="";String Defval4="";

			Statement stment=null;
			Connection conn = null;
			ResultSet rset = null;
			//System.out.println("levelcount1");
				int j=1;


	try
	{
		if(conn==null) conn = ConnectionManager.getConnection();
	}
	catch(Exception exp)
	{
		 System.out.println("Error in calling getconnection method of Filterandschdulingsearch2.jsp  :"+exp.toString());
	     exp.printStackTrace(System.err);
	}
   try
   {
		 stment= conn.createStatement();
		 resultset = stment.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+Filter_type_code+"'");
		 resultset.next();
		 levelcount = resultset.getInt("rowcount") ;
		 resultset.close() ;
		 stment.close();
		 String sql="select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME  from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+Filter_type_code+"' ORDER BY 1";
		 pstmt = conn.prepareStatement(sql);
		 rset = pstmt.executeQuery();
		 while(rset.next())
		 {
			 selectedStr="";
			 String querys=rset.getString(4);
  %>

 <tr>
  
		<td class="label"><%=rset.getString(5)%> </td>
		<td class='fields'><select  name='<%=j+"Filter_element_desc"%>' id='<%=j+"Filter_element_desc"%>' onChange="testfun('<%=j%>');location.href='../../eXH/jsp/Filterandschdulingsearch2.jsp?Filter_group_code=<%=Filter_type_code%>&selectcount=<%=j%>&flag=5&qryString='+arr+'&qryString2='+arr2+'&qryString3='+arr3+'&qryString4='+arr4+'&levelcount=<%=levelcount1%>&Transnumber=<%=tranaction_number%>';">
		<option value="">   ----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----    </option>
<%
		String sql1=rset.getString(2);	
		PreparedStatement pstatement1 = null ;
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
           // String selcou=request.getParameter("selectcount");

           }
	       else
		   {
				selectedStr=Filterleveltype[i];
		   }
  			 pstatement1 = conn.prepareStatement(sql1);
			 resultset1 = pstatement1.executeQuery();
			 while(resultset1.next())
			 {
			     if(selectedStr.equals(resultset1.getString(2)))
				 {
%> 
		  <option value="<%=selectedStr%>" selected><%=resultset1.getString(1)%></option>
<%
		         }
				 else
				 {
	 %>
  		 <option value="<%=resultset1.getString(2)%>"><%=resultset1.getString(1)%></option>
<%
		         } 
			 }
	    }
	 catch(Exception ex){
			  out.println("Error in closing dbconnection dopost method of Filterandschdulingsearch2.jsp :"+ex.toString());
		      ex.printStackTrace(System.err); 
		}
     finally
	 {
		pstatement1.close();
    	resultset1.close() ;
	 }
	%>
	</select></td>
	<td class="label"><%=rset.getString(6)%> </td>
	<td class='fields'><select name='<%=j+"Filter_subtype_desc_combo"%>' id='<%=j+"Filter_subtype_desc_combo"%>'  onChange="checkfun('<%=j%>');" >
	<option value="">   ----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----    </option>
<%
	String answer2=Filterlevelsubtype[i];
%>

<%

	String reSecond = new String("'"+selectedStr+"'");
	String sql2="";
	if(rset.getString(3).indexOf(":1")!=-1)
		{
	        sql2=rset.getString(3).replace(":1",reSecond);
		} 
		else
		{
			sql2=rset.getString(3);
		}
		  PreparedStatement pstatement2 = null ;
	      ResultSet resultset2 = null;
try
	 {

	            selectedStr2=answer2;
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
					//String selcou=request.getParameter("selectcount");
               }
			pstatement2 = conn.prepareStatement(sql2);
			resultset2 = pstatement2.executeQuery();
		 while(resultset2.next())
		 {
			if(selectedStr2.equals(resultset2.getString(2)))
		      { 
%>
		<option value="<%=selectedStr2%>" selected><%=resultset2.getString(1)%></option>
<%
		      }
		      else
		     { 
	 %>
		<option value="<%=resultset2.getString(2)%>" ><%=resultset2.getString(1)%></option>
<%
    		 }
        }
	  }
	 catch(Exception ex){
			  out.println("Error in closing dbconnection dopost method of Filterandschdulingsearch2.jsp :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
 	 finally
	 {
    pstatement2.close();
	resultset2.close() ;
	
	 }
	
	%>
		</select></td>
		<td class="label"><%=rset.getString(7)%></td>
		<td align=left>
		<%
         selectedStr3=Filterlevelcode[i];
	     selectedStr4=Filterlevelvalue[i];
	 	if(flag.equals("5"))
			   {
			selectedStr3="";
	     selectedStr4="";
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
                    Defval4= request.getParameter("qryString4");
					String[] values4=Defval4.split(",");
					if(values4[sel3].equals("|") )
					{
						selectedStr4=" ";
					}
					else
					{
					    selectedStr4=values3[sel3];
					}  



					sel3++;
					//String selcou=request.getParameter("selectcount");
               }  
	  
	     %>
		
		
		<input type="text" name ='<%="Element_code_Query"+j%>' size='15' value='<%=selectedStr3%>'  >
		<input class='button' type="button"  name='<%=j+"Element_code_Query_idb"%>' id='<%=j+"Element_code_Query_idb"%>' value='?'   onClick="myClick(event,<%=j%>)"><img src='../../eCommon/images/mandatory.gif'>
		<input type="hidden" name='<%="Element_code_Querys"+j+j%>' id='<%="Element_code_Querys"+j+j%>' value='<%=selectedStr4%>'>
		<input type="hidden" name='<%=j+"Element_code_Query_id"%>' id='<%=j+"Element_code_Query_id"%>' value="<%=querys%>">
		<input type="hidden" name='<%=j+"leval_number"%>' id='<%=j+"leval_number"%>' value='<%=rset.getString(1)%>'> 
		</td> 
<%
	j++;
	 i++;
	 }
 %>
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
		<td class="BUTTON" colspan="5"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="recordU()">
		<input class='button' type='button'  name='delete' id='delete' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onClick='delete1();'>
		</td>
		<input type=hidden name=Tranaction_number id=Tranaction_number value='<%=tranaction_number%>'>
		<input type=hidden name=count_fields id=count_fields value='<%=j%>'>
		<input type=hidden name=Filter_group_desc_id id=Filter_group_desc_id value='<%=Filter_type_code%>'>
		<input type=hidden name=count id=count value='<%=levelcount1%>' >
<%
}
catch(Exception ex){
			  out.println("Error in closing dbconnection dopost method of Filterandschdulingsearch2.jsp :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}finally
	{
    	if(rset!=null)
		{
			rset.close() ;
            pstmt.close();
		}
		if(conn!=null)
		ConnectionManager.returnConnection(conn);
	}
%>

</tr>
<tr>
     <td colspan=3></td>
</tr>
</table>
<input type=hidden name=actualmode id=actualmode value=''>
<input type=hidden name=element_field id=element_field value=''>
<input type=hidden name=element_field id=element_field value=''>
</form>	
</BODY>
</HTML>

