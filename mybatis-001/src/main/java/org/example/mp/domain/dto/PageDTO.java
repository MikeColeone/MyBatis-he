package org.example.mp.domain.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@ApiModel(description = "分页结果")
public class PageDTO<T> {
    @ApiModelProperty("总条数")
    private Long total;
    @ApiModelProperty("总页数")
    private Long pages;
    @ApiModelProperty("集合")
    private List<T> list;

    public static <PO, VO> PageDTO<VO> of(Page<PO> p, Class<VO> clazz){
        PageDTO<VO> dto = new PageDTO<>();
        // 1.总条数
        dto.setTotal(p.getTotal());
        // 2.总页数
        dto.setPages(p.getPages());
        // 3.当前页数据
        List<PO> records = p.getRecords();
        if (CollUtil.isEmpty(records)) {
            dto.setList(Collections.emptyList());
            return dto;
        }
        // 4.拷贝user的VO
        dto.setList(BeanUtil.copyToList(records, clazz));
        // 5.返回
        return dto;
    }

    public static <PO, VO> PageDTO<VO> of(Page<PO> p, Function<PO, VO> convertor){
        PageDTO<VO> dto = new PageDTO<>();
        // 1.总条数
        dto.setTotal(p.getTotal());
        // 2.总页数
        dto.setPages(p.getPages());
        // 3.当前页数据
        List<PO> records = p.getRecords();
        if (CollUtil.isEmpty(records)) {
            dto.setList(Collections.emptyList());
            return dto;
        }
        // 4.拷贝user的VO
        dto.setList(records.stream().map(convertor).collect(Collectors.toList()));
        // 5.返回
        return dto;
    }
}
