<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String facility_id=(String) session.getValue("facility_id");
%>

<html>
	<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
			// added by Sridhar Reddy @ 01-12-08 
			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }
		 //end
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
	   <!--  <script src="../../eCA/js/LocationforPract.js" language="javascript"></script>  -->
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script language="JavaScript" src ="../../eCA/js/LocationForPractitioner.js"></script>
		<script language='javascript'>
			function clearValFrame(){
				parent.frames[1].location.href="../../eCommon/html/blank.html";	
				parent.frames[0].document.forms[0].pract_id.value='';
				parent.frames[0].document.forms[0].pract_name.value='';
			}
			async function searchPract(obj)
			{
			if(obj.value!="")
				{

				var search_text = obj.value;
				target = document.forms[0].pract_id;	
				var speciality = document.forms[0].speciality.value;
				var prime_spl_code = document.forms[0].prime_spl_code.value;
				//var fields = new Array (document.forms[0].speciality);	
				//var names = new Array ( "Primary Speciality");
				//var names = new Array (getLabel('Common.primaryspeciality.label','Common'));
				//if(checkFieldsofMst( fields, names, parent.parent.messageFrame) )
				//{
					var p_facility_id="`"+'<%=facility_id%>'+"`";
					var retVal = 	new String();
					var dialogHeight= "28" ;
					var dialogWidth	= "43" ;
					var status = "no";
					var arguments	= "" ;
					var sql="";
					var search_code="";
					var search_desc="";
					var tit="";
					var  fac_id=''
					tit=getLabel("Common.practitioner.label","common");
					sql=" select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id ="+p_facility_id ;		
					search_code="practitioner_id";
					search_desc= "practitioner_name";
					
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

					retVal = await window.showModalDialog("LocationforPractSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit,"UTF-8")+"&splty_code="+prime_spl_code+"&search_text="+search_text,arguments,features);
					if (!(retVal == null)){
						target.value=retVal;
						//document.forms[0].pract_name.focus();
						PopulateName(target);
					}
					else
					{
						document.forms[0].pract_name.value="";
						//document.forms[0].pract_name.focus();
					}	
				//}	
			  }
			}
			function makeVisibleInvisible(obj){
				
				for(i=0; i<document.qry_location.loc_pract.length; i++){
					if(document.qry_location.loc_pract[i].checked == true){
						if(obj.value=="practioner")
						{
							parent.frames[1].location.href="../../eCommon/html/blank.html";
							if(document.qry_location.loc_pract[i].value == 'practioner'){
								document.getElementById('prac').innerHTML= " <table width='100%' cellpadding='3' cellspacing=0 border=0 align ='center'><tr><td  width='48%' class='label'  ><fmt:message key='Common.practitioner.label' bundle='${common_labels}'/>&nbsp;&nbsp;</td><td class='fields' width='70.5%'><input type='text' name='pract_name' size=30   onblur='getPractitioners(this)';><input type='button' style='height:22' name='pract' id='pract' value='?'  class='button'  onclick='getPractitioners(this)'><img src='../../eCommon/images/mandatory.gif'></td></tr><tr><input type='hidden' name='pract_id' size=30 ></td></tr><tr><td><input type=hidden name=mode value=practioner><input type=hidden name='facility_id'  id='facility_id' value='<%=facility_id%>'></td></tr></table>"
								document.getElementById('speciality_id').style.display='inline';
								document.getElementById('speciality_id').style.visibility='visible';   
								document.getElementById('speciality_id').style.display='inline';
								document.getElementById('location_id').style.visibility='visible';
								document.getElementById('breakdiv').style.display='inline';
								document.getElementById('breakdiv1').style.display='none';
																
							}
						}
						else
						if(obj.value=="location")
						{
							parent.frames[1].location.href="../../eCommon/html/blank.html";	
							if(document.qry_location.loc_pract[i].value == 'location'){
								document.getElementById('prac').innerHTML= "<table width='100%' cellpadding='3' cellspacing=0 border=0 align=center><tr ><td colspan=4>&nbsp;</td></tr><tr> <td  class='label'  width='25%'><fmt:message key='Common.locationtype.label' bundle='${common_labels}'/></td><td class='fields'><select name='locn_type' onchange='PopulateLoc(this)'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---- ---- <fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/>---- ----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option><option value='Z'><fmt:message key='Common.AllLocations.label' bundle='${common_labels}'/></option><option value='Y'><fmt:message key='eCA.AllNursingUnits.label' bundle='${ca_labels}'/></option><option value='X'><fmt:message key='eCA.AllClinics.label' bundle='${ca_labels}'/></option><option value='C'><fmt:message key='eCA.Clinics.label' bundle='${ca_labels}'/></option><option value='W'><fmt:message key='eCA.NursingUnits.label' bundle='${ca_labels}'/></option><option value='P'><fmt:message key='eCA.ByPractitionerRights.label' bundle='${ca_labels}'/></option></select><img src='../../eCommon/images/mandatory.gif'></td><td  class='label'  width='25%'><fmt:message key='Common.Location.label' bundle='${common_labels}'/></td><td class='fields' width='25%'><input type='text' name='locn_code' value='' size='30' maxlength='40' OnBlur ='populateLocatn()' OnChange='resetValues();setValue();clearFrame()'><input type='button' class='button' name='buttonloctn' value='?' OnClick='resetValues();populateLocatn()'><img src='../../eCommon/images/mandatory.gif'></td></tr><tr><td>&nbsp;</td></tr><tr><td><input type=hidden name=mode value=location><input type='hidden' name='flag' value='true'><input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'><input type='hidden' name='locaSerch' value=locaSerch></td></tr></table>"
								
								document.getElementById('speciality_id').style.display='none';
								//document.all.speciality_id.style.visibility='hidden'; 
								document.getElementById('location_id').style.visibility='visible';   
								document.getElementById('breakdiv').style.visibility='visible';
								document.getElementById('breakdiv').style.display='none'; //none
								document.getElementById('breakdiv1').style.display='inline';
								
							}
						}
						document.getElementById('submt').innerHTML="<table width='100%' cellpadding='3' cellspacing=0 border=0  align=center><tr ><td colspan=4 WIDTH = '100%' ALIGN ='RIGHT'><input type=submit value=<fmt:message key="Common.search.label" bundle="${common_labels}"/> class='button' onClick='searchFrame();'>&nbsp;&nbsp;&nbsp;<input type=button value=<fmt:message key="Common.clear.label" bundle="${common_labels}"/> class='button' onClick='clearing();'></td></tr></table>"
					}
				}
			}
			function clearFrame(){
			
			parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";
			parent.frames[1].location.href="../../eCommon/html/blank.html";	
			}
			function searchFrame(){
			
			parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			if(document.forms[0].pract_name)
			{
			   if(document.qry_location.pract_name.value==null || document.qry_location.pract_name.value=="")
				{
					parent.frames[1].location.href="../../eCommon/html/blank.html";
				    document.forms[0].pract_name.value="";
				}
			}
			  if(document.forms[0].pract_id)
			 {
				if(document.qry_location.pract_name.value==null || document.qry_location.pract_name.value=="")	
				{
					parent.frames[1].location.href="../../eCommon/html/blank.html";
					document.forms[0].pract_id.value="";
				}
			}
		  }
			function clearing()
			{
				parent.frames[1].location.href="../../eCommon/html/blank.html";
				if(document.forms[0].speciality) document.forms[0].speciality.value="";
				if(document.forms[0].pract_id)	 document.forms[0].pract_id.value="";
				if(document.forms[0].pract_name)   document.forms[0].pract_name.value="";
				if(document.forms[0].locn_type)   document.forms[0].locn_type.value="";
				if(document.forms[0].locn_code)
				{
					delete_values(document.forms[0].locn_code);
				}
				if(document.forms[0].pract_name) document.forms[0].pract_name.value="";
			}
			async function searchCode(obj, target){
				target = document.forms[0].pract_id;	
				var speciality = document.forms[0].speciality.value;
				var prime_spl_code = document.forms[0].prime_spl_code.value;
				//var fields = new Array (document.forms[0].speciality);	
			//var names = new Array(getLabel('Common.primaryspeciality.label','Common'));
				//if(checkFieldsofMst( fields, names, parent.parent.messageFrame) )
				//{
					var p_facility_id="`"+'<%=facility_id%>'+"`";
					var retVal = 	new String();
					var dialogHeight= "32.25" ;
					var dialogWidth	= "43" ;
					var status = "no";
					var arguments	= "" ;
					var sql="";
					var search_code="";
					var search_desc="";
					var tit="";
					var  fac_id=''
					tit=getLabel("Common.practitioner.label","common");
					sql=" select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id ="+p_facility_id ;		
					search_code = "practitioner_id";
					search_desc = "practitioner_name";
					
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
					
					retVal =await  window.showModalDialog("LocationforPractSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit,"UTF-8")+"&splty_code="+prime_spl_code,arguments,features);
					if (!(retVal == null)){
						target.value=retVal;
						//document.forms[0].pract_name.focus();
						PopulateName(target);
					}
					else
					{
						document.forms[0].pract_name.focus();
					}	
				//}		
			}
			function PopulateName(obj){
				var practitioner_id=obj.value;
				if(obj.value.length>0){
					parent.parent.frames[2].location.href="GetNameofLocationforPract.jsp?practitioner_id="+practitioner_id.toUpperCase();
				}else{
					document.forms[0].practitioner_id.value="";
					document.getElementById('prac_name').value="";
					parent.frames[0].location.href="../../eCommon/html/blank.html";
					parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";
				}
			}

			
           function CheckForSpecialCharacter(ObjText)
             {
	             var key = window.event.keyCode
		         if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			     return false
		         return true
             }


          function resetValues()
           {
              parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
            }
          function setValue()
            {
	           document.forms[0].flag.value='false';
             }
			

			  
			function PopulateLoc(obj)
		     {
				var mode=document.forms[0].mode.value;
				var locn_type= obj.value;
				if( locn_type=="X" || locn_type=="Y" || locn_type=="Z"  || locn_type=="P" ) 
				{
					//delete_values1(document.forms[0].locn_code);
					if(locn_type=="X")
					{
						document.forms[0].locn_code.value =getLabel('eCA.AllClinics.label','CA');
						document.forms[0].locaSerch.value ="*ALLC";
						document.forms[0].buttonloctn.disabled=true;
						document.forms[0].locn_code.readOnly=true;		
					}
					if(locn_type=="Y")
					{   
						document.forms[0].locn_code.value    =getLabel('eCA.AllNursingUnits.label','CA');
						document.forms[0].locaSerch.value ="*ALLW";	
						document.forms[0].buttonloctn.disabled=true;
						document.forms[0].locn_code.readOnly=true;
					}
					if(locn_type=="Z")
					{
						document.forms[0].locn_code.value =getLabel('Common.AllLocations.label','COMMON');
						document.forms[0].locaSerch.value ="*ALLZ";
						document.forms[0].buttonloctn.disabled=true;
						document.forms[0].locn_code.readOnly=true;
					}
				if(locn_type=="P")
					{
						document.forms[0].locn_code.value =getLabel('eCA.ByPractitionerRights.label','CA');
						document.forms[0].locaSerch.value ="*ALLP";
						document.forms[0].locn_code.readOnly=true;
						document.forms[0].buttonloctn.disabled=true;
					}	

				}
				else
				{
					delete_values(document.forms[0].locn_type);
					document.forms[0].locn_code.readOnly=false;

					//delete_values(document.forms[0].locn_code);
				}


				//var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%></link></HEAD><BODY CLASS='MESSAGE' onMouseDown=CodeArrest() onKeyDown=lockKey()><form name='form1' method='post' action='PopulateLocationResult.jsp?locn_type="+locn_type+"'></form></BODY></HTML>";
				//parent.frames[2].document.write(HTMLVal);
				//parent.frames[2].document.forms[0].submit();
			 }
		function delete_values(field)
		{
			
			document.forms[0].locn_code.value="";
			document.forms[0].locaSerch.value="";
			document.forms[0].buttonloctn.disabled=false;
			
			
		/*	var selected = field;
			while ( selected.options.length > 0 )
						selected.remove(selected.options[0]);
			var opt=parent.frames[2].document.createElement("Option");
			opt.text="        ---Select---       "
			opt.value="";
			field.add(opt); */
		}
		function delete_values1(field)
		{
		
	
		document.forms[0].locn_code.value=field.value;	
		document.forms[0].locaSerch.value=document.forms[0].locn_type.value;
		

		/*	var selected = field;
			while ( selected.options.length > 0 )
				selected.remove(selected.options[0]);*/
		}


		function checkMandatory(){
				if(document.qry_location.locn_type)
				{
					//alert("here1")
					var fields = new Array (document.qry_location.locn_type,document.qry_location.locn_code);	
					var names = new Array ( getLabel("Common.locationtype.label","Common"),getLabel("Common.locationcode.label","Common"));
					if(checkFieldsofMst( fields, names, parent.parent.messageFrame) )
					{
					}
					else
					{
					 return false;
					}
				}	
				else
				if(document.qry_location.pract_id)
				{
					//alert("here2")
					var fields = new Array (document.qry_location.pract_id);	
					var names = new Array (getLabel("Common.practitioner.label","Common"));
					if(checkFieldsofMst( fields, names, parent.parent.messageFrame) )
					{
					}
					else
					{
						return false;
					}
								
				}
			}


		/*function PopulateLoc(obj) {
				
				parent.frames[1].location.href="../../eCommon/html/blank.html";	
				var locn_type= obj.value;
				if( locn_type=="X" || locn_type=="Y" || locn_type=="Z"  || locn_type=="P" ) {
					delete_values(document.forms[0].locn_code);
				}else{
					delete_values(document.forms[0].locn_code);
				}
				var HTMLVal = "<HTML><HEAD></HEAD><BODY CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='PopulateLocationResult.jsp?locn_type="+locn_type+"'></form></BODY></HTML>";
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.forms[0].submit();
			}
			function delete_values(field){
				var selected = field;
				while ( selected.options.length > 0 )
						selected.remove(selected.options[0]);
				var opt=parent.frames[1].document.createElement("Option");
				opt.text="-----------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------";
				opt.value="";
				field.add(opt);
			}
			function delete_values1(field){
				var selected = field;
				while ( selected.options.length > 0 )
						selected.remove(selected.options[0]);
			}*/

		</script>
	</head>
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
		<form name='qry_location' id='qry_location' method='post' action='QueryResultLocationforPractResult.jsp' target=QueryResult onSubmit='return checkMandatory()'>
		<%
			Connection con  =  null;
		   try{
			  con=ConnectionManager.getConnection(request);
		%>



		<table width='100%' cellpadding='3' cellspacing=0 border=0 align=center id=tbl>
			<tr>
				<td align='left' ><b><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/></b>
						<input type=radio name=loc_pract value='practioner' onclick='makeVisibleInvisible(this)' > <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> <input type=radio name=loc_pract value='location' onclick='makeVisibleInvisible(this)'><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
				</td>
			</tr>
			
		</table>

		<table width='100%' cellpadding='3' cellspacing=0 border=0 align='center' id='speciality_id' >
		<div id=breakdiv>
			
			<br>
		</div>  
	 	<tr>
			<td  colspan=4>&nbsp;</td>
		</tr> 
		<tr>
			<td width='74%' class=label align="left"><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/></td>
			<td class='fields' width='36%' align="center">&nbsp;&nbsp;<input type="hidden" name="prime_spl_code" id="prime_spl_code" size="20" maxlength="20" value=""><input type="text" name="speciality" id="speciality" size='30' maxlength='20' onBlur='getPrimarySpacilityCode(this)' OnChange='resetValues();setValue();clearValFrame()'><input type="button" value="?" class="button" name='primeSearch' id='primeSearch' onClick='resetValues();getPrimarySpacilityCode(this)'></td>
		</tr>


			<!-- <td class='fields' width='25%'>&nbsp;&nbsp;
				<select name='speciality' id='speciality' onchange='clearValFrame()'>
					<option value=''>------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option> 
					<%
						PreparedStatement pstmt=null;
						ResultSet rs1=null;
						try
						{
						  String sqlSpec = "Select speciality_code, short_desc from am_speciality where eff_status ='E' order by 2";
						  pstmt = con.prepareStatement(sqlSpec);
						  rs1 = pstmt.executeQuery();
						  while(rs1!=null && rs1.next())
						  {
							out.println("<option value='"+rs1.getString(1)+"' >"+rs1.getString(2)+"</option>");
						   }
						}catch(Exception e)
						{
						   //out.println(e);//common-icn-0181
						   e.printStackTrace();//COMMON-ICN-0181
						}
						finally
						{
						   if(rs1!=null) rs1.close();	
						   if(pstmt!=null) pstmt.close();
						}
					%>
					</option>
				</select>
			</td> </tr>--> 	
			
		
		 <%} 
		catch(Exception e)
		{
		  //out.println(e.toString());//COMMON-ICN-0181
		  e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
		  ConnectionManager.returnConnection(con,request);
		}%>
		</table> 
	<!-- <td width ='25%'> -->	<table  cellpadding=0 cellspacing=0 border=0  id='location_id'>
			<div id=breakdiv1>
			
				<br>
			</div>
			<tr width='100%'>
				<td id='prac'  width='100%' ></td> <td>&nbsp;</td><!-- colspan='2' -->
			</tr>
			<tr>
				<td id='submt' ></td><!-- colspan='2' -->
			</tr>
		</table> 
		<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
		<script>
		   document.getElementById("speciality_id").style.visibility='hidden';
		   document.getElementById("location_id").style.visibility='hidden';
		</script>
		<input type='hidden' name='flag' id='flag' value='true'>
		</form>
	</body>
</html>

