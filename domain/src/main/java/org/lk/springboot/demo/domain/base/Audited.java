package org.lk.springboot.demo.domain.base;

import java.util.Date;

public interface Audited {
    public Long getId();

    public void setId(Long id);

    void setVersion(Integer version);

    Integer getVersion();

    public Date getCreateTime();

    public void setCreateTime(Date createTime);

    public Long getCreateUserId();

    public void setCreateUserId(Long createUserId);

    public Date getLastUpdateTime();

    public void setLastUpdateTime(Date lastUpdateTime);

    public Long getLastUpdateUserId();

    public void setLastUpdateUserId(Long lastUpdateUserId);
}