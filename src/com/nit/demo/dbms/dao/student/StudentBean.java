package com.nit.demo.dbms.dao.student;

/**
 * 与学生表对应的JavaBean
 *
 * @author SN
 */
public class StudentBean {

    private String SId;
    private String GId;
    private String SName;
    private String SSexy;
    private String SBdate;
    private String STele;

    public StudentBean() {
    }

    public StudentBean(String sId, String gId, String sName, String sSexy, String sBdate, String sTele) {
        super();
        SId = sId;
        GId = gId;
        SName = sName;
        SSexy = sSexy;
        SBdate = sBdate;
        STele = sTele;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String sId) {
        SId = sId;
    }

    public String getGId() {
        return GId;
    }

    public void setGId(String gId) {
        GId = gId;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String sName) {
        SName = sName;
    }

    public String getSSexy() {
        return SSexy;
    }

    public void setSSexy(String sSexy) {
        SSexy = sSexy;
    }

    public String getSBdate() {
        return SBdate;
    }

    public void setSBdate(String sBdate) {
        SBdate = sBdate;
    }

    public String getSTele() {
        return STele;
    }

    public void setSTele(String sTele) {
        STele = sTele;
    }

}
