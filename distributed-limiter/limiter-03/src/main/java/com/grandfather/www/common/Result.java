package com.grandfather.www.common;

import com.alibaba.druid.util.StringUtils;

public class Result {
    private long id;
    private Status status;

    /**
     * 描述
     */
    private String description;

    public Result() {

    }

    public Result(long id, Status status) {
        this.id = id;
        this.status = status;
    }

    public Result(long id, Status status,String description) {
        this.id = id;
        this.status = status;
        this.description=description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Result setDescription(long id, String description) {
        this.description = description;
        return new Result(id,Status.SUCCESS,description);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("id=").append(id);
        sb.append(", status=").append(status);

        if (!StringUtils.isEmpty(description)) {
            sb.append(", description=").append(description);
        }

        sb.append('}');
        return sb.toString();
    }
}
