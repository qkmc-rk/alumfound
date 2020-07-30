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
 * 校友风采
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Alumnimien对象", description="校友风采")
public class Alumnimien implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "校友风采封面url")
    private String cover;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "审稿人")
    private String reader;

    @ApiModelProperty(value = "来源")
    private String origin;

    @ApiModelProperty(value = "点击数")
    private Integer hits;

    @ApiModelProperty(value = "校友风采具体内容(富文本)")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime created;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modified;

    @ApiModelProperty(value = "是否置顶")
    private Integer isRecommend;

    @ApiModelProperty(value = "上一条校园风采ID")
    @TableField(exist = false)
    private Long lastId;

    @ApiModelProperty(value = "上一条校友风采标题")
    @TableField(exist = false)
    private String lastTitle;

    @ApiModelProperty(value = "下一条校友风采ID")
    @TableField(exist = false)
    private Long nextId;

    @ApiModelProperty(value = "下一条校友风采标题")
    @TableField(exist = false)
    private String nextTitle;


}
