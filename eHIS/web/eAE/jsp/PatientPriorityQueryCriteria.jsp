<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	 String sql              ="";
	String color             ="";
	String  green          ="";
	String red              ="";
    String yellow           ="";
    String unassigned       ="";	
	PreparedStatement pstmt	= null;
	ResultSet rset			= null;
	String locale		    = (String)session.getAttribute("LOCALE");
	/* CRF  SKR-CRF-0021 [IN028173] end  */
try
{  
 
con				= ConnectionManager.getConnection(request);
//Added By Shanmukh for MMS-DM-CRF-0147
Boolean isPriorityZoneAppl			= false;
isPriorityZoneAppl			=	CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");
String patPriorityCode    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.PatientPriorityCode.label","ae_labels");
String patPriorityDesc    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.PatientPriority.label","ae_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
//below lines modified By Shanmukh for MMS-DM-CRF-0147	
	 try
	{  
	  sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			     pstmt    = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 
				   color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")){red=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")){yellow=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")){unassigned=rset.getString("PRIORITY_ZONE_DESC");}
				}
		    
				if(pstmt!=null){
					pstmt.close();
				}
				
				if(rset!=null){
					rset.close();
				}
				
				
				
	}catch(Exception e)
	{
	e.printStackTrace();
	}




ArrayList finAr 	= new ArrayList();
ArrayList firstItem = new ArrayList();
firstItem.add("Text");  		//Type of item
firstItem.add(patPriorityCode);		//label
firstItem.add("priority_code");		//name of field
firstItem.add("2");				// SIZE
firstItem.add("2");			    //LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem	= new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(patPriorityDesc);  // label
secondItem.add("long_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem	 = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PriorityZone.label","common_labels"));  // label
thirdItem.add("priority_no");//name

/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
/*thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",2,"+green+",1,"+red+",3,"+yellow+",4,"+unassigned);
/* CRF  SKR-CRF-0021 [IN028173] end  */
/*below line added By Shanmukh for MMS-DM-CRF-0147*/
thirdItem.add("SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and EFF_STATUS='E'  and priority_zone not in ('B','W') order by PRIORITY_ZONE_ORDER ");
finAr.add(thirdItem); //add to ArrayList obj finAr

/*thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",2,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Green.label","common_labels")+",1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Red.label","common_labels")+",3,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Yellow.label","common_labels")+",4,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(thirdItem); */

ArrayList fourthItem	 = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fourthItem.add("eff_status");//name
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr

String orderByCols[] 	= new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] 		 = patPriorityCode;
orderByCols[1]		 = patPriorityDesc;

orderByColVals[0] 	 = "priority_code";
orderByColVals[1] 	 = "long_desc";

//below line Modified by Shanmukh for MMS-DM-CRF-0147
strbuff 		 = qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eAE/jsp/PatientPriorityQueryResult.jsp?green="+green+"&red="+red+"&yellow="+yellow+"&unassigned="+unassigned+"&isPriorityZoneAppl="+isPriorityZoneAppl+" ",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(fourthItem!=null)fourthItem.clear();

}catch (Exception e)  {e.printStackTrace();}
finally
	{
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
	}
%> 
