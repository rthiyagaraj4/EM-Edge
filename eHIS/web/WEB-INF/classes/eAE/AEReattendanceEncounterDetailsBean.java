package eAE;

public class AEReattendanceEncounterDetailsBean {

private String dischargedate;
private String visitdate;
private String currentdate;
private String clinicdesc;
private String maxhrsforreattend;


public void setDischargedate(String dischargedate){
    this.dischargedate=dischargedate; 
}
public String getDischargedate(){
    return dischargedate; 
}
public void setVisitdate(String visitdate){
    this.visitdate=visitdate; 
}
public String getVisitdate(){
    return visitdate; 
}
public void setCurrentdate(String currentdate){
    this.currentdate=currentdate; 
}
public String getCurrentdate(){
    return currentdate; 
}

public void setClinicdesc(String clinicdesc){
    this.clinicdesc=clinicdesc; 
}
public String getClinicdesc(){
    return clinicdesc; 
}

public void setMaxhrsforreattend(String maxhrsforreattend){
    this.maxhrsforreattend=maxhrsforreattend; 
}
public String getMaxhrsforreattend(){
    return maxhrsforreattend; 
}

}