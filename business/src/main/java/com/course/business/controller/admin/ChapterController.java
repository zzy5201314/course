package com.course.business.controller.admin;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.respDto.CommonRespDto;
import com.course.server.service.ChapterService;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.security.validator.ValidatorException;

import javax.annotation.Resource;

/**
 * @author zzy
 * @date 2022/2/14
 */
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);

    @Resource
    private ChapterService chapterService;

    @PostMapping(value = "/list")
    public CommonRespDto list(@RequestBody PageDto pageDto) {
        LOG.info("pageDto:{}", pageDto);
        CommonRespDto commonRespDto = new CommonRespDto();
        chapterService.list(pageDto);
        commonRespDto.setContent(pageDto);
        return commonRespDto;
    }

    @PostMapping(value = "/save")
    public CommonRespDto save(@RequestBody @Validated ChapterDto chapterDto) {
        LOG.info("chapterDto:{}", chapterDto);

        // 保存校验 修改为使用validation
        ValidatorUtil.require(chapterDto.getName(), "名称");
        ValidatorUtil.require(chapterDto.getCourseId(), "课程ID");
        ValidatorUtil.length(chapterDto.getCourseId().toString(), "课程ID", 1, 8);

        CommonRespDto commonRespDto = new CommonRespDto();
        chapterService.save(chapterDto);
        commonRespDto.setContent(chapterDto);
        return commonRespDto;
    }

    @DeleteMapping(value = "/delete/{id}")
    public CommonRespDto delete(@PathVariable Long id) {
        LOG.info("id:{}", id);
        CommonRespDto commonRespDto = new CommonRespDto();
        chapterService.delete(id);
        return commonRespDto;
    }

}
