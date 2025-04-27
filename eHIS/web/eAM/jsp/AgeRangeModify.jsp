<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" %>

<%
	request.setCharacterEncoding("UTF-8");
// String facility_id = request.getParameter("facility_id");
   String range_type = request.getParameter("range_type");
   String range_id=request.getParameter("range_id");
   String str="";
Connection conn = null;
Statement stmt=null;
ResultSet rset=null;

try{
out.println("<html><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script>");


%>

<script language='javascript'>

function checkNoDecimal(fld,event)
{
	//alert("here");
	var retVal;
	//alert("Range Type::"+document.agerange_form.range_type.value);
	if (document.agerange_form.range_type.value =="Age")
	{
			fld.maxLength=3;
			retVal=allowValidNumber(fld,event,3, 0);
	}
	else if (document.agerange_form.range_type.value =="Weight")
	{
		fld.maxLength=6;
 		retVal==allowValidNumber(fld, event, 3, 2);
	}
	return retVal;
}




function test(num)
	{

		

		for(var cnt=0;cnt<num;cnt++)
		{
 		 if(agerange_form.no_of_ranges.value < num)
 		 {
			agerange_form.no_of_ranges.select();
			agerange_form.no_of_ranges.focus();
			
		 }

		}


	}


function newTest()
	{

		
		var rangeVal=agerange_form.no_of_ranges.value;
		var cnt;
		if(rangeVal != "")
		 cnt = parseInt(rangeVal)+1;
		for(cnt;cnt<= 6;cnt++)
		{
			var strFrom="agerange_form.range_"+cnt+"_fr_unit";
			var strTextFrom="agerange_form.range_"+cnt+"_fr";
			var strTo="agerange_form.range_"+cnt+"_to_unit";
			var strTextTo="agerange_form.range_"+cnt+"_to";


			eval(strTextFrom).value="";
			eval(strTextTo).value="";
			eval(strFrom).options[0].selected=true;
			eval(strTo).options[0].selected=true;
		
			/*if(eval(strFrom).value=="L")
			{
				eval(strFrom).options[0].selected=true;
			}
			if(eval(strFrom).value=="M")
			{
				eval(strFrom).options[0].selected=true;
			}
			if(eval(strFrom).value=="Y")
			{
				eval(strFrom).options[0].selected=true;
			}
			if(eval(strTo).value=="L")
			{
				eval(strTo).options[0].selected=true;
			}
			if(eval(strTo).value=="M")
			{
				eval(strTo).options[0].selected=true;
			}
			if(eval(strTo).value=="Y")
			{
				eval(strTo).options[0].selected=true;
			}*/




			
			
		}

		


	}




function func()
	{
		

		if (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >6)
		{
			if(agerange_form.no_of_ranges.value.length >0)
			{
				alert("Invalid Entry");
				agerange_form.no_of_ranges.select();
				agerange_form.no_of_ranges.focus();
			}
		}
	}

function ageWeightOption(Obj)
{
	
	

	var	objName =Obj.name;
	var whichObj="document.agerange_form."+ objName;
	
	var arr1= new Array ("document.agerange_form.range_1_fr","document.agerange_form.range_1_to", "document.agerange_form.range_2_fr","document.agerange_form.range_2_to", "document.agerange_form.range_3_fr","document.agerange_form.range_3_to",
	"document.agerange_form.range_4_fr","document.agerange_form.range_4_to",
	"document.agerange_form.range_5_fr","document.agerange_form.range_5_to",
	"document.agerange_form.range_6_fr","document.agerange_form.range_6_to");

	for(var k=0; k< arr1.length;k++)
		eval(arr1[k]).value="";

	var arr= new Array ("document.agerange_form.range_1_fr_unit","document.agerange_form.range_1_to_unit", "document.agerange_form.range_2_fr_unit","document.agerange_form.range_2_to_unit", "document.agerange_form.range_3_fr_unit","document.agerange_form.range_3_to_unit",
	"document.agerange_form.range_4_fr_unit","document.agerange_form.range_4_to_unit",
	"document.agerange_form.range_5_fr_unit","document.agerange_form.range_5_to_unit",
	"document.agerange_form.range_6_fr_unit","document.agerange_form.range_6_to_unit");

	for(j =0; j< arr.length;j++)
	{

		var len=eval(arr[j]).length;
		
		if(document.agerange_form.range_type.value =="W")
		{
			
			
			for(var i=0;i<len ;i++)
			{
				
				eval(arr[j]).options[i]=null;
			}
			//eval(arr[j]).value="K";
			//eval(arr[j]).options[0].selected=true;
			eval(arr[j]).options[0] =new Option("Kgs","K");;
			eval(arr[j]).options[1] =new Option("Lbs","L");


		}

		if(document.agerange_form.range_type.value =="A")
		{
					
			for(var i=0;i<len ;i++)
			{
				eval(arr[j]).options[i]=null;
			}
			//eval(arr[j]).value="D";
			//eval(arr[j]).options[0].selected=true;
			eval(arr[j]).options[0] =new Option("Days","D");
			eval(arr[j]).options[1] =new Option("Months","M");
			eval(arr[j]).options[2] =new Option("Years","Y");
		}
	}

}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<%

out.println("</head><body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >");
conn = ConnectionManager.getConnection(request);
//Connection conn = (Connection) session.getValue( "connection" );
stmt = conn.createStatement();

String sql="select * from am_summ_range where range_id='"+range_id+"' and range_type='"+range_type+"'";
rset = stmt.executeQuery(sql);
rset.next();


out.println(" <form name='agerange_form' id='agerange_form' action='../../servlet/eAM.AgeRangeServlet' method='post' target='messageFrame'><center> <br><br>");


if ( rset.getString("eff_status").equals("E") )
{
%>
<BR>
<table border="0" cellpadding="0" cellspacing="0" width="85%">

			<tr><td>&nbsp;</td></tr>

  <tr>
	<td class="BORDER" width="100%">
	 <table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<tr>
		   	<td class="label" width="40%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		   <!-- 	<td align="left" width="60%" colspan="3">&nbsp;&nbsp;&nbsp;<select name="range_type" id="range_type" onChange="ageWeightOption(this)"> -->


			
				<td align="left" width="60%" colspan="3">&nbsp;&nbsp;

				<%
				   if (rset.getString("range_type").equals("A"))
				   {
			           	out.println("<input type='text' name='range_type' id='range_type' value='Age' size='13'   maxlength='13' readonly> ");

		   		   }
				   if (rset.getString("range_type").equals("W"))
				   {
				  		out.println("<input type='text' name='range_type' id='range_type' value='Weight' size='13' maxlength='13'  readonly>");

				   }
			   /* 
				if (rset.getString("range_type").equals("A"))
			   {
		           	out.println( "<OPTION selected VALUE="+"A"+">Age" );
		           	out.println( "<OPTION VALUE="+"W"+">Weight" );
				/*out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"L"+">Length" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );

	   		   }
			  if (rset.getString("range_type").equals("W"))
			   {
			       	out.println( "<OPTION selected VALUE="+"W"+">Weight" );
			       	out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"L"+">Length" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );

			   }
			   if (rset.getString("range_type").equals("C"))
			   {
			      	out.println( "<OPTION selected VALUE="+"C"+">Circumference" );
			      	out.println( "<OPTION VALUE="+"W"+">Weight" );
				out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"L"+">Length" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );
	   		   }
			   if (rset.getString("range_type").equals("L"))
			   {
			      	out.println( "<OPTION selected VALUE="+"L"+">Length" );
			      	out.println( "<OPTION VALUE="+"W"+">Weight" );
				out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );
	   		   }
			 if (rset.getString("range_type").equals("G"))
			   {
			      	out.println( "<OPTION selected VALUE="+"G"+">Gestation" );
			      	out.println( "<OPTION VALUE="+"L"+">Length" );
			      	out.println( "<OPTION VALUE="+"W"+">Weight" );
				out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );
	   		   }
			 if (rset.getString("range_type").equals("P"))
			   {
			      	out.println( "<OPTION selected VALUE="+"P"+">Apgar" );
			      	out.println( "<OPTION VALUE="+"L"+">Length" );
			      	out.println( "<OPTION VALUE="+"W"+">Weight" );
				out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );

	   		   }
			   */
		    %>


			<!-- 	</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img> -->
			</td>
		</tr>
		<tr>
			<td width="40%" class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
			<%
			out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp;&nbsp;<input type='text' name='range_id' id='range_id' readonly size='4' value='"+rset.getString("range_id")+ "' maxlength='4'>");
			out.println("<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>");
			%>
		</tr>
		<tr>
			 <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			 <%
			 out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='long_desc' id='long_desc' size='30' onBlur='makeValidString(this)' value=\"" +rset.getString("long_desc")+ "\" maxlength='30'>");
			 out.println("<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>");
			 %>
		</tr>
		<tr>
			 <td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			 <%
			 out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='short_desc' id='short_desc' size='15' onBlur='makeValidString(this)' value=\"" +rset.getString("short_desc")+ "\" maxlength='15'>");
			 out.println("<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>");
			 %>
		</tr>

		<!--<tr>
			 <td width="40%" class="label" >Effective From</td>

		<%
			out.println("<td width='15%' align='left'> &nbsp;&nbsp;&nbsp;<input type='text' name='eff_date_from1' id='eff_date_from1' size='10'   onblur='CheckDate(this)' maxlength='10' value='");
		 	if ( rset.getDate("eff_date_from") != null )
			{
			 java.util.Date date = rset.getDate("eff_date_from");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 String dateString = formatter.format(date);
			 out.println(dateString);
			 date = null;
			 formatter = null;
			}
			else
			 out.println("");
			 out.println("'> </td>");
		%>

			 <td width="5%" align="left" class="label">&nbsp;&nbsp;To&nbsp;&nbsp;</td>

		<%
			out.println("<td width='40%' align='left'><input type='text' name='eff_date_to1' id='eff_date_to1' size='10'  onblur='CheckDate(this)' maxlength='10' value='");

			if ( rset.getDate("eff_date_to") != null)
			{
			 java.util.Date date1 = rset.getDate("eff_date_to");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 String dateString = formatter.format(date1);
			 out.println(dateString);
			 date1 = null;
			 formatter = null;
			}
			else
			 out.println("");

		 	 out.println("'> </td>");

		%>


		</tr>-->
		<tr>
			 <td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			  <td width="60%" class='fields' class="label" colspan="3">&nbsp;&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E"
		<%
			  String eff_status = rset.getString("eff_status");
			   if  ( eff_status.equals("E") )
			    	out.println("checked>");
			   else
			    	out.println(">");
   		  	  	out.println("</td>");
   		%>
		</tr>
		<tr>
			 <td width="40%" class="label"><fmt:message key="eAM.NoofRanges.label" bundle="${am_labels}"/></td>
		<%
			 out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='no_of_ranges' id='no_of_ranges' size='1' maxlength='1'  value='"+rset.getString("no_of_ranges")+ "' onBlur='CheckNum(this);func();newTest()'>");
			 out.println("<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>");
		%>
		</tr>

			<tr><td>&nbsp;</td><td>&nbsp;</td></tr>

	    </table>
	</td>
    </tr>
</table>



<table border="0" cellpadding="0" cellspacing="0" width="85%">

			
			<th align='LEFT'><fmt:message key="eAM.Ranges.label" bundle="${am_labels}"/></th>

<tr>
  <td class="BORDER" width="100%">
	<table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<tr>
					<td width="40%" align="right" class="label">&nbsp;</td>
					<td width="15%" align="left" class="label">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td width="15%" align="left" class="label">&nbsp;<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
					<td width="15%" align="left" class="label">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>	
					<td width="15%" align="left" class="label">&nbsp;<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
				</tr>	

		<tr>
			<td width="40%" class="label">Range 1</td>
			<%
				str="";
				if((rset.getString("range_1_fr")==null)||rset.getString("range_1_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_1_fr");


				out.println("<td width='15%' class='fields'>&nbsp;&nbsp; <input type='text' name='range_1_fr' id='range_1_fr' size='6'  value='"+ str + "'maxlength='6'  onFocus='test(1)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'></td>");
				out.println("<td width='15%' class='fields' >&nbsp;<select name='range_1_fr_unit' id='range_1_fr_unit'  onFocus='test(1)'  >");

				

				String strUnit ="";

				if((rset.getString("range_1_fr_unit")==null)||rset.getString("range_1_fr_unit").equals("null"))
					strUnit="";
				else
					strUnit=rset.getString("range_1_fr_unit");
				out.println("It's coming befor");
				if((strUnit != null) && !(strUnit.equals("")))
				{

					if(strUnit.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");
					out.println("</select>");
					}
					if(strUnit.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");
					out.println("</select>");
					}
					if(strUnit.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years");
					out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");
					out.println("</select>");
					}
					if(strUnit.equals("K"))
					{
					out.println("<OPTION selected VALUE="+"K"+">Kgs");
					out.println("<OPTION VALUE="+"L"+">Lbs");
					out.println("</select>");
					}
					if(strUnit.equals("L"))
					{
					out.println("<OPTION selected VALUE="+"L"+">Lbs");
					out.println("<OPTION VALUE="+"K"+">Kgs");
					out.println("</select>");
					}

				}


				//out.println("It's coming after");

				str="";
				if(rset.getString("range_1_to")==null)
					str="";
				else
					str=rset.getString("range_1_to");

				out.println("</td><td width='15%'class='fields' >&nbsp;<input type='text' name='range_1_to' id='range_1_to' size='6' value='"+ str +"' maxlength='6' onFocus='test(1)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_1_to_unit' id='range_1_to_unit' onFocus='test(1)'  >");

				String strUnitTo1 ="";

				if(rset.getString("range_1_to_unit")==null)
					strUnitTo1="";
				else
					strUnitTo1=rset.getString("range_1_to_unit");


				if(strUnitTo1.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo1.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo1.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitTo1.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitTo1.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}



			 %>
			</td>

		</tr>

		<tr>
			<td width="40%" class="label">Range 2</td>
			<%


				if(rset.getString("range_2_fr")==null|| rset.getString("range_2_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_2_fr");

				out.println("<td width='15%'class='fields' >&nbsp;&nbsp; <input type='text' name='range_2_fr' id='range_2_fr' size='6'  value='"+str + "'maxlength='6' onFocus='test(2)' onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'></td>");
				out.println("<td width='15%' class='fields' >&nbsp;<select name='range_2_fr_unit' id='range_2_fr_unit' onFocus='test(2)' >");

				String strUnitFrom2 ="";

				if(rset.getString("range_2_fr_unit")==null)
					strUnitFrom2="";
				else
					strUnitFrom2=rset.getString("range_2_fr_unit");
				out.println("strUnitFrom2::::"+strUnitFrom2);

				if(strUnitFrom2.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom2.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom2.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitFrom2.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitFrom2.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}


				str="";
				if( rset.getString("range_2_to")==null || rset.getString("range_2_to").equals("null"))
					str="";
				else
					str=rset.getString("range_2_to");



				out.println("</td><td width='15%' class='fields' >&nbsp;<input type='text' name='range_2_to' id='range_2_to' size='6' value='"+ str + "' maxlength='6' onFocus='test(2)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_2_to_unit' id='range_2_to_unit' onFocus='test(2)' >");

				String strUnitTo2 ="";

				if(rset.getString("range_2_to_unit")==null)
					strUnitTo2="";
				else
					strUnitTo2=rset.getString("range_2_to_unit");
				//out.println("strUnitFrom2::::"+strUnitFrom2);

				if((strUnitTo2).equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitTo2).equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitTo2).equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if((strUnitTo2).equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if((strUnitTo2).equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 %>
			</td>
		</tr>

		<tr>
			<td width="40%" class="label">Range 3</td>
			<%
				str="";
				if(rset.getString("range_3_fr")==null|| rset.getString("range_3_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_3_fr");
					
				String strUnitFrom3 ="";

				if(rset.getString("range_3_fr_unit")==null)
					strUnitFrom3="";
				else
					strUnitFrom3=rset.getString("range_3_fr_unit");

				out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_3_fr' id='range_3_fr' size='6' onKeyPress='return checkNoDecimal(this,event);' value='"+ str + "'maxlength='6'  onFocus='test(3)'  onBlur='CheckNum(this)'></td>");
				out.println("<td width='15%' class='fields'>&nbsp;<select name='range_3_fr_unit' id='range_3_fr_unit' onFocus='test(3)' >");

				if((strUnitFrom3).equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitFrom3).equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitFrom3).equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if((strUnitFrom3).equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if((strUnitFrom3).equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}
				str="";
				if(rset.getString("range_3_to")==null||rset.getString("range_3_to").equals("null"))
					str="";
				else
					str=rset.getString("range_3_to");

				String strUnitTo3 ="";

				if(rset.getString("range_3_to_unit")==null)
					strUnitTo3="";
				else
					strUnitTo3=rset.getString("range_3_to_unit");

				out.println("</td><td width='15%' class='fields' >&nbsp;<input type='text' name='range_3_to' id='range_3_to' size='6' value='"+str +"' maxlength='6'  onFocus='test(3)' onKeyPress='return checkNoDecimal(this,event);'  onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_3_to_unit' id='range_3_to_unit'  onFocus='test(3)' >");

				if((strUnitTo3).equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitTo3).equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitTo3).equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select></td>");
				}
				if((strUnitTo3).equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitTo3.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 %>
			</td>
		</tr>


		<tr>
			<td width="40%" class="label">Range 4</td>
			<%
				str="";
				if(rset.getString("range_4_fr")==null||rset.getString("range_4_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_4_fr");

				String strUnitFrom4 ="";

				if(rset.getString("range_4_fr_unit")==null)
					strUnitFrom4="";
				else
					strUnitFrom4=rset.getString("range_4_fr_unit");


				out.println("<td width='15%'class='fields' >&nbsp;&nbsp; <input type='text' name='range_4_fr' id='range_4_fr' size='6'  value='"+ str + "'maxlength='6'  onFocus='test(4)'  onBlur='CheckNum(this)' onKeyPress='return checkNoDecimal(this,event);'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_4_fr_unit' id='range_4_fr_unit'  onFocus='test(4)' >");

				if((strUnitFrom4).equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitFrom4).equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitFrom4).equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if((strUnitFrom4).equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if((strUnitFrom4).equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

				str="";
				if(rset.getString("range_4_to")==null||rset.getString("range_4_to").equals("null"))
					str="";
				else
					str=rset.getString("range_4_to");
				



				out.println("</td><td width='15%' class='fields'>&nbsp;<input type='text' name='range_4_to' id='range_4_to' size='6' value='"+str+"' maxlength='6'  onFocus='test(4)' onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_4_to_unit' id='range_4_to_unit'  onFocus='test(4)' >");

				String strUnitTo4 ="";

				if(rset.getString("range_4_to_unit")==null)
					strUnitTo4="";
				else
					strUnitTo4=rset.getString("range_4_to_unit");


				if(strUnitTo4.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo4.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo4.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("</select>");
				}
				if(strUnitTo4.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitTo4.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 %>
				 
			</td>

		</tr>

		<tr>
			<td width="40%" class="label">Range 5</td>
			<%

				str="";
				if(rset.getString("range_5_fr")==null || rset.getString("range_5_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_5_fr");



				out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_5_fr' id='range_5_fr' size='6'  value='"+str+ "'maxlength='6'  onFocus='test(5)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_5_fr_unit' id='range_5_fr_unit'  onFocus='test(5)'>");

				String strUnitFrom5 ="";

				if(rset.getString("range_5_fr_unit")==null)
					strUnitFrom5="";
				else
					strUnitFrom5=rset.getString("range_5_fr_unit");



				if(strUnitFrom5.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom5.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom5.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitFrom5.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitFrom5.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

				str="";
				if(rset.getString("range_5_to")==null || rset.getString("range_5_to").equals("null"))
					str="";
				else
					str=rset.getString("range_5_to");



				out.println("</td><td width='15%' class='fields' >&nbsp;<input type='text' name='range_5_to' id='range_5_to' size='6' value='"+ str +"' maxlength='6'  onFocus='test(5)' onKeyPress='return checkNoDecimal(this,event);'  onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_5_to_unit' id='range_5_to_unit'  onFocus='test(5)'>");

					String strUnitTo5 ="";

					if(rset.getString("range_5_to_unit")==null)
					strUnitTo5="";
					else
					strUnitTo5=rset.getString("range_5_to_unit");


				if(strUnitTo5.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo5.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo5.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitTo5.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitTo5.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 %>
			</td>

		</tr>




		<tr>
			<td width="40%" class="label">Range 6</td>
			<%

				str="";
				if(rset.getString("range_6_fr")==null|| rset.getString("range_6_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_6_fr");


				out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_6_fr' id='range_6_fr' size='6'  value='"+ str + "'maxlength='6'  onFocus='test(6)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields'>&nbsp;<select name='range_6_fr_unit' id='range_6_fr_unit'  onFocus='test(6)'>");

					String strUnitFrom6 ="";

					if(rset.getString("range_6_fr_unit")==null)
					strUnitFrom6="";
					else
					strUnitFrom6=rset.getString("range_6_fr_unit");
				
				out.println("str from 6"+strUnitFrom6);

				if(strUnitFrom6.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom6.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom6.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitFrom6.equals("K"))
				{

				out.println("Str from 6::"+strUnitFrom6);
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitFrom6.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

				str="";
				if(rset.getString("range_6_to")==null||rset.getString("range_6_to").equals("null"))
					str="";
				else
					str=rset.getString("range_6_to");


				out.println("</td><td width='15%' class='fields' >&nbsp;<input type='text' name='range_6_to' id='range_6_to' size='6' value='"+ str +"' maxlength='6'  onFocus='test(6)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_6_to_unit' id='range_6_to_unit'  onFocus='test(6)'>");

				if(rset.getString("range_6_to_unit").equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(rset.getString("range_6_to_unit").equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(rset.getString("range_6_to_unit").equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(rset.getString("range_6_to_unit").equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(rset.getString("range_6_to_unit").equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 %>
			</td>

		</tr>

			<tr><td>&nbsp;</td><td>&nbsp;</td></tr>

	</table>
    </td>
  </tr>
</table>




<%

	out.println("</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");

}


//CODE FOR DISABLED RECORDS


if ( rset.getString("eff_status").equals("D") )
{
%>      <BR>
	<table border="0" cellpadding="0" cellspacing="0" width="85%">
	  <tr>
		<td class="BORDER" width="100%">
		 <table border='0' cellpadding='0' cellspacing='0' width='100%'>
			<tr>
			   	<td class="label" width="40%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			   	<td class='fields' width="60%" colspan="3">&nbsp;&nbsp;

				<%
				   if (rset.getString("range_type").equals("A"))
				   {
			           	out.println("<input type='text' name='range_type' id='range_type' value='Age' size='13'   maxlength='13' readonly> ");

		   		   }
				   if (rset.getString("range_type").equals("W"))
				   {
				  		out.println("<input type='text' name='range_type' id='range_type' value='Weight' size='13' maxlength='13'  readonly>");

				   }
				   if (rset.getString("range_type").equals("C"))
				   {
					out.println("<input type='text' name='range_type' id='range_type' value='Circumference' size='13' maxlength='13' readonly> ");
		   		   }
				   if (rset.getString("range_type").equals("L"))
				   {
					out.println("<input type='text' name='range_type' id='range_type' value='Length' size='13' maxlength='13' readonly> ");
		   		   }
				 if (rset.getString("range_type").equals("G"))
				   {
					out.println("<input type='text' name='range_type' id='range_type' value='Gestation' size='13' maxlength='13' readonly> ");
		   		   }
				 if (rset.getString("range_type").equals("P"))
				   {
					out.println("<input type='text' name='range_type' id='range_type' value='Apgar' size='13' maxlength='13' readonly> ");

		   		   }
			    %>


					&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td width="40%" class="label"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
				<%
				out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp;&nbsp;<input type='text' name='range_id' id='range_id' size='4' value='"+rset.getString("range_id")+ "' maxlength='4' readonly>");
				out.println("<img src='../../eCommon/images/mandatory.gif'></img></td>");
				%>
			</tr>
			<tr>
				 <td width="40%" class="label">Long Desc</td>
				 <%
				 out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='long_desc' id='long_desc' size='30'  value= \"" +rset.getString("long_desc")+ "\" maxlength='30' readonly>");
				 out.println("<img src='../../eCommon/images/mandatory.gif'></img></td>");
				 %>
			</tr>
			<tr>
				 <td width="40%" class="label">Short Desc</td>
				 <%
				 out.println("<td width='60%'class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='short_desc' id='short_desc' size='15' value=\"" +rset.getString("short_desc")+ "\" maxlength='15' readonly>");
				 out.println("<img src='../../eCommon/images/mandatory.gif'></img></td>");
				 %>
			</tr>

			<!-- <tr>
				 <td width="40%" align="right" class="label" >Effective From</td>

			<-%
				out.println("<td width='15%' align='left'> &nbsp;&nbsp;&nbsp;<input type='text' name='eff_date_from1' id='eff_date_from1' size='10'   onblur='CheckDate(this)' maxlength='10' value='");
			 	if ( rset.getDate("eff_date_from") != null )
				{
				 java.util.Date date = rset.getDate("eff_date_from");
				 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
				 String dateString = formatter.format(date);
				 out.println(dateString);
				 date = null;
				 formatter = null;
				}
				else
				 out.println("");
				 out.println("' readonly> </td>");
			%->

				 <td width="5%" align="left" class="label">&nbsp;To&nbsp;&nbsp;</td>

			<-%
				out.println("<td width='40%' align='left'><input type='text' name='eff_date_to1' id='eff_date_to1' size='10'  onblur='CheckDate(this)' maxlength='10' value='");

				if ( rset.getDate("eff_date_to") != null)
				{
				 java.util.Date date1 = rset.getDate("eff_date_to");
				 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
				 String dateString = formatter.format(date1);
				 out.println(dateString);
				 date1 = null;
				 formatter = null;
				}
				else
				 out.println("");

			 	 out.println("'readonly> </td>");

			%->


			</tr> -->
			<tr>
				 <td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				  <td width="60%" class='fields' colspan="3">&nbsp;&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E"
			<%
				  String eff_status = rset.getString("eff_status");
				   if  ( eff_status.equals("E") )
				    	out.println("checked>");
				   else
				    	out.println(">");
	   		  	  	out.println("</td>");
	   		%>
			</tr>
			<tr>
				 <td width="40%" class="label"><fmt:message key="eAM.NoofRanges.label" bundle="${am_labels}"/></td>
			<%
				 out.println("<td width='60%'class='fields'colspan='3'>&nbsp;&nbsp; <input type='text' name='no_of_ranges' id='no_of_ranges' size='1' maxlength='1' readonly value='"+rset.getString("no_of_ranges")+ "' onBlur='func()'>");
				 out.println("<img src='../../eCommon/images/mandatory.gif'></img></td>");
			%>
			</tr>
<TR><td>&nbsp</td><td>&nbsp;</td></tr>
		    </table>
		</td>
	    </tr>
	</table>

	

	<table border="0" cellpadding="0" cellspacing="0" width="85%">
	<th align='LEFT'><fmt:message key="eAM.Ranges.label" bundle="${am_labels}"/></th>
	<tr>
	  <td class="BORDER" width="100%">
		<table border='0' cellpadding='0' cellspacing='0' width='100%'>
			<tr>
					<td width="40%" align="right" class="label">&nbsp;</td>
					<td width="15%" align="left" class="label">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td width="15%" align="left" class="label">&nbsp;<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
					<td width="15%" align="left" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>	
					<td width="15%" align="left" class="label">&nbsp;<fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
				</tr>	

		<tr>

			<tr>
				<td width="40%" class="label">Range 1</td>
				<%

					str="";
					if(rset.getString("range_1_fr")==null)
						str="";
					else
						str=rset.getString("range_1_fr");

					 String strUnitFrom1 ="";
					if(rset.getString("range_1_fr_unit")==null|| rset.getString("range_1_fr_unit").equals("null"))
							strUnitFrom1 ="";
						else
							strUnitFrom1=rset.getString("range_1_fr_unit");


					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_1_fr' id='range_1_fr' size='6'  value='"+ str +
					"' maxlength='6'  readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_1_fr_unit' id='range_1_fr_unit' >");

					if(strUnitFrom1.equals("D"))
					{

					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom1.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPT0ION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom1.equals("Y"))
					{

					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}

					if(strUnitFrom1.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitFrom1.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}





					str="";
					if(rset.getString("range_1_to")==null|| rset.getString("range_1_to").equals("null"))
							str="";
						else
							str=rset.getString("range_1_to");

					//out.println("str is "+str);

					out.println("</td><td width='15%' class='fields'>&nbsp;&nbsp;<input type='text' name='range_1_to' id='range_1_to' size='6' value='"+str +"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_1_to_unit' id='range_1_to_unit'>");
					String strUnitTo1 ="";

					if(rset.getString("range_1_to_unit")==null)
					strUnitTo1="";
					else
					strUnitTo1=rset.getString("range_1_to_unit");

					if(strUnitTo1.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo1.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo1.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitTo1.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitTo1.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}



				 %>
				</td>

			</tr>

			<tr>
				<td width="40%" class="label">Range 2</td>
				<%

					str="";
					if(rset.getString("range_2_fr")==null||rset.getString("range_2_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_2_fr");
							out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_2_fr' id='range_2_fr' size='6'  value='"+ str + "' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_2_fr_unit' id='range_2_fr_unit' >");

					String strUnitFrom2 ="";

					if(rset.getString("range_2_fr_unit")==null)
					strUnitFrom2="";
					else
					strUnitFrom2=rset.getString("range_2_fr_unit");


					if(strUnitFrom2.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom2.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom2.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitFrom2.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitFrom2.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




					str="";
					if(rset.getString("range_2_to")==null||rset.getString("range_2_to").equals("null"))
						str="";
					else
						str=rset.getString("range_2_to");


					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_2_to' id='range_2_to' size='6' value='"+str+ "' maxlength='6' readonly>");
					out.println("</td><td width='15%'class='fields'>&nbsp;<select name='range_2_to_unit' id='range_2_to_unit'>");
					String strUnitTo2 ="";

					if(rset.getString("range_2_to_unit")==null)
					strUnitTo2="";
					else
					strUnitTo2=rset.getString("range_2_to_unit");

					if((strUnitTo2).equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitTo2).equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitTo2).equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if((strUnitTo2).equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if((strUnitTo2).equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}



				 %>
			</tr>

			<tr>
				<td width="40%" class="label">Range 3</td>
				<%

					str="";
					if(rset.getString("range_3_fr")==null||rset.getString("range_3_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_3_fr");


					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_3_fr' id='range_3_fr' size='6'  value='"+str + "'maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_3_fr_unit' id='range_3_fr_unit' >");

					String strUnitFrom3 ="";

					if(rset.getString("range_3_fr_unit")==null)
					strUnitFrom3="";
					else
					strUnitFrom3=rset.getString("range_3_fr_unit");

					if((strUnitFrom3).equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitFrom3).equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitFrom3).equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if((strUnitFrom3).equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if((strUnitFrom3).equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}



					str="";
					if(rset.getString("range_3_to")==null||rset.getString("range_3_to").equals("null"))
						str="";
					else
						str=rset.getString("range_3_to");



					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_3_to' id='range_3_to' size='6' value='"+ str +"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_3_to_unit' id='range_3_to_unit'>");

					String strUnitTo3 ="";

					if(rset.getString("range_3_to_unit")==null)
					strUnitTo3="";
					else
					strUnitTo3=rset.getString("range_3_to_unit");

					if((strUnitTo3).equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitTo3).equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitTo3).equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if((strUnitTo3).equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if((strUnitTo3).equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




				 %>
				</td>
			</tr>


			<tr>
				<td width="40%" class="label">Range 4</td>
				<%

					str="";
					if(rset.getString("range_4_fr")==null||rset.getString("range_4_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_4_fr");

					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_4_fr' id='range_4_fr' size='6'  value='"+str+ "'maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_4_fr_unit' id='range_4_fr_unit' >");

					String strUnitFrom4="";
					if(rset.getString("range_4_fr_unit")==null)
					strUnitFrom4="";
					else
					strUnitFrom4=rset.getString("range_4_fr_unit");


					if((strUnitFrom4).equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitFrom4).equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitFrom4).equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if((strUnitFrom4).equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if((strUnitFrom4).equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




					str="";
					if(rset.getString("range_4_to")==null||rset.getString("range_4_to").equals("null"))
						str="";
					else
						str=rset.getString("range_4_to");

					String strUnitTo4 ="";

					if(rset.getString("range_4_to_unit")==null)
					strUnitTo4="";
					else
					strUnitTo4=rset.getString("range_4_to_unit");



					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_4_to' id='range_4_to' size='6' value='"+ str+"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_4_to_unit' id='range_4_to_unit'>");

					if(strUnitTo4.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo4.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo4.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitTo4.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitTo4.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




				 %>
				</td>

			</tr>

			<tr>
				<td width="40%" class="label">Range 5</td>
				<%

					str="";
					if(rset.getString("range_5_fr")==null||rset.getString("range_5_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_5_fr");


					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_5_fr' id='range_5_fr' size='6'  value='"+str+ "'maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_5_fr_unit' id='range_5_fr_unit' >");

					String strUnitFrom5 ="";

					if(rset.getString("range_5_fr_unit")==null)
					strUnitFrom5="";
					else
					strUnitFrom5=rset.getString("range_5_fr_unit");

					if(strUnitFrom5.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom5.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom5.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitFrom5.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitFrom5.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}





					str="";
					if(rset.getString("range_5_to")==null||rset.getString("range_5_to").equals("null"))
						str="";
					else
						str=rset.getString("range_5_to");


					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_5_to' id='range_5_to' size='6' value='"+ str +"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_5_to_unit' id='range_5_to_unit'>");

					String strUnitTo5 ="";

					if(rset.getString("range_5_fr_unit")==null)
					strUnitTo5="";
					else
					strUnitTo5=rset.getString("range_5_fr_unit");


					if(strUnitTo5.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo5.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo5.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitTo5.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitTo5.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




				 %>
				</td>

			</tr>




			<tr>
				<td width="40%" class="label">Range 6</td>
				<%
					str="";
					if(rset.getString("range_6_fr")==null||rset.getString("range_6_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_6_fr");

					
					String strUnitFrom6 ="";

					if(rset.getString("range_6_fr_unit")==null)
					strUnitFrom6="";
					else
					strUnitFrom6=rset.getString("range_6_fr_unit");



					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_6_fr' id='range_6_fr' size='6'  value='"+ str + "'maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_6_fr_unit' id='range_6_fr_unit' >");

					if(strUnitFrom6.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom6.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom6.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitFrom6.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitFrom6.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




					str="";
					if(rset.getString("range_6_to")==null||rset.getString("range_6_to").equals("null"))
						str="";
					else
						str=rset.getString("range_6_to");


					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_6_to' id='range_6_to' size='6' value='"+ str+"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_6_to_unit' id='range_6_to_unit'>");

					if(rset.getString("range_6_to_unit").equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(rset.getString("range_6_to_unit").equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(rset.getString("range_6_to_unit").equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(rset.getString("range_6_to_unit").equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(rset.getString("range_6_to_unit").equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




				 %>
				</td>

			</tr>
			<tr><td>&nbsp;</td><td>&nbsp;</td></tr>	
		</table>
	    </td>
	  </tr>
	</table>



	<%

		out.println("</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");

}

}
catch ( Exception e )
{
	e.printStackTrace();
	out.println(e);
	
}

finally{
	if ( stmt != null ) stmt.close() ;
  	if ( rset != null ) rset.close() ;
	ConnectionManager.returnConnection(conn,request);
}


%>
</body>
</html>

