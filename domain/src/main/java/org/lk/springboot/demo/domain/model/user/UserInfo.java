package org.lk.springboot.demo.domain.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Email;
import org.lk.springboot.demo.domain.base.AuditedModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class UserInfo extends AuditedModel implements Serializable {

    @Size(min = 2, max = 12, message = "用户名必须在2到12范围之间")
    private String username;

    @Size(min = 2, max = 16, message = "昵称必须在2到16范围之间")
    private String nickname;

    @JSONField(serialize = false)
    private String upassword;

    @JSONField(serialize = false)
    private String salt;

    @NotNull(message = "性别不能为空")
    private Short gender;

    private String job;

    @Email
    private String email;

    private String province;

    private String city;

    private String district;

    private String address;

    private static final long serialVersionUID = 1L;

    @Override
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return super.getCreateTime();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @JSONField(serialize = false)
    public String getChaos(){
        return this.username + this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
        sb.append(", username=").append(username);
        sb.append(", nickname=").append(nickname);
        sb.append(", upassword=").append(upassword);
        sb.append(", salt=").append(salt);
        sb.append(", gender=").append(gender);
        sb.append(", job=").append(job);
        sb.append(", email=").append(email);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", address=").append(address);
        sb.append("]");
        return sb.toString();
    }
}