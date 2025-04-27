/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

public class ReferralRegisterAuditBean{
/*Privavate variable added and assing the value into setter method and getter method return the value*/

private String username;
private String performeddate;
private String reviewstatus;
//Below line added for this CRF ML-MMOH-CRF-0566 US3
private String cancelrejectreason;
private String cancelrejectdatetime;
private String reffrompractitioner;
private String reftopractitioner;
private String cancelrejectreasondesc;

public void setUserName(String username){
 this.username=username;
}
public String getUserName(){
return username;
}
public void setPerformedDate(String performeddate){
 this.performeddate=performeddate;
}
public String getPerformedDate(){
return performeddate;
}
public void setReviewStatus(String reviewstatus){
 this.reviewstatus=reviewstatus;
}
public String getReviewStatus(){
return reviewstatus;
}
//Below Line added for this CRF ML-MMOH-CRF-0566 US3
public void setCancelrejectreason(String cancelrejectreason){
 this.cancelrejectreason=cancelrejectreason;
}
public String getCancelrejectreason(){
return cancelrejectreason;
}
public void setCancelrejectdatetime(String cancelrejectdatetime){
 this.cancelrejectdatetime=cancelrejectdatetime;
}
public String getCancelrejectdatetime(){
return cancelrejectdatetime;
}
public void setReffrompractitioner(String reffrompractitioner){
 this.reffrompractitioner=reffrompractitioner;
}
public String getReffrompractitioner(){
return reffrompractitioner;
}
public void setReftopractitioner(String reftopractitioner){
 this.reftopractitioner=reftopractitioner;
}
public String getReftopractitioner(){
return reftopractitioner;
}
public void setCancelrejectreasondesc(String cancelrejectreasondesc){
 this.cancelrejectreasondesc=cancelrejectreasondesc;
}
public String getCancelrejectreasondesc(){
return cancelrejectreasondesc;
}

//End ML-MMOH-CRF-0566

}
