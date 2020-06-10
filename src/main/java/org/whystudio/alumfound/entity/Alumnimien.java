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


}
