<!DOCTYPE html>
  <html>
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String action_type="R";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >
<form > 																								    
																									   
 <input type=hidden name="action_type" id="action_type" value="<%=action_type%>">

<% 
	Connection con = null;  
	 String argumentset="";
	

	String strBeanName = XHGatewayListControllerBean.strBeanName; 
	//	MessageManager mm=new MessageManager();
	Properties p;
	p = (Properties) session.getValue("jdbc");	
	//ArrayList ar=new ArrayList();

    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");
  
   
    try																				 
    {
       if(con==null) con = ConnectionManager.getConnection(request);
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of MsgForApplEventTypeJsp:"+exp.toString());
	     exp.printStackTrace(System.err);
      //   exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
   	 
try
    {
		request.setAttribute("action_attr","R");
        XHGatewayListControllerBean xhBean=XHGatewayListControllerBean.getBean(strBeanName,request,session);
        xhBean.action(request,con);
		String strData[][]= xhBean.getDatabaseData();
		//LinkedList list=XHGatewayListControllerBean.list;
		//ArrayList arli=XHGatewayListControllerBean.arr;	

    	// int j=0;
	  	 for(int i=0;i<strData.length;i++) 
		 {			

			 if(strData[i][3].equals("Y"))
			 {																	   
				argumentset=argumentset+strData[i][1]+",";	      
				/* if(XHGatewayListControllerBean.list.size()>0)
				 {
					 if(XHGatewayListControllerBean.list.contains(strData[i][1]))
					{
						 System.out.println(" coming "+strData[i][1]);
						
						XHGatewayListControllerBean.list.remove(strData[i][1]);
						 argumentset=argumentset+strData[i][1]+",";
					}
							  
				    //if(list.contains(strData[i][1]))
					// {

							///System.out.println(" coming "+strData[i][1]);	  
						//	argumentset=argumentset+strData[i][1]+",";
						    //list.remove(strData[i][1]+"");
				//	 }

				 
				 }
				 else
				 {
				   argumentset=argumentset+strData[i][1]+",";
				 }		*/
				
				// strTotalList[j]=argumentset;
     					 //  j++;
						// ar.add(argumentset);
			
			 }
			 	// if(strData[i][3].equals("Y"))
				// {
					/*( if(arli.size()>0)								   
					 {
						System.out.println(" strData[i][1] :"+strData[i][1]);
						  System.out.println(" checking :"+arli.contains(strData[i][1]));
						  if(arli.contains(strData[i][1]))
						 {
							  System.out.println(strData[i][1]);	  	    

							 arli.remove(strData[i][1]);
							 System.out.println(arli);
																     
						 }																	  
																		  
						//  arli.remove(strData[i][1]);
					 }*/

						/// if(arli.contains(strData[i][1]))
						// {
							  // arli.remove(strData[i][1]);
						
						// }
						
			//		 }
					// else
					// {															  
					//   argumentset=argumentset+strData[i][1]+",";
					// }

					 
		
				// }

				/*	 if(XHGatewayListControllerBean.list.size()>0)
					 {
						  

						 for(int k=0;k<XHGatewayListControllerBean.listlist.size();k++)
						 {
							 argumentset=argumentset+(String)XHGatewayListControllerBean.list.get(k)+",";
								   XHGatewayListControllerBean.list.remove(k);
						 }
					 }*/	
			 	
		  						 										   
		 }
	 
       argumentset=argumentset.substring(0,(argumentset.length()-1));
		
		}catch(Exception exception)
		{
			 System.out.println("Error in calling db realted statements in dopost method of dataelementcrossrefapplicationusageservlet :"+exception.toString());
		    exception.printStackTrace(System.err); 
		
		}finally{
			try
			{
		     
			   ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			   System.out.println("Eroor in closing dbconnection dopost method of dataelementcrossrefapplicationusageservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
			//if(con!=null) 
													 	  
		}          
     
      
	  %>
			<script>
				parent.frames[0].document.getElementById("search_optiontext").value='<%=argumentset%>';
			
			
			</script>																						 


	  </form>
	  </body>
	  </html>
 

