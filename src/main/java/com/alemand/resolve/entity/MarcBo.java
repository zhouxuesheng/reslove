package com.alemand.resolve.entity;

/***
 * @ClassName: marcBo
 * @Description：
 * @author：周学胜
 * @Date:2018/12/13、14:54
 */
public class MarcBo {

    //题名	作者	出版社	出版年	分类号	ISBN/ISSN	价格 馆藏数量

    private String tm;
    private String zz;
    private String cbs;
    private String cbsj;
    //private String flh;
    private String isbn;
    private String jg;
    private String num;


    /**
     * 获取
     *
     * @return tm
     */
    public String getTm() {
        return this.tm;
    }

    /**
     * 设置
     *
     * @param tm
     */
    public void setTm(String tm) {
        this.tm = tm;
    }

    /**
     * 获取
     *
     * @return cbs
     */
    public String getCbs() {
        return this.cbs;
    }

    /**
     * 设置
     *
     * @param cbs
     */
    public void setCbs(String cbs) {
        this.cbs = cbs;
    }

    /**
     * 获取
     *
     * @return cbsj
     */
    public String getCbsj() {
        return this.cbsj;
    }

    /**
     * 设置
     *
     * @param cbsj
     */
    public void setCbsj(String cbsj) {
        this.cbsj = cbsj;
    }

    /**
     * 获取 private String flh;
     *
     * @return isbn private String flh;
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * 设置 private String flh;
     *
     * @param isbn private String flh;
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * 获取
     *
     * @return jg
     */
    public String getJg() {
        return this.jg;
    }

    /**
     * 设置
     *
     * @param jg
     */
    public void setJg(String jg) {
        this.jg = jg;
    }


    /**
     * 获取
     *
     * @return num
     */
    public String getNum() {
        return this.num;
    }

    /**
     * 设置
     *
     * @param num
     */
    public void setNum(String num) {
        this.num = num;
    }


    /**
     * 获取
     *
     * @return zz
     */
    public String getZz() {
        return this.zz;
    }

    /**
     * 设置
     *
     * @param zz
     */
    public void setZz(String zz) {
        this.zz = zz;
    }
}
