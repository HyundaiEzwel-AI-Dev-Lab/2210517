package com.example.demo.dto;

/**
 * menu.xml 의 fetchMenu 쿼리 결과와 매핑되는 DTO
 */
public class SampleDto {
    /** 메뉴 ID */
    private String menuId;
    /** 메뉴 이름 */
    private String menuName;
    /** 부모 메뉴 ID (null 가능) */
    private String parentId;
    /** 메뉴 깊이 */
    private Integer menuDepth;
    /** URL 경로 */
    private String urlPath;

    public SampleDto() {
    }

    public SampleDto(String menuId, String menuName, String parentId,
            Integer menuDepth, String urlPath) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.parentId = parentId;
        this.menuDepth = menuDepth;
        this.urlPath = urlPath;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuDepth() {
        return menuDepth;
    }

    public void setMenuDepth(Integer menuDepth) {
        this.menuDepth = menuDepth;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
