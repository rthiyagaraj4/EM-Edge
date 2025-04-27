/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
24/07/2012	  IN034159		Menaka V	 LIS-Blood Unit Consumption	
--------------------------------------------------------------------------------------------------------------------
*/
//function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)//IN034159
async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,enctr_id,fac_id)//IN034159
{
	var patient_id = document.blood_transfusion.patient_id.value;//IN034159
	var win_height		= "37.5";
	var win_width		= "50";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT')
	{
		win_height		= "37.5";
		win_width		= "50";
		
	}

	var retVal = new String();

	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = "122";
	var status = "no";
	var scroll = win_scroll_yn;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
	var arguments	= Accessionnum ;

	Accessionnum	=	escape(Accessionnum);
	//retVal = window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);//IN034159
	retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode+"&enc_id="+enctr_id+"&fac_id="+fac_id+"&patient_id="+patient_id,arguments,features);//IN034159
}
