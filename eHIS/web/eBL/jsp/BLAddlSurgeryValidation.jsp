<!DOCTYPE html>
<%@ page   import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>



<%	
	request.setCharacterEncoding("UTF-8");	
	Connection con = null;
	PreparedStatement pstmt = null ;	
	//Statement stmt = null; 
	ResultSet rst1=null,rst2=null;	
	CallableStatement call = null;
	String currdate="",add_blng_serv_code="",addl_serv_code="",order_cat_code="",str_add_blng_serv_code="",ord_catlog_count="",ord_i="",checked_val="";
	int tot_blng_class_code=0;
	String blng_class_code="",error_level="",sys_message_id="",error_text="",blng_class_code_orig="";
	//ArrayList a_dep_serv_code	= new ArrayList();
%>	

<%
		try{
			con	=	ConnectionManager.getConnection(request);	
//			HttpSession httpSession = request.getSession(false);
//			Properties p = (Properties)httpSession.getValue("jdbc");
			String locale = (String)session.getAttribute("LOCALE");			
			if(locale==null || locale.equals("")) locale="en";		
			String str_facility_id = (String) session.getValue("facility_id");
			if (str_facility_id==null) str_facility_id = "";

			String	strloggeduser	=  (String) session.getValue("login_user");	
			if (strloggeduser==null) strloggeduser = "";

//			System.out.println("in validation");

			String p_patient_id = request.getParameter("p_patient_id");	
			if(p_patient_id==null) p_patient_id="";	
//			System.out.println("p_patient_id " +p_patient_id);

			
			String episode_type = request.getParameter("episode_type");	
			if(episode_type==null) episode_type="";	
		
			String episode_id = request.getParameter("episode_id");	
			if(episode_id==null) episode_id="";	

			String visit_id = request.getParameter("visit_id");	
			if(visit_id==null) visit_id="";	
		

			addl_serv_code = request.getParameter("blng_serv_code");	
			if(addl_serv_code==null) addl_serv_code="";					
			//System.out.println("validation blng_serv_code" +addl_serv_code);

			order_cat_code = request.getParameter("order_cat_code");	
			if(order_cat_code==null) order_cat_code="";					
			//System.out.println("validation order_cat_code" +order_cat_code);

			ord_catlog_count = request.getParameter("ord_catlog_count");	
			if(ord_catlog_count==null) ord_catlog_count="";					
			//System.out.println("validation ord_catlog_count" +ord_catlog_count);

			ord_i = request.getParameter("ord_i");	
			if(ord_i==null) ord_i="";					
			//System.out.println("validation ord_i" +ord_i);

			checked_val = request.getParameter("checked_val");	
			if(checked_val==null) checked_val="";					
			//System.out.println("validation checked_val" +checked_val);
			String query_dep_serv="";

			try{		
				String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
				pstmt=con.prepareStatement(query_date);
				rst2 = pstmt.executeQuery();
				if (rst2!=null)
				{
				   if (rst2.next())
				   {
						 currdate = rst2.getString(1);
				   }
				}

				if (rst2 != null)   rst2.close();
				if (pstmt != null)   pstmt.close();
				

			}catch(Exception e)
			{
				System.out.println("error in date");
			}

			try{
				String sqlblngclass="{ call BLCOMMON.GET_BLNG_CLASS_CODE('"+str_facility_id+"','"+episode_type+"','"+episode_id+"','"+p_patient_id+"','',to_date('"+currdate+"','dd/mm/yyyy HH24:MI:SS'),?,?,?,?)}";

//				System.out.println("sqlblngclass @@@:"+sqlblngclass);
				call = con.prepareCall(sqlblngclass);
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.registerOutParameter(2,java.sql.Types.VARCHAR);
				call.registerOutParameter(3,java.sql.Types.VARCHAR);
				call.registerOutParameter(4,java.sql.Types.VARCHAR);
				call.execute();
				blng_class_code = call.getString(1);
				 if(blng_class_code==null) blng_class_code="";	
				error_level = call.getString(2);
				 if(error_level==null) error_level="";	
				sys_message_id = call.getString(3);
				 if(sys_message_id==null) sys_message_id="";	
				error_text = call.getString(4);
				 if(error_text==null) error_text="";	
				 call.close();
//				System.out.println("get blng class code " +blng_class_code);
//				System.out.println("get blng class error_level " +error_level);
//				System.out.println("get blng class sys_message_id " +sys_message_id);
//				System.out.println("get blng class error_text " +error_text);

			}catch(Exception rr)
			{
			  System.out.println("get blng class code " +rr);
			}

			try{		
				String query_code="SELECT Count(*)  FROM BL_OT_ADDL_SERV_DTL A, BL_OT_ADDL_SERV_HDR B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE	AND A.OPERATING_FACILITY_ID ='"+str_facility_id+"'	AND A.ORDER_CATALOG_CODE = '"+order_cat_code+"'	AND A.BLNG_CLASS_CODE = '"+blng_class_code+"'";	
				pstmt=con.prepareStatement(query_code);
				rst1 = pstmt.executeQuery();
				if (rst1!=null)
				{
				   if (rst1.next())
				   {
						 tot_blng_class_code = rst1.getInt(1);
				   }
				}
//					System.out.println("get blng class tot_blng_class_code " +tot_blng_class_code);

				if (rst1 != null)   rst1.close();
				if (pstmt != null)   pstmt.close();
				

			}catch(Exception e)
			{
				System.out.println("error in date");
			}
			if(tot_blng_class_code==0)
			{
				blng_class_code_orig = "**";
			}
			else{
				blng_class_code_orig = blng_class_code;
			}

			try{
				
				
				if(checked_val.equals("Y"))
				{
					query_dep_serv="select add_blng_serv_code from(select  ROWNUM RN,add_blng_serv_code from (select level, order_catalog_code, add_blng_serv_code,dep_blng_serv_code,CHARGE_IND, CHARGE_PERC	from BL_OT_ADDL_SERV_DTL where operating_facility_id = '"+str_facility_id+"'	and order_catalog_code = '"+order_cat_code+"' and blng_class_code = '"+blng_class_code_orig+"') connect by prior dep_blng_serv_code = add_blng_serv_code start with 	add_blng_serv_code = '"+addl_serv_code+"') where  RN>1";
				}
				else{
					

//						System.out.println("validation 2");
					query_dep_serv="select add_blng_serv_code from(select  ROWNUM RN,add_blng_serv_code from (select level, order_catalog_code, add_blng_serv_code,dep_blng_serv_code,CHARGE_IND, CHARGE_PERC	from BL_OT_ADDL_SERV_DTL where operating_facility_id = '"+str_facility_id+"'	and order_catalog_code = '"+order_cat_code+"' and blng_class_code = '"+blng_class_code_orig+"') connect by prior add_blng_serv_code = dep_blng_serv_code start with 	add_blng_serv_code = '"+addl_serv_code+"') where  RN>1";
				}
				
//						System.out.println("query_dep_serv @@@:"+query_dep_serv);
					PreparedStatement pst3=con.prepareStatement(query_dep_serv);
					ResultSet rst3 = pst3.executeQuery();
					if (rst3!=null)
					{

					   while (rst3.next())
					   {
							 add_blng_serv_code = rst3.getString(1);
						 	//a_dep_serv_code.add(add_blng_serv_code);
							str_add_blng_serv_code=str_add_blng_serv_code+add_blng_serv_code+"|";
					   }
					  // str_add_blng_serv_code=str_add_blng_serv_code+add_blng_serv_code+"|";
					   
					}
					
										
			

					if (rst3 != null)   rst3.close();
					if (pst3 != null)   pst3.close();
				
		
//					System.out.println("validation str_add_blng_serv_code" +str_add_blng_serv_code);

		}catch(Exception e)
				{
					System.out.println("error in qry" +e);
				}


%>
<html>
	<head>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
<%
//	if(checked_val.equals("Y"))
//	{
%>
<!--	<body onLoad='chk1()'>-->
<%
	//}
//else{
%>		
		<body onLoad='chk()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
//	}
%>
		<form>	

		<input type="hidden" name="str_add_blng_serv_code" id="str_add_blng_serv_code" value="<%=str_add_blng_serv_code%>"> 
		<input type="hidden" name="order_cat_code" id="order_cat_code" value="<%=order_cat_code%>"> 
		<input type="hidden" name="ord_catlog_count" id="ord_catlog_count" value="<%=ord_catlog_count%>"> 
		<input type="hidden" name="cat_i" id="cat_i" value="<%=ord_i%>"> 
		<input type="hidden" name="checked_val" id="checked_val" value="<%=checked_val%>"> 
			<%


			}catch(Exception ee)
			{
			  System.out.println("Error in edit Adhoc disc " +ee);
			}
			finally 
			{
				if(con!=null)
				{
					ConnectionManager.returnConnection(con, request);
				}
			}

		%>

		<script>
				function chk()
				{
					
					var a_str_add_srv = new Array();
					var str_add_srv=document.forms[0].str_add_blng_serv_code.value;
				//	alert(str_add_srv);
					a_str_add_srv=str_add_srv.split("|");
					var ord_catlog_count = document.forms[0].ord_catlog_count.value;
					var cat_i = document.forms[0].cat_i.value;
					var checked_val = document.forms[0].checked_val.value;
				//	alert("checked_val :"+checked_val);
					for(i=0;i<ord_catlog_count;i++)
					{
						if(i==cat_i)
						{
							var order_serv_cnt = eval("parent.frames[1].document.forms[0].order_serv_cnt_"+i);
				//			alert("order_serv_cnt :"+order_serv_cnt.value);
							var order_serv_cnt_tt = eval(order_serv_cnt.value)+1;
						for(j=0;j<order_serv_cnt_tt;j++)
						{
							serv_code=eval("parent.frames[1].document.forms[0].blng_serv_code_"+i+"_"+j);

						//	alert("22: "+serv_code.value);
							
							for(k=0;k<a_str_add_srv.length;k++)
							{
								
							//alert("22  11: "+serv_code.value);

								if(a_str_add_srv[k]==serv_code.value)
								{
									//alert("tr");
									var sel_val=eval("parent.frames[1].document.forms[0].selected_row_"+i+"_"+j);
									if(checked_val=="Y")
									{
										sel_val.checked=true;
										sel_val.value="Y";
									}else{
									sel_val.checked=false;
									sel_val.value="N";
									}
								}


							}
						}
						}
					}
				parent.frames[2].total_amt();				
				}
				

		</script>

		</form>
		</body>
		</html>

