package org.chain.demo.demomybatis.controller;

import org.chain.demo.demomybatis.common.constant.GenderEnum;
import org.chain.demo.demomybatis.dto.FamilyDto;
import org.chain.demo.demomybatis.model.Family;
import org.chain.demo.demomybatis.service.IFamilyService;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chain
 * @program demo-mybatis
 * @description 家人控制层
 * @date 2019-11-16 15:39
 **/
@RestController
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    private IFamilyService familyService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/list")
    public List<FamilyDto> list() {
        List<Family> families = familyService.queryAll();
        if (!CollectionUtils.isEmpty(families)) {
            return families.stream().map(this::entityToDto).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @PostMapping("/add")
    public void addFamily(@RequestBody FamilyDto family) throws ParseException {
        familyService.add(dtoToEntity(family));
    }

    private FamilyDto entityToDto(Family family) {
        return FamilyDto.builder()
                .id(family.getId())
                .name(family.getName())
                .address(family.getAddress())
                .gender(GenderEnum.valueOfCode(family.getGender()).getDesc())
                .birthday(sdf.format(family.getBirthday()))
                .salary(family.getSalary().getAmount())
                .remark(family.getRemark())
                .tel(family.getTel())
                .identityId(family.getIdentityId())
                .build();
    }

    private Family dtoToEntity(FamilyDto dto) throws ParseException {
        return Family.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .birthday(sdf.parse(dto.getBirthday()))
                .gender(GenderEnum.valueOfDesc(dto.getGender()).getCode())
                .tel(dto.getTel())
                .salary(Money.of(CurrencyUnit.of("CNY"), dto.getSalary()))
                .identityId(dto.getIdentityId())
                .remark(dto.getRemark())
                .build();
    }
}
