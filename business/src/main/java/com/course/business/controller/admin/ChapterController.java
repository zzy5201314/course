package com.course.business.controller.admin;

import com.course.server.domain.Chapter;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping(value = "/list")
    public PageDto list(@RequestBody PageDto pageDto){
        LOG.info("pageDto:{}",pageDto);
        chapterService.list(pageDto);
        return pageDto;
    }

    @RequestMapping(value = "/save")
    public ChapterDto save(@RequestBody ChapterDto chapterDto){
        LOG.info("chapterDto:{}",chapterDto);
        chapterService.save(chapterDto);
        return chapterDto;
    }

}
