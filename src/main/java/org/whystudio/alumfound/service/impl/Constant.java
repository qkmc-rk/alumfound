package org.whystudio.alumfound.service.impl;

/**
 * @author: mrruan
 * @email: qkmc@outlook.com
 * @date: 2020-06-19
 */
public enum Constant {

    DEFAULT(1,5);

    private Integer CURRENT_PAGE;
    private Integer SIZE;

    private Constant(Integer c, Integer s){
        CURRENT_PAGE = c;
        SIZE = s;
    }

    public Integer getCURRENT_PAGE() {
        return CURRENT_PAGE;
    }

    public void setCURRENT_PAGE(Integer CURRENT_PAGE) {
        this.CURRENT_PAGE = CURRENT_PAGE;
    }

    public Integer getSIZE() {
        return SIZE;
    }

    public void setSIZE(Integer SIZE) {
        this.SIZE = SIZE;
    }
}
