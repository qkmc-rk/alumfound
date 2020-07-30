package org.whystudio.alumfound.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 数据统计类
 * @author: CoderM
 * @date: 2020/7/28 20:08
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper =  false)
@Accessors(chain = true)
@ApiModel(value = "数据统计类对象",description = "网站访问数据")
public class Statistics implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "今天访问量")
    private Long today_visit;

    @ApiModelProperty(value = "总访问量")
    private Long total_visit;

    @ApiModelProperty(value = "数据对应日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date_visit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
