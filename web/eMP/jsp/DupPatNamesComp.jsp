<!DOCTYPE html>
<%--
	Created On : 4/26/2006 9:20 AM	  By Vinod
	Modified On : 5/5/2006 9:21 AM
	Modified By : Vinod
	Patient Names Component
	-------------------------
	A common component to draw the patient Names, included in "ChangePatientSubNames.jsp"
	The table definition part in "ChangePatientSubnames.jsp" is required to be included in any jsp for alignment purposes.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.sql.*, java.util.HashMap, java.util.ArrayList, webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"  %> 
<SCRIPT LANGUAGE="JavaScript"> 
var NamePrefixArray = new Array(); 
var NamePrefixLocArray = new Array(); 
var PrefixSexArray = new Array();
var NameSuffixArray = new Array();
var NameSuffixLocArray = new Array();
var SuffixSexArray = new Array();

async function callSearch(fromobj, toobj, field_lang)
{
	var names_in_oth_lang = document.forms[0].pat_names_in_oth_lang_yn.value;
	var lang_dir = document.forms[0].language_direction.value;	
	if(lang_dir == 'R')
	{
		var jsp_name ="../../eMP/jsp/SearchStdOtherName.jsp?names_in_oth_lang="+names_in_oth_lang+"&param_value="+encodeURIComponent(fromobj.value)+"&field_lang="+field_lang;
			
		if(fromobj.name == "family_name" || fromobj.name=="family_name_oth_lang")
		{
			jsp_name ="../../eMP/jsp/SearchStdFamilyName.jsp?names_in_oth_lang="+names_in_oth_lang+"&param_value="+encodeURIComponent(fromobj.value)+"&field_lang="+field_lang;
		}

		var retVal = new String();
		var dialogHeight = "28";
		var dialogWidth = "43";
		var status = "no";
		var arguments = "";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal =await window.showModalDialog( jsp_name,arguments,features);

		if(retVal != null)
		{
			var arr = retVal.split("`");
			if((fromobj.name).indexOf("oth_lang") == -1)
			{
				fromobj.value =arr[0]
				toobj =eval("document.forms[0]."+toobj)
				if(toobj != null)
				{
					toobj.value = arr[1]
				}
			}
			else
			{
				toobj.value = arr[0]
				fromobj.value =arr[1]
				ChangeInitCase(toobj)
			}
			//fromobj.focus();
		}
	}
}

function sel_prefix_gen(obj)
{
var val=obj.value;
var prefix_length;
	if(obj.value != "")
	{
		if(obj.name=="name_prefix")
		{
		prefix_length=NamePrefixArray.length;
		for (i = 0; i < prefix_length; i++) 
		{                      
		 if(unescape(NamePrefixArray[i])==val)
		 {
			if(document.getElementById("name_prefix_oth_lang"))
			 { document.getElementById("name_prefix_oth_lang").value=unescape(NamePrefixLocArray[i]);
			 }
			if(unescape(PrefixSexArray[i])!='B')
			document.getElementById("sex").value=unescape(PrefixSexArray[i]);
			else
					document.getElementById("sex").value="";
			
		 }
		}
		}
		else
		{
			prefix_length=NamePrefixLocArray.length;
			for (i = 0; i < prefix_length; i++) 
			{                      
			 if(unescape(NamePrefixLocArray[i])==val)
			 {
				if(document.getElementById("name_prefix"))
				{
				document.getElementById("name_prefix").value=unescape(NamePrefixArray[i]);
				}
				if(unescape(PrefixSexArray[i])!='B')
				document.getElementById("sex").value=unescape(PrefixSexArray[i]);
				else
					document.getElementById("sex").value="";
				
			 }
			}

		}
	}
	else
	{
		if(document.getElementById("name_prefix_oth_lang"))
		document.getElementById("name_prefix_oth_lang").value="";
		if(document.getElementById("name_prefix"))
		document.getElementById("name_prefix").value="";
		document.getElementById("sex").value="";
	}
	putLocalLangPatientName();
	putPatientName();
}

function sel_suffix_gen(obj)
{
var val=obj.value;
var prefix_length;
	if(obj.value != "")
	{
		if(obj.name=="name_suffix")
		{
		prefix_length=NameSuffixArray.length;
		for (i = 0; i < prefix_length; i++) 
		{                      
		 if(unescape(NameSuffixArray[i])==val)
		 {
			if(document.getElementById("name_suffix_oth_lang"))
			{	document.getElementById("name_suffix_oth_lang").value=unescape(NameSuffixLocArray[i]);
			}
			if(unescape(SuffixSexArray[i])!='B')
			document.getElementById("sex").value=unescape(SuffixSexArray[i]);
			else
					document.getElementById("sex").value="";
			
		 }
		}
		}
		else
		{
			prefix_length=NameSuffixLocArray.length;
			for (i = 0; i < prefix_length; i++) 
			{                      
			 if(unescape(NameSuffixLocArray[i])==val)
			 {
				if(document.getElementById("name_suffix"))
				{
				document.getElementById("name_suffix").value=unescape(NameSuffixArray[i]);
				}
				if(unescape(SuffixSexArray[i])!='B')
				document.getElementById("sex").value=unescape(SuffixSexArray[i]);
				else
					document.getElementById("sex").value="";
				
			 }
			}

		}
	}
	else
	{
		if(document.getElementById("name_suffix_oth_lang"))
		document.getElementById("name_suffix_oth_lang").value="";
		if(document.getElementById("name_suffix"))
		document.getElementById("name_suffix").value="";
		document.getElementById("sex").value="";
	}
	putLocalLangPatientName();
	putPatientName();
}
</SCRIPT>
<%
    Connection conn			= null;
	PreparedStatement pstmt=null ;
    ResultSet rs=null ;
	try
	{
	String language_direction = "";
	String name_comp_visibility = "visibility:hidden";
	request.setCharacterEncoding("UTF-8");
	String facility_id=checkForNull((String)session.getAttribute("facility_id")); //added for the incident 34901

	int count=0;


	Properties p					=	 (java.util.Properties) session.getValue("jdbc");
	conn							=	 ConnectionManager.getConnection(request);
 	HashMap hash_Map				=	 new HashMap();
 	HashMap hash_Map1				=	 new HashMap();
	HashMap Name_Order 			=	 new HashMap(); 

	ArrayList array_List				=	 new ArrayList();
	



		pstmt = conn.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		
		rs = pstmt.executeQuery() ;
             
			
        if ( rs != null && rs.next() ) 
		 {
		  count = rs.getInt("total");
		 }

		
		if ( count==1 ) 
		{
			 language_direction = "R" ;
			 name_comp_visibility = "visibility:visible";
		}else
		{
			 language_direction = "L" ;
			 name_comp_visibility = "visibility:hidden";
		}


		 if(pstmt != null) pstmt.close();
		 if(rs != null) rs.close();


	String patient_id						= checkForNull(request.getParameter("patient_id"));
	String group								= checkForNull(request.getParameter("group"));
	String CalledFromFunction			= checkForNull(request.getParameter("CalledFromFunction"));
	

	String a_family_name					= checkForNull(request.getParameter("a_family_name"));
	String a_first_name					= checkForNull(request.getParameter("a_first_name"));
	String a_second_name				= checkForNull(request.getParameter("a_second_name"));
	String a_third_name					= checkForNull(request.getParameter("a_third_name"));

	String a_name_prefix_loc_lang			= checkForNull(request.getParameter("a_name_prefix_loc_lang"));
	String a_first_name_loc_lang			= checkForNull(request.getParameter("a_first_name_loc_lang"));
	String a_second_name_loc_lang		= checkForNull(request.getParameter("a_second_name_loc_lang"));
	String a_third_name_loc_lang			= checkForNull(request.getParameter("a_third_name_loc_lang"));
	String a_family_name_loc_lang			= checkForNull(request.getParameter("a_family_name_loc_lang"));
	String a_name_suffix_loc_lang			= checkForNull(request.getParameter("a_name_suffix_loc_lang"));
	//String a_patient_name_loc_lang		= checkForNull(request.getParameter("a_patient_name_loc_lang"));

	//	out.println("a_patient_name_loc_lang "+a_patient_name_loc_lang);

	hash_Map	= eMP.ChangePatientDetails.getSetupData(facility_id,group, conn,p);
	String Name_Prefix_Accept_Yn			= checkForNull((String) hash_Map.get("Name_Prefix_Accept_Yn"));
	String Name_Prefix_Reqd_Yn			= checkForNull((String) hash_Map.get("Name_Prefix_Reqd_Yn"));
	String Name_Suffix_Accept_Yn			= checkForNull((String) hash_Map.get("Name_Suffix_Accept_Yn"));
	String Name_Suffix_Reqd_Yn			= checkForNull((String) hash_Map.get("Name_Suffix_Reqd_Yn"));
	String First_Name_Accept_Yn			= checkForNull((String) hash_Map.get("First_Name_Accept_Yn"));
	String First_Name_Prompt				= checkForNull((String) hash_Map.get("First_Name_Prompt"));
	String First_Name_Reqd_Yn				= checkForNull((String) hash_Map.get("First_Name_Reqd_Yn"));
	String Second_Name_Accept_Yn		= checkForNull((String) hash_Map.get("Second_Name_Accept_Yn"));
	String Second_Name_Prompt			= checkForNull((String) hash_Map.get("Second_Name_Prompt"));
	String Third_Name_Accept_Yn			= checkForNull((String) hash_Map.get("Third_Name_Accept_Yn"));
	String Third_Name_Prompt				= checkForNull((String) hash_Map.get("Third_Name_Prompt"));
	String Family_Name_Accept_Yn		= checkForNull((String) hash_Map.get("Family_Name_Accept_Yn"));
	String Family_Name_Prompt				= checkForNull((String) hash_Map.get("Family_Name_Prompt"));
	String Second_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Second_Name_Reqd_Yn"));
	String Third_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Third_Name_Reqd_Yn"));
	String Family_Name_Reqd_Yn			= checkForNull((String) hash_Map.get("Family_Name_Reqd_Yn"));
	String pat_name_as_multipart_yn		= checkForNull((String) hash_Map.get("pat_name_as_multipart_yn"));
	
	
	String Name_Prefix_Prompt				= checkForNull((String)hash_Map.get("Name_Prefix_Prompt"));
	String  Family_Name_Order				= checkForNull((String) hash_Map.get("Family_Name_Order"));
	String  First_Name_Order				= checkForNull((String) hash_Map.get("First_Name_Order"));
	String  Second_Name_Order			= checkForNull((String) hash_Map.get("Second_Name_Order"));
	String  Third_Name_Order				= checkForNull((String) hash_Map.get("Third_Name_Order"));

	//String  name_prefix_length				= checkForNull((String) hash_Map.get("name_prefix_length"),"0");
	String  first_name_length					= checkForNull((String) hash_Map.get("first_name_length"),"0");
	String  second_name_length			= checkForNull((String) hash_Map.get("second_name_length"),"0");
	String  third_name_length				= checkForNull((String) hash_Map.get("third_name_length"),"0");
	String  family_name_length				= checkForNull((String) hash_Map.get("family_name_length"),"0");
//	String  name_suffix_length				= checkForNull((String) hash_Map.get("name_suffix_length"),"0");

	 /* Prompts and Orders are placed in Hash Map for easy retrieval */
	Name_Order.put(Family_Name_Order,"Family_Name_Order");
	Name_Order.put(First_Name_Order,"First_Name_Order");
	Name_Order.put(Second_Name_Order,"Second_Name_Order");
	Name_Order.put(Third_Name_Order,"Third_Name_Order");

	String name_suffix			= "";
	String name_prefix			= "";
	String family_name		= "";
	String first_name			= "";
	String second_name		= "";
	String third_name			= "";

	int		 emptyCnt			= 0;  /*To Count the Missing Name Fields as per MP Param*/

	ArrayList arrayList2 = new ArrayList();
	arrayList2 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix",p);
	out.println("<script>");
	int a = 0;
	for(int i=0;i<arrayList2.size();i+=3) 
	{
		out.print("NamePrefixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
		out.print("NamePrefixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
		out.print("PrefixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
		a++;
	} 
	out.println("</script>");
	arrayList2.clear();
	arrayList2 = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix2",p);
	out.println("<script>");
	a = 0;
	for(int i=0;i<arrayList2.size();i+=3) 
	{
		out.print("NameSuffixArray["+a+"]=escape(\""+(String)arrayList2.get(i)+"\");");
		out.print("NameSuffixLocArray["+a+"]=escape(\""+(String)arrayList2.get(i+1)+"\");");
		out.print("SuffixSexArray["+a+"]=escape(\""+(String)arrayList2.get(i+2)+"\");");				
		a++;
	} 
	out.println("</script>");

	
	if(CalledFromFunction.equals("ChangePatDtls")) 
	{
		 hash_Map1				= eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);
		 name_suffix				= checkForNull((String) hash_Map1.get("name_suffix"));
		 name_prefix			= checkForNull((String) hash_Map1.get("name_prefix"));
		 first_name				= checkForNull((String) hash_Map1.get("first_name"));
		 second_name			= checkForNull((String) hash_Map1.get("second_name"));
		 third_name				= checkForNull((String) hash_Map1.get("third_name"));
		 family_name			= checkForNull((String) hash_Map1.get("family_name"));
	}
%>
	<tr>
		<%
						
			/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
			   if  (pat_name_as_multipart_yn.equals("Y"))
			   {
				     String order = "";
					 for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						
						 if (order.equals("First_Name_Order"))
						 {
							if(First_Name_Accept_Yn.equals("Y")) 
							{ 
								%>
								<td  class='LABELLEFT'  ><%=First_Name_Prompt%>
								<%
								if(First_Name_Reqd_Yn.equals("Y")) 
								{%>
									<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></td>
									<input type='hidden' name='first_name_prompt' id='first_name_prompt' value="<%=First_Name_Prompt%>">
								<%} else 
								{ %> <input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input></td> <% }
									%><td class='LABELLEFT' >&nbsp;</td><%
							}
							 else
								emptyCnt++;
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if(Second_Name_Accept_Yn.equals("Y")) 
							{
								%>
								<td  class='LABELLEFT' ><%=Second_Name_Prompt%>
								<% if(Second_Name_Reqd_Yn.equals("Y")) { %>
								<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input><img src='../../eCommon/images/mandatory.gif'></img></td>
								<input type='hidden' name='second_name_prompt' id='second_name_prompt' value="<%=Second_Name_Prompt%>">
								<% } else { %> <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input></td> <% }
								%><td class='LABELLEFT' >&nbsp;</td><%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							 if (Third_Name_Accept_Yn.equals("Y") )
							{ 
								%>
								<td  class='LABELLEFT' ><%=Third_Name_Prompt%>
							   <% if(Third_Name_Reqd_Yn.equals("Y")) { %>
									<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input><img src='../../eCommon/images/mandatory.gif'></img></td>
									<input type='hidden' name='third_name_prompt' id='third_name_prompt' value="<%=Third_Name_Prompt%>">
								<% } else { %> <input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input></td> <% }
								%><td class='LABELLEFT' >&nbsp;</td><%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if (Family_Name_Accept_Yn.equals("Y") ) 
							{  %>
								<td  class='LABELLEFT'  nowrap ><%=Family_Name_Prompt%>
								<%
								 if(Family_Name_Reqd_Yn.equals("Y")) { %></td><input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>
									<input type='hidden' name='family_name_prompt' id='family_name_prompt' value="<%=Family_Name_Prompt%>">
								  <% } else { %>  <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input></td> <% }
								  %><td class='LABELLEFT' >&nbsp;</td><%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 {
							 emptyCnt++;
						 }
					}
			   }else{ 

				if(Family_Name_Accept_Yn.equals("Y")) 
				{ 
					%>
					<td  class='LABELLEFT'  ><%=Family_Name_Prompt%>
						<%  if(Family_Name_Reqd_Yn.equals("Y")) { %>
						<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input></td>
						<input type='hidden' name='family_name_prompt' id='family_name_prompt' value="<%=Family_Name_Prompt%>">
					<% } else { %> <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input></td> <% }
				}}
					/*  if (pat_name_as_multipart_yn.equals("Y") */
				
				 /*To fill the blank spaces in the table with blank TDs*/
				for(int j=1;j<=emptyCnt;++j)
					{%><td class='LABELLEFT' colspan='2'>&nbsp;</td><%}
				%>
			</tr>
			<tr>

				<%	
			    emptyCnt = 0;
			   	if (pat_name_as_multipart_yn.equals("Y") )
				{
					 String order = "";
					 for(int i=1;i<=4;++i)
					 {
						 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

						

						 if (order.equals("First_Name_Order"))
						 {
							if(First_Name_Accept_Yn.equals("Y")) 
							{ 
								%>
								<td   class='fields'  width='25%' nowrap>
								<%
								out.print("<input type='text' name='first_name' id='first_name' maxlength='"+first_name_length+"' size='"+first_name_length+"'      onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this)' tabIndex='15'");
								if(CalledFromFunction.equals("ChangePatDtls") || !a_first_name.equals(""))
								{
									if(CalledFromFunction.equals("ChangePatDtls"))
									{
										if(!(((String)hash_Map1.get("first_name")).equals("")))
											out.print(" value=\""+(String)hash_Map1.get("first_name")+"\">");
										else out.print(" value=\"\" >"); 
									}
									else if(!a_first_name.equals(""))
										out.print(" value=\""+a_first_name+"\">");
									else out.print(" value=\"\" >"); 
								}
								else out.print(" value = \"\" >");%><input type='button' style='<%=name_comp_visibility%>' class='button' value='?' onclick="callSearch(first_name,'first_name_oth_lang','English')" name='bf'></td><td class='label' ></td> <%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Second_Name_Order"))
						 {
							 if (Second_Name_Accept_Yn.equals("Y")) 
							{ 
								%>
								<td   class='fields'  width='25%' nowrap>
								<%  out.print("<input type='text' name='second_name' id='second_name' maxlength='"+second_name_length+"' size='"+second_name_length+"' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this)' tabIndex='15'");
								if(CalledFromFunction.equals("ChangePatDtls") || !a_second_name.equals(""))
								{
									if(CalledFromFunction.equals("ChangePatDtls"))
									{
										if (!(((String)hash_Map1.get("second_name"))).equals(""))
											out.print(" value=\""+checkForNull((String)hash_Map1.get("second_name"))+"\">");
										else out.print(" value = \"\" >");
									}
									else if(!a_second_name.equals(""))
									{
										out.print(" value=\""+a_second_name+"\">");
									}
									else out.print(" value = \"\" >");
								} else out.print(" value = \"\" >");%><input type='button' style='<%=name_comp_visibility%>' class='button' value='?' onclick="callSearch(second_name,'second_name_oth_lang','English')" name='bs'></td><td class='label' >&nbsp;</td><%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Third_Name_Order"))
						 {
							if(Third_Name_Accept_Yn.equals("Y")) 
							{ 
								%>
								<td class='fields' width='25%' nowrap>
								<%  out.print("<input type='text' name='third_name' id='third_name' maxlength='"+third_name_length+"' size='"+third_name_length+"'  onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this)' tabIndex='15'");
								if(CalledFromFunction.equals("ChangePatDtls") || !a_third_name.equals(""))
								{
									if(CalledFromFunction.equals("ChangePatDtls"))
									{
										if(!(((String)hash_Map1.get("third_name")).equals("")))
											out.print(" value=\""+(String)hash_Map1.get("third_name")+"\">");
										else out.print(" value = \"\" >");    
									}
									else if(!a_third_name.equals(""))
									{
										out.print(" value=\""+a_third_name+"\">");
									}
									else out.print(" value = \"\" >");    
								}else out.print(" value = \"\" >");%><input type='button' style='<%=name_comp_visibility%>' class='button' value='?' onclick="callSearch(third_name,'third_name_oth_lang','English')" name='bt' id='bt'></td><td class='label' >&nbsp;</td> <%
							}
							else
							{
								emptyCnt++;
							}
						 }
						 else
						 if (order.equals("Family_Name_Order"))
						 {
							 if(Family_Name_Accept_Yn.equals("Y")) 
							{   
								out.print("<td  class='fields'  width='25%' nowrap><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"'  onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this)' tabIndex='15'");
								if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name.equals(""))
								{
									if((CalledFromFunction.equals("ChangePatDtls")) && !(((String)hash_Map1.get("family_name")).equals("")))
										out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
									else if(!a_family_name.equals(""))
										out.print(" value=\""+a_family_name+"\">");
									else out.print(" value = \"\" >");    
								} else out.print(" value = \"\" >");    
								if (pat_name_as_multipart_yn.equals("Y")) { %><input type='button' style='<%=name_comp_visibility%>' class='button' value='?' onclick="callSearch(family_name,'family_name_oth_lang','English')" name='bfam'> 
								<% } %> 
								</td><td class='label' >&nbsp;</td>
								<% 
							}
							else
							{
								emptyCnt++;
							}
						 }
						  else
						  {
							 emptyCnt++;
						  }
						}
			}/* END of	if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
				 
				
			    if(Family_Name_Accept_Yn.equals("Y"))  
			    { 
				out.print("<td class='fields' nowrap ><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);ChangeInitCase(this);putPatientName(this);' tabIndex='18'");
				}
				if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name.equals(""))
				{
					
					if( (CalledFromFunction.equals("ChangePatDtls")) && !(((String)hash_Map1.get("family_name")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name")+"\">");
					else if(!a_family_name.equals(""))
						out.print(" value=\""+a_family_name+"\" >");
					else out.print(" value = \"\" >");   
				}  
				else if(Family_Name_Accept_Yn.equals("Y"))
				{
					out.print(" value = \"\" >");
				%></td><%
				}
					
			 }
		 /*To fill the blank spaces in the table with blank TDs*/
		for(int j=1;j<=emptyCnt;++j)
			{%><td class='label' colspan='2'>&nbsp;</td><%}
		%>
		</tr>
		<tr><td colspan='4'>&nbsp;</tr>
	   <script>
		if ( (document.getElementById("family_org_membership")) && (document.forms[0].name_prefix_img) )
		{
			if (document.getElementById("family_org_membership").value=='1' && document.getElementById("name_pfx_reqd_for_org_mem_yn").value=='Y'  ){
				document.forms[0].name_prefix_img.style.visibility='visible';
			}else{
				document.forms[0].name_prefix_img.style.visibility='hidden';
		}}
		</script>
		<%
		if (CalledFromFunction.equals("ChangePatDtls") ) { %>
				<script>
				if ( document.forms[0].name_prefix_oth_lang)
				{
					if ( (document.getElementById("family_org_membership")) && (document.getElementById("family_org_membership").value=='1')  ) 
					{
						document.forms[0].name_prefix_oth_lang.disabled=true;
					}else{
						document.forms[0].name_prefix_oth_lang.disabled=false;
					}
				}
				</script>
		<% }
	//String names_in_oth_lang_yn	= checkForNull(request.getParameter("names_in_oth_lang_yn"));
		
	String family_name_loc_lang_prompt= checkForNull((String) hash_Map.get("family_name_loc_lang_prompt"));
	String pat_name_in_loc_lang_reqd_yn   =checkForNull(request.getParameter("pat_name_in_loc_lang_reqd_yn"),"N");
	
	String first_name_loc_lang_prompt			=checkForNull((String)hash_Map.get("first_name_loc_lang_prompt"));
	String second_name_loc_lang_prompt    =checkForNull((String)hash_Map.get("second_name_loc_lang_prompt"));
	String third_name_loc_lang_prompt       =checkForNull((String)hash_Map.get("third_name_loc_lang_prompt"));
	String name_prefix_loc_lang_prompt      =checkForNull((String)hash_Map.get("name_prefix_loc_lang_prompt"));
	
	String names_in_oth_lang_yn					= checkForNull((String)hash_Map.get("names_in_oth_lang_yn"),"N");
if(CalledFromFunction.equals("ChangePatDtls")) 
	{
		hash_Map1 = eMP.ChangePatientDetails.getPatientData(patient_id, conn,p);
	}
   String temp		= "";
   emptyCnt	= 0;  /*To Count the Missing Name Fields as per MP Param*/
   if(names_in_oth_lang_yn.equals("Y")) 
   {
	   if(!language_direction.equals("R"))
	   {
	   %>
		<tr>
			<%
/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
		if (pat_name_as_multipart_yn.equals("Y") )
		{
			 String order = "";
			 /*Prompts and Names to be painted in Reverse Order for Local Lang*/
			 for(int i=1;i<=4;++i)
			 {
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 if (order.equals("First_Name_Order"))
				 {
					 if (First_Name_Accept_Yn.equals("Y")) 
					 { 
						%>
						<td  class='LABELLEFT'><%=first_name_loc_lang_prompt%>&nbsp;<%
						if ( (First_Name_Reqd_Yn.equals("Y") ) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='first_oth_name_reqd_yn' id='first_oth_name_reqd_yn' value='Y'></input><img	id='first_oth' src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='first_oth_name_reqd_yn' id='first_oth_name_reqd_yn' value='N'><img	id='first_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}
						temp = ((first_name_loc_lang_prompt).equals("&nbsp;"))? First_Name_Prompt:first_name_loc_lang_prompt; %>
						
						<input type='hidden' name='first_name_oth_prompt' id='first_name_oth_prompt' value="<%=temp%>">
						</td><td class='LABELLEFT' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Second_Name_Order"))
				 {
					  if(Second_Name_Accept_Yn.equals("Y")) 
					  {
						%>
						<td   class='LABELLEFT'><%=second_name_loc_lang_prompt%>
						<%
						if ((Second_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{
							%>
							<input type='hidden' name='second_oth_name_reqd_yn' id='second_oth_name_reqd_yn' value='Y'></input><img id="sec_oth" src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{ 
							%>
							<input type='hidden' name='second_oth_name_reqd_yn' id='second_oth_name_reqd_yn' value='N'><img	id='sec_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}
						temp = ((second_name_loc_lang_prompt).equals("&nbsp;")) ? Second_Name_Prompt:second_name_loc_lang_prompt; 
						%>
						<input type='hidden' name='second_name_oth_prompt' id='second_name_oth_prompt' value="<%=temp%>"> 
						</td><td class='LABELLEFT' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Third_Name_Order"))
				 {
					  if(Third_Name_Accept_Yn.equals("Y")) 
					  { 
						%>
						<td   class='LABELLEFT'><%=third_name_loc_lang_prompt%>
						<% 
						if ((Third_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='third_oth_name_reqd_yn' id='third_oth_name_reqd_yn' value='Y'></input><img id='third_oth' src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='third_oth_name_reqd_yn' id='third_oth_name_reqd_yn' value='N'><img	id='third_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}
						temp = ((third_name_loc_lang_prompt).equals("&nbsp;")) ? Third_Name_Prompt:third_name_loc_lang_prompt; %>
						<input type='hidden' name='third_name_oth_prompt' id='third_name_oth_prompt' value="<%=temp%>">
						</td><td class='LABELLEFT' >&nbsp;</td> 
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y") ) 
					{
						%>
						<td  class='LABELLEFT' ><%=family_name_loc_lang_prompt%>
						<%
						if ((Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif'  style='visibility:visible'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='N'><img	id='fam_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input>
							<%
						}
						temp = family_name_loc_lang_prompt.equals("&nbsp;") ? Family_Name_Prompt : family_name_loc_lang_prompt; %>
						<input type='hidden' name='family_name_oth_prompt' id='family_name_oth_prompt' value="<%=temp%>">
						</td><td class='LABELLEFT' >&nbsp;</td>            
						<%
					}
					else
					{
						emptyCnt++;
					}
			 }
			 else
			 {
				emptyCnt++;
			 }
  		  }
		}/* END of  if (pat_name_as_multipart_yn.equals("Y") )   */
		else
		{
		   if(Family_Name_Accept_Yn.equals("Y") ) 
			{
				%><td   class='LABELLEFT' ><%=family_name_loc_lang_prompt%>
				<%
				if ( (Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
					out.print("<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>");
				} else { %> <input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='N'><img	id='fam_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> <% }
						temp = family_name_loc_lang_prompt.equals("&nbsp;")? Family_Name_Prompt:family_name_loc_lang_prompt ; %>
						<input type='hidden' name='family_name_oth_prompt' id='family_name_oth_prompt' value="<%=temp%>"></td>
					<%
			}
		}	

	
		 /*To fill the blank spaces in the table with blank TDs*/
		 for(int j=1;j<=emptyCnt;++j)
			   {%><td class='v' colspan='2'>&nbsp;</td><%}
		%>
		</tr>
		<tr>
		<%  		    
		 if (pat_name_as_multipart_yn.equals("Y") )
		 {
			 String order = "";
			 int tabIndex = 20;
			 emptyCnt = 0;
			 for(int i=1;i<=4;++i)
			 {
				 tabIndex++; // To increase the tab order
				 //order = (String)Name_Order.get((new Integer(i)).toString());
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 
				 if (order.equals("First_Name_Order"))
				 {
					if(First_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='fields' width='25%' nowrap><input type='text' name='first_name_oth_lang' id='first_name_oth_lang' maxlength='"+first_name_length+"' size='"+first_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='"+tabIndex+"' ");

						
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_first_name_loc_lang.equals("")  )
						{
							if (!a_first_name_loc_lang.equals(""))
								out.print(" value=\""+a_first_name_loc_lang+"\">");
							else
							if(!(((String)hash_Map1.get("first_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("first_name_loc_lang") +"\">");
							else 
							 out.print(" value = \"\" >");
								
						} else out.print(" value = \"\" >");  
						%><input type='button' class='button' value='?' style='visibility:hidden' onclick="document.forms[0].first_name_oth_lang.focus();callSearch('first_name_oth_lang','first_name','Others')" name='bfo' id='bfo'>
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Second_Name_Order"))
				 {
					if(Second_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("	<td     class='fields' width='25%' nowrap><input type='text' name='second_name_oth_lang' id='second_name_oth_lang' maxlength='"+second_name_length+"' size='"+second_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='"+tabIndex+"' ");

						
						if( CalledFromFunction.equals("ChangePatDtls") || !a_second_name_loc_lang.equals("")  )
						{
							if (!a_second_name_loc_lang.equals(""))
								out.print(" value = \""+a_second_name_loc_lang+"\" >");   
							else
							if (!(((String)hash_Map1.get("second_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("second_name_loc_lang") +"\">");
							else 
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >");
						%><input type='button' class='button' style='visibility:hidden' value='?'onclick='callSearch(second_name_oth_lang,second_name,"Others")' name='bso' id='bso'> 
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Third_Name_Order"))
				 {
					if(Third_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='fields' width='25%' nowrap><input type='text' name='third_name_oth_lang' id='third_name_oth_lang' maxlength='"+third_name_length+"' size='"+third_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='"+tabIndex+"' ");

						if ( CalledFromFunction.equals("ChangePatDtls") || !a_third_name_loc_lang.equals("") )
						{
							if (!a_third_name_loc_lang.equals(""))
								out.print(" value = \""+a_third_name_loc_lang+"\" >");  
							else
							if(!(((String)hash_Map1.get("third_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("third_name_loc_lang")+"\">");
							else 
								out.print(" value = \"\" >");   
						} 
						else out.print(" value = \"\" >");
						%><input type='button' class='button' value='?' style='visibility:hidden' onclick='callSearch(third_name_oth_lang,third_name,"Others")' name='bto' id='bto'>
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y")) 
					{
						out.println("<td  class='fields' width='25%' nowrap><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='"+tabIndex+"'");

						
						if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name_loc_lang.equals("") )
						{
							if (!a_family_name_loc_lang.equals(""))
								out.print(" value = \""+a_family_name_loc_lang+"\" >");  
							else
							if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
							else
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >"); 
					%><input type='button' class='button' value='?' style='visibility:hidden' onclick='callSearch(family_name_oth_lang,family_name,"Others")' name='bfamo' id='bfamo'>
						</td><td class='label' >&nbsp;</td>
						<%
				  }
				  else
				  {
				 	emptyCnt++;
				  }
			  }
			  else
			  {
				 emptyCnt++;
			  }
			}
		 }
		 /* if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
			   if(Family_Name_Accept_Yn.equals("Y") ) 
			   {
				out.print("<td  class='fields' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='20' ");

					

				if ( CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix_loc_lang.equals("")  )
				{
					if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
					else out.print(" value = \"\" >");    
				} 
				else out.print(" value = \""+a_name_suffix_loc_lang+"\" >");    
				%>
				</td>
				<%
			} 
		}

		 /*To fill the blank spaces in the table with blank TDs*/
			 for(int j=1;j<=emptyCnt;++j)
			   {%><td class='label' colspan='2'>&nbsp;</td><%}
			%></tr>
		<%	
			if(CalledFromFunction.equals("PatientRegistration")) { %>
				<script>if (parent.frames[0].document.getElementById("patient_name_loc_lang")) parent.frames[0].document.getElementById("patient_name_loc_lang").style.visibility = 'visible';</script><% }
   }
   else if(language_direction.equals("R"))
		{

	   /*******Added for Arabic*********/

	   	   %>
		<tr>
			<%		   



			/*If Multi Part Name is acceptable; Based on the name order in MP Param paint the prompts for names*/
		if (pat_name_as_multipart_yn.equals("Y") )
		{
			 String order = "";
			 /*Prompts and Names to be painted in Reverse Order for Local Lang*/
			 //for(int i=1;i<=4;++i)
			 for(int i=4;i>0;--i)
			 {
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y") ) 
					{
						%>
						<td  class='arabic' >
						<%
						if ((Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif'  style='visibility:visible'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='N'><img	id='fam_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input>
							<%
						}
						%>
						<%=family_name_loc_lang_prompt%>
						<%

						temp = family_name_loc_lang_prompt.equals("&nbsp;") ? Family_Name_Prompt : family_name_loc_lang_prompt; %>
						<input type='hidden' name='family_name_oth_prompt' id='family_name_oth_prompt' value="<%=temp%>">
						</td><td class='LABELLEFT' >&nbsp;</td>            
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Third_Name_Order"))
				 {
					  if(Third_Name_Accept_Yn.equals("Y")) 
					  { 
						%>
						<td   class='arabic'>
						<% 
						if ((Third_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='third_oth_name_reqd_yn' id='third_oth_name_reqd_yn' value='Y'></input><img id='third_oth' src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='third_oth_name_reqd_yn' id='third_oth_name_reqd_yn' value='N'><img	id='third_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}

						%>
						<%=third_name_loc_lang_prompt%>
						<%

						temp = ((third_name_loc_lang_prompt).equals("&nbsp;")) ? Third_Name_Prompt:third_name_loc_lang_prompt; %>
						<input type='hidden' name='third_name_oth_prompt' id='third_name_oth_prompt' value="<%=temp%>">
						</td><td class='arabic' >&nbsp;</td> 
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Second_Name_Order"))
				 {
					  if(Second_Name_Accept_Yn.equals("Y")) 
					  {
						%>
						<td   class='arabic'>
						<%
						if ((Second_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{
							%>
							<input type='hidden' name='second_oth_name_reqd_yn' id='second_oth_name_reqd_yn' value='Y'></input><img id="sec_oth" src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{ 
							%>
							<input type='hidden' name='second_oth_name_reqd_yn' id='second_oth_name_reqd_yn' value='N'><img	id='sec_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}

						%>
						<%=second_name_loc_lang_prompt%>
						<%

						temp = ((second_name_loc_lang_prompt).equals("&nbsp;")) ? Second_Name_Prompt:second_name_loc_lang_prompt; 
						%>
						<input type='hidden' name='second_name_oth_prompt' id='second_name_oth_prompt' value="<%=temp%>"> 
						</td><td class='arabic' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else  if (order.equals("First_Name_Order"))
				 {
					 if (First_Name_Accept_Yn.equals("Y")) 
					 { 
						%>
						<td  class='arabic'>&nbsp;<%
						if ( (First_Name_Reqd_Yn.equals("Y") ) && pat_name_in_loc_lang_reqd_yn.equals("Y")) 
						{ 
							%>
							<input type='hidden' name='first_oth_name_reqd_yn' id='first_oth_name_reqd_yn' value='Y'></input><img	id='first_oth' src='../../eCommon/images/mandatory.gif'></img>
							<%
						}
						else
						{
							%>
							<input type='hidden' name='first_oth_name_reqd_yn' id='first_oth_name_reqd_yn' value='N'><img	id='first_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> 
							<%
						}

						%>
						<%=first_name_loc_lang_prompt%>
						<%
						temp = ((first_name_loc_lang_prompt).equals("&nbsp;"))? First_Name_Prompt:first_name_loc_lang_prompt; %>
						
						<input type='hidden' name='first_name_oth_prompt' id='first_name_oth_prompt' value="<%=temp%>">
						</td><td class='arabic' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else
			 {
				emptyCnt++;
			 }
  		  }
		}/* END of  if (pat_name_as_multipart_yn.equals("Y") )   */
		else
		{
		   if(Family_Name_Accept_Yn.equals("Y") ) 
			{
				%><td   class='arabic' >
				<%
				if ( (Family_Name_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
					{
					out.print("<input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='Y'></input><img id='fam_oth' src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>");
				} else { %> <input type='hidden' name='family_oth_name_reqd_yn' id='family_oth_name_reqd_yn' value='N'><img	id='fam_oth' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></input> <% }
			
				%>
				<%=family_name_loc_lang_prompt%>
				<%
						temp = family_name_loc_lang_prompt.equals("&nbsp;")? Family_Name_Prompt:family_name_loc_lang_prompt ; %>
						<input type='hidden' name='family_name_oth_prompt' id='family_name_oth_prompt' value="<%=temp%>"></td>
					<%
			}
		}

		 	if(Name_Prefix_Accept_Yn.equals("Y")) 
		{ 
			%>
			<td class='arabic'  ><img src='../../eCommon/images/mandatory.gif' id='name_prefix_oth' style='visibility:hidden;'></img>&nbsp;<%=name_prefix_loc_lang_prompt%>			  			
			<% 
			if( (Name_Prefix_Reqd_Yn.equals("Y")) && pat_name_in_loc_lang_reqd_yn.equals("Y"))
			{ 
				if(Name_Prefix_Reqd_Yn.equals("Y"))
				{
				%>
				 <script>					
					if(document.getElementById("name_prefix_oth"))					
						document.getElementById("name_prefix_oth").style.visibility='visible';
				 </script>
				<%
				}
				else
				{
				%>
					<script>					
					if ( (document.getElementById("name_prefix_oth")) && (document.forms[0].name_pfx_reqd_for_org_mem_yn.value=='Y')){ document.getElementById("name_prefix_oth").style.visibility='visible' }
					else
					{
						document.getElementById("name_prefix_oth").style.visibility='hidden' 
					}
					</script>
				<%
				}	
				%>
				<input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='Y'></input>
				<%
			}
			else
			{ 
				%> 
				 <input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='N'></input>
				 <script>					
					if (document.getElementById("name_prefix_oth")) 
					{
						document.getElementById("name_prefix_oth").style.visibility='hidden'
					}
				</script>
				<%
			}
			temp = ((name_prefix_loc_lang_prompt).equals("&nbsp;")) ? Name_Prefix_Prompt:name_prefix_loc_lang_prompt ;%>
			<input type='hidden' name='name_prefix_oth_prompt' id='name_prefix_oth_prompt' value="<%=temp%>">
			</td>
			<td class='arabic'>&nbsp;</td>
			<%
		}
		else
		{ 
			%><input type='hidden' name='name_prefix_oth_name_reqd_yn' id='name_prefix_oth_name_reqd_yn' value='N'></td> <% 
		}




	
		 /*To fill the blank spaces in the table with blank TDs*/
		 for(int j=1;j<=emptyCnt;++j)
		// for(int j=emptyCnt;j>0;--j)
			   {%><td class='v' colspan='2'>&nbsp;</td><%}
		%>
		</tr>
		<tr>
		<%

			if(Name_Suffix_Accept_Yn.equals("Y")) 
			{	 
				 if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					%>
					<td   class='arabic'><Select name='name_suffix_oth_lang' id='name_suffix_oth_lang' onchange='sel_suffix_gen(this);putLocalLangPatientName(this);' dir='RTL' tabIndex='24'>
					<%
				}
				else
				{ 
				  %>
				<td   class='arabic'><Select name='name_suffix_oth_lang' id='name_suffix_oth_lang' onchange='sel_suffix_gen(this);putLocalLangPatientName(this);' dir='RTL' tabIndex='24'>
				<%}
				if(Name_Suffix_Reqd_Yn.equals("N")) 
				{
					out.print("<Option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label" ,"common_labels")+"------</option>");
				} 
				array_List.clear();
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_suffix1",p);
				
				for(int i=0;i<array_List.size();i+=2) 
				{
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<Option value=\"" + (String)array_List.get(i) + "\" ");
						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_name_suffix_loc_lang.equals("") )
						{
							if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_suffix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_suffix_loc_lang) )
								out.print(" selected > ");
							else out.print(" > "); 
						}
						else out.print(" > "); 
						out.print((String)array_List.get(i)+"</option>");
					} 
				}
			
			%>
			</td>
			<td class='arabic'>&nbsp;</td>
			<%
			}
			else
			{	
			}

		if (pat_name_as_multipart_yn.equals("Y") )
		 {
			 String order = "";
			 int tabIndex = 20;
			 emptyCnt = 0;
			 //for(int i=1;i<=4;++i)
			for(int i=4;i>0;--i)
			 {
				 tabIndex++; // To increase the tab order
				 //order = (String)Name_Order.get((new Integer(i)).toString());
				 if (Name_Order.get((new Integer(i)).toString()) != null)
							 order = (String)Name_Order.get((new Integer(i)).toString());
						 else
							 order = ""; 

				 if (order.equals("Family_Name_Order"))
				 {
					if(Family_Name_Accept_Yn.equals("Y")) 
					{
						out.println("<td  class='arabic' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this)' tabIndex='23'");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if(CalledFromFunction.equals("ChangePatDtls") || !a_family_name_loc_lang.equals("") )
						{
							if (!a_family_name_loc_lang.equals(""))
								out.print(" value = \""+a_family_name_loc_lang+"\" >");  
							else
							if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
							else
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >"); 
					%><input type='button' class='button' value='?' style='<%=name_comp_visibility%>' onclick='callSearch(family_name_oth_lang,family_name,"Others")' name='bfamo'>
						</td><td class='label' >&nbsp;</td>
						<%
				  }
				  else
				  {
				 	emptyCnt++;
				  }
			  }
			  else 	if (order.equals("Third_Name_Order"))
				 {
					if(Third_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='arabic'><input type='text' name='third_name_oth_lang' id='third_name_oth_lang' maxlength='"+third_name_length+"' size='"+third_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this)' tabIndex='22' ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if ( CalledFromFunction.equals("ChangePatDtls") || !a_third_name_loc_lang.equals("") )
						{
							if (!a_third_name_loc_lang.equals(""))
								out.print(" value = \""+a_third_name_loc_lang+"\" >");  
							else
							if(!(((String)hash_Map1.get("third_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("third_name_loc_lang")+"\">");
							else 
								out.print(" value = \"\" >");   
						} 
						else out.print(" value = \"\" >");
						%><input type='button' class='button' value='?' style='<%=name_comp_visibility%>' onclick='callSearch(third_name_oth_lang,third_name,"Others")' name='bto'>
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else if (order.equals("Second_Name_Order"))
				 {
					if(Second_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("	<td     class='arabic'><input type='text' name='second_name_oth_lang' id='second_name_oth_lang' maxlength='"+second_name_length+"' size='"+second_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this)' tabIndex='21' ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if( CalledFromFunction.equals("ChangePatDtls") || !a_second_name_loc_lang.equals("")  )
						{
							if (!a_second_name_loc_lang.equals(""))
								out.print(" value = \""+a_second_name_loc_lang+"\" >");   
							else
							if (!(((String)hash_Map1.get("second_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("second_name_loc_lang") +"\">");
							else 
								out.print(" value = \"\" >");    
						}
						else out.print(" value = \"\" >");
						%><input type='button' class='button' style='<%=name_comp_visibility%>' value='?'onclick='callSearch(second_name_oth_lang,second_name,"Others")' name='bso'> 
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else  if (order.equals("First_Name_Order"))
				 {
					if(First_Name_Accept_Yn.equals("Y")) 
					{ 
						out.println("<td     class='arabic'><input type='text' name='first_name_oth_lang' id='first_name_oth_lang' maxlength='"+first_name_length+"' size='"+first_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this)' tabIndex='20' ");

						if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

						if ( CalledFromFunction.equals("ChangePatDtls")  || !a_first_name_loc_lang.equals("")  )
						{
							if (!a_first_name_loc_lang.equals(""))
								out.print(" value=\""+a_first_name_loc_lang+"\">");
							else
							if(!(((String)hash_Map1.get("first_name_loc_lang")).equals("")))
								out.print(" value=\""+(String)hash_Map1.get("first_name_loc_lang") +"\">");
							else 
							 out.print(" value = \"\" >");
								
						} else out.print(" value = \"\" >");  
						%><input type='button' class='button' value='?' style='<%=name_comp_visibility%>' onclick="callSearch(first_name_oth_lang,first_name,'Others')" name='bfo'>
						</td><td class='label' >&nbsp;</td>
						<%
					}
					else
					{
						emptyCnt++;
					}
				 }
				 else				
			  {
				 emptyCnt++;
			  }
			}
		 }
		 /* if (pat_name_as_multipart_yn.equals("Y") ) */
			else
			{
			   if(Family_Name_Accept_Yn.equals("Y") ) 
			   {
				out.print("<td  class='arabic' ><input type='text' name='family_name_oth_lang' id='family_name_oth_lang' maxlength='"+family_name_length+"' size='"+family_name_length+"' onblur='makeValidString(this);putLocalLangPatientName(this);' tabIndex='20' ");

					if(language_direction.equals("R"))
							{
							out.println( "dir='RTL' ");
							}

				if ( CalledFromFunction.equals("ChangePatDtls") || !a_name_suffix_loc_lang.equals("")  )
				{
					if(!(((String)hash_Map1.get("family_name_loc_lang")).equals("")))
						out.print(" value=\""+(String)hash_Map1.get("family_name_loc_lang")+"\">");
					else out.print(" value = \"\" >");    
				} 
				else out.print(" value = \""+a_name_suffix_loc_lang+"\" >");    
				%>
				</td>
				<%
			} 
		}
	
			if(Name_Prefix_Accept_Yn.equals("Y")) 
			{
				if(pat_name_as_multipart_yn.equals("N")) 
				{ 
					%>
					<td class='arabic'   ><Select name='name_prefix_oth_lang' id='name_prefix_oth_lang' onchange='sel_prefix_gen(this);putLocalLangPatientName(this);if (document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=="Y"){getPatCategory();}' dir='RTL' tabIndex='19' >
					<%
				}
				else
				{ 
					%>
					<td class='arabic'  ><Select name='name_prefix_oth_lang' id='name_prefix_oth_lang' onchange='sel_prefix_gen(this);putLocalLangPatientName(this);if ( document.forms[0].entitlement_by_pat_cat_yn && document.forms[0].entitlement_by_pat_cat_yn.value=="Y"){getPatCategory();}' dir='RTL'  tabIndex='19' > 
					<%
				} 
				//if(Name_Prefix_Reqd_Yn.equals("N")) 
				//{ 
					%>
					<Option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
					<%
				//} 									
				array_List.clear(); 
				array_List = eMP.ChangePatientDetails.getResultRows(conn,"mp_name_prefix1",p);
				for(int i=0;i<array_List.size();i+=2) 
				{ 
					if(!((String)array_List.get(i)).equals("")) 
					{
						out.print("<option  value=\""+(String)array_List.get(i)+"\"");
						if(CalledFromFunction.equals("ChangePatDtls")  || !a_name_prefix_loc_lang.equals("") ) {
						if ( ((String)array_List.get(i)).equals((String)hash_Map1.get("name_prefix_loc_lang")) ||
							((String)array_List.get(i)).equals(a_name_prefix_loc_lang) )
								out.print(" selected >" );
							else out.print(" > " );
						}
						else out.print(" > " );
						out.print((String)array_List.get(i)+"</option>");
						}
					} %></Select></td>	<!-- <td class='label'>&nbsp;</td> -->
			<%}
   		    
		 

	
		 /*To fill the blank spaces in the table with blank TDs*/
			 for(int j=1;j<=emptyCnt;++j)
			   {%><td class='label' colspan='2'>&nbsp;</td><%}
			%></tr>
		<%	
			if(CalledFromFunction.equals("PatientRegistration")) { %>
				<script>if (parent.frames[0].document.getElementById("patient_name_loc_lang")) parent.frames[0].document.getElementById("patient_name_loc_lang").style.visibility = 'visible';</script><% }

		}
		/*******end for Arabic*********/
		}
		%>
		<input type='hidden' name='language_direction' id='language_direction' value=<%=language_direction%>>
		<input type='hidden' name='pat_names_in_oth_lang_yn' id='pat_names_in_oth_lang_yn' value=<%=names_in_oth_lang_yn%>>
		<%

		
	}
	catch(Exception e)
	{
		System.out.println("Error in PatNamesComp.jsp file :"+e.toString()+"<br>") ;
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
	%>
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

