package command;

import java.util.List;

public class AbstractCommand <T>{

    protected T pojo;
    private String crudaction;
    private List<T> listResult;
    private String tableId = "tableList";
    private int maxPageItems = 4;/*số item trên 1 page*/
    private int totalItems = 0;/*TỔng số item */
    private int totalPage = 5; /*tông số trang*/
    private int firstItem = 0;
    private int limit = 4;
    private int page=1;
    private String sortExpression;
    private String sortDirection;
    private String[] checkList;
    private String messageResponse;
    private String urlType;
    private String seach;
    private String id;
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSeach() {
        return seach;
    }

    public void setSeach(String seach) {
        this.seach = seach;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public T getPojo() {
        return pojo;
    }

    public void setPojo(T pojo) {
        this.pojo = pojo;
    }

    public String getCrudaction() {
        return crudaction;
    }

    public void setCrudaction(String crudaction) {
        this.crudaction = crudaction;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getMaxPageItems() {
        return maxPageItems;
    }

    public void setMaxPageItems(int maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(int firstItem) {
        this.firstItem = firstItem;
    }

    public String getSortExpression() {
        return sortExpression;
    }

    public void setSortExpression(String sortExpression) {
        this.sortExpression = sortExpression;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String[] getCheckList() {
        return checkList;
    }

    public void setCheckList(String[] checkList) {
        this.checkList = checkList;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}

