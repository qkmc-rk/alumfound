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
import java.time.LocalDateTime;

/**
 * <p>
 * 公开信息- 其它公示
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Elsepubinfo对象", description="公开信息- 其它公示")
public class Elsepubinfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "文件连接(可能是图片.pdf等)")
    private String url;

    @ApiModelProperty(value = ".png .jpg .pdf")
    private String format;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime created;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modified;

    @ApiModelProperty(value = "是否公开")
    private Integer isPublic;

    @ApiModelProperty(value = "主题")
    private String theme;

    @TableField(exist = false)
    private Long lastId;

    @TableField(exist = false)
    private String lastTitle;

    @TableField(exist = false)
    private Long nextId;

    @TableField(exist = false)
    private String nextTitle;


}
