package org.whystudio.alumfound.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 捐赠信息-校友捐赠后会记录在数据库
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Donationinfo对象", description="捐赠信息-校友捐赠后会记录在数据库")
public class Donationinfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "捐赠项目(冗余外键)")
    private String project;

    @ApiModelProperty(value = "捐赠项目表外键")
    private Long projectid;

    @ApiModelProperty(value = "捐赠人姓名")
    private String donator;

    @ApiModelProperty(value = "捐赠人性别")
    private Integer isLady;

    @ApiModelProperty(value = "是否公开,默认公开")
    private Integer isPublic;

    @ApiModelProperty(value = "捐赠金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "是否是校友,默认是")
    private Integer isSchoolfellow;

    @ApiModelProperty(value = "联系方式")
    private String contact;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "捐赠留言")
    private String message;

    @ApiModelProperty(value = "曾经班级")
    private String clazz;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime created;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modified;


    @TableField(exist = false)
    private Long lastId;

    @TableField(exist = false)
    private String lastTitle;

    @TableField(exist = false)
    private Long nextId;

    @TableField(exist = false)
    private String nextTitle;

}
