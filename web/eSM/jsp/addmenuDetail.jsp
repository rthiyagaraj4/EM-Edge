
 <%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	Connection con=null;
	Statement stmt = null;
	Statement stmtnew = null;
			try{
			request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
	stmt=con.createStatement();
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rset=null;
	String prev_menu=request.getParameter("menu");
	String Log_user= (String) session.getAttribute("login_user");
	if(prev_menu == null) prev_menu="";
	String responsibility_id= (String) session.getAttribute("responsibility_id");
	//String Role="";
	StringBuffer sqlMenu=new StringBuffer();
	String sql_module="";
	
	
	/*int Medadmin=0;

	String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";
	
	rset=stmt.executeQuery(sql);
	if (rset !=null){
		while (rset.next()){
					Medadmin=Integer.parseInt(rset.getString(1));
			}
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	}

	String sqlResp="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"'";
	
	stmt = con.createStatement();
	rset=stmt.executeQuery(sqlResp);
	if (rset !=null){
		while (rset.next()){
					Role=rset.getString(1);
					if(Role==null) Role="";
		}
	if(rset!=null) rset.close();
	}*/
//add condition(sys_defined_yn='N') in query by Senthil on 10-Oct-2011 for this incident[IN:027210] 
	//if (Role.equalsIgnoreCase("MEDADMIN"))
	sqlMenu.append("SELECT MENU_ID,MENU_NAME FROM sm_menu_hdr WHERE sys_defined_yn='N' AND (ADHOC_MENU_YN='N' OR TRUNC(SYSDATE) BETWEEN Nvl(ADHOC_MENU_EFF_FROM,TRUNC(SYSDATE)) AND NVL(ADHOC_MENU_EFF_TO ,TRUNC(SYSDATE)) AND sys_defined_yn='N')ORDER BY menu_name ");


/*else if (Medadmin==1)
{
	sqlMenu.append("Select menu_id,menu_name from sm_menu_hdr  where resp_group_id  in");
	sqlMenu.append("(Select resp_group_id   from sm_menu_admin  where ");
	sqlMenu.append(" menu_admin_id  ='"+Log_user+"' ) order by menu_name " );
}*/
%>
<html>
	<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eSM/js/menuDetail.js'></script>

		<script language="JavaScript">
			var index;
			var val;
			var txt;
			var oOption;
			var object;

			function showmodal()
			{
				if(document.getElementById('MainMenus').options.length==0 || document.getElementById("norows").value=='N')
				{
				}
				else
				{
				var menu_id=menu_detail_form.prev_menu.value;

				var url	= "../../eSM/jsp/menuPreviewFrames.jsp?menuid=" + menu_id ;
				var dialogHeight	= "400px" ;
				var dialogWidth	= "700px" ;
				var arguments	= "" ;
				var status = "no";
				var scroll = "yes";
				var dialogTop = "60";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
					
				var reportURL 	= window.showModalDialog( url, arguments, features ) ;

				}
			}

			function globalIndex(num) {
				
				menu_detail_form.MainMenus.selectedIndex= -1;
				if(num==1) menu_detail_form.Functions.selectedIndex= -1;
				
				else menu_detail_form.SubMenus.selectedIndex= -1;
				
				return true;
			}

			function Drag(obj)
			{
				
	
					var spc="";
					var obj1=menu_detail_form.SubMenus;
					var obj2=menu_detail_form.Functions;
					if(menu_detail_form.root_menu.value == 'N')
						spc+="              " ;
					if(obj1.selectedIndex != -1)
					{
						
							index=obj1.selectedIndex;
							val=obj1.options[index].value;
							txt=spc+obj1.options[index].text;
							obj1.selectedIndex=-1;

							if(containMenu(obj,val)==false)
							{
									oOption = document.createElement("OPTION");
									oOption.text=txt;
									val=menu_detail_form.Menu.value + "#" +	val;
									oOption.value=val;
									index=menu_detail_form.MainMenus.length;
									document.getElementById('MainMenus').add(oOption,index);
									var arr=val.split("#");
									var menu_id=arr[3];
									Pass2MsgFrm(2,menu_id,index);
							}
					}

					if(obj2.selectedIndex != -1)
					{
							index=obj2.selectedIndex;
							val=obj2.options[index].value;
							txt=spc+ obj2.options[index].text;
							obj2.selectedIndex=-1;
							index=menu_detail_form.MainMenus.selectedIndex;
							var menu_id=menu_detail_form.Menu.value;
							var obj=menu_detail_form.MainMenus;
							var len=obj.length;
							var newindex=obj.selectedIndex;

							if(containFunction(obj,val,newindex)==false)
							{
									if(len==1)
									{
											if(newindex==0 || newindex== -1)
											{
													var val1=obj.options[0].value;
													var arr=val1.split("#");
													if(arr[4]=="M") menu_id=arr[3];
													else menu_id=arr[0];
												
											}
									}
									else if(len==0)
									{
											menu_id=menu_detail_form.Menu.value;
									}
									else
									{
											if(newindex==-1)
											{
													var val1=obj.options[len-1].value;
													var arr=val1.split("#");
													if(arr[4]=="M") menu_id=arr[3];
													else menu_id=arr[0];
											}
											else if(newindex==0)
											{
													menu_id=menu_detail_form.Menu.value;
											}
											else
											{
													var val1=obj.options[newindex-1].value;
													var arr=val1.split("#");
													if(arr[4]=="M") menu_id=arr[3];
													else menu_id=arr[0];
											}
									}
									oOption = document.createElement("OPTION");
									oOption.text=txt;
									oOption.value=menu_id + "#" + val;
									
									document.getElementById('MainMenus').add(oOption,0);
							}
					}
					DelDummy();
					Enable_Disable_Buttons();
			}

			function Enable_Disable_Buttons()
			{
				    var mainobject=menu_detail_form.MainMenus.value;
					var main_menu = mainobject.substring(0,mainobject.indexOf("#"));
					var type = mainobject.charAt(mainobject.length-1);

					if(main_menu == "" || main_menu=="DUMMY")
					{
							if(parent.document.f_query_add_mod.document.getElementById('Up').disabled==true)
							{
				  				 	parent.document.f_query_add_mod.document.getElementById('Up').disabled=false;
									parent.document.f_query_add_mod.document.getElementById('Down').disabled=false;
									parent.document.f_query_add_mod.document.getElementById('Del').disabled=false;
							}
					}
					else if(main_menu == document.getElementById('Menu').value && type == "F")
					{
						if(parent.document.f_query_add_mod.document.getElementById('Up').disabled==true)
						{
								parent.document.f_query_add_mod.document.getElementById('Up').disabled=false;
								parent.document.f_query_add_mod.document.getElementById('Down').disabled=false;
								parent.document.f_query_add_mod.document.getElementById('Del').disabled=false;
						}
					}else if(main_menu == document.getElementById('Menu').value && type == "P")
					{
						if(parent.document.f_query_add_mod.document.getElementById('Up').disabled==true)
						{
								parent.document.f_query_add_mod.document.getElementById('Up').disabled=false;
								parent.document.f_query_add_mod.document.getElementById('Down').disabled=false;
								parent.document.f_query_add_mod.document.getElementById('Del').disabled=false;
						}
					}
					else if(main_menu == document.getElementById('Menu').value && type == "R")
					{
						if(parent.document.f_query_add_mod.document.getElementById('Up').disabled==true)
						{
								parent.document.f_query_add_mod.document.getElementById('Up').disabled=false;
								parent.document.f_query_add_mod.document.getElementById('Down').disabled=false;
								parent.document.f_query_add_mod.document.getElementById('Del').disabled=false;
						}
					}
					else if(type == "M")
					{
						if(parent.document.f_query_add_mod.document.getElementById('Up').disabled==true)
						{
								parent.document.f_query_add_mod.document.getElementById('Up').disabled=false;
								parent.document.f_query_add_mod.document.getElementById('Down').disabled=false;
								parent.document.f_query_add_mod.document.getElementById('Del').disabled=false;
						}
					}
					else
					{ 
						if(parent.document.f_query_add_mod.document.getElementById('Up').disabled==false)
						{      
								parent.document.f_query_add_mod.document.getElementById('Up').disabled=true;
								parent.document.f_query_add_mod.document.getElementById('Down').disabled=true;
								parent.document.f_query_add_mod.document.getElementById('Del').disabled=true;
						}
					}
			}

			function AddDummy() {
				oOption = document.createElement("OPTION");
				oOption.text=" ";
				oOption.value="DUMMY";
				document.getElementById('MainMenus').add(oOption);
			}

			function DelDummy() {

				var obj=menu_detail_form.MainMenus;
				if(obj.length > 0 ) {
					for(var i=0;i<obj.length;i++) {
						if(obj.options[i].value=="DUMMY") {
							obj.remove[i];
							break;
						}
					}
				}
			}

			function containFunction(obj,val,index) {
				var temp;
				var val1;
				var val2;
				var val3;
				if(obj.length!=0) {
					if(index == -1) {
						temp=obj.options[obj.length-1].value;
						var arr=temp.split("#");
						val1=arr[0] + "#"  + val;
					}
					else	if(index == 0) {
						temp=obj.options[0].value;
						var arr=temp.split("#");
						val1=arr[0] + "#"  + val;
					}
					else {
						temp=obj.options[index-1].value;
						var arr=temp.split("#");
						val1=arr[0] + "#"  + val;

					}

					for(var n=0;n<obj.length;n++) {
						var temp1=obj.options[n].value;
						var arr1=temp1.split("#");
						val3=arr1[0]+ "#"  + val;

						if(arr[0]==arr1[0] && val1==temp1) return true;
						else if(val3==temp1) return true;

					}
				}
				return false;
			}

			function containMenu(obj,val) {
				var val1=menu_detail_form.Menu.value + "#" +  val;
				for(var n=0;n<obj.length;n++) {
				var arr2=val1.split("#");
				val2=arr2[3];
				var arr3=(obj.options[n].value).split("#");
				val3=arr3[3];

					if(obj.options[n].value==val1) return true;
					else if (val2==val3) return true;
				}
				return false;
			}


			function moveoption(num)
			{
				    sel_ind =menu_detail_form.MainMenus.selectedIndex;
					if(num==1)
					{
						if(sel_ind !=0 && sel_ind !=-1)
                        {
							var obj=menu_detail_form.MainMenus;
					        index=obj.selectedIndex;
					        val=obj.options[index].value;
					        txt=obj.options[index].text;
					        var arr = val.split("#");

						var prev_ind = menu_detail_form.MainMenus.selectedIndex;
						var prev_val = document.menu_detail_form.MainMenus.options[prev_ind-1].value;
						var s_menu = prev_val.substring(0,prev_val.indexOf("#"));
						var cur_val = menu_detail_form.MainMenus.value;
					    var opt_type = cur_val.charAt(cur_val.length-1);
						var temp = "N";

						if( s_menu != document.getElementById('Menu').value &&  opt_type == "M" )
						   temp = "Y";

						if( s_menu == "DUMMY" &&  opt_type == "M")
						   temp = "N";

						if( s_menu == "DUMMY" &&  opt_type == "F")
						   temp = "Y";
						if( s_menu == "DUMMY" &&  opt_type == "P")
						   temp = "Y";

						if( s_menu == document.getElementById('Menu').value &&  opt_type == "F")
						   temp = "Y";
						if( s_menu == document.getElementById('Menu').value &&  opt_type == "R")
						   temp = "Y";   
						if( s_menu == document.getElementById('Menu').value &&  opt_type == "P")
						   temp = "Y";

						if(temp == "Y")
						{
							if(index > 0)
							{
								if((arr[4]=="F" )||(arr[4]=="R" ))
								{
										obj.remove(index);
										oOption = document.createElement("OPTION");
										oOption.text=txt;
										oOption.value=val;
										document.getElementById('MainMenus').add(oOption,index-1);
										obj.options[index-1].selected=true;
								}else if(arr[4]=="P" )
								{
										obj.remove(index);
										oOption = document.createElement("OPTION");
										oOption.text=txt;
										oOption.value=val;
										document.getElementById('MainMenus').add(oOption,index-1);
										obj.options[index-1].selected=true;
								}
								else
								{
										var endindex;
										if(index==obj.length-1) endindex=obj.length-1;
										else
										{
												for(var i=index+1;i<obj.length;i++)
												{
														val=obj.options[i].value;
														txt=obj.options[i].text;
														var arr1 = val.split("#");
														if(arr1[4] =="M")
														{
																endindex=i;
																break;
														}
														endindex=obj.length;
												}
										}
										var moveindex;
										for(var m=index-1;m>=0;m--)
										{
												val=obj.options[m].value;
												txt=obj.options[m].text;
												var arr2 = val.split("#");
												if(arr2[4] =="M")
												{
														moveindex=m;
														break;
												}
												moveindex=0;
										}
										var selectindex=moveindex;
										if(index==obj.length-1)
										{
												oOption = document.createElement("OPTION");
												oOption.text=obj.options[index].text;
												oOption.value=obj.options[index].value;
												obj.remove(index);
												document.getElementById('MainMenus').add(oOption,moveindex);
										}
										else
										{
												for(var n=index;n<endindex;n++)
												{
														oOption = document.createElement("OPTION");
														oOption.text=obj.options[n].text;
														oOption.value=obj.options[n].value;
														obj.remove(n);
														document.getElementById('MainMenus').add(oOption,moveindex);
														moveindex++;
												}
										}
										obj.options[selectindex].selected=true;
								}
							}
						}
					}
					}
					else
					{
							
						if(sel_ind != menu_detail_form.MainMenus.options.length-1 && sel_ind !=-1)
						{
							var obj=menu_detail_form.MainMenus;
					        index=obj.selectedIndex;
					        val=obj.options[index].value;
					        txt=obj.options[index].text;
							var arr = val.split("#");

						    var next_ind = menu_detail_form.MainMenus.selectedIndex;
						    var next_val = document.menu_detail_form.MainMenus.options[next_ind+1].value;
						    var temp_ind;

						if(next_val.charAt(next_val.length-1) != "M")
						{
							if(index < obj.length-1)
							{
								if((arr[4]=="F")||(arr[4]=="R"))
								{
										obj.remove(index);
										oOption = document.createElement("OPTION");
										oOption.text=txt;
										oOption.value=val;
										document.getElementById('MainMenus').add(oOption,index+1);
										obj.options[index+1].selected=true;
								} else if(arr[4]=="P")
								{
										obj.remove(index);
										oOption = document.createElement("OPTION");
										oOption.text=txt;
										oOption.value=val;
										document.getElementById('MainMenus').add(oOption,index+1);
										obj.options[index+1].selected=true;
								}
								else
								{
										var endindex;
										for(var i=index+1;i<obj.length;i++)
										{
												val=obj.options[i].value;
												txt=obj.options[i].text;
												var arr1 = val.split("#");
												if(arr1[4] =="M")
												{
														endindex=i;
														break;
												}
												endindex=obj.length;
										}

										var moveindex;
										if(endindex==obj.length-1)
										{
												for(var n=index;n<endindex;n++)
												{
														oOption = document.createElement("OPTION");
														oOption.text=obj.options[index].text;
														oOption.value=obj.options[index].value;
														obj.remove(index);
														document.getElementById('MainMenus').add(oOption,endindex+1);
												}
										}
										if(endindex < obj.length-1)
										{
												for(var m=endindex+1;m<obj.length;m++)
												{
														val=obj.options[m].value;
														txt=obj.options[m].text;
														var arr2 = val.split("#");
														if(arr2[4] =="M")
														{
																moveindex=m;
																break;
														}
														moveindex=obj.length;
												}
												var selectindex=moveindex;
												for(var n=index;n<endindex;n++)
												{
														oOption = document.createElement("OPTION");
														oOption.text=obj.options[index].text;
														oOption.value=obj.options[index].value;
														obj.remove(index);
														document.getElementById('MainMenus').add(oOption,moveindex-1);
												}
												obj.options[endindex].selected=true;

												var present_index = menu_detail_form.MainMenus.selectedIndex;

												for(i=present_index;i>0;--i)
												{
												     if(menu_detail_form.MainMenus.value.charAt(menu_detail_form.MainMenus.value.length-1) == "M")
												     {
												        	menu_detail_form.MainMenus(i+1).selected=true;
												        	break;
												 	 }
												 	 else
												 	 {        menu_detail_form.MainMenus(i).selected=true;   }
												}
										}
								}
							}
						}
					}
					
				}
			 
            }
			function Delete(ind) {
				if(parent.f_query_add_mod.document.menu_detail_form.MainMenus.selectedIndex !=-1)
				{
                obj = parent.f_query_add_mod.document.menu_detail_form.MainMenus;
                if(ind == '' || ind==null)
					index=obj.selectedIndex;
				else
					index = eval(ind);
				val=obj.options[index].value;
				txt=obj.options[index].text;
				
				var arr = val.split("#");

				if(arr[4]=="F" || arr[4]=="R" || arr[4]=="P")   {
					obj.remove(index);
				}
				else {
					
					var endindex;
					if(index==obj.length-1) obj.remove(index);
					else {
						
						for(var i=index+1;i<obj.length;i++) {
							val=obj.options[i].value;
							txt=obj.options[i].text;
							var arr1 = val.split("#");
                            if(arr1[4] =="M") {
								endindex=i;
								break;
							}
							endindex=obj.length;
						}
						if(obj.length==1) obj.remove(0);
						else {
					
							for(var n=index;n<endindex;n++) obj.remove(index);
						}
					}
				}
			
			}
			}

			function hidelist()
			{
				menu_detail_form.hiddenlist.style.visibility='hidden';

			}

			function hiddenlistassign()
			{
					var menu_func_chk=0;
					var mainobj=menu_detail_form.MainMenus;
					
					
					var hddnobj=menu_detail_form.hiddenlist;
					var len=hddnobj.length;
					for(var j=0;j<len;j++) hddnobj.remove(0);
					
					if(mainobj.length > 0)
					{
							var option_sequence=0;
							var srl_no=0;
							var menu_id=menu_detail_form.Menu.value;
							
							var tempmenu_id;
							var rootmenu_id=menu_id;
							var rootmax_no=0;
							var temp1;
							var assignmenu=menu_id;
							
							for(var i=0;i<mainobj.length;i++)
							{
									var temp=mainobj.options[i].value;
									
									var arr=temp.split("#");

									
									if(arr[4]=="M")
									{
										temp1=menu_id + "#" + arr[1] + "#" + arr[2] + "#" + arr[3] + "#" + arr[4] ;
										assignmenu=arr[3];
										
									}
									else if(arr[4]=="F")
									{
											temp1=assignmenu + "#" + arr[1] + "#" + arr[2] + "#" + arr[3] + "#" + arr[4];
											
									}
									else if(arr[4]=="R")
									{
											temp1=assignmenu + "#" + arr[1] + "#" + arr[2] + "#" + arr[3] + "#" + arr[4];
											
									}else if(arr[4]=="P")
									{
											temp1=assignmenu + "#" + arr[1] + "#" + arr[2] + "#" + arr[3] + "#" + arr[4];
											
									}
									else
										temp1="";
									
									mainobj.options[i].value=temp1;
									
							}
							
							var plen=mainobj.length
								
							for(var zz=0;zz<plen;zz++)
							{
									oOption = document.createElement("OPTION");
									oOption.text=mainobj.options[zz].text;
									var temp=mainobj.options[zz].value;
								
									var arr=temp.split("#");

									option_sequence++;
									srl_no++;
									if( tempmenu_id !=arr[0] )
									{
										
											if( rootmenu_id !=arr[0] )
											{
													option_sequence = 1;
													srl_no = 1;
													tempmenu_id=arr[0];
											}
									}

									if(rootmenu_id==arr[0])
									{
										
											rootmax_no++;
											option_sequence=rootmax_no;
											srl_no=rootmax_no;
									}

									if(arr[4]=="M")
									{
										  	menu_func_chk = 1;
										  	temp1=arr[0] + " # " + arr[1] + " # " + arr[2] + " # " + arr[3] + " # " + arr[4] + " # " + option_sequence + " # " + srl_no;
											oOption.value=temp1;
											document.getElementById('hiddenlist').add(oOption,zz);
											hddnobj.options[hddnobj.length-1].selected=true;
										}
									if(menu_func_chk == 0)
									{
											temp1=arr[0] + " # " + arr[1] + " # " + arr[2] + " # " + arr[3] + " # " + arr[4] + " # " + option_sequence + " # " + srl_no;
											oOption.value=temp1;
											document.getElementById('hiddenlist').add(oOption,zz);
											hddnobj.options[zz].selected=true;
									}
							}
					}
			
				if(document.getElementById('hiddenlist').value == '' || document.getElementById('hiddenlist').value == null){
					return false;
				}
				else
					return true;

			}


			function Pass2MsgFrm(num,menu_id,index)
			{   
			   
				if(parent.document.f_query_add_mod.document.getElementById('Menu').value=="")
				{
				//	parent.document.f_query_add_mod.document.forms[0].Preview.disabled=true;
				}
				else
				{
				//	parent.document.f_query_add_mod.document.forms[0].Preview.disabled=false;
				}
				var n=0;
				var i=0;
				var HTMLVal = new String();
				var m = document.getElementById('Menu').value;
				if(m != ""){
					parent.document.f_query_add_mod.document.getElementById('Module').disabled=false;
				}
				else{
						
						n=parent.document.f_query_add_mod.document.getElementById('MainMenus').options.length;
						for(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById('MainMenus').remove("MainMenus");
						n=parent.document.f_query_add_mod.document.getElementById('SubMenus').options.length;
						for(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById('SubMenus').remove("SubMenus");
						parent.document.f_query_add_mod.document.getElementById('Module').options[0].selected = true;	
						n=parent.document.f_query_add_mod.document.getElementById('Functions').options.length;
						for(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById('Functions').remove("Functions");
						parent.document.f_query_add_mod.documentElementById('Module').disabled=true;
				}
				if(m != ""){
				if(num==1 ) {


					val = parent.document.f_query_add_mod.document.getElementById('Menu').value ;
				    parent.document.f_query_add_mod.document.getElementById('prev_menu').value = val;

					if(parent.document.f_query_add_mod.document.getElementById('Up').disabled==true)
					{
						parent.document.f_query_add_mod.document.getElementById('Up').disabled=false;
						parent.document.f_query_add_mod.document.getElementById('Down').disabled=false;
						parent.document.f_query_add_mod.document.getElementById('Del').disabled=false;
					}
					n=parent.document.f_query_add_mod.document.getElementById('MainMenus').options.length;
					for(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById('MainMenus').remove("MainMenus");
					n=parent.document.f_query_add_mod.document.getElementById('SubMenus').options.length;
					for(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById('SubMenus').remove("SubMenus");
					num="seven";
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
					xmlStr ="<root><SEARCH Chksrc=\""+num+"\" Common_Text=\""+document.getElementById('Menu').value+"\"  /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GetValues.jsp",false)

					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)					
					eval(responseText);
								}
				
				if(num==2) {
					num="nine";
					
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
						
					xmlStr ="<root><SEARCH Chksrc=\""+num+"\" Index=\""+index+"\" Common_Text=\""+menu_id+"\"  /></root>"
					
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						
					xmlHttp.open("POST","GetValues.jsp",false)
					
					xmlHttp.send(xmlDoc)
						
					responseText=xmlHttp.responseText
						
					responseText = trimString(responseText)
						
						
					eval(responseText);
				}
				if(num==3) {
					n=parent.document.f_query_add_mod.document.getElementById('Functions').options.length;
					for(i=0;i<n;i++) parent.document.f_query_add_mod.document.getElementById('Functions').remove("Functions");
					num="eight";
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
					xmlStr ="<root><SEARCH Chksrc=\""+num+"\" menuID=\""+document.getElementById('Menu').value+"\" Common_Text=\""+document.getElementById('Module').value+"\"  /></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GetValues.jsp",false)

					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					eval(responseText);
				}
				}
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  OnMouseDown="CodeArrest()" onLoad="Focusing('Menu');hidelist()" onKeyDown = 'lockKey()'>
	<form name="menu_detail_form" id="menu_detail_form" action="../../servlet/eSM.menuDetailServlet" method="post" target="messageFrame">
	<center><br>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" align='center'>
		<tr>
			<td class="BORDER" width="100%">
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="10%" class="label"><fmt:message key="Common.menu.label" bundle="${common_labels}"/></td>
						<td class='fields' width="25%"><Select name="Menu" id="Menu" onChange="Pass2MsgFrm(1,'test',0)"><Option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
						<%
							try {
							   
								rs=stmt.executeQuery(sqlMenu.toString());
								if(rs!=null) {
									while(rs.next()) {
										String menu_id=rs.getString("menu_id")==null ? "" : rs.getString("menu_id");
										String menu_name=rs.getString("menu_name")==null ? "" : rs.getString("menu_name");
					//modified below line by Senthil on 10-Oct-2011 for this incident[IN:027210] 					
					out.println("<Option value='" + menu_id + "'>" + menu_name+" ["+menu_id+"]");
									}
								}
								if(rs!=null) rs.close();
								//if(stmt!=null) stmt.close();
							}catch(Exception e) {}
						%>
						</Select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
						 <td class='fields' width="35%"><input type="hidden" name="function" id="function" value="insert"><Select name="hiddenlist" id="hiddenlist" size="1" multiple='true'></Select>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td class="BORDER" width="100%">
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<th  width="25%" ><fmt:message key="eSM.ListofSubmenus.label" bundle="${sm_labels}"/></th>
						<th align="left" width="25%" colspan="1"><fmt:message key="Common.menu.label" bundle="${common_labels}"/></th>
					</tr>
					<tr>
						<td class='fields' width="25%">&nbsp;&nbsp;&nbsp;&nbsp;<Select name="SubMenus" id="SubMenus" size="5" style="HEIGHT: 160px; WIDTH: 320px" onClick="globalIndex(1)"></Select></td>
						<td class='fields' width="60%" rowspan="5" valign="top"><Select name="MainMenus" id="MainMenus" size="15" style="HEIGHT: 360px; WIDTH: 280px" onClick="Drag(this)"></Select></td>
						<td width="5%" class="fields" valign="bottom"><input type='button' name='Up' id='Up' class="Button" onclick="moveoption(1)" value=' <fmt:message key="Common.Up.label" bundle="${common_labels}"/>      '> </td>
					</tr>
					<tr>
						<td width="25%" class="fields" ><span class='label' width="25%">&nbsp;&nbsp;<fmt:message key="Common.Module.label" bundle="${common_labels}"/></span>&nbsp;&nbsp;<Select name="Module" id="Module" onChange="Pass2MsgFrm(3,'test',0)" disabled><Option value="">------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------
						<%
							try {
									String resp_group_id="";
								//	if (Role.equalsIgnoreCase("MEDADMIN")) // sys admin
										sql_module="Select  a.module_id,a.module_name from sm_module a  where a.install_yn='Y'  order by a.module_name";

								/*	else if (Medadmin==1)	// menu admin
									{
										 stmtnew=con.createStatement();
										String sql_new=" Select resp_group_id from sm_menu_admin where menu_admin_id='"+Log_user+"' "; 
										ResultSet rsnew=stmtnew.executeQuery(sql_new);
										if(rsnew!=null)
										{
											while(rsnew.next())
											{
												resp_group_id=rsnew.getString("resp_group_id");
												if(resp_group_id==null) resp_group_id="";
											}
										}
										if (rsnew!=null) rsnew.close();
										sql_module=" Select distinct a.module_id,a.module_name from sm_module a, sm_func_by_resp_grp b where a.install_yn='Y' and a.module_id=b.module_id and		b.resp_group_id = '"+resp_group_id+"' order by a.module_name";
									}*/
									 //System.out.println("sql_moduolle--->"+sql_module);//sel
								rs1=stmt.executeQuery(sql_module);
								if(rs1!=null) {
									while(rs1.next()) {
										String module_id=rs1.getString("module_id")==null ? "" : rs1.getString("module_id");
										String module_name=rs1.getString("module_name")==null ? "" : rs1.getString("module_name");
								
						out.println("<Option value='" + module_id + "'>" + module_name);
									}
								}
								//if(rs !=null) rs.close();
								if(rs1 !=null) rs1.close();
								if(stmt !=null) stmt.close();
								if(stmtnew !=null) stmtnew.close();

							}catch(Exception e) {}
							%>
						</Select></td>
						<td class="fields" width="5%"> <input type='button' name='Down' id='Down' class="Button" onclick="moveoption(2)" value='<fmt:message key="eSM.down.label" bundle="${sm_labels}"/>   ' > </td>
					</tr>
					<tr>
						<th  >&nbsp;&nbsp;<fmt:message key="eSM.ListofFunctions.label" bundle="${sm_labels}"/></th>
						<td class="fields" width="5%"> <input type='button' name='Del' id='Del' class="Button" onclick="Delete()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>'> </td>
					</tr>
					<tr>
						<td width="60%" class='fields' valign="bottom">&nbsp;<Select name="Functions" id="Functions" size="5" style="HEIGHT: 160px; WIDTH: 267px"  onClick="globalIndex(2);"></Select></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
				</table>
			</td>
		</tr>
	</table>
	<input type="hidden" name="prev_menu" id="prev_menu" value ='<%=prev_menu%>' >
	<input type="hidden" name="root_menu" id="root_menu" value ='' >
	<input type="hidden" name="norows" id="norows" value ='Y' >
	</center>
	</form>
	</body>
<%
	}catch(Exception e){//out.println(e);
		e.printStackTrace();
	}
	finally { 
		
		ConnectionManager.returnConnection(con,request);
}
%>
</html>

