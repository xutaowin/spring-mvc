package com.dbapp.springmvc.pojo;

import com.dbapp.springmvc.validation.ValidGroup1;
import com.dbapp.springmvc.validation.ValidGroup2;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：items
 * @since 2017-09-21 15:19:57
 */
@Alias("Items")
public class Items implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items.id
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items.name
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    //校验名称在1到30字符之间 message提示信息
    //groups此校验属于哪个分组
    @Size(min = 1,max = 30 ,message = "{items.name.length.error}",groups = ValidGroup1.class )
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items.price
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    private Float price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items.pic
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    private String pic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items.create_time
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    //非空校验
    @NotNull(message = "{items.createTime.isNull.error}",groups = ValidGroup2.class)
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items.detail
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    private String detail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table items
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items.id
     *
     * @return the value of items.id
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items.id
     *
     * @param id the value for items.id
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items.name
     *
     * @return the value of items.name
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items.name
     *
     * @param name the value for items.name
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items.price
     *
     * @return the value of items.price
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items.price
     *
     * @param price the value for items.price
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items.pic
     *
     * @return the value of items.pic
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public String getPic() {
        return pic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items.pic
     *
     * @param pic the value for items.pic
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items.create_time
     *
     * @return the value of items.create_time
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items.create_time
     *
     * @param createTime the value for items.create_time
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items.detail
     *
     * @return the value of items.detail
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items.detail
     *
     * @param detail the value for items.detail
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Items other = (Items) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Sep 21 15:19:57 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        return result;
    }
}