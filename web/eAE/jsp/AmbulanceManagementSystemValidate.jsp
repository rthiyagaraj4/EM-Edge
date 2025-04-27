<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1"%>
<jsp:useBean id="XMLobj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="bean"   scope="page"  class="eAE.AmbulanceManagementSystemBean"/>

<%
Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
hash				  = (Hashtable)hash.get( "SEARCH" ) ;

String action		  = request.getParameter( "action" );
String facility_id	  =	(String)session.getValue("facility_id");
Connection con=null;

try{
 con = ConnectionManager.getConnection(request);

if(action==null) action="";

if(action.equals("LOADMAINTDET")){

	String ambID		=	(String)hash.get("ambId");
	String type			=	(String)hash.get("type");
	ArrayList	list	=	bean.getAmbulanceMaintDet(facility_id,ambID,con);
	if(list.size()>0){
	out.println("var list = new Array()");
	for(int i=0;i<list.size();i++){
		out.println("list["+i+"] = '"+list.get(i)+"'");
	}
	out.println("populateMaintDet(list,'"+type+"')");
	}
}else if(action.equals("LOADLOCNDET")){

	String caseno		=	(String)hash.get("ambId");
	String type			=	(String)hash.get("type");
	ArrayList	list	=	bean.getAmbulanceLocnDet(facility_id,caseno,con);
    if(list.size()>0){
	out.println("var list = new Array()");
	for(int i=0;i<list.size();i++){
		out.println("list["+i+"] = '"+list.get(i)+"'");
	}
	out.println("populateMaintDet(list,'"+type+"')");
	}
}else if(action.equals("LOADDESTN")){
	String caseno		=	(String)hash.get("caseno");
	String destn=bean.loadDestn(caseno,facility_id,con);
	out.println(destn==null?"":destn);
}else if(action.equals("VEHICLEDET")){
	String vehicleid	=	(String)hash.get("vehicleid");
	ArrayList list=bean.getVehicleDet(vehicleid,facility_id,con);
	out.println("var list = new Array()");
	for(int i=0;i<list.size();i++){
		out.println("list["+i+"] = '"+list.get(i)+"'");
	}

	out.println("populateVehicleDet(list)");

}

}catch(Exception e){
	e.printStackTrace();
}

finally {
			try{
				if( con!=null ){
					ConnectionManager.returnConnection(con, request);
					con=null;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
}


%>
