package org.lk.springboot.demo.domain.model.user;

import java.io.Serializable;
import java.util.Date;

import org.lk.springboot.demo.domain.base.AuditedModel;

public class Permissions extends AuditedModel implements Serializable {
    private Long id;

    private Integer version;

    private Date createTime;

    private String pmName;

    private String pmCode;

    private String pmDesc;

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

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName == null ? null : pmName.trim();
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode == null ? null : pmCode.trim();
    }

    public String getPmDesc() {
        return pmDesc;
    }

    public void setPmDesc(String pmDesc) {
        this.pmDesc = pmDesc == null ? null : pmDesc.trim();
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
        sb.append(", pmName=").append(pmName);
        sb.append(", pmCode=").append(pmCode);
        sb.append(", pmDesc=").append(pmDesc);
        sb.append("]");
        return sb.toString();
    }
}