<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
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
try
{
	con				= ConnectionManager.getConnection(request);
ArrayList finAr 	= new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add("Clinic Code");		//label
firstItem.add("clinic_code");		//name of field
firstItem.add("4");				// SIZE
firstItem.add("4");			    //LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem	= new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add("Clinic Desc");  // label
secondItem.add("clinic_desc");   //name of field
secondItem.add("15");	// SIZE
secondItem.add("15");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem	= new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add("Treatment Area Code");  // label
thirdItem.add("treatment_code");   //name of field
thirdItem.add("2");	// SIZE
thirdItem.add("2");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fourthItem	= new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add("Treatment Area Desc");  // label
fourthItem.add("treatment_area_desc");   //name of field
fourthItem.add("15");	// SIZE
fourthItem.add("15");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem	= new ArrayList();

fifthItem.add("Text");  //Type of item
fifthItem.add("Bed/Bay No");  // label
fifthItem.add("bed_no");   //name of field
fifthItem.add("8");	// SIZE
fifthItem.add("8");	//LENGTH

finAr.add(fifthItem); //add to ArrayList obj finAr


ArrayList sixthItem	= new ArrayList();

sixthItem.add("List");  //Type of item
sixthItem.add("Pseudo Bed/Bay");  // label
sixthItem.add("pseudo_bed_yn"); //name  of field
sixthItem.add("B,Both,Y,Yes,N,No");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(sixthItem); //add to ArrayList obj finAr




ArrayList seventhItem	 = new ArrayList();

seventhItem.add("List");   //Type of item
seventhItem.add("Nature");  // label
seventhItem.add("eff_status");//name
seventhItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(seventhItem); //add to ArrayList obj finAr*/



String orderByCols[] 	= new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] 		 = "Clinic Code";
orderByCols[1]		 = "Clinic Desc";
orderByCols[2]		 = "Treatment Area Code";
orderByCols[3]		 = "Treatment Area Desc";
//orderByCols[4]		 = "Bed No";
//orderByCols[5]		 = "Nature";


orderByColVals[0] 	 = "clinic_code";
orderByColVals[1] 	 = "clinic_desc";
orderByColVals[2] 	 = "treatment_area_code";
orderByColVals[3] 	 = "treatment_area_desc";
//orderByColVals[4] 	 = "bed_no";
//orderByColVals[5] 	 = "eff_status";


strbuff 		= qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eAE/jsp/BedforTreatmentAreaQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);
finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();
sixthItem.clear();
seventhItem.clear();

}catch (Exception e)  {e.printStackTrace();}
finally
	{
		 ConnectionManager.returnConnection(con,request);
	}
%>
