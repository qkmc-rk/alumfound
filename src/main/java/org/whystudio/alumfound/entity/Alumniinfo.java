package org.whystudio.alumfound.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 前端采集并登记校友信息
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Alumniinfo对象", description="前端采集并登记校友信息")
public class Alumniinfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "校友姓名")
    private String name;

    @ApiModelProperty(value = "学院")
    private String college;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "班级")
    private String clazz;

    @ApiModelProperty(value = "联系方式")
    private String contact;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "目前从事信息")
    private String job;

    @ApiModelProperty(value = "收入(不需要精确)")
    private Double income;

    @ApiModelProperty(value = "目前所在公司")
    private String corporation;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime created;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modified;


}
