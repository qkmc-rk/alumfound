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
 * 图片新闻
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Picnews对象", description="图片新闻")
public class Picnews implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "封面url")
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

    @ApiModelProperty(value = "新闻具体内容(富文本)")
    private String content;

    @ApiModelProperty(value = "是基金会新闻吗")
    private Integer isFoundation;

    @ApiModelProperty(value = "是否长期推荐上主页")
    private Integer isRecommend;

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

    @ApiModelProperty(value = "简介")
    private String introduce;

}
