package org.lk.springboot.demo.domain.model.user;

import java.io.Serializable;
import java.util.Date;

import org.lk.springboot.demo.domain.base.AuditedModel;

public class Role extends AuditedModel implements Serializable {
    private Long id;

    private Integer version;

    private Date createTime;

    private String reName;

    private String reCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName == null ? null : reName.trim();
    }

    public String getReCode() {
        return reCode;
    }

    public void setReCode(String reCode) {
        this.reCode = reCode == null ? null : reCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", createTime=").append(createTime);
        sb.append(", reName=").append(reName);
        sb.append(", reCode=").append(reCode);
        sb.append("]");
        return sb.toString();
    }
}